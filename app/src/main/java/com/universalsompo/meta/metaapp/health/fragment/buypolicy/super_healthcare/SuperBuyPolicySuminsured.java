package com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare;

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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.BuyPolicySuminsuredArogya;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.BuyPolicySumInsured;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.Complete_health_member_info;
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

public class SuperBuyPolicySuminsured extends AppCompatActivity {
    EditText PlanTypeEdit,Deductible_spinner,policyTenure_spinner,totalPremiumAmount,IndividualTypeEdit,policyType_spinner,familyType_spinner,SumInsured_spinner,SumInsuredTpeEDit;
    TextView show_Breakup,txtNetPremiumValue,SumInsuredTpeTxt;
    Button btn_recalculate,btn_next;
    LinearLayout LinerPlan,LinerPlanType,linerBtn,LinerPolicySpinner,LinerSumInsured,LinerDeductible,LinerFamilyType,LinerPolicyTypeSpinner;
    Date date,date1,date2,date3;
    Format formatter;
    Button buttonClose;
    EditText basicPremium,sumInsuredEdit,deductibleEdit,globalDiscount,DiseaseManagement,gstEdit,totalAmount,tiedHospital,longTermDiscountTxt,ESaleTxt;
    MySharedPreference pref;
    CustomProgressDialog customprogress;
    String strSecondString,strPlanTypeEdit,str_Deductible,BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,new_str_age,ESaleDiscount,LongTermDiscount,PD_Status,strPriceTotal,strNominee_dob,str_new_dob,today,tomorrowDate,nextYear,strThirdDString,str_policyType_spinner,str_IndividualTypeEdit,str_for,strFirstTString,str_age="",str_edit_dob,str_reference_no,str_email,str_edt_phone,str_edt_name,str_policyTenure,str_SumInsured,str_edit_dob3String,str_OneEditName,str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,strChildOne,strChildTwo,strChildThree,strChildFour,strOneChild,str_oneWeightEdit,strtwoDob,strfourDob,strthreeDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,
            strGlobalDiscount,strDiseaseManagement,strGlobalAdultSpinner,strAdult1OneDiseaseSpinner,TotalValue,NetPremiumValue,PosPolicyNo,GST,str_amountPersonalSumInsured,strcriticalEdit,strhospitalEdit,strOneChildCriticalIllnessTxt,stroneChildTxt,strSumInsuredTpeEDit,str_inches,str_weight_edit,str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_weight_edit,str_spouse_inches_spinner,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_buy_policy_suminsured);
        getWindow().setStatusBarColor(ContextCompat.getColor(SuperBuyPolicySuminsured.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(SuperBuyPolicySuminsured.this);
        customprogress = new CustomProgressDialog(SuperBuyPolicySuminsured.this);
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_reference_no = getIntent().getStringExtra("str_reference_no");
        str_edit_dob = getIntent().getStringExtra("str_edit_dob");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        str_Deductible = getIntent().getStringExtra("str_Deductible");
        NetPremiumValue = getIntent().getStringExtra("NetPremiumValue");
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
        strNominee_dob = getIntent().getStringExtra("strNominee_dob");
        strPriceTotal = getIntent().getStringExtra("strPriceTotal");
        LongTermDiscount = getIntent().getStringExtra("LongTermDiscount");
        ESaleDiscount = getIntent().getStringExtra("ESaleDiscount");
        PD_Status = getIntent().getStringExtra("PD_Status");
        nextYear = getIntent().getStringExtra("nextYear");
        tomorrowDate = getIntent().getStringExtra("tomorrowDate");
        str_policyTenure = getIntent().getStringExtra("str_policyTenure");
        new_str_age = getIntent().getStringExtra("new_str_age");
        BI_Status = getIntent().getStringExtra("BI_Status");
        BI_Status1 = getIntent().getStringExtra("BI_Status1");
        BI_Status2 = getIntent().getStringExtra("BI_Status2");
        BI_Status3 = getIntent().getStringExtra("BI_Status3");
        BI_Status4 = getIntent().getStringExtra("BI_Status4");
        BI_Status5 = getIntent().getStringExtra("BI_Status5");
        strSumInsuredTpeEDit = getIntent().getStringExtra("strSumInsuredTpeEDit");
        strGlobalAdultSpinner = getIntent().getStringExtra("strGlobalAdultSpinner");
        strAdult1OneDiseaseSpinner = getIntent().getStringExtra("strAdult1OneDiseaseSpinner");


        String[] strParts =  str_age.split("yrs");
        String strFirstString = strParts[0];
         strSecondString = strParts[1];
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
        int new_dob= Integer.parseInt(strThirdDString)- Integer.parseInt(strFirstString);
        Log.e("new_dob", String.valueOf(new_dob));
        str_new_dob=strFirstDString+"-"+ strSecondDString + "-"+String.valueOf(new_dob);
        Log.e("str_new_dob", str_new_dob);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        tomorrowDate = formatter.format(date);
        Log.e("tomorrowDate",tomorrowDate);

        calendar.add(Calendar.DATE, 364);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        nextYear = formatter.format(date);
        Log.e("nextYear",nextYear);


        if(str_age.equals("18yrs-35yrs")){
            new_str_age="27-01-1995";
        }else if(str_age.equals("36yrs-45yrs")){
            new_str_age="27-01-1982";
        }else if(str_age.equals("46yrs-50yrs")){
            new_str_age="27-01-1974";
        }else if(str_age.equals("51yrs-55yrs")){
            new_str_age="27-01-1970";
        }else if(str_age.equals("56yrs-60yrs")){
            new_str_age="27-01-1965";
        }else if(str_age.equals("61yrs-65yrs")){
            new_str_age="27-01-1960";
        }

        LinerPolicySpinner=findViewById(R.id.LinerPolicySpinner);
        LinerSumInsured=findViewById(R.id.LinerSumInsured);
        LinerDeductible=findViewById(R.id.LinerDeductible);
        LinerFamilyType=findViewById(R.id.LinerFamilyType);
        LinerPolicyTypeSpinner=findViewById(R.id.LinerPolicyTypeSpinner);
        policyType_spinner=findViewById(R.id.policyType_spinner);
        familyType_spinner=findViewById(R.id.familyType_spinner);
        SumInsured_spinner=findViewById(R.id.SumInsured_spinner);
        policyTenure_spinner=findViewById(R.id.policyTenure_spinner);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        IndividualTypeEdit=findViewById(R.id.IndividualTypeEdit);
        Deductible_spinner=findViewById(R.id.Deductible_spinner);
        PlanTypeEdit=findViewById(R.id.PlanTypeEdit);
        LinerPlanType=findViewById(R.id.LinerPlanType);
        LinerPlan=findViewById(R.id.LinerPlan);
        txtNetPremiumValue=findViewById(R.id.txtNetPremiumValue);
        SumInsuredTpeTxt=findViewById(R.id.SumInsuredTpeTxt);
        btn_recalculate=findViewById(R.id.btn_recalculate);
        btn_next=findViewById(R.id.btn_next);
        show_Breakup=findViewById(R.id.show_Breakup);
        linerBtn=findViewById(R.id.linerBtn);

        if (str_for.equals("0")) {
            strFirstTString = "1";
            str_policyType_spinner="Family Floater";
            str_IndividualTypeEdit="2 Adult";
            str_Deductible="2000000";
            Deductible_spinner.setText(str_Deductible);
            str_SumInsured="2000000";
            strSumInsuredTpeEDit="Platinum";
            str_policyTenure="1 Year";
            policyTenure_spinner.setText(str_policyTenure);
            policyType_spinner.setText(str_policyType_spinner);
            familyType_spinner.setText(str_IndividualTypeEdit);
            SumInsured_spinner.setText(str_SumInsured);
            SuperHealthCareQuote();

        }else{
            str_policyTenure=strFirstTString;
            Deductible_spinner.setText(str_Deductible);
            policyType_spinner.setText(str_policyType_spinner);
            familyType_spinner.setText(str_IndividualTypeEdit);
            SumInsured_spinner.setText(str_SumInsured);
            policyTenure_spinner.setText(strFirstTString+" Year");
            totalPremiumAmount.setText(TotalValue);
            txtNetPremiumValue.setText(TotalValue);
//            txtNetPremiumValue.setText(NetPremiumValue);
//            totalPremiumAmount.setText(strPriceTotal);
        }

        if (str_Deductible.equals("100000") || str_Deductible.equals("200000")|| str_Deductible.equals("300000")|| str_Deductible.equals("400000")|| str_Deductible.equals("500000")){
            strSumInsuredTpeEDit="Gold";
            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
            LinerPlan.setVisibility(View.GONE);
        }else if (str_Deductible.equals("600000") || str_Deductible.equals("700000")|| str_Deductible.equals("800000")|| str_Deductible.equals("900000")){
            strSumInsuredTpeEDit="Diamond";
            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
            LinerPlan.setVisibility(View.GONE);
        }else if(str_Deductible.equals("1000000")){
            if (str_SumInsured.equals("300000")||str_SumInsured.equals("500000")||str_SumInsured.equals("700000")){
                strSumInsuredTpeEDit="Diamond";
                LinerPlan.setVisibility(View.GONE);
                SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
            }else if (str_SumInsured.equals("1000000")||str_SumInsured.equals("1500000") || str_SumInsured.equals("2000000")){
                LinerPlan.setVisibility(View.VISIBLE);
                PlanTypeEdit.setText(strSumInsuredTpeEDit);
                SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
            }else{
                LinerPlan.setVisibility(View.GONE);
                strSumInsuredTpeEDit="Platinum";
                SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
            }
        }else if (str_Deductible.equals("1500000") || str_Deductible.equals("2000000")|| str_Deductible.equals("3000000")|| str_Deductible.equals("4000000")){
            strSumInsuredTpeEDit="Platinum";
            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
            LinerPlan.setVisibility(View.GONE);
        }
        LinerPolicyTypeSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(SuperBuyPolicySuminsured.this);
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
                            IndividualTypeEdit.getText().toString();
                            str_IndividualTypeEdit="1 Adult";
                            IndividualTypeEdit.setText(str_IndividualTypeEdit);
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }else {
                            str_IndividualTypeEdit="2 Adult";
                            familyType_spinner.setVisibility(View.VISIBLE);
                            IndividualTypeEdit.setVisibility(View.GONE);
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerDeductible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(SuperBuyPolicySuminsured.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("300000");
                items1.add("400000");
                items1.add("500000");
                items1.add("600000");
                items1.add("700000");
                items1.add("800000");
                items1.add("900000");
                items1.add("1000000");
                items1.add("1500000");
                items1.add("2000000");
                items1.add("3000000");
                items1.add("4000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_Deductible=items1.get(options1);
                        Deductible_spinner.setText(str_Deductible);
                        str_SumInsured="Select";
                        SumInsured_spinner.setText(str_SumInsured);
                        if (str_Deductible.equals("100000") || str_Deductible.equals("200000")|| str_Deductible.equals("300000")|| str_Deductible.equals("400000")|| str_Deductible.equals("500000")){
                            strSumInsuredTpeEDit="Gold";
                            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                            LinerPlan.setVisibility(View.GONE);
                        }else if (str_Deductible.equals("600000") || str_Deductible.equals("700000")|| str_Deductible.equals("800000")|| str_Deductible.equals("900000")){
                            strSumInsuredTpeEDit="Diamond";
                            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                            LinerPlan.setVisibility(View.GONE);
                        } if(str_Deductible.equals("1000000")){
                            if (str_SumInsured.equals("300000")||str_SumInsured.equals("500000")||str_SumInsured.equals("700000")){
                                strSumInsuredTpeEDit="Diamond";
                                SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                                SuperHealthCareQuote();
                                LinerPlan.setVisibility(View.GONE);
                            }else if (str_SumInsured.equals("1000000")||str_SumInsured.equals("1500000") || str_SumInsured.equals("2000000")){
                                strSumInsuredTpeEDit="Select Plan Type";
                                PlanTypeEdit.setText(strSumInsuredTpeEDit);
                                LinerPlan.setVisibility(View.VISIBLE);
                            }
//                            else if (!str_SumInsured.equals("1000000")){
//                                strSumInsuredTpeEDit="Platinum";
//                                SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
//                            }
                        }else if (str_Deductible.equals("1500000") || str_Deductible.equals("2000000")|| str_Deductible.equals("3000000")|| str_Deductible.equals("4000000")){
                            strSumInsuredTpeEDit="Platinum";
                            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                            LinerPlan.setVisibility(View.GONE);
                        }else if (str_SumInsured.equals("str_SumInsured")){
                            Toast.makeText(SuperBuyPolicySuminsured.this, "Select Sum Insured", Toast.LENGTH_SHORT).show();
                        }else{
                            SuperHealthCareQuote();
                        }


                    }
                });
                singlePicker.show(); }
        });
        LinerSumInsured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(SuperBuyPolicySuminsured.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                if (str_Deductible.equals("300000")||str_Deductible.equals("400000")||str_Deductible.equals("500000")){
                    items1.add("200000");items1.add("300000");items1.add("500000");items1.add("700000");items1.add("1000000");
                }else if (str_Deductible.equals("600000")||str_Deductible.equals("700000")||str_Deductible.equals("800000")||str_Deductible.equals("900000")){
                    items1.add("300000");items1.add("500000");  items1.add("700000");items1.add("1000000");items1.add("1500000");items1.add("2000000");
                }else if (str_Deductible.equals("1000000")){
                    items1.add("300000");items1.add("500000");items1.add("700000");items1.add("1000000");items1.add("1500000");items1.add("2000000");
                }else if (str_Deductible.equals("1500000")||str_Deductible.equals("2000000")||str_Deductible.equals("3000000")||str_Deductible.equals("4000000")){
                    items1.add("1000000");items1.add("1500000");items1.add("2000000");items1.add("3000000");items1.add("5000000");items1.add("10000000");
                }
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_SumInsured=items1.get(options1);
                        SumInsured_spinner.setText(str_SumInsured);
                        if(str_Deductible.equals("1000000")){
                            if (str_SumInsured.equals("300000")||str_SumInsured.equals("500000")||str_SumInsured.equals("700000")){
                                strSumInsuredTpeEDit="Diamond";
                                LinerPlan.setVisibility(View.GONE);
                                SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                                SuperHealthCareQuote();
                            }else if (str_SumInsured.equals("1000000")||str_SumInsured.equals("1500000") || str_SumInsured.equals("2000000")|| str_SumInsured.equals("3000000")|| str_SumInsured.equals("5000000")|| str_SumInsured.equals("10000000")){
                                strSumInsuredTpeEDit="Select Plan Type";
                                PlanTypeEdit.setText(strSumInsuredTpeEDit);
                                LinerPlan.setVisibility(View.VISIBLE);
                            }else{
                                LinerPlan.setVisibility(View.GONE);
                                strSumInsuredTpeEDit="Platinum";
                                SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                                SuperHealthCareQuote();
                            }
                        }else if (str_policyType_spinner.equals("")){
                            Toast.makeText(SuperBuyPolicySuminsured.this, "Select Policy Type", Toast.LENGTH_SHORT).show();
                        }else if (str_IndividualTypeEdit.equals("")){
                            Toast.makeText(SuperBuyPolicySuminsured.this, "Select Family Type", Toast.LENGTH_SHORT).show();
                        }else if (str_policyTenure.equals("")){
                            Toast.makeText(SuperBuyPolicySuminsured.this, "Select Policy tenure", Toast.LENGTH_SHORT).show();
                        }else if (str_SumInsured.equals("")){
                            Toast.makeText(SuperBuyPolicySuminsured.this, "Select Sum Insured", Toast.LENGTH_SHORT).show();
                        }else{
                            SuperHealthCareQuote();
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerPlanType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(SuperBuyPolicySuminsured.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Plan Type");
                items1.add("Diamond");
                items1.add("Platinum");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSumInsuredTpeEDit=items1.get(options1);
                        PlanTypeEdit.setText(strSumInsuredTpeEDit);
                        SuperHealthCareQuote();
//                        strSumInsuredTpeEDit=strPlanTypeEdit;
                        SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                    }
                });
                singlePicker.show();
            }
        });
        LinerFamilyType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(SuperBuyPolicySuminsured.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("2 Adult");
                items1.add("1 Adult + 1 Child");
                items1.add("1 Adult + 2 Child");
                items1.add("1 Adult + 3 Child");
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
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                            if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                }else{
                                    SuperHealthCareQuote();
                                }
                            }else{
                                SuperHealthCareQuote();
                            }
                        }else{
                            str_policyType_spinner="Family Floater";
                            policyType_spinner.setText(str_policyType_spinner);
                            str_IndividualTypeEdit="2 Adult";
                            str_Deductible="2000000";
                            str_SumInsured="2000000";
                            SuperHealthCareQuote();
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerPolicySpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(SuperBuyPolicySuminsured.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("1 Year");
                items1.add("2 Year");
                items1.add("3 Year");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_policyTenure=items1.get(options1);
                        policyTenure_spinner.setText(str_policyTenure);
                        String[] strTenureParts =  str_policyTenure.split("Year");
                        strFirstTString = strTenureParts[0];
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
                        int new_dob= Integer.parseInt(strThirdDString)- Integer.parseInt(strFirstString);
                        Log.e("new_dob", String.valueOf(new_dob));
                        str_new_dob=strFirstDString+"-"+ strSecondDString + "-"+String.valueOf(new_dob);
                        Log.e("str_new_dob", str_new_dob);
                        calendar.add(Calendar.DATE, 1);
                        date = calendar.getTime();
                        formatter = new SimpleDateFormat("dd-MM-yyyy");
                        tomorrowDate = formatter.format(date);
                        Log.e("tomorrowDate",tomorrowDate);

                        switch (str_policyTenure) {
                            case "1 Year":
                                strFirstTString = "1";
                                calendar.add(Calendar.DATE, 364);
                                date1 = calendar.getTime();
                                formatter = new SimpleDateFormat("dd-MM-yyyy");
                                nextYear = formatter.format(date1);
                                Log.e("nextYear", nextYear);

                                if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else{
                                    SuperHealthCareQuote();
                                }
                                break;
                            case "2 Year":
                                strFirstTString = "2";
                                calendar.add(Calendar.DATE, 364 * 2);
                                date2 = calendar.getTime();
                                formatter = new SimpleDateFormat("dd-MM-yyyy");
                                nextYear = formatter.format(date2);
                                Log.e("next2Year", nextYear);
                                if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else{
                                    SuperHealthCareQuote();
                                }
                                break;
                            case "3 Year":
                                strFirstTString = "3";
                                calendar.add(Calendar.DATE, 364*3);
                                date3 = calendar.getTime();
                                formatter = new SimpleDateFormat("dd-MM-yyyy");
                                nextYear = formatter.format(date3);
                                Log.e("next3Year", nextYear);
                                if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                                    }else{
                                        SuperHealthCareQuote();
                                    }
                                }else{
                                    SuperHealthCareQuote();
                                }
                                break;
                        }
                    }
                });
                singlePicker.show();
            }
        });
        btn_recalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_policyType_spinner.equals("")){
                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Policy Type", Toast.LENGTH_SHORT).show();
                }else if (str_IndividualTypeEdit.equals("")){
                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Family Type", Toast.LENGTH_SHORT).show();
                }else if (str_policyTenure.equals("")){
                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Policy tenure", Toast.LENGTH_SHORT).show();
                }else if (str_SumInsured.equals("")){
                    Toast.makeText(SuperBuyPolicySuminsured.this, "Select Sum Insured", Toast.LENGTH_SHORT).show();
                }else{
//                    health_quote();
                }
            }
        });
        linerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_Deductible.equals("1000000") && str_SumInsured.equals("1000000")){
                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                    }else{
                        dialogBox();
                    }
                }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("1500000")){
                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                    }else{
                        dialogBox();
                    }
                }else if (str_Deductible.equals("1000000") && str_SumInsured.equals("2000000")){
                    if (strSumInsuredTpeEDit.equals("Select Plan Type")){
                        Toast.makeText(SuperBuyPolicySuminsured.this, "Select Plan Type", Toast.LENGTH_SHORT).show();
                    }else{
                        dialogBox();
                    }
                }else{
                    dialogBox();
                }
            }
        });
        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(SuperBuyPolicySuminsured.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.super_show_breakup);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alert_dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.gravity = Gravity.CENTER;

                buttonClose = alert_dialog.findViewById(R.id.buttonClose);
                basicPremium = alert_dialog.findViewById(R.id.basicPremium);
                sumInsuredEdit = alert_dialog.findViewById(R.id.sumInsuredEdit);
                deductibleEdit = alert_dialog.findViewById(R.id.deductibleEdit);
                gstEdit = alert_dialog.findViewById(R.id.gstEdit);
                totalAmount = alert_dialog.findViewById(R.id.totalAmount);
                globalDiscount = alert_dialog.findViewById(R.id.globalDiscount);
                DiseaseManagement = alert_dialog.findViewById(R.id.DiseaseManagement);

                basicPremium.setText(NetPremiumValue);
                sumInsuredEdit.setText(str_SumInsured);
                deductibleEdit.setText(str_Deductible);
                gstEdit.setText(GST);
                totalAmount.setText(TotalValue);

                if (str_for.equals("1")){
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
    }

    private void dialogBox() {
        final Dialog alert_dialog = new Dialog(SuperBuyPolicySuminsured.this);
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
                Intent intent=new Intent(SuperBuyPolicySuminsured.this, Super_Member_Self.class);
                intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                intent.putExtra("str_SumInsured",str_SumInsured);
                intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                intent.putExtra("NetPremiumValue",NetPremiumValue);
                intent.putExtra("GST",GST);
                intent.putExtra("strFirstTString",strFirstTString);
                intent.putExtra("str_edit_dob3String",strSecondString);
                intent.putExtra("TotalValue",TotalValue);
                intent.putExtra("strPriceTotal",strPriceTotal);
                intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                intent.putExtra("PosPolicyNo",PosPolicyNo);
                intent.putExtra("str_edt_name",str_edt_name);
                intent.putExtra("str_edt_phone",str_edt_phone);
                intent.putExtra("str_email",str_email);
                intent.putExtra("str_age",str_age);
                intent.putExtra("str_reference_no",str_reference_no);
                intent.putExtra("PD_Status",PD_Status);
                intent.putExtra("ESaleDiscount",ESaleDiscount);
                intent.putExtra("LongTermDiscount",LongTermDiscount);
                intent.putExtra("nextYear",nextYear);
                intent.putExtra("tomorrowDate",tomorrowDate);
                intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                intent.putExtra("str_Deductible",str_Deductible);
                intent.putExtra("new_str_age",new_str_age);
                intent.putExtra("BI_Status",BI_Status);
                intent.putExtra("BI_Status1",BI_Status1);
                intent.putExtra("BI_Status2",BI_Status2);
                intent.putExtra("BI_Status3",BI_Status3);
                intent.putExtra("BI_Status4",BI_Status4);
                intent.putExtra("BI_Status5",BI_Status5);
                intent.putExtra("for","0");
                startActivity(intent);
                finish();
                alert_dialog.dismiss();
            }
        });
        alert_dialog.show();
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
            QuotationDtls.put("IsLoyalCustomer","N");
            QuotationDtls.put("IsEmployee","N");
            QuotationDtls.put("EmployeeCode","");
            QuotationDtls.put("ExistingHealthPolicyNo","");
            QuotationDtls.put("IsWellnessProgram","N");
            QuotationDtls.put("GlobalCoverApplicable","N");
            QuotationDtls.put("PolicyTenure",strFirstTString);
            QuotationDtls.put("PlanType","Super Top Up");
            QuotationDtls.put("SubPlanType",strSumInsuredTpeEDit);
            JSONArray array=new JSONArray();
            if(str_IndividualTypeEdit.equals("1 Adult")){
                JSONObject obj=new JSONObject();
                obj.put("InsuredName",str_edt_name);
                obj.put("DateOfBirth",new_str_age);
                obj.put("Gender","Male");
                obj.put("Occupation","Doctors");
                obj.put("Relation","Self");
                obj.put("SumInsured",str_SumInsured);
                obj.put("deductible",str_Deductible);
                obj.put("MedicalCase","No");
                obj.put("IsWellnessProgram","N");
                obj.put("GlobalCoverApplicable","N");
                obj.put("NomineeName","");
                obj.put("NomineeRelation","");
                array.put(obj);
            }
            else if (str_policyType_spinner.equals("Family Floater")){
                if(str_IndividualTypeEdit.equals("2 Adult")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",new_str_age);
                    objAdult2.put("Gender","FeMale");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Spouse");
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_edt_name);
                    objChild1.put("DateOfBirth","27-01-2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_edt_name);
                    objChild1.put("DateOfBirth","27-01-2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_edt_name);
                    objChild2.put("DateOfBirth","27-01-2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_edt_name);
                    objChild1.put("DateOfBirth","27-01-2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_edt_name);
                    objChild2.put("DateOfBirth","27-01-2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("InsuredName",str_edt_name);
                    objChild3.put("DateOfBirth","27-01-2005");
                    objChild3.put("Gender","Male");
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation","Child3");
                    objChild3.put("SumInsured",str_SumInsured);
                    objChild3.put("deductible",str_Deductible);
                    objChild3.put("MedicalCase","No");
                    objChild3.put("IsWellnessProgram","N");
                    objChild3.put("GlobalCoverApplicable","N");
                    objChild3.put("NomineeName","");
                    objChild3.put("NomineeRelation","");
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",new_str_age);
                    objAdult2.put("Gender","Male");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Spouse");
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_edt_name);
                    objChild1.put("DateOfBirth","27-01-2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",new_str_age);
                    objAdult2.put("Gender","Male");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Spouse");
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_edt_name);
                    objChild1.put("DateOfBirth","27-01-2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_edt_name);
                    objChild2.put("DateOfBirth","27-01-2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","Asdas");
                    obj.put("NomineeRelation","Brother");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",new_str_age);
                    objAdult2.put("Gender","FeMale");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Spouse");
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_edt_name);
                    objChild1.put("DateOfBirth","27-01-2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_edt_name);
                    objChild2.put("DateOfBirth","27-01-2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","Asdas");
                    objChild2.put("NomineeRelation","Brother");
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("InsuredName",str_edt_name);
                    objChild3.put("DateOfBirth","27-01-2005");
                    objChild3.put("Gender","Male");
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation","Child3");
                    objChild3.put("SumInsured",str_SumInsured);
                    objChild3.put("deductible",str_Deductible);
                    objChild3.put("MedicalCase","No");
                    objChild3.put("IsWellnessProgram","N");
                    objChild3.put("GlobalCoverApplicable","N");
                    objChild3.put("NomineeName","");
                    objChild3.put("NomineeRelation","");
                    array.put(objChild3);
                }
                else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                    JSONObject obj=new JSONObject();
                    obj.put("InsuredName",str_edt_name);
                    obj.put("DateOfBirth",new_str_age);
                    obj.put("Gender","Male");
                    obj.put("Occupation","Doctors");
                    obj.put("Relation","Self");
                    obj.put("SumInsured",str_SumInsured);
                    obj.put("deductible",str_Deductible);
                    obj.put("MedicalCase","No");
                    obj.put("IsWellnessProgram","N");
                    obj.put("GlobalCoverApplicable","N");
                    obj.put("NomineeName","");
                    obj.put("NomineeRelation","");
                    array.put(obj);
                    JSONObject objAdult2=new JSONObject();
                    objAdult2.put("InsuredName",str_edt_name);
                    objAdult2.put("DateOfBirth",new_str_age);
                    objAdult2.put("Gender","Male");
                    objAdult2.put("Occupation","Doctors");
                    objAdult2.put("Relation","Spouse");
                    objAdult2.put("SumInsured",str_SumInsured);
                    objAdult2.put("deductible",str_Deductible);
                    objAdult2.put("MedicalCase","No");
                    objAdult2.put("IsWellnessProgram","N");
                    objAdult2.put("GlobalCoverApplicable","N");
                    objAdult2.put("NomineeName","");
                    objAdult2.put("NomineeRelation","");
                    array.put(objAdult2);
                    JSONObject objChild1=new JSONObject();
                    objChild1.put("InsuredName",str_edt_name);
                    objChild1.put("DateOfBirth","27-01-2005");
                    objChild1.put("Gender","Male");
                    objChild1.put("Occupation","Student");
                    objChild1.put("Relation","Child1");
                    objChild1.put("SumInsured",str_SumInsured);
                    objChild1.put("deductible",str_Deductible);
                    objChild1.put("MedicalCase","No");
                    objChild1.put("IsWellnessProgram","N");
                    objChild1.put("GlobalCoverApplicable","N");
                    objChild1.put("NomineeName","");
                    objChild1.put("NomineeRelation","");
                    array.put(objChild1);
                    JSONObject objChild2=new JSONObject();
                    objChild2.put("InsuredName",str_edt_name);
                    objChild2.put("DateOfBirth","27-01-2005");
                    objChild2.put("Gender","Male");
                    objChild2.put("Occupation","Student");
                    objChild2.put("Relation","Child2");
                    objChild2.put("SumInsured",str_SumInsured);
                    objChild2.put("deductible",str_Deductible);
                    objChild2.put("MedicalCase","No");
                    objChild2.put("IsWellnessProgram","N");
                    objChild2.put("GlobalCoverApplicable","N");
                    objChild2.put("NomineeName","");
                    objChild2.put("NomineeRelation","");
                    array.put(objChild2);
                    JSONObject objChild3=new JSONObject();
                    objChild3.put("InsuredName",str_edt_name);
                    objChild3.put("DateOfBirth","27-01-2005");
                    objChild3.put("Gender","Male");
                    objChild3.put("Occupation","Student");
                    objChild3.put("Relation","Child3");
                    objChild3.put("SumInsured",str_SumInsured);
                    objChild3.put("deductible",str_Deductible);
                    objChild3.put("MedicalCase","No");
                    objChild3.put("IsWellnessProgram","N");
                    objChild3.put("GlobalCoverApplicable","N");
                    objChild3.put("NomineeName","");
                    objChild3.put("NomineeRelation","");
                    array.put(objChild3);
                    JSONObject objChild4=new JSONObject();
                    objChild4.put("InsuredName",str_edt_name);
                    objChild4.put("DateOfBirth","27-01-2005");
                    objChild4.put("Gender","Male");
                    objChild4.put("Occupation","Student");
                    objChild4.put("Relation","Child4");
                    objChild4.put("SumInsured",str_SumInsured);
                    objChild4.put("deductible",str_Deductible);
                    objChild4.put("MedicalCase","No");
                    objChild4.put("IsWellnessProgram","N");
                    objChild4.put("GlobalCoverApplicable","N");
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(SuperBuyPolicySuminsured.this, object, UrlHealthConstants.SuperHealthCareQuote_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("Status").equals("True")) {
                    if (Tag == RequestHealthConstants.SUPER_HEALTH_QUOTATION) {
                        try {
                           if (object.optString("Status").equals("True")){
                               JSONObject jsonObject  = object.getJSONObject("usgiSuperHealthCare");
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
                               double newTotalValue1= Double.parseDouble(newTotalValue);
                             double newGST1=Double.parseDouble(newGST);

                               GST=String.format("%.2f", newGST1);
                               TotalValue=String.format("%.2f", newTotalValue1);

                               txtNetPremiumValue.setText(TotalValue);
                               totalPremiumAmount.setText(TotalValue);
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

}