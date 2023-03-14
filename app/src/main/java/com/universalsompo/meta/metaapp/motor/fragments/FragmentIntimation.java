package com.universalsompo.meta.metaapp.motor.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.adapters.AdapterLosstype;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ImageListenerInterface;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
import com.universalsompo.meta.metaapp.motor.models.IntimationGetInformatonModel;
import com.universalsompo.meta.metaapp.motor.models.SaveClaimIntimationModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.FileUtils;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import id.zelory.compressor.Compressor;

public class FragmentIntimation extends Fragment implements View.OnClickListener, ResponseListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ImageListenerInterface {
    private SelectorListener binder;
    private View rootview;
    private MySharedPreference pref;
    private ScrollView svClaimIntimLayout;
    private LinearLayout llClaimLayoutGone;
    private MainActivity acti;
    private CustomProgressDialog customDialog;
    private CustomProgressDialog customDialogMAin;
    private String VehicleType;
    private IntimationGetInformatonModel data;
    private int curYear;
    private int curMonth;
    private int curDay;
    private Button send_intimation;
    private SaveClaimIntimationModel savedData;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private List<Address> myAddress;
    private LocationRequest mLocationRequest;

    private ImageView header_image_part1;
    private LinearLayout contant_layout_1;
    private TextView intim_insured_name;
    private TextView intim_policy_no;
    private TextView intim_email_id;
    private TextView intim_mobile_no;
    private EditText intim_address;

    private ImageView header_image_part2;
    private LinearLayout contant_layout_2;
    private TextView loss_intim_date;
    private TextView loss_intim_time;
    private EditText intim_place;
    private EditText loss_intim_address;
    private EditText loss_intim_city;
    private EditText loss_intim_state;
    private Spinner intim_spiner_loss_type;
    private RadioButton loss_intim_police_yes;
    private EditText loss_intim_description;
    private LinearLayout loss_image_part;
    private ImageView capture_font;
    private ImageView capture_back;
    private ImageView capture_left;
    private ImageView capture_right;
    private ImageView capture_engine;
    private ImageView capture_other;

    private String IMAGE_NAME_CAR_FONT_SIDE;
    private String IMAGE_NAME_CAR_BACK_SIDE;
    private String IMAGE_NAME_CAR_LEFT_SIDE;
    private String IMAGE_NAME_CAR_RIGHT_SIDE;
    private String IMAGE_NAME_CAR_ENGINE_SIDE;
    private String IMAGE_NAME_CAR_OTHER_SIDE;

    private final String NAME_FONT_IMAGE = "car_font.png";
    private final String NAME_BACK_IMAGE = "car_back.png";
    private final String NAME_LEFT_IMAGE = "car_left.png";
    private final String NAME_RIGHT_IMAGE = "car_right.png";
    private final String NAME_ENGINE_IMAGE = "car_engine.png";
    private final String NAME_OTHER_IMAGE = "car_other.png";

    private final int CAR_FONT_SIDE = 9998;
    private final int CAR_BACK_SIDE = 9997;
    private final int CAR_LEFT_SIDE = 9996;
    private final int CAR_RIGHT_SIDE = 9995;
    private final int CAR_ENGINE_SIDE = 9994;
    private final int CAR_OTHER_SIDE = 9993;

    private final int GALARY_CAR_FONT_SIDE = 9988;
    private final int GALARY_CAR_BACK_SIDE = 9987;
    private final int GALARY_CAR_LEFT_SIDE = 9986;
    private final int GALARY_CAR_RIGHT_SIDE = 9985;
    private final int GALARY_CAR_ENGINE_SIDE = 9984;
    private final int GALARY_CAR_OTHER_SIDE = 9983;

    private ImageView header_image_part_claim_details;
    private LinearLayout content_layout_claim_details;
    private TextView loss_intim_claim_date;
    private TextView loss_intim_claim_time;
    private EditText intim_contact_number;
    private RadioButton loss_intim_tw;
    private EditText intim_estimated_amount;
    private EditText loss_intim_remarks;
    private String vehicle_type;

    private ImageView header_image_part5;
    private LinearLayout contant_layout_5;
    private ImageView claim_intim_img_vehicale_reg;
    private ImageView claim_intim_img_vehicale_policy;
    private ProgressBar progress_web_policy_doc;
    private ImageView claim_intim_img_driving_lic;

    private String IMAGE_NAME_VEHICLE_REG_IMAGE;
    private String IMAGE_NAME_VEHICLE_POLICY_IMAGE;
    private String IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE;

    private final String NAME_VEHICLE_REG_IMAGE = "vehicle_reg.png";
    private final String NAME_VEHICLE_POLICY_IMAGE = "vehicle_policy.png";
    private final String NAME_VEHICLE_DRIVING_LIC_IMAGE = "vehicle_lic.png";

    private final int VEHICLE_REG_IMAGE_TAG = 10000;
    private final int VEHICLE_POLICY_IMAGE_TAG = 20000;
    private final int VEHICLE_DRIVING_LIC_IMAGE_TAG = 30000;

    private final int VEHICLE_REG_IMAGE = 9992;
    private final int VEHICLE_POLICY_IMAGE = 9991;
    private final int VEHICLE_DRIVING_LIC_IMAGE = 9990;

    private final int GALARY_VEHICLE_REG_IMAGE = 9982;
    private final int GALARY_VEHICLE_POLICY_IMAGE = 9981;
    private final int GALARY_VEHICLE_DRIVING_LIC_IMAGE = 9980;

    private ImageView header_image_part_puc_details;
    private LinearLayout content_layout_claim_details_puc;
    private TextView intim_vehicle_no;
    private TextView loss_intim_valid_upto;
    private EditText intim_puc_number;
    private EditText intim_puc_center;
    private EditText intim_vehicle_no1;

    /* Police notify */
    private LinearLayout claim_intim_police_layout;
    private ImageView header_image_part3;
    private LinearLayout contant_layout_3;
    private EditText intim_police_station;
    private EditText intim_fir_no;
    private EditText intim_incharge_contact;
    private TextView intim_fir_date;

    /* Driver details */
    private LinearLayout claim_intim_driver_layout;
    private ImageView header_image_part4;
    private LinearLayout contant_layout_4;
    private EditText intim_driver_name;
    private EditText loss_intim_relation;
    private EditText intim_driver_age;
    private EditText intim_driver_licence;
    private Spinner intim_spiner_dl_type;
    private TextView intim_driver_exp;

    private ImageView header_image_part6;
    private LinearLayout contant_layout_6;
    private EditText intim_bank_account_holder;
    private EditText intim_bank_account_no;
    private EditText intim_bank_name;
    private EditText intim_bank_branch;
    private EditText intim_bank_ifsc;

    private ImageView header_image_part7;
    private LinearLayout contant_layout_7;
    private EditText intim_declear_place;
    private TextView intim_declear_date;
    private CheckBox claim_intim_declear;

    private WebView web_view_poilcy_doc_image;
    private RelativeLayout webview_policy_doc_layout;
    private Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_intimation, container, false);
        pref = MySharedPreference.getInstance(acti);
        assert getArguments() != null;
        VehicleType = getArguments().getString("v_type");
        getInfo();
        initView();
        savedData = SaveClaimIntimationModel.getInstance();
        customDialogMAin = CustomProgressDialog.getInstance(acti);
        return rootview;
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            acti = (MainActivity) activity;
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    private void initView() {
        initDate();
        send_intimation = rootview.findViewById(R.id.send_intimation);
        send_intimation.setOnClickListener(this);
        send_intimation.setClickable(false);
        initHeaderPart();
        initHeaderImage();
        initInnerContentLayout();
        initViewpart1();
        initViewpart2();
        initClaimdetails();
        initViewpart5();
        initPUCdetails();
        initViewpart3();
        initViewpart4();
        initViewpart6();
        initViewpart7();
        svClaimIntimLayout = rootview.findViewById(R.id.svClaimIntimationWholeLayout);
        llClaimLayoutGone = rootview.findViewById(R.id.llClaimMadeTrack);
    }


    private void initHeaderPart() {
        RelativeLayout header_part1 = rootview.findViewById(R.id.header_part1);
        RelativeLayout header_part2 = rootview.findViewById(R.id.header_part2);
        RelativeLayout header_part_claim_details = rootview.findViewById(R.id.header_part_claim_details);
        RelativeLayout header_part5 = rootview.findViewById(R.id.header_part5);
        RelativeLayout header_part_claim_details_puc = rootview.findViewById(R.id.header_part_claim_details_puc);
        RelativeLayout header_part3 = rootview.findViewById(R.id.header_part3);
        RelativeLayout header_part4 = rootview.findViewById(R.id.header_part4);
        RelativeLayout header_part6 = rootview.findViewById(R.id.header_part6);
        RelativeLayout header_part7 = rootview.findViewById(R.id.header_part7);

        header_part1.setOnClickListener(this);
        header_part2.setOnClickListener(this);
        header_part_claim_details.setOnClickListener(this);
        header_part5.setOnClickListener(this);
        header_part_claim_details_puc.setOnClickListener(this);
        header_part3.setOnClickListener(this);
        header_part4.setOnClickListener(this);
        header_part6.setOnClickListener(this);
        header_part7.setOnClickListener(this);
    }

    private void initHeaderImage() {
        claim_intim_driver_layout = rootview.findViewById(R.id.claim_intim_driver_layout);
        header_image_part1 = rootview.findViewById(R.id.header_image_part1);
        header_image_part2 = rootview.findViewById(R.id.header_image_part2);
        header_image_part_claim_details = rootview.findViewById(R.id.header_image_part_claim_details);
        header_image_part5 = rootview.findViewById(R.id.header_image_part5);
        header_image_part_puc_details = rootview.findViewById(R.id.header_image_part_puc_details);
        header_image_part3 = rootview.findViewById(R.id.header_image_part3);
        header_image_part4 = rootview.findViewById(R.id.header_image_part4);
        header_image_part6 = rootview.findViewById(R.id.header_image_part6);
        header_image_part7 = rootview.findViewById(R.id.header_image_part7);
    }

    private void initInnerContentLayout() {
        contant_layout_1 = rootview.findViewById(R.id.contant_layout_1);
        contant_layout_2 = rootview.findViewById(R.id.contant_layout_2);
        content_layout_claim_details = rootview.findViewById(R.id.content_layout_claim_details);
        contant_layout_5 = rootview.findViewById(R.id.contant_layout_5);
        content_layout_claim_details_puc = rootview.findViewById(R.id.content_layout_claim_details_puc);
        contant_layout_3 = rootview.findViewById(R.id.contant_layout_3);
        contant_layout_4 = rootview.findViewById(R.id.contant_layout_4);
        contant_layout_6 = rootview.findViewById(R.id.contant_layout_6);
        contant_layout_7 = rootview.findViewById(R.id.contant_layout_7);
    }

    private void initViewpart1() {
        intim_insured_name = rootview.findViewById(R.id.intim_insured_name);
        intim_policy_no = rootview.findViewById(R.id.intim_policy_no);
        intim_mobile_no = rootview.findViewById(R.id.intim_mobile_no);
        intim_email_id = rootview.findViewById(R.id.intim_email_id);
        intim_address = rootview.findViewById(R.id.intim_address);
    }

    private void initViewpart2() {
        loss_intim_date = rootview.findViewById(R.id.loss_intim_date);
        loss_intim_date.setOnClickListener(v -> datePickerTillToday(loss_intim_date));
        loss_intim_time = rootview.findViewById(R.id.loss_intim_time);
        loss_intim_time.setOnClickListener(v -> setTime(loss_intim_time));
        intim_place = rootview.findViewById(R.id.intim_place);
        loss_intim_address = rootview.findViewById(R.id.loss_intim_address);
        ImageView claim_loss_select_location = rootview.findViewById(R.id.claim_loss_select_location);
        claim_loss_select_location.setOnClickListener(v -> {
            customDialogMAin.showProgressBar();
            buildGoogleApiClient();
        });
        loss_intim_city = rootview.findViewById(R.id.loss_intim_city);
        loss_intim_state = rootview.findViewById(R.id.loss_intim_state);
        intim_spiner_loss_type = rootview.findViewById(R.id.intim_spiner_loss_type);
        ClaimFilterModel data;
        final ArrayList<ClaimFilterModel> dataIs = new ArrayList<>();
        data = new ClaimFilterModel("0", "-Select-");
        dataIs.add(data);
        data = new ClaimFilterModel("1", "Accident(Own Damage)");
        dataIs.add(data);
        data = new ClaimFilterModel("2", "Theft");
        dataIs.add(data);
        data = new ClaimFilterModel("3", "Third Party");
        dataIs.add(data);

        intim_spiner_loss_type.setAdapter(new AdapterLosstype(acti, dataIs));
        intim_spiner_loss_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                handleLosstypeEvent(position, dataIs.get(position).getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        RadioGroup loss_intim_radio_group = rootview.findViewById(R.id.loss_intim_radio_group);
        loss_intim_police_yes = rootview.findViewById(R.id.loss_intim_police_yes);
        loss_intim_radio_group.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checkedRadioButton = group.findViewById(checkedId);
            if (checkedRadioButton.getText().toString().equals("Yes")) {
                claim_intim_police_layout.setVisibility(View.VISIBLE);
                contant_layout_3.setVisibility(View.VISIBLE);
                header_image_part3.setBackgroundResource(R.drawable.drop_down3);
            } else {
                claim_intim_police_layout.setVisibility(View.GONE);
            }
        });
        loss_intim_description = rootview.findViewById(R.id.loss_intim_description);
        loss_intim_description.setMovementMethod(new ScrollingMovementMethod());
        loss_image_part = rootview.findViewById(R.id.loss_image_part);
        capture_font = rootview.findViewById(R.id.capture_font);
        capture_back = rootview.findViewById(R.id.capture_back);
        capture_left = rootview.findViewById(R.id.capture_left);
        capture_right = rootview.findViewById(R.id.capture_right);
        capture_engine = rootview.findViewById(R.id.capture_engine);
        capture_other = rootview.findViewById(R.id.capture_other);
        capture_font.setOnClickListener(this);
        capture_back.setOnClickListener(this);
        capture_left.setOnClickListener(this);
        capture_right.setOnClickListener(this);
        capture_engine.setOnClickListener(this);
        capture_other.setOnClickListener(this);

        capture_font.setOnLongClickListener(v -> {
            showPopUpNow(capture_font, IMAGE_NAME_CAR_FONT_SIDE);
            return false;
        });

        capture_back.setOnLongClickListener(v -> {
            showPopUpNow(capture_back, IMAGE_NAME_CAR_BACK_SIDE);
            return false;
        });

        capture_left.setOnLongClickListener(v -> {
            showPopUpNow(capture_left, IMAGE_NAME_CAR_LEFT_SIDE);
            return false;
        });

        capture_right.setOnLongClickListener(v -> {
            showPopUpNow(capture_right, IMAGE_NAME_CAR_RIGHT_SIDE);
            return false;
        });

        capture_engine.setOnLongClickListener(v -> {
            showPopUpNow(capture_engine, IMAGE_NAME_CAR_ENGINE_SIDE);
            return false;
        });

        capture_other.setOnLongClickListener(v -> {
            showPopUpNow(capture_other, IMAGE_NAME_CAR_OTHER_SIDE);
            return false;
        });
    }

    private void handleLongClick(ImageView img, String file) {
        deleteFile(file);
        img.setImageBitmap(null);
        img.setBackgroundResource(R.drawable.camera_icon2);
        if (file.equals(IMAGE_NAME_CAR_FONT_SIDE)) {
            IMAGE_NAME_CAR_FONT_SIDE = null;
        } else if (file.equals(IMAGE_NAME_CAR_BACK_SIDE)) {
            IMAGE_NAME_CAR_BACK_SIDE = null;
        } else if (file.equals(IMAGE_NAME_CAR_LEFT_SIDE)) {
            IMAGE_NAME_CAR_LEFT_SIDE = null;
        } else if (file.equals(IMAGE_NAME_CAR_RIGHT_SIDE)) {
            IMAGE_NAME_CAR_RIGHT_SIDE = null;
        } else if (file.equals(IMAGE_NAME_CAR_ENGINE_SIDE)) {
            IMAGE_NAME_CAR_ENGINE_SIDE = null;
        } else if (file.equals(IMAGE_NAME_CAR_OTHER_SIDE)) {
            IMAGE_NAME_CAR_OTHER_SIDE = null;
        }
    }

    private void showPopUpNow(final ImageView img, final String file) {
        if (file == null) {
            return;
        }
        File f = new File(file);
        if (!f.exists() || f.length() <= 0) {
            return;
        }
        LayoutInflater layoutInflater = (LayoutInflater) acti.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View popupView = layoutInflater.inflate(R.layout.image_delete_popup, null);
        TextView txt_cancel = popupView.findViewById(R.id.txt_cancel);
        TextView txt_ok = popupView.findViewById(R.id.txt_ok);
        final Dialog customDialog = new Dialog(acti);
        customDialog.setCanceledOnTouchOutside(true);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(popupView);
        customDialog.show();
        txt_ok.setOnClickListener(v -> {
            handleLongClick(img, file);
            customDialog.dismiss();
        });
        txt_cancel.setOnClickListener(v -> customDialog.dismiss());
    }

    private void initClaimdetails() {
        loss_intim_claim_date = rootview.findViewById(R.id.loss_intim_claim_date);
        loss_intim_claim_date.setOnClickListener(v -> datePickerTillToday(loss_intim_claim_date));
        loss_intim_claim_time = rootview.findViewById(R.id.loss_intim_claim_time);
        loss_intim_claim_time.setOnClickListener(v -> setTime(loss_intim_claim_time));
        intim_contact_number = rootview.findViewById(R.id.intim_contact_number);
        RadioGroup loss_intim_vehicle_type_radio_group = rootview.findViewById(R.id.loss_intim_vehicle_type_radio_group);
        loss_intim_tw = rootview.findViewById(R.id.loss_intim_tw);
        loss_intim_vehicle_type_radio_group.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checkedRadioButton = group.findViewById(checkedId);
            if (checkedRadioButton.getText().toString().equals("TW")) {
                vehicle_type = "Two Wheeler";
            } else {
                vehicle_type = "Four Wheeler";
            }
        });
        intim_estimated_amount = rootview.findViewById(R.id.intim_estimated_amount);
        loss_intim_remarks = rootview.findViewById(R.id.loss_intim_remarks);
        loss_intim_remarks.setMovementMethod(new ScrollingMovementMethod());
    }

    private void initViewpart5() {
        claim_intim_img_vehicale_reg = rootview.findViewById(R.id.claim_intim_img_vehicale_reg);
        claim_intim_img_vehicale_policy = rootview.findViewById(R.id.claim_intim_img_vehicale_policy);
        claim_intim_img_driving_lic = rootview.findViewById(R.id.claim_intim_img_driving_lic);
        web_view_poilcy_doc_image = rootview.findViewById(R.id.web_view_poilcy_doc_image);
        webview_policy_doc_layout = rootview.findViewById(R.id.webview_policy_doc_layout);
        progress_web_policy_doc = rootview.findViewById(R.id.progress_web_policy_doc);

        web_view_poilcy_doc_image.setWebViewClient(new WebViewClient());
        web_view_poilcy_doc_image.setWebChromeClient(new MyWebViewClient());

        claim_intim_img_vehicale_reg.setOnClickListener(this);
        claim_intim_img_vehicale_policy.setOnClickListener(this);
        claim_intim_img_driving_lic.setOnClickListener(this);
        claim_intim_img_vehicale_reg.setOnLongClickListener(v -> {
            showPopUpNow(claim_intim_img_vehicale_reg, IMAGE_NAME_VEHICLE_REG_IMAGE);
            return false;
        });
        claim_intim_img_vehicale_policy.setOnLongClickListener(v -> {
            if (data.getPolicyDocPath().equals("null") && data.getPolicyDocPath().trim().length() == 0) {
                showPopUpNow(claim_intim_img_vehicale_policy, IMAGE_NAME_VEHICLE_POLICY_IMAGE);
            }
            return false;
        });
        claim_intim_img_driving_lic.setOnLongClickListener(v -> {
            showPopUpNow(claim_intim_img_driving_lic, IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE);
            return false;
        });
    }

    private void initPUCdetails() {
        intim_vehicle_no = rootview.findViewById(R.id.intim_vehicle_no);
        intim_vehicle_no1 = rootview.findViewById(R.id.intim_vehicle_no1);
        loss_intim_valid_upto = rootview.findViewById(R.id.loss_intim_valid_upto);
        loss_intim_valid_upto.setOnClickListener(v -> {
            final Calendar cldr = Calendar.getInstance();
            int day = cldr.get(Calendar.DAY_OF_MONTH);
            int month = cldr.get(Calendar.MONTH);
            int year = cldr.get(Calendar.YEAR);
            // date picker dialog
            @SuppressLint("SetTextI18n") DatePickerDialog picker = new DatePickerDialog(Objects.requireNonNull(getActivity()),
                    (view, year1, monthOfYear, dayOfMonth) -> loss_intim_valid_upto.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1), year, month, day);
            picker.show();
        });
        intim_puc_number = rootview.findViewById(R.id.intim_puc_number);
        intim_puc_center = rootview.findViewById(R.id.intim_puc_center);
    }

    private void initViewpart3() {
        claim_intim_police_layout = rootview.findViewById(R.id.claim_intim_police_layout);
        intim_fir_date = rootview.findViewById(R.id.intim_fir_date);
        intim_police_station = rootview.findViewById(R.id.intim_police_station);
        intim_fir_no = rootview.findViewById(R.id.intim_fir_no);
        intim_incharge_contact = rootview.findViewById(R.id.intim_incharge_contact);
        intim_fir_date.setOnClickListener(v -> datePickerTillToday(intim_fir_date));
    }

    private void initViewpart4() {
        intim_driver_name = rootview.findViewById(R.id.intim_driver_name);
        loss_intim_relation = rootview.findViewById(R.id.loss_intim_relation);
        intim_driver_age = rootview.findViewById(R.id.intim_driver_age);
        intim_driver_licence = rootview.findViewById(R.id.intim_driver_licence);
        intim_spiner_dl_type = rootview.findViewById(R.id.intim_spiner_dl_type);
        ClaimFilterModel data;
        final ArrayList<ClaimFilterModel> dataIs = new ArrayList<>();
        data = new ClaimFilterModel("0", "-Select-");
        dataIs.add(data);
        data = new ClaimFilterModel("1", "LMV-NT");
        dataIs.add(data);
        data = new ClaimFilterModel("2", "LMV-TR");
        dataIs.add(data);
        intim_spiner_dl_type.setAdapter(new AdapterLosstype(acti, dataIs));
        intim_spiner_dl_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    savedData.setDL_Type(dataIs.get(position).getName());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        intim_driver_exp = rootview.findViewById(R.id.intim_driver_exp);
        intim_driver_exp.setOnClickListener(v -> setDate(intim_driver_exp));
    }

    private class MyWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                progress_web_policy_doc.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }
    }

    private void initViewpart6() {
        intim_bank_account_holder = rootview.findViewById(R.id.intim_bank_account_holder);
        intim_bank_account_no = rootview.findViewById(R.id.intim_bank_account_no);
        intim_bank_name = rootview.findViewById(R.id.intim_bank_name);
        intim_bank_branch = rootview.findViewById(R.id.intim_bank_branch);
        intim_bank_ifsc = rootview.findViewById(R.id.intim_bank_ifsc);
    }

    private void initViewpart7() {
        intim_declear_place = rootview.findViewById(R.id.intim_declear_place);
        intim_declear_date = rootview.findViewById(R.id.intim_declear_date);
        claim_intim_declear = rootview.findViewById(R.id.claim_intim_declear);
        claim_intim_declear.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                send_intimation.setClickable(true);
                send_intimation.setBackgroundResource(R.drawable.rounded_darker_grey);
            } else {
                send_intimation.setClickable(false);
                send_intimation.setBackgroundResource(R.drawable.rounded_with_grey);
            }
            send_intimation.setPadding((int) getResources().getDimension(R.dimen._10sdp), (int) getResources().getDimension(R.dimen._10sdp), (int) getResources().getDimension(R.dimen._10sdp), (int) getResources().getDimension(R.dimen._10sdp));
        });
        intim_declear_date.setOnClickListener(v -> datePickerTillToday(intim_declear_date));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.header_part1:
                clickEventonHeadr(header_image_part1, contant_layout_1);
                break;
            case R.id.header_part2:
                clickEventonHeadr(header_image_part2, contant_layout_2);
                break;
            case R.id.header_part_claim_details:
                clickEventonHeadr(header_image_part_claim_details, content_layout_claim_details);
                break;
            case R.id.header_part5:
                clickEventonHeadr(header_image_part5, contant_layout_5);
                break;
            case R.id.header_part_claim_details_puc:
                clickEventonHeadr(header_image_part_puc_details, content_layout_claim_details_puc);
                break;
            case R.id.header_part3:
                clickEventonHeadr(header_image_part3, contant_layout_3);
                break;
            case R.id.header_part4:
                clickEventonHeadr(header_image_part4, contant_layout_4);
                break;
            case R.id.header_part6:
                clickEventonHeadr(header_image_part6, contant_layout_6);
                break;
            case R.id.header_part7:
                clickEventonHeadr(header_image_part7, contant_layout_7);
                break;
            case R.id.capture_font:
                showDialog(CAR_FONT_SIDE, getFileName(NAME_FONT_IMAGE), GALARY_CAR_FONT_SIDE);
                break;
            case R.id.capture_back:
                showDialog(CAR_BACK_SIDE, getFileName(NAME_BACK_IMAGE), GALARY_CAR_BACK_SIDE);
                break;
            case R.id.capture_left:
                showDialog(CAR_LEFT_SIDE, getFileName(NAME_LEFT_IMAGE), GALARY_CAR_LEFT_SIDE);
                break;
            case R.id.capture_right:
                showDialog(CAR_RIGHT_SIDE, getFileName(NAME_RIGHT_IMAGE), GALARY_CAR_RIGHT_SIDE);
                break;
            case R.id.capture_engine:

                showDialog(CAR_ENGINE_SIDE, getFileName(NAME_ENGINE_IMAGE), GALARY_CAR_ENGINE_SIDE);
                break;
            case R.id.capture_other:

                showDialog(CAR_OTHER_SIDE, getFileName(NAME_OTHER_IMAGE), GALARY_CAR_OTHER_SIDE);
                break;
            case R.id.claim_intim_img_vehicale_reg:
                showDialog(VEHICLE_REG_IMAGE, getFileName(NAME_VEHICLE_REG_IMAGE), GALARY_VEHICLE_REG_IMAGE);
                break;
            case R.id.claim_intim_img_vehicale_policy:
                if (data.getPolicyDocPath().equals("null") && data.getPolicyDocPath().trim().length() == 0) {
                    showDialog(VEHICLE_POLICY_IMAGE, getFileName(NAME_VEHICLE_POLICY_IMAGE), GALARY_VEHICLE_POLICY_IMAGE);
                }
                break;
            case R.id.claim_intim_img_driving_lic:
                showDialog(VEHICLE_DRIVING_LIC_IMAGE, getFileName(NAME_VEHICLE_DRIVING_LIC_IMAGE), GALARY_VEHICLE_DRIVING_LIC_IMAGE);
                break;
            case R.id.send_intimation:
                chaeckValidations();
                break;
        }
    }

    private String getFileName(String filename) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), filename);
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

    private String getFileNameCompressed(String filename) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), filename);
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

    private void handleLosstypeEvent(int position, String data) {
        if (position != 0) {
            savedData.setTypeOfLoss(data);
            if (position == 1 || position == 3) {
                claim_intim_driver_layout.setVisibility(View.VISIBLE);
                contant_layout_4.setVisibility(View.VISIBLE);
                header_image_part4.setBackgroundResource(R.drawable.drop_down2);
                loss_image_part.setVisibility(View.VISIBLE);
            } else {
                removeAccidentImage();
                claim_intim_driver_layout.setVisibility(View.GONE);
                loss_image_part.setVisibility(View.GONE);
            }
        } else {
            removeAccidentImage();
            loss_image_part.setVisibility(View.GONE);
        }
    }

    private void clickEventonHeadr(ImageView img, LinearLayout layout) {
        if (layout.getVisibility() == View.VISIBLE) {
            img.setBackgroundResource(R.drawable.drop_down2);
            layout.setVisibility(View.GONE);
        } else if (layout.getVisibility() == View.GONE) {
            img.setBackgroundResource(R.drawable.drop_down3);
            layout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_CLAIM_POLICY_DETAIL1) {
            new AppDataPushApi().callApi(getActivity(),"Claim","Claim intimation page","User visited to intimate claim");
            if (object.optString("Message").equals("Success")) {
                Log.d("check", String.valueOf(object));

                try {
                    Log.d("check", String.valueOf(object));
                    String stIsEmailclaimTruei = object.getString("IsClaimThroughEmail");
                     LogUtils.showLog("IS TRUE", stIsEmailclaimTruei);
                    if (stIsEmailclaimTruei.equals("True")) {
                        svClaimIntimLayout.setVisibility(View.GONE);
                        llClaimLayoutGone.setVisibility(View.VISIBLE);
                        llClaimLayoutGone.setOnClickListener(v -> startTrackingNow());
                    } else {
                        svClaimIntimLayout.setVisibility(View.VISIBLE);
                        llClaimLayoutGone.setVisibility(View.GONE);
                        setValuesinpart1(object);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (Tag == RequestConstants.SAVE_CLAIM_POLICY_DETAIL) {
            if (object.optString("Message").equals("Success")) {


                new AppDataPushApi().callApi(getActivity(),"Claim","Claim intimation page","Claim intimated successfully");
                dialog = new Dialog(Objects.requireNonNull(getContext()), R.style.CustomDialog);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCancelable(false);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.setContentView(R.layout.claim_intimation_popup);
                TextView claim_number = dialog.findViewById(R.id.claim_number);
                claim_number.setText(object.optString("APIClaimNo"));
                TextView callrsa = dialog.findViewById(R.id.tvcallrsa);
                callrsa.setOnClickListener(v -> {
                    dialog.dismiss();
                    FragmentsTransactionsUtils.addFragmentAgain(acti, new FragmentDashBoard(), R.id.main_frame, FragmentsTags.DASH_BOARD_FRAGMENT);
                    binder.detect(FragmentsTags.DASH_BOARD_FRAGMENT);
                });
                dialog.show();
            } else {
                Log.d("mcheck", String.valueOf(object));

                Toast.makeText(acti, "The claim was not intimated successfully. Please try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    private void getInfo() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid", pref.getUID());
            object.put("policyId", pref.getPID());
            object.put("VehicleType", VehicleType);
             LogUtils.showLog("", "");
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(acti, object, UrlConstants.GET_CLAIM_POLICY_DETAIL1, this, RequestConstants.GET_CLAIM_POLICY_DETAIL1);
        req.execute();
    }

    private void setValuesinpart1(JSONObject object) {
        data = new IntimationGetInformatonModel(
                object.optString("Address"),
                object.optString("DrivingLicenceDocPath"),
                object.optString("EmailId"),
                object.optString("InsuredName"),
                object.optString("Message"),
                object.optString("MobileNo"),
                object.optString("PolicyDocPath"),
                object.optString("PolicyNo"),
                object.optString("VehicleNo"),
                object.optString("VehicleRegDocPath")
        );
        intim_policy_no.setText(data.getPolicyNo());
        intim_vehicle_no.setText(data.getVehicleNo());
        intim_vehicle_no1.setText(data.getVehicleNo());
        intim_insured_name.setText(data.getInsuredName());
        intim_mobile_no.setText(data.getMobileNo());
        intim_email_id.setText(data.getEmailId());
        intim_address.setText(data.getAddress());

        String[] arr = new String[3];
        String[] imageName = {NAME_VEHICLE_REG_IMAGE, NAME_VEHICLE_POLICY_IMAGE, NAME_VEHICLE_DRIVING_LIC_IMAGE};

        if ((data.getVehicleRegDocPath() != null && data.getVehicleRegDocPath().trim().length() > 0 && (!data.getVehicleRegDocPath().equals("null")))) {
            claim_intim_img_vehicale_reg.setBackgroundColor(Color.WHITE);
            arr[1] = data.getVehicleRegDocPath();
            Picasso.get().load(data.getVehicleRegDocPath()).placeholder(R.drawable.loading).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).error(R.drawable.error).into(claim_intim_img_vehicale_reg);
        }
        if ((data.getDrivingLicenceDocPath() != null && data.getDrivingLicenceDocPath().trim().length() > 0 && (!data.getDrivingLicenceDocPath().equals("null")))) {
            claim_intim_img_driving_lic.setBackgroundColor(Color.WHITE);
            arr[2] = data.getDrivingLicenceDocPath();
            Picasso.get().load(data.getDrivingLicenceDocPath()).placeholder(R.drawable.loading).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).error(R.drawable.error).into(claim_intim_img_driving_lic);
        }
        if (data.getPolicyDocPath() != null && data.getPolicyDocPath().length() > 0) {
            claim_intim_img_vehicale_policy.setVisibility(View.GONE);
            webview_policy_doc_layout.setVisibility(View.VISIBLE);
            web_view_poilcy_doc_image.loadUrl(data.getPolicyDocPath());
        }
        startDownload(arr, imageName);
    }

    private void setDate(final TextView tv) {
        initDate();
        @SuppressLint("SetTextI18n") DatePickerDialog expdatePickerDialog = new DatePickerDialog(acti,R.style.DialogTheme, (view, year, month, dayOfMonth) -> tv.setText(dayOfMonth + "/" + (month + 1) + "/" + year), curYear, curMonth, curDay);
        expdatePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        expdatePickerDialog.show();
    }

    private void setTime(final TextView tv) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(acti,R.style.DialogTheme, (timePicker, selectedHour, selectedMinute) -> {
            // TODO Auto-generated method stub
            int hour1 = selectedHour;
            String timeSet;
            if (hour1 > 12) {
                hour1 -= 12;
                timeSet = "PM";
            } else if (hour1 == 0) {
                hour1 += 12;
                timeSet = "AM";
            } else if (hour1 == 12)
                timeSet = "PM";
            else
                timeSet = "AM";

            String min;
            if (selectedMinute < 10)
                min = "0" + selectedMinute;
            else
                min = String.valueOf(selectedMinute);
            String aTime = String.valueOf(hour1) + ':' + min + " " + timeSet;
            tv.setText(aTime);
        }, hour, minute, false);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    private void initDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        curYear = c.get(Calendar.YEAR);
        curMonth = c.get(Calendar.MONTH);
        curDay = c.get(Calendar.DAY_OF_MONTH);
    }

    private void viewFromGallery(int RequestCode) {
        @SuppressLint("IntentReset") Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), RequestCode);
    }

    private void captureImage(int RequestCode, String name) {
        File mImageFile = new File(name);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Uri tempURI = Uri.fromFile(mImageFile);
        Intent photoCaptureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        photoCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempURI);
        startActivityForResult(photoCaptureIntent, RequestCode);
    }


    private void showDialog(final int RequestCode, final String Filename, final int GalaryTag) {
        System.gc();
        final Dialog profilePicDialog = new Dialog(acti);
        profilePicDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        profilePicDialog.setContentView(R.layout.dialog_motor_profile_img);
        Objects.requireNonNull(profilePicDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView txt_gallery_opt, txt_camera_opt;
        txt_camera_opt = profilePicDialog.findViewById(R.id.txt_camera_opt);
        txt_gallery_opt = profilePicDialog.findViewById(R.id.txt_gallery_opt);
        txt_gallery_opt.setOnClickListener(v -> {
            viewFromGallery(GalaryTag);
            profilePicDialog.dismiss();
        });

        txt_camera_opt.setOnClickListener(v -> {
            captureImage(RequestCode, Filename);
            profilePicDialog.dismiss();
        });
        profilePicDialog.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALARY_CAR_FONT_SIDE) {
                try {
                    handleGalaryImage(capture_font, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_FONT_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_CAR_FONT_SIDE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == GALARY_CAR_BACK_SIDE) {
                try {
                    handleGalaryImage(capture_back, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_BACK_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_CAR_BACK_SIDE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == GALARY_CAR_LEFT_SIDE) {
                try {
                    handleGalaryImage(capture_left, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_LEFT_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_CAR_LEFT_SIDE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == GALARY_CAR_RIGHT_SIDE) {
                try {
                    handleGalaryImage(capture_right, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_RIGHT_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_CAR_RIGHT_SIDE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == GALARY_CAR_ENGINE_SIDE) {
                try {
                    handleGalaryImage(capture_engine, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_ENGINE_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_CAR_ENGINE_SIDE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == GALARY_CAR_OTHER_SIDE) {
                try {
                    handleGalaryImage(capture_other, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_OTHER_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_CAR_OTHER_SIDE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == GALARY_VEHICLE_REG_IMAGE) {
                try {
                    handleGalaryImage(claim_intim_img_vehicale_reg, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_VEHICLE_REG_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_VEHICLE_REG_IMAGE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == GALARY_VEHICLE_POLICY_IMAGE) {
                try {
                    handleGalaryImage(claim_intim_img_vehicale_policy, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_VEHICLE_POLICY_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_VEHICLE_POLICY_IMAGE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == GALARY_VEHICLE_DRIVING_LIC_IMAGE) {
                try {
                    handleGalaryImage(claim_intim_img_driving_lic, FileUtils.getPathFromURI(acti.getApplicationContext(), data.getData()), NAME_VEHICLE_DRIVING_LIC_IMAGE);
                } catch (Exception e) {
                    IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE = null;
                    Toast.makeText(acti, "Please select another image or use camera", Toast.LENGTH_SHORT).show();
                }
            }

            else if (requestCode == CAR_FONT_SIDE) {
                handleCameraImages(getFileName(NAME_FONT_IMAGE), capture_font, NAME_FONT_IMAGE);
            } else if (requestCode == CAR_BACK_SIDE) {
                handleCameraImages(getFileName(NAME_BACK_IMAGE), capture_back, NAME_BACK_IMAGE);
            } else if (requestCode == CAR_LEFT_SIDE) {
                handleCameraImages(getFileName(NAME_LEFT_IMAGE), capture_left, NAME_LEFT_IMAGE);
            } else if (requestCode == CAR_RIGHT_SIDE) {
                handleCameraImages(getFileName(NAME_RIGHT_IMAGE), capture_right, NAME_RIGHT_IMAGE);
            } else if (requestCode == CAR_ENGINE_SIDE) {
                handleCameraImages(getFileName(NAME_ENGINE_IMAGE), capture_engine, NAME_ENGINE_IMAGE);
            } else if (requestCode == CAR_OTHER_SIDE) {
                handleCameraImages(getFileName(NAME_OTHER_IMAGE), capture_other, NAME_OTHER_IMAGE);
            } else if (requestCode == VEHICLE_REG_IMAGE) {
                handleCameraImages(getFileName(NAME_VEHICLE_REG_IMAGE), claim_intim_img_vehicale_reg, NAME_VEHICLE_REG_IMAGE);
            } else if (requestCode == VEHICLE_POLICY_IMAGE) {
                handleCameraImages(getFileName(NAME_VEHICLE_POLICY_IMAGE), claim_intim_img_vehicale_policy, NAME_VEHICLE_POLICY_IMAGE);
            } else if (requestCode == VEHICLE_DRIVING_LIC_IMAGE) {
                handleCameraImages(getFileName(NAME_VEHICLE_DRIVING_LIC_IMAGE), claim_intim_img_driving_lic, NAME_VEHICLE_DRIVING_LIC_IMAGE);
            }
            if (requestCode == 2222) {
                startProgressNow();
            }
        } else {
            if (customDialogMAin != null)
                customDialogMAin.hideProgressBar();
        }
    }

    private void handleGalaryImage(final ImageView img, final String File, String image) {
        String f;
        f = compressNow(File);
         LogUtils.showLog("@@@@@@@@@@@@@", f);
        Bitmap myBitmap = BitmapFactory.decodeFile(f);
        if (img != null) {
            img.setBackgroundColor(Color.WHITE);
        }
        assert img != null;
        img.setImageBitmap(myBitmap);
        startSaveImage(image, myBitmap);
    }

    private void startSaveImage(String image, Bitmap myBitmap) {
        switch (image) {
            case NAME_FONT_IMAGE:
                IMAGE_NAME_CAR_FONT_SIDE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_CAR_FONT_SIDE);
                break;
            case NAME_BACK_IMAGE:
                IMAGE_NAME_CAR_BACK_SIDE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_CAR_BACK_SIDE);
                break;
            case NAME_LEFT_IMAGE:
                IMAGE_NAME_CAR_LEFT_SIDE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_CAR_LEFT_SIDE);
                break;
            case NAME_RIGHT_IMAGE:
                IMAGE_NAME_CAR_RIGHT_SIDE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_CAR_RIGHT_SIDE);
                break;
            case NAME_ENGINE_IMAGE:
                IMAGE_NAME_CAR_ENGINE_SIDE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_CAR_ENGINE_SIDE);
                break;
            case NAME_OTHER_IMAGE:
                IMAGE_NAME_CAR_OTHER_SIDE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_CAR_OTHER_SIDE);
                break;
            case NAME_VEHICLE_DRIVING_LIC_IMAGE:
                IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE);
                break;
            case NAME_VEHICLE_POLICY_IMAGE:
                IMAGE_NAME_VEHICLE_POLICY_IMAGE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_VEHICLE_POLICY_IMAGE);
                break;
            case NAME_VEHICLE_REG_IMAGE:
                IMAGE_NAME_VEHICLE_REG_IMAGE = getFileNameCompressed(image);
                saveImageToFile(myBitmap, IMAGE_NAME_VEHICLE_REG_IMAGE);
                break;
        }
    }

    private String compressNow(final String file) {
        FileUtils.deleteCache(acti);
        File compressedImage = new Compressor.Builder(acti)
                .setMaxWidth(350)
                .setMaxHeight(700)
                .setCompressFormat(Bitmap.CompressFormat.PNG)
                .build()
                .compressToFile(new File(file));
        return compressedImage.getAbsolutePath();
    }

    private void handleCameraImages(final String Path, final ImageView img, String image) {
        String f;
        f = compressNow(Path);
         LogUtils.showLog("@@@@@@@@@@@@@", f);
        Bitmap myBitmap;
        myBitmap = BitmapFactory.decodeFile(f);
        if (img != null) {
            img.setBackgroundColor(Color.WHITE);
        }
        assert img != null;
        img.setImageBitmap(myBitmap);
        startSaveImage(image, myBitmap);
    }


    private void saveImageToFile(Bitmap bmp, String filename) {
        FileOutputStream out = null;
        try {
            new File(filename).delete();
            out = new FileOutputStream(new File(filename));
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
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

    private void chaeckValidations() {
        validPart2();

    }

    private void validPart2() {
        if (loss_intim_date.getText().toString().trim().length() <= 0) {
            loss_intim_date.requestFocus();
            Toast.makeText(acti, "Please select date of accident", Toast.LENGTH_SHORT).show();
            return;
        }
        if (loss_intim_time.getText().toString().trim().length() <= 0) {
            loss_intim_time.requestFocus();
            Toast.makeText(acti, "Please select time of accident", Toast.LENGTH_SHORT).show();
            return;
        }

        if (intim_place.getText().toString().trim().length() <= 0) {
            intim_place.requestFocus();
            Toast.makeText(acti, "Please select/enter accident place", Toast.LENGTH_SHORT).show();
            return;
        }

        if (loss_intim_address.getText().toString().trim().length() <= 0) {
            loss_intim_address.requestFocus();
            Toast.makeText(acti, "Please select/enter accident location", Toast.LENGTH_SHORT).show();
            return;
        }

        if (loss_intim_city.getText().toString().trim().length() <= 0) {
            loss_intim_city.requestFocus();
            Toast.makeText(acti, "Please select/enter accident city", Toast.LENGTH_SHORT).show();
            return;
        }

        if (loss_intim_state.getText().toString().trim().length() <= 0) {
            loss_intim_state.requestFocus();
            Toast.makeText(acti, "Please select/enter accident state", Toast.LENGTH_SHORT).show();
            return;
        }

        if (intim_spiner_loss_type.getSelectedItem().toString().equals("0")) {
            intim_spiner_loss_type.requestFocus();
            Toast.makeText(acti, "Please select type of loss", Toast.LENGTH_SHORT).show();
            return;
        }

        if (intim_spiner_loss_type.getSelectedItem().toString().equals("1") || intim_spiner_loss_type.getSelectedItem().toString().equals("3")) {
            if (!validatePart4()) {
                return;
            }
        } else {
            intim_driver_name.setText("");
            loss_intim_relation.setText("");
            intim_driver_age.setText("");
            intim_driver_licence.setText("");
            intim_driver_exp.setText("");
            savedData.setDL_Type("");
        }

        if (!validatePart3(loss_intim_police_yes)) {
            return;
        }

        if (loss_intim_description.getText().toString().trim().length() <= 0) {
            loss_intim_description.requestFocus();
            Toast.makeText(acti, "Please enter description of accident", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!validateClaimDetails()) {
            return;
        }

        if (!validatePUCDetails()) {
            return;
        }

        if (!validatePart6()) {
            return;
        }

        if (!validatePart7()) {
            return;
        }

        savedData.setDateOfAccident(loss_intim_date.getText().toString());
        savedData.setTimeOfAccident(loss_intim_time.getText().toString());
        savedData.setAccidentPlace(intim_place.getText().toString());
        savedData.setAccidentLocation(loss_intim_address.getText().toString());
        savedData.setAccidentCity(loss_intim_city.getText().toString());
        savedData.setAccidentState(loss_intim_state.getText().toString());
        savedData.setDriverName(intim_driver_name.getText().toString());
        savedData.setDriverRelation(loss_intim_relation.getText().toString());
        savedData.setAge(intim_driver_age.getText().toString());
        savedData.setDrivingLicence(intim_driver_licence.getText().toString());
        savedData.setDriverExpiryDate(intim_driver_exp.getText().toString());
        savedData.setDescription(loss_intim_description.getText().toString());
        if (loss_intim_police_yes.isChecked()) {
            savedData.setIsPoliceNotify("1");
        } else {
            savedData.setIsPoliceNotify("0");
        }
        if (loss_intim_tw.isChecked()) {
            savedData.setVehicleType("Two Wheeler");
        } else {
            savedData.setVehicleType("Four Wheeler");
        }
        savedData.setClaimDate(loss_intim_claim_date.getText().toString());
        savedData.setClaimTime(loss_intim_claim_time.getText().toString());
        savedData.setClaimContactNumber(intim_contact_number.getText().toString());
        savedData.setClaimEstimate(intim_estimated_amount.getText().toString());
        savedData.setClaimRemark(loss_intim_remarks.getText().toString());
        savedData.setPUCValidUpto(loss_intim_valid_upto.getText().toString());
        savedData.setPUCNumber(intim_puc_number.getText().toString());
        savedData.setPUCCenter(intim_puc_center.getText().toString());
        savedData.setPoliceStation(intim_police_station.getText().toString());
        savedData.setFIR_Date(intim_fir_date.getText().toString());
        savedData.setFIR_No(intim_fir_no.getText().toString());
        savedData.setInchargeContactNo(intim_incharge_contact.getText().toString());
        savedData.setBankName(intim_bank_name.getText().toString());
        savedData.setAccountHolderName(intim_bank_account_holder.getText().toString());
        savedData.setAccountNo(intim_bank_account_no.getText().toString());
        savedData.setBranchName(intim_bank_branch.getText().toString());
        savedData.setIFSCCode(intim_bank_ifsc.getText().toString());
        savedData.setDeclarationDate(intim_declear_date.getText().toString());
        savedData.setDeclarationPlace(intim_declear_place.getText().toString());
        savedData.setImage1(IMAGE_NAME_CAR_FONT_SIDE);
        savedData.setImage2(IMAGE_NAME_CAR_BACK_SIDE);
        savedData.setImage3(IMAGE_NAME_CAR_LEFT_SIDE);
        savedData.setImage4(IMAGE_NAME_CAR_RIGHT_SIDE);
        savedData.setImage5(IMAGE_NAME_CAR_ENGINE_SIDE);
        savedData.setImage6(IMAGE_NAME_CAR_OTHER_SIDE);
        savedData.setVehicleRegDocPath(IMAGE_NAME_VEHICLE_REG_IMAGE);
        savedData.setPolicyDocPath(IMAGE_NAME_VEHICLE_POLICY_IMAGE);
        savedData.setDLDocPath(IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE);
        sendData();
    }

    private boolean validatePart3(RadioButton btn) {
        if (btn.isChecked()) {
            if (intim_police_station.getText().toString().trim().length() <= 0) {
                intim_police_station.requestFocus();
                Toast.makeText(acti, "Please enter police station name", Toast.LENGTH_SHORT).show();
                return false;
            }

            if (intim_fir_no.getText().toString().trim().length() <= 0) {
                intim_fir_no.requestFocus();
                Toast.makeText(acti, "Please enter F.I.R number", Toast.LENGTH_SHORT).show();
                return false;
            }

            if (intim_incharge_contact.getText().toString().trim().length() <= 0) {
                intim_incharge_contact.requestFocus();
                Toast.makeText(acti, "Please enter in charge mobile number", Toast.LENGTH_SHORT).show();
                return false;
            }

            if (intim_fir_date.getText().toString().trim().length() <= 0) {
                intim_fir_date.requestFocus();
                Toast.makeText(acti, "Please select FIR  date", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            intim_fir_date.setText("");
            intim_police_station.setText("");
            intim_fir_no.setText("");
            intim_incharge_contact.setText("");
        }
        return true;
    }

    private boolean validatePart4() {
        if (intim_driver_name.getText().toString().trim().length() <= 0) {
            intim_driver_name.requestFocus();
            Toast.makeText(acti, "Please enter driver name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (loss_intim_relation.getText().toString().trim().length() <= 0) {
            loss_intim_relation.requestFocus();
            Toast.makeText(acti, "Please enter driver relation", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_driver_age.getText().toString().trim().length() <= 0) {
            intim_driver_age.requestFocus();
            Toast.makeText(acti, "Please enter driver age", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_driver_licence.getText().toString().trim().length() <= 0) {
            intim_driver_licence.requestFocus();
            Toast.makeText(acti, "Please enter driver Lic. number", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_driver_exp.getText().toString().trim().length() <= 0) {
            intim_driver_exp.requestFocus();
            Toast.makeText(acti, "Please enter driver Lic. expiry date", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_spiner_dl_type.getSelectedItem().toString().equals("0")) {
            intim_spiner_dl_type.requestFocus();
            Toast.makeText(acti, "Please select driving lic. type", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validateClaimDetails() {
        if (loss_intim_claim_date.getText().toString().trim().length() <= 0) {
            loss_intim_claim_date.requestFocus();
            Toast.makeText(acti, "Please select date of claim", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (loss_intim_claim_time.getText().toString().trim().length() <= 0) {
            loss_intim_claim_time.requestFocus();
            Toast.makeText(acti, "Please select time of claim", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_contact_number.getText().toString().trim().length() <= 0) {
            intim_contact_number.requestFocus();
            Toast.makeText(acti, "Please enter mobile number of contact person", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_estimated_amount.getText().toString().trim().length() <= 0) {
            intim_estimated_amount.requestFocus();
            Toast.makeText(acti, "Please enter estimated amount of claim", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (loss_intim_remarks.getText().toString().trim().length() <= 0) {
            loss_intim_remarks.requestFocus();
            Toast.makeText(acti, "Please enter remarks", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validatePUCDetails() {
        if (loss_intim_valid_upto.getText().toString().trim().length() <= 0) {
            loss_intim_valid_upto.requestFocus();
            Toast.makeText(acti, "Please select expiry date of pollution document", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_puc_number.getText().toString().trim().length() <= 0) {
            intim_puc_number.requestFocus();
            Toast.makeText(acti, "Please enter pollution document number", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_puc_center.getText().toString().trim().length() <= 0) {
            intim_puc_center.requestFocus();
            Toast.makeText(acti, "Please enter pollution certificate center details", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validatePart6() {
        if (intim_bank_account_holder.getText().toString().trim().length() <= 0) {
            intim_bank_account_holder.requestFocus();
            Toast.makeText(acti, "Please enter bank a/c holder name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_bank_account_no.getText().toString().trim().length() <= 0) {
            intim_bank_account_no.requestFocus();
            Toast.makeText(acti, "Please enter bank a/c number", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_bank_name.getText().toString().trim().length() <= 0) {
            intim_bank_name.requestFocus();
            Toast.makeText(acti, "Please enter bank name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_bank_branch.getText().toString().trim().length() <= 0) {
            intim_bank_branch.requestFocus();
            Toast.makeText(acti, "Please enter bank branch name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_bank_ifsc.getText().toString().trim().length() <= 0) {
            intim_bank_ifsc.requestFocus();
            Toast.makeText(acti, "Please enter bank IFSC code", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validatePart7() {
        if (intim_declear_place.getText().toString().trim().length() <= 0) {
            intim_declear_place.requestFocus();
            Toast.makeText(acti, "Please enter declaration place", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (intim_declear_date.getText().toString().trim().length() <= 0) {
            intim_declear_date.requestFocus();
            Toast.makeText(acti, "Please select declaration date", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!claim_intim_declear.isChecked()) {
            claim_intim_declear.requestFocus();
            Toast.makeText(acti, "Please agree terms and conditions", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void sendData() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("PolicyID", pref.getPID());
            object.put("Userid", pref.getUID());
            object.put("Policy_Number", intim_policy_no.getText().toString().trim());
            object.put("Location", savedData.getAccidentLocation());
            object.put("LossNature", savedData.getTypeOfLoss());
            object.put("PUCNumber", savedData.getPUCNumber());
            object.put("PUCCentre", savedData.getPUCCenter());
            object.put("PUCValidupto", savedData.getPUCValidUpto());
            object.put("Workshopid", "1");
            object.put("ClaimIntimatedBy", "Meta");
            if (savedData.getDriverName() != null && savedData.getDriverName().trim().length() > 0)
                object.put("Driver_name", savedData.getDriverName());
            else {
                object.put("Driver_name", "");
            }
            if (savedData.getAge() != null && savedData.getAge().trim().length() > 0)
                object.put("Driver_age", savedData.getAge());
            else {
                object.put("Driver_age", "");
            }
            if (savedData.getDrivingLicence() != null && savedData.getDrivingLicence().trim().length() > 0)
                object.put("Driving_license_no", savedData.getDrivingLicence());
            else {
                object.put("Driving_license_no", "");
            }
            if (savedData.getDriverExpiryDate() != null && savedData.getDriverExpiryDate().trim().length() > 0)
                object.put("Dl_expiry_dt", savedData.getDriverExpiryDate());
            else {
                object.put("Dl_expiry_dt", "");
            }
            object.put("AccidentDate", savedData.getDateOfAccident());
            object.put("AccidentTime", savedData.getTimeOfAccident());
            object.put("AccidentPlace", savedData.getAccidentPlace());
            object.put("AccidentCity", savedData.getAccidentCity());
            object.put("AccidentState", savedData.getAccidentState());
            object.put("IntimationDate", savedData.getClaimDate());
            object.put("IntimationTime", savedData.getClaimTime());
            object.put("MobileNumber", pref.getMOBILE());
            object.put("ContactNumber", savedData.getClaimContactNumber());
            object.put("Vehicle_type", savedData.getVehicleType());
            object.put("CustomerEmailID", pref.getEmailId());
            object.put("EstimatedAmount", savedData.getClaimEstimate());
            object.put("Is_Police_Notify", savedData.getIsPoliceNotify());
            object.put("Description", savedData.getDescription());
            object.put("FIR_number", savedData.getFIR_No());
            if (savedData.getFIR_Date() != null && savedData.getFIR_Date().trim().length() > 0)
                object.put("FIR_date", savedData.getFIR_Date());
            else {
                object.put("FIR_date", "");
            }
            if (savedData.getPoliceStation() != null && savedData.getPoliceStation().trim().length() > 0)
                object.put("Police_station", savedData.getPoliceStation());
            else {
                object.put("Police_station", "");
            }
            if (savedData.getInchargeContactNo() != null && savedData.getInchargeContactNo().trim().length() > 0)
                object.put("Incharge_contact_number", savedData.getInchargeContactNo());
            else {
                object.put("Incharge_contact_number","");
            }
            if (savedData.getDL_Type() != null && savedData.getDL_Type().trim().length() > 0)
                object.put("Dl_type", savedData.getDL_Type());
            else {
                object.put("Dl_type", "");
            }
            object.put("Acc_holder_name", savedData.getAccountHolderName());
            object.put("Acc_number", savedData.getAccountNo());
            object.put("Bank_name", savedData.getBankName());
            object.put("Branch_name", savedData.getBranchName());
            object.put("IFSC_code", savedData.getIFSCCode());
            object.put("DriverRelation", savedData.getDriverRelation());
            object.put("Remarks", savedData.getClaimRemark());

            if (savedData.getImage1() != null && savedData.getImage1().trim().length() > 0) {

                if (checkisFileavailable(savedData.getImage1())) {
                    object.put("Image1", cgetBase64(savedData.getImage1()));
                    object.put("FileExt1", savedData.getExtension());

                } else {
                    object.put("Image1", "null");
                    object.put("FileExt1", "0");
                }
            } else {
                object.put("Image1", "null");
                object.put("FileExt1", "0");
            }

            if (savedData.getImage2() != null && savedData.getImage2().trim().length() > 0) {
                if (checkisFileavailable(savedData.getImage2())) {
                    object.put("Image2", cgetBase64(savedData.getImage2()));
                    object.put("FileExt2", savedData.getExtension());
                } else {
                    object.put("Image2", "null");
                    object.put("FileExt2", "0");
                }
            } else {
                object.put("Image2", "null");
                object.put("FileExt2", "0");
            }

            if (savedData.getImage3() != null && savedData.getImage3().trim().length() > 0) {
                if (checkisFileavailable(savedData.getImage3())) {
                    object.put("Image3", cgetBase64(savedData.getImage3()));
                    object.put("FileExt3", savedData.getExtension());
                } else {
                    object.put("Image3", "null");
                    object.put("FileExt3", "0");
                }
            } else {
                object.put("Image3", "null");
                object.put("FileExt3", "0");
            }

            if (savedData.getImage4() != null && savedData.getImage4().trim().length() > 0) {
                if (checkisFileavailable(savedData.getImage4())) {
                    object.put("Image4", cgetBase64(savedData.getImage4()));
                    object.put("FileExt4", savedData.getExtension());
                } else {
                    object.put("Image4", "null");
                    object.put("FileExt4", "0");
                }
            } else {
                object.put("Image4", "null");
                object.put("FileExt4", "0");
            }

            if (savedData.getImage5() != null && savedData.getImage5().trim().length() > 0) {
                if (checkisFileavailable(savedData.getImage5())) {
                    object.put("Image5", cgetBase64(savedData.getImage5()));
                    object.put("FileExt5", savedData.getExtension());
                } else {
                    object.put("Image5", "null");
                    object.put("FileExt5", "0");
                }
            } else {
                object.put("Image5", "null");
                object.put("FileExt5", "0");
            }

            if (savedData.getImage6() != null && savedData.getImage6().trim().length() > 0) {
                if (checkisFileavailable(savedData.getImage6())) {
                    object.put("Image6", cgetBase64(savedData.getImage6()));
                    object.put("FileExt6", savedData.getExtension());
                } else {
                    object.put("Image6", "null");
                    object.put("FileExt6", "0");
                }
            } else {
                object.put("Image6", "null");
                object.put("FileExt6", "0");
            }
            if (savedData.getVehicleRegDocPath() != null && savedData.getVehicleRegDocPath().trim().length() > 0) {
                if (checkisFileavailable(savedData.getVehicleRegDocPath())) {
                    String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(savedData.getVehicleRegDocPath());
                    String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
                    assert mimetype != null;
                    if (mimetype.equals("application/pdf")) {
                        object.put("Registration_docImage", cgetBase64PDF(savedData.getVehicleRegDocPath()));
                        object.put("Registration_docExt", ".pdf");
                    } else {
                        object.put("Registration_docImage", cgetBase64(savedData.getVehicleRegDocPath()));
                        object.put("Registration_docExt", savedData.getExtension());
                    }
                } else {
                    object.put("Registration_docImage", "null");
                    object.put("Registration_docExt", "0");
                }
            } else {
                object.put("Registration_docImage", "null");
                object.put("Registration_docExt", "0");
            }
            if (savedData.getPolicyDocPath() != null && savedData.getPolicyDocPath().trim().length() > 0) {
                if (checkisFileavailable(savedData.getPolicyDocPath())) {
                    object.put("Policy_doc_pathImage", cgetBase64(savedData.getPolicyDocPath()));
                    object.put("Policy_doc_pathExt", savedData.getExtension());
                } else {
                    object.put("Policy_doc_pathImage", "null");
                    object.put("Policy_doc_pathExt", "0");
                }
            } else {
                object.put("Policy_doc_pathImage", "null");
                object.put("Policy_doc_pathExt", "0");
            }
            if (savedData.getDLDocPath() != null && savedData.getDLDocPath().trim().length() > 0) {
                if (checkisFileavailable(savedData.getDLDocPath())) {
                    object.put("Dl_doc_pathImage", cgetBase64(savedData.getDLDocPath()));
                    object.put("Dl_doc_pathExt", savedData.getExtension());
                } else {
                    object.put("Dl_doc_pathImage", "null");
                    object.put("Dl_doc_pathExt", "0");
                }
            } else {
                object.put("Dl_doc_pathImage", "null");
                object.put("Dl_doc_pathExt", "0");
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(acti, object, UrlConstants.SAVE_CLAIM_POLICY_DETAIL, this, RequestConstants.SAVE_CLAIM_POLICY_DETAIL);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String cgetBase64(String file) {
        String ImgString = null;
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeFile(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bao);
        byte[] ba = bao.toByteArray();
        try {
            ImgString = Base64.encodeToString(ba, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ImgString;
    }

    private String cgetBase64PDF(String file) {
        String str = null;
        RandomAccessFile f;
        byte[] ba = null;
        try {
            f = new RandomAccessFile(file, "r");
            ba = new byte[(int) f.length()];
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            str = Base64.encodeToString(ba, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private boolean checkisFileavailable(String filePath) {
        File file = new File(filePath);
        return file.length() > 0;
    }

    private void removeAccidentImage() {
        capture_font.setImageBitmap(null);
        capture_font.setBackgroundResource(R.drawable.camera_icon2);
        capture_back.setImageBitmap(null);
        capture_back.setBackgroundResource(R.drawable.camera_icon2);
        capture_left.setImageBitmap(null);
        capture_left.setBackgroundResource(R.drawable.camera_icon2);
        capture_right.setImageBitmap(null);
        capture_right.setBackgroundResource(R.drawable.camera_icon2);
        capture_engine.setImageBitmap(null);
        capture_engine.setBackgroundResource(R.drawable.camera_icon2);
        capture_other.setImageBitmap(null);
        capture_other.setBackgroundResource(R.drawable.camera_icon2);

        deleteFile(IMAGE_NAME_CAR_FONT_SIDE);
        deleteFile(IMAGE_NAME_CAR_BACK_SIDE);
        deleteFile(IMAGE_NAME_CAR_LEFT_SIDE);
        deleteFile(IMAGE_NAME_CAR_RIGHT_SIDE);
        deleteFile(IMAGE_NAME_CAR_ENGINE_SIDE);
        deleteFile(IMAGE_NAME_CAR_OTHER_SIDE);

        IMAGE_NAME_CAR_FONT_SIDE = null;
        IMAGE_NAME_CAR_BACK_SIDE = null;
        IMAGE_NAME_CAR_LEFT_SIDE = null;
        IMAGE_NAME_CAR_RIGHT_SIDE = null;
        IMAGE_NAME_CAR_ENGINE_SIDE = null;
        IMAGE_NAME_CAR_OTHER_SIDE = null;
    }

    private void deleteFile(String path) {
        if (path != null) {
            File file = new File(path);
            file.delete();
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(acti)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            mLastLocation = location;
        }
    };

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest().create();
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, listener);
        checkResolutionAndProceed();
    }

    private void checkResolutionAndProceed() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);
        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(result1 -> {
            Status status = result1.getStatus();
            switch (status.getStatusCode()) {
                case LocationSettingsStatusCodes.SUCCESS:
                    startProgressNow();
                    break;
                case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                    try {
                        startIntentSenderForResult(status.getResolution().getIntentSender(), 2222, null, 0, 0, 0, null);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        });
    }

    private void startProgressNow() {
        if (ActivityCompat.checkSelfPermission(acti, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(acti, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, listener);
        startServices();
    }


    private void startServices() {
        acti.runOnUiThread(() -> {
            if (mLastLocation != null) {
                getAddressNow();
            } else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buildGoogleApiClient();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void getAddressNow() {
        acti.runOnUiThread(() -> {
            Geocoder geocoder;
            geocoder = new Geocoder(acti, Locale.getDefault());
            try {
                myAddress = geocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
            } catch (IOException e) {
                showDialogForReboot();

                e.printStackTrace();
            }
            if (myAddress != null) {
                loss_intim_address.setText(myAddress.get(0).getAddressLine(0) + "," + myAddress.get(0).getLocality() + "," + myAddress.get(0).getAdminArea());
            }
        });
        customDialogMAin.hideProgressBar();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void getImageBitmap(Bitmap bitmap, int Tag) {
        if (Tag == VEHICLE_REG_IMAGE_TAG) {
            saveImageInFIle(NAME_VEHICLE_REG_IMAGE, bitmap);
        } else if (Tag == VEHICLE_POLICY_IMAGE_TAG) {
            saveImageInFIle(NAME_VEHICLE_POLICY_IMAGE, bitmap);
        } else if (Tag == VEHICLE_DRIVING_LIC_IMAGE_TAG) {
            saveImageInFIle(NAME_VEHICLE_DRIVING_LIC_IMAGE, bitmap);
        }
    }

    @Override
    public void getImageBitmapError(VolleyError error, int Tag) {
        if (Tag == VEHICLE_REG_IMAGE_TAG) {
            IMAGE_NAME_VEHICLE_REG_IMAGE = null;
        } else if (Tag == VEHICLE_POLICY_IMAGE_TAG) {
            IMAGE_NAME_VEHICLE_POLICY_IMAGE = null;
        } else if (Tag == VEHICLE_DRIVING_LIC_IMAGE_TAG) {
            IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE = null;
        }
    }

    private void saveImageInFIle(String image, Bitmap myBitmap) {
        startSaveImage(image, myBitmap);
    }


    private void datePickerTillToday(final TextView tv) {
        initDate();
        DatePickerDialog expdatePickerDialog = new DatePickerDialog(acti,R.style.DialogTheme, (view, year, month, dayOfMonth) -> tv.setText(dayOfMonth + "/" + (month + 1) + "/" + year), curYear, curMonth, curDay);
        expdatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        expdatePickerDialog.show();
    }

    private void startTrackingNow() {
        MainActivity act = acti;
       // FragmentsTransactionsUtils.replaceFragmentKeepPrevious(acti, new FragmentTrackingStatus(), R.id.main_frame, FragmentsTags.FRAGMENT_TRACKING_STATUS);
       // act.detect(FragmentsTags.FRAGMENT_TRACKING_STATUS);
    }

    private void startDownload(String[] s, String[] imgPath) {
        DownloadFileAsync dloadFAsync = new DownloadFileAsync(s);
        customDialog = CustomProgressDialog.getInstance(getActivity());
        customDialog.showProgressBar();
        dloadFAsync.execute(imgPath);
    }

    class DownloadFileAsync extends AsyncTask<String, String, String> {
        int current = 0;
        String[] paths;
        String fpath;
        boolean show = false;

        public DownloadFileAsync(String[] paths) {
            super();
            this.paths = paths;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... aurl) {
            int rows = aurl.length;
            while (current < rows) {
                int count;
                try {
                    if (this.paths[current] != null) {
                         LogUtils.showLog("@@@@@@@@@@@$$$$", "" + this.paths[current]);
                        if (current == 0) {
                            IMAGE_NAME_VEHICLE_REG_IMAGE = fpath = getFileNameCompressed(aurl[current]);
                        } else if (current == 1) {
                            IMAGE_NAME_VEHICLE_POLICY_IMAGE = fpath = getFileNameCompressed(aurl[current]);
                        } else if (current == 2) {
                            IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE = fpath = getFileNameCompressed(aurl[current]);
                        }
                        URL url = new URL(this.paths[current]);
                        URLConnection conexion = url.openConnection();
                        conexion.connect();
                        int lenghtOfFile = conexion.getContentLength();
                        InputStream input = new BufferedInputStream(url.openStream(), 512);
                        OutputStream output = new FileOutputStream(fpath);
                        byte[] data = new byte[512];
                        long total = 0;
                        while ((count = input.read(data)) != -1) {
                            total += count;
                            publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                            output.write(data, 0, count);
                        }
                        show = true;
                        output.flush();
                        output.close();
                        input.close();

                    }
                } catch (Exception e) {
                    fpath = null;
                    if (current == 0) {
                        IMAGE_NAME_VEHICLE_REG_IMAGE = null;
                    } else if (current == 1) {
                        IMAGE_NAME_VEHICLE_POLICY_IMAGE = null;
                    } else if (current == 2) {
                        IMAGE_NAME_VEHICLE_DRIVING_LIC_IMAGE = null;
                         LogUtils.showLog("@@@@@@@@@@@@@", "breaked");
                        e.printStackTrace();
                        break;
                    }
                    e.printStackTrace();
                }
                current++;
            }

            return null;
        }

        @Override
        protected void onPostExecute(String unused) {
             LogUtils.showLog("@@@@@@@@@@@", "Post");
            customDialog.hideProgressBar();
        }
    }

    private void showDialogForReboot() {
        AlertDialog.Builder builder = new AlertDialog.Builder(acti);
        builder.setTitle("Reboot Pending").setMessage("GPS needs a device reboot or type location mannually")
                .setNegativeButton("OK", (dialog, which) -> dialog.cancel())
                .show();
    }
}