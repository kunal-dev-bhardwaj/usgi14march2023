package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.adapter.HealthPager;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomTextView1;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class FragmentMetaHealthPolicyDetails extends Fragment implements ResponseListener, ViewPager.OnPageChangeListener, View.OnClickListener {
    private View v;
    private MySharedPreference prefrences;
    private ViewPager viewPager;
    private CustomTextView1 btnpolicy1;
    private CustomTextView1 btncoverages1;
    private CustomTextView1 btncontact1;
    private LinearLayout btnpolicy;
    private LinearLayout btncoverages;
    private LinearLayout btncontact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_meta_health_own_policy_tab, null);
        initView();
        return v;
    }

    private void initView() {
        viewPager = v.findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        btnpolicy = v.findViewById(R.id.btnpolicy);
        btncoverages = v.findViewById(R.id.btncoverages);
        btncontact = v.findViewById(R.id.btncontact);
        btnpolicy1 = v.findViewById(R.id.btnpolicy1);
        btncoverages1 = v.findViewById(R.id.btncoverages1);
        btncontact1 = v.findViewById(R.id.btncontact1);
        viewPager.addOnPageChangeListener(this);
        btnpolicy.setOnClickListener(this);
        btncoverages.setOnClickListener(this);
        btncontact.setOnClickListener(this);
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
    }

    private void init() {
        JSONObject jo = new JSONObject();
        try {
            jo.put(RequestConstants.TOKEN_NO, prefrences.getToken_no());
            jo.put("Uid", prefrences.getUID());
            jo.put("PolicyID", prefrences.getPolicy_id_health());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), jo, UrlHealthConstants.VIEW_UNIVERSAL_HEALTH_POLICY_DETAIL, this, RequestHealthConstants.VIEW_UNIVERSAL_HEALTH_POLICY_DETAIL);
        req.execute();
    }

    private void setBoxPolicy() {
        btnpolicy.setBackgroundResource(R.drawable.linear_rounded_left_policy_tab_dark);
        btnpolicy1.setTextColor(Color.WHITE);
        btncoverages.setBackgroundResource(R.color.my_policy_tab_light);
        btncoverages1.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
        btncontact.setBackgroundResource(R.drawable.linear_rounded_right_policy_tab_light);
        btncontact1.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
    }

    private void setBoxCoverages() {
        btnpolicy.setBackgroundResource(R.drawable.linear_rounded_left_policy_tab_light);
        btnpolicy1.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
        btncoverages.setBackgroundResource(R.color.my_policy_tab_dark);
        btncoverages1.setTextColor(Color.WHITE);
        btncontact.setBackgroundResource(R.drawable.linear_rounded_right_policy_tab_light);
        btncontact1.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
    }

    private void setBoxContact() {
        btnpolicy.setBackgroundResource(R.drawable.linear_rounded_left_policy_tab_light);
        btnpolicy1.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
        btncoverages.setBackgroundResource(R.color.my_policy_tab_light);
        btncoverages1.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
        btncontact.setBackgroundResource(R.drawable.linear_rounded_right_policy_tab_dark);
        btncontact1.setTextColor(Color.WHITE);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnpolicy:
                setBoxPolicy();
                viewPager.setCurrentItem(0);
                break;
            case R.id.btncoverages:
                setBoxCoverages();
                viewPager.setCurrentItem(1);
                break;
            case R.id.btncontact:
                setBoxContact();
                viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

    @Override
    public void onPageSelected(int position) {
        setSelection(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) { }

    private void setSelection(int position1) {
        switch (position1) {
            case 0:
                setBoxPolicy();
                break;
            case 1:
                setBoxCoverages();
                break;
            case 2:
                setBoxContact();
                break;
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.VIEW_UNIVERSAL_HEALTH_POLICY_DETAIL) {
            if (object.optString("Message").equals("Success"))
            {   if(!viewPager.isShown())
                viewPager.setVisibility(View.VISIBLE);
                prefrences.setPolicyInformation(object.toString());
                HealthPager adapter = new HealthPager(getChildFragmentManager(), 3);
                viewPager.setAdapter(adapter);
            } else {
                if(viewPager.isShown())
                    viewPager.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
