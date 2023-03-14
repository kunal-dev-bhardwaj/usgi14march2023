package com.universalsompo.meta.metaapp.health.fragment.profile;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.MyPolicyTab;
import com.universalsompo.meta.metaapp.health.fragment.profile.basicprofile.FragmentBasicProfile;
import com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.fragment.FragmentFamilyInfo;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.FragmentMedicalInfo;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FileUtils;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import id.zelory.compressor.Compressor;
import static com.universalsompo.meta.R.id.save_profile_menu;

public class FragmentHealthProfile extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private SelectorListener binder;
    private ImageView edit_userimg;
    private ImageView circleImageView;
    private Dialog profilePicDialog;
    private int saveMenuSatus = 0;
    private Menu menuGroup;
    private MenuItem saveMenuItem, editMenuItem;
    private final int CAMERA_REQUEST = 200;
    private final int GALLERY_REQUEST = 201;
    private File mImageFile;
    private String base64imageextension = "";
    private String base64string = "";
    private String Tag_Camera = "camera";
    private String Tag_Gallery = "galary";
    private String Tag = null;
    private MySharedPreference mySharedPreference;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_health_profile, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).remove_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        init();
        callApi(RequestConstants.GET_PROFILE_DETAIL);
        return v;
    }

    private void init() {
        circleImageView = v.findViewById(R.id.user_img);
        edit_userimg = v.findViewById(R.id.edit_userimg);
        edit_userimg.setVisibility(View.GONE);
        /*,risk_profile*/
        LinearLayout basic_profile = v.findViewById(R.id.basic_profile);
        LinearLayout family_info = v.findViewById(R.id.family_info);
        LinearLayout medical_info = v.findViewById(R.id.medical_info);
        LinearLayout insurance_wallet = v.findViewById(R.id.insurance_wallet);
        basic_profile.setOnClickListener(this);
        family_info.setOnClickListener(this);
        medical_info.setOnClickListener(this);
        insurance_wallet.setOnClickListener(this);
        circleImageView.setOnClickListener(this);
        mySharedPreference = MySharedPreference.getInstance(getActivity());
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.profile_menu, menu);
        menuGroup = menu;
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        if (saveMenuSatus == 0)
            menu.findItem(R.id.edit_profile_menu).setVisible(true);
        else
            menu.findItem(R.id.save_profile_menu).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }

    private void menuInvisible() {
        setHasOptionsMenu(true);// Take part in populating the action bar menu
        if (saveMenuSatus == 0) {
            editMenuItem = menuGroup.findItem(R.id.edit_profile_menu);
            editMenuItem.setVisible(true);
            saveMenuItem = menuGroup.findItem(save_profile_menu);
            saveMenuItem.setVisible(false);
        } else {
            saveMenuItem = menuGroup.findItem(R.id.save_profile_menu);
            saveMenuItem.setVisible(true);
            editMenuItem = menuGroup.findItem(R.id.edit_profile_menu);
            editMenuItem.setVisible(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_profile_menu:
                circleImageView.setEnabled(true);
                edit_userimg.setVisibility(View.VISIBLE);
                this.editMenuItem = item;
                saveMenuSatus = 1;
                menuInvisible();
                return true;

            case R.id.save_profile_menu:
                this.saveMenuItem = item;
                circleImageView.setEnabled(false);
                edit_userimg.setVisibility(View.GONE);
                saveMenuSatus = 0;
                menuInvisible();
//                callApi(RequestHealthConstants.PROFILE_IMAGE_UPDATE);
                return true;
        }
        return false;
    }

    private void callApi(Integer id) {
        //************************************* profile detail Api Call *******************************
        if (id == RequestConstants.GET_PROFILE_DETAIL) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestConstants.TOKEN_NO, mySharedPreference.getToken_no());
                object.put(RequestConstants.USER_ID, mySharedPreference.getUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_PROFILE_DETAIL, this, RequestConstants.GET_PROFILE_DETAIL);
            req.execute();
        }

        //***************************************** Update Profile Api Call *************************************
       /* else if (id == RequestHealthConstants.PROFILE_IMAGE_UPDATE) {
            JSONObject object = new JSONObject();
            try {
                object.put("TokenNo", mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());

                if (base64string.equals("")) {
                    object.put("UserImage", "");
                } else {
                    object.put("UserImage", base64string);
                }

                if (base64imageextension.equals("")) {
                    object.put("UserImageExt", "0");
                } else {
                    object.put("UserImageExt", base64imageextension);
                }
            } catch (JSONException je) {
                je.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.PROFILE_IMAGE_UPDATE, this, RequestHealthConstants.PROFILE_IMAGE_UPDATE);
            req.execute();
        }*/
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {

        if (Tag == RequestConstants.GET_PROFILE_DETAIL) {
            try {
                String image = object.optString("UserImagePath");
                if (!object.isNull("UserImagePath")){
                    Picasso.get().load(image).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.loading).error(R.drawable.hra1).into(circleImageView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       /* else if (Tag == RequestHealthConstants.PROFILE_IMAGE_UPDATE) {
            try {
                Log.d("Response", object.toString());
                Snackbar.make(Objects.requireNonNull(getView()), "Image Updated Successfully", Snackbar.LENGTH_LONG).show();
            } catch (Exception npe) {
                npe.printStackTrace();
            }
        }*/
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_img:
                showDialog();
                break;

            case R.id.basic_profile:
                replaceFragment(new FragmentBasicProfile(), FragmentsHealthTags.FRAGMENT_BASIC_PROFILE);
                break;

            case R.id.family_info:
                replaceFragment(new FragmentFamilyInfo(), FragmentsHealthTags.FRAGMENT_FAMILY_INFO);
                break;

            case R.id.medical_info:
                replaceFragment(new FragmentMedicalInfo(), FragmentsHealthTags.FRAGMENT_MEDICAL_INFO);
                break;

            case R.id.insurance_wallet:

                replace_new_Fragment(new MyPolicyTab(), FragmentsHealthTags.FRAGMENT_HEALTH_POLICY);

//                replaceFragment(new MyPolicyTab(), FragmentsHealthTags.FRAGMENT_HEALTH_POLICY);
                break;
        }
    }



    private void showDialog() {
        profilePicDialog = new Dialog(Objects.requireNonNull(getActivity()));
        profilePicDialog = new Dialog(getActivity(), android.R.style.Theme_Translucent_NoTitleBar);
        profilePicDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Objects.requireNonNull(profilePicDialog.getWindow()).setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        profilePicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        profilePicDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        profilePicDialog.setContentView(R.layout.dialog_profile_picker);

        LinearLayout camera =  profilePicDialog.findViewById(R.id.camera);
        LinearLayout gallery =  profilePicDialog.findViewById(R.id.gallery);
        LinearLayout delete_photo =  profilePicDialog.findViewById(R.id.delete_photo);
        LinearLayout cancel =  profilePicDialog.findViewById(R.id.cancel);

        profilePicDialog.show();

        gallery.setOnClickListener(v -> {
            Tag = Tag_Gallery;
            processAhed();
            profilePicDialog.dismiss();
        });

        camera.setOnClickListener(v -> {
            Tag = Tag_Camera;
            processAhed();
            profilePicDialog.dismiss();
        });

     /*   delete_photo.setOnClickListener(v -> callApi(RequestHealthConstants.PROFILE_IMAGE_UPDATE));*/

        cancel.setOnClickListener(v -> profilePicDialog.dismiss());
    }

    private void processAhed() {
        if (Tag.equals(Tag_Camera)) {
            captureImage();
        } else if (Tag.equals(Tag_Gallery)) {
            viewFromGallery();
        }
    }

    @SuppressLint("IntentReset")
    private void viewFromGallery() {
        @SuppressLint("IntentReset") Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                GALLERY_REQUEST);
    }

    private void captureImage() {
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
            }
            else if (requestCode == CAMERA_REQUEST) {
                file_Name = mImageFile.getAbsolutePath();
                Uri tempURI = Uri.fromFile(mImageFile);
                assert tempURI != null;
                 if (tempURI != null){
                     CropImage.activity(tempURI).start(Objects.requireNonNull(getContext()), this);
                     base64imageextension = file_Name.substring(file_Name.lastIndexOf("."));
                 }else {
                     Toast.makeText(getContext(), "Please click again", Toast.LENGTH_SHORT).show();
                 }
            }
            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                Uri resultUri = result.getUri();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(Objects.requireNonNull(getActivity()).getContentResolver(), resultUri);
                    handleCroppedImage(getFileName(bitmap), circleImageView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleCroppedImage(final String Path, final ImageView img) {
        String f;
        f = compressNow(Path);
        Bitmap myBitmap = BitmapFactory.decodeFile(f);
        img.setImageBitmap(myBitmap);
        startSaveImage(myBitmap);
    }

    private void startSaveImage(Bitmap myBitmap) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "profile.png");
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
//        callApi(RequestHealthConstants.PROFILE_IMAGE_UPDATE);
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
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "profile.png");
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
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    private void replace_new_Fragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equalsIgnoreCase(FragmentsHealthTags.FRAGMENT_HEALTH_POLICY)) {
                Bundle args = new Bundle();
                args.putInt("otherFrag", 1);
                frag.setArguments(args);
            }
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}