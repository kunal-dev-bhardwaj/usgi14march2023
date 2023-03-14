package com.universalsompo.meta.metaapp.utilities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import com.universalsompo.meta.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFileFromURL extends AsyncTask<String, String, String> {
    private ProgressDialog pd;
    private String Url;
    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    private String fileName;
    private Dialog download_file_dialog;

    public DownloadFileFromURL(String Url, Context mContext, String fileName) {
        this.Url = Url;
        this.mContext = mContext;
        this.fileName = fileName;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setCancelable(true);
        pd.setMessage("Loading");
        pd.setIndeterminate(false);
        pd.setCanceledOnTouchOutside(false);
        pd.show();
    }

    @Override
    protected String doInBackground(String... f_url) {
        int count;
        try {
            URL url = new URL(Url);
            URLConnection conection = url.openConnection();
            conection.connect();
            int lenghtOfFile = conection.getContentLength();
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            @SuppressLint("SdCardPath") OutputStream output = new FileOutputStream("/sdcard/download/" + fileName);
            byte[] data = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
             LogUtils.showLog("Error: ", e.getMessage());
        }
        return null;
    }

    protected void onProgressUpdate(String... progress) {

        pd.dismiss();
    }

    @Override
    protected void onPostExecute(String file_url) {
        pd.dismiss();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        @SuppressLint("SdCardPath") String imagePath = "/sdcard/download/" + fileName;
        showDialog(imagePath);
    }

    @SuppressLint("SetTextI18n")
    private void showDialog(final String doc_path) {
        download_file_dialog = new Dialog(mContext);
        download_file_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        download_file_dialog.setContentView(R.layout.dialog_download_file);
        TextView txt_open_file, txt_cancel, txt_doc_path;
        txt_cancel = download_file_dialog.findViewById(R.id.txt_cancel_file);
        txt_open_file = download_file_dialog.findViewById(R.id.txt_open_file);
        txt_doc_path = download_file_dialog.findViewById(R.id.txt_doc_path);
        txt_doc_path.setText("File Saved into : " + doc_path);
        download_file_dialog.show();

        txt_open_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(doc_path);
                MimeTypeMap map = MimeTypeMap.getSingleton();
                String ext = MimeTypeMap.getFileExtensionFromUrl(file.getName());
                String type = map.getMimeTypeFromExtension(ext);
                if (type == null)
                    type = "*/*";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.fromFile(file);
                intent.setDataAndType(data, type);
                mContext.startActivity(intent);
                download_file_dialog.dismiss();
            }
        });
        txt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download_file_dialog.dismiss();
            }

        });
    }
}