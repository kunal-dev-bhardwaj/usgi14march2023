package com.universalsompo.meta.metaapp.health.fragment.calculators;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONObject;

import java.util.Objects;

public class BloodPressureFragment extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private LinearLayout result;
    private EditText end_diastolic,end_systolic;
    private TextView tv_result_value_blue,
            tv_result_value_green,
            tv_result_value_orange,
            tv_result_value_red;
    private TextView tv_result_type_blue;
    private TextView tv_result_type_green;
    private TextView tv_result_type_orange;
    private TextView tv_result_type_red;
    private ImageView img_drop_low;
    private ImageView img_drop_low_risk;
    private ImageView img_drop_medium_risk;
    private ImageView img_drop_high_risk;
    private LinearLayout ll_result_green;
    private LinearLayout ll_result_orange;
    private LinearLayout ll_reult_red;
    private LinearLayout ll_result_blue;
    private int syst, desyst;
    private MySharedPreference pref;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_blood_pressure, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        end_diastolic = v.findViewById(R.id.end_diastolic);
        end_systolic = v.findViewById(R.id.end_systolic);
        ll_reult_red = v.findViewById(R.id.ll_reult_red);
        ll_result_orange = v.findViewById(R.id.ll_result_orange);
        ll_result_green = v.findViewById(R.id.ll_result_green);
        ll_result_blue = v.findViewById(R.id.ll_result_blue);
        tv_result_value_green = v.findViewById(R.id.tv_result_value_green);
        tv_result_value_orange = v.findViewById(R.id.tv_result_value_orange);
        tv_result_value_red = v.findViewById(R.id.tv_result_value_red);
        tv_result_value_blue = v.findViewById(R.id.tv_result_value_blue);
        tv_result_type_green = v.findViewById(R.id.tv_result_type_green);
        tv_result_type_orange = v.findViewById(R.id.tv_result_type_orange);
        tv_result_type_red = v.findViewById(R.id.tv_result_type_red);
        tv_result_type_blue = v.findViewById(R.id.tv_result_type_blue);
        img_drop_low_risk = v.findViewById(R.id.img_drop_low_risk);
        img_drop_low = v.findViewById(R.id.img_drop_low);
        img_drop_medium_risk = v.findViewById(R.id.img_drop_medium_risk);
        img_drop_high_risk = v.findViewById(R.id.img_drop_high_risk);
        clear_data.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.clear_data:
                end_diastolic.getText().clear();
                end_systolic.getText().clear();
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;

            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                if(end_systolic.getText().toString().isEmpty() || end_systolic.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please provide end systolic", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if(end_diastolic.getText().toString().isEmpty() || end_diastolic.getText().toString().equals("0")){
                    Toast.makeText(getActivity(), "Please provide end diastolic", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else {
                    result.setVisibility(View.VISIBLE);
                    syst = Integer.parseInt(end_systolic.getText().toString());
                    desyst = Integer.parseInt(end_diastolic.getText().toString());
                    if (syst < 120) {
                        tv_result_value_blue.setText(syst + "/" + desyst);
                        img_drop_low.setVisibility(View.VISIBLE);
                        img_drop_low_risk.setVisibility(View.INVISIBLE);
                        img_drop_medium_risk.setVisibility(View.INVISIBLE);
                        img_drop_high_risk.setVisibility(View.INVISIBLE);
                        ll_result_blue.setVisibility(View.VISIBLE);
                        ll_result_green.setVisibility(View.INVISIBLE);
                        ll_result_orange.setVisibility(View.INVISIBLE);
                        ll_reult_red.setVisibility(View.INVISIBLE);
                        tv_result_type_blue.setText("(Low)");
                    } else if (syst < 140) {
                        img_drop_low.setVisibility(View.INVISIBLE);
                        img_drop_low_risk.setVisibility(View.VISIBLE);
                        img_drop_medium_risk.setVisibility(View.INVISIBLE);
                        img_drop_high_risk.setVisibility(View.INVISIBLE);
                        ll_result_blue.setVisibility(View.INVISIBLE);
                        ll_result_green.setVisibility(View.VISIBLE);
                        ll_result_orange.setVisibility(View.INVISIBLE);
                        ll_reult_red.setVisibility(View.INVISIBLE);
                        tv_result_type_green.setText("(Normal)");
                        tv_result_value_green.setText(syst + "/" + desyst);
                    } else if ((syst == 140 )) {
                        img_drop_low.setVisibility(View.INVISIBLE);
                        img_drop_low_risk.setVisibility(View.INVISIBLE);
                        img_drop_medium_risk.setVisibility(View.VISIBLE);
                        img_drop_high_risk.setVisibility(View.INVISIBLE);
                        ll_result_blue.setVisibility(View.INVISIBLE);
                        ll_result_green.setVisibility(View.INVISIBLE);
                        ll_result_orange.setVisibility(View.VISIBLE);
                        ll_reult_red.setVisibility(View.INVISIBLE);
                        tv_result_type_orange.setText("(pre-hypertension)");
                        tv_result_value_orange.setText(syst + "/" +desyst);
                    } else {
                        img_drop_low.setVisibility(View.INVISIBLE);
                        img_drop_low_risk.setVisibility(View.INVISIBLE);
                        img_drop_medium_risk.setVisibility(View.INVISIBLE);
                        img_drop_high_risk.setVisibility(View.VISIBLE);
                        ll_result_blue.setVisibility(View.INVISIBLE);
                        ll_result_green.setVisibility(View.INVISIBLE);
                        ll_result_orange.setVisibility(View.INVISIBLE);
                        ll_reult_red.setVisibility(View.VISIBLE);
                        tv_result_type_red.setText("(hypertension)");
                        tv_result_value_red.setText(syst + "/" + desyst);
                    }
                }

                callApi();
                break;
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH,pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Systolic", syst);
            object.put("Diastolic", desyst);
            object.put("Result", (syst + "/" + desyst));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_HYPERTENSION, this, RequestHealthConstants.CALCULATOR_HYPERTENSION);
        req.execute();

    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_HYPERTENSION) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Blood pressure result","User successfully stored his blood pressure result " + syst + " / " + desyst);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Blood pressure result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
