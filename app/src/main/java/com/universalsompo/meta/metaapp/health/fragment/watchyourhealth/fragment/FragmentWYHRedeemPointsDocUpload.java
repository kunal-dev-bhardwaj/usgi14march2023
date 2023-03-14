package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FileUtils;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import id.zelory.compressor.Compressor;

public class FragmentWYHRedeemPointsDocUpload extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private MySharedPreference pref;
    private EditText redeem_points;
    private ImageView img_preview;
    private String base64string;
    private String id, name;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_wyh_redeem_point_upload_doc, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = new MySharedPreference(getActivity());
        assert getArguments() != null;
        id = getArguments().getString("id");
        name = getArguments().getString("name");
        initView();
        return v;
    }

    private void initView() {
        TextView redeem_points_name = v.findViewById(R.id.redeem_points_name);
        redeem_points = v.findViewById(R.id.redeem_points);
        LinearLayout gallery_layout = v.findViewById(R.id.gallery_llayout_policy);
        LinearLayout camera_llayout = v.findViewById(R.id.camera_llayout_policy);
        img_preview = v.findViewById(R.id.img_uploaded_preview_policy);
        LinearLayout btn_submit_document = v.findViewById(R.id.btn_submit_document);

        redeem_points_name.setText(name);

        gallery_layout.setOnClickListener(this);
        camera_llayout.setOnClickListener(this);
        btn_submit_document.setOnClickListener(this);
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

    private void checkvalidation() {
        if (redeem_points.getText().toString().length() == 0) {
            Toast.makeText(getActivity(), "Please enter number of points you want to redeem", Toast.LENGTH_SHORT).show();
        } else if (base64string == null) {
            Toast.makeText(getActivity(), "Please select a document", Toast.LENGTH_SHORT).show();
        } else {
            hitApi();
        }
    }

    private void hitApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("PolicyNo", "2841/61176505/00/000");
            object.put("MemberId", "101234939211");
            object.put("RedeemSubcategoryId", id);
            object.put("RedeemSubcategoryName", name);
            object.put("RequestedPoints", redeem_points.getText().toString());
            object.put("FileExt", ".png");
            object.put("AuthToken", pref.getWYHAuthToken());
            object.put("FileInBase64", base64string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.UPLOAD_DOC_FOR_POINT_REDEMPTION, this, RequestHealthConstants.UPLOAD_DOC_FOR_POINT_REDEMPTION);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.UPLOAD_DOC_FOR_POINT_REDEMPTION) {
            if (object.optString("Status").equalsIgnoreCase("true")) {
                Toast.makeText(getActivity(), "Your request has been successfully sent", Toast.LENGTH_SHORT).show();
                (Objects.requireNonNull(getActivity())).onBackPressed();
            } else {
                try {
                    Toast.makeText(getActivity(), object.getString("Message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
