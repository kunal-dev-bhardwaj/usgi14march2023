package com.universalsompo.meta.metaapp.motor.fragments;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.PressNonBackPress;
import com.universalsompo.meta.metaapp.motor.adapters.Pager;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.PolicyBackPressCallback;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.CustomTextView1;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Objects;

public class FragmentMetaOwnPolicyDetail extends Fragment implements ResponseListener, PressNonBackPress, ViewPager.OnPageChangeListener, View.OnClickListener {
    private View v;
    private MySharedPreference prefrences;
    private ViewPager viewPager;
    private CustomTextView1 btnpolicy1;
    private CustomTextView1 btnvehicle1;
    private CustomTextView1 btndocument1;
    private LinearLayout btnpolicy;
    private LinearLayout btnvehicle;
    private LinearLayout btndocument;
    private TextView no_data_txtView;
    private PolicyBackPressCallback policyBackPressCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_meta_own_policy_tab, container, false);
        initView();
        return v;
    }

    private void initView() {
        viewPager = v.findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        btnpolicy = v.findViewById(R.id.btnpolicy);
        btnvehicle = v.findViewById(R.id.btnvehicle);
        btndocument = v.findViewById(R.id.btndocument);
        btnpolicy1 = v.findViewById(R.id.btnpolicy1);
        btnvehicle1 = v.findViewById(R.id.btnvehicle1);
        btndocument1 = v.findViewById(R.id.btndocument1);
        no_data_txtView= v.findViewById(R.id.no_data);
        viewPager.addOnPageChangeListener(this);
        btnpolicy.setOnClickListener(this);
        btnvehicle.setOnClickListener(this);
        btndocument.setOnClickListener(this);
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
    }

    private void backPressedAction() {
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                policyBackPressCallback.changeFragment("Own Policy");
                return true;
            } else
                return false;
        });
    }

    private void init() {
        JSONObject jo = new JSONObject();
        try {
            jo.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
            jo.put("UserID", MySharedPreference.getInstance(getActivity()).getUID());
            jo.put("PolicyID", prefrences.getPID());
            jo.put("VehicleType", prefrences.getVehcileType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), jo, UrlConstants.VIEW_UNIVERSAL_POLICY_DETAIL, this, RequestConstants.VIEW_UNIVERSAL_POLICY_DETAIL);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.VIEW_UNIVERSAL_POLICY_DETAIL) {
            new AppDataPushApi().callApi(getActivity(),"Policy Detail","Policy detail page","User checked details of policy whose id " + prefrences.getPID());
            if (object.optString("Message").equals("Success"))
            {   if(!viewPager.isShown())
                viewPager.setVisibility(View.VISIBLE);
                if(no_data_txtView.isShown())
                    no_data_txtView.setVisibility(View.GONE);
                prefrences.setRenewalPolicyDetail(object.toString());
                Pager adapter = new Pager(getChildFragmentManager(), 3, policyBackPressCallback);
                viewPager.setAdapter(adapter);
            }
            else {
                backPressedAction();
                if(viewPager.isShown())
                    viewPager.setVisibility(View.GONE);
                if(!no_data_txtView.isShown())
                    no_data_txtView.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

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
                setBoxVehicle();
                break;
            case 2:
                setBoxDocument();
                break;
        }
    }

    private void setBoxPolicy() {
        btnpolicy.setBackgroundResource(R.drawable.linear_rounded_left_policy_tab_dark);
        btnpolicy1.setTextColor(Color.WHITE);
        btnvehicle.setBackgroundResource(R.color.my_policy_tab_light);
        btnvehicle1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        btndocument.setBackgroundResource(R.drawable.linear_rounded_right_policy_tab_light);
        btndocument1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
    }

    private void setBoxVehicle() {
        btnpolicy.setBackgroundResource(R.drawable.linear_rounded_left_policy_tab_light);
        btnpolicy1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        btnvehicle.setBackgroundResource(R.color.my_policy_tab_dark);
        btnvehicle1.setTextColor(Color.WHITE);
        btndocument.setBackgroundResource(R.drawable.linear_rounded_right_policy_tab_light);
        btndocument1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
    }

    private void setBoxDocument() {
        btnpolicy.setBackgroundResource(R.drawable.linear_rounded_left_policy_tab_light);
        btnpolicy1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        btnvehicle.setBackgroundResource(R.color.my_policy_tab_light);
        btnvehicle1.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        btndocument.setBackgroundResource(R.drawable.linear_rounded_right_policy_tab_dark);
        btndocument1.setTextColor(Color.WHITE);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnpolicy:
                setBoxPolicy();
                viewPager.setCurrentItem(0);
                break;
            case R.id.btnvehicle:
                setBoxVehicle();
                viewPager.setCurrentItem(1);
                break;
            case R.id.btndocument:
                setBoxDocument();
                viewPager.setCurrentItem(2);
                break;
        }
    }

    public void setFragmnet(PolicyBackPressCallback policyBackPressCallback) {
        this.policyBackPressCallback = policyBackPressCallback;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getActivity(), "testtt", Toast.LENGTH_SHORT).show();
        FragmentPolicy someFragment = new FragmentPolicy();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.policy_container, someFragment ); // give your fragment container id in first parameter
        transaction.commit();
    }

}
