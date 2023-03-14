package com.universalsompo.meta.metaapp.motor.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.adapters.ServiceGrideAdapter;
import com.universalsompo.meta.metaapp.motor.adapters.ServiceListAdapter;
import com.universalsompo.meta.metaapp.motor.constants.Constants;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.dialogs.ConfirmDialog;
import com.universalsompo.meta.metaapp.intefaces.LinkNewPolicyDailogCallback;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.RecyclerViewItemClickLisner;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ServiceModel;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;


import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.SERVICE_ITEMS;
import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.TOKEN_NO;

public class FragmentServiceItem extends Fragment implements ResponseListener, View.OnClickListener,
        RecyclerViewItemClickLisner.OnItemClickListener,AdapterView.OnItemClickListener , LinkNewPolicyDailogCallback {
    private View v;
    private LinearLayout grid_linearlayout;
    private GridView grdv_accessories;
    private LinearLayout vendor_layout;
    private RecyclerView recycler_view;
    private ServiceListAdapter serviceVendorAdapter;
    private ImageView grid_img;
    private Dialog alert_dialog;
    private ArrayList<ServiceModel> serviceModelArrayList;
    private static final String VENDOR_LIST_TAG = "vandor_list";
    private static final String VENDOR_GRID_TAG = "vandor_grid";
    private static String viewPageTag;
    private String vendor_type_str;
    private String veh_type, fragName;
    private SelectorListener binder;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_services_item, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).remove_elevation();
        init();
        if(getArguments() != null){
            vendor_type_str=   getArguments().getString("item");
            fragName = getArguments().getString("frag_tag");
            assert fragName != null;
            selectApiWithDialog(fragName);
        }
        return v;
    }

    private void selectApiWithDialog(String fragName) {
        switch (fragName)
        {
            case  FragmentsTags.TAG_WARRANTY_NAME:
            case  FragmentsTags.SPARE_PARTS_NAME:
            case  FragmentsTags.PARTS_ACCESSORIES_NAME:
                new ConfirmDialog("Do you want to buy "+fragName+" for ","Bike","Car",getActivity(),this).show();
                break;
            case  FragmentsTags.TAG_OWNED_CARS:
                new ConfirmDialog("Do you want to buy/sell "+fragName,"Bike","Car",getActivity(),this).show();
                break;
            default:
                veh_type= Constants.FOUR_WHEELER;
                callApi(vendor_type_str);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {
        grid_linearlayout = v.findViewById(R.id.grid_linearlayout);
        grdv_accessories = v.findViewById(R.id.grdv_accessories);
        grdv_accessories.setOnItemClickListener(this);
        grid_linearlayout.setVisibility(View.GONE);
        vendor_layout = v.findViewById(R.id.vendor_layout);
        recycler_view = v.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.addOnItemTouchListener(new RecyclerViewItemClickLisner(getActivity(), this));
        vendor_layout.setVisibility(View.VISIBLE);
        LinearLayout header_layout = v.findViewById(R.id.header_layout);
        LinearLayout grid_header_layout = v.findViewById(R.id.grid_layout);
        grid_img = v.findViewById(R.id.grid_img);
        ImageView loc_icon = v.findViewById(R.id.loc_icon);
        TextView loc_text = v.findViewById(R.id.loc_text);
        ImageView filter_image = v.findViewById(R.id.filter_image);
        TextView filter_text = v.findViewById(R.id.filter_text);
        header_layout.setVisibility(View.VISIBLE);
        loc_icon.setVisibility(View.GONE);
        loc_text.setVisibility(View.GONE);
        filter_image.setVisibility(View.GONE);
        filter_text.setVisibility(View.GONE);
        grid_header_layout.setOnClickListener(this);
        serviceModelArrayList = new ArrayList<>();
    }

    private void callApi(String vendor_type) {

        try {
            JSONObject object = new JSONObject();
            object.put(TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
            object.put("VendorType", vendor_type);
            object.put("VehicleType", veh_type);
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.SERVICE_ITEMS, this, SERVICE_ITEMS);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        try {
            if (Tag == SERVICE_ITEMS) {
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User visited to avail value add service for " + fragName);
                if (object.getString("Status").equals("true"))
                {
                    JSONArray jsonArray = object.getJSONArray("VendorsListDetails");
                    ServiceModel serviceModel;
                    if (jsonArray.length() > 1) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String imgPath = jsonObject.optString("IconPath");

                            if (imgPath.contains("AppCMS")){
                                String[] abc = imgPath.split("AppCMS");
                                imgPath = "http://mobile.universalsompo.in/AppCMS" + abc[1];
                            }

                            serviceModel = new ServiceModel(jsonObject.getString("CoupanCode"),
                                    jsonObject.getString("Description"), jsonObject.getString("Title"),
                                    jsonObject.getString("TollFreeNo"), jsonObject.getString("VendorCode"),
                                    jsonObject.getString("VendorId"), jsonObject.getString("VendorName"),
                                    jsonObject.getString("URL"), imgPath,
                                    jsonObject.getString("Discount")
                            );

                            serviceModelArrayList.add(serviceModel);

                        }

                        if(!vendor_layout.isShown())
                            vendor_layout.setVisibility(View.VISIBLE);
                        if(grid_linearlayout.isShown())
                            grid_linearlayout.setVisibility(View.GONE);
                        serviceVendorAdapter = new ServiceListAdapter(getActivity(), serviceModelArrayList);
                        recycler_view.setAdapter(serviceVendorAdapter);
                        viewPageTag=VENDOR_LIST_TAG;
                    } else {
                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                        serviceModel = new ServiceModel(jsonObject.getString("CoupanCode"),
                                jsonObject.getString("Description"), jsonObject.getString("Title"),
                                jsonObject.getString("TollFreeNo"), jsonObject.getString("VendorCode"),
                                jsonObject.getString("VendorId"), jsonObject.getString("VendorName"),
                                jsonObject.getString("URL"), jsonObject.getString("IconPath"),
                                jsonObject.getString("Discount"));
                        String dis1 = jsonObject.getString("Discount");
                        String coupcod = jsonObject.getString("CoupanCode");
                        int a = dis1.length();
                        int b = coupcod.length();
                        if (a != 0 || b != 0) {
                            Bundle bundle = new Bundle();
                            FragmentCouponCodeMotor fragmentCouponCodemotor = new FragmentCouponCodeMotor();
                            if (vendor_type_str.equalsIgnoreCase("ExtendedWarraty")) {
                                bundle.putString("item", "ExtendedWarraty");
                                bundle.putString("frag_tag",FragmentsTags.TAG_WARRANTY_NAME);
                                bundle.putString("vendor_name", jsonObject.getString("VendorName"));
                                bundle.putString("vendor_id", jsonObject.getString("VendorId"));
                                bundle.putString("title", jsonObject.getString("Title"));
                                bundle.putString("URL", jsonObject.getString("URL"));
                                bundle.putString("domain", jsonObject.getString("VendorName"));
                                bundle.putString("VehicleType",veh_type);
                                bundle.putString("Coupancode", jsonObject.getString("CoupanCode"));
                                bundle.putString("discount", jsonObject.getString("Discount"));
                                fragmentCouponCodemotor.setArguments(bundle);
                                replaceFragment(fragmentCouponCodemotor, FragmentsTags.TAG_WARRANTY_NAME);
                            } else if (vendor_type_str.equalsIgnoreCase("SpareParts")) {
                                bundle.putString("item", "SpareParts");
                                bundle.putString("frag_tag",FragmentsTags.SPARE_PARTS_NAME);
                                bundle.putString("vendor_name", jsonObject.getString("VendorName"));
                                bundle.putString("vendor_id", jsonObject.getString("VendorId"));
                                bundle.putString("title", jsonObject.getString("Title"));
                                bundle.putString("URL", jsonObject.getString("URL"));
                                bundle.putString("domain", jsonObject.getString("VendorName"));
                                bundle.putString("VehicleType",veh_type);
                                bundle.putString("Coupancode", jsonObject.getString("CoupanCode"));
                                bundle.putString("discount", jsonObject.getString("Discount"));
                                fragmentCouponCodemotor.setArguments(bundle);
                                replaceFragment(fragmentCouponCodemotor, FragmentsTags.SPARE_PARTS_NAME);
                            } else if (vendor_type_str.equalsIgnoreCase("Acceriess")) {
                                bundle.putString("item", "Acceriess");
                                bundle.putString("frag_tag",FragmentsTags.PARTS_ACCESSORIES_NAME);
                                bundle.putString("vendor_name", jsonObject.getString("VendorName"));
                                bundle.putString("vendor_id", jsonObject.getString("VendorId"));
                                bundle.putString("title", jsonObject.getString("Title"));
                                bundle.putString("URL", jsonObject.getString("URL"));
                                bundle.putString("domain", jsonObject.getString("VendorName"));
                                bundle.putString("VehicleType",veh_type);
                                bundle.putString("Coupancode", jsonObject.getString("CoupanCode"));
                                bundle.putString("discount", jsonObject.getString("Discount"));
                                fragmentCouponCodemotor.setArguments(bundle);
                                replaceFragment(fragmentCouponCodemotor, FragmentsTags.PARTS_ACCESSORIES_NAME);
                            } else if (vendor_type_str.equalsIgnoreCase("Preowned")) {
                                bundle.putString("item", "Preowned");
                                bundle.putString("frag_tag",FragmentsTags.TAG_OWNED_CARS);
                                bundle.putString("vendor_name", jsonObject.getString("VendorName"));
                                bundle.putString("vendor_id", jsonObject.getString("VendorId"));
                                bundle.putString("title", jsonObject.getString("Title"));
                                bundle.putString("URL", jsonObject.getString("URL"));
                                bundle.putString("domain", jsonObject.getString("VendorName"));
                                bundle.putString("VehicleType",veh_type);
                                bundle.putString("Coupancode", jsonObject.getString("CoupanCode"));
                                bundle.putString("discount", jsonObject.getString("Discount"));
                                fragmentCouponCodemotor.setArguments(bundle);
                                replaceFragment(fragmentCouponCodemotor, FragmentsTags.TAG_OWNED_CARS);
                            } else if (vendor_type_str.equalsIgnoreCase("SpareCars")) {
                                bundle.putString("item", "SpareCars");
                                bundle.putString("frag_tag",FragmentsTags.SPARES_CAR);
                                bundle.putString("vendor_name", jsonObject.getString("VendorName"));
                                bundle.putString("vendor_id", jsonObject.getString("VendorId"));
                                bundle.putString("title", jsonObject.getString("Title"));
                                bundle.putString("URL", jsonObject.getString("URL"));
                                bundle.putString("domain", jsonObject.getString("VendorName"));
                                bundle.putString("VehicleType",veh_type);
                                bundle.putString("Coupancode", jsonObject.getString("CoupanCode"));
                                bundle.putString("discount", jsonObject.getString("Discount"));
                                fragmentCouponCodemotor.setArguments(bundle);
                                replaceFragment(fragmentCouponCodemotor, FragmentsTags.SPARES_CAR);
                            } else if (vendor_type_str.equalsIgnoreCase("BookDriver")) {
                                bundle.putString("item", "BookDriver");
                                bundle.putString("frag_tag",FragmentsTags.BOOK_DRIVER);
                                bundle.putString("vendor_name", jsonObject.getString("VendorName"));
                                bundle.putString("vendor_id", jsonObject.getString("VendorId"));
                                bundle.putString("title", jsonObject.getString("Title"));
                                bundle.putString("URL", jsonObject.getString("URL"));
                                bundle.putString("domain", jsonObject.getString("VendorName"));
                                bundle.putString("VehicleType",veh_type);
                                bundle.putString("Coupancode", jsonObject.getString("CoupanCode"));
                                bundle.putString("discount", jsonObject.getString("Discount"));
                                fragmentCouponCodemotor.setArguments(bundle);
                                replaceFragment(fragmentCouponCodemotor, FragmentsTags.BOOK_DRIVER);
                            }
                        } else {
                            appInBrowser(serviceModel);
                        }
                    }
                } else {
                    showAlertDialog();
                    if(vendor_layout.isShown())
                        vendor_layout.setVisibility(View.GONE);
                    if(grid_linearlayout.isShown())
                        grid_linearlayout.setVisibility(View.GONE);
                    }
            } else if (Tag == RequestConstants.GET_VISITOR_COUNT) {
                if (object.optString("Status").equalsIgnoreCase("true")) {

                     LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
                } else {
                     LogUtils.showLog("@@@MESSAGE", object.optString("Message"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.grid_layout) {
            if (viewPageTag == null)
                return;
            if (viewPageTag.equals(VENDOR_LIST_TAG)) {

                if (vendor_layout.isShown())
                    vendor_layout.setVisibility(View.GONE);
                if (!grid_linearlayout.isShown())
                    grid_linearlayout.setVisibility(View.VISIBLE);

                grid_img.setImageResource(R.drawable.horizontal_lines);
                ServiceGrideAdapter serviceGrideAdapter = new ServiceGrideAdapter(getActivity(), serviceModelArrayList);
                grdv_accessories.setAdapter(serviceGrideAdapter);
                viewPageTag = VENDOR_GRID_TAG;
            } else {
                if (!vendor_layout.isShown())
                    vendor_layout.setVisibility(View.VISIBLE);
                if (grid_linearlayout.isShown())
                    grid_linearlayout.setVisibility(View.GONE);
                grid_img.setImageResource(R.drawable.grid);
                serviceVendorAdapter = new ServiceListAdapter(getActivity(), serviceModelArrayList);
                recycler_view.setAdapter(serviceVendorAdapter);
                viewPageTag = VENDOR_LIST_TAG;
            }
        }
    }

    private void appInBrowser(ServiceModel model)
    {
        Intent intent = new Intent(getActivity(), BookDriver.class);
        intent.putExtra("title", model.getTitle());
        intent.putExtra("URL", model.getURL());
        intent.putExtra("domain", model.getVendorName());
        intent.putExtra("name", model.getVendorName());
        intent.putExtra("VendorId",model.getVendorId());
        intent.putExtra("VehicleType", veh_type);
        startActivity(intent);
        FragmentsTransactionsUtils.popFragment(getActivity());
        MainActivity mainActivity=(MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.getPreviousFragmnet();
    }

    @Override
    public void onItemClick(View view, int position) {
        String dis1 = serviceModelArrayList.get(position).getDiscount();
        String coupcod = serviceModelArrayList.get(position).getCoupanCode();
        int a = dis1.length();
        int b = coupcod.length();

        if (a != 0 || b != 0) {
            Bundle bundle = new Bundle();
            FragmentCouponCodeMotor fragmentCouponCodemotor = new FragmentCouponCodeMotor();
            if (vendor_type_str.equalsIgnoreCase("ExtendedWarraty")) {
                bundle.putString("item", "ExtendedWarraty");
                bundle.putString("frag_tag",FragmentsTags.TAG_WARRANTY_NAME);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.TAG_WARRANTY_NAME);
            } else if (vendor_type_str.equalsIgnoreCase("SpareParts")) {
                bundle.putString("item", "SpareParts");
                bundle.putString("frag_tag",FragmentsTags.SPARE_PARTS_NAME);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.SPARE_PARTS_NAME);
            } else if (vendor_type_str.equalsIgnoreCase("Acceriess")) {
                bundle.putString("item", "Acceriess");
                bundle.putString("frag_tag",FragmentsTags.PARTS_ACCESSORIES_NAME);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.PARTS_ACCESSORIES_NAME);
            } else if (vendor_type_str.equalsIgnoreCase("Preowned")) {
                bundle.putString("item", "Preowned");
                bundle.putString("frag_tag",FragmentsTags.TAG_OWNED_CARS);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.TAG_OWNED_CARS);
            } else if (vendor_type_str.equalsIgnoreCase("SpareCars")) {
                bundle.putString("item", "SpareCars");
                bundle.putString("frag_tag",FragmentsTags.SPARES_CAR);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.SPARES_CAR);
            } else if (vendor_type_str.equalsIgnoreCase("BookDriver")) {
                bundle.putString("item", "BookDriver");
                bundle.putString("frag_tag",FragmentsTags.BOOK_DRIVER);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.BOOK_DRIVER);
            }
        } else {
            appInBrowser(serviceModelArrayList.get(position));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String dis1 = serviceModelArrayList.get(position).getDiscount();
        String coupcod = serviceModelArrayList.get(position).getCoupanCode();
        int a = dis1.length();
        int b = coupcod.length();

        if (a != 0 || b != 0) {
            Bundle bundle = new Bundle();
            FragmentCouponCodeMotor fragmentCouponCodemotor = new FragmentCouponCodeMotor();
            if (vendor_type_str.equalsIgnoreCase("ExtendedWarraty")) {
                bundle.putString("item", "ExtendedWarraty");
                bundle.putString("frag_tag",FragmentsTags.TAG_WARRANTY_NAME);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.TAG_WARRANTY_NAME);
            } else if (vendor_type_str.equalsIgnoreCase("SpareParts")) {
                bundle.putString("item", "SpareParts");
                bundle.putString("frag_tag",FragmentsTags.SPARE_PARTS_NAME);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.SPARE_PARTS_NAME);
            } else if (vendor_type_str.equalsIgnoreCase("Acceriess")) {
                bundle.putString("item", "Acceriess");
                bundle.putString("frag_tag",FragmentsTags.PARTS_ACCESSORIES_NAME);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.PARTS_ACCESSORIES_NAME);
            } else if (vendor_type_str.equalsIgnoreCase("Preowned")) {
                bundle.putString("item", "Preowned");
                bundle.putString("frag_tag",FragmentsTags.TAG_OWNED_CARS);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.TAG_OWNED_CARS);
            } else if (vendor_type_str.equalsIgnoreCase("SpareCars")) {
                bundle.putString("item", "SpareCars");
                bundle.putString("frag_tag",FragmentsTags.SPARES_CAR);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.SPARES_CAR);
            } else if (vendor_type_str.equalsIgnoreCase("BookDriver")) {
                bundle.putString("item", "BookDriver");
                bundle.putString("frag_tag",FragmentsTags.BOOK_DRIVER);
                bundle.putString("vendor_name", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("vendor_id", serviceModelArrayList.get(position).getVendorId());
                bundle.putString("title", serviceModelArrayList.get(position).getTitle());
                bundle.putString("URL", serviceModelArrayList.get(position).getURL());
                bundle.putString("domain", serviceModelArrayList.get(position).getVendorName());
                bundle.putString("VehicleType",veh_type);
                bundle.putString("Coupancode", serviceModelArrayList.get(position).getCoupanCode());
                bundle.putString("discount", serviceModelArrayList.get(position).getDiscount());
                fragmentCouponCodemotor.setArguments(bundle);
                replaceFragment(fragmentCouponCodemotor, FragmentsTags.BOOK_DRIVER);
            }
        } else {
            appInBrowser(serviceModelArrayList.get(position));
        }
    }

    @Override
    public void positive() {
        veh_type= Constants.TWO_WHEELER;
        callApi(vendor_type_str);

    }

    @Override
    public void Negative() {

        veh_type= Constants.FOUR_WHEELER;

        callApi(vendor_type_str);
    }

    private void showAlertDialog() {
        alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt =  alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading =  alert_dialog.findViewById(R.id.alert_heading);
        alert_msg =  alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText(getResources().getString(R.string.no_vendor_available));
        alert_heading.setText(getResources().getString(R.string.vendors_information));

        alert_dialog.show();
        ok_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();
                alert_dialog.dismiss();
            }
        });
    }

    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
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
}
