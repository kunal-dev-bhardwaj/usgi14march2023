package com.universalsompo.meta.metaapp.health.fragment.calculators;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
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
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Objects;

public class CholestrolCalcFragment extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private LinearLayout result;
    private EditText ldl,hdl,triglycerides;
    private double ldl1,hdl1,triglycerides1;
    private ImageView img_drop_low_risk;
    private ImageView img_drop_medium_risk;
    private ImageView img_drop_high_risk;
    private LinearLayout ll_reult_red;
    private LinearLayout ll_result_orange;
    private LinearLayout ll_result_green;
    private TextView tv_result_value_green;
    private TextView tv_result_value_orange;
    private TextView tv_result_value_red;
    private TextView tv_result_type_green;
    private TextView tv_result_type_orange;
    private TextView tv_result_type_red;
    private double cholestrol_string1;
    private MySharedPreference pref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_cholestrol_calc,container, false);
        pref = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        ldl = v.findViewById(R.id.ldl);
        hdl = v.findViewById(R.id.hdl);
        triglycerides = v.findViewById(R.id.triglycerides);
        ll_reult_red = v.findViewById(R.id.ll_reult_red);
        ll_result_orange = v.findViewById(R.id.ll_result_orange);
        ll_result_green = v.findViewById(R.id.ll_result_green);
        tv_result_value_green = v.findViewById(R.id.tv_result_value_green);
        tv_result_value_orange = v.findViewById(R.id.tv_result_value_orange);
        tv_result_value_red = v.findViewById(R.id.tv_result_value_red);
        tv_result_type_green = v.findViewById(R.id.tv_result_type_green);
        tv_result_type_orange = v.findViewById(R.id.tv_result_type_orange);
        tv_result_type_red = v.findViewById(R.id.tv_result_type_red);
        img_drop_low_risk = v.findViewById(R.id.img_drop_low_risk);
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
                ldl.getText().clear();
                hdl.getText().clear();
                triglycerides.getText().clear();
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;

            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                if (ldl.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please enter LDL", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (hdl.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please entre HDL", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(ldl.getText().toString()) < 0) {
                    Toast.makeText(getContext(), "Please enter LDL", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(ldl.getText().toString()) == 0) {
                    Toast.makeText(getContext(), "LDL can not be 0", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(hdl.getText().toString()) < 0) {
                    Toast.makeText(getContext(), "Please enter HDL", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(hdl.getText().toString()) == 0) {
                    Toast.makeText(getContext(), "HDL can not be 0", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (ldl.getText().toString().trim().length() < 2) {
                    Toast.makeText(getContext(), "Please enter minimum 2 digit value", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (hdl.getText().toString().trim().length() < 2) {
                    Toast.makeText(getContext(), "Please enter minimum 2 digit value", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (triglycerides.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please enter triglycerides", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(triglycerides.getText().toString()) < 0) {
                    Toast.makeText(getContext(), "Please enter triglycerides", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(triglycerides.getText().toString()) == 0) {
                    Toast.makeText(getContext(), "Triglycerides can not be 0", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (triglycerides.getText().toString().trim().length() < 2) {
                    Toast.makeText(getContext(), "Please enter minimum 2 digit value", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else {
                    result.setVisibility(View.VISIBLE);
                    ldl1 = Double.parseDouble(ldl.getText().toString());
                    hdl1 = Double.parseDouble(hdl.getText().toString());
                    triglycerides1 = Double.parseDouble(triglycerides.getText().toString());
                    double cholestrolcalc = hdl1 + ldl1 + 0.2 * triglycerides1;
                    String cholestrol_string = new DecimalFormat("##.##").format(cholestrolcalc);
                    cholestrol_string1 = Double.parseDouble(cholestrol_string);
                    if (cholestrol_string1 <= 200.0) {
                        img_drop_low_risk.setVisibility(View.VISIBLE);
                        img_drop_medium_risk.setVisibility(View.INVISIBLE);
                        img_drop_high_risk.setVisibility(View.INVISIBLE);
                        ll_result_green.setVisibility(View.VISIBLE);
                        ll_result_orange.setVisibility(View.INVISIBLE);
                        ll_reult_red.setVisibility(View.INVISIBLE);
                        tv_result_value_green.setText(String.valueOf(cholestrol_string1));
                        tv_result_type_green.setText(" (Desirable)");
                    } else if ((cholestrol_string1 > 200.0 && cholestrol_string1 < 239.0)) {
                        img_drop_medium_risk.setVisibility(View.VISIBLE);
                        img_drop_low_risk.setVisibility(View.INVISIBLE);
                        img_drop_high_risk.setVisibility(View.INVISIBLE);
                        ll_reult_red.setVisibility(View.INVISIBLE);
                        ll_result_green.setVisibility(View.INVISIBLE);
                        ll_result_orange.setVisibility(View.VISIBLE);
                        tv_result_value_orange.setText(String.valueOf(cholestrol_string1));
                        tv_result_type_orange.setText(" (Borderline High)");
                    } else if (cholestrol_string1 >= 240.0) {
                        img_drop_high_risk.setVisibility(View.VISIBLE);
                        img_drop_low_risk.setVisibility(View.INVISIBLE);
                        img_drop_medium_risk.setVisibility(View.INVISIBLE);
                        ll_reult_red.setVisibility(View.VISIBLE);
                        ll_result_green.setVisibility(View.INVISIBLE);
                        ll_result_orange.setVisibility(View.INVISIBLE);
                        tv_result_value_red.setText(String.valueOf(cholestrol_string1));
                        tv_result_type_red.setText(" (High)");
                    }

                    callApi();
                }
                break;
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("LDL", ldl1);
            object.put("HDL", hdl1);
            object.put("Triglycerides", triglycerides1);
            object.put("Result", cholestrol_string1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_CHOLESTROL_RISK, this, RequestHealthConstants.CALCULATOR_CHOLESTROL_RISK);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_CHOLESTROL_RISK) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Cholestrol risk result","User successfully stored his cholestrol risk result " + cholestrol_string1);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Cholestrol risk result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
