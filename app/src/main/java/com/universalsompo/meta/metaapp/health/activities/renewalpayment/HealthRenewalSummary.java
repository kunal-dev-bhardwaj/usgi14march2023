package com.universalsompo.meta.metaapp.health.activities.renewalpayment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.Health_Insurance_Renewal;
import com.universalsompo.meta.metaapp.health.activities.renewal_model.TenureModel;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.ChiSummery;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.MemberMedicalInfoCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi.PolicyTypeCHI;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.paymentweb.PaymentWebUrl;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.MyHealthPolicyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HealthRenewalSummary extends AppCompatActivity {
    LinearLayout PersonalEditTxt,MemberEditTxt,TenureLinerTxt,continueButton,SumInsuredLinerTxt,SpouseLiner,SonLiner,DaughterLiner;
    String strIDTypeName,strEditdobString,strIDType,strSelfName,strSelfDob1,strSelfDob,strSelfEmailId,strSelfMobileNumber,strSpouseName,strSpouseDOB,strSpouseDOB1,strSonName,strSonDOB,strSonDOB1,strDaughterName,strDaughterDOB,strDaughterDOB1,strRelation,strBasicPremiumTxt,strNetPremiumTxtRenewal,strTotalPremiumTxt,GSt,tomorrowDate,QuotationID,click,strFor,str_edt_name,str_email,streditdob,strIDTypeEdit,strIDNumberEdit,str_policy_number_health,ckycNo,uniqueTransactionNumber,strSumInsured,strPolicyTenureTxt,QuotationID1,BasicCoverPremium1,SumInsured1,Netpremium1,Finalpremium1,CGST1,SGST1,IGST1,UGST1,QuotationID2,BasicCoverPremium2,SumInsured2,Netpremium2,Finalpremium2,CGST2,SGST2,IGST2,UGST2,QuotationID3,BasicCoverPremium3,SumInsured3,Netpremium3,Finalpremium3,CGST3,SGST3,IGST3,UGST3,QuotationID51,BasicCoverPremium51,SumInsured51,Netpremium51,Finalpremium51,CGST51,SGST51,IGST51,UGST51,QuotationID52,BasicCoverPremium52,SumInsured52,Netpremium52,Finalpremium52,CGST52,SGST52,IGST52,UGST52,QuotationID53,BasicCoverPremium53,SumInsured53,Netpremium53,Finalpremium53,CGST53,SGST53,IGST53,UGST53;
    TextView termCondition,SelfName,selfEmailId,SelfMobileNumber,SelfDOB,SpouseName,SpouseDOB,SonName,SonDOB,DaughterName,DaughterDOB,PolicyTenureTxt,SumInsuredTxt,NetPremiumTxtRenewal,BasicPremiumTxt,TotalValue,PolicyStartDateTxt,GSTTxt,TotalPremiumTxt;
    private final ArrayList<TenureModel> tenureModels = new ArrayList<>();
    RenewalAdapter renewalAdapter;
    Date date;
    CheckBox checkBox;
    RecyclerView rcyRenewalHealth;
    ImageView SummeryBack;
    @SuppressLint("SimpleDateFormat")
    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_renewal_summary);
        getWindow().setStatusBarColor(ContextCompat.getColor(HealthRenewalSummary.this, R.color.colorPrimaryDark));
        str_edt_name = getIntent().getStringExtra("str_edt_name");
        strFor = getIntent().getStringExtra("strFor");
        str_email = getIntent().getStringExtra("str_email");
        streditdob = getIntent().getStringExtra("streditdob");
        strIDTypeEdit = getIntent().getStringExtra("strIDTypeEdit");
        strIDNumberEdit = getIntent().getStringExtra("strIDNumberEdit");
        str_policy_number_health = getIntent().getStringExtra("str_policy_number_health");
        ckycNo = getIntent().getStringExtra("ckycNo");
        uniqueTransactionNumber = getIntent().getStringExtra("uniqueTransactionNumber");
        strIDType = getIntent().getStringExtra("strIDType");
        strEditdobString = getIntent().getStringExtra("strEditdobString");
        strIDTypeName = getIntent().getStringExtra("strIDTypeName");
        PersonalEditTxt=findViewById(R.id.PersonalEditTxt);
        MemberEditTxt=findViewById(R.id.MemberEditTxt);
        TenureLinerTxt=findViewById(R.id.TenureLinerTxt);
        PolicyTenureTxt=findViewById(R.id.PolicyTenureTxt);
        BasicPremiumTxt=findViewById(R.id.BasicPremiumTxt);
        NetPremiumTxtRenewal=findViewById(R.id.NetPremiumTxtRenewal);
        SumInsuredTxt=findViewById(R.id.SumInsuredTxt);
        TotalValue=findViewById(R.id.TotalValue);
        PolicyStartDateTxt=findViewById(R.id.PolicyStartDateTxt);
        GSTTxt=findViewById(R.id.GSTTxt);
        TotalPremiumTxt=findViewById(R.id.TotalPremiumTxt);
        SumInsuredLinerTxt=findViewById(R.id.SumInsuredLinerTxt);
        SpouseLiner=findViewById(R.id.SpouseLiner);
        SonLiner=findViewById(R.id.SonLiner);
        SelfName=findViewById(R.id.SelfName);
        selfEmailId=findViewById(R.id.selfEmailId);
        SelfMobileNumber=findViewById(R.id.SelfMobileNumber);
        SelfDOB=findViewById(R.id.SelfDOB);
        SpouseName=findViewById(R.id.SpouseName);
        SpouseDOB=findViewById(R.id.SpouseDOB);
        SonName=findViewById(R.id.SonName);
        SonDOB=findViewById(R.id.SonDOB);
        DaughterName=findViewById(R.id.DaughterName);
        DaughterDOB=findViewById(R.id.DaughterDOB);
        DaughterLiner=findViewById(R.id.DaughterLiner);
        continueButton=findViewById(R.id.continueButton);
        rcyRenewalHealth=findViewById(R.id.rcyRenewalHealth);
        termCondition=findViewById(R.id.termCondition);
        SummeryBack=findViewById(R.id.SummeryBack);
        checkBox=findViewById(R.id.checkBox);
        click="One";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        tomorrowDate = formatter.format(date);
        Log.e("tomorrowDate",tomorrowDate);
        PolicyStartDateTxt.setText(tomorrowDate);
        ChiRenewal();

        PersonalEditTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertPopup();
            }
        });
        MemberEditTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertMemberPopup();
            }
        });

        SummeryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backMethod();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkBox.isChecked()){
                    Toast.makeText(HealthRenewalSummary.this, "Accept Terms & Condition", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(HealthRenewalSummary.this, PaymentWebUrl.class);
                    intent.putExtra("QuotationID",QuotationID);
                    intent.putExtra("strTotalPremiumTxt",strTotalPremiumTxt);
                    intent.putExtra("str_policy_number_health",str_policy_number_health);
                    intent.putExtra("checkPage","Summery");
                    intent.putExtra("checkPayment","HealthRenewal");
                    startActivity(intent);
                }
            }
        });

        termCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog alert_dialog = new Dialog(HealthRenewalSummary.this);
                alert_dialog.setCanceledOnTouchOutside(false);
                alert_dialog.setCancelable(false);
                alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alert_dialog.setContentView(R.layout.dialog_term_condition);
                ImageView crossImg;
                crossImg = alert_dialog.findViewById(R.id.crossImg);
                alert_dialog.show();
                crossImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert_dialog.dismiss();
                    }
                });
            }
        });

        SumInsuredLinerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog SumInsuredDialog = new Dialog(HealthRenewalSummary.this);
                SumInsuredDialog.setCanceledOnTouchOutside(false);
                SumInsuredDialog.setCancelable(false);
                SumInsuredDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(SumInsuredDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                SumInsuredDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                SumInsuredDialog.setContentView(R.layout.policy_suminsured);
                ImageView cutImg;
                LinearLayout SumInsuredDropDown;
                EditText SumInsuredEditText;
                TextView SumInsuredSelectPlan;
                cutImg = SumInsuredDialog.findViewById(R.id.cutImg);
                SumInsuredDropDown = SumInsuredDialog.findViewById(R.id.SumInsuredDropDown);
                SumInsuredEditText = SumInsuredDialog.findViewById(R.id.SumInsuredEditText);
                SumInsuredSelectPlan = SumInsuredDialog.findViewById(R.id.SumInsuredSelectPlan);
                SumInsuredDialog.show();
                SumInsuredSelectPlan.setText(strSumInsured);
                SumInsuredEditText.setText(strSumInsured);

                SumInsuredDropDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MyOptionsPickerView singlePicker = new MyOptionsPickerView(HealthRenewalSummary.this);
                        final ArrayList<String> items1 = new ArrayList<String>();
                        items1.add("400000");
                        items1.add("500000");
                        singlePicker.setPicker(items1);
                        singlePicker.setCyclic(false);
                        singlePicker.setSelectOptions(0);
                        singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int option2, int options3) {
                                strSumInsured=items1.get(options1);
                                SumInsuredEditText.setText(strSumInsured);
                                SumInsuredTxt.setText(strSumInsured);
                                if (strSumInsured.equals("400000")){
                                    if (click.equals("One")){
                                        fourLakhOneYear();
                                    }else if (click.equals("Two")){
                                        fourLakhTwoYear();
                                    }else if (click.equals("Three")){
                                        fourLakhThreeYear();
                                    }
                                }else if(strSumInsured.equals("500000")){
                                    if (click.equals("One")){
                                        fiveLakhOneYear();
                                    }else if (click.equals("Two")){
                                        fiveLakhTwoYear();
                                    }else if (click.equals("Three")){
                                        fiveLakhThreeYear();
                                    }
                                }
                            }
                        });
                        singlePicker.show();
                    }
                });

                cutImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SumInsuredDialog.dismiss();
                    }
                });
            }
        });

        TenureLinerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog TenureDialog = new Dialog(HealthRenewalSummary.this);
                TenureDialog.setCanceledOnTouchOutside(false);
                TenureDialog.setCancelable(false);
                TenureDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(TenureDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                TenureDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                TenureDialog.setContentView(R.layout.policy_tenure);
                ImageView cutImg;
                TextView oneYearTxt,TwoYearTxt,ThreeYearTxt,SumInsuredSelectPlan;
                RadioButton OneYear,TwoYearRadio,ThreeYearRadio;
                cutImg = TenureDialog.findViewById(R.id.cutImg);
                oneYearTxt = TenureDialog.findViewById(R.id.oneYearTxt);
                TwoYearTxt = TenureDialog.findViewById(R.id.TwoYearTxt);
                ThreeYearTxt = TenureDialog.findViewById(R.id.ThreeYearTxt);
                SumInsuredSelectPlan = TenureDialog.findViewById(R.id.SumInsuredSelectPlan);
                OneYear = TenureDialog.findViewById(R.id.OneYear);
                TwoYearRadio = TenureDialog.findViewById(R.id.TwoYearRadio);
                ThreeYearRadio = TenureDialog.findViewById(R.id.ThreeYearRadio);

                OneYear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton,boolean isChecked) {
                        if (OneYear.isChecked()) {
                            click="One";
                            OneYear.setChecked(true);
                            TwoYearRadio.setChecked(false);
                            ThreeYearRadio.setChecked(false);
                            if (strSumInsured.equals("400000")) {
                                fourLakhOneYear();
                            }else if(strSumInsured.equals("500000")){

                                fiveLakhOneYear();
                            }

                        }
                    }
                });
                TwoYearRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton,boolean isChecked) {
                        if (TwoYearRadio.isChecked()) {
                            click="Two";
                            OneYear.setChecked(false);
                            TwoYearRadio.setChecked(true);
                            ThreeYearRadio.setChecked(false);
                            if (strSumInsured.equals("400000")){
                                fourLakhTwoYear();
                            }else if(strSumInsured.equals("500000")){
                                fiveLakhTwoYear();
                            }

                        }
                    }
                });
                ThreeYearRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton,boolean isChecked) {
                        if (ThreeYearRadio.isChecked()) {
                            click="Three";
                            OneYear.setChecked(false);
                            TwoYearRadio.setChecked(false);
                            ThreeYearRadio.setChecked(true);
                            if (strSumInsured.equals("400000")){
                                fourLakhThreeYear();
                            }else if(strSumInsured.equals("500000")){
                                fiveLakhThreeYear();
                            }
                        }
                    }
                });

                if (strSumInsured.equals("400000")){
                    oneYearTxt.setText(Finalpremium1);
                    TwoYearTxt.setText(Finalpremium2);
                    ThreeYearTxt.setText(Finalpremium3);
                    SumInsuredSelectPlan.setText(strSumInsured);
                    if (click.equals("One")){
                        OneYear.setChecked(true);
                        TwoYearRadio.setChecked(false);
                        ThreeYearRadio.setChecked(false);
                        fourLakhOneYear();
                    }else if (click.equals("Two")){
                        OneYear.setChecked(false);
                        TwoYearRadio.setChecked(true);
                        ThreeYearRadio.setChecked(false);
                        fourLakhTwoYear();

                    }else if (click.equals("Three")){
                        OneYear.setChecked(false);
                        TwoYearRadio.setChecked(false);
                        ThreeYearRadio.setChecked(true);
                        fourLakhThreeYear();

                    }

                }else if (strSumInsured.equals("500000")){
                    oneYearTxt.setText(Finalpremium51);
                    TwoYearTxt.setText(Finalpremium52);
                    ThreeYearTxt.setText(Finalpremium53);
                    SumInsuredSelectPlan.setText(strSumInsured);
                    if (click.equals("One")){
                        OneYear.setChecked(true);
                        TwoYearRadio.setChecked(false);
                        ThreeYearRadio.setChecked(false);
                        fiveLakhOneYear();
                    }else if (click.equals("Two")){
                        OneYear.setChecked(false);
                        TwoYearRadio.setChecked(true);
                        ThreeYearRadio.setChecked(false);
                        fiveLakhTwoYear();
                    }else if (click.equals("Three")){
                        OneYear.setChecked(false);
                        TwoYearRadio.setChecked(false);
                        ThreeYearRadio.setChecked(true);
                        fiveLakhThreeYear();

                    }
                }


                TenureDialog.show();
                cutImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TenureDialog.dismiss();
                    }
                });
            }
        });
    }
    private void fiveLakhThreeYear() {
        strPolicyTenureTxt="3";
        GSt = String.valueOf(Double.parseDouble(CGST53) + Double.parseDouble(SGST53) + Double.parseDouble(IGST53) + Double.parseDouble(UGST53));
        QuotationID=QuotationID53;
        strNetPremiumTxtRenewal=Netpremium53;
        strTotalPremiumTxt=Finalpremium53;
        PolicyTenureTxt.setText(strPolicyTenureTxt+" Year");
        NetPremiumTxtRenewal.setText(strNetPremiumTxtRenewal);
        TotalValue.setText(strTotalPremiumTxt);
        TotalPremiumTxt.setText(strTotalPremiumTxt);
        GSTTxt.setText(GSt);
    }
    private void fiveLakhTwoYear() {
        strPolicyTenureTxt="2";
        GSt = String.valueOf(Double.parseDouble(CGST52) + Double.parseDouble(SGST52) + Double.parseDouble(IGST52) + Double.parseDouble(UGST52));
        QuotationID=QuotationID52;
        strNetPremiumTxtRenewal=Netpremium52;
        strTotalPremiumTxt=Finalpremium52;
        PolicyTenureTxt.setText(strPolicyTenureTxt+" Year");
        NetPremiumTxtRenewal.setText(strNetPremiumTxtRenewal);
        TotalValue.setText(strTotalPremiumTxt);
        TotalPremiumTxt.setText(strTotalPremiumTxt);
        GSTTxt.setText(GSt);
    }
    private void fiveLakhOneYear() {
        strPolicyTenureTxt="1         ";
        GSt = String.valueOf(Double.parseDouble(CGST51) + Double.parseDouble(SGST51) + Double.parseDouble(IGST51) + Double.parseDouble(UGST51));
        QuotationID=QuotationID51;
        strNetPremiumTxtRenewal=Netpremium51;
        strTotalPremiumTxt=Finalpremium51;
        PolicyTenureTxt.setText(strPolicyTenureTxt+" Year");
        NetPremiumTxtRenewal.setText(strNetPremiumTxtRenewal);
        TotalValue.setText(strTotalPremiumTxt);
        TotalPremiumTxt.setText(strTotalPremiumTxt);
        GSTTxt.setText(GSt);
    }
    private void fourLakhThreeYear(){
        strPolicyTenureTxt="3";
        QuotationID=QuotationID3;
        strNetPremiumTxtRenewal=Netpremium3;
        strTotalPremiumTxt=Finalpremium3;
        GSt = String.valueOf(Double.parseDouble(CGST3) + Double.parseDouble(SGST3) + Double.parseDouble(IGST3) + Double.parseDouble(UGST3));
        PolicyTenureTxt.setText(strPolicyTenureTxt+" Year");
        NetPremiumTxtRenewal.setText(strNetPremiumTxtRenewal);
        TotalValue.setText(strTotalPremiumTxt);
        TotalPremiumTxt.setText(strTotalPremiumTxt);
        GSTTxt.setText(GSt);
    }
    private void fourLakhTwoYear() {
        strPolicyTenureTxt="2";
        QuotationID=QuotationID2;
        strNetPremiumTxtRenewal=Netpremium2;
        strTotalPremiumTxt=Finalpremium2;
        GSt = String.valueOf(Double.parseDouble(CGST2) + Double.parseDouble(SGST2) + Double.parseDouble(IGST2) + Double.parseDouble(UGST2));
        PolicyTenureTxt.setText(strPolicyTenureTxt+" Year");
        NetPremiumTxtRenewal.setText(strNetPremiumTxtRenewal);
        TotalValue.setText(strTotalPremiumTxt);
        TotalPremiumTxt.setText(strTotalPremiumTxt);
        GSTTxt.setText(GSt);
    }
    private void fourLakhOneYear() {
        strPolicyTenureTxt="1         ";
        GSt = String.valueOf(Double.parseDouble(CGST1) + Double.parseDouble(SGST1) + Double.parseDouble(IGST1) + Double.parseDouble(UGST1));
        QuotationID=QuotationID1;
        strNetPremiumTxtRenewal=Netpremium1;
        strTotalPremiumTxt=Finalpremium1;
        PolicyTenureTxt.setText(strPolicyTenureTxt+" Year");
        NetPremiumTxtRenewal.setText(strNetPremiumTxtRenewal);
        TotalValue.setText(strTotalPremiumTxt);
        TotalPremiumTxt.setText(strTotalPremiumTxt);
        GSTTxt.setText(GSt);
    }
    private void ChiRenewal() {
        JSONObject object = new JSONObject();
        try {
            object.put("WACode", "20000001");
            object.put("WAAppCode","30000011");
            object.put("ProductCode","2825");
            object.put("PreviousPolicyNo",str_policy_number_health);
            object.put("CKYCNo",ckycNo);
            object.put("Ref_No_Unique_KYC",uniqueTransactionNumber);
        } catch (Exception e) {
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(HealthRenewalSummary.this, object, UrlHealthConstants.Renewal_URL, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (object.optString("ErrorDesc").equals("Premium Calculated.")) {
                    if (Tag == RequestHealthConstants.RenewalCHIAPI) {
                        JSONArray arrMember;
                        JSONArray arr;
                        try {
                            arrMember = object.getJSONArray("CHI_Renewal_Members");
                            for (int i = 0; i < arrMember.length(); i++) {
                                strRelation = arrMember.optJSONObject(i).getString("Relation");
                                if (strRelation.equals("Self")){
                                    strSelfName= arrMember.optJSONObject(i).getString("Name");
                                    strSelfDob1 = arrMember.optJSONObject(i).getString("DOB");
                                    strSelfEmailId = arrMember.optJSONObject(i).getString("EmailId");
                                    strSelfMobileNumber = arrMember.optJSONObject(i).getString("MobileNo");
                                }else if (strRelation.equals("Spouse")){
                                    strSpouseName= arrMember.optJSONObject(i).getString("Name");
                                    strSpouseDOB1 = arrMember.optJSONObject(i).getString("DOB");
                                }else if (strRelation.equals("Son")){
                                    strSonName= arrMember.optJSONObject(i).getString("Name");
                                    strSonDOB1 = arrMember.optJSONObject(i).getString("DOB");
                                }else if (strRelation.equals("Daughter")){
                                    strDaughterName= arrMember.optJSONObject(i).getString("Name");
                                    strDaughterDOB1 = arrMember.optJSONObject(i).getString("DOB");
                                }


                                if (strSelfName != null){
                                    SelfName.setText(strSelfName);
                                    selfEmailId.setText(strSelfEmailId);
                                    SelfMobileNumber.setText(strSelfMobileNumber);
                                    String parts[] = strSelfDob1.split(" ");
                                    strSelfDob= parts[0];
                                    String strSelfDob2= parts[1];
                                    SelfDOB.setText(strSelfDob);
                                }

                                if (strSpouseName != null){
                                    String parts1[] = strSpouseDOB1.split(" ");
                                    strSpouseDOB= parts1[0];
                                    String strSpouseDOB2= parts1[1];
                                    SpouseLiner.setVisibility(View.VISIBLE);
                                    SpouseName.setText(strSpouseName);
                                    SpouseDOB.setText(strSpouseDOB);
                                }else{
                                    SpouseLiner.setVisibility(View.GONE);
                                }

                                 if (strSonName != null){
                                     String parts2[] = strSonDOB1.split(" ");
                                     strSonDOB= parts2[0];
                                     String strSonDOB2= parts2[1];
                                     SonLiner.setVisibility(View.VISIBLE);
                                     SonName.setText(strSonName);
                                     SonDOB.setText(strSonDOB);
                                 }else{
                                     SonLiner.setVisibility(View.GONE);
                                 }
                                if (strDaughterName != null){
                                    String parts3[] = strDaughterDOB1.split(" ");
                                    strDaughterDOB= parts3[0];
                                    String strDaughterDOB2= parts3[1];
                                    DaughterLiner.setVisibility(View.VISIBLE);
                                    DaughterName.setText(strDaughterName);
                                    DaughterDOB.setText(strDaughterDOB);
                                }else{
                                    DaughterLiner.setVisibility(View.GONE);
                                }

                            }
                            arr = object.getJSONArray("PremiumDetails");
                            for (int i = 0; i < arr.length(); ++i) {
                                tenureModels.add(
                                        new TenureModel(
                                                arr.optJSONObject(i).optString("Quoteid"),
                                                arr.optJSONObject(i).optString("Tenure"),
                                                arr.optJSONObject(i).optString("SumInsured"),
                                                arr.optJSONObject(i).optString("BasicCoverPremium"),
                                                arr.optJSONObject(i).optString("Netpremium"),
                                                arr.optJSONObject(i).optString("Finalpremium"),
                                                arr.optJSONObject(i).optString("CGST"),
                                                arr.optJSONObject(i).optString("SGST"),
                                                arr.optJSONObject(i).optString("IGST"),
                                                arr.optJSONObject(i).optString("UGST")
                                        )
                                );

                                LinearLayoutManager layoutManager = new LinearLayoutManager(HealthRenewalSummary.this, LinearLayoutManager.HORIZONTAL, false);
                                rcyRenewalHealth.setLayoutManager(layoutManager);
                                renewalAdapter = new RenewalAdapter(HealthRenewalSummary.this, tenureModels);
                                rcyRenewalHealth.setAdapter(renewalAdapter);





                               int arrayLength=arr.length();
//                               if (arrayLength==1){
//                                   TenureLinerTxt.setVisibility(View.GONE);
//                                   SumInsuredLinerTxt.setVisibility(View.GONE);
//                               }else{
//                                   TenureLinerTxt.setVisibility(View.VISIBLE);
//                                   SumInsuredLinerTxt.setVisibility(View.VISIBLE);
//                               }
                                strSumInsured = arr.optJSONObject(i).getString("SumInsured");
                                if (strSumInsured.equals("400000")){
                                    strPolicyTenureTxt = arr.optJSONObject(i).getString("Tenure");
                                    if (strPolicyTenureTxt.equals("1         ")){
                                        QuotationID1=arr.optJSONObject(i).optString("Quoteid");
                                        SumInsured1=arr.optJSONObject(i).optString("SumInsured");
                                        BasicCoverPremium1=arr.optJSONObject(i).optString("BasicCoverPremium");
                                        Netpremium1=arr.optJSONObject(i).optString("Netpremium");
                                        Finalpremium1=arr.optJSONObject(i).optString("Finalpremium");
                                        CGST1=arr.optJSONObject(i).optString("CGST");
                                        SGST1=arr.optJSONObject(i).optString("SGST");
                                        IGST1=arr.optJSONObject(i).optString("IGST");
                                        UGST1=arr.optJSONObject(i).optString("UGST");

                                    }else if (strPolicyTenureTxt.equals("2")){
                                        QuotationID2=arr.optJSONObject(i).optString("Quoteid");
                                        SumInsured2=arr.optJSONObject(i).optString("SumInsured");
                                        BasicCoverPremium2=arr.optJSONObject(i).optString("BasicCoverPremium");
                                        Netpremium2=arr.optJSONObject(i).optString("Netpremium");
                                        Finalpremium2=arr.optJSONObject(i).optString("Finalpremium");
                                        CGST2=arr.optJSONObject(i).optString("CGST");
                                        SGST2=arr.optJSONObject(i).optString("SGST");
                                        IGST2=arr.optJSONObject(i).optString("IGST");
                                        UGST2=arr.optJSONObject(i).optString("UGST");
                                    }else if (strPolicyTenureTxt.equals("3")){
                                        QuotationID3=arr.optJSONObject(i).optString("Quoteid");
                                        SumInsured3=arr.optJSONObject(i).optString("SumInsured");
                                        BasicCoverPremium3=arr.optJSONObject(i).optString("BasicCoverPremium");
                                        Netpremium3=arr.optJSONObject(i).optString("Netpremium");
                                        Finalpremium3=arr.optJSONObject(i).optString("Finalpremium");
                                        CGST3=arr.optJSONObject(i).optString("CGST");
                                        SGST3=arr.optJSONObject(i).optString("SGST");
                                        IGST3=arr.optJSONObject(i).optString("IGST");
                                        UGST3=arr.optJSONObject(i).optString("UGST");
                                    }

                                }else if (strSumInsured.equals("500000")){
                                    strPolicyTenureTxt = arr.optJSONObject(i).getString("Tenure");
                                    if (strPolicyTenureTxt.equals("1         ")){
                                        QuotationID51=arr.optJSONObject(i).optString("Quoteid");
                                        SumInsured51=arr.optJSONObject(i).optString("SumInsured");
                                        BasicCoverPremium51=arr.optJSONObject(i).optString("BasicCoverPremium");
                                        Netpremium51=arr.optJSONObject(i).optString("Netpremium");
                                        Finalpremium51=arr.optJSONObject(i).optString("Finalpremium");
                                        CGST51=arr.optJSONObject(i).optString("CGST");
                                        SGST51=arr.optJSONObject(i).optString("SGST");
                                        IGST51=arr.optJSONObject(i).optString("IGST");
                                        UGST51=arr.optJSONObject(i).optString("UGST");
                                    }else if (strPolicyTenureTxt.equals("2")){
                                        QuotationID52=arr.optJSONObject(i).optString("Quoteid");
                                        SumInsured52=arr.optJSONObject(i).optString("SumInsured");
                                        BasicCoverPremium52=arr.optJSONObject(i).optString("BasicCoverPremium");
                                        Netpremium52=arr.optJSONObject(i).optString("Netpremium");
                                        Finalpremium52=arr.optJSONObject(i).optString("Finalpremium");
                                        CGST52=arr.optJSONObject(i).optString("CGST");
                                        SGST52=arr.optJSONObject(i).optString("SGST");
                                        IGST52=arr.optJSONObject(i).optString("IGST");
                                        UGST52=arr.optJSONObject(i).optString("UGST");
                                    }else if (strPolicyTenureTxt.equals("3")){
                                        QuotationID53=arr.optJSONObject(i).optString("Quoteid");
                                        SumInsured53=arr.optJSONObject(i).optString("SumInsured");
                                        BasicCoverPremium53=arr.optJSONObject(i).optString("BasicCoverPremium");
                                        Netpremium53=arr.optJSONObject(i).optString("Netpremium");
                                        Finalpremium53=arr.optJSONObject(i).optString("Finalpremium");
                                        CGST53=arr.optJSONObject(i).optString("CGST");
                                        SGST53=arr.optJSONObject(i).optString("SGST");
                                        IGST53=arr.optJSONObject(i).optString("IGST");
                                        UGST53=arr.optJSONObject(i).optString("UGST");
                                    }
                                }


//                                QuotationID=arr.optJSONObject(0).optString("Quoteid");
//                                strSumInsured=arr.optJSONObject(0).optString("SumInsured");
//                                strPolicyTenureTxt=arr.optJSONObject(0).optString("Tenure");
//                                strTotalPremiumTxt=arr.optJSONObject(0).optString("Finalpremium");
//                                strNetPremiumTxtRenewal=arr.optJSONObject(0).optString("Netpremium");
//                                CGST1=arr.optJSONObject(0).optString("CGST");
//                                SGST1=arr.optJSONObject(0).optString("SGST");
//                                IGST1=arr.optJSONObject(0).optString("IGST");
//                                UGST1=arr.optJSONObject(0).optString("UGST");
//                                GSt = String.valueOf(Double.parseDouble(CGST1) + Double.parseDouble(SGST1) + Double.parseDouble(IGST1) + Double.parseDouble(UGST1));
//                                PolicyTenureTxt.setText(strPolicyTenureTxt+" Year");
//                                SumInsuredTxt.setText(strSumInsured);
//                                GSTTxt.setText(GSt);
//                                NetPremiumTxtRenewal.setText(strNetPremiumTxtRenewal);
//                                TotalPremiumTxt.setText(strTotalPremiumTxt);
//                                TotalValue.setText(strTotalPremiumTxt);
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else {

                }
            }
            @Override
            public void onError(VolleyError error, int Tag) {
            }

        }, RequestHealthConstants.RenewalCHIAPI);
        req.execute();
    }
    private void alertMemberPopup() {
        Dialog alertMemberNSTP;
        alertMemberNSTP = new Dialog(HealthRenewalSummary.this);
        alertMemberNSTP.setCanceledOnTouchOutside(false);
        alertMemberNSTP.setCancelable(false);
        alertMemberNSTP.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alertMemberNSTP.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertMemberNSTP.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertMemberNSTP.setContentView(R.layout.alert_dialog_edit_member);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(alertMemberNSTP.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        alertMemberNSTP.show();
        RadioButton AddMemberRadio = alertMemberNSTP.findViewById(R.id.AddMemberRadio);
        RadioButton DeleteMemberRadio = alertMemberNSTP.findViewById(R.id.DeleteMemberRadio);
        ImageView cutImgNSTP = alertMemberNSTP.findViewById(R.id.cutImgNSTP);
        TextView ok_dialog = alertMemberNSTP.findViewById(R.id.ok_dialog);
        cutImgNSTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMemberNSTP.dismiss();
            }
        });

        AddMemberRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (AddMemberRadio.isChecked()){
                    AddMemberRadio.setChecked(true);
                    DeleteMemberRadio.setChecked(false);

                }
            }
        });
        DeleteMemberRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (DeleteMemberRadio.isChecked()){
                    DeleteMemberRadio.setChecked(true);
                    AddMemberRadio.setChecked(false);

                }
            }
        });

        ok_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertPopup();
                alertMemberNSTP.dismiss();
            }
        });
    }
    private void alertPopup() {
        Dialog alert_dialogNSTP;
        alert_dialogNSTP = new Dialog(HealthRenewalSummary.this);
        alert_dialogNSTP.setCanceledOnTouchOutside(false);
        alert_dialogNSTP.setCancelable(false);
        alert_dialogNSTP.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialogNSTP.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert_dialogNSTP.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialogNSTP.setContentView(R.layout.alert_dialog_nstp_new);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(alert_dialogNSTP.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        alert_dialogNSTP.show();
        TextView ok_dialog = alert_dialogNSTP.findViewById(R.id.ok_dialog);
        TextView CancelDialog = alert_dialogNSTP.findViewById(R.id.CancelDialog);
        ImageView cutImgNSTP = alert_dialogNSTP.findViewById(R.id.cutImgNSTP);
        cutImgNSTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialogNSTP.dismiss();
            }
        });
        CancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialogNSTP.dismiss();
            }
        });

        ok_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialogNSTP.dismiss();

            }
        });
    }
    private void backMethod() {
        Intent intent=new Intent(HealthRenewalSummary.this, Health_Insurance_Renewal.class);
        intent.putExtra("str_edt_name",str_edt_name);
        intent.putExtra("str_email",str_email);
        intent.putExtra("streditdob",streditdob);
        intent.putExtra("strIDTypeEdit",strIDTypeEdit);
        intent.putExtra("strIDNumberEdit",strIDNumberEdit);
        intent.putExtra("str_policy_number_health",str_policy_number_health);
        intent.putExtra("strIDType",strIDType);
        intent.putExtra("strEditdobString",strEditdobString);
        intent.putExtra("strIDTypeName",strIDTypeName);
        intent.putExtra("strFor","1");
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        backMethod();
    }
    public void data_click(int position) {
        QuotationID=tenureModels.get(position).getQuoteid();
        strPolicyTenureTxt=tenureModels.get(position).getTenure();
        if (strPolicyTenureTxt.equals("2")){
        }else if (strPolicyTenureTxt.equals("3")){
        }else{
            String parts1[] = strPolicyTenureTxt.split(" ");
            String str1= parts1[0];
            strPolicyTenureTxt=str1;
        }
        strSumInsured=tenureModels.get(position).getSumInsured();
        strBasicPremiumTxt=tenureModels.get(position).getBasicCoverPremium();
        strNetPremiumTxtRenewal=tenureModels.get(position).getNetpremium();
        strTotalPremiumTxt=tenureModels.get(position).getFinalpremium();
        strTotalPremiumTxt=tenureModels.get(position).getFinalpremium();
        CGST1=tenureModels.get(position).getCGST();
        IGST1=tenureModels.get(position).getIGST();
        SGST1=tenureModels.get(position).getSGST();
        UGST1=tenureModels.get(position).getUGST();
        GSt = String.valueOf(Double.parseDouble(CGST1) + Double.parseDouble(SGST1) + Double.parseDouble(IGST1) + Double.parseDouble(UGST1));
        PolicyTenureTxt.setText(strPolicyTenureTxt+" Year");
        SumInsuredTxt.setText(strSumInsured);
        GSTTxt.setText(GSt);
        BasicPremiumTxt.setText(strBasicPremiumTxt);
        NetPremiumTxtRenewal.setText(strNetPremiumTxtRenewal);
        TotalPremiumTxt.setText(strTotalPremiumTxt);
        TotalValue.setText(strTotalPremiumTxt);
    }
}