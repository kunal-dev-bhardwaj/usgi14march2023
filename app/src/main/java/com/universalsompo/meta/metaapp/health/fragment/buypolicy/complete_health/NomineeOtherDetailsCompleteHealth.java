package com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.ArogyaNomineeOtherDetails;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_Payment;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class NomineeOtherDetailsCompleteHealth extends AppCompatActivity {
    String strAddDiscountBtn,strsecondAdultCritical_under_spinner2,strsOneChildCritical_under_spinner2,strtwoChildCritical_under_spinner2, strthirdChildCritical_under_spinner2,strfourChildCritical_under_spinner2,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2, strfourChildPersonal_under_spinner2,stroneChildhospital_under_spinner2,strtwoChildhospital_under_spinner2,strthirdChildhospital_under_spinner2,strfourChildhospital_under_spinner2,BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,PA_Status,CI_Status,DHC_Status,Esale_Status,Life_Status,Sub_Status,Sub_Type,Tiered_Status,PA_Status1,CI_Status1,DHC_Status1,PA_Status2,CI_Status2,DHC_Status2,PA_Status3,CI_Status3,DHC_Status3,PA_Status4,CI_Status4,DHC_Status4,PA_Status5,CI_Status5,DHC_Status5,new_str_age,ESaleDiscount,PD_Status,strSumInsuredTpeEDit,LifeStyleDiscountStr,LongTermDiscount, nextYear,tomorrowDate,strbloodSugarAdultTwo,strbloodPressureAdultTwo,strbloodPressureDiastolicAdultTwo,strcholesterolAdultTwo,strbloodSugarChildOne,strbloodPressureChildOne,strbloodPressureDiastolicChildOne,strcholesterolChildOne,strbloodSugarChildTwo,strbloodPressureChildTwo,strbloodPressureDiastolicChildTwo,strcholesterolChildTwo,strbloodSugarThirdChild,strbloodPressureThirdChild,strbloodPressureDiastolicThirdChild,strcholesterolThirdChild, strbloodSugarFourChild,strbloodPressureFourChild,strbloodPressureDiastolicFourChild,strcholesterolFourChild,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,str_nomineedob3String,strNominee_dob,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName;
    String strBMIEdit,strBMIAdultOneEdit,strBMIChildEdit,strBMIChildTwoEdit,strBMIEChildThreeEdit,strBMIFourChildEdit,strPriceTotal,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit,str_edit_dob3String,strProposerSpinner,strNomineeName,strContactNominee,strbloodSugar,strbloodPressure,strbloodPressureDiastolic,stredtcholesterol,NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for,strAddressLine1,strAddressLine2,strAddressLine3,strpincode,strCityName,strstateName;
    Date date;
    Format formatter;
    EditText Nominee_dob,NomineeName,ContactNominee,policyTypeEdit,familyTypeEdit,sumInsuredEdit,policyTenureEdit,totalPremiumAmount,QuotationID,hospitalCashSpinner,oneChildPersonal_under_Edit,twoChildPersonal_under_Edit,thirdChildPersonal_under_Edit,fourChildPersonal_under_Edit,editSumInsured,subLimitAmount,discountedit,criticalEdit,peronalAccidentEdit,hospitalEdit,editPersonalAccident,editPASpinner;
    TextView show_Breakup;
    EditText proposer_spinner;
     Button btn_continue;
     LinearLayout linerRelationShip;
    private SimpleDateFormat dateFormatter;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nominee_other_details_complete_health);
        getWindow().setStatusBarColor(ContextCompat.getColor(NomineeOtherDetailsCompleteHealth.this, R.color.colorPrimaryDark));
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
        linerRelationShip=findViewById(R.id.linerRelationShip);
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
        policyTypeEdit.setText(str_policyType_spinner);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        sumInsuredEdit.setText(str_SumInsured);
        policyTenureEdit.setText(strFirstTString+" Year");
        totalPremiumAmount.setText(str_TotalValue);
//        hospitalCashSpinner.setText(str_SumInsured);
        QuotationID.setText(PosPolicyNo);
//        hospitalCashSpinner.setAlpha(0.5f);
        policyTypeEdit.setAlpha(0.5f);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setAlpha(0.5f);

        if (str_for.equals("1")){
            proposer_spinner.setText(strProposerSpinner);
            NomineeName.setText(strNomineeName);
            ContactNominee.setText(strContactNominee);
            Nominee_dob.setText(strNominee_dob);
        }

        strProposerSpinner="Spouse";
        proposer_spinner.setText(strProposerSpinner);
        linerRelationShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(NomineeOtherDetailsCompleteHealth.this);
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

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(NomineeOtherDetailsCompleteHealth.this);
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
                  if (strNomineeName.equals("")){
                     Toast.makeText(NomineeOtherDetailsCompleteHealth.this, "Please Enter Nominee Name", Toast.LENGTH_SHORT).show();
                 }else  if (strContactNominee.equals("")){
                     Toast.makeText(NomineeOtherDetailsCompleteHealth.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                 }else if (strNominee_dob.equals("")){
                      Toast.makeText(NomineeOtherDetailsCompleteHealth.this, "Please Enter Nominee DOB", Toast.LENGTH_SHORT).show();
                  }else{
                      Intent intent=new Intent(NomineeOtherDetailsCompleteHealth.this, Payment_Complete_healthCare.class);
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
                      intent.putExtra("for","0");
                      startActivity(intent);
                      finish();
                  }


//                  else if (str_nomineedob3String != null) {
//                      int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_nomineedob3String);
//                      if (dateValidation < 18 || (dateValidation > 55)) {
//                          Toast.makeText(NomineeOtherDetailsCompleteHealth.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
//                          Nominee_dob.setText("");
//                      }else {
//                          Intent intent=new Intent(NomineeOtherDetailsCompleteHealth.this, Payment_Complete_healthCare.class);
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
        DatePickerDialog datePicker = new DatePickerDialog(NomineeOtherDetailsCompleteHealth.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
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
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(NomineeOtherDetailsCompleteHealth.this,PersonalHabbitCompleteHealthCare.class);
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