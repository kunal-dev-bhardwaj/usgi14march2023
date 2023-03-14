package com.universalsompo.meta.metaapp.health.fragment.buypolicy.aplusbuyjourney;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class APlusPlanType extends AppCompatActivity {
    LinearLayout policyTypeDropDown, FirstAdultLiner, FloaterLiner, GrandLiner, TextLiner, SelfAgeLiner, SpouseAgeLiner, mainSonLiner, SonLiner, LinerSonFirst, FirstSonAgeLiner, SecondSonAgeLiner, LinerSecond, ThirdSonLiner, ThirdSonAgeLiner, FourthLiner, FourSonAgeLiner, mainMotherLiner, MotherAgeLiner, mainFatherLiner, FatherAgeLiner, mainMotherInLawLiner, MotherLawAgeLiner, mainFatherInLaw, FatherLawAgeLiner, mainGrandMother, GrandMotherAgeLiner, mainGrandFather, GrandFatherAgeLiner, mainGrandSon, GrandSonAgeLiner, mainGrandDaughter, GrandDaughterAgeLiner, SonInLawAgeLiner, DaughterInLawAgeLiner, BrotherInLawAgeLiner, SisterInLawAgeLiner, SonAgeLiner, DaughterAgeLiner, BrotherAgeLiner, SisterAgeLiner, NephewAgeLiner, NieceAgeLiner;
    Button btnNext, minusSonBtn, addSonBtn;
    int FamilyTypeCounter = 0;
    int mCounter = 0, counterAdult = 0;
    int maxCounter = 4;
    String strPincode, strState, strCity;
    String state, city,strGenderEditSpinner;
    ArrayList<String> relation_list = new ArrayList<>();
    ArrayList<Integer> age_list = new ArrayList<>();
    EditText policyType_spinner, FamilyTypeSpinner, SelfAgeEditText, SpouseAgeEditText, FirstSonAgeEditText, SecondSonAgeEditText, ThirdSonAgeEditText, FourSonAgeEditText, MotherAgeEditText, FatherAgeEditText, MotherLawAgeEditText, FatherLawAgeEditText, GrandMotherAgeEditText, GrandFatherAgeEditText, GrandSonAgeEditText, GrandDaughterAgeEditText, SonInLawAgeEditText, DaughterInLawAgeEditText, BrotherInLawAgeEditText, SisterInLawAgeEditText, SonAgeEditText, DaughterAgeEditText, BrotherAgeEditText, SisterAgeEditText, NephewAgeEditText, NieceAgeEditText;
    CheckBox CheckBoxSelf, CheckBoxSpouse, CheckBoxSon, CheckBoxMother, CheckBoxFather, CheckBoxMotherLaw, CheckBoxFatherLaw, CheckBoxGrandMother, CheckBoxGrandFather, CheckBoxGrandSon, CheckBoxGrandDaughter, CheckBoxSonInLaw, CheckBoxDaughterInLaw, CheckBoxBrotherInLaw, CheckBoxSisterInLaw, CheckBox_Son, CheckBox_Daughter, CheckBox_Brother, CheckBox_Sister, CheckBox_Nephew, CheckBox_Niece;
    TextView SonCounterText;
    String strFor, str_policyType_spinner, str_age = "", strGenderSpinner, strEdtName, strEdtPhone, strEdtEmail, FamilyComposition, ParentComposition, strCheckBoxSelf = "", strSelfAgeEditText = "", strCheckBoxSpouse = "", strSpouseAgeEditText = "", strCheckBoxSon = "", strFirstSonAgeEditText = "", strSecondSonAgeEditText = "", strThirdSonAgeEditText = "", strFourSonAgeEditText = "", strMotherAgeEditText = "", strCheckBoxMother = "", strFatherAgeEditText = "", strCheckBoxFather = "", strMotherLawAgeEditText = "", strCheckBoxMotherLaw = "", strFatherLawAgeEditText = "", strCheckBoxFatherLaw = "", str_edit_dob3String = "", today = "", strGrandMotherEditText, strCheckBoxGrandMother, strGrandFatherAgeEditText, strCheckBoxGrandFather, strCheckBoxGrandSon, strGrandSonAgeEditText, strCheckBoxGrandDaughter, strGrandDaughterAgeEditText, strCheckBoxSonInLaw, strSonInLawAgeEditText, strCheckBoxDaughterInLaw, strDaughterInLawAgeEditText, strCheckBoxBrotherInLaw, strBrotherInLawAgeEditText, strCheckBoxSisterInLaw, strSisterInLawAgeEditText, strCheckBox_Son, strCheckBox_Daughter, strCheckBox_Brother, strCheckBox_Sister, strCheckBox_Nephew, strCheckBox_Niece, strSonAgeEditText, strDaughterAgeEditText, strBrotherAgeEditText, strSisterAgeEditText, strNephewAgeEditText, strNieceAgeEditText;
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    int selectYearAdult, selectYearSecondAdult, SelectMonth, SelectDays, selectFirstYearChild, selectSonYearChild, selectDaughterYearChild, selectNephewYearChild, selectNieceYearChild, selectBrotherAdultYear, selectSisterAdultYear, daysLeftChild1, daysLeftSon, daysLeftDaughter, daysLeftNephew, daysLeftNiece, daysLeftGrandDaughter, daysLeftGrandSon, selectSecSonChild, daysLeftChild2, daysLeftChild3, selectThirdSonChild, daysLeftChild4, selectYearChildFour, FirstDaughterYearChild, daysLeftDaughter1, SecondDaughterYearChild, daysLeftDaughter2, ThirdDaughterYearChild, daysLeftDaughter3, FourDaughterYearChild, daysLeftDaughter4, selectYearMotherAdult, selectYearFatherAdult, selectMotherLawAdult, selectFatherLawAdult, selectYearGrandMother, selectYearGrandFather, selectYearSisterInLaw, selectYearBrotherInLaw, selectYearDaughterInLaw, selectYearSonInLaw, selectYearGrandDaughter, selectYearGrandSon;
    Date date, CurrentDate, SelectDate;
    public Period period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplus_plan_type);
        getWindow().setStatusBarColor(ContextCompat.getColor(APlusPlanType.this, R.color.colorPrimaryDark));
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        today = dateFormatter.format(date);
        strFor = getIntent().getStringExtra("strFor");
        strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
        strEdtPhone = getIntent().getStringExtra("strEdtPhone");
        strEdtEmail = getIntent().getStringExtra("strEdtEmail");
        strEdtName = getIntent().getStringExtra("strEdtName");
        str_age = getIntent().getStringExtra("str_age");
        strCheckBoxSelf = getIntent().getStringExtra("strCheckBoxSelf");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        strSelfAgeEditText = getIntent().getStringExtra("strSelfAgeEditText");
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
        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearMotherAdult = getIntent().getIntExtra("selectYearMotherAdult", 0);
        selectMotherLawAdult = getIntent().getIntExtra("selectMotherLawAdult", 0);
        selectFirstYearChild = getIntent().getIntExtra("selectFirstYearChild", 0);
        selectSecSonChild = getIntent().getIntExtra("selectSecSonChild", 0);
        selectThirdSonChild = getIntent().getIntExtra("selectThirdSonChild", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
        mCounter = getIntent().getIntExtra("mCounter", 0);
        strPincode = getIntent().getStringExtra("strPincode");
        strState = getIntent().getStringExtra("strState");
        strCity = getIntent().getStringExtra("strCity");
        strGenderEditSpinner = getIntent().getStringExtra("strGenderSpinner");

        Log.d("scuhusc", "onCreate: "+strGenderEditSpinner);
        initView();
    }

    private void initView() {
        policyTypeDropDown = findViewById(R.id.policyTypeDropDown);
        TextLiner = findViewById(R.id.TextLiner);
        GrandLiner = findViewById(R.id.GrandLiner);
        FirstAdultLiner = findViewById(R.id.FirstAdultLiner);
        FloaterLiner = findViewById(R.id.FloaterLiner);
        //Button
        btnNext = findViewById(R.id.btnNext);
        minusSonBtn = findViewById(R.id.minusSonBtn);
        addSonBtn = findViewById(R.id.addSonBtn);

        SelfAgeLiner = findViewById(R.id.SelfAgeLiner);
        SpouseAgeLiner = findViewById(R.id.SpouseAgeLiner);
        mainSonLiner = findViewById(R.id.mainSonLiner);
        SonLiner = findViewById(R.id.SonLiner);
        LinerSonFirst = findViewById(R.id.LinerSonFirst);
        FirstSonAgeLiner = findViewById(R.id.FirstSonAgeLiner);
        LinerSecond = findViewById(R.id.LinerSecond);
        SecondSonAgeLiner = findViewById(R.id.SecondSonAgeLiner);
        ThirdSonLiner = findViewById(R.id.ThirdSonLiner);
        ThirdSonAgeLiner = findViewById(R.id.ThirdSonAgeLiner);
        FourthLiner = findViewById(R.id.FourthLiner);
        FourSonAgeLiner = findViewById(R.id.FourSonAgeLiner);
        mainMotherLiner = findViewById(R.id.mainMotherLiner);
        MotherAgeLiner = findViewById(R.id.MotherAgeLiner);
        mainFatherLiner = findViewById(R.id.mainFatherLiner);
        FatherAgeLiner = findViewById(R.id.FatherAgeLiner);
        mainMotherInLawLiner = findViewById(R.id.mainMotherInLawLiner);
        MotherLawAgeLiner = findViewById(R.id.MotherLawAgeLiner);
        mainFatherInLaw = findViewById(R.id.mainFatherInLaw);
        FatherLawAgeLiner = findViewById(R.id.FatherLawAgeLiner);
        mainGrandMother = findViewById(R.id.mainGrandMother);
        GrandMotherAgeLiner = findViewById(R.id.GrandMotherAgeLiner);
        mainGrandFather = findViewById(R.id.mainGrandFather);
        //EditText
        policyType_spinner = findViewById(R.id.policyType_spinner);
        SelfAgeEditText = findViewById(R.id.SelfAgeEditText);
        SpouseAgeEditText = findViewById(R.id.SpouseAgeEditText);
        FirstSonAgeEditText = findViewById(R.id.FirstSonAgeEditText);
        SecondSonAgeEditText = findViewById(R.id.SecondSonAgeEditText);
        ThirdSonAgeEditText = findViewById(R.id.ThirdSonAgeEditText);
        FourSonAgeEditText = findViewById(R.id.FourSonAgeEditText);
        MotherAgeEditText = findViewById(R.id.MotherAgeEditText);
        FatherAgeEditText = findViewById(R.id.FatherAgeEditText);
        MotherLawAgeEditText = findViewById(R.id.MotherLawAgeEditText);
        FatherLawAgeEditText = findViewById(R.id.FatherLawAgeEditText);
        FamilyTypeSpinner = findViewById(R.id.FamilyTypeSpinner);
        GrandMotherAgeEditText = findViewById(R.id.GrandMotherAgeEditText);
        GrandFatherAgeLiner = findViewById(R.id.GrandFatherAgeLiner);
        GrandFatherAgeEditText = findViewById(R.id.GrandFatherAgeEditText);
        mainGrandSon = findViewById(R.id.mainGrandSon);
        GrandSonAgeEditText = findViewById(R.id.GrandSonAgeEditText);
        GrandSonAgeLiner = findViewById(R.id.GrandSonAgeLiner);
        mainGrandDaughter = findViewById(R.id.mainGrandDaughter);
        GrandDaughterAgeLiner = findViewById(R.id.GrandDaughterAgeLiner);
        GrandDaughterAgeEditText = findViewById(R.id.GrandDaughterAgeEditText);
        SonInLawAgeLiner = findViewById(R.id.SonInLawAgeLiner);
        SonInLawAgeEditText = findViewById(R.id.SonInLawAgeEditText);
        DaughterInLawAgeLiner = findViewById(R.id.DaughterInLawAgeLiner);
        DaughterInLawAgeEditText = findViewById(R.id.DaughterInLawAgeEditText);
        BrotherInLawAgeLiner = findViewById(R.id.BrotherInLawAgeLiner);
        BrotherInLawAgeEditText = findViewById(R.id.BrotherInLawAgeEditText);
        SisterInLawAgeLiner = findViewById(R.id.SisterInLawAgeLiner);
        SisterInLawAgeEditText = findViewById(R.id.SisterInLawAgeEditText);
        SonAgeLiner = findViewById(R.id.SonAgeLiner);
        SonAgeEditText = findViewById(R.id.SonAgeEditText);
        DaughterAgeLiner = findViewById(R.id.DaughterAgeLiner);
        DaughterAgeEditText = findViewById(R.id.DaughterAgeEditText);
        BrotherAgeLiner = findViewById(R.id.BrotherAgeLiner);
        BrotherAgeEditText = findViewById(R.id.BrotherAgeEditText);
        SisterAgeLiner = findViewById(R.id.SisterAgeLiner);
        SisterAgeEditText = findViewById(R.id.SisterAgeEditText);
        NephewAgeLiner = findViewById(R.id.NephewAgeLiner);
        NephewAgeEditText = findViewById(R.id.NephewAgeEditText);
        NieceAgeLiner = findViewById(R.id.NieceAgeLiner);
        NieceAgeEditText = findViewById(R.id.NieceAgeEditText);
        //CheckBox
        CheckBoxSelf = findViewById(R.id.CheckBoxSelf);
        CheckBoxSpouse = findViewById(R.id.CheckBoxSpouse);
        CheckBoxSon = findViewById(R.id.CheckBoxSon);
        CheckBoxMother = findViewById(R.id.CheckBoxMother);
        CheckBoxFather = findViewById(R.id.CheckBoxFather);
        CheckBoxMotherLaw = findViewById(R.id.CheckBoxMotherLaw);
        CheckBoxFatherLaw = findViewById(R.id.CheckBoxFatherLaw);
        CheckBoxGrandMother = findViewById(R.id.CheckBoxGrandMother);
        CheckBoxGrandFather = findViewById(R.id.CheckBoxGrandFather);
        CheckBoxGrandSon = findViewById(R.id.CheckBoxGrandSon);
        CheckBoxGrandDaughter = findViewById(R.id.CheckBoxGrandDaughter);
        CheckBoxSonInLaw = findViewById(R.id.CheckBoxSonInLaw);
        CheckBoxDaughterInLaw = findViewById(R.id.CheckBoxDaughterInLaw);
        CheckBoxBrotherInLaw = findViewById(R.id.CheckBoxBrotherInLaw);
        CheckBoxSisterInLaw = findViewById(R.id.CheckBoxSisterInLaw);
        CheckBox_Son = findViewById(R.id.CheckBox_Son);
        CheckBox_Daughter = findViewById(R.id.CheckBox_Daughter);
        CheckBox_Brother = findViewById(R.id.CheckBox_Brother);
        CheckBox_Sister = findViewById(R.id.CheckBox_Sister);
        CheckBox_Nephew = findViewById(R.id.CheckBox_Nephew);
        CheckBox_Niece = findViewById(R.id.CheckBox_Niece);
        //TextView
        SonCounterText = findViewById(R.id.SonCounterText);
        str_policyType_spinner = "Select Policy Type";
        policyType_spinner.setText(str_policyType_spinner);
        strCheckBoxSelf = "UnChecked";
        strCheckBoxSpouse = "UnChecked";
        strCheckBoxSon = "UnChecked";
        strCheckBoxMother = "UnChecked";
        strCheckBoxFather = "UnChecked";
        strCheckBoxMotherLaw = "UnChecked";
        strCheckBoxFatherLaw = "UnChecked";
        strCheckBoxGrandMother = "UnChecked";
        strCheckBoxGrandFather= "UnChecked";
        strCheckBoxGrandSon= "UnChecked";
        strCheckBoxGrandDaughter= "UnChecked";
        strCheckBoxSonInLaw= "UnChecked";
        strCheckBoxDaughterInLaw= "UnChecked";
        strCheckBoxBrotherInLaw= "UnChecked";
        strCheckBoxSisterInLaw= "UnChecked";
        strCheckBox_Son= "UnChecked";
        strCheckBox_Daughter= "UnChecked";
        strCheckBox_Brother= "UnChecked";
        strCheckBox_Sister= "UnChecked";
        strCheckBox_Nephew= "UnChecked";
        strCheckBox_Niece= "UnChecked";
//        if (strFor.equals("0")){
//            str_policyType_spinner="Select Policy Type";
//            policyType_spinner.setText(str_policyType_spinner);
//        }



        policyTypeDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(APlusPlanType.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Individual");
                items1.add("Multi-individual");
                items1.add("Family Floater");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_policyType_spinner = items1.get(options1);
                        policyType_spinner.setText(str_policyType_spinner);
                        FirstAdultLiner.setVisibility(View.VISIBLE);
                        FloaterLiner.setVisibility(View.VISIBLE);
                        if (str_policyType_spinner.equals("Individual")) {
                            GrandLiner.setVisibility(View.VISIBLE);
                            TextLiner.setVisibility(View.GONE);
                            mainSonLiner.setVisibility(View.GONE);

                            CheckBoxSelf.setChecked(false);
                            CheckBoxSpouse.setChecked(false);
                            CheckBoxMother.setChecked(false);
                            CheckBoxFather.setChecked(false);
                            CheckBoxMotherLaw.setChecked(false);
                            CheckBoxFatherLaw.setChecked(false);
                            CheckBoxGrandFather.setChecked(false);
                            CheckBoxGrandMother.setChecked(false);
                            CheckBox_Son.setChecked(false);
                            CheckBox_Daughter.setChecked(false);
                            CheckBox_Brother.setChecked(false);
                            CheckBox_Sister.setChecked(false);
                            CheckBox_Nephew.setChecked(false);
                            CheckBox_Niece.setChecked(false);
                            CheckBoxSisterInLaw.setChecked(false);
                            CheckBoxBrotherInLaw.setChecked(false);
                            CheckBoxSonInLaw.setChecked(false);
                            CheckBoxDaughterInLaw.setChecked(false);
                            CheckBoxGrandSon.setChecked(false);
                            CheckBoxGrandDaughter.setChecked(false);
                            CheckBoxSon.setChecked(false);

                        } else if (str_policyType_spinner.equals("Multi-individual")) {
                            GrandLiner.setVisibility(View.VISIBLE);
                            TextLiner.setVisibility(View.VISIBLE);
                            mainSonLiner.setVisibility(View.GONE);

                            CheckBoxSelf.setChecked(false);
                            CheckBoxSpouse.setChecked(false);
                            CheckBoxMother.setChecked(false);
                            CheckBoxFather.setChecked(false);
                            CheckBoxMotherLaw.setChecked(false);
                            CheckBoxFatherLaw.setChecked(false);
                            CheckBoxGrandFather.setChecked(false);
                            CheckBoxGrandMother.setChecked(false);
                            CheckBox_Son.setChecked(false);
                            CheckBox_Daughter.setChecked(false);
                            CheckBox_Brother.setChecked(false);
                            CheckBox_Sister.setChecked(false);
                            CheckBox_Nephew.setChecked(false);
                            CheckBox_Niece.setChecked(false);
                            CheckBoxSisterInLaw.setChecked(false);
                            CheckBoxBrotherInLaw.setChecked(false);
                            CheckBoxSonInLaw.setChecked(false);
                            CheckBoxDaughterInLaw.setChecked(false);
                            CheckBoxGrandSon.setChecked(false);
                            CheckBoxGrandDaughter.setChecked(false);
                            CheckBoxSon.setChecked(false);

                        } else {
                            TextLiner.setVisibility(View.VISIBLE);
                            GrandLiner.setVisibility(View.GONE);
                            mainSonLiner.setVisibility(View.VISIBLE);

                            CheckBoxSelf.setChecked(false);
                            CheckBoxSpouse.setChecked(false);
                            CheckBoxMother.setChecked(false);
                            CheckBoxFather.setChecked(false);
                            CheckBoxMotherLaw.setChecked(false);
                            CheckBoxFatherLaw.setChecked(false);
                            CheckBoxGrandFather.setChecked(false);
                            CheckBoxGrandMother.setChecked(false);
                            CheckBox_Son.setChecked(false);
                            CheckBox_Daughter.setChecked(false);
                            CheckBox_Brother.setChecked(false);
                            CheckBox_Sister.setChecked(false);
                            CheckBox_Nephew.setChecked(false);
                            CheckBox_Niece.setChecked(false);
                            CheckBoxSisterInLaw.setChecked(false);
                            CheckBoxBrotherInLaw.setChecked(false);
                            CheckBoxSonInLaw.setChecked(false);
                            CheckBoxDaughterInLaw.setChecked(false);
                            CheckBoxGrandSon.setChecked(false);
                            CheckBoxGrandDaughter.setChecked(false);
                            CheckBoxSon.setChecked(false);

                        }
                    }
                });
                singlePicker.show();
            }
        });
        //Self
        CheckBoxSelf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBoxSelf = "Checked";
                    SelfAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                    if (counterAdult < 2) {
                        counterAdult++;
                    } else {
                        CheckBoxSelf.setChecked(false);
                        SelfAgeLiner.setVisibility(View.GONE);
                        Toast.makeText(APlusPlanType.this, "You Can Select Only 2 Adult", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    strCheckBoxSelf = "UnChecked";
                    SelfAgeLiner.setVisibility(View.GONE);
                    FamilyTypeCounter--;
                    if (counterAdult > 0) {
                        counterAdult--;
                    }

                }
                strSelfAgeEditText = "Select Dob";
                SelfAgeEditText.setText(strSelfAgeEditText);
            }
        });
        SelfAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    showFirstCalender();
                }
            }
        });

        //spouse
        CheckBoxSpouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBoxSpouse = "Checked";
                    SpouseAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                    if (counterAdult < 2) {
                        counterAdult++;
                    } else {
                        CheckBoxSpouse.setChecked(false);
                        SpouseAgeLiner.setVisibility(View.GONE);
                        Toast.makeText(APlusPlanType.this, "You Can Select Only 2 Adult", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    strCheckBoxSpouse = "UnChecked";
                    FamilyTypeCounter--;
                    if (counterAdult > 0) {
                        counterAdult--;
                    }
                    SpouseAgeLiner.setVisibility(View.GONE);


                }
                strSpouseAgeEditText = "Select Dob";
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
                if (isChecked) {
                    mCounter++;
                    strCheckBoxSon = "Checked";
                    SonCounterText.setText(String.valueOf(mCounter));
                    SonLiner.setVisibility(View.VISIBLE);
                    strFirstSonAgeEditText = "Select Dob";
                    strSecondSonAgeEditText = "Select Dob";
                    strThirdSonAgeEditText = "Select Dob";
                    strFourSonAgeEditText = "Select Dob";
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                    LinerSonFirst.setVisibility(View.VISIBLE);
                } else {
                    mCounter--;
                    SonCounterText.setText(String.valueOf(mCounter));
                    strCheckBoxSon = "UnChecked";
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
                } else if (mCounter == 1) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.GONE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                } else if (mCounter == 2) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                } else if (mCounter == 3) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.GONE);
                } else if (mCounter == 4) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.VISIBLE);
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
                } else if (mCounter == 1) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.GONE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                } else if (mCounter == 2) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.GONE);
                    FourthLiner.setVisibility(View.GONE);
                } else if (mCounter == 3) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.GONE);
                } else if (mCounter == 4) {
                    SonCounterText.setText(String.valueOf(mCounter));
                    LinerSonFirst.setVisibility(View.VISIBLE);
                    LinerSecond.setVisibility(View.VISIBLE);
                    ThirdSonLiner.setVisibility(View.VISIBLE);
                    FourthLiner.setVisibility(View.VISIBLE);
                }
            }
        });
        FirstSonAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFirstSonCalender();
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
        //mother
        CheckBoxMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CheckBoxMotherLaw.isChecked() && CheckBoxFatherLaw.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMotherLaw.isChecked() || CheckBoxFatherLaw.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxGrandMother.isChecked() && CheckBoxGrandFather.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxGrandMother.isChecked() || CheckBoxGrandFather.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else {
                    if (isChecked) {
                        FamilyTypeCounter++;
                        MotherAgeLiner.setVisibility(View.VISIBLE);
                        strCheckBoxMother = "Checked";
                        MotherLawAgeLiner.setVisibility(View.GONE);
                        FatherLawAgeLiner.setVisibility(View.GONE);
                        if (CheckBoxMother.isChecked() && CheckBoxFather.isChecked()) {
                            mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                            mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                            mainGrandMother.setBackgroundResource(R.drawable.light_grey_);
                            mainGrandFather.setBackgroundResource(R.drawable.light_grey_);
                            mainMotherInLawLiner.setClickable(false);
                            mainFatherInLaw.setClickable(false);
                            CheckBoxMotherLaw.setChecked(false);
                            CheckBoxFatherLaw.setChecked(false);
                        } else if (CheckBoxMother.isChecked() || CheckBoxFather.isChecked()) {
                            mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                            mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                            mainGrandMother.setBackgroundResource(R.drawable.light_grey_);
                            mainGrandFather.setBackgroundResource(R.drawable.light_grey_);
                            mainMotherInLawLiner.setClickable(false);
                            mainFatherInLaw.setClickable(false);
                            CheckBoxMotherLaw.setChecked(false);
                            CheckBoxFatherLaw.setChecked(false);
                        } else {
                            FamilyTypeCounter--;
                            MotherAgeLiner.setVisibility(View.GONE);
                            strCheckBoxMother = "UnChecked";
                            mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                            mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                            mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                            mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                            mainFatherInLaw.setClickable(true);
                            mainMotherInLawLiner.setClickable(true);
                        }
                        strMotherAgeEditText = "Select Dob";
                        MotherAgeEditText.setText(strMotherAgeEditText);
                    } else {
                        FamilyTypeCounter--;
                        MotherAgeLiner.setVisibility(View.GONE);
                        strCheckBoxMother = "UnChecked";
                        strMotherAgeEditText = "Select Dob";
                        MotherAgeEditText.setText(strMotherAgeEditText);
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                        mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                        mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherInLaw.setClickable(true);
                        mainMotherInLawLiner.setClickable(true);
                    }

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
                if (CheckBoxMotherLaw.isChecked() && CheckBoxFatherLaw.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMotherLaw.isChecked() || CheckBoxFatherLaw.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxGrandMother.isChecked() && CheckBoxGrandFather.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxGrandMother.isChecked() || CheckBoxGrandFather.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (isChecked) {
                    if (CheckBoxMother.isChecked() && CheckBoxFather.isChecked()) {
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandMother.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandFather.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherInLawLiner.setClickable(false);
                        CheckBoxMotherLaw.setChecked(false);
                        CheckBoxFatherLaw.setChecked(false);
                    } else if (CheckBoxMother.isChecked() || CheckBoxFather.isChecked()) {
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandMother.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandFather.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherInLawLiner.setClickable(false);
                        CheckBoxMotherLaw.setChecked(false);
                        CheckBoxFatherLaw.setChecked(false);
                    } else {
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                        mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                        mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherInLawLiner.setClickable(true);
                        mainFatherInLaw.setClickable(true);
                    }
                    FamilyTypeCounter++;
                    FatherAgeLiner.setVisibility(View.VISIBLE);
                    strFatherAgeEditText = "Select Dob";
                    FatherAgeEditText.setText(strFatherAgeEditText);
                    strCheckBoxFather = "Checked";
                    MotherLawAgeLiner.setVisibility(View.GONE);
                    FatherLawAgeLiner.setVisibility(View.GONE);
                } else {
                    FamilyTypeCounter--;
                    FatherAgeLiner.setVisibility(View.GONE);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setClickable(true);
                    mainMotherInLawLiner.setClickable(true);
                    strFatherAgeEditText = "Select Dob";
                    FatherAgeEditText.setText(strFatherAgeEditText);
                    strCheckBoxFather = "UnChecked";
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
                if (CheckBoxMother.isChecked() && CheckBoxFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMother.isChecked() || CheckBoxFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxGrandMother.isChecked() && CheckBoxGrandFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxGrandMother.isChecked() || CheckBoxGrandFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother & Father", Toast.LENGTH_SHORT).show();
                } else if (isChecked) {
                    if (CheckBoxMotherLaw.isChecked() && CheckBoxFatherLaw.isChecked()) {
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandMother.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandFather.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                    } else if (CheckBoxMotherLaw.isChecked() || CheckBoxFatherLaw.isChecked()) {
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandMother.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandFather.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                    } else {
                        mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                        mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherLiner.setClickable(true);
                        mainFatherLiner.setClickable(true);
                    }
                    FamilyTypeCounter++;
                    MotherLawAgeLiner.setVisibility(View.VISIBLE);
                    strMotherLawAgeEditText = "Select Dob";
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    strCheckBoxMotherLaw = "Checked";
                    MotherAgeLiner.setVisibility(View.GONE);
                    FatherAgeLiner.setVisibility(View.GONE);
                } else {
                    FamilyTypeCounter--;
                    MotherLawAgeLiner.setVisibility(View.GONE);
                    strMotherLawAgeEditText = "Select Dob";
                    MotherLawAgeEditText.setText(strMotherLawAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                    strCheckBoxMotherLaw = "UnChecked";
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
                if (CheckBoxMother.isChecked() && CheckBoxFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMother.isChecked() || CheckBoxFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxGrandMother.isChecked() && CheckBoxGrandFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxGrandMother.isChecked() || CheckBoxGrandFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    Toast.makeText(APlusPlanType.this, "Can't Select Mother-In-Law & Father-In-Law", Toast.LENGTH_SHORT).show();
                } else if (isChecked) {
                    if (CheckBoxMotherLaw.isChecked() && CheckBoxFatherLaw.isChecked()) {
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandMother.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandFather.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                    } else if (CheckBoxMotherLaw.isChecked() || CheckBoxFatherLaw.isChecked()) {
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandMother.setBackgroundResource(R.drawable.light_grey_);
                        mainGrandFather.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                    } else {
                        mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                        mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherLiner.setClickable(true);
                        mainFatherLiner.setClickable(true);
                    }
                    FamilyTypeCounter++;
                    strCheckBoxFatherLaw = "Checked";
                    FatherLawAgeLiner.setVisibility(View.VISIBLE);
                    strFatherLawAgeEditText = "Select Dob";
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    MotherAgeLiner.setVisibility(View.GONE);
                    FatherAgeLiner.setVisibility(View.GONE);
                } else {
                    FamilyTypeCounter--;
                    FatherLawAgeLiner.setVisibility(View.GONE);
                    strFatherLawAgeEditText = "Select Dob";
                    FatherLawAgeEditText.setText(strFatherLawAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandMother.setBackgroundResource(R.drawable.new_grey_border);
                    mainGrandFather.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                    strCheckBoxFatherLaw = "UnChecked";
                }


            }
        });
        FatherLawAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFatherInLawCalender();
            }
        });
        //GrandMother
        CheckBoxGrandMother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CheckBoxMother.isChecked() && CheckBoxFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    CheckBoxGrandMother.setChecked(false);
                    CheckBoxGrandFather.setChecked(false);
                    Toast.makeText(APlusPlanType.this, "Can't Select GrandMother & GrandFather", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMother.isChecked() || CheckBoxFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    CheckBoxGrandMother.setChecked(false);
                    CheckBoxGrandFather.setChecked(false);
                    Toast.makeText(APlusPlanType.this, "Can't Select GrandMother & GrandFather", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMotherLaw.isChecked() && CheckBoxFatherLaw.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    CheckBoxGrandMother.setChecked(false);
                    CheckBoxGrandFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(APlusPlanType.this, "Can't Select GrandMother & GrandFather", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMotherLaw.isChecked() || CheckBoxFatherLaw.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    CheckBoxGrandMother.setChecked(false);
                    CheckBoxGrandFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(APlusPlanType.this, "Can't Select GrandMother & GrandFather", Toast.LENGTH_SHORT).show();
                } else if (isChecked) {
                    if (CheckBoxGrandMother.isChecked() && CheckBoxGrandFather.isChecked()) {
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                        CheckBoxMotherLaw.setChecked(false);
                        CheckBoxFatherLaw.setChecked(false);
                    } else if (CheckBoxGrandMother.isChecked() || CheckBoxGrandFather.isChecked()) {
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                        CheckBoxMotherLaw.setChecked(false);
                        CheckBoxFatherLaw.setChecked(false);
                    } else {
                        mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherLiner.setClickable(true);
                        mainFatherLiner.setClickable(true);
                        CheckBoxMother.setChecked(true);
                        CheckBoxFather.setChecked(true);
                        CheckBoxMotherLaw.setChecked(true);
                        CheckBoxFatherLaw.setChecked(true);
                    }
                    FamilyTypeCounter++;
                    strCheckBoxGrandMother = "Checked";
                    GrandMotherAgeLiner.setVisibility(View.VISIBLE);
                    strGrandMotherEditText = "Select Dob";
                    GrandMotherAgeEditText.setText(strGrandMotherEditText);
                } else {
                    FamilyTypeCounter--;
                    GrandMotherAgeLiner.setVisibility(View.GONE);
                    strGrandMotherEditText = "Select Dob";
                    GrandMotherAgeEditText.setText(strGrandMotherEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                    mainMotherInLawLiner.setClickable(true);
                    mainFatherInLaw.setClickable(true);
                    strCheckBoxGrandMother = "UnChecked";
                }


            }
        });
        GrandMotherAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowGrandMother();
            }
        });
        //GrandFather
        CheckBoxGrandFather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (CheckBoxMother.isChecked() && CheckBoxFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    CheckBoxGrandMother.setChecked(false);
                    CheckBoxGrandFather.setChecked(false);
                    Toast.makeText(APlusPlanType.this, "Can't Select GrandMother & GrandFather", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMother.isChecked() || CheckBoxFather.isChecked()) {
                    CheckBoxMotherLaw.setChecked(false);
                    CheckBoxFatherLaw.setChecked(false);
                    CheckBoxGrandMother.setChecked(false);
                    CheckBoxGrandFather.setChecked(false);
                    Toast.makeText(APlusPlanType.this, "Can't Select GrandMother & GrandFather", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMotherLaw.isChecked() && CheckBoxFatherLaw.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    CheckBoxGrandMother.setChecked(false);
                    CheckBoxGrandFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(APlusPlanType.this, "Can't Select GrandMother & GrandFather", Toast.LENGTH_SHORT).show();
                } else if (CheckBoxMotherLaw.isChecked() || CheckBoxFatherLaw.isChecked()) {
                    CheckBoxMother.setChecked(false);
                    CheckBoxFather.setChecked(false);
                    CheckBoxGrandMother.setChecked(false);
                    CheckBoxGrandFather.setChecked(false);
                    mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                    mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                    Toast.makeText(APlusPlanType.this, "Can't Select GrandMother & GrandFather", Toast.LENGTH_SHORT).show();
                } else if (isChecked) {
                    if (CheckBoxGrandMother.isChecked() && CheckBoxGrandFather.isChecked()) {
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                        CheckBoxMotherLaw.setChecked(false);
                        CheckBoxFatherLaw.setChecked(false);
                    } else if (CheckBoxGrandMother.isChecked() || CheckBoxGrandFather.isChecked()) {
                        mainMotherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.light_grey_);
                        mainFatherInLaw.setBackgroundResource(R.drawable.light_grey_);
                        mainMotherLiner.setClickable(false);
                        mainFatherLiner.setClickable(false);
                        CheckBoxMother.setChecked(false);
                        CheckBoxFather.setChecked(false);
                        CheckBoxMotherLaw.setChecked(false);
                        CheckBoxFatherLaw.setChecked(false);
                    } else {
                        mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                        mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                        mainMotherLiner.setClickable(true);
                        mainFatherLiner.setClickable(true);
                        CheckBoxMother.setChecked(true);
                        CheckBoxFather.setChecked(true);
                        CheckBoxMotherLaw.setChecked(true);
                        CheckBoxFatherLaw.setChecked(true);
                    }
                    FamilyTypeCounter++;
                    strCheckBoxGrandFather = "Checked";
                    GrandFatherAgeLiner.setVisibility(View.VISIBLE);
                    strGrandFatherAgeEditText = "Select Dob";
                    GrandFatherAgeEditText.setText(strGrandFatherAgeEditText);
                } else {
                    FamilyTypeCounter--;
                    GrandFatherAgeLiner.setVisibility(View.GONE);
                    strGrandFatherAgeEditText = "Select Dob";
                    GrandFatherAgeEditText.setText(strGrandFatherAgeEditText);
                    mainMotherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherInLawLiner.setBackgroundResource(R.drawable.new_grey_border);
                    mainFatherInLaw.setBackgroundResource(R.drawable.new_grey_border);
                    mainMotherLiner.setClickable(true);
                    mainFatherLiner.setClickable(true);
                    mainMotherInLawLiner.setClickable(true);
                    mainFatherInLaw.setClickable(true);
                    strCheckBoxGrandFather = "UnChecked";
                }


            }
        });
        GrandFatherAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowGrandFather();
            }
        });
        //GrandSon
        CheckBoxGrandSon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBoxGrandSon = "Checked";
                    GrandSonAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                } else {
                    strCheckBoxGrandSon = "UnChecked";
                    FamilyTypeCounter--;
                    GrandSonAgeLiner.setVisibility(View.GONE);

                }
                strGrandSonAgeEditText = "Select Dob";
                GrandSonAgeEditText.setText(strGrandSonAgeEditText);
            }
        });
        GrandSonAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowGrandSon();
            }
        });

        //GrandDaughter
        CheckBoxGrandDaughter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBoxGrandDaughter = "Checked";
                    GrandDaughterAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                } else {
                    strCheckBoxGrandDaughter = "UnChecked";
                    FamilyTypeCounter--;
                    GrandDaughterAgeLiner.setVisibility(View.GONE);

                }
                strGrandDaughterAgeEditText = "Select Dob";
                GrandDaughterAgeEditText.setText(strGrandDaughterAgeEditText);
            }
        });
        GrandDaughterAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowGrandDaughter();
            }
        });
        //SonInLaw
        CheckBoxSonInLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBoxSonInLaw = "Checked";
                    SonInLawAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                    if (counterAdult < 2) {
                        counterAdult++;
                    } else {
                        CheckBoxSonInLaw.setChecked(false);
                        SonInLawAgeLiner.setVisibility(View.GONE);
                        Toast.makeText(APlusPlanType.this, "You Can Select Only 2 Adult", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    strCheckBoxSonInLaw = "UnChecked";
                    FamilyTypeCounter--;
                    if (counterAdult > 0) {
                        counterAdult--;
                    }
                    SonInLawAgeLiner.setVisibility(View.GONE);


                }
                strSonInLawAgeEditText = "Select Dob";
                SonInLawAgeEditText.setText(strSonInLawAgeEditText);
            }
        });
        SonInLawAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowSonInLaw();
            }
        });


        //DaughterInLaw
        CheckBoxDaughterInLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBoxDaughterInLaw = "Checked";
                    DaughterInLawAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                    if (counterAdult < 2) {
                        counterAdult++;
                    } else {
                        CheckBoxDaughterInLaw.setChecked(false);
                        DaughterInLawAgeLiner.setVisibility(View.GONE);
                        Toast.makeText(APlusPlanType.this, "You Can Select Only 2 Adult", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    strCheckBoxDaughterInLaw = "UnChecked";
                    FamilyTypeCounter--;
                    if (counterAdult > 0) {
                        counterAdult--;
                    }
                    DaughterInLawAgeLiner.setVisibility(View.GONE);

                }
                strDaughterInLawAgeEditText = "Select Dob";
                DaughterInLawAgeEditText.setText(strDaughterInLawAgeEditText);
            }
        });
        DaughterInLawAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowDaughterInLaw();
            }
        });


        //BrotherInLaw

        CheckBoxBrotherInLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBoxBrotherInLaw = "Checked";
                    BrotherInLawAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                    if (counterAdult < 2) {
                        counterAdult++;
                    } else {
                        CheckBoxBrotherInLaw.setChecked(false);
                        BrotherInLawAgeLiner.setVisibility(View.GONE);
                        Toast.makeText(APlusPlanType.this, "You Can Select Only 2 Adult", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    strCheckBoxBrotherInLaw = "UnChecked";
                    FamilyTypeCounter--;
                    if (counterAdult > 0) {
                        counterAdult--;
                    }
                    BrotherInLawAgeLiner.setVisibility(View.GONE);

                }
                strBrotherInLawAgeEditText = "Select Dob";
                BrotherInLawAgeEditText.setText(strBrotherInLawAgeEditText);
            }
        });
        BrotherInLawAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowBrotherInLaw();
            }
        });

        //SisterInLaw
        CheckBoxSisterInLaw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBoxSisterInLaw = "Checked";
                    SisterInLawAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                    if (counterAdult < 2) {
                        counterAdult++;
                    } else {
                        CheckBoxSisterInLaw.setChecked(false);
                        SisterInLawAgeLiner.setVisibility(View.GONE);
                        Toast.makeText(APlusPlanType.this, "You Can Select Only 2 Adult", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    strCheckBoxSisterInLaw = "UnChecked";
                    FamilyTypeCounter--;
                    if (counterAdult > 0) {
                        counterAdult--;
                    }
                    SisterInLawAgeLiner.setVisibility(View.GONE);

                }
                strSisterInLawAgeEditText = "Select Dob";
                SisterInLawAgeEditText.setText(strSisterInLawAgeEditText);
            }
        });
        SisterInLawAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowSisterInLaw();
            }
        });


        //Sons
        CheckBox_Son.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBox_Son = "Checked";
                    SonAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                } else {
                    strCheckBox_Son = "UnChecked";
                    FamilyTypeCounter--;
                    SonAgeLiner.setVisibility(View.GONE);

                }
                strSonAgeEditText = "Select Dob";
                SonAgeEditText.setText(strSonAgeEditText);
            }
        });
        SonAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSonCalender();
            }
        });

        //Daughter
        CheckBox_Daughter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBox_Daughter = "Checked";
                    DaughterAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                } else {
                    strCheckBox_Daughter = "UnChecked";
                    FamilyTypeCounter--;
                    DaughterAgeLiner.setVisibility(View.GONE);

                }
                strDaughterAgeEditText = "Select Dob";
                DaughterAgeEditText.setText(strDaughterAgeEditText);
            }
        });
        DaughterAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDaughterCalender();
            }
        });

        //Brother
        CheckBox_Brother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBox_Brother = "Checked";
                    BrotherAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                    if (counterAdult < 2) {
                        counterAdult++;
                    } else {
                        BrotherAgeLiner.setVisibility(View.GONE);
                        CheckBox_Brother.setChecked(false);
                        Toast.makeText(APlusPlanType.this, "You Can Select Only 2 Adult", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    strCheckBox_Brother = "UnChecked";
                    FamilyTypeCounter--;
                    if (counterAdult > 0) {
                        counterAdult--;
                    }
                    BrotherAgeLiner.setVisibility(View.GONE);

                }
                strBrotherAgeEditText = "Select Dob";
                BrotherAgeEditText.setText(strBrotherAgeEditText);
            }
        });
        BrotherAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShowBrother();
            }
        });


        //Sister
        CheckBox_Sister.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBox_Sister = "Checked";
                    SisterAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                    if (counterAdult < 2) {
                        counterAdult++;
                    } else {
                        CheckBox_Sister.setChecked(false);
                        SisterAgeLiner.setVisibility(View.GONE);
                        Toast.makeText(APlusPlanType.this, "You Can Select Only 2 Adult", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    strCheckBox_Sister = "UnChecked";
                    FamilyTypeCounter--;
                    if (counterAdult > 0) {
                        counterAdult--;
                    }
                    SisterAgeLiner.setVisibility(View.GONE);

                }
                strSisterAgeEditText = "Select Dob";
                SisterAgeEditText.setText(strSisterAgeEditText);
            }
        });
        SisterAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShowSister();
            }
        });


        //Nephew
        CheckBox_Nephew.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBox_Nephew = "Checked";
                    NephewAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                } else {
                    strCheckBox_Nephew = "UnChecked";
                    FamilyTypeCounter--;
                    NephewAgeLiner.setVisibility(View.GONE);

                }
                strNephewAgeEditText = "Select Dob";
                NephewAgeEditText.setText(strNephewAgeEditText);
            }
        });
        NephewAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showNephewCalender();
            }
        });

        //Niece
        CheckBox_Niece.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    strCheckBox_Niece = "Checked";
                    NieceAgeLiner.setVisibility(View.VISIBLE);
                    FamilyTypeCounter++;
                } else {
                    strCheckBox_Niece = "UnChecked";
                    FamilyTypeCounter--;
                    NieceAgeLiner.setVisibility(View.GONE);

                }
                strNieceAgeEditText = "Select Dob";
                NieceAgeEditText.setText(strNieceAgeEditText);
            }
        });
        NieceAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showNieceCalender();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str_policyType_spinner.equals("Select Policy Type")) {
                    Toast.makeText(APlusPlanType.this, "Select Policy Type", Toast.LENGTH_SHORT).show();
                }
                if (str_policyType_spinner.equals("Individual")) {
                    if (FamilyTypeCounter == 0) {
                        Toast.makeText(APlusPlanType.this, "Select any insured member", Toast.LENGTH_SHORT).show();
                    } else if (FamilyTypeCounter > 1) {
                        Toast.makeText(APlusPlanType.this, "You can select only 1 members", Toast.LENGTH_SHORT).show();
                    } else {
                        conditionCheck();
                    }
                } else if (str_policyType_spinner.equals("Multi-individual")) {
                    if (!(CheckBoxSelf.isChecked() || CheckBoxSpouse.isChecked() || CheckBoxMother.isChecked() || CheckBoxFather.isChecked() || CheckBoxMotherLaw.isChecked() || CheckBoxFatherLaw.isChecked() || CheckBox_Brother.isChecked() || CheckBox_Sister.isChecked() || CheckBoxSisterInLaw.isChecked() || CheckBoxBrotherInLaw.isChecked() || CheckBoxSonInLaw.isChecked() || CheckBoxDaughterInLaw.isChecked() || CheckBoxGrandFather.isChecked() || CheckBoxGrandMother.isChecked())) {
                        Toast.makeText(APlusPlanType.this, "Please Select Any Insure", Toast.LENGTH_SHORT).show();
                    } else if (FamilyTypeCounter + mCounter <= 1) {
                        Toast.makeText(APlusPlanType.this, "Please Select Any other Insure", Toast.LENGTH_SHORT).show();
                    } else if (FamilyTypeCounter + mCounter > 6) {
                        Toast.makeText(APlusPlanType.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                    } else {
                        conditionCheck();
                    }
                } else {
                    if (!(CheckBoxSelf.isChecked() || CheckBoxSpouse.isChecked() || CheckBoxMother.isChecked() || CheckBoxFather.isChecked() || CheckBoxMotherLaw.isChecked() || CheckBoxFatherLaw.isChecked())) {
                        Toast.makeText(APlusPlanType.this, "Please Select Any Insure", Toast.LENGTH_SHORT).show();
                    } else if (FamilyTypeCounter + mCounter <= 1) {
                        Toast.makeText(APlusPlanType.this, "Please Select Any other Insure", Toast.LENGTH_SHORT).show();
                    } else if (FamilyTypeCounter + mCounter > 6) {
                        Toast.makeText(APlusPlanType.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                    } else if (CheckBoxSelf.isChecked() && strSelfAgeEditText.equals("Select Dob")) {
                        Toast.makeText(APlusPlanType.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
                    } else if (CheckBoxSpouse.isChecked() && strSpouseAgeEditText.equals("Select Dob")) {
                        Toast.makeText(APlusPlanType.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
                    } else if (CheckBoxMother.isChecked() && strMotherAgeEditText.equals("Select Dob")) {
                        Toast.makeText(APlusPlanType.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
                    } else if (CheckBoxFather.isChecked() && strFatherAgeEditText.equals("Select Dob")) {
                        Toast.makeText(APlusPlanType.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
                    } else if (CheckBoxMotherLaw.isChecked() && strMotherLawAgeEditText.equals("Select Dob")) {
                        Toast.makeText(APlusPlanType.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
                    } else if (CheckBoxFatherLaw.isChecked() && strFatherLawAgeEditText.equals("Select Dob")) {
                        Toast.makeText(APlusPlanType.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
                    } else if (CheckBoxSon.isChecked()) {
                        if (mCounter == 1 && strFirstSonAgeEditText.equals("Select Dob")) {
                            Toast.makeText(APlusPlanType.this, "Enter First Child DOB", Toast.LENGTH_SHORT).show();
                        } else if (mCounter == 2 && strSecondSonAgeEditText.equals("Select Dob")) {
                            Toast.makeText(APlusPlanType.this, "Enter Second Child DOB", Toast.LENGTH_SHORT).show();
                        } else if (mCounter == 3 && strThirdSonAgeEditText.equals("Select Dob")) {
                            Toast.makeText(APlusPlanType.this, "Enter Third Child DOB", Toast.LENGTH_SHORT).show();
                        } else if (mCounter == 4 && strFourSonAgeEditText.equals("Select Dob")) {
                            Toast.makeText(APlusPlanType.this, "Enter Fourth Child DOB", Toast.LENGTH_SHORT).show();
                        } else {
                            NextMethod();
                        }
                    } else {
                        NextMethod();
                    }
                }
            }
        });
    }

    public void showFirstCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSelfAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strSelfAgeEditText", strSelfAgeEditText);
            String[] strdDate = strSelfAgeEditText.split("/");
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
            if (selectYearAdult < 18 || (selectYearAdult > 55)) {
                Toast.makeText(APlusPlanType.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strSelfAgeEditText = "Select Dob";
            } else {
                if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                    str_age = "18yrs-25yrs";
                } else if (selectYearAdult >= 26 && selectYearAdult <= 30) {
                    str_age = "26yrs-30yrs";
                } else if (selectYearAdult >= 31 && selectYearAdult <= 35) {
                    str_age = "31yrs-35yrs";
                } else if (selectYearAdult >= 36 && selectYearAdult <= 40) {
                    str_age = "36yrs-40yrs";
                } else if (selectYearAdult >= 41 && selectYearAdult <= 45) {
                    str_age = "41yrs-45yrs";
                } else if (selectYearAdult >= 46 && selectYearAdult <= 50) {
                    str_age = "46yrs-50yrs";
                } else if (selectYearAdult >= 51 && selectYearAdult <= 55) {
                    str_age = "51yrs-55yrs";
                } /*else if (selectYearAdult >= 56 && selectYearAdult <= 60) {
                    str_age = "56yrs-60yrs";
                } else if (selectYearAdult >= 61 && selectYearAdult <= 65) {
                    str_age = "61yrs-65yrs";
                } else if (selectYearAdult >= 66 && selectYearAdult <= 70) {
                    str_age = "66yrs-70yrs";
                } else if (selectYearAdult >= 71 && selectYearAdult <= 75) {
                    str_age = "71yrs-75yrs";
                }
*/
            }
            SelfAgeEditText.setText(strSelfAgeEditText);
            Log.e("str_age", str_age);

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }

    public void showSpouseCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSpouseAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strSpouseAgeEditText", strSpouseAgeEditText);
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
            if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 55)) {
                Toast.makeText(APlusPlanType.this, "Spouse Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strSpouseAgeEditText = "Select Dob";
            } else {
                if (str_policyType_spinner.equals("Individual")) {
                    if (selectYearSecondAdult >= 18 && (selectYearSecondAdult <= 25)) {
                        str_age = "18yrs-25yrs";
                    } else if (selectYearSecondAdult >= 26 && selectYearSecondAdult <= 30) {
                        str_age = "26yrs-30yrs";
                    } else if (selectYearSecondAdult >= 31 && selectYearSecondAdult <= 35) {
                        str_age = "31yrs-35yrs";
                    } else if (selectYearSecondAdult >= 36 && selectYearSecondAdult <= 40) {
                        str_age = "36yrs-40yrs";
                    } else if (selectYearSecondAdult >= 41 && selectYearSecondAdult <= 45) {
                        str_age = "41yrs-45yrs";
                    } else if (selectYearSecondAdult >= 46 && selectYearSecondAdult <= 50) {
                        str_age = "46yrs-50yrs";
                    } else if (selectYearSecondAdult >= 51 && selectYearSecondAdult <= 55) {
                        str_age = "51yrs-55yrs";
                    } /*else if (selectYearSecondAdult >= 56 && selectYearSecondAdult <= 60) {
                        str_age = "56yrs-60yrs";
                    } else if (selectYearSecondAdult >= 61 && selectYearSecondAdult <= 65) {
                        str_age = "61yrs-65yrs";
                    } else if (selectYearSecondAdult >= 66 && selectYearSecondAdult <= 70) {
                        str_age = "66yrs-70yrs";
                    } else if (selectYearSecondAdult >= 71 && selectYearSecondAdult <= 75) {
                        str_age = "71yrs-75yrs";
                    }*/
                } else {
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectYearSecondAdult >= 18 && (selectYearSecondAdult <= 25)) {
                            str_age = "18yrs-25yrs";
                        } else if (selectYearSecondAdult >= 26 && selectYearSecondAdult <= 30) {
                            str_age = "26yrs-30yrs";
                        } else if (selectYearSecondAdult >= 31 && selectYearSecondAdult <= 35) {
                            str_age = "31yrs-35yrs";
                        } else if (selectYearSecondAdult >= 36 && selectYearSecondAdult <= 40) {
                            str_age = "36yrs-40yrs";
                        } else if (selectYearSecondAdult >= 41 && selectYearSecondAdult <= 45) {
                            str_age = "41yrs-45yrs";
                        } else if (selectYearSecondAdult >= 46 && selectYearSecondAdult <= 50) {
                            str_age = "46yrs-50yrs";
                        } else if (selectYearSecondAdult >= 51 && selectYearSecondAdult <= 55) {
                            str_age = "51yrs-55yrs";
                        } /*else if (selectYearSecondAdult >= 56 && selectYearSecondAdult <= 60) {
                            str_age = "56yrs-60yrs";
                        } else if (selectYearSecondAdult >= 61 && selectYearSecondAdult <= 65) {
                            str_age = "61yrs-65yrs";
                        } else if (selectYearSecondAdult >= 66 && selectYearSecondAdult <= 70) {
                            str_age = "66yrs-70yrs";
                        } else if (selectYearSecondAdult >= 71 && selectYearSecondAdult <= 75) {
                            str_age = "71yrs-75yrs";
                        }*/
                    }
                }
            }
            SpouseAgeEditText.setText(strSpouseAgeEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showFirstSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    Toast.makeText(APlusPlanType.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strFirstSonAgeEditText = "Select Dob";
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                } else {
                    FirstSonAgeEditText.setText(strFirstSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showSecondSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    Toast.makeText(APlusPlanType.this, "Second Son Age greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strSecondSonAgeEditText = "Select Dob";
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                } else {
                    SecondSonAgeEditText.setText(strSecondSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showThirdSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    Toast.makeText(APlusPlanType.this, "Third Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strThirdSonAgeEditText = "Select Dob";
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                } else {
                    ThirdSonAgeEditText.setText(strThirdSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showFourSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                if (daysLeftChild4 < 91 || (selectYearChildFour > 25)) {
                    Toast.makeText(APlusPlanType.this, "Fourth Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strFourSonAgeEditText = "Select Dob";
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                } else {
                    FourSonAgeEditText.setText(strFourSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showMotherCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
            if (selectYearMotherAdult <= 41 || (selectYearMotherAdult > 55)) {
                Toast.makeText(APlusPlanType.this, "Mother Age must be between 41 to 55 years ", Toast.LENGTH_SHORT).show();
                strMotherAgeEditText = "Select Dob";
                MotherAgeEditText.setText(strMotherAgeEditText);
            } else {
                if (str_policyType_spinner.equals("Individual")) {
                    if (selectYearMotherAdult >= 18 && (selectYearMotherAdult <= 25)) {
                        str_age = "18yrs-25yrs";
                    } else if (selectYearMotherAdult >= 26 && selectYearMotherAdult <= 30) {
                        str_age = "26yrs-30yrs";
                    } else if (selectYearMotherAdult >= 31 && selectYearMotherAdult <= 35) {
                        str_age = "31yrs-35yrs";
                    } else if (selectYearMotherAdult >= 36 && selectYearMotherAdult <= 40) {
                        str_age = "36yrs-40yrs";
                    } else if (selectYearMotherAdult >= 41 && selectYearMotherAdult <= 45) {
                        str_age = "41yrs-45yrs";
                    } else if (selectYearMotherAdult >= 46 && selectYearMotherAdult <= 50) {
                        str_age = "46yrs-50yrs";
                    } else if (selectYearMotherAdult >= 51 && selectYearMotherAdult <= 55) {
                        str_age = "51yrs-55yrs";
                    } /*else if (selectYearMotherAdult >= 56 && selectYearMotherAdult <= 60) {
                        str_age = "56yrs-60yrs";
                    } else if (selectYearMotherAdult >= 61 && selectYearMotherAdult <= 65) {
                        str_age = "61yrs-65yrs";
                    } else if (selectYearMotherAdult >= 66 && selectYearMotherAdult <= 70) {
                        str_age = "66yrs-70yrs";
                    } else if (selectYearMotherAdult >= 71 && selectYearMotherAdult <= 75) {
                        str_age = "71yrs-75yrs";
                    }*/

                } else {
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectYearMotherAdult >= 18 && (selectYearMotherAdult <= 25)) {
                            str_age = "18yrs-25yrs";
                        } else if (selectYearMotherAdult >= 26 && selectYearMotherAdult <= 30) {
                            str_age = "26yrs-30yrs";
                        } else if (selectYearMotherAdult >= 31 && selectYearMotherAdult <= 35) {
                            str_age = "31yrs-35yrs";
                        } else if (selectYearMotherAdult >= 36 && selectYearMotherAdult <= 40) {
                            str_age = "36yrs-40yrs";
                        } else if (selectYearMotherAdult >= 41 && selectYearMotherAdult <= 45) {
                            str_age = "41yrs-45yrs";
                        } else if (selectYearMotherAdult >= 46 && selectYearMotherAdult <= 50) {
                            str_age = "46yrs-50yrs";
                        } else if (selectYearMotherAdult >= 51 && selectYearMotherAdult <= 55) {
                            str_age = "51yrs-55yrs";
                        } /*else if (selectYearMotherAdult >= 56 && selectYearMotherAdult <= 60) {
                            str_age = "56yrs-60yrs";
                        } else if (selectYearMotherAdult >= 61 && selectYearMotherAdult <= 65) {
                            str_age = "61yrs-65yrs";
                        } else if (selectYearMotherAdult >= 66 && selectYearMotherAdult <= 70) {
                            str_age = "66yrs-70yrs";
                        } else if (selectYearMotherAdult >= 71 && selectYearMotherAdult <= 75) {
                            str_age = "71yrs-75yrs";
                        }*/
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
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strFatherAgeEditText = dateFormatter.format(newDate.getTime());
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
            if (selectYearFatherAdult <= 41 || (selectYearFatherAdult > 55)) {
                Toast.makeText(APlusPlanType.this, "Father Age must be between 41 to 55 years ", Toast.LENGTH_SHORT).show();
                strFatherAgeEditText = "Select Dob";
                FatherAgeEditText.setText(strFatherAgeEditText);
            } else {
                if (str_policyType_spinner.equals("Individual")) {
                    if (selectYearFatherAdult >= 18 && (selectYearFatherAdult <= 25)) {
                        str_age = "18yrs-25yrs";
                    } else if (selectYearFatherAdult >= 26 && selectYearFatherAdult <= 30) {
                        str_age = "26yrs-30yrs";
                    } else if (selectYearFatherAdult >= 31 && selectYearFatherAdult <= 35) {
                        str_age = "31yrs-35yrs";
                    } else if (selectYearFatherAdult >= 36 && selectYearFatherAdult <= 40) {
                        str_age = "36yrs-40yrs";
                    } else if (selectYearFatherAdult >= 41 && selectYearFatherAdult <= 45) {
                        str_age = "41yrs-45yrs";
                    } else if (selectYearFatherAdult >= 46 && selectYearFatherAdult <= 50) {
                        str_age = "46yrs-50yrs";
                    } else if (selectYearFatherAdult >= 51 && selectYearFatherAdult <= 55) {
                        str_age = "51yrs-55yrs";
                    } /*else if (selectYearFatherAdult >= 56 && selectYearFatherAdult <= 60) {
                        str_age = "56yrs-60yrs";
                    } else if (selectYearFatherAdult >= 61 && selectYearFatherAdult <= 65) {
                        str_age = "61yrs-65yrs";
                    } else if (selectYearFatherAdult >= 66 && selectYearFatherAdult <= 70) {
                        str_age = "66yrs-70yrs";
                    } else if (selectYearFatherAdult >= 71 && selectYearFatherAdult <= 75) {
                        str_age = "71yrs-75yrs";
                    }*/
                } else {
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectYearFatherAdult >= 18 && (selectYearFatherAdult <= 25)) {
                            str_age = "18yrs-25yrs";
                        } else if (selectYearFatherAdult >= 26 && selectYearFatherAdult <= 30) {
                            str_age = "26yrs-30yrs";
                        } else if (selectYearFatherAdult >= 31 && selectYearFatherAdult <= 35) {
                            str_age = "31yrs-35yrs";
                        } else if (selectYearFatherAdult >= 36 && selectYearFatherAdult <= 40) {
                            str_age = "36yrs-40yrs";
                        } else if (selectYearFatherAdult >= 41 && selectYearFatherAdult <= 45) {
                            str_age = "41yrs-45yrs";
                        } else if (selectYearFatherAdult >= 46 && selectYearFatherAdult <= 50) {
                            str_age = "46yrs-50yrs";
                        } else if (selectYearFatherAdult >= 51 && selectYearFatherAdult <= 55) {
                            str_age = "51yrs-55yrs";
                        } /*else if (selectYearFatherAdult >= 56 && selectYearFatherAdult <= 60) {
                            str_age = "56yrs-60yrs";
                        } else if (selectYearFatherAdult >= 61 && selectYearFatherAdult <= 65) {
                            str_age = "61yrs-65yrs";
                        } else if (selectYearFatherAdult >= 66 && selectYearFatherAdult <= 70) {
                            str_age = "66yrs-70yrs";
                        } else if (selectYearFatherAdult >= 71 && selectYearFatherAdult <= 75) {
                            str_age = "71yrs-75yrs";
                        }*/
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
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
            if (selectMotherLawAdult <= 41 || (selectMotherLawAdult > 55)) {
                Toast.makeText(APlusPlanType.this, "Mother-In-Law Age must be between 41 to 55 years ", Toast.LENGTH_SHORT).show();
                strMotherLawAgeEditText = "Select Dob";
                MotherLawAgeEditText.setText(strMotherLawAgeEditText);
            } else {
                if (str_policyType_spinner.equals("Individual")) {
                    if (selectMotherLawAdult >= 18 && (selectMotherLawAdult <= 25)) {
                        str_age = "18yrs-25yrs";
                    } else if (selectMotherLawAdult >= 26 && selectMotherLawAdult <= 30) {
                        str_age = "26yrs-30yrs";
                    } else if (selectMotherLawAdult >= 31 && selectMotherLawAdult <= 35) {
                        str_age = "31yrs-35yrs";
                    } else if (selectMotherLawAdult >= 36 && selectMotherLawAdult <= 40) {
                        str_age = "36yrs-40yrs";
                    } else if (selectMotherLawAdult >= 41 && selectMotherLawAdult <= 45) {
                        str_age = "41yrs-45yrs";
                    } else if (selectMotherLawAdult >= 46 && selectMotherLawAdult <= 50) {
                        str_age = "46yrs-50yrs";
                    } else if (selectMotherLawAdult >= 51 && selectMotherLawAdult <= 55) {
                        str_age = "51yrs-55yrs";
                    } /*else if (selectMotherLawAdult >= 56 && selectMotherLawAdult <= 60) {
                        str_age = "56yrs-60yrs";
                    } else if (selectMotherLawAdult >= 61 && selectMotherLawAdult <= 65) {
                        str_age = "61yrs-65yrs";
                    } else if (selectMotherLawAdult >= 66 && selectMotherLawAdult <= 70) {
                        str_age = "66yrs-70yrs";
                    } else if (selectMotherLawAdult >= 71 && selectMotherLawAdult <= 75) {
                        str_age = "71yrs-75yrs";
                    }*/
                } else {
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectMotherLawAdult >= 18 && (selectMotherLawAdult <= 25)) {
                            str_age = "18yrs-25yrs";
                        } else if (selectMotherLawAdult >= 26 && selectMotherLawAdult <= 30) {
                            str_age = "26yrs-30yrs";
                        } else if (selectMotherLawAdult >= 31 && selectMotherLawAdult <= 35) {
                            str_age = "31yrs-35yrs";
                        } else if (selectMotherLawAdult >= 36 && selectMotherLawAdult <= 40) {
                            str_age = "36yrs-40yrs";
                        } else if (selectMotherLawAdult >= 41 && selectMotherLawAdult <= 45) {
                            str_age = "41yrs-45yrs";
                        } else if (selectMotherLawAdult >= 46 && selectMotherLawAdult <= 50) {
                            str_age = "46yrs-50yrs";
                        } else if (selectMotherLawAdult >= 51 && selectMotherLawAdult <= 55) {
                            str_age = "51yrs-55yrs";
                        } /*else if (selectMotherLawAdult >= 56 && selectMotherLawAdult <= 60) {
                            str_age = "56yrs-60yrs";
                        } else if (selectMotherLawAdult >= 61 && selectMotherLawAdult <= 65) {
                            str_age = "61yrs-65yrs";
                        } else if (selectMotherLawAdult >= 66 && selectMotherLawAdult <= 70) {
                            str_age = "66yrs-70yrs";
                        } else if (selectMotherLawAdult >= 71 && selectMotherLawAdult <= 75) {
                            str_age = "71yrs-75yrs";
                        }*/
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
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
            if (selectFatherLawAdult <= 41 || (selectFatherLawAdult > 55)) {
                Toast.makeText(APlusPlanType.this, "Father-In-Law Age must be between 41 to 55 years ", Toast.LENGTH_SHORT).show();
                strFatherLawAgeEditText = "Select Dob";
                FatherLawAgeEditText.setText(strFatherLawAgeEditText);
            } else {
                if (str_policyType_spinner.equals("Individual")) {
                    if (selectFatherLawAdult >= 18 && (selectFatherLawAdult <= 25)) {
                        str_age = "18yrs-25yrs";
                    } else if (selectFatherLawAdult >= 26 && selectFatherLawAdult <= 30) {
                        str_age = "26yrs-30yrs";
                    } else if (selectFatherLawAdult >= 31 && selectFatherLawAdult <= 35) {
                        str_age = "31yrs-35yrs";
                    } else if (selectFatherLawAdult >= 36 && selectFatherLawAdult <= 40) {
                        str_age = "36yrs-40yrs";
                    } else if (selectFatherLawAdult >= 41 && selectFatherLawAdult <= 45) {
                        str_age = "41yrs-45yrs";
                    } else if (selectFatherLawAdult >= 46 && selectFatherLawAdult <= 50) {
                        str_age = "46yrs-50yrs";
                    } else if (selectFatherLawAdult >= 51 && selectFatherLawAdult <= 55) {
                        str_age = "51yrs-55yrs";
                    } /*else if (selectFatherLawAdult >= 56 && selectFatherLawAdult <= 60) {
                        str_age = "56yrs-60yrs";
                    } else if (selectFatherLawAdult >= 61 && selectFatherLawAdult <= 65) {
                        str_age = "61yrs-65yrs";
                    } else if (selectFatherLawAdult >= 66 && selectFatherLawAdult <= 70) {
                        str_age = "66yrs-70yrs";
                    } else if (selectFatherLawAdult >= 71 && selectFatherLawAdult <= 75) {
                        str_age = "71yrs-75yrs";
                    }*/
                } else {
                    if (!strCheckBoxSelf.equals("Checked")) {
                        if (selectFatherLawAdult >= 18 && (selectFatherLawAdult <= 25)) {
                            str_age = "18yrs-25yrs";
                        } else if (selectFatherLawAdult >= 26 && selectFatherLawAdult <= 30) {
                            str_age = "26yrs-30yrs";
                        } else if (selectFatherLawAdult >= 31 && selectFatherLawAdult <= 35) {
                            str_age = "31yrs-35yrs";
                        } else if (selectFatherLawAdult >= 36 && selectFatherLawAdult <= 40) {
                            str_age = "36yrs-40yrs";
                        } else if (selectFatherLawAdult >= 41 && selectFatherLawAdult <= 45) {
                            str_age = "41yrs-45yrs";
                        } else if (selectFatherLawAdult >= 46 && selectFatherLawAdult <= 50) {
                            str_age = "46yrs-50yrs";
                        } else if (selectFatherLawAdult >= 51 && selectFatherLawAdult <= 55) {
                            str_age = "51yrs-55yrs";
                        } /*else if (selectFatherLawAdult >= 56 && selectFatherLawAdult <= 60) {
                            str_age = "56yrs-60yrs";
                        } else if (selectFatherLawAdult >= 61 && selectFatherLawAdult <= 65) {
                            str_age = "61yrs-65yrs";
                        } else if (selectFatherLawAdult >= 66 && selectFatherLawAdult <= 70) {
                            str_age = "66yrs-70yrs";
                        } else if (selectFatherLawAdult >= 71 && selectFatherLawAdult <= 75) {
                            str_age = "71yrs-75yrs";
                        }*/
                    }
                }
                FatherLawAgeEditText.setText(strFatherLawAgeEditText);
            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }

    private void ShowGrandMother() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strGrandMotherEditText = dateFormatter.format(newDate.getTime());
            Log.e("strGrandMotherEditText", strGrandMotherEditText);
            GrandMotherAgeEditText.setText(strGrandMotherEditText);
            try {
                SelectDate = dateFormatter.parse(strGrandMotherEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearGrandMother = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearGrandMother <= 41 || (selectYearGrandMother > 55)) {
                Toast.makeText(APlusPlanType.this, "Grand Mother must be between 41 to 55 years ", Toast.LENGTH_SHORT).show();
                strGrandMotherEditText = "Select Dob";
            }
            GrandMotherAgeEditText.setText(strGrandMotherEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();

    }

    private void ShowGrandFather() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strGrandFatherAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strGrandFatherAgeEditText", strGrandFatherAgeEditText);
            GrandFatherAgeEditText.setText(strGrandFatherAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strGrandFatherAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearGrandFather = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearGrandFather <= 41 || (selectYearGrandFather > 55)) {
                Toast.makeText(APlusPlanType.this, "Grand Father must be between 41 to 55 years ", Toast.LENGTH_SHORT).show();
                strGrandMotherEditText = "Select Dob";
            }
            GrandFatherAgeEditText.setText(strGrandFatherAgeEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void ShowSisterInLaw() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSisterInLawAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strSisterInLawAgeEditText", strSisterInLawAgeEditText);
            SisterInLawAgeEditText.setText(strSisterInLawAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strSisterInLawAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearSisterInLaw = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearSisterInLaw < 18 || (selectYearSisterInLaw > 55)) {
                Toast.makeText(APlusPlanType.this, "Sister-In-Law must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strSisterInLawAgeEditText = "Select Dob";
            }
            SisterInLawAgeEditText.setText(strSisterInLawAgeEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void ShowBrotherInLaw() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strBrotherInLawAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strBrotherInLawAgeEditText", strBrotherInLawAgeEditText);
            BrotherInLawAgeEditText.setText(strBrotherInLawAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strBrotherInLawAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearBrotherInLaw = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearBrotherInLaw < 18 || (selectYearBrotherInLaw > 55)) {
                Toast.makeText(APlusPlanType.this, "Brother-In-Law must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strBrotherInLawAgeEditText = "Select Dob";
            }
            BrotherInLawAgeEditText.setText(strBrotherInLawAgeEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void ShowDaughterInLaw() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strDaughterInLawAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strDaughterInLawAgeEditText", strDaughterInLawAgeEditText);
            DaughterInLawAgeEditText.setText(strDaughterInLawAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strDaughterInLawAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearDaughterInLaw = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearDaughterInLaw < 18 || (selectYearBrotherInLaw > 55)) {
                Toast.makeText(APlusPlanType.this, "Daughter-In-Law must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strDaughterInLawAgeEditText = "Select Dob";
            }
            DaughterInLawAgeEditText.setText(strDaughterInLawAgeEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void ShowSonInLaw() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSonInLawAgeEditText = dateFormatter.format(newDate.getTime());
            Log.e("strSonInLawAgeEditText", strSonInLawAgeEditText);
            SonInLawAgeEditText.setText(strSonInLawAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strSonInLawAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearSonInLaw = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectYearSonInLaw < 18 || (selectYearSonInLaw > 55)) {
                Toast.makeText(APlusPlanType.this, "Son-In-Law must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strSonInLawAgeEditText = "Select Dob";
            }
            SonInLawAgeEditText.setText(strSonInLawAgeEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void ShowGrandDaughter() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strGrandDaughterAgeEditText = dateFormatter.format(newDate.getTime());
            GrandDaughterAgeEditText.setText(strGrandDaughterAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strGrandDaughterAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearGrandDaughter = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strGrandDaughterAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftGrandDaughter = Integer.parseInt(days);

            }
            if (strGrandDaughterAgeEditText != null) {
                if (daysLeftGrandDaughter < 91 || (selectYearGrandDaughter > 25)) {
                    Toast.makeText(APlusPlanType.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strGrandDaughterAgeEditText = "Select Dob";
                    GrandDaughterAgeEditText.setText(strGrandDaughterAgeEditText);
                } else {
                    GrandDaughterAgeEditText.setText(strGrandDaughterAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void ShowGrandSon() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strGrandSonAgeEditText = dateFormatter.format(newDate.getTime());
            GrandSonAgeEditText.setText(strGrandSonAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strGrandSonAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearGrandSon = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strGrandSonAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftGrandSon = Integer.parseInt(days);

            }
            if (strGrandSonAgeEditText != null) {
                if (daysLeftGrandSon < 91 || (selectYearGrandSon > 25)) {
                    Toast.makeText(APlusPlanType.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strGrandSonAgeEditText = "Select Dob";
                    GrandSonAgeEditText.setText(strGrandSonAgeEditText);
                } else {
                    GrandSonAgeEditText.setText(strGrandSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showSonCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSonAgeEditText = dateFormatter.format(newDate.getTime());
            SonAgeEditText.setText(strSonAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strSonAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectSonYearChild = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strSonAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftSon = Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strSonAgeEditText != null) {
                if (daysLeftSon < 91 || (selectSonYearChild > 25)) {
                    Toast.makeText(APlusPlanType.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strSonAgeEditText = "Select Dob";
                    SonAgeEditText.setText(strSonAgeEditText);
                } else {
                    SonAgeEditText.setText(strSonAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showDaughterCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strDaughterAgeEditText = dateFormatter.format(newDate.getTime());
            DaughterAgeEditText.setText(strDaughterAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strDaughterAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectDaughterYearChild = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strDaughterAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftDaughter = Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strDaughterAgeEditText != null) {
                if (daysLeftDaughter < 91 || (selectDaughterYearChild > 25)) {
                    Toast.makeText(APlusPlanType.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strDaughterAgeEditText = "Select Dob";
                    DaughterAgeEditText.setText(strDaughterAgeEditText);
                } else {
                    DaughterAgeEditText.setText(strDaughterAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showNephewCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strNephewAgeEditText = dateFormatter.format(newDate.getTime());
            NephewAgeEditText.setText(strNephewAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strNephewAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectNephewYearChild = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strNephewAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftNephew = Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strNephewAgeEditText != null) {
                if (daysLeftNephew < 91 || (selectNephewYearChild > 25)) {
                    Toast.makeText(APlusPlanType.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strNephewAgeEditText = "Select Dob";
                    NephewAgeEditText.setText(strNephewAgeEditText);
                } else {
                    NephewAgeEditText.setText(strNephewAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    public void showNieceCalender() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strNieceAgeEditText = dateFormatter.format(newDate.getTime());
            NieceAgeEditText.setText(strNieceAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strNieceAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectNieceYearChild = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strNieceAgeEditText, formatter);
                LocalDate end = LocalDate.parse(today, formatter);
                String days = String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftNiece = Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strNieceAgeEditText != null) {
                if (daysLeftNiece < 91 || (selectNieceYearChild > 25)) {
                    Toast.makeText(APlusPlanType.this, "Son Age must be greater than 3 month to 25 Years", Toast.LENGTH_SHORT).show();
                    strNieceAgeEditText = "Select Dob";
                    NieceAgeEditText.setText(strNieceAgeEditText);
                } else {
                    NieceAgeEditText.setText(strNieceAgeEditText);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void ShowBrother() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strBrotherAgeEditText = dateFormatter.format(newDate.getTime());
            BrotherAgeEditText.setText(strBrotherAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strBrotherAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectBrotherAdultYear = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectBrotherAdultYear < 18 || (selectBrotherAdultYear > 55)) {
                Toast.makeText(APlusPlanType.this, "Grand Son must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strBrotherAgeEditText = "Select Dob";
            }
            BrotherAgeEditText.setText(strBrotherAgeEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private void ShowSister() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(APlusPlanType.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strSisterAgeEditText = dateFormatter.format(newDate.getTime());
            SisterAgeEditText.setText(strSisterAgeEditText);
            try {
                SelectDate = dateFormatter.parse(strSisterAgeEditText);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectSisterAdultYear = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (selectSisterAdultYear < 18 || (selectSisterAdultYear > 55)) {
                Toast.makeText(APlusPlanType.this, "Grand Son must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                strSisterAgeEditText = "Select Dob";
            }
            SisterAgeEditText.setText(strSisterAgeEditText);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }


    private void conditionCheck() {
        if (CheckBoxSelf.isChecked() && strSelfAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Self DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxSpouse.isChecked() && strSpouseAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Spouse DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxMother.isChecked() && strMotherAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Mother DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxFather.isChecked() && strFatherAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Father DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxMotherLaw.isChecked() && strMotherLawAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Mother-In-Law DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxFatherLaw.isChecked() && strFatherLawAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Father-In-Law DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxGrandMother.isChecked() && strGrandMotherEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter GrandMother DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxGrandFather.isChecked() && strGrandFatherAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter GrandFather DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxGrandSon.isChecked() && strGrandSonAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter GrandSon DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxGrandDaughter.isChecked() && strGrandDaughterAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter GrandDaughter DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxSonInLaw.isChecked() && strSonInLawAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Son-In-Law DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxDaughterInLaw.isChecked() && strDaughterInLawAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Daughter-In-Law DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxBrotherInLaw.isChecked() && strBrotherInLawAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Brother-In-Law DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBoxSisterInLaw.isChecked() && strSisterInLawAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Sister-In-Law DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBox_Son.isChecked() && strSonAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Son DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBox_Daughter.isChecked() && strDaughterAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Daughter DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBox_Brother.isChecked() && strBrotherAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Brother DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBox_Sister.isChecked() && strSisterAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Sister DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBox_Nephew.isChecked() && strNephewAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Nephew DOB", Toast.LENGTH_SHORT).show();
        } else if (CheckBox_Niece.isChecked() && strNieceAgeEditText.equals("Select Dob")) {
            Toast.makeText(APlusPlanType.this, "Enter Niece DOB", Toast.LENGTH_SHORT).show();
        } else {
            NextMethod();
        }
    }

    private void NextMethod() {
        if (str_policyType_spinner.equals("Individual")) {
            if (strCheckBoxSelf.equals("Checked")) {
                FamilyComposition = "1 Adult";
                ParentComposition = "";
            }
            if (strCheckBoxSpouse.equals("Checked")) {
                FamilyComposition = "1 Adult";
                ParentComposition = "";
            }
            if (strCheckBoxMother.equals("Checked")) {
                FamilyComposition = "1 Parent";
                ParentComposition = "";
            }
            if (strCheckBoxFather.equals("Checked")) {
                FamilyComposition = "1 Parent";
                ParentComposition = "";
            }
            if (strCheckBoxMotherLaw.equals("Checked")) {
                FamilyComposition = "1 Parent";
                ParentComposition = "";
            }
            if (strCheckBoxFatherLaw.equals("Checked")) {
                FamilyComposition = "1 Parent";
                ParentComposition = "";
            }
        } else {
            if (strCheckBoxSelf.equals("Checked") && strCheckBoxSpouse.equals("Checked")) {
                if (mCounter == 1) {
                    FamilyComposition = "2 Adult + 1 Child";
                } else if (mCounter == 2) {
                    FamilyComposition = "2 Adult + 2 Child";
                } else if (mCounter == 3) {
                    FamilyComposition = "2 Adult + 3 Child";
                } else if (mCounter == 4) {
                    FamilyComposition = "2 Adult + 4 Child";
                } else {
                    FamilyComposition = "2 Adult";
                }
            } else {
                if (strCheckBoxSelf.equals("Checked") || strCheckBoxSpouse.equals("Checked")) {
                    if (mCounter == 1) {
                        FamilyComposition = "1 Adult + 1 Child";
                    } else if (mCounter == 2) {
                        FamilyComposition = "1 Adult + 2 Child";
                    } else if (mCounter == 3) {
                        FamilyComposition = "1 Adult + 3 Child";
                    } else if (mCounter == 4) {
                        FamilyComposition = "1 Adult + 4 Child";
                    } else {
                        FamilyComposition = "1 Adult";
                    }
                }
            }
            if (strCheckBoxMother.equals("Checked")) {
                if (strCheckBoxFather.equals("Checked")) {
                    ParentComposition = "2 Parent";
                } else {
                    ParentComposition = "1 Parent";
                }
            } else if (strCheckBoxFather.equals("Checked")) {
                ParentComposition = "1 Parent";
            } else if (strCheckBoxMotherLaw.equals("Checked")) {
                if (strCheckBoxFatherLaw.equals("Checked")) {
                    ParentComposition = "2 Parent";
                } else {
                    ParentComposition = "1 Parent";
                }
            } else if (strCheckBoxFatherLaw.equals("Checked")) {
                ParentComposition = "1 Parent";
            } else {
                ParentComposition = "";
            }
        }


        if (str_policyType_spinner.equals("Family Floater") || str_policyType_spinner.equals("Multi-individual")) {
            relation_list.clear();
            if (CheckBoxSelf.isChecked()) {
                relation_list.add("Self");
            }
            if (CheckBoxSpouse.isChecked()) {
                relation_list.add("Spouse");
            }
            if (CheckBoxMother.isChecked()) {
                relation_list.add("Mother");
            }
            if (CheckBoxFather.isChecked()) {
                relation_list.add("Father");
            }
            if (CheckBoxMotherLaw.isChecked()) {
                relation_list.add("Mother-In-Law");
            }
            if (CheckBoxFatherLaw.isChecked()) {
                relation_list.add("Father-In-Law");
            }
            if (CheckBoxGrandMother.isChecked()) {
                relation_list.add("Grand Mother");
            }
            if (CheckBoxGrandFather.isChecked()) {
                relation_list.add("Grand Father");
            }
            if (CheckBoxGrandSon.isChecked()) {
                relation_list.add("Grand Son");
            }
            if (CheckBoxGrandDaughter.isChecked()) {
                relation_list.add("Grand Daughter");
            }
            if (CheckBoxSonInLaw.isChecked()) {
                relation_list.add("Son-In-Law");
            }
            if (CheckBoxDaughterInLaw.isChecked()) {
                relation_list.add("Daughter-In-Law");
            }
            if (CheckBoxBrotherInLaw.isChecked()) {
                relation_list.add("Brother-In-Law");
            }
            if (CheckBoxSisterInLaw.isChecked()) {
                relation_list.add("Sister-In-Law");
            }
            if (CheckBox_Son.isChecked()) {
                relation_list.add("Son");
            }
            if (CheckBox_Daughter.isChecked()) {
                relation_list.add("Daughter");
            }
            if (CheckBox_Brother.isChecked()) {
                relation_list.add("Brother");
            }
            if (CheckBox_Sister.isChecked()) {
                relation_list.add("Sister");
            }
            if (CheckBox_Nephew.isChecked()) {
                relation_list.add("Nephew");
            }
            if (CheckBox_Niece.isChecked()) {
                relation_list.add("Niece");
            }

            if (CheckBoxSon.isChecked()){
                if (!strFirstSonAgeEditText.equals("Select Dob")){
                    relation_list.add("Child 1");
                }
                if (!strSecondSonAgeEditText.equals("Select Dob")){
                    relation_list.add("Child 2");
                }
                if (!strThirdSonAgeEditText.equals("Select Dob")){
                    relation_list.add("Child 3");
                }
                if (!strFourSonAgeEditText.equals("Select Dob")){
                    relation_list.add("Child 4");
                }
            }


            //age_list

            age_list.clear();

            if (selectYearAdult != 0){
                age_list.add(selectYearAdult);
            }

            if (selectYearSecondAdult != 0){
                age_list.add(selectYearSecondAdult);

            }
            if (selectYearFatherAdult != 0){

                age_list.add(selectYearFatherAdult);

            }
            if (selectYearMotherAdult!=0){

                age_list.add(selectYearMotherAdult);


            }
            if (selectMotherLawAdult != 0){

                age_list.add(selectMotherLawAdult);

            }
            if (selectFatherLawAdult != 0){

                age_list.add(selectFatherLawAdult);

            }
            if (selectYearGrandMother != 0){
                age_list.add(selectYearGrandMother);

            }
            if (selectYearGrandFather != 0){
                age_list.add(selectYearGrandFather);

            }

            if (daysLeftGrandSon >= 91 && selectYearGrandSon<18){
                age_list.add(daysLeftGrandSon);

            }else{
                if (selectYearGrandSon!=0){
                    age_list.add(selectYearGrandSon);

                }
            }
            if (daysLeftGrandDaughter >= 91  && selectYearGrandDaughter<18){
                age_list.add(daysLeftGrandDaughter);

            }else{
                if (selectYearGrandDaughter!=0){
                    age_list.add(selectYearGrandDaughter);

                }
            }
            if (selectYearSonInLaw != 0){
                age_list.add(selectYearSonInLaw);

            }
            if (selectYearDaughterInLaw != 0){

                age_list.add(selectYearDaughterInLaw);

            }
            if (selectYearBrotherInLaw != 0){
                age_list.add(selectYearBrotherInLaw);

            }
            if (selectYearSisterInLaw != 0){
                age_list.add(selectYearSisterInLaw);

            }
            if (daysLeftSon >= 91 && selectSonYearChild<18){
                age_list.add(daysLeftSon);

            }else{
                if (selectSonYearChild!=0){
                    age_list.add(selectSonYearChild);
                }
            }
            if (daysLeftDaughter >= 91 && selectDaughterYearChild<18){
                age_list.add(daysLeftDaughter);

            }else{
                if (selectDaughterYearChild!=0){
                    age_list.add(selectDaughterYearChild);
                }

            }
            if (selectBrotherAdultYear != 0){

                age_list.add(selectBrotherAdultYear);


            }
            if (selectSisterAdultYear != 0){

                age_list.add(selectSisterAdultYear);

            }
            if (daysLeftNephew >= 91 && selectNephewYearChild<18){
                age_list.add(daysLeftNephew);

            }else{
                if (selectNephewYearChild!=0){
                    age_list.add(selectNephewYearChild);
                }
            }
            if (daysLeftNiece >= 91 && selectNieceYearChild<18){
                age_list.add(daysLeftNiece);

            }else{
                if (selectNieceYearChild!=0){
                    age_list.add(selectNieceYearChild);
                }

            }




            Intent intent = new Intent(APlusPlanType.this, APlusAddOns.class);
            intent.putExtra("strEdtName", strEdtName);
            intent.putExtra("strEdtPhone", strEdtPhone);
            intent.putExtra("strEdtEmail", strEdtEmail);
            intent.putExtra("str_policyType_spinner", str_policyType_spinner);
            intent.putExtra("strSelfAgeEditText", strSelfAgeEditText);
            intent.putExtra("strCheckBoxSelf", strCheckBoxSelf);
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
            intent.putExtra("FamilyTypeCounter", FamilyTypeCounter);
            intent.putExtra("selectYearAdult", selectYearAdult);
            intent.putExtra("FamilyComposition", FamilyComposition);
            intent.putExtra("ParentComposition", ParentComposition);
            intent.putExtra("selectFirstYearChild", selectFirstYearChild);
            intent.putExtra("selectSecSonChild", selectSecSonChild);
            intent.putExtra("selectThirdSonChild", selectThirdSonChild);
            intent.putExtra("selectYearChildFour", selectYearChildFour);
            intent.putExtra("selectYearSecondAdult", selectYearSecondAdult);
            intent.putExtra("selectYearMotherAdult", selectYearMotherAdult);
            intent.putExtra("selectMotherLawAdult", selectMotherLawAdult);
            intent.putExtra("selectFatherLawAdult", selectFatherLawAdult);
            intent.putExtra("selectYearFatherAdult", selectYearFatherAdult);
            intent.putExtra("strPincode", strPincode);
            intent.putExtra("str_age", str_age);
            intent.putExtra("strState", strState);
            intent.putExtra("strCity", strCity);
            intent.putExtra("strGenderEditSpinner", strGenderEditSpinner);
            intent.putExtra("strFor", "0");
            intent.putStringArrayListExtra("relation_list", relation_list);
            intent.putIntegerArrayListExtra("age_list",age_list);
            startActivity(intent);
        }else{
            Intent intent = new Intent(APlusPlanType.this, APlusAddOns.class);
            intent.putExtra("strEdtName", strEdtName);
            intent.putExtra("strEdtPhone", strEdtPhone);
            intent.putExtra("strEdtEmail", strEdtEmail);
            intent.putExtra("str_policyType_spinner", str_policyType_spinner);
            intent.putExtra("strCheckBoxSelf", strCheckBoxSelf);
            intent.putExtra("strGenderSpinner", strGenderSpinner);
            intent.putExtra("strCheckBoxSpouse", strCheckBoxSpouse);
            intent.putExtra("strCheckBoxMother", strCheckBoxMother);
            intent.putExtra("strCheckBoxFather", strCheckBoxFather);
            intent.putExtra("strCheckBoxMotherLaw", strCheckBoxMotherLaw);
            intent.putExtra("strCheckBoxFatherLaw", strCheckBoxFatherLaw);
            intent.putExtra("strFirstSonAgeEditText", strFirstSonAgeEditText);
            intent.putExtra("strSecondSonAgeEditText", strSecondSonAgeEditText);
            intent.putExtra("strThirdSonAgeEditText", strThirdSonAgeEditText);
            intent.putExtra("strFourSonAgeEditText", strFourSonAgeEditText);
            intent.putExtra("strCheckBoxSon", strCheckBoxSon);
            intent.putExtra("mCounter", mCounter);
            intent.putExtra("FamilyTypeCounter", FamilyTypeCounter);
            intent.putExtra("selectYearAdult", selectYearAdult);
            intent.putExtra("FamilyComposition", FamilyComposition);
            intent.putExtra("ParentComposition", ParentComposition);
            intent.putExtra("selectFirstYearChild", selectFirstYearChild);
            intent.putExtra("selectSecSonChild", selectSecSonChild);
            intent.putExtra("selectThirdSonChild", selectThirdSonChild);
            intent.putExtra("selectYearChildFour", selectYearChildFour);
            intent.putExtra("selectYearSecondAdult", selectYearSecondAdult);
            intent.putExtra("selectYearMotherAdult", selectYearMotherAdult);
            intent.putExtra("selectMotherLawAdult", selectMotherLawAdult);
            intent.putExtra("selectFatherLawAdult", selectFatherLawAdult);
            intent.putExtra("selectYearFatherAdult", selectYearFatherAdult);
            intent.putExtra("strCheckBoxGrandMother", strCheckBoxGrandMother);
            intent.putExtra("strCheckBoxGrandFather", strCheckBoxGrandFather);
            intent.putExtra("strCheckBoxGrandSon", strCheckBoxGrandSon);
            intent.putExtra("strCheckBoxGrandDaughter", strCheckBoxGrandDaughter);
            intent.putExtra("strCheckBoxSonInLaw", strCheckBoxSonInLaw);
            intent.putExtra("strCheckBoxDaughterInLaw", strCheckBoxDaughterInLaw);
            intent.putExtra("strCheckBoxBrotherInLaw", strCheckBoxBrotherInLaw);
            intent.putExtra("strCheckBoxSisterInLaw", strCheckBoxSisterInLaw);
            intent.putExtra("strCheckBox_Son", strCheckBox_Son);
            intent.putExtra("strCheckBox_Daughter", strCheckBox_Daughter);
            intent.putExtra("strCheckBox_Brother", strCheckBox_Brother);
            intent.putExtra("strCheckBox_Sister", strCheckBox_Sister);
            intent.putExtra("strCheckBox_Nephew", strCheckBox_Nephew);
            intent.putExtra("strCheckBox_Niece", strCheckBox_Niece);
            intent.putExtra("str_age", str_age);
            intent.putExtra("strPincode", strPincode);
            intent.putExtra("strState", strState);
            intent.putExtra("strCity", strCity);
            intent.putExtra("strGenderEditSpinner", strGenderEditSpinner);
            intent.putExtra("strFor", "0");
            intent.putStringArrayListExtra("relation_list", relation_list);
            Log.d("asdfgfd", "NextMethod: "+strFatherAgeEditText+"  "+strFatherLawAgeEditText);
            if (strSelfAgeEditText != null && (!strSelfAgeEditText.isEmpty())){
                intent.putExtra("strSelfAgeEditText", strSelfAgeEditText);
            } if (strSpouseAgeEditText != null && (!strSpouseAgeEditText.isEmpty())){
                intent.putExtra("strSpouseAgeEditText", strSpouseAgeEditText);
            } if (strMotherAgeEditText != null && (!strMotherAgeEditText.isEmpty())){
                intent.putExtra("strMotherAgeEditText", strMotherAgeEditText);
            } if (strFatherAgeEditText != null && (!strFatherAgeEditText.isEmpty())){
                intent.putExtra("strFatherAgeEditText", strFatherAgeEditText);
            } if (strMotherLawAgeEditText != null && (!strMotherLawAgeEditText.isEmpty())){
                intent.putExtra("strMotherLawAgeEditText", strMotherLawAgeEditText);
            }if (strFatherLawAgeEditText != null && (!strFatherLawAgeEditText.isEmpty())){
                intent.putExtra("strFatherLawAgeEditText", strFatherLawAgeEditText);
            } if (strGrandMotherEditText != null && (!strGrandMotherEditText.isEmpty())){
                intent.putExtra("strGrandMotherEditText", strGrandMotherEditText);
            }if (strGrandFatherAgeEditText != null && (!strGrandFatherAgeEditText.isEmpty())){
                intent.putExtra("strGrandFatherAgeEditText", strGrandFatherAgeEditText);
            }if (strSisterInLawAgeEditText != null && (!strSisterInLawAgeEditText.isEmpty())){
                intent.putExtra("strSisterInLawAgeEditText", strSisterInLawAgeEditText);
            }if (strBrotherInLawAgeEditText != null && (!strBrotherInLawAgeEditText.isEmpty())){
                intent.putExtra("strBrotherInLawAgeEditText", strBrotherInLawAgeEditText);
            }
            if (strDaughterInLawAgeEditText != null && (!strDaughterInLawAgeEditText.isEmpty())){
                intent.putExtra("strDaughterInLawAgeEditText", strDaughterInLawAgeEditText);
            }if (strSonInLawAgeEditText != null && (!strSonInLawAgeEditText.isEmpty())){
                intent.putExtra("strSonInLawAgeEditText", strSonInLawAgeEditText);
            }if (strGrandDaughterAgeEditText != null && (!strGrandDaughterAgeEditText.isEmpty())){
                intent.putExtra("strGrandDaughterAgeEditText", strGrandDaughterAgeEditText);
            }if (strGrandSonAgeEditText != null && (!strGrandSonAgeEditText.isEmpty())){
                intent.putExtra("strGrandSonAgeEditText", strGrandSonAgeEditText);
            }

            if (strSonAgeEditText != null && (!strSonAgeEditText.isEmpty())){
                intent.putExtra("strSonAgeEditText", strSonAgeEditText);
            } if (strDaughterAgeEditText != null && (!strDaughterAgeEditText.isEmpty())){
                intent.putExtra("strDaughterAgeEditText", strDaughterAgeEditText);
            } if (strNephewAgeEditText != null && (!strNephewAgeEditText.isEmpty())){
                intent.putExtra("strNephewAgeEditText", strNephewAgeEditText);
            } if (strNieceAgeEditText != null && (!strNieceAgeEditText.isEmpty())){
                intent.putExtra("strNieceAgeEditText", strNieceAgeEditText);
            } if (strBrotherAgeEditText != null && (!strBrotherAgeEditText.isEmpty())){
                intent.putExtra("strBrotherAgeEditText", strBrotherAgeEditText);
            } if (strSisterAgeEditText != null && (!strSisterAgeEditText.isEmpty())){
                intent.putExtra("strSisterAgeEditText", strSisterAgeEditText);
            }

            startActivity(intent);
        }
    }
}