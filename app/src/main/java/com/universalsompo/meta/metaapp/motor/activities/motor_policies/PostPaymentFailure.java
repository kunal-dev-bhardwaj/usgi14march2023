package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;

public class PostPaymentFailure extends AppCompatActivity {
          TextView TryAgainText,backToHomeTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_payment_failure);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        TryAgainText=findViewById(R.id.TryAgainText);
        backToHomeTxt=findViewById(R.id.backToHomeTxt);

        TryAgainText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PostPaymentFailure.this, Motor_summery.class);
                startActivity(intent);
                finish();
            }
        });

        backToHomeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PostPaymentFailure.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(PostPaymentFailure.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}