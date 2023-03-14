package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model.CategoryModel;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model.SubCategoryModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FileUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import id.zelory.compressor.Compressor;

public class FragmentWYHUpload extends Fragment implements AdapterView.OnItemSelectedListener, ResponseListener, View.OnClickListener {
    private View v;
    private MySharedPreference pref;
    private Spinner spn_category_type, spn_sub_category_type;
    private List<CategoryModel> categorylist;
    private List<SubCategoryModel> subcategorylist;
    private List<String> listcategory;
    private List<String> listsubcategory;
    private String selectedCategoryId = "-1";
    private String selectedSubCategoryId = "-1";
    private EditText doc_name;
    private LinearLayout upload_sub_category;
    private ImageView img_preview;
    private String base64string;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_wyh_upload_doc, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = new MySharedPreference(getActivity());
        initView();
        return v;
    }

    private void initView() {
        spn_category_type = v.findViewById(R.id.spn_category_type);
        spn_sub_category_type = v.findViewById(R.id.spn_sub_category_type);
        upload_sub_category = v.findViewById(R.id.upload_sub_category);
        doc_name = v.findViewById(R.id.doc_name);
        doc_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                doc_name.post(new Runnable() {
                    @Override
                    public void run() {
                        Objects.requireNonNull(getActivity()).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                        doc_name.clearFocus();
                        doc_name.setCursorVisible(false);
                    }
                });
            }
        });
        LinearLayout gallery_layout = v.findViewById(R.id.gallery_llayout_policy);
        LinearLayout camera_llayout = v.findViewById(R.id.camera_llayout_policy);
        img_preview = v.findViewById(R.id.img_uploaded_preview_policy);
        LinearLayout btn_submit_document = v.findViewById(R.id.btn_submit_document);

        spn_category_type.setOnItemSelectedListener(this);
        spn_sub_category_type.setOnItemSelectedListener(this);
        categorylist = new ArrayList<>();
        subcategorylist = new ArrayList<>();
        listcategory = new ArrayList<>();
        listsubcategory = new ArrayList<>();
        categorylist.clear();
        subcategorylist.clear();

        gallery_layout.setOnClickListener(this);
        camera_llayout.setOnClickListener(this);
        btn_submit_document.setOnClickListener(this);

        hitApi(RequestHealthConstants.GET_WYH_CATEGORY_LIST);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spn_category_type:
                if (categorylist.size() > 0) {
                    selectedCategoryId = categorylist.get(position).getId();
                    if (!selectedCategoryId.equalsIgnoreCase("-1")){
                        hitApi(RequestHealthConstants.GET_WYH_SUB_CATEGORY_LIST);
                    } else {
                        upload_sub_category.setVisibility(View.GONE);
                    }
                }
                break;

            case R.id.spn_sub_category_type:
                if (subcategorylist.size()>0){
                    selectedSubCategoryId = subcategorylist.get(position).getId();
                    if (!selectedSubCategoryId.equalsIgnoreCase("-1")){
                    }
                }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void hitApi(Integer id) {
        if (id == RequestHealthConstants.GET_WYH_CATEGORY_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestConstants.TOKEN_NO,pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("MainCategoryId", "0");
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_WYH_CATEGORY_LIST, this, RequestHealthConstants.GET_WYH_CATEGORY_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_WYH_SUB_CATEGORY_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("MainCategoryId", selectedCategoryId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_WYH_SUB_CATEGORY_LIST, this, RequestHealthConstants.GET_WYH_SUB_CATEGORY_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.UPLOAD_WYH_DOCUMENT) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
                object.put("Uid",pref.getUID());
                object.put("PolicyNo", "2841/61176505/00/000");
                object.put("MemberId", "101234939211");
                object.put("RptSubCategoryID", selectedSubCategoryId);
                object.put("ReportDocName", doc_name.getText().toString());
                object.put("FileExt", ".png");
                object.put("AuthToken", pref.getWYHAuthToken());
                object.put("FileInBase64", base64string);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.UPLOAD_WYH_DOCUMENT, this, RequestHealthConstants.UPLOAD_WYH_DOCUMENT);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_WYH_CATEGORY_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                try {
                    listcategory.clear();
                    categorylist.add(new CategoryModel("-1", "-Select-"));
                    listcategory.add("-Select-");
                    JSONArray arr = object.getJSONArray("ReportCategory");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        categorylist.add(new CategoryModel(obj.getString("MainCategoryId"), obj.getString("CategoryName")));
                        listcategory.add(obj.optString("CategoryName"));
                    }
                    ArrayAdapter categoryArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, listcategory);
                    spn_category_type.setAdapter(categoryArrayAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (Tag == RequestHealthConstants.GET_WYH_SUB_CATEGORY_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                upload_sub_category.setVisibility(View.VISIBLE);
                try {
                    listsubcategory.clear();
                    subcategorylist.add(new SubCategoryModel("-1", "-Select-"));
                    listsubcategory.add("-Select-");
                    JSONArray arr = object.getJSONArray("ReportCategory");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        subcategorylist.add(new SubCategoryModel(obj.getString("SubCategoryId"), obj.getString("CategoryName")));
                        listsubcategory.add(obj.optString("CategoryName"));
                    }
                    ArrayAdapter subcategoryArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, listsubcategory);
                    spn_sub_category_type.setAdapter(subcategoryArrayAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (Tag == RequestHealthConstants.UPLOAD_WYH_DOCUMENT) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                try {
                    String ref_no = object.getString("ReferenceID");
                    showdialog(ref_no);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(getActivity(), "Unable to upload document", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            int CAMERA_REQUEST = 200;
            int GALLERY_REQUEST = 201;
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

    private void handleCameraImages(final String Path, final ImageView img) {
        String f;
        f = compressNow(Path);
        Bitmap myBitmap = BitmapFactory.decodeFile(f);
        if (img != null) {
            img.setBackgroundColor(Color.WHITE);
        }
        assert img != null;
        img.setImageBitmap(myBitmap);
        startSaveImage("doccamera.png", myBitmap);
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

    private void handleGalaryImage(final ImageView img, final String File) {
        String f;
        f = compressNow(File);
        Bitmap myBitmap = BitmapFactory.decodeFile(f);
        if (img != null) {
            img.setBackgroundColor(Color.WHITE);
        }
        assert img != null;
        img.setImageBitmap(myBitmap);
        startSaveImage("policyDoc.png", myBitmap);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void captureImage(String name) {
        File mImageFile = new File(name);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Uri tempURI = Uri.fromFile(mImageFile);
        Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
        startActivityForResult(photoCaptureIntent, 200);
    }

    @SuppressLint("IntentReset")
    private void viewFromGallery() {
        @SuppressLint("IntentReset") Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 201);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gallery_llayout_policy:
                viewFromGallery();
                break;
            case R.id.camera_llayout_policy:
                captureImage(getFileName());
                break;
            case R.id.btn_submit_document:
                checkvalidation();
                break;
        }
    }

    private void checkvalidation() {
        if (selectedCategoryId.equals("-1")) {
            Toast.makeText(getActivity(), "Please select category", Toast.LENGTH_SHORT).show();
        } else if (selectedSubCategoryId.equals("-1")) {
            Toast.makeText(getActivity(), "Please select sub category", Toast.LENGTH_SHORT).show();
        } else if (doc_name.getText().toString().length() == 0) {
            Toast.makeText(getActivity(), "Please enter document name", Toast.LENGTH_SHORT).show();
        } else if (base64string == null) {
            Toast.makeText(getActivity(), "Please select a document", Toast.LENGTH_SHORT).show();
        } else {
            hitApi(RequestHealthConstants.UPLOAD_WYH_DOCUMENT);
        }
    }

    private void showdialog(String ref_no) {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.dialog_ref_number);
        TextView des, tv_ref_submit;
        des = dialog.findViewById(R.id.des);
        tv_ref_submit = dialog.findViewById(R.id.tv_ref_submit);
        des.setText("You have successfully uploaded your document. Here is your reference number " + ref_no + " for further queries.");

        tv_ref_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Objects.requireNonNull(getActivity()).onBackPressed();
            }
        });
        dialog.show();
    }
}
