package com.universalsompo.meta.metaapp.motor.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.motor.adapters.TipOfTheDayAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.MotorTipsModel;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentTips extends Fragment implements ResponseListener{
    private View v;
    private TipOfTheDayAdapter adapter;
    private ListView listView;
    private TextView no_data;
    public MotorTipsModel model;
    private List<MotorTipsModel> modelList;
    private LinearLayout shimmerIncludeLayout ;
    private ShimmerFrameLayout mShimmerViewContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tips, container, false);
        init();
        callApi();
        return v;
    }

    private void init() {
        listView = v.findViewById(R.id.tips_list);
        no_data = v.findViewById(R.id.no_data);
        shimmerIncludeLayout = v.findViewById(R.id.shimmerIncludeLayout);
        mShimmerViewContainer = v.findViewById(R.id.parentShimmerLayout);
        modelList = new ArrayList<>();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
            object.put("CategoryId", "0");
            ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.GET_RSS_FEED, this, RequestConstants.GET_RSS_FEED);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_RSS_FEED) {
            new AppDataPushApi().callApi(getActivity(),"Tipss of day","Tips of day page","User visited to tips of day");
            if (!modelList.isEmpty()) {
                modelList.clear();
            }
            if (object.optString("Status").equals("false")) {
                no_data.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            } else {
                no_data.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                try {
                    JSONArray jsonArray = object.getJSONArray("RssFeed");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        model = new MotorTipsModel(obj.optString("Category"), obj.optString("CategoryId"), obj.optString("ImagePath"), obj.optString("Links"), obj.optString("PubDate"), obj.optString("Title"));
                        modelList.add(model);
                        Activity activity = getActivity();
                        if (isAdded() && activity != null){
                            getLayoutInflater().inflate(R.layout.fragment_tips_item_shimmer,shimmerIncludeLayout,true);
                        }
                    }
                    mShimmerViewContainer.startShimmer();
                    mShimmerViewContainer.postDelayed(() -> {
                        adapter = new TipOfTheDayAdapter(getActivity(), modelList);
                        listView.setAdapter(adapter);
                        mShimmerViewContainer.stopShimmer();
                        mShimmerViewContainer.setVisibility(View.GONE);
                    },3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
    }
}
