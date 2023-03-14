package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.motor.adapters.ContentAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ContentModel;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentContent extends Fragment implements ResponseListener {
    private View rootview;
    private RecyclerView content_list;
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_content, container, false);
        init();
        callApi();
        return rootview;
    }

    private void init() {
        shimmerIncludeLayout = rootview.findViewById(R.id.shimmerIncludeLayout);
        mShimmerViewContainer = rootview.findViewById(R.id.parentShimmerLayout);
        content_list = rootview.findViewById(R.id.content_list);
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.GET_CONTENT, this, RequestConstants.GET_CONTENT);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_CONTENT) {
            new AppDataPushApi().callApi(getActivity(),"Content","Video section","Checked for uploaded youtub videos");
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("VideoContentDetails");
                    LogUtils.showLog("content", "array size" + arr);
                    final ArrayList<ContentModel> data = new ArrayList<>();
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);

                        String imgPath = obj.optString("ThumbnailPath");
                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in/AppCMS" + abc[1];
                        }*/

                        data.add(
                                new ContentModel(
                                        imgPath,
                                        obj.optString("Title"),
                                        obj.optString("UploadedDate"),
                                        obj.optString("Description"),
                                        obj.optString("URL")
                                )
                        );
                        Activity activity = getActivity();
                        if (isAdded() && activity != null){
                            getLayoutInflater().inflate(R.layout.fragment_content_item_shimmer,shimmerIncludeLayout,true);
                        }
                    }

                    mShimmerViewContainer.startShimmer();
                    mShimmerViewContainer.postDelayed(() -> {
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        content_list.setLayoutManager(layoutManager);
                        content_list.setAdapter(new ContentAdapter(getActivity(), data));
                        mShimmerViewContainer.stopShimmer();
                        mShimmerViewContainer.setVisibility(View.GONE);
                    },3000);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                mShimmerViewContainer.setVisibility(View.GONE);
                final Dialog dialog = new Dialog(Objects.requireNonNull(getActivity()));
                dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.setContentView(R.layout.no_data_found_dialog);
                TextView heading = dialog.findViewById(R.id.dialog_heading);
                TextView subheading = dialog.findViewById(R.id.dialog_subheading);
                heading.setText("Oops !!");
                subheading.setText("No data found");
                TextView ok = dialog.findViewById(R.id.tvok);

                ok.setOnClickListener(v -> {
                    Objects.requireNonNull(getActivity()).onBackPressed();
                    dialog.dismiss();
                });

                dialog.show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}