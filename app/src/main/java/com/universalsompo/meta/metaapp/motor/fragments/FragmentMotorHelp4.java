package com.universalsompo.meta.metaapp.motor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.google.android.material.snackbar.Snackbar;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONObject;

import java.util.Objects;

public class FragmentMotorHelp4 extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private String name, id_help1, id_help2, id_help3, id_help4;
    private EditText message;
    private MySharedPreference mySharedPreference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_motor_help_4, container, false);
        assert getArguments() != null;
        name = getArguments().getString("name");
        id_help1 = getArguments().getString("id_help1");
        id_help2 = getArguments().getString("id_help2");
        id_help3 = getArguments().getString("id_help3");
        id_help4 = getArguments().getString("id_help4");
        mySharedPreference = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    private void init() {
        TextView category_name = v.findViewById(R.id.category_name);
        message = v.findViewById(R.id.message);
        Button submit = v.findViewById(R.id.submit);
        category_name.setText(name);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.submit) {
            callApi();
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
            object.put("CategoryID1", id_help1);
            object.put("CategoryID2", id_help2);
            object.put("CategoryID3", id_help3);
            object.put("CategoryID4", id_help4);
            object.put("Comment", message.getText().toString());
            object.put("FileInBase64", "");
            object.put("FileExt", "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.SAVE_HELP, this, RequestConstants.SAVE_HELP);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.SAVE_HELP) {
            new AppDataPushApi().callApi(getActivity(),"Help","Help page","User facing problem in " + id_help1 + " -> " + id_help2 + " -> " + id_help3 + " -> " + id_help4 + " & submitted his issue");
            try {
                Snackbar.make(Objects.requireNonNull(getView()), "Your request sent successfully", Snackbar.LENGTH_LONG).show();
                ((MainActivity) Objects.requireNonNull(getActivity())).changeFragmnet();
            } catch (Exception npe) {
                npe.printStackTrace();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
