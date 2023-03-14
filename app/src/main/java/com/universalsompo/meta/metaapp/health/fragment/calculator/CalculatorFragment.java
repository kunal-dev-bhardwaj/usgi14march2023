package com.universalsompo.meta.metaapp.health.fragment.calculator;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.calculators.FragmentCalculatorMenu;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentLinkNewPolicyHealth;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentMetaOwnPolicyHealth;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Objects;

public class CalculatorFragment extends Fragment implements View.OnClickListener {
    private View view1;
    private View view2;
    private TextView btn_own_policy;
    private TextView btn_other_policy;
    private MySharedPreference prefrences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_calculator, container, false);
        Bundle bundle = getArguments();
        if (bundle !=null&& bundle.containsKey("otherFrag")){
            ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
            ((MainActivityHealth) getActivity()).hidefooter();
            ((MainActivityHealth) getActivity()).remove_elevation();
        }
        int fragNo = bundle.getInt("otherFrag");
        prefrences = MySharedPreference.getInstance(getActivity());
        btn_own_policy = v.findViewById(R.id.btn_own_policy);
        btn_other_policy = v.findViewById(R.id.btn_other_policy);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);
        if (fragNo==0){
            selectOther();
        } else {
            initListener();
        }
        return v;
    }
    private void initListener() {
        selectOwn();
    }

    private void selectOwn() {
        btn_own_policy.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.tab_text));
        btn_other_policy.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        view2.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.tab_text);
        FragmentCalculatorMenu fragmentMetaOwnPolicy = new FragmentCalculatorMenu();
        btn_own_policy.setOnClickListener(this);
        btn_other_policy.setOnClickListener(this);
        addFragment(fragmentMetaOwnPolicy);
    }

    private void selectOther() {
        btn_own_policy.setOnClickListener(this);
        btn_other_policy.setOnClickListener(this);
        btn_own_policy.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
        btn_other_policy.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.tab_text));
        view2.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.grey);
        addFragment(new CalculatorInsurance());
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
    private void addFragment(Fragment frg) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.policy_container, frg);
        childFragTrans.commit();
    }
}