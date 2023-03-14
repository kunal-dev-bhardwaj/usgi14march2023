package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.universalsompo.meta.R;

import org.joda.time.DateTimeUtils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Previous_Private_Policy_Details extends AppCompatActivity {
    LinearLayout ncb_liner,start_policy_liner,claim_liner,btn_liner;
     RadioButton yes_previous_policy,no_previous_policy,yes_claim_policy,no_claim_policy;
     EditText previous_start_date;
    private SimpleDateFormat dateFormatter;
    Button btn_next,btn_previous;
    long elapsedDays;
    Date date;
    Date dateNew;
    Format formatter;
    Date Policy_End_Date= null;
    Date registerDate;
    String current_date,nextYear;
    String str_edt_phone="",str_edt_email="",str_edt_registration_no="",str_edt_city="",str_rto_location="",str_manufacture_year="",str_edt_registration_date="",str_previous_start_date="",str_manufacture_name="",str_vehicle_model="",str_previousPolicy="",str_claim_policy="No";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous__private__policy__details);
        getWindow().setStatusBarColor(ContextCompat.getColor(Previous_Private_Policy_Details.this, R.color.colorPrimaryDark));
        initView();
        str_edt_registration_no = getIntent().getStringExtra("str_edt_registration_no");
        str_edt_city = getIntent().getStringExtra("str_edt_city");
        str_edt_phone = getIntent().getStringExtra("str_edt_phone");
        str_edt_email = getIntent().getStringExtra("str_edt_email");
        str_rto_location = getIntent().getStringExtra("str_rto_location");
        str_manufacture_year = getIntent().getStringExtra("str_manufacture_year");
        str_edt_registration_date = getIntent().getStringExtra("str_edt_registration_date");
        str_manufacture_name = getIntent().getStringExtra("str_manufacture_name");
        str_vehicle_model = getIntent().getStringExtra("str_vehicle_model");

    }

    private void initView() {
        ncb_liner=findViewById(R.id.ncb_liner);
        claim_liner=findViewById(R.id.claim_liner);
        start_policy_liner=findViewById(R.id.start_policy_liner);
        yes_previous_policy=findViewById(R.id.yes_previous_policy);
        no_previous_policy=findViewById(R.id.no_previous_policy);
        yes_claim_policy=findViewById(R.id.yes_claim_policy);
        no_claim_policy=findViewById(R.id.no_claim_policy);
        previous_start_date=findViewById(R.id.previous_start_date);
        btn_liner=findViewById(R.id.btn_liner);
        btn_previous=findViewById(R.id.btn_previous);
        btn_next=findViewById(R.id.btn_next);

        yes_previous_policy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_previous_policy.isChecked())
                    str_previousPolicy="Yes";
                start_policy_liner.setVisibility(View.VISIBLE);
                btn_liner.setVisibility(View.VISIBLE);
                claim_liner.setVisibility(View.VISIBLE);
                no_previous_policy.setChecked(false);
            }
        });
        no_previous_policy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_previous_policy.isChecked())
                    str_previousPolicy="No";
                    btn_liner.setVisibility(View.GONE);
                    start_policy_liner.setVisibility(View.GONE);
                     claim_liner.setVisibility(View.GONE);
                yes_previous_policy.setChecked(false);
            }
        });


        yes_claim_policy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (yes_claim_policy.isChecked())
                    str_claim_policy="Yes";
                    ncb_liner.setVisibility(View.GONE);
//                btn_liner.setVisibility(View.VISIBLE);
                no_claim_policy.setChecked(false);
            }
        });

        no_claim_policy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (no_claim_policy.isChecked())
                    str_claim_policy="No";
                    ncb_liner.setVisibility(View.VISIBLE);
//                    btn_liner.setVisibility(View.GONE);
                    yes_claim_policy.setChecked(false);
            }
        });
        previous_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalender();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_previous_start_date=previous_start_date.getText().toString();
               if (!str_previousPolicy.equals("")&&!str_previous_start_date.equals("")){
                   Intent intent=new Intent(Previous_Private_Policy_Details.this,Private_Policy_Type.class);
                   intent.putExtra("str_edt_registration_no",str_edt_registration_no);
                   intent.putExtra("str_edt_city",str_edt_city);
                   intent.putExtra("str_edt_phone",str_edt_phone);
                   intent.putExtra("str_edt_email",str_edt_email);
                   intent.putExtra("str_rto_location",str_rto_location);
                   intent.putExtra("str_manufacture_year",str_manufacture_year);
                   intent.putExtra("str_edt_registration_date",str_edt_registration_date);
                   intent.putExtra("str_manufacture_name",str_manufacture_name);
                   intent.putExtra("str_vehicle_model",str_vehicle_model);
                   intent.putExtra("str_previousPolicy",str_previousPolicy);
                   intent.putExtra("str_claim_policy",str_claim_policy);
                   intent.putExtra("str_previous_start_date",str_previous_start_date);
                   startActivity(intent);
                   finish();

               }else if (!str_previous_start_date.equals("")){
                   if (nextYear.compareTo(current_date)<0){
                       if (elapsedDays<=44){
                           Intent intent=new Intent(Previous_Private_Policy_Details.this,Private_Policy_Type.class);
                           intent.putExtra("str_edt_registration_no",str_edt_registration_no);
                           intent.putExtra("str_edt_city",str_edt_city);
                           intent.putExtra("str_edt_phone",str_edt_phone);
                           intent.putExtra("str_edt_email",str_edt_email);
                           intent.putExtra("str_rto_location",str_rto_location);
                           intent.putExtra("str_manufacture_year",str_manufacture_year);
                           intent.putExtra("str_edt_registration_date",str_edt_registration_date);
                           intent.putExtra("str_manufacture_name",str_manufacture_name);
                           intent.putExtra("str_vehicle_model",str_vehicle_model);
                           intent.putExtra("str_previousPolicy",str_previousPolicy);
                           intent.putExtra("str_claim_policy",str_claim_policy);
                           intent.putExtra("str_previous_start_date",str_previous_start_date);
                           startActivity(intent);
                           finish(); }
                       else {
                           Toast.makeText(Previous_Private_Policy_Details.this, "Previous Policy End Date Should not be more than 44 days From Today Date ", Toast.LENGTH_SHORT).show();
                       }
                   }
               }else{
                   Toast.makeText(Previous_Private_Policy_Details.this, "Select Policy Policy and Policy Date", Toast.LENGTH_SHORT).show();
               }


//               else if (elapsedDays==365||elapsedDays==366){
//                       Intent intent=new Intent(Previous_Private_Policy_Details.this,Private_Policy_Type.class);
//                       intent.putExtra("str_edt_registration_no",str_edt_registration_no);
//                       intent.putExtra("str_edt_city",str_edt_city);
//                       intent.putExtra("str_edt_phone",str_edt_phone);
//                       intent.putExtra("str_edt_email",str_edt_email);
//                       intent.putExtra("str_rto_location",str_rto_location);
//                       intent.putExtra("str_manufacture_year",str_manufacture_year);
//                       intent.putExtra("str_edt_registration_date",str_edt_registration_date);
//                       intent.putExtra("str_manufacture_name",str_manufacture_name);
//                       intent.putExtra("str_vehicle_model",str_vehicle_model);
//                       intent.putExtra("str_previousPolicy",str_previousPolicy);
//                       intent.putExtra("str_claim_policy",str_claim_policy);
//                       intent.putExtra("str_previous_start_date",str_previous_start_date);
//                       startActivity(intent);
//                       finish();
//                   }else{
//                       Toast.makeText(Previous_Private_Policy_Details.this, "Previous Policy End Date Should not be more than 44 days From Today Date ", Toast.LENGTH_SHORT).show();
//                   }

            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Previous_Private_Policy_Details.this,Private_car_vehicle_details.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd/M/yyyy");
        DatePickerDialog datePicker = new DatePickerDialog(Previous_Private_Policy_Details.this, R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            str_previous_start_date=dateFormatter.format(newDate.getTime());
            previous_start_date.setText(str_previous_start_date);

            newDate.add(Calendar.DATE, 365);
            dateNew = newDate.getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            nextYear = formatter.format(dateNew);

            try {
                Policy_End_Date = new SimpleDateFormat("dd/M/yyyy").parse(nextYear);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Log.e("nextYear",nextYear);
            try {
//                Date registerDate=new SimpleDateFormat("dd/M/yyyy").parse(str_edt_registration_date);
               // Date previousDate=new SimpleDateFormat("dd/M/yyyy").parse(str_previous_start_date);
                Calendar calendar = Calendar.getInstance();
                date = calendar.getTime();
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                current_date = formatter.format(date);
                 registerDate=new SimpleDateFormat("dd/M/yyyy").parse(current_date);
                Log.e("current_date",current_date);

                printDifference(registerDate, Policy_End_Date);

            } catch (ParseException e) {
                e.printStackTrace();
            }


        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }


    public void printDifference(Date startDate, Date endDate) {
        //milliseconds
//        long different = -endDate.getTime();
        long different = endDate.getTime()-startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : "+ endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

         elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;
//        Log.e("%d days, %d hours, %d minutes, %d seconds%n",elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);


        System.out.printf("%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
    }

}