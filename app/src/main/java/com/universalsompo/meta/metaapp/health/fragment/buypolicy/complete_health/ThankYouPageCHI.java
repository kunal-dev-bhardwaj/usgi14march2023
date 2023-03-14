package com.universalsompo.meta.metaapp.health.fragment.buypolicy.complete_health;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ThankYouPageCHI extends AppCompatActivity {
    String downloadPolicy;
    TextView ClickHereTxt;
    Button btn_continue;
    String dest_file_path = "test.pdf";
    int downloadedSize = 0, totalsize;
    float per = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you_page_chi);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        downloadPolicy = getIntent().getStringExtra("downloadPolicy");
        ClickHereTxt = findViewById(R.id.ClickHereTxt);
        btn_continue = findViewById(R.id.btn_continue);
//        downloadPolicy="https://webuat.universalsompo.com/WAPDFUAT/WAPDFGenerat.aspx?QuoteID=e03yTlkleBJlB_HRYZsQJQ==";


        ClickHereTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                downloadAndOpenPDF();
//                downloadPdf();
//                downloadAttachment(ThankYouPageCHI.this, "PolicySchedule", ".pdf",DIRECTORY_DOWNLOADS, downloadPolicy);
                downloadAttachment(ThankYouPageCHI.this,downloadPolicy);
            }
        });
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThankYouPageCHI.this, MainActivityHealth.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void downloadAndOpenPDF() {
        new Thread(new Runnable() {
            public void run() {
                Uri path = Uri.fromFile(downloadFile(downloadPolicy));
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(ThankYouPageCHI.this, "PDF Reader application is not installed in your device", Toast.LENGTH_SHORT).show();
                }
            }
        }).start();

    }

    File downloadFile(String dwnload_file_path) {
        File file = null;
        try {
            URL url = new URL(dwnload_file_path);
            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);

            // connect
            urlConnection.connect();

            // set the path where we want to save the file
            File SDCardRoot = Environment.getExternalStorageDirectory();
            // create a new file, to save the downloaded file
            file = new File(SDCardRoot, dest_file_path);

            FileOutputStream fileOutput = new FileOutputStream(file);

            // Stream used for reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            // this is the total size of the file which we are
            // downloading
            totalsize = urlConnection.getContentLength();
            Toast.makeText(ThankYouPageCHI.this, "Starting PDF download...", Toast.LENGTH_SHORT).show();

            // create a buffer...
            byte[] buffer = new byte[1024 * 1024];
            int bufferLength = 0;

            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
                per = ((float) downloadedSize / totalsize) * 100;

                Toast.makeText(ThankYouPageCHI.this, "Total PDF File size  : " + (totalsize / 1024)+ " KB\n\nDownloading PDF " + (int) per
                        + "% complete", Toast.LENGTH_SHORT).show();
            }
            // close the output stream when complete //
            fileOutput.close();
            Toast.makeText(ThankYouPageCHI.this, "Download Complete. Open PDF Application installed in the device.", Toast.LENGTH_SHORT).show();


        } catch (final IOException e) {
            Toast.makeText(ThankYouPageCHI.this, "Some error occured. Press back and try again.", Toast.LENGTH_SHORT).show();
        } catch (final Exception e) {
            Toast.makeText(ThankYouPageCHI.this, "Download Complete. Open PDF Application installed in the device.", Toast.LENGTH_SHORT).show();
        }
        return file;
    }

    private void downloadPdf() {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadPolicy));
        request.setMimeType("application/pdf");


//        String title = URLUtil.guessFileName(downloadPolicy,null,"application/pdf");
//        request.setTitle(title);
        request.setDescription("Downloading file Please wait...");
        String cookies = CookieManager.getInstance().getCookie(downloadPolicy);
        request.addRequestHeader("cookies",cookies);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(DIRECTORY_DOWNLOADS,".pdf");
        DownloadManager manager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        manager.enqueue(request);



        Toast.makeText(ThankYouPageCHI.this, "PDF File Downloading Please wait...", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(ThankYouPageCHI.this, MainActivityHealth.class);
        startActivity(intent);
        finish();
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

        return downloadmanager.enqueue(request);
    }
}