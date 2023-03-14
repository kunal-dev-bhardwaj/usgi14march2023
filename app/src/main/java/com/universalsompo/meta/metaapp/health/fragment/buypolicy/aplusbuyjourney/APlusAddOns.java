package com.universalsompo.meta.metaapp.health.fragment.buypolicy.aplusbuyjourney;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.google.gson.Gson;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.NewCHIAddOns;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class APlusAddOns extends AppCompatActivity {
    HorizontalScrollView horizontalView;
    LinearLayout AddonsLiner, continueButton, SumInsuredDropDown,linear_firstMember_sumSpinner,linear_secondMember_sumSpinner,linear_thirdMember_sumSpinner,linear_fourthMember_sumSpinner,linear_fifthMember_sumSpinner,linear_sixthMember_sumSpinner;
    String today,nextYear,strPolicyTenure,str_policyType_spinner,strFor,strEdtName,strEdtPhone,strEdtEmail,FamilyComposition,ParentComposition,PlanType,strSumInsured,strTotalPremium,strSelfAgeEditText,strGender,PosPolicyNo,NetPremium,GSt,DirectPolicyDiscountPremium,strBasicPremium,MaternityAndChildcareAdd,MaternityAndChildcareMale,CoverageNonMedical,PreExistingDiseaseStatus,LongTermDiscountStatus,OrganDiscountStatus,WomenDiscountStatus,EmployeeDiscountStatus,FamilyDiscountStatus,PreExistingDiseaseCoverPremium,strfamilyDiscount,CoverageNonMedicalCoverPremium,MaternityChildcareCoverPremium;
    String str_age,strGenderSpinner,strCheckBoxSelf,strCheckBoxSpouse,strSpouseAgeEditText="",strCheckBoxSon="",strFirstSonAgeEditText="",strSecondSonAgeEditText="",strThirdSonAgeEditText="",strFourSonAgeEditText="",strMotherAgeEditText="",strCheckBoxMother="",strFatherAgeEditText="",strCheckBoxFather="",strMotherLawAgeEditText="",strCheckBoxMotherLaw="",strFatherLawAgeEditText="",strCheckBoxFatherLaw="",strPermanentPinCode="",strPresentPinCode="",strGrandMotherEditText = "";
    double addons,BasicInsuranceCoverPremium1,MaternityChildcareCoverPremium1,CoverageNonMedicalCoverPremium1,PreExistingDiseaseCoverPremium1,Discounts,LongTermDiscountDiscountPremium,OrganDonorDiscountPremium,WomenDiscountPremium,FamilyDiscountPremium,EmployeeDiscountPremium;
    double BasicInsuranceCoverPremiumAd1,MaternityChildcareCoverPremiumAd1,CoverageNonMedicalCoverPremiumAd1,PreExistingDiseaseCoverPremiumAd1;
    int FamilyTypeCounter,mCounter,selectYearAdult,selectYearSecondAdult,selectFirstYearChild,selectSecSonChild,selectThirdSonChild,selectYearChildFour,selectYearMotherAdult,selectMotherLawAdult;
    EditText SumInsuredEditText,edt_firstMember_sumInsured,edt_secondMember_sumInsured,edt_thirdMember_sumInsured,edt_fourthMember_sumInsured,edt_fifthMember_sumInsured,edt_sixthMember_sumInsured;
    Date date;
    Double totalPremium = 0.0,nonMedical= 0.0,total = 0.0,preDieses = 0.0,maternity=0.0,totalAddons = 0.0;
    CheckBox CheckBoxCoverageNonMedical,CheckBoxPreExistingDisease,CheckBoxMaternityChildcare,checkBoxFamilyDiscount,checkbox_women_discount,CheckBoxOrganDiscount,CheckBoxDircePolicyDiscount,CheckBoxEmployeDiscount;
    String strCheckBoxGrandMother,strCheckBoxGrandFather,strCheckBoxGrandSon,strCheckBoxGrandDaughter,strCheckBoxSonInLaw,strCheckBoxDaughterInLaw,strCheckBoxBrotherInLaw,strCheckBoxSisterInLaw,strCheckBox_Son,strCheckBox_Daughter,strCheckBox_Brother,strCheckBox_Sister,strCheckBox_Nephew,strCheckBox_Niece;
    String strAge,strPincode,strState,strCity,strNonMedical,strPreDieses,strFamilyDiscount,strWomenDiscount,strOrganDiscount,strLongTurmDiscount,strEmployeDiscount,strDirectPolicyDiscount,strGrandFatherAgeEditText="",strSisterInLawAgeEditText="",strBrotherInLawAgeEditText="",strDaughterInLawAgeEditText=" ",strSonInLawAgeEditText="",strGrandDaughterAgeEditText="",strGrandSonAgeEditText="",strSonAgeEditText="",strDaughterAgeEditText="",strNephewAgeEditText="",strNieceAgeEditText = "",strBrotherAgeEditText = "",strSisterAgeEditText = "";
    RadioButton btnRadio_SilverOneYear,btnRadio_SilverTwoYear,btnRadio_SilverThreeYear,btnRadio_GoldOneYear,btnRadio_GoldTwoYear,btnRadio_GoldThreeYear,btnRadio_DiamondOneYear,btnRadio_DiamondTwoYear,btnRadio_DiamondThreeYear;
    int adult1_age = 0,adult2_age = 0, adult3_age = 0, adult4_age = 0, adult5_age = 0, adult6_age = 0;
    ArrayList<String> relation_list = new ArrayList<>();
    ArrayList<Integer> age_list = new ArrayList<>();
    String plantypes ="",strGenderEditSpinner="";
    LinearLayout linear_card1,linear_card2,linear_card3,linear_card4,linear_card5,LinerMaternity;
    String strSecondSumInsured,strthirdSumInsured,strfourthSumInsured,strfifthSumInsured,strSixthSumInsured,relation1,relation2,relation3,relation4,relation5,relation6;
    TextView TotalPremium,PreexistingDiseasePremiumTxt,MaternityChildcarePremiumTxt,NoMedicalPremiumTxt,text_secondMember_relation,text_thirdMember_relation,text_fourthMember_relation,text_fifthMember_relation,text_sixthMember_relation,text_firstMember_Relation,basicPremium_SilverCard,basicPremium_GoldCard,basicPremium_DiamondCard,text_familyDiscount_amount;
    @SuppressLint("SimpleDateFormat")
    Format formatter=new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplus_add_ons);
        getWindow().setStatusBarColor(ContextCompat.getColor(APlusAddOns.this, R.color.colorPrimaryDark));

        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
        strFor = getIntent().getStringExtra("strFor");
        strGenderSpinner = getIntent().getStringExtra("strGenderSpinner");
        strEdtPhone = getIntent().getStringExtra("strEdtPhone");
        strEdtEmail = getIntent().getStringExtra("strEdtEmail");
        strEdtName = getIntent().getStringExtra("strEdtName");
        str_age = getIntent().getStringExtra("str_age");
        FamilyComposition = getIntent().getStringExtra("FamilyComposition");
        ParentComposition = getIntent().getStringExtra("ParentComposition");
        strCheckBoxSelf = getIntent().getStringExtra("strCheckBoxSelf");
        str_policyType_spinner = getIntent().getStringExtra("str_policyType_spinner");
      //  strSelfAgeEditText = getIntent().getStringExtra("strSelfAgeEditText");
        strCheckBoxSpouse = getIntent().getStringExtra("strCheckBoxSpouse");
      //  strSpouseAgeEditText = getIntent().getStringExtra("strSpouseAgeEditText");
        strCheckBoxMother = getIntent().getStringExtra("strCheckBoxMother");
     //   strMotherAgeEditText = getIlinear_nonCoveragentent().getStringExtra("strMotherAgeEditText");
     //   strFatherAgeEditText = getIntent().getStringExtra("strFatherAgeEditText");
        strCheckBoxFather = getIntent().getStringExtra("strCheckBoxFather");
        strCheckBoxMotherLaw = getIntent().getStringExtra("strCheckBoxMotherLaw");
     //   strMotherLawAgeEditText = getIntent().getStringExtra("strMotherLawAgeEditText");
        strCheckBoxFatherLaw = getIntent().getStringExtra("strCheckBoxFatherLaw");
     //   strFatherLawAgeEditText = getIntent().getStringExtra("strFatherLawAgeEditText");
        strFirstSonAgeEditText = getIntent().getStringExtra("strFirstSonAgeEditText");
        strSecondSonAgeEditText = getIntent().getStringExtra("strSecondSonAgeEditText");
        strThirdSonAgeEditText = getIntent().getStringExtra("strThirdSonAgeEditText");
        strFourSonAgeEditText = getIntent().getStringExtra("strFourSonAgeEditText");
        strCheckBoxSon = getIntent().getStringExtra("strCheckBoxSon");
        strPincode = getIntent().getStringExtra("strPincode");
        strState = getIntent().getStringExtra("strState");
        strCity = getIntent().getStringExtra("strCity");
        strCheckBoxGrandMother = getIntent().getStringExtra("strCheckBoxGrandMother");
        strCheckBoxGrandFather = getIntent().getStringExtra("strCheckBoxGrandFather");
        strCheckBoxGrandSon = getIntent().getStringExtra("strCheckBoxGrandSon");
        strCheckBoxGrandDaughter = getIntent().getStringExtra("strCheckBoxGrandDaughter");
        strCheckBoxSonInLaw = getIntent().getStringExtra("strCheckBoxSonInLaw");
        strCheckBoxDaughterInLaw = getIntent().getStringExtra("strCheckBoxDaughterInLaw");
        strCheckBoxBrotherInLaw = getIntent().getStringExtra("strCheckBoxBrotherInLaw");
        strCheckBoxSisterInLaw = getIntent().getStringExtra("strCheckBoxSisterInLaw");
        strCheckBox_Son = getIntent().getStringExtra("strCheckBox_Son");
        strCheckBox_Daughter = getIntent().getStringExtra("strCheckBox_Daughter");
        strCheckBox_Brother = getIntent().getStringExtra("strCheckBox_Brother");
        strCheckBox_Sister = getIntent().getStringExtra("strCheckBox_Sister");
        strCheckBox_Nephew = getIntent().getStringExtra("strCheckBox_Nephew");
        strCheckBox_Niece = getIntent().getStringExtra("strCheckBox_Niece");
        strGenderEditSpinner = getIntent().getStringExtra("strGenderSpinner");

        if (getIntent().hasExtra("strSelfAgeEditText")){
            strSelfAgeEditText = getIntent().getStringExtra("strSelfAgeEditText");
        }
        if (getIntent().hasExtra("strSpouseAgeEditText")){
            strSpouseAgeEditText = getIntent().getStringExtra("strSpouseAgeEditText");
        }
        if (getIntent().hasExtra("strMotherAgeEditText")){
            strMotherAgeEditText = getIntent().getStringExtra("strMotherAgeEditText");
        }
        if (getIntent().hasExtra("strFatherAgeEditText")){
            strFatherAgeEditText = getIntent().getStringExtra("strFatherAgeEditText");
        }
        if (getIntent().hasExtra("strMotherLawAgeEditText")){
            strMotherLawAgeEditText = getIntent().getStringExtra("strMotherLawAgeEditText");
        }
        if (getIntent().hasExtra("strFatherLawAgeEditText")){
            strFatherLawAgeEditText = getIntent().getStringExtra("strFatherLawAgeEditText");
        }
        if(getIntent().hasExtra("strGrandMotherEditText")){
            strGrandMotherEditText = getIntent().getStringExtra("strGrandMotherEditText");
        }
        if (getIntent().hasExtra("strGrandFatherAgeEditText")){
            strGrandFatherAgeEditText = getIntent().getStringExtra("strGrandFatherAgeEditText");
        }
        if (getIntent().hasExtra("strGrandSonAgeEditText")){
            strGrandSonAgeEditText = getIntent().getStringExtra("strGrandSonAgeEditText");
        }
        if (getIntent().hasExtra("strGrandDaughterAgeEditText")){
            strGrandDaughterAgeEditText = getIntent().getStringExtra("strGrandDaughterAgeEditText");
        }
        if (getIntent().hasExtra("strSonInLawAgeEditText")){
            strSonInLawAgeEditText = getIntent().getStringExtra("strSonInLawAgeEditText");
        }
        if (getIntent().hasExtra("strDaughterInLawAgeEditText")){
            strDaughterInLawAgeEditText = getIntent().getStringExtra("strDaughterInLawAgeEditText");
        }
        if (getIntent().hasExtra("strBrotherInLawAgeEditText")){
            strBrotherInLawAgeEditText = getIntent().getStringExtra("strBrotherInLawAgeEditText");
        }
        if (getIntent().hasExtra("strSisterInLawAgeEditText")){
            strSisterInLawAgeEditText = getIntent().getStringExtra("strSisterInLawAgeEditText");
        }
        if (getIntent().hasExtra("strSonAgeEditText")){
            strSonAgeEditText = getIntent().getStringExtra("strSonAgeEditText");
        }
        if (getIntent().hasExtra("strDaughterAgeEditText")){
            strDaughterAgeEditText = getIntent().getStringExtra("strDaughterAgeEditText");
        }
        if (getIntent().hasExtra("strBrotherAgeEditText")){
            strBrotherAgeEditText = getIntent().getStringExtra("strBrotherAgeEditText");
        }
        if (getIntent().hasExtra("strSisterAgeEditText")){
            strSisterAgeEditText = getIntent().getStringExtra("strSisterAgeEditText");
        }
        if (getIntent().hasExtra("strNephewAgeEditText")){
            strNephewAgeEditText = getIntent().getStringExtra("strNephewAgeEditText");
        }
        if (getIntent().hasExtra("strNieceAgeEditText")){
            strNieceAgeEditText = getIntent().getStringExtra("strNieceAgeEditText");
        }


        selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
        selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
        selectYearMotherAdult = getIntent().getIntExtra("selectYearMotherAdult", 0);
        selectMotherLawAdult = getIntent().getIntExtra("selectMotherLawAdult", 0);
        selectFirstYearChild = getIntent().getIntExtra("selectFirstYearChild", 0);
        selectSecSonChild = getIntent().getIntExtra("selectSecSonChild", 0);
        selectThirdSonChild = getIntent().getIntExtra("selectThirdSonChild", 0);
        selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        FamilyTypeCounter = getIntent().getIntExtra("FamilyTypeCounter", 0);
        mCounter = getIntent().getIntExtra("mCounter", 0);
        relation_list = getIntent().getStringArrayListExtra("relation_list");
        age_list = getIntent().getIntegerArrayListExtra("age_list");

        initView();
    }

    private void initView() {
        horizontalView = findViewById(R.id.horizontalView);
        AddonsLiner = findViewById(R.id.AddonsLiner);
        SumInsuredEditText = findViewById(R.id.SumInsuredEditText);
        SumInsuredDropDown = findViewById(R.id.SumInsuredDropDown);
        PreexistingDiseasePremiumTxt = findViewById(R.id.PreexistingDiseasePremiumTxt);
        MaternityChildcarePremiumTxt = findViewById(R.id.MaternityChildcarePremiumTxt);
        NoMedicalPremiumTxt = findViewById(R.id.NoMedicalPremiumTxt);
        TotalPremium = findViewById(R.id.TotalPremium);
        continueButton = findViewById(R.id.continueButton);

        //Linear Layout
       // linear_firstMember_sumSpinner = findViewById(R.id.linear_firstMember_sumSpinner);
        linear_secondMember_sumSpinner = findViewById(R.id.linear_secondMember_sumSpinner);
        linear_thirdMember_sumSpinner = findViewById(R.id.linear_thirdMember_sumSpinner);
        linear_fourthMember_sumSpinner = findViewById(R.id.linear_fourthMember_sumSpinner);
        linear_fifthMember_sumSpinner = findViewById(R.id.linear_fifthMember_sumSpinner);
        linear_sixthMember_sumSpinner = findViewById(R.id.linear_sixthMember_sumSpinner);
        linear_card1 = findViewById(R.id.linear_card1);
        linear_card2 = findViewById(R.id.linear_card2);
        linear_card3 = findViewById(R.id.linear_card3);
        linear_card4 = findViewById(R.id.linear_card4);
        linear_card5 = findViewById(R.id.linear_card5);
        LinerMaternity = findViewById(R.id.LinerMaternity);


        //Edit Text
       // edt_firstMember_sumInsured = findViewById(R.id.edt_firstMember_sumInsured);
        edt_secondMember_sumInsured = findViewById(R.id.edt_seconMember_sumInsured);
        edt_thirdMember_sumInsured = findViewById(R.id.edt_thirdMember_sumInsured);
        edt_fourthMember_sumInsured = findViewById(R.id.edt_fourthMember_sumInsured);
        edt_fifthMember_sumInsured = findViewById(R.id.edt_fifthMember_sumInsured);
        edt_sixthMember_sumInsured = findViewById(R.id.edt_sixthMember_sumInsured);

        //Text View
        text_secondMember_relation = findViewById(R.id.text_secondMember_Relation);
        text_thirdMember_relation = findViewById(R.id.text_thirdMember_Relation);
        text_fourthMember_relation = findViewById(R.id.text_fourthMember_Relation);
        text_fifthMember_relation = findViewById(R.id.text_fifthMember_Relation);
        text_sixthMember_relation = findViewById(R.id.text_sixthMember_Relation);
        text_firstMember_Relation = findViewById(R.id.text_firstMember_Relation);
        basicPremium_SilverCard = findViewById(R.id.basicPremium_SilverCard);
        basicPremium_GoldCard = findViewById(R.id.basicPremium_GoldCard);
        basicPremium_DiamondCard = findViewById(R.id.basicPremium_DiamondCard);
        text_familyDiscount_amount = findViewById(R.id.text_familyDiscount_amount);

        //Radio Button
        btnRadio_SilverOneYear = findViewById(R.id.btnRadio_SilverOneYear);
        btnRadio_SilverTwoYear = findViewById(R.id.btnRadio_SilverTwoYear);
        btnRadio_SilverThreeYear = findViewById(R.id.btnRadio_SilverThirdYear);
        btnRadio_GoldOneYear = findViewById(R.id.btnRadio_GoldOneYear);
        btnRadio_GoldTwoYear = findViewById(R.id.btnRadio_GoldTwoYear);
        btnRadio_GoldThreeYear = findViewById(R.id.btnRadio_GoldThreeYear);
        btnRadio_DiamondOneYear = findViewById(R.id.btnRadio_DiamondOneYear);
        btnRadio_DiamondTwoYear = findViewById(R.id.btnRadio_DiamondTwoYear);
        btnRadio_DiamondThreeYear = findViewById(R.id.btnRadio_DiamondThreeYear);

        //CheckBox
        CheckBoxCoverageNonMedical = findViewById(R.id.CheckBoxCoverageNonMedical);
        CheckBoxPreExistingDisease = findViewById(R.id.CheckBoxPreExistingDisease);
        checkBoxFamilyDiscount = findViewById(R.id.checkBoxFamilyDiscount);
        checkbox_women_discount = findViewById(R.id.checkbox_women_discount);
        CheckBoxOrganDiscount = findViewById(R.id.CheckBoxOrganDiscount);
        CheckBoxDircePolicyDiscount = findViewById(R.id.CheckBoxDircePolicyDiscount);
        CheckBoxEmployeDiscount = findViewById(R.id.CheckBoxEmployeDiscount);
        CheckBoxMaternityChildcare = findViewById(R.id.CheckBoxMaternityChildcare);

        strSumInsured = "5000000";
        SumInsuredEditText.setText(strSumInsured);


        Log.d("fjdfhfd", "initView: "+strGrandSonAgeEditText+"  "+strGrandFatherAgeEditText);


        if (str_policyType_spinner.equals("Multi-individual")||str_policyType_spinner.equals("Family Floater")) {
            horizontalView.setVisibility(View.VISIBLE);
            AddonsLiner.setVisibility(View.VISIBLE);
            text_firstMember_Relation.setVisibility(View.VISIBLE);

            for (int i = 0; i<age_list.size();i++){
                if (i==0){
                    adult1_age = age_list.get(i);

                } if (i==1){
                    adult2_age = age_list.get(i);
                    linear_card1.setVisibility(View.VISIBLE);

                } if (i==2){
                    adult3_age = age_list.get(i);
                    linear_card2.setVisibility(View.VISIBLE);

                } if (i==3){
                    adult4_age = age_list.get(i);
                    linear_card3.setVisibility(View.VISIBLE);

                } if (i==4) {
                    adult5_age = age_list.get(i);
                    linear_card4.setVisibility(View.VISIBLE);

                }if (i==5) {
                    adult6_age = age_list.get(i);
                    linear_card5.setVisibility(View.VISIBLE);

                }

            }

        } else {
            horizontalView.setVisibility(View.GONE);
            AddonsLiner.setVisibility(View.GONE);
            text_firstMember_Relation.setVisibility(View.GONE);

        }

        Log.d("sxiccddc", "initView: "+strFatherAgeEditText+"  "+strFatherLawAgeEditText);

        if (strCheckBoxSelf.equals("Checked")){
            strAge = strSelfAgeEditText;
           if(strGenderEditSpinner.equals("Female")){
               LinerMaternity.setVisibility(View.VISIBLE);
            }else{
               LinerMaternity.setVisibility(View.GONE);
           }
        }else if (strCheckBoxSpouse.equals("Checked")){
            strAge = strSpouseAgeEditText;
            if(strGenderEditSpinner.equals("Female")){
                LinerMaternity.setVisibility(View.VISIBLE);
            }else{
                LinerMaternity.setVisibility(View.GONE);
            }
        }else if (strCheckBoxMother.equals("Checked")){
            strAge = strMotherAgeEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }else if (strCheckBoxFather.equals("Checked")){
            strAge = strFatherAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBoxMotherLaw.equals("Checked")){
            strAge = strMotherLawAgeEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }else if (strCheckBoxFatherLaw.equals("Checked")){
            strAge = strFatherLawAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBoxGrandMother.equals("Checked")){
            strAge = strGrandMotherEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }else if (strCheckBoxGrandFather.equals("Checked")){
            strAge = strGrandFatherAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBoxGrandSon.equals("Checked")){
            strAge = strGrandSonAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBoxGrandDaughter.equals("Checked")){
            strAge = strGrandDaughterAgeEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }else if (strCheckBoxSonInLaw.equals("Checked")){
            strAge = strSonInLawAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBoxDaughterInLaw.equals("Checked")){
            strAge = strDaughterInLawAgeEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }else if (strCheckBoxBrotherInLaw.equals("Checked")){
            strAge = strBrotherInLawAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBoxSisterInLaw.equals("Checked")){
            strAge = strSisterInLawAgeEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }else if (strCheckBox_Son.equals("Checked")){
            strAge = strSonAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBox_Daughter.equals("Checked")){
            strAge = strDaughterAgeEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }else if (strCheckBox_Brother.equals("Checked")){
            strAge = strBrotherAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBox_Sister.equals("Checked")){
            strAge = strSisterAgeEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }else if (strCheckBox_Nephew.equals("Checked")){
            strAge = strNephewAgeEditText;
            LinerMaternity.setVisibility(View.GONE);
        }else if (strCheckBox_Niece.equals("Checked")){
            strAge = strNieceAgeEditText;
            LinerMaternity.setVisibility(View.VISIBLE);
        }

        Log.d("duhdudc", "initView: "+strAge);

        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        today = formatter.format(date);
        plantypes="Silver";
        strPolicyTenure="1";
        if (strPolicyTenure.equals("2")){
            calendar.add(Calendar.DATE, 364 * 2);
            date = calendar.getTime();
            nextYear = formatter.format(date);
        }else if(strPolicyTenure.equals("3")){
            calendar.add(Calendar.DATE, 364*3);
            date = calendar.getTime();
            nextYear = formatter.format(date);
        }else{
            calendar.add(Calendar.DATE, 364);
            date = calendar.getTime();
            nextYear = formatter.format(date);
            Log.e("nextYear", nextYear);
        }

        CoverageNonMedical="False";
        MaternityAndChildcareMale="False";
        PreExistingDiseaseStatus="False";
        LongTermDiscountStatus="False";
        OrganDiscountStatus="False";
        WomenDiscountStatus="False";
        EmployeeDiscountStatus="False";
        FamilyDiscountStatus="False";
        strNonMedical = "False";
       strPreDieses = "False";
        strFamilyDiscount = "False";
        strWomenDiscount = "False";
        strOrganDiscount = "False";
        strLongTurmDiscount = "False";
        strEmployeDiscount = "False";
        strDirectPolicyDiscount = "False";
        strPresentPinCode="121103";
        strPermanentPinCode="100005";
        ADDOnsAPI();
        TotalPremiumAPI();


        SumInsuredDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(APlusAddOns.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("500000");
                items1.add("750000");
                items1.add("1000000");
                items1.add("1250000");
                items1.add("1500000");
                items1.add("2000000");
                items1.add("2500000");
                items1.add("5000000");
                items1.add("7500000");
                items1.add("10000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSumInsured = items1.get(options1);
                        SumInsuredEditText.setText(strSumInsured);
                        ADDOnsAPI();
                        TotalPremiumAPI();
                    }
                });
                singlePicker.show();
            }

        });

        //Second Member Dropdown
        linear_secondMember_sumSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(APlusAddOns.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("500000");
                items1.add("750000");
                items1.add("1000000");
                items1.add("1250000");
                items1.add("1500000");
                items1.add("2000000");
                items1.add("2500000");
                items1.add("5000000");
                items1.add("7500000");
                items1.add("10000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSecondSumInsured = items1.get(options1);
                        edt_secondMember_sumInsured.setText(strSecondSumInsured);
                    }
                });
                singlePicker.show();
            }
        });

        //Third Member Dropdown
        linear_thirdMember_sumSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(APlusAddOns.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("500000");
                items1.add("750000");
                items1.add("1000000");
                items1.add("1250000");
                items1.add("1500000");
                items1.add("2000000");
                items1.add("2500000");
                items1.add("5000000");
                items1.add("7500000");
                items1.add("10000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strthirdSumInsured = items1.get(options1);
                        edt_thirdMember_sumInsured.setText(strthirdSumInsured);
                    }
                });
                singlePicker.show();
            }
        });

        //Fourth Member Dropdown
        linear_fourthMember_sumSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(APlusAddOns.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("500000");
                items1.add("750000");
                items1.add("1000000");
                items1.add("1250000");
                items1.add("1500000");
                items1.add("2000000");
                items1.add("2500000");
                items1.add("5000000");
                items1.add("7500000");
                items1.add("10000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strfourthSumInsured = items1.get(options1);
                        edt_fourthMember_sumInsured.setText(strfourthSumInsured);
                    }
                });
                singlePicker.show();
            }
        });

        //Fifth Member Dropdown
        linear_fifthMember_sumSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(APlusAddOns.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("500000");
                items1.add("750000");
                items1.add("1000000");
                items1.add("1250000");
                items1.add("1500000");
                items1.add("2000000");
                items1.add("2500000");
                items1.add("5000000");
                items1.add("7500000");
                items1.add("10000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strfifthSumInsured = items1.get(options1);
                        edt_fifthMember_sumInsured.setText(strfifthSumInsured);
                    }
                });
                singlePicker.show();
            }
        });

        //Sixth Member Dropdown
        linear_sixthMember_sumSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(APlusAddOns.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("500000");
                items1.add("750000");
                items1.add("1000000");
                items1.add("1250000");
                items1.add("1500000");
                items1.add("2000000");
                items1.add("2500000");
                items1.add("5000000");
                items1.add("7500000");
                items1.add("10000000");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strSixthSumInsured = items1.get(options1);
                        edt_sixthMember_sumInsured.setText(strSixthSumInsured);
                    }
                });
                singlePicker.show();
            }
        });

        for (int i = 0; i<relation_list.size();i++){
            if (i == 0){
                relation1 = relation_list.get(i);
                text_firstMember_Relation.setText(relation1);

            }
            if (i==1){
                relation2 = relation_list.get(i);
                text_secondMember_relation.setText(relation2);
            }
            if (i==2){
                relation3 = relation_list.get(i);
                text_thirdMember_relation.setText(relation3);
            }
            if (i==3){
                relation4 = relation_list.get(i);
                text_fourthMember_relation.setText(relation4);
            }
            if (i==4){
                relation5 = relation_list.get(i);
                text_fifthMember_relation.setText(relation5);
            }
            if (i==5){
                relation6 = relation_list.get(i);
                text_sixthMember_relation.setText(relation6);
            }

        }

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(APlusAddOns.this, APlusPersonalInmofo.class);
                intent.putExtra("str_policyType_spinner", str_policyType_spinner);
                startActivity(intent);
            }
        });

        CheckBoxPreExistingDisease.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    strPreDieses = "True";
                    preDieses = (Double.parseDouble(PreExistingDiseaseCoverPremium));
                    totalPremium = Double.parseDouble(strTotalPremium);
                    total = totalPremium+preDieses;
                    totalAddons = total;
                    TotalPremium.setText(String.valueOf(totalAddons));
                }else{
                    strPreDieses = "False";
                    // total = totalPremium-preDieses;
                    total = totalPremium+preDieses;
                    totalAddons = total;;
                    TotalPremium.setText(strTotalPremium);
                }
            }
        });

        CheckBoxMaternityChildcare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    maternity = (Double.parseDouble(MaternityChildcareCoverPremium));
                    totalPremium = Double.parseDouble(strTotalPremium);
                    totalAddons = totalAddons+maternity;
                    TotalPremium.setText(String.valueOf(totalAddons));
                }else{
                    totalAddons = totalAddons-maternity;
                    TotalPremium.setText(String.valueOf(totalAddons));
                   // TotalPremium.setText(strTotalPremium);
                }
            }
        });

        CheckBoxCoverageNonMedical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    strNonMedical = "True";
                    nonMedical = (Double.parseDouble(CoverageNonMedicalCoverPremium));
                    totalPremium = Double.parseDouble(strTotalPremium);
                    total = totalPremium+nonMedical;
                    TotalPremium.setText(String.valueOf(total));

                }else{
                    strNonMedical = "False";
                    TotalPremium.setText(strTotalPremium);
                }

            }
        });




        checkBoxFamilyDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxFamilyDiscount.isChecked()){
                    strFamilyDiscount = "True";
                }else{
                    strFamilyDiscount = "False";
                }

            }
        });

        checkbox_women_discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkbox_women_discount.isChecked()){
                    strWomenDiscount = "True";
                }else{
                    strWomenDiscount = "False";
                }

            }
        });
        CheckBoxEmployeDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckBoxEmployeDiscount.isChecked()){
                    strEmployeDiscount = "True";
                }else{
                    strEmployeDiscount = "False";
                }

            }
        });
        CheckBoxDircePolicyDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckBoxDircePolicyDiscount.isChecked()){
                    strDirectPolicyDiscount = "True";
                }else{
                    strDirectPolicyDiscount = "False";
                }

            }
        });


        CheckBoxOrganDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckBoxOrganDiscount.isChecked()){
                    strOrganDiscount = "True";
                }else{
                    strOrganDiscount = "False";
                }

            }
        });



        btnRadio_SilverOneYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Silver";
                strPolicyTenure = "1";
                btnRadio_SilverOneYear.setChecked(true);
                btnRadio_SilverTwoYear.setChecked(false);
                btnRadio_SilverThreeYear.setChecked(false);
                btnRadio_GoldOneYear.setChecked(false);
                btnRadio_GoldTwoYear.setChecked(false);
                btnRadio_GoldThreeYear.setChecked(false);
                btnRadio_DiamondOneYear.setChecked(false);
                btnRadio_DiamondTwoYear.setChecked(false);
                btnRadio_DiamondThreeYear.setChecked(false);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });

        btnRadio_SilverTwoYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Silver";
                strPolicyTenure = "2";
                btnRadio_SilverOneYear.setChecked(false);
                btnRadio_SilverTwoYear.setChecked(true);
                btnRadio_SilverThreeYear.setChecked(false);
                btnRadio_GoldOneYear.setChecked(false);
                btnRadio_GoldTwoYear.setChecked(false);
                btnRadio_GoldThreeYear.setChecked(false);
                btnRadio_DiamondOneYear.setChecked(false);
                btnRadio_DiamondTwoYear.setChecked(false);
                btnRadio_DiamondThreeYear.setChecked(false);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });

        btnRadio_SilverThreeYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Silver";
                strPolicyTenure = "3";
                btnRadio_SilverOneYear.setChecked(false);
                btnRadio_SilverTwoYear.setChecked(false);
                btnRadio_SilverThreeYear.setChecked(true);
                btnRadio_GoldOneYear.setChecked(false);
                btnRadio_GoldTwoYear.setChecked(false);
                btnRadio_GoldThreeYear.setChecked(false);
                btnRadio_DiamondOneYear.setChecked(false);
                btnRadio_DiamondTwoYear.setChecked(false);
                btnRadio_DiamondThreeYear.setChecked(false);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });

        btnRadio_GoldOneYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Gold";
                strPolicyTenure = "1";
                btnRadio_SilverOneYear.setChecked(false);
                btnRadio_SilverTwoYear.setChecked(false);
                btnRadio_SilverThreeYear.setChecked(false);
                btnRadio_GoldOneYear.setChecked(true);
                btnRadio_GoldTwoYear.setChecked(false);
                btnRadio_GoldThreeYear.setChecked(false);
                btnRadio_DiamondOneYear.setChecked(false);
                btnRadio_DiamondTwoYear.setChecked(false);
                btnRadio_DiamondThreeYear.setChecked(false);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });
        btnRadio_GoldTwoYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Gold";
                strPolicyTenure = "2";
                btnRadio_SilverOneYear.setChecked(false);
                btnRadio_SilverTwoYear.setChecked(false);
                btnRadio_SilverThreeYear.setChecked(false);
                btnRadio_GoldOneYear.setChecked(false);
                btnRadio_GoldTwoYear.setChecked(true);
                btnRadio_GoldThreeYear.setChecked(false);
                btnRadio_DiamondOneYear.setChecked(false);
                btnRadio_DiamondTwoYear.setChecked(false);
                btnRadio_DiamondThreeYear.setChecked(false);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });

        btnRadio_GoldThreeYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Gold";
                strPolicyTenure = "3";
                btnRadio_SilverOneYear.setChecked(false);
                btnRadio_SilverTwoYear.setChecked(false);
                btnRadio_SilverThreeYear.setChecked(false);
                btnRadio_GoldOneYear.setChecked(false);
                btnRadio_GoldTwoYear.setChecked(false);
                btnRadio_GoldThreeYear.setChecked(true);
                btnRadio_DiamondOneYear.setChecked(false);
                btnRadio_DiamondTwoYear.setChecked(false);
                btnRadio_DiamondThreeYear.setChecked(false);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });

        btnRadio_DiamondOneYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Diamond";
                strPolicyTenure = "1";
                btnRadio_SilverOneYear.setChecked(false);
                btnRadio_SilverTwoYear.setChecked(false);
                btnRadio_SilverThreeYear.setChecked(false);
                btnRadio_GoldOneYear.setChecked(false);
                btnRadio_GoldTwoYear.setChecked(false);
                btnRadio_GoldThreeYear.setChecked(false);
                btnRadio_DiamondOneYear.setChecked(true);
                btnRadio_DiamondTwoYear.setChecked(false);
                btnRadio_DiamondThreeYear.setChecked(false);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });

        btnRadio_DiamondTwoYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Diamond";
                strPolicyTenure = "2";
                btnRadio_SilverOneYear.setChecked(false);
                btnRadio_SilverTwoYear.setChecked(false);
                btnRadio_SilverThreeYear.setChecked(false);
                btnRadio_GoldOneYear.setChecked(false);
                btnRadio_GoldTwoYear.setChecked(false);
                btnRadio_GoldThreeYear.setChecked(false);
                btnRadio_DiamondOneYear.setChecked(false);
                btnRadio_DiamondTwoYear.setChecked(true);
                btnRadio_DiamondThreeYear.setChecked(false);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });

        btnRadio_DiamondThreeYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantypes = "Diamond";
                strPolicyTenure = "3";
                btnRadio_SilverOneYear.setChecked(false);
                btnRadio_SilverTwoYear.setChecked(false);
                btnRadio_SilverThreeYear.setChecked(false);
                btnRadio_GoldOneYear.setChecked(false);
                btnRadio_GoldTwoYear.setChecked(false);
                btnRadio_GoldThreeYear.setChecked(false);
                btnRadio_DiamondOneYear.setChecked(false);
                btnRadio_DiamondTwoYear.setChecked(false);
                btnRadio_DiamondThreeYear.setChecked(true);
                ADDOnsAPI();
                TotalPremiumAPI();
            }
        });

    }



    private void ADDOnsAPI() {

//        if (str_policyType_spinner.equals("Individual")) {
//            if (strGenderSpinner.equals("Female")) {
//                if (strCheckBoxSelf.equals("Checked")) {
//                    strGender = "F";
//                    if (selectYearAdult > 18) {
//                        MaternityAndChildcareAdd = "True";
//                    } else {
//                        MaternityAndChildcareAdd = "False";
//                    }
//                } else if (strCheckBoxSpouse.equals("Checked")) {
//                    strGender = "M";
//                    MaternityAndChildcareAdd = "False";
//                }
//            } else {
//                if (strCheckBoxSpouse.equals("Checked")) {
//                    strGender = "F";
//                    if (selectYearSecondAdult > 18) {
//                        MaternityAndChildcareAdd = "True";
//                    }else{
//                        MaternityAndChildcareAdd = "False";
//                    }
//                }else{
//                    strGender = "M";
//                    MaternityAndChildcareAdd = "False";
//                }
//
//            }
//        }
        JSONObject object = new JSONObject();
        try {
            JSONObject RootObject = new JSONObject();
            //Authentication
            JSONObject AuthenticationObject = new JSONObject();
            AuthenticationObject.put("WACode", "20000001");
            AuthenticationObject.put("WAAppCode", "30000011");
            AuthenticationObject.put("WAUserID", "USER01");
            AuthenticationObject.put("WAUserPwd", "pass@123");
            AuthenticationObject.put("WAType", "0");
            RootObject.put("Authentication", AuthenticationObject);
            //Customer
            JSONObject CustomerObject = new JSONObject();
            CustomerObject.put("CustomerType", str_policyType_spinner);
            CustomerObject.put("CustomerName", "");
            CustomerObject.put("DOB", "");
            CustomerObject.put("Gender", "F");
            CustomerObject.put("CanBeParent", "0");
            CustomerObject.put("ContactTelephoneSTD", "");
            CustomerObject.put("MobileNo", strEdtPhone);
            CustomerObject.put("Emailid", strEdtEmail);
            CustomerObject.put("PresentAddressLine1", "");
            CustomerObject.put("PresentAddressLine2", "");
            CustomerObject.put("PresentStateCode", strState);
            CustomerObject.put("PresentCityDistCode", strCity);
            CustomerObject.put("PresentPinCode", strPincode);
            CustomerObject.put("PermanentAddressLine1", "");
            CustomerObject.put("PermanentAddressLine2", "");
            CustomerObject.put("PermanentStateCode", "");
            CustomerObject.put("PermanentCityDistCode", "");
            CustomerObject.put("PermanentPinCode", strPermanentPinCode);
            CustomerObject.put("CustGSTNo", "NULL");
            CustomerObject.put("ProductName", "A PLUS HEALTH INSURANCE");
            CustomerObject.put("InstrumentNo", "NULL");
            CustomerObject.put("InstrumentDate", "NULL");
            CustomerObject.put("BankID", "NULL");
            CustomerObject.put("PosPolicyNo", "");
            CustomerObject.put("ProductCode", "2858");
            CustomerObject.put("WAURN", "NULL");
            CustomerObject.put("NomineeName", "");
            CustomerObject.put("NomineeRelation", "");
            CustomerObject.put("PANNo", "NULL");
            CustomerObject.put("AadhaarNo", "");
            CustomerObject.put("EIA", "NULL");
            CustomerObject.put("CKYCNo", "");
            CustomerObject.put("Ref_No_Unique_KYC", "");
            RootObject.put("Customer", CustomerObject);
            //POSAGENT
            JSONObject POSAGENTObject = new JSONObject();
            POSAGENTObject.put("Name", "");
            POSAGENTObject.put("PAN", "");
            POSAGENTObject.put("Aadhar", "");
            POSAGENTObject.put("Email", "");
            POSAGENTObject.put("MobileNo", "");
            POSAGENTObject.put("Location", "");
//            POSAGENTObject.put("Location", "MUMBAI CORPORATE OFFICE");
            POSAGENTObject.put("Information1", "NULL");
            POSAGENTObject.put("Information2", "NULL");
            RootObject.put("POSAGENT", POSAGENTObject);

            JSONObject ProductObject = new JSONObject();
            JSONObject GeneralProposalObject = new JSONObject();
            JSONObject GeneralProposalGroupObject = new JSONObject();
            JSONObject DistributionChannelObject = new JSONObject();
            //Branch
            JSONObject BranchDetailsObject = new JSONObject();

            BranchDetailsObject.put("IMDBranchName", "NULL");
            BranchDetailsObject.put("IMDBranchCode", "NULL");
            DistributionChannelObject.put("BranchDetails", BranchDetailsObject);
            //SpDetails
            JSONObject SPDetailsObject = new JSONObject();
            SPDetailsObject.put("SPName", "NULL");
            SPDetailsObject.put("SPCode", "NULL");
            DistributionChannelObject.put("SPDetails", SPDetailsObject);
            GeneralProposalGroupObject.put("DistributionChannel", DistributionChannelObject);

            //GeneralProposalInformation
            JSONObject GeneralProposalInformationObject = new JSONObject();
            GeneralProposalInformationObject.put("TypeOfBusiness", "FROM INTERMEDIARY");
            GeneralProposalInformationObject.put("ServiceTaxExemptionCategory", "No Exemption");
            GeneralProposalInformationObject.put("BusinessType", "New");
            GeneralProposalInformationObject.put("Sector", "Others");
            GeneralProposalInformationObject.put("DealId", "INTR-2312-0019722");
            GeneralProposalInformationObject.put("PolicyType", str_policyType_spinner);
            GeneralProposalInformationObject.put("FamilyComposition", "");
            GeneralProposalInformationObject.put("ParentComposition", "");
            GeneralProposalInformationObject.put("PlanType", plantypes);
            GeneralProposalInformationObject.put("ProposalDate", today);
            GeneralProposalInformationObject.put("PolicyDuration", strPolicyTenure);
            GeneralProposalInformationObject.put("PolicyNumberChar", "NULL");
            //PolicyEffectiveDate
            JSONObject PolicyEffectiveDateObject = new JSONObject();
            PolicyEffectiveDateObject.put("Fromdate", today);
            PolicyEffectiveDateObject.put("Todate", nextYear);
            PolicyEffectiveDateObject.put("Fromhour", "00:01");
            PolicyEffectiveDateObject.put("Tohour", "23:59");
            GeneralProposalInformationObject.put("PolicyEffectiveDate", PolicyEffectiveDateObject);

            GeneralProposalInformationObject.put("EmployeeCode", "");
            GeneralProposalInformationObject.put("InstallmentFrequency", "");
            GeneralProposalInformationObject.put("RequestType", "Quotation");
            GeneralProposalGroupObject.put("GeneralProposalInformation", GeneralProposalInformationObject);
            GeneralProposalObject.put("GeneralProposalGroup", GeneralProposalGroupObject);

            //FinancierDetails
            JSONObject FinancierDetailsObject = new JSONObject();
            JSONObject FinancierDtlGrpObject = new JSONObject();
            JSONObject FinancierDtlGrpDataObject = new JSONObject();
            FinancierDtlGrpDataObject.put("FinancierCode", "NULL");
            FinancierDtlGrpDataObject.put("AgreementType", "NULL");
            FinancierDtlGrpDataObject.put("BranchName", "NULL");
            FinancierDtlGrpDataObject.put("FinancierName", "NULL");
            FinancierDtlGrpDataObject.put("SrNo", "NULL");
            FinancierDtlGrpObject.put("FinancierDtlGrpData", FinancierDtlGrpDataObject);
            FinancierDetailsObject.put("FinancierDtlGrp", FinancierDtlGrpObject);
            GeneralProposalObject.put("FinancierDetails", FinancierDetailsObject);

            //PreviousPolicyDetails
            JSONObject PreviousPolicyDetailsObject = new JSONObject();
            JSONObject PreviousPolDtlGroupObject = new JSONObject();
            JSONObject PreviousPolDtlGroupDataObject = new JSONObject();
            PreviousPolDtlGroupDataObject.put("ProductCode", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimSettled", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimPremium", "0");
            PreviousPolDtlGroupDataObject.put("ClaimAmount", "0");
            PreviousPolDtlGroupDataObject.put("DateofLoss", "NULL");
            PreviousPolDtlGroupDataObject.put("NatureofLoss", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimNo", "99999999");
            PreviousPolDtlGroupDataObject.put("PolicyEffectiveTo", "999999");
            PreviousPolDtlGroupDataObject.put("PolicyEffectiveFrom", "99");
            PreviousPolDtlGroupDataObject.put("PolicyPremium", "0");
            PreviousPolDtlGroupDataObject.put("PolicyNo", "NULL");
            PreviousPolDtlGroupDataObject.put("PolicyYear", "NULL");
            PreviousPolDtlGroupDataObject.put("OfficeCode", "NULL");
            PreviousPolDtlGroupDataObject.put("CorporateCustomerId", "NULL");
            PreviousPolDtlGroupDataObject.put("InsurerName", "NULL");
            PreviousPolDtlGroupDataObject.put("InsurerAddress", "NULL");
            PreviousPolDtlGroupObject.put("PreviousPolDtlGroupData", PreviousPolDtlGroupDataObject);
            PreviousPolicyDetailsObject.put("PreviousPolDtlGroup", PreviousPolDtlGroupObject);
            PreviousPolicyDetailsObject.put("PreviousPolicyType", "Package Policy");
            PreviousPolicyDetailsObject.put("OfficeAddress", "NULL");
            GeneralProposalObject.put("PreviousPolicyDetails", PreviousPolicyDetailsObject);
            ProductObject.put("GeneralProposal", GeneralProposalObject);

            //PremiumCalculation
            JSONObject PremiumCalculationObject = new JSONObject();
            PremiumCalculationObject.put("NetPremium", "0");
            PremiumCalculationObject.put("ServiceTax", "0");
            PremiumCalculationObject.put("StampDuty2", "0");
            PremiumCalculationObject.put("TotalPremium", "0");
            PremiumCalculationObject.put("CGST", "0");
            PremiumCalculationObject.put("SGST", "0");
            PremiumCalculationObject.put("UGST", "0");
            PremiumCalculationObject.put("IGST", "0");
            PremiumCalculationObject.put("TotalBasePremium", "0");
            PremiumCalculationObject.put("TotalAddonPremium", "0");
            PremiumCalculationObject.put("TotalDiscountPremium", "0");
            ProductObject.put("PremiumCalculation", PremiumCalculationObject);

            //Risks
            JSONObject RisksObject = new JSONObject();
            JSONObject RiskObject = new JSONObject();
            JSONObject RisksDataObject = new JSONObject();
            JSONObject InsuredDetailsObject = new JSONObject();
            JSONArray InsuredDetailsGroupArray = new JSONArray();

            JSONObject InsuredDetailsObj = new JSONObject();
            InsuredDetailsObj.put("InsuredType", "Adult");
            InsuredDetailsObj.put("FirstName", "");
            InsuredDetailsObj.put("LastName", "");
            InsuredDetailsObj.put("DOB", strAge);
            InsuredDetailsObj.put("Gender", "F");
            InsuredDetailsObj.put("Relationship", "Self");
            InsuredDetailsObj.put("Occupation", "");
            InsuredDetailsObj.put("NomineeName", "");
            InsuredDetailsObj.put("NomineeRelationship", "");
            InsuredDetailsObj.put("NomineeDOB", "");
            InsuredDetailsObj.put("NomineeAge", "");
            InsuredDetailsObj.put("NomineeGender", "");
            InsuredDetailsObj.put("AppointeeName", "");
            InsuredDetailsObj.put("AppointeeDOB", "");
            InsuredDetailsObj.put("AppointeeAge", "");
            InsuredDetailsObj.put("AppointeeGender", "");
            InsuredDetailsObj.put("AppointeeRelation", "");

            JSONObject HealthIndicatorsObj = new JSONObject();
            HealthIndicatorsObj.put("PED", "");
            HealthIndicatorsObj.put("PEDDeclared", "");
            HealthIndicatorsObj.put("BodyMassIndex", "17");
            HealthIndicatorsObj.put("IllnessOrDisease", "");
            HealthIndicatorsObj.put("TreatementOrMedicine", "");
            HealthIndicatorsObj.put("VisitedDoctor", "");
            HealthIndicatorsObj.put("Hospitalized", "");
            HealthIndicatorsObj.put("TakenAnyTreatement", "");
            HealthIndicatorsObj.put("Alcohol", "");
            HealthIndicatorsObj.put("AlcoholType", "");
            HealthIndicatorsObj.put("AlcoholQuantity", "");
            HealthIndicatorsObj.put("AlcoholDuration", "");
            HealthIndicatorsObj.put("Smoker", "Y");
            HealthIndicatorsObj.put("SmokerType", "Cigrate");
            HealthIndicatorsObj.put("SmokerQuantity", "0");
            HealthIndicatorsObj.put("SmokerDuration", "5");
            HealthIndicatorsObj.put("Tobacco", "Y");
            HealthIndicatorsObj.put("TobaccoType", "Gutkha");
            HealthIndicatorsObj.put("TobaccoQuantity", "0");
            HealthIndicatorsObj.put("TobaccoDuration", "0");
            HealthIndicatorsObj.put("Narcotics", "");
            InsuredDetailsObj.put("HealthIndicators", HealthIndicatorsObj);

            JSONObject CoverDetailsObj = new JSONObject();
            JSONArray CoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversObj = new JSONObject();
            BasicInsuranceCoversObj.put("Applicable", "True");
            BasicInsuranceCoversObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversObj.put("CoverRate", "0");
            BasicInsuranceCoversObj.put("CoverPremium", "0");
            BasicInsuranceCoversObj.put("CoverGroups", "Basic Insurance Cover");
            CoversArray.put(BasicInsuranceCoversObj);


            JSONObject MaternityAndChildcareCoversObj = new JSONObject();
            MaternityAndChildcareCoversObj.put("Applicable", "True");
            MaternityAndChildcareCoversObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversObj.put("CoverRate", "0");
            MaternityAndChildcareCoversObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversObj.put("CoverGroups", "MATERNITY AND CHILDCARE BENEFIT WAITING PERIOD MODIFICATION");
            CoversArray.put(MaternityAndChildcareCoversObj);

            JSONObject CoverageForNonMedicalCoversObj = new JSONObject();
            CoverageForNonMedicalCoversObj.put("Applicable", "True");
            CoverageForNonMedicalCoversObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversObj.put("CoverGroups", "COVERAGE FOR NON-MEDICAL ITEMS");
            CoversArray.put(CoverageForNonMedicalCoversObj);

            JSONObject PreExistingDiseaseCoversObj = new JSONObject();
            PreExistingDiseaseCoversObj.put("Applicable", "True");
            PreExistingDiseaseCoversObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversObj.put("CoverRate", "0");
            PreExistingDiseaseCoversObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversObj.put("CoverGroups", "PRE-EXISTING DISEASE WAITING PERIOD");
            CoversArray.put(PreExistingDiseaseCoversObj);

            CoverDetailsObj.put("Covers", CoversArray);
            InsuredDetailsObj.put("CoverDetails", CoverDetailsObj);


            InsuredDetailsGroupArray.put(InsuredDetailsObj);
            //2nd Adult

            //
            InsuredDetailsObject.put("InsuredDetailsGroup", InsuredDetailsGroupArray);
            RisksDataObject.put("InsuredDetails", InsuredDetailsObject);
            //otherLoading
            JSONObject OtherLoadingsObject = new JSONObject();
            JSONObject OtherLoadingGroupObject = new JSONObject();
            JSONObject OtherLoadingGroupDataObject = new JSONObject();
            OtherLoadingGroupDataObject.put("LoadingAmount", "0");
            OtherLoadingGroupDataObject.put("LoadingRate", "0");
            OtherLoadingGroupDataObject.put("SumInsured", "0");
            OtherLoadingGroupDataObject.put("Rate", "0");
            OtherLoadingGroupDataObject.put("Premium", "0");
            OtherLoadingGroupDataObject.put("Applicable", "False");
            OtherLoadingGroupDataObject.put("Description", "NULL");
            OtherLoadingGroupObject.put("OtherLoadingGroupData", OtherLoadingGroupDataObject);
            OtherLoadingsObject.put("OtherLoadingGroup", OtherLoadingGroupObject);

            RisksDataObject.put("OtherLoadings", OtherLoadingsObject);
            //OtherDiscounts
            JSONObject OtherDiscountsObject = new JSONObject();
            JSONArray OtherDiscountGroupArray = new JSONArray();

            JSONObject LongObject = new JSONObject();
            LongObject.put("DiscountAmount", "0");
            LongObject.put("DiscountRate", "0");
            LongObject.put("SumInsured", strSumInsured);
            LongObject.put("Rate", "0");
            LongObject.put("Premium", "0");
            LongObject.put("Applicable", "True");
            LongObject.put("Description", "Long term discount");
            OtherDiscountGroupArray.put(LongObject);

            JSONObject FamilyDiscountObject = new JSONObject();
            FamilyDiscountObject.put("DiscountAmount", "0");
            FamilyDiscountObject.put("DiscountRate", "0");
            FamilyDiscountObject.put("SumInsured", strSumInsured);
            FamilyDiscountObject.put("Rate", "0");
            FamilyDiscountObject.put("Premium", "0");
            FamilyDiscountObject.put("Applicable", "True");
            FamilyDiscountObject.put("Description", "Family Discount");
            OtherDiscountGroupArray.put(FamilyDiscountObject);


            JSONObject DirectPolicyObject = new JSONObject();
            DirectPolicyObject.put("DiscountAmount", "0");
            DirectPolicyObject.put("DiscountRate", "0");
            DirectPolicyObject.put("SumInsured", strSumInsured);
            DirectPolicyObject.put("Rate", "0");
            DirectPolicyObject.put("Premium", "0");
            DirectPolicyObject.put("Applicable", "True");
            DirectPolicyObject.put("Description", "Direct Policy Discount");
            OtherDiscountGroupArray.put(DirectPolicyObject);

            JSONObject EmployeeDiscountObject = new JSONObject();
            EmployeeDiscountObject.put("DiscountAmount", "0");
            EmployeeDiscountObject.put("DiscountRate", "0");
            EmployeeDiscountObject.put("SumInsured", strSumInsured);
            EmployeeDiscountObject.put("Rate", "0");
            EmployeeDiscountObject.put("Premium", "0");
            EmployeeDiscountObject.put("Applicable", "True");
            EmployeeDiscountObject.put("Description", "Employee Discount");
            OtherDiscountGroupArray.put(EmployeeDiscountObject);

            JSONObject WomenDiscountObject = new JSONObject();
            WomenDiscountObject.put("DiscountAmount", "0");
            WomenDiscountObject.put("DiscountRate", "0");
            WomenDiscountObject.put("SumInsured", strSumInsured);
            WomenDiscountObject.put("Rate", "0");
            WomenDiscountObject.put("Premium", "0");
            WomenDiscountObject.put("Applicable", "True");
            WomenDiscountObject.put("Description", "Women Discount");
            OtherDiscountGroupArray.put(WomenDiscountObject);

            JSONObject OrganDonorDiscountObject = new JSONObject();
            OrganDonorDiscountObject.put("DiscountAmount", "0");
            OrganDonorDiscountObject.put("DiscountRate", "0");
            OrganDonorDiscountObject.put("SumInsured", strSumInsured);
            OrganDonorDiscountObject.put("Rate", "0");
            OrganDonorDiscountObject.put("Premium", "0");
            OrganDonorDiscountObject.put("Applicable", "True");
            OrganDonorDiscountObject.put("Description", "Organ Donor Discount");
            OtherDiscountGroupArray.put(OrganDonorDiscountObject);



            OtherDiscountsObject.put("OtherDiscountGroup", OtherDiscountGroupArray);
            RisksDataObject.put("OtherDiscounts", OtherDiscountsObject);
            RiskObject.put("RisksData", RisksDataObject);
            RisksObject.put("Risk", RiskObject);
            ProductObject.put("Risks", RisksObject);

            RootObject.put("Product", ProductObject);
            //PaymentDetails
            JSONObject PaymentDetailsObj = new JSONObject();
            JSONObject PaymentEntryObj = new JSONObject();
            PaymentEntryObj.put("PaymentId", "NULL");
            PaymentEntryObj.put("MICRCheque", "NULL");
            PaymentEntryObj.put("InstrumentDate", "NULL");
            PaymentEntryObj.put("DraweeBankName", "NULL");
            PaymentEntryObj.put("HOUSEBANKNAME", "NULL");
            PaymentEntryObj.put("AmountPaid", "NULL");
            PaymentEntryObj.put("PaymentType", "NULL");
            PaymentEntryObj.put("PaymentMode", "NULL");
            PaymentEntryObj.put("InstrumentNo", "NULL");
            PaymentEntryObj.put("Status", "NULL");
            PaymentEntryObj.put("DepositSlipNo", "NULL");
            PaymentEntryObj.put("PayerType", "NULL");
            PaymentDetailsObj.put("PaymentEntry", PaymentEntryObj);
            RootObject.put("PaymentDetails", PaymentDetailsObj);
            //Error
            JSONObject ErrorsObj = new JSONObject();
            ErrorsObj.put("ErrorCode", "0");
            ErrorsObj.put("ErrDescription", "NULL");
            RootObject.put("Errors", ErrorsObj);

            //mainObject
            object.put("Root", RootObject);
            Log.e("objectApi", String.valueOf(object));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(APlusAddOns.this, object, UrlHealthConstants.APLusURL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                try {
                    JSONObject RootJsonObject = object.getJSONObject("Root");
                    JSONObject ErrorsJsonObject = RootJsonObject.getJSONObject("Errors");
                    String ErrDescription = ErrorsJsonObject.getString("ErrDescription");
                    if (ErrDescription.equals("")) {
                        if (Tag == RequestHealthConstants.APLUSHealthAPI) {
                            try {

                                JSONObject CustomerJsonObject = RootJsonObject.getJSONObject("Customer");
                                PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
                                JSONObject ProductJsonObject = RootJsonObject.getJSONObject("Product");
                                JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                                JSONObject RisksJsonObject = ProductJsonObject.getJSONObject("Risks");
                                JSONObject newRisksJsonObject = RisksJsonObject.getJSONObject("Risk");
                                JSONObject RisksDataJsonObject = newRisksJsonObject.getJSONObject("RisksData");
                                JSONObject InsuredDetailsJsonObject = RisksDataJsonObject.getJSONObject("InsuredDetails");
                                JSONObject OtherDiscountsJsonObject = RisksDataJsonObject.getJSONObject("OtherDiscounts");
                                JSONArray InsuredDetailsGroupArray1 = InsuredDetailsJsonObject.getJSONArray("InsuredDetailsGroup");

                                for (int k = 0; k < InsuredDetailsGroupArray1.length(); k++) {
                                    if (str_policyType_spinner.equals("Individual")) {
                                        JSONObject CoverDetailsJsonObject = InsuredDetailsGroupArray1.getJSONObject(0).getJSONObject("CoverDetails");
                                        Log.e("CoverDetailsJsonObject", CoverDetailsJsonObject.toString());
                                        JSONArray CoversArray = CoverDetailsJsonObject.getJSONArray("Covers");
                                        Log.e("CoversArray", String.valueOf(CoversArray));
                                        for (int l = 0; l < CoversArray.length(); l++) {
                                            JSONObject JsonObjectCover = CoversArray.getJSONObject(l);
                                            String CoverName = JsonObjectCover.getString("CoverGroups");
                                            if (CoverName.equalsIgnoreCase("Basic Insurance Cover")) {
                                                BasicInsuranceCoverPremiumAd1= Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                            }  else if (CoverName.equalsIgnoreCase("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                MaternityChildcareCoverPremiumAd1= Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                            } else if (CoverName.equalsIgnoreCase("Coverage for Non-Medical Items")) {
                                                CoverageNonMedicalCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                            } else if (CoverName.equalsIgnoreCase("Pre-Existing Disease waiting period")) {
                                                PreExistingDiseaseCoverPremiumAd1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                            }
                                            PreExistingDiseaseCoverPremium= String.valueOf(PreExistingDiseaseCoverPremiumAd1);
                                            CoverageNonMedicalCoverPremium= String.valueOf(CoverageNonMedicalCoverPremiumAd1);
                                            MaternityChildcareCoverPremium= String.valueOf(MaternityChildcareCoverPremiumAd1);
                                            PreexistingDiseasePremiumTxt.setText(PreExistingDiseaseCoverPremium);
                                            NoMedicalPremiumTxt.setText(CoverageNonMedicalCoverPremium);
                                            MaternityChildcarePremiumTxt.setText(MaternityChildcareCoverPremium);

                                        }
                                    }

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        Toast.makeText(getApplication(), "" + ErrDescription, Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(VolleyError error, int Tag) {

            }
        },
                RequestHealthConstants.APLUSHealthAPI);
        req.execute();
    }


    private void TotalPremiumAPI() {
//        if (str_policyType_spinner.equals("Individual")) {
//            if (strCheckBoxSpouse.equals("Checked")) {
//                if (strGenderSpinner.equals("Female")) {
//                    strGender = "M";
//                }else{
//                    strGender = "F";
//                }
//              //  strSelfAgeEditText = strSpouseAgeEditText;
//            }else{
//                if (strGenderSpinner.equals("Female")) {
//                    strGender = "F";
//                }else{
//                    strGender = "M";
//                }
//            }
//        }


        JSONObject object = new JSONObject();
        try {
            JSONObject RootObject = new JSONObject();
            //Authentication
            JSONObject AuthenticationObject = new JSONObject();
            AuthenticationObject.put("WACode", "20000001");
            AuthenticationObject.put("WAAppCode", "30000011");
            AuthenticationObject.put("WAUserID", "USER01");
            AuthenticationObject.put("WAUserPwd", "pass@123");
            AuthenticationObject.put("WAType", "0");
            RootObject.put("Authentication", AuthenticationObject);
            //Customer
            JSONObject CustomerObject = new JSONObject();
            CustomerObject.put("CustomerType", str_policyType_spinner);
            CustomerObject.put("CustomerName", "");
            CustomerObject.put("DOB", "");
            CustomerObject.put("Gender", "F");
            CustomerObject.put("CanBeParent", "0");
            CustomerObject.put("ContactTelephoneSTD", "");
            CustomerObject.put("MobileNo", strEdtPhone);
            CustomerObject.put("Emailid", strEdtEmail);
            CustomerObject.put("PresentAddressLine1", "");
            CustomerObject.put("PresentAddressLine2", "");
            CustomerObject.put("PresentStateCode", strState);
            CustomerObject.put("PresentCityDistCode", strCity);
            CustomerObject.put("PresentPinCode", strPincode);
            CustomerObject.put("PermanentAddressLine1", "");
            CustomerObject.put("PermanentAddressLine2", "");
            CustomerObject.put("PermanentStateCode", "");
            CustomerObject.put("PermanentCityDistCode", "");
            CustomerObject.put("PermanentPinCode", strPermanentPinCode);
            CustomerObject.put("CustGSTNo", "NULL");
            CustomerObject.put("ProductName", "A PLUS HEALTH INSURANCE");
            CustomerObject.put("InstrumentNo", "NULL");
            CustomerObject.put("InstrumentDate", "NULL");
            CustomerObject.put("BankID", "NULL");
            CustomerObject.put("PosPolicyNo", "");
            CustomerObject.put("ProductCode", "2858");
            CustomerObject.put("WAURN", "NULL");
            CustomerObject.put("NomineeName", "");
            CustomerObject.put("NomineeRelation", "");
            CustomerObject.put("PANNo", "NULL");
            CustomerObject.put("AadhaarNo", "");
            CustomerObject.put("EIA", "NULL");
            CustomerObject.put("CKYCNo", "");
            CustomerObject.put("Ref_No_Unique_KYC", "");
            RootObject.put("Customer", CustomerObject);
            //POSAGENT
            JSONObject POSAGENTObject = new JSONObject();
            POSAGENTObject.put("Name", "");
            POSAGENTObject.put("PAN", "");
            POSAGENTObject.put("Aadhar", "");
            POSAGENTObject.put("Email", "");
            POSAGENTObject.put("MobileNo", "");
            POSAGENTObject.put("Location", "");
//            POSAGENTObject.put("Location", "MUMBAI CORPORATE OFFICE");
            POSAGENTObject.put("Information1", "NULL");
            POSAGENTObject.put("Information2", "NULL");
            RootObject.put("POSAGENT", POSAGENTObject);

            JSONObject ProductObject = new JSONObject();
            JSONObject GeneralProposalObject = new JSONObject();
            JSONObject GeneralProposalGroupObject = new JSONObject();
            JSONObject DistributionChannelObject = new JSONObject();
            //Branch
            JSONObject BranchDetailsObject = new JSONObject();

            BranchDetailsObject.put("IMDBranchName", "NULL");
            BranchDetailsObject.put("IMDBranchCode", "NULL");
            DistributionChannelObject.put("BranchDetails", BranchDetailsObject);
            //SpDetails
            JSONObject SPDetailsObject = new JSONObject();
            SPDetailsObject.put("SPName", "NULL");
            SPDetailsObject.put("SPCode", "NULL");
            DistributionChannelObject.put("SPDetails", SPDetailsObject);
            GeneralProposalGroupObject.put("DistributionChannel", DistributionChannelObject);

            //GeneralProposalInformation
            JSONObject GeneralProposalInformationObject = new JSONObject();
            GeneralProposalInformationObject.put("TypeOfBusiness", "FROM INTERMEDIARY");
            GeneralProposalInformationObject.put("ServiceTaxExemptionCategory", "No Exemption");
            GeneralProposalInformationObject.put("BusinessType", "New");
            GeneralProposalInformationObject.put("Sector", "Others");
            GeneralProposalInformationObject.put("DealId", "INTR-2312-0019722");
            GeneralProposalInformationObject.put("PolicyType", str_policyType_spinner);
            GeneralProposalInformationObject.put("FamilyComposition", "");
            GeneralProposalInformationObject.put("ParentComposition", "");
            GeneralProposalInformationObject.put("PlanType", plantypes);
            GeneralProposalInformationObject.put("ProposalDate", today);
            GeneralProposalInformationObject.put("PolicyDuration", strPolicyTenure);
            GeneralProposalInformationObject.put("PolicyNumberChar", "NULL");
            //PolicyEffectiveDate
            JSONObject PolicyEffectiveDateObject = new JSONObject();
            PolicyEffectiveDateObject.put("Fromdate", today);
            PolicyEffectiveDateObject.put("Todate", nextYear);
            PolicyEffectiveDateObject.put("Fromhour", "00:01");
            PolicyEffectiveDateObject.put("Tohour", "23:59");
            GeneralProposalInformationObject.put("PolicyEffectiveDate", PolicyEffectiveDateObject);

            GeneralProposalInformationObject.put("EmployeeCode", "");
            GeneralProposalInformationObject.put("InstallmentFrequency", "");
            GeneralProposalInformationObject.put("RequestType", "Quotation");
            GeneralProposalGroupObject.put("GeneralProposalInformation", GeneralProposalInformationObject);
            GeneralProposalObject.put("GeneralProposalGroup", GeneralProposalGroupObject);

            //FinancierDetails
            JSONObject FinancierDetailsObject = new JSONObject();
            JSONObject FinancierDtlGrpObject = new JSONObject();
            JSONObject FinancierDtlGrpDataObject = new JSONObject();
            FinancierDtlGrpDataObject.put("FinancierCode", "NULL");
            FinancierDtlGrpDataObject.put("AgreementType", "NULL");
            FinancierDtlGrpDataObject.put("BranchName", "NULL");
            FinancierDtlGrpDataObject.put("FinancierName", "NULL");
            FinancierDtlGrpDataObject.put("SrNo", "NULL");
            FinancierDtlGrpObject.put("FinancierDtlGrpData", FinancierDtlGrpDataObject);
            FinancierDetailsObject.put("FinancierDtlGrp", FinancierDtlGrpObject);
            GeneralProposalObject.put("FinancierDetails", FinancierDetailsObject);

            //PreviousPolicyDetails
            JSONObject PreviousPolicyDetailsObject = new JSONObject();
            JSONObject PreviousPolDtlGroupObject = new JSONObject();
            JSONObject PreviousPolDtlGroupDataObject = new JSONObject();
            PreviousPolDtlGroupDataObject.put("ProductCode", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimSettled", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimPremium", "0");
            PreviousPolDtlGroupDataObject.put("ClaimAmount", "0");
            PreviousPolDtlGroupDataObject.put("DateofLoss", "NULL");
            PreviousPolDtlGroupDataObject.put("NatureofLoss", "NULL");
            PreviousPolDtlGroupDataObject.put("ClaimNo", "99999999");
            PreviousPolDtlGroupDataObject.put("PolicyEffectiveTo", "999999");
            PreviousPolDtlGroupDataObject.put("PolicyEffectiveFrom", "99");
            PreviousPolDtlGroupDataObject.put("PolicyPremium", "0");
            PreviousPolDtlGroupDataObject.put("PolicyNo", "NULL");
            PreviousPolDtlGroupDataObject.put("PolicyYear", "NULL");
            PreviousPolDtlGroupDataObject.put("OfficeCode", "NULL");
            PreviousPolDtlGroupDataObject.put("CorporateCustomerId", "NULL");
            PreviousPolDtlGroupDataObject.put("InsurerName", "NULL");
            PreviousPolDtlGroupDataObject.put("InsurerAddress", "NULL");
            PreviousPolDtlGroupObject.put("PreviousPolDtlGroupData", PreviousPolDtlGroupDataObject);
            PreviousPolicyDetailsObject.put("PreviousPolDtlGroup", PreviousPolDtlGroupObject);
            PreviousPolicyDetailsObject.put("PreviousPolicyType", "Package Policy");
            PreviousPolicyDetailsObject.put("OfficeAddress", "NULL");
            GeneralProposalObject.put("PreviousPolicyDetails", PreviousPolicyDetailsObject);
            ProductObject.put("GeneralProposal", GeneralProposalObject);

            //PremiumCalculation
            JSONObject PremiumCalculationObject = new JSONObject();
            PremiumCalculationObject.put("NetPremium", "0");
            PremiumCalculationObject.put("ServiceTax", "0");
            PremiumCalculationObject.put("StampDuty2", "0");
            PremiumCalculationObject.put("TotalPremium", "0");
            PremiumCalculationObject.put("CGST", "0");
            PremiumCalculationObject.put("SGST", "0");
            PremiumCalculationObject.put("UGST", "0");
            PremiumCalculationObject.put("IGST", "0");
            PremiumCalculationObject.put("TotalBasePremium", "0");
            PremiumCalculationObject.put("TotalAddonPremium", "0");
            PremiumCalculationObject.put("TotalDiscountPremium", "0");

            ProductObject.put("PremiumCalculation", PremiumCalculationObject);

            //Risks
            JSONObject RisksObject = new JSONObject();
            JSONObject RiskObject = new JSONObject();
            JSONObject RisksDataObject = new JSONObject();
            JSONObject InsuredDetailsObject = new JSONObject();
            JSONArray InsuredDetailsGroupArray = new JSONArray();

            JSONObject InsuredDetailsObj = new JSONObject();
            InsuredDetailsObj.put("InsuredType", "Adult");
            InsuredDetailsObj.put("FirstName", "");
            InsuredDetailsObj.put("LastName", "");
            InsuredDetailsObj.put("DOB", strAge);
            InsuredDetailsObj.put("Gender", "F");
            InsuredDetailsObj.put("Relationship", "Self");
            InsuredDetailsObj.put("Occupation", "");
            InsuredDetailsObj.put("NomineeName", "");
            InsuredDetailsObj.put("NomineeRelationship", "");
            InsuredDetailsObj.put("NomineeDOB", "");
            InsuredDetailsObj.put("NomineeAge", "");
            InsuredDetailsObj.put("NomineeGender", "");
            InsuredDetailsObj.put("AppointeeName", "");
            InsuredDetailsObj.put("AppointeeDOB", "");
            InsuredDetailsObj.put("AppointeeAge", "");
            InsuredDetailsObj.put("AppointeeGender", "");
            InsuredDetailsObj.put("AppointeeRelation", "");

            JSONObject HealthIndicatorsObj = new JSONObject();
            HealthIndicatorsObj.put("PED", "");
            HealthIndicatorsObj.put("PEDDeclared", "");
            HealthIndicatorsObj.put("BodyMassIndex", "17");
            HealthIndicatorsObj.put("IllnessOrDisease", "");
            HealthIndicatorsObj.put("TreatementOrMedicine", "");
            HealthIndicatorsObj.put("VisitedDoctor", "");
            HealthIndicatorsObj.put("Hospitalized", "");
            HealthIndicatorsObj.put("TakenAnyTreatement", "");
            HealthIndicatorsObj.put("Alcohol", "");
            HealthIndicatorsObj.put("AlcoholType", "");
            HealthIndicatorsObj.put("AlcoholQuantity", "");
            HealthIndicatorsObj.put("AlcoholDuration", "");
            HealthIndicatorsObj.put("Smoker", "Y");
            HealthIndicatorsObj.put("SmokerType", "Cigrate");
            HealthIndicatorsObj.put("SmokerQuantity", "0");
            HealthIndicatorsObj.put("SmokerDuration", "5");
            HealthIndicatorsObj.put("Tobacco", "Y");
            HealthIndicatorsObj.put("TobaccoType", "Gutkha");
            HealthIndicatorsObj.put("TobaccoQuantity", "0");
            HealthIndicatorsObj.put("TobaccoDuration", "0");
            HealthIndicatorsObj.put("Narcotics", "");
            InsuredDetailsObj.put("HealthIndicators", HealthIndicatorsObj);

            JSONObject CoverDetailsObj = new JSONObject();
            JSONArray CoversArray = new JSONArray();
            JSONObject BasicInsuranceCoversObj = new JSONObject();
            BasicInsuranceCoversObj.put("Applicable", "True");
            BasicInsuranceCoversObj.put("CoverSI", strSumInsured);
            BasicInsuranceCoversObj.put("CoverRate", "0");
            BasicInsuranceCoversObj.put("CoverPremium", "0");
            BasicInsuranceCoversObj.put("CoverGroups", "Basic Insurance Cover");
            CoversArray.put(BasicInsuranceCoversObj);


            JSONObject MaternityAndChildcareCoversObj = new JSONObject();
            MaternityAndChildcareCoversObj.put("Applicable", MaternityAndChildcareMale);
            MaternityAndChildcareCoversObj.put("CoverSI", strSumInsured);
            MaternityAndChildcareCoversObj.put("CoverRate", "0");
            MaternityAndChildcareCoversObj.put("CoverPremium", "0");
            MaternityAndChildcareCoversObj.put("CoverGroups", "MATERNITY AND CHILDCARE BENEFIT WAITING PERIOD MODIFICATION");
            CoversArray.put(MaternityAndChildcareCoversObj);

            JSONObject CoverageForNonMedicalCoversObj = new JSONObject();
            CoverageForNonMedicalCoversObj.put("Applicable", strNonMedical);
            CoverageForNonMedicalCoversObj.put("CoverSI", strSumInsured);
            CoverageForNonMedicalCoversObj.put("CoverRate", "0");
            CoverageForNonMedicalCoversObj.put("CoverPremium", "0");
            CoverageForNonMedicalCoversObj.put("CoverGroups", "COVERAGE FOR NON-MEDICAL ITEMS");
            CoversArray.put(CoverageForNonMedicalCoversObj);

            JSONObject PreExistingDiseaseCoversObj = new JSONObject();
            PreExistingDiseaseCoversObj.put("Applicable", strPreDieses);
            PreExistingDiseaseCoversObj.put("CoverSI", strSumInsured);
            PreExistingDiseaseCoversObj.put("CoverRate", "0");
            PreExistingDiseaseCoversObj.put("CoverPremium", "0");
            PreExistingDiseaseCoversObj.put("CoverGroups", "PRE-EXISTING DISEASE WAITING PERIOD");
            CoversArray.put(PreExistingDiseaseCoversObj);

            CoverDetailsObj.put("Covers", CoversArray);
            InsuredDetailsObj.put("CoverDetails", CoverDetailsObj);
            InsuredDetailsGroupArray.put(InsuredDetailsObj);
             //2nd Adult


        //
            InsuredDetailsObject.put("InsuredDetailsGroup", InsuredDetailsGroupArray);
            RisksDataObject.put("InsuredDetails", InsuredDetailsObject);
            //otherLoading
            JSONObject OtherLoadingsObject = new JSONObject();
            JSONObject OtherLoadingGroupObject = new JSONObject();
            JSONObject OtherLoadingGroupDataObject = new JSONObject();
            OtherLoadingGroupDataObject.put("LoadingAmount", "0");
            OtherLoadingGroupDataObject.put("LoadingRate", "0");
            OtherLoadingGroupDataObject.put("SumInsured", "0");
            OtherLoadingGroupDataObject.put("Rate", "0");
            OtherLoadingGroupDataObject.put("Premium", "0");
            OtherLoadingGroupDataObject.put("Applicable", "False");
            OtherLoadingGroupDataObject.put("Description", "NULL");
            OtherLoadingGroupObject.put("OtherLoadingGroupData", OtherLoadingGroupDataObject);
            OtherLoadingsObject.put("OtherLoadingGroup", OtherLoadingGroupObject);

            RisksDataObject.put("OtherLoadings", OtherLoadingsObject);
            //OtherDiscounts
            JSONObject OtherDiscountsObject = new JSONObject();
            JSONArray OtherDiscountGroupArray = new JSONArray();

            JSONObject LongObject = new JSONObject();
            LongObject.put("DiscountAmount", "0");
            LongObject.put("DiscountRate", "0");
            LongObject.put("SumInsured", strSumInsured);
            LongObject.put("Rate", "0");
            LongObject.put("Premium", "0");
            LongObject.put("Applicable", strLongTurmDiscount);
            LongObject.put("Description", "Long term discount");
            OtherDiscountGroupArray.put(LongObject);

            JSONObject FamilyDiscountObject = new JSONObject();
            FamilyDiscountObject.put("DiscountAmount", "0");
            FamilyDiscountObject.put("DiscountRate", "0");
            FamilyDiscountObject.put("SumInsured", strSumInsured);
            FamilyDiscountObject.put("Rate", "0");
            FamilyDiscountObject.put("Premium", "0");
            FamilyDiscountObject.put("Applicable", "True");
            FamilyDiscountObject.put("Description", "Family Discount");
            OtherDiscountGroupArray.put(FamilyDiscountObject);


            JSONObject DirectPolicyObject = new JSONObject();
            DirectPolicyObject.put("DiscountAmount", "0");
            DirectPolicyObject.put("DiscountRate", "0");
            DirectPolicyObject.put("SumInsured", strSumInsured);
            DirectPolicyObject.put("Rate", "0");
            DirectPolicyObject.put("Premium", "0");
            DirectPolicyObject.put("Applicable", strDirectPolicyDiscount);
            DirectPolicyObject.put("Description", "Direct Policy Discount");
            OtherDiscountGroupArray.put(DirectPolicyObject);

            JSONObject EmployeeDiscountObject = new JSONObject();
            EmployeeDiscountObject.put("DiscountAmount", "0");
            EmployeeDiscountObject.put("DiscountRate", "0");
            EmployeeDiscountObject.put("SumInsured", strSumInsured);
            EmployeeDiscountObject.put("Rate", "0");
            EmployeeDiscountObject.put("Premium", "0");
            EmployeeDiscountObject.put("Applicable", strEmployeDiscount);
            EmployeeDiscountObject.put("Description", "Employee Discount");
            OtherDiscountGroupArray.put(EmployeeDiscountObject);

            JSONObject WomenDiscountObject = new JSONObject();
            WomenDiscountObject.put("DiscountAmount", "0");
            WomenDiscountObject.put("DiscountRate", "0");
            WomenDiscountObject.put("SumInsured", strSumInsured);
            WomenDiscountObject.put("Rate", "0");
            WomenDiscountObject.put("Premium", "0");
            WomenDiscountObject.put("Applicable", strWomenDiscount);
            WomenDiscountObject.put("Description", "Women Discount");
            OtherDiscountGroupArray.put(WomenDiscountObject);

            JSONObject OrganDonorDiscountObject = new JSONObject();
            OrganDonorDiscountObject.put("DiscountAmount", "0");
            OrganDonorDiscountObject.put("DiscountRate", "0");
            OrganDonorDiscountObject.put("SumInsured", strSumInsured);
            OrganDonorDiscountObject.put("Rate", "0");
            OrganDonorDiscountObject.put("Premium", "0");
            OrganDonorDiscountObject.put("Applicable", strOrganDiscount);
            OrganDonorDiscountObject.put("Description", "Organ Donor Discount");
            OtherDiscountGroupArray.put(OrganDonorDiscountObject);

            OtherDiscountsObject.put("OtherDiscountGroup", OtherDiscountGroupArray);
            RisksDataObject.put("OtherDiscounts", OtherDiscountsObject);
            RiskObject.put("RisksData", RisksDataObject);
            RisksObject.put("Risk", RiskObject);
            ProductObject.put("Risks", RisksObject);

            RootObject.put("Product", ProductObject);
            //PaymentDetails
            JSONObject PaymentDetailsObj = new JSONObject();
            JSONObject PaymentEntryObj = new JSONObject();
            PaymentEntryObj.put("PaymentId", "NULL");
            PaymentEntryObj.put("MICRCheque", "NULL");
            PaymentEntryObj.put("InstrumentDate", "NULL");
            PaymentEntryObj.put("DraweeBankName", "NULL");
            PaymentEntryObj.put("HOUSEBANKNAME", "NULL");
            PaymentEntryObj.put("AmountPaid", "NULL");
            PaymentEntryObj.put("PaymentType", "NULL");
            PaymentEntryObj.put("PaymentMode", "NULL");
            PaymentEntryObj.put("InstrumentNo", "NULL");
            PaymentEntryObj.put("Status", "NULL");
            PaymentEntryObj.put("DepositSlipNo", "NULL");
            PaymentEntryObj.put("PayerType", "NULL");
            PaymentDetailsObj.put("PaymentEntry", PaymentEntryObj);
            RootObject.put("PaymentDetails", PaymentDetailsObj);
            //Error
            JSONObject ErrorsObj = new JSONObject();
            ErrorsObj.put("ErrorCode", "0");
            ErrorsObj.put("ErrDescription", "NULL");
            RootObject.put("Errors", ErrorsObj);

            //mainObject
            object.put("Root", RootObject);
            Log.e("objectApi", String.valueOf(object));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(APlusAddOns.this, object, UrlHealthConstants.APLusURL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                try {
                    JSONObject RootJsonObject = object.getJSONObject("Root");
                    Log.d("dffdmffd", "onSuccess: "+new Gson().toJson(RootJsonObject));
                    JSONObject ErrorsJsonObject = RootJsonObject.getJSONObject("Errors");
                    String ErrDescription = ErrorsJsonObject.getString("ErrDescription");
                    if (ErrDescription.equals("")) {
                        if (Tag == RequestHealthConstants.APLUSHealthAPI) {
                            try {
//                                customprogress.hideProgressBar();
                                JSONObject CustomerJsonObject = RootJsonObject.getJSONObject("Customer");
                                PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
                                JSONObject ProductJsonObject = RootJsonObject.getJSONObject("Product");
                                JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
                                JSONObject RisksJsonObject = ProductJsonObject.getJSONObject("Risks");
                                JSONObject newRisksJsonObject = RisksJsonObject.getJSONObject("Risk");
                                JSONObject RisksDataJsonObject = newRisksJsonObject.getJSONObject("RisksData");
                                JSONObject InsuredDetailsJsonObject = RisksDataJsonObject.getJSONObject("InsuredDetails");
                                JSONObject OtherDiscountsJsonObject = RisksDataJsonObject.getJSONObject("OtherDiscounts");
                                JSONArray InsuredDetailsGroupArray1 = InsuredDetailsJsonObject.getJSONArray("InsuredDetailsGroup");
                                String strTotalPremium1 = PremiumCalculationJsonObject.getString("TotalPremium");
                                String strBasePremium = PremiumCalculationJsonObject.getString("TotalBasePremium");
                                NetPremium = PremiumCalculationJsonObject.getString("NetPremium");
                                String CGST = PremiumCalculationJsonObject.getString("CGST");
                                String SGST = PremiumCalculationJsonObject.getString("SGST");
                                String UGST = PremiumCalculationJsonObject.getString("UGST");
                                String IGST = PremiumCalculationJsonObject.getString("IGST");

                                GSt = String.valueOf(Double.parseDouble(CGST) + Double.parseDouble(SGST) + Double.parseDouble(UGST) + Double.parseDouble(IGST));
                                JSONArray OtherDiscountsJsonArray = OtherDiscountsJsonObject.getJSONArray("OtherDiscountGroup");
                                for (int j = 0; j < OtherDiscountsJsonArray.length(); j++) {
                                    JSONObject OtherDiscountsObject = OtherDiscountsJsonArray.getJSONObject(j);
                                    String DescriptionName = OtherDiscountsObject.getString("Description");
                                    if (DescriptionName.equals("Direct Policy Discount")) {
                                        DirectPolicyDiscountPremium = OtherDiscountsObject.getString("Premium");
                                    }else if (DescriptionName.equals("Long term discount")) {
                                        LongTermDiscountDiscountPremium = Double.parseDouble(OtherDiscountsObject.getString("Premium"));
                                    }else if (DescriptionName.equals("Organ Donor Discount")) {
                                        OrganDonorDiscountPremium = Double.parseDouble(OtherDiscountsObject.getString("Premium"));
                                    }else if (DescriptionName.equals("Women Discount")) {
                                        WomenDiscountPremium = Double.parseDouble(OtherDiscountsObject.getString("Premium"));
                                    }else if (DescriptionName.equals("Family Discount")) {
                                        FamilyDiscountPremium = Double.parseDouble(OtherDiscountsObject.getString("Premium"));
                                    }else if (DescriptionName.equals("Employee Discount")) {
                                        EmployeeDiscountPremium = Double.parseDouble(OtherDiscountsObject.getString("Premium"));
                                    }
                                    Discounts = LongTermDiscountDiscountPremium +WomenDiscountPremium + OrganDonorDiscountPremium + FamilyDiscountPremium+EmployeeDiscountPremium;
                                    strfamilyDiscount = String.valueOf(FamilyDiscountPremium);
                                    text_familyDiscount_amount.setText(strfamilyDiscount);

                                }
                                for (int k = 0; k < InsuredDetailsGroupArray1.length(); k++) {
                                    if (str_policyType_spinner.equals("Individual")) {
                                        JSONObject CoverDetailsJsonObject = InsuredDetailsGroupArray1.getJSONObject(0).getJSONObject("CoverDetails");
                                        Log.e("CoverDetailsJsonObject", CoverDetailsJsonObject.toString());
                                        JSONArray CoversArray = CoverDetailsJsonObject.getJSONArray("Covers");
                                        Log.e("CoversArray", String.valueOf(CoversArray));
                                        for (int l = 0; l < CoversArray.length(); l++) {
                                            JSONObject JsonObjectCover = CoversArray.getJSONObject(l);
                                            String CoverName = JsonObjectCover.getString("CoverGroups");
                                            if (CoverName.equalsIgnoreCase("Basic Insurance Cover")) {
                                                BasicInsuranceCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                            }  else if (CoverName.equalsIgnoreCase("Maternity and Childcare Benefit Waiting Period Modification")) {
                                                MaternityChildcareCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                            } else if (CoverName.equalsIgnoreCase("Coverage for Non-Medical Items")) {
                                                CoverageNonMedicalCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                            } else if (CoverName.equalsIgnoreCase("Pre-Existing Disease waiting period")) {
                                                PreExistingDiseaseCoverPremium1 = Double.parseDouble(JsonObjectCover.getString("CoverPremium"));
                                            }
                                            strBasicPremium = String.valueOf(BasicInsuranceCoverPremium1);
                                            double addonsNew;
                                            addonsNew = MaternityChildcareCoverPremium1 + CoverageNonMedicalCoverPremium1+ PreExistingDiseaseCoverPremium1;
                                            addons = (int) addonsNew;
                                            Log.e("addons", String.valueOf(addons));
                                        }
                                    }

                                }
                                double doubleTotalPremium1 = Double.parseDouble(strTotalPremium1);
                                double mathMainPremiumTotal = Math.round(doubleTotalPremium1 * 100.0) / 100.0;
                                strTotalPremium = String.valueOf(mathMainPremiumTotal);
                                TotalPremium.setText(strTotalPremium);
                                if (plantypes.equals("Silver")){
                                    basicPremium_DiamondCard.setText("");
                                    basicPremium_GoldCard.setText("");
                                    basicPremium_SilverCard.setText(strBasePremium);
                                }else if (plantypes.equals("Gold")){
                                    basicPremium_SilverCard.setText("");
                                    basicPremium_DiamondCard.setText("");
                                    basicPremium_GoldCard.setText(strBasePremium);
                                }else{
                                    basicPremium_SilverCard.setText("");
                                    basicPremium_GoldCard.setText("");
                                    basicPremium_DiamondCard.setText(strBasePremium);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        Toast.makeText(getApplication(), "" + ErrDescription, Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(VolleyError error, int Tag) {

            }
        },
                RequestHealthConstants.APLUSHealthAPI);
        req.execute();
    }


}