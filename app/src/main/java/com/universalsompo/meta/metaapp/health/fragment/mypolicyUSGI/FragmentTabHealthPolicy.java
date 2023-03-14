package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.HealthPolicyDetailModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

public class FragmentTabHealthPolicy extends Fragment {
    private View v;
    private MySharedPreference prefrences;
    private TextView policy_holder_name, insurer_name, product_name, policy_number, policy_category, expiry_date, sum_insured, premium, composition;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_health_policy_tab, container, false);
        prefrences = MySharedPreference.getInstance(getActivity());
        initView();
        return v;
    }

    private void initView() {
        policy_holder_name = v.findViewById(R.id.policy_holder_name);
        insurer_name = v.findViewById(R.id.insurer_name);
        product_name = v.findViewById(R.id.product_name);
        policy_number = v.findViewById(R.id.policy_number);
        policy_category = v.findViewById(R.id.policy_category);
        expiry_date = v.findViewById(R.id.expiry_date);
        sum_insured = v.findViewById(R.id.sum_insured);
        premium = v.findViewById(R.id.premium);
        composition = v.findViewById(R.id.composition);
        initializeData();
    }

    @SuppressLint("SetTextI18n")
    private void initializeData() {
        HealthPolicyDetailModel data = new Gson().fromJson(prefrences.getPolicyInformation(), HealthPolicyDetailModel.class);
        policy_holder_name.setText(data.getPolicy_Holder_Name());
        insurer_name.setText("Universal Sompo General Insurance Co. Ltd.");
        product_name.setText(data.getProduct_Name());
        policy_number.setText(data.getPolicy_Number());
        policy_category.setText(data.getPolicy_Category());
        expiry_date.setText(data.getPolicy_To_Date());
        sum_insured.setText(data.getSumInsured());
        premium.setText(data.getPremium());
        composition.setText(data.getComposition());
        prefrences.setIns_comp_ID_health(data.getInsCompID());
    }
}
