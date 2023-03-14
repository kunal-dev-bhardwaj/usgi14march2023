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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.HospitalListActivity;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.Policies_web_Browser;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
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

public class Payment_Complete_healthCare extends AppCompatActivity  {
    String InsuredType1="",strAddDiscountBtn="",strsecondAdultCritical_under_spinner2="",strsOneChildCritical_under_spinner2="",strtwoChildCritical_under_spinner2="", strthirdChildCritical_under_spinner2="",strfourChildCritical_under_spinner2="",stroneChildPersonal_under_spinner2="",strtwoChildPersonal_under_spinner2="",strthirdChildPersonal_under_spinner2="", strfourChildPersonal_under_spinner2="",stroneChildhospital_under_spinner2="",strtwoChildhospital_under_spinner2="",strthirdChildhospital_under_spinner2="",strfourChildhospital_under_spinner2="",BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,PA_Status,CI_Status,DHC_Status,Esale_Status,Life_Status,Sub_Status,Sub_Type,Tiered_Status,PA_Status1,CI_Status1,DHC_Status1,PA_Status2,CI_Status2,DHC_Status2,PA_Status3,CI_Status3,DHC_Status3,PA_Status4,CI_Status4,DHC_Status4,PA_Status5,CI_Status5,DHC_Status5,new_str_age="",ESaleDiscount,PD_Status,strSumInsuredTpeEDit="",LifeStyleDiscountStr="",LongTermDiscount="",strbloodSugarAdultTwo="",strbloodPressureAdultTwo="",strbloodPressureDiastolicAdultTwo="",strcholesterolAdultTwo="",strbloodSugarChildOne="",strbloodPressureChildOne="",strbloodPressureDiastolicChildOne="",strcholesterolChildOne="",strbloodSugarChildTwo="",strbloodPressureChildTwo="",strbloodPressureDiastolicChildTwo="",strcholesterolChildTwo="",strbloodSugarThirdChild="",strbloodPressureThirdChild="",strbloodPressureDiastolicThirdChild="",strcholesterolThirdChild="", strbloodSugarFourChild="",strbloodPressureFourChild="",strbloodPressureDiastolicFourChild="",strcholesterolFourChild="",strOneChild="",strtwoDob="",strthreeDob="",strfourDob="",strChildOne="",
            strChildTwo="",strChildThree="",strChildFour="",str_oneWeightEdit="",strtwoWeightEdit="",str_thirdWeightEdit="",strFourWeightEdit="",str_oneGenderSpinner="",str_oneFtSpinner="",str_oneInchesSpinner="",str_twoGenderSpinner="",str_twoFtSpinner="",str_twoInchesSpinner="",str_thirdGenderSpinner="",str_thirdFtSpinner="",str_thirdInchesSpinner="",str_fourGenderSpinner="",str_fourFtSpinner="",str_fourInchesSpinner="",strBMIEdit="",strBMIAdultOneEdit="",strBMIChildEdit="",strBMIChildTwoEdit="",strBMIEChildThreeEdit="",strBMIFourChildEdit="",strPriceTotal="",str_edit_dob3String="",strProposerSpinner="",strContactNominee="",strNomineeName="",strbloodSugar="",strbloodPressure="",strbloodPressureDiastolic="",stredtcholesterol="",NetPremiumValue="",GST="",str_amountPersonalSumInsured="",str_for,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner="",str_spouse_ft_spinner="",str_spouse_inches_spinner="",str_spouse_weight_edit="",str_edit_dob="",str_spouse_edit_dob_dob="",
    strNominee_dob="", strAnyDisease="",strAnyhabitual="",strSubLimit="",strnoDiabetes="",strnoSpouseDiabetes="",strNoHypertension="",strNoSpouseHypertension="",strNoCholesterol="",strNoSpouseCholesterol="",strforSelf="",strforSpouse="",strSubLimitAmount="",strAnyTreatment="",strDiscount="",strcriticalEdit="",strCriticalIllness="",strCriticalUnderSpinner="",strCriticalUnderSpinner2="",strperonalAccidentEdit="",strPersonalAccidentSpinner="",strpersonalUnder_spinner="",strpersonal_under_spinner2="",strhospitalEdit="",strhospitalCashSpinner="",strhospital_under_spinner="",strhospital_under_spinner2="",str_TotalValue="",str_policyType_spinner="",str_SumInsured="",
            str_IndividualTypeEdit="",str_OneEditName="",str_twoChildEditName="",str_thirdNameEdit="",str_fourNameEdit="",strFirstTString="",PosPolicyNo="",str_RelationEdit="",strRelationAdultOneEdit="",strRelationChildEdit="",strRelationChildTwoEdit="",strRelationChildThreeEdit="",strRelationFourChildEdit="",strAddressLine1="",strAddressLine2="",strAddressLine3="",strpincode="",strCityName="",strstateName="";
   EditText totalAmount,quotationId;
   String strTotalAmount="",strQuotationId;
   Button btn_continue;
   private MySharedPreference pref;
   CustomProgressDialog customprogress;
   String today,tomorrowDate,nextYear ;
   Date date;
   Format formatter;
   TextView show_Breakup;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Payment_Complete_healthCare.this,NomineeOtherDetailsCompleteHealth.class);
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
        intent.putExtra("strAnyTreatment",strAnyTreatment);
        intent.putExtra("strCriticalUnderSpinner2",strCriticalUnderSpinner2);
        intent.putExtra("strperonalAccidentEdit",strperonalAccidentEdit);
        intent.putExtra("strPersonalAccidentSpinner",strPersonalAccidentSpinner);
        intent.putExtra("strpersonalUnder_spinner",strpersonalUnder_spinner);
        intent.putExtra("strhospital_under_spinner",strhospital_under_spinner);
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
        intent.putExtra("new_str_age",new_str_age);
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__complete_health_care);
        getWindow().setStatusBarColor(ContextCompat.getColor(Payment_Complete_healthCare.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(Payment_Complete_healthCare.this);
        customprogress = new CustomProgressDialog(Payment_Complete_healthCare.this);

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
        strAnyDisease = getIntent().getStringExtra("strAnyDisease");
        strnoDiabetes = getIntent().getStringExtra("strnoDiabetes");
        strNoHypertension = getIntent().getStringExtra("strNoHypertension");
        strNoCholesterol = getIntent().getStringExtra("strNoCholesterol");
        strnoSpouseDiabetes = getIntent().getStringExtra("strnoSpouseDiabetes");
        strNoSpouseHypertension = getIntent().getStringExtra("strNoSpouseHypertension");
        strNoSpouseCholesterol = getIntent().getStringExtra("strNoSpouseCholesterol");
        strAnyhabitual = getIntent().getStringExtra("strAnyhabitual");
        strforSelf = getIntent().getStringExtra("strforSelf");
        strforSpouse = getIntent().getStringExtra("strforSpouse");
        strSubLimit = getIntent().getStringExtra("strSubLimit");
        strSubLimitAmount = getIntent().getStringExtra("strSubLimitAmount");
        strAnyTreatment = getIntent().getStringExtra("strAnyTreatment");
        strDiscount = getIntent().getStringExtra("strDiscount");
        strcriticalEdit = getIntent().getStringExtra("strcriticalEdit");
        strCriticalIllness = getIntent().getStringExtra("strCriticalIllness");
        strCriticalUnderSpinner = getIntent().getStringExtra("strCriticalUnderSpinner");
        strCriticalUnderSpinner2 = getIntent().getStringExtra("strCriticalUnderSpinner2");
        strperonalAccidentEdit = getIntent().getStringExtra("strperonalAccidentEdit");
        strPersonalAccidentSpinner = getIntent().getStringExtra("strPersonalAccidentSpinner");
        strpersonalUnder_spinner = getIntent().getStringExtra("strpersonalUnder_spinner");
        strpersonal_under_spinner2 = getIntent().getStringExtra("strpersonal_under_spinner2");
        strhospitalEdit = getIntent().getStringExtra("strhospitalEdit");
        strhospitalCashSpinner = getIntent().getStringExtra("strhospitalCashSpinner");
        strhospital_under_spinner = getIntent().getStringExtra("strhospital_under_spinner");
        strhospital_under_spinner2 = getIntent().getStringExtra("strhospital_under_spinner2");
        str_TotalValue = getIntent().getStringExtra("TotalValue");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        str_SumInsured = getIntent().getStringExtra("str_SumInsured");
        str_IndividualTypeEdit = getIntent().getStringExtra("str_IndividualTypeEdit");
        str_OneEditName = getIntent().getStringExtra("str_OneEditName");
        str_twoChildEditName = getIntent().getStringExtra("str_twoChildEditName");
        str_thirdNameEdit = getIntent().getStringExtra("str_thirdNameEdit");
        str_fourNameEdit = getIntent().getStringExtra("str_fourNameEdit");
        strFirstTString = getIntent().getStringExtra("strFirstTString");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        str_for = getIntent().getStringExtra("for");
        str_amountPersonalSumInsured = getIntent().getStringExtra("str_amountPersonalSumInsured");
        strhospitalEdit = getIntent().getStringExtra("strhospitalEdit");
        strcriticalEdit = getIntent().getStringExtra("strcriticalEdit");
        strSubLimitAmount = getIntent().getStringExtra("strSubLimitAmount");
        strDiscount = getIntent().getStringExtra("strDiscount");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        GST = getIntent().getStringExtra("GST");
        strProposerSpinner = getIntent().getStringExtra("strProposerSpinner");
        strContactNominee = getIntent().getStringExtra("strContactNominee");
        strNomineeName = getIntent().getStringExtra("strNomineeName");
        strbloodSugar = getIntent().getStringExtra("strbloodSugar");
        strbloodPressure = getIntent().getStringExtra("strbloodPressure");
        strbloodPressureDiastolic = getIntent().getStringExtra("strbloodPressureDiastolic");
        stredtcholesterol = getIntent().getStringExtra("stredtcholesterol");
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
        strChildOne = getIntent().getStringExtra("strChildOne");
        strChildTwo = getIntent().getStringExtra("strChildTwo");
        strChildThree = getIntent().getStringExtra("strChildThree");
        strChildFour = getIntent().getStringExtra("strChildFour");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
        strtwoWeightEdit = getIntent().getStringExtra("strtwoWeightEdit");
        str_thirdWeightEdit = getIntent().getStringExtra("str_thirdWeightEdit");
        strFourWeightEdit = getIntent().getStringExtra("strFourWeightEdit");
        strOneChild = getIntent().getStringExtra("strOneChild");
        strtwoDob = getIntent().getStringExtra("strtwoDob");
        strthreeDob = getIntent().getStringExtra("strthreeDob");
        strfourDob = getIntent().getStringExtra("strfourDob");
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
        str_amountPersonalSumInsured = getIntent().getStringExtra("str_amountPersonalSumInsured");
        strhospitalEdit = getIntent().getStringExtra("strhospitalEdit");
        strcriticalEdit = getIntent().getStringExtra("strcriticalEdit");
        strSubLimitAmount = getIntent().getStringExtra("strSubLimitAmount");
        strDiscount = getIntent().getStringExtra("strDiscount");
        new_str_age = getIntent().getStringExtra("new_str_age");
        PA_Status = getIntent().getStringExtra("PA_Status");
        PA_Status1 = getIntent().getStringExtra("PA_Status1");
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

        initView();
        Calendar calendar = Calendar.getInstance();

        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        Log.e("Today",today);


//        calendar.add(Calendar.DATE, 1);
//        date = calendar.getTime();
//        formatter = new SimpleDateFormat("dd/MM/yyyy");
//        tomorrowDate = formatter.format(date);
//        Log.e("tomorrowDate",tomorrowDate);
//
//        calendar.add(Calendar.DATE, 364);
//        date = calendar.getTime();
//        formatter = new SimpleDateFormat("dd/MM/yyyy");
//        nextYear = formatter.format(date);
//        Log.e("nextYear",nextYear);
    }

    private void initView() {
        totalAmount=findViewById(R.id.totalAmount);
        quotationId=findViewById(R.id.quotationId);
        btn_continue=findViewById(R.id.btn_continue);
        show_Breakup=findViewById(R.id.show_Breakup);


        strQuotationId=PosPolicyNo;

        totalAmount.setText(str_TotalValue);
        quotationId.setText(strQuotationId);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_TotalValue=totalAmount.getText().toString();
                strQuotationId=quotationId.getText().toString();

                hitPayment();
            }
        });

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Payment_Complete_healthCare.this);
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

        if (str_spouse_gender.equals("Select Gender")){
            str_spouse_gender="";
        }
        if (str_oneGenderSpinner.equals("Select Gender")){
            str_oneGenderSpinner="";
        }if (str_twoGenderSpinner.equals("Select Gender")){
            str_twoGenderSpinner="";
        }if (str_thirdGenderSpinner.equals("Select Gender")){
            str_thirdGenderSpinner="";
        }if (str_fourGenderSpinner.equals("Select Gender")){
            str_fourGenderSpinner="";
        }
         if(str_IndividualTypeEdit.equals("2 Adult")){
             InsuredType1="Adult";
         }else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
             InsuredType1="Adult";
         }else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
             InsuredType1="Adult";
         }else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
             InsuredType1="Adult";
         }else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
             InsuredType1="Adult";
         }

        if(CI_Status1 == null ||CI_Status1.equals("null")||CI_Status1.isEmpty()){
            CI_Status1="False";
        } if(DHC_Status1 == null ||DHC_Status1.equals("null")||DHC_Status1.isEmpty()){
            DHC_Status1="False";
        } if(PA_Status1 == null ||PA_Status1.equals("null")||PA_Status1.isEmpty()){
            PA_Status1="False";
        }
        if(CI_Status2 == null ||CI_Status2.equals("null")||CI_Status2.isEmpty()){
            CI_Status2="False";
        } if(DHC_Status2 == null ||DHC_Status2.equals("null")||DHC_Status2.isEmpty()){
            DHC_Status2="False";
        } if(PA_Status2 == null ||PA_Status2.equals("null")||PA_Status2.isEmpty()){
            PA_Status2="False";
        }
        if(CI_Status3 == null ||CI_Status3.equals("null")||CI_Status3.isEmpty()){
            CI_Status3="False";
        } if(DHC_Status3 == null ||DHC_Status3.equals("null")||DHC_Status3.isEmpty()){
            DHC_Status3="False";
        } if(PA_Status3 == null ||PA_Status3.equals("null")||PA_Status3.isEmpty()){
            PA_Status3="False";
        }
        if(CI_Status4 == null ||CI_Status4.equals("null")||CI_Status4.isEmpty()){
            CI_Status4="False";
        } if(DHC_Status4 == null ||DHC_Status4.equals("null")||DHC_Status4.isEmpty()){
            DHC_Status4="False";
        } if(PA_Status4 == null ||PA_Status4.equals("null")||PA_Status4.isEmpty()){
            PA_Status4="False";
        }
        if(CI_Status5 == null ||CI_Status5.equals("null")||CI_Status5.isEmpty()){
            CI_Status5="False";
        } if(DHC_Status5 == null ||DHC_Status5.equals("null")||DHC_Status5.isEmpty()){
            DHC_Status5="False";
        } if(PA_Status5 == null ||PA_Status5.equals("null")||PA_Status5.isEmpty()){
            PA_Status5="False";
        }
        if(str_OneEditName == null ||str_OneEditName.equals("null")||str_OneEditName.isEmpty()){
            str_OneEditName="";
        }

        if(strBMIAdultOneEdit == null ||strBMIAdultOneEdit.equals("null")||strBMIAdultOneEdit.isEmpty()){
            strBMIAdultOneEdit="";
        }if(strBMIChildEdit == null ||strBMIChildEdit.equals("null")||strBMIChildEdit.isEmpty()){
            strBMIChildEdit="";
        }if(strBMIChildTwoEdit == null ||strBMIChildTwoEdit.equals("null")||strBMIChildTwoEdit.isEmpty()){
            strBMIChildTwoEdit="";
        }if(strBMIEChildThreeEdit == null ||strBMIEChildThreeEdit.equals("null")||strBMIEChildThreeEdit.isEmpty()){
            strBMIEChildThreeEdit="";
        }if(strBMIFourChildEdit == null ||strBMIFourChildEdit.equals("null")||strBMIFourChildEdit.isEmpty()){
            strBMIFourChildEdit="";
        }

         if(strbloodSugarAdultTwo == null ||strbloodSugarAdultTwo.equals("null")||strbloodSugarAdultTwo.isEmpty()){
             strbloodSugarAdultTwo="";
         }if(strbloodPressureAdultTwo == null ||strbloodPressureAdultTwo.equals("null")||strbloodPressureAdultTwo.isEmpty()){
            strbloodPressureAdultTwo="";
        } if(strbloodPressureDiastolicAdultTwo == null ||strbloodPressureDiastolicAdultTwo.equals("null")||strbloodPressureDiastolicAdultTwo.isEmpty()){
            strbloodPressureDiastolicAdultTwo="";
        } if(strcholesterolAdultTwo == null ||strcholesterolAdultTwo.equals("null")||strcholesterolAdultTwo.isEmpty()){
            strcholesterolAdultTwo="";
        } if(strbloodSugarChildOne == null ||strbloodSugarChildOne.equals("null")||strbloodSugarChildOne.isEmpty()){
            strbloodSugarChildOne="";
        } if(strbloodPressureChildOne == null ||strbloodPressureChildOne.equals("null")||strbloodPressureChildOne.isEmpty()){
            strbloodPressureChildOne="";
        } if(strbloodPressureDiastolicChildOne == null ||strbloodPressureDiastolicChildOne.equals("null")||strbloodPressureDiastolicChildOne.isEmpty()){
            strbloodPressureDiastolicChildOne="";
        } if(strcholesterolChildOne == null ||strcholesterolChildOne.equals("null")||strcholesterolChildOne.isEmpty()){
             strcholesterolChildOne="";
         } if(strbloodSugarChildTwo == null ||strbloodSugarChildTwo.equals("null")||strbloodSugarChildTwo.isEmpty()){
             strbloodSugarChildTwo="";
         } if(strbloodPressureChildTwo == null ||strbloodPressureChildTwo.equals("null")||strbloodPressureChildTwo.isEmpty()){
             strbloodPressureChildTwo="";
         } if(strbloodPressureDiastolicChildTwo == null ||strbloodPressureDiastolicChildTwo.equals("null")||strbloodPressureDiastolicChildTwo.isEmpty()){
             strbloodPressureDiastolicChildTwo="";
         } if(strcholesterolChildTwo == null ||strcholesterolChildTwo.equals("null")||strcholesterolChildTwo.isEmpty()){
             strcholesterolChildTwo="";
         } if(strbloodSugarThirdChild == null ||strbloodSugarThirdChild.equals("null")||strbloodSugarThirdChild.isEmpty()){
             strbloodSugarThirdChild="";
         } if(strbloodPressureThirdChild == null ||strbloodPressureThirdChild.equals("null")||strbloodPressureThirdChild.isEmpty()){
             strbloodPressureThirdChild="";
         } if(strbloodPressureDiastolicThirdChild == null ||strbloodPressureDiastolicThirdChild.equals("null")||strbloodPressureDiastolicThirdChild.isEmpty()){
             strbloodPressureDiastolicThirdChild="";
         } if(strcholesterolThirdChild == null ||strcholesterolThirdChild.equals("null")||strcholesterolThirdChild.isEmpty()){
             strcholesterolThirdChild="";
         } if(strbloodSugarFourChild == null ||strbloodSugarFourChild.equals("null")||strbloodSugarFourChild.isEmpty()){
             strbloodSugarFourChild="";
         } if(strbloodPressureFourChild == null ||strbloodPressureFourChild.equals("null")||strbloodPressureFourChild.isEmpty()){
             strbloodPressureFourChild="";
         } if(strbloodPressureDiastolicFourChild == null ||strbloodPressureDiastolicFourChild.equals("null")||strbloodPressureDiastolicFourChild.isEmpty()){
             strbloodPressureDiastolicFourChild="";
         } if(strcholesterolFourChild == null ||strcholesterolFourChild.equals("null")||strcholesterolFourChild.isEmpty()){
             strcholesterolFourChild="";
         }




    }

    private void hitPayment() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("name",str_edt_name);
            object.put("phoneno",str_edt_phone);
            object.put("emailid",str_email);
            object.put("DOB",str_edit_dob);
            object.put("gender",str_gender);
            object.put("Occupation",str_occupation);
            object.put("Spouse_Name",str_edt_Spouse_name);
            object.put("Spouse_DOB",str_spouse_edit_dob_dob);
            object.put("Spouse_Gender",str_spouse_gender);
            object.put("Spouse_Occupation",str_spouse_occupation_spinner);
            object.put("Total_Premium",str_TotalValue);
            object.put("Proposal_Date",today);
            object.put("From_Date",tomorrowDate);
            object.put("To_Date",nextYear);
            object.put("Plan_Type",str_policyType_spinner);
            object.put("Floater_Type",str_IndividualTypeEdit);
            object.put("Sum_Insured",str_SumInsured);
            object.put("Policy_Duration",strFirstTString);
            object.put("PA_Status",PA_Status);
            object.put("CI_Status",CI_Status);
            object.put("DHC_Status",DHC_Status);
            object.put("Esale_Status",Esale_Status);
            object.put("Life_Status",Life_Status);
            object.put("PD_Status",PD_Status);
            object.put("Sub_Status",Sub_Status);
            object.put("Tiered_Status",Tiered_Status);
            object.put("Sub_Type",Sub_Type);
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
            object.put("Policy_Type",strSumInsuredTpeEDit);
            object.put("InsuredType","Adult");
            object.put("FirstName",strNomineeName);
            object.put("LastName","");
            object.put("Relationship",str_RelationEdit);
            object.put("Nominee_Relation",strProposerSpinner);
            object.put("pre_exist_Disease","N");
            object.put("BloodSugar",strbloodSugar);
            object.put("BloodpressureSys",strbloodPressure);
            object.put("BloodpressureDia",strbloodPressureDiastolic);
            object.put("Colestrol",stredtcholesterol);
            object.put("BMI",strBMIEdit);
            object.put("Tobacco_Alcohol","N");
            object.put("Comorbidity","N");
            object.put("InsuredType1",InsuredType1);
            object.put("FirstName1",str_edt_Spouse_name);
            object.put("LastName1","");
            object.put("gender1",str_spouse_gender);
            object.put("Occupation1",str_spouse_occupation_spinner);
            object.put("Relationship1",strRelationAdultOneEdit);
            object.put("pre_exist_Disease1","N");
            object.put("BloodSugar1",strbloodSugarAdultTwo);
            object.put("BloodpressureSys1",strbloodPressureAdultTwo);
            object.put("BloodpressureDia1",strbloodPressureDiastolicAdultTwo);
            object.put("Colestrol1",strcholesterolAdultTwo);
            object.put("BMI1",strBMIAdultOneEdit);
            object.put("Tobacco_Alcohol1","N");
            object.put("Comorbidity1","N");
            object.put("Present_Add_1",strAddressLine1);
            object.put("Present_Add_2",strAddressLine2);
            object.put("Present_State",strstateName);
            object.put("Present_City",strCityName);
            object.put("Present_PinCode",strpincode);
            object.put("Permanent_Add_1",strAddressLine1);
            object.put("Permanent_Add_2",strAddressLine2);
            object.put("Permanent_State",strstateName);
            object.put("Permanent_City",strCityName);
            object.put("Permanent_PinCode",strpincode);
            object.put("InsuredType2","");
            object.put("FirstName2",str_OneEditName);
            object.put("LastName2","");
            object.put("gender2",str_oneGenderSpinner);
            object.put("Occupation2","Student");
            object.put("Relationship2",strRelationChildEdit);
            object.put("pre_exist_Disease2","N");
            object.put("BloodSugar2",strbloodSugarChildOne);
            object.put("BloodpressureSys2",strbloodPressureChildOne);
            object.put("BloodpressureDia2",strbloodPressureDiastolicChildOne);
            object.put("Colestrol2",strcholesterolChildOne);
            object.put("BMI2",strBMIChildEdit);
            object.put("Tobacco_Alcohol2","N");
            object.put("Comorbidity2","N");
            object.put("InsuredType3","");
            object.put("FirstName3",str_twoChildEditName);
            object.put("LastName3","");
            object.put("gender3",str_twoGenderSpinner);
            object.put("Occupation3","Student");
            object.put("Relationship3",strRelationChildTwoEdit);
            object.put("pre_exist_Disease3","N");
            object.put("BloodSugar3",strbloodSugarChildTwo);
            object.put("BloodpressureSys3",strbloodPressureChildTwo);
            object.put("BloodpressureDia3",strbloodPressureDiastolicChildTwo);
            object.put("Colestrol3",strcholesterolChildTwo);
            object.put("BMI3",strBMIChildTwoEdit);
            object.put("Tobacco_Alcohol3","N");
            object.put("Comorbidity3","N");
            object.put("InsuredType4","");
            object.put("FirstName4",str_thirdNameEdit);
            object.put("gender4",str_thirdGenderSpinner);
            object.put("LastName4","");
            object.put("Occupation4","Student");
            object.put("Relationship4",strRelationChildThreeEdit);
            object.put("pre_exist_Disease4","N");
            object.put("BloodSugar4",strbloodSugarThirdChild);
            object.put("BloodpressureSys4",strbloodPressureThirdChild);
            object.put("BloodpressureDia4",strbloodPressureDiastolicThirdChild);
            object.put("Colestrol4",strcholesterolThirdChild);
            object.put("BMI4",strBMIEChildThreeEdit);
            object.put("Tobacco_Alcohol4","N");
            object.put("Comorbidity4","N");
            object.put("InsuredType5","");
            object.put("FirstName5",str_fourNameEdit);
            object.put("LastName5","");
            object.put("gender5",str_fourGenderSpinner);
            object.put("Occupation5","Student");
            object.put("Relationship5",strRelationFourChildEdit);
            object.put("pre_exist_Disease5","N");
            object.put("BloodSugar5",strbloodSugarFourChild);
            object.put("BloodpressureSys5",strbloodPressureFourChild);
            object.put("BloodpressureDia5",strbloodPressureDiastolicFourChild);
            object.put("Colestrol5",strcholesterolFourChild);
            object.put("BMI5",strBMIFourChildEdit);
            object.put("Tobacco_Alcohol5","N");
            object.put("Comorbidity5","N");
            object.put("BI_Status",BI_Status);
            object.put("BI_Status1",BI_Status1);
            object.put("BI_Status2",BI_Status2);
            object.put("BI_Status3",BI_Status3);
            object.put("BI_Status4",BI_Status4);
            object.put("BI_Status5",BI_Status5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Payment_Complete_healthCare.this, object, UrlHealthConstants.BUY_POLICY_COMPLETE_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestHealthConstants.BUY_POLICY_Complete_URL) {
                        try {
                            JSONObject jsonObject = object.getJSONObject("Authentication");
                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
                            JSONObject ProductJsonObject = object.getJSONObject("Product");
                            JSONObject GeneralProposalJsonObject = ProductJsonObject.getJSONObject("GeneralProposal");
                            JSONObject FinancierDetailsJsonObject = GeneralProposalJsonObject.getJSONObject("FinancierDetails");
                            JSONObject FinancierDtlGrpJsonObject = FinancierDetailsJsonObject.getJSONObject("FinancierDtlGrp");
                            JSONObject FinancierDtlGrpDataJsonObject = FinancierDtlGrpJsonObject.getJSONObject("FinancierDtlGrpData");
                            JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                            Log.e("gg", String.valueOf(PremiumCalculationJsonObject));
                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
                            Log.e("TotalPremium", String.valueOf(TotalPremiumJsonObject));
                            String WACode = jsonObject.getString("WACode");
                            Log.e("WACode", WACode);
                            String PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
                            Log.e("PosPolicyNo", PosPolicyNo);
                            String TotalValue = TotalPremiumJsonObject.getString("Value");
                            Log.e("TotalValue", TotalValue);

                            Intent intent=new Intent(Payment_Complete_healthCare.this, PaymentWebUrl.class);
                            intent.putExtra("WACode",WACode);
                            intent.putExtra("PosPolicyNo",PosPolicyNo);
                            intent.putExtra("TotalValue",str_TotalValue);
                            startActivity(intent);


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
        }, RequestHealthConstants.BUY_POLICY_Complete_URL);
        req.execute();

    }
//    private void hitPayment() {
//        JSONObject object = new JSONObject();
//        try {
//            object.put("TokenNo", pref.getToken_no());
//            object.put("Uid",pref.getUID());
//            object.put("Name",str_edt_name);
//            object.put("PhoneNo",str_edt_phone);
//            object.put("emailid",str_email);
//            object.put("DOB",str_edit_dob);
//            object.put("gender",str_gender);
//            object.put("Occupation",str_occupation);
//            object.put("Spouse_Name",str_edt_Spouse_name);
//            object.put("Spouse_DOB",str_spouse_edit_dob_dob);
//            object.put("Spouse_Gender",str_spouse_gender);
//            object.put("Spouse_Occupation",str_spouse_occupation_spinner);
//            object.put("Total_Premium",str_TotalValue);
//            object.put("Proposal_Date",today);
//            object.put("From_Date",tomorrowDate);
//            object.put("To_Date",nextYear);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ProjectVolleyRequest req = new ProjectVolleyRequest(Payment_Complete_healthCare.this, object, UrlHealthConstants.BUY_POLICY_COMPLETE_URL, new ResponseListener() {
//            @Override
//            public void onSuccess(JSONObject object, int Tag) {
//                if (object.optString("Status").equals("true")) {
//                    if (Tag == RequestHealthConstants.BUY_POLICY_Complete_URL) {
//                        try {
//                            JSONObject jsonObject = object.getJSONObject("Authentication");
//                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
//                            JSONObject ProductJsonObject = object.getJSONObject("Product");
//                            JSONObject GeneralProposalJsonObject = ProductJsonObject.getJSONObject("GeneralProposal");
//                            JSONObject FinancierDetailsJsonObject = GeneralProposalJsonObject.getJSONObject("FinancierDetails");
//                            JSONObject FinancierDtlGrpJsonObject = FinancierDetailsJsonObject.getJSONObject("FinancierDtlGrp");
//                            JSONObject FinancierDtlGrpDataJsonObject = FinancierDtlGrpJsonObject.getJSONObject("FinancierDtlGrpData");
//                            JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
//                            Log.e("gg", String.valueOf(PremiumCalculationJsonObject));
//                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
//                            Log.e("TotalPremium", String.valueOf(TotalPremiumJsonObject));
//                            String WACode = jsonObject.getString("WACode");
//                            Log.e("WACode", WACode);
//                            String PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
//                            Log.e("PosPolicyNo", PosPolicyNo);
//                            String TotalValue = TotalPremiumJsonObject.getString("Value");
//                            Log.e("TotalValue", TotalValue);
//
//                            Intent intent=new Intent(Payment_Complete_healthCare.this, PaymentWebUrl.class);
//                            intent.putExtra("WACode",WACode);
//                            intent.putExtra("PosPolicyNo",PosPolicyNo);
//                            intent.putExtra("TotalValue",str_TotalValue);
//                            startActivity(intent);
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                } else {
//                    Toast.makeText(getApplication(), "Cannot connect to Internet, please try again later", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onError(VolleyError error, int Tag) {
//
//            }
//        }, RequestHealthConstants.BUY_POLICY_Complete_URL);
//        req.execute();
//
//    }


}