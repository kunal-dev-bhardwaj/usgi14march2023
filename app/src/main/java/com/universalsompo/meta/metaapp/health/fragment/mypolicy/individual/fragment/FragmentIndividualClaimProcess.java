package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.AssetPDFActivity;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Objects;

public class FragmentIndividualClaimProcess extends Fragment implements View.OnClickListener {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    private TextView btncashless;
    private TextView btnreimbursement;
    private LinearLayout btncashless1,btnreimbursement1;
    private LinearLayout cashless_layout,reimbursement_layout;
    private LinearLayout download_pdf;
    String policyID/*, insuranceID*/, insuranceName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_health_individual_process, container,false);
        prefrences = MySharedPreference.getInstance(getActivity());
        policyID = getArguments().getString("policyID");
        insuranceName = getArguments().getString("insuranceName");
        init();
        return v;
    }

    void init() {
        btncashless = v.findViewById(R.id.btncashless);
        btnreimbursement = v.findViewById(R.id.btnreimbursement);
        btncashless1 = v.findViewById(R.id.btncashless1);
        btnreimbursement1 = v.findViewById(R.id.btnreimbursement1);
        cashless_layout = v.findViewById(R.id.cashless_layout);
        reimbursement_layout = v.findViewById(R.id.reimbursement_layout);
        download_pdf = v.findViewById(R.id.download_pdf);

        btncashless.setOnClickListener(this);
        btnreimbursement.setOnClickListener(this);

        download_pdf.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), AssetPDFActivity.class);
            Objects.requireNonNull(getActivity()).startActivity(i);
        });
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.btncashless:
                setBoxAccidentalDeath();
                break;

            case R.id.btnreimbursement:
                setBoxDisablement();
                break;
        }
    }

    void setBoxAccidentalDeath() {
        btncashless1.setBackgroundResource(R.drawable.linear_rounded_left_claim_tab_dark);
        btncashless.setTextColor(Color.WHITE);
        btnreimbursement1.setBackgroundResource(R.drawable.linear_rounded_right_claim_tab_light);
        btnreimbursement.setTextColor(getResources().getColor(R.color.lightblack));
        cashless_layout.setVisibility(View.VISIBLE);
        reimbursement_layout.setVisibility(View.GONE);
    }

    void setBoxDisablement() {
        btncashless1.setBackgroundResource(R.drawable.linear_rounded_left_claim_tab_light);
        btncashless.setTextColor(getResources().getColor(R.color.lightblack));
        btnreimbursement1.setBackgroundResource(R.drawable.linear_rounded_right_claim_tab_dark);
        btnreimbursement.setTextColor(Color.WHITE);
        cashless_layout.setVisibility(View.GONE);
        reimbursement_layout.setVisibility(View.VISIBLE);
    }
}
