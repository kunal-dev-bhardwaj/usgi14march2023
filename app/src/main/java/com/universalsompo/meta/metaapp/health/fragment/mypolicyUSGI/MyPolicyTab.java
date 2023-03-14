package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.FragmentHealthProfile;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class MyPolicyTab extends Fragment implements View.OnClickListener, ResponseListener {
    private View view1;
    private View view2;
    private TextView btn_own_policy;
    private TextView btn_other_policy;
    private LinearLayout navigate_motor;
    int day_left_to_expire;
    private MySharedPreference prefrences;
    private final ArrayList<MyHealthPolicyModel> data1 = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View v = inflater.inflate(R.layout.fragment_policy_health_tab, container, false);
        prefrences = MySharedPreference.getInstance(getActivity());
        btn_own_policy = v.findViewById(R.id.btn_own_policy);
        btn_other_policy = v.findViewById(R.id.btn_other_policy);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);
        navigate_motor = v.findViewById(R.id.liner_txt);
        if (bundle !=null&& bundle.containsKey("otherFrag")){
            ((MainActivityHealth) requireActivity()).hidenav();
            ((MainActivityHealth) getActivity()).hidefooter();
            ((MainActivityHealth) getActivity()).remove_elevation();
            int fragNo = bundle.getInt("otherFrag");
            if (bundle.getInt("otherFrag") == 1){
                navigate_motor.setVisibility(View.GONE);
            }
            if (bundle.getInt("otherFrag1") == 2){
                navigate_motor.setVisibility(View.GONE);

            } if (bundle.getInt("otherFrag1") == 0){
                navigate_motor.setVisibility(View.GONE);

            }else {
                navigate_motor.setVisibility(View.VISIBLE);
            }

            if (fragNo==0){
                selectOther();
            } else {
                initListener();
            }

        }
        if (bundle !=null&& bundle.containsKey("otherFrag1")){
            ((MainActivity) requireActivity()).remove_elevation();
            int fragNo = bundle.getInt("otherFrag1");
            if (fragNo==0){
                selectOther();
            } else {
                initListener();
            }
            navigate_motor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new FragmentPolicy(), FragmentsTags.POLICY_FRAGMENT);
                }
            });

            init();
        }
        return v;
    }
    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equalsIgnoreCase(FragmentsTags.POLICY_FRAGMENT)){
                Bundle args = new Bundle();
                args.putInt("otherFrag3", 1);
                frag.setArguments(args);
            }
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame, Tag);

        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
    private void replaceFragment1(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equalsIgnoreCase(FragmentsHealthTags.FRAGMENT_HEALTH_POLICY)) {
                Bundle args = new Bundle();
                args.putInt("otherFrag3", 1);
                frag.setArguments(args);
            }
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame, Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void initListener() {
        selectOwn();
    }

    private void selectOwn() {
        btn_own_policy.setTextColor(ContextCompat.getColor(requireActivity(), R.color.tab_text));
        btn_other_policy.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
        view2.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.tab_text);
        FragmentMetaOwnPolicyHealth fragmentMetaOwnPolicy = new FragmentMetaOwnPolicyHealth();
        btn_own_policy.setOnClickListener(this);
        btn_other_policy.setOnClickListener(this);
        addFragment(fragmentMetaOwnPolicy);
    }

    private void selectOther() {
        btn_own_policy.setOnClickListener(this);
        btn_other_policy.setOnClickListener(this);
        btn_own_policy.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
        btn_other_policy.setTextColor(ContextCompat.getColor(requireActivity(), R.color.tab_text));
        view2.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.grey);
        addFragment(new FragmentLinkNewPolicyHealth());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_own_policy:
                selectOwn();
                break;

            case R.id.btn_other_policy:
                selectOther();
                break;
        }
    }

    private void init() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("UserID", prefrences.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlHealthConstants.UNIVERSAL_HEALTH_POLICY, this, RequestHealthConstants.UNIVERSAL_HEALTH_POLICY);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (object.optString("Message").equals("Success")) {
            if (Tag == RequestHealthConstants.UNIVERSAL_HEALTH_POLICY) {
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("UnivSompoHealthPolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                        String RemainingDay = arr.optJSONObject(i).getString("RemainingDay");
                        day_left_to_expire = Integer.parseInt(RemainingDay);
                        if (day_left_to_expire < 1) {
                        }else {
                            data1.add(
                                    new MyHealthPolicyModel(
                                            arr.optJSONObject(i).optString("ClaimContactNumber"),
                                            arr.optJSONObject(i).optString("ClaimEmailID"),
                                            arr.optJSONObject(i).optString("Composition"),
                                            arr.optJSONObject(i).optString("ExpiryDate"),
                                            arr.optJSONObject(i).optString("InsCompLogoPath"),
                                            arr.optJSONObject(i).optString("InsCompName"),
                                            arr.optJSONObject(i).optString("IsClaimInitiated"),
                                            arr.optJSONObject(i).optString("PolicyID"),
                                            arr.optJSONObject(i).optString("Policy_Category"),
                                            arr.optJSONObject(i).optString("Policy_Holder_Name"),
                                            arr.optJSONObject(i).optString("Policy_Number"),
                                            arr.optJSONObject(i).optString("Premium"),
                                            arr.optJSONObject(i).optString("Product_Name"),
                                            arr.optJSONObject(i).optString("RemainingDay"),
                                            arr.optJSONObject(i).optString("SumInsured")
                                    )
                            );
                        }
                    }
                    if (data1.size() == 0) {
                        navigate_motor.setVisibility(View.GONE);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private void addFragment(Fragment frg) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.policy_container, frg);
        childFragTrans.commit();
    }
}
