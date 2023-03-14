package com.universalsompo.meta.metaapp.health.fragment.buypolicy.aplusbuyjourney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.universalsompo.meta.R;

public class APlusMedicalDetails extends AppCompatActivity {
          LinearLayout continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplus_medical_details);
        getWindow().setStatusBarColor(ContextCompat.getColor(APlusMedicalDetails.this, R.color.colorPrimaryDark));

        continueButton=findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(APlusMedicalDetails.this,APlusSummary.class);
                startActivity(intent);
            }
        });
    }
}