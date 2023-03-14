package com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health;

import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.AllIndividualCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.AllIndividualHospitalCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.ChildCriticalCalculate;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.AllIndivisualHealth.ChildHospitalCalculate;

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
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.BuyPolicyModel;
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

public class BuyPolicySumInsured extends AppCompatActivity {
     String BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,new_str_age,ESaleDiscount,LongTermDiscount,PD_Status,strPriceTotal,strNominee_dob,str_new_dob,today,tomorrowDate,nextYear,strThirdDString,str_policyType_spinner,str_IndividualTypeEdit,str_for,strFirstTString,str_age="",str_edit_dob,str_reference_no,str_email,str_edt_phone,str_edt_name,str_policyTenure,str_SumInsured,str_edit_dob3String,str_OneEditName,str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,strChildOne,strChildTwo,strChildThree,strChildFour,strOneChild,str_oneWeightEdit,strtwoDob,strfourDob,strthreeDob,strtwoWeightEdit,str_thirdWeightEdit,strFourWeightEdit,
             TotalValue,NetPremiumValue,PosPolicyNo,GST,str_amountPersonalSumInsured,strcriticalEdit,strhospitalEdit,strOneChildCriticalIllnessTxt,stroneChildTxt,strSumInsuredTpeEDit,str_inches,str_weight_edit,str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_weight_edit,str_spouse_inches_spinner,str_RelationEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit;
    double  amountPersonalSumInsured,personalSumInsured;
    EditText totalPremiumAmount,IndividualTypeEdit,policyType_spinner,familyType_spinner,SumInsured_spinner,SumInsuredTpeEDit;
    private MySharedPreference pref;
    CustomProgressDialog customprogress;
    Date date,date1,date2,date3;
    LinearLayout linerBtn,policyTypeSpinnerLiner,LinerFamilyType,LinerSumInsuredSpinner,LinerPolicySpinner;
    Format formatter;
    EditText policyTenure_spinner;
    String[] policyTenure;
    Button btn_recalculate,btn_next;
    double totalPrice;
    TextView show_Breakup,txtNetPremiumValue,SumInsuredTpeTxt;
    EditText basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital,longTermDiscountTxt,ESaleTxt;
    Button buttonClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_policy_sum_insured);
        getWindow().setStatusBarColor(ContextCompat.getColor(BuyPolicySumInsured.this, R.color.colorPrimaryDark));

        pref = MySharedPreference.getInstance(BuyPolicySumInsured.this);
        customprogress = new CustomProgressDialog(BuyPolicySumInsured.this);
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_email = getIntent().getStringExtra("str_email");
        str_age = getIntent().getStringExtra("str_age");
        str_reference_no = getIntent().getStringExtra("str_reference_no");
        str_edit_dob = getIntent().getStringExtra("str_edit_dob");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
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

        policyType_spinner=findViewById(R.id.policyType_spinner);
        policyTypeSpinnerLiner=findViewById(R.id.policyTypeSpinnerLiner);
        LinerFamilyType=findViewById(R.id.LinerFamilyType);
        LinerSumInsuredSpinner=findViewById(R.id.LinerSumInsuredSpinner);
        LinerPolicySpinner=findViewById(R.id.LinerPolicySpinner);
        familyType_spinner=findViewById(R.id.familyType_spinner);
        SumInsured_spinner=findViewById(R.id.SumInsured_spinner);
        policyTenure_spinner=findViewById(R.id.policyTenure_spinner);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        IndividualTypeEdit=findViewById(R.id.IndividualTypeEdit);
        txtNetPremiumValue=findViewById(R.id.txtNetPremiumValue);
//        policyTenure=getResources().getStringArray(R.array.policyTenure);
        btn_recalculate=findViewById(R.id.btn_recalculate);
        btn_next=findViewById(R.id.btn_next);
        show_Breakup=findViewById(R.id.show_Breakup);
        linerBtn=findViewById(R.id.linerBtn);
        SumInsuredTpeEDit=findViewById(R.id.SumInsuredTpeEDit);
        SumInsuredTpeTxt=findViewById(R.id.SumInsuredTpeTxt);

        if (str_for.equals("0")) {
            strFirstTString = "1";
            str_policyType_spinner="Family Floater";
            str_IndividualTypeEdit="2 Adult";
            str_SumInsured="500000";
            strSumInsuredTpeEDit="Essential";
            PD_Status="False";
            str_policyTenure="1 Year";
            BI_Status="True";
            BI_Status1="True";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status4="False";
            BI_Status5="False";

            policyTenure_spinner.setText(str_policyTenure);
            policyType_spinner.setText(str_policyType_spinner);
            familyType_spinner.setText(str_IndividualTypeEdit);
            SumInsured_spinner.setText(str_SumInsured);
            health_quote();

        }else{
            policyType_spinner.setText(str_policyType_spinner);
            if (str_policyType_spinner.equals("Individual")){
                IndividualTypeEdit.setVisibility(View.VISIBLE);
                familyType_spinner.setVisibility(View.GONE);
                IndividualTypeEdit.setText(str_IndividualTypeEdit);
            }else{
                IndividualTypeEdit.setVisibility(View.GONE);
                familyType_spinner.setVisibility(View.VISIBLE);
                familyType_spinner.setText(str_IndividualTypeEdit);
            }

            str_policyTenure=strFirstTString;
            SumInsured_spinner.setText(str_SumInsured);
            policyTenure_spinner.setText(strFirstTString+" Year");
            totalPremiumAmount.setText(TotalValue);
            txtNetPremiumValue.setText(NetPremiumValue);

//            txtNetPremiumValue.setText(NetPremiumValue);
//            totalPremiumAmount.setText(strPriceTotal);
        }

//        final ArrayAdapter<String> policyTenureAdapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,policyTenure);
//        policyTenure_spinner.setAdapter(policyTenureAdapter);
        if (str_SumInsured.equals("500000") || str_SumInsured.equals("400000")){
            strSumInsuredTpeEDit="Essential";
            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
        }else{
            strSumInsuredTpeEDit="Privilege";
            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
        }

        policyTypeSpinnerLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySumInsured.this);
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
                            BI_Status="True";
                            BI_Status1="False";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            IndividualTypeEdit.setText(str_IndividualTypeEdit);
                            health_quote();
                        }else {
                            str_IndividualTypeEdit="2 Adult";
                            BI_Status="True";
                            BI_Status1="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            familyType_spinner.setVisibility(View.VISIBLE);
                            familyType_spinner.setText(str_IndividualTypeEdit);
                            IndividualTypeEdit.setVisibility(View.GONE);
                            health_quote();
                        }
                    }
                });
                singlePicker.show(); }
        });

        LinerFamilyType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySumInsured.this);
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
                            BI_Status="True";
                            BI_Status1="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            health_quote();
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                            BI_Status1="False";
                            BI_Status="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            health_quote();
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                            BI_Status1="False";
                            BI_Status="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            health_quote();
                        }
                        else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                            BI_Status1="False";
                            BI_Status="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            health_quote();
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                            BI_Status="True";
                            BI_Status1="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            health_quote();
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                            BI_Status="True";
                            BI_Status1="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            health_quote();
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                            BI_Status="True";
                            BI_Status1="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            health_quote();
                        }
                        else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                            BI_Status="True";
                            BI_Status1="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                            health_quote();
                        }else{
                            str_policyType_spinner="Family Floater";
                            policyType_spinner.setText(str_policyType_spinner);
                            str_IndividualTypeEdit="2 Adult";
                            str_SumInsured="500000";
                            BI_Status="True";
                            BI_Status1="True";
                            BI_Status2="False";
                            BI_Status3="False";
                            BI_Status4="False";
                            BI_Status5="False";
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerSumInsuredSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySumInsured.this);
                final ArrayList<String> items1 = new ArrayList<String>();
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
                        str_SumInsured=items1.get(options1);
                        SumInsured_spinner.setText(str_SumInsured);
                        if (str_SumInsured.equals("500000") || str_SumInsured.equals("400000")){
                            strSumInsuredTpeEDit="Essential";
                            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                        }else{
                            strSumInsuredTpeEDit="Privilege";
                            SumInsuredTpeTxt.setText(strSumInsuredTpeEDit);
                        }
                        if (str_policyType_spinner.equals("")){
                            Toast.makeText(BuyPolicySumInsured.this, "Select Policy Type", Toast.LENGTH_SHORT).show();
                        }else if (str_IndividualTypeEdit.equals("")){
                            Toast.makeText(BuyPolicySumInsured.this, "Select Family Type", Toast.LENGTH_SHORT).show();
                        }else if (str_policyTenure.equals("")){
                            Toast.makeText(BuyPolicySumInsured.this, "Select Policy tenure", Toast.LENGTH_SHORT).show();
                        }else if (str_SumInsured.equals("")){
                            Toast.makeText(BuyPolicySumInsured.this, "Select Sum Insured", Toast.LENGTH_SHORT).show();
                        }else{
                            health_quote();
                        }
                    }
                });
                singlePicker.show();
            }
        });
        LinerPolicySpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(BuyPolicySumInsured.this);
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

                        switch (str_policyTenure) {
                            case "1 Year":
                                strFirstTString = "1";
                                PD_Status="False";
                                calendar.add(Calendar.DATE, 364);
                                date1 = calendar.getTime();
                                formatter = new SimpleDateFormat("dd/MM/yyyy");
                                nextYear = formatter.format(date1);
                                Log.e("nextYear", nextYear);
                                health_quote();
                                break;
                            case "2 Year":
                                strFirstTString = "2";
                                PD_Status="True";
                                calendar.add(Calendar.DATE, 364 * 2);
                                date2 = calendar.getTime();
                                formatter = new SimpleDateFormat("dd/MM/yyyy");
                                nextYear = formatter.format(date2);
                                Log.e("next2Year", nextYear);
                                health_quote();
                                break;
                            case "3 Year":
                                strFirstTString = "3";
                                PD_Status="True";
                                calendar.add(Calendar.DATE, 364*3);
                                date3 = calendar.getTime();
                                formatter = new SimpleDateFormat("dd/MM/yyyy");
                                nextYear = formatter.format(date3);
                                Log.e("next3Year", nextYear);
                                health_quote();
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
                    Toast.makeText(BuyPolicySumInsured.this, "Select Policy Type", Toast.LENGTH_SHORT).show();
                }else if (str_IndividualTypeEdit.equals("")){
                    Toast.makeText(BuyPolicySumInsured.this, "Select Family Type", Toast.LENGTH_SHORT).show();
                }else if (str_policyTenure.equals("")){
                    Toast.makeText(BuyPolicySumInsured.this, "Select Policy tenure", Toast.LENGTH_SHORT).show();
                }else if (str_SumInsured.equals("")){
                    Toast.makeText(BuyPolicySumInsured.this, "Select Sum Insured", Toast.LENGTH_SHORT).show();
                }else{
                    health_quote();
                }
            }
        });

        linerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(BuyPolicySumInsured.this);
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
                        Intent intent=new Intent(BuyPolicySumInsured.this,Complete_health_member_info.class);
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
        });

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(BuyPolicySumInsured.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.show_breakup);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alert_dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.gravity = Gravity.CENTER;


                criticalEdit = alert_dialog.findViewById(R.id.criticalEdit);
                premiumEdit = alert_dialog.findViewById(R.id.premiumEdit);
                hospitalEdit = alert_dialog.findViewById(R.id.hospitalEdit);
                basicPremium = alert_dialog.findViewById(R.id.basicPremium);
                subLimitAmount = alert_dialog.findViewById(R.id.subLimitAmount);
                totalAmount = alert_dialog.findViewById(R.id.totalAmount);
                gstEdit = alert_dialog.findViewById(R.id.gstEdit);
                tiedHospital = alert_dialog.findViewById(R.id.tiedHospital);
                longTermDiscountTxt = alert_dialog.findViewById(R.id.longTermDiscountTxt);
                ESaleTxt = alert_dialog.findViewById(R.id.ESaleTxt);
                buttonClose = alert_dialog.findViewById(R.id.buttonClose);

                if(PD_Status.equals("False")){
                        ESaleDiscount="110.00";
                       ESaleTxt.setText(ESaleDiscount);
                }else{
                   ESaleTxt.setText(ESaleDiscount);
                    }

              if (strFirstTString.equals("2")){
                    longTermDiscountTxt.setText(LongTermDiscount);
                }else if (strFirstTString.equals("3")){
                    longTermDiscountTxt.setText(LongTermDiscount);
                }else{
                    longTermDiscountTxt.setText("0");
                }


                basicPremium.setText(NetPremiumValue);
                criticalEdit.setText(strcriticalEdit);
                premiumEdit.setText(str_amountPersonalSumInsured);
                hospitalEdit.setText(strhospitalEdit);
                subLimitAmount.setText("0");
                totalAmount.setText(TotalValue);
                tiedHospital.setText("0");
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

    private void health_quote() {

        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("Plan_Type",str_policyType_spinner);
            object.put("Floater_Type",str_IndividualTypeEdit);
            object.put("Sum_Insured",str_SumInsured);
            object.put("Policy_Duration",strFirstTString);
            object.put("DOB",new_str_age);
            object.put("Proposal_Date",today);
            object.put("From_Date",tomorrowDate);
            object.put("To_Date",nextYear);
            object.put("PA_Status","False");
            object.put("CI_Status","False");
            object.put("DHC_Status","False");
            object.put("Esale_Status","True");
            object.put("Life_Status","False");
            object.put("PD_Status",PD_Status);
            object.put("Sub_Status","False");
            object.put("Tiered_Status","False");
            object.put("Sub_Type","");
            if(str_IndividualTypeEdit.equals("2 Adult")){
                object.put("DOB1",new_str_age);
            }
            object.put("DOB1","");
            object.put("DOB2","");
            object.put("DOB3","");
            object.put("DOB4","");
            object.put("DOB5","");
            object.put("PA_Status1","False");
            object.put("CI_Status1","False");
            object.put("DHC_Status1","False");
            object.put("PA_Status2","False");
            object.put("CI_Status2","False");
            object.put("DHC_Status2","False");
            object.put("PA_Status3","False");
            object.put("CI_Status3","False");
            object.put("DHC_Status3","False");
            object.put("PA_Status4","False");
            object.put("CI_Status4","False");
            object.put("DHC_Status4","False");
            object.put("PA_Status5","False");
            object.put("CI_Status5","False");
            object.put("DHC_Status5","False");
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(BuyPolicySumInsured.this, object, UrlHealthConstants.BUY_HEALTH_CARE_QUOTATION_URL, new ResponseListener() {
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
                            JSONObject OtherDiscountsJsonObject = RisksDataJsonObject.getJSONObject("OtherDiscounts");
                            JSONObject OtherDiscountGroupJsonObject = OtherDiscountsJsonObject.getJSONObject("OtherDiscountGroup");
                            JSONArray OtherDiscountGroupDataJsonObject = OtherDiscountGroupJsonObject.getJSONArray("OtherDiscountGroupData");

                            for (int i=0;i <OtherDiscountGroupDataJsonObject.length();i++){
                                JSONObject LongTermJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(5);
                                JSONObject PremiumJson=LongTermJsonObject.getJSONObject("Premium");
                                LongTermDiscount = PremiumJson.getString("Value");
                                Log.e("LongTermDiscount",LongTermDiscount);
                                JSONObject ESaleJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(4);
                                JSONObject ESale=ESaleJsonObject.getJSONObject("Premium");
                                ESaleDiscount = ESale.getString("Value");
                                Log.e("ESaleDiscount",ESaleDiscount);

                            }
                            Log.e("gg", String.valueOf(PremiumCalculationJsonObject));
                            JSONObject NetPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("NetPremium");
                            JSONObject ServiceTaxJsonObject = PremiumCalculationJsonObject.getJSONObject("ServiceTax");
                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
                            Log.e("TotalPremium", String.valueOf(TotalPremiumJsonObject));
                            NetPremiumValue = NetPremiumJsonObject.getString("Value");
                            TotalValue = TotalPremiumJsonObject.getString("Value");
                            PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
                            GST = ServiceTaxJsonObject.getString("Value");
//                            totalPrice= Double.parseDouble(TotalValue)-110.0;
//                            strPriceTotal= String.valueOf(totalPrice);
                            totalPremiumAmount.setText(TotalValue);
                            txtNetPremiumValue.setText(NetPremiumValue);

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