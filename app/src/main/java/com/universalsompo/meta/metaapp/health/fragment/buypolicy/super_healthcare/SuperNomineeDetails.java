package com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare;

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
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.ArogyaNomineeOtherDetails;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.SuperNomineeDetails;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Payment_Complete_healthCare;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.PersonalHabbitCompleteHealthCare;

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

public class SuperNomineeDetails extends AppCompatActivity {
    String BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,PA_Status,CI_Status,DHC_Status,Esale_Status,Life_Status,Sub_Status,Sub_Type,Tiered_Status,PA_Status1,CI_Status1,DHC_Status1,PA_Status2,CI_Status2,DHC_Status2,PA_Status3,CI_Status3,DHC_Status3,PA_Status4,CI_Status4,DHC_Status4,PA_Status5,CI_Status5,DHC_Status5,new_str_age,ESaleDiscount,PD_Status,strSumInsuredTpeEDit,LifeStyleDiscountStr,LongTermDiscount, nextYear,tomorrowDate,strbloodSugarAdultTwo,strbloodPressureAdultTwo,strbloodPressureDiastolicAdultTwo,strcholesterolAdultTwo,strbloodSugarChildOne,strbloodPressureChildOne,strbloodPressureDiastolicChildOne,strcholesterolChildOne,strbloodSugarChildTwo,strbloodPressureChildTwo,strbloodPressureDiastolicChildTwo,strcholesterolChildTwo,strbloodSugarThirdChild,strbloodPressureThirdChild,strbloodPressureDiastolicThirdChild,strcholesterolThirdChild, strbloodSugarFourChild,strbloodPressureFourChild,strbloodPressureDiastolicFourChild,strcholesterolFourChild,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,str_nomineedob3String,strNominee_dob,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2,strfourChildPersonal_under_spinner2;
    String strAppointeeNomineeName, strAppointeeNomineeDobEdit, strAppointeeGenderEdit,strGlobalDiscount,strDiseaseManagement,GlobalCoverApplicable1,GlobalCoverApplicable2,GlobalCoverApplicable3,GlobalCoverApplicable4,GlobalCoverApplicable5,GlobalCoverApplicable6,IsWellnessProgram1,IsWellnessProgram2,IsWellnessProgram3,IsWellnessProgram4,IsWellnessProgram5,IsWellnessProgram6,IsLoyalCustomer,strGlobalAdultSpinner,strGlobalAdult2Spinner,strGlobalChild1Spinner,strGlobalChild2Spinner,strGlobalChild3Spinner,strGlobalChild4Spinner,strDiseaseAdult2Spinner,strAdult1OneDiseaseSpinner,strDiseaseChild1Spinner,strDiseaseChild2Spinner,strDiseaseChild3Spinner,strDiseaseChild4Spinner,TotalValue,str_employeeCodeEdit,strExisting_policy_number,str_employeeCodeDiscountValue,str_LoyaltyDiscountEdit,str_loyalty_spinner,str_employeeDiscountEditSpinner,str_life_style_spinner,str_Deductible,strBMIEdit,strBMIAdultOneEdit,strBMIChildEdit,strBMIChildTwoEdit,strBMIEChildThreeEdit,strBMIFourChildEdit,strPriceTotal,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit,str_edit_dob3String,strProposerSpinner,strNomineeName,strContactNominee,strbloodSugar,strbloodPressure,strbloodPressureDiastolic,stredtcholesterol,NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for,strAddressLine1,strAddressLine2,strAddressLine3,strpincode,strCityName,strstateName;
    Date date,CurrentDate, SelectDate;
    Format formatter;
    EditText appointeeNomineeName, appointeeNomineeDobEdit, AppointeeGenderEdit,Deductible_spinner,Nominee_dob,NomineeName,ContactNominee,policyTypeEdit,familyTypeEdit,sumInsuredEdit,employeeDiscount,deductibleEdit,policyTenureEdit,totalPremiumAmount,QuotationID,hospitalCashSpinner,oneChildPersonal_under_Edit,twoChildPersonal_under_Edit,thirdChildPersonal_under_Edit,fourChildPersonal_under_Edit,editSumInsured,subLimitAmount,discountedit,criticalEdit,peronalAccidentEdit,hospitalEdit,editPersonalAccident,editPASpinner;
    TextView show_Breakup;
    EditText proposer_spinner;
    Button btn_continue;
    LinearLayout LinerNomineeSuper,appointeeNominee,linerAppointeeSpinner;
    private SimpleDateFormat dateFormatter;
    int selectAppointee,selectNomineeYear,selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour;
    public Period period;
    ImageView calendarAppointeeIconDob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_nominee_details);
        getWindow().setStatusBarColor(ContextCompat.getColor(SuperNomineeDetails.this, R.color.colorPrimaryDark));
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
        TotalValue = getIntent().getStringExtra("TotalValue");
        strFirstTString = getIntent().getStringExtra("strFirstTString");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        strChildOne = getIntent().getStringExtra("strChildOne");
        strChildTwo = getIntent().getStringExtra("strChildTwo");
        strChildThree = getIntent().getStringExtra("strChildThree");
        strChildFour = getIntent().getStringExtra("strChildFour");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        GST = getIntent().getStringExtra("GST");
        strOneChild = getIntent().getStringExtra("strOneChild");
        strtwoDob = getIntent().getStringExtra("strtwoDob");
        strthreeDob = getIntent().getStringExtra("strthreeDob");
        strfourDob = getIntent().getStringExtra("strfourDob");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
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
        strNominee_dob = getIntent().getStringExtra("strNominee_dob");
        strAnyDisease = getIntent().getStringExtra("strAnyDisease");
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
        strbloodSugarAdultTwo = getIntent().getStringExtra("strbloodSugarAdultTwo");
        strbloodPressureAdultTwo = getIntent().getStringExtra("strbloodPressureAdultTwo");
        strbloodPressureDiastolicAdultTwo = getIntent().getStringExtra("strbloodPressureDiastolicAdultTwo");
        strcholesterolAdultTwo = getIntent().getStringExtra("strcholesterolAdultTwo");
        strbloodPressureChildOne = getIntent().getStringExtra("strbloodPressureChildOne");
        strbloodSugarChildOne = getIntent().getStringExtra("strbloodSugarChildOne");
        strbloodPressureDiastolicChildOne = getIntent().getStringExtra("strbloodPressureDiastolicChildOne");
        strcholesterolChildOne = getIntent().getStringExtra("strcholesterolChildOne");
        strbloodSugarChildTwo = getIntent().getStringExtra("strbloodSugarChildTwo");
        strbloodPressureChildTwo = getIntent().getStringExtra("strbloodPressureChildTwo");
        strbloodPressureDiastolicChildTwo = getIntent().getStringExtra("strbloodPressureDiastolicChildTwo");
        strcholesterolChildTwo = getIntent().getStringExtra("strcholesterolChildTwo");
        strbloodSugarThirdChild = getIntent().getStringExtra("strbloodSugarThirdChild");
        strbloodPressureThirdChild = getIntent().getStringExtra("strbloodPressureThirdChild");
        strbloodPressureDiastolicThirdChild = getIntent().getStringExtra("strbloodPressureDiastolicThirdChild");
        strcholesterolThirdChild = getIntent().getStringExtra("strcholesterolThirdChild");
        strbloodSugarFourChild = getIntent().getStringExtra("strbloodSugarFourChild");
        strbloodPressureFourChild = getIntent().getStringExtra("strbloodPressureFourChild");
        strbloodPressureDiastolicFourChild = getIntent().getStringExtra("strbloodPressureDiastolicFourChild");
        strcholesterolFourChild = getIntent().getStringExtra("strcholesterolFourChild");
        ESaleDiscount = getIntent().getStringExtra("ESaleDiscount");
        PD_Status = getIntent().getStringExtra("PD_Status");
        nextYear = getIntent().getStringExtra("nextYear");
        tomorrowDate = getIntent().getStringExtra("tomorrowDate");
        strSumInsuredTpeEDit = getIntent().getStringExtra("strSumInsuredTpeEDit");
        strSubLimitAmount = getIntent().getStringExtra("strSubLimitAmount");
        LifeStyleDiscountStr = getIntent().getStringExtra("LifeStyleDiscountStr");
        LongTermDiscount = getIntent().getStringExtra("LongTermDiscount");
        strCriticalUnderSpinner2 = getIntent().getStringExtra("strCriticalUnderSpinner2");
        strpersonalUnder_spinner = getIntent().getStringExtra("strpersonalUnder_spinner");
        strhospital_under_spinner = getIntent().getStringExtra("strhospital_under_spinner");
        strAnyTreatment = getIntent().getStringExtra("strAnyTreatment");
        str_amountPersonalSumInsured = getIntent().getStringExtra("str_amountPersonalSumInsured");
        strhospitalEdit = getIntent().getStringExtra("strhospitalEdit");
        strcriticalEdit = getIntent().getStringExtra("strcriticalEdit");
        strSubLimitAmount = getIntent().getStringExtra("strSubLimitAmount");
        strDiscount = getIntent().getStringExtra("strDiscount");
        new_str_age = getIntent().getStringExtra("new_str_age");
        PA_Status = getIntent().getStringExtra("PA_Status");
        CI_Status = getIntent().getStringExtra("CI_Status");
        DHC_Status = getIntent().getStringExtra("DHC_Status");
        CI_Status1 = getIntent().getStringExtra("CI_Status1");
        DHC_Status1 = getIntent().getStringExtra("DHC_Status1");
        PA_Status2 = getIntent().getStringExtra("PA_Status2");
        CI_Status2 = getIntent().getStringExtra("CI_Status2");
        DHC_Status2 = getIntent().getStringExtra("DHC_Status2");
        PA_Status3 = getIntent().getStringExtra("PA_Status3");
        CI_Status3 = getIntent().getStringExtra("CI_Status3");
        DHC_Status3 = getIntent().getStringExtra("DHC_Status3");
        PA_Status4 = getIntent().getStringExtra("PA_Status4");
        CI_Status4 = getIntent().getStringExtra("CI_Status4");
        DHC_Status4 = getIntent().getStringExtra("DHC_Status4");
        PA_Status5 = getIntent().getStringExtra("PA_Status5");
        CI_Status5 = getIntent().getStringExtra("CI_Status5");
        DHC_Status5 = getIntent().getStringExtra("DHC_Status5");
        Esale_Status = getIntent().getStringExtra("Esale_Status");
        Life_Status = getIntent().getStringExtra("Life_Status");
        Sub_Status = getIntent().getStringExtra("Sub_Status");
        Tiered_Status = getIntent().getStringExtra("Tiered_Status");
        Sub_Type = getIntent().getStringExtra("Sub_Type");
        BI_Status = getIntent().getStringExtra("BI_Status");
        BI_Status1 = getIntent().getStringExtra("BI_Status1");
        BI_Status2 = getIntent().getStringExtra("BI_Status2");
        BI_Status3 = getIntent().getStringExtra("BI_Status3");
        BI_Status4 = getIntent().getStringExtra("BI_Status4");
        BI_Status5 = getIntent().getStringExtra("BI_Status5");
        str_Deductible = getIntent().getStringExtra("str_Deductible");
        str_employeeCodeDiscountValue = getIntent().getStringExtra("str_employeeCodeDiscountValue");
        str_LoyaltyDiscountEdit = getIntent().getStringExtra("str_LoyaltyDiscountEdit");
        str_loyalty_spinner = getIntent().getStringExtra("str_loyalty_spinner");
        str_employeeDiscountEditSpinner = getIntent().getStringExtra("str_employeeDiscountEditSpinner");
        str_life_style_spinner = getIntent().getStringExtra("str_life_style_spinner");
        str_employeeCodeEdit = getIntent().getStringExtra("str_employeeCodeEdit");
        strExisting_policy_number = getIntent().getStringExtra("strExisting_policy_number");
        strGlobalAdultSpinner = getIntent().getStringExtra("strGlobalAdultSpinner");
        strGlobalAdult2Spinner = getIntent().getStringExtra("strGlobalAdult2Spinner");
        strGlobalChild1Spinner = getIntent().getStringExtra("strGlobalChild1Spinner");
        strGlobalChild2Spinner = getIntent().getStringExtra("strGlobalChild2Spinner");
        strGlobalChild3Spinner = getIntent().getStringExtra("strGlobalChild3Spinner");
        strGlobalChild4Spinner = getIntent().getStringExtra("strGlobalChild4Spinner");
        strAdult1OneDiseaseSpinner = getIntent().getStringExtra("strAdult1OneDiseaseSpinner");
        strDiseaseAdult2Spinner = getIntent().getStringExtra("strDiseaseAdult2Spinner");
        strDiseaseChild1Spinner = getIntent().getStringExtra("strDiseaseChild1Spinner");
        strDiseaseChild2Spinner = getIntent().getStringExtra("strDiseaseChild2Spinner");
        strDiseaseChild3Spinner = getIntent().getStringExtra("strDiseaseChild3Spinner");
        strDiseaseChild4Spinner = getIntent().getStringExtra("strDiseaseChild4Spinner");
        IsLoyalCustomer = getIntent().getStringExtra("IsLoyalCustomer");
        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearChild = getIntent().getIntExtra("selectYearChild", 0);
        selectYearChildTwo = getIntent().getIntExtra("selectYearChildTwo", 0);
        selectYearChildThird = getIntent().getIntExtra("selectYearChildThird", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        GlobalCoverApplicable1 = getIntent().getStringExtra("GlobalCoverApplicable1");
        GlobalCoverApplicable2 = getIntent().getStringExtra("GlobalCoverApplicable2");
        GlobalCoverApplicable3 = getIntent().getStringExtra("GlobalCoverApplicable3");
        GlobalCoverApplicable4 = getIntent().getStringExtra("GlobalCoverApplicable4");
        GlobalCoverApplicable5 = getIntent().getStringExtra("GlobalCoverApplicable5");
        GlobalCoverApplicable6 = getIntent().getStringExtra("GlobalCoverApplicable6");
        IsWellnessProgram1 = getIntent().getStringExtra("IsWellnessProgram1");
        IsWellnessProgram2 = getIntent().getStringExtra("IsWellnessProgram2");
        IsWellnessProgram3 = getIntent().getStringExtra("IsWellnessProgram3");
        IsWellnessProgram4 = getIntent().getStringExtra("IsWellnessProgram4");
        IsWellnessProgram5 = getIntent().getStringExtra("IsWellnessProgram5");
        IsWellnessProgram6 = getIntent().getStringExtra("IsWellnessProgram6");
        selectNomineeYear = getIntent().getIntExtra("selectNomineeYear", 0);
        strAppointeeNomineeName = getIntent().getStringExtra("strAppointeeNomineeName");
        strAppointeeNomineeDobEdit = getIntent().getStringExtra("strAppointeeNomineeDobEdit");
        strAppointeeGenderEdit = getIntent().getStringExtra("strAppointeeGenderEdit");

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

        initView();
    }
    private void initView() {
        LinerNomineeSuper=findViewById(R.id.LinerNomineeSuper);
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
        ContactNominee=findViewById(R.id.ContactNominee);
        btn_continue=findViewById(R.id.btn_continue);
        Nominee_dob=findViewById(R.id.Nominee_dob);
        Deductible_spinner=findViewById(R.id.Deductible_spinner);
        policyTypeEdit.setText(str_policyType_spinner);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        sumInsuredEdit.setText(str_SumInsured);
        policyTenureEdit.setText(strFirstTString+" Year");
        totalPremiumAmount.setText(TotalValue);
//        hospitalCashSpinner.setText(str_SumInsured);
        QuotationID.setText(PosPolicyNo);
//        hospitalCashSpinner.setAlpha(0.5f);
        policyTypeEdit.setAlpha(0.5f);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setAlpha(0.5f);
        Deductible_spinner.setAlpha(0.5f);
        Deductible_spinner.setText(str_Deductible);
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
            proposer_spinner.setText(strProposerSpinner);
            strAppointeeNomineeDobEdit = "Select Dob";
            strAppointeeGenderEdit = "Select Gender";
            appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);
            AppointeeGenderEdit.setText(strAppointeeGenderEdit);
        }


        LinerNomineeSuper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(SuperNomineeDetails.this);
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
        linerAppointeeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(SuperNomineeDetails.this);
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
                                Calendar calendar = Calendar.getInstance();
                                date = calendar.getTime();
                                formatter = new SimpleDateFormat("dd/MM/yyyy");
                                String today1 = formatter.format(date);
                                try {
                                    SelectDate = dateFormatter.parse(strAppointeeNomineeDobEdit);
                                    CurrentDate = dateFormatter.parse(today1);
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
                                    Toast.makeText(SuperNomineeDetails.this, "Appointee Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
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
                final Dialog alert_dialog = new Dialog(SuperNomineeDetails.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.super_show_breakup);
                EditText globalDiscount,DiseaseManagement,lifeStyleDiscountEditText,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
                Button buttonClose;

                buttonClose = alert_dialog.findViewById(R.id.buttonClose);
                employeeDiscount = alert_dialog.findViewById(R.id.employeeDiscount);
                basicPremium = alert_dialog.findViewById(R.id.basicPremium);
                sumInsuredEdit = alert_dialog.findViewById(R.id.sumInsuredEdit);
                deductibleEdit = alert_dialog.findViewById(R.id.deductibleEdit);
                gstEdit = alert_dialog.findViewById(R.id.gstEdit);
                globalDiscount = alert_dialog.findViewById(R.id.globalDiscount);
                DiseaseManagement = alert_dialog.findViewById(R.id.DiseaseManagement);
                totalAmount = alert_dialog.findViewById(R.id.totalAmount);

                basicPremium.setText(NetPremiumValue);
                sumInsuredEdit.setText(str_SumInsured);
                deductibleEdit.setText(str_Deductible);
                gstEdit.setText(GST);
                totalAmount.setText(TotalValue);
                employeeDiscount.setText(str_employeeCodeDiscountValue);

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

                buttonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });
                alert_dialog.show();
            }
        });

        Nominee_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalender();

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
                    Toast.makeText(SuperNomineeDetails.this, "Please Enter Nominee Name", Toast.LENGTH_SHORT).show();
                }else  if (strContactNominee.equals("")){
                    Toast.makeText(SuperNomineeDetails.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                }else if (strNominee_dob.equals("")){
                    Toast.makeText(SuperNomineeDetails.this, "Please Enter Nominee DOB", Toast.LENGTH_SHORT).show();
                }else if (selectNomineeYear <= 5) {
                    if (strAppointeeNomineeName.equals("")) {
                        Toast.makeText(SuperNomineeDetails.this, "Enter Appointee Name", Toast.LENGTH_SHORT).show();
                    } else if (strAppointeeNomineeDobEdit.equals("Select Dob") || strAppointeeNomineeDobEdit.equals("")) {
                        Toast.makeText(SuperNomineeDetails.this, "Enter Appointee DOB", Toast.LENGTH_SHORT).show();
                    } else if (strAppointeeGenderEdit.equals("Select Gender")) {
                        Toast.makeText(SuperNomineeDetails.this, "Select Appointee Gender", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent=new Intent(SuperNomineeDetails.this, Super_Health_Payment.class);
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
                        intent.putExtra("strNominee_dob",strNominee_dob);
                        intent.putExtra("strAnyDisease",strAnyDisease);
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
                        intent.putExtra("strOneChild",strOneChild);
                        intent.putExtra("strtwoDob",strtwoDob);
                        intent.putExtra("strthreeDob",strthreeDob);
                        intent.putExtra("strfourDob",strfourDob);
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
                        intent.putExtra("PD_Status",PD_Status);
                        intent.putExtra("ESaleDiscount",ESaleDiscount);
                        intent.putExtra("nextYear",nextYear);
                        intent.putExtra("tomorrowDate",tomorrowDate);
                        intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                        intent.putExtra("strSubLimitAmount",strSubLimitAmount);
                        intent.putExtra("LifeStyleDiscountStr",LifeStyleDiscountStr);
                        intent.putExtra("LongTermDiscount",LongTermDiscount);
                        intent.putExtra("strAnyTreatment",strAnyTreatment);
                        intent.putExtra("strCriticalUnderSpinner2",strCriticalUnderSpinner2);
                        intent.putExtra("strperonalAccidentEdit",strperonalAccidentEdit);
                        intent.putExtra("strPersonalAccidentSpinner",strPersonalAccidentSpinner);
                        intent.putExtra("strpersonalUnder_spinner",strpersonalUnder_spinner);
                        intent.putExtra("strhospital_under_spinner",strhospital_under_spinner);
                        intent.putExtra("str_amountPersonalSumInsured",str_amountPersonalSumInsured);
                        intent.putExtra("strcriticalEdit",strcriticalEdit);
                        intent.putExtra("strhospitalEdit",strhospitalEdit);
                        intent.putExtra("strDiscount",strDiscount);
                        intent.putExtra("GST",GST);
                        intent.putExtra("new_str_age",new_str_age);
                        intent.putExtra("PA_Status",PA_Status);
                        intent.putExtra("CI_Status",CI_Status);
                        intent.putExtra("DHC_Status",DHC_Status);
                        intent.putExtra("CI_Status1",CI_Status1);
                        intent.putExtra("DHC_Status1",DHC_Status1);
                        intent.putExtra("PA_Status2",PA_Status2);
                        intent.putExtra("CI_Status2",CI_Status2);
                        intent.putExtra("DHC_Status2",DHC_Status2);
                        intent.putExtra("PA_Status3",PA_Status3);
                        intent.putExtra("CI_Status3",CI_Status3);
                        intent.putExtra("DHC_Status3",DHC_Status3);
                        intent.putExtra("PA_Status4",PA_Status4);
                        intent.putExtra("CI_Status4",CI_Status4);
                        intent.putExtra("DHC_Status4",DHC_Status4);
                        intent.putExtra("PA_Status5",PA_Status5);
                        intent.putExtra("CI_Status5",CI_Status5);
                        intent.putExtra("DHC_Status5",DHC_Status5);
                        intent.putExtra("Esale_Status",Esale_Status);
                        intent.putExtra("Life_Status",Life_Status);
                        intent.putExtra("Sub_Status",Sub_Status);
                        intent.putExtra("Tiered_Status",Tiered_Status);
                        intent.putExtra("Sub_Type",Sub_Type);
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
                        intent.putExtra("str_employeeCodeEdit",str_employeeCodeEdit);
                        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
                        intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                        intent.putExtra("strGlobalAdult2Spinner",strGlobalAdult2Spinner);
                        intent.putExtra("strGlobalChild1Spinner",strGlobalChild1Spinner);
                        intent.putExtra("strGlobalChild2Spinner",strGlobalChild2Spinner);
                        intent.putExtra("strGlobalChild3Spinner",strGlobalChild3Spinner);
                        intent.putExtra("strGlobalChild4Spinner",strGlobalChild4Spinner);
                        intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                        intent.putExtra("strDiseaseAdult2Spinner",strDiseaseAdult2Spinner);
                        intent.putExtra("strDiseaseChild1Spinner",strDiseaseChild1Spinner);
                        intent.putExtra("strDiseaseChild2Spinner",strDiseaseChild2Spinner);
                        intent.putExtra("strDiseaseChild3Spinner",strDiseaseChild3Spinner);
                        intent.putExtra("strDiseaseChild4Spinner",strDiseaseChild4Spinner);
                        intent.putExtra("selectYearAdult",selectYearAdult);
                        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                        intent.putExtra("selectYearChild",selectYearChild);
                        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                        intent.putExtra("selectYearChildThird",selectYearChildThird);
                        intent.putExtra("selectYearChildFour",selectYearChildFour);
                        intent.putExtra("IsLoyalCustomer",IsLoyalCustomer);
                        intent.putExtra("GlobalCoverApplicable1",GlobalCoverApplicable1);
                        intent.putExtra("GlobalCoverApplicable2",GlobalCoverApplicable2);
                        intent.putExtra("GlobalCoverApplicable3",GlobalCoverApplicable3);
                        intent.putExtra("GlobalCoverApplicable4",GlobalCoverApplicable4);
                        intent.putExtra("GlobalCoverApplicable5",GlobalCoverApplicable5);
                        intent.putExtra("GlobalCoverApplicable6",GlobalCoverApplicable6);
                        intent.putExtra("IsWellnessProgram1",IsWellnessProgram1);
                        intent.putExtra("IsWellnessProgram2",IsWellnessProgram2);
                        intent.putExtra("IsWellnessProgram3",IsWellnessProgram3);
                        intent.putExtra("IsWellnessProgram4",IsWellnessProgram4);
                        intent.putExtra("IsWellnessProgram5",IsWellnessProgram5);
                        intent.putExtra("IsWellnessProgram6",IsWellnessProgram6);
                        intent.putExtra("strAppointeeNomineeName", strAppointeeNomineeName);
                        intent.putExtra("strAppointeeNomineeDobEdit", strAppointeeNomineeDobEdit);
                        intent.putExtra("strAppointeeGenderEdit", strAppointeeGenderEdit);
                        intent.putExtra("selectNomineeYear", selectNomineeYear);
                    }
                }else{
                    Intent intent=new Intent(SuperNomineeDetails.this, Super_Health_Payment.class);
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
                    intent.putExtra("strNominee_dob",strNominee_dob);
                    intent.putExtra("strAnyDisease",strAnyDisease);
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
                    intent.putExtra("strOneChild",strOneChild);
                    intent.putExtra("strtwoDob",strtwoDob);
                    intent.putExtra("strthreeDob",strthreeDob);
                    intent.putExtra("strfourDob",strfourDob);
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
                    intent.putExtra("PD_Status",PD_Status);
                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                    intent.putExtra("nextYear",nextYear);
                    intent.putExtra("tomorrowDate",tomorrowDate);
                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                    intent.putExtra("strSubLimitAmount",strSubLimitAmount);
                    intent.putExtra("LifeStyleDiscountStr",LifeStyleDiscountStr);
                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                    intent.putExtra("strAnyTreatment",strAnyTreatment);
                    intent.putExtra("strCriticalUnderSpinner2",strCriticalUnderSpinner2);
                    intent.putExtra("strperonalAccidentEdit",strperonalAccidentEdit);
                    intent.putExtra("strPersonalAccidentSpinner",strPersonalAccidentSpinner);
                    intent.putExtra("strpersonalUnder_spinner",strpersonalUnder_spinner);
                    intent.putExtra("strhospital_under_spinner",strhospital_under_spinner);
                    intent.putExtra("str_amountPersonalSumInsured",str_amountPersonalSumInsured);
                    intent.putExtra("strcriticalEdit",strcriticalEdit);
                    intent.putExtra("strhospitalEdit",strhospitalEdit);
                    intent.putExtra("strDiscount",strDiscount);
                    intent.putExtra("GST",GST);
                    intent.putExtra("new_str_age",new_str_age);
                    intent.putExtra("PA_Status",PA_Status);
                    intent.putExtra("CI_Status",CI_Status);
                    intent.putExtra("DHC_Status",DHC_Status);
                    intent.putExtra("CI_Status1",CI_Status1);
                    intent.putExtra("DHC_Status1",DHC_Status1);
                    intent.putExtra("PA_Status2",PA_Status2);
                    intent.putExtra("CI_Status2",CI_Status2);
                    intent.putExtra("DHC_Status2",DHC_Status2);
                    intent.putExtra("PA_Status3",PA_Status3);
                    intent.putExtra("CI_Status3",CI_Status3);
                    intent.putExtra("DHC_Status3",DHC_Status3);
                    intent.putExtra("PA_Status4",PA_Status4);
                    intent.putExtra("CI_Status4",CI_Status4);
                    intent.putExtra("DHC_Status4",DHC_Status4);
                    intent.putExtra("PA_Status5",PA_Status5);
                    intent.putExtra("CI_Status5",CI_Status5);
                    intent.putExtra("DHC_Status5",DHC_Status5);
                    intent.putExtra("Esale_Status",Esale_Status);
                    intent.putExtra("Life_Status",Life_Status);
                    intent.putExtra("Sub_Status",Sub_Status);
                    intent.putExtra("Tiered_Status",Tiered_Status);
                    intent.putExtra("Sub_Type",Sub_Type);
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
                    intent.putExtra("str_employeeCodeEdit",str_employeeCodeEdit);
                    intent.putExtra("strExisting_policy_number",strExisting_policy_number);
                    intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
                    intent.putExtra("strGlobalAdult2Spinner",strGlobalAdult2Spinner);
                    intent.putExtra("strGlobalChild1Spinner",strGlobalChild1Spinner);
                    intent.putExtra("strGlobalChild2Spinner",strGlobalChild2Spinner);
                    intent.putExtra("strGlobalChild3Spinner",strGlobalChild3Spinner);
                    intent.putExtra("strGlobalChild4Spinner",strGlobalChild4Spinner);
                    intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
                    intent.putExtra("strDiseaseAdult2Spinner",strDiseaseAdult2Spinner);
                    intent.putExtra("strDiseaseChild1Spinner",strDiseaseChild1Spinner);
                    intent.putExtra("strDiseaseChild2Spinner",strDiseaseChild2Spinner);
                    intent.putExtra("strDiseaseChild3Spinner",strDiseaseChild3Spinner);
                    intent.putExtra("strDiseaseChild4Spinner",strDiseaseChild4Spinner);
                    intent.putExtra("selectYearAdult",selectYearAdult);
                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                    intent.putExtra("selectYearChild",selectYearChild);
                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                    intent.putExtra("IsLoyalCustomer",IsLoyalCustomer);
                    intent.putExtra("GlobalCoverApplicable1",GlobalCoverApplicable1);
                    intent.putExtra("GlobalCoverApplicable2",GlobalCoverApplicable2);
                    intent.putExtra("GlobalCoverApplicable3",GlobalCoverApplicable3);
                    intent.putExtra("GlobalCoverApplicable4",GlobalCoverApplicable4);
                    intent.putExtra("GlobalCoverApplicable5",GlobalCoverApplicable5);
                    intent.putExtra("GlobalCoverApplicable6",GlobalCoverApplicable6);
                    intent.putExtra("IsWellnessProgram1",IsWellnessProgram1);
                    intent.putExtra("IsWellnessProgram2",IsWellnessProgram2);
                    intent.putExtra("IsWellnessProgram3",IsWellnessProgram3);
                    intent.putExtra("IsWellnessProgram4",IsWellnessProgram4);
                    intent.putExtra("IsWellnessProgram5",IsWellnessProgram5);
                    intent.putExtra("IsWellnessProgram6",IsWellnessProgram6);
                    intent.putExtra("strAppointeeNomineeName", strAppointeeNomineeName);
                    intent.putExtra("strAppointeeNomineeDobEdit", strAppointeeNomineeDobEdit);
                    intent.putExtra("strAppointeeGenderEdit", strAppointeeGenderEdit);
                    intent.putExtra("selectNomineeYear", selectNomineeYear);
                    intent.putExtra("for","0");
                    startActivity(intent);
                    finish();
                }


//                  else if (str_nomineedob3String != null) {
//                      int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_nomineedob3String);
//                      if (dateValidation < 18 || (dateValidation > 55)) {
//                          Toast.makeText(SuperNomineeDetails.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
//                          Nominee_dob.setText("");
//                      }else {
//                          Intent intent=new Intent(SuperNomineeDetails.this, Payment_Complete_healthCare.class);
//                          intent.putExtra("str_edt_name",str_edt_name);
//                          intent.putExtra("str_edt_phone",str_edt_phone);
//                          intent.putExtra("str_email",str_email);
//                          intent.putExtra("str_age",str_age);
//                          intent.putExtra("str_reference_no",str_reference_no);
//                          intent.putExtra("str_edit_dob",str_edit_dob);
//                          intent.putExtra("str_gender",str_gender);
//                          intent.putExtra("str_edit_dob3String",str_edit_dob3String);
//                          intent.putExtra("str_occupation",str_occupation);
//                          intent.putExtra("str_ft",str_ft);
//                          intent.putExtra("str_inches",str_inches);
//                          intent.putExtra("str_weight_edit",str_weight_edit);
//                          intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
//                          intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
//                          intent.putExtra("str_spouse_gender",str_spouse_gender);
//                          intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
//                          intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
//                          intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
//                          intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
//                          intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                          intent.putExtra("str_SumInsured",str_SumInsured);
//                          intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                          intent.putExtra("str_OneEditName",str_OneEditName);
//                          intent.putExtra("str_twoChildEditName",str_twoChildEditName);
//                          intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
//                          intent.putExtra("str_fourNameEdit",str_fourNameEdit);
//                          intent.putExtra("TotalValue",str_TotalValue);
//                          intent.putExtra("str_policyType_spinner",str_policyType_spinner);
//                          intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
//                          intent.putExtra("str_SumInsured",str_SumInsured);
//                          intent.putExtra("strFirstTString",strFirstTString);
//                          intent.putExtra("PosPolicyNo",PosPolicyNo);
//                          intent.putExtra("strChildOne",strChildOne);
//                          intent.putExtra("strChildTwo",strChildTwo);
//                          intent.putExtra("strChildThree",strChildThree);
//                          intent.putExtra("strChildFour",strChildFour);
//                          intent.putExtra("NetPremiumValue",NetPremiumValue);
//                          intent.putExtra("strOneChild",strOneChild);
//                          intent.putExtra("strtwoDob",strtwoDob);
//                          intent.putExtra("strthreeDob",strthreeDob);
//                          intent.putExtra("strfourDob",strfourDob);
//                          intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
//                          intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
//                          intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
//                          intent.putExtra("strFourWeightEdit",strFourWeightEdit);
//                          intent.putExtra("strbloodSugar",strbloodSugar);
//                          intent.putExtra("strbloodPressure",strbloodPressure);
//                          intent.putExtra("strbloodPressureDiastolic",strbloodPressureDiastolic);
//                          intent.putExtra("stredtcholesterol",stredtcholesterol);
//                          intent.putExtra("strProposerSpinner",strProposerSpinner);
//                          intent.putExtra("strContactNominee",strContactNominee);
//                          intent.putExtra("strNomineeName",strNomineeName);
//                          intent.putExtra("str_RelationEdit",str_RelationEdit);
//                          intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
//                          intent.putExtra("strRelationChildEdit",strRelationChildEdit);
//                          intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
//                          intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
//                          intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
//                          intent.putExtra("strAddressLine1",strAddressLine1);
//                          intent.putExtra("strAddressLine2",strAddressLine2);
//                          intent.putExtra("strAddressLine3",strAddressLine3);
//                          intent.putExtra("strpincode",strpincode);
//                          intent.putExtra("strCityName",strCityName);
//                          intent.putExtra("strstateName",strstateName);
//                          intent.putExtra("strNominee_dob",strNominee_dob);
//                          intent.putExtra("GST",GST);
//                          intent.putExtra("strAnyDisease",strAnyDisease);
//                          intent.putExtra("for","0");
//                          startActivity(intent);
//                          finish();
//                      }
//                  }
            }
        });

    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(SuperNomineeDetails.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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

            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today1 = formatter.format(date);
            try {
                SelectDate = dateFormatter.parse(strNominee_dob);
                CurrentDate = dateFormatter.parse(today1);
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
        DatePickerDialog datePicker = new DatePickerDialog(SuperNomineeDetails.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            strAppointeeNomineeDobEdit = dateFormatter.format(newDate.getTime());
            appointeeNomineeDobEdit.setText(strAppointeeNomineeDobEdit);
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today1 = formatter.format(date);
            try {
                SelectDate = dateFormatter.parse(strAppointeeNomineeDobEdit);
                CurrentDate = dateFormatter.parse(today1);
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
                Toast.makeText(SuperNomineeDetails.this, "Appointee Age must be between 18 to 75 years ", Toast.LENGTH_SHORT).show();
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
        Intent intent=new Intent(SuperNomineeDetails.this, SuperAddressDetails.class);
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
        intent.putExtra("TotalValue",TotalValue);
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
        intent.putExtra("strChildOne",strChildOne);
        intent.putExtra("strChildTwo",strChildTwo);
        intent.putExtra("strChildThree",strChildThree);
        intent.putExtra("strChildFour",strChildFour);
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("strOneChild",strOneChild);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
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
        intent.putExtra("PD_Status",PD_Status);
        intent.putExtra("ESaleDiscount",ESaleDiscount);
        intent.putExtra("nextYear",nextYear);
        intent.putExtra("tomorrowDate",tomorrowDate);
        intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
        intent.putExtra("strSubLimitAmount",strSubLimitAmount);
        intent.putExtra("LifeStyleDiscountStr",LifeStyleDiscountStr);
        intent.putExtra("LongTermDiscount",LongTermDiscount);
        intent.putExtra("strCriticalUnderSpinner2",strCriticalUnderSpinner2);
        intent.putExtra("strperonalAccidentEdit",strperonalAccidentEdit);
        intent.putExtra("strPersonalAccidentSpinner",strPersonalAccidentSpinner);
        intent.putExtra("strpersonalUnder_spinner",strpersonalUnder_spinner);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("strhospital_under_spinner",strhospital_under_spinner);
        intent.putExtra("PA_Status",PA_Status);
        intent.putExtra("CI_Status",CI_Status);
        intent.putExtra("DHC_Status",DHC_Status);
        intent.putExtra("CI_Status1",CI_Status1);
        intent.putExtra("DHC_Status1",DHC_Status1);
        intent.putExtra("PA_Status2",PA_Status2);
        intent.putExtra("CI_Status2",CI_Status2);
        intent.putExtra("DHC_Status2",DHC_Status2);
        intent.putExtra("PA_Status3",PA_Status3);
        intent.putExtra("CI_Status3",CI_Status3);
        intent.putExtra("DHC_Status3",DHC_Status3);
        intent.putExtra("PA_Status4",PA_Status4);
        intent.putExtra("CI_Status4",CI_Status4);
        intent.putExtra("DHC_Status4",DHC_Status4);
        intent.putExtra("PA_Status5",PA_Status5);
        intent.putExtra("CI_Status5",CI_Status5);
        intent.putExtra("DHC_Status5",DHC_Status5);
        intent.putExtra("Esale_Status",Esale_Status);
        intent.putExtra("Life_Status",Life_Status);
        intent.putExtra("Sub_Status",Sub_Status);
        intent.putExtra("Tiered_Status",Tiered_Status);
        intent.putExtra("Sub_Type",Sub_Type);
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
        intent.putExtra("str_employeeCodeEdit",str_employeeCodeEdit);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
        intent.putExtra("strGlobalAdult2Spinner",strGlobalAdult2Spinner);
        intent.putExtra("strGlobalChild1Spinner",strGlobalChild1Spinner);
        intent.putExtra("strGlobalChild2Spinner",strGlobalChild2Spinner);
        intent.putExtra("strGlobalChild3Spinner",strGlobalChild3Spinner);
        intent.putExtra("strGlobalChild4Spinner",strGlobalChild4Spinner);
        intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
        intent.putExtra("strDiseaseAdult2Spinner",strDiseaseAdult2Spinner);
        intent.putExtra("strDiseaseChild1Spinner",strDiseaseChild1Spinner);
        intent.putExtra("strDiseaseChild2Spinner",strDiseaseChild2Spinner);
        intent.putExtra("strDiseaseChild3Spinner",strDiseaseChild3Spinner);
        intent.putExtra("strDiseaseChild4Spinner",strDiseaseChild4Spinner);
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearChild",selectYearChild);
        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
        intent.putExtra("selectYearChildThird",selectYearChildThird);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        intent.putExtra("IsLoyalCustomer",IsLoyalCustomer);
        intent.putExtra("GlobalCoverApplicable1",GlobalCoverApplicable1);
        intent.putExtra("GlobalCoverApplicable2",GlobalCoverApplicable2);
        intent.putExtra("GlobalCoverApplicable3",GlobalCoverApplicable3);
        intent.putExtra("GlobalCoverApplicable4",GlobalCoverApplicable4);
        intent.putExtra("GlobalCoverApplicable5",GlobalCoverApplicable5);
        intent.putExtra("GlobalCoverApplicable6",GlobalCoverApplicable6);
        intent.putExtra("IsWellnessProgram1",IsWellnessProgram1);
        intent.putExtra("IsWellnessProgram2",IsWellnessProgram2);
        intent.putExtra("IsWellnessProgram3",IsWellnessProgram3);
        intent.putExtra("IsWellnessProgram4",IsWellnessProgram4);
        intent.putExtra("IsWellnessProgram5",IsWellnessProgram5);
        intent.putExtra("IsWellnessProgram6",IsWellnessProgram6);
        intent.putExtra("for","1");
        startActivity(intent);
        finish();
    }
}