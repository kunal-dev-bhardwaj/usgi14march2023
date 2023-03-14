package com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class PersonalHabbitCompleteHealthCare extends AppCompatActivity {
    String strAddDiscountBtn,strsecondAdultCritical_under_spinner2,strsOneChildCritical_under_spinner2,strtwoChildCritical_under_spinner2, strthirdChildCritical_under_spinner2,strfourChildCritical_under_spinner2,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2, strfourChildPersonal_under_spinner2,stroneChildhospital_under_spinner2,strtwoChildhospital_under_spinner2,strthirdChildhospital_under_spinner2,strfourChildhospital_under_spinner2,BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,PA_Status,CI_Status,DHC_Status,Esale_Status,Life_Status,Sub_Status,Sub_Type,Tiered_Status,PA_Status1,CI_Status1,DHC_Status1,PA_Status2,CI_Status2,DHC_Status2,PA_Status3,CI_Status3,DHC_Status3,PA_Status4,CI_Status4,DHC_Status4,PA_Status5,CI_Status5,DHC_Status5,new_str_age,ESaleDiscount,PD_Status,strSumInsuredTpeEDit,LifeStyleDiscountStr,LongTermDiscount, nextYear,tomorrowDate,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,strBMIEdit,strBMIAdultOneEdit,strBMIChildEdit,strBMIChildTwoEdit,strBMIEChildThreeEdit,strBMIFourChildEdit,strPriceTotal,strNominee_dob,str_edit_dob3String,strProposerSpinner,strContactNominee,strNomineeName,strAnyhabitual,strAnyDisease,strnoDiabetes,strSubLimit,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strbloodSugar="",strbloodPressure,strbloodPressureDiastolic,stredtcholesterol,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName,strbloodSugarAdultTwo,strbloodPressureAdultTwo,strbloodPressureDiastolicAdultTwo,strcholesterolAdultTwo,strbloodPressureChildOne,strbloodSugarChildOne,strbloodPressureDiastolicChildOne,
    strcholesterolChildOne,strbloodSugarChildTwo,strbloodPressureChildTwo,strbloodPressureDiastolicChildTwo,strcholesterolChildTwo,strbloodSugarThirdChild,strbloodPressureThirdChild,strbloodPressureDiastolicThirdChild,strcholesterolThirdChild,strbloodSugarFourChild,strbloodPressureFourChild,strbloodPressureDiastolicFourChild,strcholesterolFourChild;
    String NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit,strAddressLine1,strAddressLine2,strAddressLine3,strpincode,strCityName,strstateName;
    Date date;
    Format formatter;
    EditText policyTypeEdit,familyTypeEdit,sumInsuredEdit,policyTenureEdit,totalPremiumAmount,QuotationID,hospitalCashSpinner,oneChildPersonal_under_Edit,twoChildPersonal_under_Edit,thirdChildPersonal_under_Edit,fourChildPersonal_under_Edit,editSumInsured,subLimitAmount,discountedit,criticalEdit,peronalAccidentEdit,hospitalEdit,editPersonalAccident,editPASpinner;
    TextView show_Breakup,adultOneTxt,adultTwoTxt,childTxtOne,ChildTwoTxt,childThirdTxt,ChildFourTxt,AdultTobaccoTxt,AdultTwoTobaccoTxt,childTobaccoOne,ChildTwoTobaccoTxt,ChildThreeTobaccoTxt,TextChildFourTobacco;
    LinearLayout linerAdult1,linerAdult2,linerChildOne,linerChildTwo,linerChildThree,linerChildFour,linerAdultOneQty,linerAdultTwoQty,linerChildOneQty,linerChildTwoQty,linerChildThreeQty,linerChildFourQty,linerAdultOneTobaccoQty,linerAdultTwoTobaccoQty,AdultTwoLiner,LinerTobaccoChildOne,ChildOneTobaccoQtyLiner,Child2TobaccoLiner,linerChildTwoTobaccoQty,LinerChildThreeTobacco,LinerChildThreeTobaccoQty,LinerChildFourTobacco,LinerChildFourTobaccoQty;
    CheckBox checkbox,checkBoxAdult2,CheckboxChild1,CheckboxChild2,CheckboxChild3,CheckboxChild4,checkBoxAdult1Tobacco,checkBoxAdultTwoTobacco,checkBoxchild1Tobacco,checkBoxChild2Tobacco,checkBoxChildThreeTobacco,checkBoxChildFourTobacco;
    Button btn_continue;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_habbit_complete_health_care);
        getWindow().setStatusBarColor(ContextCompat.getColor(PersonalHabbitCompleteHealthCare.this, R.color.colorPrimaryDark));
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
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        str_for = getIntent().getStringExtra("for");
        str_amountPersonalSumInsured = getIntent().getStringExtra("str_amountPersonalSumInsured");
        strhospitalEdit = getIntent().getStringExtra("strhospitalEdit");
        strcriticalEdit = getIntent().getStringExtra("strcriticalEdit");
        strSubLimitAmount = getIntent().getStringExtra("strSubLimitAmount");
        strDiscount = getIntent().getStringExtra("strDiscount");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        GST = getIntent().getStringExtra("GST");
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
        PA_Status1 = getIntent().getStringExtra("PA_Status1");
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
        Sub_Type = getIntent().getStringExtra("Sub_Type");
        strAddDiscountBtn = getIntent().getStringExtra("strAddDiscountBtn");
        strsecondAdultCritical_under_spinner2 = getIntent().getStringExtra("strsecondAdultCritical_under_spinner2");
        strsOneChildCritical_under_spinner2 = getIntent().getStringExtra("strsOneChildCritical_under_spinner2");
        strtwoChildCritical_under_spinner2 = getIntent().getStringExtra("strtwoChildCritical_under_spinner2");
        strthirdChildCritical_under_spinner2 = getIntent().getStringExtra("strthirdChildCritical_under_spinner2");
        strfourChildCritical_under_spinner2 = getIntent().getStringExtra("strfourChildCritical_under_spinner2");
        strpersonal_under_spinner2 = getIntent().getStringExtra("strpersonal_under_spinner2");
        stroneChildPersonal_under_spinner2 = getIntent().getStringExtra("stroneChildPersonal_under_spinner2");
        strtwoChildPersonal_under_spinner2 = getIntent().getStringExtra("strtwoChildPersonal_under_spinner2");
        strthirdChildPersonal_under_spinner2 = getIntent().getStringExtra("strthirdChildPersonal_under_spinner2");
        strfourChildPersonal_under_spinner2 = getIntent().getStringExtra("strfourChildPersonal_under_spinner2");
        strhospital_under_spinner2 = getIntent().getStringExtra("strhospital_under_spinner2");
        stroneChildhospital_under_spinner2 = getIntent().getStringExtra("stroneChildhospital_under_spinner2");
        strtwoChildhospital_under_spinner2 = getIntent().getStringExtra("strtwoChildhospital_under_spinner2");
        strthirdChildhospital_under_spinner2 = getIntent().getStringExtra("strthirdChildhospital_under_spinner2");
        strfourChildhospital_under_spinner2 = getIntent().getStringExtra("strfourChildhospital_under_spinner2");
        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearChild = getIntent().getIntExtra("selectYearChild", 0);
        selectYearChildTwo = getIntent().getIntExtra("selectYearChildTwo", 0);
        selectYearChildThird = getIntent().getIntExtra("selectYearChildThird", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);

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
        hospitalCashSpinner=findViewById(R.id.hospitalCashSpinner);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        adultOneTxt=findViewById(R.id.adultOneTxt);
        adultTwoTxt=findViewById(R.id.adultTwoTxt);
        childTxtOne=findViewById(R.id.childTxtOne);
        ChildTwoTxt=findViewById(R.id.ChildTwoTxt);
        childThirdTxt=findViewById(R.id.childThirdTxt);
        ChildFourTxt=findViewById(R.id.ChildFourTxt);
        AdultTobaccoTxt=findViewById(R.id.AdultTobaccoTxt);
        AdultTwoTobaccoTxt=findViewById(R.id.AdultTwoTobaccoTxt);
        childTobaccoOne=findViewById(R.id.childTobaccoOne);
        ChildThreeTobaccoTxt=findViewById(R.id.ChildThreeTobaccoTxt);
        linerAdult1=findViewById(R.id.linerAdult1);
        linerAdult2=findViewById(R.id.linerAdult2);
        linerChildOne=findViewById(R.id.linerChildOne);
        linerChildTwo=findViewById(R.id.linerChildTwo);
        linerChildThree=findViewById(R.id.linerChildThree);
        ChildOneTobaccoQtyLiner=findViewById(R.id.ChildOneTobaccoQtyLiner);
        Child2TobaccoLiner=findViewById(R.id.Child2TobaccoLiner);
        linerChildFour=findViewById(R.id.linerChildFour);
        linerAdultOneQty=findViewById(R.id.linerAdultOneQty);
        linerAdultTwoQty=findViewById(R.id.linerAdultTwoQty);
        linerChildOneQty=findViewById(R.id.linerChildOneQty);
        linerChildTwoQty=findViewById(R.id.linerChildTwoQty);
        linerChildThreeQty=findViewById(R.id.linerChildThreeQty);
        linerChildFourQty=findViewById(R.id.linerChildFourQty);
        AdultTwoLiner=findViewById(R.id.AdultTwoLiner);
        LinerTobaccoChildOne=findViewById(R.id.LinerTobaccoChildOne);
        linerAdultOneTobaccoQty=findViewById(R.id.linerAdultOneTobaccoQty);
        linerAdultTwoTobaccoQty=findViewById(R.id.linerAdultTwoTobaccoQty);
        linerChildTwoTobaccoQty=findViewById(R.id.linerChildTwoTobaccoQty);
        LinerChildThreeTobacco=findViewById(R.id.LinerChildThreeTobacco);
        LinerChildThreeTobaccoQty=findViewById(R.id.LinerChildThreeTobaccoQty);
        LinerChildFourTobacco=findViewById(R.id.LinerChildFourTobacco);
        LinerChildFourTobaccoQty=findViewById(R.id.LinerChildFourTobaccoQty);
        show_Breakup=findViewById(R.id.show_Breakup);
        QuotationID=findViewById(R.id.QuotationID);
        checkbox=findViewById(R.id.checkbox);
        checkBoxAdult2=findViewById(R.id.checkBoxAdult2);
        CheckboxChild1=findViewById(R.id.CheckboxChild1);
        CheckboxChild2=findViewById(R.id.CheckboxChild2);
        CheckboxChild3=findViewById(R.id.CheckboxChild3);
        CheckboxChild4=findViewById(R.id.CheckboxChild4);
        checkBoxChild2Tobacco=findViewById(R.id.checkBoxChild2Tobacco);
        checkBoxchild1Tobacco=findViewById(R.id.checkBoxchild1Tobacco);
        checkBoxAdult1Tobacco=findViewById(R.id.checkBoxAdult1Tobacco);
        checkBoxAdultTwoTobacco=findViewById(R.id.checkBoxAdultTwoTobacco);
        ChildTwoTobaccoTxt=findViewById(R.id.ChildTwoTobaccoTxt);
        TextChildFourTobacco=findViewById(R.id.TextChildFourTobacco);
        checkBoxChildThreeTobacco=findViewById(R.id.checkBoxChildThreeTobacco);
        checkBoxChildFourTobacco=findViewById(R.id.checkBoxChildFourTobacco);
        btn_continue=findViewById(R.id.btn_continue);

        policyTypeEdit.setText(str_policyType_spinner);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        sumInsuredEdit.setText(str_SumInsured);
        policyTenureEdit.setText(strFirstTString+" Year");
        totalPremiumAmount.setText(str_TotalValue);
        //hospitalCashSpinner.setText(str_SumInsured);
        QuotationID.setText(PosPolicyNo);
//        hospitalCashSpinner.setAlpha(0.5f);
        policyTypeEdit.setAlpha(0.5f);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setAlpha(0.5f);
        if (str_policyType_spinner.equals("Individual")){
            adultOneTxt.setText(str_edt_name);
            AdultTobaccoTxt.setText(str_edt_name);
            linerAdult1.setVisibility(View.VISIBLE);
            linerAdultOneTobaccoQty.setVisibility(View.GONE);
            AdultTwoTobaccoTxt.setVisibility(View.GONE);
            linerAdult2.setVisibility(View.GONE);
            linerChildOne.setVisibility(View.GONE);
            linerChildTwo.setVisibility(View.GONE);
            linerChildThree.setVisibility(View.GONE);
            linerChildFour.setVisibility(View.GONE);
        }else if (str_policyType_spinner.equals("Family Floater")){
            switch (str_IndividualTypeEdit) {
                case "2 Adult":
                    linerAdult1.setVisibility(View.VISIBLE);
                    linerAdult2.setVisibility(View.VISIBLE);
                    AdultTwoLiner.setVisibility(View.VISIBLE);
                    linerChildOne.setVisibility(View.GONE);
                    linerChildTwo.setVisibility(View.GONE);
                    linerChildThree.setVisibility(View.GONE);
                    linerChildFour.setVisibility(View.GONE);
                    adultOneTxt.setText(str_edt_name);
                    AdultTobaccoTxt.setText(str_edt_name);
                    adultTwoTxt.setText(str_edt_Spouse_name);
                    AdultTwoTobaccoTxt.setText(str_edt_Spouse_name);
                    break;
                case "1 Adult + 1 Child":
                    linerAdult1.setVisibility(View.VISIBLE);
                    LinerTobaccoChildOne.setVisibility(View.VISIBLE);
                    linerAdult2.setVisibility(View.GONE);
                    linerChildOne.setVisibility(View.VISIBLE);
                    linerChildTwo.setVisibility(View.GONE);
                    linerChildThree.setVisibility(View.GONE);
                    linerChildFour.setVisibility(View.GONE);
                    adultOneTxt.setText(str_edt_name);
                    AdultTobaccoTxt.setText(str_edt_name);
                    childTxtOne.setText(str_OneEditName);
                    childTobaccoOne.setText(str_OneEditName);

                    break;
                case "1 Adult + 2 Child":
                    linerAdult1.setVisibility(View.VISIBLE);
                    LinerTobaccoChildOne.setVisibility(View.VISIBLE);
                    Child2TobaccoLiner.setVisibility(View.VISIBLE);
                    linerAdult2.setVisibility(View.GONE);
                    linerChildOne.setVisibility(View.VISIBLE);
                    linerChildTwo.setVisibility(View.VISIBLE);
                    linerChildThree.setVisibility(View.GONE);
                    linerChildFour.setVisibility(View.GONE);
                    adultOneTxt.setText(str_edt_name);
                    AdultTobaccoTxt.setText(str_edt_name);
                    AdultTwoTobaccoTxt.setText(str_edt_Spouse_name);
                    childTxtOne.setText(str_OneEditName);
                    ChildTwoTxt.setText(str_twoChildEditName);
                    childTobaccoOne.setText(str_OneEditName);
                    ChildTwoTobaccoTxt.setText(str_twoChildEditName);
                    break;
                case "1 Adult + 3 Child":
                    linerAdult1.setVisibility(View.VISIBLE);
                    LinerTobaccoChildOne.setVisibility(View.VISIBLE);
                    Child2TobaccoLiner.setVisibility(View.VISIBLE);
                    LinerChildThreeTobacco.setVisibility(View.VISIBLE);
                    linerAdult2.setVisibility(View.GONE);
                    linerChildOne.setVisibility(View.VISIBLE);
                    linerChildTwo.setVisibility(View.VISIBLE);
                    linerChildThree.setVisibility(View.VISIBLE);
                    linerChildFour.setVisibility(View.GONE);
                    adultOneTxt.setText(str_edt_name);

                    AdultTobaccoTxt.setText(str_edt_name);
                    childTxtOne.setText(str_OneEditName);
                    ChildTwoTxt.setText(str_twoChildEditName);
                    childThirdTxt.setText(str_thirdNameEdit);
                    childTobaccoOne.setText(str_OneEditName);
                    ChildTwoTobaccoTxt.setText(str_twoChildEditName);
                    ChildThreeTobaccoTxt.setText(str_thirdNameEdit);
                    break;
                case "2 Adult + 1 Child":
                    linerAdult1.setVisibility(View.VISIBLE);
                    LinerTobaccoChildOne.setVisibility(View.VISIBLE);
                    linerAdult2.setVisibility(View.VISIBLE);
                    linerChildOne.setVisibility(View.VISIBLE);
                    linerChildTwo.setVisibility(View.GONE);
                    linerChildThree.setVisibility(View.GONE);
                    linerChildFour.setVisibility(View.GONE);
                    AdultTwoLiner.setVisibility(View.VISIBLE);
                    adultOneTxt.setText(str_edt_name);
                    AdultTobaccoTxt.setText(str_edt_name);
                    AdultTwoTobaccoTxt.setText(str_edt_Spouse_name);
                    adultTwoTxt.setText(str_edt_Spouse_name);
                    childTxtOne.setText(str_OneEditName);
                    childTobaccoOne.setText(str_OneEditName);
                    break;
                case "2 Adult + 2 Child":
                    linerAdult1.setVisibility(View.VISIBLE);
                    linerAdult2.setVisibility(View.VISIBLE);
                    linerChildOne.setVisibility(View.VISIBLE);
                    linerChildTwo.setVisibility(View.VISIBLE);
                    LinerTobaccoChildOne.setVisibility(View.VISIBLE);
                    Child2TobaccoLiner.setVisibility(View.VISIBLE);
                    linerChildThree.setVisibility(View.GONE);
                    linerChildFour.setVisibility(View.GONE);
                    AdultTwoLiner.setVisibility(View.VISIBLE);
                    adultOneTxt.setText(str_edt_name);
                    adultTwoTxt.setText(str_edt_Spouse_name);
                    AdultTobaccoTxt.setText(str_edt_name);
                    AdultTwoTobaccoTxt.setText(str_edt_Spouse_name);
                    childTxtOne.setText(str_OneEditName);
                    ChildTwoTxt.setText(str_twoChildEditName);
                    childTobaccoOne.setText(str_OneEditName);
                    ChildTwoTobaccoTxt.setText(str_twoChildEditName);
                    break;
                case "2 Adult + 3 Child":
                    AdultTwoLiner.setVisibility(View.VISIBLE);
                    linerAdult1.setVisibility(View.VISIBLE);
                    linerAdult2.setVisibility(View.VISIBLE);
                    linerChildOne.setVisibility(View.VISIBLE);
                    linerChildTwo.setVisibility(View.VISIBLE);
                    LinerTobaccoChildOne.setVisibility(View.VISIBLE);
                    Child2TobaccoLiner.setVisibility(View.VISIBLE);
                    LinerChildThreeTobacco.setVisibility(View.VISIBLE);
                    linerChildThree.setVisibility(View.VISIBLE);
                    linerChildFour.setVisibility(View.GONE);
                    adultOneTxt.setText(str_edt_name);
                    adultTwoTxt.setText(str_edt_Spouse_name);
                    childTxtOne.setText(str_OneEditName);
                    AdultTobaccoTxt.setText(str_edt_name);
                    AdultTwoTobaccoTxt.setText(str_edt_Spouse_name);
                    ChildTwoTxt.setText(str_twoChildEditName);
                    childThirdTxt.setText(str_thirdNameEdit);
                    childTobaccoOne.setText(str_OneEditName);
                    ChildTwoTobaccoTxt.setText(str_twoChildEditName);
                    ChildThreeTobaccoTxt.setText(str_thirdNameEdit);
                    break;
                case "2 Adult + 4 Child":
                    AdultTwoLiner.setVisibility(View.VISIBLE);
                    linerAdult1.setVisibility(View.VISIBLE);
                    linerAdult2.setVisibility(View.VISIBLE);
                    linerChildOne.setVisibility(View.VISIBLE);
                    linerChildTwo.setVisibility(View.VISIBLE);
                    LinerTobaccoChildOne.setVisibility(View.VISIBLE);
                    LinerChildThreeTobacco.setVisibility(View.VISIBLE);
                    LinerChildFourTobacco.setVisibility(View.VISIBLE);
                    Child2TobaccoLiner.setVisibility(View.VISIBLE);
                    linerChildThree.setVisibility(View.VISIBLE);
                    linerChildFour.setVisibility(View.VISIBLE);
                    adultOneTxt.setText(str_edt_name);
                    AdultTobaccoTxt.setText(str_edt_name);
                    adultTwoTxt.setText(str_edt_Spouse_name);
                    AdultTwoTobaccoTxt.setText(str_edt_Spouse_name);
                    childTxtOne.setText(str_OneEditName);
                    ChildTwoTxt.setText(str_twoChildEditName);
                    childThirdTxt.setText(str_thirdNameEdit);
                    ChildFourTxt.setText(str_fourNameEdit);
                    childTobaccoOne.setText(str_OneEditName);
                    ChildTwoTobaccoTxt.setText(str_twoChildEditName);
                    ChildThreeTobaccoTxt.setText(str_thirdNameEdit);
                    TextChildFourTobacco.setText(str_fourNameEdit);
                    break;
               }
            }
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerAdultOneQty.setVisibility(View.VISIBLE);
                }else{
                    linerAdultOneQty.setVisibility(View.GONE);
                }
            }
        });
        checkBoxAdult2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerAdultTwoQty.setVisibility(View.VISIBLE);
                }else{
                    linerAdultTwoQty.setVisibility(View.GONE);
                }
            }
        });

        CheckboxChild1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerChildOneQty.setVisibility(View.VISIBLE);
                }else{
                    linerChildOneQty.setVisibility(View.GONE);
                }
            }
        });

        CheckboxChild2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerChildTwoQty.setVisibility(View.VISIBLE);
                }else{
                    linerChildTwoQty.setVisibility(View.GONE);
                }
            }
        });

        CheckboxChild3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerChildThreeQty.setVisibility(View.VISIBLE);
                }else{
                    linerChildThreeQty.setVisibility(View.GONE);
                }
            }
        });
        CheckboxChild4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerChildFourQty.setVisibility(View.VISIBLE);
                }else{
                    linerChildFourQty.setVisibility(View.GONE);
                }
            }
        });
        checkBoxAdult1Tobacco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerAdultOneTobaccoQty.setVisibility(View.VISIBLE);
                }else{
                    linerAdultOneTobaccoQty.setVisibility(View.GONE);
                }
            }
        });

        checkBoxAdultTwoTobacco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerAdultTwoTobaccoQty.setVisibility(View.VISIBLE);
                }else{
                    linerAdultTwoTobaccoQty.setVisibility(View.GONE);
                }
            }
        });
        checkBoxchild1Tobacco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ChildOneTobaccoQtyLiner.setVisibility(View.VISIBLE);
                }else{
                    ChildOneTobaccoQtyLiner.setVisibility(View.GONE);
                }
            }
        });
        checkBoxChild2Tobacco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linerChildTwoTobaccoQty.setVisibility(View.VISIBLE);
                }else{
                    linerChildTwoTobaccoQty.setVisibility(View.GONE);
                }
            }
        });
        checkBoxChildThreeTobacco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    LinerChildThreeTobaccoQty.setVisibility(View.VISIBLE);
                }else{
                    LinerChildThreeTobaccoQty.setVisibility(View.GONE);
                }
            }
        });
        checkBoxChildFourTobacco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    LinerChildFourTobaccoQty.setVisibility(View.VISIBLE);
                }else{
                    LinerChildFourTobaccoQty.setVisibility(View.GONE);
                }
            }
        });

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(PersonalHabbitCompleteHealthCare.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.chi_show_breakup);
                EditText ESaleTxt,longTermDiscountTxt,lifeStyleDiscountEditText,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
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
                longTermDiscountTxt = alert_dialog.findViewById(R.id.longTermDiscountTxt);
                lifeStyleDiscountEditText = alert_dialog.findViewById(R.id.lifeStyleDiscountEditText);
                ESaleTxt = alert_dialog.findViewById(R.id.ESaleTxt);


                if(PD_Status.equals("False")){
                    ESaleDiscount="110.00";
                    ESaleTxt.setText(ESaleDiscount);
                }else{
                    ESaleDiscount="110.00";
                    ESaleTxt.setText(ESaleDiscount);
                }

                if (strFirstTString.equals("2")){
                    longTermDiscountTxt.setText(LongTermDiscount);
                }else if (strFirstTString.equals("3")){
                    longTermDiscountTxt.setText(LongTermDiscount);
                }else{
                    longTermDiscountTxt.setText("0");
                }
                lifeStyleDiscountEditText.setText(LifeStyleDiscountStr);
                subLimitAmount.setText(strSubLimitAmount);

                if (strCriticalUnderSpinner2.equals("Yes")) {
                    criticalEdit.setText(strcriticalEdit);
                }else {
                    criticalEdit.setText("0");
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    premiumEdit.setText(str_amountPersonalSumInsured);
                }else{
                    premiumEdit.setText("0");
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospitalEdit.setText(strhospitalEdit);
                }else{
                    hospitalEdit.setText("0");
                }
//                if (!strAnyTreatment.equals("Yes")) {
//                    strDiscount = "0.0";
//                }
                tiedHospital.setText(strDiscount);

                basicPremium.setText(NetPremiumValue);
//                criticalEdit.setText(strcriticalEdit);
//                premiumEdit.setText(str_amountPersonalSumInsured);
//                hospitalEdit.setText(strhospitalEdit);
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

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(checkbox.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(checkBoxAdult2.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(CheckboxChild1.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(CheckboxChild2.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(CheckboxChild3.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(CheckboxChild4.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(checkBoxAdult1Tobacco.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(checkBoxAdultTwoTobacco.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(checkBoxchild1Tobacco.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(checkBoxChild2Tobacco.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(checkBoxChildThreeTobacco.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else if(checkBoxChildFourTobacco.isChecked()){
                    Toast.makeText(PersonalHabbitCompleteHealthCare.this, "Due to personal habits you cannot proceed further", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(PersonalHabbitCompleteHealthCare.this, NomineeOtherDetailsCompleteHealth.class);
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
                    intent.putExtra("new_str_age",new_str_age);
                    intent.putExtra("PA_Status",PA_Status);
                    intent.putExtra("CI_Status",CI_Status);
                    intent.putExtra("DHC_Status",DHC_Status);
                    intent.putExtra("CI_Status1",CI_Status1);
                    intent.putExtra("DHC_Status1",DHC_Status1);
                    intent.putExtra("PA_Status1",PA_Status1);
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
                    intent.putExtra("GST",GST);
                    intent.putExtra("BI_Status",BI_Status);
                    intent.putExtra("BI_Status1",BI_Status1);
                    intent.putExtra("BI_Status2",BI_Status2);
                    intent.putExtra("BI_Status3",BI_Status3);
                    intent.putExtra("BI_Status4",BI_Status4);
                    intent.putExtra("BI_Status5",BI_Status5);
                    intent.putExtra("Sub_Type",Sub_Type);
                    intent.putExtra("strAddDiscountBtn",strAddDiscountBtn);
                    intent.putExtra("strsecondAdultCritical_under_spinner2",strsecondAdultCritical_under_spinner2);
                    intent.putExtra("strsOneChildCritical_under_spinner2",strsOneChildCritical_under_spinner2);
                    intent.putExtra("strtwoChildCritical_under_spinner2",strtwoChildCritical_under_spinner2);
                    intent.putExtra("strthirdChildCritical_under_spinner2",strthirdChildCritical_under_spinner2);
                    intent.putExtra("strfourChildCritical_under_spinner2",strfourChildCritical_under_spinner2);
                    intent.putExtra("strpersonal_under_spinner2",strpersonal_under_spinner2);
                    intent.putExtra("stroneChildPersonal_under_spinner2",stroneChildPersonal_under_spinner2);
                    intent.putExtra("strtwoChildPersonal_under_spinner2",strtwoChildPersonal_under_spinner2);
                    intent.putExtra("strthirdChildPersonal_under_spinner2",strthirdChildPersonal_under_spinner2);
                    intent.putExtra("strfourChildPersonal_under_spinner2",strfourChildPersonal_under_spinner2);
                    intent.putExtra("strhospital_under_spinner2",strhospital_under_spinner2);
                    intent.putExtra("stroneChildhospital_under_spinner2",stroneChildhospital_under_spinner2);
                    intent.putExtra("strtwoChildhospital_under_spinner2",strtwoChildhospital_under_spinner2);
                    intent.putExtra("strthirdChildhospital_under_spinner2",strthirdChildhospital_under_spinner2);
                    intent.putExtra("strfourChildhospital_under_spinner2",strfourChildhospital_under_spinner2);
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
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(PersonalHabbitCompleteHealthCare.this,MedicalHistoryCompleteHealth.class);
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
        intent.putExtra("strPriceTotal",strPriceTotal);
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
        intent.putExtra("PD_Status",PD_Status);
        intent.putExtra("ESaleDiscount",ESaleDiscount);
        intent.putExtra("nextYear",nextYear);
        intent.putExtra("tomorrowDate",tomorrowDate);
        intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
        intent.putExtra("strSubLimitAmount",strSubLimitAmount);
        intent.putExtra("LifeStyleDiscountStr",LifeStyleDiscountStr);
        intent.putExtra("LongTermDiscount",LongTermDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("PA_Status",PA_Status);
        intent.putExtra("CI_Status",CI_Status);
        intent.putExtra("DHC_Status",DHC_Status);
        intent.putExtra("PA_Status1",PA_Status1);
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
        intent.putExtra("Sub_Type",Sub_Type);
        intent.putExtra("strAddDiscountBtn",strAddDiscountBtn);
        intent.putExtra("strsecondAdultCritical_under_spinner2",strsecondAdultCritical_under_spinner2);
        intent.putExtra("strsOneChildCritical_under_spinner2",strsOneChildCritical_under_spinner2);
        intent.putExtra("strtwoChildCritical_under_spinner2",strtwoChildCritical_under_spinner2);
        intent.putExtra("strthirdChildCritical_under_spinner2",strthirdChildCritical_under_spinner2);
        intent.putExtra("strfourChildCritical_under_spinner2",strfourChildCritical_under_spinner2);
        intent.putExtra("strpersonal_under_spinner2",strpersonal_under_spinner2);
        intent.putExtra("stroneChildPersonal_under_spinner2",stroneChildPersonal_under_spinner2);
        intent.putExtra("strtwoChildPersonal_under_spinner2",strtwoChildPersonal_under_spinner2);
        intent.putExtra("strthirdChildPersonal_under_spinner2",strthirdChildPersonal_under_spinner2);
        intent.putExtra("strfourChildPersonal_under_spinner2",strfourChildPersonal_under_spinner2);
        intent.putExtra("strhospital_under_spinner2",strhospital_under_spinner2);
        intent.putExtra("stroneChildhospital_under_spinner2",stroneChildhospital_under_spinner2);
        intent.putExtra("strtwoChildhospital_under_spinner2",strtwoChildhospital_under_spinner2);
        intent.putExtra("strthirdChildhospital_under_spinner2",strthirdChildhospital_under_spinner2);
        intent.putExtra("strfourChildhospital_under_spinner2",strfourChildhospital_under_spinner2);
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearChild",selectYearChild);
        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
        intent.putExtra("selectYearChildThird",selectYearChildThird);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        intent.putExtra("for","1");
        startActivity(intent);
        finish();
    }
}