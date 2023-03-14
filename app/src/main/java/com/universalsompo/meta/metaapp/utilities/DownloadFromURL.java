package com.universalsompo.meta.metaapp.utilities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFromURL extends AsyncTask<String, String, String> {
    private ProgressDialog pd;
    private String Url;
    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    private String fileName;

    public DownloadFromURL(String Url, Context mContext, String fileName) {
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

    /**
     * Updating progress bar
     */
    protected void onProgressUpdate(String... progress) {
        pd.dismiss();
    }

    /**
     * After completing background task
     * Dismiss the progress dialog
     **/
    @Override
    protected void onPostExecute(String file_url) {
        pd.dismiss();
    }
}
