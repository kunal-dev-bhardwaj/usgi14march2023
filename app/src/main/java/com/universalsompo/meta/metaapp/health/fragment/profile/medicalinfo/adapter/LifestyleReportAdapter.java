package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter;

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

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.LifestyleReportModel;
import com.universalsompo.meta.metaapp.utilities.FileUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class LifestyleReportAdapter extends RecyclerView.Adapter<LifestyleReportAdapter.MyViewHolder> {
    private Activity mContext;
    private List<LifestyleReportModel> lifestyleReportList;
    private String Doc_path;
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder build;
    private int id = 1;
    private Dialog download_file_dialog;
    private String CHANNEL_ID = "downloading_report";

    public LifestyleReportAdapter(Activity mContext, List<LifestyleReportModel> lifestyleReportList) {
        this.mContext = mContext;
        this.lifestyleReportList = lifestyleReportList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView hra_status, hra_date;
        LinearLayout share, download;

        public MyViewHolder(View view) {
            super(view);
            hra_status = view.findViewById(R.id.hra_status);
            hra_date = view.findViewById(R.id.hra_date);
            share = view.findViewById(R.id.share);
            download = view.findViewById(R.id.download);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_lifestyle_report_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.hra_status.setText("Completed");
        holder.hra_date.setText(lifestyleReportList.get(position).getDate());

        Doc_path = lifestyleReportList.get(position).getFilePath();

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doc_path = lifestyleReportList.get(position).getFilePath();
                startDownload(Doc_path.substring(Doc_path.lastIndexOf("/") + 1), Doc_path,"share");
            }
        });

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doc_path = lifestyleReportList.get(position).getFilePath();
                if (!Doc_path.equals("")) {
                    startDownload(Doc_path.substring(Doc_path.lastIndexOf("/") + 1), Doc_path,"download");
                } else {
                    Toast.makeText(mContext, "You have no document", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lifestyleReportList.size();
    }

    private void startDownload(String Title, String url,String moto) {
        String CHANNEL_ID = "downloading";
        mNotifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        build = new NotificationCompat.Builder(mContext,CHANNEL_ID);
        build.setContentTitle(Title).setContentText("Progress 0 %").setSmallIcon(android.R.drawable.stat_sys_download);
        new LifestyleReportAdapter.DownloadTask(Title,moto).execute(url);
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
        private String moto;

        private DownloadTask(String name,String moto) {
            this.moto = moto;
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
            PendingIntent pIntent = PendingIntent.getActivity(mContext, 0, intent, 0);

            build.setContentTitle(name);
            build.setContentText("Download complete");
            build.setProgress(0, 0, false);
            build.setSmallIcon(android.R.drawable.stat_sys_download_done);
            build.setContentIntent(pIntent).build();
            mNotifyManager.notify(id, build.build());
            if(moto.equals("share")){
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("application/pdf");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"LifeStyle HRA Report");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                mContext.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            } else {
                showDialog("/sdcard/download/" + name);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void showDialog(final String doc_path) {
        download_file_dialog = new Dialog(mContext);
        download_file_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        download_file_dialog.setCanceledOnTouchOutside(false);
        download_file_dialog.setCancelable(false);
        Objects.requireNonNull(download_file_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        download_file_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        download_file_dialog.setContentView(R.layout.dialog_download_file);
        TextView txt_open_file, txt_cancel, txt_doc_path;
        txt_cancel = download_file_dialog.findViewById(R.id.txt_cancel_file);
        txt_open_file = download_file_dialog.findViewById(R.id.txt_open_file);
        txt_doc_path = download_file_dialog.findViewById(R.id.txt_doc_path);
        txt_doc_path.setText(mContext.getResources().getString(R.string.file_saved_into)+" : " + doc_path);
        download_file_dialog.show();

        txt_open_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(doc_path);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
                String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
                intent.setDataAndType(Uri.fromFile(file), mimetype);
                LogUtils.showLog("@@@@@@@@@@@@", mimetype);

                if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(intent);
                } else {
                    assert mimetype != null;
                    ErrorDialog(FileUtils.toTitleCase(mimetype.split("/")[1]) + " Reader application is not installed in your device", mimetype.split("/")[1]);
                }
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

    private void ErrorDialog(String MSG, final String Text) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.file_reader_not_found);
        TextView msg = dialog.findViewById(R.id.msg);
        RelativeLayout play =  dialog.findViewById(R.id.play);
        LinearLayout ok =  dialog.findViewById(R.id.ok);
        msg.setText(MSG);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/search?q=" + Text + " reader"));
                mContext.startActivity(intent);
                dialog.dismiss();

            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
