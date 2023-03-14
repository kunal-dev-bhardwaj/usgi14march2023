package com.universalsompo.meta.metaapp.health.fragment.profile.mychallenges.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

public class FragmentSweatItOut extends Fragment {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_health_sweat_it_out, container,false);
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    void init() {}

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }
}
