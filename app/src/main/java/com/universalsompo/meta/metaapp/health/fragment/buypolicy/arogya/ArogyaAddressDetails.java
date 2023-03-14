package com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.AddressCompleteHealth;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class ArogyaAddressDetails extends AppCompatActivity {
    String strParentEditText,str_life_style_spinner,str_Payment_spinner,new_str_age,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,strOneChild,str_oneWeightEdit,strtwoDob,strthreeDob,strfourDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,GST,strAnyDisease="",strAnyhabitual,strSubLimit,strnoDiabetes,strnoSpouseDiabetes,strNoHypertension,strNoSpouseHypertension,strNoCholesterol,strNoSpouseCholesterol,strforSelf,strforSpouse,strSubLimitAmount,strAnyTreatment,strDiscount,strcriticalEdit, strCriticalIllness,strCriticalUnderSpinner,strCriticalUnderSpinner2,strperonalAccidentEdit,strPersonalAccidentSpinner,strpersonalUnder_spinner,strpersonal_under_spinner2,strhospitalEdit,strhospitalCashSpinner,strhospital_under_spinner,strhospital_under_spinner2, strOneChildCriticalIllnessTxt,stroneChildTxt,str_twoChildEditName,stroneChildPersonal_under_spinner2,strtwoChildPersonal_under_spinner2,strthirdChildPersonal_under_spinner2,strfourChildPersonal_under_spinner2;
    String BMI,Individual_BMI,twoAdult_BMI,OneChildBMI,TwoChildBMI,ThreeChildBMI,FourChildBMI,strLoyaltyDiscount,str_policyTenure,str_existing_spinner,strExisting_policy_number,strNominee_dob,NetPremium,TotalPremium,TotalInstallPremium,QuoteId,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit,str_edit_dob3String,strProposerSpinner,strNomineeName,strContactNominee,strbloodSugar,strbloodPressure,strbloodPressureDiastolic,stredtcholesterol,NetPremiumValue,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,
            str_spouse_edit_dob_dob,str_policyType_spinner,str_SumInsured, streditPASpinner,str_amountPersonalSumInsured,str_IndividualTypeEdit,str_OneEditName,str_thirdNameEdit,str_fourNameEdit,str_TotalValue,strFirstTString,PosPolicyNo,strChildOne,strChildTwo,strChildThree,strChildFour,today,strThirdDString,str_for,strAddressLine1,strAddressLine2,strAddressLine3,strpincode,strCityName,strstateName;
    EditText Payment_spinner,policyTypeEdit,familyTypeEdit,sumInsuredEdit,policyTenureEdit,totalPremiumAmount,QuotationID,addressLine1,addressLine2,addressLine3,pincode,CityName,stateName,subLimitAmount,discountedit,criticalEdit,peronalAccidentEdit,hospitalEdit,editPersonalAccident,editPASpinner;
    TextView show_Breakup;
    Date date;
    Format formatter;
    Button btn_continue;
    private MySharedPreference pref;
    CustomProgressDialog customprogress;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour,FamilyTypeCounter,ParentCounter;
    String strMotherFtEdit,strFatherLawInchesEdit,strMotherInchesEdit,strFatherFtEdit,strFatherInchesEdit,strMotherLawFtEdit,strMotherLawInchesEdit,strFatherLawFtEdit,strMotherName,strMotherDob,strMotherOccupationEdit,strMotherWeightEdit,strFatherName,strFatherDob,strFatherWeightEdit, strFatherOccupationEdit,strMotherLawName,strMotherLawDob,strMotherLawOccupationEdit,strMotherLawWeightEdit,strFatherLawName, strFatherLawDob,strFatherLawOccupationEdit,strFatherLawWeightEdit,selectYearMother,selectYearFather,selectYearMotherLaw,selectYearFatherLaw, MotherBMI,FatherBMI,MotherLawBMI,FatherLawBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arogya_address_details);
        getWindow().setStatusBarColor(ContextCompat.getColor(ArogyaAddressDetails.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(ArogyaAddressDetails.this);
        customprogress = new CustomProgressDialog(ArogyaAddressDetails.this);

        strParentEditText = getIntent().getStringExtra("strParentEditText");
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
        TotalInstallPremium = getIntent().getStringExtra("TotalInstallPremium");
        QuoteId = getIntent().getStringExtra("QuoteId");
        TotalPremium = getIntent().getStringExtra("TotalPremium");
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
        policyTypeEdit=findViewById(R.id.policyTypeEdit);
        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        show_Breakup=findViewById(R.id.show_Breakup);
        QuotationID=findViewById(R.id.QuotationID);
        addressLine1=findViewById(R.id.addressLine1);
        addressLine2=findViewById(R.id.addressLine2);
        addressLine3=findViewById(R.id.addressLine3);
        pincode=findViewById(R.id.pincode);
        CityName=findViewById(R.id.CityName);
        stateName=findViewById(R.id.stateName);
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
            addressLine1.setText(strAddressLine1);
            addressLine2.setText(strAddressLine2);
            addressLine3.setText(strAddressLine3);
            pincode.setText(strpincode);
            CityName.setText(strCityName);
            stateName.setText(strstateName);
        }
        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(ArogyaAddressDetails.this);
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
        pincode.addTextChangedListener(new TextWatcher() {

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
                Is_Valid_refer(pincode); // pass your EditText Obj here.
            }

            public void Is_Valid_refer(EditText edt_refer) {
                if (edt_refer.length()== 6) {
                    strpincode = edt_refer.getText().toString();
                    pincodeURL();
                } else  if (edt_refer.getText().toString().equals("")) {
                    Toast.makeText(ArogyaAddressDetails.this, "Please Enter 6 Digit PinCode/ZipCode", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strAddressLine1=addressLine1.getText().toString();
                strAddressLine2=addressLine2.getText().toString();
                strAddressLine3=addressLine3.getText().toString();
                strpincode=pincode.getText().toString();
                strCityName=CityName.getText().toString();
                strstateName=stateName.getText().toString();

                if (strAddressLine1.equals("")){
                    Toast.makeText(ArogyaAddressDetails.this, "Please Enter Address Line 1", Toast.LENGTH_SHORT).show();
                }else if (strAddressLine2.equals("")){
                    Toast.makeText(ArogyaAddressDetails.this, "Please Enter Address Line 2", Toast.LENGTH_SHORT).show();
                }else if (strAddressLine3.equals("")){
                    Toast.makeText(ArogyaAddressDetails.this, "Please Enter HouseNo/LandMark", Toast.LENGTH_SHORT).show();
                }else if (strpincode.equals("")){
                    Toast.makeText(ArogyaAddressDetails.this, "Please Enter PinCode/ZipCode", Toast.LENGTH_SHORT).show();
                }else if (strCityName.equals("")){
                    Toast.makeText(ArogyaAddressDetails.this, "Please Enter City Name", Toast.LENGTH_SHORT).show();
                }else if (strstateName.equals("")){
                    Toast.makeText(ArogyaAddressDetails.this, "Please Enter State Name", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(ArogyaAddressDetails.this, ArogyaMedicalHistory.class);
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
                    intent.putExtra("strAddressLine1",strAddressLine1);
                    intent.putExtra("strAddressLine2",strAddressLine2);
                    intent.putExtra("strAddressLine3",strAddressLine3);
                    intent.putExtra("strpincode",strpincode);
                    intent.putExtra("strCityName",strCityName);
                    intent.putExtra("strstateName",strstateName);
                    intent.putExtra("QuoteId",QuoteId);
                    intent.putExtra("NetPremium",NetPremium);
                    intent.putExtra("TotalPremium",TotalPremium);
                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
                    intent.putExtra("strNominee_dob",strNominee_dob);
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
                    intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                    intent.putExtra("str_existing_spinner",str_existing_spinner);
                    intent.putExtra("selectYearAdult",selectYearAdult);
                    intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                    intent.putExtra("selectYearChild",selectYearChild);
                    intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                    intent.putExtra("selectYearChildThird",selectYearChildThird);
                    intent.putExtra("selectYearChildFour",selectYearChildFour);
                    intent.putExtra("strParentEditText",strParentEditText);
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
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ArogyaAddressDetails.this, Arogya_Medical_Discount.class);
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
        intent.putExtra("strAddressLine1",strAddressLine1);
        intent.putExtra("strAddressLine2",strAddressLine2);
        intent.putExtra("strAddressLine3",strAddressLine3);
        intent.putExtra("strpincode",strpincode);
        intent.putExtra("strCityName",strCityName);
        intent.putExtra("strstateName",strstateName);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("TotalPremium",TotalPremium);
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
        intent.putExtra("strParentEditText",strParentEditText);
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
    private void pincodeURL() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("pincode",strpincode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(ArogyaAddressDetails.this, object, UrlHealthConstants.GetStateCity_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("true")) {
                    if (Tag == RequestHealthConstants.GetCity) {
                        try {
                            strCityName = object.getString("CityName");
                            strstateName= object.getString("StateName");
                            CityName.setText(strCityName);
                            stateName.setText(strstateName);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(getApplication(), "PinCode is Wrong "+object.optString("Message"), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestHealthConstants.GetCity);
        req.execute();

    }

}