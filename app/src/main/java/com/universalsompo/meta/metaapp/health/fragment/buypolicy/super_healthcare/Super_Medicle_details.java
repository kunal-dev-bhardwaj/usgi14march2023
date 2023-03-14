package com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
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

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_Medical_Discount;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.AddressCompleteHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Medical_Complete_health;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Medicle_details;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Super_Medicle_details extends AppCompatActivity {
    Spinner spinner_more,spinner_habitual,self_diabetes_spinner,self_hypertension_spinner,self_cholesterol_spinner,Spouse_diabetes_spinner,Spouse_hypertension_spinner,Spouse_cholesterol_spinner,self_habitual,spouse_habitual, sub_limit_spinner,treatment_spinner,Critical_under_spinner,Critical_illness_spinner,PersonalAccidentSpinner ;
    String strDiseaseManagement,strGlobalDiscount,GlobalCoverApplicable1,GlobalCoverApplicable2,GlobalCoverApplicable3,GlobalCoverApplicable4,GlobalCoverApplicable5,GlobalCoverApplicable6,IsWellnessProgram1,IsWellnessProgram2,IsWellnessProgram3,IsWellnessProgram4,IsWellnessProgram5,IsWellnessProgram6,strGlobalChild1Spinner,strGlobalChild2Spinner,strGlobalChild3Spinner,strGlobalChild4Spinner,strAdult1OneDiseaseSpinner,strGlobalAdultSpinner,strGlobalAdult2Spinner,strDiseaseChild1Spinner,strDiseaseChild2Spinner,strDiseaseChild3Spinner,strDiseaseChild4Spinner,strDiseaseAdult2Spinner,str_LoyaltyDiscountEdit,IsLoyalCustomer,strExisting_policy_number,str_employeeCodeDiscountValue,IsEmployee,str_employeeCodeEdit,str_Deductible,str_employeeDiscountEditSpinner,BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,str_edit_dob3StringSpouse,new_str_age,strTwoChildCriticalIllnessTxt,strtwoChildTxt,strOneChildCriticalIllnessTxtthird,str_amountPersonalSumInsuredThird,strThirdChildTxt,strFourChildCriticalIllnessTxt,strFourChildTxt,amountPersonalSumInsuredFour,str_amountPersonalSumInsuredTwo,str_amountPersonalSumInsuredChild1,strcriticalEditAdult,strcriticalEditAdult1,str_amountPersonalSumInsuredAdult,str_amountPersonalSumInsuredAdult1,strhospitalEditAdult,strhospitalEditAdult1,strSumInsuredTpeEDit,PA_Status,CI_Status,DHC_Status,Esale_Status,Life_Status,Sub_Status,Sub_Type,Tiered_Status,PA_Status1,CI_Status1,DHC_Status1,PA_Status2,CI_Status2,DHC_Status2,PA_Status3,CI_Status3,DHC_Status3,PA_Status4,CI_Status4,DHC_Status4,PA_Status5,CI_Status5,DHC_Status5,tomorrowDate,nextYear,ESaleDiscount,LongTermDiscount,PD_Status,LifeStyleDiscountStr,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,strPriceTotal,strNominee_dob,str_edit_dob3String,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strsecondAdultCritical_under_spinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2,strfourChildPersonal_under_spinner2;
    LinearLayout linerMainGlobal,employeeCodeLiner,linerHabits,linerEmployeeDiscountEditSpinner,localityDiscountLiner,addDiscountBtn,subtractDiscountBtn,subLimitLiner,yesMedicalConditionLiner,personalAccidentLiner,secondAdultCriticalSpinnerLiner,SecondAdultCashLiner,secondAdultPersonalLiner,OneChildCriticalSpinnerLiner,oneChildPersonalLiner,oneChildCashLiner, twoChildCriticalSpinnerLiner,twoChildPersonalLiner,twoChildCashLiner,thirdChildCriticalSpinnerLiner,thirdChildPersonalLiner,thirdChildCashLiner,fourChildCriticalSpinnerLiner,fourChildPersonalLiner,fourChildCashLiner;
    String[] anyDisease,yesSpiner,yesNo,noDiabetes,noHypertension,noCholesterol,forSelf,forSpouse,subLimit,amount;
    Button btn_continue;
    String NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for;
    EditText LoyaltyDiscountEdit,employeeCodeDiscountValue,Deductible_spinner,secondAdultCritical_under_spinner2Edit,OneChildCritical_under_spinner2Edit,twoChildCritical_under_spinner2Edit,thirdChildCritical_under_spinner2Edit,fourChildCritical_under_spinner2Edit,oneChildhospital_under_spinner2Edit,twoChildhospital_under_spinner2Edit,thirdChildhospital_under_spinnerEdit,fourChildhospital_under_spinner2Edit,personal_under_spinner2Edit,hospital_under_spinner2Edit,policyTypeEdit,familyTypeEdit,sumInsuredEdit,employeeDiscount,deductibleEdit,policyTenureEdit,totalPremiumAmount,QuotationID,hospitalCashSpinner,oneChildPersonal_under_Edit,twoChildPersonal_under_Edit,thirdChildPersonal_under_Edit,fourChildPersonal_under_Edit,editSumInsured,subLimitAmount,discountedit,criticalEdit,peronalAccidentEdit,hospitalEdit,editPersonalAccident,editPASpinner;
    TextView editAdult2,editChild1,editChild2,editChild3,editChild4,adultTwoDisease,childOneDisease,childTwoDisease,childThreeDisease,childFourDisease,twoAdultCriticalIllnessTxt,SecondAdultPersonalEdit,SecondAdultTxt, OneChildCriticalIllnessTxt,OneChildPersonalEdit,oneChildTxt,twoChildCriticalIllnessTxt,twoChildPersonalEdit,twoChildTxt,thirdChildCriticalIllnessTxt,thirdChildPersonalEdit,thirdChildTxt,fourChildCriticalIllnessTxt,fourChildPersonalEdit,fourChildTxt;
    EditText adult1OneDiseaseSpinner,GlobalAdultSpinner,GlobalAdult2Edit,GlobalAdult2Spinner,GlobalChild1Edit,GlobalChild1Spinner,GlobalChild2Spinner,GlobalChild2Edit,GlobalChild3Edit,GlobalChild3Spinner,GlobalChild4Edit,GlobalChild4Spinner,existing_policy_number,employeeCodeEdit,life_style_spinner,employeeDiscountEditSpinner,loyalty_spinner,DiseaseAdult2Edit,DiseaseAdult2Spinner,DiseaseChild1Spinner,DiseaseChild2Spinner,DiseaseChild3Spinner,DiseaseChild4Spinner,DiseaseChild1Edit,DiseaseChild2Edit,DiseaseChild3Edit,DiseaseChild4Edit,Critical_under_spinner2,secondAdultCritical_under_spinner2,sOneChildCritical_under_spinner2,twoChildCritical_under_spinner2,thirdChildCritical_under_spinner2,fourChildCritical_under_spinner2,personalUnder_spinner,personal_under_spinner2,oneChildPersonal_under_spinner2,twoChildPersonal_under_spinner2,thirdChildPersonal_under_spinner2,fourChildPersonal_under_spinner2,hospital_under_spinner,hospital_under_spinner2,oneChildhospital_under_spinner2,twoChildhospital_under_spinner2,thirdChildhospital_under_spinner2,fourChildhospital_under_spinner2;
    ImageView criticalDropDown,PADropDown;
    LinearLayout AdultLinerGlobal,Adult2LinerGlobal,Child1LinerGlobal,Child2LinerGlobal,Child3LinerGlobal,Child4LinerGlobal,adultOneDiseaseLiner,adultTwoDiseaseLiner,Child1LinerDisease,Child2LinerDisease,Child3LinerDisease,Child4LinerDisease,GlobalAdult1Liner,adult1OneDiseaseLiner,LinerAdultTwoDisease,DiseaseChild1Liner,DiseaseChild2Liner,DiseaseChild3Liner,DiseaseChild4Liner,GlobalAdult2Liner,GlobalChild1Liner,GlobalChild2Liner,GlobalChild3Liner,GlobalChild4Liner;
    double personalSumInsured;
    double amountPersonalSumInsured=0.0;
    private static Super_Medicle_details instance;
    Date date;
    TextView show_Breakup;
    Format formatter;
    MySharedPreference pref;
    CustomProgressDialog customprogress;
    String strBMIEdit,strBMIAdultOneEdit,strBMIChildEdit,strBMIChildTwoEdit,strBMIEChildThreeEdit,strBMIFourChildEdit,strsOneChildCritical_under_spinner2,strtwoChildCritical_under_spinner2,strthirdChildCritical_under_spinner2,strfourChildCritical_under_spinner2,stroneChildhospital_under_spinner2,strtwoChildhospital_under_spinner2,strthirdChildhospital_under_spinner2,strfourChildhospital_under_spinner2,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit;
    String TotalValue,str_family_individual="",str_edit_adult="",str_no_child="",str_no_parent="",str_deductible="",str_sum_insured="",str_premium_amount="",
            str_life_style_spinner="",str_loyalty_spinner,str_existing_policy_amount="",str_existing_spinner="",str_self="",str_spouse_edit,str_proposer_self_spinner;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour;
    String[] select;
    LinearLayout loyaltyLiner;
    String TotalInstallPremium="",TotalPremium="";
    TextView editAdult1,adultOneDisease;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super__medicle_details);
        pref = MySharedPreference.getInstance(Super_Medicle_details.this);
        customprogress = new CustomProgressDialog(Super_Medicle_details.this);
        getWindow().setStatusBarColor(ContextCompat.getColor(Super_Medicle_details.this, R.color.colorPrimaryDark));
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
        new_str_age = getIntent().getStringExtra("new_str_age");
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
        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearChild = getIntent().getIntExtra("selectYearChild", 0);
        selectYearChildTwo = getIntent().getIntExtra("selectYearChildTwo", 0);
        selectYearChildThird = getIntent().getIntExtra("selectYearChildThird", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        IsLoyalCustomer = getIntent().getStringExtra("IsLoyalCustomer");
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
        str_for = getIntent().getStringExtra("for");


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

        init();
    }

    private void init() {

        linerMainGlobal=findViewById(R.id.linerMainGlobal);
        AdultLinerGlobal=findViewById(R.id.AdultLinerGlobal);
        Adult2LinerGlobal=findViewById(R.id.Adult2LinerGlobal);
        Child1LinerGlobal=findViewById(R.id.Child1LinerGlobal);
        Child2LinerGlobal=findViewById(R.id.Child2LinerGlobal);
        Child3LinerGlobal=findViewById(R.id.Child3LinerGlobal);
        Child4LinerGlobal=findViewById(R.id.Child4LinerGlobal);
        adultOneDiseaseLiner=findViewById(R.id.adultOneDiseaseLiner);
        adultTwoDiseaseLiner=findViewById(R.id.adultTwoDiseaseLiner);
        GlobalAdult1Liner=findViewById(R.id.GlobalAdult1Liner);
        GlobalAdult2Liner=findViewById(R.id.GlobalAdult2Liner);
        GlobalChild1Liner=findViewById(R.id.GlobalChild1Liner);
        GlobalChild2Liner=findViewById(R.id.GlobalChild2Liner);
        GlobalChild3Liner=findViewById(R.id.GlobalChild3Liner);
        GlobalChild4Liner=findViewById(R.id.GlobalChild4Liner);
        adult1OneDiseaseLiner=findViewById(R.id.adult1OneDiseaseLiner);
        LinerAdultTwoDisease=findViewById(R.id.LinerAdultTwoDisease);
        DiseaseChild1Liner=findViewById(R.id.DiseaseChild1Liner);
        Child1LinerDisease=findViewById(R.id.Child1LinerDisease);
        DiseaseChild2Liner=findViewById(R.id.DiseaseChild2Liner);
        Child2LinerDisease=findViewById(R.id.Child2LinerDisease);
        DiseaseChild3Liner=findViewById(R.id.DiseaseChild3Liner);
        Child3LinerDisease=findViewById(R.id.Child3LinerDisease);
        DiseaseChild4Liner=findViewById(R.id.DiseaseChild4Liner);
        Child4LinerDisease=findViewById(R.id.Child4LinerDisease);
        GlobalAdultSpinner=findViewById(R.id.GlobalAdultSpinner);
        adult1OneDiseaseSpinner=findViewById(R.id.adult1OneDiseaseSpinner);
        GlobalAdult2Edit=findViewById(R.id.GlobalAdult2Edit);
        GlobalAdult2Spinner=findViewById(R.id.GlobalAdult2Spinner);
        DiseaseAdult2Edit=findViewById(R.id.DiseaseAdult2Edit);
        DiseaseAdult2Spinner=findViewById(R.id.DiseaseAdult2Spinner);
        DiseaseChild1Spinner=findViewById(R.id.DiseaseChild1Spinner);
        DiseaseChild1Edit=findViewById(R.id.DiseaseChild1Edit);
        DiseaseChild2Spinner=findViewById(R.id.DiseaseChild2Spinner);
        DiseaseChild2Edit=findViewById(R.id.DiseaseChild2Edit);
        DiseaseChild3Spinner=findViewById(R.id.DiseaseChild3Spinner);
        DiseaseChild3Edit=findViewById(R.id.DiseaseChild3Edit);
        DiseaseChild4Spinner=findViewById(R.id.DiseaseChild4Spinner);
        DiseaseChild4Edit=findViewById(R.id.DiseaseChild4Edit);
        GlobalChild1Edit=findViewById(R.id.GlobalChild1Edit);
        GlobalChild1Spinner=findViewById(R.id.GlobalChild1Spinner);
        GlobalChild2Spinner=findViewById(R.id.GlobalChild2Spinner);
        GlobalChild2Edit=findViewById(R.id.GlobalChild2Edit);
        GlobalChild3Edit=findViewById(R.id.GlobalChild3Edit);
        GlobalChild3Spinner=findViewById(R.id.GlobalChild3Spinner);
        GlobalChild4Edit=findViewById(R.id.GlobalChild4Edit);
        GlobalChild4Spinner=findViewById(R.id.GlobalChild4Spinner);
        policyTypeEdit=findViewById(R.id.policyTypeEdit);
        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        Deductible_spinner=findViewById(R.id.Deductible_spinner);
        employeeCodeDiscountValue=findViewById(R.id.employeeCodeDiscountValue);
        LoyaltyDiscountEdit=findViewById(R.id.LoyaltyDiscountEdit);
        existing_policy_number=findViewById(R.id.existing_policy_number);
        show_Breakup=findViewById(R.id.show_Breakup);
        QuotationID=findViewById(R.id.QuotationID);
        btn_continue=findViewById(R.id.btn_continue);
        life_style_spinner=findViewById(R.id.life_style_spinner);
        loyalty_spinner=findViewById(R.id.loyalty_spinner);
        employeeCodeLiner=findViewById(R.id.employeeCodeLiner);
        employeeCodeEdit=findViewById(R.id.employeeCodeEdit);
        linerEmployeeDiscountEditSpinner=findViewById(R.id.linerEmployeeDiscountEditSpinner);
        employeeDiscountEditSpinner=findViewById(R.id.employeeDiscountEditSpinner);
        localityDiscountLiner=findViewById(R.id.localityDiscountLiner);
        loyaltyLiner=findViewById(R.id.loyaltyLiner);
        editAdult1=findViewById(R.id.editAdult1);
        editAdult2=findViewById(R.id.editAdult2);
        editChild1=findViewById(R.id.editChild1);
        editChild2=findViewById(R.id.editChild2);
        editChild3=findViewById(R.id.editChild3);
        editChild4=findViewById(R.id.editChild4);
        adultOneDisease=findViewById(R.id.adultOneDisease);
        adultTwoDisease=findViewById(R.id.adultTwoDisease);
        childOneDisease=findViewById(R.id.childOneDisease);
        childTwoDisease=findViewById(R.id.childTwoDisease);
        childThreeDisease=findViewById(R.id.childThreeDisease);
        childFourDisease=findViewById(R.id.childFourDisease);
        linerHabits=findViewById(R.id.linerHabits);

        policyTypeEdit.setText(str_policyType_spinner);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        sumInsuredEdit.setText(str_SumInsured);
        policyTenureEdit.setText(strFirstTString+" Year");
        totalPremiumAmount.setText(TotalValue);
        Deductible_spinner.setText(str_Deductible);
//        hospitalCashSpinner.setText(str_SumInsured);
        QuotationID.setText(PosPolicyNo);
//        hospitalCashSpinner.setAlpha(0.5f);
        policyTypeEdit.setAlpha(0.5f);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setAlpha(0.5f);
        Deductible_spinner.setAlpha(0.5f);
        QuotationID.setAlpha(0.5f);



        if (strSumInsuredTpeEDit.equals("Gold")){
            linerMainGlobal.setVisibility(View.GONE);
        }else{
            linerMainGlobal.setVisibility(View.VISIBLE);
        }

        if (str_for.equals("0")){
            strAnyDisease="Select";
            str_life_style_spinner="Select";
            str_employeeDiscountEditSpinner="No";
            str_loyalty_spinner="No";
            IsEmployee="N";
            IsLoyalCustomer="N";
            IsWellnessProgram1="N";
            IsWellnessProgram2="N";
            IsWellnessProgram3="N";
            IsWellnessProgram4="N";
            IsWellnessProgram5="N";
            IsWellnessProgram6="N";
            GlobalCoverApplicable1="N";
            GlobalCoverApplicable2="N";
            GlobalCoverApplicable3="N";
            GlobalCoverApplicable4="N";
            GlobalCoverApplicable5="N";
            GlobalCoverApplicable6="N";
            SuperHealthCareQuote();
            life_style_spinner.setText(str_life_style_spinner);
            employeeDiscountEditSpinner.setText(str_employeeDiscountEditSpinner);
            loyalty_spinner.setText(str_loyalty_spinner);
            if(str_policyType_spinner.equals("Individual")){
                AdultLinerGlobal.setVisibility(View.VISIBLE);
                GlobalAdult1Liner.setVisibility(View.VISIBLE);
                adult1OneDiseaseLiner.setVisibility(View.VISIBLE);
                strGlobalAdultSpinner="No";
                strAdult1OneDiseaseSpinner="No";
                GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                editAdult1.setText(str_edt_name+" is covered under Global Cover");
                adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
            }
            else{
                if (str_IndividualTypeEdit.equals("2 Adult")){
                    AdultLinerGlobal.setVisibility(View.VISIBLE);
                    GlobalAdult1Liner.setVisibility(View.VISIBLE);
                    Adult2LinerGlobal.setVisibility(View.VISIBLE);

                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);

                    strGlobalAdultSpinner="No";
                    strGlobalAdult2Spinner="No";
                    strAdult1OneDiseaseSpinner="No";
                    strDiseaseAdult2Spinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);

                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                    editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                    adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                }
                else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                    AdultLinerGlobal.setVisibility(View.VISIBLE);
                    GlobalAdult1Liner.setVisibility(View.VISIBLE);
                    Child1LinerGlobal.setVisibility(View.VISIBLE);
                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                    Child1LinerDisease.setVisibility(View.VISIBLE);
                    strGlobalAdultSpinner="No";
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    strGlobalChild1Spinner="No";
                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                    strAdult1OneDiseaseSpinner="No";
                    strDiseaseChild1Spinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                    editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                    childOneDisease.setText(str_OneEditName+" is covered under Disease Management");

                }
                else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                    AdultLinerGlobal.setVisibility(View.VISIBLE);
                    Child1LinerGlobal.setVisibility(View.VISIBLE);
                    Child2LinerGlobal.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                    Child1LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                    Child2LinerDisease.setVisibility(View.VISIBLE);
                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                    strGlobalAdultSpinner="No";
                    strGlobalChild1Spinner="No";
                    strGlobalChild2Spinner="No";
                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                    strAdult1OneDiseaseSpinner="No";
                    strDiseaseChild1Spinner="No";
                    strDiseaseChild2Spinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                    editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                    childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");

                }
                else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                    AdultLinerGlobal.setVisibility(View.VISIBLE);
                    Child1LinerGlobal.setVisibility(View.VISIBLE);
                    Child2LinerGlobal.setVisibility(View.VISIBLE);
                    Child3LinerGlobal.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                    Child1LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                    Child2LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild3Edit.setVisibility(View.VISIBLE);
                    Child3LinerDisease.setVisibility(View.VISIBLE);
                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                    GlobalChild3Edit.setVisibility(View.VISIBLE);


                    strGlobalAdultSpinner="No";
                    strGlobalChild1Spinner="No";
                    strGlobalChild2Spinner="No";
                    strGlobalChild3Spinner="No";
                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                    GlobalChild3Edit.setText(strGlobalChild3Spinner);
                    strAdult1OneDiseaseSpinner="No";
                    strDiseaseChild1Spinner="No";
                    strDiseaseChild2Spinner="No";
                    strDiseaseChild3Spinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                    DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                    editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                    editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                    childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                    childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");

                }
                else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                    AdultLinerGlobal.setVisibility(View.VISIBLE);
                    Adult2LinerGlobal.setVisibility(View.VISIBLE);
                    Child1LinerGlobal.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                    Child1LinerDisease.setVisibility(View.VISIBLE);
                    adultTwoDisease.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                    GlobalChild1Edit.setVisibility(View.VISIBLE);


                    strGlobalAdultSpinner="No";
                    strGlobalAdult2Spinner="No";
                    strGlobalChild1Spinner="No";
                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    strAdult1OneDiseaseSpinner="No";
                    strDiseaseAdult2Spinner="No";
                    strDiseaseChild1Spinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                    editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                    editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                    adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                    childOneDisease.setText(str_OneEditName+" is covered under Disease Management");

                }
                else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                    AdultLinerGlobal.setVisibility(View.VISIBLE);
                    Adult2LinerGlobal.setVisibility(View.VISIBLE);
                    Child1LinerGlobal.setVisibility(View.VISIBLE);
                    Child2LinerGlobal.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                    Child1LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                    Child2LinerDisease.setVisibility(View.VISIBLE);
                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                    strGlobalAdultSpinner="No";
                    strGlobalAdult2Spinner="No";
                    strGlobalChild1Spinner="No";
                    strGlobalChild2Spinner="No";
                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                    strAdult1OneDiseaseSpinner="No";
                    strDiseaseAdult2Spinner="No";
                    strDiseaseChild1Spinner="No";
                    strDiseaseChild2Spinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                    editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                    editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                    adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                    childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");

                }
                else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                    AdultLinerGlobal.setVisibility(View.VISIBLE);
                    Adult2LinerGlobal.setVisibility(View.VISIBLE);
                    Child1LinerGlobal.setVisibility(View.VISIBLE);
                    Child2LinerGlobal.setVisibility(View.VISIBLE);
                    Child3LinerGlobal.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                    Child1LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                    Child2LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild3Edit.setVisibility(View.VISIBLE);
                    Child3LinerDisease.setVisibility(View.VISIBLE);

                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                    GlobalChild3Edit.setVisibility(View.VISIBLE);
                    strGlobalAdultSpinner="No";
                    strGlobalAdult2Spinner="No";
                    strGlobalChild1Spinner="No";
                    strGlobalChild2Spinner="No";
                    strGlobalChild3Spinner="No";
                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                    GlobalChild3Edit.setText(strGlobalChild3Spinner);
                    strAdult1OneDiseaseSpinner="No";
                    strDiseaseAdult2Spinner="No";
                    strDiseaseChild1Spinner="No";
                    strDiseaseChild2Spinner="No";
                    strDiseaseChild3Spinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                    DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                    editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                    editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                    editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                    adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                    childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                    childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");

                }
                else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                    AdultLinerGlobal.setVisibility(View.VISIBLE);
                    Adult2LinerGlobal.setVisibility(View.VISIBLE);
                    Child1LinerGlobal.setVisibility(View.VISIBLE);
                    Child2LinerGlobal.setVisibility(View.VISIBLE);
                    Child3LinerGlobal.setVisibility(View.VISIBLE);
                    Child4LinerGlobal.setVisibility(View.VISIBLE);

                    adultOneDiseaseLiner.setVisibility(View.VISIBLE);
                    adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                    Child1LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                    Child2LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild3Edit.setVisibility(View.VISIBLE);
                    Child3LinerDisease.setVisibility(View.VISIBLE);
                    Child4LinerDisease.setVisibility(View.VISIBLE);
                    DiseaseChild4Edit.setVisibility(View.VISIBLE);

                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                    GlobalChild3Edit.setVisibility(View.VISIBLE);
                    GlobalChild4Edit.setVisibility(View.VISIBLE);
                    strGlobalAdultSpinner="No";
                    strGlobalAdult2Spinner="No";
                    strGlobalChild1Spinner="No";
                    strGlobalChild2Spinner="No";
                    strGlobalChild3Spinner="No";
                    strGlobalChild4Spinner="No";
                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                    GlobalChild3Edit.setText(strGlobalChild3Spinner);
                    GlobalChild4Edit.setText(strGlobalChild4Spinner);
                    strAdult1OneDiseaseSpinner="No";
                    strDiseaseAdult2Spinner="No";
                    strDiseaseChild1Spinner="No";
                    strDiseaseChild2Spinner="No";
                    strDiseaseChild3Spinner="No";
                    strDiseaseChild4Spinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                    DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                    DiseaseChild4Edit.setText(strDiseaseChild4Spinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                    editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                    editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                    editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");
                    editChild4.setText(str_fourNameEdit+" is covered under Global Cover");
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                    adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                    childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                    childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");
                    childFourDisease.setText(str_fourNameEdit+" is covered under Disease Management");

                }
            }
        }
        else{
            life_style_spinner.setText(str_life_style_spinner);
            if (str_employeeDiscountEditSpinner.equals("Yes")) {
                employeeCodeLiner.setVisibility(View.VISIBLE);
                employeeDiscountEditSpinner.setText(str_employeeDiscountEditSpinner);
                employeeCodeDiscountValue.setText(str_employeeCodeDiscountValue);
                employeeCodeEdit.setText(str_employeeCodeEdit);
            }else{
                str_employeeDiscountEditSpinner="No";
                employeeDiscountEditSpinner.setText(str_employeeDiscountEditSpinner);

            }
            if (str_loyalty_spinner.equals("Yes")){
                loyaltyLiner.setVisibility(View.VISIBLE);
                LoyaltyDiscountEdit.setText(str_LoyaltyDiscountEdit);
                loyalty_spinner.setText(str_loyalty_spinner);
                existing_policy_number.setText(strExisting_policy_number);
            }else{
                str_loyalty_spinner="No";
                loyalty_spinner.setText(str_loyalty_spinner);
            }
            if (strGlobalAdultSpinner.equals("No")){
                if (str_policyType_spinner.equals("Individual")){
                    strGlobalAdultSpinner="No";
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                }
                else {
                    if (str_IndividualTypeEdit.equals("2 Adult")){
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="No";
                        strGlobalAdult2Spinner="No";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                        GlobalAdult2Edit.setVisibility(View.VISIBLE);
                        GlobalAdult2Spinner.setVisibility(View.GONE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");

                    }
                    else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="No";
                        strGlobalChild1Spinner="No";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalChild1Edit.setText(strGlobalChild1Spinner);
                        GlobalChild1Edit.setVisibility(View.VISIBLE);
                        GlobalChild1Spinner.setVisibility(View.GONE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");

                    }
                    else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="No";
                        strGlobalChild1Spinner="No";
                        strGlobalChild2Spinner="No";
                        GlobalChild1Edit.setVisibility(View.VISIBLE);
                        GlobalChild2Edit.setVisibility(View.VISIBLE);
                        GlobalChild1Spinner.setVisibility(View.GONE);
                        GlobalChild2Spinner.setVisibility(View.GONE);
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalChild1Edit.setText(strGlobalChild1Spinner);
                        GlobalChild2Edit.setText(strGlobalChild2Spinner);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        Child3LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="No";
                        strGlobalChild1Spinner="No";
                        strGlobalChild2Spinner="No";
                        strGlobalChild3Spinner="No";
                        GlobalChild1Edit.setVisibility(View.VISIBLE);
                        GlobalChild2Edit.setVisibility(View.VISIBLE);
                        GlobalChild3Edit.setVisibility(View.VISIBLE);
                        GlobalChild1Spinner.setVisibility(View.GONE);
                        GlobalChild2Spinner.setVisibility(View.GONE);
                        GlobalChild3Spinner.setVisibility(View.GONE);
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalChild1Edit.setText(strGlobalChild1Spinner);
                        GlobalChild2Edit.setText(strGlobalChild2Spinner);
                        GlobalChild3Edit.setText(strGlobalChild3Spinner);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                        editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="No";
                        strGlobalAdult2Spinner="No";
                        strGlobalChild1Spinner="No";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                        GlobalChild1Edit.setText(strGlobalChild1Spinner);
                        GlobalAdult2Edit.setVisibility(View.VISIBLE);
                        GlobalAdult2Spinner.setVisibility(View.GONE);
                        GlobalChild1Edit.setVisibility(View.VISIBLE);
                        GlobalChild1Spinner.setVisibility(View.GONE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="No";
                        strGlobalAdult2Spinner="No";
                        strGlobalChild1Spinner="No";
                        strGlobalChild2Spinner="No";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                        GlobalChild1Edit.setText(strGlobalChild1Spinner);
                        GlobalChild2Edit.setText(strGlobalChild2Spinner);
                        GlobalAdult2Edit.setVisibility(View.VISIBLE);
                        GlobalAdult2Spinner.setVisibility(View.GONE);
                        GlobalChild1Edit.setVisibility(View.VISIBLE);
                        GlobalChild1Spinner.setVisibility(View.GONE);
                        GlobalChild2Edit.setVisibility(View.VISIBLE);
                        GlobalChild2Spinner.setVisibility(View.GONE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        Child3LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="No";
                        strGlobalAdult2Spinner="No";
                        strGlobalChild1Spinner="No";
                        strGlobalChild2Spinner="No";
                        strGlobalChild3Spinner="No";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                        GlobalChild1Edit.setText(strGlobalChild1Spinner);
                        GlobalChild2Edit.setText(strGlobalChild2Spinner);
                        GlobalChild3Edit.setText(strGlobalChild3Spinner);
                        GlobalAdult2Edit.setVisibility(View.VISIBLE);
                        GlobalAdult2Spinner.setVisibility(View.GONE);
                        GlobalChild1Edit.setVisibility(View.VISIBLE);
                        GlobalChild1Spinner.setVisibility(View.GONE);
                        GlobalChild2Edit.setVisibility(View.VISIBLE);
                        GlobalChild2Spinner.setVisibility(View.GONE);
                        GlobalChild3Edit.setVisibility(View.VISIBLE);
                        GlobalChild3Spinner.setVisibility(View.GONE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                        editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");

                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        Child3LinerGlobal.setVisibility(View.VISIBLE);
                        Child4LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="No";
                        strGlobalAdult2Spinner="No";
                        strGlobalChild1Spinner="No";
                        strGlobalChild2Spinner="No";
                        strGlobalChild3Spinner="No";
                        strGlobalChild4Spinner="No";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                        GlobalChild1Edit.setText(strGlobalChild1Spinner);
                        GlobalChild2Edit.setText(strGlobalChild2Spinner);
                        GlobalChild3Edit.setText(strGlobalChild3Spinner);
                        GlobalChild4Edit.setText(strGlobalChild4Spinner);
                        GlobalAdult2Edit.setVisibility(View.VISIBLE);
                        GlobalAdult2Spinner.setVisibility(View.GONE);
                        GlobalChild1Edit.setVisibility(View.VISIBLE);
                        GlobalChild1Spinner.setVisibility(View.GONE);
                        GlobalChild2Edit.setVisibility(View.VISIBLE);
                        GlobalChild2Spinner.setVisibility(View.GONE);
                        GlobalChild3Edit.setVisibility(View.VISIBLE);
                        GlobalChild3Spinner.setVisibility(View.GONE);
                        GlobalChild4Edit.setVisibility(View.VISIBLE);
                        GlobalChild4Spinner.setVisibility(View.GONE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                        editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");
                        editChild4.setText(str_fourNameEdit+" is covered under Global Cover");
                    }
                }
            }
            else{
                if (str_policyType_spinner.equals("Individual")){
                    strGlobalAdultSpinner="Yes";
                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                    editAdult1.setText(str_edt_name+" is covered under Global Cover");
                }else {
                    if (str_IndividualTypeEdit.equals("2 Adult")){
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="Yes";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                        GlobalAdult2Edit.setVisibility(View.GONE);
                        GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="Yes";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                        GlobalChild1Edit.setVisibility(View.GONE);
                        GlobalChild1Spinner.setVisibility(View.VISIBLE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="Yes";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                        GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                        GlobalChild1Edit.setVisibility(View.GONE);
                        GlobalChild1Spinner.setVisibility(View.VISIBLE);
                        GlobalChild2Edit.setVisibility(View.GONE);
                        GlobalChild2Spinner.setVisibility(View.VISIBLE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        Child3LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="Yes";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                        GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                        GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                        GlobalChild1Edit.setVisibility(View.GONE);
                        GlobalChild1Spinner.setVisibility(View.VISIBLE);
                        GlobalChild2Edit.setVisibility(View.GONE);
                        GlobalChild2Spinner.setVisibility(View.VISIBLE);
                        GlobalChild3Edit.setVisibility(View.GONE);
                        GlobalChild3Spinner.setVisibility(View.VISIBLE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                        editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="Yes";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                        GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                        GlobalAdult2Edit.setVisibility(View.GONE);
                        GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                        GlobalChild1Edit.setVisibility(View.GONE);
                        GlobalChild1Spinner.setVisibility(View.VISIBLE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");

                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="Yes";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                        GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                        GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                        GlobalAdult2Edit.setVisibility(View.GONE);
                        GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                        GlobalChild1Edit.setVisibility(View.GONE);
                        GlobalChild1Spinner.setVisibility(View.VISIBLE);
                        GlobalChild2Edit.setVisibility(View.GONE);
                        GlobalChild2Spinner.setVisibility(View.VISIBLE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");

                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        Child3LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="Yes";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                        GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                        GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                        GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                        GlobalAdult2Edit.setVisibility(View.GONE);
                        GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                        GlobalChild1Edit.setVisibility(View.GONE);
                        GlobalChild1Spinner.setVisibility(View.VISIBLE);
                        GlobalChild2Edit.setVisibility(View.GONE);
                        GlobalChild2Spinner.setVisibility(View.VISIBLE);
                        GlobalChild3Edit.setVisibility(View.GONE);
                        GlobalChild3Spinner.setVisibility(View.VISIBLE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                        editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");
                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                        Adult2LinerGlobal.setVisibility(View.VISIBLE);
                        Child1LinerGlobal.setVisibility(View.VISIBLE);
                        Child2LinerGlobal.setVisibility(View.VISIBLE);
                        Child3LinerGlobal.setVisibility(View.VISIBLE);
                        Child4LinerGlobal.setVisibility(View.VISIBLE);
                        strGlobalAdultSpinner="Yes";
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                        GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                        GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                        GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                        GlobalChild4Spinner.setText(strGlobalChild4Spinner);
                        GlobalAdult2Edit.setVisibility(View.GONE);
                        GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                        GlobalChild1Edit.setVisibility(View.GONE);
                        GlobalChild1Spinner.setVisibility(View.VISIBLE);
                        GlobalChild2Edit.setVisibility(View.GONE);
                        GlobalChild2Spinner.setVisibility(View.VISIBLE);
                        GlobalChild3Edit.setVisibility(View.GONE);
                        GlobalChild3Spinner.setVisibility(View.VISIBLE);
                        GlobalChild4Edit.setVisibility(View.GONE);
                        GlobalChild4Spinner.setVisibility(View.VISIBLE);
                        editAdult1.setText(str_edt_name+" is covered under Global Cover");
                        editAdult2.setText(str_edt_Spouse_name+" is covered under Global Cover");
                        editChild1.setText(str_OneEditName+" is covered under Global Cover");
                        editChild2.setText(str_twoChildEditName+" is covered under Global Cover");
                        editChild3.setText(str_thirdNameEdit+" is covered under Global Cover");
                        editChild4.setText(str_fourNameEdit+" is covered under Global Cover");
                    }
                }

            }

            if (strAdult1OneDiseaseSpinner.equals("No")){
                if (str_policyType_spinner.equals("Individual")){
                    strAdult1OneDiseaseSpinner="No";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                }
                else {
                    if (str_IndividualTypeEdit.equals("2 Adult")){
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="No";
                        strDiseaseAdult2Spinner="No";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                        DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                        DiseaseAdult2Spinner.setVisibility(View.GONE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                    }
                    else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="No";
                        strDiseaseChild1Spinner="No";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                        DiseaseChild1Edit.setVisibility(View.VISIBLE);
                        DiseaseChild1Spinner.setVisibility(View.GONE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="No";
                        strDiseaseChild1Spinner="No";
                        strDiseaseChild2Spinner="No";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                        DiseaseChild1Edit.setVisibility(View.VISIBLE);
                        DiseaseChild1Spinner.setVisibility(View.GONE);
                        DiseaseChild2Spinner.setVisibility(View.GONE);
                        DiseaseChild2Edit.setVisibility(View.VISIBLE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                    }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        Child3LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="No";
                        strDiseaseChild1Spinner="No";
                        strDiseaseChild2Spinner="No";
                        strDiseaseChild3Spinner="No";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                        DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                        DiseaseChild1Edit.setVisibility(View.VISIBLE);
                        DiseaseChild1Spinner.setVisibility(View.GONE);
                        DiseaseChild2Spinner.setVisibility(View.GONE);
                        DiseaseChild2Edit.setVisibility(View.VISIBLE);
                        DiseaseChild3Edit.setVisibility(View.VISIBLE);
                        DiseaseChild3Spinner.setVisibility(View.GONE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                        childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");

                    }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="No";
                        strDiseaseAdult2Spinner="No";
                        strDiseaseChild1Spinner="No";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                        DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                        DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                        DiseaseAdult2Spinner.setVisibility(View.GONE);
                        DiseaseChild1Edit.setVisibility(View.VISIBLE);
                        DiseaseChild1Spinner.setVisibility(View.GONE);
                        DiseaseChild2Spinner.setVisibility(View.GONE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="No";
                        strDiseaseAdult2Spinner="No";
                        strDiseaseChild1Spinner="No";
                        strDiseaseChild2Spinner="No";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                        DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                        DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                        DiseaseAdult2Spinner.setVisibility(View.GONE);
                        DiseaseChild1Edit.setVisibility(View.VISIBLE);
                        DiseaseChild1Spinner.setVisibility(View.GONE);
                        DiseaseChild2Spinner.setVisibility(View.GONE);
                        DiseaseChild2Edit.setVisibility(View.VISIBLE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                    } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        Child3LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="No";
                        strDiseaseAdult2Spinner="No";
                        strDiseaseChild1Spinner="No";
                        strDiseaseChild2Spinner="No";
                        strDiseaseChild3Spinner="No";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                        DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                        DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                        DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                        DiseaseAdult2Spinner.setVisibility(View.GONE);
                        DiseaseChild1Edit.setVisibility(View.VISIBLE);
                        DiseaseChild1Spinner.setVisibility(View.GONE);
                        DiseaseChild2Spinner.setVisibility(View.GONE);
                        DiseaseChild2Edit.setVisibility(View.VISIBLE);
                        DiseaseChild3Edit.setVisibility(View.VISIBLE);
                        DiseaseChild3Spinner.setVisibility(View.GONE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                        childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");
                    }
                    else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        Child3LinerDisease.setVisibility(View.VISIBLE);
                        Child4LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="No";
                        strDiseaseAdult2Spinner="No";
                        strDiseaseChild1Spinner="No";
                        strDiseaseChild2Spinner="No";
                        strDiseaseChild3Spinner="No";
                        strDiseaseChild4Spinner="No";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                        DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                        DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                        DiseaseChild4Edit.setText(strDiseaseChild4Spinner);
                        DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                        DiseaseAdult2Spinner.setVisibility(View.GONE);
                        DiseaseChild1Edit.setVisibility(View.VISIBLE);
                        DiseaseChild1Spinner.setVisibility(View.GONE);
                        DiseaseChild2Spinner.setVisibility(View.GONE);
                        DiseaseChild2Edit.setVisibility(View.VISIBLE);
                        DiseaseChild3Edit.setVisibility(View.VISIBLE);
                        DiseaseChild3Spinner.setVisibility(View.GONE);
                        DiseaseChild4Edit.setVisibility(View.VISIBLE);
                        DiseaseChild4Spinner.setVisibility(View.GONE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                        childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");
                        childFourDisease.setText(str_fourNameEdit+" is covered under Disease Management");

                    }
                }
            }
            else{
                if (str_policyType_spinner.equals("Individual")){
                    strAdult1OneDiseaseSpinner="Yes";
                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                    adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                }else {
                    if (str_IndividualTypeEdit.equals("2 Adult")){
                        strAdult1OneDiseaseSpinner="Yes";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                        DiseaseAdult2Edit.setVisibility(View.GONE);
                        DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                    }else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="Yes";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                        DiseaseChild1Edit.setVisibility(View.GONE);
                        DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="Yes";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                        DiseaseChild1Edit.setVisibility(View.GONE);
                        DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Edit.setVisibility(View.GONE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                    }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        Child3LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="Yes";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                        DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                        DiseaseChild1Edit.setVisibility(View.GONE);
                        DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Edit.setVisibility(View.GONE);
                        DiseaseChild3Edit.setVisibility(View.GONE);
                        DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                        childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");
                    } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="Yes";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                        DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                        DiseaseAdult2Edit.setVisibility(View.GONE);
                        DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild1Edit.setVisibility(View.GONE);
                        DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                    }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="Yes";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                        DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                        DiseaseAdult2Edit.setVisibility(View.GONE);
                        DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild1Edit.setVisibility(View.GONE);
                        DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Edit.setVisibility(View.GONE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                    } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        Child3LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="Yes";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                        DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                        DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                        DiseaseAdult2Edit.setVisibility(View.GONE);
                        DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild1Edit.setVisibility(View.GONE);
                        DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Edit.setVisibility(View.GONE);
                        DiseaseChild3Edit.setVisibility(View.GONE);
                        DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                        childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");

                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                        adultTwoDiseaseLiner.setVisibility(View.VISIBLE);
                        Child1LinerDisease.setVisibility(View.VISIBLE);
                        Child2LinerDisease.setVisibility(View.VISIBLE);
                        Child3LinerDisease.setVisibility(View.VISIBLE);
                        Child4LinerDisease.setVisibility(View.VISIBLE);
                        strAdult1OneDiseaseSpinner="Yes";
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                        DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                        DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                        DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                        DiseaseChild4Spinner.setText(strDiseaseChild4Spinner);
                        DiseaseAdult2Edit.setVisibility(View.GONE);
                        DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild1Edit.setVisibility(View.GONE);
                        DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild2Edit.setVisibility(View.GONE);
                        DiseaseChild3Edit.setVisibility(View.GONE);
                        DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                        DiseaseChild4Edit.setVisibility(View.GONE);
                        DiseaseChild4Spinner.setVisibility(View.VISIBLE);
                        adultOneDisease.setText(str_edt_name+" is covered under Disease Management");
                        adultTwoDisease.setText(str_edt_Spouse_name+" is covered under Disease Management");
                        childOneDisease.setText(str_OneEditName+" is covered under Disease Management");
                        childTwoDisease.setText(str_twoChildEditName+" is covered under Disease Management");
                        childThreeDisease.setText(str_thirdNameEdit+" is covered under Disease Management");
                        childFourDisease.setText(str_fourNameEdit+" is covered under Disease Management");

                    }
                }

            }
        }

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Super_Medicle_details.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.super_show_breakup);
                EditText loyaltyDiscount,globalDiscount,DiseaseManagement,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
                Button buttonClose;

                buttonClose = alert_dialog.findViewById(R.id.buttonClose);
                employeeDiscount = alert_dialog.findViewById(R.id.employeeDiscount);
                loyaltyDiscount = alert_dialog.findViewById(R.id.loyaltyDiscount);
                basicPremium = alert_dialog.findViewById(R.id.basicPremium);
                sumInsuredEdit = alert_dialog.findViewById(R.id.sumInsuredEdit);
                deductibleEdit = alert_dialog.findViewById(R.id.deductibleEdit);
                globalDiscount = alert_dialog.findViewById(R.id.globalDiscount);
                DiseaseManagement = alert_dialog.findViewById(R.id.DiseaseManagement);
                gstEdit = alert_dialog.findViewById(R.id.gstEdit);
                totalAmount = alert_dialog.findViewById(R.id.totalAmount);

                basicPremium.setText(NetPremiumValue);
                loyaltyDiscount.setText(str_LoyaltyDiscountEdit);
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
        linerHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select");
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_life_style_spinner=items1.get(options1);
                        life_style_spinner.setText(str_life_style_spinner);
                        if (str_life_style_spinner.equals("Yes")) {
                            final Dialog alert_dialog = new Dialog(Super_Medicle_details.this);
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
                        }
                        else if(str_life_style_spinner.equals("No")) {
                            btn_continue.setVisibility(View.VISIBLE);
                        }else {
                            btn_continue.setVisibility(View.VISIBLE);
                        }
                    }
                });
                singlePicker.show();

            }
        });
        linerEmployeeDiscountEditSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_employeeDiscountEditSpinner=items1.get(options1);
                        employeeDiscountEditSpinner.setText(str_employeeDiscountEditSpinner);
                        if (str_employeeDiscountEditSpinner.equals("Yes")) {
                            employeeCodeLiner.setVisibility(View.VISIBLE);
                            IsEmployee="Y";
                        }
                        else {
                            employeeCodeLiner.setVisibility(View.GONE);
                            IsEmployee="N";
                            SuperHealthCareQuote();
                        }
                    }
                });
                singlePicker.show();

            }
        });
        employeeCodeEdit.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                // TODO Auto-generated method stub
                Is_Valid_refer(employeeCodeEdit); // pass your EditText Obj here.
            }

            public void Is_Valid_refer(EditText edt_refer) {
                if (edt_refer.length()== 6) {
                    str_employeeCodeEdit = edt_refer.getText().toString();
                    SuperHealthCareQuote();
                } else  if (edt_refer.getText().toString().equals("")) {
                    Toast.makeText(Super_Medicle_details.this, "Please Enter 6 Digit Employee Code", Toast.LENGTH_SHORT).show();
                }
            }
        });
        localityDiscountLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_loyalty_spinner=items1.get(options1);
                        loyalty_spinner.setText(str_loyalty_spinner);
                        if (str_loyalty_spinner.equals("Yes")){
                            loyaltyLiner.setVisibility(View.VISIBLE);
                            IsLoyalCustomer="Y";
                        }else{
                            loyaltyLiner.setVisibility(View.GONE);
                            IsLoyalCustomer="N";
                            SuperHealthCareQuote();
                        }
                    }
                });
                singlePicker.show();

            }
        });
        existing_policy_number.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
                // TODO Auto-generated method stub
            }@Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                // TODO Auto-generated method stub
                Is_Valid_refer(existing_policy_number); // pass your EditText Obj here.
            }

            public void Is_Valid_refer(EditText edt_refer) {
                if (edt_refer.length()== 20) {
                    strExisting_policy_number = edt_refer.getText().toString();
                    if (!edt_refer.getText().toString().contains("/")){
                        Toast.makeText(Super_Medicle_details.this, "Please Enter Existing Policy Number", Toast.LENGTH_SHORT).show();
                    }else{
                        SuperHealthCareQuote();
                    }
                } else  if (edt_refer.getText().toString().equals("")) {
                    Toast.makeText(Super_Medicle_details.this, "Please Enter Existing Policy Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        GlobalAdult1Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGlobalAdultSpinner=items1.get(options1);
                        GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                        if (strGlobalAdultSpinner.equals("No")){
                            if (str_policyType_spinner.equals("Individual")){
                                strGlobalAdultSpinner="No";
                                GlobalCoverApplicable1="N";
                                SuperHealthCareQuote();
                                GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                            }
                            else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    GlobalCoverApplicable1="N";
                                    GlobalCoverApplicable2="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="No";
                                    strGlobalAdult2Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                                    GlobalAdult2Spinner.setVisibility(View.GONE);
                                }
                                else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    GlobalCoverApplicable1="N";
                                    GlobalCoverApplicable3="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="No";
                                    strGlobalChild1Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                                    GlobalChild1Spinner.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    GlobalCoverApplicable1="N";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="No";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                                    GlobalChild1Spinner.setVisibility(View.GONE);
                                    GlobalChild2Spinner.setVisibility(View.GONE);
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                                    GlobalChild2Edit.setText(strGlobalChild2Spinner);

                                }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    GlobalCoverApplicable1="N";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    GlobalCoverApplicable5="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="No";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    strGlobalChild3Spinner="No";
                                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                                    GlobalChild3Edit.setVisibility(View.VISIBLE);
                                    GlobalChild1Spinner.setVisibility(View.GONE);
                                    GlobalChild2Spinner.setVisibility(View.GONE);
                                    GlobalChild3Spinner.setVisibility(View.GONE);
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                                    GlobalChild3Edit.setText(strGlobalChild3Spinner);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    GlobalCoverApplicable1="N";
                                    GlobalCoverApplicable2="N";
                                    GlobalCoverApplicable3="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="No";
                                    strGlobalAdult2Spinner="No";
                                    strGlobalChild1Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                                    GlobalAdult2Spinner.setVisibility(View.GONE);
                                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                                    GlobalChild1Spinner.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    GlobalCoverApplicable1="N";
                                    GlobalCoverApplicable2="N";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="No";
                                    strGlobalAdult2Spinner="No";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                                    GlobalAdult2Spinner.setVisibility(View.GONE);
                                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                                    GlobalChild1Spinner.setVisibility(View.GONE);
                                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                                    GlobalChild2Spinner.setVisibility(View.GONE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    GlobalCoverApplicable1="N";
                                    GlobalCoverApplicable2="N";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    GlobalCoverApplicable5="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="No";
                                    strGlobalAdult2Spinner="No";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    strGlobalChild3Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                                    GlobalChild3Edit.setText(strGlobalChild3Spinner);
                                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                                    GlobalAdult2Spinner.setVisibility(View.GONE);
                                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                                    GlobalChild1Spinner.setVisibility(View.GONE);
                                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                                    GlobalChild2Spinner.setVisibility(View.GONE);
                                    GlobalChild3Edit.setVisibility(View.VISIBLE);
                                    GlobalChild3Spinner.setVisibility(View.GONE);

                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    GlobalCoverApplicable1="N";
                                    GlobalCoverApplicable2="N";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    GlobalCoverApplicable5="N";
                                    GlobalCoverApplicable6="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="No";
                                    strGlobalAdult2Spinner="No";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    strGlobalChild3Spinner="No";
                                    strGlobalChild4Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Edit.setText(strGlobalAdult2Spinner);
                                    GlobalChild1Edit.setText(strGlobalChild1Spinner);
                                    GlobalChild2Edit.setText(strGlobalChild2Spinner);
                                    GlobalChild3Edit.setText(strGlobalChild3Spinner);
                                    GlobalChild4Edit.setText(strGlobalChild4Spinner);
                                    GlobalAdult2Edit.setVisibility(View.VISIBLE);
                                    GlobalAdult2Spinner.setVisibility(View.GONE);
                                    GlobalChild1Edit.setVisibility(View.VISIBLE);
                                    GlobalChild1Spinner.setVisibility(View.GONE);
                                    GlobalChild2Edit.setVisibility(View.VISIBLE);
                                    GlobalChild2Spinner.setVisibility(View.GONE);
                                    GlobalChild3Edit.setVisibility(View.VISIBLE);
                                    GlobalChild3Spinner.setVisibility(View.GONE);
                                    GlobalChild4Edit.setVisibility(View.VISIBLE);
                                    GlobalChild4Spinner.setVisibility(View.GONE);
                                }
                            }
                        }
                        else{
                            if (str_policyType_spinner.equals("Individual")){
                                GlobalCoverApplicable1="Y";
                                SuperHealthCareQuote();
                                strGlobalAdultSpinner="Yes";
                                GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                            }else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    GlobalCoverApplicable1="Y";
                                    GlobalCoverApplicable2="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="Yes";
                                    strGlobalAdult2Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                    GlobalAdult2Edit.setVisibility(View.GONE);
                                    GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    GlobalCoverApplicable1="Y";
                                    GlobalCoverApplicable3="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="Yes";
                                    strGlobalChild1Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                    GlobalChild1Edit.setVisibility(View.GONE);
                                    GlobalChild1Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    GlobalCoverApplicable1="Y";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="Yes";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                    GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                                    GlobalChild1Edit.setVisibility(View.GONE);
                                    GlobalChild1Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild2Edit.setVisibility(View.GONE);
                                    GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    GlobalCoverApplicable1="Y";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    GlobalCoverApplicable5="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="Yes";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    strGlobalChild3Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                    GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                                    GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                                    GlobalChild1Edit.setVisibility(View.GONE);
                                    GlobalChild1Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild2Edit.setVisibility(View.GONE);
                                    GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild3Edit.setVisibility(View.GONE);
                                    GlobalChild3Spinner.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    GlobalCoverApplicable1="Y";
                                    GlobalCoverApplicable2="N";
                                    GlobalCoverApplicable3="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="Yes";
                                    strGlobalAdult2Spinner="No";
                                    strGlobalChild1Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                    GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                    GlobalAdult2Edit.setVisibility(View.GONE);
                                    GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild1Edit.setVisibility(View.GONE);
                                    GlobalChild1Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    GlobalCoverApplicable1="Y";
                                    GlobalCoverApplicable2="N";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="Yes";
                                    strGlobalAdult2Spinner="No";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                    GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                    GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                                    GlobalAdult2Edit.setVisibility(View.GONE);
                                    GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild1Edit.setVisibility(View.GONE);
                                    GlobalChild1Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild2Edit.setVisibility(View.GONE);
                                    GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    GlobalCoverApplicable1="Y";
                                    GlobalCoverApplicable2="N";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    GlobalCoverApplicable5="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="Yes";
                                    strGlobalAdult2Spinner="No";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    strGlobalChild3Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                    GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                    GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                                    GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                                    GlobalAdult2Edit.setVisibility(View.GONE);
                                    GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild1Edit.setVisibility(View.GONE);
                                    GlobalChild1Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild2Edit.setVisibility(View.GONE);
                                    GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild3Edit.setVisibility(View.GONE);
                                    GlobalChild3Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    GlobalCoverApplicable1="Y";
                                    GlobalCoverApplicable2="N";
                                    GlobalCoverApplicable3="N";
                                    GlobalCoverApplicable4="N";
                                    GlobalCoverApplicable5="N";
                                    GlobalCoverApplicable6="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdultSpinner="Yes";
                                    strGlobalAdult2Spinner="No";
                                    strGlobalChild1Spinner="No";
                                    strGlobalChild2Spinner="No";
                                    strGlobalChild3Spinner="No";
                                    strGlobalChild4Spinner="No";
                                    GlobalAdultSpinner.setText(strGlobalAdultSpinner);
                                    GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                    GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                    GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                                    GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                                    GlobalChild4Spinner.setText(strGlobalChild4Spinner);
                                    GlobalAdult2Edit.setVisibility(View.GONE);
                                    GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild1Edit.setVisibility(View.GONE);
                                    GlobalChild1Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild2Edit.setVisibility(View.GONE);
                                    GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild3Edit.setVisibility(View.GONE);
                                    GlobalChild3Spinner.setVisibility(View.VISIBLE);
                                    GlobalChild4Edit.setVisibility(View.GONE);
                                    GlobalChild4Spinner.setVisibility(View.VISIBLE);
                                }
                            }

                        }
                    }
                });
                singlePicker.show();
            }
        });
        GlobalAdult2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGlobalAdult2Spinner=items1.get(options1);
                        GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                        if (strGlobalAdult2Spinner.equals("No")){
                            if (str_IndividualTypeEdit.equals("2 Adult")){
                                    GlobalCoverApplicable2="N";
                                    SuperHealthCareQuote();
                                    strGlobalAdult2Spinner="No";
                                   GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                    GlobalAdult2Edit.setVisibility(View.GONE);
                                    GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                     GlobalCoverApplicable2="N";
                                     SuperHealthCareQuote();
                                     strGlobalAdult2Spinner="No";
                                GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                GlobalAdult2Edit.setVisibility(View.GONE);
                                GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                   GlobalCoverApplicable2="N";
                                   SuperHealthCareQuote();
                                   strGlobalAdult2Spinner="No";
                                GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                GlobalAdult2Edit.setVisibility(View.GONE);
                                GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                     GlobalCoverApplicable2="N";
                                     SuperHealthCareQuote();
                                     strGlobalAdult2Spinner="No";
                                GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                GlobalAdult2Edit.setVisibility(View.GONE);
                                GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    GlobalCoverApplicable2="N";
                                    SuperHealthCareQuote();
                                   strGlobalAdult2Spinner="No";
                                GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                GlobalAdult2Edit.setVisibility(View.GONE);
                                GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                }
                            }
                        else{
                            if (str_IndividualTypeEdit.equals("2 Adult")){
                                   GlobalCoverApplicable2="Y";
                                    SuperHealthCareQuote();
                                    strGlobalAdult2Spinner="Yes";
                                    GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                    GlobalAdult2Edit.setVisibility(View.GONE);
                                    GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                  GlobalCoverApplicable2="Y";
                                  SuperHealthCareQuote();
                                  strGlobalAdult2Spinner="Yes";
                                  GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                  GlobalAdult2Edit.setVisibility(View.GONE);
                                  GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                  GlobalCoverApplicable2="Y";
                                  SuperHealthCareQuote();
                                  strGlobalAdult2Spinner="Yes";
                                  GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                  GlobalAdult2Edit.setVisibility(View.GONE);
                                  GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                  GlobalCoverApplicable2="Y";
                                  SuperHealthCareQuote();
                                  strGlobalAdult2Spinner="Yes";
                                  GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                  GlobalAdult2Edit.setVisibility(View.GONE);
                                  GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                  GlobalCoverApplicable2="Y";
                                  SuperHealthCareQuote();
                                 strGlobalAdult2Spinner="Yes";
                                 GlobalAdult2Spinner.setText(strGlobalAdult2Spinner);
                                 GlobalAdult2Edit.setVisibility(View.GONE);
                                 GlobalAdult2Spinner.setVisibility(View.VISIBLE);
                                }
                            }
                        }
                });
                singlePicker.show();
            }
        });
        GlobalChild1Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGlobalChild1Spinner=items1.get(options1);
                        GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                        if (strGlobalChild1Spinner.equals("No")){
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                GlobalCoverApplicable3="N";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="No";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                GlobalCoverApplicable3="N";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="No";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                GlobalCoverApplicable3="N";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="No";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                GlobalCoverApplicable3="N";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="No";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                GlobalCoverApplicable3="N";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="No";
                                GlobalChild1Edit.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.VISIBLE);
                                GlobalChild1Spinner.setVisibility(View.GONE);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                GlobalCoverApplicable3="N";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="No";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                GlobalCoverApplicable3="N";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="No";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }
                        }
                        else{
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                GlobalCoverApplicable3="Y";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="Yes";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                GlobalCoverApplicable3="Y";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="Yes";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                GlobalCoverApplicable3="Y";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="Yes";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                GlobalCoverApplicable3="Y";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="Yes";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                GlobalCoverApplicable3="Y";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="Yes";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                GlobalCoverApplicable3="Y";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="Yes";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                GlobalCoverApplicable3="Y";
                                SuperHealthCareQuote();
                                strGlobalChild1Spinner="Yes";
                                GlobalChild1Spinner.setText(strGlobalChild1Spinner);
                                GlobalChild1Edit.setVisibility(View.GONE);
                                GlobalChild1Spinner.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        GlobalChild2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGlobalChild2Spinner=items1.get(options1);
                        GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                        if (strGlobalChild2Spinner.equals("No")){
                             if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                 GlobalCoverApplicable4="N";
                                 SuperHealthCareQuote();
                                    strGlobalChild2Spinner="No";
                                    GlobalChild2Edit.setVisibility(View.GONE);
                                    GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                 GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                             }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                 GlobalCoverApplicable4="N";
                                 SuperHealthCareQuote();
                                 strGlobalChild2Spinner="No";
                                 GlobalChild2Edit.setVisibility(View.GONE);
                                 GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                 GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                           }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                 GlobalCoverApplicable4="N";
                                 SuperHealthCareQuote();
                                 strGlobalChild2Spinner="No";
                                 GlobalChild2Edit.setVisibility(View.GONE);
                                 GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                 GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                           } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                 GlobalCoverApplicable4="N";
                                 SuperHealthCareQuote();
                                 strGlobalChild2Spinner="No";
                                 GlobalChild2Edit.setVisibility(View.GONE);
                                 GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                 GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                          }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                 GlobalCoverApplicable4="N";
                                 SuperHealthCareQuote();
                                 strGlobalChild2Spinner="No";
                                 GlobalChild2Edit.setVisibility(View.GONE);
                                 GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                 GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                                }
                            }
                        else{
                            if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                GlobalCoverApplicable4="Y";
                                SuperHealthCareQuote();
                                strGlobalChild2Spinner="Yes";
                                GlobalChild2Edit.setVisibility(View.GONE);
                                GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                           }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                GlobalCoverApplicable4="Y";
                                SuperHealthCareQuote();
                                strGlobalChild2Spinner="Yes";
                                GlobalChild2Edit.setVisibility(View.GONE);
                                GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                          }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                GlobalCoverApplicable4="Y";
                                SuperHealthCareQuote();
                                strGlobalChild2Spinner="Yes";
                                GlobalChild2Edit.setVisibility(View.GONE);
                                GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                          } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                GlobalCoverApplicable4="Y";
                                SuperHealthCareQuote();
                                strGlobalChild2Spinner="Yes";
                                GlobalChild2Edit.setVisibility(View.GONE);
                                GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                         }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                GlobalCoverApplicable4="Y";
                                SuperHealthCareQuote();
                                strGlobalChild2Spinner="Yes";
                                GlobalChild2Edit.setVisibility(View.GONE);
                                GlobalChild2Spinner.setVisibility(View.VISIBLE);
                                GlobalChild2Spinner.setText(strGlobalChild2Spinner);
                                }
                            } }
                });
                singlePicker.show();
            }
        });
        GlobalChild3Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGlobalChild3Spinner=items1.get(options1);
                        GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                        if (strGlobalChild3Spinner.equals("No")){
                           if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                               GlobalCoverApplicable5="N";
                               SuperHealthCareQuote();
                               strGlobalChild3Spinner="No";
                               GlobalChild3Edit.setVisibility(View.GONE);
                               GlobalChild3Spinner.setVisibility(View.VISIBLE);
                               GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                               GlobalCoverApplicable5="N";
                               SuperHealthCareQuote();
                               strGlobalChild3Spinner="No";
                               GlobalChild3Edit.setVisibility(View.GONE);
                               GlobalChild3Spinner.setVisibility(View.VISIBLE);
                               GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                               GlobalCoverApplicable5="N";
                               SuperHealthCareQuote();
                               strGlobalChild3Spinner="No";
                               GlobalChild3Edit.setVisibility(View.GONE);
                               GlobalChild3Spinner.setVisibility(View.VISIBLE);
                               GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                            }
                        }
                        else{
                            if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                GlobalCoverApplicable5="Y";
                                SuperHealthCareQuote();
                                strGlobalChild3Spinner="Yes";
                                GlobalChild3Edit.setVisibility(View.GONE);
                                GlobalChild3Spinner.setVisibility(View.VISIBLE);
                                GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                GlobalCoverApplicable5="Y";
                                SuperHealthCareQuote();
                                strGlobalChild3Spinner="Yes";
                                GlobalChild3Edit.setVisibility(View.GONE);
                                GlobalChild3Spinner.setVisibility(View.VISIBLE);
                                GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                GlobalCoverApplicable5="Y";
                                SuperHealthCareQuote();
                                strGlobalChild3Spinner="Yes";
                                GlobalChild3Edit.setVisibility(View.GONE);
                                GlobalChild3Spinner.setVisibility(View.VISIBLE);
                                GlobalChild3Spinner.setText(strGlobalChild3Spinner);
                            }
                        } }
                });
                singlePicker.show();
            }
        });
        GlobalChild4Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGlobalChild4Spinner=items1.get(options1);
                        GlobalChild4Spinner.setText(strGlobalChild4Spinner);
                        if (strGlobalChild4Spinner.equals("No")){
                           if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                               GlobalCoverApplicable6="N";
                               SuperHealthCareQuote();
                               strGlobalChild4Spinner="No";
                               GlobalChild4Spinner.setText(strGlobalChild4Spinner);
                               GlobalChild4Edit.setVisibility(View.GONE);
                               GlobalChild4Spinner.setVisibility(View.VISIBLE);
                            }
                        }
                        else{
                           if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                               GlobalCoverApplicable6="Y";
                               SuperHealthCareQuote();
                               strGlobalChild4Spinner="Yes";
                               GlobalChild4Spinner.setText(strGlobalChild4Spinner);
                               GlobalChild4Edit.setVisibility(View.GONE);
                               GlobalChild4Spinner.setVisibility(View.VISIBLE);
                            }
                        } }
                });
                singlePicker.show();
            }
        });


        adult1OneDiseaseLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strAdult1OneDiseaseSpinner=items1.get(options1);
                        adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                        if (strAdult1OneDiseaseSpinner.equals("No")){
                            if (str_policyType_spinner.equals("Individual")){
                                IsWellnessProgram1="N";
                                SuperHealthCareQuote();
                                strAdult1OneDiseaseSpinner="No";
                                adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                            }
                            else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    IsWellnessProgram1="N";
                                    IsWellnessProgram2="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="No";
                                    strDiseaseAdult2Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                                    DiseaseAdult2Spinner.setVisibility(View.GONE);
                                }
                                else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    IsWellnessProgram1="N";
                                    IsWellnessProgram3="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="No";
                                    strDiseaseChild1Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild1Spinner.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    IsWellnessProgram1="N";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="No";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild1Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    IsWellnessProgram1="N";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    IsWellnessProgram5="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="No";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    strDiseaseChild3Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                                    DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild1Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild3Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild3Spinner.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    IsWellnessProgram1="N";
                                    IsWellnessProgram2="N";
                                    IsWellnessProgram3="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="No";
                                    strDiseaseAdult2Spinner="No";
                                    strDiseaseChild1Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                                    DiseaseAdult2Spinner.setVisibility(View.GONE);
                                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild1Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Spinner.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    IsWellnessProgram1="N";
                                    IsWellnessProgram2="N";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="No";
                                    strDiseaseAdult2Spinner="No";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                                    DiseaseAdult2Spinner.setVisibility(View.GONE);
                                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild1Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    IsWellnessProgram1="N";
                                    IsWellnessProgram2="N";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    IsWellnessProgram5="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="No";
                                    strDiseaseAdult2Spinner="No";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    strDiseaseChild3Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                                    DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                                    DiseaseAdult2Spinner.setVisibility(View.GONE);
                                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild1Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild3Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild3Spinner.setVisibility(View.GONE);

                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    IsWellnessProgram1="N";
                                    IsWellnessProgram2="N";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    IsWellnessProgram5="N";
                                    IsWellnessProgram6="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="No";
                                    strDiseaseAdult2Spinner="No";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    strDiseaseChild3Spinner="No";
                                    strDiseaseChild4Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Edit.setText(strDiseaseAdult2Spinner);
                                    DiseaseChild1Edit.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Edit.setText(strDiseaseChild2Spinner);
                                    DiseaseChild3Edit.setText(strDiseaseChild3Spinner);
                                    DiseaseChild4Edit.setText(strDiseaseChild4Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.VISIBLE);
                                    DiseaseAdult2Spinner.setVisibility(View.GONE);
                                    DiseaseChild1Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild1Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Spinner.setVisibility(View.GONE);
                                    DiseaseChild2Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild3Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild3Spinner.setVisibility(View.GONE);
                                    DiseaseChild4Edit.setVisibility(View.VISIBLE);
                                    DiseaseChild4Spinner.setVisibility(View.GONE);
                                }
                            }
                        }
                        else{
                            if (str_policyType_spinner.equals("Individual")){
                                IsWellnessProgram1="Y";
                                SuperHealthCareQuote();
                                strAdult1OneDiseaseSpinner="Yes";
                                adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                            }else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    IsWellnessProgram1="Y";
                                    IsWellnessProgram2="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="Yes";
                                    strDiseaseAdult2Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    IsWellnessProgram1="Y";
                                    IsWellnessProgram3="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="Yes";
                                    strDiseaseChild1Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                    DiseaseChild1Edit.setVisibility(View.GONE);
                                    DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    IsWellnessProgram1="Y";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="Yes";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                    DiseaseChild1Edit.setVisibility(View.GONE);
                                    DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Edit.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    IsWellnessProgram1="Y";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    IsWellnessProgram5="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="Yes";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    strDiseaseChild3Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                    DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                                    DiseaseChild1Edit.setVisibility(View.GONE);
                                    DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Edit.setVisibility(View.GONE);
                                    DiseaseChild3Edit.setVisibility(View.GONE);
                                    DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    IsWellnessProgram1="Y";
                                    IsWellnessProgram2="N";
                                    IsWellnessProgram3="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="Yes";
                                    strDiseaseAdult2Spinner="No";
                                    strDiseaseChild1Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild1Edit.setVisibility(View.GONE);
                                    DiseaseChild1Spinner.setVisibility(View.VISIBLE);

                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    IsWellnessProgram1="Y";
                                    IsWellnessProgram2="N";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="Yes";
                                    strDiseaseAdult2Spinner="No";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild1Edit.setVisibility(View.GONE);
                                    DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Edit.setVisibility(View.GONE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    IsWellnessProgram1="Y";
                                    IsWellnessProgram2="N";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    IsWellnessProgram5="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="Yes";
                                    strDiseaseAdult2Spinner="No";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    strDiseaseChild3Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                    DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild1Edit.setVisibility(View.GONE);
                                    DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Edit.setVisibility(View.GONE);
                                    DiseaseChild3Edit.setVisibility(View.GONE);
                                    DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    IsWellnessProgram1="Y";
                                    IsWellnessProgram2="N";
                                    IsWellnessProgram3="N";
                                    IsWellnessProgram4="N";
                                    IsWellnessProgram5="N";
                                    IsWellnessProgram6="N";
                                    SuperHealthCareQuote();
                                    strAdult1OneDiseaseSpinner="Yes";
                                    strDiseaseAdult2Spinner="No";
                                    strDiseaseChild1Spinner="No";
                                    strDiseaseChild2Spinner="No";
                                    strDiseaseChild3Spinner="No";
                                    strDiseaseChild4Spinner="No";
                                    adult1OneDiseaseSpinner.setText(strAdult1OneDiseaseSpinner);
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                    DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                    DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                                    DiseaseChild4Spinner.setText(strDiseaseChild4Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild1Edit.setVisibility(View.GONE);
                                    DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild2Edit.setVisibility(View.GONE);
                                    DiseaseChild3Edit.setVisibility(View.GONE);
                                    DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                                    DiseaseChild4Edit.setVisibility(View.GONE);
                                    DiseaseChild4Spinner.setVisibility(View.VISIBLE);
                                }
                            }

                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerAdultTwoDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDiseaseAdult2Spinner=items1.get(options1);
                        DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                        if (strDiseaseAdult2Spinner.equals("No")){
                            if (str_IndividualTypeEdit.equals("2 Adult")){
                                  IsWellnessProgram2="N";
                                  SuperHealthCareQuote();
                                    strDiseaseAdult2Spinner="No";
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                  IsWellnessProgram2="N";
                                  SuperHealthCareQuote();
                                   strDiseaseAdult2Spinner="No";
                                   DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                   DiseaseAdult2Edit.setVisibility(View.GONE);
                                   DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                             }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                IsWellnessProgram2="N";
                                SuperHealthCareQuote();
                                strDiseaseAdult2Spinner="No";
                                DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                DiseaseAdult2Edit.setVisibility(View.GONE);
                                DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                IsWellnessProgram2="N";
                                SuperHealthCareQuote();
                                strDiseaseAdult2Spinner="No";
                                DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                DiseaseAdult2Edit.setVisibility(View.GONE);
                                DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                           }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                IsWellnessProgram2="N";
                                SuperHealthCareQuote();
                                strDiseaseAdult2Spinner="No";
                                DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                DiseaseAdult2Edit.setVisibility(View.GONE);
                                DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                            }
                        }else{
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    IsWellnessProgram2="Y";
                                    SuperHealthCareQuote();
                                    strDiseaseAdult2Spinner="Yes";
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    IsWellnessProgram2="Y";
                                    SuperHealthCareQuote();
                                    strDiseaseAdult2Spinner="Yes";
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    IsWellnessProgram2="Y";
                                    SuperHealthCareQuote();
                                    strDiseaseAdult2Spinner="Yes";
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    IsWellnessProgram2="Y";
                                    SuperHealthCareQuote();
                                    strDiseaseAdult2Spinner="Yes";
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    IsWellnessProgram2="Y";
                                    SuperHealthCareQuote();
                                    strDiseaseAdult2Spinner="Yes";
                                    DiseaseAdult2Spinner.setText(strDiseaseAdult2Spinner);
                                    DiseaseAdult2Edit.setVisibility(View.GONE);
                                    DiseaseAdult2Spinner.setVisibility(View.VISIBLE);
                                }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        DiseaseChild1Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDiseaseChild1Spinner=items1.get(options1);
                        DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                        if (strDiseaseChild1Spinner.equals("No")){
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                IsWellnessProgram3="N";
                                SuperHealthCareQuote();
                                    strDiseaseChild1Spinner="No";
                                    DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                    DiseaseChild1Edit.setVisibility(View.GONE);
                                    DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                IsWellnessProgram3="N";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="No";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                           }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                IsWellnessProgram3="N";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="No";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                           }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                IsWellnessProgram3="N";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="No";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                           }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                IsWellnessProgram3="N";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="No";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                           } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                IsWellnessProgram3="N";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="No";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                IsWellnessProgram3="N";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="No";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                                }
                            }
                        else{
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                IsWellnessProgram3="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="Yes";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                IsWellnessProgram3="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="Yes";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                IsWellnessProgram3="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="Yes";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                             } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                IsWellnessProgram3="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="Yes";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                IsWellnessProgram3="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="Yes";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                IsWellnessProgram3="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="Yes";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                           }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                IsWellnessProgram3="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild1Spinner="Yes";
                                DiseaseChild1Spinner.setText(strDiseaseChild1Spinner);
                                DiseaseChild1Edit.setVisibility(View.GONE);
                                DiseaseChild1Spinner.setVisibility(View.VISIBLE);
                                }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        DiseaseChild2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDiseaseChild2Spinner=items1.get(options1);
                        DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                        if (strDiseaseChild2Spinner.equals("No")){
                             if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                 IsWellnessProgram4="N";
                                 SuperHealthCareQuote();
                                strDiseaseChild2Spinner="No";
                                DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                DiseaseChild2Edit.setVisibility(View.GONE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                 IsWellnessProgram4="N";
                                 SuperHealthCareQuote();
                                 strDiseaseChild2Spinner = "No";
                                 DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                 DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                 DiseaseChild2Edit.setVisibility(View.GONE);
                             }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                 IsWellnessProgram4="N";
                                 SuperHealthCareQuote();
                                 strDiseaseChild2Spinner="No";
                                 DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                 DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                 DiseaseChild2Edit.setVisibility(View.GONE);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                 IsWellnessProgram4="N";
                                 SuperHealthCareQuote();
                                 strDiseaseChild2Spinner="No";
                                 DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                 DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                 DiseaseChild2Edit.setVisibility(View.GONE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                 IsWellnessProgram4="N";
                                 SuperHealthCareQuote();
                                 strDiseaseChild2Spinner="No";
                                 DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                                 DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                                 DiseaseChild2Edit.setVisibility(View.GONE);
                            }
                        }
                        else{
                           if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                               IsWellnessProgram4="Y";
                               SuperHealthCareQuote();
                               strDiseaseChild2Spinner="Yes";
                               DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                               DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                               DiseaseChild2Edit.setVisibility(View.GONE);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                               IsWellnessProgram4="Y";
                               SuperHealthCareQuote();
                               strDiseaseChild2Spinner="Yes";
                               DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                               DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                               DiseaseChild2Edit.setVisibility(View.GONE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                               IsWellnessProgram4="Y";
                               SuperHealthCareQuote();
                               strDiseaseChild2Spinner="Yes";
                               DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                               DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                               DiseaseChild2Edit.setVisibility(View.GONE);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                               IsWellnessProgram4="Y";
                               SuperHealthCareQuote();
                               strDiseaseChild2Spinner="Yes";
                               DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                               DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                               DiseaseChild2Edit.setVisibility(View.GONE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                               IsWellnessProgram4="Y";
                               SuperHealthCareQuote();
                               strDiseaseChild2Spinner="Yes";
                               DiseaseChild2Spinner.setText(strDiseaseChild2Spinner);
                               DiseaseChild2Spinner.setVisibility(View.VISIBLE);
                               DiseaseChild2Edit.setVisibility(View.GONE);
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        DiseaseChild3Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDiseaseChild3Spinner=items1.get(options1);
                        DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                        if (strDiseaseChild3Spinner.equals("No")){
                          if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                              IsWellnessProgram5="N";
                              SuperHealthCareQuote();
                              strDiseaseChild3Spinner="No";
                              DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                              DiseaseChild3Edit.setVisibility(View.GONE);
                              DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                              IsWellnessProgram5="N";
                              SuperHealthCareQuote();
                              strDiseaseChild3Spinner="No";
                              DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                              DiseaseChild3Edit.setVisibility(View.GONE);
                              DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                              IsWellnessProgram5="N";
                              SuperHealthCareQuote();
                              strDiseaseChild3Spinner="No";
                              DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                              DiseaseChild3Edit.setVisibility(View.GONE);
                              DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                            }
                        }
                        else{
                            if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                IsWellnessProgram5="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild3Spinner="Yes";
                                DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                                DiseaseChild3Edit.setVisibility(View.GONE);
                                DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                IsWellnessProgram5="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild3Spinner="Yes";
                                DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                                DiseaseChild3Edit.setVisibility(View.GONE);
                                DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                IsWellnessProgram5="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild3Spinner="Yes";
                                DiseaseChild3Spinner.setText(strDiseaseChild3Spinner);
                                DiseaseChild3Edit.setVisibility(View.GONE);
                                DiseaseChild3Spinner.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });
        DiseaseChild4Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Super_Medicle_details.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strDiseaseChild4Spinner=items1.get(options1);
                        DiseaseChild4Spinner.setText(strDiseaseChild4Spinner);
                        if (strDiseaseChild4Spinner.equals("No")){
                            if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                IsWellnessProgram6="N";
                                SuperHealthCareQuote();
                                strDiseaseChild4Spinner="No";
                                DiseaseChild4Spinner.setText(strDiseaseChild4Spinner);
                                DiseaseChild4Edit.setVisibility(View.GONE);
                                DiseaseChild4Spinner.setVisibility(View.VISIBLE);
                            }
                        }
                        else{
                            if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                IsWellnessProgram6="Y";
                                SuperHealthCareQuote();
                                strDiseaseChild4Spinner="Yes";
                                DiseaseChild4Spinner.setText(strDiseaseChild4Spinner);
                                DiseaseChild4Edit.setVisibility(View.GONE);
                                DiseaseChild4Spinner.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });


        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_life_style_spinner.equals("Select")){
                    Toast.makeText(Super_Medicle_details.this, "Please select Medical Condition & adverse Lifestyle habits ", Toast.LENGTH_SHORT).show();
                }else if (str_life_style_spinner.equals("Yes")){
                    Toast.makeText(Super_Medicle_details.this, "We cannot proceed application as you are going through Medical Condition & adverse Lifestyle habits ", Toast.LENGTH_SHORT).show();
                }else
                {
                    Intent intent=new Intent(Super_Medicle_details.this, SuperAddressDetails.class);
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
                    intent.putExtra("str_edit_dob3String",str_edit_dob3String);
                    intent.putExtra("str_weight_edit",str_weight_edit);
                    intent.putExtra("str_edt_Spouse_name",str_edt_Spouse_name);
                    intent.putExtra("str_spouse_edit_dob_dob",str_spouse_edit_dob_dob);
                    intent.putExtra("str_spouse_gender",str_spouse_gender);
                    intent.putExtra("str_spouse_occupation_spinner",str_spouse_occupation_spinner);
                    intent.putExtra("str_spouse_ft_spinner",str_spouse_ft_spinner);
                    intent.putExtra("str_spouse_inches_spinner",str_spouse_inches_spinner);
                    intent.putExtra("str_spouse_weight_edit",str_spouse_weight_edit);
                    intent.putExtra("strAnyDisease",strAnyDisease);
                    intent.putExtra("strPriceTotal",strPriceTotal);
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
                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                    intent.putExtra("str_SumInsured",str_SumInsured);
                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                    intent.putExtra("str_OneEditName",str_OneEditName);
                    intent.putExtra("str_twoChildEditName",str_twoChildEditName);
                    intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
                    intent.putExtra("str_fourNameEdit",str_fourNameEdit);
                    intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                    intent.putExtra("strFirstTString",strFirstTString);
                    intent.putExtra("TotalValue",TotalValue);
                    intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                    intent.putExtra("PosPolicyNo",PosPolicyNo);
                    intent.putExtra("str_amountPersonalSumInsured",str_amountPersonalSumInsured);
                    intent.putExtra("strhospitalEdit",strhospitalEdit);
                    intent.putExtra("strcriticalEdit",strcriticalEdit);
                    intent.putExtra("strSubLimitAmount",strSubLimitAmount);
                    intent.putExtra("strDiscount",strDiscount);
                    intent.putExtra("GST",GST);
                    intent.putExtra("NetPremiumValue",NetPremiumValue);
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
                    intent.putExtra("nextYear",nextYear);
                    intent.putExtra("tomorrowDate",tomorrowDate);
                    intent.putExtra("PD_Status",PD_Status);
                    intent.putExtra("ESaleDiscount",ESaleDiscount);
                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                    intent.putExtra("strSubLimitAmount",strSubLimitAmount);
                    intent.putExtra("LifeStyleDiscountStr",LifeStyleDiscountStr);
                    intent.putExtra("LongTermDiscount",LongTermDiscount);
                    intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
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
                    intent.putExtra("BI_Status",BI_Status);
                    intent.putExtra("BI_Status1",BI_Status1);
                    intent.putExtra("BI_Status2",BI_Status2);
                    intent.putExtra("BI_Status3",BI_Status3);
                    intent.putExtra("BI_Status4",BI_Status4);
                    intent.putExtra("BI_Status5",BI_Status5);
                    intent.putExtra("Sub_Type",Sub_Type);
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
                    intent.putExtra("for","0");
                    startActivity(intent);
                    finish();
//                    SuperHealthCareQuote();
                }
            }
        });
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
            QuotationDtls.put("IsLoyalCustomer",IsLoyalCustomer);
            QuotationDtls.put("IsEmployee",IsEmployee);
            QuotationDtls.put("EmployeeCode",str_employeeCodeEdit);
            QuotationDtls.put("ExistingHealthPolicyNo",strExisting_policy_number);
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
                obj.put("IsWellnessProgram",IsWellnessProgram1);
                obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
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
                    obj.put("IsWellnessProgram",IsWellnessProgram1);
                    obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_Spouse_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram",IsWellnessProgram2);
                    objAdult2.put("GlobalCoverApplicable",GlobalCoverApplicable2);
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
                    obj.put("IsWellnessProgram",IsWellnessProgram1);
                    obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
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
                    objChild1.put("IsWellnessProgram",IsWellnessProgram3);
                    objChild1.put("GlobalCoverApplicable",GlobalCoverApplicable3);
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
                    obj.put("IsWellnessProgram",IsWellnessProgram1);
                    obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
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
                    objChild1.put("IsWellnessProgram",IsWellnessProgram3);
                    objChild1.put("GlobalCoverApplicable",GlobalCoverApplicable3);
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
                    objChild2.put("IsWellnessProgram",IsWellnessProgram4);
                    objChild2.put("GlobalCoverApplicable",GlobalCoverApplicable4);
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
                    obj.put("IsWellnessProgram",IsWellnessProgram1);
                    obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
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
                    objChild1.put("IsWellnessProgram",IsWellnessProgram3);
                    objChild1.put("GlobalCoverApplicable",GlobalCoverApplicable3);
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
                    objChild2.put("IsWellnessProgram",IsWellnessProgram4);
                    objChild2.put("GlobalCoverApplicable",GlobalCoverApplicable4);
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
                    objChild3.put("IsWellnessProgram",IsWellnessProgram5);
                    objChild3.put("GlobalCoverApplicable",GlobalCoverApplicable5);
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
                    obj.put("IsWellnessProgram",IsWellnessProgram1);
                    obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_Spouse_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram",IsWellnessProgram2);
                    objAdult2.put("GlobalCoverApplicable",GlobalCoverApplicable2);
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
                    objChild1.put("IsWellnessProgram",IsWellnessProgram3);
                    objChild1.put("GlobalCoverApplicable",GlobalCoverApplicable3);
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
                    obj.put("IsWellnessProgram",IsWellnessProgram1);
                    obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_Spouse_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram",IsWellnessProgram2);
                    objAdult2.put("GlobalCoverApplicable",GlobalCoverApplicable2);
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
                    objChild1.put("IsWellnessProgram",IsWellnessProgram3);
                    objChild1.put("GlobalCoverApplicable",GlobalCoverApplicable3);
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
                    objChild2.put("IsWellnessProgram",IsWellnessProgram4);
                    objChild2.put("GlobalCoverApplicable",GlobalCoverApplicable4);
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
                    obj.put("IsWellnessProgram",IsWellnessProgram1);
                    obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_Spouse_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram",IsWellnessProgram2);
                    objAdult2.put("GlobalCoverApplicable",GlobalCoverApplicable2);
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
                    objChild1.put("IsWellnessProgram",IsWellnessProgram3);
                    objChild1.put("GlobalCoverApplicable",GlobalCoverApplicable3);
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
                    objChild2.put("IsWellnessProgram",IsWellnessProgram4);
                    objChild2.put("GlobalCoverApplicable",GlobalCoverApplicable4);
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
                    objChild3.put("IsWellnessProgram",IsWellnessProgram5);
                    objChild3.put("GlobalCoverApplicable",GlobalCoverApplicable5);
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
                    obj.put("IsWellnessProgram",IsWellnessProgram1);
                    obj.put("GlobalCoverApplicable",GlobalCoverApplicable1);
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_Spouse_name);
                    objAdult2.put("DateOfBirth",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram",IsWellnessProgram2);
                    objAdult2.put("GlobalCoverApplicable",GlobalCoverApplicable2);
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
                    objChild1.put("IsWellnessProgram",IsWellnessProgram3);
                    objChild1.put("GlobalCoverApplicable",GlobalCoverApplicable3);
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
                    objChild2.put("IsWellnessProgram",IsWellnessProgram4);
                    objChild2.put("GlobalCoverApplicable",GlobalCoverApplicable4);
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
                    objChild3.put("IsWellnessProgram",IsWellnessProgram5);
                    objChild3.put("GlobalCoverApplicable",GlobalCoverApplicable5);
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
                    objChild4.put("IsWellnessProgram",IsWellnessProgram6);
                    objChild4.put("GlobalCoverApplicable",GlobalCoverApplicable6);
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(Super_Medicle_details.this, object, UrlHealthConstants.SuperHealthCareQuote_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("True")) {
                    if (Tag == RequestHealthConstants.SUPER_HEALTH_QUOTATION) {
                        try {
                           if (object.optString("Status").equals("True")){
                               JSONObject jsonObject  = object.getJSONObject("usgiSuperHealthCare");
                               str_employeeCodeDiscountValue = jsonObject.optString("EmployeeDiscount");
                              String new_employeeCodeDiscountValue = jsonObject.optString("EmployeeDiscount");
                               String new_LoyaltyDiscountEdit = jsonObject.optString("LoyaltyDiscount");
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
                               double newLoyaltyDiscountEdit1= Double.parseDouble(new_LoyaltyDiscountEdit);
                               double newemployeeCodeDiscountValue1= Double.parseDouble(new_employeeCodeDiscountValue);
                               double newTotalValue1= Double.parseDouble(newTotalValue);
                               double newGST1=Double.parseDouble(newGST);
                               str_LoyaltyDiscountEdit=String.format("%.2f", newLoyaltyDiscountEdit1);
                               str_employeeCodeDiscountValue=String.format("%.2f", newemployeeCodeDiscountValue1);
                               GST=String.format("%.2f", newGST1);
                               TotalValue=String.format("%.2f", newTotalValue1);
                               totalPremiumAmount.setText(TotalValue);
                               employeeCodeDiscountValue.setText(str_employeeCodeDiscountValue);
                               LoyaltyDiscountEdit.setText(str_LoyaltyDiscountEdit);

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
        Intent intent=new Intent(Super_Medicle_details.this, Super_Member_Self.class);
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
        intent.putExtra("strGlobalAdultSpinner",strGlobalAdultSpinner);
        intent.putExtra("strAdult1OneDiseaseSpinner",strAdult1OneDiseaseSpinner);
        startActivity(intent);
        finish();

    }
    }
