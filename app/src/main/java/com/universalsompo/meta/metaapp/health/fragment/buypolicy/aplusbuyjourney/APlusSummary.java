package com.universalsompo.meta.metaapp.health.fragment.buypolicy.aplusbuyjourney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.universalsompo.meta.R;

public class APlusSummary extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplus_summary);
        getWindow().setStatusBarColor(ContextCompat.getColor(APlusSummary.this, R.color.colorPrimaryDark));

    }
}