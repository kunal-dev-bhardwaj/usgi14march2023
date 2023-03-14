package com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
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
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculation;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationAdult;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationOne;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationThree;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationTwo;
import static com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.BmiCalculation.calculationfour;

public class Complete_health_member_info extends AppCompatActivity {
    Button btn_continue;
    String BI_Status,BI_Status1,BI_Status2,BI_Status3,BI_Status4,BI_Status5,strFourString,strFirstString,new_str_age,strselfProposerRelation,strSumInsuredTpeEDit,ESaleDiscount,LongTermDiscount,PD_Status,str_selfProposerGender,str_selfProposerOccupation,strBMIFourChildEdit,strBMIEChildThreeEdit,strBMIChildTwoEdit,strBMIChildEdit,strBMIAdultOneEdit,strBMIEdit,strPriceTotal,strNominee_dob,str_family_individual,str_selfProposerDob,str_edit_dob3String1,str_proposer_self_spinner,TotalValue,NetPremiumValue,GST,PosPolicyNo,str_policyType_spinner,str_IndividualTypeEdit,str_SumInsured,str_policyTenure,strFirstTString,str_edt_name="",str_edt_phone="",str_email="",str_age="",str_reference_no="",str_gender="",str_occupation="",str_ft="",str_inches="",str_weight_edit="",str_edt_Spouse_name="",str_spouse_edit_dob="",str_spouse_gender="",str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob,str_edit_dob3String,str_spouse_edit_dob_dob,str_OneEditName,str_edit_dob3StringSpouse,strOneChild,strChildOne,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,strtwoDob,strChildTwo,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,
            strthreeDob,strChildThree,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,strfourDob,strChildFour,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner;
    EditText selfProposerRelation,selfProposerGender,selfProposerOccupation,spouse_occupation_spinner,spouse_ft_spinner,spouse_inches_spinner,oneGenderSpinner,BMIAdultOneEdit,BMIChildEdit,BMIChildTwoEdit,familyTypeEdit,sumInsuredEdit,policyTenureEdit,QuotationID,selfProposerDob,proposer_edt_name,IndividualTypeEdit,policyType_spinner,familyType_spinner,edt_name,edit_dob,weight_edit,edt_Spouse_name,spouse_edit_dob,spouse_weight_edit,totalPremiumAmount;
    private SimpleDateFormat dateFormatter;
    LinearLayout adultLiner,spouseLiner,oneChildLiner,twoChildLiner,threeChildLiner,fourChildLiner,proposer_liner,gender_liner,linerOccupation,ftLiner,LinerInches,spouseGender,spouseOccupation,spouseFt,spouseInches,spouseRelationLiner,ChildOneGender,ChildOneLinerRelation,LinerFtChildOne,LinerInchesChildOne,childTwoGenderLiner,LinerChildTwoFt,LinerChildTwoInches,ChildTwoRelationLiner,thirdLinerGender,LinerFtThird,thirdInchesLiner,RelationThirdLiner,LinerGenderFour,LinerFtFour,LinerInchesFour,LinerRelationFour;
    Spinner proposer_spinner,proposer_self_spinner,SelfProposerMarital,policyTenure_spinner,gender_spinner,occupation_spinner,ft_spinner,inches_spinner;
    String[] familyFloater,familyChildFloater,Salutation,policyTenure, gender,Marital;
    String[] occupation,yesNo,relation_with_insure;
    String[] ft;
    String[] inches;
    ImageView sumInsuredDropDown;
    final double change = 2.2046226218;
    double kg = 0.0;
    double BMI=0.0;
    double cm=0.0;
    String str_amountPersonalSumInsured,strcriticalEdit,strhospitalEdit,strOneChildCriticalIllnessTxt,stroneChildTxt;
    String str_new_dob,today,tomorrowDate,nextYear,strThirdDString ;
    Date date,CurrentDate,SelectDate;
    TextView show_Breakup;
    double  amountPersonalSumInsured,personalSumInsured;
    Format formatter;
    private MySharedPreference pref;
    CustomProgressDialog customprogress;
    double Individual_BMI=0.0,twoAdult_BMI=0.0,OneChildBMI,TwoChildBMI,ThreeChildBMI,FourChildBMI;
   EditText spouse_gender_spinner,edit_ft,edit_inches,edit_occupation,edit_gender,oneFtSpinner,oneInchesSpinner,twoGenderSpinner,twoFtSpinner,twoInchesSpinner,thirdGenderSpinner,thirdFtSpinner,thirdInchesSpinner,fourGenderSpinner,fourFtSpinner,fourInchesSpinner,BMIEdit,BMIEChildThreeEdit,BMIFourChildEdit,RelationEdit,RelationAdultOneEdit,RelationChildEdit,RelationChildTwoEdit,RelationChildThreeEdit,RelationFourChildEdit,policyTenure_edit,SumInsured_spinner,OneEditName,OneDob,oneOccupationSpinner,oneWeightEdit,twoChildEditName,twoOccupationSpinner,twoDob,twoWeightEdit,thirdNameEdit,thirdDob,thirdOccupationSpinner,thirdWeightEdit,fourNameEdit,fourDob,fourOccupationSpinner,FourWeightEdit;
   Spinner selfProposerSpinner;
    String str_for,str_RelationEdit,str_twoChildEditName,str_thirdNameEdit,str_fourNameEdit,str_oneWeightEdit,str_thirdWeightEdit,strFourWeightEdit,strRelationAdultOneEdit,strRelationChildEdit,strRelationChildTwoEdit,strRelationChildThreeEdit,strRelationFourChildEdit;
    public Period period;
    int selectYearAdult,selectYearSecondAdult,SelectMonth,SelectDays,selectYearChild,selectYearChildTwo,selectYearChildThird,selectYearChildFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_health_member_info);
      getWindow().setStatusBarColor(ContextCompat.getColor(Complete_health_member_info.this, R.color.colorPrimaryDark));
      pref = MySharedPreference.getInstance(Complete_health_member_info.this);
        customprogress = new CustomProgressDialog(Complete_health_member_info.this);
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
        LongTermDiscount = getIntent().getStringExtra("LongTermDiscount");
        ESaleDiscount = getIntent().getStringExtra("ESaleDiscount");
        PD_Status = getIntent().getStringExtra("PD_Status");
        nextYear = getIntent().getStringExtra("nextYear");
        tomorrowDate = getIntent().getStringExtra("tomorrowDate");
        strSumInsuredTpeEDit = getIntent().getStringExtra("strSumInsuredTpeEDit");
        new_str_age = getIntent().getStringExtra("new_str_age");
        str_for = getIntent().getStringExtra("for");
        BI_Status = getIntent().getStringExtra("BI_Status");
        BI_Status1 = getIntent().getStringExtra("BI_Status1");
        BI_Status2 = getIntent().getStringExtra("BI_Status2");
        BI_Status3 = getIntent().getStringExtra("BI_Status3");
        BI_Status4 = getIntent().getStringExtra("BI_Status4");
        BI_Status5 = getIntent().getStringExtra("BI_Status5");

        if (str_for.equals("1")){
            selectYearAdult = getIntent().getIntExtra("selectYearAdult", 0);
            selectYearSecondAdult = getIntent().getIntExtra("selectYearSecondAdult", 0);
            selectYearChild = getIntent().getIntExtra("selectYearChild", 0);
            selectYearChildTwo = getIntent().getIntExtra("selectYearChildTwo", 0);
            selectYearChildThird = getIntent().getIntExtra("selectYearChildThird", 0);
            selectYearChildFour = getIntent().getIntExtra("selectYearChildFour", 0);
        }


        init();
        String[] strParts =  str_age.split("yrs");
         strFirstString = strParts[0];

        String[] strParts1 = str_age.split("-");
        String strFirstString1 = strParts1[0]; // 004
        String strSecondString1 = strParts1[1];

        String[] strParts2 =  strSecondString1.split("yrs");
        strFourString = strParts2[0];

//        Toast.makeText(Complete_health_member_info.this, strFirstString, Toast.LENGTH_SHORT).show();
//        Toast.makeText(Complete_health_member_info.this, strFourString, Toast.LENGTH_SHORT).show();


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

        if(str_IndividualTypeEdit.equals("1 Adult")){
            BI_Status="True";
            BI_Status1="False";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status4="False";
            BI_Status5="False";
        }else if(str_IndividualTypeEdit.equals("2 Adult")){
            BI_Status="True";
            BI_Status1="True";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status4="False";
            BI_Status5="False";
        } else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
            BI_Status="True";
            BI_Status1="False";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status4="False";
            BI_Status5="False";
        }
        else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
            BI_Status="True";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status1="False";
            BI_Status4="False";
            BI_Status5="False";
        }
        else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
            BI_Status="True";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status1="False";
            BI_Status4="False";
            BI_Status5="False";
        }
        else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
            BI_Status="True";
            BI_Status1="True";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status4="False";
            BI_Status5="False";
        }
        else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
            BI_Status="True";
            BI_Status1="True";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status4="False";
            BI_Status5="False";
        }
        else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
            BI_Status="True";
            BI_Status1="True";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status4="False";
            BI_Status5="False";
        }
        else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
            BI_Status="True";
            BI_Status1="True";
            BI_Status2="False";
            BI_Status3="False";
            BI_Status4="False";
            BI_Status5="False";
        }

    }
    private void init() {

        familyTypeEdit=findViewById(R.id.familyTypeEdit);
        sumInsuredEdit=findViewById(R.id.sumInsuredEdit);
        policyTenureEdit=findViewById(R.id.policyTenureEdit);
        proposer_spinner=findViewById(R.id.proposer_spinner);
        proposer_liner=findViewById(R.id.proposer_liner);
        btn_continue=findViewById(R.id.btn_continue);
        edt_name=findViewById(R.id.edt_name);
        edit_dob=findViewById(R.id.edit_dob);
        IndividualTypeEdit=findViewById(R.id.IndividualTypeEdit);
        policyType_spinner=findViewById(R.id.policyType_spinner);
//        familyType_spinner=findViewById(R.id.familyType_spinner);
        SumInsured_spinner=findViewById(R.id.SumInsured_spinner);
        sumInsuredDropDown=findViewById(R.id.sumInsuredDropDown);
        selfProposerSpinner=findViewById(R.id.selfProposerSpinner);
        RelationEdit=findViewById(R.id.RelationEdit);
        gender_spinner=findViewById(R.id.gender_spinner);
        BMIAdultOneEdit=findViewById(R.id.BMIAdultOneEdit);
        BMIChildEdit=findViewById(R.id.BMIChildEdit);
        BMIChildTwoEdit=findViewById(R.id.BMIChildTwoEdit);
        RelationChildThreeEdit=findViewById(R.id.RelationChildThreeEdit);
        RelationFourChildEdit=findViewById(R.id.RelationFourChildEdit);
        RelationChildTwoEdit=findViewById(R.id.RelationChildTwoEdit);
        RelationChildEdit=findViewById(R.id.RelationChildEdit);
        RelationAdultOneEdit=findViewById(R.id.RelationAdultOneEdit);
        spouse_gender_spinner=findViewById(R.id.spouse_gender_spinner);

        spouse_occupation_spinner=findViewById(R.id.spouse_occupation_spinner);
        ft_spinner=findViewById(R.id.ft_spinner);
        spouse_ft_spinner=findViewById(R.id.spouse_ft_spinner);
        inches_spinner=findViewById(R.id.inches_spinner);
        spouse_inches_spinner=findViewById(R.id.spouse_inches_spinner);
        weight_edit=findViewById(R.id.weight_edit);
        edt_Spouse_name=findViewById(R.id.edt_Spouse_name);
        spouse_edit_dob=findViewById(R.id.spouse_edit_dob);
        spouse_weight_edit=findViewById(R.id.spouse_weight_edit);
        totalPremiumAmount=findViewById(R.id.totalPremiumAmount);
        QuotationID=findViewById(R.id.QuotationID);
        oneChildLiner=findViewById(R.id.oneChildLiner);
        twoChildLiner=findViewById(R.id.twoChildLiner);
        threeChildLiner=findViewById(R.id.threeChildLiner);
        fourChildLiner=findViewById(R.id.fourChildLiner);
        spouseLiner=findViewById(R.id.spouseLiner);
        adultLiner=findViewById(R.id.adultLiner);
        policyTenure_edit=findViewById(R.id.policyTenure_edit);
        edit_gender=findViewById(R.id.edit_gender);
        edit_occupation=findViewById(R.id.edit_occupation);
        edit_ft=findViewById(R.id.edit_ft);
        edit_inches=findViewById(R.id.edit_inches);
        show_Breakup=findViewById(R.id.show_Breakup);
        selfProposerDob=findViewById(R.id.selfProposerDob);
        selfProposerGender=findViewById(R.id.selfProposerGender);
        selfProposerOccupation=findViewById(R.id.selfProposerOccupation);
        SelfProposerMarital=findViewById(R.id.SelfProposerMarital);
        selfProposerRelation=findViewById(R.id.selfProposerRelation);
        BMIEdit=findViewById(R.id.BMIEdit);
        BMIEChildThreeEdit=findViewById(R.id.BMIEChildThreeEdit);
        BMIFourChildEdit=findViewById(R.id.BMIFourChildEdit);



        gender_liner=findViewById(R.id.gender_liner);
        linerOccupation=findViewById(R.id.linerOccupation);
        ftLiner=findViewById(R.id.ftLiner);
        LinerInches=findViewById(R.id.LinerInches);

        spouseGender=findViewById(R.id.spouseGender);
        spouseOccupation=findViewById(R.id.spouseOccupation);
        spouseFt=findViewById(R.id.spouseFt);
        spouseInches=findViewById(R.id.spouseInches);

        ChildOneGender=findViewById(R.id.ChildOneGender);
        LinerFtChildOne=findViewById(R.id.LinerFtChildOne);
        LinerInchesChildOne=findViewById(R.id.LinerInchesChildOne);

        childTwoGenderLiner=findViewById(R.id.childTwoGenderLiner);
        LinerChildTwoFt=findViewById(R.id.LinerChildTwoFt);
        LinerChildTwoInches=findViewById(R.id.LinerChildTwoInches);

        thirdLinerGender=findViewById(R.id.thirdLinerGender);
        LinerFtThird=findViewById(R.id.LinerFtThird);
        thirdInchesLiner=findViewById(R.id.thirdInchesLiner);

        LinerGenderFour=findViewById(R.id.LinerGenderFour);
        LinerFtFour=findViewById(R.id.LinerFtFour);
        LinerInchesFour=findViewById(R.id.LinerInchesFour);


        OneEditName=findViewById(R.id.OneEditName);
        OneDob=findViewById(R.id.OneChildDob);
        oneGenderSpinner=findViewById(R.id.oneGenderSpinner);
        oneOccupationSpinner=findViewById(R.id.oneOccupationSpinner);
        oneFtSpinner=findViewById(R.id.oneFtSpinner);
        oneInchesSpinner=findViewById(R.id.oneInchesSpinner);
        oneWeightEdit=findViewById(R.id.oneWeightEdit);

        twoChildEditName=findViewById(R.id.twoChildEditName);
        twoDob=findViewById(R.id.twoDob);
        twoGenderSpinner=findViewById(R.id.twoGenderSpinner);
        twoOccupationSpinner=findViewById(R.id.twoOccupationSpinner);
        twoFtSpinner=findViewById(R.id.twoFtSpinner);
        twoInchesSpinner=findViewById(R.id.twoInchesSpinner);
        twoWeightEdit=findViewById(R.id.twoWeightEdit);

        thirdNameEdit=findViewById(R.id.thirdNameEdit);
        thirdDob=findViewById(R.id.thirdDob);
        thirdGenderSpinner=findViewById(R.id.thirdGenderSpinner);
        thirdInchesSpinner=findViewById(R.id.thirdInchesSpinner);
        thirdFtSpinner=findViewById(R.id.thirdFtSpinner);
        thirdOccupationSpinner=findViewById(R.id.thirdOccupationSpinner);
        thirdWeightEdit=findViewById(R.id.thirdWeightEdit);

        fourNameEdit=findViewById(R.id.fourNameEdit);
        fourDob=findViewById(R.id.fourDob);
        fourGenderSpinner=findViewById(R.id.fourGenderSpinner);
        fourOccupationSpinner=findViewById(R.id.fourOccupationSpinner);
        fourFtSpinner=findViewById(R.id.fourFtSpinner);
        fourInchesSpinner=findViewById(R.id.fourInchesSpinner);
        FourWeightEdit=findViewById(R.id.FourWeightEdit);

        spouseRelationLiner=findViewById(R.id.spouseRelationLiner);
        ChildOneLinerRelation=findViewById(R.id.ChildOneLinerRelation);
        ChildTwoRelationLiner=findViewById(R.id.ChildTwoRelationLiner);
        RelationThirdLiner=findViewById(R.id.RelationThirdLiner);
        LinerRelationFour=findViewById(R.id.LinerRelationFour);

        yesNo=getResources().getStringArray(R.array.yesNo);
        relation_with_insure=getResources().getStringArray(R.array.relation_with_insure);

        policyType_spinner.setText(str_policyType_spinner);
        policyType_spinner.setAlpha(0.5f);
        familyTypeEdit.setText(str_IndividualTypeEdit);
        familyTypeEdit.setAlpha(0.5f);
        sumInsuredEdit.setText(str_SumInsured);
        sumInsuredEdit.setAlpha(0.5f);
        policyTenureEdit.setText(strFirstTString+" Year");
        policyTenureEdit.setAlpha(0.5f);
        totalPremiumAmount.setText(TotalValue);
        totalPremiumAmount.setAlpha(0.5f);
        QuotationID.setText(PosPolicyNo);
        QuotationID.setAlpha(0.5f);
        adultLiner.setVisibility(View.VISIBLE);
        spouseLiner.setVisibility(View.VISIBLE);
        oneChildLiner.setVisibility(View.GONE);
        twoChildLiner.setVisibility(View.GONE);
        threeChildLiner.setVisibility(View.GONE);
        fourChildLiner.setVisibility(View.GONE);

        str_RelationEdit="Self";
        RelationEdit.setText(str_RelationEdit);


        if (str_policyType_spinner.equals("Individual")){
            adultLiner.setVisibility(View.VISIBLE);
            spouseLiner.setVisibility(View.GONE);
            oneChildLiner.setVisibility(View.GONE);
            twoChildLiner.setVisibility(View.GONE);
            threeChildLiner.setVisibility(View.GONE);
            fourChildLiner.setVisibility(View.GONE);
            BI_Status="True";
//            str_for="1";
        }else {
            if(str_IndividualTypeEdit.equals("2 Adult")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.GONE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
                BI_Status="True";
                BI_Status1="True";
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                BI_Status="True";
                BI_Status2="False";
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                BI_Status="True";
                BI_Status2="False";
                BI_Status3="False";
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.VISIBLE);
                fourChildLiner.setVisibility(View.GONE);
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                str_thirdOccupationSpinner="Student";
                thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                BI_Status="True";
                BI_Status2="False";
                BI_Status3="False";
                BI_Status4="False";
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                BI_Status="True";
                BI_Status1="True";
                BI_Status2="False";
//                str_for="1";
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
//                str_for="1";
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                BI_Status="True";
                BI_Status1="True";
                BI_Status2="False";
                BI_Status3="False";
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.VISIBLE);
                fourChildLiner.setVisibility(View.GONE);
//                str_for="1";
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                str_thirdOccupationSpinner="Student";
                thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                BI_Status="True";
                BI_Status1="True";
                BI_Status2="False";
                BI_Status3="False";
                BI_Status4="False";
            }
            else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.VISIBLE);
                oneChildLiner.setVisibility(View.VISIBLE);
                twoChildLiner.setVisibility(View.VISIBLE);
                threeChildLiner.setVisibility(View.VISIBLE);
                fourChildLiner.setVisibility(View.VISIBLE);
//                str_for="1";
                str_oneOccupationSpinner="Student";
                oneOccupationSpinner.setText(str_oneOccupationSpinner);
                str_twoOccupationSpinner="Student";
                twoOccupationSpinner.setText(str_twoOccupationSpinner);
                str_thirdOccupationSpinner="Student";
                thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                str_fourOccupationSpinner="Student";
                fourOccupationSpinner.setText(str_fourOccupationSpinner);
                BI_Status="True";
                BI_Status1="True";
                BI_Status2="False";
                BI_Status3="False";
                BI_Status4="False";
                BI_Status5="False";
            }
            else{
                adultLiner.setVisibility(View.VISIBLE);
                spouseLiner.setVisibility(View.GONE);
                oneChildLiner.setVisibility(View.GONE);
                twoChildLiner.setVisibility(View.GONE);
                threeChildLiner.setVisibility(View.GONE);
                fourChildLiner.setVisibility(View.GONE);
                BI_Status="True";
            }
        }
        edt_name.setText(str_edt_name);

        final ArrayAdapter<String> adapterproposer_spinner=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,yesNo);
        proposer_spinner.setAdapter(adapterproposer_spinner);
//        final ArrayAdapter<String> relation_with_insure_adapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,relation_with_insure);
//        proposer_self_spinner.setAdapter(relation_with_insure_adapter);

//        familyChildFloater=getResources().getStringArray(R.array.floater_no_child);
//        final ArrayAdapter<String> policyFamilyAdapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,familyChildFloater);
//        familyType_spinner.setAdapter(policyFamilyAdapter);


//        CompleteSumInsured=getResources().getStringArray(R.array.CompleteSumInsured);
//        final ArrayAdapter<String> sumInsuredAdapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,CompleteSumInsured);
//        SumInsured_spinner.setAdapter(sumInsuredAdapter);

//        policyTenure=getResources().getStringArray(R.array.policyTenure);
//        final ArrayAdapter<String> policyTenureAdapter=new ArrayAdapter<String>(getApplication(), R.layout.spinner_item_text,policyTenure);
//        policyTenure_spinner.setAdapter(policyTenureAdapter);

        Salutation=getResources().getStringArray(R.array.Salutation);
        final ArrayAdapter<String> adapterSalutation=new ArrayAdapter<String>(this, R.layout.spinner_item_text,Salutation);
        selfProposerSpinner.setAdapter(adapterSalutation);

        Marital=getResources().getStringArray(R.array.Marital);
        final ArrayAdapter<String> adapterMarital=new ArrayAdapter<String>(this, R.layout.spinner_item_text,Marital);
        SelfProposerMarital.setAdapter(adapterMarital);

        str_oneOccupationSpinner="Student";
        str_twoOccupationSpinner="Student";
        str_thirdOccupationSpinner="Student";
        str_fourOccupationSpinner="Student";
        oneOccupationSpinner.setText(str_oneOccupationSpinner);
        twoOccupationSpinner.setText(str_twoOccupationSpinner);
        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
        fourOccupationSpinner.setText(str_fourOccupationSpinner);

//        oneOccupationSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Student");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_oneOccupationSpinner=items1.get(options1);
//                        oneOccupationSpinner.setText(str_oneOccupationSpinner);
//
//                    }
//                });
//                singlePicker.show(); }
//        });
//
//        twoOccupationSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Student");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_twoOccupationSpinner=items1.get(options1);
//                        twoOccupationSpinner.setText(str_twoOccupationSpinner);
//
//                    }
//                });
//                singlePicker.show(); }
//        });
//
//        thirdOccupationSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Student");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_thirdOccupationSpinner=items1.get(options1);
//                        thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
//
//                    }
//                });
//                singlePicker.show(); }
//        });
//        fourOccupationSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("Student");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_fourOccupationSpinner=items1.get(options1);
//                        fourOccupationSpinner.setText(str_fourOccupationSpinner);
//
//                    }
//                });
//                singlePicker.show(); }
//        });
//

        if (str_for.equals("1")){
             if (str_policyType_spinner.equals("Individual")){
                 edit_dob.setText(str_edit_dob);
                 gender_spinner.setVisibility(View.GONE);
                 edit_gender.setVisibility(View.VISIBLE);
                 edit_occupation.setVisibility(View.VISIBLE);
                 edit_ft.setVisibility(View.VISIBLE);
                 edit_inches.setVisibility(View.VISIBLE);
                 inches_spinner.setVisibility(View.GONE);
                 ft_spinner.setVisibility(View.GONE);
                 edit_gender.setText(str_gender);
                 edit_occupation.setText(str_occupation);
                 edit_ft.setText(str_ft);
                 edit_inches.setText(str_inches);
                 weight_edit.setText(str_weight_edit);
                 BMIEdit.setText(strBMIEdit);
                 str_for="1";
             }else if (str_policyType_spinner.equals("Family Floater")){
                 str_oneOccupationSpinner="Student";
                 str_twoOccupationSpinner="Student";
                 str_thirdOccupationSpinner="Student";
                 str_fourOccupationSpinner="Student";
                 familyTypeEdit.setText(str_IndividualTypeEdit);
                 switch (str_IndividualTypeEdit) {
                     case "2 Adult":
                         adultLiner.setVisibility(View.VISIBLE);
                         spouseLiner.setVisibility(View.VISIBLE);
                         oneChildLiner.setVisibility(View.GONE);
                         twoChildLiner.setVisibility(View.GONE);
                         threeChildLiner.setVisibility(View.GONE);
                         fourChildLiner.setVisibility(View.GONE);
                         edit_dob.setText(str_edit_dob);
                         gender_spinner.setVisibility(View.GONE);
                         edit_gender.setVisibility(View.VISIBLE);
                         edit_occupation.setVisibility(View.VISIBLE);
                         edit_ft.setVisibility(View.VISIBLE);
                         edit_inches.setVisibility(View.VISIBLE);
                         inches_spinner.setVisibility(View.GONE);
                         ft_spinner.setVisibility(View.GONE);
                         edit_gender.setText(str_gender);
                         spouse_gender_spinner.setText(str_spouse_gender);
                         edit_occupation.setText(str_occupation);
                         spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                         edit_ft.setText(str_ft);
                         spouse_ft_spinner.setText(str_spouse_ft_spinner);
                         edit_inches.setText(str_inches);
                         spouse_inches_spinner.setText(str_spouse_inches_spinner);
                         weight_edit.setText(str_weight_edit);
                         edt_Spouse_name.setText(str_edt_Spouse_name);
                         spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                         spouse_weight_edit.setText(str_spouse_weight_edit);
                         BMIEdit.setText(strBMIEdit);
                         BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                         RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                         break;
                     case "1 Adult + 1 Child":
                         adultLiner.setVisibility(View.VISIBLE);
                         spouseLiner.setVisibility(View.GONE);
                         oneChildLiner.setVisibility(View.VISIBLE);
                         twoChildLiner.setVisibility(View.GONE);
                         threeChildLiner.setVisibility(View.GONE);
                         fourChildLiner.setVisibility(View.GONE);
                         edit_dob.setText(str_edit_dob);
                         gender_spinner.setVisibility(View.GONE);
                         edit_gender.setVisibility(View.VISIBLE);
                         edit_occupation.setVisibility(View.VISIBLE);
                         edit_ft.setVisibility(View.VISIBLE);
                         edit_inches.setVisibility(View.VISIBLE);
                         inches_spinner.setVisibility(View.GONE);
                         ft_spinner.setVisibility(View.GONE);
                         edit_gender.setText(str_gender);
                         edit_occupation.setText(str_occupation);
                         edit_ft.setText(str_ft);
                         edit_inches.setText(str_inches);
                         weight_edit.setText(str_weight_edit);
                         oneGenderSpinner.setText(str_oneGenderSpinner);
                         OneEditName.setText(str_OneEditName);
                         OneDob.setText(strOneChild);
                         oneOccupationSpinner.setText(str_oneOccupationSpinner);
                         oneWeightEdit.setText(str_oneWeightEdit);
                         BMIEdit.setText(strBMIEdit);
                         BMIChildEdit.setText(strBMIChildEdit);
                         oneFtSpinner.setText(str_oneFtSpinner);
                         oneInchesSpinner.setText(str_oneInchesSpinner);
                         RelationChildEdit.setText(strRelationChildEdit);
                         str_for = "1";
                         break;
                     case "1 Adult + 2 Child":
                         adultLiner.setVisibility(View.VISIBLE);
                         spouseLiner.setVisibility(View.GONE);
                         oneChildLiner.setVisibility(View.VISIBLE);
                         twoChildLiner.setVisibility(View.VISIBLE);
                         threeChildLiner.setVisibility(View.GONE);
                         fourChildLiner.setVisibility(View.GONE);
                         edit_dob.setText(str_edit_dob);
                         gender_spinner.setVisibility(View.GONE);
                         edit_gender.setVisibility(View.VISIBLE);
                         edit_occupation.setVisibility(View.VISIBLE);
                         edit_ft.setVisibility(View.VISIBLE);
                         edit_inches.setVisibility(View.VISIBLE);
                         inches_spinner.setVisibility(View.GONE);
                         ft_spinner.setVisibility(View.GONE);
                         edit_gender.setText(str_gender);
                         edit_occupation.setText(str_occupation);
                         edit_ft.setText(str_ft);
                         edit_inches.setText(str_inches);
                         weight_edit.setText(str_weight_edit);
                         OneEditName.setText(str_OneEditName);
                         OneDob.setText(strOneChild);
                         oneGenderSpinner.setText(str_oneGenderSpinner);
                         oneWeightEdit.setText(str_oneWeightEdit);
                         twoChildEditName.setText(str_twoChildEditName);
                         twoDob.setText(strtwoDob);
                         twoWeightEdit.setText(strtwoWeightEdit);
                         twoOccupationSpinner.setText(str_twoOccupationSpinner);
                         oneOccupationSpinner.setText(str_oneOccupationSpinner);
                         BMIEdit.setText(strBMIEdit);
                         BMIChildEdit.setText(strBMIChildEdit);
                         BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                         oneFtSpinner.setText(str_oneFtSpinner);
                         oneInchesSpinner.setText(str_oneInchesSpinner);
                         twoGenderSpinner.setText(str_twoGenderSpinner);
                         twoFtSpinner.setText(str_twoFtSpinner);
                         twoInchesSpinner.setText(str_twoInchesSpinner);
                         RelationChildEdit.setText(strRelationChildEdit);
                         RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                         str_for = "1";
                         break;
                     case "1 Adult + 3 Child":
                         adultLiner.setVisibility(View.VISIBLE);
                         spouseLiner.setVisibility(View.GONE);
                         oneChildLiner.setVisibility(View.VISIBLE);
                         twoChildLiner.setVisibility(View.VISIBLE);
                         threeChildLiner.setVisibility(View.VISIBLE);
                         fourChildLiner.setVisibility(View.GONE);
                         edit_dob.setText(str_edit_dob);
                         gender_spinner.setVisibility(View.GONE);
                         edit_gender.setVisibility(View.VISIBLE);
                         edit_occupation.setVisibility(View.VISIBLE);
                         edit_ft.setVisibility(View.VISIBLE);
                         edit_inches.setVisibility(View.VISIBLE);
                         inches_spinner.setVisibility(View.GONE);
                         ft_spinner.setVisibility(View.GONE);
                         edit_gender.setText(str_gender);
                         edit_occupation.setText(str_occupation);
                         edit_ft.setText(str_ft);
                         edit_inches.setText(str_inches);
                         weight_edit.setText(str_weight_edit);
                         OneEditName.setText(str_OneEditName);
                         OneDob.setText(strOneChild);
                         oneWeightEdit.setText(str_oneWeightEdit);
                         oneGenderSpinner.setText(str_oneGenderSpinner);
                         twoChildEditName.setText(str_twoChildEditName);
                         twoDob.setText(strtwoDob);
                         twoWeightEdit.setText(strtwoWeightEdit);
                         thirdNameEdit.setText(str_thirdNameEdit);
                         thirdDob.setText(strthreeDob);
                         thirdWeightEdit.setText(str_thirdWeightEdit);
                         twoOccupationSpinner.setText(str_twoOccupationSpinner);
                         thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                         oneOccupationSpinner.setText(str_oneOccupationSpinner);
                         BMIEdit.setText(strBMIEdit);
                         BMIChildEdit.setText(strBMIChildEdit);
                         BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                         BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                         oneFtSpinner.setText(str_oneFtSpinner);
                         oneInchesSpinner.setText(str_oneInchesSpinner);
                         twoGenderSpinner.setText(str_twoGenderSpinner);
                         twoFtSpinner.setText(str_twoFtSpinner);
                         twoInchesSpinner.setText(str_twoInchesSpinner);
                         thirdGenderSpinner.setText(str_thirdGenderSpinner);
                         thirdFtSpinner.setText(str_thirdFtSpinner);
                         thirdInchesSpinner.setText(str_thirdInchesSpinner);
                         RelationChildEdit.setText(strRelationChildEdit);
                         RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                         RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                         RelationFourChildEdit.setText(strRelationFourChildEdit);

                         str_for = "1";
                         break;
                     case "2 Adult + 1 Child":
                         adultLiner.setVisibility(View.VISIBLE);
                         spouseLiner.setVisibility(View.VISIBLE);
                         oneChildLiner.setVisibility(View.VISIBLE);
                         twoChildLiner.setVisibility(View.GONE);
                         threeChildLiner.setVisibility(View.GONE);
                         fourChildLiner.setVisibility(View.GONE);
                         edit_dob.setText(str_edit_dob);
                         gender_spinner.setVisibility(View.GONE);
                         edit_gender.setVisibility(View.VISIBLE);
                         edit_occupation.setVisibility(View.VISIBLE);
                         edit_ft.setVisibility(View.VISIBLE);
                         edit_inches.setVisibility(View.VISIBLE);
                         inches_spinner.setVisibility(View.GONE);
                         ft_spinner.setVisibility(View.GONE);
                         edit_gender.setText(str_gender);
                         spouse_gender_spinner.setText(str_spouse_gender);
                         edit_occupation.setText(str_occupation);
                         spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                         edit_ft.setText(str_ft);
                         spouse_ft_spinner.setText(str_spouse_ft_spinner);
                         edit_inches.setText(str_inches);
                         spouse_inches_spinner.setText(str_spouse_inches_spinner);
                         weight_edit.setText(str_weight_edit);
                         edt_Spouse_name.setText(str_edt_Spouse_name);
                         spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                         spouse_weight_edit.setText(str_spouse_weight_edit);
                         OneEditName.setText(str_OneEditName);
                         OneDob.setText(strOneChild);
                         oneGenderSpinner.setText(str_oneGenderSpinner);
                         oneWeightEdit.setText(str_oneWeightEdit);
                         oneOccupationSpinner.setText(str_oneOccupationSpinner);
                         BMIEdit.setText(strBMIEdit);
                         BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                         BMIChildEdit.setText(strBMIChildEdit);
                         oneFtSpinner.setText(str_oneFtSpinner);
                         oneInchesSpinner.setText(str_oneInchesSpinner);
                         RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                         RelationChildEdit.setText(strRelationChildEdit);
                         str_for = "1";
                         break;
                     case "2 Adult + 2 Child":
                         adultLiner.setVisibility(View.VISIBLE);
                         spouseLiner.setVisibility(View.VISIBLE);
                         oneChildLiner.setVisibility(View.VISIBLE);
                         twoChildLiner.setVisibility(View.VISIBLE);
                         threeChildLiner.setVisibility(View.GONE);
                         fourChildLiner.setVisibility(View.GONE);
                         edit_dob.setText(str_edit_dob);
                         gender_spinner.setVisibility(View.GONE);
                         edit_gender.setVisibility(View.VISIBLE);
                         edit_occupation.setVisibility(View.VISIBLE);
                         edit_ft.setVisibility(View.VISIBLE);
                         edit_inches.setVisibility(View.VISIBLE);

                         inches_spinner.setVisibility(View.GONE);
                         ft_spinner.setVisibility(View.GONE);
                         edit_gender.setText(str_gender);
                         spouse_gender_spinner.setText(str_spouse_gender);
                         edit_occupation.setText(str_occupation);
                         spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                         edit_ft.setText(str_ft);
                         spouse_ft_spinner.setText(str_spouse_ft_spinner);
                         edit_inches.setText(str_inches);
                         spouse_inches_spinner.setText(str_spouse_inches_spinner);
                         weight_edit.setText(str_weight_edit);
                         edt_Spouse_name.setText(str_edt_Spouse_name);
                         spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                         spouse_weight_edit.setText(str_spouse_weight_edit);
                         OneEditName.setText(str_OneEditName);
                         OneDob.setText(strOneChild);
                         oneGenderSpinner.setText(str_oneGenderSpinner);
                         oneWeightEdit.setText(str_oneWeightEdit);
                         twoChildEditName.setText(str_twoChildEditName);
                         twoDob.setText(strtwoDob);
                         twoWeightEdit.setText(strtwoWeightEdit);
                         twoOccupationSpinner.setText(str_twoOccupationSpinner);
                         oneOccupationSpinner.setText(str_oneOccupationSpinner);
                         BMIEdit.setText(strBMIEdit);
                         BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                         BMIChildEdit.setText(strBMIChildEdit);
                         BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                         oneFtSpinner.setText(str_oneFtSpinner);
                         oneInchesSpinner.setText(str_oneInchesSpinner);
                         twoGenderSpinner.setText(str_twoGenderSpinner);
                         twoFtSpinner.setText(str_twoFtSpinner);
                         twoInchesSpinner.setText(str_twoInchesSpinner);

                         RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                         RelationChildEdit.setText(strRelationChildEdit);
                         RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                         str_for = "1";
                         break;
                     case "2 Adult + 3 Child":
                         adultLiner.setVisibility(View.VISIBLE);
                         spouseLiner.setVisibility(View.VISIBLE);
                         oneChildLiner.setVisibility(View.VISIBLE);
                         twoChildLiner.setVisibility(View.VISIBLE);
                         threeChildLiner.setVisibility(View.VISIBLE);
                         fourChildLiner.setVisibility(View.GONE);
                         edit_dob.setText(str_edit_dob);
                         gender_spinner.setVisibility(View.GONE);
                         edit_gender.setVisibility(View.VISIBLE);
                         edit_occupation.setVisibility(View.VISIBLE);
                         edit_ft.setVisibility(View.VISIBLE);
                         edit_inches.setVisibility(View.VISIBLE);
                         inches_spinner.setVisibility(View.GONE);
                         ft_spinner.setVisibility(View.GONE);
                         edit_gender.setText(str_gender);
                         spouse_gender_spinner.setText(str_spouse_gender);
                         spouse_gender_spinner.setText(str_spouse_gender);
                         edit_occupation.setText(str_occupation);
                         spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                         edit_ft.setText(str_ft);
                         spouse_ft_spinner.setText(str_spouse_ft_spinner);
                         edit_inches.setText(str_inches);
                         spouse_inches_spinner.setText(str_spouse_inches_spinner);
                         weight_edit.setText(str_weight_edit);
                         edt_Spouse_name.setText(str_edt_Spouse_name);
                         spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                         spouse_weight_edit.setText(str_spouse_weight_edit);
                         OneEditName.setText(str_OneEditName);
                         OneDob.setText(strOneChild);
                         oneWeightEdit.setText(str_oneWeightEdit);
                         oneGenderSpinner.setText(str_oneGenderSpinner);
                         twoChildEditName.setText(str_twoChildEditName);
                         twoDob.setText(strtwoDob);
                         twoWeightEdit.setText(strtwoWeightEdit);
                         thirdNameEdit.setText(str_thirdNameEdit);
                         thirdDob.setText(strthreeDob);
                         thirdWeightEdit.setText(str_thirdWeightEdit);
                         twoOccupationSpinner.setText(str_twoOccupationSpinner);
                         thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                         oneOccupationSpinner.setText(str_oneOccupationSpinner);
                         BMIEdit.setText(strBMIEdit);
                         BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                         BMIChildEdit.setText(strBMIChildEdit);
                         BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                         BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                         oneFtSpinner.setText(str_oneFtSpinner);
                         oneInchesSpinner.setText(str_oneInchesSpinner);
                         twoGenderSpinner.setText(str_twoGenderSpinner);
                         twoFtSpinner.setText(str_twoFtSpinner);
                         twoInchesSpinner.setText(str_twoInchesSpinner);
                         thirdGenderSpinner.setText(str_thirdGenderSpinner);
                         thirdFtSpinner.setText(str_thirdFtSpinner);
                         thirdInchesSpinner.setText(str_thirdInchesSpinner);
                         RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                         RelationChildEdit.setText(strRelationChildEdit);
                         RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                         RelationChildThreeEdit.setText(strRelationChildThreeEdit);


                         str_for = "1";
                         break;
                     case "2 Adult + 4 Child":
                         adultLiner.setVisibility(View.VISIBLE);
                         spouseLiner.setVisibility(View.VISIBLE);
                         oneChildLiner.setVisibility(View.VISIBLE);
                         twoChildLiner.setVisibility(View.VISIBLE);
                         threeChildLiner.setVisibility(View.VISIBLE);
                         fourChildLiner.setVisibility(View.VISIBLE);
                         edit_occupation.setVisibility(View.VISIBLE);
                         edit_ft.setVisibility(View.VISIBLE);
                         edit_inches.setVisibility(View.VISIBLE);
                         inches_spinner.setVisibility(View.GONE);
                         ft_spinner.setVisibility(View.GONE);
                         edit_gender.setText(str_gender);
                         edit_dob.setText(str_edit_dob);
                         edit_occupation.setText(str_occupation);
                         edit_ft.setText(str_ft);
                         edit_inches.setText(str_inches);
                         weight_edit.setText(str_weight_edit);
                         BMIEdit.setText(strBMIEdit);
                         edt_Spouse_name.setText(str_edt_Spouse_name);
                         spouse_gender_spinner.setText(str_spouse_gender);
                         spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                         spouse_ft_spinner.setText(str_spouse_ft_spinner);
                         spouse_inches_spinner.setText(str_spouse_inches_spinner);
                         spouse_edit_dob.setText(str_spouse_edit_dob_dob);
                         spouse_weight_edit.setText(str_spouse_weight_edit);
                         BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                         OneEditName.setText(str_OneEditName);
                         OneDob.setText(strOneChild);
                         oneWeightEdit.setText(str_oneWeightEdit);
                         oneGenderSpinner.setText(str_oneGenderSpinner);
                         oneFtSpinner.setText(str_oneFtSpinner);
                         oneInchesSpinner.setText(str_oneInchesSpinner);
                         BMIChildEdit.setText(strBMIChildEdit);
                         twoChildEditName.setText(str_twoChildEditName);
                         twoDob.setText(strtwoDob);
                         twoWeightEdit.setText(strtwoWeightEdit);
                         thirdNameEdit.setText(str_thirdNameEdit);
                         thirdDob.setText(strthreeDob);
                         thirdWeightEdit.setText(str_thirdWeightEdit);
                         fourNameEdit.setText(str_fourNameEdit);
                         fourDob.setText(strfourDob);
                         FourWeightEdit.setText(strFourWeightEdit);
                         oneOccupationSpinner.setText(str_oneOccupationSpinner);
                         twoOccupationSpinner.setText(str_twoOccupationSpinner);
                         thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
                         fourOccupationSpinner.setText(str_fourOccupationSpinner);
                         BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                         BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                         BMIFourChildEdit.setText(strBMIFourChildEdit);
                         twoGenderSpinner.setText(str_twoGenderSpinner);
                         twoFtSpinner.setText(str_twoFtSpinner);
                         twoInchesSpinner.setText(str_twoInchesSpinner);
                         thirdGenderSpinner.setText(str_thirdGenderSpinner);
                         thirdFtSpinner.setText(str_thirdFtSpinner);
                         thirdInchesSpinner.setText(str_thirdInchesSpinner);
                         fourGenderSpinner.setText(str_fourGenderSpinner);
                         fourFtSpinner.setText(str_fourFtSpinner);
                         fourInchesSpinner.setText(str_fourInchesSpinner);
                         RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                         RelationChildEdit.setText(strRelationChildEdit);
                         RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                         RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                         RelationFourChildEdit.setText(strRelationFourChildEdit);
                         str_for = "1";
                         break;
                 }
             }
            }
        else{
            edit_dob.setText(str_edit_dob);
            edit_gender.setText(str_gender);
            edit_occupation.setText(str_occupation);
            edit_ft.setText(str_ft);
            edit_inches.setText(str_inches);
            weight_edit.setText(str_weight_edit);
            edt_Spouse_name.setText(str_edt_Spouse_name);
            spouse_edit_dob.setText(str_spouse_edit_dob_dob);
            spouse_weight_edit.setText(str_spouse_weight_edit);
            BMIEdit.setText(strBMIEdit);
         }

//        if (!str_for.equals("1")){
//            if (str_policyType_spinner.equals("Individual")){
//                IndividualTypeEdit.setVisibility(View.VISIBLE);
//                IndividualTypeEdit.getText().toString();
//                str_IndividualTypeEdit="1 Adult";
//                IndividualTypeEdit.setText(str_IndividualTypeEdit);
//                adultLiner.setVisibility(View.VISIBLE);
//                spouseLiner.setVisibility(View.GONE);
//                oneChildLiner.setVisibility(View.GONE);
//                twoChildLiner.setVisibility(View.GONE);
//                threeChildLiner.setVisibility(View.GONE);
//                fourChildLiner.setVisibility(View.GONE);
//            }else {
//                adultLiner.setVisibility(View.VISIBLE);
//                spouseLiner.setVisibility(View.VISIBLE);
//                oneChildLiner.setVisibility(View.GONE);
//                twoChildLiner.setVisibility(View.GONE);
//                threeChildLiner.setVisibility(View.GONE);
//                fourChildLiner.setVisibility(View.GONE);
//                str_oneOccupationSpinner="Student";
//                str_twoOccupationSpinner="Student";
//                str_thirdOccupationSpinner="Student";
//                str_fourOccupationSpinner="Student";
//                oneOccupationSpinner.setText(str_oneOccupationSpinner);
//                twoOccupationSpinner.setText(str_twoOccupationSpinner);
//                thirdOccupationSpinner.setText(str_thirdOccupationSpinner);
//                fourOccupationSpinner.setText(str_fourOccupationSpinner);
//            }
//        }else {
//            familyType_spinner.setText(str_IndividualTypeEdit);
//        }
//
//        if(str_policyType_spinner.equals("Individual")){
//            int personalSumInsured= Integer.parseInt(str_SumInsured);
//            double amountPersonalSumInsured=(personalSumInsured/1000)*0.4;
//            str_amountPersonalSumInsured= String.valueOf(amountPersonalSumInsured);
//             strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//             strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//        } else {
//            if (str_IndividualTypeEdit.equals("2 Adult")){
//                 amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                 personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
//                str_amountPersonalSumInsured= String.valueOf(personalSumInsured);
//                 //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit));
//                strcriticalEdit=String.valueOf(add_strcriticalEdit);
//                //HospitalCash
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit));
//                strhospitalEdit=String.valueOf(add_strhospitalEdit);
//            }
//            else if (str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
//                 amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                 personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured;
//                str_amountPersonalSumInsured= String.valueOf(personalSumInsured);
//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                strcriticalEdit=String.valueOf(add_strcriticalEdit);
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                strhospitalEdit=String.valueOf(add_strhospitalEdit);
//
//            }
//            else if (str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
//                double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
//                str_amountPersonalSumInsured= String.valueOf(personalSumInsured);
//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                strcriticalEdit=(String.valueOf(add_strcriticalEdit));
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                strhospitalEdit=(String.valueOf(add_strhospitalEdit));
//            }
//            else if (str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
//                double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
//                str_amountPersonalSumInsured= String.valueOf(personalSumInsured);
//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                strcriticalEdit=(String.valueOf(add_strcriticalEdit));
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                strhospitalEdit=(String.valueOf(add_strhospitalEdit));
//            }
//            else if (str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
//                double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
//                str_amountPersonalSumInsured= String.valueOf(personalSumInsured);
//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                strcriticalEdit=(String.valueOf(add_strcriticalEdit));
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt));
//                strhospitalEdit=(String.valueOf(add_strhospitalEdit));
//            }
//            else if (str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
//                double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
//                str_amountPersonalSumInsured= String.valueOf(personalSumInsured);
//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                strcriticalEdit=(String.valueOf(add_strcriticalEdit));
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                strhospitalEdit=(String.valueOf(add_strhospitalEdit));
//            }
//            else if (str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
//                double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
//                str_amountPersonalSumInsured= String.valueOf(personalSumInsured);
//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                strcriticalEdit=(String.valueOf(add_strcriticalEdit));
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                strhospitalEdit=(String.valueOf(add_strhospitalEdit));
//            }
//            else if (str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
//                double amountPersonalSumInsured=(Integer.parseInt(str_SumInsured)/1000)*0.4;
//                double personalSumInsured= amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured+amountPersonalSumInsured;
//                str_amountPersonalSumInsured= String.valueOf(personalSumInsured);
//                //function
//                strcriticalEdit= AllIndividualCalculate(str_edit_dob3String,str_SumInsured);
//                strhospitalEdit= AllIndividualHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                strOneChildCriticalIllnessTxt= ChildCriticalCalculate(str_edit_dob3String,str_SumInsured);
//                stroneChildTxt= ChildHospitalCalculate(str_edit_dob3String,str_SumInsured);
//                int add_strcriticalEdit=(Integer.parseInt(strcriticalEdit)+Integer.parseInt(strcriticalEdit)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt)+Integer.parseInt(strOneChildCriticalIllnessTxt));
//                strcriticalEdit=(String.valueOf(add_strcriticalEdit));
//                int add_strhospitalEdit=(Integer.parseInt(strhospitalEdit)+Integer.parseInt(strhospitalEdit)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt)+Integer.parseInt(stroneChildTxt));
//                strhospitalEdit=(String.valueOf(add_strhospitalEdit));
//            }
//        }


//        if (str_for.equals("1")){
//            familyType_spinner.setText(str_IndividualTypeEdit);
//        }else {
//            familyType_spinner.setText("2 Adult");
//        }

//        familyType_spinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("2 Adult");
//                items1.add("1 Adult + 1 Child");
//                items1.add("1 Adult + 2 Child");
//                items1.add("1 Adult + 3 Child");
//                items1.add("2 Adult + 1 Child");
//                items1.add("2 Adult + 2 Child");
//                items1.add("2 Adult + 3 Child");
//                items1.add("2 Adult + 4 Child");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//
//                        str_IndividualTypeEdit=items1.get(options1);
//                        familyType_spinner.setText(str_IndividualTypeEdit);
//                        if(str_IndividualTypeEdit.equals("2 Adult")){
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.VISIBLE);
//                            oneChildLiner.setVisibility(View.GONE);
//                            twoChildLiner.setVisibility(View.GONE);
//                            threeChildLiner.setVisibility(View.GONE);
//                            fourChildLiner.setVisibility(View.GONE);
//
//                            str_for="1";
//
//                        }
//                        else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.GONE);
//                            oneChildLiner.setVisibility(View.VISIBLE);
//                            twoChildLiner.setVisibility(View.GONE);
//                            threeChildLiner.setVisibility(View.GONE);
//                            fourChildLiner.setVisibility(View.GONE);
//
//                            str_for="1";
//
//                        }
//                        else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.GONE);
//                            oneChildLiner.setVisibility(View.VISIBLE);
//                            twoChildLiner.setVisibility(View.VISIBLE);
//                            threeChildLiner.setVisibility(View.GONE);
//                            fourChildLiner.setVisibility(View.GONE);
//
//                            str_for="1";
//
//                        }
//                        else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.GONE);
//                            oneChildLiner.setVisibility(View.VISIBLE);
//                            twoChildLiner.setVisibility(View.VISIBLE);
//                            threeChildLiner.setVisibility(View.VISIBLE);
//                            fourChildLiner.setVisibility(View.GONE);
//
//                            str_for="1";
//
//                        }
//                        else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.VISIBLE);
//                            oneChildLiner.setVisibility(View.VISIBLE);
//                            twoChildLiner.setVisibility(View.GONE);
//                            threeChildLiner.setVisibility(View.GONE);
//                            fourChildLiner.setVisibility(View.GONE);
//
//                            str_for="1";
//
//                        }
//                        else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.VISIBLE);
//                            oneChildLiner.setVisibility(View.VISIBLE);
//                            twoChildLiner.setVisibility(View.VISIBLE);
//                            threeChildLiner.setVisibility(View.GONE);
//                            fourChildLiner.setVisibility(View.GONE);
//                            str_for="1";
//
//
//                        }
//                        else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.VISIBLE);
//                            oneChildLiner.setVisibility(View.VISIBLE);
//                            twoChildLiner.setVisibility(View.VISIBLE);
//                            threeChildLiner.setVisibility(View.VISIBLE);
//                            fourChildLiner.setVisibility(View.GONE);
//                            str_for="1";
//
//
//                        }
//                        else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.VISIBLE);
//                            oneChildLiner.setVisibility(View.VISIBLE);
//                            twoChildLiner.setVisibility(View.VISIBLE);
//                            threeChildLiner.setVisibility(View.VISIBLE);
//                            fourChildLiner.setVisibility(View.VISIBLE);
//                            str_for="1";
//
//
//                        }
//                        else{
//                            adultLiner.setVisibility(View.VISIBLE);
//                            spouseLiner.setVisibility(View.GONE);
//                            oneChildLiner.setVisibility(View.GONE);
//                            twoChildLiner.setVisibility(View.GONE);
//                            threeChildLiner.setVisibility(View.GONE);
//                            fourChildLiner.setVisibility(View.GONE);
//                        }
//                    }
//                });
//                singlePicker.show(); }
//        });

        show_Breakup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog alert_dialog = new Dialog(Complete_health_member_info.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.show_breakup);
                EditText longTermDiscountTxt,ESaleTxt,basicPremium,criticalEdit,premiumEdit,hospitalEdit,subLimitAmount,gstEdit,totalAmount,tiedHospital;
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
                ESaleTxt = alert_dialog.findViewById(R.id.ESaleTxt);

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

//        SumInsured_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                str_SumInsured= String.valueOf(CompleteSumInsured[i]);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });

        strRelationAdultOneEdit="Spouse";
        strselfProposerRelation="Spouse";
        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
        selfProposerRelation.setText(strselfProposerRelation);
        strRelationChildEdit="Daughter";
        strRelationChildTwoEdit="Daughter";
        strRelationChildThreeEdit="Daughter";
        strRelationFourChildEdit="Daughter";
        RelationChildEdit.setText(strRelationChildEdit);
        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
        RelationFourChildEdit.setText(strRelationFourChildEdit);


        selfProposerRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
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
                        strselfProposerRelation=items1.get(options1);
                        selfProposerRelation.setText(strselfProposerRelation);
                    }
                });
                singlePicker.show(); }
        });
        spouseRelationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Spouse");
                items1.add("Daughter in law");
                items1.add("Son in law");
                items1.add("Mother");
                items1.add("Father");
                items1.add("Father in law");
                items1.add("Mother in law");
                items1.add("Brother");
                items1.add("Sister");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationAdultOneEdit=items1.get(options1);
                        RelationAdultOneEdit.setText(strRelationAdultOneEdit);
                    }
                });
                singlePicker.show(); }
        });
        ChildOneLinerRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildEdit=items1.get(options1);
                        RelationChildEdit.setText(strRelationChildEdit);
                    }
                });
                singlePicker.show(); }
        });
        ChildTwoRelationLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildTwoEdit=items1.get(options1);
                        RelationChildTwoEdit.setText(strRelationChildTwoEdit);
                    }
                });
                singlePicker.show(); }
        });
        RelationThirdLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationChildThreeEdit=items1.get(options1);
                        RelationChildThreeEdit.setText(strRelationChildThreeEdit);
                    }
                });
                singlePicker.show(); }
        });
        LinerRelationFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Daughter");
                items1.add("Son");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strRelationFourChildEdit=items1.get(options1);
                        RelationFourChildEdit.setText(strRelationFourChildEdit);
                    }
                });
                singlePicker.show(); }
        });



//        sumInsuredDropDown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
//                final ArrayList<String> items1 = new ArrayList<String>();
//                items1.add("400000");
//                items1.add("500000");
//                items1.add("600000");
//                items1.add("700000");
//                items1.add("800000");
//                items1.add("900000");
//                items1.add("1000000");
//                singlePicker.setPicker(items1);
//                singlePicker.setCyclic(false);
//                singlePicker.setSelectOptions(0);
//                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
//                    @Override
//                    public void onOptionsSelect(int options1, int option2, int options3) {
//                        str_SumInsured=items1.get(options1);
//                        SumInsured_spinner.setText(str_SumInsured);
//
//                        if (str_policyType_spinner.equals("")){
//                            Toast.makeText(Complete_health_member_info.this, "Select Policy Type", Toast.LENGTH_SHORT).show();
//                        }else if (str_IndividualTypeEdit.equals("")){
//                            Toast.makeText(Complete_health_member_info.this, "Select Family Type", Toast.LENGTH_SHORT).show();
//                        }else if (str_policyTenure.equals("")){
//                            Toast.makeText(Complete_health_member_info.this, "Select Policy tenure", Toast.LENGTH_SHORT).show();
//                        }else if (str_SumInsured.equals("")){
//                            Toast.makeText(Complete_health_member_info.this, "Select Sum Insured", Toast.LENGTH_SHORT).show();
//                        }else{
//
//                        }
//
//                    }
//                });
//                singlePicker.show(); }
//        });

     if (str_for.equals("0")){
         str_selfProposerGender="Select Gender";
         str_gender="Select Gender";
         str_spouse_gender="Select Gender";
         str_oneGenderSpinner="Select Gender";
         str_twoGenderSpinner="Select Gender";
         str_thirdGenderSpinner="Select Gender";
         str_fourGenderSpinner="Select Gender";
         str_selfProposerOccupation="Occupation";
         str_occupation="Occupation";
         str_spouse_occupation_spinner="Occupation";
         str_ft="Ft";
         str_spouse_ft_spinner="Ft";
         str_oneFtSpinner="Ft";
         str_twoFtSpinner="Ft";
         str_thirdFtSpinner="Ft";
         str_fourFtSpinner="Ft";
         str_inches="Inches";
         str_spouse_inches_spinner="Inches";
         str_oneInchesSpinner="Inches";
         str_twoInchesSpinner="Inches";
         str_thirdInchesSpinner="Inches";
         str_fourInchesSpinner="Inches";
         selfProposerGender.setText(str_selfProposerGender);
         selfProposerOccupation.setText(str_selfProposerOccupation);
         edit_gender.setText(str_gender);
         edit_occupation.setText(str_occupation);
         edit_ft.setText(str_ft);
         edit_inches.setText(str_inches);
         spouse_gender_spinner.setText(str_spouse_gender);
         spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
         spouse_ft_spinner.setText(str_spouse_ft_spinner);
         spouse_inches_spinner.setText(str_spouse_inches_spinner);
         oneGenderSpinner.setText(str_oneGenderSpinner);
         oneFtSpinner.setText(str_oneFtSpinner);
         oneInchesSpinner.setText(str_oneInchesSpinner);
         twoGenderSpinner.setText(str_twoGenderSpinner);
         twoFtSpinner.setText(str_twoFtSpinner);
         twoInchesSpinner.setText(str_twoInchesSpinner);
         thirdGenderSpinner.setText(str_thirdGenderSpinner);
         thirdFtSpinner.setText(str_thirdFtSpinner);
         thirdInchesSpinner.setText(str_thirdInchesSpinner);
         fourGenderSpinner.setText(str_fourGenderSpinner);
         fourFtSpinner.setText(str_fourFtSpinner);
         fourInchesSpinner.setText(str_fourInchesSpinner);
     }



        //selfProposer
        selfProposerGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_selfProposerGender=items1.get(options1);
                        selfProposerGender.setText(str_selfProposerGender);
                    }
                });
                singlePicker.show(); }
        });
        selfProposerOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyer");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting");
                items1.add("Teachers");
                items1.add("Bankers");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Self");
                items1.add("Salaried");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_selfProposerOccupation=items1.get(options1);
                        selfProposerOccupation.setText(str_selfProposerOccupation);
                    }
                });
                singlePicker.show(); }
        });

        gender_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_gender=items1.get(options1);
                        edit_gender.setText(str_gender);
                        if (!str_gender.equals("Select Gender")){
                            if (str_edit_dob3String != null) {
//                                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
                                try {
                                    SelectDate = dateFormatter.parse(str_edit_dob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearAdult < 18 || (selectYearAdult > 55)) {
                                    Toast.makeText(Complete_health_member_info.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    edit_dob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        linerOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_occupation=items1.get(options1);
                        edit_occupation.setText(str_occupation);
                        if (!str_occupation.equals("Occupation")){
                            if (str_edit_dob3String != null) {
                                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
                                try {
                                    SelectDate = dateFormatter.parse(str_edit_dob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearAdult < 18 || (selectYearAdult > 55)) {
                                    Toast.makeText(Complete_health_member_info.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    edit_dob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        ftLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_ft=ft.get(options1);
                        edit_ft.setText(str_ft);
                        str_weight_edit=weight_edit.getText().toString();
                        if(!str_ft.equals("Ft") && !str_inches.equals("Inches") && !str_weight_edit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_ft, str_inches);
                            kg = Double.parseDouble(str_weight_edit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEdit) >= 17.5 && Double.parseDouble(strBMIEdit) <= 30.0) {
                                   BMIEdit.setText(strBMIEdit);
                               }else{
                                BMIEdit.setText(strBMIEdit);
                                Toast.makeText(Complete_health_member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_inches=inches.get(options1);
                        edit_inches.setText(str_inches);
                        str_weight_edit=weight_edit.getText().toString();
                        if(!str_ft.equals("Ft") && !str_inches.equals("Inches") && !str_weight_edit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_ft, str_inches);
                            kg = Double.parseDouble(str_weight_edit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEdit) >= 17.5 && Double.parseDouble(strBMIEdit) <= 30.0) {
                                BMIEdit.setText(strBMIEdit);
                            }else{
                                BMIEdit.setText(strBMIEdit);
                                Toast.makeText(Complete_health_member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        weight_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==2){
                    str_weight_edit=weight_edit.getText().toString();
                    if(!str_ft.equals("Ft") && !str_inches.equals("Inches") && !str_weight_edit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_ft, str_inches);
                        kg = Double.parseDouble(str_weight_edit);
                        BMI = calculateBMI(kg, cm);
                        strBMIEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIEdit) >= 17.5 && Double.parseDouble(strBMIEdit) <= 30.0) {
                            BMIEdit.setText(strBMIEdit);
                        }else{
                            BMIEdit.setText(strBMIEdit);
                            Toast.makeText(Complete_health_member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }else if(str_ft.equals("Ft") && str_inches.equals("Inches")){
                        Toast.makeText(Complete_health_member_info.this, "Please Select Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIEdit.setText(strBMIEdit);
                    }else if (str_weight_edit.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Please Enter 1st Adult Weight", Toast.LENGTH_SHORT).show();
                        BMIEdit.setText(strBMIEdit);
                    }else {
                        strBMIEdit=String.format("%.2f", BMI);
                        BMIEdit.setText(strBMIEdit);
                    }
                }
            }
        });


        //2nd adult
        spouseGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_spouse_gender=items1.get(options1);
                        spouse_gender_spinner.setText(str_spouse_gender);
                        if (!str_spouse_gender.equals("Select Gender")){
                            if (str_edit_dob3StringSpouse != null) {
                                try {
                                    SelectDate = dateFormatter.parse(str_spouse_edit_dob_dob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearSecondAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 55)) {
                                    Toast.makeText(Complete_health_member_info.this, "2nd Adult Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    spouse_edit_dob.setText("");
                                }
//                                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                                if (dateValidation <= 17 || (dateValidation >= 56)) {
//                                    Toast.makeText(Complete_health_member_info.this, "2nd Adult Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
//                                    spouse_edit_dob.setText("");
//                                }
                            }
                        }

                    }
                });
                singlePicker.show(); }
        });
        spouseOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Occupation");
                items1.add("Doctors");
                items1.add("Lawyers");
                items1.add("Accounts");
                items1.add("Architects");
                items1.add("Consulting engineers");
                items1.add("Teachers");
                items1.add("Administrative Function and persons primarily engaged in occupation of similar Hazard");
                items1.add("Bankers Persons engaged in clerical function");
                items1.add("Bureaucrats");
                items1.add("Housewife");
                items1.add("Student");
                items1.add("Shopkeeper");
                items1.add("Writer");
                items1.add("Fashion Designer");
                items1.add("Desk job");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_spouse_occupation_spinner=items1.get(options1);
                        spouse_occupation_spinner.setText(str_spouse_occupation_spinner);
                        if (!str_spouse_occupation_spinner.equals("Occupation")){
                            if (str_edit_dob3StringSpouse != null) {
                                try {
                                    SelectDate = dateFormatter.parse(str_spouse_edit_dob_dob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearSecondAdult = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 55)) {
                                    Toast.makeText(Complete_health_member_info.this, "2nd Adult Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                                    spouse_edit_dob.setText("");
                                }
                            }
                        }

                    }
                });
                singlePicker.show();
            }
        });
        spouseFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                      str_spouse_ft_spinner=ft.get(options1);
                        spouse_ft_spinner.setText(str_spouse_ft_spinner);
                    str_spouse_weight_edit=spouse_weight_edit.getText().toString();
                    if(!str_spouse_ft_spinner.equals("Ft") && !str_spouse_inches_spinner.equals("Inches") && !str_spouse_weight_edit.equals("")) {
                    cm = convertFeetandInchesToCentimeter(str_spouse_ft_spinner, str_spouse_inches_spinner);
                    kg = Double.parseDouble(str_spouse_weight_edit);
                    BMI = calculateBMI(kg, cm);
                    strBMIAdultOneEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIAdultOneEdit) >= 17.5 && Double.parseDouble(strBMIAdultOneEdit) <= 30.0) {
                            BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                        }else{
                            BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                            Toast.makeText(Complete_health_member_info.this, "2nd Adult Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                     }
                    }
                });
                singlePicker.show(); }
        });
        spouseInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_spouse_inches_spinner=inches.get(options1);
                        spouse_inches_spinner.setText(str_spouse_inches_spinner);
                        str_spouse_weight_edit=spouse_weight_edit.getText().toString();
                        if(!str_spouse_ft_spinner.equals("Ft") && !str_spouse_inches_spinner.equals("Inches") && !str_spouse_weight_edit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_spouse_ft_spinner, str_spouse_inches_spinner);
                            kg = Double.parseDouble(str_spouse_weight_edit);
                            BMI = calculateBMI(kg, cm);
                            strBMIAdultOneEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIAdultOneEdit) >= 17.5 && Double.parseDouble(strBMIAdultOneEdit) <= 30.0) {
                                BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                            }else{
                                BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                                Toast.makeText(Complete_health_member_info.this, "2nd Adult Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        spouse_weight_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==2){
                    str_spouse_weight_edit=spouse_weight_edit.getText().toString();
                    if(!str_spouse_ft_spinner.equals("Ft") && !str_spouse_inches_spinner.equals("Inches") && !str_spouse_weight_edit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_spouse_ft_spinner, str_spouse_inches_spinner);
                        kg = Double.parseDouble(str_spouse_weight_edit);
                        BMI = calculateBMI(kg, cm);
                        strBMIAdultOneEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIAdultOneEdit) >= 17.5 && Double.parseDouble(strBMIAdultOneEdit) <= 30.0) {
                            BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                        }else{
                            BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                            Toast.makeText(Complete_health_member_info.this, "2nd Adult Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }else if(str_spouse_ft_spinner.equals("Ft") && str_spouse_inches_spinner.equals("Inches")){
                        Toast.makeText(Complete_health_member_info.this, "Please Select 2nd Adult Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                    }else if (str_spouse_weight_edit.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Please Enter 2nd Adult Weight", Toast.LENGTH_SHORT).show();
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                    }else {
                        strBMIAdultOneEdit=String.format("%.2f", BMI);
                        BMIAdultOneEdit.setText(strBMIAdultOneEdit);
                    }
                }
            }
        });

      //1st child
        ChildOneGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_oneGenderSpinner=items1.get(options1);
                        oneGenderSpinner.setText(str_oneGenderSpinner);
                        if (!str_oneGenderSpinner.equals("Select Gender")){
                            if (strChildOne != null) {
                                try {
                                    SelectDate = dateFormatter.parse(strOneChild);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearChild = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearChild < 1 || (selectYearChild > 25)) {
                                    Toast.makeText(Complete_health_member_info.this, "1st Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                                    OneDob.setText("");
                                }

//                                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
//                                if (dateValidation <= 0 || (dateValidation >=26)) {
//                                    Toast.makeText(Complete_health_member_info.this, "1st Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                                }
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerFtChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                str_oneFtSpinner=ft.get(options1);
                oneFtSpinner.setText(str_oneFtSpinner);
                str_oneWeightEdit=oneWeightEdit.getText().toString();
                if(!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                    cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                    kg = Double.parseDouble(str_oneWeightEdit);
                    BMI = calculateBMI(kg, cm);
                    strBMIChildEdit=String.format("%.2f", BMI);
                    if (Double.parseDouble(strBMIChildEdit) >= 17.5 && Double.parseDouble(strBMIChildEdit) <= 30.0) {
                        BMIChildEdit.setText(strBMIChildEdit);
                    }else{
                        BMIChildEdit.setText(strBMIChildEdit);
                        Toast.makeText(Complete_health_member_info.this, "1st child Weight is not normal", Toast.LENGTH_SHORT).show();
                    }
                     }
                    }
                });
                singlePicker.show(); }
        });
        LinerInchesChildOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_oneInchesSpinner=inches.get(options1);
                        oneInchesSpinner.setText(str_oneInchesSpinner);
                        str_oneWeightEdit=oneWeightEdit.getText().toString();
                        if(!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                            kg = Double.parseDouble(str_oneWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIChildEdit) >= 17.5 && Double.parseDouble(strBMIChildEdit) <= 30.0) {
                                BMIChildEdit.setText(strBMIChildEdit);
                            }else{
                                BMIChildEdit.setText(strBMIChildEdit);
                                Toast.makeText(Complete_health_member_info.this, "1st child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        oneWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==2){
                    str_oneWeightEdit=oneWeightEdit.getText().toString();
                    if(!str_oneFtSpinner.equals("Ft") && !str_oneInchesSpinner.equals("Inches") && !str_oneWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                        kg = Double.parseDouble(str_oneWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIChildEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIChildEdit) >= 17.5 && Double.parseDouble(strBMIChildEdit) <= 30.0) {
                            BMIChildEdit.setText(strBMIChildEdit);
                        }else{
                            BMIChildEdit.setText(strBMIChildEdit);
                            Toast.makeText(Complete_health_member_info.this, "1st child Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_oneFtSpinner.equals("Ft") && str_oneInchesSpinner.equals("Inches")){
                        Toast.makeText(Complete_health_member_info.this, "Please Select 1st Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIChildEdit.setText(strBMIChildEdit);
                    }else if (str_oneWeightEdit.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Please Enter 1st Child Weight", Toast.LENGTH_SHORT).show();
                        BMIChildEdit.setText(strBMIChildEdit);
                    }else {
                        strBMIChildEdit=String.format("%.2f", BMI);
                        BMIChildEdit.setText(strBMIChildEdit);
                    }
                }
            }
        });

        //2nd child
        childTwoGenderLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_twoGenderSpinner=items1.get(options1);
                        twoGenderSpinner.setText(str_twoGenderSpinner);
                        if (!str_twoGenderSpinner.equals("Select Gender")){
                            if (strChildTwo != null){
                                try {
                                    SelectDate = dateFormatter.parse(strtwoDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearChildTwo = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                }
                                catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearChildTwo < 1 || (selectYearChildTwo > 25)) {
                                    Toast.makeText(Complete_health_member_info.this, "2nd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                                    twoDob.setText("");
                                }
//                                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
//                                if (dateValidation <= 0 || (dateValidation >=26)) {
//                                    Toast.makeText(Complete_health_member_info.this, "2nd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                                }
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerChildTwoFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_twoFtSpinner=ft.get(options1);
                        twoFtSpinner.setText(str_twoFtSpinner);
                        strtwoWeightEdit=twoWeightEdit.getText().toString();
                        if(!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                            kg = Double.parseDouble(strtwoWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildTwoEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIChildTwoEdit) >= 17.5 && Double.parseDouble(strBMIChildTwoEdit) <= 30.0) {
                                BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                            }else{
                                BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                                Toast.makeText(Complete_health_member_info.this, "2nd child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerChildTwoInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_twoInchesSpinner=inches.get(options1);
                        twoInchesSpinner.setText(str_twoInchesSpinner);
                        strtwoWeightEdit=twoWeightEdit.getText().toString();
                        if(!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                            kg = Double.parseDouble(strtwoWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIChildTwoEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIChildTwoEdit) >= 17.5 && Double.parseDouble(strBMIChildTwoEdit) <= 30.0) {
                                BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                            }else{
                                BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                                Toast.makeText(Complete_health_member_info.this, "2nd child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        twoWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==2){
                    strtwoWeightEdit=twoWeightEdit.getText().toString();
                    if(!str_twoFtSpinner.equals("Ft") && !str_twoInchesSpinner.equals("Inches") && !strtwoWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                        kg = Double.parseDouble(strtwoWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIChildTwoEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIChildTwoEdit) >= 17.5 && Double.parseDouble(strBMIChildTwoEdit) <= 30.0) {
                            BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                        }else{
                            BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                            Toast.makeText(Complete_health_member_info.this, "2nd child Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }else if(str_twoFtSpinner.equals("Ft") && str_twoInchesSpinner.equals("Inches")){
                        Toast.makeText(Complete_health_member_info.this, "Please Select 2nd Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    }else if (strtwoWeightEdit.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Please Enter 2nd Child Weight", Toast.LENGTH_SHORT).show();
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    }else {
                        strBMIChildTwoEdit=String.format("%.2f", BMI);
                        BMIChildTwoEdit.setText(strBMIChildTwoEdit);
                    }
                }
            }
        });

        //3rd child
        thirdLinerGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_thirdGenderSpinner=items1.get(options1);
                        thirdGenderSpinner.setText(str_thirdGenderSpinner);
                        if (!str_thirdGenderSpinner.equals("Select Gender")){
                            if (strChildThree != null){
                                try {
                                    SelectDate = dateFormatter.parse(strthreeDob);
                                    CurrentDate = dateFormatter.parse(today);
                                    long selectNewDate = SelectDate.getTime();
                                    long TodayendDate = CurrentDate.getTime();
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                        selectYearChildThird = period.getYears();
                                        SelectMonth = period.getMonths();
                                        SelectDays = period.getDays();
                                    }
                                }
                                catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (selectYearChildThird < 1 || (selectYearChildThird > 25)) {
                                    Toast.makeText(Complete_health_member_info.this, "3rd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                                    thirdDob.setText("");
                                }
//                                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
//                                if (dateValidation <= 0 || (dateValidation >=26)) {
//                                    Toast.makeText(Complete_health_member_info.this, "3rd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                                }
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerFtThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_thirdFtSpinner=ft.get(options1);
                        thirdFtSpinner.setText(str_thirdFtSpinner);
                        str_thirdWeightEdit=thirdWeightEdit.getText().toString();
                if(!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                    cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                    kg = Double.parseDouble(str_thirdWeightEdit);
                    BMI = calculateBMI(kg, cm);
                    strBMIEChildThreeEdit=String.format("%.2f", BMI);
                    if (Double.parseDouble(strBMIEChildThreeEdit) >= 17.5 && Double.parseDouble(strBMIEChildThreeEdit) <= 30.0) {
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    }else{
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                        Toast.makeText(Complete_health_member_info.this, "3rd child Weight is not normal", Toast.LENGTH_SHORT).show();
                    }

                     }
                    }
                });
                singlePicker.show(); }
        });
        thirdInchesLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_thirdInchesSpinner=inches.get(options1);
                        thirdInchesSpinner.setText(str_thirdInchesSpinner);
                        str_thirdWeightEdit=thirdWeightEdit.getText().toString();
                        if(!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                            kg = Double.parseDouble(str_thirdWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIEChildThreeEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIEChildThreeEdit) >= 17.5 && Double.parseDouble(strBMIEChildThreeEdit) <= 30.0) {
                                BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                            }else{
                                BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                                Toast.makeText(Complete_health_member_info.this, "3rd child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        thirdWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==2){
                    str_thirdWeightEdit=thirdWeightEdit.getText().toString();
                    if(!str_thirdFtSpinner.equals("Ft") && !str_thirdInchesSpinner.equals("Inches") && !str_thirdWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                        kg = Double.parseDouble(str_thirdWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIEChildThreeEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIEChildThreeEdit) >= 17.5 && Double.parseDouble(strBMIEChildThreeEdit) <= 30.0) {
                            BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                        }else{
                            BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                            Toast.makeText(Complete_health_member_info.this, "3rd child Weight is not normal", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(str_thirdFtSpinner.equals("Ft") && str_thirdInchesSpinner.equals("Inches")){
                        Toast.makeText(Complete_health_member_info.this, "Please Select 3rd Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    }else if (str_thirdWeightEdit.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Please Enter 3rd Child Weight", Toast.LENGTH_SHORT).show();
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    }else {
                        strBMIEChildThreeEdit=String.format("%.2f", BMI);
                        BMIEChildThreeEdit.setText(strBMIEChildThreeEdit);
                    }
                }
            }
        });

        //4th child
        LinerGenderFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> items1 = new ArrayList<String>();
                items1.add("Select Gender");
                items1.add("Male");
                items1.add("Female");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_fourGenderSpinner=items1.get(options1);
                        fourGenderSpinner.setText(str_fourGenderSpinner);
                      if (!str_fourGenderSpinner.equals("Select Gender")){
                        if (strChildFour != null){
                            try {
                                SelectDate = dateFormatter.parse(strfourDob);
                                CurrentDate = dateFormatter.parse(today);
                                long selectNewDate = SelectDate.getTime();
                                long TodayendDate = CurrentDate.getTime();
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                    selectYearChildFour = period.getYears();
                                    SelectMonth = period.getMonths();
                                    SelectDays = period.getDays();
                                }
                            }
                            catch (ParseException e) {
                                e.printStackTrace();
                            }
                            if (selectYearChildFour < 1 || (selectYearChildFour > 25)) {
                                Toast.makeText(Complete_health_member_info.this, "4th Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                                    fourDob.setText("");
                            }
//                      int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildFour);
//                            if (dateValidation <= 0 || (dateValidation >=26)) {
//                             Toast.makeText(Complete_health_member_info.this, "4th Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                        }
                          }
                         }
                    }
                });
                singlePicker.show(); }
        });
        LinerFtFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> ft = new ArrayList<String>();
                ft.add("Ft");ft.add("0");ft.add("1");ft.add("2");ft.add("3");ft.add("4");ft.add("5");ft.add("6");ft.add("7");ft.add("8");
                singlePicker.setPicker(ft);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_fourFtSpinner=ft.get(options1);
                        fourFtSpinner.setText( str_fourFtSpinner);
                        strFourWeightEdit=FourWeightEdit.getText().toString();
                        if(!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                            kg = Double.parseDouble(strFourWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIFourChildEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIFourChildEdit) >= 17.5 && Double.parseDouble(strBMIFourChildEdit) <= 30.0) {
                                BMIFourChildEdit.setText(strBMIFourChildEdit);
                            }else{
                                BMIFourChildEdit.setText(strBMIFourChildEdit);
                                Toast.makeText(Complete_health_member_info.this, "4th child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        LinerInchesFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOptionsPickerView singlePicker = new MyOptionsPickerView(Complete_health_member_info.this);
                final ArrayList<String> inches = new ArrayList<String>();
                inches.add("Inches");inches.add("0");inches.add("1");inches.add("2");inches.add("3");inches.add("4");inches.add("5");inches.add("6");inches.add("7");inches.add("8");inches.add("9");inches.add("10");inches.add("11");
                singlePicker.setPicker(inches);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        str_fourInchesSpinner=inches.get(options1);
                        fourInchesSpinner.setText(str_fourInchesSpinner);
                        strFourWeightEdit=FourWeightEdit.getText().toString();
                        if(!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                            cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                            kg = Double.parseDouble(strFourWeightEdit);
                            BMI = calculateBMI(kg, cm);
                            strBMIFourChildEdit=String.format("%.2f", BMI);
                            if (Double.parseDouble(strBMIFourChildEdit) >= 17.5 && Double.parseDouble(strBMIFourChildEdit) <= 30.0) {
                                BMIFourChildEdit.setText(strBMIFourChildEdit);
                            }else{
                                BMIFourChildEdit.setText(strBMIFourChildEdit);
                                Toast.makeText(Complete_health_member_info.this, "4th child Weight is not normal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                singlePicker.show(); }
        });
        FourWeightEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()==2){
                    strFourWeightEdit=FourWeightEdit.getText().toString();
                    if(!str_fourFtSpinner.equals("Ft") && !str_fourInchesSpinner.equals("Inches") && !strFourWeightEdit.equals("")) {
                        cm = convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                        kg = Double.parseDouble(strFourWeightEdit);
                        BMI = calculateBMI(kg, cm);
                        strBMIFourChildEdit=String.format("%.2f", BMI);
                        if (Double.parseDouble(strBMIFourChildEdit) >= 17.5 && Double.parseDouble(strBMIFourChildEdit) <= 30.0) {
                            BMIFourChildEdit.setText(strBMIFourChildEdit);
                        }else{
                            BMIFourChildEdit.setText(strBMIFourChildEdit);
                            Toast.makeText(Complete_health_member_info.this, "4th child Weight is not normal", Toast.LENGTH_SHORT).show();
                        }                    }else if(str_fourFtSpinner.equals("Ft") && str_fourInchesSpinner.equals("Inches")){
                        Toast.makeText(Complete_health_member_info.this, "Please Select 4th Child Ft & Inches", Toast.LENGTH_SHORT).show();
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    }else if (strFourWeightEdit.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Please Enter 4th Child Weight", Toast.LENGTH_SHORT).show();
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    }else {
                        strBMIFourChildEdit=String.format("%.2f", BMI);
                        BMIFourChildEdit.setText(strBMIFourChildEdit);
                    }
                }
            }
        });

        proposer_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_family_individual = String.valueOf(yesNo[i]);
                if (str_family_individual.equals("Yes")){
                    proposer_liner.setVisibility(View.GONE);
                }else {
                    proposer_liner.setVisibility(View.VISIBLE);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
//         proposer_self_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                str_proposer_self_spinner = String.valueOf(relation_with_insure[i]);
//
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });


//        oneOccupationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                str_oneOccupationSpinner= String.valueOf(occupation[i]);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });

//        twoOccupationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                str_twoOccupationSpinner= String.valueOf(occupation[i]);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
//        thirdOccupationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                str_thirdOccupationSpinner= String.valueOf(occupation[i]);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
//        fourOccupationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                str_fourOccupationSpinner= String.valueOf(occupation[i]);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });


        selfProposerDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderProposer();


            }
        });

        edit_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    showCalender();
                }


            }
        });

        spouse_edit_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderspouse();
            }
        });
        OneDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderchild();
            }
        });

        twoDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalendertwochild();
            }
        });
        thirdDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderthreechild();
            }
        });
        fourDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderfourchild();
            }
        });




        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Individual_BMI=0.0;
                twoAdult_BMI=0.0;
                str_edt_name=edt_name.getText().toString();
                str_edit_dob=edit_dob.getText().toString();
                str_weight_edit=weight_edit.getText().toString();
                str_spouse_edit_dob_dob=spouse_edit_dob.getText().toString();
                str_edt_Spouse_name=edt_Spouse_name.getText().toString();
                str_spouse_weight_edit=spouse_weight_edit.getText().toString();
                str_OneEditName=OneEditName.getText().toString();
                str_twoChildEditName=twoChildEditName.getText().toString();
                str_thirdNameEdit=thirdNameEdit.getText().toString();
                str_fourNameEdit=fourNameEdit.getText().toString();
                str_oneWeightEdit=oneWeightEdit.getText().toString();
                strOneChild=OneDob.getText().toString();
                strtwoDob=twoDob.getText().toString();
                strtwoWeightEdit=twoWeightEdit.getText().toString();
                str_thirdWeightEdit=thirdWeightEdit.getText().toString();
                strthreeDob=thirdDob.getText().toString();
                strFourWeightEdit=FourWeightEdit.getText().toString();
                strfourDob=fourDob.getText().toString();

                if (str_policyType_spinner.equals("Individual")){
                    if (str_edt_name.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                    }else if(str_edit_dob.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                    } else if (str_gender.equals("Select Gender")){
                        Toast.makeText(Complete_health_member_info.this, "Select Gender", Toast.LENGTH_SHORT).show();
                    }else if (str_occupation.equals("Occupation")){
                        Toast.makeText(Complete_health_member_info.this, "Select Occupation", Toast.LENGTH_SHORT).show();
                    } else if(str_ft.equals("Ft") && str_inches.equals("Inches")){
                        Toast.makeText(Complete_health_member_info.this, "Enter Ft & Inches", Toast.LENGTH_SHORT).show();
                    }else if (str_weight_edit.equals("")){
                        Toast.makeText(Complete_health_member_info.this, "Enter Weight in Kg", Toast.LENGTH_SHORT).show();
                    } else {
                        if (str_edit_dob3String != null){
                            try {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                                SelectDate = dateFormat.parse(str_edit_dob);
                                CurrentDate = dateFormat.parse(today);
                                long selectNewDate = SelectDate.getTime();
                                long TodayendDate = CurrentDate.getTime();
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                                    selectYearAdult = period.getYears();
                                    SelectMonth = period.getMonths();
                                    SelectDays = period.getDays();
                                }
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            if (selectYearAdult < 18 || (selectYearAdult > 55)) {
                                Toast.makeText(Complete_health_member_info.this, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                            }else if(!str_ft.equals("Ft") && !str_inches.equals("Inches")) {
                                cm=convertFeetandInchesToCentimeter(str_ft, str_inches);
                                kg= Double.parseDouble(str_weight_edit);
                                BMI=calculateBMI(kg,cm);
                                if (BMI!=0.0){
                                    if (BMI < 17.5) {
                                        Toast.makeText(Complete_health_member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                    else if (BMI >= 17.5 && BMI <= 30.0) {
                                        Intent intent=new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
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
                                        intent.putExtra("str_weight_edit",str_weight_edit);
                                        intent.putExtra("str_edit_dob3String",str_edit_dob3String);
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
                                        intent.putExtra("str_twoChildEditName",str_twoChildEditName);
                                        intent.putExtra("str_thirdNameEdit",str_thirdNameEdit);
                                        intent.putExtra("str_fourNameEdit",str_fourNameEdit);
                                        intent.putExtra("TotalValue",TotalValue);
                                        intent.putExtra("strPriceTotal",strPriceTotal);
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
                                        intent.putExtra("GST",GST);
                                        intent.putExtra("strOneChild",strOneChild);
                                        intent.putExtra("strtwoDob",strtwoDob);
                                        intent.putExtra("strthreeDob",strthreeDob);
                                        intent.putExtra("strfourDob",strfourDob);
                                        intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
                                        intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
                                        intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
                                        intent.putExtra("strFourWeightEdit",strFourWeightEdit);
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
                                        intent.putExtra("PD_Status",PD_Status);
                                        intent.putExtra("ESaleDiscount",ESaleDiscount);
                                        intent.putExtra("LongTermDiscount",LongTermDiscount);
                                        intent.putExtra("nextYear",nextYear);
                                        intent.putExtra("tomorrowDate",tomorrowDate);
                                        intent.putExtra("new_str_age",new_str_age);
                                        intent.putExtra("strSumInsuredTpeEDit",strSumInsuredTpeEDit);
                                        intent.putExtra("BI_Status",BI_Status);
                                        intent.putExtra("BI_Status1",BI_Status1);
                                        intent.putExtra("BI_Status2",BI_Status2);
                                        intent.putExtra("BI_Status3",BI_Status3);
                                        intent.putExtra("BI_Status4",BI_Status4);
                                        intent.putExtra("BI_Status5",BI_Status5);
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
//                                    else if (BMI >= 24.9 && BMI < 30) {
//                                        Toast.makeText(Complete_health_member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
//                                    }
                                    else if (BMI > 30) {
                                        Toast.makeText(Complete_health_member_info.this, "Weight is not normal", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
               }else {
                    if(str_IndividualTypeEdit.equals("2 Adult")){
                          str_spouse_edit_dob_dob = spouse_edit_dob.getText().toString();
                           str_edt_Spouse_name = edt_Spouse_name.getText().toString();
                           str_spouse_weight_edit = spouse_weight_edit.getText().toString();
                           str_OneEditName = OneEditName.getText().toString();
                           str_twoChildEditName = twoChildEditName.getText().toString();
                           str_thirdNameEdit = thirdNameEdit.getText().toString();
                           str_fourNameEdit = fourNameEdit.getText().toString();
                           if (str_edt_name.equals("")) {
                               Toast.makeText(Complete_health_member_info.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                           } else if (str_edit_dob.equals("")) {
                               Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                           } else if (str_gender.equals("Select Gender")) {
                               Toast.makeText(Complete_health_member_info.this, "Select Gender", Toast.LENGTH_SHORT).show();
                           } else if (str_occupation.equals("Occupation")) {
                               Toast.makeText(Complete_health_member_info.this, "Select Occupation", Toast.LENGTH_SHORT).show();
                           } else if (str_ft.equals("Ft") && str_inches.equals("Inches")) {
                               Toast.makeText(Complete_health_member_info.this, "Enter Ft & Inches", Toast.LENGTH_SHORT).show();
                           } else if (str_weight_edit.equals("")) {
                               Toast.makeText(Complete_health_member_info.this, "Enter Weight in Kg", Toast.LENGTH_SHORT).show();
                           }else if (str_edt_Spouse_name.equals("")){
                               Toast.makeText(Complete_health_member_info.this, "Enter 2nd Adult Name", Toast.LENGTH_SHORT).show();
                           }else if(str_spouse_edit_dob_dob.equals("")){
                               Toast.makeText(Complete_health_member_info.this, "Enter 2nd Adult Date of Birth", Toast.LENGTH_SHORT).show();
                           }else if (str_spouse_gender.equals("Select Gender")){
                               Toast.makeText(Complete_health_member_info.this, "Select 2nd Adult Gender", Toast.LENGTH_SHORT).show();

                           }else if (str_spouse_occupation_spinner.equals("Occupation")){
                               Toast.makeText(Complete_health_member_info.this, "Select 2nd Adult Occupation", Toast.LENGTH_SHORT).show();

                           }else if (str_spouse_ft_spinner.equals("Ft")){
                               Toast.makeText(Complete_health_member_info.this, "Select 2nd Adult Ft", Toast.LENGTH_SHORT).show();

                           }else if (str_spouse_inches_spinner.equals("Inches")){
                               Toast.makeText(Complete_health_member_info.this, "Select 2nd Adult Inches", Toast.LENGTH_SHORT).show();

                           }else if (str_spouse_weight_edit.equals("")){
                               Toast.makeText(Complete_health_member_info.this, "Enter 2nd Adult Weight in Kg", Toast.LENGTH_SHORT).show();
                           }else {
                               Individual_BMI = calculation(str_edt_name, str_gender, str_occupation, str_edit_dob, str_ft, str_inches, str_weight_edit, str_edit_dob3String, strThirdDString,selectYearAdult, getApplicationContext());
                               twoAdult_BMI = calculationAdult(str_edt_Spouse_name, str_spouse_edit_dob_dob, str_spouse_gender, str_spouse_occupation_spinner, str_spouse_ft_spinner, str_spouse_inches_spinner, str_spouse_weight_edit, str_edit_dob3StringSpouse, strThirdDString, selectYearSecondAdult,getApplicationContext());
                               if (Individual_BMI != 0.0 && twoAdult_BMI != 0.0) {
                                   if (Individual_BMI < 17.5) {
                                       Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                   } else if (twoAdult_BMI < 17.5) {
                                       Toast.makeText(Complete_health_member_info.this, "2nd Adult  weight is not normal", Toast.LENGTH_SHORT).show();
                                   } else if (Individual_BMI >= 17.5 && Individual_BMI <= 30.0 && twoAdult_BMI >= 17.5 && twoAdult_BMI <= 30.0) {
                                       Intent intent = new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
                                       intent.putExtra("str_edt_name", str_edt_name);
                                       intent.putExtra("str_edt_phone", str_edt_phone);
                                       intent.putExtra("str_email", str_email);
                                       intent.putExtra("str_age", str_age);
                                       intent.putExtra("str_reference_no", str_reference_no);
                                       intent.putExtra("str_edit_dob", str_edit_dob);
                                       intent.putExtra("str_edit_dob3String", str_edit_dob3String);
                                       intent.putExtra("str_gender", str_gender);
                                       intent.putExtra("str_occupation", str_occupation);
                                       intent.putExtra("str_ft", str_ft);
                                       intent.putExtra("str_inches", str_inches);
                                       intent.putExtra("str_weight_edit", str_weight_edit);
                                       intent.putExtra("str_edt_Spouse_name", str_edt_Spouse_name);
                                       intent.putExtra("str_spouse_edit_dob_dob", str_spouse_edit_dob_dob);
                                       intent.putExtra("str_spouse_gender", str_spouse_gender);
                                       intent.putExtra("str_spouse_occupation_spinner", str_spouse_occupation_spinner);
                                       intent.putExtra("str_spouse_ft_spinner", str_spouse_ft_spinner);
                                       intent.putExtra("str_spouse_inches_spinner", str_spouse_inches_spinner);
                                       intent.putExtra("str_spouse_weight_edit", str_spouse_weight_edit);
                                       intent.putExtra("str_policyType_spinner", str_policyType_spinner);
                                       intent.putExtra("str_SumInsured", str_SumInsured);
                                       intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
                                       intent.putExtra("str_twoChildEditName", str_twoChildEditName);
                                       intent.putExtra("str_thirdNameEdit", str_thirdNameEdit);
                                       intent.putExtra("str_fourNameEdit", str_fourNameEdit);
                                       intent.putExtra("TotalValue", TotalValue);
                                       intent.putExtra("str_policyType_spinner", str_policyType_spinner);
                                       intent.putExtra("str_IndividualTypeEdit", str_IndividualTypeEdit);
                                       intent.putExtra("str_SumInsured", str_SumInsured);
                                       intent.putExtra("strFirstTString", strFirstTString);
                                       intent.putExtra("PosPolicyNo", PosPolicyNo);
                                       intent.putExtra("strChildOne", strChildOne);
                                       intent.putExtra("strChildTwo", strChildTwo);
                                       intent.putExtra("strChildThree", strChildThree);
                                       intent.putExtra("strChildFour", strChildFour);
                                       intent.putExtra("strOneChild", strOneChild);
                                       intent.putExtra("strtwoDob", strtwoDob);
                                       intent.putExtra("strthreeDob", strthreeDob);
                                       intent.putExtra("strfourDob", strfourDob);
                                       intent.putExtra("str_oneWeightEdit", str_oneWeightEdit);
                                       intent.putExtra("strtwoWeightEdit", strtwoWeightEdit);
                                       intent.putExtra("str_thirdWeightEdit", str_thirdWeightEdit);
                                       intent.putExtra("strFourWeightEdit", strFourWeightEdit);
                                       intent.putExtra("NetPremiumValue", NetPremiumValue);
                                       intent.putExtra("strPriceTotal", strPriceTotal);
                                       intent.putExtra("GST", GST);
                                       intent.putExtra("str_RelationEdit", str_RelationEdit);
                                       intent.putExtra("strRelationAdultOneEdit", strRelationAdultOneEdit);
                                       intent.putExtra("strRelationChildEdit", strRelationChildEdit);
                                       intent.putExtra("strRelationChildTwoEdit", strRelationChildTwoEdit);
                                       intent.putExtra("strRelationChildThreeEdit", strRelationChildThreeEdit);
                                       intent.putExtra("strRelationFourChildEdit", strRelationFourChildEdit);
                                       intent.putExtra("strNominee_dob", strNominee_dob);
                                       intent.putExtra("strBMIEdit", strBMIEdit);
                                       intent.putExtra("strBMIAdultOneEdit", strBMIAdultOneEdit);
                                       intent.putExtra("strBMIChildEdit", strBMIChildEdit);
                                       intent.putExtra("strBMIChildTwoEdit", strBMIChildTwoEdit);
                                       intent.putExtra("strBMIEChildThreeEdit", strBMIEChildThreeEdit);
                                       intent.putExtra("strBMIFourChildEdit", strBMIFourChildEdit);
                                       intent.putExtra("str_oneGenderSpinner", str_oneGenderSpinner);
                                       intent.putExtra("str_oneFtSpinner", str_oneFtSpinner);
                                       intent.putExtra("str_oneInchesSpinner", str_oneInchesSpinner);
                                       intent.putExtra("str_twoGenderSpinner", str_twoGenderSpinner);
                                       intent.putExtra("str_twoFtSpinner", str_twoFtSpinner);
                                       intent.putExtra("str_twoInchesSpinner", str_twoInchesSpinner);
                                       intent.putExtra("str_thirdGenderSpinner", str_thirdGenderSpinner);
                                       intent.putExtra("str_thirdFtSpinner", str_thirdFtSpinner);
                                       intent.putExtra("str_thirdInchesSpinner", str_thirdInchesSpinner);
                                       intent.putExtra("str_fourGenderSpinner", str_fourGenderSpinner);
                                       intent.putExtra("str_fourFtSpinner", str_fourFtSpinner);
                                       intent.putExtra("str_fourInchesSpinner", str_fourInchesSpinner);
                                       intent.putExtra("PD_Status", PD_Status);
                                       intent.putExtra("ESaleDiscount", ESaleDiscount);
                                       intent.putExtra("LongTermDiscount", LongTermDiscount);
                                       intent.putExtra("nextYear", nextYear);
                                       intent.putExtra("tomorrowDate", tomorrowDate);
                                       intent.putExtra("strSumInsuredTpeEDit", strSumInsuredTpeEDit);
                                       intent.putExtra("new_str_age", new_str_age);
                                       intent.putExtra("BI_Status",BI_Status);
                                       intent.putExtra("BI_Status1",BI_Status1);
                                       intent.putExtra("BI_Status2",BI_Status2);
                                       intent.putExtra("BI_Status3",BI_Status3);
                                       intent.putExtra("BI_Status4",BI_Status4);
                                       intent.putExtra("BI_Status5",BI_Status5);
                                       intent.putExtra("selectYearAdult",selectYearAdult);
                                       intent.putExtra("selectYearSecondAdult",selectYearSecondAdult);
                                       intent.putExtra("selectYearChild",selectYearChild);
                                       intent.putExtra("selectYearChildTwo",selectYearChildTwo);
                                       intent.putExtra("selectYearChildThird",selectYearChildThird);
                                       intent.putExtra("selectYearChildFour",selectYearChildFour);
                                       intent.putExtra("for", "0");
                                       startActivity(intent);
                                       finish();
                                   }
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                                   else if (Individual_BMI > 30) {
                                       Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                                   } else if (twoAdult_BMI > 30) {
                                       Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                   }
                               }
                           }
                    }
                   else if(str_IndividualTypeEdit.equals("1 Adult + 1 Child")){
                        if(!str_edit_dob.equals("")){
                            Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                            OneChildBMI= calculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                            if (Individual_BMI!=0.0 && OneChildBMI!=0.0){
                                if (Individual_BMI < 17.5) {
                                    Toast.makeText(Complete_health_member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else  if (OneChildBMI < 17.5){
                                    Toast.makeText(Complete_health_member_info.this, "1st Child weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (Individual_BMI >= 17.5 && Individual_BMI <= 30.0 && OneChildBMI >= 17.5 && OneChildBMI <= 30.0) {
                                    Intent intent=new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
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
                                    intent.putExtra("strOneChild",strOneChild);
                                    intent.putExtra("strtwoDob",strtwoDob);
                                    intent.putExtra("strthreeDob",strthreeDob);
                                    intent.putExtra("strfourDob",strfourDob);
                                    intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
                                    intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
                                    intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
                                    intent.putExtra("strFourWeightEdit",strFourWeightEdit);
                                    intent.putExtra("NetPremiumValue",NetPremiumValue);
                                    intent.putExtra("strPriceTotal",strPriceTotal);
                                    intent.putExtra("GST",GST);
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
//                                else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                    Toast.makeText(Complete_health_member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                                } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                    Toast.makeText(Complete_health_member_info.this, "1st Child weight is not normal", Toast.LENGTH_SHORT).show();
//                                }
                                else if (Individual_BMI > 30) {
                                    Toast.makeText(Complete_health_member_info.this, "Adult weight is not normal", Toast.LENGTH_SHORT).show();
                                }else if (OneChildBMI >30) {
                                    Toast.makeText(Complete_health_member_info.this, "1st Child weight is not normal", Toast.LENGTH_SHORT).show();
                                } }
                        }else{
                            Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                        }
                   }
                   else if(str_IndividualTypeEdit.equals("1 Adult + 2 Child")){
                       if(!str_edit_dob.equals("")){
                           Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                           OneChildBMI= calculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                           TwoChildBMI= calculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                           if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                               if (Individual_BMI < 18.5) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               } else  if (OneChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (TwoChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (Individual_BMI >= 17.5 && Individual_BMI <= 30.0 && OneChildBMI >= 17.5 && OneChildBMI <= 30.0 && TwoChildBMI >= 17.5 && TwoChildBMI <= 30.0) {
                                   Intent intent=new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
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
                                   intent.putExtra("strPriceTotal",strPriceTotal);
                                   intent.putExtra("strChildTwo",strChildTwo);
                                   intent.putExtra("strChildThree",strChildThree);
                                   intent.putExtra("strChildFour",strChildFour);
                                   intent.putExtra("NetPremiumValue",NetPremiumValue);
                                   intent.putExtra("strtwoDob",strtwoDob);
                                   intent.putExtra("strOneChild",strOneChild);
                                   intent.putExtra("strtwoDob",strtwoDob);
                                   intent.putExtra("strthreeDob",strthreeDob);
                                   intent.putExtra("strfourDob",strfourDob);
                                   intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
                                   intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
                                   intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
                                   intent.putExtra("strFourWeightEdit",strFourWeightEdit);
                                   intent.putExtra("str_RelationEdit",str_RelationEdit);
                                   intent.putExtra("strRelationAdultOneEdit",strRelationAdultOneEdit);
                                   intent.putExtra("strRelationChildEdit",strRelationChildEdit);
                                   intent.putExtra("strRelationChildTwoEdit",strRelationChildTwoEdit);
                                   intent.putExtra("strRelationChildThreeEdit",strRelationChildThreeEdit);
                                   intent.putExtra("strRelationFourChildEdit",strRelationFourChildEdit);
                                   intent.putExtra("strNominee_dob",strNominee_dob);
                                   intent.putExtra("GST",GST);
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
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                               else if (Individual_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (OneChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (TwoChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               } }
                       }else{
                           Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                       }
                   }
                   else if(str_IndividualTypeEdit.equals("1 Adult + 3 Child")){
                       if(!str_edit_dob.equals("")){
                           Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                           OneChildBMI= calculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                           TwoChildBMI= calculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                           ThreeChildBMI= calculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                           if (Individual_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                               if (Individual_BMI < 18.5) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               } else  if (OneChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (TwoChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (ThreeChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (Individual_BMI >= 17.5 && Individual_BMI <= 30.0 && OneChildBMI >= 17.5 && OneChildBMI <= 30.0 && TwoChildBMI >= 17.5 && TwoChildBMI <= 30.0 && ThreeChildBMI >= 17.5 && ThreeChildBMI <= 30.0) {
                                   Intent intent=new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
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
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                               else if (Individual_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (OneChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (TwoChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               }}else if (ThreeChildBMI > 30) {
                               Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                           } }
                       }
                   else if(str_IndividualTypeEdit.equals("2 Adult + 1 Child")){
                       if(!str_edit_dob.equals("")){
                           Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                           twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                           OneChildBMI= calculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                           if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0){
                               if (Individual_BMI < 17.5) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (twoAdult_BMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (OneChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (Individual_BMI >= 17.5 && Individual_BMI <= 30.0 && twoAdult_BMI >= 17.5 && twoAdult_BMI <= 30.0 && OneChildBMI >= 17.5 && OneChildBMI <= 30.0) {
                                   Intent intent=new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
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
                                   intent.putExtra("str_policyType_spinner",str_policyType_spinner);
                                   intent.putExtra("str_IndividualTypeEdit",str_IndividualTypeEdit);
                                   intent.putExtra("str_SumInsured",str_SumInsured);
                                   intent.putExtra("strFirstTString",strFirstTString);
                                   intent.putExtra("PosPolicyNo",PosPolicyNo);
                                   intent.putExtra("strChildOne",strChildOne);
                                   intent.putExtra("strChildTwo",strChildTwo);
                                   intent.putExtra("strChildThree",strChildThree);
                                   intent.putExtra("strChildFour",strChildFour);
                                   intent.putExtra("strOneChild",strOneChild);
                                   intent.putExtra("strtwoDob",strtwoDob);
                                   intent.putExtra("strthreeDob",strthreeDob);
                                   intent.putExtra("strfourDob",strfourDob);
                                   intent.putExtra("str_oneWeightEdit",str_oneWeightEdit);
                                   intent.putExtra("strtwoWeightEdit",strtwoWeightEdit);
                                   intent.putExtra("str_thirdWeightEdit",str_thirdWeightEdit);
                                   intent.putExtra("strFourWeightEdit",strFourWeightEdit);
                                   intent.putExtra("NetPremiumValue",NetPremiumValue);
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
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                               else if (Individual_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (twoAdult_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (OneChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               } }
                       }else{
                           Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                       }
                   }
                   else if(str_IndividualTypeEdit.equals("2 Adult + 2 Child")){
                       if(!str_edit_dob.equals("")){
                           Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                           twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                           OneChildBMI= calculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                           TwoChildBMI= calculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                           if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0){
                               if (Individual_BMI < 17.5) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (twoAdult_BMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (OneChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (TwoChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (Individual_BMI >= 17.5 && Individual_BMI <= 30.0 && twoAdult_BMI >= 17.5 && twoAdult_BMI <= 30.0 && OneChildBMI >= 17.5 && OneChildBMI <= 30.0 && TwoChildBMI >= 17.5 && TwoChildBMI <= 30.0) {
                                   Intent intent=new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
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
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                               else if (Individual_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (twoAdult_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (OneChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (TwoChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               } }
                       }else{
                           Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                       }
                   }
                   else if(str_IndividualTypeEdit.equals("2 Adult + 3 Child")){
                       if(!str_edit_dob.equals("")){
                           Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                           twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                           OneChildBMI= calculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                           TwoChildBMI= calculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                           ThreeChildBMI= calculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                           if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0){
                               if (Individual_BMI < 17.5) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (twoAdult_BMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (OneChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (TwoChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (ThreeChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (Individual_BMI >= 17.5 && Individual_BMI <= 30.0 && twoAdult_BMI >= 17.5 && twoAdult_BMI <= 30.0 && OneChildBMI >= 17.5 && OneChildBMI <= 30.0 && TwoChildBMI >= 17.5 && TwoChildBMI <= 30.0 && ThreeChildBMI >= 17.5 && ThreeChildBMI <= 30.0) {
                                   Intent intent=new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
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
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Adult 1  weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                               else if (Individual_BMI >30) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (twoAdult_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (OneChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (TwoChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (ThreeChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                               }
                           }
                       }else{
                           Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                       }




                   }
                   else if(str_IndividualTypeEdit.equals("2 Adult + 4 Child")){
                       if(!str_edit_dob.equals("")){
                           Individual_BMI= calculation(str_edt_name,str_gender,str_occupation,str_edit_dob,str_ft,str_inches,str_weight_edit,str_edit_dob3String,strThirdDString,selectYearAdult,getApplicationContext());
                           twoAdult_BMI= calculationAdult(str_edt_Spouse_name,str_spouse_edit_dob_dob,str_spouse_gender,str_spouse_occupation_spinner,str_spouse_ft_spinner,str_spouse_inches_spinner,str_spouse_weight_edit,str_edit_dob3StringSpouse,strThirdDString,selectYearSecondAdult,getApplicationContext());
                           OneChildBMI= calculationOne(str_OneEditName,strOneChild,str_oneGenderSpinner,str_oneOccupationSpinner,str_oneFtSpinner,str_oneInchesSpinner,str_oneWeightEdit,strChildOne,strThirdDString,selectYearChild,getApplicationContext());
                           TwoChildBMI= calculationTwo(str_twoChildEditName,strtwoDob,str_twoGenderSpinner,str_twoOccupationSpinner,str_twoFtSpinner,str_twoInchesSpinner,strtwoWeightEdit,strChildTwo,strThirdDString,selectYearChildTwo,getApplicationContext());
                           ThreeChildBMI= calculationThree(str_thirdNameEdit,strthreeDob,str_thirdGenderSpinner,str_thirdOccupationSpinner,str_thirdFtSpinner,str_thirdInchesSpinner,str_thirdWeightEdit,strChildThree,strThirdDString,selectYearChildThird,getApplicationContext());
                           FourChildBMI= calculationfour(str_fourNameEdit,strfourDob,str_fourGenderSpinner,str_fourOccupationSpinner,str_fourFtSpinner,str_fourInchesSpinner,strFourWeightEdit,strChildFour,strThirdDString,selectYearChildFour,getApplicationContext());
                           if (Individual_BMI!=0.0 && twoAdult_BMI!=0.0 && OneChildBMI!=0.0 && TwoChildBMI!=0.0 && ThreeChildBMI!=0.0 && FourChildBMI!=0.0){
                               if (Individual_BMI < 17.5) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (twoAdult_BMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (OneChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (TwoChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (ThreeChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else  if (FourChildBMI < 17.5){
                                   Toast.makeText(Complete_health_member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (Individual_BMI >= 17.5 && Individual_BMI <= 30.0 && twoAdult_BMI >= 17.5 && twoAdult_BMI <= 30.0 && OneChildBMI >= 17.5 && OneChildBMI <= 30.0 && TwoChildBMI >= 17.5 && TwoChildBMI <= 30.0 && ThreeChildBMI >= 17.5 && ThreeChildBMI <= 30.0 && FourChildBMI >= 17.5 && FourChildBMI <= 30.0) {
                                   Intent intent=new Intent(Complete_health_member_info.this, Medical_Complete_health.class);
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
//                               else if (Individual_BMI >= 24.9 && Individual_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Adult 1  weight is not normal", Toast.LENGTH_SHORT).show();
//                               } else if (twoAdult_BMI >= 24.9 && twoAdult_BMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (OneChildBMI >= 24.9 && OneChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 1weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (TwoChildBMI >= 24.9 && TwoChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (ThreeChildBMI >= 24.9 && ThreeChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }else if (FourChildBMI >= 24.9 && FourChildBMI < 30) {
//                                   Toast.makeText(Complete_health_member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
//                               }
                               else if (Individual_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Adult 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (twoAdult_BMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "2nd Adult weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (OneChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 1 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (TwoChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 2 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (ThreeChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 3 weight is not normal", Toast.LENGTH_SHORT).show();
                               }else if (FourChildBMI > 30) {
                                   Toast.makeText(Complete_health_member_info.this, "Child 4 weight is not normal", Toast.LENGTH_SHORT).show();
                               } }
                       }else{
                           Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                       }




                   }
                   else{
                           Toast.makeText(Complete_health_member_info.this, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
                       }
                }

               }
        });

    }

    private void showCalenderchild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Complete_health_member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strOneChild=dateFormatter.format(newDate.getTime());
            String[] strdDate2=  strOneChild.split("/");
            String strone = strdDate2[0];
            String strtwo = strdDate2[1];
            strChildOne = strdDate2[2];
            OneDob.setText(strOneChild);

            try {
                SelectDate = dateFormatter.parse(strOneChild);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChild= period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (strChildOne != null) {
                if (selectYearChild < 1 || (selectYearChild > 25)) {
                    Toast.makeText(Complete_health_member_info.this, "1st Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                }else{
                    OneDob.setText(strOneChild);
                }
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalendertwochild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Complete_health_member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strtwoDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strtwoDob.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strChildTwo = strDateOB2[2];
            twoDob.setText(strtwoDob);

            try {
                SelectDate = dateFormatter.parse(strtwoDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChildTwo = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (strChildTwo != null) {
                if (selectYearChildTwo < 1 || (selectYearChildTwo > 25)) {
                    Toast.makeText(Complete_health_member_info.this, "2nd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                }else{
                    twoDob.setText(strtwoDob);
                }
            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderthreechild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Complete_health_member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strthreeDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strthreeDob.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strChildThree = strDateOB2[2];
            thirdDob.setText(strthreeDob);
            try {
                SelectDate = dateFormatter.parse(strthreeDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChildThird = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (strChildThree != null) {
                if (selectYearChildThird < 1 || (selectYearChildThird > 25)) {
                    Toast.makeText(Complete_health_member_info.this, "3rd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                }else{
                    thirdDob.setText(strthreeDob);
                }
            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    private void showCalenderfourchild() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Complete_health_member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            strfourDob=dateFormatter.format(newDate.getTime());
            String[] strDateOB2=  strfourDob.split("/");
            String strone = strDateOB2[0];
            String strtwo = strDateOB2[1];
            strChildFour = strDateOB2[2];
            fourDob.setText(strfourDob);

            try {
                SelectDate = dateFormatter.parse(strfourDob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearChildFour = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (strChildFour != null) {
                if (selectYearChildFour < 1 || (selectYearChildFour > 25)) {
                    Toast.makeText(Complete_health_member_info.this, "4th Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
                }else{
                    fourDob.setText(strfourDob);
                }
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }



//    private void health_quote() {
//
//            JSONObject object = new JSONObject();
//            try {
//                object.put("TokenNo", pref.getToken_no());
//                object.put("Uid",pref.getUID());
//                object.put("Plan_Type",str_policyType_spinner);
//                object.put("Floater_Type",str_IndividualTypeEdit);
//                object.put("Sum_Insured",str_SumInsured);
//                object.put("Policy_Duration",strFirstTString);
//                object.put("DOB",str_new_dob);
//                object.put("Proposal_Date",today);
//                object.put("From_Date",tomorrowDate);
//                object.put("To_Date",nextYear);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            ProjectVolleyRequest req = new ProjectVolleyRequest(Complete_health_member_info.this, object, UrlHealthConstants.BUY_HEALTH_CARE_QUOTATION_URL, new ResponseListener() {
//                @Override
//                public void onSuccess(JSONObject object, int Tag) {
//                    if (object.optString("Status").equals("true")) {
//                        if (Tag == RequestHealthConstants.QUOTATION_Complete_URL) {
//                            try {
//                                JSONObject CustomerJsonObject = object.getJSONObject("Customer");
//                                JSONObject ProductJsonObject = object.getJSONObject("Product");
//                                JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
//                                Log.e("gg", String.valueOf(PremiumCalculationJsonObject));
//                                JSONObject NetPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("NetPremium");
//                                JSONObject ServiceTaxJsonObject = PremiumCalculationJsonObject.getJSONObject("ServiceTax");
//                                JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
//                                Log.e("TotalPremium", String.valueOf(TotalPremiumJsonObject));
//                                 NetPremiumValue = NetPremiumJsonObject.getString("Value");
//                                 TotalValue = TotalPremiumJsonObject.getString("Value");
//                                PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
//                                GST = ServiceTaxJsonObject.getString("Value");
//                                Log.e("TotalValue", TotalValue);
//                                totalPremiumAmount.setText(TotalValue);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    } else {
//                        Toast.makeText(getApplication(), "Cannot connect to Internet, please try again later", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                @Override
//                public void onError(VolleyError error, int Tag) {
//
//                }
//            }, RequestHealthConstants.QUOTATION_Complete_URL);
//            req.execute();
//
//        }


    private double calculateBMI(double kg, double cm) {
        double heightMeter= cm/ 100;
         BMI = kg/ (heightMeter * heightMeter);
           Log.e("bmi", String.valueOf(BMI));
        return BMI;
    }
    public double convertFeetandInchesToCentimeter(String feet, String inches) {
        double heightInFeet = 0;
        double heightInInches = 0;
        try {
            if (feet != null && feet.trim().length() != 0) {
                heightInFeet = Double.parseDouble(feet);
            }
            if (inches != null && inches.trim().length() != 0) {
                heightInInches = Double.parseDouble(inches);
            }

        } catch (NumberFormatException nfe) {

        }
         cm=(heightInFeet * 30.48) + (heightInInches * 2.54);
        Log.e("heightInCm", String.valueOf(cm));
        return cm;

    }
    private void showCalenderspouse() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Complete_health_member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            str_spouse_edit_dob_dob=dateFormatter.format(newDate.getTime());
            String[] strdDate1=  str_spouse_edit_dob_dob.split("/");
            String str_edit_dobDString = strdDate1[0];
            String str_edit_dob2String = strdDate1[1];
            str_edit_dob3StringSpouse = strdDate1[2];
            spouse_edit_dob.setText(str_spouse_edit_dob_dob);

            try {
                SelectDate = dateFormatter.parse(str_spouse_edit_dob_dob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearSecondAdult = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (str_for.equals("0")){
                if (str_edit_dob3StringSpouse != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3StringSpouse);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                    if (dateValidation < Integer.parseInt(strFirstString) || (dateValidation > Integer.parseInt(strFourString))) {
                    if (selectYearSecondAdult < Integer.parseInt(strFirstString) || (selectYearSecondAdult > Integer.parseInt(strFourString))) {
                        str_edit_dob=str_spouse_edit_dob_dob;
                        BI_Status="True";
                        BI_Status1="True";
                        health_quote();
                        Toast.makeText(Complete_health_member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        str_edit_dob=str_spouse_edit_dob_dob;
                        BI_Status="True";
                        BI_Status1="True";
                        health_quote();
                    }
                }
            }
            else if (str_for.equals("1")){
                if (str_edit_dob3StringSpouse != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3StringSpouse);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                    if (dateValidation < Integer.parseInt(strFirstString) || (dateValidation > Integer.parseInt(strFourString))) {
                    if (selectYearSecondAdult < Integer.parseInt(strFirstString) || (selectYearSecondAdult > Integer.parseInt(strFourString))) {
                        str_edit_dob=str_spouse_edit_dob_dob;
                        BI_Status="True";
                        BI_Status1="True";
                        health_quote();
                        Toast.makeText(Complete_health_member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        str_edit_dob=str_spouse_edit_dob_dob;
                        BI_Status="True";
                        BI_Status1="True";
                        health_quote();
                    }
                }
            }


//            if (str_for.equals("0")){
//                if (str_edit_dob3StringSpouse != null) {
//                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                    int dateValidationAdult2 = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                    if (dateValidationAdult2 < dateValidation ){
//                    }else if(dateValidationAdult2 >dateValidation) {
//                        str_edit_dob=str_spouse_edit_dob_dob;
//                        BI_Status="True";
//                        BI_Status1="True";
//                        health_quote();
//                        Toast.makeText(Complete_health_member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
//                    }else{
//                        str_edit_dob=str_spouse_edit_dob_dob;
//                        BI_Status="True";
//                        BI_Status1="True";
//                        health_quote();
//                    }
//
//                }
//            }
//            else if (str_for.equals("1")){
//                if (str_edit_dob3StringSpouse != null) {
//                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                    int dateValidationAdult2 = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
//                    if (dateValidationAdult2 < dateValidation ){
//                    }else if(dateValidationAdult2 >dateValidation) {
//                        str_edit_dob=str_spouse_edit_dob_dob;
//                        BI_Status="True";
//                        BI_Status1="True";
//                        health_quote();
//                        Toast.makeText(Complete_health_member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
//                    }else{
//                        str_edit_dob=str_spouse_edit_dob_dob;
//                        BI_Status="True";
//                        BI_Status1="True";
//                        health_quote();
//                    }
//
//                }
//            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Complete_health_member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            str_edit_dob=dateFormatter.format(newDate.getTime());

            Log.e("str_edit_dob", str_edit_dob);
            String[] strdDate=  str_edit_dob.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            str_edit_dob3String = strdDate[2];
            Log.e("str_edit_dob3String", str_edit_dob3String);
            edit_dob.setText(str_edit_dob);
            try {
                SelectDate = dateFormatter.parse(str_edit_dob);
                CurrentDate = dateFormatter.parse(today);
                long selectNewDate = SelectDate.getTime();
                long TodayendDate = CurrentDate.getTime();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    period = new Period(selectNewDate, TodayendDate, PeriodType.yearMonthDay());
                    selectYearAdult = period.getYears();
                    SelectMonth = period.getMonths();
                    SelectDays = period.getDays();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (str_for.equals("0")){
                if (str_edit_dob3String != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3String);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
                    if (selectYearAdult < Integer.parseInt(strFirstString) || (selectYearAdult > Integer.parseInt(strFourString))) {
                        health_quote();
                        BI_Status="True";
                        Toast.makeText(Complete_health_member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        BI_Status="True";
                        health_quote();
                    }
                }
            }
            else if (str_for.equals("1")){
                if (str_edit_dob3String != null) {
                    Log.e("str_edit_dob3String",str_edit_dob3String);
                    int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//                    if (dateValidation < Integer.parseInt(strFirstString) || (dateValidation > Integer.parseInt(strFourString))) {
                        if (selectYearAdult < Integer.parseInt(strFirstString) || (selectYearAdult > Integer.parseInt(strFourString))) {
                        health_quote();
                        BI_Status="True";
                        Toast.makeText(Complete_health_member_info.this, "As per new input premium will get changed..", Toast.LENGTH_SHORT).show();
                    }else{
                        BI_Status="True";
                        health_quote();
                    }
                }
            }



        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }


    private void showCalenderProposer() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Complete_health_member_info.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            str_selfProposerDob=dateFormatter.format(newDate.getTime());
            Log.e("str_edit_dob", str_selfProposerDob);

            String[] strdDate=  str_selfProposerDob.split("/");
            String str_edit_dobDString = strdDate[0];
            String str_edit_dob2String = strdDate[1];
            str_edit_dob3String1 = strdDate[2];
            Log.e("str_edit_dob3String", str_edit_dob3String1);

            selfProposerDob.setText(str_selfProposerDob);
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Complete_health_member_info.this, BuyPolicySumInsured.class);
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
        intent.putExtra("TotalValue",TotalValue);
        intent.putExtra("NetPremiumValue",NetPremiumValue);
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
        intent.putExtra("LongTermDiscount",LongTermDiscount);
        intent.putExtra("new_str_age",new_str_age);
        intent.putExtra("GST",GST);
        intent.putExtra("BI_Status",BI_Status);
        intent.putExtra("BI_Status1",BI_Status1);
        intent.putExtra("BI_Status2",BI_Status2);
        intent.putExtra("BI_Status3",BI_Status3);
        intent.putExtra("BI_Status4",BI_Status4);
        intent.putExtra("BI_Status5",BI_Status5);
        intent.putExtra("for","1");
        startActivity(intent);
        finish();
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
            object.put("PA_Status","False");
            object.put("CI_Status","False");
            object.put("DHC_Status","False");
            object.put("Esale_Status","True");
            object.put("Life_Status","False");
            object.put("PD_Status",PD_Status);
            object.put("Sub_Status","False");
            object.put("Tiered_Status","False");
            object.put("Sub_Type","");
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
        ProjectVolleyRequest req = new ProjectVolleyRequest(Complete_health_member_info.this, object, UrlHealthConstants.BUY_HEALTH_CARE_QUOTATION_URL, new ResponseListener() {
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
//    private void health_quoteAdult() {
//
//        JSONObject object = new JSONObject();
//        try {
//            object.put("TokenNo", pref.getToken_no());
//            object.put("Uid",pref.getUID());
//            object.put("Plan_Type",str_policyType_spinner);
//            object.put("Floater_Type",str_IndividualTypeEdit);
//            object.put("Sum_Insured",str_SumInsured);
//            object.put("Policy_Duration",strFirstTString);
//            object.put("DOB",str_spouse_edit_dob_dob);
//            object.put("Proposal_Date",today);
//            object.put("From_Date",tomorrowDate);
//            object.put("To_Date",nextYear);
//            object.put("PA_Status","False");
//            object.put("CI_Status","False");
//            object.put("DHC_Status","False");
//            object.put("Esale_Status","True");
//            object.put("Life_Status","False");
//            object.put("PD_Status",PD_Status);
//            object.put("Sub_Status","False");
//            object.put("Tiered_Status","False");
//            object.put("Sub_Type","");
//            object.put("DOB1","");
//            object.put("DOB2","");
//            object.put("DOB3","");
//            object.put("DOB4","");
//            object.put("DOB5","");
//            object.put("PA_Status1","False");
//            object.put("CI_Status1","False");
//            object.put("DHC_Status1","False");
//            object.put("PA_Status2","False");
//            object.put("CI_Status2","False");
//            object.put("DHC_Status2","False");
//            object.put("PA_Status3","False");
//            object.put("CI_Status3","False");
//            object.put("DHC_Status3","False");
//            object.put("PA_Status4","False");
//            object.put("CI_Status4","False");
//            object.put("DHC_Status4","False");
//            object.put("PA_Status5","False");
//            object.put("CI_Status5","False");
//            object.put("DHC_Status5","False");
//            object.put("BI_Status",BI_Status);
//            object.put("BI_Status1",BI_Status1);
//            object.put("BI_Status2",BI_Status2);
//            object.put("BI_Status3",BI_Status3);
//            object.put("BI_Status4",BI_Status4);
//            object.put("BI_Status5",BI_Status5);
//            object.put("Policy_Type",strSumInsuredTpeEDit);
//            object.put("Policy_Type",strSumInsuredTpeEDit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ProjectVolleyRequest req = new ProjectVolleyRequest(Complete_health_member_info.this, object, UrlHealthConstants.BUY_HEALTH_CARE_QUOTATION_URL, new ResponseListener() {
//            @Override
//            public void onSuccess(JSONObject object, int Tag) {
//                if (object.optString("Status").equals("true")) {
//                    if (Tag == RequestHealthConstants.QUOTATION_Complete_URL) {
//                        try {
//                            JSONObject CustomerJsonObject = object.getJSONObject("Customer");
//                            JSONObject ProductJsonObject = object.getJSONObject("Product");
//                            JSONObject PremiumCalculationJsonObject = ProductJsonObject.getJSONObject("PremiumCalculation");
//                            JSONObject RisksJsonObject = ProductJsonObject.getJSONObject("Risks");
//                            JSONObject newRisksJsonObject = RisksJsonObject.getJSONObject("Risk");
//                            JSONObject RisksDataJsonObject = newRisksJsonObject.getJSONObject("RisksData");
//                            JSONObject OtherDiscountsJsonObject = RisksDataJsonObject.getJSONObject("OtherDiscounts");
//                            JSONObject OtherDiscountGroupJsonObject = OtherDiscountsJsonObject.getJSONObject("OtherDiscountGroup");
//                            JSONArray OtherDiscountGroupDataJsonObject = OtherDiscountGroupJsonObject.getJSONArray("OtherDiscountGroupData");
//
//                            for (int i=0;i <OtherDiscountGroupDataJsonObject.length();i++){
//                                JSONObject LongTermJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(5);
//                                JSONObject PremiumJson=LongTermJsonObject.getJSONObject("Premium");
//                                LongTermDiscount = PremiumJson.getString("Value");
//                                Log.e("LongTermDiscount",LongTermDiscount);
//                                JSONObject ESaleJsonObject = OtherDiscountGroupDataJsonObject.getJSONObject(4);
//                                JSONObject ESale=ESaleJsonObject.getJSONObject("Premium");
//                                ESaleDiscount = ESale.getString("Value");
//                                Log.e("ESaleDiscount",ESaleDiscount);
//
//                            }
//                            Log.e("gg", String.valueOf(PremiumCalculationJsonObject));
//                            JSONObject NetPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("NetPremium");
//                            JSONObject ServiceTaxJsonObject = PremiumCalculationJsonObject.getJSONObject("ServiceTax");
//                            JSONObject TotalPremiumJsonObject = PremiumCalculationJsonObject.getJSONObject("TotalPremium");
//                            Log.e("TotalPremium", String.valueOf(TotalPremiumJsonObject));
//                            NetPremiumValue = NetPremiumJsonObject.getString("Value");
//                            TotalValue = TotalPremiumJsonObject.getString("Value");
//                            PosPolicyNo = CustomerJsonObject.getString("PosPolicyNo");
//                            GST = ServiceTaxJsonObject.getString("Value");
////                            totalPrice= Double.parseDouble(TotalValue)-110.0;
////                            strPriceTotal= String.valueOf(totalPrice);
//                            totalPremiumAmount.setText(TotalValue);
////                            txtNetPremiumValue.setText(NetPremiumValue);
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
//        }, RequestHealthConstants.QUOTATION_Complete_URL);
//        req.execute();
//
//    }

}