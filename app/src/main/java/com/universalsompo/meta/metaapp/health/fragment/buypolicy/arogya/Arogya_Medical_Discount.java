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
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.Health_Insurance_Renewal;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Medical_Complete_health;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Payment_Complete_healthCare;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Arogya_Medical_Discount extends AppCompatActivity {
   Button btn_continue;
    String strParentEditText,str_oneOccupationSpinner,str_twoOccupationSpinner,str_thirdOccupationSpinner,str_fourOccupationSpinner,BMI,Individual_BMI,twoAdult_BMI,OneChildBMI,TwoChildBMI,ThreeChildBMI,FourChildBMI,str_policyTenure,str_Payment_spinner,new_str_age,str_oneGenderSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_twoGenderSpinner,str_twoFtSpinner,str_twoInchesSpinner,str_thirdGenderSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_fourGenderSpinner,str_fourFtSpinner,str_fourInchesSpinner,strNominee_dob,strExisting_policy_number,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_family_individual="",str_edit_adult="",str_no_child="",str_no_parent="",str_deductible="",str_sum_insured="",str_premium_amount="",
            strLoyaltyDiscount,str_life_style_spinner="",str_existing_policy_amount="",str_existing_spinner="",str_edit_dob="",str_gender="",str_self="",str_occupation="",str_weight_edit="",str_spouse_edit_dob_dob,str_spouse_weight_edit,str_edt_Spouse_name,str_spouse_gender,str_ft,str_inches,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_edit,str_proposer_self_spinner,NetPremium,
            TotalPremium,QuoteId,str_policyType_spinner,str_SumInsured,str_IndividualTypeEdit,  str_OneEditName, str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,TotalValue,strFirstTString,PosPolicyNo,str_for,strRelationFourChildEdit,strRelationChildThreeEdit,strRelationChildTwoEdit,strRelationChildEdit, strRelationAdultOneEdit,str_RelationEdit,GST,strFourWeightEdit,str_thirdWeightEdit,strtwoWeightEdit,strfourDob,strthreeDob,strtwoDob, strOneChild,str_oneWeightEdit,NetPremiumValue,strChildFour,strChildThree,strChildTwo,strChildOne,str_edit_dob3String;
    String[] select;
    EditText life_style_spinner,existing_spinner,Payment_spinner,policyTypeEdit,existing_policy_number,familyTypeEdit,sumInsuredEdit,policyTenureEdit,totalPremiumAmount,QuotationID,existing_policy_amount;
     MySharedPreference pref;
    CustomProgressDialog customprogress;
    String TotalInstallPremium="";
    LinearLayout loyaltyLiner,life_style_spinnerLiner,existing_spinnerLiner;
    TextView show_Breakup;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour,FamilyTypeCounter,ParentCounter;
    String strMotherFtEdit,strFatherLawInchesEdit,strMotherInchesEdit,strFatherFtEdit,strFatherInchesEdit,strMotherLawFtEdit,strMotherLawInchesEdit,strFatherLawFtEdit,strMotherName,strMotherDob,strMotherOccupationEdit,strMotherWeightEdit,strFatherName,strFatherDob,strFatherWeightEdit, strFatherOccupationEdit,strMotherLawName,strMotherLawDob,strMotherLawOccupationEdit,strMotherLawWeightEdit,strFatherLawName, strFatherLawDob,strFatherLawOccupationEdit,strFatherLawWeightEdit,selectYearMother,selectYearFather,selectYearMotherLaw,selectYearFatherLaw, MotherBMI,FatherBMI,MotherLawBMI,FatherLawBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arogya__medical__discount);
        getWindow().setStatusBarColor(ContextCompat.getColor(Arogya_Medical_Discount.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(Arogya_Medical_Discount.this);
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
        strOneChild = getIntent().getStringExtra("strOneChild");
        str_oneWeightEdit = getIntent().getStringExtra("str_oneWeightEdit");
        strtwoDob = getIntent().getStringExtra("strtwoDob");
        strthreeDob = getIntent().getStringExtra("strthreeDob");
        strfourDob = getIntent().getStringExtra("strfourDob");
        strtwoWeightEdit = getIntent().getStringExtra("strtwoWeightEdit");
        str_thirdWeightEdit = getIntent().getStringExtra("str_thirdWeightEdit");
        strFourWeightEdit = getIntent().getStringExtra("strFourWeightEdit");
        GST = getIntent().getStringExtra("GST");
        str_RelationEdit = getIntent().getStringExtra("str_RelationEdit");
        strRelationAdultOneEdit = getIntent().getStringExtra("strRelationAdultOneEdit");
        strRelationChildEdit = getIntent().getStringExtra("strRelationChildEdit");
        strRelationChildTwoEdit = getIntent().getStringExtra("strRelationChildTwoEdit");
        strRelationChildThreeEdit = getIntent().getStringExtra("strRelationChildThreeEdit");
        strRelationFourChildEdit = getIntent().getStringExtra("strRelationFourChildEdit");
        str_for = getIntent().getStringExtra("for");
        TotalValue = getIntent().getStringExtra("TotalValue");
        strFirstTString = getIntent().getStringExtra("strFirstTString");
        TotalPremium = getIntent().getStringExtra("TotalPremium");
        TotalInstallPremium = getIntent().getStringExtra("TotalInstallPremium");
        NetPremium = getIntent().getStringExtra("NetPremium");
        QuoteId = getIntent().getStringExtra("QuoteId");
        strNominee_dob = getIntent().getStringExtra("strNominee_dob");
        str_existing_spinner = getIntent().getStringExtra("str_existing_spinner");
        strExisting_policy_number = getIntent().getStringExtra("strExisting_policy_number");
        strLoyaltyDiscount = getIntent().getStringExtra("strLoyaltyDiscount");
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

        init();
    }

    private void init() {
        btn_continue=findViewById(R.id.btn_continue);
        life_style_spinner=findViewById(R.id.life_style_spinner);
        existing_spinner=findViewById(R.id.existing_spinner);
        existing_policy_amount=findViewById(R.id.existing_policy_amount);
        policyTypeEdit=findViewById(R.id.policyTypeEdit);
        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        existing_policy_number=findViewById(R.id.existing_policy_number);
        Payment_spinner=findViewById(R.id.Payment_spinner);
        QuotationID=findViewById(R.id.QuotationID);
        loyaltyLiner=findViewById(R.id.loyaltyLiner);
        life_style_spinnerLiner=findViewById(R.id.life_style_spinnerLiner);
        existing_spinnerLiner=findViewById(R.id.existing_spinnerLiner);
        show_Breakup=findViewById(R.id.show_Breakup);

//        existing_policy_amount.setText(TotalPremium);


        policyTypeEdit.setText(str_policyType_spinner);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        sumInsuredEdit.setText(str_SumInsured);
        policyTenureEdit.setText(strFirstTString+" Year");
        totalPremiumAmount.setText(TotalValue);
        QuotationID.setText(QuoteId);
        policyTypeEdit.setAlpha(0.5f);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setAlpha(0.5f);
        Payment_spinner.setText(str_Payment_spinner);
        Payment_spinner.setAlpha(0.5f);

//        select=getResources().getStringArray(R.array.select);
//        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.spinner_item_text,select);
//        life_style_spinner.setAdapter(adapter);
//        existing_spinner.setAdapter(adapter);


        if(str_for.equals("0")) {
            str_life_style_spinner="Select";
            life_style_spinner.setText(str_life_style_spinner);
            str_existing_spinner="Select";
            existing_spinner.setText(str_existing_spinner);
        }else {
            life_style_spinner.setText(str_life_style_spinner);
            existing_spinner.setText(str_existing_spinner);
            if (str_existing_spinner.equals("Select")){
                loyaltyLiner.setVisibility(View.GONE);
            }else if (str_existing_spinner.equals("Yes")){
                loyaltyLiner.setVisibility(View.VISIBLE);
                existing_policy_number.setText(strExisting_policy_number);
                existing_policy_amount.setText(strLoyaltyDiscount);
            }else{
                loyaltyLiner.setVisibility(View.GONE);
            }
        }


        life_style_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Medical_Discount.this);
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
                            final Dialog alert_dialog = new Dialog(Arogya_Medical_Discount.this);
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

        existing_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Arogya_Medical_Discount.this);
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
                        str_existing_spinner=items1.get(options1);
                        existing_spinner.setText(str_existing_spinner);
                        if (str_existing_spinner.equals("Select")){
                            loyaltyLiner.setVisibility(View.GONE);
                        }else if (str_existing_spinner.equals("Yes")){
                            loyaltyLiner.setVisibility(View.VISIBLE);
                        }else{
                            loyaltyLiner.setVisibility(View.GONE);
                        }
                    }
                });
                singlePicker.show();

            }
        });


//else if (existing_policy_amount.equals("")){
//            Toast.makeText(Arogya_Medical_Discount.this, "Enter Loyalty Discount", Toast.LENGTH_SHORT).show();
//        }else if (strExisting_policy_number.equals("")){
//            Toast.makeText(Arogya_Medical_Discount.this, "Enter Policy Number", Toast.LENGTH_SHORT).show();
//        }else if (!strExisting_policy_number.contains("/")){
//            Toast.makeText(Arogya_Medical_Discount.this, "Enter Valid Policy Number", Toast.LENGTH_SHORT).show();
//        }
        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Arogya_Medical_Discount.this);
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
                    btn_continue.setVisibility(View.VISIBLE);
                    linerExisting.setVisibility(View.GONE);
                }
                installmentAmount.setText(TotalInstallPremium);
                basicPremium.setText(NetPremium);
//                criticalEdit.setText("0");
//                premiumEdit.setText("0");
//                hospitalEdit.setText("0");
//                subLimitAmount.setText("0");
                totalAmount.setText(TotalValue);
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
                        Toast.makeText(Arogya_Medical_Discount.this, "Please Enter Existing Policy Number", Toast.LENGTH_SHORT).show();
                     }else{
                         SaveQuotationWA();
                     }
                } else  if (edt_refer.getText().toString().equals("")) {
                    Toast.makeText(Arogya_Medical_Discount.this, "Please Enter Existing Policy Number", Toast.LENGTH_SHORT).show();
                }
            }
        });



        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              strExisting_policy_number=existing_policy_number.getText().toString();
                if (str_life_style_spinner.equals("Select")){
                    Toast.makeText(Arogya_Medical_Discount.this, "Please Select Medical Condition", Toast.LENGTH_SHORT).show();
                }else if (str_existing_spinner.equals("Select")){
                   Toast.makeText(Arogya_Medical_Discount.this, "Please Select Existing Policy No", Toast.LENGTH_SHORT).show();
                }else{
                   Intent intent = new Intent(Arogya_Medical_Discount.this, ArogyaAddressDetails.class);
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
                    intent.putExtra("GST",GST);
                    intent.putExtra("str_RelationEdit",str_RelationEdit);
                    intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                    intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                    intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                    intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                    intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                    intent.putExtra("PosPolicyNo",PosPolicyNo);
                    intent.putExtra("QuoteId",QuoteId);
                    intent.putExtra("NetPremium",NetPremium);
                    intent.putExtra("TotalPremium",TotalPremium);
                    intent.putExtra("TotalInstallPremium",TotalInstallPremium);
                    intent.putExtra("for","0");
                   intent.putExtra("strFirstTString",strFirstTString);
                   intent.putExtra("strNominee_dob",strNominee_dob);
                   intent.putExtra("strExisting_policy_number",strExisting_policy_number);
                   intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
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
                    intent.putExtra("new_str_age",new_str_age);
                    intent.putExtra("str_Payment_spinner",str_Payment_spinner);
                    intent.putExtra("str_policyTenure",str_policyTenure);
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
                   startActivity(intent);
                   finish();
               }


//                Intent intent=new Intent(Arogya_Medical_Discount.this, Arogya_Payment.class);
//                startActivity(intent);
//                Arogya_Medical_Discount.this.finish();
            }
        });
    }

    private void SaveQuotationWA() {
        JSONObject object = new JSONObject();
        try {
            object.put("QuoteId","");
            object.put("ProductCode","2851");
            object.put("PolicyType",str_policyType_spinner);
            object.put("FamilyCombo","");
            object.put("PlanType",str_IndividualTypeEdit);
            object.put("PolicyDuration",str_policyTenure);
            object.put("IsPED","No");
            object.put("BasicPremium","");
            object.put("NetPremium","");
            object.put("GST","");
            object.put("TotalPremium","");
            object.put("UpdateFlag","");
            object.put("PageName","");
            object.put("RedirectUrl","");
            object.put("ProposalNo","");
            object.put("PolicyNo","");
            object.put("IsSameProposer","Yes");
            object.put("ProposerName","Prafulla");
            object.put("ProposerRelation","Brother");
            object.put("InstallmentFrequency",str_Payment_spinner);
            object.put("IsLoyatyDicsount",str_existing_spinner);
            object.put("ExistingPolicyNo",strExisting_policy_number);
            JSONArray array=new JSONArray();
            if(str_IndividualTypeEdit.equals("1 Adult")){
                JSONObject obj=new JSONObject();
                obj.put("Name",str_edt_name);
                obj.put("DOB",str_edit_dob);
                obj.put("Gender",str_gender);
                obj.put("HeightInFeet",str_ft);
                obj.put("HeightInInches",str_inches);
                obj.put("Weight",str_weight_edit);
                obj.put("BMI",BMI);
                obj.put("Occupation",str_occupation);
                obj.put("Relation",str_RelationEdit);
                obj.put("SumInsured",str_SumInsured);
                array.put(obj);
            }
            else if (str_policyType_spinner.equals("Family Floater")){
                if(str_IndividualTypeEdit.equals("2 Adult")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("Name",str_fourNameEdit);
                    objChild4.put("DOB",strfourDob);
                    objChild4.put("Gender",str_fourGenderSpinner);
                    objChild4.put("HeightInFeet",str_fourFtSpinner);
                    objChild4.put("HeightInInches",str_fourInchesSpinner);
                    objChild4.put("Weight",strFourWeightEdit);
                    objChild4.put("BMI",FourChildBMI);
                    objChild4.put("Occupation",str_fourOccupationSpinner);
                    objChild4.put("Relation",strRelationFourChildEdit);
                    objChild4.put("SumInsured",str_SumInsured);
                    array.put(objChild4);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",str_edit_dob);
                    obj.put("Gender",str_gender);
                    obj.put("HeightInFeet",str_ft);
                    obj.put("HeightInInches",str_inches);
                    obj.put("Weight",str_weight_edit);
                    obj.put("BMI",Individual_BMI);
                    obj.put("Occupation",str_occupation);
                    obj.put("Relation",str_RelationEdit);
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_Spouse_name);
                    objAdult2.put("DOB",str_spouse_edit_dob_dob);
                    objAdult2.put("Gender",str_spouse_gender);
                    objAdult2.put("HeightInFeet",str_spouse_ft_spinner);
                    objAdult2.put("HeightInInches",str_spouse_inches_spinner);
                    objAdult2.put("Weight",str_spouse_weight_edit);
                    objAdult2.put("BMI",twoAdult_BMI);
                    objAdult2.put("Occupation",str_spouse_occupation_spinner);
                    objAdult2.put("Relation",strRelationAdultOneEdit);
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_OneEditName);
                    objChild1.put("DOB",strOneChild);
                    objChild1.put("Gender",str_oneGenderSpinner);
                    objChild1.put("HeightInFeet",str_oneFtSpinner);
                    objChild1.put("HeightInInches",str_oneInchesSpinner);
                    objChild1.put("Weight",str_oneWeightEdit);
                    objChild1.put("BMI",OneChildBMI);
                    objChild1.put("Occupation",str_oneOccupationSpinner);
                    objChild1.put("Relation",strRelationChildEdit);
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_twoChildEditName);
                    objChild2.put("DOB",strtwoDob);
                    objChild2.put("Gender",str_twoGenderSpinner);
                    objChild2.put("HeightInFeet",str_twoInchesSpinner);
                    objChild2.put("HeightInInches",str_twoInchesSpinner);
                    objChild2.put("Weight",strtwoWeightEdit);
                    objChild2.put("BMI",TwoChildBMI);
                    objChild2.put("Occupation",str_twoOccupationSpinner);
                    objChild2.put("Relation",strRelationChildTwoEdit);
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_thirdNameEdit);
                    objChild3.put("DOB",strthreeDob);
                    objChild3.put("Gender",str_thirdGenderSpinner);
                    objChild3.put("HeightInFeet",str_thirdFtSpinner);
                    objChild3.put("HeightInInches",str_thirdInchesSpinner);
                    objChild3.put("Weight",str_thirdWeightEdit);
                    objChild3.put("BMI",ThreeChildBMI);
                    objChild3.put("Occupation",str_thirdOccupationSpinner);
                    objChild3.put("Relation",strRelationChildThreeEdit);
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("Name",str_fourNameEdit);
                    objChild4.put("DOB",strfourDob);
                    objChild4.put("Gender",str_fourGenderSpinner);
                    objChild4.put("HeightInFeet",str_fourFtSpinner);
                    objChild4.put("HeightInInches",str_fourInchesSpinner);
                    objChild4.put("Weight",strFourWeightEdit);
                    objChild4.put("BMI",FourChildBMI);
                    objChild4.put("Occupation",str_fourOccupationSpinner);
                    objChild4.put("Relation",strRelationFourChildEdit);
                    objChild4.put("SumInsured",str_SumInsured);
                    array.put(objChild4);
                }
            }
            object.put("asiQouteInsuredInfo",array);
            JSONObject Customer_Details_obj=new JSONObject();
            Customer_Details_obj.put("CustomerId","");
            Customer_Details_obj.put("CustomerName","");
            object.put("CustomerDetails",Customer_Details_obj);
            JSONObject authenticate_obj=new JSONObject();
            authenticate_obj.put("WebAggregatorCode","20000001");
            authenticate_obj.put("WAApplicationCode","30000011");
            authenticate_obj.put("WAUserID","USER01");
            authenticate_obj.put("WAUserPassword","pass@123");
            authenticate_obj.put("WAType","0");
            object.put("authenticate",authenticate_obj);
            object.put("ErrorMessage","");

        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(Arogya_Medical_Discount.this, object, UrlHealthConstants.SaveQuotationWA_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("ErrorMessage").equals("null")) {
                    if (Tag == RequestHealthConstants.Arogya_QUATATION) {
                        try {
                            QuoteId  = object.optString("QuoteId");
                            TotalValue = object.optString("TotalPremium");
                            NetPremium = object.optString("NetPremium");
                            GST = object.optString("GST");
                            strLoyaltyDiscount = object.optString("LoyaltyDiscount");
                            JSONArray installmentFreq = object.getJSONArray("installmentFreq");
                            for (int i = 0; i < installmentFreq.length(); i++) {
                                JSONObject obj = installmentFreq.getJSONObject(0);
                                TotalInstallPremium = obj.optString("TotalInstallPremium");

                            }
                            existing_policy_amount.setText(strLoyaltyDiscount);
                            totalPremiumAmount.setText(TotalValue);
//                            txtNetPremiumValue.setText(NetPremium);
                            QuotationID.setText(QuoteId);
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }else {
                    Toast.makeText(getApplication(), object.optString("ErrorMessage"), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {

            }
        }, RequestHealthConstants.Arogya_QUATATION);
        req.execute();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Arogya_Medical_Discount.this, Arogya_Member_info.class);
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
        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
        intent.putExtra("strtwoDob",strtwoDob);
        intent.putExtra("strthreeDob",strthreeDob);
        intent.putExtra("strfourDob",strfourDob);
        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
        intent.putExtra("GST",GST);
        intent.putExtra("NetPremium",NetPremium);
        intent.putExtra("str_RelationEdit",str_RelationEdit);
        intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
        intent.putExtra("strRelationChildEdit",strRelationChildEdit);
        intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
        intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
        intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
        intent.putExtra("strNominee_dob",strNominee_dob);
        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
        intent.putExtra("str_existing_spinner",str_existing_spinner);
        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
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
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("QuoteId",QuoteId);
        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
        intent.putExtra("str_policyTenure",str_policyTenure);
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
        startActivity(intent);
        finish();

    }
}
