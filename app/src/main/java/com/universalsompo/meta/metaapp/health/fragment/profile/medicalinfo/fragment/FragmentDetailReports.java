package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.universalsompo.meta.BuildConfig;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.reminders.TypesOfReminders;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.DownloadFromURL;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class FragmentDetailReports extends Fragment implements ResponseListener, View.OnClickListener {
    View v;
    private SelectorListener binder;
    String patient_name, test_id, test_date, report_path, extension;
    private TextView patient_name1, consult_date1;
    private ImageView doc_image;
    private LinearLayout set_reminder;
    private FloatingActionButton edit1,delete1,share1;
    private EditText patient_name_edt;
    private LinearLayout save;
    private FloatingActionsMenu multiple_actions_left;
    MySharedPreference pref;
    private WebView pdf_doc;
    Uri uri;
    private ProgressDialog pdLoading;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_detail_reports, container, false);
        ((MainActivityHealth) getActivity()).remove_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        patient_name = getArguments().getString("patient_name");
        test_id = getArguments().getString("test_id");
        test_date = getArguments().getString("test_date");
        report_path = getArguments().getString("test_image");
        init();
        return v;
    }

    void init() {
        patient_name1 = v.findViewById(R.id.patient_name);
        consult_date1 = v.findViewById(R.id.consult_date);
        doc_image = v.findViewById(R.id.doc_image);
        set_reminder = v.findViewById(R.id.set_reminder);
        edit1 = v.findViewById(R.id.edit);
        delete1 = v.findViewById(R.id.delete);
        share1 = v.findViewById(R.id.share);
        save = v.findViewById(R.id.save);
        patient_name_edt = v.findViewById(R.id.patient_name_edt);
        multiple_actions_left = v.findViewById(R.id.multiple_actions_left);
        pdf_doc = v.findViewById(R.id.pdf_doc);

        extension = report_path.substring(report_path.lastIndexOf("."));

        patient_name1.setText(patient_name);
        consult_date1.setText(test_date);
        patient_name_edt.setText(patient_name);

        if (extension.equals(".jpg") || extension.equals(".jpeg") || extension.equals(".png")) {
            doc_image.setVisibility(View.VISIBLE);
            pdf_doc.setVisibility(View.GONE);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms
                    Glide.with(getContext())
                            .load(report_path)
                            .into(doc_image);
                }
            }, 500);
        } else if (extension.equals(".pdf") || extension.equals(".doc") || extension.equals(".docx")) {
            pdLoading = new ProgressDialog(getContext());
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

            doc_image.setVisibility(View.GONE);
            pdf_doc.setVisibility(View.VISIBLE);
            pdf_doc.getSettings().setJavaScriptEnabled(true);
            pdf_doc.loadUrl("http://docs.google.com/gview?embedded=true&url=" + report_path);
            pdf_doc.setWebViewClient(new WebViewClient() {

                public void onPageFinished(WebView view, String url) {
                    // do your stuff here
                    pdLoading.dismiss();
                }
            });
        }

        set_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdailog();
            }
        });

        share1.setOnClickListener(this);

        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdeletedialog();
                //deletereports();
            }
        });

        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiple_actions_left.setVisibility(View.GONE);
                save.setVisibility(View.VISIBLE);
                patient_name1.setVisibility(View.GONE);
                patient_name_edt.setVisibility(View.VISIBLE);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callApi(RequestHealthConstants.SAVE_REPORTS);
                    }
                });
            }
        });
    }

    private void showdeletedialog() {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        final Dialog dialog = new Dialog(getActivity(), R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.delete_others_medical_record_dialog);
        TextView yes = dialog.findViewById(R.id.delete_medical_other_record);
        TextView no = dialog.findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                deletereports();
            }
        });

        dialog.show();
    }

    public void deletereports() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("DocID", test_id);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.DELETE_REPORTS, this, RequestHealthConstants.DELETE_REPORTS);
        req.execute();
    }

    private void showdailog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.reminder_set_dialog1);
        LinearLayout txt_doctor_consultation, txt_lab_test;
        txt_doctor_consultation = dialog.findViewById(R.id.txt_doctor_consultation);
        txt_lab_test = dialog.findViewById(R.id.txt_lab_test);

        dialog.show();

        txt_doctor_consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new TypesOfReminders();
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_REMINDER);
                ((MainActivityHealth)getActivity()).changeTitle(FragmentsHealthTags.HEALTH_REMINDER);
                dialog.dismiss();
            }
        });

        txt_lab_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new TypesOfReminders();
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HEALTH_REMINDER);
                ((MainActivityHealth)getActivity()).changeTitle(FragmentsHealthTags.HEALTH_REMINDER);
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.SAVE_REPORTS) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("DocID", test_id);
                object.put("UserID", pref.getUID());
                object.put("PatientName", patient_name_edt.getText().toString());
                object.put("TestDate", test_date);
                object.put("FileInBase64", "");
                object.put("FileExt", "");
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_REPORTS, this, RequestHealthConstants.SAVE_REPORTS);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.DELETE_REPORTS){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(getActivity(), "Successfully deleted", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            } else {
                Toast.makeText(getActivity(), "Unable to update your thyroid values", Toast.LENGTH_SHORT).show();
            }
        } else if (Tag == RequestHealthConstants.SAVE_REPORTS){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(getActivity(), "Successfully updated", Toast.LENGTH_SHORT).show();
                patient_name_edt.setVisibility(View.GONE);
                patient_name1.setVisibility(View.VISIBLE);
                multiple_actions_left.setVisibility(View.VISIBLE);
                save.setVisibility(View.GONE);
            } else {
                Toast.makeText(getActivity(), "Unable to update values", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    private Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        } else {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;
    }

    public void OnClickShare(View view) {
        if (extension.equals(".jpg") || extension.equals(".jpeg") || extension.equals(".png")) {
            Bitmap bitmap = getBitmapFromView(doc_image);
            try {
                File file = new File(getContext().getExternalCacheDir(), "abc.png");
                FileOutputStream fOut = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                fOut.flush();
                fOut.close();
                file.setReadable(true, false);
                final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Uri uri = FileProvider.getUriForFile(getContext(), BuildConfig.APPLICATION_ID + ".provider", file);
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                intent.setType("image/png");
                startActivity(Intent.createChooser(intent, "Share image via"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            File outputFile = new File(Environment.getExternalStoragePublicDirectory
                    (Environment.DIRECTORY_DOWNLOADS), patient_name+".pdf");
            if (outputFile.exists()) {
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.getUriForFile(getContext(), BuildConfig.APPLICATION_ID + ".provider", outputFile);
                } else {
                    uri = Uri.fromFile(outputFile);
                }
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.setType("application/pdf");
                share.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(share, "Share doc via"));
            } else {
                new DownloadFromURL(report_path, getContext(), patient_name+".pdf").execute();
                OnClickShare(view);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.share:
                OnClickShare(v);
                multiple_actions_left.collapse();
                break;
        }
    }
}