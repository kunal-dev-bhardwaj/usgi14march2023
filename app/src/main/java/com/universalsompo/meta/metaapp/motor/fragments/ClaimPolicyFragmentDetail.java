package com.universalsompo.meta.metaapp.motor.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.adapters.ClaimPolicyAdapterForSwipe;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.Objects;


public class ClaimPolicyFragmentDetail extends Fragment implements ResponseListener, View.OnClickListener, ViewPager.OnPageChangeListener {
    private LinearLayout accedent;
    private LinearLayout theft;
    private LinearLayout third_party;
    private TextView accedent1;
    private TextView theft1;
    private TextView third_party1;
    private String InsComp;
    private View myView;
    private ViewPager pager2;
    private String[] data = new String[3];
    private String vehicleType;
    MySharedPreference pref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.claim_policy_fragment_detail, container, false);
         pref = MySharedPreference.getInstance(getActivity());
        InsComp = pref.getINSkey();
        assert getArguments() != null;
        vehicleType=getArguments().getString("v_type");
        String ACCENT_METHOD = "Accident";
        hitAccident(ACCENT_METHOD);
        return myView;
    }

    private void hitAccident(String method) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("ContentType", method);
            object.put("InsComp", InsComp);
            object.put("VehicleType", vehicleType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.CLAIM_POLICY_WRITEUP, this, 1);
        req.execute();
    }

    private void hitTheft(String method, int Tag) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("ContentType", method);
             object.put("InsComp", InsComp);
            object.put("VehicleType", vehicleType);

        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.CLAIM_POLICY_WRITEUP, this, Tag);
        req.execute();
    }

    private void hitThirdParty(String method, int Tag) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("ContentType", method);
            object.put("InsComp", InsComp);
            object.put("VehicleType", vehicleType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.CLAIM_POLICY_WRITEUP, this, Tag);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        pager2 = myView.findViewById(R.id.pager2);
        int THEFT_TAG = 2;
        int THIRD_PARTY_TAG = 3;
        int ACCENT_TAG = 1;
        if (Tag == ACCENT_TAG) {
                String THEFT_METHOD = "Theft";
                hitTheft(THEFT_METHOD, THEFT_TAG);
                data[0] = object.optString("ContentText");
            } else if (Tag == THEFT_TAG) {
                String THIRD_PARTY_METHOD = "ThirdParty";
                hitThirdParty(THIRD_PARTY_METHOD, THIRD_PARTY_TAG);
                data[1] = object.optString("ContentText");
            } else if (Tag == THIRD_PARTY_TAG) {
                data[2] = object.optString("ContentText");
                initView();
            }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private void initView() {
        accedent = myView.findViewById(R.id.accedent);
        theft = myView.findViewById(R.id.theft);
        third_party = myView.findViewById(R.id.third_party);
        accedent1 = myView.findViewById(R.id.accedent1);
        theft1 = myView.findViewById(R.id.theft1);
        third_party1 = myView.findViewById(R.id.third_party1);
        pager2 = myView.findViewById(R.id.pager2);
        pager2.setAdapter(new ClaimPolicyAdapterForSwipe(getActivity(), data));
        pager2.addOnPageChangeListener(this);
        accedent.setOnClickListener(this);
        theft.setOnClickListener(this);
        third_party.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.accedent:
                setBoxAccedent();
                pager2.setCurrentItem(0);
                break;
            case R.id.theft:
                setBoxTheft();
                pager2.setCurrentItem(1);
                break;
            case R.id.third_party:
                setBoxThirdParty();
                pager2.setCurrentItem(2);
                break;
        }
    }

    private void setBoxAccedent() {
        accedent.setBackgroundResource(R.drawable.linear_rounded_left_claim_tab_dark);
        accedent1.setTextColor(Color.WHITE);
        theft.setBackgroundResource(R.color.claim_tab_light);
        theft1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.lightblack));
        third_party.setBackgroundResource(R.drawable.linear_rounded_right_claim_tab_light);
        third_party1.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
    }

    private void setBoxTheft() {
        accedent.setBackgroundResource(R.drawable.linear_rounded_left_claim_tab_light);
        accedent1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.lightblack));
        theft.setBackgroundResource(R.color.claim_tab_dark);
        theft1.setTextColor(Color.WHITE);
        third_party.setBackgroundResource(R.drawable.linear_rounded_right_claim_tab_light);
        third_party1.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
    }

    private void setBoxThirdParty() {
        accedent.setBackgroundResource(R.drawable.linear_rounded_left_claim_tab_light);
        accedent1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.lightblack));
        theft.setBackgroundResource(R.color.claim_tab_light);
        theft1.setTextColor(ContextCompat.getColor(getContext(), R.color.lightblack));
        third_party.setBackgroundResource(R.drawable.linear_rounded_right_claim_tab_dark);
        third_party1.setTextColor(Color.WHITE);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        setSelection(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private void setSelection(int position1) {
        switch (position1) {
            case 0:
                setBoxAccedent();
                break;
            case 1:
                setBoxTheft();
                break;
            case 2:
                setBoxThirdParty();
                break;
        }
    }
}
