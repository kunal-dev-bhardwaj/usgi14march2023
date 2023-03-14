package com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.BuyPolicySumInsured;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class BuyPolicySuminsuredArogya extends AppCompatActivity {
    EditText ParentEditText,installmentAmount,Payment_spinner,totalPremiumAmountQuid,totalPremiumAmount,SumInsured_spinner,policyTenure_spinner,policyType_spinner,familyType_spinner,IndividualTypeEdit;
    String str_life_style_spinner,strLoyaltyDiscount,new_str_age,str_Payment_spinner,str_for,str_SumInsured,str_policyTenure,strFirstTString,str_policyType_spinner,str_IndividualTypeEdit,strSumInsuredTpeEDit;
    TextView SumInsuredTpeTxt,show_Breakup,txtNetPremiumValue;
    String strParentEditText,str_existing_spinner,strExisting_policy_number,str_new_dob,today,tomorrowDate,nextYear,strThirdDString,str_age="",str_edit_dob,str_reference_no,str_email,str_edt_phone,str_edt_name,str_edit_dob3String,strSecondString,str_OneEditName,str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,strChildOne,strChildTwo,strChildThree,strChildFour,strOneChild,str_oneWeightEdit,strtwoDob,strfourDob,strthreeDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,NetPremium,
    strNominee_dob,QuoteId,TotalInstallPremium,TotalValue,NetPremiumValue,PosPolicyNo,GST,str_amountPersonalSumInsured,strcriticalEdit,strhospitalEdit,strOneChildCriticalIllnessTxt,stroneChildTxt,str_inches,str_weight_edit,str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_weight_edit,str_spouse_inches_spinner,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit;
     MySharedPreference pref;
    CustomProgressDialog customprogress;
    Date date;
    LinearLayout ParentSpinnerLiner,ParentMainLinear,linerBtn,policyType_spinnerLiner,familyType_spinnerLiner,SumInsured_spinnerLiner,Payment_spinnerLiner;
    Format formatter;
    Button btn_recalculate,btn_next;
    int FamilyTypeCounter=0;
    int ParentCounter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_policy_suminsured_arogya);
        getWindow().setStatusBarColor(ContextCompat.getColor(BuyPolicySuminsuredArogya.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(BuyPolicySuminsuredArogya.this);
        customprogress = new CustomProgressDialog(BuyPolicySuminsuredArogya.this);
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_reference_no = getIntent().getStringExtra("str_reference_no");
        str_edit_dob = getIntent().getStringExtra("str_edit_dob");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        NetPremium = getIntent().getStringExtra("NetPremium");
        TotalValue = getIntent().getStringExtra("TotalValue");
        str_for = getIntent().getStringExtra("for");
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
        strFirstTString = getIntent().getStringExtra("strFirstTString");
        PosPolicyNo = getIntent().getStringExtra("PosPolicyNo");
        strChildOne = getIntent().getStringExtra("strChildOne");
        strChildTwo = getIntent().getStringExtra("strChildTwo");
        strChildThree = getIntent().getStringExtra("strChildThree");
        strChildFour = getIntent().getStringExtra("strChildFour");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
        NetPremium = getIntent().getStringExtra("NetPremium");
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
        TotalInstallPremium = getIntent().getStringExtra("TotalInstallPremium");
        strNominee_dob = getIntent().getStringExtra("strNominee_dob");
        str_existing_spinner = getIntent().getStringExtra("str_existing_spinner");
        strExisting_policy_number = getIntent().getStringExtra("strExisting_policy_number");
        str_Payment_spinner = getIntent().getStringExtra("str_Payment_spinner");
        str_policyTenure = getIntent().getStringExtra("str_policyTenure");
        strLoyaltyDiscount = getIntent().getStringExtra("strLoyaltyDiscount");
        new_str_age = getIntent().getStringExtra("new_str_age");
        str_life_style_spinner = getIntent().getStringExtra("str_life_style_spinner");
        strParentEditText = getIntent().getStringExtra("strParentEditText");
        FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
        ParentCounter = getIntent().getIntExtra("ParentCounter", 0);


        String[] strParts =  str_age.split("yrs");
        String strFirstString = strParts[0];
        String strSecondString = strParts[1];
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
        int new_dob= Integer.parseInt(strThirdDString)- Integer.parseInt(strFirstString);
        Log.e("new_dob", String.valueOf(new_dob));
        str_new_dob=strFirstDString+"/"+ strSecondDString + "/"+String.valueOf(new_dob);
        Log.e("str_new_dob", str_new_dob);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        tomorrowDate = formatter.format(date);
        Log.e("tomorrowDate",tomorrowDate);
        calendar.add(Calendar.DATE, 364);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        nextYear = formatter.format(date);
        Log.e("nextYear",nextYear);

        if(str_age.equals("18yrs-35yrs")){
            new_str_age="27/01/1995";
        }else if(str_age.equals("36yrs-45yrs")){
            new_str_age="27/01/1982";
        }else if(str_age.equals("46yrs-50yrs")){
            new_str_age="27/01/1974";
        }else if(str_age.equals("51yrs-55yrs")){
            new_str_age="27/01/1970";
        }

        initView();
    }
    private void initView() {

        ParentSpinnerLiner=findViewById(R.id.ParentSpinnerLiner);
        ParentMainLinear=findViewById(R.id.ParentMainLinear);
        policyType_spinnerLiner=findViewById(R.id.policyType_spinnerLiner);
        familyType_spinnerLiner=findViewById(R.id.familyType_spinnerLiner);
        SumInsured_spinnerLiner=findViewById(R.id.SumInsured_spinnerLiner);
        Payment_spinnerLiner=findViewById(R.id.Payment_spinnerLiner);
        SumInsured_spinner=findViewById(R.id.SumInsured_spinner);
        policyTenure_spinner=findViewById(R.id.policyTenure_spinner);
        policyType_spinner=findViewById(R.id.policyType_spinner);
        familyType_spinner=findViewById(R.id.familyType_spinner);
        SumInsuredTpeTxt=findViewById(R.id.SumInsuredTpeTxt);
        IndividualTypeEdit=findViewById(R.id.IndividualTypeEdit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        txtNetPremiumValue=findViewById(R.id.txtNetPremiumValue);
        Payment_spinner=findViewById(R.id.Payment_spinner);
        installmentAmount=findViewById(R.id.installmentAmount);
        show_Breakup=findViewById(R.id.show_Breakup);
        btn_recalculate=findViewById(R.id.btn_recalculate);
        linerBtn=findViewById(R.id.linerBtn);
        btn_next=findViewById(R.id.btn_next);
        totalPremiumAmountQuid=findViewById(R.id.totalPremiumAmountQuid);
        ParentEditText=findViewById(R.id.ParentEditText);

        str_SumInsured="300000";
        SumInsured_spinner.setText(str_SumInsured);
        str_policyTenure="1 Year";
        String[] strTenureParts =  str_policyTenure.split("Year");
        strFirstTString = strTenureParts[0];
        policyTenure_spinner.setText(str_policyTenure);

//        str_policyType_spinner="Family Floater";
//        policyType_spinner.setText(str_policyType_spinner);
//        str_IndividualTypeEdit="2 Adult";
//        familyType_spinner.setText(str_IndividualTypeEdit);
//        str_SumInsured="300000";
//        SumInsured_spinner.setText(str_SumInsured);

//        if (str_SumInsured.equals("100000") || str_SumInsured.equals("400000")){
//            strSumInsuredTpeEDit="Essential";
//            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
//        }else{
//            strSumInsuredTpeEDit="Privilege";
//            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
//        }


        if (str_for.equals("0")) {
            strFirstTString = "1";
            str_policyType_spinner="Family Floater";
            str_IndividualTypeEdit="2 Adult";
            str_SumInsured="300000";
            strParentEditText="Select Parent";
            str_Payment_spinner="Monthly";
            FamilyTypeCounter=2;
            ParentCounter=0;
            Payment_spinner.setText(str_Payment_spinner);
            policyType_spinner.setText(str_policyType_spinner);
            familyType_spinner.setText(str_IndividualTypeEdit);
            ParentMainLinear.setVisibility(View.VISIBLE);
            ParentEditText.setText(strParentEditText);
            SaveQuotationWA();
        }
        else{
            if (str_policyType_spinner.equals("Individual")){
                IndividualTypeEdit.setVisibility(View.VISIBLE);
                familyType_spinner.setVisibility(View.GONE);
                ParentMainLinear.setVisibility(View.GONE);
                IndividualTypeEdit.setText(str_IndividualTypeEdit);
                ParentCounter=0;
            }else{
                IndividualTypeEdit.setVisibility(View.GONE);
                familyType_spinner.setVisibility(View.VISIBLE);
                familyType_spinner.setText(str_IndividualTypeEdit);
                if(str_IndividualTypeEdit.equals("2 Adult")){
                    ParentMainLinear.setVisibility(View.VISIBLE);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                    ParentMainLinear.setVisibility(View.VISIBLE);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                    ParentMainLinear.setVisibility(View.VISIBLE);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                    ParentMainLinear.setVisibility(View.VISIBLE);
                } else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
                    ParentMainLinear.setVisibility(View.VISIBLE);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                    ParentMainLinear.setVisibility(View.VISIBLE);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                    ParentMainLinear.setVisibility(View.VISIBLE);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                    ParentMainLinear.setVisibility(View.VISIBLE);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                    ParentMainLinear.setVisibility(View.GONE);
                }
            }
            ParentEditText.setText(strParentEditText);
            policyType_spinner.setText(str_policyType_spinner);
            SumInsured_spinner.setText(str_SumInsured);
            txtNetPremiumValue.setText(TotalValue);
            totalPremiumAmount.setText(TotalValue);
            Payment_spinner.setText(str_Payment_spinner);
            installmentAmount.setText(TotalInstallPremium);
        }
        policyType_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySuminsuredArogya.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Individual");
                items1.add("Family Floater");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_policyType_spinner=items1.get(options1);
                        policyType_spinner.setText(str_policyType_spinner);
                        if (str_policyType_spinner.equals("Individual")){
                            IndividualTypeEdit.setVisibility(View.VISIBLE);
                            familyType_spinner.setVisibility(View.GONE);
                            ParentMainLinear.setVisibility(View.GONE);
                            IndividualTypeEdit.getText().toString();
                            str_IndividualTypeEdit="1 Adult";
                            IndividualTypeEdit.setText(str_IndividualTypeEdit);
                            strFirstTString="1";
                            FamilyTypeCounter=1;
                            ParentCounter=0;
                            strParentEditText="Select Parent";
                            ParentEditText.setText(strParentEditText);
                            SaveQuotationWA();

                        }else {
                            str_IndividualTypeEdit="2 Adult";
                            familyType_spinner.setText(str_IndividualTypeEdit);
                            familyType_spinner.setVisibility(View.VISIBLE);
                            ParentMainLinear.setVisibility(View.VISIBLE);
                            IndividualTypeEdit.setVisibility(View.GONE);
                            strFirstTString="1";
                            FamilyTypeCounter=2;
                            SaveQuotationWA();
                        }
                    }
                });
                singlePicker.show(); }
        });
        familyType_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySuminsuredArogya.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("2 Adult");
                items1.add("1 Adult + 1 Child");
                items1.add("1 Adult + 2 Child");
                items1.add("1 Adult + 3 Child");
                items1.add("1 Adult + 4 Child");
                items1.add("2 Adult + 1 Child");
                items1.add("2 Adult + 2 Child");
                items1.add("2 Adult + 3 Child");
                items1.add("2 Adult + 4 Child");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_IndividualTypeEdit=items1.get(options1);
                        familyType_spinner.setText(str_IndividualTypeEdit);
                        if(str_IndividualTypeEdit.equals("2 Adult")){
                            FamilyTypeCounter=2;
                            str_IndividualTypeEdit="2 Adult";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                            FamilyTypeCounter=2;
                            str_IndividualTypeEdit="1 Adult + 1 Child";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                            FamilyTypeCounter=3;
                            str_IndividualTypeEdit="1 Adult + 2 Child";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                            FamilyTypeCounter=4;
                            str_IndividualTypeEdit="1 Adult + 3 Child";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                        } else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
                            FamilyTypeCounter=5;
                            str_IndividualTypeEdit="1 Adult + 4 Child";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                            FamilyTypeCounter=3;
                            str_IndividualTypeEdit="2 Adult + 1 Child";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                            FamilyTypeCounter=4;
                            str_IndividualTypeEdit="2 Adult + 2 Child";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                            FamilyTypeCounter=5;
                            str_IndividualTypeEdit="2 Adult + 3 Child";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                            FamilyTypeCounter=6;
                            str_IndividualTypeEdit="2 Adult + 4 Child";
                            strFirstTString="1";
                            strParentEditText="Select Parent";
                            ParentEditText.setText(strParentEditText);
                            ParentMainLinear.setVisibility(View.GONE);
                        }else{
                            str_policyType_spinner="Family Floater";
                            policyType_spinner.setText(str_policyType_spinner);
                            str_IndividualTypeEdit="2 Adult";
                            str_SumInsured="500000";
                            strFirstTString="1";
                            ParentMainLinear.setVisibility(View.VISIBLE);
                            FamilyTypeCounter=2;
                            SaveQuotationWA();
                        }
                        if (!str_policyType_spinner.equals("Individual")) {
                            if (FamilyTypeCounter == 0) {
                                Toast.makeText(BuyPolicySuminsuredArogya.this, "Select any insured member", Toast.LENGTH_SHORT).show();
                            }else if (FamilyTypeCounter+ParentCounter> 6) {
                                Toast.makeText(BuyPolicySuminsuredArogya.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                            }else{
                                SaveQuotationWA();
                            }
                        }else{
                            SaveQuotationWA();
                        }
                    }
                });
                singlePicker.show(); }
        });
        ParentSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySuminsuredArogya.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Parent");
                items1.add("Mother");
                items1.add("Father");
                items1.add("Mother & Father");
                items1.add("Mother-In-Law");
                items1.add("Father-In-Law");
                items1.add("Mother-In-Law & Father-In-Law");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strParentEditText=items1.get(options1);
                        ParentEditText.setText(strParentEditText);
                        if (strParentEditText.equals("Mother")){
                            ParentCounter=1;
                        }else if (strParentEditText.equals("Father")){
                            ParentCounter=1;
                        }else if (strParentEditText.equals("Mother & Father")){
                            ParentCounter=2;
                        }else if (strParentEditText.equals("Mother-In-Law")){
                            ParentCounter=1;
                        }else if (strParentEditText.equals("Father-In-Law")){
                            ParentCounter=1;
                        }else if (strParentEditText.equals("Mother-In-Law & Father-In-Law")){
                            ParentCounter=2;
                        }

                        if (!str_policyType_spinner.equals("Individual")) {
                            if (FamilyTypeCounter == 0) {
                                Toast.makeText(BuyPolicySuminsuredArogya.this, "Select any insured member", Toast.LENGTH_SHORT).show();
                            }else if (FamilyTypeCounter+ParentCounter> 6) {
                                Toast.makeText(BuyPolicySuminsuredArogya.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                            }else{
                                SaveQuotationWA();
                            }
                        }else{
                            SaveQuotationWA();
                        }
                    }
                });
                singlePicker.show();
            }
        });
        Payment_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySuminsuredArogya.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Monthly");
                items1.add("Quarterly");
                items1.add("Half Yearly");
                items1.add("Annually");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_Payment_spinner=items1.get(options1);
                        Payment_spinner.setText(str_Payment_spinner);
                        if (str_Payment_spinner.equals("Monthly")){
                            str_Payment_spinner="Monthly";
                        }else if (str_Payment_spinner.equals("Quarterly")){
                            str_Payment_spinner="Quarterly";
                        }else if (str_Payment_spinner.equals("Half Yearly")){
                            str_Payment_spinner="Half Yearly";
                        } else if(str_Payment_spinner.equals("Annually")){
                            str_Payment_spinner="Annualy";
                        }

                        if (!str_policyType_spinner.equals("Individual")) {
                            if (FamilyTypeCounter == 0) {
                                Toast.makeText(BuyPolicySuminsuredArogya.this, "Select any insured member", Toast.LENGTH_SHORT).show();
                            }else if (FamilyTypeCounter+ParentCounter> 6) {
                                Toast.makeText(BuyPolicySuminsuredArogya.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                            }else{
                                SaveQuotationWA();
                            }
                        }else{
                            SaveQuotationWA();
                        }
                    }
                });
                singlePicker.show();
            }
        });
        SumInsured_spinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySuminsuredArogya.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("50000");
                items1.add("100000");
                items1.add("150000");
                items1.add("200000");
                items1.add("250000");
                items1.add("300000");
                items1.add("350000");
                items1.add("400000");
                items1.add("450000");
                items1.add("500000");
                items1.add("550000");
                items1.add("600000");
                items1.add("650000");
                items1.add("700000");
                items1.add("750000");
                items1.add("800000");
                items1.add("850000");
                items1.add("900000");
                items1.add("950000");
                items1.add("1000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_SumInsured=items1.get(options1);
                        SumInsured_spinner.setText(str_SumInsured);
                        str_policyTenure="1 Year";
                        if (!str_policyType_spinner.equals("Individual")) {
                            if (FamilyTypeCounter == 0) {
                                Toast.makeText(BuyPolicySuminsuredArogya.this, "Select any insured member", Toast.LENGTH_SHORT).show();
                            }else if (FamilyTypeCounter+ParentCounter> 6) {
                                Toast.makeText(BuyPolicySuminsuredArogya.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                            }else{
                                SaveQuotationWA();
                            }
                        }else{
                            SaveQuotationWA();
                        }


//                        SaveQuotationWA();
                    }
                });
                singlePicker.show(); }
        });
        btn_recalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_policyType_spinner.equals("")){
                    Toast.makeText(BuyPolicySuminsuredArogya.this, "Select Policy Type", Toast.LENGTH_SHORT).show();
                }else if (str_IndividualTypeEdit.equals("")){
                    Toast.makeText(BuyPolicySuminsuredArogya.this, "Select Family Type", Toast.LENGTH_SHORT).show();
                }else if (str_policyTenure.equals("")){
                    Toast.makeText(BuyPolicySuminsuredArogya.this, "Select Policy tenure", Toast.LENGTH_SHORT).show();
                }else if (str_SumInsured.equals("")){
                    Toast.makeText(BuyPolicySuminsuredArogya.this, "Select Sum Insured", Toast.LENGTH_SHORT).show();
                }else{
                    if (!str_policyType_spinner.equals("Individual")) {
                        if (FamilyTypeCounter == 0) {
                            Toast.makeText(BuyPolicySuminsuredArogya.this, "Select any insured member", Toast.LENGTH_SHORT).show();
                        }else if (FamilyTypeCounter+ParentCounter> 6) {
                            Toast.makeText(BuyPolicySuminsuredArogya.this, "You can select only 6 members", Toast.LENGTH_SHORT).show();
                        }else{
                            SaveQuotationWA();
                        }
                    }else{
                        SaveQuotationWA();
                    }
//                    SaveQuotationWA();
                }
            }
        });
        linerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(BuyPolicySuminsuredArogya.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.dialog_coming_soon);
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
                        Intent intent=new Intent(BuyPolicySuminsuredArogya.this, Arogya_Member_info.class);
                        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                        intent.putExtra("str_SumInsured",str_SumInsured);
                        intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                        intent.putExtra("NetPremiumValue",NetPremiumValue);
                        intent.putExtra("NetPremium",NetPremium);
                        intent.putExtra("GST",GST);
                        intent.putExtra("strFirstTString",strFirstTString);
                        intent.putExtra("str_edit_dob3String",strSecondString);
                        intent.putExtra("TotalValue",TotalValue);
                        intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                        intent.putExtra("PosPolicyNo",PosPolicyNo);
                        intent.putExtra("str_edt_name",str_edt_name);
                        intent.putExtra("str_edt_phone",str_edt_phone);
                        intent.putExtra("str_email",str_email);
                        intent.putExtra("str_age",str_age);
                        intent.putExtra("str_reference_no",str_reference_no);
                        intent.putExtra("QuoteId",QuoteId);
                        intent.putExtra("TotalInstallPremium",TotalInstallPremium);
                        intent.putExtra("strNominee_dob",strNominee_dob);
                        intent.putExtra("strExisting_policy_number",strExisting_policy_number);
                        intent.putExtra("str_existing_spinner",str_existing_spinner);
                        intent.putExtra("str_Payment_spinner",str_Payment_spinner);
                        intent.putExtra("new_str_age",new_str_age);
                        intent.putExtra("str_policyTenure",str_policyTenure);
                        intent.putExtra("strLoyaltyDiscount",strLoyaltyDiscount);
                        intent.putExtra("str_life_style_spinner",str_life_style_spinner);
                        intent.putExtra("str_existing_spinner",str_existing_spinner);
                        intent.putExtra("strParentEditText",strParentEditText);
                        intent.putExtra("FamilyTypeCounter",FamilyTypeCounter);
                        intent.putExtra("ParentCounter",ParentCounter);
                        intent.putExtra("for","0");
                        startActivity(intent);
                        finish();
                        alert_dialog.dismiss();
                    }
                });
                alert_dialog.show();
            }
        });
        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(BuyPolicySuminsuredArogya.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.arogya_show_breakup);
                EditText policyNoExisting, LifeStyleDiscount,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
                Button buttonClose;
                LinearLayout linerExisting,installmentLiner;
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
                installmentLiner = alert_dialog.findViewById(R.id.installmentLiner);
                installmentLiner.setVisibility(View.GONE);
                if (str_for.equals("1")) {
                    if (str_existing_spinner.equals("Yes")){
                        LifeStyleDiscount.setText("Yes");
                        linerExisting.setVisibility(View.VISIBLE);
                        policyNoExisting.setText(strExisting_policy_number);
                    }else{
                        linerExisting.setVisibility(View.GONE);
                    }
                }else {
                    linerExisting.setVisibility(View.GONE);
                }

                basicPremium.setText(NetPremium);
//                criticalEdit.setText(strcriticalEdit);
//                premiumEdit.setText(str_amountPersonalSumInsured);
//                hospitalEdit.setText(strhospitalEdit);
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
            object.put("IsLoyatyDicsount","No");
            object.put("ExistingPolicyNo","");
            JSONArray array=new JSONArray();
            if(str_IndividualTypeEdit.equals("1 Adult")){
                JSONObject obj=new JSONObject();
                obj.put("Name",str_edt_name);
                obj.put("DOB",new_str_age);
                obj.put("Gender","Male");
                obj.put("HeightInFeet","6");
                obj.put("HeightInInches","7");
                obj.put("Weight","68");
                obj.put("BMI","22.12");
                obj.put("Occupation","Doctors");
                obj.put("Relation","Self");
                obj.put("SumInsured",str_SumInsured);
                array.put(obj);
            }
            else if (str_policyType_spinner.equals("Family Floater")){
                if(str_IndividualTypeEdit.equals("2 Adult")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_name);
                    objAdult2.put("DOB",new_str_age);
                    objAdult2.put("Gender","Male");
                    objAdult2.put("HeightInFeet","6");
                    objAdult2.put("HeightInInches","7");
                    objAdult2.put("Weight","68");
                    objAdult2.put("BMI","22.12");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Self");
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_edt_name);
                    objChild1.put("DOB","27/01/2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("HeightInFeet","6");
                    objChild1.put("HeightInInches","7");
                    objChild1.put("Weight","68");
                    objChild1.put("BMI","22.12");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_edt_name);
                    objChild1.put("DOB","27/01/2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("HeightInFeet","6");
                    objChild1.put("HeightInInches","7");
                    objChild1.put("Weight","68");
                    objChild1.put("BMI","22.12");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_edt_name);
                    objChild2.put("DOB","27/01/2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("HeightInFeet","6");
                    objChild2.put("HeightInInches","7");
                    objChild2.put("Weight","68");
                    objChild2.put("BMI","22.12");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_edt_name);
                    objChild1.put("DOB","27/01/2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("HeightInFeet","6");
                    objChild1.put("HeightInInches","7");
                    objChild1.put("Weight","68");
                    objChild1.put("BMI","22.12");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_edt_name);
                    objChild2.put("DOB","27/01/2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("HeightInFeet","6");
                    objChild2.put("HeightInInches","7");
                    objChild2.put("Weight","68");
                    objChild2.put("BMI","22.12");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_edt_name);
                    objChild3.put("DOB","27/01/2005");
                    objChild3.put("Gender","Male");
                    objChild3.put("HeightInFeet","6");
                    objChild3.put("HeightInInches","7");
                    objChild3.put("Weight","68");
                    objChild3.put("BMI","22.12");
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation","Child3");
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_edt_name);
                    objChild1.put("DOB","27/01/2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("HeightInFeet","6");
                    objChild1.put("HeightInInches","7");
                    objChild1.put("Weight","68");
                    objChild1.put("BMI","22.12");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_edt_name);
                    objChild2.put("DOB","27/01/2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("HeightInFeet","6");
                    objChild2.put("HeightInInches","7");
                    objChild2.put("Weight","68");
                    objChild2.put("BMI","22.12");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_edt_name);
                    objChild3.put("DOB","27/01/2005");
                    objChild3.put("Gender","Male");
                    objChild3.put("HeightInFeet","6");
                    objChild3.put("HeightInInches","7");
                    objChild3.put("Weight","68");
                    objChild3.put("BMI","22.12");
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation","Child3");
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("Name",str_edt_name);
                    objChild4.put("DOB","27/01/2005");
                    objChild4.put("Gender","Male");
                    objChild4.put("HeightInFeet","6");
                    objChild4.put("HeightInInches","7");
                    objChild4.put("Weight","68");
                    objChild4.put("BMI","22.12");
                    objChild4.put("Occupation","Student");
                    objChild4.put("Relation","Child4");
                    objChild4.put("SumInsured",str_SumInsured);
                    array.put(objChild4);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_name);
                    objAdult2.put("DOB",new_str_age);
                    objAdult2.put("Gender","Male");
                    objAdult2.put("HeightInFeet","6");
                    objAdult2.put("HeightInInches","7");
                    objAdult2.put("Weight","68");
                    objAdult2.put("BMI","22.12");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Self");
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_edt_name);
                    objChild1.put("DOB","27/01/2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("HeightInFeet","6");
                    objChild1.put("HeightInInches","7");
                    objChild1.put("Weight","68");
                    objChild1.put("BMI","22.12");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_name);
                    objAdult2.put("DOB",new_str_age);
                    objAdult2.put("Gender","Male");
                    objAdult2.put("HeightInFeet","6");
                    objAdult2.put("HeightInInches","7");
                    objAdult2.put("Weight","68");
                    objAdult2.put("BMI","22.12");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Self");
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_edt_name);
                    objChild1.put("DOB","27/01/2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("HeightInFeet","6");
                    objChild1.put("HeightInInches","7");
                    objChild1.put("Weight","68");
                    objChild1.put("BMI","22.12");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_edt_name);
                    objChild2.put("DOB","27/01/2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("HeightInFeet","6");
                    objChild2.put("HeightInInches","7");
                    objChild2.put("Weight","68");
                    objChild2.put("BMI","22.12");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_name);
                    objAdult2.put("DOB",new_str_age);
                    objAdult2.put("Gender","Male");
                    objAdult2.put("HeightInFeet","6");
                    objAdult2.put("HeightInInches","7");
                    objAdult2.put("Weight","68");
                    objAdult2.put("BMI","22.12");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Self");
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_edt_name);
                    objChild1.put("DOB","27/01/2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("HeightInFeet","6");
                    objChild1.put("HeightInInches","7");
                    objChild1.put("Weight","68");
                    objChild1.put("BMI","22.12");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_edt_name);
                    objChild2.put("DOB","27/01/2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("HeightInFeet","6");
                    objChild2.put("HeightInInches","7");
                    objChild2.put("Weight","68");
                    objChild2.put("BMI","22.12");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_edt_name);
                    objChild3.put("DOB","27/01/2005");
                    objChild3.put("Gender","Male");
                    objChild3.put("HeightInFeet","6");
                    objChild3.put("HeightInInches","7");
                    objChild3.put("Weight","68");
                    objChild3.put("BMI","22.12");
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation","Child3");
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("Name",str_edt_name);
                    obj.put("DOB",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("HeightInFeet","6");
                    obj.put("HeightInInches","7");
                    obj.put("Weight","68");
                    obj.put("BMI","22.12");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("Name",str_edt_name);
                    objAdult2.put("DOB",new_str_age);
                    objAdult2.put("Gender","Male");
                    objAdult2.put("HeightInFeet","6");
                    objAdult2.put("HeightInInches","7");
                    objAdult2.put("Weight","68");
                    objAdult2.put("BMI","22.12");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Self");
                    objAdult2.put("SumInsured",str_SumInsured);
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("Name",str_edt_name);
                    objChild1.put("DOB","27/01/2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("HeightInFeet","6");
                    objChild1.put("HeightInInches","7");
                    objChild1.put("Weight","68");
                    objChild1.put("BMI","22.12");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("Name",str_edt_name);
                    objChild2.put("DOB","27/01/2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("HeightInFeet","6");
                    objChild2.put("HeightInInches","7");
                    objChild2.put("Weight","68");
                    objChild2.put("BMI","22.12");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("Name",str_edt_name);
                    objChild3.put("DOB","27/01/2005");
                    objChild3.put("Gender","Male");
                    objChild3.put("HeightInFeet","6");
                    objChild3.put("HeightInInches","7");
                    objChild3.put("Weight","68");
                    objChild3.put("BMI","22.12");
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation","Child3");
                    objChild3.put("SumInsured",str_SumInsured);
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("Name",str_edt_name);
                    objChild4.put("DOB","27/01/2005");
                    objChild4.put("Gender","Male");
                    objChild4.put("HeightInFeet","6");
                    objChild4.put("HeightInInches","7");
                    objChild4.put("Weight","68");
                    objChild4.put("BMI","22.12");
                    objChild4.put("Occupation","Student");
                    objChild4.put("Relation","Child4");
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(BuyPolicySuminsuredArogya.this, object, UrlHealthConstants.SaveQuotationWA_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("ErrorMessage").equals("null")) {
                    if (Tag == RequestHealthConstants.Arogya_QUATATION) {
                        try {
                            QuoteId  = object.optString("QuoteId");
                            TotalValue = object.optString("TotalPremium");
                            NetPremium = object.optString("NetPremium");
                            GST = object.optString("GST");
                            JSONArray installmentFreq = object.getJSONArray("installmentFreq");
                            for (int i = 0; i < installmentFreq.length(); i++) {
                                JSONObject obj = installmentFreq.getJSONObject(0);
                                TotalInstallPremium = obj.optString("TotalInstallPremium");
                                installmentAmount.setText(TotalInstallPremium);
                            }
                            totalPremiumAmount.setText(TotalValue);
                            txtNetPremiumValue.setText(TotalValue);
                            totalPremiumAmountQuid.setText(QuoteId);
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
        }, RequestHealthConstants.Arogya_QUATATION);
        req.execute();

    }

}