package com.universalsompo.meta.metaapp.motor.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.DocumentCallback;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.DocumentModel;
import com.universalsompo.meta.metaapp.motor.models.TrackingStatusModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FileUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.MyCheckPermission;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import id.zelory.compressor.Compressor;

import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.BASE_64_STRING;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.DOCUMENT_IMG_UPLOAD;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.DOC_ID;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.FILE_EXTENSION;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.GET_DOC_CATEGORY;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.TOKEN_NO;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.USER_ID;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.GET_REG_NO_LIST_DOCUMENT;

public class FragmentDocumentUpload extends Fragment implements View.OnClickListener, ResponseListener, AdapterView.OnItemSelectedListener {
    private View v;
    private LinearLayout poll_doc_rc_llayout;
    private RelativeLayout rc_relative_layout;
    private ImageView img_preview;
    private Spinner doc_autotxt;
    private Spinner spn_veh_reg;
    private Spinner poll_doc_spn_veh_reg;
    private TextView expir_date_txt;
    private ArrayList<DocumentModel> modelArrayList;
    private List<String> docTypeList;
    private ArrayList<TrackingStatusModel> arrayListModel;
    private List<String> reg_no_list;
    private Dialog saveDialog, alert_dialog;
    private DocumentCallback documentCallback;
    private String base64imageextension;
    private String base64string = "";
    private String selectedDocTypeId = "";
    private String strSelectedDocType = "";
    private String selectedRegId = "";
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private String veh_type="";
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_document_upload, container, false);
        init();
        checkAppPermission();
        callApi(GET_DOC_CATEGORY);
        return v;
    }


    void checkAppPermission() {
        if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
            if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.CAMERA)) {
                    if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                        if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)) {
                            ActivityCompat.requestPermissions(getActivity(),
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                        } else {
                            MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                            }, RequestConstants.INITIAL_PERMISSION);
                        }
                    } else {
                        MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                        }, RequestConstants.INITIAL_PERMISSION);
                    }
                } else {
                    MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                    }, RequestConstants.INITIAL_PERMISSION);
                }
            } else {
                MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                }, RequestConstants.INITIAL_PERMISSION);
            }
        } else {
            MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, RequestConstants.INITIAL_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RequestConstants.INITIAL_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    if (grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                        if (grantResults[3] == PackageManager.PERMISSION_GRANTED) {
                            if (grantResults[4] == PackageManager.PERMISSION_GRANTED) {
                            } else {
                                Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void init() {
        LinearLayout gallery_layout = v.findViewById(R.id.gallery_llayout);
        LinearLayout camera_llayout = v.findViewById(R.id.camera_llayout);
        poll_doc_rc_llayout = v.findViewById(R.id.poll_doc_rc_llayout);
        LinearLayout expiry_date_llayout = v.findViewById(R.id.expiry_date_llayout);
        rc_relative_layout = v.findViewById(R.id.rc_relative_layout);
        img_preview = v.findViewById(R.id.img_uploaded_preview);
        Button btn_save = v.findViewById(R.id.btn_save);
        doc_autotxt = v.findViewById(R.id.doc_autotxt);
        spn_veh_reg = v.findViewById(R.id.spn_veh_reg);
        poll_doc_spn_veh_reg = v.findViewById(R.id.poll_doc_spn_veh_reg);
        expir_date_txt = v.findViewById(R.id.expir_date_txt);
        LinearLayout image_click = v.findViewById(R.id.image_click);
        LinearLayout image_click1 = v.findViewById(R.id.image_click1);
        LinearLayout image_click2 = v.findViewById(R.id.image_click2);
        spn_veh_reg.setVisibility(View.GONE);
        poll_doc_rc_llayout.setVisibility(View.GONE);
        rc_relative_layout.setVisibility(View.GONE);
        docTypeList = new ArrayList<>();
        modelArrayList = new ArrayList<>();
        arrayListModel = new ArrayList<>();
        reg_no_list = new ArrayList<>();
        gallery_layout.setOnClickListener(this);
        camera_llayout.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        expiry_date_llayout.setOnClickListener(this);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        image_click.setOnClickListener(v -> doc_autotxt.performClick());
        image_click1.setOnClickListener(v -> spn_veh_reg.performClick());
        image_click2.setOnClickListener(v -> poll_doc_spn_veh_reg.performClick());
        doc_autotxt.setOnItemSelectedListener(this);
        spn_veh_reg.setOnItemSelectedListener(this);
        poll_doc_spn_veh_reg.setOnItemSelectedListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            documentCallback = (DocumentCallback) context;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            int GALLERY_REQUEST = 302;
            int CAMERA_REQUEST = 301;
            if (requestCode == GALLERY_REQUEST) {
                try {
                    handleGalaryImage(img_preview, FileUtils.getPathFromURI(Objects.requireNonNull(getActivity()).getApplicationContext(), data.getData()));
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == CAMERA_REQUEST) {
                handleCameraImages(getFileName(), img_preview);
            }
        }
    }

    private void handleGalaryImage(final ImageView img, final String File) {
        String f;
        f = compressNow(File);
        LogUtils.showLog("@@@@@@@@@@@@@", f);
        Bitmap myBitmap = BitmapFactory.decodeFile(f);
        if (img != null) {
            img.setBackgroundColor(Color.WHITE);
        }
        assert img != null;
        img.setImageBitmap(myBitmap);
        startSaveImage("DocGallery.png", myBitmap);
    }

    private void handleCameraImages(final String Path, final ImageView img) {
        String f;
        f = compressNow(Path);
        LogUtils.showLog("@@@@@@@@@@@@@", f);
        Bitmap myBitmap = BitmapFactory.decodeFile(Path);
        if (img != null) {
            img.setBackgroundColor(Color.WHITE);
        }
        assert img != null;
        img.setImageBitmap(myBitmap);
        startSaveImage("doccamera.png", myBitmap);
    }

    private String compressNow(final String file) {
        FileUtils.deleteCache(getActivity());
        File compressedImage = new Compressor.Builder(Objects.requireNonNull(getActivity()))
                .setMaxWidth(1000)
                .setMaxHeight(1000)
                .setCompressFormat(Bitmap.CompressFormat.PNG)
                .build()
                .compressToFile(new File(file));
        return compressedImage.getAbsolutePath();
    }

    private String getFileName() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "doccamera.png");
        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file.getAbsolutePath();
    }

    private void startSaveImage(String image, Bitmap myBitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), image);
        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        saveImageToFile(myBitmap, file.getAbsolutePath());
    }

    private void saveImageToFile(Bitmap bmp, String filename) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            convertBitmaptoBase64(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void convertBitmaptoBase64(Bitmap bitmap) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, bao);
        byte[] ba = bao.toByteArray();
        try {
            base64string = Base64.encodeToString(ba, Base64.DEFAULT);
            base64imageextension = ".png";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gallery_llayout:
                viewFromGallery();
                break;

            case R.id.camera_llayout:
                if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }else{
                    if ((!selectedDocTypeId.equals("")) && !(doc_autotxt.getSelectedItem().toString().equals("- Select Document Type -"))) {
                        captureImage(getFileName());

                    }else {
                        Snackbar.make(Objects.requireNonNull(getView()), "Document Type is mandatory", Snackbar.LENGTH_LONG).show();
                    }
                }
                break;

            case R.id.btn_save:
                callApi(DOCUMENT_IMG_UPLOAD);
                break;

            case R.id.expiry_date_llayout:
                showCalender();
                datePickerDialog.show();
                break;

        }
    }

    private void viewFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 302);
    }
    private void captureImage(String name){
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        File mImageFile = new File(name);
        Uri tempURI = Uri.fromFile(mImageFile);
        Log.e("tempURI", String.valueOf(tempURI));
        Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
        startActivityForResult(photoCaptureIntent, 301);
    }
    private void callApi(Integer url_id) {
        try {
            JSONObject object = new JSONObject();
            object.put(TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
            if (url_id == DOCUMENT_IMG_UPLOAD) {
                object.put(TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put(USER_ID, MySharedPreference.getInstance(getActivity()).getUID());
                object.put("PolicyId", selectedRegId);
                if(veh_type!=null)
                    object.put("VehicleType",veh_type);
                object.put(DOC_ID, selectedDocTypeId);
                if (base64imageextension == null)
                    base64imageextension = ".jpg";
                object.put(FILE_EXTENSION, base64imageextension);
                object.put(BASE_64_STRING, base64string);
                if ((!selectedDocTypeId.equals("")) && !(doc_autotxt.getSelectedItem().toString().equals("- Select Document Type -"))) {
                    if (strSelectedDocType.equalsIgnoreCase("Vehicle Reg")) {
                        if (!selectedRegId.equals("") && !(spn_veh_reg.getSelectedItem().toString().equals("- Select Registration No -"))) {
                            if (!base64string.equals("")) {
                                object.put("ExpiryDate", "");
                                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.DOCUMENT_IMG_UPLOAD, this, DOCUMENT_IMG_UPLOAD);
                                req.execute();
                            } else
                                Snackbar.make(Objects.requireNonNull(getView()), "Document Image is mandatory", Snackbar.LENGTH_LONG).show();
                        } else
                            Snackbar.make(Objects.requireNonNull(getView()), "Please select RC number", Snackbar.LENGTH_LONG).show();
                    } else if (strSelectedDocType.equalsIgnoreCase("Pollution Doc")) {
                        if (!selectedRegId.equals("") && !(poll_doc_spn_veh_reg.getSelectedItem().toString().equals("- Select Registration No -"))) {
                            if (expir_date_txt.getText().toString().contains("-")) {
                                object.put("ExpiryDate", expir_date_txt.getText().toString());
                                if (!base64string.equals("")) {
                                    ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.DOCUMENT_IMG_UPLOAD, this, DOCUMENT_IMG_UPLOAD);
                                    req.execute();
                                } else
                                    Snackbar.make(Objects.requireNonNull(getView()), "Document Image is mandatory", Snackbar.LENGTH_LONG).show();
                            } else
                                Snackbar.make(Objects.requireNonNull(getView()), "Please select POC expiry date", Snackbar.LENGTH_LONG).show();
                        } else
                            Snackbar.make(Objects.requireNonNull(getView()), "Please select RC number", Snackbar.LENGTH_LONG).show();
                    } else {
                        if (!base64string.equals("")) {
                            object.put("ExpiryDate", "");
                            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.DOCUMENT_IMG_UPLOAD, this, DOCUMENT_IMG_UPLOAD);
                            req.execute();
                        } else
                            Snackbar.make(Objects.requireNonNull(getView()), "Document Image is mandatory", Snackbar.LENGTH_LONG).show();
                    }
                } else
                    Snackbar.make(Objects.requireNonNull(getView()), "Please select document type", Snackbar.LENGTH_LONG).show();
            }

            if (url_id == GET_DOC_CATEGORY) {
                object.put(USER_ID, MySharedPreference.getInstance(getActivity()).getUID());
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_DOC_CATEGORY, this, GET_DOC_CATEGORY);
                req.execute();
            }

            if (url_id == RequestConstants.GET_REG_NO_LIST_DOCUMENT) {
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
                object.put("DocId", selectedDocTypeId);
                object.put("VehicleType",veh_type);
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_REG_NO_LIST_DOCUMENT, this, RequestConstants.GET_REG_NO_LIST_DOCUMENT);
                req.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == GET_DOC_CATEGORY) {
            new AppDataPushApi().callApi(getActivity(),"KYC Docs","Upload page","User came on KYC document to upload");
            if (!docTypeList.isEmpty())
                docTypeList.clear();
            if (!modelArrayList.isEmpty())
                modelArrayList.clear();
            docTypeList.add("- Select Document Type -");
            try {
                if (object.optString("Status").equalsIgnoreCase("true")) {
                    JSONArray jsonArray = object.getJSONArray("DocCategory");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        DocumentModel documentModel = new DocumentModel(jsonObject.getString("docId"), jsonObject.getString("docCategory"));
                        modelArrayList.add(documentModel);
                        docTypeList.add(jsonObject.getString("docCategory"));
                    }
                    doc_autotxt.setAdapter(new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, docTypeList));
                } else {
                    showAllAttchedDialog();
                }
            } catch (Exception npe) {
                npe.printStackTrace();
            }
        }

        if (Tag == GET_REG_NO_LIST_DOCUMENT) {
            if (!arrayListModel.isEmpty())
                arrayListModel.clear();
            if (!reg_no_list.isEmpty())
                reg_no_list.clear();
            reg_no_list.add("- Select Registration No -");
            if (object.optString("Status").equalsIgnoreCase("true")) {
                try {

                    JSONArray jsonArray = object.getJSONArray("RegistrationNoDetails");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject json = jsonArray.getJSONObject(i);
                        TrackingStatusModel statusModel = new TrackingStatusModel(json.optString("PolicyId"), json.optString("RegNo"), "0", json.optString("VehicleType"));
                        arrayListModel.add(statusModel);
                        reg_no_list.add(json.optString("RegNo"));
                    }
                    ArrayAdapter<String> carsArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, reg_no_list);

                    if (strSelectedDocType.equalsIgnoreCase("Pollution Doc")) {
                        poll_doc_spn_veh_reg.setVisibility(View.VISIBLE);
                        poll_doc_spn_veh_reg.setAdapter(carsArrayAdapter);
                    } else {
                        spn_veh_reg.setAdapter(carsArrayAdapter);
                        spn_veh_reg.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        if (Tag == DOCUMENT_IMG_UPLOAD) {
            new AppDataPushApi().callApi(getActivity(),"KYC Docs","Upload page","User uploaded a KYC document");
            try {
                String msg = object.optString("Message");
                Snackbar.make(Objects.requireNonNull(getView()), msg, Snackbar.LENGTH_LONG).show();
                if (spn_veh_reg.isShown())
                    spn_veh_reg.setVisibility(View.GONE);
                if (docTypeList.size() == 2) {
                    if (reg_no_list.size() == 2)
                        showAllAttchedDialog();
                    else {
                        uploadMoreDocDialog();
                    }
                } else {
                    uploadMoreDocDialog();
                    callApi(RequestConstants.DOCUMENT_TYPE_FOR_UPLOAD);
                }
            } catch (Exception npe) {
                npe.printStackTrace();
            }
            selectedDocTypeId = null;
            base64string = "";
            selectedRegId = "";
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof AuthFailureError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof ServerError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof NetworkError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof ParseError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        }
    }

    @SuppressLint("SetTextI18n")
    private void showAllAttchedDialog() {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert);
        TextView ok_txt;
        TextView alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        TextView alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_heading.setText("All document uploaded");
        alert_msg.setVisibility(View.GONE);
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> {
            documentCallback.fragemntTransfer(new FragmentDocuments(), FragmentsTags.DOCUMENTS_FRAGMENT, null);
            alert_dialog.dismiss();
        });
    }

    private void uploadMoreDocDialog() {
        saveDialog = new Dialog(Objects.requireNonNull(getActivity()));
        saveDialog.setCanceledOnTouchOutside(false);
        saveDialog.setCancelable(false);
        saveDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(saveDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        saveDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        saveDialog.setContentView(R.layout.savedoc_custom_dialog);
        TextView uploadoc_yes, uploadoc_no;
        uploadoc_yes = saveDialog.findViewById(R.id.save_yes);
        uploadoc_no = saveDialog.findViewById(R.id.save_no);
        saveDialog.show();
        uploadoc_yes.setOnClickListener(v -> {
            img_preview.setImageBitmap(null);
            img_preview.setImageResource(R.drawable.image_preview);
            rc_relative_layout.setVisibility(View.GONE);
            saveDialog.dismiss();
            callApi(GET_DOC_CATEGORY);
        });

        uploadoc_no.setOnClickListener(v -> {
            documentCallback.fragemntTransfer(new FragmentDocuments(), FragmentsTags.DOCUMENTS_FRAGMENT, null);
            saveDialog.dismiss();
        });
    }

    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()),R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            expir_date_txt.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.poll_doc_spn_veh_reg:

            case R.id.spn_veh_reg:
                if (position > 0) {
                    selectedRegId = arrayListModel.get(position - 1).getPolicy_no();
                    veh_type= arrayListModel.get(position-1).getVehicleType();
                }
                break;

            case R.id.doc_autotxt:
                if (position > 0) {
                    selectedDocTypeId = modelArrayList.get(position - 1).getDoc_category_id();
                    strSelectedDocType = modelArrayList.get(position - 1).getDoc_category();
                    if (strSelectedDocType.equalsIgnoreCase("Vehicle Reg")) {
                        rc_relative_layout.setVisibility(View.VISIBLE);
                        if (poll_doc_rc_llayout.isShown()) {
                            poll_doc_rc_llayout.setVisibility(View.GONE);
                            expir_date_txt.setText("POC Exp Date");
                        }
                        spn_veh_reg.setVisibility(View.VISIBLE);
                        callApi(GET_REG_NO_LIST_DOCUMENT);
                    } else if (strSelectedDocType.equalsIgnoreCase("Pollution Doc")) {
                        rc_relative_layout.setVisibility(View.VISIBLE);
                        if (spn_veh_reg.isShown())
                            spn_veh_reg.setVisibility(View.GONE);
                        poll_doc_rc_llayout.setVisibility(View.VISIBLE);
                        callApi(GET_REG_NO_LIST_DOCUMENT);
                    } else {
                        if (spn_veh_reg.isShown())
                            spn_veh_reg.setVisibility(View.GONE);
                        if (poll_doc_rc_llayout.isShown())
                            poll_doc_rc_llayout.setVisibility(View.GONE);
                        if (rc_relative_layout.isShown())
                            rc_relative_layout.setVisibility(View.GONE);
                        expir_date_txt.setText("POC Exp Date");
                    }
                } else {
                    if (spn_veh_reg.isShown())
                        spn_veh_reg.setVisibility(View.GONE);
                    if (poll_doc_rc_llayout.isShown())
                        poll_doc_rc_llayout.setVisibility(View.GONE);
                    if (rc_relative_layout.isShown())
                        rc_relative_layout.setVisibility(View.GONE);
                    expir_date_txt.setText("POC Exp Date");
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}






//package com.universalsompo.meta.metaapp.motor.fragments;
//
//import android.Manifest;
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.app.DatePickerDialog;
//import android.app.Dialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Environment;
//import android.os.Handler;
//import android.os.StrictMode;
//import android.provider.MediaStore;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import com.google.android.material.snackbar.Snackbar;
//
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//import androidx.core.content.FileProvider;
//import androidx.fragment.app.Fragment;
//import android.util.Base64;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.theartofdev.edmodo.cropper.CropImage;
//import com.universalsompo.meta.R;
//import com.universalsompo.meta.metaapp.motor.activities.AppExecutor;
//import com.universalsompo.meta.metaapp.motor.activities.BitmapUtils;
//import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
//import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
//import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
//import com.universalsompo.meta.metaapp.intefaces.DocumentCallback;
//import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
//import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
//import com.universalsompo.meta.metaapp.motor.models.DocumentModel;
//import com.universalsompo.meta.metaapp.motor.models.TrackingStatusModel;
//import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
//import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
//import com.universalsompo.meta.metaapp.utilities.FileUtils;
//import com.android.volley.AuthFailureError;
//import com.android.volley.NetworkError;
//import com.android.volley.NoConnectionError;
//import com.android.volley.ParseError;
//import com.android.volley.ServerError;
//import com.android.volley.TimeoutError;
//import com.android.volley.VolleyError;
//import com.universalsompo.meta.metaapp.utilities.LogUtils;
//import com.universalsompo.meta.metaapp.utilities.MyCheckPermission;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Locale;
//import java.util.Objects;
//
//import id.zelory.compressor.Compressor;
//
//import static android.app.Activity.RESULT_OK;
//import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.BASE_64_STRING;
//import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.DOCUMENT_IMG_UPLOAD;
//import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.DOC_ID;
//import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.FILE_EXTENSION;
//import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.GET_DOC_CATEGORY;
//import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.TOKEN_NO;
//import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.USER_ID;
//import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.GET_REG_NO_LIST_DOCUMENT;
//
//public class FragmentDocumentUpload extends Fragment implements View.OnClickListener, ResponseListener, AdapterView.OnItemSelectedListener {
//    private View v;
//    private LinearLayout poll_doc_rc_llayout;
//    private RelativeLayout rc_relative_layout;
//    private ImageView img_preview;
//    private Spinner doc_autotxt;
//    private Spinner spn_veh_reg;
//    private Spinner poll_doc_spn_veh_reg;
//    private TextView expir_date_txt;
//    private ArrayList<DocumentModel> modelArrayList;
//    private List<String> docTypeList;
//    private ArrayList<TrackingStatusModel> arrayListModel;
//    private List<String> reg_no_list;
//    private Dialog saveDialog, alert_dialog;
//    private DocumentCallback documentCallback;
//    private String base64imageextension;
//    private String base64string = "";
//    private String selectedDocTypeId = "";
//    private String strSelectedDocType = "";
//    private String selectedRegId = "";
//    private DatePickerDialog datePickerDialog;
//    private SimpleDateFormat dateFormatter;
//    private String veh_type="";
//    private static final int MY_CAMERA_PERMISSION_CODE = 100;
//    private String File_Name = null;
//    private File mImageFile;
//    private Bitmap myBitmap;
//    private String mTempPhotoPath;
//    private static final int REQUEST_STORAGE_PERMISSION = 1;
//    private static final String FILE_PROVIDER_AUTHORITY = "com.universalsompo.meta.fileprovider";
//    private static final int REQUEST_IMAGE_CAPTURE = 1;
//    private AppExecutor mAppExcutor;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        v = inflater.inflate(R.layout.fragment_document_upload, container, false);
//         init();
////         checkAppPermission();
//         callApi(GET_DOC_CATEGORY);
//         return v;
//    }
//
//
//    void checkAppPermission() {
//        if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
//            if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.CAMERA)) {
//                    if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)) {
//                        if (MyCheckPermission.checkAppPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)) {
//                            ActivityCompat.requestPermissions(getActivity(),
//                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//                        } else {
//                            MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
//                            }, RequestConstants.INITIAL_PERMISSION);
//                        }
//                    } else {
//                        MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
//                        }, RequestConstants.INITIAL_PERMISSION);
//                    }
//                } else {
//                    MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
//                    }, RequestConstants.INITIAL_PERMISSION);
//                }
//            } else {
//                MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
//                }, RequestConstants.INITIAL_PERMISSION);
//            }
//        } else {
//            MyCheckPermission.requestPermissionNow(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
//            }, RequestConstants.INITIAL_PERMISSION);
//        }
//    }
//
////    @Override
////    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
////        if (requestCode == RequestConstants.INITIAL_PERMISSION) {
////            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////                if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
////                    if (grantResults[2] == PackageManager.PERMISSION_GRANTED) {
////                        if (grantResults[3] == PackageManager.PERMISSION_GRANTED) {
////                            if (grantResults[4] == PackageManager.PERMISSION_GRANTED) {
////                            } else {
////                                Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
////                            }
////                        } else {
////                            Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
////                        }
////                    } else {
////                        Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
////                    }
////                } else {
////                    Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
////                }
////            } else {
////                Toast.makeText(getContext(), "You have to accept these permission ", Toast.LENGTH_SHORT).show();
////            }
////        } else {
////            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
////        }
////    }
//
//
//    private void init() {
//        LinearLayout gallery_layout = v.findViewById(R.id.gallery_llayout);
//        LinearLayout camera_llayout = v.findViewById(R.id.camera_llayout);
//        poll_doc_rc_llayout = v.findViewById(R.id.poll_doc_rc_llayout);
//        LinearLayout expiry_date_llayout = v.findViewById(R.id.expiry_date_llayout);
//        rc_relative_layout = v.findViewById(R.id.rc_relative_layout);
//        img_preview = v.findViewById(R.id.img_uploaded_preview);
//        Button btn_save = v.findViewById(R.id.btn_save);
//        doc_autotxt = v.findViewById(R.id.doc_autotxt);
//        spn_veh_reg = v.findViewById(R.id.spn_veh_reg);
//        poll_doc_spn_veh_reg = v.findViewById(R.id.poll_doc_spn_veh_reg);
//        expir_date_txt = v.findViewById(R.id.expir_date_txt);
//        LinearLayout image_click = v.findViewById(R.id.image_click);
//        LinearLayout image_click1 = v.findViewById(R.id.image_click1);
//        LinearLayout image_click2 = v.findViewById(R.id.image_click2);
//        spn_veh_reg.setVisibility(View.GONE);
//        poll_doc_rc_llayout.setVisibility(View.GONE);
//        rc_relative_layout.setVisibility(View.GONE);
//        docTypeList = new ArrayList<>();
//        modelArrayList = new ArrayList<>();
//        arrayListModel = new ArrayList<>();
//        reg_no_list = new ArrayList<>();
//        gallery_layout.setOnClickListener(this);
//        camera_llayout.setOnClickListener(this);
//        btn_save.setOnClickListener(this);
//        expiry_date_llayout.setOnClickListener(this);
//        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
//        image_click.setOnClickListener(v -> doc_autotxt.performClick());
//        image_click1.setOnClickListener(v -> spn_veh_reg.performClick());
//        image_click2.setOnClickListener(v -> poll_doc_spn_veh_reg.performClick());
//        doc_autotxt.setOnItemSelectedListener(this);
//        spn_veh_reg.setOnItemSelectedListener(this);
//        poll_doc_spn_veh_reg.setOnItemSelectedListener(this);
//    }
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof Activity) {
//            documentCallback = (DocumentCallback) context;
//        }
//    }
//
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            // Process the image and set it to the TextView
//            processAndSetImage();
//        } else {
//
//            // Otherwise, delete the temporary image file
//            BitmapUtils.deleteImageFile(getActivity(), mTempPhotoPath);
//        }
//
//
////        if (resultCode == Activity.RESULT_OK) {
////            int GALLERY_REQUEST = 302;
////            int CAMERA_REQUEST = 200;
////            if (requestCode == GALLERY_REQUEST) {
////                try {
////                    handleGalaryImage(img_preview, FileUtils.getPathFromURI(Objects.requireNonNull(getActivity()).getApplicationContext(), data.getData()));
////                } catch (Exception e) {
////                    Toast.makeText(getActivity(), "Please select another image or use camera", Toast.LENGTH_SHORT).show();
////                }
////            } else if (requestCode == CAMERA_REQUEST) {
////                    File_Name = mImageFile.getAbsolutePath();
////                    Uri tempURI = Uri.fromFile(mImageFile);
////                    CropImage.activity(tempURI).start(getContext(), this);
////                    base64imageextension = File_Name.substring(File_Name.lastIndexOf("."));
////
////                }
////                //**************************** Crop REQUEST ****************************************************
////                if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
////                    CropImage.ActivityResult result = CropImage.getActivityResult(data);
////                    Uri resultUri = result.getUri();
////                    try {
////                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), resultUri);
////                        String imagePath = resultUri.toString();
////                        handleCroppedImage(getFil_eName("help_image.png", bitmap), img_preview, "helpimage.png");
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                    }
////                }
////
//////            } else if (requestCode == CAMERA_REQUEST) {
//////                handleCameraImages(getFileName(), img_preview);
//////            }
////        }
//    }
//
//    void handleCroppedImage(final String Path, final ImageView img, String image) {
//        String f = null;
//        f = compress_Now(Path);
//        LogUtils.showLog("@@@@@@@@@@@@@", f);
//        myBitmap = BitmapFactory.decodeFile(f);
//        img.setImageBitmap(myBitmap);
//        start_SaveImage(image, myBitmap);
//    }
//
//    void start_SaveImage(String image, Bitmap myBitmap) {
//        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), image);
//        if (!file.exists()) {
//            try {
//                new File(file.getParent()).mkdirs();
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        saveImage_ToFile(myBitmap, file.getAbsolutePath());
//    }
//
//    private void convert_BitmaptoBase64(Bitmap bitmap) {
//        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bao);
//        byte[] ba = bao.toByteArray();
//        try {
//            base64string = Base64.encodeToString(ba, Base64.DEFAULT);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    String compress_Now(final String file) {
//        FileUtils.deleteCache(getActivity());
//        File compressedImage = new Compressor.Builder(getActivity())
//                .setMaxWidth(350)
//                .setMaxHeight(350)
//                .setCompressFormat(Bitmap.CompressFormat.PNG)
//                .build()
//                .compressToFile(new File(file));
//        return compressedImage.getAbsolutePath();
//    }
//
//    void saveImage_ToFile(Bitmap bmp, String filename) {
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(filename);
//            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
//            convert_BitmaptoBase64(bmp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    String getFil_eName(String filename, Bitmap bmp) {
//        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), filename);
//        FileOutputStream out = null;
//        if (!file.exists()) {
//            try {
//                new File(file.getParent()).mkdirs();
//                file.createNewFile();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//        try {
//            out = new FileOutputStream(file);
//            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
//            if (out != null) {
//                out.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return file.getAbsolutePath();
//    }
//
//
//    private void handleGalaryImage(final ImageView img, final String File) {
//        String f;
//        f = compressNow(File);
//         LogUtils.showLog("@@@@@@@@@@@@@", f);
//        Bitmap myBitmap = BitmapFactory.decodeFile(f);
//        if (img != null) {
//            img.setBackgroundColor(Color.WHITE);
//        }
//        assert img != null;
//        img.setImageBitmap(myBitmap);
//        startSaveImage("DocGallery.png", myBitmap);
//    }
//
//    private void handleCameraImages(final String Path, final ImageView img) {
//        String f;
//        f = compressNow(Path);
//        LogUtils.showLog("@@@@@@@@@@@@@", f);
//        Bitmap myBitmap = BitmapFactory.decodeFile(Path);
//        if (img != null) {
//            img.setBackgroundColor(Color.WHITE);
//        }
//        assert img != null;
//        img.setImageBitmap(myBitmap);
//        startSaveImage("doccamera.png", myBitmap);
//    }
//
//    private String compressNow(final String file) {
//        FileUtils.deleteCache(getActivity());
//        File compressedImage = new Compressor.Builder(Objects.requireNonNull(getActivity()))
//                .setMaxWidth(1000)
//                .setMaxHeight(1000)
//                .setCompressFormat(Bitmap.CompressFormat.PNG)
//                .build()
//                .compressToFile(new File(file));
//        return compressedImage.getAbsolutePath();
//    }
//
//    private String getFileName() {
//        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "doccamera.png");
//        if (!file.exists()) {
//            try {
//                new File(file.getParent()).mkdirs();
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return file.getAbsolutePath();
//    }
//
//    private void startSaveImage(String image, Bitmap myBitmap) {
//        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), image);
//        if (!file.exists()) {
//            try {
//                new File(file.getParent()).mkdirs();
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        saveImageToFile(myBitmap, file.getAbsolutePath());
//    }
//
//    private void saveImageToFile(Bitmap bmp, String filename) {
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(filename);
//            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
//            convertBitmaptoBase64(bmp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void convertBitmaptoBase64(Bitmap bitmap) {
//        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 70, bao);
//        byte[] ba = bao.toByteArray();
//        try {
//            base64string = Base64.encodeToString(ba, Base64.DEFAULT);
//            base64imageextension = ".png";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.gallery_llayout:
//                viewFromGallery();
//                break;
//
//            case R.id.camera_llayout:
//
//                if (ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
//
//                    // If you do not have permission, request it
//                    ActivityCompat.requestPermissions(getActivity(),
//                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                            REQUEST_STORAGE_PERMISSION);
//                } else {
//                    if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//                        requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
//                    }else{
//                        if ((!selectedDocTypeId.equals("")) && !(doc_autotxt.getSelectedItem().toString().equals("- Select Document Type -"))) {
////                        captureImage(getFileName());
////                            captureImage();
//                            launchCamera();
//                        }else {
//                            Snackbar.make(Objects.requireNonNull(getView()), "Document Type is mandatory", Snackbar.LENGTH_LONG).show();
//                        }
//
//                    // Launch the camera if the permission exists
//
//                }
//
//
//
//                }
//                break;
//
//            case R.id.btn_save:
//                callApi(DOCUMENT_IMG_UPLOAD);
//                break;
//
//            case R.id.expiry_date_llayout:
//                showCalender();
//                datePickerDialog.show();
//                break;
//
//        }
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        // Called when you request permission to read and write to external storage
//        switch (requestCode) {
//            case REQUEST_STORAGE_PERMISSION: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // If you get permission, launch the camera
//                    launchCamera();
//                } else {
//                    // If you do not get permission, show a Toast
//                    Toast.makeText(getActivity(), "permission_denied", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            }
//        }
//    }
//
//    private void launchCamera() {
//
//        // Create the capture image intent
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//
//        // Ensure that there's a camera activity to handle the intent
//        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//            // Create the temporary File where the photo should go
//            File photoFile = null;
//            try {
//                photoFile = BitmapUtils.createTempImageFile(getActivity());
//            } catch (IOException ex) {
//                // Error occurred while creating the File
//                ex.printStackTrace();
//            }
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//
//                // Get the path of the temporary file
//                mTempPhotoPath = photoFile.getAbsolutePath();
//
//                // Get the content URI for the image file
//                Uri photoURI = FileProvider.getUriForFile(getActivity(),
//                        FILE_PROVIDER_AUTHORITY,
//                        photoFile);
//
//                // Add the URI so the camera can store the image
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//
//                // Launch the camera activity
//                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//            }
//        }
//    }
//
//
//
//    private void viewFromGallery() {
//        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/*");
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 302);
//    }
//    private void captureImage(){
//
//        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
//        StrictMode.setVmPolicy(builder.build());
//        mImageFile = new File(Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "temp.png");
//        Uri tempURI = Uri.fromFile(mImageFile);
//        Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
//        startActivityForResult(photoCaptureIntent, 200);
//
//       /*  StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
//        StrictMode.setVmPolicy(builder.build());
//        File mImageFile = new File(name);
//        Uri tempURI = Uri.fromFile(mImageFile);
//        Log.e("tempURI", String.valueOf(tempURI));
//        Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
//        startActivityForResult(photoCaptureIntent, 301);*/
//    }
//    private void callApi(Integer url_id) {
//        try {
//            JSONObject object = new JSONObject();
//            object.put(TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
//            if (url_id == DOCUMENT_IMG_UPLOAD) {
//                object.put(TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
//                object.put(USER_ID, MySharedPreference.getInstance(getActivity()).getUID());
//                object.put("PolicyId", selectedRegId);
//                if(veh_type!=null)
//                object.put("VehicleType",veh_type);
//                object.put(DOC_ID, selectedDocTypeId);
//                if (base64imageextension == null)
//                    base64imageextension = ".jpg";
//                object.put(FILE_EXTENSION, base64imageextension);
//                object.put(BASE_64_STRING, base64string);
//                if ((!selectedDocTypeId.equals("")) && !(doc_autotxt.getSelectedItem().toString().equals("- Select Document Type -"))) {
//                    if (strSelectedDocType.equalsIgnoreCase("Vehicle Reg")) {
//                        if (!selectedRegId.equals("") && !(spn_veh_reg.getSelectedItem().toString().equals("- Select Registration No -"))) {
//                            if (!base64string.equals("")) {
//                                object.put("ExpiryDate", "");
//                                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.DOCUMENT_IMG_UPLOAD, this, DOCUMENT_IMG_UPLOAD);
//                                req.execute();
//                            } else
//                                Snackbar.make(Objects.requireNonNull(getView()), "Document Image is mandatory", Snackbar.LENGTH_LONG).show();
//                        } else
//                            Snackbar.make(Objects.requireNonNull(getView()), "Please select RC number", Snackbar.LENGTH_LONG).show();
//                    } else if (strSelectedDocType.equalsIgnoreCase("Pollution Doc")) {
//                        if (!selectedRegId.equals("") && !(poll_doc_spn_veh_reg.getSelectedItem().toString().equals("- Select Registration No -"))) {
//                            if (expir_date_txt.getText().toString().contains("-")) {
//                                object.put("ExpiryDate", expir_date_txt.getText().toString());
//                                if (!base64string.equals("")) {
//                                    ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.DOCUMENT_IMG_UPLOAD, this, DOCUMENT_IMG_UPLOAD);
//                                    req.execute();
//                                } else
//                                    Snackbar.make(Objects.requireNonNull(getView()), "Document Image is mandatory", Snackbar.LENGTH_LONG).show();
//                            } else
//                                Snackbar.make(Objects.requireNonNull(getView()), "Please select POC expiry date", Snackbar.LENGTH_LONG).show();
//                        } else
//                            Snackbar.make(Objects.requireNonNull(getView()), "Please select RC number", Snackbar.LENGTH_LONG).show();
//                    } else {
//                        if (!base64string.equals("")) {
//                            object.put("ExpiryDate", "");
//                            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.DOCUMENT_IMG_UPLOAD, this, DOCUMENT_IMG_UPLOAD);
//                            req.execute();
//                        } else
//                            Snackbar.make(Objects.requireNonNull(getView()), "Document Image is mandatory", Snackbar.LENGTH_LONG).show();
//                    }
//                } else
//                    Snackbar.make(Objects.requireNonNull(getView()), "Please select document type", Snackbar.LENGTH_LONG).show();
//            }
//
//            if (url_id == GET_DOC_CATEGORY) {
//                object.put(USER_ID, MySharedPreference.getInstance(getActivity()).getUID());
//                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_DOC_CATEGORY, this, GET_DOC_CATEGORY);
//                req.execute();
//            }
//
//            if (url_id == RequestConstants.GET_REG_NO_LIST_DOCUMENT) {
//                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
//                object.put("DocId", selectedDocTypeId);
//                object.put("VehicleType",veh_type);
//                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_REG_NO_LIST_DOCUMENT, this, RequestConstants.GET_REG_NO_LIST_DOCUMENT);
//                req.execute();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onSuccess(JSONObject object, int Tag) {
//        if (Tag == GET_DOC_CATEGORY) {
//            new AppDataPushApi().callApi(getActivity(),"KYC Docs","Upload page","User came on KYC document to upload");
//            if (!docTypeList.isEmpty())
//                docTypeList.clear();
//            if (!modelArrayList.isEmpty())
//                modelArrayList.clear();
//            docTypeList.add("- Select Document Type -");
//            try {
//                if (object.optString("Status").equalsIgnoreCase("true")) {
//                    JSONArray jsonArray = object.getJSONArray("DocCategory");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        DocumentModel documentModel = new DocumentModel(jsonObject.getString("docId"), jsonObject.getString("docCategory"));
//                        modelArrayList.add(documentModel);
//                        docTypeList.add(jsonObject.getString("docCategory"));
//                    }
//                    doc_autotxt.setAdapter(new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, docTypeList));
//                } else {
//                    showAllAttchedDialog();
//                }
//            } catch (Exception npe) {
//                npe.printStackTrace();
//            }
//        }
//
//        if (Tag == GET_REG_NO_LIST_DOCUMENT) {
//            if (!arrayListModel.isEmpty())
//                arrayListModel.clear();
//            if (!reg_no_list.isEmpty())
//                reg_no_list.clear();
//            reg_no_list.add("- Select Registration No -");
//            if (object.optString("Status").equalsIgnoreCase("true")) {
//                try {
//
//                    JSONArray jsonArray = object.getJSONArray("RegistrationNoDetails");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject json = jsonArray.getJSONObject(i);
//                        TrackingStatusModel statusModel = new TrackingStatusModel(json.optString("PolicyId"), json.optString("RegNo"), "0", json.optString("VehicleType"));
//                        arrayListModel.add(statusModel);
//                        reg_no_list.add(json.optString("RegNo"));
//                    }
//                    ArrayAdapter<String> carsArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, reg_no_list);
//
//                    if (strSelectedDocType.equalsIgnoreCase("Pollution Doc")) {
//                        poll_doc_spn_veh_reg.setVisibility(View.VISIBLE);
//                        poll_doc_spn_veh_reg.setAdapter(carsArrayAdapter);
//                    } else {
//                        spn_veh_reg.setAdapter(carsArrayAdapter);
//                        spn_veh_reg.setVisibility(View.VISIBLE);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//
//        if (Tag == DOCUMENT_IMG_UPLOAD) {
//            new AppDataPushApi().callApi(getActivity(),"KYC Docs","Upload page","User uploaded a KYC document");
//            try {
//                String msg = object.optString("Message");
//                Snackbar.make(Objects.requireNonNull(getView()), msg, Snackbar.LENGTH_LONG).show();
//                if (spn_veh_reg.isShown())
//                    spn_veh_reg.setVisibility(View.GONE);
//                if (docTypeList.size() == 2) {
//                        if (reg_no_list.size() == 2)
//                            showAllAttchedDialog();
//                        else {
//                            uploadMoreDocDialog();
//                        }
//                } else {
//                    uploadMoreDocDialog();
//                    callApi(RequestConstants.DOCUMENT_TYPE_FOR_UPLOAD);
//                }
//            } catch (Exception npe) {
//                npe.printStackTrace();
//            }
//            selectedDocTypeId = null;
//            base64string = "";
//            selectedRegId = "";
//        }
//    }
//
//    @Override
//    public void onError(VolleyError error, int Tag) {
//        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
//            Log.d("check1", "Error: " + error.getMessage());
//        } else if (error instanceof AuthFailureError) {
//            //TODO
//            Log.d("check1", "Error: " + error.getMessage());
//        } else if (error instanceof ServerError) {
//            //TODO
//            Log.d("check1", "Error: " + error.getMessage());
//        } else if (error instanceof NetworkError) {
//            //TODO
//            Log.d("check1", "Error: " + error.getMessage());
//        } else if (error instanceof ParseError) {
//            //TODO
//            Log.d("check1", "Error: " + error.getMessage());
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private void showAllAttchedDialog() {
//        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
//        alert_dialog.setCanceledOnTouchOutside(false);
//        alert_dialog.setCancelable(false);
//        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        alert_dialog.setContentView(R.layout.custom_alert);
//        TextView ok_txt;
//        TextView alert_heading = alert_dialog.findViewById(R.id.alert_heading);
//        TextView alert_msg = alert_dialog.findViewById(R.id.alert_msg);
//        alert_heading.setText("All document uploaded");
//        alert_msg.setVisibility(View.GONE);
//        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
//        alert_dialog.show();
//        ok_txt.setOnClickListener(v -> {
//            documentCallback.fragemntTransfer(new FragmentDocuments(), FragmentsTags.DOCUMENTS_FRAGMENT, null);
//            alert_dialog.dismiss();
//        });
//    }
//
//    private void uploadMoreDocDialog() {
//        saveDialog = new Dialog(Objects.requireNonNull(getActivity()));
//        saveDialog.setCanceledOnTouchOutside(false);
//        saveDialog.setCancelable(false);
//        saveDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        Objects.requireNonNull(saveDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        saveDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        saveDialog.setContentView(R.layout.savedoc_custom_dialog);
//        TextView uploadoc_yes, uploadoc_no;
//        uploadoc_yes = saveDialog.findViewById(R.id.save_yes);
//        uploadoc_no = saveDialog.findViewById(R.id.save_no);
//        saveDialog.show();
//        uploadoc_yes.setOnClickListener(v -> {
//            img_preview.setImageBitmap(null);
//            img_preview.setImageResource(R.drawable.image_preview);
//            rc_relative_layout.setVisibility(View.GONE);
//            saveDialog.dismiss();
//            callApi(GET_DOC_CATEGORY);
//        });
//
//        uploadoc_no.setOnClickListener(v -> {
//            documentCallback.fragemntTransfer(new FragmentDocuments(), FragmentsTags.DOCUMENTS_FRAGMENT, null);
//            saveDialog.dismiss();
//        });
//    }
//
//    private void showCalender() {
//        Calendar newCalendar = Calendar.getInstance();
//        datePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()),R.style.DialogTheme, (view, year, monthOfYear, dayOfMonth) -> {
//            Calendar newDate = Calendar.getInstance();
//            newDate.set(year, monthOfYear, dayOfMonth);
//            expir_date_txt.setText(dateFormatter.format(newDate.getTime()));
//        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//    }
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        switch (parent.getId()) {
//            case R.id.poll_doc_spn_veh_reg:
//
//            case R.id.spn_veh_reg:
//                if (position > 0) {
//                    selectedRegId = arrayListModel.get(position - 1).getPolicy_no();
//                    veh_type= arrayListModel.get(position-1).getVehicleType();
//                }
//                break;
//
//            case R.id.doc_autotxt:
//                if (position > 0) {
//                    selectedDocTypeId = modelArrayList.get(position - 1).getDoc_category_id();
//                    strSelectedDocType = modelArrayList.get(position - 1).getDoc_category();
//                    if (strSelectedDocType.equalsIgnoreCase("Vehicle Reg")) {
//                        rc_relative_layout.setVisibility(View.VISIBLE);
//                        if (poll_doc_rc_llayout.isShown()) {
//                            poll_doc_rc_llayout.setVisibility(View.GONE);
//                            expir_date_txt.setText("POC Exp Date");
//                        }
//                        spn_veh_reg.setVisibility(View.VISIBLE);
//                        callApi(GET_REG_NO_LIST_DOCUMENT);
//                    } else if (strSelectedDocType.equalsIgnoreCase("Pollution Doc")) {
//                        rc_relative_layout.setVisibility(View.VISIBLE);
//                        if (spn_veh_reg.isShown())
//                            spn_veh_reg.setVisibility(View.GONE);
//                        poll_doc_rc_llayout.setVisibility(View.VISIBLE);
//                        callApi(GET_REG_NO_LIST_DOCUMENT);
//                    } else {
//                        if (spn_veh_reg.isShown())
//                            spn_veh_reg.setVisibility(View.GONE);
//                        if (poll_doc_rc_llayout.isShown())
//                            poll_doc_rc_llayout.setVisibility(View.GONE);
//                        if (rc_relative_layout.isShown())
//                            rc_relative_layout.setVisibility(View.GONE);
//                        expir_date_txt.setText("POC Exp Date");
//                    }
//                } else {
//                    if (spn_veh_reg.isShown())
//                        spn_veh_reg.setVisibility(View.GONE);
//                    if (poll_doc_rc_llayout.isShown())
//                        poll_doc_rc_llayout.setVisibility(View.GONE);
//                    if (rc_relative_layout.isShown())
//                        rc_relative_layout.setVisibility(View.GONE);
//                    expir_date_txt.setText("POC Exp Date");
//                }
//                break;
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//    private void processAndSetImage() {
//
//
//
//        // Resample the saved image to fit the ImageView
//        myBitmap = BitmapUtils.resamplePic(getActivity(), mTempPhotoPath);
//
//
//        // Set the new bitmap to the ImageView
//        img_preview.setImageBitmap(myBitmap);
//    }
//
//
//}
