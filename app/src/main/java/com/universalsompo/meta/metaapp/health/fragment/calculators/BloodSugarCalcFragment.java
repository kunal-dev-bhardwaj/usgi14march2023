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

public class BloodSugarCalcFragment extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private LinearLayout result;
    private EditText sugar_fasting, sugar_pp;
    private LinearLayout ll_result_green;
    private LinearLayout ll_result_orange;
    private LinearLayout ll_reult_red;
    private TextView tv_result_value_green;
    private TextView tv_result_value_orange;
    private TextView tv_result_value_red;
    private TextView tv_result_type_green;
    private TextView tv_result_type_orange;
    private TextView tv_result_type_red;
    private ImageView img_drop_low_risk;
    private ImageView img_drop_medium_risk;
    private ImageView img_drop_high_risk;
    private LinearLayout ll_result_green_pp;
    private LinearLayout ll_result_orange_pp;
    private LinearLayout ll_result_red_pp;
    private TextView tv_result_value_green_pp;
    private TextView tv_result_value_orange_pp;
    private TextView tv_result_value_red_pp;
    private TextView tv_result_type_green_pp;
    private TextView tv_result_type_orange_pp;
    private TextView tv_result_type_red_pp;
    private ImageView img_drop_normal;
    private ImageView img_drop_pre_diabatic;
    private ImageView img_drop_diabtic;
    private MySharedPreference pref;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_blood_sugar_calc, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        sugar_fasting = v.findViewById(R.id.sugar_fasting);
        sugar_pp = v.findViewById(R.id.sugar_pp);
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
        img_drop_pre_diabatic = v.findViewById(R.id.img_drop_pre_diabatic);
        img_drop_diabtic = v.findViewById(R.id.img_drop_diabtic);
        ll_result_red_pp = v.findViewById(R.id.ll_reult_red_pp);
        ll_result_orange_pp = v.findViewById(R.id.ll_result_orange_pp);
        ll_result_green_pp = v.findViewById(R.id.ll_result_green_pp);
        tv_result_value_green_pp = v.findViewById(R.id.tv_result_value_green_pp);
        tv_result_value_orange_pp = v.findViewById(R.id.tv_result_value_orange_pp);
        tv_result_value_red_pp = v.findViewById(R.id.tv_result_value_red_pp);
        tv_result_type_green_pp = v.findViewById(R.id.tv_result_type_green_pp);
        tv_result_type_orange_pp = v.findViewById(R.id.tv_result_type_orange_pp);
        tv_result_type_red_pp = v.findViewById(R.id.tv_result_type_red_pp);
        img_drop_normal = v.findViewById(R.id.img_drop_normal);
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
                sugar_fasting.getText().clear();
                sugar_pp.getText().clear();
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;

            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                if (sugar_fasting.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please enter Fasting", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (sugar_pp.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please enter PP", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(sugar_fasting.getText().toString()) == 0) {
                    Toast.makeText(getContext(), "Fasting can not be 0", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(sugar_pp.getText().toString()) == 0) {
                    Toast.makeText(getContext(), "PP can not be 0", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (sugar_fasting.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Please enter blood sugar fasting ", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (sugar_pp.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Please enter blood sugar pp ", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else {
                    result.setVisibility(View.VISIBLE);
                    int sugarValue = Integer.parseInt(sugar_fasting.getText().toString());
                    int ppValue = Integer.parseInt(sugar_pp.getText().toString());
                    if (sugarValue < 110) {
                        ll_result_green.setVisibility(View.VISIBLE);
                        ll_result_orange.setVisibility(View.INVISIBLE);
                        ll_reult_red.setVisibility(View.INVISIBLE);
                        img_drop_medium_risk.setVisibility(View.INVISIBLE);
                        img_drop_high_risk.setVisibility(View.INVISIBLE);
                        img_drop_low_risk.setVisibility(View.VISIBLE);
                        tv_result_value_green.setText(sugar_fasting.getText().toString());
                        tv_result_type_green.setText(" (Normal)");
                    } else if (sugarValue <= 126) {
                        img_drop_medium_risk.setVisibility(View.VISIBLE);
                        img_drop_high_risk.setVisibility(View.INVISIBLE);
                        img_drop_low_risk.setVisibility(View.INVISIBLE);
                        ll_result_green.setVisibility(View.INVISIBLE);
                        ll_result_orange.setVisibility(View.VISIBLE);
                        ll_reult_red.setVisibility(View.INVISIBLE);
                        tv_result_value_orange.setText(sugar_fasting.getText().toString());
                        tv_result_type_orange.setText(" (Pre-diabetic)");
                    } else {
                        img_drop_medium_risk.setVisibility(View.INVISIBLE);
                        img_drop_high_risk.setVisibility(View.VISIBLE);
                        img_drop_low_risk.setVisibility(View.INVISIBLE);
                        ll_result_green.setVisibility(View.INVISIBLE);
                        ll_result_orange.setVisibility(View.INVISIBLE);
                        ll_reult_red.setVisibility(View.VISIBLE);
                        tv_result_value_red.setText(sugar_fasting.getText().toString());
                        tv_result_type_red.setText(" (Diabetic)");
                    }

                    if (ppValue < 140) {
                        ll_result_green_pp.setVisibility(View.VISIBLE);
                        ll_result_orange_pp.setVisibility(View.INVISIBLE);
                        ll_result_red_pp.setVisibility(View.INVISIBLE);
                        img_drop_diabtic.setVisibility(View.INVISIBLE);
                        img_drop_pre_diabatic.setVisibility(View.INVISIBLE);
                        img_drop_normal.setVisibility(View.VISIBLE);
                        tv_result_value_green_pp.setText(sugar_pp.getText().toString());
                        tv_result_type_green_pp.setText(" (Normal)");
                    } else if (ppValue <= 199) {
                        img_drop_diabtic.setVisibility(View.INVISIBLE);
                        img_drop_pre_diabatic.setVisibility(View.VISIBLE);
                        img_drop_normal.setVisibility(View.INVISIBLE);
                        ll_result_green_pp.setVisibility(View.INVISIBLE);
                        ll_result_orange_pp.setVisibility(View.VISIBLE);
                        ll_result_red_pp.setVisibility(View.INVISIBLE);
                        tv_result_value_orange_pp.setText(sugar_pp.getText().toString());
                        tv_result_type_orange_pp.setText(" (Pre-diabetic)");
                    } else {
                        img_drop_diabtic.setVisibility(View.VISIBLE);
                        img_drop_pre_diabatic.setVisibility(View.INVISIBLE);
                        img_drop_normal.setVisibility(View.INVISIBLE);
                        ll_result_green_pp.setVisibility(View.INVISIBLE);
                        ll_result_orange_pp.setVisibility(View.INVISIBLE);
                        ll_result_red_pp.setVisibility(View.VISIBLE);
                        tv_result_value_red_pp.setText(sugar_pp.getText().toString());
                        tv_result_type_red_pp.setText(" (Diabetic)");
                    }
                }
                callApi();
                break;
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();

        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("BloodSugarFasting", sugar_fasting.getText().toString());
            object.put("BloodSugarPP", sugar_pp.getText().toString());
            if (sugar_fasting.getText().toString().equals("")) {
                object.put("Result", sugar_pp.getText().toString());
            } else {
                object.put("Result", sugar_fasting.getText().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_DIABETES_RISK, this, RequestHealthConstants.CALCULATOR_DIABETES_RISK);
        req.execute();

    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_DIABETES_RISK) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                if (sugar_fasting.getText().toString().equals("")) {
                    new AppDataPushApi().callApi(getActivity(),"Calculators","Diabetes risk result","User successfully stored his diabetes risk result " + sugar_pp.getText().toString());
                } else {
                    new AppDataPushApi().callApi(getActivity(),"Calculators","Diabetes risk result","User successfully stored his diabetes risk result " + sugar_fasting.getText().toString());
                }
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Diabetes risk result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
