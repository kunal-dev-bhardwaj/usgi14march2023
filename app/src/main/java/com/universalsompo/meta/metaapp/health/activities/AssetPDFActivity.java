package com.universalsompo.meta.metaapp.health.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.barteksc.pdfviewer.PDFView;
import com.universalsompo.meta.R;

import java.io.File;
import java.io.InputStream;

public class AssetPDFActivity extends AppCompatActivity {
    private static final String FILENAME = "list_of_unpayable_items.pdf";
    PDFView ReadTxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_pdf_opener_layout);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);*/
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        TextView back_button = findViewById(R.id.back_button);

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back_button.setTypeface(fontAwesomeFont);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        init();
    }

    public void init(){
        ReadTxt = findViewById(R.id.pdfView);
        File file = new File(this.getCacheDir(), FILENAME);

        if (!file.exists()) {
            try {
                InputStream asset = this.getAssets().open(FILENAME);
                ReadTxt.fromStream(asset)
                        .pages(0, 2, 1, 3, 4, 5)
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(true)
                        .defaultPage(0)
                        .enableAnnotationRendering(false)
                        .password(null)
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .spacing(0)
                        .load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(getApplicationContext(), "File not found",Toast.LENGTH_LONG).show();
        }
    }
}
