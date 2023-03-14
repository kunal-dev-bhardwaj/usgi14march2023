package com.universalsompo.meta.metaapp.motor.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.print.PdfPrint;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.MimeTypeMap;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.intefaces.PolicyBackPressCallback;
import com.universalsompo.meta.metaapp.motor.models.PolicyDetailModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.SendEmailDialog;
import com.google.gson.Gson;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class FragmentDocumentPolicy extends Fragment implements View.OnClickListener {
    private View v;
    private MySharedPreference prefrences;
    private PolicyDetailModel data;
    private String policy_id = "";
    private Dialog download_file_dialog;
    private WebView pdf_view;
    private ProgressBar progress_web;
    private String mail_id = "";
    private PolicyBackPressCallback policyBackPressCallback;
    private int PERMISSION_REQUEST = 0;
    private boolean allowSave = true;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_document_tab, container, false);
        init();
        data = new Gson().fromJson(prefrences.getRenewalPolicyDetail(), PolicyDetailModel.class);
        pdf_view.loadUrl(data.getPolicyDocPath());
        policy_id = MySharedPreference.getInstance(getActivity()).getPID();
        mail_id = MySharedPreference.getInstance(getActivity()).getEmailId();
        new AppDataPushApi().callApi(getActivity(),"Policy Detail","Document","Checked for policy document");
        backPressedAction();
        return v;
    }

    private void backPressedAction() {
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if(event.getAction()==KeyEvent.ACTION_UP)
                {
                    if (MainActivity.menu.isShown() || MainActivity.locator.isShown() || MainActivity.bebefits.isShown() || MainActivity.tips_dialog.isShown()) {
                        MainActivity.menu.setVisibility(View.GONE);
                        MainActivity.locator.setVisibility(View.GONE);
                        MainActivity.bebefits.setVisibility(View.GONE);
                        MainActivity.tips_dialog.setVisibility(View.GONE);
                        removeSelectorOnBottom();
                        return true;
                    } else
                    {
                        policyBackPressCallback.changeFragment("Own Policy");
                    }
                }
            }
            return true;
        });
    }

    private void removeSelectorOnBottom() {
        MainActivity.tvhome.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.black));
        MainActivity.iconhome.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.black));

        MainActivity.tvlocator.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        MainActivity.iconlocator.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));

        MainActivity.tvgift.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        MainActivity.icongift.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));

        MainActivity.tvcall.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
    }

    private void init() {
        TextView txt_doc_download = v.findViewById(R.id.btn_download);
        TextView txt_snd_mail = v.findViewById(R.id.btn_sendemail);
        pdf_view = v.findViewById(R.id.pdf_view);
        progress_web = v.findViewById(R.id.progress_web);
        pdf_view.getSettings().setJavaScriptEnabled(true);
        pdf_view.setWebViewClient(new WebViewClient());
        pdf_view.setWebChromeClient(new MyWebViewClient());
        pdf_view.getSettings().setBuiltInZoomControls(true);
        pdf_view.setInitialScale(50);
        prefrences = MySharedPreference.getInstance(getActivity());
        txt_doc_download.setOnClickListener(this);
        txt_snd_mail.setOnClickListener(this);
    }

    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                progress_web.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_download:
                new AppDataPushApi().callApi(getActivity(),"Policy Detail","Document","Downloaded policy document");
                savePdf();
                break;
            case R.id.btn_sendemail:
                new AppDataPushApi().callApi(getActivity(),"Policy Detail","Document","Open dialog to email policy document");
                SendEmailDialog emailDialog = new SendEmailDialog(getActivity(), data.getVehicleType(), mail_id, policy_id, FragmentsTags.FRAGMENT_DOCUMENT_POLICY);
                emailDialog.show();
                break;
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
        download_file_dialog.setContentView(R.layout.dialog_download_motor);
        TextView txt_open_file, txt_cancel, txt_doc_path;
        txt_cancel = download_file_dialog.findViewById(R.id.txt_cancel_file);
        txt_open_file = download_file_dialog.findViewById(R.id.txt_open_file);
        txt_doc_path = download_file_dialog.findViewById(R.id.txt_doc_path);
        txt_doc_path.setText("File Saved into : " + doc_path);
        download_file_dialog.show();

        txt_open_file.setOnClickListener(v -> {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            File file = new File(doc_path);
            MimeTypeMap map = MimeTypeMap.getSingleton();
            String ext = MimeTypeMap.getFileExtensionFromUrl(file.getName());
            String type = map.getMimeTypeFromExtension(ext);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.fromFile(file);
            intent.setDataAndType(data, type);
            if (intent.resolveActivity(Objects.requireNonNull(getActivity()).getPackageManager()) != null) {
                getActivity().startActivity(intent);
            } else {
                assert type != null;
                ErrorDialog(type.split("/")[1]);
            }
            download_file_dialog.dismiss();
        });

        txt_cancel.setOnClickListener(v -> download_file_dialog.dismiss());
    }


    private void ErrorDialog(final String Text) {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.dialog_file_not_found_motor);
        LinearLayout play = dialog.findViewById(R.id.play);
        LinearLayout ok = dialog.findViewById(R.id.ok);

        play.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/search?q=" + Text + " reader"));
            startActivity(intent);
            dialog.dismiss();
        });
        ok.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    public void setFragmnet(PolicyBackPressCallback policyBackPressCallback) {
        this.policyBackPressCallback = policyBackPressCallback;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void savePdf() {
        if(!allowSave)
            return;
        allowSave = false;
        if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getContext()), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PERMISSION_GRANTED) {
            String fileName = String.format("%s.pdf", new SimpleDateFormat("dd_MM_yyyyHH_mm_ss", Locale.US).format(new Date()));
            final PrintDocumentAdapter printAdapter = pdf_view.createPrintDocumentAdapter(fileName);
            PrintAttributes printAttributes = new PrintAttributes.Builder()
                    .setMediaSize(PrintAttributes.MediaSize.ISO_A4)
                    .setResolution(new PrintAttributes.Resolution("pdf", "pdf", 600, 600))
                    .setMinMargins(PrintAttributes.Margins.NO_MARGINS)
                    .build();
            final File file = Environment.getExternalStorageDirectory();
            new PdfPrint(printAttributes).print(
                    printAdapter,
                    file,
                    fileName,
                    new PdfPrint.CallbackPrint() {
                        @Override
                        public void onSuccess(String path) {
                            allowSave = true;
                            showDialog(path);
                        }

                        @Override
                        public void onFailure(Exception ex) {
                            allowSave = true;
                            Toast.makeText(getContext(),
                                    String.format("Exception while saving the file and the exception is %s", ex.getMessage()),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
        } else {
            ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity()), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST) {
            if (grantResults[Arrays.asList(permissions).indexOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)] == PERMISSION_GRANTED) {
                savePdf();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}