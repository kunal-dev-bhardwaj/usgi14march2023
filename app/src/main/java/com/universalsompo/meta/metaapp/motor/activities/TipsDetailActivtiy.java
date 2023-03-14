package com.universalsompo.meta.metaapp.motor.activities;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.TipsModel;
import com.squareup.picasso.Picasso;

public class TipsDetailActivtiy extends AppCompatActivity {
    private TipsModel tipsModel;
    private ImageView img_tips;
    private TextView txt_tips;
    private Toolbar toolbar;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_detail);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (android.os.Build.VERSION.SDK_INT >= 21)
            getWindow().setStatusBarColor(Color.parseColor("#FF08938A"));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        init();

    }

    private void init() {
        tipsModel = (TipsModel) getIntent().getSerializableExtra("tipsModel");
        mTitle = findViewById(R.id.toolbar_title);
        txt_tips = findViewById(R.id.txt_tip_detail);
        img_tips = findViewById(R.id.img_tip_detail);


        txt_tips.setText(tipsModel.getTipsTxt());
        Picasso.get().load(tipsModel.getImgPath()).into(img_tips);
        mTitle.setText("Tips of the day");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();

        return true;
    }
}
