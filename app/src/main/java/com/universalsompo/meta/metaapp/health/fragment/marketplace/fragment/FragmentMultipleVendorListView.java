package com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.adapter.MultipleVendorListAdapter;
import com.universalsompo.meta.metaapp.health.fragment.marketplace.model.MultipleVendor;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentMultipleVendorListView extends Fragment implements ResponseListener {
    private View v;
    private String type, state, city, id1;
    private TextView no_data;
    private RecyclerView listview;
    private final ArrayList<MultipleVendor> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_multiple_vendor_list_layout, container, false);
        assert getArguments() != null;
        type = getArguments().getString("type");
        state = getArguments().getString("state");
        city = getArguments().getString("city");
        id1 = getArguments().getString("id");
        init();
        return v;
    }

    private void init() {
        no_data = v.findViewById(R.id.no_data);
        listview = v.findViewById(R.id.listview);

        if (type.equalsIgnoreCase("Wellness Center")) {
            callApi(RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST);
        } else if (type.equalsIgnoreCase("Doctor Consultation")) {
            callApi(RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST);
        } else if (type.equalsIgnoreCase("Medicine")) {
            callApi(RequestHealthConstants.GET_MEDICINE_VENDOR_LIST);
        } else if (type.equalsIgnoreCase("Lab Test")) {
            callApi(RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST);
        } else if (type.equalsIgnoreCase("Health Packages")) {
            callApi(RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST);
        } else if (type.equalsIgnoreCase("Homecare")) {
            callApi(RequestHealthConstants.GET_HOMECARE_VENDOR_LIST);
        }
    }

    private void callApi(Integer id){
        if (id == RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST, this, RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST, this, RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_MEDICINE_VENDOR_LIST) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_MEDICINE_VENDOR_LIST, this, RequestHealthConstants.GET_MEDICINE_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_LAB_TEST_VENDOR_LIST, this, RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST, this, RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST);
            req.execute();
        } else if (id == RequestHealthConstants.GET_HOMECARE_VENDOR_LIST) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
                object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
                object.put("HomeCareTypeID", id1);
                object.put("State", state);
                object.put("City", city);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_HOMECARE_VENDOR_LIST, this, RequestHealthConstants.GET_HOMECARE_VENDOR_LIST);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        MultipleVendorListAdapter multipleVendorListAdapter;
        if(Tag == RequestHealthConstants.GET_WELLNESS_CENTER_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","List of multiple vendors listview of type " + type);
                no_data.setVisibility(View.GONE);
                listview.setVisibility(View.VISIBLE);
                JSONArray arr1;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr1 = object.getJSONArray("MarketPlaceResList");
                    for (int i = 0; i < arr1.length(); i++) {
                        JSONObject obj = arr1.getJSONObject(i);
                        String imgPath = obj.optString("LogoURL");

                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in:50003/AppCMS" + abc[1];
                        }*/
                        data.add(
                                new MultipleVendor(
                                        obj.optString("Address"),
                                        obj.optString("Details"),
                                        obj.optString("Latitude"),
                                        imgPath,
                                        obj.optString("Longitude"),
                                        obj.optString("VendorID"),
                                        obj.optString("VendorName"),
                                        obj.optString("WebsiteURL")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    listview.setLayoutManager(layoutManager);
                    multipleVendorListAdapter = new MultipleVendorListAdapter(getActivity(), data, type);
                    listview.setAdapter(multipleVendorListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","No multiple vendors found for type " + type);
                no_data.setVisibility(View.VISIBLE);
                listview.setVisibility(View.GONE);
            }
        } else if(Tag == RequestHealthConstants.GET_DOCTOR_CONSULTATION_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","List of multiple vendors listview of type " + type);
                no_data.setVisibility(View.GONE);
                listview.setVisibility(View.VISIBLE);
                JSONArray arr1;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr1 = object.getJSONArray("MarketPlaceResList");
                    for (int i = 0; i < arr1.length(); i++) {
                        JSONObject obj = arr1.getJSONObject(i);
                        String imgPath = obj.optString("LogoURL");

                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in:50003/AppCMS" + abc[1];
                        }*/
                        data.add(
                                new MultipleVendor(
                                        obj.optString("Address"),
                                        obj.optString("Details"),
                                        obj.optString("Latitude"),
                                        imgPath,
                                        obj.optString("Longitude"),
                                        obj.optString("VendorID"),
                                        obj.optString("VendorName"),
                                        obj.optString("WebsiteURL")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    listview.setLayoutManager(layoutManager);
                    multipleVendorListAdapter = new MultipleVendorListAdapter(getActivity(), data, type);
                    listview.setAdapter(multipleVendorListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","No multiple vendors found for type " + type);
                no_data.setVisibility(View.VISIBLE);
                listview.setVisibility(View.GONE);
            }
        } else if(Tag == RequestHealthConstants.GET_MEDICINE_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","List of multiple vendors listview of type " + type);
                no_data.setVisibility(View.GONE);
                listview.setVisibility(View.VISIBLE);
                JSONArray arr1;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr1 = object.getJSONArray("MarketPlaceResList");
                    for (int i = 0; i < arr1.length(); i++) {
                        JSONObject obj = arr1.getJSONObject(i);
                        String imgPath = obj.optString("LogoURL");

                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in:50003/AppCMS" + abc[1];
                        }*/
                        data.add(
                                new MultipleVendor(
                                        obj.optString("Address"),
                                        obj.optString("Details"),
                                        obj.optString("Latitude"),
                                        imgPath,
                                        obj.optString("Longitude"),
                                        obj.optString("VendorID"),
                                        obj.optString("VendorName"),
                                        obj.optString("WebsiteURL")
                                )
                            );
                        }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    listview.setLayoutManager(layoutManager);
                    multipleVendorListAdapter = new MultipleVendorListAdapter(getActivity(), data, type);
                    listview.setAdapter(multipleVendorListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","No multiple vendors found for type " + type);
                no_data.setVisibility(View.VISIBLE);
                listview.setVisibility(View.GONE);
            }
        } else if(Tag == RequestHealthConstants.GET_LAB_TEST_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","List of multiple vendors listview of type " + type);
                no_data.setVisibility(View.GONE);
                listview.setVisibility(View.VISIBLE);
                JSONArray arr1;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr1 = object.getJSONArray("MarketPlaceResList");
                    for (int i = 0; i < arr1.length(); i++) {
                        JSONObject obj = arr1.getJSONObject(i);
                        String imgPath = obj.optString("LogoURL");

                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in:50003/AppCMS" + abc[1];
                        }*/
                        data.add(
                                new MultipleVendor(
                                        obj.optString("Address"),
                                        obj.optString("Details"),
                                        obj.optString("Latitude"),
                                        imgPath,
                                        obj.optString("Longitude"),
                                        obj.optString("VendorID"),
                                        obj.optString("VendorName"),
                                        obj.optString("WebsiteURL")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    listview.setLayoutManager(layoutManager);
                    multipleVendorListAdapter = new MultipleVendorListAdapter(getActivity(), data, type);
                    listview.setAdapter(multipleVendorListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","No multiple vendors found for type " + type);
                no_data.setVisibility(View.VISIBLE);
                listview.setVisibility(View.GONE);
            }
        } else if(Tag == RequestHealthConstants.GET_HEALTH_PACKAGES_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","List of multiple vendors listview of type " + type);
                no_data.setVisibility(View.GONE);
                listview.setVisibility(View.VISIBLE);
                JSONArray arr1;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr1 = object.getJSONArray("MarketPlaceResList");
                    for (int i = 0; i < arr1.length(); i++) {
                        JSONObject obj = arr1.getJSONObject(i);
                        String imgPath = obj.optString("LogoURL");

                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in:50003/AppCMS" + abc[1];
                        }*/
                        data.add(
                                new MultipleVendor(
                                        obj.optString("Address"),
                                        obj.optString("Details"),
                                        obj.optString("Latitude"),
                                        imgPath,
                                        obj.optString("Longitude"),
                                        obj.optString("VendorID"),
                                        obj.optString("VendorName"),
                                        obj.optString("WebsiteURL")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    listview.setLayoutManager(layoutManager);
                    multipleVendorListAdapter = new MultipleVendorListAdapter(getActivity(), data, type);
                    listview.setAdapter(multipleVendorListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }  else {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","No multiple vendors found for type " + type);
                no_data.setVisibility(View.VISIBLE);
                listview.setVisibility(View.GONE);
            }
        } else if(Tag == RequestHealthConstants.GET_HOMECARE_VENDOR_LIST) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","List of multiple vendors listview of type " + type);
                no_data.setVisibility(View.GONE);
                listview.setVisibility(View.VISIBLE);
                JSONArray arr1;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr1 = object.getJSONArray("MarketPlaceResList");
                    for (int i = 0; i < arr1.length(); i++) {
                        JSONObject obj = arr1.getJSONObject(i);
                        String imgPath = obj.optString("LogoURL");

                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in:50003/AppCMS" + abc[1];
                        }*/
                        data.add(
                                new MultipleVendor(
                                        obj.optString("Address"),
                                        obj.optString("Details"),
                                        obj.optString("Latitude"),
                                        imgPath,
                                        obj.optString("Longitude"),
                                        obj.optString("VendorID"),
                                        obj.optString("VendorName"),
                                        obj.optString("WebsiteURL")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    listview.setLayoutManager(layoutManager);
                    multipleVendorListAdapter = new MultipleVendorListAdapter(getActivity(), data, type);
                    listview.setAdapter(multipleVendorListAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                new AppDataPushApi().callApi(getActivity(),"Multiple Vendors","Multiple vendors list page","No multiple vendors found for type " + type);
                no_data.setVisibility(View.VISIBLE);
                listview.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
