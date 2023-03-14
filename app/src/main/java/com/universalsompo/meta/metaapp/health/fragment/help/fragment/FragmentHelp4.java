package com.universalsompo.meta.metaapp.health.fragment.help.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.theartofdev.edmodo.cropper.CropImage;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FileUtils;
import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import id.zelory.compressor.Compressor;

public class FragmentHelp4 extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private String name, id_help1, id_help2, id_help3, id_help4,str_message;
    private EditText message;
    private Dialog profilePicDialog;
    private final int CAMERA_REQUEST = 200;
    private final int GALLERY_REQUEST = 201;
    private File mImageFile;
    private String base64imageextension = "";
    private String base64string = "";
    private String Tag_Camera = "camera";
    private String Tag_Gallery = "galary";
    private String Tag = null;
    private MySharedPreference mySharedPreference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_help_4, container, false);
        mySharedPreference = MySharedPreference.getInstance(getActivity());

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        assert getArguments() != null;
        name = getArguments().getString("name");
        id_help1 = getArguments().getString("id_help1");
        id_help2 = getArguments().getString("id_help2");
        id_help3 = getArguments().getString("id_help3");
        id_help4 = getArguments().getString("id_help4");
        init();
        return v;
    }

    private void init() {
        TextView category_name = v.findViewById(R.id.category_name);
        message =  v.findViewById(R.id.message);
        LinearLayout attach_file = v.findViewById(R.id.attach_file);
        attach_file.setVisibility(View.GONE);
        Button submit = v.findViewById(R.id.submit);
        category_name.setText(name);
        attach_file.setOnClickListener(this);
        submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.attach_file:
                showDialog();
                break;

            case R.id.submit:
                str_message = message.getText().toString().trim();
                if (str_message.isEmpty()) {
                    message.setFocusableInTouchMode(true);
                    message.setCursorVisible(true);
                    message.requestFocus();
                    Snackbar.make(Objects.requireNonNull(getView()), "Enter your message", Snackbar.LENGTH_LONG).show();
                }else {
                    callApi();
                }
                break;
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH,mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
            object.put("CategoryID1", id_help1);
            object.put("CategoryID2", id_help2);
            object.put("CategoryID3", id_help3);
            object.put("CategoryID4", id_help4);
            object.put("Comment", str_message);
            if (base64string.equals("")) {
                object.put("FileInBase64", "");
            } else {
                object.put("FileInBase64", base64string);
            }

            if (base64imageextension.equals("")) {
                object.put("FileExt", "0");
            } else {
                object.put("FileExt", base64imageextension);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_USER_DETAILS, this, RequestHealthConstants.SAVE_USER_DETAILS);
        req.execute();
    }

    private void showDialog() {
        profilePicDialog = new Dialog(Objects.requireNonNull(getActivity()));
        profilePicDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(profilePicDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        profilePicDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        profilePicDialog.setContentView(R.layout.dialog_profile_img);
        TextView txt_gallery_opt, txt_camera_opt;
        txt_camera_opt =  profilePicDialog.findViewById(R.id.txt_camera_opt);
        txt_gallery_opt =  profilePicDialog.findViewById(R.id.txt_gallery_opt);
        profilePicDialog.show();
        txt_gallery_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tag = Tag_Gallery;
                processAhed();
                profilePicDialog.dismiss();
            }
        });

        txt_camera_opt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tag = Tag_Camera;
                processAhed();
                profilePicDialog.dismiss();
            }

        });
    }

    private void processAhed() {
        if (Tag.equals(Tag_Camera)) {
            captureImage();
        } else if (Tag.equals(Tag_Gallery)) {
            viewFromGallery();
        }
    }

    private void viewFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                GALLERY_REQUEST);
    }

    private void captureImage() {
        mImageFile = new File(Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "temp.png");
        Uri tempURI = Uri.fromFile(mImageFile);
        Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
        startActivityForResult(photoCaptureIntent, CAMERA_REQUEST);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            String file_Name;
            if (requestCode == GALLERY_REQUEST) {
                Uri selectedImageUri = data.getData();
                assert selectedImageUri != null;
                CropImage.activity(selectedImageUri)
                        .start(Objects.requireNonNull(getContext()), this);
                try {
                    file_Name = FileUtils.getPathFromURI(Objects.requireNonNull(getActivity()).getApplicationContext(), selectedImageUri);
                    base64imageextension = file_Name.substring(file_Name.lastIndexOf("."));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == CAMERA_REQUEST) {
                file_Name = mImageFile.getAbsolutePath();
                Uri tempURI = Uri.fromFile(mImageFile);
                CropImage.activity(tempURI).start(Objects.requireNonNull(getContext()), this);
                base64imageextension = file_Name.substring(file_Name.lastIndexOf("."));
            } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                Uri resultUri = result.getUri();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(Objects.requireNonNull(getActivity()).getContentResolver(), resultUri);
                    handleCroppedImage(getFileName(bitmap));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleCroppedImage(final String Path) {
        String f;
        f = compressNow(Path);
        Bitmap myBitmap = BitmapFactory.decodeFile(f);
        startSaveImage(myBitmap);
    }

    private void startSaveImage(Bitmap myBitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "helpimage.png");
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

    private void convertBitmaptoBase64(Bitmap bitmap) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bao);
        byte[] ba = bao.toByteArray();
        try {
            base64string = Base64.encodeToString(ba, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String compressNow(final String file) {
        FileUtils.deleteCache(getActivity());
        File compressedImage = new Compressor.Builder(Objects.requireNonNull(getActivity()))
                .setMaxWidth(350)
                .setMaxHeight(350)
                .setCompressFormat(Bitmap.CompressFormat.PNG)
                .build()
                .compressToFile(new File(file));
        return compressedImage.getAbsolutePath();
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

    private String getFileName(Bitmap bmp) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "help_image.png");
        FileOutputStream out;
        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_USER_DETAILS) {
            try {
                new AppDataPushApi().callApi(getActivity(),"Help","Help page","User facing problem in " + id_help1 + " -> " + id_help2 + " -> " + id_help3 + " -> " + id_help4 + " & submitted his issue");
                Snackbar.make(Objects.requireNonNull(getView()), "Your request sent successfully", Snackbar.LENGTH_LONG).show();
                ((MainActivityHealth) Objects.requireNonNull(getActivity())).changeFragmnet();
            } catch (Exception npe) {
                npe.printStackTrace();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
