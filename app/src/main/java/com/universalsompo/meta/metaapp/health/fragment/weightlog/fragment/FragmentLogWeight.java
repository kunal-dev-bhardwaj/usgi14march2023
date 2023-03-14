package com.universalsompo.meta.metaapp.health.fragment.weightlog.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FileUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.MyCheckPermission;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import id.zelory.compressor.Compressor;

public class FragmentLogWeight extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference prefrences;
    String previous_weight;
    private ImageView minus_weight, add_weight;
    private EditText weight;
    double previous, next;
    private LinearLayout save_weight;
    private ImageView user_img;
    private LinearLayout upload_image;

    private Dialog profilePicDialog;
    private final int CAMERA_REQUEST = 200;
    private final int GALLERY_REQUEST = 201;
    private File mImageFile;
    private String base64imageextension = "";
    private String base64string = "";
    private String Tag_Camera = "camera";
    private String Tag_Gallery = "galary";

    private String Tag = null;
    private String File_Name = null, new_file_name = "";
    private Bitmap myBitmap;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_log_weight, container,false);
        ((MainActivityHealth) getActivity()).show_elevation();
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        checkAppPermission();
        return v;
    }

    private void init(){
        assert getArguments() != null;
        previous_weight = getArguments().getString("previous_weight");
        minus_weight = v.findViewById(R.id.minus_weight);
        add_weight = v.findViewById(R.id.add_weight);
        weight = v.findViewById(R.id.weight);
        save_weight = v.findViewById(R.id.save_weight);
        user_img = v.findViewById(R.id.user_img);
        upload_image = v.findViewById(R.id.upload_image);

        StringTokenizer a = new StringTokenizer(previous_weight, " ");
        String a1 = a.nextToken();
        weight.setText(a1);

        minus_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous = Double.parseDouble(weight.getText().toString());
                //previous = Double.parseDouble(previous_weight);
                next = previous - 0.5;
                weight.setText("" + next);
            }
        });

        add_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous = Double.parseDouble(weight.getText().toString());
                //previous = Double.parseDouble(previous_weight);
                next = previous + 0.5;
                weight.setText("" + next);
            }
        });

        upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        save_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savingweight(weight.getText().toString());
            }
        });
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
    private void savingweight(String s) {
        JSONObject object = new JSONObject();

        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
            object.put("UserID", prefrences.getUID());
            object.put("Weight", s);
            if (base64string.equals("")) {
                object.put("ImageInBase64", "");
            } else {
                object.put("ImageInBase64", base64string);
            }

            if (base64imageextension.equals("")) {
                object.put("FileExtension", "0");
            } else {
                object.put("FileExtension", base64imageextension);
            }
            object.put("LoseGain", "");
            object.put("LoseGainBy", "");
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_WEIGHT, this, RequestHealthConstants.SAVE_WEIGHT);
        req.execute();
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

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_WEIGHT) {
            if (object.optString("Message").equals("Success")) {
                Toast.makeText(getActivity(), "Weight logged successfully", Toast.LENGTH_SHORT).show();
                prefrences.setweight(weight.getText().toString());
                getFragmentManager().popBackStack();
            } else {
                Toast.makeText(getActivity(), "Please try again later!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    private void showDialog() {
        profilePicDialog = new Dialog(getActivity());
        profilePicDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        profilePicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        profilePicDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        profilePicDialog.setContentView(R.layout.dialog_profile_img);
        TextView txt_gallery_opt, txt_camera_opt;
        txt_camera_opt = profilePicDialog.findViewById(R.id.txt_camera_opt);
        txt_gallery_opt = profilePicDialog.findViewById(R.id.txt_gallery_opt);

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

    void processAhed() {
        if (Tag.equals(Tag_Camera)) {
            captureImage();

        } else if (Tag.equals(Tag_Gallery)) {
            viewFromGallery();
        }
    }

    void viewFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                GALLERY_REQUEST);
    }

    void captureImage() {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        mImageFile = new File(Environment.getExternalStorageDirectory() + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "temp.png");
        Uri tempURI = Uri.fromFile(mImageFile);
        Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
        startActivityForResult(photoCaptureIntent, CAMERA_REQUEST);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            File_Name = null;
            //********************************* Gallery Request *************************************************
            if (requestCode == GALLERY_REQUEST) {
                Uri selectedImageUri = data.getData();
                CropImage.activity(selectedImageUri)
                        .start(getContext(), this);
                if (null != selectedImageUri) {

                    try {
                        File_Name = FileUtils.getPathFromURI(getActivity().getApplicationContext(), selectedImageUri);
                        base64imageextension = File_Name.substring(File_Name.lastIndexOf("."));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            //************************************* Camera Request *********************************************
            else if (requestCode == CAMERA_REQUEST) {
                File_Name = mImageFile.getAbsolutePath();
                Uri tempURI = Uri.fromFile(mImageFile);
                CropImage.activity(tempURI).start(getContext(), this);
                base64imageextension = File_Name.substring(File_Name.lastIndexOf("."));

            }

            //**************************** Crop REQUEST ****************************************************
            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                Uri resultUri = result.getUri();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), resultUri);
                    String imagePath = resultUri.toString();
                    handleCroppedImage(getFileName("help_image.png", bitmap), user_img, "helpimage.png");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void handleCroppedImage(final String Path, final ImageView img, String image) {
        String f = null;
        f = compressNow(Path);
        LogUtils.showLog("@@@@@@@@@@@@@", f);
        myBitmap = BitmapFactory.decodeFile(f);
        img.setImageBitmap(myBitmap);
        startSaveImage(image, myBitmap);
    }

    void startSaveImage(String image, Bitmap myBitmap) {
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

    String compressNow(final String file) {
        FileUtils.deleteCache(getActivity());
        File compressedImage = new Compressor.Builder(getActivity())
                .setMaxWidth(350)
                .setMaxHeight(350)
                .setCompressFormat(Bitmap.CompressFormat.PNG)
                .build()
                .compressToFile(new File(file));
        return compressedImage.getAbsolutePath();
    }

    void saveImageToFile(Bitmap bmp, String filename) {
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

    String getFileName(String filename, Bitmap bmp) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), filename);
        FileOutputStream out = null;
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
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file.getAbsolutePath();
    }
}
