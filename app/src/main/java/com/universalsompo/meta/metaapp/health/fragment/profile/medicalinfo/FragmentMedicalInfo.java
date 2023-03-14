package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentFamilyHistory;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentMedicalHistory;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentMedicalRecords;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentStats;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import java.util.Objects;

public class FragmentMedicalInfo extends Fragment {
    private View v;
    private SelectorListener binder;
    private Menu menuGroup;
    MenuItem inviteMenuItem;
    private LinearLayout stats, medical_history, family_history, medical_records;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_medical_info, container,false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        stats = v.findViewById(R.id.stats);
        medical_history = v.findViewById(R.id.medical_history);
        family_history = v.findViewById(R.id.family_history);
        medical_records = v.findViewById(R.id.medical_records);
        
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment1(new FragmentStats(), FragmentsHealthTags.FRAGMENT_STATS);
            }
        });

        medical_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentMedicalHistory(), FragmentsHealthTags.FRAGMENT_MEDICAL_HISTORY);
            }
        });

        family_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentFamilyHistory(), FragmentsHealthTags.FRAGMENT_FAMILY_HISTORY);
            }
        });

        medical_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentMedicalRecords(), FragmentsHealthTags.FRAGMENT_MEDICAL_RECORDS);
            }
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

    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void replaceFragment1(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            Bundle args = new Bundle();
            args.putString("open_lipid_profile", "0");
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
