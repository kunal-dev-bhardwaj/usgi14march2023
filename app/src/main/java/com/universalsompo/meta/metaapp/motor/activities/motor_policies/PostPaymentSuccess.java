package com.universalsompo.meta.metaapp.motor.activities.motor_policies;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health.ThankYouPageCHI;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.paymentmotor.MotorPayemntWebURl;

public class PostPaymentSuccess extends AppCompatActivity {
          TextView backToHomeTxt;
          String downloadPolicy;
          LinearLayout downloadLiner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_payemnt_success);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        downloadPolicy = getIntent().getStringExtra("downloadPolicy");
        backToHomeTxt=findViewById(R.id.backToHomeTxt);
        downloadLiner=findViewById(R.id.downloadLiner);
        backToHomeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PostPaymentSuccess.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        downloadLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                downloadPdf();
                if (!downloadPolicy.equals("")){
                    downloadAttachment(PostPaymentSuccess.this,downloadPolicy);
                }else{
                    Toast.makeText(PostPaymentSuccess.this, "Policy Not created", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(PostPaymentSuccess.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void downloadPdf() {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadPolicy));
        request.setMimeType("application/pdf");
        String title = URLUtil.guessFileName(downloadPolicy,null,"application/pdf");
        request.setTitle(title);
        request.setDescription("Downloading file Please wait...");
        String cookies = CookieManager.getInstance().getCookie(downloadPolicy);
        request.addRequestHeader("cookies",cookies);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title);
        DownloadManager manager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        manager.enqueue(request);

        Toast.makeText(PostPaymentSuccess.this, "PDF File Downloading Please wait...", Toast.LENGTH_SHORT).show();


    }
    public long downloadAttachment(Context context,String url) {
        DownloadManager downloadmanager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        //downloadAttachment(ThankYouPageCHI.this, "PolicySchedule", ".pdf",DIRECTORY_DOWNLOADS, downloadPolicy);
        String path="PolicySchedule"+".pdf";
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(DIRECTORY_DOWNLOADS,path);
//        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        Toast.makeText(PostPaymentSuccess.this, "PDF File Downloading Please wait...", Toast.LENGTH_SHORT).show();
        return downloadmanager.enqueue(request);
    }
}