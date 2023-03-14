package com.universalsompo.meta.metaapp.health;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.MyOptionsPickerView;
import com.universalsompo.meta.R;

import java.text.DecimalFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

public class CalculatorPlanDetails extends AppCompatActivity {
    Button btnNext;
    LinearLayout amount_dropdown;
    public Period period;
    double long_discount = 0.0,convert_amount = 0.0;
    String strGenderEditSpinner = "",selected_type,spouse_checked,mother_checkbox,motherlaw_checkbox = "",selected_year;
    int selected_amount =0,planAmount=0,nonMedical = 0,meternityCover = 0,Diabetes = 0,Hypertension = 0,add = 0,women_discount = 0,double_convert,add_ons_value = 0,discount_checkbox = 0,discount_value = 0;
    String zone1,age26,age31,age36,age41,age46,age51,age56,age61,age66,age71,agee18,agee26,agee31,agee36,agee41,agee46,agee51,agee56,agee61,agee66,agee71,gender,discount_amount = "";
    EditText edt_amount_spinner;
    RadioButton btnradio_silver_1year,btnradio_silver_2year,btnradio_silver_3year,btnradio_gold_1year,btnradio_gold_2year,btnradio_gold_3year,btnradio_diamond_1year,btnradio_diamond_2year,btnradio_diamond_3year;
    TextView silver_1year,silver_2year,silver_3year,gold_1year,gold_2year,gold_3year,diamond_1year,diamond_2year,diamond_3year;
    ImageView img_plan_back;
    String strDirect_ChannelDiscount = "",strWomen_Discount = "",strChild_zone = "",strByDefaultValue = "",strageChild = "";
    String strDisease_checkbox = "", strNonMedical = "", strMaternityCover = "",strDabetes_checkbox = "",strHypertension = "",strDirectChannelDiscount = "",strWomenDiscount = "",strLongTermDiscount = "",spouse_gender = "",mother_gender = "",motherLaw_gender = "",silver_one_year = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_plan_details);
        btnNext =findViewById(R.id.btnNext);
        amount_dropdown = findViewById(R.id.amount_dropdown);
        edt_amount_spinner = findViewById(R.id.edt_amount_spinner);
        img_plan_back = findViewById(R.id.img_plan_back);


        img_plan_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });

        zone1 = getIntent().getStringExtra("zone1");
        age26 = getIntent().getStringExtra("age26");
        age31 = getIntent().getStringExtra("age31");
        age36 = getIntent().getStringExtra("age36");
        age41 = getIntent().getStringExtra("age41");
        age46 = getIntent().getStringExtra("age46");
        age51 = getIntent().getStringExtra("age51");
        age56 = getIntent().getStringExtra("age56");
        age61 = getIntent().getStringExtra("age61");
        age66 = getIntent().getStringExtra("age66");
        age71 = getIntent().getStringExtra("age71");
        agee18 = getIntent().getStringExtra("agee18");
        agee26 = getIntent().getStringExtra("agee26");
        agee31 = getIntent().getStringExtra("agee31");
        agee36 = getIntent().getStringExtra("agee36");
        agee41 = getIntent().getStringExtra("agee41");
        agee46 = getIntent().getStringExtra("agee46");
        agee51 = getIntent().getStringExtra("agee51");
        agee56 = getIntent().getStringExtra("agee56");
        agee61 = getIntent().getStringExtra("agee61");
        agee66 = getIntent().getStringExtra("agee66");
        agee71 = getIntent().getStringExtra("agee71");
        strageChild = getIntent().getStringExtra("agechild");
        gender = getIntent().getStringExtra("gender");
        spouse_checked = getIntent().getStringExtra("spouse_checked");
        mother_checkbox = getIntent().getStringExtra("mother_checked");
        motherlaw_checkbox = getIntent().getStringExtra("mother_lawchecked");
        spouse_gender = getIntent().getStringExtra("spouse_gender");
        mother_gender = getIntent().getStringExtra("mother_gender");
        motherLaw_gender = getIntent().getStringExtra("motherLaw_gender");
        strChild_zone = getIntent().getStringExtra("child_zone1");




        silver_1year = findViewById(R.id.silver_1year);
        silver_2year = findViewById(R.id.silver_2year);
        silver_3year = findViewById(R.id.silver_3year);
        gold_1year = findViewById(R.id.gold_1year);
        gold_2year = findViewById(R.id.gold_2year);
        gold_3year = findViewById(R.id.gold_3year);
        diamond_1year = findViewById(R.id.diamond_1year);
        diamond_2year = findViewById(R.id.diamond_2year);
        diamond_3year = findViewById(R.id.diamond_3year);

        //Radio Button
        btnradio_silver_1year = findViewById(R.id.btnradio_silver_1year);
        btnradio_silver_2year = findViewById(R.id.btnradio_silver_2year);
        btnradio_silver_3year = findViewById(R.id.btnradio_silver_3year);
        btnradio_gold_1year = findViewById(R.id.btnradio_gold_1year);
        btnradio_gold_2year = findViewById(R.id.btnradio_gold_2year);
        btnradio_gold_3year = findViewById(R.id.btnradio_gold_3year);
        btnradio_diamond_1year = findViewById(R.id.btnradio_diamond_1year);
        btnradio_diamond_2year = findViewById(R.id.btnradio_diamond_2year);
        btnradio_diamond_3year = findViewById(R.id.btnradio_diamond_3year);

        strByDefaultValue = edt_amount_spinner.getText().toString();

        if (strChild_zone != null){
            if (strByDefaultValue.equals("10 Lakh") && strChild_zone.equals("delhi")){

                silver_1year.setText("7940");
                silver_2year.setText("15880");
                silver_3year.setText("23820");
                gold_1year.setText("8450");
                gold_2year.setText("16900");
                gold_3year.setText("25350");
                diamond_1year.setText("10420");
                diamond_2year.setText("20840");
                diamond_3year.setText("31260");

            }else if (strByDefaultValue.equals("10 Lakh") && strChild_zone.equals("other")){

                silver_1year.setText("7140");
                silver_2year.setText("14280");
                silver_3year.setText("21420");
                gold_1year.setText("7610");
                gold_2year.setText("15220");
                gold_3year.setText("22830");
                diamond_1year.setText("9380");
                diamond_2year.setText("18760");
                diamond_3year.setText("28140");

            }
        }
        else if (zone1 != null) {
            if (strByDefaultValue.equals("10 Lakh") && zone1.equals("delhi")){
                silver_1year.setText("8660");
                silver_2year.setText("17320");
                silver_3year.setText("25980");
                gold_1year.setText("9180");
                gold_2year.setText("18360");
                gold_3year.setText("27540");
                diamond_1year.setText("11170");
                diamond_2year.setText("22340");
                diamond_3year.setText("33510");
            }else if (strByDefaultValue.equals("10 Lakh") && zone1.equals("other")){

                silver_1year.setText("7790");
                silver_2year.setText("15580");
                silver_3year.setText("23370");
                gold_1year.setText("8270");
                gold_2year.setText("16540");
                gold_3year.setText("24810");
                diamond_1year.setText("10050");
                diamond_2year.setText("20100");
                diamond_3year.setText("30150");

            }
        }
        else if(age26 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age26.equals("delhi")){

                silver_1year.setText("10050");
                silver_2year.setText("20100");
                silver_3year.setText("30150");
                gold_1year.setText("10600");
                gold_2year.setText("21200");
                gold_3year.setText("31800");
                diamond_1year.setText("12640");
                diamond_2year.setText("25280");
                diamond_3year.setText("37920");

            }
            else if (strByDefaultValue.equals("10 Lakh") && age26.equals("other")){

                silver_1year.setText("9050");
                silver_2year.setText("18100");
                silver_3year.setText("27150");
                gold_1year.setText("9540");
                gold_2year.setText("19080");
                gold_3year.setText("28620");
                diamond_1year.setText("11380");
                diamond_2year.setText("22760");
                diamond_3year.setText("34140");

            }

        }
        else if(age31 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age31.equals("delhi")) {
                silver_1year.setText("10050");
                silver_2year.setText("20100");
                silver_3year.setText("30150");
                gold_1year.setText("10600");
                gold_2year.setText("21200");
                gold_3year.setText("31800");
                diamond_1year.setText("12640");
                diamond_2year.setText("25280");
                diamond_3year.setText("37920");

            } else if (strByDefaultValue.equals("10 Lakh") && age31.equals("other")) {

                silver_1year.setText("9050");
                silver_2year.setText("18100");
                silver_3year.setText("27150");
                gold_1year.setText("9540");
                gold_2year.setText("19080");
                gold_3year.setText("28620");
                diamond_1year.setText("11380");
                diamond_2year.setText("22760");
                diamond_3year.setText("34140");

            }


        }
        else if(age36 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age36.equals("delhi")) {
                String Sliver36="11610";
                String Gold36="12170";
                String Diamond36="14280";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            } else if (strByDefaultValue.equals("10 Lakh") && age36.equals("other")) {
                String Sliver36="10450";
                String Gold36="10960";
                String Diamond36="12860";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            }

        }
        else if (age41 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age41.equals("delhi")) {
                String Sliver36="12710";
                String Gold36="13290";
                String Diamond36="15450";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            } else if (strByDefaultValue.equals("10 Lakh") && age41.equals("other")) {
                String Sliver36="11440";
                String Gold36="11960";
                String Diamond36="13910";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));

            }

        }
        else if (age46 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age46.equals("delhi")) {
                String Sliver36="15480";
                String Gold36="16080";
                String Diamond36="18340";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            } else if (strByDefaultValue.equals("10 Lakh") && age46.equals("other")) {
                String Sliver36="13930";
                String Gold36="14470";
                String Diamond36="16510";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));

            }

        }
        else if (age51 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age51.equals("delhi")) {
                String Sliver36="20400";
                String Gold36="21070";
                String Diamond36="23550";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            } else if (strByDefaultValue.equals("10 Lakh") && age51.equals("other")) {
                String Sliver36="18360";
                String Gold36="18960";
                String Diamond36="21200";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));

            }

        }
        else if (age56 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age56.equals("delhi")) {
                String Sliver36="27090";
                String Gold36="27840";
                String Diamond36="30630";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            } else if (strByDefaultValue.equals("10 Lakh") && age56.equals("other")) {
                String Sliver36="24380";
                String Gold36="25060";
                String Diamond36="27570";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            }

        }
        else if (age61 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age61.equals("delhi")) {
                String Sliver36="37490";
                String Gold36="38380";
                String Diamond36="41660";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            } else if (strByDefaultValue.equals("10 Lakh") && age61.equals("other")) {
                String Sliver36="33740";
                String Gold36="34550";
                String Diamond36="37490";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            }

        }
        else if (age66 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age66.equals("delhi")) {
                String Sliver36="51080";
                String Gold36="52190";
                String Diamond36="56090";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));

            } else if (strByDefaultValue.equals("10 Lakh") && age66.equals("other")) {
                String Sliver36="45980";
                String Gold36="46970";
                String Diamond36="50480";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            }

        }
        else if (age71 != null) {
            if (strByDefaultValue.equals("10 Lakh") && age71.equals("delhi")) {
                String Sliver36="77790";
                String Gold36="79260";
                String Diamond36="84410";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            } else if (strByDefaultValue.equals("10 Lakh") && age71.equals("other")) {
                String Sliver36="51890";
                String Gold36="52990";
                String Diamond36="56920";
                int sliver2= Integer.parseInt(Sliver36)*2;
                int sliver3= Integer.parseInt(Sliver36)*3;
                int Gold362= Integer.parseInt(Gold36)*2;
                int Gold363= Integer.parseInt(Gold36)*3;
                int diamond2= Integer.parseInt(Diamond36)*2;
                int diamond3= Integer.parseInt(Diamond36)*3;
                silver_1year.setText(Sliver36);
                silver_2year.setText(String.valueOf(sliver2));
                silver_3year.setText(String.valueOf(sliver3));
                gold_1year.setText(Gold36);
                gold_2year.setText(String.valueOf(Gold362));
                gold_3year.setText(String.valueOf(Gold363));
                diamond_1year.setText(Diamond36);
                diamond_2year.setText(String.valueOf(diamond2));
                diamond_3year.setText(String.valueOf(diamond3));
            }

        }
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!strGenderEditSpinner.equals("3 Lakh") && !strGenderEditSpinner.equals("5 Lakh") && !strGenderEditSpinner.equals("7 . 5 Lakh") && !strByDefaultValue.equals("10 Lakh") && !strGenderEditSpinner.equals("12 . 5 Lakh") && !strGenderEditSpinner.equals("15 Lakh") && !strGenderEditSpinner.equals("20 Lakh") && !strGenderEditSpinner.equals("25 Lakh") && !strGenderEditSpinner.equals("50 Lakh") && !strGenderEditSpinner.equals("75 Lakh") && !strGenderEditSpinner.equals("1 Crore") ){

                    Toast.makeText(CalculatorPlanDetails.this, "Please Select Amount", Toast.LENGTH_SHORT).show();

                }else  if (!btnradio_silver_1year.isChecked() && !btnradio_silver_2year.isChecked() && !btnradio_silver_3year.isChecked() && !btnradio_gold_1year.isChecked() && !btnradio_gold_2year.isChecked() && !btnradio_gold_3year.isChecked() && !btnradio_diamond_1year.isChecked() && !btnradio_diamond_2year.isChecked() && !btnradio_diamond_3year.isChecked()){

                    Toast.makeText(CalculatorPlanDetails.this, "Please Select Silver,Gold or Diamond Plan", Toast.LENGTH_SHORT).show();

                }else {

                    final Dialog viewBottomSheet = new Dialog(CalculatorPlanDetails.this);
                    viewBottomSheet.setCanceledOnTouchOutside(false);
                    viewBottomSheet.setCancelable(false);
                    viewBottomSheet.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Objects.requireNonNull(viewBottomSheet.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    viewBottomSheet.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation1;
                    viewBottomSheet.setContentView(R.layout.health_bottom_addons);
                    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                    lp.copyFrom(viewBottomSheet.getWindow().getAttributes());
                    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                    lp.gravity = Gravity.BOTTOM;
                    viewBottomSheet.getWindow().setAttributes(lp);

                    Log.d("wyew", "onCreate: " +spouse_checked+"   " +mother_checkbox + "   "+motherlaw_checkbox);

                    ImageView bottomCancel = viewBottomSheet.findViewById(R.id.bottomCancel);
                    TextView txtPrice = viewBottomSheet.findViewById(R.id.MaternityChildcarePremiumTxt);
                    TextView total_premium = viewBottomSheet.findViewById(R.id.TotalPremium);
                    TextView non_medical = viewBottomSheet.findViewById(R.id.non_medical);
                    TextView meternity_text = viewBottomSheet.findViewById(R.id.meternity_text);
                    LinearLayout maternity_linear = viewBottomSheet.findViewById(R.id.maternity_linear);
                    LinearLayout  linear_diabetes = viewBottomSheet.findViewById(R.id.linear_diabetes);
                    LinearLayout  hypertension = viewBottomSheet.findViewById(R.id.hypertension);
                    TextView  diabetes_text = viewBottomSheet.findViewById(R.id.diabetes_text);
                    TextView  text_hypertension = viewBottomSheet.findViewById(R.id.text_hypertension);
                    CheckBox disease_checkbox = viewBottomSheet.findViewById(R.id.disease_checkbox);
                    CheckBox medical_item_checkbox = viewBottomSheet.findViewById(R.id.medical_item_checkbox);
                    CheckBox maternity_checkbox = viewBottomSheet.findViewById(R.id.maternity_checkbox);
                    CheckBox diabetes_checkbox = viewBottomSheet.findViewById(R.id.diabetes_checkbox);
                    CheckBox hypertension_checkbox = viewBottomSheet.findViewById(R.id.hypertension_checkbox);


                    if (strDisease_checkbox.equals("")) {
                        disease_checkbox.setChecked(false);

                    } else if (strDisease_checkbox.equals("Checked")) {
                        disease_checkbox.setChecked(true);

                    } else {
                        disease_checkbox.setChecked(false);

                    }

                    if (strNonMedical.equals("")) {
                        medical_item_checkbox.setChecked(false);

                    } else if (strNonMedical.equals("Checked")) {
                        medical_item_checkbox.setChecked(true);

                    } else {
                        medical_item_checkbox.setChecked(false);

                    }

                    if (strMaternityCover.equals("")){
                        maternity_checkbox.setChecked(false);
                    }else if (strMaternityCover.equals("Checked")){
                        maternity_checkbox.setChecked(true);
                    }else{
                        maternity_checkbox.setChecked(false);
                    }
                    if (strDabetes_checkbox.equals("")){
                        diabetes_checkbox.setChecked(false);
                    }else if (strDabetes_checkbox.equals("Checked")){
                        diabetes_checkbox.setChecked(true);
                    }else{
                        diabetes_checkbox.setChecked(false);
                    }
                    if (strHypertension.equals("")){
                        hypertension_checkbox.setChecked(false);
                    }else if (strHypertension.equals("Checked")){
                        hypertension_checkbox.setChecked(true);
                    }else{
                        hypertension_checkbox.setChecked(false);
                    }




                    disease_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                            if (disease_checkbox.isChecked()){

                                strDisease_checkbox = "Checked";

                                selected_amount = selected_amount + planAmount;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value = add_ons_value + planAmount;



                            }else{

                                strDisease_checkbox = "Unchecked";
                                selected_amount = selected_amount - planAmount;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value = add_ons_value-planAmount;



                            }

                        }
                    });

                    medical_item_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                            if (medical_item_checkbox.isChecked()){

                                strNonMedical = "Checked";
                                selected_amount = selected_amount + nonMedical;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value = add_ons_value +nonMedical;




                            }else{
                                strNonMedical = "Unchecked";
                                selected_amount = selected_amount - nonMedical;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value = add_ons_value - nonMedical;



                            }

                        }
                    });
                    if(gender.equals("Female")){
                        maternity_linear.setVisibility(View.VISIBLE);
                    }else{
                        maternity_linear.setVisibility(View.GONE);
                    }
                    maternity_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                            if (maternity_checkbox.isChecked() && gender.equals("Female")){
                                strHypertension = "Checked";
                                selected_amount = selected_amount + meternityCover;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value = add_ons_value+meternityCover;



                            }else if (maternity_checkbox.isChecked() && gender.equals("Male")){
                                strHypertension = "Unchecked";
                                maternity_checkbox.setChecked(false);
                                maternity_checkbox.setFocusable(false);
                                maternity_checkbox.setClickable(false);
                                maternity_checkbox.setFocusableInTouchMode(false);
                                Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();


                            }

                            else{
                                selected_amount = selected_amount - meternityCover;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value = add_ons_value - meternityCover;

                            }

                        }
                    });

                    diabetes_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                            if (diabetes_checkbox.isChecked()){
                                strDabetes_checkbox = "Checked";
                                selected_amount = selected_amount + Diabetes;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value = add_ons_value+Diabetes;



                            }else{
                                strDabetes_checkbox = "Unchecked";
                                selected_amount = selected_amount - Diabetes;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value = add_ons_value - Diabetes;

                            }

                        }
                    });

                    hypertension_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                            if (hypertension_checkbox.isChecked()){
                                strMaternityCover = "Checked";
                                selected_amount = selected_amount + Hypertension;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value =  add_ons_value+Hypertension;


                            }else{
                                strMaternityCover = "Unchecked";
                                selected_amount = selected_amount - Hypertension;
                                total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                                add_ons_value =  add_ons_value - Hypertension;

                            }

                        }
                    });


                    txtPrice.setText("\u20B9 "+planAmount);
                    non_medical.setText("\u20B9" +nonMedical);
                    total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                    meternity_text.setText("\u20B9" +meternityCover);

                    if (btnradio_diamond_1year.isChecked()){

                        linear_diabetes.setVisibility(View.VISIBLE);
                        hypertension.setVisibility(View.VISIBLE);

                        txtPrice.setText("\u20B9 "+planAmount);
                        total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                        non_medical.setText("\u20B9" +nonMedical);
                        meternity_text.setText("\u20B9" +meternityCover);
                        diabetes_text.setText("\u20B9" +Diabetes);
                        text_hypertension.setText("\u20B9" +Hypertension);

                    }else if (btnradio_diamond_2year.isChecked()){

                        linear_diabetes.setVisibility(View.VISIBLE);
                        hypertension.setVisibility(View.VISIBLE);

                        txtPrice.setText("\u20B9 "+planAmount);
                        total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                        non_medical.setText("\u20B9" +nonMedical);
                        meternity_text.setText("\u20B9" +meternityCover);
                        diabetes_text.setText("\u20B9" +Diabetes);
                        text_hypertension.setText("\u20B9" +Hypertension);

                    }else if (btnradio_diamond_3year.isChecked()){

                        linear_diabetes.setVisibility(View.VISIBLE);
                        hypertension.setVisibility(View.VISIBLE);

                        txtPrice.setText("\u20B9 "+planAmount);
                        total_premium.setText("\u20B9" +currencyFormat(selected_amount));
                        non_medical.setText("\u20B9" +nonMedical);
                        meternity_text.setText("\u20B9" +meternityCover);
                        diabetes_text.setText("\u20B9" +Diabetes);
                        text_hypertension.setText("\u20B9" +Hypertension);

                    }



                    LinearLayout continueButton = viewBottomSheet.findViewById(R.id.continueButton);

                    continueButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewBottomSheet.dismiss();

                            final Dialog discountBottomSheet = new Dialog(CalculatorPlanDetails.this);
                            discountBottomSheet.setCanceledOnTouchOutside(false);
                            discountBottomSheet.setCancelable(false);
                            discountBottomSheet.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            Objects.requireNonNull(discountBottomSheet.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                            discountBottomSheet.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation1;
                            discountBottomSheet.setContentView(R.layout.health_bottom_discount);
                            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                            lp.copyFrom(discountBottomSheet.getWindow().getAttributes());
                            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                            lp.gravity = Gravity.BOTTOM;
                            discountBottomSheet.getWindow().setAttributes(lp);

                            ImageView bottomCancelDis = discountBottomSheet.findViewById(R.id.bottomCancelDis);
                            LinearLayout continueButtonDis = discountBottomSheet.findViewById(R.id.continueButtonDis);
                            LinearLayout longturm_discount = discountBottomSheet.findViewById(R.id.longturm_discount);
                            TextView text_channel_discount = discountBottomSheet.findViewById(R.id.text_channel_discount);
                            TextView text_women_discount = discountBottomSheet.findViewById(R.id.text_women_discount);
                            LinearLayout woment_discount_linear = discountBottomSheet.findViewById(R.id.woment_discount_linear);
                            TextView text_longterm_discount = discountBottomSheet.findViewById(R.id.text_longterm_discount);
                            TextView discount_totalpremium = discountBottomSheet.findViewById(R.id.discount_totalpremium);
                            CheckBox direct_channel_checkbox = discountBottomSheet.findViewById(R.id.direct_channel_checkbox);
                            CheckBox checkbox_women_discount = discountBottomSheet.findViewById(R.id.checkbox_women_discount);
                            CheckBox longturm_checkbox = discountBottomSheet.findViewById(R.id.longturm_checkbox);

                            discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));




                            if (btnradio_silver_1year.isChecked()){

                                add = selected_amount*15/100 ;
                                women_discount = selected_amount*5/100;
                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_women_discount.setText("\u20b9" + currencyFormat(women_discount));

                                longturm_discount.setVisibility(View.GONE);
                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){

                                        //   add = selected_amount*15/100 ;

                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));
                                        discount_checkbox = discount_checkbox-add;

                                    }else{

                                        selected_amount = selected_amount + add;
                                        discount_checkbox = discount_checkbox + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }

                                }
                            });
                            if(gender.equals("Female")){
                                woment_discount_linear.setVisibility(View.VISIBLE);
                            }else{
                                woment_discount_linear.setVisibility(View.GONE);
                            }
                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){

                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                    }


                                }
                            });


                            if (btnradio_silver_2year.isChecked()){

                                add = selected_amount*15/100 ;
                                long_discount = selected_amount*2.5/100;
                                double_convert = (int)long_discount;

                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_longterm_discount.setText("\u20b9" + currencyFormat(double_convert));
                                longturm_discount.setVisibility(View.VISIBLE);

                                longturm_checkbox.setChecked(true);
                                selected_amount = selected_amount - double_convert;
                                discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){

                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }else{

                                        selected_amount = selected_amount + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }

                                }
                            });

                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){

                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                    }


                                }
                            });



                          /*  longturm_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (longturm_checkbox.isChecked()){

                                        selected_amount = selected_amount - double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }else {

                                        selected_amount = selected_amount + double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }

                                }
                            });
*/
                            if (btnradio_silver_3year.isChecked()){

                                add = selected_amount*15/100 ;
                                long_discount = selected_amount*5/100;
                                double_convert = (int)long_discount;
                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_longterm_discount.setText("\u20b9" + currencyFormat(double_convert));
                                longturm_discount.setVisibility(View.VISIBLE);

                                longturm_checkbox.setChecked(true);
                                selected_amount = selected_amount - double_convert;
                                discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){

                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }else{

                                        selected_amount = selected_amount + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }

                                }
                            });

                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){

                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                    }

                                }
                            });
/*
                            longturm_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (longturm_checkbox.isChecked()){

                                        selected_amount = selected_amount - double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }else {

                                        selected_amount = selected_amount + double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }

                                }
                            });
*/

                            if (btnradio_gold_1year.isChecked()){

                                add = selected_amount*15/100 ;
                                women_discount = selected_amount*5/100;
                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_women_discount.setText("\u20b9" + currencyFormat(women_discount));

                                longturm_discount.setVisibility(View.GONE);
                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){
                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }else{
                                        selected_amount = selected_amount + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }

                                }
                            });
                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){
                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                    }


                                }
                            });


                            if (btnradio_gold_2year.isChecked()){

                                add = selected_amount*15/100 ;
                                long_discount = selected_amount*2.5/100;
                                double_convert = (int)long_discount;
                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_longterm_discount.setText("\u20b9" + currencyFormat(double_convert));
                                longturm_discount.setVisibility(View.VISIBLE);

                                longturm_checkbox.setChecked(true);
                                selected_amount = selected_amount - double_convert;
                                discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){
                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }else{
                                        selected_amount = selected_amount + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }

                                }
                            });

                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){
                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                    }


                                }
                            });

/*
                            longturm_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (longturm_checkbox.isChecked()){

                                        selected_amount = selected_amount - double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }else {

                                        selected_amount = selected_amount + double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }

                                }
                            });
*/

                            if (btnradio_gold_3year.isChecked()){

                                add = selected_amount*15/100 ;
                                long_discount = selected_amount*5/100;
                                double_convert = (int)long_discount;
                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_longterm_discount.setText("\u20b9" + currencyFormat(double_convert));
                                longturm_discount.setVisibility(View.VISIBLE);

                                longturm_checkbox.setChecked(true);
                                selected_amount = selected_amount - double_convert;
                                discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){
                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }else{
                                        selected_amount = selected_amount + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }

                                }
                            });

                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){
                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                    }

                                }
                            });
/*
                            longturm_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (longturm_checkbox.isChecked()){

                                        selected_amount = selected_amount - double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }else {

                                        selected_amount = selected_amount + double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }

                                }
                            });
*/

                            if (btnradio_diamond_1year.isChecked()){

                                add = selected_amount*15/100 ;
                                women_discount = selected_amount*5/100;
                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_women_discount.setText("\u20b9" + currencyFormat(women_discount));

                                longturm_discount.setVisibility(View.GONE);
                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){
                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }else{
                                        selected_amount = selected_amount + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }

                                }
                            });
                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){
                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                    }


                                }
                            });


                            if (btnradio_diamond_2year.isChecked()){

                                add = selected_amount*15/100 ;
                                long_discount = selected_amount*2.5/100;
                                double_convert = (int)long_discount;

                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_longterm_discount.setText("\u20b9" + currencyFormat(double_convert));
                                longturm_discount.setVisibility(View.VISIBLE);

                                longturm_checkbox.setChecked(true);
                                selected_amount = selected_amount - double_convert;
                                discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){
                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }else{
                                        selected_amount = selected_amount + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));

                                    }

                                }
                            });

                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){
                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                    }


                                }
                            });

/*
                            longturm_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (longturm_checkbox.isChecked()){

                                        selected_amount = selected_amount - double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                        discount_value = discount_value - add;

                                    }else {

                                        selected_amount = selected_amount + double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                        discount_value = discount_value + add;

                                    }

                                }
                            });
*/

                            if (btnradio_diamond_3year.isChecked()){

                                add = selected_amount*15/100 ;
                                long_discount = selected_amount*5/100;
                                double_convert = (int)long_discount;
                                text_channel_discount.setText("\u20b9" + currencyFormat(add));
                                text_longterm_discount.setText("\u20b9" + currencyFormat(double_convert));
                                longturm_discount.setVisibility(View.VISIBLE);

                                longturm_checkbox.setChecked(true);
                                selected_amount = selected_amount - double_convert;
                                discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                            }
                            direct_channel_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (direct_channel_checkbox.isChecked()){
                                        selected_amount = selected_amount - add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));
                                        discount_value = discount_value - add;

                                        Log.d("vdgf", "onCheckedChanged: "+discount_value);

                                    }else{
                                        selected_amount = selected_amount + add;
                                        discount_totalpremium.setText("\u20B9" +currencyFormat(selected_amount));
                                        discount_value = discount_value + add;

                                    }

                                }
                            });

                            checkbox_women_discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (b && gender.equals("Female")){
                                        selected_amount = selected_amount - women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                        discount_value = discount_value - add;


                                    }else if (b && gender.equals("Male")){
                                        checkbox_women_discount.setChecked(false);
                                        checkbox_women_discount.setFocusable(false);
                                        checkbox_women_discount.setClickable(false);
                                        checkbox_women_discount.setFocusableInTouchMode(false);
                                        Toast.makeText(CalculatorPlanDetails.this, "This Discount Only For Female", Toast.LENGTH_SHORT).show();

                                    }
                                    else{

                                        selected_amount = selected_amount + women_discount;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));
                                        discount_value = discount_value + add;
                                    }

                                }
                            });
/*
                            longturm_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                    if (longturm_checkbox.isChecked()){

                                        selected_amount = selected_amount - double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }else {

                                        selected_amount = selected_amount + double_convert;
                                        discount_totalpremium.setText("\u20B9" + currencyFormat(selected_amount));

                                    }

                                }
                            });
*/


                            bottomCancelDis.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    btnradio_silver_1year.setChecked(false);
                                    btnradio_silver_2year.setChecked(false);
                                    btnradio_silver_3year.setChecked(false);
                                    btnradio_gold_1year.setChecked(false);
                                    btnradio_gold_2year.setChecked(false);
                                    btnradio_gold_3year.setChecked(false);
                                    btnradio_diamond_1year.setChecked(false);
                                    btnradio_diamond_2year.setChecked(false);
                                    btnradio_diamond_3year.setChecked(false);




                                    discountBottomSheet.dismiss();






                                }
                            });





                            continueButtonDis.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    discountBottomSheet.dismiss();
                                    Intent intent = new Intent(CalculatorPlanDetails.this,  CalculatorPlanDetails.class);
                                    intent.putExtra("sum_insured",strGenderEditSpinner);
                                    intent.putExtra("plan_type" , selected_type);
                                    intent.putExtra("policy_tenure" , selected_year);
                                    intent.putExtra("add_ons",add_ons_value);
                                    intent.putExtra("discount",discount_value);
                                    intent.putExtra("total_premium", currencyFormat(selected_amount));
                                    startActivity(intent);
                                }
                            });



                            discountBottomSheet.show();
                        }
                    });

                    bottomCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewBottomSheet.dismiss();
                        }
                    });
                    viewBottomSheet.show();

                }

            }
        });
        amount_dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyOptionsPickerView singlePicker = new MyOptionsPickerView(CalculatorPlanDetails.this);
                final ArrayList<String> items1 = new ArrayList<String>();

                btnradio_silver_1year.setChecked(false);
                btnradio_silver_2year.setChecked(false);
                btnradio_silver_3year.setChecked(false);
                btnradio_gold_1year.setChecked(false);
                btnradio_gold_2year.setChecked(false);
                btnradio_gold_3year.setChecked(false);
                btnradio_diamond_1year.setChecked(false);
                btnradio_diamond_2year.setChecked(false);
                btnradio_diamond_3year.setChecked(false);

                items1.add("3 Lakh");
                items1.add("5 Lakh");
                items1.add("7 . 5 Lakh");
                items1.add("10 Lakh");
                items1.add("12 . 5 Lakh");
                items1.add("15 Lakh");
                items1.add("20 Lakh");
                items1.add("25 Lakh");
                items1.add("50 Lakh");
                items1.add("75 Lakh");
                items1.add("1 Crore");
                singlePicker.setPicker(items1);
                singlePicker.setCyclic(false);
                singlePicker.setSelectOptions(0);
                singlePicker.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        strGenderEditSpinner=items1.get(options1);
                        edt_amount_spinner.setText(strGenderEditSpinner);
                        if (strChild_zone != null){

                            if (strGenderEditSpinner.equals("3 Lakh") && strChild_zone.equals("delhi")){
                                silver_1year.setText("3950");
                                silver_2year.setText("7900");
                                silver_3year.setText("11850");
                                gold_1year.setText("4410");
                                gold_2year.setText("8820");
                                gold_3year.setText("13230");
                                diamond_1year.setText("6210");
                                diamond_2year.setText("12420");
                                diamond_3year.setText("18630");


                            }else if (strGenderEditSpinner.equals("5 Lakh") && strChild_zone.equals("delhi")) {

                                silver_1year.setText("4940");
                                silver_2year.setText("9880");
                                silver_3year.setText("14820");
                                gold_1year.setText("5420");
                                gold_2year.setText("10840");
                                gold_3year.setText("16260");
                                diamond_1year.setText("7270");
                                diamond_2year.setText("14540");
                                diamond_3year.setText("21810");

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && strChild_zone.equals("delhi")){

                                silver_1year.setText("6100");
                                silver_2year.setText("12200");
                                silver_3year.setText("18300");
                                gold_1year.setText("6590");
                                gold_2year.setText("13180");
                                gold_3year.setText("19770");
                                diamond_1year.setText("8490");
                                diamond_2year.setText("16980");
                                diamond_3year.setText("25470");

                            }else if (strGenderEditSpinner.equals("10 Lakh") && strChild_zone.equals("delhi")){

                                silver_1year.setText("7940");
                                silver_2year.setText("15880");
                                silver_3year.setText("23820");
                                gold_1year.setText("8450");
                                gold_2year.setText("16900");
                                gold_3year.setText("25350");
                                diamond_1year.setText("10420");
                                diamond_2year.setText("20840");
                                diamond_3year.setText("31260");

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && strChild_zone.equals("delhi")){

                                silver_1year.setText("8440");
                                silver_2year.setText("16880");
                                silver_3year.setText("25320");
                                gold_1year.setText("8960");
                                gold_2year.setText("17920");
                                gold_3year.setText("26880");
                                diamond_1year.setText("10940");
                                diamond_2year.setText("21880");
                                diamond_3year.setText("32820");

                            }else if (strGenderEditSpinner.equals("15 Lakh") && strChild_zone.equals("delhi")){

                                silver_1year.setText("9660");
                                silver_2year.setText("19320");
                                silver_3year.setText("28980");
                                gold_1year.setText("10190");
                                gold_2year.setText("20380");
                                gold_3year.setText("30570");
                                diamond_1year.setText("12210");
                                diamond_2year.setText("24420");
                                diamond_3year.setText("36630");

                            }else if (strGenderEditSpinner.equals("20 Lakh") && strChild_zone.equals("delhi")){

                                silver_1year.setText("10330");
                                silver_2year.setText("20660");
                                silver_3year.setText("30990");
                                gold_1year.setText("10860");
                                gold_2year.setText("21720");
                                gold_3year.setText("32580");
                                diamond_1year.setText("12900");
                                diamond_2year.setText("25800");
                                diamond_3year.setText("38700");

                            }else if (strGenderEditSpinner.equals("25 Lakh") && strChild_zone.equals("delhi")){

                                silver_1year.setText("10680");
                                silver_2year.setText("21360");
                                silver_3year.setText("32040");
                                gold_1year.setText("11220");
                                gold_2year.setText("22440");
                                gold_3year.setText("33660");
                                diamond_1year.setText("13260");
                                diamond_2year.setText("26520");
                                diamond_3year.setText("39780");

                            }else if (strGenderEditSpinner.equals("50 Lakh") && strChild_zone.equals("delhi")){

                                silver_1year.setText("11180");
                                silver_2year.setText("22360");
                                silver_3year.setText("33540");
                                gold_1year.setText("11730");
                                gold_2year.setText("23460");
                                gold_3year.setText("35190");
                                diamond_1year.setText("13800");
                                diamond_2year.setText("27600");
                                diamond_3year.setText("41400");

                            }else if (strGenderEditSpinner.equals("75 Lakh") && strChild_zone.equals("delhi")){

                                silver_1year.setText("12130");
                                silver_2year.setText("24260");
                                silver_3year.setText("36390");
                                gold_1year.setText("12690");
                                gold_2year.setText("25380");
                                gold_3year.setText("38070");
                                diamond_1year.setText("14800");
                                diamond_2year.setText("29600");
                                diamond_3year.setText("44400");

                            }else if (strGenderEditSpinner.equals("1 Crore") && strChild_zone.equals("delhi")){

                                silver_1year.setText("12890");
                                silver_2year.setText("25780");
                                silver_3year.setText("38670");
                                gold_1year.setText("13460");
                                gold_2year.setText("26920");
                                gold_3year.setText("40380");
                                diamond_1year.setText("15600");
                                diamond_2year.setText("31200");
                                diamond_3year.setText("46800");

                            }else if (strGenderEditSpinner.equals("3 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("3550");
                                silver_2year.setText("7100");
                                silver_3year.setText("10650");
                                gold_1year.setText("3970");
                                gold_2year.setText("7940");
                                gold_3year.setText("11910");
                                diamond_1year.setText("5590");
                                diamond_2year.setText("11180");
                                diamond_3year.setText("16770");

                            }else if (strGenderEditSpinner.equals("5 Lakh") && strChild_zone.equals("other")) {

                                silver_1year.setText("4450");
                                silver_2year.setText("8900");
                                silver_3year.setText("13350");
                                gold_1year.setText("4880");
                                gold_2year.setText("9760");
                                gold_3year.setText("14640");
                                diamond_1year.setText("6540");
                                diamond_2year.setText("13080");
                                diamond_3year.setText("19620");

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("5490");
                                silver_2year.setText("10980");
                                silver_3year.setText("16470");
                                gold_1year.setText("5930");
                                gold_2year.setText("11860");
                                gold_3year.setText("17790");
                                diamond_1year.setText("7640");
                                diamond_2year.setText("15280");
                                diamond_3year.setText("22920");

                            }else if (strGenderEditSpinner.equals("10 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("7140");
                                silver_2year.setText("14280");
                                silver_3year.setText("21420");
                                gold_1year.setText("7610");
                                gold_2year.setText("15220");
                                gold_3year.setText("22830");
                                diamond_1year.setText("9380");
                                diamond_2year.setText("18760");
                                diamond_3year.setText("28140");

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("7600");
                                silver_2year.setText("15200");
                                silver_3year.setText("22800");
                                gold_1year.setText("8070");
                                gold_2year.setText("16140");
                                gold_3year.setText("24210");
                                diamond_1year.setText("9850");
                                diamond_2year.setText("19700");
                                diamond_3year.setText("29550");

                            }else if (strGenderEditSpinner.equals("15 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("8690");
                                silver_2year.setText("17380");
                                silver_3year.setText("26070");
                                gold_1year.setText("9170");
                                gold_2year.setText("18340");
                                gold_3year.setText("27510");
                                diamond_1year.setText("10990");
                                diamond_2year.setText("21980");
                                diamond_3year.setText("32970");

                            }else if (strGenderEditSpinner.equals("20 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("9290");
                                silver_2year.setText("18580");
                                silver_3year.setText("27870");
                                gold_1year.setText("9780");
                                gold_2year.setText("19560");
                                gold_3year.setText("29340");
                                diamond_1year.setText("11610");
                                diamond_2year.setText("23220");
                                diamond_3year.setText("34830");

                            }else if (strGenderEditSpinner.equals("25 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("9610");
                                silver_2year.setText("19220");
                                silver_3year.setText("28830");
                                gold_1year.setText("10090");
                                gold_2year.setText("20180");
                                gold_3year.setText("30270");
                                diamond_1year.setText("11940");
                                diamond_2year.setText("23880");
                                diamond_3year.setText("35820");

                            }else if (strGenderEditSpinner.equals("50 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("10060");
                                silver_2year.setText("20120");
                                silver_3year.setText("30180");
                                gold_1year.setText("10560");
                                gold_2year.setText("21120");
                                gold_3year.setText("31680");
                                diamond_1year.setText("12420");
                                diamond_2year.setText("24840");
                                diamond_3year.setText("37260");

                            }else if (strGenderEditSpinner.equals("75 Lakh") && strChild_zone.equals("other")){

                                silver_1year.setText("10920");
                                silver_2year.setText("21840");
                                silver_3year.setText("32760");
                                gold_1year.setText("11420");
                                gold_2year.setText("22840");
                                gold_3year.setText("34260");
                                diamond_1year.setText("13320");
                                diamond_2year.setText("26640");
                                diamond_3year.setText("39960");

                            }else if (strGenderEditSpinner.equals("1 Crore") && strChild_zone.equals("other")) {

                                silver_1year.setText("11600");
                                silver_2year.setText("23200");
                                silver_3year.setText("34800");
                                gold_1year.setText("12110");
                                gold_2year.setText("24220");
                                gold_3year.setText("36330");
                                diamond_1year.setText("14040");
                                diamond_2year.setText("28080");
                                diamond_3year.setText("42120");
                            }

                        }
                        else if (zone1 != null){
                            if (strGenderEditSpinner.equals("3 Lakh") && zone1.equals("delhi")){
                                silver_1year.setText("4270");
                                silver_2year.setText("8540");
                                silver_3year.setText("12810");
                                gold_1year.setText("4740");
                                gold_2year.setText("9480");
                                gold_3year.setText("14220");
                                diamond_1year.setText("6550");
                                diamond_2year.setText("13100");
                                diamond_3year.setText("19650");


                            }else if (strGenderEditSpinner.equals("5 Lakh") && zone1.equals("delhi")) {

                                silver_1year.setText("5360");
                                silver_2year.setText("10720");
                                silver_3year.setText("16080");
                                gold_1year.setText("5850");
                                gold_2year.setText("11700");
                                gold_3year.setText("17550");
                                diamond_1year.setText("7700");
                                diamond_2year.setText("15400");
                                diamond_3year.setText("23100");

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && zone1.equals("delhi")){

                                silver_1year.setText("6640");
                                silver_2year.setText("13280");
                                silver_3year.setText("19920");
                                gold_1year.setText("7140");
                                gold_2year.setText("14280");
                                gold_3year.setText("21420");
                                diamond_1year.setText("9050");
                                diamond_2year.setText("18100");
                                diamond_3year.setText("27150");

                            }else if (strGenderEditSpinner.equals("10 Lakh") && zone1.equals("delhi")){

                                silver_1year.setText("8660");
                                silver_2year.setText("17320");
                                silver_3year.setText("25980");
                                gold_1year.setText("9180");
                                gold_2year.setText("18360");
                                gold_3year.setText("27540");
                                diamond_1year.setText("11170");
                                diamond_2year.setText("22340");
                                diamond_3year.setText("33510");

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && zone1.equals("delhi")){

                                silver_1year.setText("9200");
                                silver_2year.setText("18400");
                                silver_3year.setText("27600");
                                gold_1year.setText("9730");
                                gold_2year.setText("19460");
                                gold_3year.setText("29190");
                                diamond_1year.setText("11730");
                                diamond_2year.setText("23460");
                                diamond_3year.setText("35190");

                            }else if (strGenderEditSpinner.equals("15 Lakh") && zone1.equals("delhi")){

                                silver_1year.setText("10040");
                                silver_2year.setText("20080");
                                silver_3year.setText("30120");
                                gold_1year.setText("10580");
                                gold_2year.setText("21160");
                                gold_3year.setText("31740");
                                diamond_1year.setText("12610");
                                diamond_2year.setText("25220");
                                diamond_3year.setText("37830");

                            }else if (strGenderEditSpinner.equals("20 Lakh") && zone1.equals("delhi")){

                                silver_1year.setText("10760");
                                silver_2year.setText("21520");
                                silver_3year.setText("32280");
                                gold_1year.setText("11310");
                                gold_2year.setText("22620");
                                gold_3year.setText("33930");
                                diamond_1year.setText("13350");
                                diamond_2year.setText("21500");
                                diamond_3year.setText("40050");

                            }else if (strGenderEditSpinner.equals("25 Lakh") && zone1.equals("delhi")){

                                silver_1year.setText("11150");
                                silver_2year.setText("22300");
                                silver_3year.setText("33450");
                                gold_1year.setText("11690");
                                gold_2year.setText("23380");
                                gold_3year.setText("35070");
                                diamond_1year.setText("13750");
                                diamond_2year.setText("27500");
                                diamond_3year.setText("41250");

                            }else if (strGenderEditSpinner.equals("50 Lakh") && zone1.equals("delhi")){

                                silver_1year.setText("11180");
                                silver_2year.setText("22360");
                                silver_3year.setText("33540");
                                gold_1year.setText("12310");
                                gold_2year.setText("24620");
                                gold_3year.setText("36930");
                                diamond_1year.setText("14390");
                                diamond_2year.setText("28780");
                                diamond_3year.setText("43170");

                            }else if (strGenderEditSpinner.equals("75 Lakh") && zone1.equals("delhi")){

                                silver_1year.setText("12130");
                                silver_2year.setText("24260");
                                silver_3year.setText("36390");
                                gold_1year.setText("13960");
                                gold_2year.setText("27920");
                                gold_3year.setText("41880");
                                diamond_1year.setText("16100");
                                diamond_2year.setText("32200");
                                diamond_3year.setText("48300");

                            }else if (strGenderEditSpinner.equals("1 Crore") && zone1.equals("delhi")){

                                silver_1year.setText("12890");
                                silver_2year.setText("25780");
                                silver_3year.setText("38670");
                                gold_1year.setText("14800");
                                gold_2year.setText("29600");
                                gold_3year.setText("44400");
                                diamond_1year.setText("16980");
                                diamond_2year.setText("33960");
                                diamond_3year.setText("50940");

                            }else if (strGenderEditSpinner.equals("3 Lakh") && zone1.equals("other")){

                                silver_1year.setText("3840");
                                silver_2year.setText("7680");
                                silver_3year.setText("11520");
                                gold_1year.setText("4260");
                                gold_2year.setText("8520");
                                gold_3year.setText("12780");
                                diamond_1year.setText("5890");
                                diamond_2year.setText("11780");
                                diamond_3year.setText("17670");

                            }else if (strGenderEditSpinner.equals("5 Lakh") && zone1.equals("other")) {

                                silver_1year.setText("4830");
                                silver_2year.setText("9660");
                                silver_3year.setText("14490");
                                gold_1year.setText("5260");
                                gold_2year.setText("10520");
                                gold_3year.setText("15780");
                                diamond_1year.setText("6930");
                                diamond_2year.setText("13860");
                                diamond_3year.setText("20790");

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && zone1.equals("other")){

                                silver_1year.setText("5970");
                                silver_2year.setText("11940");
                                silver_3year.setText("17910");
                                gold_1year.setText("6430");
                                gold_2year.setText("12860");
                                gold_3year.setText("19290");
                                diamond_1year.setText("8150");
                                diamond_2year.setText("16300");
                                diamond_3year.setText("24450");

                            }else if (strGenderEditSpinner.equals("10 Lakh") && zone1.equals("other")){

                                silver_1year.setText("7790");
                                silver_2year.setText("15580");
                                silver_3year.setText("23370");
                                gold_1year.setText("8270");
                                gold_2year.setText("16540");
                                gold_3year.setText("24810");
                                diamond_1year.setText("10050");
                                diamond_2year.setText("20100");
                                diamond_3year.setText("30150");

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && zone1.equals("other")){

                                silver_1year.setText("8280");
                                silver_2year.setText("16560");
                                silver_3year.setText("24840");
                                gold_1year.setText("8760");
                                gold_2year.setText("17520");
                                gold_3year.setText("26280");
                                diamond_1year.setText("10560");
                                diamond_2year.setText("21120");
                                diamond_3year.setText("31680");

                            }else if (strGenderEditSpinner.equals("15 Lakh") && zone1.equals("other")){

                                silver_1year.setText("9040");
                                silver_2year.setText("18080");
                                silver_3year.setText("27120");
                                gold_1year.setText("9520");
                                gold_2year.setText("19040");
                                gold_3year.setText("28560");
                                diamond_1year.setText("11350");
                                diamond_2year.setText("22700");
                                diamond_3year.setText("34050");

                            }else if (strGenderEditSpinner.equals("20 Lakh") && zone1.equals("other")){

                                silver_1year.setText("9690");
                                silver_2year.setText("19380");
                                silver_3year.setText("29070");
                                gold_1year.setText("10180");
                                gold_2year.setText("20360");
                                gold_3year.setText("30540");
                                diamond_1year.setText("12020");
                                diamond_2year.setText("24040");
                                diamond_3year.setText("36060");

                            }else if (strGenderEditSpinner.equals("25 Lakh") && zone1.equals("other")){

                                silver_1year.setText("10030");
                                silver_2year.setText("20060");
                                silver_3year.setText("30090");
                                gold_1year.setText("10520");
                                gold_2year.setText("21040");
                                gold_3year.setText("31560");
                                diamond_1year.setText("12370");
                                diamond_2year.setText("24740");
                                diamond_3year.setText("37110");

                            }else if (strGenderEditSpinner.equals("50 Lakh") && zone1.equals("other")){

                                silver_1year.setText("10580");
                                silver_2year.setText("21160");
                                silver_3year.setText("31740");
                                gold_1year.setText("11080");
                                gold_2year.setText("22160");
                                gold_3year.setText("33240");
                                diamond_1year.setText("12950");
                                diamond_2year.setText("25900");
                                diamond_3year.setText("38850");

                            }else if (strGenderEditSpinner.equals("75 Lakh") && zone1.equals("other")){

                                silver_1year.setText("12040");
                                silver_2year.setText("24080");
                                silver_3year.setText("36120");
                                gold_1year.setText("12560");
                                gold_2year.setText("25120");
                                gold_3year.setText("37680");
                                diamond_1year.setText("14490");
                                diamond_2year.setText("28980");
                                diamond_3year.setText("43470");

                            }else if (strGenderEditSpinner.equals("1 Crore") && zone1.equals("other")) {

                                silver_1year.setText("12790");
                                silver_2year.setText("25580");
                                silver_3year.setText("38370");
                                gold_1year.setText("13320");
                                gold_2year.setText("26640");
                                gold_3year.setText("39960");
                                diamond_1year.setText("15280");
                                diamond_2year.setText("30560");
                                diamond_3year.setText("45840");
                            }
                        }
                        else if (age26 != null){
                            if(strGenderEditSpinner.equals("3 Lakh") && age26.equals("delhi")) {

                                silver_1year.setText("4810");
                                silver_2year.setText("9620");
                                silver_3year.setText("14430");
                                gold_1year.setText("5280");
                                gold_2year.setText("10560");
                                gold_3year.setText("15840");
                                diamond_1year.setText("7120");
                                diamond_2year.setText("14240");
                                diamond_3year.setText("21360");

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("6060");
                                silver_2year.setText("12120");
                                silver_3year.setText("18180");
                                gold_1year.setText("6560");
                                gold_2year.setText("13120");
                                gold_3year.setText("19680");
                                diamond_1year.setText("8450");
                                diamond_2year.setText("16900");
                                diamond_3year.setText("25350");

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("7530");
                                silver_2year.setText("15060");
                                silver_3year.setText("22590");
                                gold_1year.setText("8040");
                                gold_2year.setText("16080");
                                gold_3year.setText("24120");
                                diamond_1year.setText("10000");
                                diamond_2year.setText("20000");
                                diamond_3year.setText("30000");

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("10050");
                                silver_2year.setText("20100");
                                silver_3year.setText("30150");
                                gold_1year.setText("10600");
                                gold_2year.setText("21200");
                                gold_3year.setText("31800");
                                diamond_1year.setText("12640");
                                diamond_2year.setText("25280");
                                diamond_3year.setText("37920");

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("10900");
                                silver_2year.setText("21800");
                                silver_3year.setText("32700");
                                gold_1year.setText("11450");
                                gold_2year.setText("22900");
                                gold_3year.setText("34350");
                                diamond_1year.setText("13520");
                                diamond_2year.setText("27040");
                                diamond_3year.setText("40560");

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("11740");
                                silver_2year.setText("23480");
                                silver_3year.setText("35220");
                                gold_1year.setText("12290");
                                gold_2year.setText("24580");
                                gold_3year.setText("36870");
                                diamond_1year.setText("14370");
                                diamond_2year.setText("28740");
                                diamond_3year.setText("43110");

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("12890");
                                silver_2year.setText("25780");
                                silver_3year.setText("38670");
                                gold_1year.setText("13450");
                                gold_2year.setText("26900");
                                gold_3year.setText("40350");
                                diamond_1year.setText("15540");
                                diamond_2year.setText("31080");
                                diamond_3year.setText("46620");

                            }else if (strGenderEditSpinner.equals("25 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("13300");
                                silver_2year.setText("26600");
                                silver_3year.setText("39900");
                                gold_1year.setText("13860");
                                gold_2year.setText("27720");
                                gold_3year.setText("41580");
                                diamond_1year.setText("15960");
                                diamond_2year.setText("31920");
                                diamond_3year.setText("47880");

                            }else if (strGenderEditSpinner.equals("50 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("13990");
                                silver_2year.setText("27980");
                                silver_3year.setText("41970");
                                gold_1year.setText("14570");
                                gold_2year.setText("29140");
                                gold_3year.setText("43710");
                                diamond_1year.setText("16700");
                                diamond_2year.setText("33400");
                                diamond_3year.setText("50100");

                            }else if (strGenderEditSpinner.equals("75 Lakh") && age26.equals("delhi")){

                                silver_1year.setText("16560");
                                silver_2year.setText("33120");
                                silver_3year.setText("49680");
                                gold_1year.setText("17160");
                                gold_2year.setText("34320");
                                gold_3year.setText("51480");
                                diamond_1year.setText("19390");
                                diamond_2year.setText("38780");
                                diamond_3year.setText("58170");

                            }else if (strGenderEditSpinner.equals("1 Crore") && age26.equals("delhi")){

                                silver_1year.setText("17530");
                                silver_2year.setText("35060");
                                silver_3year.setText("52590");
                                gold_1year.setText("18150");
                                gold_2year.setText("36300");
                                gold_3year.setText("54450");
                                diamond_1year.setText("20410");
                                diamond_2year.setText("40820");
                                diamond_3year.setText("61230");

                            }else if (strGenderEditSpinner.equals("3 Lakh") && age26.equals("other")){

                                silver_1year.setText("4320");
                                silver_2year.setText("8640");
                                silver_3year.setText("12960");
                                gold_1year.setText("4750");
                                gold_2year.setText("9500");
                                gold_3year.setText("14250");
                                diamond_1year.setText("6410");
                                diamond_2year.setText("12820");
                                diamond_3year.setText("19230");

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age26.equals("other")){

                                silver_1year.setText("5460");
                                silver_2year.setText("7636");
                                silver_3year.setText("11454");
                                gold_1year.setText("5900");
                                gold_2year.setText("11800");
                                gold_3year.setText("17700");
                                diamond_1year.setText("7610");
                                diamond_2year.setText("15220");
                                diamond_3year.setText("22830");

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age26.equals("other")){

                                silver_1year.setText("6780");
                                silver_2year.setText("13560");
                                silver_3year.setText("20340");
                                gold_1year.setText("7240");
                                gold_2year.setText("14480");
                                gold_3year.setText("21720");
                                diamond_1year.setText("9000");
                                diamond_2year.setText("18000");
                                diamond_3year.setText("27000");

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age26.equals("other")){

                                silver_1year.setText("9050");
                                silver_2year.setText("18100");
                                silver_3year.setText("27150");
                                gold_1year.setText("9540");
                                gold_2year.setText("19080");
                                gold_3year.setText("28620");
                                diamond_1year.setText("11380");
                                diamond_2year.setText("22760");
                                diamond_3year.setText("34140");

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age26.equals("other")){

                                silver_1year.setText("9810");
                                silver_2year.setText("19620");
                                silver_3year.setText("29430");
                                gold_1year.setText("10310");
                                gold_2year.setText("20620");
                                gold_3year.setText("30930");
                                diamond_1year.setText("12170");
                                diamond_2year.setText("24340");
                                diamond_3year.setText("36510");

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age26.equals("other")){

                                silver_1year.setText("10560");
                                silver_2year.setText("21120");
                                silver_3year.setText("31680");
                                gold_1year.setText("11060");
                                gold_2year.setText("22120");
                                gold_3year.setText("33180");
                                diamond_1year.setText("12930");
                                diamond_2year.setText("25860");
                                diamond_3year.setText("38790");

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age26.equals("other")){

                                silver_1year.setText("11600");
                                silver_2year.setText("23200");
                                silver_3year.setText("34800");
                                gold_1year.setText("12100");
                                gold_2year.setText("24200");
                                gold_3year.setText("36300");
                                diamond_1year.setText("13990");
                                diamond_2year.setText("27980");
                                diamond_3year.setText("41970");

                            }else if (strGenderEditSpinner.equals("25 Lakh") && age26.equals("other")){

                                silver_1year.setText("11970");
                                silver_2year.setText("23940");
                                silver_3year.setText("35910");
                                gold_1year.setText("12480");
                                gold_2year.setText("24960");
                                gold_3year.setText("37440");
                                diamond_1year.setText("14370");
                                diamond_2year.setText("28740");
                                diamond_3year.setText("43110");

                            }else if (strGenderEditSpinner.equals("50 Lakh") && age26.equals("other")){

                                silver_1year.setText("12590");
                                silver_2year.setText("25180");
                                silver_3year.setText("37770");
                                gold_1year.setText("13110");
                                gold_2year.setText("26220");
                                gold_3year.setText("39330");
                                diamond_1year.setText("15030");
                                diamond_2year.setText("30060");
                                diamond_3year.setText("45090");

                            }else if (strGenderEditSpinner.equals("75 Lakh") && age26.equals("other")){

                                silver_1year.setText("14900");
                                silver_2year.setText("29800");
                                silver_3year.setText("44700");
                                gold_1year.setText("15450");
                                gold_2year.setText("30900");
                                gold_3year.setText("46350");
                                diamond_1year.setText("17450");
                                diamond_2year.setText("34900");
                                diamond_3year.setText("52350");

                            }else if (strGenderEditSpinner.equals("1 Crore") && age26.equals("other")){

                                silver_1year.setText("15780");
                                silver_2year.setText("31560");
                                silver_3year.setText("47340");
                                gold_1year.setText("16330");
                                gold_2year.setText("32660");
                                gold_3year.setText("48990");
                                diamond_1year.setText("18370");
                                diamond_2year.setText("36740");
                                diamond_3year.setText("55110");

                            }

                        }
                        else if (age31 != null){

                            if(strGenderEditSpinner.equals("3 Lakh") && age31.equals("delhi")) {

                                silver_1year.setText("4810");
                                silver_2year.setText("9620");
                                silver_3year.setText("14430");
                                gold_1year.setText("5280");
                                gold_2year.setText("10560");
                                gold_3year.setText("15840");
                                diamond_1year.setText("7120");
                                diamond_2year.setText("14240");
                                diamond_3year.setText("21360");

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("6060");
                                silver_2year.setText("12120");
                                silver_3year.setText("18180");
                                gold_1year.setText("6560");
                                gold_2year.setText("13120");
                                gold_3year.setText("19680");
                                diamond_1year.setText("8450");
                                diamond_2year.setText("16900");
                                diamond_3year.setText("25350");

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("7530");
                                silver_2year.setText("15060");
                                silver_3year.setText("22590");
                                gold_1year.setText("8040");
                                gold_2year.setText("16080");
                                gold_3year.setText("24120");
                                diamond_1year.setText("10000");
                                diamond_2year.setText("20000");
                                diamond_3year.setText("30000");

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("10050");
                                silver_2year.setText("20100");
                                silver_3year.setText("30150");
                                gold_1year.setText("10600");
                                gold_2year.setText("21200");
                                gold_3year.setText("31800");
                                diamond_1year.setText("12640");
                                diamond_2year.setText("25280");
                                diamond_3year.setText("37920");

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("10900");
                                silver_2year.setText("21800");
                                silver_3year.setText("32700");
                                gold_1year.setText("11450");
                                gold_2year.setText("22900");
                                gold_3year.setText("34350");
                                diamond_1year.setText("13520");
                                diamond_2year.setText("27040");
                                diamond_3year.setText("40560");

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("11740");
                                silver_2year.setText("23480");
                                silver_3year.setText("35220");
                                gold_1year.setText("12290");
                                gold_2year.setText("24580");
                                gold_3year.setText("36870");
                                diamond_1year.setText("14370");
                                diamond_2year.setText("28740");
                                diamond_3year.setText("43110");

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("12890");
                                silver_2year.setText("25780");
                                silver_3year.setText("38670");
                                gold_1year.setText("13450");
                                gold_2year.setText("26900");
                                gold_3year.setText("40350");
                                diamond_1year.setText("15540");
                                diamond_2year.setText("31080");
                                diamond_3year.setText("46620");

                            }else if (strGenderEditSpinner.equals("25 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("13300");
                                silver_2year.setText("26600");
                                silver_3year.setText("39900");
                                gold_1year.setText("13860");
                                gold_2year.setText("27720");
                                gold_3year.setText("41580");
                                diamond_1year.setText("15960");
                                diamond_2year.setText("31920");
                                diamond_3year.setText("47880");

                            }else if (strGenderEditSpinner.equals("50 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("13990");
                                silver_2year.setText("27980");
                                silver_3year.setText("41970");
                                gold_1year.setText("14570");
                                gold_2year.setText("29140");
                                gold_3year.setText("43710");
                                diamond_1year.setText("16700");
                                diamond_2year.setText("33400");
                                diamond_3year.setText("50100");

                            }else if (strGenderEditSpinner.equals("75 Lakh") && age31.equals("delhi")){

                                silver_1year.setText("16560");
                                silver_2year.setText("33120");
                                silver_3year.setText("49680");
                                gold_1year.setText("17160");
                                gold_2year.setText("34320");
                                gold_3year.setText("51480");
                                diamond_1year.setText("19390");
                                diamond_2year.setText("38780");
                                diamond_3year.setText("58170");

                            }else if (strGenderEditSpinner.equals("1 Crore") && age31.equals("delhi")){

                                silver_1year.setText("17530");
                                silver_2year.setText("35060");
                                silver_3year.setText("52590");
                                gold_1year.setText("18150");
                                gold_2year.setText("36300");
                                gold_3year.setText("54450");
                                diamond_1year.setText("20410");
                                diamond_2year.setText("40820");
                                diamond_3year.setText("61230");

                            }else if (strGenderEditSpinner.equals("3 Lakh") && age31.equals("other")){

                                silver_1year.setText("4320");
                                silver_2year.setText("8640");
                                silver_3year.setText("12960");
                                gold_1year.setText("4750");
                                gold_2year.setText("9500");
                                gold_3year.setText("14250");
                                diamond_1year.setText("6410");
                                diamond_2year.setText("12820");
                                diamond_3year.setText("19230");

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age31.equals("other")){

                                silver_1year.setText("5460");
                                silver_2year.setText("7636");
                                silver_3year.setText("11454");
                                gold_1year.setText("5900");
                                gold_2year.setText("11800");
                                gold_3year.setText("17700");
                                diamond_1year.setText("7610");
                                diamond_2year.setText("15220");
                                diamond_3year.setText("22830");

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age31.equals("other")){

                                silver_1year.setText("6780");
                                silver_2year.setText("13560");
                                silver_3year.setText("20340");
                                gold_1year.setText("7240");
                                gold_2year.setText("14480");
                                gold_3year.setText("21720");
                                diamond_1year.setText("9000");
                                diamond_2year.setText("18000");
                                diamond_3year.setText("27000");

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age31.equals("other")){

                                silver_1year.setText("9050");
                                silver_2year.setText("18100");
                                silver_3year.setText("27150");
                                gold_1year.setText("9540");
                                gold_2year.setText("19080");
                                gold_3year.setText("28620");
                                diamond_1year.setText("11380");
                                diamond_2year.setText("22760");
                                diamond_3year.setText("34140");

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age31.equals("other")){

                                silver_1year.setText("9810");
                                silver_2year.setText("19620");
                                silver_3year.setText("29430");
                                gold_1year.setText("10310");
                                gold_2year.setText("20620");
                                gold_3year.setText("30930");
                                diamond_1year.setText("12170");
                                diamond_2year.setText("24340");
                                diamond_3year.setText("36510");

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age31.equals("other")){

                                silver_1year.setText("10560");
                                silver_2year.setText("21120");
                                silver_3year.setText("31680");
                                gold_1year.setText("11060");
                                gold_2year.setText("22120");
                                gold_3year.setText("33180");
                                diamond_1year.setText("12930");
                                diamond_2year.setText("25860");
                                diamond_3year.setText("38790");

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age31.equals("other")){

                                silver_1year.setText("11600");
                                silver_2year.setText("23200");
                                silver_3year.setText("34800");
                                gold_1year.setText("12100");
                                gold_2year.setText("24200");
                                gold_3year.setText("36300");
                                diamond_1year.setText("13990");
                                diamond_2year.setText("27980");
                                diamond_3year.setText("41970");

                            }else if (strGenderEditSpinner.equals("25 Lakh") && age31.equals("other")){

                                silver_1year.setText("11970");
                                silver_2year.setText("23940");
                                silver_3year.setText("35910");
                                gold_1year.setText("12480");
                                gold_2year.setText("24960");
                                gold_3year.setText("37440");
                                diamond_1year.setText("14370");
                                diamond_2year.setText("28740");
                                diamond_3year.setText("43110");

                            }else if (strGenderEditSpinner.equals("50 Lakh") && age31.equals("other")){

                                silver_1year.setText("12590");
                                silver_2year.setText("25180");
                                silver_3year.setText("37770");
                                gold_1year.setText("13110");
                                gold_2year.setText("26220");
                                gold_3year.setText("39330");
                                diamond_1year.setText("15030");
                                diamond_2year.setText("30060");
                                diamond_3year.setText("45090");

                            }else if (strGenderEditSpinner.equals("75 Lakh") && age31.equals("other")){

                                silver_1year.setText("14900");
                                silver_2year.setText("29800");
                                silver_3year.setText("44700");
                                gold_1year.setText("15450");
                                gold_2year.setText("30900");
                                gold_3year.setText("46350");
                                diamond_1year.setText("17450");
                                diamond_2year.setText("34900");
                                diamond_3year.setText("52350");

                            }else if (strGenderEditSpinner.equals("1 Crore") && age31.equals("other")){

                                silver_1year.setText("15780");
                                silver_2year.setText("31560");
                                silver_3year.setText("47340");
                                gold_1year.setText("16330");
                                gold_2year.setText("32660");
                                gold_3year.setText("48990");
                                diamond_1year.setText("18370");
                                diamond_2year.setText("36740");
                                diamond_3year.setText("55110");

                            }

                        }
                        else if (age36 != null){

                            if (strGenderEditSpinner.equals("3 Lakh") && age36.equals("delhi")){
                                String Sliver36="5470";
                                String Gold36="5950";
                                String Diamond36="7820";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age36.equals("delhi")){

                                String Sliver36="6920";
                                String Gold36="7420";
                                String Diamond36="9360";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age36.equals("delhi")){

                                String Sliver36="8610";
                                String Gold36="9130";
                                String Diamond36="11140";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age36.equals("delhi")){
                                String Sliver36="11610";
                                String Gold36="12170";
                                String Diamond36="14280";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age36.equals("delhi")){
                                String Sliver36="12700";
                                String Gold36="13270";
                                String Diamond36="15400";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age36.equals("delhi")){
                                String Sliver36="13760";
                                String Gold36="14340";
                                String Diamond36="16480";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age36.equals("delhi")){
                                String Sliver36="15240";
                                String Gold36="15820";
                                String Diamond36="17990";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("25 Lakh") && age36.equals("delhi")){
                                String Sliver36="15680";
                                String Gold36="16270";
                                String Diamond36="18440";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("50 Lakh") && age36.equals("delhi")){
                                String Sliver36="16470";
                                String Gold36="17070";
                                String Diamond36="19280";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("75 Lakh") && age36.equals("delhi")){
                                String Sliver36="19570";
                                String Gold36="20210";
                                String Diamond36="22530";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("1 Crore") && age36.equals("delhi")){
                                String Sliver36="20700";
                                String Gold36="21350";
                                String Diamond36="23710";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("3 Lakh") && age36.equals("other")){
                                String Sliver36="4920";
                                String Gold36="5360";
                                String Diamond36="7040";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age36.equals("other")){
                                String Sliver36="6230";
                                String Gold36="6680";
                                String Diamond36="8420";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age36.equals("other")){
                                String Sliver36="7750";
                                String Gold36="8220";
                                String Diamond36="10030";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age36.equals("other")){

                                String Sliver36="10450";
                                String Gold36="10960";
                                String Diamond36="12860";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age36.equals("other")){
                                String Sliver36="11430";
                                String Gold36="11940";
                                String Diamond36="13860";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age36.equals("other")){
                                String Sliver36="12390";
                                String Gold36="12900";
                                String Diamond36="14840";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age36.equals("other")){
                                String Sliver36="13710";
                                String Gold36="14240";
                                String Diamond36="16190";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("25 Lakh") && age36.equals("other")){

                                String Sliver36="14120";
                                String Gold36="14640";
                                String Diamond36="16600";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("50 Lakh") && age36.equals("other")){

                                String Sliver36="14830";
                                String Gold36="15360";
                                String Diamond36="17350";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("75 Lakh") && age36.equals("other")){
                                String Sliver36="17620";
                                String Gold36="18190";
                                String Diamond36="20270";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age36.equals("other")){
                                String Sliver36="18630";
                                String Gold36="19210";
                                String Diamond36="21340";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                        }
                        else if (age41 != null){
                            if (strGenderEditSpinner.equals("3 Lakh") && age41.equals("delhi")){
                                String Sliver36="5970";
                                String Gold36="6460";
                                String Diamond36="8340";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age41.equals("delhi")){
                                String Sliver36="7570";
                                String Gold36="8080";
                                String Diamond36="10050";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age41.equals("delhi")){
                                String Sliver36="9430";
                                String Gold36="9970";
                                String Diamond36="12010";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age41.equals("delhi")){
                                String Sliver36="12710";
                                String Gold36="13290";
                                String Diamond36="15450";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age41.equals("delhi")){
                                String Sliver36="13870";
                                String Gold36="14460";
                                String Diamond36="16640";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age41.equals("delhi")){
                                String Sliver36="15010";
                                String Gold36="15600";
                                String Diamond36="17800";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age41.equals("delhi")){
                                String Sliver36="16570";
                                String Gold36="17170";
                                String Diamond36="19390";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("25 Lakh") && age41.equals("delhi")){
                                String Sliver36="17040";
                                String Gold36="17640";
                                String Diamond36="19880";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("50 Lakh") && age41.equals("delhi")){
                                String Sliver36="17910";
                                String Gold36="18530";
                                String Diamond36="20800";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("75 Lakh") && age41.equals("delhi")){
                                String Sliver36="21300";
                                String Gold36="21960";
                                String Diamond36="24350";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age41.equals("delhi")){
                                String Sliver36="22540";
                                String Gold36="23220";
                                String Diamond36="25660";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("3 Lakh") && age41.equals("other")){
                                String Sliver36="5370";
                                String Gold36="5810";
                                String Diamond36="7510";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("5 Lakh") && age41.equals("other")){
                                String Sliver36="6810";
                                String Gold36="7270";
                                String Diamond36="9040";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age41.equals("other")){
                                String Sliver36="8480";
                                String Gold36="8970";
                                String Diamond36="10810";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age41.equals("other")){
                                String Sliver36="11440";
                                String Gold36="11960";
                                String Diamond36="13910";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age41.equals("other")){
                                String Sliver36="12480";
                                String Gold36="13010";
                                String Diamond36="14980";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age41.equals("other")){
                                String Sliver36="13510";
                                String Gold36="14040";
                                String Diamond36="16020";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age41.equals("other")){
                                String Sliver36="14910";
                                String Gold36="15450";
                                String Diamond36="17450";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age41.equals("other")){
                                String Sliver36="15340";
                                String Gold36="15880";
                                String Diamond36="17890";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age41.equals("other")){
                                String Sliver36="16120";
                                String Gold36="16670";
                                String Diamond36="18720";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age41.equals("other")){
                                String Sliver36="19170";
                                String Gold36="19760";
                                String Diamond36="21910";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age41.equals("other")){
                                String Sliver36="20290";
                                String Gold36="20890";
                                String Diamond36="23100";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }

                        }
                        else if (age46 != null){
                            if (strGenderEditSpinner.equals("3 Lakh") && age46.equals("delhi")){
                                String Sliver36="7580";
                                String Gold36="8080";
                                String Diamond36="10010";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age46.equals("delhi")){
                                String Sliver36="9470";
                                String Gold36="10000";
                                String Diamond36="12020";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age46.equals("delhi")){
                                String Sliver36="11640";
                                String Gold36="12210";
                                String Diamond36="14330";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age46.equals("delhi")){
                                String Sliver36="15480";
                                String Gold36="16080";
                                String Diamond36="18340";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age46.equals("delhi")){
                                String Sliver36="16770";
                                String Gold36="17390";
                                String Diamond36="19670";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age46.equals("delhi")){
                                String Sliver36="18050";
                                String Gold36="18670";
                                String Diamond36="20980";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age46.equals("delhi")){

                                String Sliver36="19780";
                                String Gold36="20410";
                                String Diamond36="22740";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age46.equals("delhi")){

                                String Sliver36="20920";
                                String Gold36="21550";
                                String Diamond36="23900";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age46.equals("delhi")){
                                String Sliver36="21940";
                                String Gold36="22590";
                                String Diamond36="24980";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age46.equals("delhi")){
                                String Sliver36="25900";
                                String Gold36="26590";
                                String Diamond36="29120";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age46.equals("delhi")){
                                String Sliver36="27370";
                                String Gold36="28090";
                                String Diamond36="30680";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("3 Lakh") && age46.equals("other")){
                                String Sliver36="6830";
                                String Gold36="7280";
                                String Diamond36="9010";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("5 Lakh") && age46.equals("other")){

                                String Sliver36="8520";
                                String Gold36="9000";
                                String Diamond36="10820";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age46.equals("other")){

                                String Sliver36="10480";
                                String Gold36="10990";
                                String Diamond36="128890";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age46.equals("other")){

                                String Sliver36="13930";
                                String Gold36="14470";
                                String Diamond36="16510";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age46.equals("other")){
                                String Sliver36="15100";
                                String Gold36="15650";
                                String Diamond36="17710";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("15 Lakh") && age46.equals("other")){

                                String Sliver36="16250";
                                String Gold36="16800";
                                String Diamond36="18880";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age46.equals("other")){
                                String Sliver36="17800";
                                String Gold36="18370";
                                String Diamond36="20470";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age46.equals("other")){
                                String Sliver36="18830";
                                String Gold36="19400";
                                String Diamond36="21510";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age46.equals("other")){
                                String Sliver36="19740";
                                String Gold36="20330";
                                String Diamond36="22480";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("75 Lakh") && age46.equals("other")){
                                String Sliver36="23310";
                                String Gold36="23930";
                                String Diamond36="26210";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age46.equals("other")){
                                String Sliver36="24630";
                                String Gold36="25280";
                                String Diamond36="27620";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }

                        }
                        else if (age51 != null){
                            if (strGenderEditSpinner.equals("3 Lakh") && age51.equals("delhi")){
                                String Sliver36="9840";
                                String Gold36="10370";
                                String Diamond36="12390";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age51.equals("delhi")){
                                String Sliver36="12370";
                                String Gold36="12930";
                                String Diamond36="15110";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age51.equals("delhi")){
                                String Sliver36="15290";
                                String Gold36="15900";
                                String Diamond36="18190";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age51.equals("delhi")){
                                String Sliver36="20400";
                                String Gold36="21070";
                                String Diamond36="23550";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age51.equals("delhi")){
                                String Sliver36="22060";
                                String Gold36="22740";
                                String Diamond36="25260";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age51.equals("delhi")){
                                String Sliver36="23700";
                                String Gold36="24390";
                                String Diamond36="26940";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age51.equals("delhi")){
                                String Sliver36="25900";
                                String Gold36="26590";
                                String Diamond36="29180";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("25 Lakh") && age51.equals("delhi")){
                                String Sliver36="27140";
                                String Gold36="27850";
                                String Diamond36="30540";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age51.equals("delhi")){

                                String Sliver36="28530";
                                String Gold36="29260";
                                String Diamond36="31920";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age51.equals("delhi")){

                                String Sliver36="33840";
                                String Gold36="34630";
                                String Diamond36="37480";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age51.equals("delhi")){
                                String Sliver36="35830";
                                String Gold36="36650";
                                String Diamond36="39590";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("3 Lakh") && age51.equals("other")){
                                String Sliver36="8860";
                                String Gold36="9330";
                                String Diamond36="11150";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("5 Lakh") && age51.equals("other")){
                                String Sliver36="11130";
                                String Gold36="11640";
                                String Diamond36="13600";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age51.equals("other")){
                                String Sliver36="13760";
                                String Gold36="14310";
                                String Diamond36="16370";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("10 Lakh") && age51.equals("other")){

                                String Sliver36="18360";
                                String Gold36="18960";
                                String Diamond36="21200";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age51.equals("other")){
                                String Sliver36="19860";
                                String Gold36="20470";
                                String Diamond36="22740";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("15 Lakh") && age51.equals("other")){
                                String Sliver36="21330";
                                String Gold36="21950";
                                String Diamond36="24240";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("20 Lakh") && age51.equals("other")){
                                String Sliver36="23310";
                                String Gold36="23940";
                                String Diamond36="26260";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("25 Lakh") && age51.equals("other")){
                                String Sliver36="24430";
                                String Gold36="25060";
                                String Diamond36="27410";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("50 Lakh") && age51.equals("other")){
                                String Sliver36="25680";
                                String Gold36="26330";
                                String Diamond36="28730";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("75 Lakh") && age51.equals("other")){
                                String Sliver36="30450";
                                String Gold36="31160";
                                String Diamond36="33730";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                            else if (strGenderEditSpinner.equals("1 Crore") && age51.equals("other")){
                                String Sliver36="32250";
                                String Gold36="32990";
                                String Diamond36="35630";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }


                        }
                        else if (age56 != null){

                            if (strGenderEditSpinner.equals("3 Lakh") && age56.equals("delhi")){
                                String Sliver36="12880";
                                String Gold36="13440";
                                String Diamond36="15580";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age56.equals("delhi")){
                                String Sliver36="16290";
                                String Gold36="16910";
                                String Diamond36="19270";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age56.equals("delhi")){
                                String Sliver36="20230";
                                String Gold36="20900";
                                String Diamond36="23440";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age56.equals("delhi")){
                                String Sliver36="27090";
                                String Gold36="27840";
                                String Diamond36="30630";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age56.equals("delhi")){
                                String Sliver36="29200";
                                String Gold36="29970";
                                String Diamond36="32810";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("15 Lakh") && age56.equals("delhi")){
                                String Sliver36="31290";
                                String Gold36="32070";
                                String Diamond36="34950";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age56.equals("delhi")){
                                String Sliver36="34060";
                                String Gold36="34860";
                                String Diamond36="37790";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age56.equals("delhi")){
                                String Sliver36="35480";
                                String Gold36="36290";
                                String Diamond36="39240";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age56.equals("delhi")){
                                String Sliver36="37400";
                                String Gold36="38250";
                                String Diamond36="41280";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age56.equals("delhi")){
                                String Sliver36="44540";
                                String Gold36="45470";
                                String Diamond36="48760";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age56.equals("delhi")){
                                String Sliver36="47260";
                                String Gold36="48230";
                                String Diamond36="51640";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("3 Lakh") && age56.equals("other")){
                                String Sliver36="11590";
                                String Gold36="12090";
                                String Diamond36="14030";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age56.equals("other")){
                                String Sliver36="14660";
                                String Gold36="15220";
                                String Diamond36="17350";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age56.equals("other")){
                                String Sliver36="18210";
                                String Gold36="18810";
                                String Diamond36="21090";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age56.equals("other")){
                                String Sliver36="24380";
                                String Gold36="25060";
                                String Diamond36="27570";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age56.equals("other")){
                                String Sliver36="26280";
                                String Gold36="26970";
                                String Diamond36="29530";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age56.equals("other")){
                                String Sliver36="28160";
                                String Gold36="28860";
                                String Diamond36="31450";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age56.equals("other")){
                                String Sliver36="30650";
                                String Gold36="31370";
                                String Diamond36="34010";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age56.equals("other")){
                                String Sliver36="31940";
                                String Gold36="32660";
                                String Diamond36="35320";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age56.equals("other")){
                                String Sliver36="33660";
                                String Gold36="34420";
                                String Diamond36="37150";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age56.equals("other")){
                                String Sliver36="40090";
                                String Gold36="40920";
                                String Diamond36="43880";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age56.equals("other")){
                                String Sliver36="42530";
                                String Gold36="43400";
                                String Diamond36="46480";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                        }
                        else if (age61 != null){

                            if (strGenderEditSpinner.equals("3 Lakh") && age61.equals("delhi")){
                                String Sliver36="17560";
                                String Gold36="18180";
                                String Diamond36="20530";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age61.equals("delhi")){
                                String Sliver36="22400";
                                String Gold36="23100";
                                String Diamond36="25760";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age61.equals("delhi")){
                                String Sliver36="27960";
                                String Gold36="28740";
                                String Diamond36="31650";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age61.equals("delhi")){
                                String Sliver36="37490";
                                String Gold36="38380";
                                String Diamond36="41660";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age61.equals("delhi")){
                                String Sliver36="40200";
                                String Gold36="41120";
                                String Diamond36="44470";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("15 Lakh") && age61.equals("delhi")){
                                String Sliver36="42850";
                                String Gold36="43780";
                                String Diamond36="47190";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age61.equals("delhi")){
                                String Sliver36="46410";
                                String Gold36="47370";
                                String Diamond36="50840";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age61.equals("delhi")){
                                String Sliver36="48130";
                                String Gold36="49100";
                                String Diamond36="52610";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age61.equals("delhi")){
                                String Sliver36="50970";
                                String Gold36="51990";
                                String Diamond36="55610";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age61.equals("delhi")){
                                String Sliver36="60910";
                                String Gold36="62050";
                                String Diamond36="66040";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age61.equals("delhi")){
                                String Sliver36="64780";
                                String Gold36="65970";
                                String Diamond36="70130";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("3 Lakh") && age61.equals("other")){
                                String Sliver36="15800";
                                String Gold36="16360";
                                String Diamond36="18470";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("5 Lakh") && age61.equals("other")){
                                String Sliver36="20160";
                                String Gold36="20790";
                                String Diamond36="23180";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age61.equals("other")){
                                String Sliver36="25160";
                                String Gold36="25860";
                                String Diamond36="28480";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age61.equals("other")){
                                String Sliver36="33740";
                                String Gold36="34550";
                                String Diamond36="37490";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age61.equals("other")){
                                String Sliver36="36180";
                                String Gold36="37010";
                                String Diamond36="40020";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("15 Lakh") && age61.equals("other")){
                                String Sliver36="38570";
                                String Gold36="39410";
                                String Diamond36="42470";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age61.equals("other")){
                                String Sliver36="41770";
                                String Gold36="42630";
                                String Diamond36="45760";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age61.equals("other")){

                                String Sliver36="43320";
                                String Gold36="44190";
                                String Diamond36="47340";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age61.equals("other")){

                                String Sliver36="45870";
                                String Gold36="46790";
                                String Diamond36="50050";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age61.equals("other")){
                                String Sliver36="54820";
                                String Gold36="55840";
                                String Diamond36="59440";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age61.equals("other")){
                                String Sliver36="58300";
                                String Gold36="59370";
                                String Diamond36="63120";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }
                        }
                        else if (age66 != null){
                            if (strGenderEditSpinner.equals("3 Lakh") && age66.equals("delhi")){
                                String Sliver36="23680";
                                String Gold36="24370";
                                String Diamond36="26980";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age66.equals("delhi")){
                                String Sliver36="30340";
                                String Gold36="31140";
                                String Diamond36="34160";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age66.equals("delhi")){
                                String Sliver36="37970";
                                String Gold36="38920";
                                String Diamond36="42310";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age66.equals("delhi")){
                                String Sliver36="51080";
                                String Gold36="52190";
                                String Diamond36="56090";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age66.equals("delhi")){
                                String Sliver36="54740";
                                String Gold36="55870";
                                String Diamond36="59880";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("15 Lakh") && age66.equals("delhi")){
                                String Sliver36="58360";
                                String Gold36="59480";
                                String Diamond36="63570";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age66.equals("delhi")){
                                String Sliver36="63090";
                                String Gold36="64250";
                                String Diamond36="68430";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age66.equals("delhi")){
                                String Sliver36="65150";
                                String Gold36="66330";
                                String Diamond36="70550";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age66.equals("delhi")){
                                String Sliver36="69040";
                                String Gold36="70260";
                                String Diamond36="74650";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age66.equals("delhi")){
                                String Sliver36="82690";
                                String Gold36="84100";
                                String Diamond36="89000";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age66.equals("delhi")){
                                String Sliver36="88050";
                                String Gold36="89540";
                                String Diamond36="94670";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("3 Lakh") && age66.equals("other")){
                                String Sliver36="21310";
                                String Gold36="21940";
                                String Diamond36="24280";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("5 Lakh") && age66.equals("other")){
                                String Sliver36="27310";
                                String Gold36="28030";
                                String Diamond36="30740";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age66.equals("other")){
                                String Sliver36="34180";
                                String Gold36="35030";
                                String Diamond36="38080";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("10 Lakh") && age66.equals("other")){
                                String Sliver36="45980";
                                String Gold36="46970";
                                String Diamond36="50480";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age66.equals("other")){
                                String Sliver36="49270";
                                String Gold36="50290";
                                String Diamond36="53890";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("15 Lakh") && age66.equals("other")){
                                String Sliver36="52520";
                                String Gold36="53530";
                                String Diamond36="57210";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("20 Lakh") && age66.equals("other")){
                                String Sliver36="56780";
                                String Gold36="57820";
                                String Diamond36="61590";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age66.equals("other")){
                                String Sliver36="58640";
                                String Gold36="59690";
                                String Diamond36="63500";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("50 Lakh") && age66.equals("other")){
                                String Sliver36="62130";
                                String Gold36="63240";
                                String Diamond36="67180";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age66.equals("other")){
                                String Sliver36="74430";
                                String Gold36="75690";
                                String Diamond36="80100";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("1 Crore") && age66.equals("other")){
                                String Sliver36="79240";
                                String Gold36="80580";
                                String Diamond36="85210";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }

                        }
                        else if (age71 != null){
                            if (strGenderEditSpinner.equals("3 Lakh") && age71.equals("delhi")){
                                String Sliver36="35700";
                                String Gold36="36540";
                                String Diamond36="39650";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("5 Lakh") && age71.equals("delhi")){
                                String Sliver36="45910";
                                String Gold36="46920";
                                String Diamond36="50660";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age71.equals("delhi")){
                                String Sliver36="57660";
                                String Gold36="58880";
                                String Diamond36="63240";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age71.equals("delhi")){
                                String Sliver36="77790";
                                String Gold36="79260";
                                String Diamond36="84410";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age71.equals("delhi")){
                                String Sliver36="83320";
                                String Gold36="84840";
                                String Diamond36="90130";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));

                            }else if (strGenderEditSpinner.equals("15 Lakh") && age71.equals("delhi")){
                                String Sliver36="88810";
                                String Gold36="90310";
                                String Diamond36="95740";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age71.equals("delhi")){
                                String Sliver36="95880";
                                String Gold36="97440";
                                String Diamond36="103010";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age71.equals("delhi")){
                                String Sliver36="98630";
                                String Gold36="100210";
                                String Diamond36="105860";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age71.equals("delhi")){
                                String Sliver36="104610";
                                String Gold36="106270";
                                String Diamond36="112160";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age71.equals("delhi")){
                                String Sliver36="125610";
                                String Gold36="127550";
                                String Diamond36="134240";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age71.equals("delhi")){
                                String Sliver36="133880";
                                String Gold36="135950";
                                String Diamond36="143010";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("3 Lakh") && age71.equals("other")){
                                String Sliver36="32130";
                                String Gold36="32890";
                                String Diamond36="35690";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("5 Lakh") && age71.equals("other")){
                                String Sliver36="41320";
                                String Gold36="42230";
                                String Diamond36="45590";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("7 . 5 Lakh") && age71.equals("other")){
                                String Sliver36="51890";
                                String Gold36="52990";
                                String Diamond36="56920";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("10 Lakh") && age71.equals("other")){
                                String Sliver36="70010";
                                String Gold36="71330";
                                String Diamond36="75970";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("12 . 5 Lakh") && age71.equals("other")){
                                String Sliver36="74990";
                                String Gold36="76350";
                                String Diamond36="81120";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("15 Lakh") && age71.equals("other")){
                                String Sliver36="79920";
                                String Gold36="81280";
                                String Diamond36="86170";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("20 Lakh") && age71.equals("other")){
                                String Sliver36="86290";
                                String Gold36="87690";
                                String Diamond36="92710";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("25 Lakh") && age71.equals("other")){
                                String Sliver36="88770";
                                String Gold36="90190";
                                String Diamond36="95270";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("50 Lakh") && age71.equals("other")){
                                String Sliver36="94150";
                                String Gold36="95640";
                                String Diamond36="100940";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("75 Lakh") && age71.equals("other")){
                                String Sliver36="113050";
                                String Gold36="114800";
                                String Diamond36="120810";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }else if (strGenderEditSpinner.equals("1 Crore") && age71.equals("other")){
                                String Sliver36="120500";
                                String Gold36="122360";
                                String Diamond36="128700";
                                int sliver2= Integer.parseInt(Sliver36)*2;
                                int sliver3= Integer.parseInt(Sliver36)*3;
                                int Gold362= Integer.parseInt(Gold36)*2;
                                int Gold363= Integer.parseInt(Gold36)*3;
                                int diamond2= Integer.parseInt(Diamond36)*2;
                                int diamond3= Integer.parseInt(Diamond36)*3;
                                silver_1year.setText(Sliver36);
                                silver_2year.setText(String.valueOf(sliver2));
                                silver_3year.setText(String.valueOf(sliver3));
                                gold_1year.setText(Gold36);
                                gold_2year.setText(String.valueOf(Gold362));
                                gold_3year.setText(String.valueOf(Gold363));
                                diamond_1year.setText(Diamond36);
                                diamond_2year.setText(String.valueOf(diamond2));
                                diamond_3year.setText(String.valueOf(diamond3));
                            }

                        }
                    }
                });
                singlePicker.show();
            }
        });

        btnradio_silver_1year.setChecked(false);
        btnradio_silver_2year.setChecked(false);
        btnradio_silver_3year.setChecked(false);
        btnradio_gold_1year.setChecked(false);
        btnradio_gold_2year.setChecked(false);
        btnradio_gold_3year.setChecked(false);
        btnradio_diamond_1year.setChecked(false);
        btnradio_diamond_2year.setChecked(false);
        btnradio_diamond_3year.setChecked(false);

        btnradio_silver_1year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";
                if (btnradio_silver_1year.isChecked()) {

                    btnradio_silver_1year.setChecked(true);
                    btnradio_silver_2year.setChecked(false);
                    btnradio_silver_3year.setChecked(false);
                    btnradio_gold_1year.setChecked(false);
                    btnradio_gold_2year.setChecked(false);
                    btnradio_gold_3year.setChecked(false);
                    btnradio_diamond_1year.setChecked(false);
                    btnradio_diamond_2year.setChecked(false);
                    btnradio_diamond_3year.setChecked(false);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;


                        }

                    }

                    else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            meternityCover = 6910;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            meternityCover = 6910;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            meternityCover = 6910 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            meternityCover = 6910 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            meternityCover = 6910 ;
                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            meternityCover = 6910 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            meternityCover = 6910 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            meternityCover = 6090 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            meternityCover = 5690 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            meternityCover = 5690 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            meternityCover = 5260 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            meternityCover = 4360 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }

                    convert_amount = (Double.parseDouble(silver_1year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Silver";
                    selected_year = "1 Year";



                }
            }
        });

        btnradio_silver_2year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";

                if (btnradio_silver_2year.isChecked()) {

                    convert_amount = (Double.parseDouble(silver_2year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Silver";
                    selected_year = "2 Year";

                    btnradio_silver_1year.setChecked(false);
                    btnradio_silver_2year.setChecked(true);
                    btnradio_silver_3year.setChecked(false);
                    btnradio_gold_1year.setChecked(false);
                    btnradio_gold_2year.setChecked(false);
                    btnradio_gold_3year.setChecked(false);
                    btnradio_diamond_1year.setChecked(false);
                    btnradio_diamond_2year.setChecked(false);
                    btnradio_diamond_3year.setChecked(false);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;


                        }

                    }


                    else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            meternityCover = 6910;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            meternityCover = 6910;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            meternityCover = 6910 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            meternityCover = 6910 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            meternityCover = 6910 ;
                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            meternityCover = 6910 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            meternityCover = 6910 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            meternityCover = 6090 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            meternityCover = 5690 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            meternityCover = 5690 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            meternityCover = 5260 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            meternityCover = 4360 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }

                }
            }
        });

        btnradio_silver_3year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";

                if (btnradio_silver_3year.isChecked()) {

                    convert_amount = (Double.parseDouble(silver_3year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Silver";
                    selected_year = "3 Year";

                    btnradio_silver_1year.setChecked(false);
                    btnradio_silver_2year.setChecked(false);
                    btnradio_silver_3year.setChecked(true);
                    btnradio_gold_1year.setChecked(false);
                    btnradio_gold_2year.setChecked(false);
                    btnradio_gold_3year.setChecked(false);
                    btnradio_diamond_1year.setChecked(false);
                    btnradio_diamond_2year.setChecked(false);
                    btnradio_diamond_3year.setChecked(false);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;


                        }

                    }


                    else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            meternityCover = 6910;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            meternityCover = 6910;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            meternityCover = 6910 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            meternityCover = 6910 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            meternityCover = 6910 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            meternityCover = 6910 ;
                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            meternityCover = 6910 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            meternityCover = 6910 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            meternityCover = 6910 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            meternityCover = 6910 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            meternityCover = 6090 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            meternityCover = 6090 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            meternityCover = 5690 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            meternityCover = 5690 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            meternityCover = 5690 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            meternityCover = 5690 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            meternityCover = 5260 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            meternityCover = 5260 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            meternityCover = 4360 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            meternityCover = 4360 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            meternityCover = 2910 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            meternityCover = 2910 ;

                        }

                    }

                }
            }
        });

        btnradio_gold_1year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";

                if (btnradio_gold_1year.isChecked()){

                    btnradio_silver_1year.setChecked(false);
                    btnradio_silver_2year.setChecked(false);
                    btnradio_silver_3year.setChecked(false);
                    btnradio_gold_1year.setChecked(true);
                    btnradio_gold_2year.setChecked(false);
                    btnradio_gold_3year.setChecked(false);
                    btnradio_diamond_1year.setChecked(false);
                    btnradio_diamond_2year.setChecked(false);
                    btnradio_diamond_3year.setChecked(false);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;


                        }

                    }

                    else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            meternityCover = 9030;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            meternityCover = 9030;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            meternityCover = 9030 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            meternityCover = 9030 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            meternityCover = 9030 ;
                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            meternityCover = 9030 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            meternityCover = 9030 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            meternityCover = 7970 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            meternityCover = 7440 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            meternityCover = 7440 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            meternityCover = 6880 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            meternityCover = 5700 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            meternityCover = 300 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }


                    convert_amount = (Double.parseDouble(gold_1year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Gold";
                    selected_year = "1 Year";

                }


            }
        });

        btnradio_gold_2year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";

                if (btnradio_gold_2year.isChecked()){

                    btnradio_silver_1year.setChecked(false);
                    btnradio_silver_2year.setChecked(false);
                    btnradio_silver_3year.setChecked(false);
                    btnradio_gold_1year.setChecked(false);
                    btnradio_gold_2year.setChecked(true);
                    btnradio_gold_3year.setChecked(false);
                    btnradio_diamond_1year.setChecked(false);
                    btnradio_diamond_2year.setChecked(false);
                    btnradio_diamond_3year.setChecked(false);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;


                        }

                    }

                    else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            meternityCover = 9030;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            meternityCover = 9030;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            meternityCover = 9030 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            meternityCover = 9030 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            meternityCover = 9030 ;
                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            meternityCover = 9030 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            meternityCover = 9030 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            meternityCover = 7970 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            meternityCover = 7440 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            meternityCover = 7440 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            meternityCover = 6880 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            meternityCover = 5700 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }


                    convert_amount = (Double.parseDouble(gold_2year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Gold";
                    selected_year = "2 Year";

                }


            }
        });

        btnradio_gold_3year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";

                if (btnradio_gold_3year.isChecked()){

                    btnradio_silver_1year.setChecked(false);
                    btnradio_silver_2year.setChecked(false);
                    btnradio_silver_3year.setChecked(false);
                    btnradio_gold_1year.setChecked(false);
                    btnradio_gold_2year.setChecked(false);
                    btnradio_gold_3year.setChecked(true);
                    btnradio_diamond_1year.setChecked(false);
                    btnradio_diamond_2year.setChecked(false);
                    btnradio_diamond_3year.setChecked(false);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;


                        }

                    }

                    else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            meternityCover = 9030;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            meternityCover = 9030;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            meternityCover = 9030 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            meternityCover = 9030 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            meternityCover = 9030 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            meternityCover = 9030 ;
                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            meternityCover = 9030 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            meternityCover = 9030 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            meternityCover = 9030 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            meternityCover = 9030 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            meternityCover = 7970 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            meternityCover = 7970 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            meternityCover = 7440 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            meternityCover = 7440 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            meternityCover = 7440 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            meternityCover = 7440 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            meternityCover = 6880 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            meternityCover = 6880 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            meternityCover = 5700 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            meternityCover = 5700 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            meternityCover = 3800 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            meternityCover = 3800 ;

                        }

                    }


                    convert_amount = (Double.parseDouble(gold_3year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Gold";
                    selected_year = "3 Year";

                }


            }
        });

        btnradio_diamond_1year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";

                if (btnradio_diamond_1year.isChecked()){

                    btnradio_silver_1year.setChecked(false);
                    btnradio_silver_2year.setChecked(false);
                    btnradio_silver_3year.setChecked(false);
                    btnradio_gold_1year.setChecked(false);
                    btnradio_gold_2year.setChecked(false);
                    btnradio_gold_3year.setChecked(false);
                    btnradio_diamond_1year.setChecked(true);
                    btnradio_diamond_2year.setChecked(false);
                    btnradio_diamond_3year.setChecked(false);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;
                            Diabetes = 14620;
                            Hypertension = 11080;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;
                            Diabetes = 14620;
                            Hypertension = 11080;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;
                            Diabetes = 14620;
                            Hypertension = 11080;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;
                            Diabetes = 18280;
                            Hypertension = 13850;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }

                    } else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            Diabetes = 50;
                            Hypertension = 50;
                            meternityCover = 13020;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            Diabetes = 70;
                            Hypertension = 63;
                            meternityCover = 13020;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            Diabetes = 78;
                            Hypertension = 78;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            Diabetes = 137;
                            Hypertension = 98;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            Diabetes = 192;
                            Hypertension = 122;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            Diabetes = 269;
                            Hypertension = 153;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            Diabetes = 376;
                            Hypertension = 191;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            Diabetes = 527;
                            Hypertension = 238;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            Diabetes = 738;
                            Hypertension = 298;
                            meternityCover = 13020 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            Diabetes = 1033;
                            Hypertension = 373;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            Diabetes = 1446;
                            Hypertension = 466;
                            meternityCover = 13020 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            Diabetes = 75;
                            Hypertension = 50;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            Diabetes = 105;
                            Hypertension = 63;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            Diabetes = 147;
                            Hypertension = 78;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            Diabetes = 206;
                            Hypertension = 98;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            Diabetes = 288;
                            Hypertension = 122;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            Diabetes = 403;
                            Hypertension = 153;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            Diabetes = 565;
                            Hypertension = 191;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            Diabetes = 791;
                            Hypertension = 238;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            Diabetes = 1107;
                            Hypertension = 298;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            Diabetes = 1550;
                            Hypertension = 373;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            Diabetes = 2169;
                            Hypertension = 466;
                            meternityCover = 13020 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            Diabetes = 100;
                            Hypertension = 100;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            Diabetes = 105;
                            Hypertension = 125;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            Diabetes = 196;
                            Hypertension = 156;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            Diabetes = 274;
                            Hypertension = 195;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            Diabetes = 384;
                            Hypertension = 244;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            Diabetes = 538;
                            Hypertension = 305;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            Diabetes = 753;
                            Hypertension = 381;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            Diabetes = 1054;
                            Hypertension = 477;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            Diabetes = 1476;
                            Hypertension = 596;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            Diabetes = 2066;
                            Hypertension = 745;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            Diabetes = 2893;
                            Hypertension = 931;
                            meternityCover = 13020 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            Diabetes = 150;
                            Hypertension = 200;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            Diabetes = 210;
                            Hypertension = 250;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            Diabetes = 294;
                            Hypertension = 313;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            Diabetes = 412;
                            Hypertension = 391;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            Diabetes = 576;
                            Hypertension = 488;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            Diabetes = 807;
                            Hypertension = 610;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            Diabetes = 1129;
                            Hypertension = 763;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            Diabetes = 1581;
                            Hypertension = 954;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            Diabetes = 2214;
                            Hypertension = 1192;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            Diabetes = 3099;
                            Hypertension = 1490;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            Diabetes = 4339;
                            Hypertension = 1863;
                            meternityCover = 11490 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            Diabetes = 200;
                            Hypertension = 300;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            Diabetes = 280;
                            Hypertension = 375;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            Diabetes = 392;
                            Hypertension = 469;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            Diabetes = 549;
                            Hypertension = 586;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            Diabetes = 768;
                            Hypertension = 732;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            Diabetes = 1076;
                            Hypertension = 916;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            Diabetes = 1506;
                            Hypertension = 1144;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            Diabetes = 2108;
                            Hypertension = 1431;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            Diabetes = 2952;
                            Hypertension = 1788;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            Diabetes = 4132;
                            Hypertension = 2235;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            Diabetes = 5785;
                            Hypertension = 2794;
                            meternityCover = 10720 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            Diabetes = 300;
                            Hypertension = 400;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            Diabetes = 420;
                            Hypertension = 500;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            Diabetes = 588;
                            Hypertension = 625;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            Diabetes = 823;
                            Hypertension = 781;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            Diabetes = 1152;
                            Hypertension = 977;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            Diabetes = 1613;
                            Hypertension = 1221;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            Diabetes = 2259;
                            Hypertension = 1526;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            Diabetes = 3162;
                            Hypertension = 1907;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            Diabetes = 4427;
                            Hypertension = 2384;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            Diabetes = 6198;
                            Hypertension = 2980;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            Diabetes = 8678;
                            Hypertension = 3725;
                            meternityCover = 10720 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            Diabetes = 400;
                            Hypertension = 500;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            Diabetes = 560;
                            Hypertension = 625;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            Diabetes = 784;
                            Hypertension = 781;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            Diabetes = 1098;
                            Hypertension = 977;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            Diabetes = 1537;
                            Hypertension = 1221;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            Diabetes = 2151;
                            Hypertension = 1526;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            Diabetes = 3012;
                            Hypertension = 1907;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            Diabetes = 4217;
                            Hypertension = 2384;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            Diabetes = 5903;
                            Hypertension = 2980;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            Diabetes = 8264;
                            Hypertension = 3725;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            Diabetes = 11570;
                            Hypertension = 4657;
                            meternityCover = 9920 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            Diabetes = 600;
                            Hypertension = 600;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            Diabetes = 840;
                            Hypertension = 750;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            Diabetes = 1176;
                            Hypertension = 938;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            Diabetes = 1646;
                            Hypertension = 1172;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            Diabetes = 2305;
                            Hypertension = 1465;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            Diabetes = 3227;
                            Hypertension = 1831;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            Diabetes = 4518;
                            Hypertension = 2289;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            Diabetes = 6325;
                            Hypertension = 2861;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            Diabetes = 8855;
                            Hypertension = 3576;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            Diabetes = 12397;
                            Hypertension = 4470;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            Diabetes = 17355;
                            Hypertension = 5588;
                            meternityCover = 8220 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            Diabetes = 800;
                            Hypertension = 700;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            Diabetes = 1120;
                            Hypertension = 875;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            Diabetes = 1568;
                            Hypertension = 1094;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            Diabetes = 2195;
                            Hypertension = 1367;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            Diabetes = 3073;
                            Hypertension = 1709;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            Diabetes = 4303;
                            Hypertension = 2136;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            Diabetes = 6024;
                            Hypertension = 2670;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            Diabetes = 4433;
                            Hypertension = 3338;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            Diabetes = 11806;
                            Hypertension = 4172;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            Diabetes = 16529;
                            Hypertension = 5215;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            Diabetes = 23140;
                            Hypertension = 6519;
                            meternityCover = 5480 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            Diabetes = 800;
                            Hypertension = 700;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            Diabetes = 1120;
                            Hypertension = 875;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            Diabetes = 1568;
                            Hypertension = 1094;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            Diabetes = 2195;
                            Hypertension = 1367;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            Diabetes = 3073;
                            Hypertension = 1709;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            Diabetes = 4303;
                            Hypertension = 2136;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            Diabetes = 6024;
                            Hypertension = 2670;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            Diabetes = 8433;
                            Hypertension = 3338;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            Diabetes = 11806;
                            Hypertension = 4172;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            Diabetes = 16529;
                            Hypertension = 5215;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            Diabetes = 23140;
                            Hypertension = 6519;
                            meternityCover = 5480 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            Diabetes = 850;
                            Hypertension = 800;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            Diabetes = 1190;
                            Hypertension = 1000;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            Diabetes = 1666;
                            Hypertension = 1250;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            Diabetes = 2332;
                            Hypertension = 1563;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            Diabetes = 3265;
                            Hypertension = 1953;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            Diabetes = 4572;
                            Hypertension = 2441;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            Diabetes = 6400;
                            Hypertension = 3052;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            Diabetes = 8960;
                            Hypertension = 3815;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            Diabetes = 12544;
                            Hypertension = 4768;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            Diabetes = 17562;
                            Hypertension = 5960;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            Diabetes = 24587;
                            Hypertension = 7451;
                            meternityCover = 5480 ;

                        }

                    }


                    convert_amount = (Double.parseDouble(diamond_1year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Diamond";
                    selected_year = "1 Year";

                }

            }
        });

        btnradio_diamond_2year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";

                if (btnradio_diamond_2year.isChecked()){

                    btnradio_silver_1year.setChecked(false);
                    btnradio_silver_2year.setChecked(false);
                    btnradio_silver_3year.setChecked(false);
                    btnradio_gold_1year.setChecked(false);
                    btnradio_gold_2year.setChecked(false);
                    btnradio_gold_3year.setChecked(false);
                    btnradio_diamond_1year.setChecked(false);
                    btnradio_diamond_2year.setChecked(true);
                    btnradio_diamond_3year.setChecked(false);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;
                            Diabetes = 14620;
                            Hypertension = 11080;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;
                            Diabetes = 14620;
                            Hypertension = 11080;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;
                            Diabetes = 14620;
                            Hypertension = 11080;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;
                            Diabetes = 18280;
                            Hypertension = 13850;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }

                    } else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            Diabetes = 50;
                            Hypertension = 50;
                            meternityCover = 13020;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            Diabetes = 70;
                            Hypertension = 63;
                            meternityCover = 13020;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            Diabetes = 78;
                            Hypertension = 78;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            Diabetes = 137;
                            Hypertension = 98;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            Diabetes = 192;
                            Hypertension = 122;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            Diabetes = 269;
                            Hypertension = 153;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            Diabetes = 376;
                            Hypertension = 191;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            Diabetes = 527;
                            Hypertension = 238;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            Diabetes = 738;
                            Hypertension = 298;
                            meternityCover = 13020 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            Diabetes = 1033;
                            Hypertension = 373;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            Diabetes = 1446;
                            Hypertension = 466;
                            meternityCover = 13020 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            Diabetes = 75;
                            Hypertension = 50;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            Diabetes = 105;
                            Hypertension = 63;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            Diabetes = 147;
                            Hypertension = 78;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            Diabetes = 206;
                            Hypertension = 98;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            Diabetes = 288;
                            Hypertension = 122;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            Diabetes = 403;
                            Hypertension = 153;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            Diabetes = 565;
                            Hypertension = 191;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            Diabetes = 791;
                            Hypertension = 238;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            Diabetes = 1107;
                            Hypertension = 298;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            Diabetes = 1550;
                            Hypertension = 373;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            Diabetes = 2169;
                            Hypertension = 466;
                            meternityCover = 13020 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            Diabetes = 100;
                            Hypertension = 100;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            Diabetes = 105;
                            Hypertension = 125;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            Diabetes = 196;
                            Hypertension = 156;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            Diabetes = 274;
                            Hypertension = 195;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            Diabetes = 384;
                            Hypertension = 244;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            Diabetes = 538;
                            Hypertension = 305;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            Diabetes = 753;
                            Hypertension = 381;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            Diabetes = 1054;
                            Hypertension = 477;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            Diabetes = 1476;
                            Hypertension = 596;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            Diabetes = 2066;
                            Hypertension = 745;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            Diabetes = 2893;
                            Hypertension = 931;
                            meternityCover = 13020 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            Diabetes = 150;
                            Hypertension = 200;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            Diabetes = 210;
                            Hypertension = 250;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            Diabetes = 294;
                            Hypertension = 313;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            Diabetes = 412;
                            Hypertension = 391;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            Diabetes = 576;
                            Hypertension = 488;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            Diabetes = 807;
                            Hypertension = 610;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            Diabetes = 1129;
                            Hypertension = 763;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            Diabetes = 1581;
                            Hypertension = 954;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            Diabetes = 2214;
                            Hypertension = 1192;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            Diabetes = 3099;
                            Hypertension = 1490;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            Diabetes = 4339;
                            Hypertension = 1863;
                            meternityCover = 11490 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            Diabetes = 200;
                            Hypertension = 300;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            Diabetes = 280;
                            Hypertension = 375;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            Diabetes = 392;
                            Hypertension = 469;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            Diabetes = 549;
                            Hypertension = 586;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            Diabetes = 768;
                            Hypertension = 732;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            Diabetes = 1076;
                            Hypertension = 916;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            Diabetes = 1506;
                            Hypertension = 1144;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            Diabetes = 2108;
                            Hypertension = 1431;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            Diabetes = 2952;
                            Hypertension = 1788;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            Diabetes = 4132;
                            Hypertension = 2235;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            Diabetes = 5785;
                            Hypertension = 2794;
                            meternityCover = 10720 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            Diabetes = 300;
                            Hypertension = 400;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            Diabetes = 420;
                            Hypertension = 500;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            Diabetes = 588;
                            Hypertension = 625;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            Diabetes = 823;
                            Hypertension = 781;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            Diabetes = 1152;
                            Hypertension = 977;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            Diabetes = 1613;
                            Hypertension = 1221;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            Diabetes = 2259;
                            Hypertension = 1526;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            Diabetes = 3162;
                            Hypertension = 1907;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            Diabetes = 4427;
                            Hypertension = 2384;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            Diabetes = 6198;
                            Hypertension = 2980;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            Diabetes = 8678;
                            Hypertension = 3725;
                            meternityCover = 10720 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            Diabetes = 400;
                            Hypertension = 500;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            Diabetes = 560;
                            Hypertension = 625;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            Diabetes = 784;
                            Hypertension = 781;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            Diabetes = 1098;
                            Hypertension = 977;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            Diabetes = 1537;
                            Hypertension = 1221;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            Diabetes = 2151;
                            Hypertension = 1526;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            Diabetes = 3012;
                            Hypertension = 1907;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            Diabetes = 4217;
                            Hypertension = 2384;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            Diabetes = 5903;
                            Hypertension = 2980;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            Diabetes = 8264;
                            Hypertension = 3725;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            Diabetes = 11570;
                            Hypertension = 4657;
                            meternityCover = 9920 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            Diabetes = 600;
                            Hypertension = 600;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            Diabetes = 840;
                            Hypertension = 750;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            Diabetes = 1176;
                            Hypertension = 938;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            Diabetes = 1646;
                            Hypertension = 1172;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            Diabetes = 2305;
                            Hypertension = 1465;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            Diabetes = 3227;
                            Hypertension = 1831;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            Diabetes = 4518;
                            Hypertension = 2289;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            Diabetes = 6325;
                            Hypertension = 2861;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            Diabetes = 8855;
                            Hypertension = 3576;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            Diabetes = 12397;
                            Hypertension = 4470;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            Diabetes = 17355;
                            Hypertension = 5588;
                            meternityCover = 8220 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            Diabetes = 800;
                            Hypertension = 700;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            Diabetes = 1120;
                            Hypertension = 875;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            Diabetes = 1568;
                            Hypertension = 1094;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            Diabetes = 2195;
                            Hypertension = 1367;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            Diabetes = 3073;
                            Hypertension = 1709;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            Diabetes = 4303;
                            Hypertension = 2136;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            Diabetes = 6024;
                            Hypertension = 2670;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            Diabetes = 4433;
                            Hypertension = 3338;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            Diabetes = 11806;
                            Hypertension = 4172;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            Diabetes = 16529;
                            Hypertension = 5215;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            Diabetes = 23140;
                            Hypertension = 6519;
                            meternityCover = 5480 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            Diabetes = 800;
                            Hypertension = 700;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            Diabetes = 1120;
                            Hypertension = 875;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            Diabetes = 1568;
                            Hypertension = 1094;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            Diabetes = 2195;
                            Hypertension = 1367;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            Diabetes = 3073;
                            Hypertension = 1709;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            Diabetes = 4303;
                            Hypertension = 2136;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            Diabetes = 6024;
                            Hypertension = 2670;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            Diabetes = 8433;
                            Hypertension = 3338;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            Diabetes = 11806;
                            Hypertension = 4172;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            Diabetes = 16529;
                            Hypertension = 5215;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            Diabetes = 23140;
                            Hypertension = 6519;
                            meternityCover = 5480 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            Diabetes = 850;
                            Hypertension = 800;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            Diabetes = 1190;
                            Hypertension = 1000;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            Diabetes = 1666;
                            Hypertension = 1250;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            Diabetes = 2332;
                            Hypertension = 1563;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            Diabetes = 3265;
                            Hypertension = 1953;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            Diabetes = 4572;
                            Hypertension = 2441;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            Diabetes = 6400;
                            Hypertension = 3052;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            Diabetes = 8960;
                            Hypertension = 3815;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            Diabetes = 12544;
                            Hypertension = 4768;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            Diabetes = 17562;
                            Hypertension = 5960;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            Diabetes = 24587;
                            Hypertension = 7451;
                            meternityCover = 5480 ;

                        }

                    }

                    convert_amount = (Double.parseDouble(diamond_2year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Diamond";
                    selected_year = "2 Year";

                }
            }
        });

        btnradio_diamond_3year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strDisease_checkbox = "Unchecked";
                strNonMedical = "Unchecked";
                strHypertension = "Unchecked";
                strDabetes_checkbox = "Unchecked";
                strMaternityCover = "Unchecked";

                if (btnradio_diamond_3year.isChecked()){

                    btnradio_silver_1year.setChecked(false);
                    btnradio_silver_2year.setChecked(false);
                    btnradio_silver_3year.setChecked(false);
                    btnradio_gold_1year.setChecked(false);
                    btnradio_gold_2year.setChecked(false);
                    btnradio_gold_3year.setChecked(false);
                    btnradio_diamond_1year.setChecked(false);
                    btnradio_diamond_2year.setChecked(false);
                    btnradio_diamond_3year.setChecked(true);

                    if (strageChild != null){
                        int ageChild = Integer.parseInt(strageChild);
                        if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 740;
                            nonMedical = 150;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 970;
                            nonMedical = 200;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 1220 ;
                            nonMedical = 250 ;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 1630 ;
                            nonMedical = 320 ;
                            Diabetes = 12180;
                            Hypertension = 9230;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 1710 ;
                            nonMedical = 340 ;
                            Diabetes = 14620;
                            Hypertension = 11080;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 1950 ;
                            nonMedical = 380 ;
                            Diabetes = 14620;
                            Hypertension = 11080;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 2030 ;
                            nonMedical = 400 ;
                            Diabetes = 14620;
                            Hypertension = 11080;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 2080 ;
                            nonMedical = 420 ;
                            Diabetes = 18280;
                            Hypertension = 13850;

                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 2200 ;
                            nonMedical = 450 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }else if((ageChild>=0&&ageChild<18) &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 2400 ;
                            nonMedical = 480 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }else if((ageChild>=0&&ageChild<18) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 2580 ;
                            nonMedical = 520 ;
                            Diabetes = 18280;
                            Hypertension = 13850;


                        }

                    } else if (agee18 != null){
                        int age = Integer.parseInt(agee18);
                        if((age>17&&age<26) && strGenderEditSpinner.equals("3 Lakh") ){
                            planAmount = 150;
                            nonMedical = 25;
                            Diabetes = 50;
                            Hypertension = 50;
                            meternityCover = 13020;

                        }else if((age>17&&age<26) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 165;
                            nonMedical = 31;
                            Diabetes = 70;
                            Hypertension = 63;
                            meternityCover = 13020;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 182 ;
                            nonMedical = 39 ;
                            Diabetes = 78;
                            Hypertension = 78;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 49 ;
                            Diabetes = 137;
                            Hypertension = 98;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 61 ;
                            Diabetes = 192;
                            Hypertension = 122;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 76 ;
                            Diabetes = 269;
                            Hypertension = 153;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 266 ;
                            nonMedical = 95 ;
                            Diabetes = 376;
                            Hypertension = 191;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 292 ;
                            nonMedical = 119 ;
                            Diabetes = 527;
                            Hypertension = 238;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) &&strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 149 ;
                            Diabetes = 738;
                            Hypertension = 298;
                            meternityCover = 13020 ;

                        }else if(age>17 && age<26 &&strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 186 ;
                            Diabetes = 1033;
                            Hypertension = 373;
                            meternityCover = 13020 ;

                        }else if((age>17 && age<26) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 389 ;
                            nonMedical = 233 ;
                            Diabetes = 1446;
                            Hypertension = 466;
                            meternityCover = 13020 ;

                        }

                    }else if (agee26 != null){
                        int agge = Integer.parseInt(agee26);

                        if((agge>25 && agge<31) && strGenderEditSpinner.equals("3 Lakh")) {
                            planAmount = 200 ;
                            nonMedical = 50 ;
                            Diabetes = 75;
                            Hypertension = 50;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 220 ;
                            nonMedical = 63 ;
                            Diabetes = 105;
                            Hypertension = 63;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 242 ;
                            nonMedical = 78 ;
                            Diabetes = 147;
                            Hypertension = 78;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {

                            planAmount = 266 ;
                            nonMedical = 98 ;
                            Diabetes = 206;
                            Hypertension = 98;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 293 ;
                            nonMedical = 122 ;
                            Diabetes = 288;
                            Hypertension = 122;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 322 ;
                            nonMedical = 153 ;
                            Diabetes = 403;
                            Hypertension = 153;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 354 ;
                            nonMedical = 191 ;
                            Diabetes = 565;
                            Hypertension = 191;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 390 ;
                            nonMedical = 238 ;
                            Diabetes = 791;
                            Hypertension = 238;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 429 ;
                            nonMedical = 298 ;
                            Diabetes = 1107;
                            Hypertension = 298;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 472 ;
                            nonMedical = 373 ;
                            Diabetes = 1550;
                            Hypertension = 373;
                            meternityCover = 13020 ;

                        }else  if((agge>25 && agge<31) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 519 ;
                            nonMedical = 466 ;
                            Diabetes = 2169;
                            Hypertension = 466;
                            meternityCover = 13020 ;
                        }
                    }else if (agee31 != null){

                        int agge31 = Integer.parseInt(agee31);

                        if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 225 ;
                            nonMedical = 60 ;
                            Diabetes = 100;
                            Hypertension = 100;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("5 Lakh")) {
                            planAmount = 248 ;
                            nonMedical = 75 ;
                            Diabetes = 105;
                            Hypertension = 125;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("7 . 5 Lakh")) {
                            planAmount = 272 ;
                            nonMedical = 94 ;
                            Diabetes = 196;
                            Hypertension = 156;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")) {
                            planAmount = 299 ;
                            nonMedical = 117 ;
                            Diabetes = 274;
                            Hypertension = 195;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("12 . 5 Lakh")) {
                            planAmount = 329 ;
                            nonMedical = 146 ;
                            Diabetes = 384;
                            Hypertension = 244;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("15 Lakh")) {
                            planAmount = 362 ;
                            nonMedical = 183 ;
                            Diabetes = 538;
                            Hypertension = 305;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("20 Lakh")) {
                            planAmount = 399 ;
                            nonMedical = 229 ;
                            Diabetes = 753;
                            Hypertension = 381;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("25 Lakh")) {
                            planAmount = 438 ;
                            nonMedical = 286 ;
                            Diabetes = 1054;
                            Hypertension = 477;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("50 Lakh")) {
                            planAmount = 482 ;
                            nonMedical = 358 ;
                            Diabetes = 1476;
                            Hypertension = 596;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("75 Lakh")) {
                            planAmount = 531 ;
                            nonMedical = 447 ;
                            Diabetes = 2066;
                            Hypertension = 745;
                            meternityCover = 13020 ;

                        }else if((agge31>30 && agge31<36) && strGenderEditSpinner.equals("1 Crore")) {
                            planAmount = 584 ;
                            nonMedical = 559 ;
                            Diabetes = 2893;
                            Hypertension = 931;
                            meternityCover = 13020 ;
                        }

                    }else if (agee36 != null){

                        int age_36 = Integer.parseInt(agee36);

                        if((age_36>35 && age_36<41) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 250 ;
                            nonMedical = 80 ;
                            Diabetes = 150;
                            Hypertension = 200;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 275 ;
                            nonMedical = 100 ;
                            Diabetes = 210;
                            Hypertension = 250;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 303 ;
                            nonMedical = 120 ;
                            Diabetes = 294;
                            Hypertension = 313;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 333 ;
                            nonMedical = 156 ;
                            Diabetes = 412;
                            Hypertension = 391;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 366 ;
                            nonMedical = 195 ;
                            Diabetes = 576;
                            Hypertension = 488;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 403 ;
                            nonMedical = 244 ;
                            Diabetes = 807;
                            Hypertension = 610;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 443 ;
                            nonMedical = 305 ;
                            Diabetes = 1129;
                            Hypertension = 763;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 487 ;
                            nonMedical = 381 ;
                            Diabetes = 1581;
                            Hypertension = 954;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 536 ;
                            nonMedical = 477 ;
                            Diabetes = 2214;
                            Hypertension = 1192;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 589 ;
                            nonMedical = 596 ;
                            Diabetes = 3099;
                            Hypertension = 1490;
                            meternityCover = 11490 ;

                        }else if ((age_36>35 && age_36<41) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 648 ;
                            nonMedical = 745 ;
                            Diabetes = 4339;
                            Hypertension = 1863;
                            meternityCover = 11490 ;
                        }

                    }else if (agee41 != null){
                        int age_41 = Integer.parseInt(agee41);

                        if ((age_41>40 && age_41<46 ) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 300 ;
                            nonMedical = 100 ;
                            Diabetes = 200;
                            Hypertension = 300;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 330 ;
                            nonMedical = 125 ;
                            Diabetes = 280;
                            Hypertension = 375;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 363 ;
                            nonMedical = 156 ;
                            Diabetes = 392;
                            Hypertension = 469;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 399 ;
                            nonMedical = 195 ;
                            Diabetes = 549;
                            Hypertension = 586;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 439 ;
                            nonMedical = 244 ;
                            Diabetes = 768;
                            Hypertension = 732;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 483 ;
                            nonMedical = 305 ;
                            Diabetes = 1076;
                            Hypertension = 916;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 531 ;
                            nonMedical = 381 ;
                            Diabetes = 1506;
                            Hypertension = 1144;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 585 ;
                            nonMedical = 477 ;
                            Diabetes = 2108;
                            Hypertension = 1431;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 643 ;
                            nonMedical = 596 ;
                            Diabetes = 2952;
                            Hypertension = 1788;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 707 ;
                            nonMedical = 745 ;
                            Diabetes = 4132;
                            Hypertension = 2235;
                            meternityCover = 10720 ;

                        }else if ((age_41>40 && age_41<46) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 778 ;
                            nonMedical = 931 ;
                            Diabetes = 5785;
                            Hypertension = 2794;
                            meternityCover = 10720 ;

                        }

                    }else if (agee46 != null){

                        int age_46 = Integer.parseInt(agee46);

                        if ((age_46>45 && age_46<51) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 325 ;
                            nonMedical = 100 ;
                            Diabetes = 300;
                            Hypertension = 400;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 358 ;
                            nonMedical = 125 ;
                            Diabetes = 420;
                            Hypertension = 500;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 393 ;
                            nonMedical = 156 ;
                            Diabetes = 588;
                            Hypertension = 625;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 433 ;
                            nonMedical = 195 ;
                            Diabetes = 823;
                            Hypertension = 781;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 476 ;
                            nonMedical = 244 ;
                            Diabetes = 1152;
                            Hypertension = 977;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 523 ;
                            nonMedical = 305 ;
                            Diabetes = 1613;
                            Hypertension = 1221;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 576 ;
                            nonMedical = 381 ;
                            Diabetes = 2259;
                            Hypertension = 1526;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 633 ;
                            nonMedical = 477 ;
                            Diabetes = 3162;
                            Hypertension = 1907;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 697 ;
                            nonMedical = 596 ;
                            Diabetes = 4427;
                            Hypertension = 2384;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 766 ;
                            nonMedical = 745 ;
                            Diabetes = 6198;
                            Hypertension = 2980;
                            meternityCover = 10720 ;

                        }else if((age_46>45 && age_46<51) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 843 ;
                            nonMedical = 931 ;
                            Diabetes = 8678;
                            Hypertension = 3725;
                            meternityCover = 10720 ;
                        }

                    }else if (agee51 != null){

                        int age_51 = Integer.parseInt(agee51);

                        if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 350 ;
                            nonMedical = 200 ;
                            Diabetes = 400;
                            Hypertension = 500;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 385 ;
                            nonMedical = 250 ;
                            Diabetes = 560;
                            Hypertension = 625;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 425 ;
                            nonMedical = 313 ;
                            Diabetes = 784;
                            Hypertension = 781;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 466 ;
                            nonMedical = 391 ;
                            Diabetes = 1098;
                            Hypertension = 977;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 512 ;
                            nonMedical = 488 ;
                            Diabetes = 1537;
                            Hypertension = 1221;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 564 ;
                            nonMedical = 610 ;
                            Diabetes = 2151;
                            Hypertension = 1526;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 620 ;
                            nonMedical = 763 ;
                            Diabetes = 3012;
                            Hypertension = 1907;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 682 ;
                            nonMedical = 954 ;
                            Diabetes = 4217;
                            Hypertension = 2384;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 750 ;
                            nonMedical = 1192 ;
                            Diabetes = 5903;
                            Hypertension = 2980;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 825 ;
                            nonMedical = 1490 ;
                            Diabetes = 8264;
                            Hypertension = 3725;
                            meternityCover = 9920 ;

                        }else if ((age_51>50 && age_51<56) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 908 ;
                            nonMedical = 1863 ;
                            Diabetes = 11570;
                            Hypertension = 4657;
                            meternityCover = 9920 ;

                        }

                    }else if (agee56 != null){

                        int age_56 = Integer.parseInt(agee56);

                        if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 375 ;
                            nonMedical = 200 ;
                            Diabetes = 600;
                            Hypertension = 600;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 413 ;
                            nonMedical = 250 ;
                            Diabetes = 840;
                            Hypertension = 750;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 454 ;
                            nonMedical = 313 ;
                            Diabetes = 1176;
                            Hypertension = 938;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 499 ;
                            nonMedical = 391 ;
                            Diabetes = 1646;
                            Hypertension = 1172;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 549 ;
                            nonMedical = 488 ;
                            Diabetes = 2305;
                            Hypertension = 1465;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 604 ;
                            nonMedical = 610 ;
                            Diabetes = 3227;
                            Hypertension = 1831;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 664 ;
                            nonMedical = 763 ;
                            Diabetes = 4518;
                            Hypertension = 2289;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 731 ;
                            nonMedical = 954 ;
                            Diabetes = 6325;
                            Hypertension = 2861;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 804 ;
                            nonMedical = 1192 ;
                            Diabetes = 8855;
                            Hypertension = 3576;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 884 ;
                            nonMedical = 1490 ;
                            Diabetes = 12397;
                            Hypertension = 4470;
                            meternityCover = 8220 ;

                        }else if ((age_56>55 && age_56<61) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 973 ;
                            nonMedical = 1862 ;
                            Diabetes = 17355;
                            Hypertension = 5588;
                            meternityCover = 8220 ;

                        }

                    }else if (agee61 != null){

                        int age_61 = Integer.parseInt(agee61);

                        if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 400 ;
                            nonMedical = 250 ;
                            Diabetes = 800;
                            Hypertension = 700;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 440 ;
                            nonMedical = 313 ;
                            Diabetes = 1120;
                            Hypertension = 875;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 484 ;
                            nonMedical = 391 ;
                            Diabetes = 1568;
                            Hypertension = 1094;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 532 ;
                            nonMedical = 488 ;
                            Diabetes = 2195;
                            Hypertension = 1367;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 586 ;
                            nonMedical = 610 ;
                            Diabetes = 3073;
                            Hypertension = 1709;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 644 ;
                            nonMedical = 763 ;
                            Diabetes = 4303;
                            Hypertension = 2136;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 709 ;
                            nonMedical = 954 ;
                            Diabetes = 6024;
                            Hypertension = 2670;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 779 ;
                            nonMedical = 1192 ;
                            Diabetes = 4433;
                            Hypertension = 3338;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 857 ;
                            nonMedical = 1490 ;
                            Diabetes = 11806;
                            Hypertension = 4172;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 943 ;
                            nonMedical = 1863 ;
                            Diabetes = 16529;
                            Hypertension = 5215;
                            meternityCover = 5480 ;

                        }else if ((age_61>60 && age_61<66) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1037 ;
                            nonMedical = 2328 ;
                            Diabetes = 23140;
                            Hypertension = 6519;
                            meternityCover = 5480 ;

                        }

                    }else if (agee66 != null){

                        int age_66 = Integer.parseInt(agee66);

                        if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("3 Lakh")){

                            planAmount = 425 ;
                            nonMedical = 250 ;
                            Diabetes = 800;
                            Hypertension = 700;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 468 ;
                            nonMedical = 313 ;
                            Diabetes = 1120;
                            Hypertension = 875;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 514 ;
                            nonMedical = 391 ;
                            Diabetes = 1568;
                            Hypertension = 1094;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 566 ;
                            nonMedical = 488 ;
                            Diabetes = 2195;
                            Hypertension = 1367;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 622 ;
                            nonMedical = 610 ;
                            Diabetes = 3073;
                            Hypertension = 1709;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 684 ;
                            nonMedical = 763 ;
                            Diabetes = 4303;
                            Hypertension = 2136;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 753 ;
                            nonMedical = 954 ;
                            Diabetes = 6024;
                            Hypertension = 2670;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 828 ;
                            nonMedical = 1192 ;
                            Diabetes = 8433;
                            Hypertension = 3338;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 911 ;
                            nonMedical = 1490 ;
                            Diabetes = 11806;
                            Hypertension = 4172;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1002 ;
                            nonMedical = 1863 ;
                            Diabetes = 16529;
                            Hypertension = 5215;
                            meternityCover = 5480 ;

                        }else if ((age_66>65 && age_66<71) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1102 ;
                            nonMedical = 2328 ;
                            Diabetes = 23140;
                            Hypertension = 6519;
                            meternityCover = 5480 ;

                        }

                    }else if(agee71 != null){

                        int age_71 = Integer.parseInt(agee71);

                        if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("3 Lakh")){
                            planAmount = 450 ;
                            nonMedical = 250 ;
                            Diabetes = 850;
                            Hypertension = 800;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("5 Lakh")){
                            planAmount = 495 ;
                            nonMedical = 313 ;
                            Diabetes = 1190;
                            Hypertension = 1000;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("7 . 5 Lakh")){
                            planAmount = 545 ;
                            nonMedical = 391 ;
                            Diabetes = 1666;
                            Hypertension = 1250;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("10 Lakh") || strByDefaultValue.equals("10 Lakh")){
                            planAmount = 599 ;
                            nonMedical = 488 ;
                            Diabetes = 2332;
                            Hypertension = 1563;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("12 . 5 Lakh")){
                            planAmount = 659 ;
                            nonMedical = 610 ;
                            Diabetes = 3265;
                            Hypertension = 1953;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("15 Lakh")){
                            planAmount = 725 ;
                            nonMedical = 763 ;
                            Diabetes = 4572;
                            Hypertension = 2441;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("20 Lakh")){
                            planAmount = 797 ;
                            nonMedical = 954 ;
                            Diabetes = 6400;
                            Hypertension = 3052;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("25 Lakh")){
                            planAmount = 877 ;
                            nonMedical = 1192 ;
                            Diabetes = 8960;
                            Hypertension = 3815;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("50 Lakh")){
                            planAmount = 965 ;
                            nonMedical = 1490 ;
                            Diabetes = 12544;
                            Hypertension = 4768;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("75 Lakh")){
                            planAmount = 1061 ;
                            nonMedical = 1863 ;
                            Diabetes = 17562;
                            Hypertension = 5960;
                            meternityCover = 5480 ;

                        }else if ((age_71>70 && age_71<76) && strGenderEditSpinner.equals("1 Crore")){
                            planAmount = 1167 ;
                            nonMedical = 2328 ;
                            Diabetes = 24587;
                            Hypertension = 7451;
                            meternityCover = 5480 ;

                        }

                    }

                    convert_amount = (Double.parseDouble(diamond_3year.getText().toString()));
                    selected_amount = (int)convert_amount;
                    selected_type = "Diamond";
                    selected_year = "3 year";

                }
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        add_ons_value=0;
    }

    private String currencyFormat(int selected_amount){
        DecimalFormat decimalFormat  = new DecimalFormat("###,##,##0.00");
        return decimalFormat.format(Double.parseDouble(String.valueOf(selected_amount)));
    }

    @Override
    protected void onResume() {
        super.onResume();

        discount_value = 0;

    }




}