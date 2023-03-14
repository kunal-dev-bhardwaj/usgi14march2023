package com.universalsompo.meta.metaapp.motor.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.models.CashLessModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.SendEmailDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class AutoClaimFormAdapter extends RecyclerView.Adapter<AutoClaimFormAdapter.MyViewHolder> {
    private Activity mContext;
    private List<CashLessModel> list;
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder build;
    private int id = 1;
    private SendEmailDialog emailDialog;
    private String v_type;
    private MySharedPreference pref;
    private CustomProgressDialog customProgressDialog;
    private String CHANNEL_ID = "auto_form_download";

    public AutoClaimFormAdapter(Activity mContext, List<CashLessModel> list, String v_type) {
        this.mContext = mContext;
        this.list = list;
        this.v_type = v_type;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        LinearLayout download1, email1;

        private MyViewHolder(View view) {
            super(view);
            text1 = view.findViewById(R.id.text1);
            download1 = view.findViewById(R.id.download1);
            email1 = view.findViewById(R.id.email1);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto_claim_forms, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        pref = MySharedPreference.getInstance(mContext);
        customProgressDialog = new CustomProgressDialog(mContext);
        holder.text1.setText(list.get(position).getFormType());

        holder.download1.setOnClickListener(v -> {
            customProgressDialog.showProgressBar();
            String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(list.get(position).getFormPath());
            AutoClaimFormAdapter.this.startDownload(list.get(position).getInsCompName() + "_" + list.get(position).getFormType() + "." + extension, list.get(position).getFormPath(), holder.download1);
        });

        holder.email1.setOnClickListener(v -> {
            emailDialog = new SendEmailDialog(mContext, v_type, pref.getEmailId(), list.get(position).getFormId(), FragmentsTags.FRAGMENT_DOCUMENT_CLAIM);
            emailDialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void startDownload(String Title, String url, LinearLayout img) {
        mNotifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        build = new NotificationCompat.Builder(mContext,CHANNEL_ID);
        build.setContentTitle(Title).setContentText("Progress 0 %").setSmallIcon(android.R.drawable.stat_sys_download);
        new DownloadTask(mContext, Title, img).execute(url);
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

    @SuppressLint("StaticFieldLeak")
    public class DownloadTask extends AsyncTask<String, Integer, String> {
        private Context context;
        private String name;

        public DownloadTask(Context context, String name, LinearLayout img) {
            this.context = context;
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
                    if (isCancelled()) {
                        input.close();
                        return null;
                    }
                    total += count;
                    if (fileLength > 0)
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
                } catch (IOException ignored) {
                }
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
            PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, 0);
            build.setContentTitle(name);
            build.setContentText("Download complete");
            build.setProgress(0, 0, false);
            build.setSmallIcon(android.R.drawable.stat_sys_download_done);
            build.setContentIntent(pIntent).build();
            mNotifyManager.notify(id, build.build());
            customProgressDialog.hideProgressBar();
            showDialog("/sdcard/download/" + name);
        }
    }

    @SuppressLint("SetTextI18n")
    private void showDialog(final String doc_path) {
        final Dialog download_file_dialog = new Dialog(mContext);
        download_file_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        download_file_dialog.setCanceledOnTouchOutside(false);
        download_file_dialog.setCancelable(false);
        Objects.requireNonNull(download_file_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        download_file_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        download_file_dialog.setContentView(R.layout.dialog_download_motor);
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
            if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                mContext.startActivity(intent);
            } else {
                assert mimetype != null;
                AutoClaimFormAdapter.this.ErrorDialog(mimetype.split("/")[1]);
            }
            download_file_dialog.dismiss();
        });
        txt_cancel.setOnClickListener(v -> download_file_dialog.dismiss());
    }

    private void ErrorDialog(final String Text) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.dialog_file_not_found_motor);
        LinearLayout play =  dialog.findViewById(R.id.play);
        LinearLayout ok =  dialog.findViewById(R.id.ok);
        play.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/search?q=" + Text + " reader"));
            mContext.startActivity(intent);
            dialog.dismiss();
        });
        ok.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }
}
