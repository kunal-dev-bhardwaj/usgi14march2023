package com.universalsompo.meta.metaapp.health.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.AyushPDFActivity;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.Objects;

public class FragmentHomeRemedies1 extends Fragment {
    View v;
    private SelectorListener binder;

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home_remedies1, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        ((MainActivityHealth) getActivity()).hidefooter();

        LinearLayout footer_layout = v.findViewById(R.id.footer_layout);
        footer_layout.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), AyushPDFActivity.class);
            Objects.requireNonNull(getActivity()).startActivity(i);
        });
        return v;
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

    private void replaceFragment(Fragment frag) {
        FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HOME_REMEDIES);
        binder.detect(FragmentsHealthTags.FRAGMENT_HOME_REMEDIES);
    }
}
