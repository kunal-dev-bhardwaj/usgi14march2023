package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
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
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import id.zelory.compressor.Compressor;

import static com.universalsompo.meta.R.id.save_profile_menu;

public class  FragmentProfile extends Fragment implements ResponseListener, AdapterView.OnItemSelectedListener, View.OnClickListener {
    private View v;
    private EditText edt_userName, edt_mob;
    private EditText edt_dob;
    private EditText edt_email;
    private EditText edt_pincode;
    private EditText edt_landline;
    private Spinner spn_city;
    private EditText edt_address;
    private Spinner spn_state;
    private ImageView edit_userimg;
    private ImageView circleImageView;
    private List<String> cityList;
    private List<String> stateList;
    private List<ClaimFilterModel> stateModelList;
    private List<ClaimFilterModel> cityModelList;
    private Dialog profilePicDialog;
    private int saveMenuSatus = 0;
    private Menu menuGroup;
    private MenuItem saveMenuItem, editMenuItem;
    private String selectedStateId = "";
    private String selectedCityId = "";
    private String selectedState = "";
    private String selectedCity = "";
    private final int CAMERA_REQUEST = 200;
    private final int GALLERY_REQUEST = 201;
    private File mImageFile;
    private String base64imageextension = "";
    private String base64string = "";
    private String Tag_Camera = "camera";
    private String Tag_Gallery = "galary";
    private String Tag = null;
    private MySharedPreference mySharedPreference;
    private SimpleDateFormat dateFormatter;
    private   Bitmap myBitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_profile, container, false);
        init();
        setHasOptionsMenu(true);
        if (NetworkUtils.isConnected(getActivity()))
        callApi(RequestConstants.GET_PROFILE_DETAIL);
        return v;
    }

    private void init() {
        edt_userName = v.findViewById(R.id.edt_username);
        edt_address = v.findViewById(R.id.edt_address);
        edt_dob = v.findViewById(R.id.edt_dob);
        edt_email = v.findViewById(R.id.edt_email);
        edt_pincode = v.findViewById(R.id.edt_pincode);
        edt_landline = v.findViewById(R.id.edt_landline);
        spn_city = v.findViewById(R.id.spn_city);
        spn_state = v.findViewById(R.id.spn_state);
//        circleImageView = v.findViewById(R.id.user_img);
//        edit_userimg = v.findViewById(R.id.edit_userimg);
//        edit_userimg.setVisibility(View.GONE);
        edt_mob = v.findViewById(R.id.edt_mob);
        spn_state.setOnItemSelectedListener(this);
        spn_city.setOnItemSelectedListener(this);
//        circleImageView.setOnClickListener(this);
        edt_dob.setOnClickListener(this);
        cityList = new ArrayList<>();
        stateList = new ArrayList<>();
        stateModelList = new ArrayList<>();
        cityModelList = new ArrayList<>();
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
        setHasOptionsMenu(true);
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
                edt_userName.setEnabled(false);
                edt_dob.setEnabled(true);
                edt_dob.setFocusable(true);
                edt_email.setEnabled(false);
                edt_mob.setEnabled(false);
                edt_address.setEnabled(true);
                edt_landline.setEnabled(true);
                edt_pincode.setEnabled(true);
                spn_state.setEnabled(true);
//                circleImageView.setEnabled(true);
//                edit_userimg.setVisibility(View.VISIBLE);
                edt_address.setFocusable(true);
                spn_city.setBackgroundResource(R.drawable.drop_down_list1);
                spn_state.setBackgroundResource(R.drawable.drop_down_list1);
                this.editMenuItem = item;
                saveMenuSatus = 1;
                menuInvisible();
                if (NetworkUtils.isConnected(getActivity()))
                callApi(RequestConstants.GET_STATE);
                return true;

            case R.id.save_profile_menu:
                this.saveMenuItem = item;
                edt_userName.setEnabled(false);
                edt_dob.setEnabled(false);
                edt_email.setEnabled(false);
                edt_mob.setEnabled(false);
                edt_address.setEnabled(false);
                edt_landline.setEnabled(false);
                edt_pincode.setEnabled(false);
                spn_city.setEnabled(false);
                spn_state.setEnabled(false);
//                circleImageView.setEnabled(false);
//                edit_userimg.setVisibility(View.GONE);
                spn_city.setBackgroundColor(Color.TRANSPARENT);
                spn_state.setBackgroundColor(Color.TRANSPARENT);
                saveMenuSatus = 0;
                menuInvisible();
                if (NetworkUtils.isConnected(getActivity()))
                    callApi(RequestConstants.PROFILE_UPDATE);
                return true;
        }

        return false;
    }

    private void callApi(Integer id) {
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
        } else if (id == RequestConstants.GET_STATE) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestConstants.TOKEN_NO, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_STATE, this, RequestConstants.GET_STATE);
            req.execute();
        } else if (id == RequestConstants.GET_CITY) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestConstants.TOKEN_NO, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
                object.put("StateId", selectedStateId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_CITY, this, RequestConstants.GET_CITY);
            req.execute();
        } else if (id == RequestConstants.PROFILE_UPDATE) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestConstants.TOKEN_NO, mySharedPreference.getToken_no());
                object.put(RequestConstants.USER_ID, mySharedPreference.getUID());
                object.put("Address", edt_address.getText().toString());
                object.put("PinCode", edt_pincode.getText().toString());
                object.put("LandLine", edt_landline.getText().toString());
                object.put("DOB", edt_dob.getText().toString());

                if (selectedCityId == null)
                    object.put("City", "");
                else
                    object.put("City", selectedCityId);

                if (selectedStateId == null)
                    object.put("State", "");
                else
                    object.put("State", selectedStateId);

                if (base64imageextension.equals("")) {
                    object.put("UserImageExt", "0");
                } else {
                    object.put("UserImageExt", base64imageextension);
                }

                if (base64string.equals("")) {
                    object.put("UserImage", "");
                } else {
                    object.put("UserImage", base64string);
                }
            } catch (JSONException je) {
                je.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.PROFILE_UPDATE, this, RequestConstants.PROFILE_UPDATE);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        ArrayAdapter<String> cityArrayAdapter;
        ArrayAdapter<String> stateArrayAdapter;
        if (Tag == RequestConstants.GET_PROFILE_DETAIL) {
            new AppDataPushApi().callApi(getActivity(),"Profile","Profile page","User checked his profile");
            try {
                if (!object.optString("UserName").equals("")) {
                    edt_userName.setText(object.optString("UserName"));
                }

                if (!object.optString("DOB").equals("")) {
                    edt_dob.setText(parseDateToddMMyyyy(object.optString("DOB")));
                    mySharedPreference.setDOB(object.optString("DOB"));
                }

                if (!object.optString("Email").equals("")) {
                    edt_email.setText(object.optString("Email"));
                }

                if (!object.optString("Address").equals("")) {
                    edt_address.setText(object.optString("Address"));
                    mySharedPreference.setaddress(object.optString("Address"));
                }

                if (!object.optString("PinCode").equals("")) {
                    edt_pincode.setText(object.optString("PinCode"));
                    mySharedPreference.setpincode(object.optString("PinCode"));
                }

                if (!object.optString("LandLine").equals("")) {
                    edt_landline.setText(object.optString("LandLine"));
                    mySharedPreference.setLandLine(object.optString("LandLine"));
                }

                if (!object.optString("MobileNo").equals("")) {
                    edt_mob.setText(object.optString("MobileNo"));
                }

                Picasso.get().load(object.optString("UserImagePath")).fit().placeholder(R.drawable.dummy).into(circleImageView);

                if (object.optString("City").equals("")) {
                    cityList.add("- Select -");
                } else {
                    cityList.add(object.optString("City"));
                    selectedCity = object.optString("City");
                    mySharedPreference.setcity(object.optString("City"));
                }

                if (object.optString("State").equals("")) {
                    stateList.add("- Select -");
                } else {
                    stateList.add(object.optString("State"));
                    selectedState = object.optString("State");
                    mySharedPreference.setstate(object.optString("State"));
                }

                cityArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, cityList);
                stateArrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, stateList);

                spn_city.setAdapter(cityArrayAdapter);
                spn_state.setAdapter(stateArrayAdapter);
                spn_city.setEnabled(false);
                spn_state.setEnabled(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Tag == RequestConstants.GET_STATE) {
            try {
                if (!stateList.isEmpty())
                    stateList.clear();
                if (!stateModelList.isEmpty())
                    stateModelList.clear();
                stateModelList.add(new ClaimFilterModel("0", "- Select -"));
                stateList.add("- Select -");
                JSONArray arr = object.getJSONArray("StateDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    stateModelList.add(new ClaimFilterModel(obj.getString("StateId"), obj.getString("StateName")));
                    stateList.add(obj.optString("StateName"));
                }
                stateArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, stateList);
                spn_state.setAdapter(stateArrayAdapter);
                ArrayAdapter myAdap = (ArrayAdapter) spn_state.getAdapter();
                int spinnerPosition = myAdap.getPosition(selectedState);
                spn_state.setSelection(spinnerPosition);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (Tag == RequestConstants.GET_CITY) {
            if (!cityList.isEmpty())
                cityList.clear();
            if (!cityModelList.isEmpty())
                cityModelList.clear();
            cityModelList.add(new ClaimFilterModel("0", "- Select -"));
            cityList.add("- Select -");
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("CityDetails");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        cityModelList.add(new ClaimFilterModel(obj.getString("CityId"), obj.getString("CityName")));
                        cityList.add(obj.getString("CityName"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cityArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item, cityList);
                spn_city.setAdapter(cityArrayAdapter);

                ArrayAdapter myAdap = (ArrayAdapter) spn_city.getAdapter();
                int spinnerPosition = myAdap.getPosition(selectedCity);
                spn_city.setSelection(spinnerPosition);
            } else {
                Snackbar.make(Objects.requireNonNull(getView()), "No city associated with this state", Snackbar.LENGTH_LONG).show();
            }
        } else if (Tag == RequestConstants.PROFILE_UPDATE) {
            new AppDataPushApi().callApi(getActivity(),"Profile","Profile update page","User updated his profile");
            try {
                Log.d("Response", object.toString());
                Snackbar.make(Objects.requireNonNull(getView()), "Profile Saved Successfully", Snackbar.LENGTH_LONG).show();
                if(myBitmap!=null)
                MainActivity.img_user.setImageBitmap(myBitmap);
            } catch (Exception npe) {
                npe.printStackTrace();
            }
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spn_state:
                if (stateModelList.size() > 0) {
                    selectedStateId = stateModelList.get(position).getId();
                }
                if (!selectedStateId.equals("")) {
                    spn_city.setEnabled(true);
                     LogUtils.showLog("STATE ID", selectedStateId);
                    if (NetworkUtils.isConnected(getActivity()))
                        callApi(RequestConstants.GET_CITY);
                }
                break;

            case R.id.spn_city:
                if (cityModelList.size() > 0) {
                     LogUtils.showLog("CITY ID", selectedCityId);
                    selectedCityId = cityModelList.get(position).getId();
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_img:
//                showDialog();
                break;
            case R.id.edt_dob:
                showCalender();

                break;
        }
    }

    private void showDialog() {
        profilePicDialog = new Dialog(Objects.requireNonNull(getActivity()));
        profilePicDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(profilePicDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        profilePicDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        profilePicDialog.setContentView(R.layout.dialog_motor_profile_img);
        TextView txt_gallery_opt, txt_camera_opt,txt_remove_opt;
        txt_camera_opt = profilePicDialog.findViewById(R.id.txt_camera_opt);
        txt_gallery_opt = profilePicDialog.findViewById(R.id.txt_gallery_opt);
        txt_remove_opt = profilePicDialog.findViewById(R.id.txt_remove_opt);

        profilePicDialog.show();

        txt_gallery_opt.setOnClickListener(v -> {
            Tag = Tag_Gallery;
            processAhed();
            profilePicDialog.dismiss();
        });

        txt_camera_opt.setOnClickListener(v -> {
            Tag = Tag_Camera;
            processAhed();
            profilePicDialog.dismiss();
        });

        txt_remove_opt.setOnClickListener(v -> {
            Tag = Tag_Gallery;
            processAhed();
            profilePicDialog.dismiss();
        });

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
                CropImage.activity(tempURI).start(Objects.requireNonNull(getContext()), this);
                base64imageextension = file_Name.substring(file_Name.lastIndexOf("."));
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

    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(Objects.requireNonNull(getActivity()), R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                Toast.makeText(getActivity(), dateFormatter.format(newDate.getTime()), Toast.LENGTH_SHORT).show();
                edt_dob.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }

    private String parseDateToddMMyyyy(String time) {
        String inputPattern;
        if(time.contains("/"))
            inputPattern = "MM/dd/yyyy";
        else
            inputPattern = "MMM-dd-yyyy";
        String outputPattern = "dd-MMM-yyyy";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date;
        String str = null;
        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
