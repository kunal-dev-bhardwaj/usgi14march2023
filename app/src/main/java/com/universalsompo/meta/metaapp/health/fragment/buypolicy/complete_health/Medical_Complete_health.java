package com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health;

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
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.CriticalIllnessCalculation;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.AllIndividualCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.AllIndividualHospitalCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.ChildCriticalCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.ChildHospitalCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.CriticalIllnessCalculation.ChildCriticalIllnessCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.CriticalIllnessCalculation.CriticalIllnessCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.IndividualHealth.IndividualHealthCalculate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Medical_Complete_health extends AppCompatActivity {
    Spinner spinner_habitual,self_diabetes_spinner,self_hypertension_spinner,self_cholesterol_spinner,Spouse_diabetes_spinner,Spouse_hypertension_spinner,Spouse_cholesterol_spinner,self_habitual,spouse_habitual,Critical_under_spinner,Critical_illness_spinner,PersonalAccidentSpinner ;
    String BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,str_edit_dob3StringSpouse,new_str_age,strTwoChildCriticalIllnessTxt,strtwoChildTxt,strOneChildCriticalIllnessTxtthird,str_amountPersonalSumInsuredThird,strThirdChildTxt,strFourChildCriticalIllnessTxt,strFourChildTxt,amountPersonalSumInsuredFour,str_amountPersonalSumInsuredTwo,str_amountPersonalSumInsuredChild1,strcriticalEditAdult,strcriticalEditAdult1,str_amountPersonalSumInsuredAdult,str_amountPersonalSumInsuredAdult1,strhospitalEditAdult,strhospitalEditAdult1,strSumInsuredTpeEDit,PA_Status,CI_Status,DHC_Status,Esale_Status,Life_Status,Sub_Status,Sub_Type,Tiered_Status,PA_Status1,CI_Status1,DHC_Status1,PA_Status2,CI_Status2,DHC_Status2,PA_Status3,CI_Status3,DHC_Status3,PA_Status4,CI_Status4,DHC_Status4,PA_Status5,CI_Status5,DHC_Status5,tomorrowDate,nextYear,ESaleDiscount,LongTermDiscount,PD_Status,LifeStyleDiscountStr,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,strPriceTotal,strNominee_dob,str_edit_dob3String,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strsecondAdultCritical_under_spinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2,strfourChildPersonal_under_spinner2;
    LinearLayout LinerSpinner_more,sub_limit_spinnerLiner,treatment_spinnerLiner,self_spouse_liner,habitual_liner,criticalLiner,criticalSpinnerLiner,addDiscountBtn,subtractDiscountBtn,subLimitLiner,yesMedicalConditionLiner,personalAccidentLiner,secondAdultCriticalSpinnerLiner,secondAdultCritical_under_spinner2Liner,LinerOneChildCritical_under_spinner2,twoChildCritical_under_spinner2Liner,thirdChildCritical_under_spinner2Liner,fourChildCritical_under_spinner2Liner,personalUnder_spinnerLiner,personal_under_spinner2EditLiner,oneChildPersonal_under_spinner2Liner,twoChildPersonal_under_spinner2Liner,thirdChildPersonal_under_spinner2Liner,fourChildPersonal_under_spinner2Liner,hospital_under_spinnerLiner,hospital_under_spinner2Liner,oneChildhospital_under_spinner2Liner,LinertwoChildhospital_under_spinner2,thirdChildhospital_under_spinner2Liner,fourChildhospital_under_spinner2Liner,SecondAdultCashLiner,secondAdultPersonalLiner,OneChildCriticalSpinnerLiner,oneChildPersonalLiner,oneChildCashLiner, twoChildCriticalSpinnerLiner,twoChildPersonalLiner,twoChildCashLiner,thirdChildCriticalSpinnerLiner,thirdChildPersonalLiner,thirdChildCashLiner,fourChildCriticalSpinnerLiner,fourChildPersonalLiner,fourChildCashLiner;
    String[] anyDisease,yesSpiner,yesNo,noDiabetes,noHypertension,noCholesterol,forSelf,forSpouse,subLimit,amount;Button btn_continue;
    String NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for;
    EditText spinner_more,treatment_spinner,sub_limit_spinner,secondAdultCritical_under_spinner2Edit,OneChildCritical_under_spinner2Edit,twoChildCritical_under_spinner2Edit,thirdChildCritical_under_spinner2Edit,fourChildCritical_under_spinner2Edit,oneChildhospital_under_spinner2Edit,twoChildhospital_under_spinner2Edit,thirdChildhospital_under_spinnerEdit,fourChildhospital_under_spinner2Edit,personal_under_spinner2Edit,hospital_under_spinner2Edit,policyTypeEdit,familyTypeEdit,sumInsuredEdit,policyTenureEdit,totalPremiumAmount,QuotationID,hospitalCashSpinner,oneChildPersonal_under_Edit,twoChildPersonal_under_Edit,thirdChildPersonal_under_Edit,fourChildPersonal_under_Edit,editSumInsured,subLimitAmount,discountedit,criticalEdit,peronalAccidentEdit,hospitalEdit,editPersonalAccident,editPASpinner;
    TextView discountTxt,criticalIllnessNameTxt,criticalIllnessAmountTxt,personalEdit,hospitalCashtxt,twoAdultCriticalIllnessTxt,SecondAdultPersonalEdit,SecondAdultTxt, OneChildCriticalIllnessTxt,OneChildPersonalEdit,oneChildTxt,twoChildCriticalIllnessTxt,twoChildPersonalEdit,twoChildTxt,thirdChildCriticalIllnessTxt,thirdChildPersonalEdit,thirdChildTxt,fourChildCriticalIllnessTxt,fourChildPersonalEdit,fourChildTxt;
   EditText Critical_under_spinner2,secondAdultCritical_under_spinner2,sOneChildCritical_under_spinner2,twoChildCritical_under_spinner2,thirdChildCritical_under_spinner2,fourChildCritical_under_spinner2,personalUnder_spinner,personal_under_spinner2,oneChildPersonal_under_spinner2,twoChildPersonal_under_spinner2,thirdChildPersonal_under_spinner2,fourChildPersonal_under_spinner2,hospital_under_spinner,hospital_under_spinner2,oneChildhospital_under_spinner2,twoChildhospital_under_spinner2,thirdChildhospital_under_spinner2,fourChildhospital_under_spinner2;
   ImageView criticalDropDown,PADropDown;
    double personalSumInsured;
    double amountPersonalSumInsured=0.0;
    private static Medical_Complete_health instance;
    Date date;
    TextView show_Breakup;
    Format formatter;
    MySharedPreference pref;
    CustomProgressDialog customprogress;
    String strAddDiscountBtn="subtract";
    String strBMIEdit,strBMIAdultOneEdit,strBMIChildEdit,strBMIChildTwoEdit,strBMIEChildThreeEdit,strBMIFourChildEdit,strsOneChildCritical_under_spinner2,strtwoChildCritical_under_spinner2,strthirdChildCritical_under_spinner2,strfourChildCritical_under_spinner2,stroneChildhospital_under_spinner2,strtwoChildhospital_under_spinner2,strthirdChildhospital_under_spinner2,strfourChildhospital_under_spinner2,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Medical_Complete_health.this,Complete_health_member_info.class);
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
        intent.putExtra("strSubLimit",strSubLimit);
        intent.putExtra("LifeStyleDiscountStr",LifeStyleDiscountStr);
        intent.putExtra("LongTermDiscount",LongTermDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("BI_Status",BI_Status);
        intent.putExtra("BI_Status1",BI_Status1);
        intent.putExtra("BI_Status2",BI_Status2);
        intent.putExtra("BI_Status3",BI_Status3);
        intent.putExtra("BI_Status4",BI_Status4);
        intent.putExtra("BI_Status5",BI_Status5);
        intent.putExtra("strAddDiscountBtn",strAddDiscountBtn);
        intent.putExtra("selectYearAdult",selectYearAdult);
        intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
        intent.putExtra("selectYearChild",selectYearChild);
        intent.putExtra("selectYearChildTwo",selectYearChildTwo);
        intent.putExtra("selectYearChildThird",selectYearChildThird);
        intent.putExtra("selectYearChildFour",selectYearChildFour);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical__complete_health);

        pref = MySharedPreference.getInstance(Medical_Complete_health.this);
        customprogress = new CustomProgressDialog(Medical_Complete_health.this);
        getWindow().setStatusBarColor(ContextCompat.getColor(Medical_Complete_health.this, R.color.colorPrimaryDark));
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
        new_str_age = getIntent().getStringExtra("new_str_age");
        BI_Status = getIntent().getStringExtra("BI_Status");
        BI_Status1 = getIntent().getStringExtra("BI_Status1");
        BI_Status2 = getIntent().getStringExtra("BI_Status2");
        BI_Status3 = getIntent().getStringExtra("BI_Status3");
        BI_Status4 = getIntent().getStringExtra("BI_Status4");
        BI_Status5 = getIntent().getStringExtra("BI_Status5");
        strSubLimit = getIntent().getStringExtra("strSubLimit");
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
        str_for = getIntent().getStringExtra("for");
        Log.e("selectYearAdult", String.valueOf(selectYearAdult));
        Log.e("selectYearSecondAdult", String.valueOf(selectYearSecondAdult));
        Log.e("selectYearChild", String.valueOf(selectYearChild));
        Log.e("selectYearChildTwo", String.valueOf(selectYearChildTwo));
        Log.e("selectYearChildThird", String.valueOf(selectYearChildThird));
        Log.e("selectYearChildFour", String.valueOf(selectYearChildFour));

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

//        String[] strdDate1=  str_spouse_edit_dob_dob.split("/");
//        String str_edit_dobDString = strdDate1[0];
//        String str_edit_dob2String = strdDate1[1];
//        str_edit_dob3StringSpouse = strdDate1[2];
//
//        if (str_for.equals("0")){
//            if (str_edit_dob3StringSpouse != null) {
//                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                int dateValidationAdult2 = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                if (dateValidationAdult2 < dateValidation ){
//                }else if(dateValidationAdult2 >dateValidation) {
//                    health_quote();
//                }
//
//            }
//        }
//        else if (str_for.equals("1")){
//            if (str_edit_dob3StringSpouse != null) {
//                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                int dateValidationAdult2 = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                if (dateValidationAdult2 < dateValidation ){
//                }else if(dateValidationAdult2 >dateValidation) {
//                    health_quote();
//                }
//
//            }
//        }

       if (str_for.equals("0")){
           if(str_policyType_spinner.equals("Individual")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";

           }
           else if (str_IndividualTypeEdit.equals("2 Adult")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";
               PA_Status1="False";
               CI_Status1 = "False";
               DHC_Status1="False";
           }
           else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";
               PA_Status2="False";
               CI_Status2 = "False";
               DHC_Status2="False";
           }
           else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";
               PA_Status3="False";
               CI_Status3 = "False";
               DHC_Status3="False";
           }
           else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";
               PA_Status4="False";
               CI_Status4 = "False";
               DHC_Status4="False";
           }
           else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";
               PA_Status1="False";
               CI_Status1 = "False";
               DHC_Status1="False";
               PA_Status2="False";
               CI_Status2 = "False";
               DHC_Status2="False";
           }
           else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";
               PA_Status1="False";
               CI_Status1 = "False";
               DHC_Status1="False";
               PA_Status2="False";
               CI_Status2 = "False";
               DHC_Status2="False";
               PA_Status3="False";
               CI_Status3 = "False";
               DHC_Status3="False";
           }
           else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";
               PA_Status1="False";
               CI_Status1 = "False";
               DHC_Status1="False";
               PA_Status2="False";
               CI_Status2 = "False";
               DHC_Status2="False";
               PA_Status3="False";
               CI_Status3 = "False";
               DHC_Status3="False";
               PA_Status4="False";
               CI_Status4 = "False";
               DHC_Status4="False";
           }
           else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
               PA_Status="False";
               CI_Status="False";
               DHC_Status="False";
               PA_Status1="False";
               CI_Status1 = "False";
               DHC_Status1="False";
               PA_Status2="False";
               CI_Status2 = "False";
               DHC_Status2="False";
               PA_Status3="False";
               CI_Status3 = "False";
               DHC_Status3="False";
               PA_Status4="False";
               CI_Status4 = "False";
               DHC_Status4="False";
               PA_Status5="False";
               CI_Status5 = "False";
               DHC_Status5="False";
           }
           Esale_Status="True";
           Life_Status="False";
           Sub_Status="False";
           Tiered_Status="False";
           Sub_Type="";
       }else{
           Esale_Status="True";
       }



        health_quote();
        initView();
        instance = this;
    }

    @SuppressLint("LongLogTag")
    private void initView() {
        policyTypeEdit=findViewById(R.id.policyTypeEdit);
        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        show_Breakup=findViewById(R.id.show_Breakup);
        QuotationID=findViewById(R.id.QuotationID);
        spinner_more=findViewById(R.id.spinner_more);
        spinner_habitual=findViewById(R.id.spinner_habitual);
        self_spouse_liner=findViewById(R.id.self_spouse_liner);
        LinerSpinner_more=findViewById(R.id.LinerSpinner_more);
        sub_limit_spinnerLiner=findViewById(R.id.sub_limit_spinnerLiner);
        treatment_spinnerLiner=findViewById(R.id.treatment_spinnerLiner);
        self_diabetes_spinner=findViewById(R.id.self_diabetes_spinner);
        self_hypertension_spinner=findViewById(R.id.self_hypertension_spinner);
        self_cholesterol_spinner=findViewById(R.id.self_cholesterol_spinner);
        Spouse_diabetes_spinner=findViewById(R.id.Spouse_diabetes_spinner);
        Spouse_hypertension_spinner=findViewById(R.id.Spouse_hypertension_spinner);
        Spouse_cholesterol_spinner=findViewById(R.id.Spouse_cholesterol_spinner);
        self_habitual=findViewById(R.id.self_habitual);
        spouse_habitual=findViewById(R.id.spouse_habitual);
        habitual_liner=findViewById(R.id.habitual_liner);
        sub_limit_spinner=findViewById(R.id.sub_limit_spinner);
        subLimitAmount=findViewById(R.id.subLimitAmount);
        editSumInsured=findViewById(R.id.editSumInsured);
        twoAdultCriticalIllnessTxt=findViewById(R.id.twoAdultCriticalIllnessTxt);
        criticalIllnessNameTxt=findViewById(R.id.criticalIllnessNameTxt);
        criticalIllnessAmountTxt=findViewById(R.id.criticalIllnessAmountTxt);
        treatment_spinner=findViewById(R.id.treatment_spinner);
        discountedit=findViewById(R.id.discountedit);
        criticalEdit=findViewById(R.id.criticalEdit);
        editPASpinner=findViewById(R.id.editPASpinner);
        PADropDown=findViewById(R.id.PADropDown);
        editPersonalAccident=findViewById(R.id.editPersonalAccident);
        Critical_under_spinner=findViewById(R.id.Critical_under_spinner);
        Critical_illness_spinner=findViewById(R.id.Critical_illness_spinner);
        personalUnder_spinner=findViewById(R.id.personalUnder_spinner);
        SecondAdultCashLiner=findViewById(R.id.SecondAdultCashLiner);
        personal_under_spinner2=findViewById(R.id.personal_under_spinner2);
        oneChildPersonal_under_spinner2=findViewById(R.id.oneChildPersonal_under_spinner2);
        twoChildPersonal_under_spinner2=findViewById(R.id.twoChildPersonal_under_spinner2);
        thirdChildPersonal_under_spinner2=findViewById(R.id.thirdChildPersonal_under_spinner2);
        fourChildPersonal_under_spinner2=findViewById(R.id.fourChildPersonal_under_spinner2);
        SecondAdultPersonalEdit=findViewById(R.id.SecondAdultPersonalEdit);
        hospital_under_spinner=findViewById(R.id.hospital_under_spinner);
        hospitalCashSpinner=findViewById(R.id.hospitalCashSpinner);
        PersonalAccidentSpinner=findViewById(R.id.PersonalAccidentSpinner);
        criticalSpinnerLiner=findViewById(R.id.criticalSpinnerLiner);
        hospital_under_spinner2=findViewById(R.id.hospital_under_spinner2);
        oneChildhospital_under_spinner2=findViewById(R.id.oneChildhospital_under_spinner2);
        twoChildhospital_under_spinner2=findViewById(R.id.twoChildhospital_under_spinner2);
        thirdChildhospital_under_spinner2=findViewById(R.id.thirdChildhospital_under_spinner2);
        fourChildhospital_under_spinner2=findViewById(R.id.fourChildhospital_under_spinner2);
        Critical_under_spinner2=findViewById(R.id.Critical_under_spinner2);
        secondAdultCritical_under_spinner2Edit=findViewById(R.id.secondAdultCritical_under_spinner2Edit);
        hospital_under_spinner2Edit=findViewById(R.id.hospital_under_spinner2Edit);
        oneChildhospital_under_spinner2Edit=findViewById(R.id.oneChildhospital_under_spinner2Edit);
        twoChildhospital_under_spinner2Edit=findViewById(R.id.twoChildhospital_under_spinner2Edit);
        thirdChildhospital_under_spinnerEdit=findViewById(R.id.thirdChildhospital_under_spinnerEdit);
        fourChildhospital_under_spinner2Edit=findViewById(R.id.fourChildhospital_under_spinner2Edit);
        personal_under_spinner2Edit=findViewById(R.id.personal_under_spinner2Edit);
        personalEdit=findViewById(R.id.personalEdit);
        peronalAccidentEdit=findViewById(R.id.peronalAccidentEdit);
        criticalLiner=findViewById(R.id.criticalLiner);
        hospitalEdit=findViewById(R.id.hospitalEdit);
        hospitalCashtxt=findViewById(R.id.hospitalCashtxt);
        btn_continue=findViewById(R.id.btn_continue);
        subLimitLiner=findViewById(R.id.subLimitLiner);
        addDiscountBtn=findViewById(R.id.addDiscountBtn);
        subtractDiscountBtn=findViewById(R.id.subtractDiscountBtn);
        yesMedicalConditionLiner=findViewById(R.id.yesMedicalConditionLiner);
        criticalDropDown=findViewById(R.id.criticalDropDown);
        personalAccidentLiner=findViewById(R.id.personalAccidentLiner);
        secondAdultCriticalSpinnerLiner=findViewById(R.id.secondAdultCriticalSpinnerLiner);
        secondAdultCritical_under_spinner2Liner=findViewById(R.id.secondAdultCritical_under_spinner2Liner);
        LinerOneChildCritical_under_spinner2=findViewById(R.id.LinerOneChildCritical_under_spinner2);
        twoChildCritical_under_spinner2Liner=findViewById(R.id.twoChildCritical_under_spinner2Liner);
        thirdChildCritical_under_spinner2Liner=findViewById(R.id.thirdChildCritical_under_spinner2Liner);
        fourChildCritical_under_spinner2Liner=findViewById(R.id.fourChildCritical_under_spinner2Liner);
        personalUnder_spinnerLiner=findViewById(R.id.personalUnder_spinnerLiner);
        personal_under_spinner2EditLiner=findViewById(R.id.personal_under_spinner2EditLiner);
        oneChildPersonal_under_spinner2Liner=findViewById(R.id.oneChildPersonal_under_spinner2Liner);
        twoChildPersonal_under_spinner2Liner=findViewById(R.id.twoChildPersonal_under_spinner2Liner);
        thirdChildPersonal_under_spinner2Liner=findViewById(R.id.thirdChildPersonal_under_spinner2Liner);
        fourChildPersonal_under_spinner2Liner=findViewById(R.id.fourChildPersonal_under_spinner2Liner);
        hospital_under_spinnerLiner=findViewById(R.id.hospital_under_spinnerLiner);
        hospital_under_spinner2Liner=findViewById(R.id.hospital_under_spinner2Liner);
        oneChildhospital_under_spinner2Liner=findViewById(R.id.oneChildhospital_under_spinner2Liner);
        LinertwoChildhospital_under_spinner2=findViewById(R.id.LinertwoChildhospital_under_spinner2);
        thirdChildhospital_under_spinner2Liner=findViewById(R.id.thirdChildhospital_under_spinner2Liner);
        fourChildhospital_under_spinner2Liner=findViewById(R.id.fourChildhospital_under_spinner2Liner);
        secondAdultCritical_under_spinner2=findViewById(R.id.secondAdultCritical_under_spinner2);
        fourChildCritical_under_spinner2=findViewById(R.id.fourChildCritical_under_spinner2);
        thirdChildCritical_under_spinner2=findViewById(R.id.thirdChildCritical_under_spinner2);
        twoChildCritical_under_spinner2=findViewById(R.id.twoChildCritical_under_spinner2);
        sOneChildCritical_under_spinner2=findViewById(R.id.sOneChildCritical_under_spinner2);
        SecondAdultTxt=findViewById(R.id.SecondAdultTxt);
        secondAdultPersonalLiner=findViewById(R.id.secondAdultPersonalLiner);
        OneChildCriticalSpinnerLiner=findViewById(R.id.OneChildCriticalSpinnerLiner);
        oneChildPersonalLiner=findViewById(R.id.oneChildPersonalLiner);
        OneChildCriticalIllnessTxt=findViewById(R.id.OneChildCriticalIllnessTxt);
        OneChildPersonalEdit=findViewById(R.id.OneChildPersonalEdit);
        oneChildTxt=findViewById(R.id.oneChildTxt);
        oneChildCashLiner=findViewById(R.id.oneChildCashLiner);
        twoChildCriticalSpinnerLiner=findViewById(R.id.twoChildCriticalSpinnerLiner);
        twoChildCriticalIllnessTxt=findViewById(R.id.twoChildCriticalIllnessTxt);
        twoChildPersonalLiner=findViewById(R.id.twoChildPersonalLiner);
        twoChildPersonalEdit=findViewById(R.id.twoChildPersonalEdit);
        twoChildCashLiner=findViewById(R.id.twoChildCashLiner);
        twoChildTxt=findViewById(R.id.twoChildTxt);
        thirdChildCriticalSpinnerLiner=findViewById(R.id.thirdChildCriticalSpinnerLiner);
        thirdChildCriticalIllnessTxt=findViewById(R.id.thirdChildCriticalIllnessTxt);
        thirdChildPersonalLiner=findViewById(R.id.thirdChildPersonalLiner);
        thirdChildPersonal_under_spinner2=findViewById(R.id.thirdChildPersonal_under_spinner2);
        thirdChildPersonalEdit=findViewById(R.id.thirdChildPersonalEdit);
        thirdChildTxt=findViewById(R.id.thirdChildTxt);
        thirdChildCashLiner=findViewById(R.id.thirdChildCashLiner);
        fourChildCriticalSpinnerLiner=findViewById(R.id.fourChildCriticalSpinnerLiner);
        fourChildCriticalIllnessTxt=findViewById(R.id.fourChildCriticalIllnessTxt);
        fourChildPersonalEdit=findViewById(R.id.fourChildPersonalEdit);
        fourChildPersonalLiner=findViewById(R.id.fourChildPersonalLiner);
        fourChildCashLiner=findViewById(R.id.fourChildCashLiner);
        fourChildTxt=findViewById(R.id.fourChildTxt);
        oneChildPersonal_under_Edit=findViewById(R.id.oneChildPersonal_under_Edit);
        twoChildPersonal_under_Edit=findViewById(R.id.twoChildPersonal_under_Edit);
        thirdChildPersonal_under_Edit=findViewById(R.id.thirdChildPersonal_under_Edit);
        fourChildPersonal_under_Edit=findViewById(R.id.fourChildPersonal_under_Edit);
        discountTxt=findViewById(R.id.discountTxt);
        OneChildCritical_under_spinner2Edit=findViewById(R.id.OneChildCritical_under_spinner2Edit);
        twoChildCritical_under_spinner2Edit=findViewById(R.id.twoChildCritical_under_spinner2Edit);
        thirdChildCritical_under_spinner2Edit=findViewById(R.id.thirdChildCritical_under_spinner2Edit);
        fourChildCritical_under_spinner2Edit=findViewById(R.id.fourChildCritical_under_spinner2Edit);

        policyTypeEdit.setText(str_policyType_spinner);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        sumInsuredEdit.setText(str_SumInsured);
        policyTenureEdit.setText(strFirstTString+" Year");
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
        yesNo = getResources().getStringArray(R.array.NoYes);
        yesSpiner = getResources().getStringArray(R.array.yesNo);
//        spinner_more.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, anyDisease));
        spinner_habitual.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, anyDisease));
        self_diabetes_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noDiabetes));
        self_hypertension_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noHypertension));
        self_cholesterol_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noCholesterol));
        Spouse_diabetes_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noDiabetes));
        Spouse_hypertension_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noHypertension));
        Spouse_cholesterol_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, noCholesterol));
        self_habitual.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, forSelf));
        spouse_habitual.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, forSpouse));
//       sub_limit_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, subLimit));
//        treatment_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, anyDisease));
        Critical_under_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        personalUnder_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        hospital_under_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        hospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        oneChildhospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        twoChildhospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        thirdChildhospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        fourChildhospital_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        Critical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        secondAdultCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        sOneChildCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        twoChildCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        thirdChildCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        fourChildCritical_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        Critical_illness_spinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, amount));
//        personal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        oneChildPersonal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        twoChildPersonal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        thirdChildPersonal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
//        fourChildPersonal_under_spinner2.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, yesNo));
        PersonalAccidentSpinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, amount));
//        hospitalCashSpinner.setAdapter(new ArrayAdapter(Objects.requireNonNull(getApplicationContext()), R.layout.spinner_item_text, amount));


       if(str_for.equals("0")) {
           strAnyDisease="Select";
           spinner_more.setText(strAnyDisease);
           strAnyTreatment="Select";
           treatment_spinner.setText(strAnyTreatment);
       }
        LinerSpinner_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
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
                        strAnyDisease=items1.get(options1);
                        spinner_more.setText(strAnyDisease);
                        if (strAnyDisease.equals("Yes")) {
                            strAddDiscountBtn="subtract";
                            final Dialog alert_dialog = new Dialog(Medical_Complete_health.this);
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
                        else if(strAnyDisease.equals("No")) {
                            strAddDiscountBtn="subtract";
                            Life_Status="True";
                            health_quote();
                            btn_continue.setVisibility(View.VISIBLE);
                        }else {
                            strAddDiscountBtn="subtract";
                            Life_Status="False";
                            btn_continue.setVisibility(View.VISIBLE);
                        }
                    }
                });
                singlePicker.show();

            }
        });

        addDiscountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { subLimitLiner.setVisibility(View.VISIBLE);
            strAddDiscountBtn="add";
            subtractDiscountBtn.setVisibility(View.VISIBLE);addDiscountBtn.setVisibility(View.GONE); }});
           subtractDiscountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { subLimitLiner.setVisibility(View.GONE);
                strAddDiscountBtn="subtract";
            addDiscountBtn.setVisibility(View.VISIBLE);subtractDiscountBtn.setVisibility(View.GONE); }});

        self_diabetes_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { strnoDiabetes = String.valueOf(noDiabetes[i]);
            if (strnoDiabetes.equals("No Diabetes Selected")) {strnoDiabetes="No"; } }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){}});
        Spouse_diabetes_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strnoSpouseDiabetes = String.valueOf(noDiabetes[i]);if (strnoSpouseDiabetes.equals("No Diabetes Selected")) { strnoSpouseDiabetes="No";}}
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});
        self_hypertension_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strNoHypertension = String.valueOf(noHypertension[i]);if (strNoHypertension.equals("No Hypertension Selected")){strNoHypertension="No"; } }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});
        Spouse_hypertension_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strNoSpouseHypertension = String.valueOf(noHypertension[i]);if (strNoSpouseHypertension.equals("No Hypertension Selected")) { strNoSpouseHypertension="No"; } }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});
        self_cholesterol_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strNoCholesterol = String.valueOf(noCholesterol[i]);if (strNoCholesterol.equals("No Cholesterol Selected")) { strNoCholesterol="No"; } }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});
        Spouse_cholesterol_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { strNoSpouseCholesterol = String.valueOf(noCholesterol[i]);
                if (strNoSpouseCholesterol.equals("No Cholesterol Selected")) {strNoSpouseCholesterol="No";}}
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});
        spinner_habitual.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strAnyhabitual = String.valueOf(anyDisease[i]);if (strAnyhabitual.equals("Yes")) {habitual_liner.setVisibility(View.VISIBLE);}else { habitual_liner.setVisibility(View.GONE); }}
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});

        self_habitual.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { strforSelf = String.valueOf(forSelf[i]);}
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});

        spouse_habitual.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {strforSpouse = String.valueOf(forSpouse[i]);}
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});

//

        if (str_for.equals("0")){
            strCriticalUnderSpinner2="No";
            strsecondAdultCritical_under_spinner2="No";
            strsOneChildCritical_under_spinner2="No";
            strtwoChildCritical_under_spinner2="No";
            strthirdChildCritical_under_spinner2="No";
            strfourChildCritical_under_spinner2="No";
            secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
            secondAdultCritical_under_spinner2.setVisibility(View.GONE);
            sOneChildCritical_under_spinner2.setVisibility(View.GONE);
            OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
            twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
            twoChildCritical_under_spinner2.setVisibility(View.GONE);
            thirdChildCritical_under_spinner2.setVisibility(View.GONE);
            thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
            fourChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
            fourChildCritical_under_spinner2.setVisibility(View.GONE);
            Critical_under_spinner2.setText(strCriticalUnderSpinner2);
            secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
            OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
            twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
            thirdChildCritical_under_spinner2Edit.setText(strthirdChildCritical_under_spinner2);
            fourChildCritical_under_spinner2Edit.setText(strfourChildCritical_under_spinner2);

            strpersonalUnder_spinner="No";
            strpersonal_under_spinner2="No";
            stroneChildPersonal_under_spinner2="No";
            strtwoChildPersonal_under_spinner2="No";
            strthirdChildPersonal_under_spinner2="No";
            strfourChildPersonal_under_spinner2="No";

            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
            personal_under_spinner2.setVisibility(View.GONE);
            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);

            personalUnder_spinner.setText(strpersonalUnder_spinner);
            personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);

            strhospital_under_spinner="No";
            strhospital_under_spinner2="No";
            stroneChildhospital_under_spinner2="No";
            strtwoChildhospital_under_spinner2="No";
            strthirdChildhospital_under_spinner2="No";
            strfourChildhospital_under_spinner2="No";

            hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
            hospital_under_spinner2.setVisibility(View.GONE);
            oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
            oneChildhospital_under_spinner2.setVisibility(View.GONE);
            twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
            twoChildhospital_under_spinner2.setVisibility(View.GONE);
            thirdChildhospital_under_spinner2.setVisibility(View.GONE);
            thirdChildhospital_under_spinnerEdit.setVisibility(View.VISIBLE);
            fourChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
            fourChildhospital_under_spinner2.setVisibility(View.GONE);

            hospital_under_spinner.setText(strhospital_under_spinner);
            hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
            oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
            twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
            thirdChildhospital_under_spinnerEdit.setText(strthirdChildhospital_under_spinner2);
            fourChildhospital_under_spinner2Edit.setText(strfourChildhospital_under_spinner2);

            strSubLimit="Sub Limit Not Selected";
            discountTxt.setText("(What is Sub-Limit (upto 10% Discount))");
            sub_limit_spinner.setText(strSubLimit);
             if(strAnyDisease.equals("Select")) {
                 Life_Status="False";
                 btn_continue.setVisibility(View.VISIBLE);
            }

//            if (strAddDiscountBtn.equals("subtract")){
//                subLimitLiner.setVisibility(View.GONE);
//                addDiscountBtn.setVisibility(View.VISIBLE);
//                subtractDiscountBtn.setVisibility(View.GONE);
//            }
            if (!strAnyTreatment.equals("Yes")) {
                strAnyTreatment="Select";
                treatment_spinner.setText(strAnyTreatment);
            }

        }
        else{
            editSumInsured.setText(str_SumInsured);
            editPersonalAccident.setText(str_SumInsured);
            editPASpinner.setText(str_SumInsured);
            criticalEdit.setText(strcriticalEdit);
            peronalAccidentEdit.setText(str_amountPersonalSumInsured);
            hospitalEdit.setText(strhospitalEdit);
            spinner_more.setText(strAnyDisease);

            if (strAddDiscountBtn.equals("add")){
                subLimitLiner.setVisibility(View.VISIBLE);
                subtractDiscountBtn.setVisibility(View.VISIBLE);
                addDiscountBtn.setVisibility(View.GONE);
                sub_limit_spinner.setText(strSubLimit);
                subLimitAmount.setText(strSubLimitAmount);
                if (strSubLimit.equals("Sub Limit-A")) {
                    discountTxt.setText("(What is Sub-Limit (upto 10% Discount))");
                }else if (strSubLimit.equals("Sub Limit-B")) {
                    discountTxt.setText("(What is Sub-Limit (upto 5% Discount))");
                }else if (strSubLimit.equals("Sub Limit-C")) {
                    discountTxt.setText("(What is Sub-Limit (upto 5% Discount))");
                }
            }else{
                subLimitLiner.setVisibility(View.GONE);
                addDiscountBtn.setVisibility(View.VISIBLE);
                subtractDiscountBtn.setVisibility(View.GONE);
            }

            Critical_under_spinner2.setText(strCriticalUnderSpinner2);
            personalUnder_spinner.setText(strpersonalUnder_spinner);
            hospital_under_spinner.setText(strhospital_under_spinner);
               if(strAnyDisease.equals("No")) {
                   spinner_more.setText(strAnyDisease);
                   btn_continue.setVisibility(View.VISIBLE);
               }

            if (strAnyTreatment.equals("Yes")) {
                treatment_spinner.setText(strAnyTreatment);
                discountedit.setText(strDiscount);
            }

            if (str_IndividualTypeEdit.equals("2 Adult")){
                if (strCriticalUnderSpinner2.equals("Yes")){
                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                }else{
                    strsecondAdultCritical_under_spinner2="No";
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    personalUnder_spinner.setText(strpersonalUnder_spinner);
                    personal_under_spinner2.setText(strpersonal_under_spinner2);
                    personal_under_spinner2Edit.setVisibility(View.GONE);
                    personal_under_spinner2.setVisibility(View.VISIBLE);
                }else{
                    strpersonal_under_spinner2="No";
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setVisibility(View.GONE);
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                }else{
                    strpersonal_under_spinner2="No";
                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    hospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                }

            }
            else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                if (strCriticalUnderSpinner2.equals("Yes")){
                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                }
                else{
                    strsOneChildCritical_under_spinner2="No";
                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    personalUnder_spinner.setText(strpersonalUnder_spinner);
                    if (strChildOne!= null){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        if (selectYearChild >= 5 ) {
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        }else{
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                        } }
                }else{
                    stroneChildPersonal_under_spinner2="No";
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                }else{
                    stroneChildhospital_under_spinner2="No";
                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                }
            }
            else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                if (strCriticalUnderSpinner2.equals("Yes")){
                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                }
                else{
                    strsOneChildCritical_under_spinner2="No";
                    strtwoChildCritical_under_spinner2="No";
                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    personalUnder_spinner.setText(strpersonalUnder_spinner);
                    if ((strChildOne!= null) && (strChildTwo!= null)) {
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        if ((selectYearChild >= 5) && selectYearChildTwo >= 5) {
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                        } else if ((selectYearChild < 5) && selectYearChildTwo >= 5) {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your First Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2 = "No";
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);

                        } else if ((selectYearChild >= 5) && selectYearChildTwo < 5) {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                        } else if ((selectYearChild < 5) && selectYearChildTwo < 5) {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2 = "No";
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        }else{
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2 = "No";
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        }
                    }
                }else{
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                }else{
                    stroneChildhospital_under_spinner2="No";
                    strtwoChildhospital_under_spinner2="No";
                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                }
            }
            else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                if (strCriticalUnderSpinner2.equals("Yes")){
                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                    thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                }
                else{
                    strsOneChildCritical_under_spinner2="No";
                    strtwoChildCritical_under_spinner2="No";
                    strthirdChildCritical_under_spinner2="No";
                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                    thirdChildCritical_under_spinner2.setVisibility(View.GONE);
                    thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    thirdChildCritical_under_spinner2Edit.setText(strthirdChildCritical_under_spinner2);
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    personalUnder_spinner.setText(strpersonalUnder_spinner);
                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                        //all bde
                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //all chote
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5))  {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first chota second bda,third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            stroneChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first bda,second chota,third bda
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first  bda,second bda ,third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first and third chota second bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            stroneChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first and second chota third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first bda and second third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        else {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2 = "No";
                            strtwoChildPersonal_under_spinner2 = "No";
                            strthirdChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        }
                    }
                }
                else{
                    Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    strthirdChildPersonal_under_spinner2="No";
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                    thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildhospital_under_spinnerEdit.setVisibility(View.GONE);
                }else{
                    stroneChildhospital_under_spinner2="No";
                    strtwoChildhospital_under_spinner2="No";
                    strthirdChildhospital_under_spinner2="No";
                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                    thirdChildhospital_under_spinner2.setVisibility(View.GONE);
                    thirdChildhospital_under_spinnerEdit.setVisibility(View.VISIBLE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                    thirdChildhospital_under_spinnerEdit.setText(strthirdChildhospital_under_spinner2);
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                if (strCriticalUnderSpinner2.equals("Yes")){
                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                }
                else{
                    strsOneChildCritical_under_spinner2="No";
                    strsecondAdultCritical_under_spinner2="No";
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    personalUnder_spinner.setText(strpersonalUnder_spinner);
                    personal_under_spinner2Edit.setVisibility(View.GONE);
                    personal_under_spinner2.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setText(strpersonal_under_spinner2);
                    if (strChildOne!= null){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        if (selectYearChild >= 5 ) {
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        }else{
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                        } }
                }else{
                    stroneChildPersonal_under_spinner2="No";
                    strpersonal_under_spinner2="No";
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                }else{
                    stroneChildhospital_under_spinner2="No";
                    strpersonal_under_spinner2="No";
                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    hospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                if (strCriticalUnderSpinner2.equals("Yes")){
                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                }
                else{
                    strsOneChildCritical_under_spinner2="No";
                    strtwoChildCritical_under_spinner2="No";
                    strsecondAdultCritical_under_spinner2="No";
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    personalUnder_spinner.setText(strpersonalUnder_spinner);
                    personal_under_spinner2Edit.setVisibility(View.GONE);
                    personal_under_spinner2.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setText(strpersonal_under_spinner2);
                    if ((strChildOne!= null) && (strChildTwo!= null)) {
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        if ((selectYearChild >= 5) && selectYearChildTwo >= 5) {
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                        }
                        else if ((selectYearChild < 5) && selectYearChildTwo < 5) {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        }
                        else if ((selectYearChild < 5) && selectYearChildTwo >= 5) {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2 = "No";
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);

                        }
                        else if ((selectYearChild >= 5) && selectYearChildTwo < 5) {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);

                        }
                        else{
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            stroneChildPersonal_under_spinner2 = "No";
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        }
                    }else{
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        stroneChildPersonal_under_spinner2 = "No";
                        strtwoChildPersonal_under_spinner2 = "No";
                        personal_under_spinner2Edit.setVisibility(View.GONE);
                        personal_under_spinner2.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setVisibility(View.GONE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    }

//                    oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
//                    twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
//                    personal_under_spinner2Edit.setVisibility(View.GONE);
//                    personal_under_spinner2.setVisibility(View.VISIBLE);
//                    oneChildPersonal_under_Edit.setVisibility(View.GONE);
//                    oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
//                    twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
//                    twoChildPersonal_under_Edit.setVisibility(View.GONE);
                }else{
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    strpersonal_under_spinner2="No";
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                }else{
                    stroneChildhospital_under_spinner2="No";
                    strtwoChildhospital_under_spinner2="No";
                    strpersonal_under_spinner2="No";
                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    hospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                if (strCriticalUnderSpinner2.equals("Yes")){
                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                    thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                }
                else{
                    strsOneChildCritical_under_spinner2="No";
                    strtwoChildCritical_under_spinner2="No";
                    strthirdChildCritical_under_spinner2="No";
                    strsecondAdultCritical_under_spinner2="No";
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                    thirdChildCritical_under_spinner2.setVisibility(View.GONE);
                    thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    thirdChildCritical_under_spinner2Edit.setText(strthirdChildCritical_under_spinner2);
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    personalUnder_spinner.setText(strpersonalUnder_spinner);
                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                        //all bde
                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //all chote
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5))  {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first chota second bda,third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            stroneChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first bda,second chota,third bda
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first  bda,second bda ,third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first and third chota second bda
                        else if ((selectYearChild <5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            stroneChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first and second chota third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first bda and second third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        else{
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            strpersonal_under_spinner2="No";
                            personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        }
                    }

//                    oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
//                    twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
//                    thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
//                    personal_under_spinner2Edit.setVisibility(View.GONE);
//                    personal_under_spinner2.setVisibility(View.VISIBLE);
//                    oneChildPersonal_under_Edit.setVisibility(View.GONE);
//                    oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
//                    twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
//                    twoChildPersonal_under_Edit.setVisibility(View.GONE);
//                    thirdChildPersonal_under_Edit.setVisibility(View.GONE);
//                    thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                }else{
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    strthirdChildPersonal_under_spinner2="No";
                    strpersonal_under_spinner2="No";
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                    thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildhospital_under_spinnerEdit.setVisibility(View.GONE);
                }else{
                    stroneChildhospital_under_spinner2="No";
                    strtwoChildhospital_under_spinner2="No";
                    strthirdChildhospital_under_spinner2="No";
                    strpersonal_under_spinner2="No";
                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    hospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                    thirdChildhospital_under_spinner2.setVisibility(View.GONE);
                    thirdChildhospital_under_spinnerEdit.setVisibility(View.VISIBLE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                    thirdChildhospital_under_spinnerEdit.setText(strthirdChildhospital_under_spinner2);
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                if (strCriticalUnderSpinner2.equals("Yes")){
                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                    fourChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                    fourChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                    thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                    fourChildCritical_under_spinner2.setText(strfourChildCritical_under_spinner2);
                }
                else{
                    strsOneChildCritical_under_spinner2="No";
                    strtwoChildCritical_under_spinner2="No";
                    strthirdChildCritical_under_spinner2="No";
                    strsecondAdultCritical_under_spinner2="No";
                    strfourChildCritical_under_spinner2="No";

                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                    thirdChildCritical_under_spinner2.setVisibility(View.GONE);
                    thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    fourChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                    fourChildCritical_under_spinner2.setVisibility(View.GONE);
                    thirdChildCritical_under_spinner2Edit.setText(strthirdChildCritical_under_spinner2);
                    fourChildCritical_under_spinner2Edit.setText(strfourChildCritical_under_spinner2);
                }

                if (strpersonalUnder_spinner.equals("Yes")){
                    personalUnder_spinner.setText(strpersonalUnder_spinner);
                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null) && (strChildFour!= null)){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                        int dateValidation4 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildFour);
                        //all bde
                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5) && (selectYearChildFour >= 5))  {

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);

                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                        }
                        //all chote
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5) && (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();

                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first chota ,second third four bde
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first third four bde second chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            strtwoChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first second four bda and third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first,second ,third bda and four chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your fourth child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        //first and second chota third four bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first second third chota and fourth bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first,second and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first third chota and second and fouth bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first and fourth chota second and third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and fourth child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        //first second fourth chota and third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first second and fourth child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        //first third and fourth chota second bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first third and fourth child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        else {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            strpersonal_under_spinner2="No";
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";

                            personal_under_spinner2.setVisibility(View.GONE);
                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                            personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                        }
                    }
                    else{
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);

                    }
                }else{
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    strthirdChildPersonal_under_spinner2="No";
                    strpersonal_under_spinner2="No";
                    strfourChildPersonal_under_spinner2="No";
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);

                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                    fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                    fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                }

                if (strhospital_under_spinner.equals("Yes")){
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                    thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                    fourChildhospital_under_spinner2.setText(strfourChildhospital_under_spinner2);

                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                    thirdChildhospital_under_spinnerEdit.setVisibility(View.GONE);
                    fourChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                    fourChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                }else{
                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    hospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                    thirdChildhospital_under_spinner2.setVisibility(View.GONE);
                    thirdChildhospital_under_spinnerEdit.setVisibility(View.VISIBLE);
                    fourChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                    fourChildhospital_under_spinner2.setVisibility(View.GONE);
                    hospital_under_spinner.setText(strhospital_under_spinner);
                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                    thirdChildhospital_under_spinnerEdit.setText(strthirdChildhospital_under_spinner2);
                    fourChildhospital_under_spinner2Edit.setText(strfourChildhospital_under_spinner2);

                }
            }
        }

        if (str_for.equals("0")){
            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                if (strChildOne!= null){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        if (selectYearChild >= 5 ) {
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            PA_Status="False";
                            PA_Status2="False";
                            health_quote();
                        }else{
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            PA_Status="False";
                            PA_Status2="False";
                            health_quote();
                        }
                    }
            }
            else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                if ((strChildOne!= null) && (strChildTwo!= null)) {
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                    int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                    if ((selectYearChild >= 5) && selectYearChildTwo >= 5) {
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        health_quote();
                    }
                    else if ((selectYearChild < 5) && selectYearChildTwo >= 5) {
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your First Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2 = "No";
                        strtwoChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                    }
                    else if ((selectYearChild >= 5) && selectYearChildTwo < 5) {
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        health_quote();
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2 = "No";
                        strtwoChildPersonal_under_spinner2 = "No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                    }
                    else{
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        health_quote();
                        stroneChildPersonal_under_spinner2 = "No";
                        strtwoChildPersonal_under_spinner2 = "No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    } } }
            else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                thirdChildCashLiner.setVisibility(View.VISIBLE);
                thirdChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                thirdChildPersonalLiner.setVisibility(View.VISIBLE);
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);

                if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                    int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                    int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                    //all bde
                    if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //all chote
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5))  {
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                    }
                    //first chota second bda,third bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first bda,second chota,third bda
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first  bda,second bda ,third chota
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first and third chota second bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first and second chota third bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first bda and second third chota
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    else {
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";

                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);

                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                    }
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);

                if (strChildOne!= null){
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                    if (selectYearChild >= 5 ) {
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    }else{
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        health_quote();
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                    } }


            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                if ((strChildOne!= null) && (strChildTwo!= null)) {
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                    int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                    if ((selectYearChild >= 5) && selectYearChildTwo >= 5) {
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        health_quote();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    }
                    else if ((selectYearChild < 5) && selectYearChildTwo < 5) {
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        health_quote();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    }
                    else if ((selectYearChild < 5) && selectYearChildTwo >= 5) {
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2 = "No";
                        strtwoChildPersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    }
                    else if ((selectYearChild >= 5) && selectYearChildTwo < 5) {
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2 = "No";
                        strtwoChildPersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                    }
                    else{
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        health_quote();
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2 = "No";
                        strtwoChildPersonal_under_spinner2 = "No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    }
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                thirdChildCashLiner.setVisibility(View.VISIBLE);
                thirdChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                thirdChildPersonalLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);

                if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                    int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                    int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                    //all bde
                    if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //all chote
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                    }
                    //first chota second bda,third bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first bda,second chota,third bda
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first  bda,second bda ,third chota
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first and third chota second bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first and second chota third bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    //first bda and second third chota
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    }
                    else {
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                    }
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                fourChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                fourChildPersonalLiner.setVisibility(View.VISIBLE);
                fourChildCashLiner.setVisibility(View.VISIBLE);
                fourChildTxt.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                thirdChildCashLiner.setVisibility(View.VISIBLE);
                thirdChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                thirdChildPersonalLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null) && (strChildFour!= null)){
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                    int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                    int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                    int dateValidation4 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildFour);
                    //all bde
                    if ((selectYearChild >= 5 ) && (selectYearChildTwo >= 5) && (selectYearChildThird >= 5) && (selectYearChildFour >= 5))  {
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);


                    }
                    //all chote
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5) && (selectYearChildFour < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                    }
                    //first chota ,second third four bde
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                    }
                    //first third four bde second chota
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                    }
                    //first second four bda and third chota
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                    }
                    //first,second ,third bda and four chota
                    else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your fourth child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setAlpha(0.5f);
                    }
                    //first and second chota third four bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);

                    }
                    //first second third chota and fourth bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first second and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                    }
                    //first third chota and second and fouth bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                    }
                    //first and fourth chota second and third bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and fourth child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setAlpha(0.5f);
                    }
                    //first second fourth chota and third bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first second and fourth child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setAlpha(0.5f);
                    }
                    //first third and fourth chota second bda
                    else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour < 5)){
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first third and fourth child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setAlpha(0.5f);
                    }
                    else {
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status="False";
                        PA_Status1="False";
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";
                        personal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                        personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                    }
                }
                else{
                    Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                    PA_Status="False";
                    PA_Status1="False";
                    PA_Status2="False";
                    PA_Status3="False";
                    PA_Status4="False";
                    PA_Status5="False";
                    health_quote();
                    strpersonal_under_spinner2="No";
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    strthirdChildPersonal_under_spinner2="No";
                    strfourChildPersonal_under_spinner2="No";

                    personal_under_spinner2.setVisibility(View.GONE);
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                    fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);

                }
            }
        }

    //

        if(str_policyType_spinner.equals("Individual")){
            editSumInsured.setText(str_SumInsured);
            editPersonalAccident.setText(str_SumInsured);
            editPASpinner.setText(str_SumInsured);
//           int personalSumInsured= Integer.parseInt(str_SumInsured);
//           double amountPersonalSumInsured=(personalSumInsured/1000)*0.4;
//           str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//            peronalAccidentEdit.setText(str_amountPersonalSumInsured);
//            strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//            strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//            criticalEdit.setText(strcriticalEdit);
//            hospitalEdit.setText(strhospitalEdit);
//            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsured);
//            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
        }
        else {
            if (str_IndividualTypeEdit.equals("2 Adult")){
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
//                double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
//                peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
//             //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit));
//                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                //personalAccident
//                personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                //HospitalCash
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit));
//                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
            }
            else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                if (strpersonalUnder_spinner.equals("No")){
                    PA_Status="False";
                    PA_Status2="False";
                    stroneChildPersonal_under_spinner2="No";
                    oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                }
                else{
                    if (strChildOne!= null){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        if (selectYearChild >= 5 ) {
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
//                            stroneChildPersonal_under_spinner2="Yes";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
//                            PA_Status="True";
//                            PA_Status2="True";


//                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
//                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        }else{
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);

                            PA_Status="False";
                            PA_Status2="False";

//                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                        peronalAccidentEdit.setText(String.valueOf(str_amountPersonalSumInsured));
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                        } }

                }

            }
            else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                //function
               /* strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);

                */

                if (strpersonalUnder_spinner.equals("No")){
                    PA_Status="False";
                    PA_Status2="False";
                    PA_Status3="False";
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                }else{
                    if ((strChildOne!= null) && (strChildTwo!= null)) {
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        if ((selectYearChild >= 5) && selectYearChildTwo >= 5) {
//                            PA_Status="True";
//                            PA_Status2="False";
//                            PA_Status3="False";
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
//                            stroneChildPersonal_under_spinner2="No";
//                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            health_quote();
                        }
                        else if ((selectYearChild < 5) && selectYearChildTwo >= 5) {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your First Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
//                            PA_Status="True";
//                            PA_Status2="False";
//                            PA_Status3="False";
                            health_quote();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2 = "No";
//                            strtwoChildPersonal_under_spinner2="No";
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);

                        }
                        else if ((selectYearChild >= 5) && selectYearChildTwo < 5) {
//                            PA_Status="True";
//                            PA_Status2="False";
//                            PA_Status3="False";
                            health_quote();
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
//                            stroneChildPersonal_under_spinner2 = "No";
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        else{
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and Second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status="True";
                            PA_Status2="False";
                            PA_Status3="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2 = "No";
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        }
                    }

                }
            }
            else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                thirdChildCashLiner.setVisibility(View.VISIBLE);
                thirdChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                thirdChildPersonalLiner.setVisibility(View.VISIBLE);
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);

                if (strpersonalUnder_spinner.equals("No")){
                    PA_Status="False";
                    PA_Status2="False";
                    PA_Status3="False";
                    PA_Status4="False";
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    strthirdChildPersonal_under_spinner2="No";
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                }else{
                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                        //all bde
                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            health_quote();
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //all chote
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5))  {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            PA_Status="True";
                            PA_Status2="False";
                            PA_Status3="False";
                            PA_Status4="False";
                            health_quote();
                        }
                        //first chota second bda,third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            stroneChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first bda,second chota,third bda
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first  bda,second bda ,third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first and third chota second bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            stroneChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first and second chota third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first bda and second third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second and third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        else {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status="True";
                            PA_Status2="False";
                            PA_Status3="False";
                            PA_Status4="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";

                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);

                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                    }
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);

                if (strpersonalUnder_spinner.equals("No")){
                    PA_Status="False";
                    PA_Status1="False";
                    PA_Status2="False";
                    health_quote();
                    strpersonal_under_spinner2="No";
                    stroneChildPersonal_under_spinner2="No";
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    personal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                }else{
                    if (strChildOne!= null){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        if (selectYearChild >= 5 ) {
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
//                            PA_Status="True";
//                            PA_Status1="False";
//                            PA_Status2="False";
                            health_quote();

//                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
//                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        }else{
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            health_quote();
//                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                        peronalAccidentEdit.setText(String.valueOf(str_amountPersonalSumInsured));
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                        } }

                }





//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                if (strChildOne!= null){
//                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
//                    if (dateValidation > 5 ) {
//                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
//                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
//                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
//                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(String.valueOf(amountPersonalSumInsured)));
//                    }else{
//                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
//                        stroneChildPersonal_under_spinner2="No";
//                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
//                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
//                        oneChildPersonal_under_Edit.setAlpha(0.5f);
//                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
//                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
//                    } }



            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);

             /*   //function
                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);

                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);

                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);

              */

                if (strpersonalUnder_spinner.equals("No")){
                    PA_Status="False";
                    PA_Status1="False";
                    PA_Status2="False";
                    PA_Status3="False";
                    PA_Status4="False";
                    health_quote();
                    strpersonal_under_spinner2="No";
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                }
                else{
                    if ((strChildOne!= null) && (strChildTwo!= null)) {
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        if ((selectYearChild >= 5) && selectYearChildTwo >= 5) {
//                            PA_Status="True";
//                            PA_Status1="False";
//                            PA_Status2="False";
//                            PA_Status3="False";
                            health_quote();
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
//                            strpersonal_under_spinner2="No";
//                            stroneChildPersonal_under_spinner2="No";
//                            strtwoChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                        }
                        else if ((selectYearChild < 5) && selectYearChildTwo < 5) {
                            PA_Status2="False";
                            PA_Status3="False";
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        }
                        else if ((selectYearChild < 5) && selectYearChildTwo >= 5) {
//                            PA_Status="True";
//                            PA_Status1="False";
//                            PA_Status2="False";
//                            PA_Status3="False";
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
//                            strpersonal_under_spinner2="No";
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2 = "No";
//                            strtwoChildPersonal_under_spinner2="No";
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);

                        }
                        else if ((selectYearChild >= 5) && selectYearChildTwo < 5) {
//                            PA_Status="True";
//                            PA_Status1="False";
//                            PA_Status2="False";
//                            PA_Status3="False";
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
//                            strpersonal_under_spinner2="No";
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
//                            stroneChildPersonal_under_spinner2 = "No";
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);

                        }
                        else{
                            PA_Status2="False";
                            PA_Status3="False";
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first child and second child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            stroneChildPersonal_under_spinner2 = "No";
                            strtwoChildPersonal_under_spinner2 = "No";
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                thirdChildCashLiner.setVisibility(View.VISIBLE);
                thirdChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                thirdChildPersonalLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);

                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);


                if (strpersonalUnder_spinner.equals("No")){
                    PA_Status="False";
                    PA_Status1="False";
                    PA_Status2="False";
                    PA_Status3="False";
                    PA_Status4="False";
                    health_quote();
                    strpersonal_under_spinner2="No";
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    strthirdChildPersonal_under_spinner2="No";
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);

                }
                else{
                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                        //all bde
                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            health_quote();
                        }
                        //all chote
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5))  {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            PA_Status2="False";
                            PA_Status3="False";
                            PA_Status4="False";
                            health_quote();
                        }
                        //first chota second bda,third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            PA_Status2="False";
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            stroneChildPersonal_under_spinner2="No";
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first bda,second chota,third bda
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            PA_Status3="False";
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            strtwoChildPersonal_under_spinner2="No";
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first  bda,second bda ,third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            PA_Status4="False";
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first and third chota second bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            PA_Status2="False";
                            PA_Status4="False";
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            stroneChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first and second chota third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            PA_Status2="False";
                            PA_Status3="False";
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        }
                        //first bda and second third chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your second and third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            PA_Status3="False";
                            PA_Status4="False";
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        }
                        else {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status3="False";
                            PA_Status4="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";

                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);

                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                    }

                }
                /*   //function
                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                    int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                    int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);

                    if ((dateValidation > 5 )&& (dateValidation1 > 5) && (dateValidation3 > 5))  {
                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                    } else if ((dateValidation < 5 )&& (dateValidation1 > 5) && (dateValidation3 > 5)){
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        stroneChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                        thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                    } else if ((dateValidation > 5 )&& (dateValidation1 < 5)&& (dateValidation3 > 5)){
                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        strtwoChildPersonal_under_spinner2="No";
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+"0.0");
                        thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));

                    } else if ((dateValidation > 5 )&& (dateValidation1 > 5)&& (dateValidation3 < 5)){
                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        strthirdChildPersonal_under_spinner2="No";
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+"0.0");
                    } else {
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        strthirdChildPersonal_under_spinner2="No";
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setAlpha(0.5f);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        stroneChildPersonal_under_spinner2="No";
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        strtwoChildPersonal_under_spinner2="No";
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setAlpha(0.5f);
                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
                        double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
                        twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+"0.0");
                        thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+"0.0");
                    } }

              */
            }
            else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                OneChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                fourChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                oneChildPersonalLiner.setVisibility(View.VISIBLE);
                oneChildCashLiner.setVisibility(View.VISIBLE);
                secondAdultCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                secondAdultPersonalLiner.setVisibility(View.VISIBLE);
                SecondAdultCashLiner.setVisibility(View.VISIBLE);
                twoChildCashLiner.setVisibility(View.VISIBLE);
                twoChildPersonalLiner.setVisibility(View.VISIBLE);
                fourChildPersonalLiner.setVisibility(View.VISIBLE);
                fourChildCashLiner.setVisibility(View.VISIBLE);
                fourChildTxt.setVisibility(View.VISIBLE);
                twoChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                thirdChildCashLiner.setVisibility(View.VISIBLE);
                thirdChildCriticalSpinnerLiner.setVisibility(View.VISIBLE);
                thirdChildPersonalLiner.setVisibility(View.VISIBLE);

                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
                editSumInsured.setText(str_SumInsured);
                editPersonalAccident.setText(str_SumInsured);
                editPASpinner.setText(str_SumInsured);
              /*  //function
                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                fourChildCriticalIllnessTxt.setText(str_fourNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                fourChildTxt.setText(str_fourNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);

               */
                if (strpersonalUnder_spinner.equals("No")){
                    PA_Status="False";
                    PA_Status1="False";
                    PA_Status2="False";
                    PA_Status3="False";
                    PA_Status4="False";
                    PA_Status5="False";
                    health_quote();
                    strpersonal_under_spinner2="No";
                    stroneChildPersonal_under_spinner2="No";
                    strtwoChildPersonal_under_spinner2="No";
                    strthirdChildPersonal_under_spinner2="No";
                    strfourChildPersonal_under_spinner2="No";
                    personal_under_spinner2.setVisibility(View.GONE);
                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                    fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                    personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                    oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                    twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                    thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                    fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);

                }else{
                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null) && (strChildFour!= null)){
                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                        int dateValidation4 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildFour);
                        //all bde
                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5) && (selectYearChildFour >= 5))  {
                            health_quote();
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                        }
                        //all chote
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5) && (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status3="False";
                            PA_Status4="False";
                            PA_Status5="False";
                            health_quote();
                            strpersonal_under_spinner2="No";
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first chota ,second third four bde
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            stroneChildPersonal_under_spinner2="No";
                            PA_Status2="False";
                            health_quote();
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                        }
                        //first third four bde second chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your Second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            PA_Status3="False";
                            strtwoChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                        }
                        //first second four bda and third chota
                        else if ((selectYearChild > 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            health_quote();
                            PA_Status4="False";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                        }
                        //first,second ,third bda and four chota
                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your fourth Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status5="False";
                            health_quote();
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        //first and second chota third four bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and second Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status3="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);

                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);

                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first second third chota and fourth bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first second and third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status3="False";
                            PA_Status4="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first third chota and second and fouth bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and third Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status4="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        }
                        //first and fourth chota second and third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first and fourth Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status5="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        //first second fourth chota and third bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first, second and fourth Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status3="False";
                            PA_Status5="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        //first third and fourth chota second bda
                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour < 5)){
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your first third and fourth Child can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status4="False";
                            PA_Status5="False";
                            health_quote();
                            stroneChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";
                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                        }
                        else {
                            Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                            PA_Status2="False";
                            PA_Status3="False";
                            PA_Status4="False";
                            PA_Status5="False";
                            health_quote();
                            strpersonal_under_spinner2="No";
                            stroneChildPersonal_under_spinner2="No";
                            strtwoChildPersonal_under_spinner2="No";
                            strthirdChildPersonal_under_spinner2="No";
                            strfourChildPersonal_under_spinner2="No";

                            personal_under_spinner2.setVisibility(View.VISIBLE);
                            personal_under_spinner2Edit.setVisibility(View.GONE);
                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                        }
                    }
                    else{
                        Toast.makeText(Medical_Complete_health.this, "Age is below 5 So Your children's can't take any add-on’s", Toast.LENGTH_SHORT).show();
                        PA_Status2="False";
                        PA_Status3="False";
                        PA_Status4="False";
                        PA_Status5="False";
                        health_quote();
                        strpersonal_under_spinner2="No";
                        stroneChildPersonal_under_spinner2="No";
                        strtwoChildPersonal_under_spinner2="No";
                        strthirdChildPersonal_under_spinner2="No";
                        strfourChildPersonal_under_spinner2="No";

                        personal_under_spinner2.setVisibility(View.VISIBLE);
                        personal_under_spinner2Edit.setVisibility(View.GONE);
                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                        personal_under_spinner2.setText(strpersonal_under_spinner2);
                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);

                    }


                }
            }
        }

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Medical_Complete_health.this);
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

                ESaleTxt.setText(ESaleDiscount);

//                if(PD_Status.equals("False")){
//                    ESaleDiscount="110.00";
//                    ESaleTxt.setText(ESaleDiscount);
//                }else{
//                    ESaleDiscount="110.00";
//                    ESaleTxt.setText(ESaleDiscount);
//                }

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

        criticalLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items = new ArrayList<String>();items.add("100000");items.add("200000");items.add("300000");items.add("400000");items.add("500000");items.add("600000");items.add("700000");items.add("800000");items.add("900000");items.add("1000000");
                singlePicker.setPicker(items);singlePicker.setCyclic(false);singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strCriticalIllness=items.get(options1);editSumInsured.setText(strCriticalIllness); }});singlePicker.show(); }});
        PADropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> itemsPA = new ArrayList<String>();
                itemsPA.add("100000");itemsPA.add("200000");itemsPA.add("300000");itemsPA.add("400000");itemsPA.add("500000");itemsPA.add("600000");itemsPA.add("700000");itemsPA.add("800000");itemsPA.add("900000");itemsPA.add("1000000");
                singlePicker.setPicker(itemsPA);singlePicker.setCyclic(false);singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        streditPASpinner=itemsPA.get(options1);
                        editPASpinner.setText(streditPASpinner);
                        if(str_policyType_spinner.equals("Individual")){
                            amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                            peronalAccidentEdit.setText(String.valueOf(amountPersonalSumInsured));
                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured)); }
                        else{
                            if (str_IndividualTypeEdit.equals("2 Adult")) {
                                amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                                str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured+amountPersonalSumInsured);
                                peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            }
                            else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                               double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
                               peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                               personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                               OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            } else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                               double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                               peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                               personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                               OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                               twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                          }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                               double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                               peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                               personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                               OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                               twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                               thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                               double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                               peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                               personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                               SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                               OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                           }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                                amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                                peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                                personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                                peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                                personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                amountPersonalSumInsured=IndividualHealthCalculate(str_age,str_SumInsured,streditPASpinner,getApplicationContext());
                                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
                                peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                                personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                                fourChildPersonalEdit.setText(str_fourNameEdit+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
                            }
                        }
                    }
                });
                singlePicker.show();*/

            }
        });
        criticalDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items = new ArrayList<String>();
                items.add("100000");
                items.add("200000");
                items.add("300000");
                items.add("400000");
                items.add("500000");
                items.add("600000");
                items.add("700000");
                items.add("800000");
                items.add("900000");
                items.add("1000000");
                singlePicker.setPicker(items);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strCriticalIllness=items.get(options1);
                        editSumInsured.setText(strCriticalIllness);
                        if(str_policyType_spinner.equals("Individual")){
                            strcriticalEdit= CriticalIllnessCalculate(str_age,str_SumInsured,strCriticalIllness,getApplicationContext());
                            criticalEdit.setText(strcriticalEdit);
                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                        }else {
                            if (str_IndividualTypeEdit.equals("2 Adult")) {
                                editSumInsured.setText(strCriticalIllness);
                                editPersonalAccident.setText(str_SumInsured);
                                editPASpinner.setText(str_SumInsured);
                                strcriticalEdit = CriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit));
                                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                                criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
                                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
                            }
                            else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")) {
                                editSumInsured.setText(strCriticalIllness);
                                editPersonalAccident.setText(str_SumInsured);
                                editPASpinner.setText(str_SumInsured);
                                strcriticalEdit = CriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                strOneChildCriticalIllnessTxt = ChildCriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());

                                int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
                                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                                criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
                                OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }
                            else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                editSumInsured.setText(strCriticalIllness);
                                editPersonalAccident.setText(str_SumInsured);
                                strcriticalEdit = CriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                strOneChildCriticalIllnessTxt = ChildCriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }
                            else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                editSumInsured.setText(strCriticalIllness);
                                editPersonalAccident.setText(str_SumInsured);
                                strcriticalEdit = CriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                strOneChildCriticalIllnessTxt = ChildCriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }
                            else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                editSumInsured.setText(strCriticalIllness);
                                editPersonalAccident.setText(str_SumInsured);
                                strcriticalEdit = CriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                strOneChildCriticalIllnessTxt = ChildCriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }
                            else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                                editSumInsured.setText(strCriticalIllness);
                                editPersonalAccident.setText(str_SumInsured);
                                strcriticalEdit = CriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                strOneChildCriticalIllnessTxt = ChildCriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }
                            else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                editSumInsured.setText(strCriticalIllness);
                                editPersonalAccident.setText(str_SumInsured);
                                strcriticalEdit = CriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                strOneChildCriticalIllnessTxt = ChildCriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }
                            else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                editSumInsured.setText(strCriticalIllness);
                                editPersonalAccident.setText(str_SumInsured);
                                strcriticalEdit = CriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                strOneChildCriticalIllnessTxt = ChildCriticalIllnessCalculate(str_age, str_SumInsured, strCriticalIllness, getApplicationContext());
                                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
                                criticalEdit.setText(String.valueOf(add_strcriticalEdit));
                                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                fourChildCriticalIllnessTxt.setText(str_fourNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }


                        } }});singlePicker.show();*/
            }});
        personalAccidentLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("100000");
                items1.add("200000");
                items1.add("300000");
                items1.add("400000");
                items1.add("500000");
                items1.add("600000");
                items1.add("700000");
                items1.add("800000");
                items1.add("900000");
                items1.add("1000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        //  singleTVOptions.setText("Single Picker " + items.get(options1));

                        strCriticalUnderSpinner=items1.get(options1);
                        editPersonalAccident.setText(strCriticalUnderSpinner);
                        Toast.makeText(getApplicationContext(), "" + items1.get(options1), Toast.LENGTH_SHORT).show();


                    }
                });
                singlePicker.show();

            }
        });
        sub_limit_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Sub Limit Not Selected");
                items1.add("Sub Limit-A");
                items1.add("Sub Limit-B");
                items1.add("Sub Limit-C");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSubLimit=items1.get(options1);
                        sub_limit_spinner.setText(strSubLimit);
                        discountTxt.setText("(What is Sub-Limit (upto 10% Discount))");
                        if (strSubLimit.equals("Sub Limit-A")) {
                            discountTxt.setText("(What is Sub-Limit (upto 10% Discount))");
                            Sub_Type="A";
                            Sub_Status="True";
                            health_quote();
                        }else if (strSubLimit.equals("Sub Limit-B")) {
                            discountTxt.setText("(What is Sub-Limit (upto 5% Discount))");
                            Sub_Type="B";
                            Sub_Status="True";
                            health_quote();
                        }else if (strSubLimit.equals("Sub Limit-C")) {
                            discountTxt.setText("(What is Sub-Limit (upto 5% Discount))");
                            Sub_Type="C";
                            Sub_Status="True";
                            health_quote();
                        }else {
                            subLimitAmount.setText("0");
                        }
                    }
                });
                singlePicker.show();

            }
        });
        treatment_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
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
                        strAnyTreatment=items1.get(options1);
                        treatment_spinner.setText(strAnyTreatment);
                        if (strAnyTreatment.equals("Yes")) {
                            Tiered_Status="True";
                            health_quote();
                            discountedit.setText(strDiscount);
                        }else {
                            Tiered_Status="False";
                            health_quote();
                        }
                    }
                });
                singlePicker.show();

            }
        });
        Critical_under_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strCriticalUnderSpinner = String.valueOf(yesNo[i]);
                if (strCriticalUnderSpinner.equals("Yes")) {
                    criticalLiner.setVisibility(View.VISIBLE);
                    criticalSpinnerLiner.setVisibility(View.VISIBLE);
                }else {
                    criticalLiner.setVisibility(View.GONE);
                    criticalSpinnerLiner.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Critical_illness_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strCriticalIllness = String.valueOf(amount[i]); }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        criticalSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strCriticalUnderSpinner2=items1.get(options1);
                        Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                        if (strCriticalUnderSpinner2.equals("No")){
                            if (str_policyType_spinner.equals("Individual")){
                                CI_Status="False";
                                strCriticalUnderSpinner2="No";
                                Critical_under_spinner2.setText(strCriticalUnderSpinner2);

                                health_quote();
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+"0.0");
//                        criticalEdit.setText("0.0");
                            } else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    CI_Status="False";
                                    CI_Status1="False";
                                    strCriticalUnderSpinner2="No";
                                    strsecondAdultCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                                    health_quote();
                                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);

//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            criticalEdit.setText("0.0");
                                } else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    CI_Status="False";
                                    CI_Status2="False";
                                    strCriticalUnderSpinner2="No";
                                    strsOneChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                                    health_quote();
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            criticalEdit.setText("0.0");
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    CI_Status="False";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    strCriticalUnderSpinner2="No";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                                    health_quote();
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            criticalEdit.setText("0.0");
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    CI_Status="False";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    CI_Status4="False";
                                    strCriticalUnderSpinner2="No";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    strthirdChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                                    thirdChildCritical_under_spinner2Edit.setText(strthirdChildCritical_under_spinner2);

                                    health_quote();
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    thirdChildCritical_under_spinner2.setVisibility(View.GONE);
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+"0.0");
//                    criticalEdit.setText("0.0");
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    CI_Status="False";
                                    CI_Status1="False";
                                    CI_Status2="False";
                                    strCriticalUnderSpinner2="No";
                                    strsecondAdultCritical_under_spinner2="No";
                                    strsOneChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);

                                    health_quote();
                                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                          criticalEdit.setText("0.0");
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    CI_Status="False";
                                    CI_Status1="False";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    strCriticalUnderSpinner2="No";
                                    strsecondAdultCritical_under_spinner2="No";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);

                                    health_quote();
                                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
//                            criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + "0.0");
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + "0.0");
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + "0.0");
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName + " is covered under Critical Illness for Rs. " + "0.0");
//                         criticalEdit.setText("0.0");
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    CI_Status="False";
                                    CI_Status1="False";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    CI_Status4="False";
                                    strCriticalUnderSpinner2="No";
                                    strsecondAdultCritical_under_spinner2="No";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    strthirdChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                                    thirdChildCritical_under_spinner2Edit.setText(strthirdChildCritical_under_spinner2);
                                    health_quote();

//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+"0.0");
                                    secondAdultCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    secondAdultCritical_under_spinner2.setVisibility(View.GONE);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.GONE);
                                    twoChildCritical_under_spinner2.setVisibility(View.GONE);
                                    twoChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    thirdChildCritical_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    thirdChildCritical_under_spinner2.setVisibility(View.GONE);
//                            criticalEdit.setText("0.0");
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    CI_Status="False";
                                    CI_Status1="False";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    CI_Status4="False";
                                    CI_Status5="False";
                                    strCriticalUnderSpinner2="No";
                                    strsecondAdultCritical_under_spinner2="No";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    strthirdChildCritical_under_spinner2="No";
                                    strfourChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2Edit.setText(strsecondAdultCritical_under_spinner2);
                                    OneChildCritical_under_spinner2Edit.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2Edit.setText(strtwoChildCritical_under_spinner2);
                                    thirdChildCritical_under_spinner2Edit.setText(strthirdChildCritical_under_spinner2);
                                    fourChildCritical_under_spinner2Edit.setText(strfourChildCritical_under_spinner2);

                                    health_quote();
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+"0.0");
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+"0.0");
//                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+"0.0");
//                            fourChildCriticalIllnessTxt.setText(str_fourNameEdit+" is covered under Critical Illness for Rs. "+"0.0");
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
//                            criticalEdit.setText("0.0");
                                }
                            }
                        }
                        else{
                            if (str_policyType_spinner.equals("Individual")){
                                CI_Status="True";
                                strCriticalUnderSpinner2="Yes";
                                Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                health_quote();
//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit));
//                        criticalEdit.setText(strcriticalEdit);
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                            }else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    CI_Status="True";
                                    CI_Status1="False";
                                    strCriticalUnderSpinner2="Yes";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    strsecondAdultCritical_under_spinner2="No";
                                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                    health_quote();
//                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit));
//                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
                                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    CI_Status="True";
                                    CI_Status2="False";
                                    strCriticalUnderSpinner2="Yes";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    strsOneChildCritical_under_spinner2="No";
                                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                    health_quote();


//                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    CI_Status="True";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    strCriticalUnderSpinner2="Yes";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                    health_quote();
//                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    CI_Status="True";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    CI_Status4="False";
                                    strCriticalUnderSpinner2="Yes";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    strthirdChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                    thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                                    health_quote();

//                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    thirdChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    thirdChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    CI_Status="True";
                                    CI_Status1="False";
                                    CI_Status2="False";
                                    strCriticalUnderSpinner2="Yes";
                                    strsecondAdultCritical_under_spinner2="No";
                                    strsOneChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                    health_quote();
//                           int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    CI_Status="True";
                                    CI_Status1="False";
                                    CI_Status2="False";
                                    CI_Status3="False";

                                    strCriticalUnderSpinner2="Yes";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    strsecondAdultCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                    health_quote();
//                            int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt) + Integer.parseInt(strOneChildCriticalIllnessTxt));
//                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                            criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    CI_Status="True";
                                    CI_Status1="False";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    CI_Status4="False";
                                    strCriticalUnderSpinner2="Yes";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    strthirdChildCritical_under_spinner2="No";
                                    strsecondAdultCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                    thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                                    health_quote();
//                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    secondAdultCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    secondAdultCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    OneChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    sOneChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    thirdChildCritical_under_spinner2Edit.setVisibility(View.GONE);
                                    thirdChildCritical_under_spinner2.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    CI_Status="True";
                                    CI_Status1="False";
                                    CI_Status2="False";
                                    CI_Status3="False";
                                    CI_Status4="False";
                                    CI_Status5="False";
                                    strCriticalUnderSpinner2="Yes";
                                    strsOneChildCritical_under_spinner2="No";
                                    strtwoChildCritical_under_spinner2="No";
                                    strthirdChildCritical_under_spinner2="No";
                                    strsecondAdultCritical_under_spinner2="No";
                                    strfourChildCritical_under_spinner2="No";
                                    Critical_under_spinner2.setText(strCriticalUnderSpinner2);
                                    secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                    sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                    twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                    thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                                    fourChildCritical_under_spinner2.setText(strfourChildCritical_under_spinner2);
                                    health_quote();
//                            int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                            criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                            criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                            OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                            twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                            thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                            fourChildCriticalIllnessTxt.setText(str_fourNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
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
                });
                singlePicker.show(); }
        });
        secondAdultCritical_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strsecondAdultCritical_under_spinner2=items1.get(options1);
                        secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                        if (strsecondAdultCritical_under_spinner2.equals("No")){
                            if (str_IndividualTypeEdit.equals("2 Adult")){
                                CI_Status1="False";
                                strsecondAdultCritical_under_spinner2="No";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")) {
                                CI_Status1="False";
                                strsecondAdultCritical_under_spinner2="No";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                CI_Status1="False";
                                strsecondAdultCritical_under_spinner2="No";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                CI_Status1="False";
                                strsecondAdultCritical_under_spinner2="No";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                CI_Status1="False";
                                strsecondAdultCritical_under_spinner2="No";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }
                        }else{
                            if (str_IndividualTypeEdit.equals("2 Adult")){
                                CI_Status1="True";
                                strsecondAdultCritical_under_spinner2="Yes";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")) {
                                CI_Status1="True";
                                strsecondAdultCritical_under_spinner2="Yes";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();
//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                CI_Status1="True";
                                strsecondAdultCritical_under_spinner2="Yes";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                CI_Status1="True";
                                strsecondAdultCritical_under_spinner2="Yes";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();
//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                CI_Status1="True";
                                strsecondAdultCritical_under_spinner2="Yes";
                                secondAdultCritical_under_spinner2.setText(strsecondAdultCritical_under_spinner2);
                                health_quote();
//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }


                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerOneChildCritical_under_spinner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strsOneChildCritical_under_spinner2=items1.get(options1);
                        sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                        if (strsOneChildCritical_under_spinner2.equals("No")) {
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                CI_Status2="False";
                                strsOneChildCritical_under_spinner2="No";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                CI_Status2="False";
                                strsOneChildCritical_under_spinner2="No";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                CI_Status2="False";
                                strsOneChildCritical_under_spinner2="No";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();
                            }
                            else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")) {
                                CI_Status2="False";
                                strsOneChildCritical_under_spinner2="No";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                CI_Status2="False";
                                strsOneChildCritical_under_spinner2="No";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                CI_Status2="False";
                                strsOneChildCritical_under_spinner2="No";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                CI_Status2="False";
                                strsOneChildCritical_under_spinner2="No";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }
                        }else {
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                CI_Status2="True";
                                strsOneChildCritical_under_spinner2="Yes";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();
                            } if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                CI_Status2="True";
                                strsOneChildCritical_under_spinner2="Yes";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();
                            } if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                CI_Status2="True";
                                strsOneChildCritical_under_spinner2="Yes";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();
                            }
                            else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                CI_Status2="True";
                                strsOneChildCritical_under_spinner2="Yes";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                                CI_Status2="True";
                                strsOneChildCritical_under_spinner2="Yes";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                CI_Status2="True";
                                strsOneChildCritical_under_spinner2="Yes";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                CI_Status2="True";
                                strsOneChildCritical_under_spinner2="Yes";
                                sOneChildCritical_under_spinner2.setText(strsOneChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        twoChildCritical_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strtwoChildCritical_under_spinner2=items1.get(options1);
                        twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                        if (strtwoChildCritical_under_spinner2.equals("No")) {
                             if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                CI_Status3="False";
                                strtwoChildCritical_under_spinner2="No";
                                 twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                 CI_Status3="False";
                                strtwoChildCritical_under_spinner2="No";
                                 twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                 CI_Status3="False";
                                strtwoChildCritical_under_spinner2="No";
                                 twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                 CI_Status3="False";
                                strtwoChildCritical_under_spinner2="No";
                                 twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                 CI_Status3="False";
                                strtwoChildCritical_under_spinner2="No";
                                 twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit) + Integer.parseInt(strcriticalEdit) + Integer.parseInt(strOneChildCriticalIllnessTxt));
////                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName + " is covered under Critical Illness for Rs. " + strOneChildCriticalIllnessTxt);
                            }
                        }else {
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                CI_Status3="True";
                                strtwoChildCritical_under_spinner2="Yes";
                                twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();
                            }
                            else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                CI_Status3="True";
                                strtwoChildCritical_under_spinner2="Yes";
                                twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            } else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                CI_Status3="True";
                                strtwoChildCritical_under_spinner2="Yes";
                                twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }  else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                CI_Status3="True";
                                strtwoChildCritical_under_spinner2="Yes";
                                twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                                CI_Status3="True";
                                strtwoChildCritical_under_spinner2="Yes";
                                twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                CI_Status3="True";
                                strtwoChildCritical_under_spinner2="Yes";
                                twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                CI_Status3="True";
                                strtwoChildCritical_under_spinner2="Yes";
                                twoChildCritical_under_spinner2.setText(strtwoChildCritical_under_spinner2);
                                health_quote();

//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                                OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        thirdChildCritical_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strthirdChildCritical_under_spinner2=items1.get(options1);
                        thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                        if (strthirdChildCritical_under_spinner2.equals("No")) {
                            if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                CI_Status4="False";
                                strthirdChildCritical_under_spinner2="No";
                                thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                                health_quote();
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                CI_Status4="False";
                                strthirdChildCritical_under_spinner2="No";
                                thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                                health_quote();


//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+0);
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                        twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                        thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+"0.0");
                            }
                        }
                        else {
                            if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                CI_Status4="True";
                                strthirdChildCritical_under_spinner2="Yes";
                                thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                                health_quote();
                            }
                            else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                CI_Status4="True";
                                strthirdChildCritical_under_spinner2="Yes";
                                thirdChildCritical_under_spinner2.setText(strthirdChildCritical_under_spinner2);
                                health_quote();
//                        int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                        criticalEdit.setText(String.valueOf(add_strcriticalEdit));
//                        criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEdit);
//                        OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                        twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
//                        thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        fourChildCritical_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strfourChildCritical_under_spinner2=items1.get(options1);
                        fourChildCritical_under_spinner2.setText(strfourChildCritical_under_spinner2);
                        if (strfourChildCritical_under_spinner2.equals("No")) {
                            if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                CI_Status5="False";
                                strfourChildCritical_under_spinner2="No";
                                fourChildCritical_under_spinner2.setText(strfourChildCritical_under_spinner2);
                                health_quote();
                            }
                        }else {
                           if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                CI_Status5="True";
                               strfourChildCritical_under_spinner2="Yes";
                               fourChildCritical_under_spinner2.setText(strfourChildCritical_under_spinner2);
                                health_quote();
                            }}
                    }
                });
                singlePicker.show(); }
        });

        personalUnder_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strpersonalUnder_spinner=items1.get(options1);
                        personalUnder_spinner.setText(strpersonalUnder_spinner);
                        if (strpersonalUnder_spinner.equals("No")){
                            if (str_policyType_spinner.equals("Individual")){
                                PA_Status="False";
                                health_quote();
                            }else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    PA_Status="False";
                                    PA_Status1="False";
                                    health_quote();
                                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    personal_under_spinner2.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    PA_Status="False";
                                    PA_Status2="False";
                                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    health_quote();
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    PA_Status="False";
                                    PA_Status2="False";
                                    PA_Status3="False";
                                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    health_quote();
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    PA_Status="False";
                                    PA_Status2="False";
                                    PA_Status3="False";
                                    PA_Status4="False";
                                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    health_quote();
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    PA_Status="False";
                                    PA_Status1="False";
                                    PA_Status2="False";
                                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    personal_under_spinner2.setVisibility(View.GONE);
                                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    health_quote();
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    PA_Status="False";
                                    PA_Status1="False";
                                    PA_Status2="False";
                                    PA_Status3="False";
                                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    personal_under_spinner2.setVisibility(View.GONE);
                                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    health_quote();
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    PA_Status="False";
                                    PA_Status1="False";
                                    PA_Status2="False";
                                    PA_Status3="False";
                                    PA_Status4="False";
                                    personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    personal_under_spinner2.setVisibility(View.GONE);
                                    oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                    thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                    health_quote();
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    PA_Status="False";
                                    PA_Status1="False";
                                    PA_Status2="False";
                                    PA_Status3="False";
                                    PA_Status4="False";
                                    PA_Status5="False";
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
                                    health_quote();
                                }
                            }
                        }
                        else{
                            if (str_policyType_spinner.equals("Individual")){
                                PA_Status="True";
                                health_quote();
                            }else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    PA_Status="True";
                                    PA_Status1="False";
                                    health_quote();
                                    strpersonal_under_spinner2="No";
                                    personal_under_spinner2.setText(strpersonal_under_spinner2);
                                    personal_under_spinner2Edit.setVisibility(View.GONE);
                                    personal_under_spinner2.setVisibility(View.VISIBLE);
                                }
                                else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    if (strChildOne!= null){
                                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                                        if (selectYearChild >= 5 ) {
                                            PA_Status="True";
                                            PA_Status2="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            stroneChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        }else{
                                            PA_Status="True";
                                            PA_Status2="False";
                                            health_quote();
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                    }
                                }
                                else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    if ((strChildOne!= null) && (strChildTwo!= null)) {
                                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                                        if ((selectYearChild >= 5) && selectYearChildTwo >= 5) {
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            health_quote();
                                        }
                                        else if ((selectYearChild < 5) && selectYearChildTwo >= 5) {
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            health_quote();
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2 = "No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);

                                        }
                                        else if ((selectYearChild >= 5) && selectYearChildTwo < 5) {
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2 = "No";
                                            strtwoChildPersonal_under_spinner2 = "No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);

                                        }
                                        else{
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            health_quote();
                                            stroneChildPersonal_under_spinner2 = "No";
                                            strtwoChildPersonal_under_spinner2 = "No";
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        }
                                    }
                                }
                                else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                                         //all bde
                                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                       //all chote
                                       else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5))  {
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                       }
                                        //first chota second bda,third bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                       //first bda,second chota,third bda
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //first  bda,second bda ,third chota
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                        //first and third chota second bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //first and second chota third bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //first bda and second third chota
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        else {
                                            PA_Status="True";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";

                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);

                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                    }
                                }
                                else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    strpersonal_under_spinner2="No";
                                    personal_under_spinner2Edit.setVisibility(View.GONE);
                                    personal_under_spinner2.setVisibility(View.VISIBLE);
                                    personal_under_spinner2.setText(strpersonal_under_spinner2);
                                    if (strChildOne!= null){
                                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                                        if (selectYearChild >= 5 ) {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        }
                                        else{
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            health_quote();
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                    }else{
                                        PA_Status="True";
                                        PA_Status1="False";
                                        PA_Status2="False";
                                        strpersonal_under_spinner2="No";
                                        health_quote();
                                        personal_under_spinner2.setText(strpersonal_under_spinner2);
                                        stroneChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        personal_under_spinner2Edit.setVisibility(View.GONE);
                                        personal_under_spinner2.setVisibility(View.VISIBLE);
                                    }
//                            personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                            SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                            OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                            peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
                                }
                                else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    if ((strChildOne!= null) && (strChildTwo!= null)) {
                                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                                        if ((selectYearChild >= 5) && selectYearChildTwo >= 5) {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        }
                                       else if ((selectYearChild < 5) && selectYearChildTwo < 5) {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                       }
                                       else if ((selectYearChild < 5) && selectYearChildTwo >= 5) {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            health_quote();
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2 = "No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);

                                        }
                                        else if ((selectYearChild >= 5) && selectYearChildTwo < 5) {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            health_quote();
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2 = "No";
                                            strtwoChildPersonal_under_spinner2 = "No";
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);

                                        }
                                        else{
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            health_quote();
                                            personal_under_spinner2Edit.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setVisibility(View.GONE);
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2Edit.setText(strpersonal_under_spinner2);
                                            stroneChildPersonal_under_spinner2 = "No";
                                            strtwoChildPersonal_under_spinner2 = "No";
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    else{
                                        PA_Status="True";
                                        PA_Status1="False";
                                        PA_Status2="False";
                                        PA_Status3="False";
                                        health_quote();
                                        strpersonal_under_spinner2="Yes";
                                        stroneChildPersonal_under_spinner2 = "No";
                                        strtwoChildPersonal_under_spinner2 = "No";
                                        personal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        personal_under_spinner2Edit.setVisibility(View.GONE);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                        personal_under_spinner2.setText(strpersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                    }
                                }
                                else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                                        //all bde
                                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //all chote
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5))  {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);

                                        }
                                        //first chota second bda,third bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //first bda,second chota,third bda
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //first  bda,second bda ,third chota
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //first and third chota second bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //first and second chota third bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        //first bda and second third chota
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                        }
                                        else {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            health_quote();
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";

                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);

                                            strpersonal_under_spinner2="No";
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                    }
                                }
                                else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null) && (strChildFour!= null)){
                                        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                                        int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                                        int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                                        int dateValidation4 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildFour);
                                        //all bde
                                        if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5) && (selectYearChildFour >= 5))  {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);

                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                        }
                                        //all chote
                                       else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5) && (selectYearChildFour < 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                        }
                                       //first chota ,second third four bde
                                       else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                        }
                                       //first third four bde second chota
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                        }
                                        //first second four bda and third chota
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                        }
                                        //first,second ,third bda and four chota
                                        else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                            oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                        //first and second chota third four bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);

                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);

                                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        }
                                        //first second third chota and fourth bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        }
                                        //first third chota and second and fouth bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);

                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        }
                                        //first and fourth chota second and third bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                        //first second fourth chota and third bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setAlpha(0.5f);
                                            thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                        //first third and fourth chota second bda
                                        else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour < 5)){
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";
                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setAlpha(0.5f);
                                            twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                            fourChildPersonal_under_Edit.setAlpha(0.5f);
                                        }
                                        else {
                                            PA_Status="True";
                                            PA_Status1="False";
                                            PA_Status2="False";
                                            PA_Status3="False";
                                            PA_Status4="False";
                                            PA_Status5="False";
                                            health_quote();
                                            strpersonal_under_spinner2="No";
                                            stroneChildPersonal_under_spinner2="No";
                                            strtwoChildPersonal_under_spinner2="No";
                                            strthirdChildPersonal_under_spinner2="No";
                                            strfourChildPersonal_under_spinner2="No";

                                            personal_under_spinner2.setVisibility(View.VISIBLE);
                                            personal_under_spinner2Edit.setVisibility(View.GONE);
                                            oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                            fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                            fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                                            personal_under_spinner2.setText(strpersonal_under_spinner2);
                                            oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                            twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                            thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                            fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                        }
                                    }
                                    else{
                                        PA_Status="True";
                                        PA_Status1="False";
                                        PA_Status2="False";
                                        PA_Status3="False";
                                        PA_Status4="False";
                                        PA_Status5="False";
                                        health_quote();
                                        strpersonal_under_spinner2="No";
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="No";
                                        strthirdChildPersonal_under_spinner2="No";
                                        strfourChildPersonal_under_spinner2="No";

                                        personal_under_spinner2.setVisibility(View.VISIBLE);
                                        personal_under_spinner2Edit.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                                        personal_under_spinner2.setText(strpersonal_under_spinner2);
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                        thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                        fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);

                                    }
                                }
                            } }
                    }
                });
                singlePicker.show(); }
        });
        personal_under_spinner2EditLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strpersonal_under_spinner2=items1.get(options1);
                        personal_under_spinner2.setText(strpersonal_under_spinner2);
                        if (strpersonal_under_spinner2.equals("No")){
                            if (str_IndividualTypeEdit.equals("2 Adult")){
                                PA_Status1="False";
                                health_quote();
                                strpersonal_under_spinner2="No";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                PA_Status1="False";
                                health_quote();
                                strpersonal_under_spinner2="No";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                PA_Status1="False";
                                health_quote();
                                strpersonal_under_spinner2="No";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                PA_Status1="False";
                                health_quote();
                                strpersonal_under_spinner2="No";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                PA_Status1="False";
                                health_quote();
                                strpersonal_under_spinner2="No";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            } }
                        else{
                            if (str_IndividualTypeEdit.equals("2 Adult")){
                                PA_Status1="True";
                                health_quote();
                                strpersonal_under_spinner2="Yes";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                PA_Status1="True";
                                health_quote();
                                strpersonal_under_spinner2="Yes";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                PA_Status1="True";
                                health_quote();
                                strpersonal_under_spinner2="Yes";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                PA_Status1="True";
                                health_quote();
                                strpersonal_under_spinner2="Yes";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                PA_Status1="True";
                                health_quote();
                                strpersonal_under_spinner2="Yes";
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                            } }
                    }
                });
                singlePicker.show();
            }
        });
        oneChildPersonal_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        stroneChildPersonal_under_spinner2=items1.get(options1);
                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                        if (strChildOne!= null){
                            int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                            if (selectYearChild >= 5 ) {
                                if (stroneChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                        PA_Status2="False";
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                    else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")) {
                                        PA_Status2="False";
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                    else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        PA_Status2="False";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);

                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")) {
                                        PA_Status2="False";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                        PA_Status2="False";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                        PA_Status2="False";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status2="False";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    } }
                                else{
                                    if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                        PA_Status2="True";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")) {
                                        PA_Status2="True";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    }
                                    else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        PA_Status2="True";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                        PA_Status2="True";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                        PA_Status2="True";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                        PA_Status2="True";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status2="True";
                                        health_quote();
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        stroneChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                    } }
                            }
                            else{
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                stroneChildPersonal_under_spinner2="No";
                                PA_Status2="False";
                                health_quote();
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                            }

                        }

                    }
                });
                singlePicker.show();
            }
        });
        twoChildPersonal_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strtwoChildPersonal_under_spinner2=items1.get(options1);
                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                        if ((strChildOne!= null) && (strChildTwo!= null)){
                            int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                            int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                            if ((selectYearChild >= 5 )&& selectYearChildTwo >= 5) {
                                if (strtwoChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")) {
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    } }
                                else{
                                    if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")) {
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }
                                    else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    } }
                            }
                            else if ((selectYearChild < 5 )&& selectYearChildTwo >= 5){
                                if (strtwoChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")) {
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);

                                    }
                                    else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status3="False";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="No";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    } }
                                else{
                                    if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")) {
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }
                                    else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status3="True";
                                        health_quote();
                                        oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                        stroneChildPersonal_under_spinner2="No";
                                        strtwoChildPersonal_under_spinner2="Yes";
                                        oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                        twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                        oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                        oneChildPersonal_under_Edit.setAlpha(0.5f);
                                        twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                        twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                    } }
                            }
                            else if ((selectYearChild >= 5 )&& selectYearChildTwo < 5){
                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                strtwoChildPersonal_under_spinner2="No";
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                PA_Status3="False";
                                health_quote();
                            } else {
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                stroneChildPersonal_under_spinner2="No";
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                strtwoChildPersonal_under_spinner2="No";
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                PA_Status3="False";
                                PA_Status2="False";
                                health_quote();

//                        double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                        str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//                        double personalSumInsured= amountPersonalSumInsured;
//                        peronalAccidentEdit.setText(String.valueOf(personalSumInsured));
//                        personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+String.valueOf(amountPersonalSumInsured));
//                        OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+"0.0");
//                        twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+"0.0");
                            } }

                    }
                });
                singlePicker.show();
            }
        });
        thirdChildPersonal_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strthirdChildPersonal_under_spinner2=items1.get(options1);
                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                        if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null)){
                            int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                            int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                            int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);

                            //all bde
                            if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5))  {
                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                if (strthirdChildPersonal_under_spinner2.equals("No")) {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }
                                }
                                else {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }

                                }
                            }
                            //all chote
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5))  {
                                PA_Status="True";
                                PA_Status2="False";
                                PA_Status3="False";
                                PA_Status4="False";
                                health_quote();
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                stroneChildPersonal_under_spinner2="No";
                                strtwoChildPersonal_under_spinner2="No";
                                strthirdChildPersonal_under_spinner2="No";
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setAlpha(0.5f);
                            }
                            //first chota second bda,third bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)){
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                stroneChildPersonal_under_spinner2="No";
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                if (strthirdChildPersonal_under_spinner2.equals("No")) {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }
                                }
                                else {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }

                                }
                            }
                            //first bda,second chota,third bda
                            else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                strtwoChildPersonal_under_spinner2="No";
                                oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                if (strthirdChildPersonal_under_spinner2.equals("No")) {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }
                                }
                                else {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }

                                }
                            }
                            //first  bda,second bda ,third chota
                            else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                strthirdChildPersonal_under_spinner2="No";
                                oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                if (strthirdChildPersonal_under_spinner2.equals("No")) {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }
                                }
                            }
                            //first and third chota second bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)){
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                stroneChildPersonal_under_spinner2="No";
                                strthirdChildPersonal_under_spinner2="No";
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                if (strthirdChildPersonal_under_spinner2.equals("No")) {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }
                                }
                            }
                            //first and second chota third bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)){
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                stroneChildPersonal_under_spinner2="No";
                                strtwoChildPersonal_under_spinner2="No";
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                if (strthirdChildPersonal_under_spinner2.equals("No")) {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }
                                }
                                else {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="Yes";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "True";
                                        health_quote();
                                    }

                                }
                            }
                            //first bda and second third chota
                            else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)){
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                strtwoChildPersonal_under_spinner2="No";
                                strthirdChildPersonal_under_spinner2="No";
                                oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                if (strthirdChildPersonal_under_spinner2.equals("No")) {
                                    if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                        strthirdChildPersonal_under_spinner2="No";
                                        thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                        PA_Status4 = "False";
                                        health_quote();
                                    }
                                }
                            }

                        }

                    }
                });
                singlePicker.show();
            }
        });
        fourChildPersonal_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strfourChildPersonal_under_spinner2=items1.get(options1);
                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                        if ((strChildOne!= null) && (strChildTwo!= null) && (strChildThree!= null) && (strChildFour!= null)){
                            int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
                            int dateValidation1 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                            int dateValidation3 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
                            int dateValidation4 = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildFour);
                            //all bde
                            if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5) && (selectYearChildFour >= 5))  {
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);

                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                                else{
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="True";
                                        strfourChildPersonal_under_spinner2="Yes";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }


                            }
                            //all chote
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5) && (selectYearChildThird < 5) && (selectYearChildFour < 5)){
                                stroneChildPersonal_under_spinner2="No";
                                strtwoChildPersonal_under_spinner2="No";
                                strthirdChildPersonal_under_spinner2="No";
                                strfourChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                                fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status="True";
                                        PA_Status2="False";
                                        PA_Status3="False";
                                        PA_Status4="False";
                                        PA_Status5="False";
                                        health_quote();
                                    }
                                }
                                else{
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status="True";
                                        PA_Status2="False";
                                        PA_Status3="False";
                                        PA_Status4="False";
                                        PA_Status5="False";
                                        health_quote();
                                    }
                                }

                            }
                            //first chota ,second third four bde
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5) && (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                                stroneChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                                else{
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="True";
                                        strfourChildPersonal_under_spinner2="Yes";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }


                            }
                            //first third four bde second chota
                            else if ((selectYearChild >= 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                                strtwoChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                                else{
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="True";
                                        strfourChildPersonal_under_spinner2="Yes";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                            }
                            //first second four bda and third chota
                            else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                                strthirdChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                                else{
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="True";
                                        strfourChildPersonal_under_spinner2="Yes";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                            }
                            //first,second ,third bda and four chota
                            else if ((selectYearChild >= 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                                strfourChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                oneChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setVisibility(View.GONE);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                                fourChildPersonal_under_Edit.setAlpha(0.5f);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                            }
                            //first and second chota third four bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour >= 5)){
                                stroneChildPersonal_under_spinner2="No";
                                strtwoChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);

                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);

                                fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                                else{
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="True";
                                        strfourChildPersonal_under_spinner2="Yes";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }

                            }
                            //first second third chota and fourth bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                                stroneChildPersonal_under_spinner2="No";
                                strtwoChildPersonal_under_spinner2="No";
                                strthirdChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                                else{
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="True";
                                        strfourChildPersonal_under_spinner2="Yes";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                            }
                            //first third chota and second and fouth bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour >= 5)){
                                stroneChildPersonal_under_spinner2="No";
                                strthirdChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_spinner2.setVisibility(View.VISIBLE);

                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                                else{
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="True";
                                        strfourChildPersonal_under_spinner2="Yes";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }

                            }
                            //first and fourth chota second and third bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                                strpersonal_under_spinner2="No";
                                stroneChildPersonal_under_spinner2="No";
                                strfourChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                fourChildPersonal_under_Edit.setAlpha(0.5f);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                            }
                            //first second fourth chota and third bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo < 5)&& (selectYearChildThird >= 5)&& (selectYearChildFour < 5)){
                                stroneChildPersonal_under_spinner2="No";
                                strtwoChildPersonal_under_spinner2="No";
                                strfourChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_spinner2.setVisibility(View.GONE);
                                twoChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                thirdChildPersonal_under_Edit.setVisibility(View.GONE);
                                fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_spinner2.setVisibility(View.GONE);

                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_Edit.setText(strtwoChildPersonal_under_spinner2);
                                twoChildPersonal_under_Edit.setAlpha(0.5f);
                                thirdChildPersonal_under_spinner2.setText(strthirdChildPersonal_under_spinner2);
                                fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                fourChildPersonal_under_Edit.setAlpha(0.5f);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                            }
                            //first third and fourth chota second bda
                            else if ((selectYearChild < 5 )&& (selectYearChildTwo >= 5)&& (selectYearChildThird < 5)&& (selectYearChildFour < 5)){
                                stroneChildPersonal_under_spinner2="No";
                                strthirdChildPersonal_under_spinner2="No";
                                strfourChildPersonal_under_spinner2="No";
                                personal_under_spinner2.setVisibility(View.VISIBLE);
                                personal_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildPersonal_under_spinner2.setVisibility(View.GONE);
                                oneChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildPersonal_under_Edit.setVisibility(View.GONE);
                                thirdChildPersonal_under_spinner2.setVisibility(View.GONE);
                                thirdChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_Edit.setVisibility(View.VISIBLE);
                                fourChildPersonal_under_spinner2.setVisibility(View.GONE);
                                personal_under_spinner2.setText(strpersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setText(stroneChildPersonal_under_spinner2);
                                oneChildPersonal_under_Edit.setAlpha(0.5f);
                                twoChildPersonal_under_spinner2.setText(strtwoChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setText(strthirdChildPersonal_under_spinner2);
                                thirdChildPersonal_under_Edit.setAlpha(0.5f);
                                fourChildPersonal_under_Edit.setText(strfourChildPersonal_under_spinner2);
                                fourChildPersonal_under_Edit.setAlpha(0.5f);
                                if (strfourChildPersonal_under_spinner2.equals("No")){
                                    if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                        PA_Status5="False";
                                        strfourChildPersonal_under_spinner2="No";
                                        fourChildPersonal_under_spinner2.setText(strfourChildPersonal_under_spinner2);
                                        health_quote();
                                    }
                                }
                            }
                        }
                    }
                });
                singlePicker.show();
            }
        });

        PersonalAccidentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strPersonalAccidentSpinner = String.valueOf(amount[i]);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        hospital_under_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strhospital_under_spinner=items1.get(options1);
                        hospital_under_spinner.setText(strhospital_under_spinner);
                        if (strhospital_under_spinner.equals("No")){
                            if (str_policyType_spinner.equals("Individual")){
                                DHC_Status="False";
                                strhospital_under_spinner="No";
                                hospital_under_spinner.setText(strhospital_under_spinner);
                                health_quote();
                            } else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    hospital_under_spinner2.setVisibility(View.GONE);
                                    DHC_Status="False";
                                    DHC_Status1="False";
                                    strhospital_under_spinner="No";
                                    strhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                                    health_quote();
//                            hospitalEdit.setText("0.0");
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
                                } else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    DHC_Status="False";
                                    DHC_Status2="False";
                                    strhospital_under_spinner="No";
                                    stroneChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                                    health_quote();
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
//                            hospitalEdit.setText("0.0");
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    DHC_Status="False";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    strhospital_under_spinner="No";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                                    health_quote();
//                            hospitalEdit.setText("0.0");
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                            twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    DHC_Status="False";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    DHC_Status4="False";
                                    strhospital_under_spinner="No";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    strthirdChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                                    thirdChildhospital_under_spinnerEdit.setText(strthirdChildhospital_under_spinner2);
                                    health_quote();
//                            hospitalEdit.setText("0.0");
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                            twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                            thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+"0.0");
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                                    thirdChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    thirdChildhospital_under_spinnerEdit.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    DHC_Status="False";
                                    DHC_Status1="False";
                                    DHC_Status2="False";
                                    strhospital_under_spinner="No";
                                    strhospital_under_spinner2="No";
                                    stroneChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                                    health_quote();
//                            hospitalEdit.setText("0.0");
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
                                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    hospital_under_spinner2.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    DHC_Status="False";
                                    DHC_Status1="False";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    strhospital_under_spinner="No";
                                    strhospital_under_spinner2="No";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);

                                    health_quote();
//                            hospitalEdit.setText("0.0");
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                            twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
                                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    hospital_under_spinner2.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    DHC_Status="False";
                                    DHC_Status1="False";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    DHC_Status4="False";

                                    strhospital_under_spinner="No";
                                    strhospital_under_spinner2="No";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    strthirdChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                                    thirdChildhospital_under_spinnerEdit.setText(strthirdChildhospital_under_spinner2);
                                    health_quote();
//                            hospitalEdit.setText("0.0");
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                            twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                            thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+"0.0");
                                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    hospital_under_spinner2.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    thirdChildhospital_under_spinner2.setVisibility(View.GONE);
                                    thirdChildhospital_under_spinnerEdit.setVisibility(View.VISIBLE);
                                }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    DHC_Status="False";
                                    DHC_Status1="False";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    DHC_Status4="False";
                                    DHC_Status5="False";

                                    strhospital_under_spinner="No";
                                    strhospital_under_spinner2="No";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    strthirdChildhospital_under_spinner2="No";
                                    strfourChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2Edit.setText(strhospital_under_spinner2);
                                    oneChildhospital_under_spinner2Edit.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2Edit.setText(strtwoChildhospital_under_spinner2);
                                    thirdChildhospital_under_spinnerEdit.setText(strthirdChildhospital_under_spinner2);
                                    fourChildhospital_under_spinner2Edit.setText(strfourChildhospital_under_spinner2);
                                    health_quote();
//                            hospitalEdit.setText("0.0");
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                            twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                            thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+"0.0");
//                            fourChildTxt.setText(str_fourNameEdit+" is covered under Hospital Cash for Rs. "+"0.0");
                                    hospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    hospital_under_spinner2.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2.setVisibility(View.GONE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    thirdChildhospital_under_spinner2.setVisibility(View.GONE);
                                    thirdChildhospital_under_spinnerEdit.setVisibility(View.VISIBLE);
                                    fourChildhospital_under_spinner2Edit.setVisibility(View.VISIBLE);
                                    fourChildhospital_under_spinner2.setVisibility(View.GONE);
                                } } }
                        else {
                            if (str_policyType_spinner.equals("Individual")) {
                                DHC_Status="True";
                                strhospital_under_spinner="Yes";
                                hospital_under_spinner.setText(strhospital_under_spinner);
                                health_quote();
//                        int add_strcriticalEdit = (Integer.parseInt(strcriticalEdit));
//                        criticalEdit.setText(strcriticalEdit);
//                        criticalIllnessNameTxt.setText(str_edt_name + " is covered under Critical Illness for Rs. " + strcriticalEdit);
                            } else {
                                if (str_IndividualTypeEdit.equals("2 Adult")) {
                                    DHC_Status="True";
                                    DHC_Status1="False";
                                    strhospital_under_spinner="Yes";
                                    strhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                                    health_quote();

//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                                } else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")) {
                                    DHC_Status="True";
                                    DHC_Status2="False";
                                    health_quote();
                                    strhospital_under_spinner="Yes";
                                    stroneChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")) {
                                    DHC_Status="True";
                                    DHC_Status1="False";
                                    DHC_Status2="False";
                                    health_quote();
                                    strhospital_under_spinner="Yes";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);

//                                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                                hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                                hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                                oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                                twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                                oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                } else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                    DHC_Status="True";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    DHC_Status4="False";
                                    strhospital_under_spinner="Yes";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    strthirdChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                    thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);

                                    health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    thirdChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    thirdChildhospital_under_spinnerEdit.setVisibility(View.GONE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")) {
                                    DHC_Status="True";
                                    DHC_Status2="False";
                                    DHC_Status1="False";
                                    health_quote();
                                    strhospital_under_spinner="Yes";
                                    strhospital_under_spinner2="No";
                                    stroneChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                                hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                                SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                                oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                    DHC_Status="True";
                                    DHC_Status1="False";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    health_quote();
                                    strhospital_under_spinner="Yes";
                                    strhospital_under_spinner2="No";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);


//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                                twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                    DHC_Status="True";
                                    DHC_Status1="False";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    DHC_Status4="False";
                                    health_quote();
                                    strhospital_under_spinner="Yes";
                                    strhospital_under_spinner2="No";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    strthirdChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                    thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);

//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                                thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    thirdChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    thirdChildhospital_under_spinnerEdit.setVisibility(View.GONE);
                                } else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                    DHC_Status="True";
                                    DHC_Status1="False";
                                    DHC_Status2="False";
                                    DHC_Status3="False";
                                    DHC_Status4="False";
                                    DHC_Status5="False";
                                    health_quote();
                                    strhospital_under_spinner="Yes";
                                    strhospital_under_spinner2="No";
                                    stroneChildhospital_under_spinner2="No";
                                    strtwoChildhospital_under_spinner2="No";
                                    strthirdChildhospital_under_spinner2="No";
                                    strfourChildhospital_under_spinner2="No";
                                    hospital_under_spinner.setText(strhospital_under_spinner);
                                    hospital_under_spinner2.setText(strhospital_under_spinner2);
                                    oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                    twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                    thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                                    fourChildhospital_under_spinner2.setText(strfourChildhospital_under_spinner2);


//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            fourChildTxt.setText(str_fourNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                                    hospital_under_spinner2Edit.setVisibility(View.GONE);
                                    hospital_under_spinner2.setVisibility(View.VISIBLE);
                                    oneChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    oneChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    twoChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    thirdChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                    thirdChildhospital_under_spinnerEdit.setVisibility(View.GONE);
                                    fourChildhospital_under_spinner2Edit.setVisibility(View.GONE);
                                    fourChildhospital_under_spinner2.setVisibility(View.VISIBLE);
                                }
                            } }


                    }
                });
                singlePicker.show(); }
        });
        hospital_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strhospital_under_spinner2=items1.get(options1);
                        hospital_under_spinner2.setText(strhospital_under_spinner2);
                        if (strhospital_under_spinner2.equals("No")){
                            if (str_IndividualTypeEdit.equals("2 Adult")){
                                DHC_Status1="False";
                                strhospital_under_spinner2="No";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                DHC_Status1="False";
                                strhospital_under_spinner2="No";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                DHC_Status1="False";
                                strhospital_under_spinner2="No";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                DHC_Status1="False";
                                strhospital_under_spinner2="No";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                            thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                DHC_Status1="False";
                                strhospital_under_spinner2="No";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+"0.0");
//                            oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                            thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                            fourChildTxt.setText(str_fourNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            } }
                        else {
                            if (str_IndividualTypeEdit.equals("2 Adult")) {
                                DHC_Status1="True";
                                strhospital_under_spinner2="Yes";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")) {
                                DHC_Status1="True";
                                strhospital_under_spinner2="Yes";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                DHC_Status1="True";
                                strhospital_under_spinner2="Yes";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                DHC_Status1="True";
                                strhospital_under_spinner2="Yes";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                DHC_Status1="True";
                                strhospital_under_spinner2="Yes";
                                hospital_under_spinner2.setText(strhospital_under_spinner2);
                                health_quote();
//                            int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                            hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                            hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                            oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                            fourChildTxt.setText(str_fourNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } }

                    }
                });
                singlePicker.show(); }
        });
        oneChildhospital_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        stroneChildhospital_under_spinner2=items1.get(options1);
                        oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                        if (stroneChildhospital_under_spinner2.equals("No")){
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                DHC_Status2="False";
                                stroneChildhospital_under_spinner2="No";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                    int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                DHC_Status2="False";
                                stroneChildhospital_under_spinner2="No";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                DHC_Status2="False";
                                stroneChildhospital_under_spinner2="No";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                DHC_Status2="False";
                                stroneChildhospital_under_spinner2="No";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                DHC_Status2="False";
                                stroneChildhospital_under_spinner2="No";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                DHC_Status2="False";
                                stroneChildhospital_under_spinner2="No";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                DHC_Status2="False";
                                stroneChildhospital_under_spinner2="No";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        fourChildTxt.setText(str_fourNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }
                        }
                        else {
                            if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")) {
                                DHC_Status2 = "True";
                                stroneChildhospital_under_spinner2="Yes";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")) {
                                DHC_Status2 = "True";
                                stroneChildhospital_under_spinner2="Yes";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")) {
                                DHC_Status2 = "True";
                                stroneChildhospital_under_spinner2="Yes";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")) {
                                DHC_Status2 = "True";
                                stroneChildhospital_under_spinner2="Yes";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                DHC_Status2 = "True";
                                stroneChildhospital_under_spinner2="Yes";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                DHC_Status2 = "True";
                                stroneChildhospital_under_spinner2="Yes";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                DHC_Status2 = "True";
                                stroneChildhospital_under_spinner2="Yes";
                                oneChildhospital_under_spinner2.setText(stroneChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        fourChildTxt.setText(str_fourNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } }

                    }
                });
                singlePicker.show(); }
        });
        LinertwoChildhospital_under_spinner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strtwoChildhospital_under_spinner2=items1.get(options1);
                        twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                        if (strtwoChildhospital_under_spinner2.equals("No")){
                            if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                DHC_Status3="False";
                                strtwoChildhospital_under_spinner2="No";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                DHC_Status3="False";
                                strtwoChildhospital_under_spinner2="No";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                DHC_Status3="False";
                                strtwoChildhospital_under_spinner2="No";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                DHC_Status3="False";
                                strtwoChildhospital_under_spinner2="No";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                DHC_Status3="False";
                                strtwoChildhospital_under_spinner2="No";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+"0.0");
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        fourChildTxt.setText(str_fourNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }
                        }
                        else {
                            if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                DHC_Status3="True";
                                strtwoChildhospital_under_spinner2="Yes";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                DHC_Status3="True";
                                strtwoChildhospital_under_spinner2="Yes";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);

                                health_quote();

//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }  else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")) {
                                DHC_Status3="True";
                                strtwoChildhospital_under_spinner2="Yes";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                DHC_Status3="True";
                                strtwoChildhospital_under_spinner2="Yes";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                DHC_Status3="True";
                                strtwoChildhospital_under_spinner2="Yes";
                                twoChildhospital_under_spinner2.setText(strtwoChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        fourChildTxt.setText(str_fourNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } }

                    }
                });
                singlePicker.show(); }
        });
        thirdChildhospital_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strthirdChildhospital_under_spinner2=items1.get(options1);
                        thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                        if (strthirdChildhospital_under_spinner2.equals("No")){
                            if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                DHC_Status4="False";
                                strthirdChildhospital_under_spinner2="No";
                                thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                                health_quote();

//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+"0.0");
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                DHC_Status4="False";
                                strthirdChildhospital_under_spinner2="No";
                                thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+"0.0");
                            }else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                DHC_Status4="False";
                                strthirdChildhospital_under_spinner2="No";
                                thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+"0.0");
//                        fourChildTxt.setText(str_fourNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }
                        }
                        else {
                            if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                DHC_Status4="True";
                                strthirdChildhospital_under_spinner2="Yes";
                                thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                                health_quote();
//                    int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                    hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                    oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                    twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                    thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                            }  else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")) {
                                DHC_Status4="True";
                                strthirdChildhospital_under_spinner2="Yes";
                                thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                                health_quote();
//                    int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                    hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                    hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                    SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                    oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                    twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                    thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            } else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                DHC_Status4="True";
                                strthirdChildhospital_under_spinner2="Yes";
                                thirdChildhospital_under_spinner2.setText(strthirdChildhospital_under_spinner2);
                                health_quote();
//                    int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                    hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                    hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                    SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                    oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                    twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                    thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                    fourChildTxt.setText(str_fourNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        fourChildhospital_under_spinner2Liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Medical_Complete_health.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Yes");
                items1.add("No");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strfourChildhospital_under_spinner2=items1.get(options1);
                        fourChildhospital_under_spinner2.setText(strfourChildhospital_under_spinner2);
                        if (strfourChildhospital_under_spinner2.equals("No")){
                            if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                DHC_Status5="False";
                                strfourChildhospital_under_spinner2="No";
                                fourChildhospital_under_spinner2.setText(strfourChildhospital_under_spinner2);
                                health_quote();

//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
//                        fourChildTxt.setText(str_fourNameEdit+" is covered under Hospital Cash for Rs. "+"0.0");
                            }
                        } else {
                            if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")) {
                                DHC_Status5 = "True";
                                strfourChildhospital_under_spinner2="Yes";
                                fourChildhospital_under_spinner2.setText(strfourChildhospital_under_spinner2);
                                health_quote();
//                        int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                        hospitalEdit.setText(String.valueOf(add_strhospitalEdit));
//                        hospitalCashtxt.setText(str_edt_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        SecondAdultTxt.setText(str_edt_Spouse_name + " is covered under Hospital Cash for Rs. " + strhospitalEdit);
//                        oneChildTxt.setText(str_OneEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        twoChildTxt.setText(str_twoChildEditName + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        thirdChildTxt.setText(str_thirdNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
//                        fourChildTxt.setText(str_fourNameEdit + " is covered under Hospital Cash for Rs. " + stroneChildTxt);
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strSubLimitAmount=subLimitAmount.getText().toString();
                strDiscount=discountedit.getText().toString();
                strcriticalEdit=criticalEdit.getText().toString();
                strperonalAccidentEdit=peronalAccidentEdit.getText().toString();
                strhospitalEdit=hospitalEdit.getText().toString();
                if (strAnyDisease.equals("Select")) {
                    Toast.makeText(Medical_Complete_health.this, "Please Select Any disease", Toast.LENGTH_SHORT).show();
                }
//                else if (strAnyhabitual.equals("Select")) {
//                    Toast.makeText(Medical_Complete_health.this, "Please Select Any habitual ", Toast.LENGTH_SHORT).show();
//                }else if (strforSelf.equals("For Self")) {
//                    strforSelf="No";
//                }else if (strforSpouse.equals("For Spouse")) {
//                    strforSpouse="No";
//                }else if (strAnyTreatment.equals("Select")) {
//                    strAnyTreatment="No";
//                }
                else {
//                    Intent intent=new Intent(Medical_Complete_health.this,Payment_Complete_healthCare.class);
                    Intent intent=new Intent(Medical_Complete_health.this,AddressCompleteHealth.class);
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
                    intent.putExtra("TotalValue",str_TotalValue);
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
                    intent.putExtra("PA_Status1",PA_Status1);
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
            object.put("DOB1",str_spouse_edit_dob_dob);
            object.put("DOB2",strOneChild);
            object.put("DOB3",strtwoDob);
            object.put("DOB4",strthreeDob);
            object.put("DOB5",strfourDob);
            object.put("PA_Status1",PA_Status1);
            object.put("CI_Status1",CI_Status1);
            object.put("DHC_Status1",DHC_Status1);
            object.put("PA_Status2",PA_Status2);
            object.put("CI_Status2",CI_Status2);
            object.put("DHC_Status2",DHC_Status2);
            object.put("PA_Status3",PA_Status3);
            object.put("CI_Status3",CI_Status3);
            object.put("DHC_Status3",DHC_Status3);
            object.put("PA_Status4",PA_Status4);
            object.put("CI_Status4",CI_Status4);
            object.put("DHC_Status4",DHC_Status4);
            object.put("PA_Status5",PA_Status5);
            object.put("CI_Status5",CI_Status5);
            object.put("DHC_Status5",DHC_Status5);
            object.put("BI_Status",BI_Status);
            object.put("BI_Status1",BI_Status1);
            object.put("BI_Status2",BI_Status2);
            object.put("BI_Status3",BI_Status3);
            object.put("BI_Status4",BI_Status4);
            object.put("BI_Status5",BI_Status5);
            object.put("Policy_Type",strSumInsuredTpeEDit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Medical_Complete_health.this, object, UrlHealthConstants.BUY_HEALTH_CARE_QUOTATION_URL, new ResponseListener() {
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
                            JSONArray InsuredDetailsGroupDataJsonObject = InsuredDetailsGroupJsonObject.getJSONArray("InsuredDetailsGroupData");
                            JSONObject OtherDiscountsJsonObject = RisksDataJsonObject.getJSONObject("OtherDiscounts");
                            JSONObject OtherDiscountGroupJsonObject = OtherDiscountsJsonObject.getJSONObject("OtherDiscountGroup");
                            JSONArray OtherDiscountGroupDataJsonObject = OtherDiscountGroupJsonObject.getJSONArray("OtherDiscountGroupData");

                            for (int k=0; k <InsuredDetailsGroupDataJsonObject.length();k++){
                                JSONObject CoverDetailsJsonObject = InsuredDetailsGroupDataJsonObject.getJSONObject(0);
                                JSONObject CoversDetailsJsonObject = CoverDetailsJsonObject.getJSONObject("CoverDetails");
                                Log.e("CoversDetailsJsonObject",CoversDetailsJsonObject.toString());
                                JSONObject CoversJsonObject = CoversDetailsJsonObject.getJSONObject("Covers");
                                JSONArray CoverDataJsonObject = CoversJsonObject.getJSONArray("CoverData");

                                for (int j=0; j <CoverDataJsonObject.length();j++){
                                    JSONObject JsonObjectCover = CoverDataJsonObject.getJSONObject(j);
                                    String CoversPersonal=JsonObjectCover.getJSONObject("CoverGroups").optString("Value");
                                    if(CoversPersonal.equals("Personal Accident Cover")){
                                        JSONObject PremiumJson=JsonObjectCover.getJSONObject("CoverPremium");
                                        str_amountPersonalSumInsuredAdult = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonal.equals("Critical Illness Cover")){
                                        JSONObject PremiumJson=JsonObjectCover.getJSONObject("CoverPremium");
                                        strcriticalEditAdult = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonal.equals("Daily Hospital Cash Cover")){
                                        JSONObject PremiumJson=JsonObjectCover.getJSONObject("CoverPremium");
                                        strhospitalEditAdult = PremiumJson.getString("Value");

                                    }

                                }

                                JSONObject CoverDetailsJsonObjectAdult2 = InsuredDetailsGroupDataJsonObject.getJSONObject(1);
                                JSONObject CoversDetailsJsonObjectAdult2 = CoverDetailsJsonObjectAdult2.getJSONObject("CoverDetails");
                                JSONObject CoversJsonObjectAdult2 = CoversDetailsJsonObjectAdult2.getJSONObject("Covers");
                                JSONArray CoverDataJsonObjectAdult2 = CoversJsonObjectAdult2.getJSONArray("CoverData");
                                for (int Adult2=0; Adult2 <CoverDataJsonObjectAdult2.length();Adult2++){
                                    JSONObject JsonObjectCoverAdult2 = CoverDataJsonObjectAdult2.getJSONObject(Adult2);
                                    String CoversPersonalAdult2=JsonObjectCoverAdult2.getJSONObject("CoverGroups").optString("Value");
                                    if(CoversPersonalAdult2.equals("Personal Accident Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverAdult2.getJSONObject("CoverPremium");
                                        str_amountPersonalSumInsuredAdult1 = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalAdult2.equals("Critical Illness Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverAdult2.getJSONObject("CoverPremium");
                                        strcriticalEditAdult1 = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalAdult2.equals("Daily Hospital Cash Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverAdult2.getJSONObject("CoverPremium");
                                        strhospitalEditAdult1 = PremiumJson.getString("Value");
                                    } }

                                JSONObject CoverDetailsJsonObjectChild1= InsuredDetailsGroupDataJsonObject.getJSONObject(2);
                                JSONObject CoversDetailsJsonObjectChild1 = CoverDetailsJsonObjectChild1.getJSONObject("CoverDetails");
                                JSONObject CoversJsonObjectChild1 = CoversDetailsJsonObjectChild1.getJSONObject("Covers");
                                JSONArray CoverDataJsonObjectChild1 = CoversJsonObjectChild1.getJSONArray("CoverData");
                                for (int Child1=0; Child1 <CoverDataJsonObjectChild1.length();Child1++){
                                    JSONObject JsonObjectCoverChild1 = CoverDataJsonObjectChild1.getJSONObject(Child1);
                                    String CoversPersonalChid1=JsonObjectCoverChild1.getJSONObject("CoverGroups").optString("Value");
                                    if(CoversPersonalChid1.equals("Personal Accident Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild1.getJSONObject("CoverPremium");
                                        str_amountPersonalSumInsuredChild1 = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalChid1.equals("Critical Illness Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild1.getJSONObject("CoverPremium");
                                        strOneChildCriticalIllnessTxt = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalChid1.equals("Daily Hospital Cash Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild1.getJSONObject("CoverPremium");
                                        stroneChildTxt = PremiumJson.getString("Value");
                                    }
                                }
                                JSONObject CoverDetailsJsonObjectChild2= InsuredDetailsGroupDataJsonObject.getJSONObject(3);
                                JSONObject CoversDetailsJsonObjectChild2 = CoverDetailsJsonObjectChild2.getJSONObject("CoverDetails");
                                JSONObject CoversJsonObjectChild2 = CoversDetailsJsonObjectChild2.getJSONObject("Covers");
                                JSONArray CoverDataJsonObjectChild2 = CoversJsonObjectChild2.getJSONArray("CoverData");
                                for (int Child1=0; Child1 <CoverDataJsonObjectChild2.length();Child1++){
                                    JSONObject JsonObjectCoverChild2 = CoverDataJsonObjectChild2.getJSONObject(Child1);
                                    String CoversPersonalChild2=JsonObjectCoverChild2.getJSONObject("CoverGroups").optString("Value");
                                    if(CoversPersonalChild2.equals("Personal Accident Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild2.getJSONObject("CoverPremium");
                                        str_amountPersonalSumInsuredTwo = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalChild2.equals("Critical Illness Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild2.getJSONObject("CoverPremium");
                                        strTwoChildCriticalIllnessTxt = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalChild2.equals("Daily Hospital Cash Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild2.getJSONObject("CoverPremium");
                                        strtwoChildTxt = PremiumJson.getString("Value");
                                    }
                                }

                                JSONObject CoverDetailsJsonObjectChild3= InsuredDetailsGroupDataJsonObject.getJSONObject(4);
                                JSONObject CoversDetailsJsonObjectChild3 = CoverDetailsJsonObjectChild3.getJSONObject("CoverDetails");
                                JSONObject CoversJsonObjectChild3 = CoversDetailsJsonObjectChild3.getJSONObject("Covers");
                                JSONArray CoverDataJsonObjectChild3 = CoversJsonObjectChild3.getJSONArray("CoverData");
                                for (int Child3=0; Child3<CoverDataJsonObjectChild3.length();Child3++){
                                    JSONObject JsonObjectCoverChild3 = CoverDataJsonObjectChild3.getJSONObject(Child3);
                                    String CoversPersonalChild3=JsonObjectCoverChild3.getJSONObject("CoverGroups").optString("Value");
                                    if(CoversPersonalChild3.equals("Personal Accident Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild3.getJSONObject("CoverPremium");
                                        str_amountPersonalSumInsuredThird = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalChild3.equals("Critical Illness Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild3.getJSONObject("CoverPremium");
                                        strOneChildCriticalIllnessTxtthird = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalChild3.equals("Daily Hospital Cash Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild3.getJSONObject("CoverPremium");
                                        strThirdChildTxt = PremiumJson.getString("Value");
                                    }
                                }

                                JSONObject CoverDetailsJsonObjectChild4= InsuredDetailsGroupDataJsonObject.getJSONObject(5);
                                JSONObject CoversDetailsJsonObjectChild4 = CoverDetailsJsonObjectChild4.getJSONObject("CoverDetails");
                                JSONObject CoversJsonObjectChild4 = CoversDetailsJsonObjectChild4.getJSONObject("Covers");
                                JSONArray CoverDataJsonObjectChild4 = CoversJsonObjectChild4.getJSONArray("CoverData");
                                for (int Child4=0; Child4<CoverDataJsonObjectChild4.length();Child4++){
                                    JSONObject JsonObjectCoverChild4 = CoverDataJsonObjectChild4.getJSONObject(Child4);
                                    String CoversPersonalChild4=JsonObjectCoverChild4.getJSONObject("CoverGroups").optString("Value");
                                    if(CoversPersonalChild4.equals("Personal Accident Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild4.getJSONObject("CoverPremium");
                                        amountPersonalSumInsuredFour = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalChild4.equals("Critical Illness Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild4.getJSONObject("CoverPremium");
                                        strFourChildCriticalIllnessTxt = PremiumJson.getString("Value");
                                    }
                                    if(CoversPersonalChild4.equals("Daily Hospital Cash Cover")){
                                        JSONObject PremiumJson=JsonObjectCoverChild4.getJSONObject("CoverPremium");
                                        strFourChildTxt = PremiumJson.getString("Value");
                                    }
                                }

                            }

                            if(str_policyType_spinner.equals("Individual")){
                                editSumInsured.setText(str_SumInsured);
                                editPersonalAccident.setText(str_SumInsured);
                                editPASpinner.setText(str_SumInsured);
                                criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                strcriticalEdit=String.valueOf(doublecriticalEditAdult1);
                                criticalEdit.setText(strcriticalEdit);
                                double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                str_amountPersonalSumInsured=String.valueOf(doublestr_amountPersonalSumInsuredAdult);
                                peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                                strhospitalEdit= String.valueOf(doublestrhospitalEditAdult);
                                hospitalEdit.setText(strhospitalEdit);

                            }else {
                                if (str_IndividualTypeEdit.equals("2 Adult")){
                                    criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                    twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult1);
                                    personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                    SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult1);
                                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                    SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult1);
                                   double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                   double  doublecriticalEditAdult2= Double.parseDouble(strcriticalEditAdult1);
                                   double newdoublecriticalEditAdult1=doublecriticalEditAdult1+doublecriticalEditAdult2;
                                    strcriticalEdit=String.valueOf(newdoublecriticalEditAdult1);
                                    criticalEdit.setText(strcriticalEdit);
                                    double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                    double doublestr_amountPersonalSumInsuredAdult1= Double.parseDouble(str_amountPersonalSumInsuredAdult1);
                                    double newdoublecriticalEditAdultPersonal=doublestr_amountPersonalSumInsuredAdult+doublestr_amountPersonalSumInsuredAdult1;
                                    str_amountPersonalSumInsured= String.valueOf(newdoublecriticalEditAdultPersonal);
                                    peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                              double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                              double doublestrhospitalEditAdult1= Double.parseDouble(strhospitalEditAdult1);
                              double newdoublecriticalEditAdultHospital=doublestrhospitalEditAdult+doublestrhospitalEditAdult1;
                              strhospitalEdit= String.valueOf(newdoublecriticalEditAdultHospital);
                               hospitalEdit.setText(strhospitalEdit);
//
                                }
                                else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                                    criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                    OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                    OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredChild1);
                                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                    oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                                    double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                    double  doublestrOneChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxt);
                                    double newdoublecriticalEditAdult1=doublecriticalEditAdult1+doublestrOneChildCriticalIllnessTxt;
                                    strcriticalEdit=String.valueOf(newdoublecriticalEditAdult1);
                                    criticalEdit.setText(strcriticalEdit);
                                    double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                    double doublestr_amountPersonalSumInsuredChild1= Double.parseDouble(str_amountPersonalSumInsuredChild1);
                                    double newdoublecriticalEditAdultPersonal=doublestr_amountPersonalSumInsuredAdult+doublestr_amountPersonalSumInsuredChild1;
                                    str_amountPersonalSumInsured= String.valueOf(newdoublecriticalEditAdultPersonal);
                                    peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                    double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                                    double doublestrhospitalstroneChildTxt= Double.parseDouble(stroneChildTxt);
                                    double newdoublecriticalEditAdultHospital=doublestrhospitalEditAdult+doublestrhospitalstroneChildTxt;
                                    strhospitalEdit= String.valueOf(newdoublecriticalEditAdultHospital);
                                    hospitalEdit.setText(strhospitalEdit);
                                }
                                else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                                    criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                    personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                    OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredChild1);
                                    oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                                    twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strTwoChildCriticalIllnessTxt);
                                    twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredTwo);
                                    twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+strtwoChildTxt);
                                    double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                    double  doublestrOneChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxt);
                                    double  doublestrTwoChildCriticalIllnessTxt= Double.parseDouble(strTwoChildCriticalIllnessTxt);
                                    double newdoublecriticalEditAdult1=doublecriticalEditAdult1+doublestrOneChildCriticalIllnessTxt+doublestrTwoChildCriticalIllnessTxt;
                                    strcriticalEdit=String.valueOf(newdoublecriticalEditAdult1);
                                    criticalEdit.setText(strcriticalEdit);
                                    double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                    double doublestr_amountPersonalSumInsuredChild1= Double.parseDouble(str_amountPersonalSumInsuredChild1);
                                    double doublestr_amountPersonalSumInsuredChild2= Double.parseDouble(str_amountPersonalSumInsuredTwo);
                                    double newdoublecriticalEditAdultPersonal=doublestr_amountPersonalSumInsuredAdult+doublestr_amountPersonalSumInsuredChild1+doublestr_amountPersonalSumInsuredChild2;
                                    str_amountPersonalSumInsured= String.valueOf(newdoublecriticalEditAdultPersonal);
                                    peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                    double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                                    double doublestrhospitalstroneChildTxt= Double.parseDouble(stroneChildTxt);
                                    double doublestrhospitalstrTwoChildTxt= Double.parseDouble(strtwoChildTxt);
                                    double newdoublecriticalEditAdultHospital=doublestrhospitalEditAdult+doublestrhospitalstroneChildTxt+doublestrhospitalstrTwoChildTxt;
                                    strhospitalEdit= String.valueOf(newdoublecriticalEditAdultHospital);
                                    hospitalEdit.setText(strhospitalEdit);
                                }
                                else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                                    criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                    personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                    OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredChild1);
                                    oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                                    twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strTwoChildCriticalIllnessTxt);
                                    twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredTwo);
                                    twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+strtwoChildTxt);
                                    thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxtthird);
                                    thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredThird);
                                    thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+strThirdChildTxt);
                                    double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                    double  doublestrOneChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxt);
                                    double  doublestrTwoChildCriticalIllnessTxt= Double.parseDouble(strTwoChildCriticalIllnessTxt);
                                    double  doublestrThreeChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxtthird);
                                    double newdoublecriticalEditAdult1=doublecriticalEditAdult1+doublestrOneChildCriticalIllnessTxt+doublestrTwoChildCriticalIllnessTxt+doublestrThreeChildCriticalIllnessTxt;
                                    strcriticalEdit=String.valueOf(newdoublecriticalEditAdult1);
                                    criticalEdit.setText(strcriticalEdit);
                                    double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                    double doublestr_amountPersonalSumInsuredChild1= Double.parseDouble(str_amountPersonalSumInsuredChild1);
                                    double doublestr_amountPersonalSumInsuredChild2= Double.parseDouble(str_amountPersonalSumInsuredTwo);
                                    double doublestr_amountPersonalSumInsuredChild3= Double.parseDouble(str_amountPersonalSumInsuredThird);
                                    double newdoublecriticalEditAdultPersonal=doublestr_amountPersonalSumInsuredAdult+doublestr_amountPersonalSumInsuredChild1+doublestr_amountPersonalSumInsuredChild2+doublestr_amountPersonalSumInsuredChild3;
                                    str_amountPersonalSumInsured= String.valueOf(newdoublecriticalEditAdultPersonal);
                                    peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                    double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                                    double doublestrhospitalstroneChildTxt= Double.parseDouble(stroneChildTxt);
                                    double doublestrhospitalstrTwoChildTxt= Double.parseDouble(strtwoChildTxt);
                                    double doublestrhospitalstrThirdChildTxt= Double.parseDouble(strThirdChildTxt);
                                    double newdoublecriticalEditAdultHospital=doublestrhospitalEditAdult+doublestrhospitalstroneChildTxt+doublestrhospitalstrTwoChildTxt+doublestrhospitalstrThirdChildTxt;
                                    strhospitalEdit= String.valueOf(newdoublecriticalEditAdultHospital);
                                    hospitalEdit.setText(strhospitalEdit);

                                }
                                else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                                    criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                    twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult1);
                                    OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                    SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult1);
                                    OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredChild1);
                                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                    SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult1);
                                    oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                                    double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                    double  doublecriticalEditAdult2= Double.parseDouble(strcriticalEditAdult1);
                                    double  doublestrOneChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxt);
                                    double newdoublecriticalEditAdult1=doublecriticalEditAdult1+doublecriticalEditAdult2+doublestrOneChildCriticalIllnessTxt;
                                    strcriticalEdit=String.valueOf(newdoublecriticalEditAdult1);
                                    criticalEdit.setText(strcriticalEdit);
                                    double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                    double doublestr_amountPersonalSumInsuredAdult1= Double.parseDouble(str_amountPersonalSumInsuredAdult1);
                                    double doublestr_amountPersonalSumInsuredChild1= Double.parseDouble(str_amountPersonalSumInsuredChild1);
                                    double newdoublecriticalEditAdultPersonal=doublestr_amountPersonalSumInsuredAdult+doublestr_amountPersonalSumInsuredAdult1+doublestr_amountPersonalSumInsuredChild1;
                                    str_amountPersonalSumInsured= String.valueOf(newdoublecriticalEditAdultPersonal);
                                    peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                    double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                                    double doublestrhospitalEditAdult1= Double.parseDouble(strhospitalEditAdult1);
                                    double doublestrhospitalstroneChildTxt= Double.parseDouble(stroneChildTxt);
                                    double newdoublecriticalEditAdultHospital=doublestrhospitalEditAdult+doublestrhospitalEditAdult1+doublestrhospitalstroneChildTxt;
                                    strhospitalEdit= String.valueOf(newdoublecriticalEditAdultHospital);
                                    hospitalEdit.setText(strhospitalEdit);
                                }
                                else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                                    criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                    twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult1);
                                    OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                    SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult1);
                                    OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredChild1);
                                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                    SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult1);
                                    oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                                    twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strTwoChildCriticalIllnessTxt);
                                    twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredTwo);
                                    twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+strtwoChildTxt);
                                    double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                    double  doublecriticalEditAdult2= Double.parseDouble(strcriticalEditAdult1);
                                    double  doublestrOneChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxt);
                                    double  doublestrTwoChildCriticalIllnessTxt= Double.parseDouble(strTwoChildCriticalIllnessTxt);
                                    double newdoublecriticalEditAdult1=doublecriticalEditAdult1+doublecriticalEditAdult2+doublestrOneChildCriticalIllnessTxt+doublestrTwoChildCriticalIllnessTxt;
                                    strcriticalEdit=String.valueOf(newdoublecriticalEditAdult1);
                                    criticalEdit.setText(strcriticalEdit);
                                    double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                    double doublestr_amountPersonalSumInsuredAdult1= Double.parseDouble(str_amountPersonalSumInsuredAdult1);
                                    double doublestr_amountPersonalSumInsuredChild1= Double.parseDouble(str_amountPersonalSumInsuredChild1);
                                    double doublestr_amountPersonalSumInsuredChild2= Double.parseDouble(str_amountPersonalSumInsuredTwo);
                                    double newdoublecriticalEditAdultPersonal=doublestr_amountPersonalSumInsuredAdult+doublestr_amountPersonalSumInsuredAdult1+doublestr_amountPersonalSumInsuredChild1+doublestr_amountPersonalSumInsuredChild2;
                                    str_amountPersonalSumInsured= String.valueOf(newdoublecriticalEditAdultPersonal);
                                    peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                    double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                                    double doublestrhospitalEditAdult1= Double.parseDouble(strhospitalEditAdult1);
                                    double doublestrhospitalstroneChildTxt= Double.parseDouble(stroneChildTxt);
                                    double doublestrhospitalstrTwoChildTxt= Double.parseDouble(strtwoChildTxt);
                                    double newdoublecriticalEditAdultHospital=doublestrhospitalEditAdult+doublestrhospitalEditAdult1+doublestrhospitalstroneChildTxt+doublestrhospitalstrTwoChildTxt;
                                    strhospitalEdit= String.valueOf(newdoublecriticalEditAdultHospital);
                                    hospitalEdit.setText(strhospitalEdit);
                                }
                                else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                                    criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                    twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult1);
                                    OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strTwoChildCriticalIllnessTxt);
                                    thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxtthird);
                                    personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                    SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult1);
                                    OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredChild1);
                                    twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredTwo);
                                    thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredThird);
                                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                    SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult1);
                                    oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                                    twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+strtwoChildTxt);
                                    thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+strThirdChildTxt);
                                    double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                    double  doublecriticalEditAdult2= Double.parseDouble(strcriticalEditAdult1);
                                    double  doublestrOneChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxt);
                                    double  doublestrTwoChildCriticalIllnessTxt= Double.parseDouble(strTwoChildCriticalIllnessTxt);
                                    double  doublestrThreeChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxtthird);
                                    double newdoublecriticalEditAdult1=doublecriticalEditAdult1+doublecriticalEditAdult2+doublestrOneChildCriticalIllnessTxt+doublestrTwoChildCriticalIllnessTxt+doublestrThreeChildCriticalIllnessTxt;
                                    strcriticalEdit=String.valueOf(newdoublecriticalEditAdult1);
                                    criticalEdit.setText(strcriticalEdit);
                                    double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                    double doublestr_amountPersonalSumInsuredAdult1= Double.parseDouble(str_amountPersonalSumInsuredAdult1);
                                    double doublestr_amountPersonalSumInsuredChild1= Double.parseDouble(str_amountPersonalSumInsuredChild1);
                                    double doublestr_amountPersonalSumInsuredChild2= Double.parseDouble(str_amountPersonalSumInsuredTwo);
                                    double doublestr_amountPersonalSumInsuredChild3= Double.parseDouble(str_amountPersonalSumInsuredThird);
                                    double newdoublecriticalEditAdultPersonal=doublestr_amountPersonalSumInsuredAdult+doublestr_amountPersonalSumInsuredAdult1+doublestr_amountPersonalSumInsuredChild1+doublestr_amountPersonalSumInsuredChild2+doublestr_amountPersonalSumInsuredChild3;
                                    str_amountPersonalSumInsured= String.valueOf(newdoublecriticalEditAdultPersonal);
                                    peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                    double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                                    double doublestrhospitalEditAdult1= Double.parseDouble(strhospitalEditAdult1);
                                    double doublestrhospitalstroneChildTxt= Double.parseDouble(stroneChildTxt);
                                    double doublestrhospitalstrTwoChildTxt= Double.parseDouble(strtwoChildTxt);
                                    double doublestrhospitalstrThirdChildTxt= Double.parseDouble(strThirdChildTxt);
                                    double newdoublecriticalEditAdultHospital=doublestrhospitalEditAdult+doublestrhospitalEditAdult1+doublestrhospitalstroneChildTxt+doublestrhospitalstrTwoChildTxt+doublestrhospitalstrThirdChildTxt;
                                    strhospitalEdit= String.valueOf(newdoublecriticalEditAdultHospital);
                                    hospitalEdit.setText(strhospitalEdit);
                                }
                                else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                                    criticalIllnessNameTxt.setText(str_edt_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult);
                                    twoAdultCriticalIllnessTxt.setText(str_edt_Spouse_name+" is covered under Critical Illness for Rs. "+strcriticalEditAdult1);
                                    OneChildCriticalIllnessTxt.setText(str_OneEditName+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxt);
                                    twoChildCriticalIllnessTxt.setText(str_twoChildEditName+" is covered under Critical Illness for Rs. "+strTwoChildCriticalIllnessTxt);
                                    thirdChildCriticalIllnessTxt.setText(str_thirdNameEdit+" is covered under Critical Illness for Rs. "+strOneChildCriticalIllnessTxtthird);
                                    fourChildCriticalIllnessTxt.setText(str_fourNameEdit+" is covered under Critical Illness for Rs. "+strFourChildCriticalIllnessTxt);

                                    personalEdit.setText(str_edt_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult);
                                    SecondAdultPersonalEdit.setText(str_edt_Spouse_name+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredAdult1);
                                    OneChildPersonalEdit.setText(str_OneEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredChild1);
                                    twoChildPersonalEdit.setText(str_twoChildEditName+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredTwo);
                                    thirdChildPersonalEdit.setText(str_thirdNameEdit+" is covered under Personal Accident for Rs. "+str_amountPersonalSumInsuredThird);
                                    fourChildPersonalEdit.setText(str_fourNameEdit+" is covered under Personal Accident for Rs. "+amountPersonalSumInsuredFour);

                                    hospitalCashtxt.setText(str_edt_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult);
                                    SecondAdultTxt.setText(str_edt_Spouse_name+" is covered under Hospital Cash for Rs. "+strhospitalEditAdult1);
                                    oneChildTxt.setText(str_OneEditName+" is covered under Hospital Cash for Rs. "+stroneChildTxt);
                                    twoChildTxt.setText(str_twoChildEditName+" is covered under Hospital Cash for Rs. "+strtwoChildTxt);
                                    thirdChildTxt.setText(str_thirdNameEdit+" is covered under Hospital Cash for Rs. "+strThirdChildTxt);
                                    fourChildTxt.setText(str_fourNameEdit+" is covered under Hospital Cash for Rs. "+strFourChildTxt);

                                    double  doublecriticalEditAdult1= Double.parseDouble(strcriticalEditAdult);
                                    double  doublecriticalEditAdult2= Double.parseDouble(strcriticalEditAdult1);
                                    double  doublestrOneChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxt);
                                    double  doublestrTwoChildCriticalIllnessTxt= Double.parseDouble(strTwoChildCriticalIllnessTxt);
                                    double  doublestrThreeChildCriticalIllnessTxt= Double.parseDouble(strOneChildCriticalIllnessTxtthird);
                                    double  doublestrFourChildCriticalIllnessTxt= Double.parseDouble(strFourChildCriticalIllnessTxt);
                                    double newdoublecriticalEditAdult1=doublecriticalEditAdult1+doublecriticalEditAdult2+doublestrOneChildCriticalIllnessTxt+doublestrTwoChildCriticalIllnessTxt+doublestrThreeChildCriticalIllnessTxt+doublestrFourChildCriticalIllnessTxt;
                                    strcriticalEdit=String.valueOf(newdoublecriticalEditAdult1);
                                    criticalEdit.setText(strcriticalEdit);
                                    double doublestr_amountPersonalSumInsuredAdult= Double.parseDouble(str_amountPersonalSumInsuredAdult);
                                    double doublestr_amountPersonalSumInsuredAdult1= Double.parseDouble(str_amountPersonalSumInsuredAdult1);
                                    double doublestr_amountPersonalSumInsuredChild1= Double.parseDouble(str_amountPersonalSumInsuredChild1);
                                    double doublestr_amountPersonalSumInsuredChild2= Double.parseDouble(str_amountPersonalSumInsuredTwo);
                                    double doublestr_amountPersonalSumInsuredChild3= Double.parseDouble(str_amountPersonalSumInsuredThird);
                                    double doublestr_amountPersonalSumInsuredChild4= Double.parseDouble(amountPersonalSumInsuredFour);
                                    double newdoublecriticalEditAdultPersonal=doublestr_amountPersonalSumInsuredAdult+doublestr_amountPersonalSumInsuredAdult1+doublestr_amountPersonalSumInsuredChild1+doublestr_amountPersonalSumInsuredChild2+doublestr_amountPersonalSumInsuredChild3+doublestr_amountPersonalSumInsuredChild4;
                                    str_amountPersonalSumInsured= String.valueOf(newdoublecriticalEditAdultPersonal);
                                    peronalAccidentEdit.setText(str_amountPersonalSumInsured);
                                    double doublestrhospitalEditAdult= Double.parseDouble(strhospitalEditAdult);
                                    double doublestrhospitalEditAdult1= Double.parseDouble(strhospitalEditAdult1);
                                    double doublestrhospitalstroneChildTxt= Double.parseDouble(stroneChildTxt);
                                    double doublestrhospitalstrTwoChildTxt= Double.parseDouble(strtwoChildTxt);
                                    double doublestrhospitalstrThirdChildTxt= Double.parseDouble(strThirdChildTxt);
                                    double doublestrhospitalstrFourChildTxt= Double.parseDouble(strFourChildTxt);
                                    double newdoublecriticalEditAdultHospital=doublestrhospitalEditAdult+doublestrhospitalEditAdult1+doublestrhospitalstroneChildTxt+doublestrhospitalstrTwoChildTxt+doublestrhospitalstrThirdChildTxt+doublestrhospitalstrFourChildTxt;
                                    strhospitalEdit= String.valueOf(newdoublecriticalEditAdultHospital);
                                    hospitalEdit.setText(strhospitalEdit);
                                }

                            }

                            for (int i=0;i <OtherDiscountGroupDataJsonObject.length();i++){
                                JSONObject JsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(i);
                                String Discounts=JsonObject.getJSONObject("Description").optString("Value");
                                if (Discounts.equals("Life Style Discount")){
                                    JSONObject LifeStyle=JsonObject.getJSONObject("Premium");
                                    LifeStyleDiscountStr = LifeStyle.getString("Value");
                                    Log.e("LifeStyleDiscountStr",LifeStyleDiscountStr);
                                }

                                if (Discounts.equals("Tiered Hospital Discount")){
                                    JSONObject LifeStyle=JsonObject.getJSONObject("Premium");
                                    strDiscount = LifeStyle.getString("Value");
                                    Log.e("strDiscount",strDiscount);
                                    discountedit.setText(strDiscount);
                                }
                                if (Discounts.equals("E-sale Discount")){
                                    JSONObject LifeStyle=JsonObject.getJSONObject("Premium");
                                    ESaleDiscount = LifeStyle.getString("Value");
                                    Log.e("ESaleDiscount",ESaleDiscount);
                                }
                                if (Discounts.equals("Policy Duration Discount")){
                                    JSONObject LifeStyle=JsonObject.getJSONObject("Premium");
                                    LongTermDiscount = LifeStyle.getString("Value");
                                    Log.e("LongTermDiscount",LongTermDiscount);
                                }
                                if (Discounts.equals("Sub Category Discount")){
                                    JSONObject LifeStyle=JsonObject.getJSONObject("Premium");
                                    strSubLimitAmount = LifeStyle.getString("Value");
                                    Log.e("strSubLimitAmount",strSubLimitAmount);
                                    subLimitAmount.setText(strSubLimitAmount);
                                }




//                                    JSONObject TiredHospital=TieredHospitalJson.getJSONObject("Premium");
//                                    strDiscount = TiredHospital.getString("Value");
                                    Log.e("NoOfMemberDiscount",Discounts);





                               /* JSONObject LongTermJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(1);
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

                                */


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