package com.universalsompo.meta.metaapp.health.fragment.weightlog.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.weightlog.adapter.LoggedWeightAdapter;
import com.universalsompo.meta.metaapp.health.fragment.weightlog.model.LoggedWeight;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentWeightLog extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference prefrences;
    private TextView last_logged_weight, last_logged_weight_days;
    private RecyclerView previous_log_weight_list;
    private final ArrayList<LoggedWeight> data = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_weight_log, container,false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).remove_elevation();
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    private void init(){
        last_logged_weight = v.findViewById(R.id.last_logged_weight);
        last_logged_weight_days = v.findViewById(R.id.last_logged_weight_days);
        LinearLayout log_weight = v.findViewById(R.id.log_weight);
        LinearLayout setting_of_target_weight = v.findViewById(R.id.setting_of_target_weight);
        previous_log_weight_list = v.findViewById(R.id.previous_log_weight_list);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(previous_log_weight_list.getContext(),
                getResources().getConfiguration().orientation);
        previous_log_weight_list.addItemDecoration(dividerItemDecoration);
        getuserlogweight();

        setting_of_target_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentSetYourTarget());
            }
        });

        log_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentLogWeight();
                Bundle args = new Bundle();
                args.putString("previous_weight", last_logged_weight.getText().toString());
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_WEIGHT_LOG);
            }
        });
    }

    private void getuserlogweight() {
        JSONObject object = new JSONObject();

        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
            object.put("UserID", prefrences.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_USER_WEIGHT_LIST, this, RequestHealthConstants.GET_USER_WEIGHT_LIST);
        req.execute();
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_USER_WEIGHT_LIST){
            if (object.optString("Message").equals("Success")){
                last_logged_weight.setText(object.optString("LastLogedWeight"));
                if(object.optString("LastLogedDate").equalsIgnoreCase("0 Days ago")){
                    last_logged_weight_days.setText("Today");
                } else {
                    last_logged_weight_days.setText(object.optString("LastLogedDate"));
                }
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("DboardUsersWeightList");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new LoggedWeight(
                                        obj.optString("Date"),
                                        obj.optString("ImagePath"),
                                        obj.optString("Weight")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    previous_log_weight_list.setLayoutManager(layoutManager);
                    LoggedWeightAdapter loggedWeightAdapter = new LoggedWeightAdapter(data);
                    previous_log_weight_list.setAdapter(loggedWeightAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private void replaceFragment(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_SET_YOUR_TARGET);
            binder.detect(FragmentsHealthTags.FRAGMENT_SET_YOUR_TARGET);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
