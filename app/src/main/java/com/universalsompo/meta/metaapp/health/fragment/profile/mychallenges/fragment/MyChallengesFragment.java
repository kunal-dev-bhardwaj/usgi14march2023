package com.universalsompo.meta.metaapp.health.fragment.profile.mychallenges.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
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
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONObject;

public class MyChallengesFragment extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    /*private WrappingGridView list,list1;*/
    private TextView global_challenge, corporate_challenge;
    private LinearLayout sweat_it_out;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my_challenges, container, false);
        ((MainActivityHealth) getActivity()).show_elevation();
        init();
        return v;
    }

    private void init() {
        /*list = (WrappingGridView) v.findViewById(R.id.list);
        list1 = (WrappingGridView) v.findViewById(R.id.list1);*/
        global_challenge = v.findViewById(R.id.global_challenge);
        corporate_challenge = v.findViewById(R.id.corporate_challenge);
        sweat_it_out = v.findViewById(R.id.sweat_it_out);

        sweat_it_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentSweatItOut(), FragmentsHealthTags.FRAGMENT_SWEAT_IT_OUT);
            }
        });

        // getmychallenges();
    }

    /*public void getmychallenges() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, RequestHealthConstants.TOKEN_NO_VALUE);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_MY_CHALLENGES, this, RequestHealthConstants.GET_MY_CHALLENGES);
        req.execute();
    }*/

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {

    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
