package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.fragment.FragmentIndividualClaimIntimateTab;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyMemberListModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MyMemberListAdapter extends RecyclerView.Adapter<MyMemberListAdapter.MyViewHolder> implements ResponseListener {
    private Activity mContext;
    private List<MyMemberListModel> listModelJobsInfo;
    private MySharedPreference prefrences;
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder build;
    private int id = 1;
    private Dialog download_file_dialog;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, dob, age, relationship, exclusions, coverage_details_txt;
        View view_claim_renew, view1;
        LinearLayout coverage_details_layout, coverage_details_click, policy_doc, file_claim, file_renew, renew_claim_policy;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            dob = view.findViewById(R.id.dob);
            age = view.findViewById(R.id.age);
            relationship = view.findViewById(R.id.relationship);
            exclusions = view.findViewById(R.id.exclusions);
            coverage_details_txt = view.findViewById(R.id.coverage_details_txt);
            coverage_details_layout = view.findViewById(R.id.coverage_details_layout);
            coverage_details_click = view.findViewById(R.id.coverage_details_click);
            policy_doc = view.findViewById(R.id.policy_doc);
            file_claim = view.findViewById(R.id.file_claim);
            file_renew = view.findViewById(R.id.file_renew);
            renew_claim_policy = view.findViewById(R.id.renew_claim_policy);
            view_claim_renew = view.findViewById(R.id.view_claim_renew);
            view1 = view.findViewById(R.id.view1);
        }
    }

    public MyMemberListAdapter(Activity mContext, List<MyMemberListModel> listModelJobsInfo, MySharedPreference prefrences) {
        this.mContext = mContext;
        this.listModelJobsInfo = listModelJobsInfo;
        this.prefrences = prefrences;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meta_health_member_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.name.setText(listModelJobsInfo.get(position).getName());
        String date_of_birth = listModelJobsInfo.get(position).getDate_Of_Birth();
        @SuppressLint("SimpleDateFormat") DateFormat inputFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = null;
        try {
            date = inputFormatter.parse(date_of_birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        @SuppressLint("SimpleDateFormat") DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String output = outputFormatter.format(date);
        holder.dob.setText(output);
        holder.age.setText(listModelJobsInfo.get(position).getAge());
        holder.relationship.setText(listModelJobsInfo.get(position).getRelationShip());
        holder.exclusions.setText(listModelJobsInfo.get(position).getExclusions());
        holder.coverage_details_txt.setText(listModelJobsInfo.get(position).getCoverageDetails());

       holder.coverage_details_click.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                if(holder.coverage_details_layout.getVisibility() == View.VISIBLE) {
                    holder.coverage_details_layout.setVisibility(View.GONE);
                } else {
                    holder.coverage_details_layout.setVisibility(View.VISIBLE);
                }
           }
       });

       holder.policy_doc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String DOc_Path = listModelJobsInfo.get(position).getPolicyURL();
               if (!DOc_Path.equals(""))
                   startDownload(DOc_Path.substring(DOc_Path.lastIndexOf("/") + 1), DOc_Path);
               else
                   Toast.makeText(mContext, "You have no policy document", Toast.LENGTH_SHORT).show();
           }
       });

        String remain_days = prefrences.getHealthPolicyRemainingDays();
        if (Integer.parseInt(remain_days) <= -31) {
            holder.renew_claim_policy.setVisibility(View.GONE);
            holder.view1.setVisibility(View.GONE);
        } else if (Integer.parseInt(remain_days) >= -30 && Integer.parseInt(remain_days) <= 0) {
            holder.renew_claim_policy.setVisibility(View.VISIBLE);
            holder.file_renew.setVisibility(View.VISIBLE);
            holder.file_claim.setVisibility(View.GONE);
            holder.view_claim_renew.setVisibility(View.GONE);
        } else if (Integer.parseInt(remain_days) >= 0 && Integer.parseInt(remain_days) <= 45) {
            holder.renew_claim_policy.setVisibility(View.VISIBLE);
        } else {
            holder.renew_claim_policy.setVisibility(View.VISIBLE);
            holder.file_renew.setVisibility(View.GONE);
            holder.file_claim.setVisibility(View.VISIBLE);
            holder.view_claim_renew.setVisibility(View.GONE);
        }

        holder.file_claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentIndividualClaimIntimateTab();
                Bundle b = new Bundle();
                b.putString("policyID", prefrences.getPolicy_id_health());
                b.putString("insuranceName", "Universal Sompo General Insurance Pvt. Ltd.");
                frag.setArguments(b);
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(mContext, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_CLAIM_INTIMATION);
                ((MainActivityHealth) mContext).detect(FragmentsHealthTags.FRAGMENT_HEALTH_CLAIM_INTIMATION);
            }
        });

        holder.file_renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(mContext).getToken_no());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(mContext, object, UrlHealthConstants.HEALTH_RENEWAL, this, RequestHealthConstants.HEALTH_RENEWAL);
        req.execute();
    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }

    private void startDownload(String Title, String url) {
        mNotifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        build = new NotificationCompat.Builder(mContext);
        build.setContentTitle(Title).setContentText("Progress 0 %").setSmallIcon(android.R.drawable.stat_sys_download);
        new MyMemberListAdapter.DownloadTask(mContext, Title).execute(url);
    }

    public class DownloadTask extends AsyncTask<String, Integer, String> {
        private Context context;
        private String name;
        public DownloadTask(Context context, String name) {
            this.context = context;
            this.name = name;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            build.setProgress(100, 0, false);
            mNotifyManager.notify(id, build.build());
        }

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

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            File file = new File("/sdcard/download/" + name);
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
            showDialog("/sdcard/download/" + name);
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
        txt_doc_path.setText("File Saved into : " + doc_path);
        download_file_dialog.show();

        txt_open_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(doc_path);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
                String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
                intent.setDataAndType(Uri.fromFile(file), mimetype);

                if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(intent);
                } else {
                    assert mimetype != null;
                    ErrorDialog(mimetype.split("/")[1]);
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

    private void ErrorDialog(final String Text) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.dialog_file_not_found_motor);
        LinearLayout play = dialog.findViewById(R.id.play);
        LinearLayout ok = dialog.findViewById(R.id.ok);

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

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.HEALTH_RENEWAL) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                String url = object.optString("RenewURL");
                Intent in = new Intent(mContext, PolicyInBrowser.class);
                in.putExtra("PolicyNo", prefrences.getPolicy_no_health());
                in.putExtra("Url", url);
                in.putExtra("ISFROMPDFFULL", "");
                in.putExtra("CompName", "Universal Insurance General Insurance Co. Ltd.");
                mContext.startActivity(in);
            } else {
                Toast.makeText(mContext, "No URL found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
