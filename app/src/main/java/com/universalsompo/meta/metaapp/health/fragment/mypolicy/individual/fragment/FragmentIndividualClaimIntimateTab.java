package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.FragmentHealthClaimIntimation;

import java.util.Objects;

public class FragmentIndividualClaimIntimateTab extends Fragment implements View.OnClickListener {
    View v;
    String policyID/*, insuranceID*/, insuranceName;
    private LinearLayout a1, b1, c1, d1, e1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_individual_claim_intimate_tab, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).remove_elevation();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).hidenav();
        assert getArguments() != null;
        policyID = getArguments().getString("policyID");
        // insuranceID = getArguments().getString("insuranceID");
        insuranceName = getArguments().getString("insuranceName");
        init();
        return v;
    }

    void init() {
        ImageView img1 = v.findViewById(R.id.img1);
        ImageView img2 = v.findViewById(R.id.img2);
        ImageView img3 = v.findViewById(R.id.img3);
        ImageView img4 = v.findViewById(R.id.img4);
        ImageView img5 = v.findViewById(R.id.img5);
        a1 = v.findViewById(R.id.a);
        b1 = v.findViewById(R.id.b);
        c1 = v.findViewById(R.id.c);
        d1 = v.findViewById(R.id.d);
        e1 = v.findViewById(R.id.e);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);

        addFragment(new FragmentIndividualClaimProcess(), policyID/*, insuranceID*/, insuranceName);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.img1:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));

                addFragment(new FragmentIndividualClaimProcess(), policyID/*, insuranceID*/, insuranceName);
                break;

            case R.id.img2:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));

                addFragment(new FragmentIndividualClaimContact(), policyID/*, insuranceID*/, insuranceName);
                break;

            case R.id.img3:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));

                //Toast.makeText(getActivity(), "Functionality disabled", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentIndividualClaimHospital(), policyID/*, insuranceID*/, insuranceName);
                break;

            case R.id.img4:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));

                addFragment(new FragmentIndividualClaimForm(), policyID/*, insuranceID*/, insuranceName);
                break;

            case R.id.img5:
                a1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                b1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                c1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));
                d1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.pastel_yellow));
                e1.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightish_grey));

                addFragment(new FragmentHealthClaimIntimation(), policyID/*, insuranceID*/, insuranceName);
                break;
        }
    }

    void addFragment(Fragment frg, String policyid/*, String insuranceid*/, String insurancename) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        Bundle args = new Bundle();
        args.putString("policyID", policyid);
        // args.putString("insuranceID", insuranceid);
        args.putString("insuranceName", insurancename);
        frg.setArguments(args);
        childFragTrans.replace(R.id.health_corporate_policy_container_5, frg);
        childFragTrans.commit();
    }
}
