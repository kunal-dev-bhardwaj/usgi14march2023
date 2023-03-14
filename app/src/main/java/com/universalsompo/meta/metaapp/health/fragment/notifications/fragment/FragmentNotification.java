package com.universalsompo.meta.metaapp.health.fragment.notifications.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;

public class FragmentNotification extends Fragment {
    View v;
    private SelectorListener binder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_notification, container, false);
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        init();
        return v;
    }

    void init() {
    }

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
