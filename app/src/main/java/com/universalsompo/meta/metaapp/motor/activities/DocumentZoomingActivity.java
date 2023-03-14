package com.universalsompo.meta.metaapp.motor.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.utilities.BaseActivity;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class DocumentZoomingActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_zooming);
        if (android.os.Build.VERSION.SDK_INT >= 21)
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));       // Anirudh

        ImageView img_doc = findViewById(R.id.img_doc_zoom);
        LinearLayout cross_icon = findViewById(R.id.remove_zoom_img);
        TextView back_button = findViewById(R.id.back_button);
        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);
        String img_url = getIntent().getStringExtra("IMG URL");
        Picasso.get().load(img_url).fit().placeholder(R.drawable.image_preview).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(img_doc);
        cross_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
