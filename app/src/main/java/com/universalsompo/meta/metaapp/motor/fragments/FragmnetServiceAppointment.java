package com.universalsompo.meta.metaapp.motor.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.adapters.AccessoriesAdapter;
import com.universalsompo.meta.metaapp.motor.adapters.AdapterFilter;
import com.universalsompo.meta.metaapp.motor.adapters.VendorListAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.RecyclerViewItemClickLisner;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
import com.universalsompo.meta.metaapp.motor.models.RSAModel;
import com.universalsompo.meta.metaapp.motor.models.TrackingStatusModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
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
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.GET_MULTIBRAND_LIST;

public class FragmnetServiceAppointment extends Fragment implements AdapterView.OnItemClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, View.OnClickListener, ResponseListener {
    private View v;
    private LinearLayout haveRsa_llayout;
    private LinearLayout call_llayout;
    private RelativeLayout list_llayout;
    private LinearLayout vendor_layout;
    private LinearLayout vendor_grid_layout;
    private LinearLayout header_layout;
    private LinearLayout main_llayout;
    private RelativeLayout grid_relative_layout;
    private RelativeLayout vendor_detail_layout;
    private ListView car_list;
    private ArrayList<TrackingStatusModel> arrayCarListModel;
    private List<String> list;
    private static String policy_id;
    private static String vehicle_type;
    private TextView rsa_oem;
    private TextView rsa_multibrand;
    private String oem_id = "";
    private TextView rc_no_txt;
    private TextView txt_tollfree_no;
    private ArrayList<RSAModel> vendorModelArrayList;
    private RecyclerView recyclerView;
    private GridView gridView;
    private AccessoriesAdapter accessoriesAdapter;
    private VendorListAdapter vendorListAdapter;
    private ImageView grid_img;
    private TextView vname_txt;
    private TextView vdetatil_txt;
    private TextView vdiscount_txt;
    private TextView vcouponcode_txt;
    private ImageView vimg_img;
    private String urlBender;
    private String couponCodestr;
    private String contactNo;
    private static String viewPageTag;
    private static final String VENDOR_LIST_TAG = "vandor_list";
    private static final String VENDOR_GRID_TAG = "vandor_grid";
    private static final String CALL_PAGE = "call_page";
    private static final String CAR_LIST = "car_list";
    private static final String HAVE_SERVICE = "have_service";
    private static final String VENDOR_DETAIL_TAG = "vendor detail";
    private static int CAR_LIST_FLAG = 0;
    private static int GRID_FLAG = 0;
    private static int CALL_FLAG = 0;
    private Dialog alert_dialog;
    private static int selectedBenderPosition;
    private MySharedPreference pref;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    private CustomProgressDialog customDialogMAin;
    private TextView loc_text;
    private String cityText;
    private String myCurrentCity;
    private String vendorIdforDetails;
    private boolean isAccending = false;
    private ImageView filter_image;
    private boolean is_discount_same;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_service_appointment, null);
        ((MainActivity) Objects.requireNonNull(Objects.requireNonNull(getActivity()))).remove_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        init();
        callApi(RequestConstants.GET_LIST_OF_CARS_FOR_SERVICE1);
        customDialogMAin = CustomProgressDialog.getInstance(getActivity());
        return v;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        main_llayout = v.findViewById(R.id.main_llayout);
        list_llayout = v.findViewById(R.id.list_llayout);
        haveRsa_llayout = v.findViewById(R.id.haveRsa_llayout);
        call_llayout = v.findViewById(R.id.call_layout);
        vendor_layout = v.findViewById(R.id.vendor_layout);
        vendor_grid_layout = v.findViewById(R.id.grid_linearlayout);
        header_layout = v.findViewById(R.id.header_layout);
        grid_relative_layout = v.findViewById(R.id.grid_relative_layout);
        vendor_detail_layout = v.findViewById(R.id.vendor_detail_layout);
        list_llayout.setVisibility(View.GONE);
        vendor_detail_layout.setVisibility(View.GONE);
        car_list = v.findViewById(R.id.car_list);
        arrayCarListModel = new ArrayList<>();
        list = new ArrayList<>();
        car_list.setOnItemClickListener(this);
        rsa_multibrand = v.findViewById(R.id.txt_no);
        rsa_oem = v.findViewById(R.id.txt_yes);
        TextView have_rsa_txt = v.findViewById(R.id.rsa_have_txt);
        rc_no_txt = v.findViewById(R.id.rsa_rc_txt);
        have_rsa_txt.setText("Get service done by");
        rsa_multibrand.setOnClickListener(this);
        rsa_oem.setOnClickListener(this);
        txt_tollfree_no = v.findViewById(R.id.txt_tollfree_no);
        TextView txt_cancel = v.findViewById(R.id.txt_edit);
        TextView txt_call = v.findViewById(R.id.txt_call);
        txt_cancel.setText("Cancel");
        txt_cancel.setOnClickListener(this);
        txt_call.setOnClickListener(this);
        LinearLayout list_grid_layout = v.findViewById(R.id.grid_layout);
        LinearLayout filter_layout = v.findViewById(R.id.filter_layout);
        LinearLayout loc_layout = v.findViewById(R.id.loc_layout);
        loc_text = v.findViewById(R.id.loc_text);
        grid_img = v.findViewById(R.id.grid_img);
        filter_image = v.findViewById(R.id.filter_image);
        list_grid_layout.setOnClickListener(this);
        filter_layout.setOnClickListener(this);
        loc_layout.setOnClickListener(this);
        filter_image.setVisibility(View.VISIBLE);
        recyclerView = v.findViewById(R.id.recycler_view);
        TextView no_data = v.findViewById(R.id.no_data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        no_data.setVisibility(View.GONE);
        gridView = v.findViewById(R.id.grdv_accessories);

        recyclerView.addOnItemTouchListener(new RecyclerViewItemClickLisner(getActivity(), (view, position) -> {
            vendorIdforDetails = vendorModelArrayList.get(position).getVendor_id();
            selectedBenderPosition = position;
            callApi(RequestConstants.GET_SERVICE_BENDER_DETAILS);

        }));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            vendorIdforDetails = vendorModelArrayList.get(position).getVendor_id();
            selectedBenderPosition = position;
            GRID_FLAG = 1;
            callApi(RequestConstants.GET_SERVICE_BENDER_DETAILS);
        });

        vname_txt = v.findViewById(R.id.vname_txt);
        vdetatil_txt = v.findViewById(R.id.vdetatil_txt);
        vdiscount_txt = v.findViewById(R.id.vdiscount_txt);
        vcouponcode_txt = v.findViewById(R.id.vcouponcode_txt);
        TextView copy_coupon_code_txt = v.findViewById(R.id.copy_coupon_code_txt);
        vimg_img = v.findViewById(R.id.vimg_img);
        TextView book_txt = v.findViewById(R.id.book_txt);
        copy_coupon_code_txt.setOnClickListener(this);
        book_txt.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.car_list) {
            list_llayout.setVisibility(View.GONE);
            haveRsa_llayout.setVisibility(View.VISIBLE);
            viewPageTag = HAVE_SERVICE;
            policy_id = arrayCarListModel.get(position).getPolicy_no();
            vehicle_type = arrayCarListModel.get(position).getVehicleType();
            if (!policy_id.equalsIgnoreCase(""))
                callApi(RequestConstants.GET_OEM_MULTIBRAND_1);
            rc_no_txt.setText(arrayCarListModel.get(position).getReg_no());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_yes:
                if (!oem_id.equalsIgnoreCase(""))
                    callApi(RequestConstants.GET_OEM_DETAILS);
                break;
            case R.id.txt_no:
                callApi(RequestConstants.GET_SERVICE_PROVIDER_CITY);

                initLocation();
                break;
            case R.id.txt_call:
                CALL_FLAG = 1;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + contactNo));
                startActivity(intent);
                break;
            case R.id.txt_edit:
                call_llayout.setVisibility(View.GONE);
                haveRsa_llayout.setVisibility(View.VISIBLE);
                viewPageTag = HAVE_SERVICE;
                break;
            case R.id.grid_layout:
                if (viewPageTag == null)
                    return;
                if (viewPageTag.equals(VENDOR_LIST_TAG)) {
                    vendor_grid_layout.setVisibility(View.VISIBLE);
                    if (vendor_layout.isShown())
                        vendor_layout.setVisibility(View.GONE);
                    accessoriesAdapter = new AccessoriesAdapter(getActivity(), vendorModelArrayList);
                    gridView.setAdapter(accessoriesAdapter);
                    viewPageTag = VENDOR_GRID_TAG;
                    grid_img.setImageResource(R.drawable.horizontal_lines);
                } else {
                    vendorListAdapter = new VendorListAdapter(getActivity(), vendorModelArrayList);
                    recyclerView.setAdapter(vendorListAdapter);
                    vendor_layout.setVisibility(View.VISIBLE);
                    if (vendor_grid_layout.isShown())
                        vendor_grid_layout.setVisibility(View.GONE);
                    viewPageTag = VENDOR_LIST_TAG;
                    grid_img.setImageResource(R.drawable.grid);
                }
                grid_relative_layout.setBackgroundResource(R.color.white);

                break;
            case R.id.loc_layout:
                callApi(RequestConstants.GET_SERVICE_PROVIDER_CITY);
                break;
            case R.id.filter_layout:
                if (!is_discount_same) {
                    if (isAccending) {
                        getDecendingList();
                    } else
                        getAccendingList();
                } else
                    Toast.makeText(getActivity(), "Sorting is not possible, since all discounts are same", Toast.LENGTH_SHORT).show();
                break;
            case R.id.copy_coupon_code_txt:
                ClipboardManager clipboard = (ClipboardManager) Objects.requireNonNull(getActivity()).getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Code", couponCodestr);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getActivity(), "Coupon code copied", Toast.LENGTH_LONG).show();
                break;
            case R.id.book_txt:
                Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                in.putExtra("PolicyNo", "");
                in.putExtra("VehicleType", vehicle_type);
                in.putExtra("vendor_id", vendorModelArrayList.get(selectedBenderPosition).getVendor_id());
                in.putExtra("ISFROMPDFFULL", "");
                in.putExtra("Url", urlBender);
                in.putExtra("fargmentTag", "Service Apppointment");
                in.putExtra("type", "");
                Objects.requireNonNull(getActivity()).startActivity(in);
                break;
        }
    }

    private void callApi(int requestId) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            if (requestId == RequestConstants.GET_LIST_OF_CARS_FOR_SERVICE1) {
                object.put(RequestConstants.USER_ID, pref.getUID());
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_LIST_OF_CARS_FOR_SERVICE1, this, RequestConstants.GET_LIST_OF_CARS_FOR_SERVICE1);
                req.execute();
            } else if (requestId == RequestConstants.GET_OEM_MULTIBRAND_1) {
                object.put("PolicyId", policy_id);
                object.put(RequestConstants.USER_ID, pref.getUID());
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_OEM_MULTIBRAND_1, this, RequestConstants.GET_OEM_MULTIBRAND_1);
                req.execute();
            } else if (requestId == RequestConstants.GET_OEM_DETAILS) {
                object.put("MakeId", oem_id);
                object.put(RequestConstants.USER_ID, pref.getUID());
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_OEM_DETAILS, this, RequestConstants.GET_OEM_DETAILS);
                req.execute();
            } else if (requestId == GET_MULTIBRAND_LIST) {
                object.put(RequestConstants.USER_ID, pref.getUID());
                object.put("City", cityText);
                object.put("VendorType", "ServiceAndAppointment");
                object.put("VehicleType", vehicle_type);
                object.put(RequestConstants.USER_ID, pref.getUID());
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_MULTIBRAND_LIST, this, GET_MULTIBRAND_LIST);
                req.execute();
            } else if (requestId == RequestConstants.GET_SERVICE_BENDER_DETAILS) {
                object.put(RequestConstants.USER_ID, pref.getUID());
                object.put("VendorId", vendorIdforDetails);
                object.put("VehicleType", vehicle_type);
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_SERVICE_BENDER_DETAILS, this, RequestConstants.GET_SERVICE_BENDER_DETAILS);
                req.execute();
            } else if (requestId == RequestConstants.GET_VISITOR_COUNT) {
                object.put("VendorId", vendorModelArrayList.get(selectedBenderPosition).getVendor_id());
                object.put("VehicleType", vehicle_type);
                object.put("Uid", pref.getUID());
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_VISITOR_COUNT, this, RequestConstants.GET_VISITOR_COUNT);
                req.execute();
            } else if (requestId == RequestConstants.GET_SERVICE_PROVIDER_CITY) {
                object.put(RequestConstants.USER_ID, pref.getUID());
                object.put("VendorType", "ServiceAndAppointment");
                ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_SERVICE_PROVIDER_CITY, this, RequestConstants.GET_SERVICE_PROVIDER_CITY);
                req.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_LIST_OF_CARS_FOR_SERVICE1) {
            if (object.optString("Status").equalsIgnoreCase("true")) {
                try {
                    JSONArray jsonArray = object.getJSONArray("RegistrationNoDetails");
                    int RegNoArrayLength = jsonArray.length();
                    JSONObject json;
                    TrackingStatusModel statusModel;
                    if (RegNoArrayLength > 1) {
                        for (int i = 0; i < RegNoArrayLength; i++) {
                            json = jsonArray.getJSONObject(i);
                            statusModel = new TrackingStatusModel(json.optString("PolicyId"), json.optString("RegNo"), "0", json.optString("VehicleType"));
                            arrayCarListModel.add(statusModel);
                            list.add(json.optString("RegNo"));
                            list_llayout.setVisibility(View.VISIBLE);
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.vendor_list_item, list);
                        car_list.setAdapter(adapter);
                        viewPageTag = CAR_LIST;
                        CAR_LIST_FLAG = 1;
                    } else {
                        json = jsonArray.getJSONObject(0);
                        policy_id = json.optString("PolicyId");
                        if (!policy_id.equalsIgnoreCase("")) {
                            list_llayout.setVisibility(View.GONE);
                            haveRsa_llayout.setVisibility(View.VISIBLE);
                            rc_no_txt.setText(json.optString("RegNo"));
                            vehicle_type = json.optString("VehicleType");
                            callApi(RequestConstants.GET_OEM_MULTIBRAND_1);
                            viewPageTag = HAVE_SERVICE;
                            CAR_LIST_FLAG = 0;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                addPolicy.showAlertDialogForPolicy(getActivity(), "There is no policy for Service Appointment");
            }
        } else if (Tag == RequestConstants.GET_OEM_MULTIBRAND_1) {
            if (object.optString("Status").equalsIgnoreCase("true")) {
                rsa_multibrand.setText(object.optString("Multibrand"));
                rsa_oem.setText(object.optString("Make"));
                oem_id = object.optString("MakeId");
            }
        } else if (Tag == RequestConstants.GET_OEM_DETAILS) {
            if (object.optString("Status").equalsIgnoreCase("true")) {
                if (object.optString("URLStatus").equals("True") || object.optString("TollFreeNoStatus").equals("True")) {
                    main_llayout.setBackgroundResource(R.drawable.road_side_assistance);
                    vendorListVisiblityGone();
                    if (object.optString("URLStatus").equals("True")) {
                        Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                        in.putExtra("PolicyNo", "");
                        in.putExtra("Url", object.optString("URL"));
                        in.putExtra("fargmentTag", "Renew Policy");
                        in.putExtra("ISFROMPDFFULL", "");
                        in.putExtra("VehicleType", "");
                        in.putExtra("vendor_id", "");
                        in.putExtra("type", "");
                        Objects.requireNonNull(getActivity()).startActivity(in);
                    } else if (object.optString("TollFreeNoStatus").equals("True")) {
                        contactNo = object.optString("TollFreeNo");
                        txt_tollfree_no.setText(contactNo);
                        call_llayout.setVisibility(View.VISIBLE);
                        viewPageTag = CALL_PAGE;
                        haveRsa_llayout.setVisibility(View.GONE);
                    }
                } else
                    showAlertDialog("Brand");
            } else
                showAlertDialog("Brand");
        } else if (Tag == GET_MULTIBRAND_LIST) {
            if (object.optString("Status").equalsIgnoreCase("true")) {
                haveRsa_llayout.setVisibility(View.GONE);
                vendorModelArrayList = new ArrayList<>();
                try {
                    JSONArray jsonArray = object.getJSONArray("SAVendorDetails");
                    JSONObject json;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        json = jsonArray.getJSONObject(i);
                        String imgPath = json.optString("IconPath");
                        if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in//AppCMS" + abc[1];
                        }
                        RSAModel model = new RSAModel(json.optString("VendorId"), json.optString("VendorName"), json.optString("Discount"), json.optString("Description"), imgPath);
                        vendorModelArrayList.add(model);
                    }
                    if (vendor_grid_layout.isShown()) {
                        viewPageTag = VENDOR_GRID_TAG;
                        accessoriesAdapter = new AccessoriesAdapter(getActivity(), vendorModelArrayList);
                        gridView.setAdapter(accessoriesAdapter);
                    }
                    if (vendor_layout.isShown()) {
                        viewPageTag = VENDOR_LIST_TAG;
                        vendorListAdapter = new VendorListAdapter(getActivity(), vendorModelArrayList);
                        recyclerView.setAdapter(vendorListAdapter);
                    }
                    if (!vendor_layout.isShown() && !(vendor_grid_layout.isShown())) {
                        viewPageTag = VENDOR_LIST_TAG;
                        vendorListAdapter = new VendorListAdapter(getActivity(), vendorModelArrayList);
                        recyclerView.setAdapter(vendorListAdapter);
                        grid_relative_layout.setBackgroundResource(R.color.white);
                        vendor_layout.setVisibility(View.VISIBLE);
                        header_layout.setVisibility(View.VISIBLE);
                        filter_image.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.bi_directional_icon));
                        is_discount_same = isDiscountSame();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                showAlertDialog("Multibrand");
            }
        } else if (Tag == RequestConstants.GET_SERVICE_BENDER_DETAILS) {
            if (object.optString("Status").equalsIgnoreCase("true")) {
                urlBender = object.optString("URL");
                couponCodestr = object.optString("CoupanCode");
                String tollFree = object.optString("TollFreeNo");
                if (!urlBender.equalsIgnoreCase("")) {
                    if (!couponCodestr.equalsIgnoreCase("")) {
                        vname_txt.setText(vendorModelArrayList.get(selectedBenderPosition).getVendor_name());
                        vdiscount_txt.setText(vendorModelArrayList.get(selectedBenderPosition).getVendor_discount());
                        vdetatil_txt.setText(vendorModelArrayList.get(selectedBenderPosition).getOffers());
                        Picasso.get().load(vendorModelArrayList.get(selectedBenderPosition).getVendor_img()).into(vimg_img);
                        vcouponcode_txt.setText(couponCodestr);
                        main_llayout.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.background));
                        vendorListVisiblityGone();
                        vendor_detail_layout.setVisibility(View.VISIBLE);
                        viewPageTag = VENDOR_DETAIL_TAG;
                    } else {
                        Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                        in.putExtra("PolicyNo", "");
                        in.putExtra("Url", urlBender);
                        in.putExtra("fargmentTag", "Service Appointment");
                        in.putExtra("ISFROMPDFFULL", "");
                        in.putExtra("VehicleType", "");
                        in.putExtra("vendor_id", "");
                        in.putExtra("type", "");
                        Objects.requireNonNull(getActivity()).startActivity(in);
                    }
                } else {
                    contactNo = tollFree;
                    txt_tollfree_no.setText(contactNo);
                    vendorListVisiblityGone();
                    main_llayout.setBackgroundResource(R.drawable.road_side_assistance);
                    call_llayout.setVisibility(View.VISIBLE);
                    viewPageTag = CALL_PAGE;
                }
            }
        } else if (Tag == RequestConstants.GET_VISITOR_COUNT) {
            LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
        } else if (Tag == RequestConstants.GET_SERVICE_PROVIDER_CITY) {
            ArrayList cityList = new ArrayList<ClaimFilterModel>();
            if (object.optString("Status").equalsIgnoreCase("true")) {
                LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
                ClaimFilterModel model = new ClaimFilterModel("-1", "Use Current Location");
                cityList.add(model);
                try {
                    JSONArray jsonArray = object.getJSONArray("CityDetails");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject json = jsonArray.getJSONObject(i);
                        model = new ClaimFilterModel(json.optString("CityId"), json.optString("CityName"));
                        cityList.add(model);
                    }
                    popUpForCityList(cityList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isDiscountSame() {
        boolean checkDiscountStr = false;
        for (int i = 0; i < vendorModelArrayList.size() - 1; i++) {
            if (vendorModelArrayList.get(0).getVendor_discount().equals(vendorModelArrayList.get(i + 1).getVendor_discount())) {
                checkDiscountStr = true;
            } else {
                checkDiscountStr = false;
                return checkDiscountStr;
            }
        }
        return checkDiscountStr;
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        Log.e("this is working","not called");
    }

    private void vendorListVisiblityGone() {
        if (vendor_layout.isShown())
            vendor_layout.setVisibility(View.GONE);
        if (vendor_grid_layout.isShown())
            vendor_grid_layout.setVisibility(View.GONE);
        if (header_layout.isShown())
            header_layout.setVisibility(View.GONE);
    }

    private void initLocation() {
        customDialogMAin.showProgressBar();
        buildGoogleApiClient();
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(Objects.requireNonNull(getActivity()))
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    private LocationListener listener = new LocationListener() {
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
        if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getActivity()), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, listener);
        startServices();
    }

    private void startServices() {
        Objects.requireNonNull(getActivity()).runOnUiThread(() -> {
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

    private void getAddressNow() {
        Objects.requireNonNull(getActivity()).runOnUiThread(() -> {
            Geocoder geocoder;
            geocoder = new Geocoder(getActivity(), Locale.getDefault());
            List<Address> myAddress = null;
            try {
                myAddress = geocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (myAddress != null) {
                cityText = myAddress.get(0).getLocality();
                myCurrentCity = myAddress.get(0).getLocality();
                loc_text.setText(myAddress.get(0).getLocality());
                callApi(GET_MULTIBRAND_LIST);
            }
        });
        customDialogMAin.hideProgressBar();
    }

    @Override
    public void onConnectionSuspended(int i) { }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) { }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2222) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    startProgressNow();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(getActivity(), "Enabling GPS is mandatory", Toast.LENGTH_LONG).show();
                    customDialogMAin.hideProgressBar();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void popUpForCityList(final ArrayList<ClaimFilterModel> cityList) {
        final AdapterFilter adapter = new AdapterFilter(getActivity(), cityList, 1);// overload constructor, 1 for temperory that define the the 1st position color will change
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.claim_map_filter_screen, null);
        final EditText tv = dialogView.findViewById(R.id.inputSearch);
        tv.setVisibility(View.GONE);
        ListView lv = dialogView.findViewById(R.id.list_view_filter);
        lv.setAdapter(adapter);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setPositiveButton("Cancel", null);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(v -> alertDialog.dismiss());
        lv.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            if (position == 0) {
                cityText = myCurrentCity;
            } else {
                ClaimFilterModel selectedStateId = cityList.get(position);
                cityText = selectedStateId.getName();
            }
            loc_text.setText(cityText);
            callApi(GET_MULTIBRAND_LIST);
            alertDialog.dismiss();
        });
    }

    private void getAccendingList() {
        Collections.sort(vendorModelArrayList, (o1, o2) -> o2.getVendor_discount().compareTo(o1.getVendor_discount()));
        isAccending = true;
        filter_image.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.accending_icon));
        if (!vendor_grid_layout.isShown()) {
            viewPageTag = VENDOR_LIST_TAG;
            vendorListAdapter = new VendorListAdapter(getActivity(), vendorModelArrayList);
            recyclerView.setAdapter(vendorListAdapter);
        } else {
            viewPageTag = VENDOR_GRID_TAG;
            accessoriesAdapter = new AccessoriesAdapter(getActivity(), vendorModelArrayList);
            gridView.setAdapter(accessoriesAdapter);
        }
    }

    private void getDecendingList() {
        getAccendingList();
        Collections.reverse(vendorModelArrayList);
        isAccending = false;
        filter_image.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.decending_icon));
        if (!vendor_grid_layout.isShown()) {
            viewPageTag = VENDOR_LIST_TAG;
            vendorListAdapter = new VendorListAdapter(getActivity(), vendorModelArrayList);
            recyclerView.setAdapter(vendorListAdapter);
        } else {
            viewPageTag = VENDOR_GRID_TAG;
            accessoriesAdapter = new AccessoriesAdapter(getActivity(), vendorModelArrayList);
            gridView.setAdapter(accessoriesAdapter);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(getView()).setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    try {
                        switch (viewPageTag) {
                            case VENDOR_LIST_TAG:
                            case VENDOR_GRID_TAG:
                                if (vendor_layout.isShown())
                                    vendor_layout.setVisibility(View.GONE);
                                if (vendor_grid_layout.isShown())
                                    vendor_grid_layout.setVisibility(View.GONE);
                                if (header_layout.isShown())
                                    header_layout.setVisibility(View.GONE);
                                haveRsa_llayout.setVisibility(View.VISIBLE);
                                viewPageTag = HAVE_SERVICE;
                                return true;
                            case HAVE_SERVICE:
                                if (CAR_LIST_FLAG == 1) {
                                    if (haveRsa_llayout.isShown())
                                        haveRsa_llayout.setVisibility(View.GONE);
                                    vendorListVisiblityGone();
                                    list_llayout.setVisibility(View.VISIBLE);
                                    viewPageTag = CAR_LIST;
                                    main_llayout.setBackgroundResource(R.drawable.road_side_assistance);
                                    return true;
                                } else
                                    return false;
                            case CALL_PAGE:
                                call_llayout.setVisibility(View.GONE);
                                if (CALL_FLAG == 0) {
                                    haveRsa_llayout.setVisibility(View.VISIBLE);
                                    viewPageTag = HAVE_SERVICE;
                                    return true;
                                } else {
                                    CALL_FLAG = 0;
                                    return false;
                                }
                            case VENDOR_DETAIL_TAG:
                                if (vendor_detail_layout.isShown())
                                    vendor_detail_layout.setVisibility(View.GONE);
                                header_layout.setVisibility(View.VISIBLE);
                                if (GRID_FLAG == 1) {
                                    vendor_grid_layout.setVisibility(View.VISIBLE);
                                    viewPageTag = VENDOR_GRID_TAG;
                                    GRID_FLAG = 0;
                                } else {
                                    vendor_layout.setVisibility(View.VISIBLE);
                                    viewPageTag = VENDOR_LIST_TAG;
                                }
                                return true;
                            case CAR_LIST:
                                return false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        });
    }

    @SuppressLint("SetTextI18n")
    private void showAlertDialog(String head) {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText("No multibrand available.");
        alert_heading.setText(head + " information");
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> {
            if (viewPageTag.equals(VENDOR_LIST_TAG) || viewPageTag.equals(VENDOR_GRID_TAG)) {
                cityText = myCurrentCity;
                loc_text.setText(cityText);
                callApi(GET_MULTIBRAND_LIST);
            }
            alert_dialog.dismiss();

        });
    }
}
