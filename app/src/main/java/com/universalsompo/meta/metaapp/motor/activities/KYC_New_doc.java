package com.universalsompo.meta.metaapp.motor.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.universalsompo.meta.R;

import java.io.IOException;

public class KYC_New_doc extends AppCompatActivity {
    ImageView img_preview;
    final int TAKE_PHOTO_REQ = 100;
    Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_y_c__new_doc);

        LinearLayout camera_llayout = findViewById(R.id.camera_llayout);
        img_preview = findViewById(R.id.img_uploaded_preview);
        camera_llayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, TAKE_PHOTO_REQ);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int CAMERA_REQUEST = 301;
        if (requestCode == CAMERA_REQUEST) {
            if (resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Bitmap resized = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
                img_preview.setImageBitmap(ProfilePicture.getRoundedRectBitmap(resized));
            }
        }
    }

    public static class ProfilePicture {
        public static Bitmap getRoundedRectBitmap(Bitmap resized) {
            Bitmap result = null;
            try {
                result = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(result);

                int color = 0xff424242;
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, 200, 200);

                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(color);
                canvas.drawCircle(50, 50, 50, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(resized, rect, rect, paint);


            } catch (NullPointerException e) {
            } catch (OutOfMemoryError o) {
            }
            return result;
        }
    }
}