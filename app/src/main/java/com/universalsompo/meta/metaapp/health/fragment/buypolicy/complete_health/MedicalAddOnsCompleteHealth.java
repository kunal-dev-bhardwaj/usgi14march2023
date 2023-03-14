package com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health;

import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.AllIndividualCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.AllIndividualHospitalCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.ChildCriticalCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.ChildHospitalCalculate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class MedicalAddOnsCompleteHealth extends AppCompatActivity {
    Spinner spinner_more,spinner_habitual,self_diabetes_spinner,self_hypertension_spinner,self_cholesterol_spinner,Spouse_diabetes_spinner,Spouse_hypertension_spinner,Spouse_cholesterol_spinner,self_habitual,spouse_habitual, sub_limit_spinner,treatment_spinner,Critical_under_spinner,Critical_illness_spinner,PersonalAccidentSpinner,personalUnder_spinner,personal_under_spinner2,oneChildPersonal_under_spinner2,twoChildPersonal_under_spinner2,thirdChildPersonal_under_spinner2,fourChildPersonal_under_spinner2,hospital_under_spinner,hospital_under_spinner2,oneChildhospital_under_spinner2,twoChildhospital_under_spinner2,thirdChildhospital_under_spinner2,fourChildhospital_under_spinner2,Critical_under_spinner2,secondAdultCritical_under_spinner2,sOneChildCritical_under_spinner2,twoChildCritical_under_spinner2,thirdChildCritical_under_spinner2,fourChildCritical_under_spinner2 ;
    String strSumInsuredTpeEDit,PA_Status,CI_Status,DHC_Status,Esale_Status,Life_Status,Sub_Status,Sub_Type,Tiered_Status,tomorrowDate,nextYear,ESaleDiscount,LongTermDiscount,PD_Status,LifeStyleDiscountStr,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,strPriceTotal,strNominee_dob,str_edit_dob3String,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strsecondAdultCritical_under_spinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2,strfourChildPersonal_under_spinner2;
    LinearLayout self_spouse_liner,habitual_liner,criticalLiner,criticalSpinnerLiner,addDiscountBtn,subtractDiscountBtn,subLimitLiner,yesMedicalConditionLiner,personalAccidentLiner,secondAdultCriticalSpinnerLiner,SecondAdultCashLiner,secondAdultPersonalLiner,OneChildCriticalSpinnerLiner,oneChildPersonalLiner,oneChildCashLiner, twoChildCriticalSpinnerLiner,twoChildPersonalLiner,twoChildCashLiner,thirdChildCriticalSpinnerLiner,thirdChildPersonalLiner,thirdChildCashLiner,fourChildCriticalSpinnerLiner,fourChildPersonalLiner,fourChildCashLiner;
    String[] anyDisease,yesNo,noDiabetes,noHypertension,noCholesterol,forSelf,forSpouse,subLimit,amount;
    Button btn_continue;
    String NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for;
    EditText secondAdultCritical_under_spinner2Edit,OneChildCritical_under_spinner2Edit,twoChildCritical_under_spinner2Edit,thirdChildCritical_under_spinner2Edit,fourChildCritical_under_spinner2Edit,oneChildhospital_under_spinner2Edit,twoChildhospital_under_spinner2Edit,thirdChildhospital_under_spinnerEdit,fourChildhospital_under_spinner2Edit,personal_under_spinner2Edit,hospital_under_spinner2Edit,policyTypeEdit,familyTypeEdit,sumInsuredEdit,policyTenureEdit,totalPremiumAmount,QuotationID,hospitalCashSpinner,oneChildPersonal_under_Edit,twoChildPersonal_under_Edit,thirdChildPersonal_under_Edit,fourChildPersonal_under_Edit,editSumInsured,subLimitAmount,discountedit,criticalEdit,peronalAccidentEdit,hospitalEdit,editPersonalAccident,editPASpinner;
    TextView discountTxt,criticalIllnessNameTxt,criticalIllnessAmountTxt,personalEdit,hospitalCashtxt,twoAdultCriticalIllnessTxt,SecondAdultPersonalEdit,SecondAdultTxt, OneChildCriticalIllnessTxt,OneChildPersonalEdit,oneChildTxt,twoChildCriticalIllnessTxt,twoChildPersonalEdit,twoChildTxt,thirdChildCriticalIllnessTxt,thirdChildPersonalEdit,thirdChildTxt,fourChildCriticalIllnessTxt,fourChildPersonalEdit,fourChildTxt;
    ImageView criticalDropDown,PADropDown;
    double personalSumInsured;
    double amountPersonalSumInsured=0.0;
    private static MedicalAddOnsCompleteHealth instance;
    Date date;
    TextView show_Breakup;
    Format formatter;
    MySharedPreference pref;
    CustomProgressDialog customprogress;
    String strBMIEdit,strBMIAdultOneEdit,strBMIChildEdit,strBMIChildTwoEdit,strBMIEChildThreeEdit,strBMIFourChildEdit,strsOneChildCritical_under_spinner2,strtwoChildCritical_under_spinner2,strthirdChildCritical_under_spinner2,strfourChildCritical_under_spinner2,stroneChildhospital_under_spinner2,strtwoChildhospital_under_spinner2,strthirdChildhospital_under_spinner2,strfourChildhospital_under_spinner2,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit
            ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_add_ons_complete_health);

        pref = MySharedPreference.getInstance(MedicalAddOnsCompleteHealth.this);
        customprogress = new CustomProgressDialog(MedicalAddOnsCompleteHealth.this);
        getWindow().setStatusBarColor(ContextCompat.getColor(MedicalAddOnsCompleteHealth.this, R.color.colorPrimaryDark));
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_reference_no = getIntent().getStringExtra("str_reference_no");
        str_edit_dob = getIntent().getStringExtra("str_edit_dob");
        str_edit_dob3String = getIntent().getStringExtra("str_edit_dob3String");
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
        str_RelationEdit = getIntent().getStringExtra("str_RelationEdit");
        strRelationAdultOneEdit = getIntent().getStringExtra("strRelationAdultOneEdit");
        strRelationChildEdit = getIntent().getStringExtra("strRelationChildEdit");
        strRelationChildTwoEdit = getIntent().getStringExtra("strRelationChildTwoEdit");
        strRelationChildThreeEdit = getIntent().getStringExtra("strRelationChildThreeEdit");
        strRelationFourChildEdit = getIntent().getStringExtra("strRelationFourChildEdit");
        strNominee_dob = getIntent().getStringExtra("strNominee_dob");
        strPriceTotal = getIntent().getStringExtra("strPriceTotal");
        strAnyDisease = getIntent().getStringExtra("strAnyDisease");
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
        str_for = getIntent().getStringExtra("for");

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
        PA_Status="True";
        CI_Status="True";
        DHC_Status="True";
        Esale_Status="True";
        Life_Status="True";
        Sub_Status="True";
        Tiered_Status="False";
        Sub_Type="";
        health_quote();
        initView();
        instance = this;

    }
    @SuppressLint("LongLogTag")
    private void initView() {
        policyTypeEdit = findViewById(R.id.policyTypeEdit);
        familyTypeEdit = findViewById(R.id.familyTypeEdit);
        sumInsuredEdit = findViewById(R.id.sumInsuredEdit);
        policyTenureEdit = findViewById(R.id.policyTenureEdit);
        totalPremiumAmount = findViewById(R.id.totalPremiumAmount);
        show_Breakup = findViewById(R.id.show_Breakup);
        QuotationID = findViewById(R.id.QuotationID);
        spinner_more = findViewById(R.id.spinner_more);
        spinner_habitual = findViewById(R.id.spinner_habitual);
        self_spouse_liner = findViewById(R.id.self_spouse_liner);
        self_diabetes_spinner = findViewById(R.id.self_diabetes_spinner);
        self_hypertension_spinner = findViewById(R.id.self_hypertension_spinner);
        self_cholesterol_spinner = findViewById(R.id.self_cholesterol_spinner);
        Spouse_diabetes_spinner = findViewById(R.id.Spouse_diabetes_spinner);
        Spouse_hypertension_spinner = findViewById(R.id.Spouse_hypertension_spinner);
        Spouse_cholesterol_spinner = findViewById(R.id.Spouse_cholesterol_spinner);
        self_habitual = findViewById(R.id.self_habitual);
        spouse_habitual = findViewById(R.id.spouse_habitual);
        habitual_liner = findViewById(R.id.habitual_liner);
        sub_limit_spinner = findViewById(R.id.sub_limit_spinner);
        subLimitAmount = findViewById(R.id.subLimitAmount);
        editSumInsured = findViewById(R.id.editSumInsured);
        twoAdultCriticalIllnessTxt = findViewById(R.id.twoAdultCriticalIllnessTxt);
        criticalIllnessNameTxt = findViewById(R.id.criticalIllnessNameTxt);
        criticalIllnessAmountTxt = findViewById(R.id.criticalIllnessAmountTxt);
        treatment_spinner = findViewById(R.id.treatment_spinner);
        discountedit = findViewById(R.id.discountedit);
        criticalEdit = findViewById(R.id.criticalEdit);
        editPASpinner = findViewById(R.id.editPASpinner);
        PADropDown = findViewById(R.id.PADropDown);
        editPersonalAccident = findViewById(R.id.editPersonalAccident);
        Critical_under_spinner = findViewById(R.id.Critical_under_spinner);
        Critical_illness_spinner = findViewById(R.id.Critical_illness_spinner);
        personalUnder_spinner = findViewById(R.id.personalUnder_spinner);
        SecondAdultCashLiner = findViewById(R.id.SecondAdultCashLiner);
        personal_under_spinner2 = findViewById(R.id.personal_under_spinner2);
        oneChildPersonal_under_spinner2 = findViewById(R.id.oneChildPersonal_under_spinner2);
        twoChildPersonal_under_spinner2 = findViewById(R.id.twoChildPersonal_under_spinner2);
        thirdChildPersonal_under_spinner2 = findViewById(R.id.thirdChildPersonal_under_spinner2);
        fourChildPersonal_under_spinner2 = findViewById(R.id.fourChildPersonal_under_spinner2);
        SecondAdultPersonalEdit = findViewById(R.id.SecondAdultPersonalEdit);
        hospital_under_spinner = findViewById(R.id.hospital_under_spinner);
        hospitalCashSpinner = findViewById(R.id.hospitalCashSpinner);
        PersonalAccidentSpinner = findViewById(R.id.PersonalAccidentSpinner);
        criticalSpinnerLiner = findViewById(R.id.criticalSpinnerLiner);
        hospital_under_spinner2 = findViewById(R.id.hospital_under_spinner2);
        oneChildhospital_under_spinner2 = findViewById(R.id.oneChildhospital_under_spinner2);
        twoChildhospital_under_spinner2 = findViewById(R.id.twoChildhospital_under_spinner2);
        thirdChildhospital_under_spinner2 = findViewById(R.id.thirdChildhospital_under_spinner2);
        fourChildhospital_under_spinner2 = findViewById(R.id.fourChildhospital_under_spinner2);
        Critical_under_spinner2 = findViewById(R.id.Critical_under_spinner2);
        secondAdultCritical_under_spinner2Edit = findViewById(R.id.secondAdultCritical_under_spinner2Edit);
        hospital_under_spinner2Edit = findViewById(R.id.hospital_under_spinner2Edit);
        oneChildhospital_under_spinner2Edit = findViewById(R.id.oneChildhospital_under_spinner2Edit);
        twoChildhospital_under_spinner2Edit = findViewById(R.id.twoChildhospital_under_spinner2Edit);
        thirdChildhospital_under_spinnerEdit = findViewById(R.id.thirdChildhospital_under_spinnerEdit);
        fourChildhospital_under_spinner2Edit = findViewById(R.id.fourChildhospital_under_spinner2Edit);
        personal_under_spinner2Edit = findViewById(R.id.personal_under_spinner2Edit);
        personalEdit = findViewById(R.id.personalEdit);
        peronalAccidentEdit = findViewById(R.id.peronalAccidentEdit);
        criticalLiner = findViewById(R.id.criticalLiner);
        hospitalEdit = findViewById(R.id.hospitalEdit);
        hospitalCashtxt = findViewById(R.id.hospitalCashtxt);
        btn_continue = findViewById(R.id.btn_continue);
        subLimitLiner = findViewById(R.id.subLimitLiner);
        addDiscountBtn = findViewById(R.id.addDiscountBtn);
        subtractDiscountBtn = findViewById(R.id.subtractDiscountBtn);
        yesMedicalConditionLiner = findViewById(R.id.yesMedicalConditionLiner);
        criticalDropDown = findViewById(R.id.criticalDropDown);
        personalAccidentLiner = findViewById(R.id.personalAccidentLiner);
        secondAdultCriticalSpinnerLiner = findViewById(R.id.secondAdultCriticalSpinnerLiner);
        secondAdultCritical_under_spinner2 = findViewById(R.id.secondAdultCritical_under_spinner2);
        fourChildCritical_under_spinner2 = findViewById(R.id.fourChildCritical_under_spinner2);
        thirdChildCritical_under_spinner2 = findViewById(R.id.thirdChildCritical_under_spinner2);
        twoChildCritical_under_spinner2 = findViewById(R.id.twoChildCritical_under_spinner2);
        sOneChildCritical_under_spinner2 = findViewById(R.id.sOneChildCritical_under_spinner2);
        SecondAdultTxt = findViewById(R.id.SecondAdultTxt);
        secondAdultPersonalLiner = findViewById(R.id.secondAdultPersonalLiner);
        OneChildCriticalSpinnerLiner = findViewById(R.id.OneChildCriticalSpinnerLiner);
        oneChildPersonalLiner = findViewById(R.id.oneChildPersonalLiner);
        OneChildCriticalIllnessTxt = findViewById(R.id.OneChildCriticalIllnessTxt);
        OneChildPersonalEdit = findViewById(R.id.OneChildPersonalEdit);
        oneChildTxt = findViewById(R.id.oneChildTxt);
        oneChildCashLiner = findViewById(R.id.oneChildCashLiner);
        twoChildCriticalSpinnerLiner = findViewById(R.id.twoChildCriticalSpinnerLiner);
        twoChildCriticalIllnessTxt = findViewById(R.id.twoChildCriticalIllnessTxt);
        twoChildPersonalLiner = findViewById(R.id.twoChildPersonalLiner);
        twoChildPersonalEdit = findViewById(R.id.twoChildPersonalEdit);
        twoChildCashLiner = findViewById(R.id.twoChildCashLiner);
        twoChildTxt = findViewById(R.id.twoChildTxt);
        thirdChildCriticalSpinnerLiner = findViewById(R.id.thirdChildCriticalSpinnerLiner);
        thirdChildCriticalIllnessTxt = findViewById(R.id.thirdChildCriticalIllnessTxt);
        thirdChildPersonalLiner = findViewById(R.id.thirdChildPersonalLiner);
        thirdChildPersonal_under_spinner2 = findViewById(R.id.thirdChildPersonal_under_spinner2);
        thirdChildPersonalEdit = findViewById(R.id.thirdChildPersonalEdit);
        thirdChildTxt = findViewById(R.id.thirdChildTxt);
        thirdChildCashLiner = findViewById(R.id.thirdChildCashLiner);
        fourChildCriticalSpinnerLiner = findViewById(R.id.fourChildCriticalSpinnerLiner);
        fourChildCriticalIllnessTxt = findViewById(R.id.fourChildCriticalIllnessTxt);
        fourChildPersonalEdit = findViewById(R.id.fourChildPersonalEdit);
        fourChildPersonalLiner = findViewById(R.id.fourChildPersonalLiner);
        fourChildCashLiner = findViewById(R.id.fourChildCashLiner);
        fourChildTxt = findViewById(R.id.fourChildTxt);
        oneChildPersonal_under_Edit = findViewById(R.id.oneChildPersonal_under_Edit);
        twoChildPersonal_under_Edit = findViewById(R.id.twoChildPersonal_under_Edit);
        thirdChildPersonal_under_Edit = findViewById(R.id.thirdChildPersonal_under_Edit);
        fourChildPersonal_under_Edit = findViewById(R.id.fourChildPersonal_under_Edit);
        discountTxt = findViewById(R.id.discountTxt);
        OneChildCritical_under_spinner2Edit = findViewById(R.id.OneChildCritical_under_spinner2Edit);
        twoChildCritical_under_spinner2Edit = findViewById(R.id.twoChildCritical_under_spinner2Edit);
        thirdChildCritical_under_spinner2Edit = findViewById(R.id.thirdChildCritical_under_spinner2Edit);
        fourChildCritical_under_spinner2Edit = findViewById(R.id.fourChildCritical_under_spinner2Edit);

        policyTypeEdit.setText(str_policyType_spinner);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        sumInsuredEdit.setText(str_SumInsured);
        policyTenureEdit.setText(strFirstTString + " Year");
        totalPremiumAmount.setText(str_TotalValue);
        hospitalCashSpinner.setText(str_SumInsured);
        QuotationID.setText(PosPolicyNo);
        hospitalCashSpinner.setAlpha(0.5f);
        policyTypeEdit.setAlpha(0.5f);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setAlpha(0.5f);
        anyDisease = getResources().getStringArray(R.array.any_disease);
        noDiabetes = getResources().getStringArray(R.array.no_diabetes);
        noHypertension = getResources().getStringArray(R.array.no_hypertension);
        noCholesterol = getResources().getStringArray(R.array.no_cholesterol);
        forSelf = getResources().getStringArray(R.array.for_self);
        forSpouse = getResources().getStringArray(R.array.for_spouse);
        subLimit = getResources().getStringArray(R.array.subLimit);
        amount = getResources().getStringArray(R.array.amount);
        yesNo = getResources().getStringArray(R.array.yesNo);
        spinner_more.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, anyDisease));
        spinner_habitual.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, anyDisease));
        self_diabetes_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noDiabetes));
        self_hypertension_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noHypertension));
        self_cholesterol_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noCholesterol));
        Spouse_diabetes_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noDiabetes));
        Spouse_hypertension_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noHypertension));
        Spouse_cholesterol_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noCholesterol));
        self_habitual.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, forSelf));
        spouse_habitual.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, forSpouse));
        sub_limit_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, subLimit));
        treatment_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, anyDisease));
        Critical_under_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        personalUnder_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        hospital_under_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        hospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        oneChildhospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        twoChildhospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        thirdChildhospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        fourChildhospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        Critical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        secondAdultCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        sOneChildCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        twoChildCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        thirdChildCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        fourChildCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        Critical_illness_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, amount));
        personal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        oneChildPersonal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        twoChildPersonal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        thirdChildPersonal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        fourChildPersonal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        PersonalAccidentSpinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, amount));
//        hospitalCashSpinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, amount));
        spinner_more.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strAnyDisease = String.valueOf(anyDisease[i]);
                if (strAnyDisease.equals("Yes")) {
                    final Dialog alert_dialog = new Dialog(MedicalAddOnsCompleteHealth.this);
                    alert_dialog.setCanceledOnTouchOutside(false);
                    alert_dialog.setCancelable(false);
                    alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                    alert_dialog.setContentView(R.layout.alert_dialog_medical);
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(alert_dialog.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                    lp.gravity = Gravity.CENTER;
                    TextView ok_dialog;
                    ok_dialog = alert_dialog.findViewById(R.id.ok_dialog);
                    ok_dialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alert_dialog.dismiss();
                        }
                    });
                    btn_continue.setVisibility(View.GONE);
                    alert_dialog.show();
                } else {
                    btn_continue.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        addDiscountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subLimitLiner.setVisibility(View.VISIBLE);
                subtractDiscountBtn.setVisibility(View.VISIBLE);
                addDiscountBtn.setVisibility(View.GONE);
            }
        });
        subtractDiscountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subLimitLiner.setVisibility(View.GONE);
                addDiscountBtn.setVisibility(View.VISIBLE);
                subtractDiscountBtn.setVisibility(View.GONE);
            }
        });

        self_diabetes_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strnoDiabetes = String.valueOf(noDiabetes[i]);
                if (strnoDiabetes.equals("No Diabetes Selected")) {
                    strnoDiabetes = "No";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Spouse_diabetes_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strnoSpouseDiabetes = String.valueOf(noDiabetes[i]);
                if (strnoSpouseDiabetes.equals("No Diabetes Selected")) {
                    strnoSpouseDiabetes = "No";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        self_hypertension_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strNoHypertension = String.valueOf(noHypertension[i]);
                if (strNoHypertension.equals("No Hypertension Selected")) {
                    strNoHypertension = "No";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Spouse_hypertension_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strNoSpouseHypertension = String.valueOf(noHypertension[i]);
                if (strNoSpouseHypertension.equals("No Hypertension Selected")) {
                    strNoSpouseHypertension = "No";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        self_cholesterol_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strNoCholesterol = String.valueOf(noCholesterol[i]);
                if (strNoCholesterol.equals("No Cholesterol Selected")) {
                    strNoCholesterol = "No";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Spouse_cholesterol_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strNoSpouseCholesterol = String.valueOf(noCholesterol[i]);
                if (strNoSpouseCholesterol.equals("No Cholesterol Selected")) {
                    strNoSpouseCholesterol = "No";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner_habitual.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strAnyhabitual = String.valueOf(anyDisease[i]);
                if (strAnyhabitual.equals("Yes")) {
                    habitual_liner.setVisibility(View.VISIBLE);
                } else {
                    habitual_liner.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        self_habitual.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strforSelf = String.valueOf(forSelf[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spouse_habitual.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strforSpouse = String.valueOf(forSpouse[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        sub_limit_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strSubLimit = String.valueOf(subLimit[i]);
                discountTxt.setText("(What is Sub-Limit (upto 10% Discount))");
                if (strSubLimit.equals("Sub Limit-A")) {
                    discountTxt.setText("(What is Sub-Limit (upto 10% Discount))");
                    Sub_Type="A";
                    health_quote();
//                    double intSubLimitAmount;
//                    intSubLimitAmount= (Double.parseDouble(NetPremiumValue))/10;
//                    double new_Str_TotalValue= Double.parseDouble(str_TotalValue)-intSubLimitAmount;
//                    strSubLimitAmount=String.valueOf( Math.round(intSubLimitAmount * 100.0) / 100.0);
//                    subLimitAmount.setText(strSubLimitAmount);
//                    str_TotalValue= String.valueOf(Math.round(new_Str_TotalValue * 100.0) / 100.0);
//                    totalPremiumAmount.setText(str_TotalValue);
                }else if (strSubLimit.equals("Sub Limit-B")) {
                    discountTxt.setText("(What is Sub-Limit (upto 5% Discount))");
                    Sub_Type="B";
                    health_quote();
//                    double intSubLimitAmount;
//                    intSubLimitAmount= (Double.parseDouble(NetPremiumValue))/5;
//                    double new_Str_TotalValue= Double.parseDouble(str_TotalValue)-intSubLimitAmount;
//                    strSubLimitAmount=String.valueOf( Math.round(intSubLimitAmount * 100.0) / 100.0);
//                    subLimitAmount.setText(strSubLimitAmount);
//                    str_TotalValue= String.valueOf(Math.round(new_Str_TotalValue * 100.0) / 100.0);
//                    totalPremiumAmount.setText(str_TotalValue);
                }else if (strSubLimit.equals("Sub Limit-C")) {
                    discountTxt.setText("(What is Sub-Limit (upto 5% Discount))");
                    Sub_Type="C";
                    health_quote();
//                    double intSubLimitAmount;
//                    intSubLimitAmount= (Double.parseDouble(NetPremiumValue))/5;
//                    double new_Str_TotalValue= Double.parseDouble(str_TotalValue)-intSubLimitAmount;
//                    strSubLimitAmount=String.valueOf( Math.round(intSubLimitAmount * 100.0) / 100.0);
//                    subLimitAmount.setText(strSubLimitAmount);
//                    str_TotalValue= String.valueOf(Math.round(new_Str_TotalValue * 100.0) / 100.0);
//                    totalPremiumAmount.setText(str_TotalValue);
                }else {
                    subLimitAmount.setText("0");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        treatment_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strAnyTreatment = String.valueOf(anyDisease[i]);
                if (strAnyTreatment.equals("Yes")) {
                    Tiered_Status="True";
                    health_quote();
                    discountedit.setText(strDiscount);
//                    if (strSubLimit.equals("Sub Limit-A")) {
//                     double double_strSubLimitAmount= (Double.parseDouble(strSubLimitAmount))/2;
//                        strDiscount=String.valueOf(Math.round(double_strSubLimitAmount * 100.0) / 100.0);
//                        discountedit.setText(strDiscount);
//                    }
                }else {
                    Tiered_Status="False";
                    health_quote();
//                    strDiscount="0";
//                    discountedit.setText(strDiscount);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        personalUnder_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strpersonalUnder_spinner = String.valueOf(yesNo[i]);
                if (strpersonalUnder_spinner.equals("No")){
                    if (str_policyType_spinner.equals("Individual")){
                        PA_Status="False";
                        health_quote();
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
//                        peronalAccidentEdit.setText("0.0");
                    }else {
                        if (str_IndividualTypeEdit.equals("2 Adult")){
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            peronalAccidentEdit.setText("0.0");
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+"0.0");
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            peronalAccidentEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            peronalAccidentEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+"0.0");
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            peronalAccidentEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+"0.0");
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            peronalAccidentEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+"0.0");
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            peronalAccidentEdit.setText("0.0");
                        } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+"0.0");
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+"0.0");
                            peronalAccidentEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+"0.0");
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+"0.0");
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+"0.0");
                            fourChildPersonalEdit.setText(str_fourNameEdit+" is covered under Personal Accident for Rs. "+"0.0");
                            peronalAccidentEdit.setText("0.0");
                        }
                    }
                }
                else{
                    if (str_policyType_spinner.equals("Individual")){
                        PA_Status="True";
                        health_quote();
//                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                        double personalSumInsured= amountPersonalSumInsured;
//                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                    }else {
                        if (str_IndividualTypeEdit.equals("2 Adult")){
                            double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                            double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                            double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                            double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                            double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                            double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        }
                        else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                            double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                            double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                            double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                            double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                            double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                            double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                            double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                            double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                            double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                            double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            fourChildPersonalEdit.setText(str_fourNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        } } }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Critical_under_spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strCriticalUnderSpinner2 = String.valueOf(yesNo[i]);
                if (strCriticalUnderSpinner2.equals("No")){
                    if (str_policyType_spinner.equals("Individual")){
                        CI_Status="False";
                        health_quote();
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+"0.0");
//                        criticalEdit.setText("0.0");
                    } else {
                        if (str_IndividualTypeEdit.equals("2 Adult")){
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+"0.0");
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under critical illness for Rs. "+"0.0");
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                            criticalEdit.setText("0.0");
                        } else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                            criticalEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+"0.0");
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            criticalEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+"0.0");
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under critical illness for Rs. "+"0.0");
                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            thirdChildCritical_under_spinner2.setVisibility(View.GONE);
                            criticalEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+"0.0");
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+"0.0");
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                            criticalEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                            criticalIllnessNameTxt.setText(str_edt_name + " is covered under critical illness for Rs. " + "0.0");
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under critical illness for Rs. " + "0.0");
                            OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under critical illness for Rs. " + "0.0");
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName + " is covered under critical illness for Rs. " + "0.0");
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            criticalEdit.setText("0.0");
                        } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+"0.0");
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+"0.0");
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under critical illness for Rs. "+"0.0");
                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under critical illness for Rs. "+"0.0");
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            thirdChildCritical_under_spinner2.setVisibility(View.GONE);
                            criticalEdit.setText("0.0");
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+"0.0");
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under critical illness for Rs. "+"0.0");
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+"0.0");
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under critical illness for Rs. "+"0.0");
                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under critical illness for Rs. "+"0.0");
                            fourChildCriticalIllnessTxt.setText(str_fourNameEdit+" is covered under critical illness for Rs. "+"0.0");
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2.setVisibility(View.GONE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            thirdChildCritical_under_spinner2.setVisibility(View.GONE);
                            fourChildCritical_under_spinner2.setVisibility(View.GONE);
                            fourChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                            criticalEdit.setText("0.0");
                        }
                    }
                }
                else{
                    if (str_policyType_spinner.equals("Individual")){
                        CI_Status="True";
                        health_quote();
//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit));
//                        criticalEdit.setText(strcriticalEdit);
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                    }else {
                        if (str_IndividualTypeEdit.equals("2 Adult")){
                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit));
                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                            secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                        }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            thirdChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            thirdChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                        } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                            secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                            int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt) + Integer.parseInt(strOneChildCriticalIllnessTxt));
                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                            criticalIllnessNameTxt.setText(str_edt_name + " is covered under critical illness for Rs. " + strcriticalEdit);
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under critical illness for Rs. " + strcriticalEdit);
                            OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under critical illness for Rs. " + strOneChildCriticalIllnessTxt);
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName + " is covered under critical illness for Rs. " + strOneChildCriticalIllnessTxt);
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                            secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                        } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                            secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            thirdChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            thirdChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                        }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            fourChildCriticalIllnessTxt.setText(str_fourNameEdit+" is covered under critical illness for Rs. "+strOneChildCriticalIllnessTxt);
                            secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                            secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                            OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            thirdChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                            thirdChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                        }
                    }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(MedicalAddOnsCompleteHealth.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.chi_show_breakup);
                EditText lifeStyleDiscountEditText,longTermDiscountTxt,ESaleTxt,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
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

//                if (!strAnyTreatment.equals("Yes")) {
//                    strDiscount = "0.0";
//                }
                tiedHospital.setText(strDiscount);


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


//                if (strAnyDisease.equals("Yes")) {
//                    criticalEdit.setText(strcriticalEdit);
//                    premiumEdit.setText(str_amountPersonalSumInsured);
//                    hospitalEdit.setText(strhospitalEdit);
//                }else {
//                    criticalEdit.setText("0");
//                    premiumEdit.setText("0");
//                    hospitalEdit.setText("0");
//                }
                basicPremium.setText(NetPremiumValue);
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

    }
        @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(MedicalAddOnsCompleteHealth.this,Complete_health_member_info.class);
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
        intent.putExtra("TotalValue",str_TotalValue);
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
        startActivity(intent);
        finish();

    }
    private void health_quote() {

        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("Plan_Type",str_policyType_spinner);
            object.put("Floater_Type",str_IndividualTypeEdit);
            object.put("Sum_Insured",str_SumInsured);
            object.put("Policy_Duration",strFirstTString);
            object.put("DOB",str_edit_dob);
            object.put("Proposal_Date",today);
            object.put("From_Date",tomorrowDate);
            object.put("To_Date",nextYear);
            object.put("PA_Status",PA_Status);
            object.put("CI_Status",CI_Status);
            object.put("DHC_Status",DHC_Status);
            object.put("Esale_Status",Esale_Status);
            object.put("Life_Status",Life_Status);
            object.put("PD_Status",PD_Status);
            object.put("Sub_Status",Sub_Status);
            object.put("Sub_Type",Sub_Type);
            object.put("Tiered_Status",Tiered_Status);
            object.put("Policy_Type",strSumInsuredTpeEDit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(MedicalAddOnsCompleteHealth.this, object, UrlHealthConstants.BUY_HEALTH_CARE_QUOTATION_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestHealthConstants.QUOTATION_Complete_URL) {
                        try {
                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
                            JSONObject ProductJsonObject = object.getJSONObject("Product");
                            JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                            JSONObject RisksJsonObject = ProductJsonObject.getJSONObject("Risks");
                            JSONObject newRisksJsonObject = RisksJsonObject.getJSONObject("Risk");
                            JSONObject RisksDataJsonObject = newRisksJsonObject.getJSONObject("RisksData");
                            JSONObject InsuredDetailsJsonObject = RisksDataJsonObject.getJSONObject("InsuredDetails");
                            JSONObject InsuredDetailsGroupJsonObject = InsuredDetailsJsonObject.getJSONObject("InsuredDetailsGroup");
                            JSONObject InsuredDetailsGroupDataJsonObject = InsuredDetailsGroupJsonObject.getJSONObject("InsuredDetailsGroupData");
                            JSONObject CoverDetailsJsonObject = InsuredDetailsGroupDataJsonObject.getJSONObject("CoverDetails");
                            JSONObject CoversJsonObject = CoverDetailsJsonObject.getJSONObject("Covers");
                            JSONArray CoverDataJsonObject = CoversJsonObject.getJSONArray("CoverData");
                            JSONObject OtherDiscountsJsonObject = RisksDataJsonObject.getJSONObject("OtherDiscounts");
                            JSONObject OtherDiscountGroupJsonObject = OtherDiscountsJsonObject.getJSONObject("OtherDiscountGroup");
                            JSONArray OtherDiscountGroupDataJsonObject = OtherDiscountGroupJsonObject.getJSONArray("OtherDiscountGroupData");

                            for (int j=0; j <CoverDataJsonObject.length();j++){
                                Log.e("CoverDataJsonObject",CoverDataJsonObject.toString());
                                JSONObject PersonalCoverAccidentObject = CoverDataJsonObject.getJSONObject(1);
                                JSONObject PremiumJson=PersonalCoverAccidentObject.getJSONObject("CoverPremium");
                                str_amountPersonalSumInsured = PremiumJson.getString("Value");
                                Log.e("amountPersonalSumInsured", String.valueOf(str_amountPersonalSumInsured));
                                JSONObject CriticalIllnessObject = CoverDataJsonObject.getJSONObject(2);
                                Log.e("CriticalIllnessObject",CriticalIllnessObject.toString());
                                JSONObject CriticalIllness=CriticalIllnessObject.getJSONObject("CoverPremium");
                                strcriticalEdit = CriticalIllness.getString("Value");
                                Log.e("strcriticalEdit",strcriticalEdit);
                                JSONObject HospitalCashCoverObject = CoverDataJsonObject.getJSONObject(3);
                                Log.e("HospitalCashCoverObject",HospitalCashCoverObject.toString());
                                JSONObject HospitalCash=HospitalCashCoverObject.getJSONObject("CoverPremium");
                                strhospitalEdit = HospitalCash.getString("Value");
                                Log.e("strhospitalEdit",strhospitalEdit);

                                criticalEdit.setText(strcriticalEdit);
                                peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                hospitalEdit.setText(strhospitalEdit);
                                criticalIllnessNameTxt.setText(str_edt_name+" is covered under critical illness for Rs. "+strcriticalEdit);
                                personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsured);
                                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                            }



                            for (int i=0;i <OtherDiscountGroupDataJsonObject.length();i++){

                                JSONObject LongTermJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(1);
                                JSONObject PremiumJson=LongTermJsonObject.getJSONObject("Premium");
                                LongTermDiscount = PremiumJson.getString("Value");
                                Log.e("LongTermDiscount",LongTermDiscount);

//                                JSONObject ESaleJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(3);
//                                JSONObject ESale=ESaleJsonObject.getJSONObject("Premium");
//                                ESaleDiscount = ESale.getString("Value");
//                                Log.e("ESaleDiscount",ESaleDiscount);

                                if(Tiered_Status.equals("True")){
                                    JSONObject TieredHospitalJson = OtherDiscountGroupDataJsonObject.getJSONObject(5);
                                    JSONObject TiredHospital=TieredHospitalJson.getJSONObject("Premium");
                                    strDiscount = TiredHospital.getString("Value");
                                    Log.e("strDiscount",strDiscount);

                                    JSONObject LifeStyleJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(3);
                                    JSONObject LifeStyle=LifeStyleJsonObject.getJSONObject("Premium");
                                    LifeStyleDiscountStr = LifeStyle.getString("Value");
                                    Log.e("LifeStyleDiscountStr",LifeStyleDiscountStr);

                                    JSONObject SubDiscountJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(4);
                                    JSONObject SubDiscount=SubDiscountJsonObject.getJSONObject("Premium");
                                    strSubLimitAmount = SubDiscount.getString("Value");
                                    Log.e("strSubLimitAmount",strSubLimitAmount);
                                    subLimitAmount.setText(strSubLimitAmount);
                                    discountedit.setText(strDiscount);
                                }

                                JSONObject LifeStyleJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(4);
                                JSONObject LifeStyle=LifeStyleJsonObject.getJSONObject("Premium");
                                LifeStyleDiscountStr = LifeStyle.getString("Value");
                                Log.e("LifeStyleDiscountStr",LifeStyleDiscountStr);

                                if(Tiered_Status.equals("False")){
                                    JSONObject SubDiscountJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(5);
                                    JSONObject SubDiscount=SubDiscountJsonObject.getJSONObject("Premium");
                                    strSubLimitAmount = SubDiscount.getString("Value");
                                    Log.e("strSubLimitAmount",strSubLimitAmount);
                                    subLimitAmount.setText(strSubLimitAmount);
                                    discountedit.setText(strDiscount);
                                }


                            }


                            Log.e("gg", String.valueOf(PremiumCalculationJsonObject));
                            JSONObject NetPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("NetPremium");
                            JSONObject ServiceTaxJsonObject = PremiumCalculationJsonObject.getJSONObject("ServiceTax");
                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
                            Log.e("TotalPremium", String.valueOf(TotalPremiumJsonObject));
                            NetPremiumValue = NetPremiumJsonObject.getString("Value");
                            str_TotalValue = TotalPremiumJsonObject.getString("Value");
                            PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
                            GST = ServiceTaxJsonObject.getString("Value");
//                            totalPrice= Double.parseDouble(TotalValue)-110.0;
//                            strPriceTotal= String.valueOf(totalPrice);
//                            totalPremiumAmount.setText(str_TotalValue);
                            totalPremiumAmount.setText(str_TotalValue);
//                            txtNetPremiumValue.setText(NetPremiumValue);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(getApplication(), "Cannot connect to Internet, please try again later", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestHealthConstants.QUOTATION_Complete_URL);
        req.execute();

    }

}