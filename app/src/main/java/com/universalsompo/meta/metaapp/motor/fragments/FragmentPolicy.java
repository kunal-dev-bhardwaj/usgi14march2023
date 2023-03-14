package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.MyPolicyTab;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.intefaces.Interface3;
import com.universalsompo.meta.metaapp.intefaces.PolicyBackPressCallback;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentPolicy extends Fragment implements View.OnClickListener, Interface3, PolicyBackPressCallback, ResponseListener {
    private View view1;
    private View view2;
    private static View view3;
    private TextView navigate_health;
    private TextView btn_own_policy;
    private TextView btn_other_policy;
    private static ImageView policy_filter_img;
    private SelectorListener binder;
    private FragmentMetaOwnPolicy fragmentMetaOwnPolicy;
    private int filterImagePosition;
    private int actionBarHeight;
    private Dialog dialog;
    private final ArrayList<MyPolicyModel> data1 = new ArrayList<>();
    int day_left_to_expire;
    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View v = inflater.inflate(R.layout.fragment_policy, container, false);
        ((MainActivity) requireActivity()).remove_elevation();
        btn_own_policy = v.findViewById(R.id.btn_own_policy);
        btn_other_policy = v.findViewById(R.id.btn_other_policy);
        policy_filter_img = v.findViewById(R.id.policy_filter_img);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);
        view3 = v.findViewById(R.id.view3);
        navigate_health = v.findViewById(R.id.navigate_health);

        navigate_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(), "Dashboard", "Marketplace", "User clicked on insurance vault tab");
                replaceFragment(new MyPolicyTab(), FragmentsHealthTags.FRAGMENT_HEALTH_POLICY);
            }
        });

        filterImagePosition = policy_filter_img.getTop();
        if (bundle !=null&& bundle.containsKey("otherFrag")){
            ((MainActivity) requireActivity()).remove_elevation();
            int fragNo = bundle.getInt("otherFrag");
            if (fragNo==0){
                selectOther();
            } else {
                initListener();
            }
        }

        if (bundle !=null&& bundle.containsKey("otherFrag3")){
            int fragNo = bundle.getInt("otherFrag3");
            if (fragNo==0){
                selectOther();
            } else {
                initListener();
            }
        }
        TypedValue tv = new TypedValue();
        if (getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }

        init();
        return v;
    }
    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equalsIgnoreCase(FragmentsHealthTags.FRAGMENT_HEALTH_POLICY)) {
                Bundle args = new Bundle();
                args.putInt("otherFrag1", 1);
                frag.setArguments(args);
            }
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
    public void show_filter() {
        policy_filter_img.setVisibility(View.VISIBLE);
    }

    private void initListener() {
        selectOwn();
    }

    private void selectOwn() {
        btn_own_policy.setTextColor(ContextCompat.getColor(requireActivity(), R.color.tab_text));
        btn_other_policy.setTextColor(ContextCompat.getColor(getActivity(), R.color.lightblack));
        view2.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.tab_text);
        fragmentMetaOwnPolicy = new FragmentMetaOwnPolicy();
        filtericonVisibility(false);
        requireActivity().setFinishOnTouchOutside(true);
        btn_own_policy.setOnClickListener(this);
        btn_other_policy.setOnClickListener(this);
        policy_filter_img.setOnClickListener(this);
        addFragment(fragmentMetaOwnPolicy);
        filtericonVisibility(true);
        getActivity().setFinishOnTouchOutside(true);
        addFragment(fragmentMetaOwnPolicy);
    }

    private void selectOther() {
        btn_own_policy.setOnClickListener(this);
        btn_other_policy.setOnClickListener(this);
        policy_filter_img.setOnClickListener(this);
        btn_own_policy.setTextColor(ContextCompat.getColor(requireActivity(), R.color.lightblack));
        btn_other_policy.setTextColor(ContextCompat.getColor(getActivity(), R.color.tab_text));
        view2.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.grey);
        addFragment(new FragmentLinkNewPolicy2());
    }

    private void showFilterDialog(Context context, int x, int y) {
        dialog = new Dialog(context) {
            @Override
            public boolean onTouchEvent(@NonNull MotionEvent event) {
                // Tap anywhere to close dialog.
                this.dismiss();
                return true;
            }
        };
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.filter_policy_type_dailog);
        dialog.setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.END;
        dialog.setCancelable(true);
        dialog.getWindow().setAttributes(lp);
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.x = x;
        wmlp.y = y;
        LinearLayout filter_head_llayout = dialog.findViewById(R.id.filter_head_llayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, actionBarHeight + filterImagePosition, 0, 0);
        filter_head_llayout.setLayoutParams(params);
        ImageView two_wheeler_img = dialog.findViewById(R.id.two_wheeler_img);
        two_wheeler_img.setOnClickListener(v -> {
            fragmentMetaOwnPolicy.filteration("TW");
            dialog.dismiss();
        });
        ImageView four_wheeler_img = dialog.findViewById(R.id.four_wheeler_img);
        four_wheeler_img.setOnClickListener(v -> {
            fragmentMetaOwnPolicy.filteration("FW");
            dialog.dismiss();
        });

        TextView all_wheeler_img = dialog.findViewById(R.id.all_wheeler_img);
        all_wheeler_img.setOnClickListener(v -> {
            fragmentMetaOwnPolicy.filteration("All");
            dialog.dismiss();
        });

        dialog.show();

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

            case R.id.policy_filter_img:
                showFilterDialog(getActivity(), Math.round(v.getX()) - (v.getWidth() * 2),
                        v.getTop() + (v.getHeight()));
                break;
        }
    }

    public  static void filtericonVisibility(boolean flag) {
        if (flag) {
            policy_filter_img.setVisibility(View.VISIBLE);
            view3.setVisibility(View.VISIBLE);
        } else {
            policy_filter_img.setVisibility(View.GONE);
            view3.setVisibility(View.GONE);
        }
    }

    private void addFragment(Fragment frg) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.policy_container, frg);
        childFragTrans.commit();
    }

    @Override
    public void getSelect(int position) {
        binder.detect(FragmentsTags.CLAIM_FRAGMENT);
    }

    @Override
    public void changeFragment(String tag) {
        if (tag.equalsIgnoreCase("Own Policy"))
            selectOwn();
    }
    private void init() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("UserID", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.UNIVERSAL_POLICY, this, RequestConstants.UNIVERSAL_POLICY);
        req.execute();
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.UNIVERSAL_POLICY) {
            new AppDataPushApi().callApi(getActivity(),"Policy Vault","Policy vault page","User checked his list of policies in vault");
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = object.getJSONArray("objPolicyList");
                    for (int i = 0; i < arr.length(); i++) {
                        String NoOfDaysLeft = arr.optJSONObject(i).getString("NoOfDaysLeft");
                        day_left_to_expire = Integer.parseInt(NoOfDaysLeft);
                        if (day_left_to_expire < 1) {
                        } else {
                            JSONObject obj = arr.getJSONObject(i);
                            data1.add(
                                    new MyPolicyModel(
                                            obj.optString("ChasisNo"),
                                            obj.optString("ClientUserID"),
                                            obj.optString("CoverageDetails"),
                                            obj.optString("EngineNo"),
                                            obj.optString("IDV"),
                                            obj.optString("InsCompContactNo"),
                                            obj.optString("InsCompID"),
                                            obj.optString("InsCompName"),
                                            obj.optString("InsCompURL"),
                                            obj.optString("IsClaimInitiated"),
                                            obj.optString("Make"),
                                            obj.optString("ManufacturingYear"),
                                            obj.optString("Model"),
                                            obj.optString("NoOfDaysLeft"),
                                            obj.optString("PolicyDoc"),
                                            obj.optString("PolicyHolderName"),
                                            obj.optString("PolicyID"),
                                            obj.optString("PolicyNumber"),
                                            obj.optString("PolicyStartDate"),
                                            obj.optString("PolicyToDate"),
                                            obj.optString("PolicyType"),
                                            obj.optString("Premium"),
                                            obj.optString("RegistrationNumber"),
                                            obj.optString("Riders"),
                                            obj.optString("Variant"),
                                            obj.optString("VehicleClass"),
                                            obj.optString("VehicleType")
                                    )
                            );

                        }
                    }
                    if (data1.size() == 0) {
                        navigate_health.setVisibility(View.GONE);
                    }else {
                        navigate_health.setVisibility(View.VISIBLE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
