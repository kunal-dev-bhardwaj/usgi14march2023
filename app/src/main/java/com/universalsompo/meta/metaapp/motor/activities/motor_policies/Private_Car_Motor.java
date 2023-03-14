package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

public class Private_Car_Motor extends AppCompatActivity {
     EditText edt_phone,edt_email;
     Button btn_next;
    private MySharedPreference pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private__car__motor);
        getWindow().setStatusBarColor(ContextCompat.getColor(Private_Car_Motor.this, R.color.colorPrimaryDark));
        pref = MySharedPreference.getInstance(Private_Car_Motor.this);
        edt_phone=findViewById(R.id.edt_phone);
        edt_email=findViewById(R.id.edt_email);
        btn_next=findViewById(R.id.btn_next);

        edt_phone.setText(pref.getMOBILE());
        edt_email.setText(pref.getEmailId());

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Private_Car_Motor.this,Private_car_vehicle_details.class);
                startActivity(intent);
                Private_Car_Motor.this.finish();
            }
        });
        initView();

    }

    private void initView() {


    }
}