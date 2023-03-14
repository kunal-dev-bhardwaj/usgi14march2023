package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.app.NotificationCompat;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.FileUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.SendEmailDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class FragmentIndividualClaimForm extends Fragment implements ResponseListener {
    private View v;
    private MySharedPreference prefrences;
    String policyID/*, insuranceID*/, insuranceName;
    private TextView no_data;
    private LinearLayout forms, download, email;
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder build;
    int id = 1;
    private Dialog download_file_dialog;
    private CustomProgressDialog customDialog;
    private String CHANNEL_ID = "download_individual_claim";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_health_individual_form, container,false);
        assert getArguments() != null;
        policyID = getArguments().getString("policyID");
        // insuranceID = getArguments().getString("insuranceID");
        insuranceName = getArguments().getString("insuranceName");
        prefrences = MySharedPreference.getInstance(getActivity());
        customDialog = CustomProgressDialog.getInstance(getActivity());
        init();
        return v;
    }

    void init() {
        no_data = v.findViewById(R.id.no_data);
        TextView insurance_comp_name = v.findViewById(R.id.insurance_comp_name);
        forms = v.findViewById(R.id.forms);
        download = v.findViewById(R.id.download);
        email = v.findViewById(R.id.email);
        insurance_comp_name.setText(insuranceName);
        callApi();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
            object.put("UserID", prefrences.getUID());
            object.put("PolicyID", policyID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.URL_GET_BASIC_USER_DETAILS_INTIMATION, this, RequestHealthConstants.URL_GET_BASIC_USER_DETAILS_INTIMATION);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.URL_GET_BASIC_USER_DETAILS_INTIMATION) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                if (object.optString("ReimbursementDocPath") == null || object.optString("ReimbursementDocPath").equalsIgnoreCase("")) {
                    no_data.setVisibility(View.VISIBLE);
                    forms.setVisibility(View.GONE);
                } else {
                    forms.setVisibility(View.VISIBLE);
                    no_data.setVisibility(View.GONE);

                    String doc_path = null;
                    String form_id = null;
                    try {
                        doc_path = object.getString("ReimbursementDocPath");
                        form_id = object.getString("FormId");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    final String finalDoc_path = doc_path;
                    final String finalform_id = form_id;
                    email.setOnClickListener(v -> {
                        SendEmailDialog emailDialog = new SendEmailDialog(getActivity(), MySharedPreference.getInstance(getActivity()).getEmailId(), finalform_id, FragmentsHealthTags.FRAGMENT_HEALTH_EMAIL_CLAIM_FORM);
                        emailDialog.show();
                    });

                    download.setOnClickListener(v -> {
                        customDialog.showProgressBar();
                        assert finalDoc_path != null;
                        startDownload(finalDoc_path.substring(finalDoc_path.lastIndexOf("/") + 1), finalDoc_path);
                    });
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    void startDownload(String Title, String url) {
        mNotifyManager = (NotificationManager) Objects.requireNonNull(getActivity()).getSystemService(Context.NOTIFICATION_SERVICE);
        build = new NotificationCompat.Builder(getActivity(),CHANNEL_ID);
        build.setContentTitle(Title).setContentText("Progress 0 %").setSmallIcon(android.R.drawable.stat_sys_download);
        new DownloadTask(Title).execute(url);
    }

    private void createChannel(NotificationManager notificationManager) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            String name = "USGI-PULZ";
            String description = "Notification of USGI-PULZ";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.BLUE);
            notificationManager.createNotificationChannel(mChannel);
        }
    }

    public class DownloadTask extends AsyncTask<String, Integer, String> {
        private String name;

        DownloadTask(String name) {
                this.name = name;
            }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            build.setProgress(100, 0, false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createChannel(mNotifyManager);
            mNotifyManager.notify(id, build.build());
        }

        @SuppressLint("SdCardPath")
        @Override
        protected String doInBackground(String... sUrl) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(sUrl[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode()
                            + " " + connection.getResponseMessage();
                }
                int fileLength = connection.getContentLength();
                input = connection.getInputStream();
                output = new FileOutputStream("/sdcard/download/" + name);
                byte[] data = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    // allow canceling with back button
                    if (isCancelled()) {
                        input.close();
                        return null;
                    }
                    total += count;
                    // publishing the progress....
                    if (fileLength > 0) // only if total length is known
                        publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }
            } catch (Exception e) {
                return e.toString();
            } finally {
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                } catch (IOException ignored) { }
                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            build.setContentTitle("Progress " + progress[0] + "%").setContentText("Download in progress");
            build.setProgress(100, progress[0], false);
            mNotifyManager.notify(id, build.build());
            super.onProgressUpdate(progress);
        }

        @SuppressLint("SdCardPath")
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            @SuppressLint("SdCardPath") File file = new File("/sdcard/download/" + name);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
            String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            intent.setDataAndType(Uri.fromFile(file), mimetype);
            PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
            build.setContentTitle(name);
            build.setContentText("Download complete");
            build.setProgress(0, 0, false);
            build.setSmallIcon(android.R.drawable.stat_sys_download_done);
            build.setContentIntent(pIntent).build();
            mNotifyManager.notify(id, build.build());
            customDialog.hideProgressBar();
            showDialog("/sdcard/download/" + name);
        }
    }

    @SuppressLint("SetTextI18n")
    private void showDialog(final String doc_path) {
        download_file_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        download_file_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        download_file_dialog.setCanceledOnTouchOutside(false);
        download_file_dialog.setCancelable(false);
        Objects.requireNonNull(download_file_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        download_file_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        download_file_dialog.setContentView(R.layout.dialog_download_file);
        TextView txt_open_file, txt_cancel, txt_doc_path;
        txt_cancel =  download_file_dialog.findViewById(R.id.txt_cancel_file);
        txt_open_file =  download_file_dialog.findViewById(R.id.txt_open_file);
        txt_doc_path =  download_file_dialog.findViewById(R.id.txt_doc_path);
        txt_doc_path.setText("File Saved into : " + doc_path);
        download_file_dialog.show();

        txt_open_file.setOnClickListener(v -> {
            File file = new File(doc_path);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
            String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            intent.setDataAndType(Uri.fromFile(file), mimetype);
            LogUtils.showLog("@@@@@@@@@@@@", mimetype);

            if (intent.resolveActivity(Objects.requireNonNull(getActivity()).getPackageManager()) != null) {
                getActivity().startActivity(intent);
            } else {
                assert mimetype != null;
                ErrorDialog(FileUtils.toTitleCase(mimetype.split("/")[1]) + " Reader application is not installed in your device", mimetype.split("/")[1]);
            }
            download_file_dialog.dismiss();
        });

        txt_cancel.setOnClickListener(v -> download_file_dialog.dismiss());
    }

    private void ErrorDialog(String MSG, final String Text) {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.file_reader_not_found);
        TextView msg =  dialog.findViewById(R.id.msg);
        RelativeLayout play =  dialog.findViewById(R.id.play);
        LinearLayout ok =  dialog.findViewById(R.id.ok);
        msg.setText(MSG);

        play.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/search?q=" + Text + " reader"));
            Objects.requireNonNull(getActivity()).startActivity(intent);
            dialog.dismiss();
        });
        ok.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }
}
