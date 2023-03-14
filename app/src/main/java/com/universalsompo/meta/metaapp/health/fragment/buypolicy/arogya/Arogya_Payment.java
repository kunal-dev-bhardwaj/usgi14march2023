package com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.NomineeOtherDetailsCompleteHealth;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Payment_Complete_healthCare;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.util.Date;
import java.util.Objects;

public class Arogya_Payment extends AppCompatActivity {
   EditText totalPremiumTxt,installmentAmountTxt,quotationIdTxt;
   String strParentEditText,strAppointeeNomineeName, strAppointeeNomineeDobEdit, strAppointeeGenderEdit,str_life_style_spinner,BMI,Individual_BMI,twoAdult_BMI,OneChildBMI,TwoChildBMI,ThreeChildBMI,FourChildBMI,strLoyaltyDiscount,str_policyTenure,str_Payment_spinner,new_str_age,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_edit_dob,str_occupation,str_gender,QuoteId,TotalPremium,TotalInstallPremium;
   Button btn_continue;
   String str_edit_dob3String,strProposerSpinner,strContactNominee,strNomineeName,strbloodSugar,strbloodPressure,strbloodPressureDiastolic,stredtcholesterol,NetPremiumValue,GST,str_amountPersonalSumInsured,str_for,str_reference_no="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_spouse_edit_dob_dob,
    str_existing_spinner,strExisting_policy_number,strNominee_dob,NetPremium, strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit,strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2,str_TotalValue,str_policyType_spinner,str_SumInsured,
            str_IndividualTypeEdit,str_OneEditName,str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,strFirstTString,PosPolicyNo,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit,strAddressLine1,strAddressLine2,strAddressLine3,strpincode,strCityName,strstateName;
    EditText totalAmount,quotationId;
    String strTotalAmount="",strQuotationId;
    MySharedPreference pref;
    CustomProgressDialog customprogress;
    String today,tomorrowDate,nextYear ;
    Date date;
    Format formatter;
    TextView show_Breakup;
    String  strMotherFtEdit,strFatherLawInchesEdit,strMotherInchesEdit,strFatherFtEdit,strFatherInchesEdit,strMotherLawFtEdit,strMotherLawInchesEdit,strFatherLawFtEdit,strMotherName,strMotherDob,strMotherOccupationEdit,strMotherWeightEdit,strFatherName,strFatherDob,strFatherWeightEdit, strFatherOccupationEdit,strMotherLawName,strMotherLawDob,strMotherLawOccupationEdit,strMotherLawWeightEdit,strFatherLawName, strFatherLawDob,strFatherLawOccupationEdit,strFatherLawWeightEdit,selectYearMother,selectYearFather,selectYearMotherLaw,selectYearFatherLaw, MotherBMI,FatherBMI,MotherLawBMI,FatherLawBMI;
    int selectNomineeYear,selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour,FamilyTypeCounter,ParentCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arogya__payment);
        getWindow().setStatusBarColor(ContextCompat.getColor(Arogya_Payment.this, R.color.colorPrimaryDark));
//        QuoteId = getIntent().getStringExtra("QuoteId");
//        TotalPremium = getIntent().getStringExtra("TotalPremium");
//        TotalInstallPremium = getIntent().getStringExtra("TotalInstallPremium");
//        str_edt_name = getIntent().getStringExtra("str_edt_name");
//        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
//        str_email = getIntent().getStringExtra("str_email");
//        str_age = getIntent().getStringExtra("str_age");
//        str_edit_dob = getIntent().getStringExtra("str_edit_dob");
//        str_gender = getIntent().getStringExtra("str_gender");
//        str_occupation = getIntent().getStringExtra("str_occupation");

        pref = MySharedPreference.getInstance(Arogya_Payment.this);
        customprogress = new CustomProgressDialog(Arogya_Payment.this);

        strParentEditText = getIntent().getStringExtra("strParentEditText");
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
        NetPremium = getIntent().getStringExtra("NetPremium");
        QuoteId = getIntent().getStringExtra("QuoteId");
        TotalInstallPremium = getIntent().getStringExtra("TotalInstallPremium");
        strNominee_dob = getIntent().getStringExtra("strNominee_dob");
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
        strOneChild = getIntent().getStringExtra("strOneChild");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
        strtwoDob = getIntent().getStringExtra("strtwoDob");
        strthreeDob = getIntent().getStringExtra("strthreeDob");
        strfourDob = getIntent().getStringExtra("strfourDob");
        strtwoWeightEdit = getIntent().getStringExtra("strtwoWeightEdit");
        str_thirdWeightEdit = getIntent().getStringExtra("str_thirdWeightEdit");
        strFourWeightEdit = getIntent().getStringExtra("strFourWeightEdit");
        new_str_age = getIntent().getStringExtra("new_str_age");
        str_Payment_spinner = getIntent().getStringExtra("str_Payment_spinner");
        str_policyTenure = getIntent().getStringExtra("str_policyTenure");
        strLoyaltyDiscount = getIntent().getStringExtra("strLoyaltyDiscount");
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
        FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
        ParentCounter = getIntent().getIntExtra("ParentCounter", 0);
        strAppointeeNomineeName = getIntent().getStringExtra("strAppointeeNomineeName");
        strAppointeeNomineeDobEdit = getIntent().getStringExtra("strAppointeeNomineeDobEdit");
        strAppointeeGenderEdit = getIntent().getStringExtra("strAppointeeGenderEdit");
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


        initView();

    }

    private void initView() {
        totalPremiumTxt=findViewById(R.id.totalPremiumTxt);
        installmentAmountTxt=findViewById(R.id.installmentAmountTxt);
        quotationIdTxt=findViewById(R.id.quotationIdTxt);
        btn_continue=findViewById(R.id.btn_continue);
        show_Breakup=findViewById(R.id.show_Breakup);

        totalPremiumTxt.setText(str_TotalValue);
        installmentAmountTxt.setText(TotalInstallPremium);
        quotationIdTxt.setText(QuoteId);



        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveProposalWA_Payment();
            }
        });
        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Arogya_Payment.this);
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
//                criticalEdit.setText("0");
//                premiumEdit.setText("0");
//                hospitalEdit.setText("0");
//                subLimitAmount.setText("0");
                totalAmount.setText(str_TotalValue);
//                tiedHospital.setText("0");
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

    private void SaveProposalWA_Payment() {
        JSONObject object = new JSONObject();
        try {
            JSONObject customerdetails=new JSONObject();
            customerdetails.put("CustomerId", "");
            customerdetails.put("CustomerName", str_edt_name);
            customerdetails.put("MobileNo", str_edt_phone);
            customerdetails.put("emailid", str_email);
            customerdetails.put("Gender", str_gender);
            customerdetails.put("DOB", str_edit_dob);
            customerdetails.put("Occupation", str_occupation);
            customerdetails.put("AddressLine1", strAddressLine1);
            customerdetails.put("AddressLine2", strAddressLine2);
            customerdetails.put("AddressLine3", strAddressLine3);
            customerdetails.put("Landmark", "");
            customerdetails.put("StateName", "Maharashtra");
            customerdetails.put("NumStateCd", "0");
            customerdetails.put("CityName", strCityName);
            customerdetails.put("numCityCD", "0");
            customerdetails.put("CountryName", "INDIA");
            customerdetails.put("numCountrycd", "0");
            customerdetails.put("Pincode", strpincode);
            customerdetails.put("QuoteId", QuoteId);
            customerdetails.put("InsertUpdateFlag", "");
            customerdetails.put("WebArggCode", "");
            customerdetails.put("WebArggAppCode", "");
            customerdetails.put("AgeBand", str_age);
            object.put("customerdetails",customerdetails);
            JSONObject nomineedetails=new JSONObject();
            nomineedetails.put("QuoteId",QuoteId);
            nomineedetails.put("NomineeName",strNomineeName);
            nomineedetails.put("NomineeDOB",strNominee_dob);
            nomineedetails.put("NomineeRelation",strProposerSpinner);
            nomineedetails.put("NomineeStatus","");
            object.put("nomineedetails",nomineedetails);
            object.put("PolicyNumber","");
            object.put("TotalPremium","");
            JSONObject authenticate=new JSONObject();
            authenticate.put("WebAggregatorCode","20000001");
            authenticate.put("WAApplicationCode","30000011");
            authenticate.put("WAUserID","USER01");
            authenticate.put("WAUserPassword","pass@123");
            authenticate.put("WAType","0");
            object.put("authenticate",authenticate);
            object.put("ProposalNo","");
            object.put("QuoteNo",QuoteId);
            object.put("ErrorMessage","");
    } catch (Exception e) {
        e.printStackTrace();
    }
      ProjectVolleyRequest req = new ProjectVolleyRequest(Arogya_Payment.this, object, UrlHealthConstants.Arogya_SaveProposalWA_URL, new ResponseListener() {
        @Override
        public void onSuccess(JSONObject object, int Tag) {
            if (object.optString("ErrorMessage").equals("null")) {
                if (Tag == RequestHealthConstants.Arogya_Buy_URL) {

                    String TotalPremium = object.optString("TotalPremium");
                    String ProposalNo = object.optString("ProposalNo");
                    Intent intent = new Intent(Arogya_Payment.this, PaymentWebUrl.class);
                    intent.putExtra("WACode","20000001");
                    intent.putExtra("TotalValue",TotalPremium);
                    intent.putExtra("PosPolicyNo",ProposalNo);
                    intent.putExtra("checkPage","Summery");
                    intent.putExtra("checkPayment","Arogya");
                    startActivity(intent);


                }
            }else {
                Toast.makeText(getApplication(), "Cannot connect to Internet, please try again later", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onError(VolleyError error, int Tag) {

        }
    }, RequestHealthConstants.Arogya_Buy_URL);
        req.execute();

}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Arogya_Payment.this, ArogyaNomineeOtherDetails.class);
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
        intent.putExtra("NetPremium",NetPremium);
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
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("strNominee_dob",strNominee_dob);
        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("QuoteId",QuoteId);
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
        intent.putExtra("for","1");
        startActivity(intent);
        finish();
    }
}