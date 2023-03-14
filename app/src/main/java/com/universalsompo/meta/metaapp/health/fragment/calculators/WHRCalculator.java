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

public class WHRCalculator extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private EditText hip,waist;
    private LinearLayout result;
    private LinearLayout ll_reult_red;
    private LinearLayout ll_result_orange;
    private LinearLayout ll_result_green;
    private TextView tv_result_value_green;
    private TextView tv_result_value_orange;
    private TextView tv_result_value_red;
    private TextView tv_result_type_green;
    private TextView tv_result_type_orange;
    private TextView tv_result_type_red;
    private ImageView img_drop_low_risk;
    private ImageView img_drop_medium_risk;
    private ImageView img_drop_high_risk;
    private double whr1;
    private String gender;
    private MySharedPreference pref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.whr_calc_fragment, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init(){
        gender = pref.getgender();
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
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        hip = v.findViewById(R.id.hip);
        waist = v.findViewById(R.id.waist);
        clear_data.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.clear_data:
                hip.getText().clear();
                waist.getText().clear();
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;
            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                result.setVisibility(View.VISIBLE);
                if (waist.getText().toString().isEmpty() || waist.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter your waist size", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (hip.getText().toString().isEmpty() || hip.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter your hip size", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else {
                    double waist_size = Double.parseDouble(waist.getText().toString());
                    double hip_size = Double.parseDouble(hip.getText().toString());
                    double whr = waist_size / hip_size;
                    String whr_string = new DecimalFormat("##.##").format(whr);
                    whr1 = Double.parseDouble(whr_string);
                    if (gender.equals("Female")) {
                        if (whr1 <= 0.80) {
                            img_drop_low_risk.setVisibility(View.VISIBLE);
                            img_drop_medium_risk.setVisibility(View.INVISIBLE);
                            img_drop_high_risk.setVisibility(View.INVISIBLE);
                            ll_result_green.setVisibility(View.VISIBLE);
                            ll_result_orange.setVisibility(View.INVISIBLE);
                            ll_reult_red.setVisibility(View.INVISIBLE);
                            tv_result_value_green.setText(String.valueOf(whr1));
                            tv_result_type_green.setText(" (Low risk)");
                        } else if ((whr1 > 0.81 && whr1 < 0.85)) {
                            img_drop_medium_risk.setVisibility(View.VISIBLE);
                            img_drop_low_risk.setVisibility(View.INVISIBLE);
                            img_drop_high_risk.setVisibility(View.INVISIBLE);
                            ll_reult_red.setVisibility(View.INVISIBLE);
                            ll_result_green.setVisibility(View.INVISIBLE);
                            ll_result_orange.setVisibility(View.VISIBLE);
                            tv_result_value_orange.setText(String.valueOf(whr1));
                            tv_result_type_orange.setText(" (Moderate risk)");
                        } else if (whr1 >= 0.85) {
                            img_drop_high_risk.setVisibility(View.VISIBLE);
                            img_drop_low_risk.setVisibility(View.INVISIBLE);
                            img_drop_medium_risk.setVisibility(View.INVISIBLE);
                            ll_reult_red.setVisibility(View.VISIBLE);
                            ll_result_green.setVisibility(View.INVISIBLE);
                            ll_result_orange.setVisibility(View.INVISIBLE);
                            tv_result_value_red.setText(String.valueOf(whr1));
                            tv_result_type_red.setText(" (High risk)");
                        }
                    } else {
                        if (whr1 <= 0.95) {
                            img_drop_low_risk.setVisibility(View.VISIBLE);
                            img_drop_medium_risk.setVisibility(View.INVISIBLE);
                            img_drop_high_risk.setVisibility(View.INVISIBLE);
                            ll_result_green.setVisibility(View.VISIBLE);
                            ll_result_orange.setVisibility(View.INVISIBLE);
                            ll_reult_red.setVisibility(View.INVISIBLE);
                            tv_result_value_green.setText(String.valueOf(whr1));
                            tv_result_type_green.setText(" (Low risk)");
                        } else if ((whr1 > .96 && whr1 <= 1)) {
                            img_drop_medium_risk.setVisibility(View.VISIBLE);
                            img_drop_low_risk.setVisibility(View.INVISIBLE);
                            img_drop_high_risk.setVisibility(View.INVISIBLE);
                            ll_reult_red.setVisibility(View.INVISIBLE);
                            ll_result_green.setVisibility(View.INVISIBLE);
                            ll_result_orange.setVisibility(View.VISIBLE);
                            tv_result_value_orange.setText(String.valueOf(whr1));
                            tv_result_type_orange.setText(" (Moderate risk)");
                        } else if (whr1 > 1) {
                            img_drop_high_risk.setVisibility(View.VISIBLE);
                            img_drop_low_risk.setVisibility(View.INVISIBLE);
                            img_drop_medium_risk.setVisibility(View.INVISIBLE);
                            ll_reult_red.setVisibility(View.VISIBLE);
                            ll_result_green.setVisibility(View.INVISIBLE);
                            ll_result_orange.setVisibility(View.INVISIBLE);
                            tv_result_value_red.setText(String.valueOf(whr1));
                            tv_result_type_red.setText(" (High risk)");
                        }
                        callApi();
                    }
                }
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Waist", waist.getText().toString());
            object.put("Hip", hip.getText().toString());
            object.put("Result", whr1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_WHR, this, RequestHealthConstants.CALCULATOR_WHR);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_WHR) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","WHR result","User successfully saved his WHR result " + whr1);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","WHR result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
