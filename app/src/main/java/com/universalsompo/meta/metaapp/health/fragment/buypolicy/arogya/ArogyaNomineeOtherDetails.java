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
import android.widget.TextView;
import android.widget.Toast;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PersonalInformationCHI;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class ArogyaNomineeOtherDetails extends AppCompatActivity {
    String strParentEditText,strAppointeeNomineeName, strAppointeeNomineeDobEdit, strAppointeeGenderEdit,str_life_style_spinner,str_Payment_spinner,new_str_age,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,strNominee_dob,str_existing_spinner,strExisting_policy_number,strOneChild,str_oneWeightEdit,str_nomineedob3String,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2,strfourChildPersonal_under_spinner2;
    String  BMI,Individual_BMI,twoAdult_BMI,OneChildBMI,TwoChildBMI,ThreeChildBMI,FourChildBMI,strLoyaltyDiscount,str_policyTenure,TotalInstallPremium, QuoteId,NetPremium,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit,str_edit_dob3String,strProposerSpinner,strNomineeName,strContactNominee,strbloodSugar,strbloodPressure,strbloodPressureDiastolic,stredtcholesterol,NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for,strAddressLine1,strAddressLine2,strAddressLine3,strpincode,strCityName,strstateName;
    Date date,CurrentDate, SelectDate;
    Format formatter;
    EditText Payment_spinner, Nominee_dob,NomineeName,ContactNominee,policyTypeEdit,familyTypeEdit,sumInsuredEdit,policyTenureEdit,totalPremiumAmount,QuotationID,hospitalCashSpinner,oneChildPersonal_under_Edit,twoChildPersonal_under_Edit,thirdChildPersonal_under_Edit,fourChildPersonal_under_Edit,editSumInsured,subLimitAmount,discountedit,criticalEdit,peronalAccidentEdit,hospitalEdit,editPersonalAccident,editPASpinner;
    TextView show_Breakup;
    EditText proposer_spinner,NomineeGenderEdit,appointeeNomineeName, appointeeNomineeDobEdit, AppointeeGenderEdit;
    Button btn_continue;
    LinearLayout proposer_spinnerLiner,appointeeNominee,linerAppointeeSpinner;
    private SimpleDateFormat dateFormatter;
    int phoneNumberInt,selectAppointee,selectNomineeYear,selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour,FamilyTypeCounter,ParentCounter;
    public Period period;
    ImageView calendarAppointeeIconDob;
    String strMotherFtEdit,strFatherLawInchesEdit,strMotherInchesEdit,strFatherFtEdit,strFatherInchesEdit,strMotherLawFtEdit,strMotherLawInchesEdit,strFatherLawFtEdit,strMotherName,strMotherDob,strMotherOccupationEdit,strMotherWeightEdit,strFatherName,strFatherDob,strFatherWeightEdit, strFatherOccupationEdit,strMotherLawName,strMotherLawDob,strMotherLawOccupationEdit,strMotherLawWeightEdit,strFatherLawName, strFatherLawDob,strFatherLawOccupationEdit,strFatherLawWeightEdit,selectYearMother,selectYearFather,selectYearMotherLaw,selectYearFatherLaw, MotherBMI,FatherBMI,MotherLawBMI,FatherLawBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arogya_nominee_other_details);

        getWindow().setStatusBarColor(ContextCompat.getColor(ArogyaNomineeOtherDetails.this, R.color.colorPrimaryDark));
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
        proposer_spinnerLiner=findViewById(R.id.proposer_spinnerLiner);
        appointeeNominee=findViewById(R.id.appointeeNominee);
        appointeeNomineeName = findViewById(R.id.appointeeNomineeName);
        appointeeNomineeDobEdit = findViewById(R.id.appointeeNomineeDobEdit);
        calendarAppointeeIconDob = findViewById(R.id.calendarAppointeeIconDob);
        linerAppointeeSpinner = findViewById(R.id.linerAppointeeSpinner);
        AppointeeGenderEdit = findViewById(R.id.AppointeeGenderEdit);
        policyTypeEdit=findViewById(R.id.policyTypeEdit);
        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        show_Breakup=findViewById(R.id.show_Breakup);
        QuotationID=findViewById(R.id.QuotationID);
        proposer_spinner=findViewById(R.id.proposer_spinner);
        NomineeName=findViewById(R.id.NomineeName);
        Nominee_dob=findViewById(R.id.Nominee_dob);
        ContactNominee=findViewById(R.id.ContactNominee);
        btn_continue=findViewById(R.id.btn_continue);
        Payment_spinner=findViewById(R.id.Payment_spinner);
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

        Payment_spinner.setText(str_Payment_spinner);
        Payment_spinner.setAlpha(0.5f);

        if (str_for.equals("1")){
            proposer_spinner.setText(strProposerSpinner);
            NomineeName.setText(strNomineeName);
            ContactNominee.setText(strContactNominee);
            Nominee_dob.setText(strNominee_dob);
            if (selectNomineeYear <= 5) {
                appointeeNominee.setVisibility(View.VISIBLE);
                appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);
                appointeeNomineeName.setText(strAppointeeNomineeName);
                AppointeeGenderEdit.setText(strAppointeeGenderEdit);
            } else {
                appointeeNominee.setVisibility(View.GONE);
            }
        }else{
            strProposerSpinner="Spouse";
            strAppointeeNomineeDobEdit = "Select Dob";
            strAppointeeGenderEdit = "Select Gender";
            proposer_spinner.setText(strProposerSpinner);
            appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);
            AppointeeGenderEdit.setText(strAppointeeGenderEdit);
        }


        proposer_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaNomineeOtherDetails.this);
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
                        strProposerSpinner=items1.get(options1);
                        proposer_spinner.setText(strProposerSpinner);
                    }
                });
                singlePicker.show();
            }
        });
        Nominee_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalender();


            }
        });
        linerAppointeeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(ArogyaNomineeOtherDetails.this);
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
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                if (selectAppointee < 18 || (selectAppointee > 75)) {
                                    Toast.makeText(ArogyaNomineeOtherDetails.this, "Appointee Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
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


        calendarAppointeeIconDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNomineeAppointCalender();
            }
        });
        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(ArogyaNomineeOtherDetails.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.arogya_show_breakup);
                EditText installmentAmount,policyNoExisting, LifeStyleDiscount,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
                Button buttonClose;
                LinearLayout linerExisting;
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
                installmentAmount = alert_dialog.findViewById(R.id.installmentAmount);
                if (str_existing_spinner.equals("Yes")){
                    LifeStyleDiscount.setText(strLoyaltyDiscount);
                    linerExisting.setVisibility(View.VISIBLE);
                    policyNoExisting.setText(strExisting_policy_number);
                }else{
                    strLoyaltyDiscount="No";
                    LifeStyleDiscount.setText(strLoyaltyDiscount);
                    linerExisting.setVisibility(View.GONE);
                }
                installmentAmount.setText(TotalInstallPremium);
                basicPremium.setText(NetPremium);
//                criticalEdit.setText(strcriticalEdit);
//                premiumEdit.setText(str_amountPersonalSumInsured);
//                hospitalEdit.setText(strhospitalEdit);
//                subLimitAmount.setText(strSubLimitAmount);
                totalAmount.setText(str_TotalValue);
//                tiedHospital.setText(strDiscount);
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
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNomineeName=NomineeName.getText().toString();
                strNominee_dob=Nominee_dob.getText().toString();
                strContactNominee=ContactNominee.getText().toString();
                strAppointeeNomineeName = appointeeNomineeName.getText().toString();
                strAppointeeNomineeDobEdit = appointeeNomineeDobEdit.getText().toString();
                strAppointeeGenderEdit = AppointeeGenderEdit.getText().toString();

                if (strNomineeName.equals("")){
                    Toast.makeText(ArogyaNomineeOtherDetails.this, "Please Enter Nominee Name", Toast.LENGTH_SHORT).show();
                }else  if (strContactNominee.equals("")){
                    Toast.makeText(ArogyaNomineeOtherDetails.this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
                }else  if (strContactNominee.length() < 10){
                    Toast.makeText(ArogyaNomineeOtherDetails.this, "Please Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                }else  if (!strContactNominee.matches("^[6-9]\\d{9}$")){
                    Toast.makeText(ArogyaNomineeOtherDetails.this, "Please Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                }else if (strNominee_dob.equals("")){
                    Toast.makeText(ArogyaNomineeOtherDetails.this, "Please Enter Nominee DOB", Toast.LENGTH_SHORT).show();
                }else if (selectNomineeYear <= 5) {
                    if (strAppointeeNomineeName.equals("")) {
                        Toast.makeText(ArogyaNomineeOtherDetails.this, "Enter Appointee Name", Toast.LENGTH_SHORT).show();
                    } else if (strAppointeeNomineeDobEdit.equals("Select Dob") || strAppointeeNomineeDobEdit.equals("")) {
                        Toast.makeText(ArogyaNomineeOtherDetails.this, "Enter Appointee DOB", Toast.LENGTH_SHORT).show();
                    } else if (strAppointeeGenderEdit.equals("Select Gender")) {
                        Toast.makeText(ArogyaNomineeOtherDetails.this, "Select Appointee Gender", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent=new Intent(ArogyaNomineeOtherDetails.this, Arogya_Payment.class);
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
                        intent.putExtra("TotalValue",str_TotalValue);
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
                        intent.putExtra("strbloodSugar",strbloodSugar);
                        intent.putExtra("strbloodPressure",strbloodPressure);
                        intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
                        intent.putExtra("stredtcholesterol",stredtcholesterol);
                        intent.putExtra("strProposerSpinner",strProposerSpinner);
                        intent.putExtra("strContactNominee",strContactNominee);
                        intent.putExtra("strNomineeName",strNomineeName);
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
                        intent.putExtra("GST",GST);
                        intent.putExtra("QuoteId",QuoteId);
                        intent.putExtra("NetPremium",NetPremium);
                        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
                        intent.putExtra("strNominee_dob",strNominee_dob);
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
                        intent.putExtra("strAppointeeNomineeName", strAppointeeNomineeName);
                        intent.putExtra("strAppointeeNomineeDobEdit", strAppointeeNomineeDobEdit);
                        intent.putExtra("strAppointeeGenderEdit", strAppointeeGenderEdit);
                        intent.putExtra("selectNomineeYear", selectNomineeYear);
                        intent.putExtra("strParentEditText", strParentEditText);
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
                }else{
                    Intent intent=new Intent(ArogyaNomineeOtherDetails.this, Arogya_Payment.class);
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
                    intent.putExtra("TotalValue",str_TotalValue);
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
                    intent.putExtra("strbloodSugar",strbloodSugar);
                    intent.putExtra("strbloodPressure",strbloodPressure);
                    intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
                    intent.putExtra("stredtcholesterol",stredtcholesterol);
                    intent.putExtra("strProposerSpinner",strProposerSpinner);
                    intent.putExtra("strContactNominee",strContactNominee);
                    intent.putExtra("strNomineeName",strNomineeName);
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
                    intent.putExtra("GST",GST);
                    intent.putExtra("QuoteId",QuoteId);
                    intent.putExtra("NetPremium",NetPremium);
                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
                    intent.putExtra("strNominee_dob",strNominee_dob);
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
                    intent.putExtra("strAppointeeNomineeName", strAppointeeNomineeName);
                    intent.putExtra("strAppointeeNomineeDobEdit", strAppointeeNomineeDobEdit);
                    intent.putExtra("strAppointeeGenderEdit", strAppointeeGenderEdit);
                    intent.putExtra("selectNomineeYear", selectNomineeYear);
                    intent.putExtra("strParentEditText", strParentEditText);
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


//                else if (str_nomineedob3String != null) {
//                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_nomineedob3String);
//                    if (dateValidation < 18 || (dateValidation > 55)) {
//                        Toast.makeText(ArogyaNomineeOtherDetails.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
//                        Nominee_dob.setText("");
//                    }else {
//                        Intent intent=new Intent(ArogyaNomineeOtherDetails.this, Arogya_Payment.class);
//                        intent.putExtra("str_edt_name",str_edt_name);
//                        intent.putExtra("str_edt_phone",str_edt_phone);
//                        intent.putExtra("str_email",str_email);
//                        intent.putExtra("str_age",str_age);
//                        intent.putExtra("str_reference_no",str_reference_no);
//                        intent.putExtra("str_edit_dob",str_edit_dob);
//                        intent.putExtra("str_gender",str_gender);
//                        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                        intent.putExtra("str_occupation",str_occupation);
//                        intent.putExtra("str_ft",str_ft);
//                        intent.putExtra("str_inches",str_inches);
//                        intent.putExtra("str_weight_edit",str_weight_edit);
//                        intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                        intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                        intent.putExtra("str_spouse_gender",str_spouse_gender);
//                        intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                        intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                        intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                        intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                        intent.putExtra("str_SumInsured",str_SumInsured);
//                        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                        intent.putExtra("str_OneEditName",str_OneEditName);
//                        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                        intent.putExtra("TotalValue",str_TotalValue);
//                        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                        intent.putExtra("str_SumInsured",str_SumInsured);
//                        intent.putExtra("strFirstTString",strFirstTString);
//                        intent.putExtra("PosPolicyNo",PosPolicyNo);
//                        intent.putExtra("strChildOne",strChildOne);
//                        intent.putExtra("strChildTwo",strChildTwo);
//                        intent.putExtra("strChildThree",strChildThree);
//                        intent.putExtra("strChildFour",strChildFour);
//                        intent.putExtra("NetPremiumValue",NetPremiumValue);
//                        intent.putExtra("strOneChild",strOneChild);
//                        intent.putExtra("strtwoDob",strtwoDob);
//                        intent.putExtra("strthreeDob",strthreeDob);
//                        intent.putExtra("strfourDob",strfourDob);
//                        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                        intent.putExtra("strbloodSugar",strbloodSugar);
//                        intent.putExtra("strbloodPressure",strbloodPressure);
//                        intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                        intent.putExtra("stredtcholesterol",stredtcholesterol);
//                        intent.putExtra("strProposerSpinner",strProposerSpinner);
//                        intent.putExtra("strContactNominee",strContactNominee);
//                        intent.putExtra("strNomineeName",strNomineeName);
//                        intent.putExtra("str_RelationEdit",str_RelationEdit);
//                        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                        intent.putExtra("strAddressLine1",strAddressLine1);
//                        intent.putExtra("strAddressLine2",strAddressLine2);
//                        intent.putExtra("strAddressLine3",strAddressLine3);
//                        intent.putExtra("strpincode",strpincode);
//                        intent.putExtra("strCityName",strCityName);
//                        intent.putExtra("strstateName",strstateName);
//                        intent.putExtra("GST",GST);
//                        intent.putExtra("QuoteId",QuoteId);
//                        intent.putExtra("NetPremium",NetPremium);
//                        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
//                        intent.putExtra("strNominee_dob",strNominee_dob);
//                        intent.putExtra("str_existing_spinner",str_existing_spinner);
//                        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
//                        intent.putExtra("for","0");
//                        startActivity(intent);
//                        finish();
//                    }
//                }

            }
        });

    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(ArogyaNomineeOtherDetails.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strNominee_dob=dateFormatter.format(newDate.getTime());
            Log.e("str_edit_dob", strNominee_dob);

            String[] strdDate=  strNominee_dob.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            str_nomineedob3String = strdDate[2];
            Log.e("str_edit_dob3String", str_nomineedob3String);

            Nominee_dob.setText(strNominee_dob);
            try {
                SelectDate = dateFormatter.parse(strNominee_dob);
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
        DatePickerDialog datePicker = new DatePickerDialog(ArogyaNomineeOtherDetails.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (selectAppointee < 18 || (selectAppointee > 75)) {
                Toast.makeText(ArogyaNomineeOtherDetails.this, "Appointee Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
                strAppointeeNomineeDobEdit = "Select Dob";
                appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);

            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ArogyaNomineeOtherDetails.this, ArogyaMedicalHistory.class);
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