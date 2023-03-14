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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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

public class BACCalcFragment extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private LinearLayout result;
    private LinearLayout ll_result_green, ll_reult_red;
    private TextView tv_result_value_green, tv_result_value_red;
    private TextView tv_result_type_green, tv_result_type_red;
    private Spinner spin_no_drinks;
    private Spinner spin_type_of_alcohal;
    private Spinner spin_no_of_hours_drink;
    private ImageView img_drop_low_risk;
    private ImageView img_drop_high_risk;
    private String gender;
    private MySharedPreference pref;
    private EditText weight;
    private String result1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bac_calc, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        gender = pref.getgender();
        weight = v.findViewById(R.id.weight);
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        spin_no_drinks = v.findViewById(R.id.spin_no_drinks);
        String[] no_drinks = getResources().getStringArray(R.array.No_of_drinks);
        spin_no_drinks.setAdapter(new ArrayAdapter(Objects.requireNonNull(getActivity()), R.layout.spinner_item_text, no_drinks));
        spin_type_of_alcohal = v.findViewById(R.id.spin_type_of_alcohal);
        String[] type_of_alcohol = getResources().getStringArray(R.array.type_of_alcohol);
        spin_type_of_alcohal.setAdapter(new ArrayAdapter(getActivity(), R.layout.spinner_item_text, type_of_alcohol));
        spin_no_of_hours_drink = v.findViewById(R.id.spin_no_of_hours_drink);
        String[] no_of_hr = getResources().getStringArray(R.array.no_of_hours_drink);
        spin_no_of_hours_drink.setAdapter(new ArrayAdapter(getActivity(), R.layout.spinner_item_text, no_of_hr));
        ll_reult_red = v.findViewById(R.id.ll_reult_red);
        ll_result_green = v.findViewById(R.id.ll_result_green);
        tv_result_value_green = v.findViewById(R.id.tv_result_value_green);
        tv_result_value_red = v.findViewById(R.id.tv_result_value_red);
        tv_result_type_green = v.findViewById(R.id.tv_result_type_green);
        tv_result_type_red = v.findViewById(R.id.tv_result_type_red);
        img_drop_low_risk = v.findViewById(R.id.img_drop_low_risk);
        img_drop_high_risk = v.findViewById(R.id.img_drop_high_risk);
        weight.setText(pref.getweight());
        clear_data.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.clear_data:
                new AppDataPushApi().callApi(getActivity(),"Calculators","BAC","User cleared all his filled data");
                tv_result_type_green.setText("( with in permissible limit)");
                weight.setText("");
                tv_result_value_green.setText("0.02% ");
                spin_no_drinks.setSelection(0);
                spin_no_of_hours_drink.setSelection(0);
                spin_type_of_alcohal.setSelection(0);
                img_drop_high_risk.setVisibility(View.INVISIBLE);
                img_drop_low_risk.setVisibility(View.VISIBLE);
                ll_result_green.setVisibility(View.VISIBLE);
                ll_reult_red.setVisibility(View.INVISIBLE);
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;

            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                if (spin_no_drinks.getSelectedItemPosition() == 0) {
                    Toast.makeText(getContext(), "Please select no of drinks", Toast.LENGTH_LONG).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (spin_type_of_alcohal.getSelectedItemPosition() == 0) {
                    Toast.makeText(getContext(), "Please select type of alcohal", Toast.LENGTH_LONG).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (weight.getText().toString().trim().length() <= 0) {
                    Toast.makeText(getContext(), "Please enter weight", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (!(Float.parseFloat(weight.getText().toString()) <= 200)) {
                    Toast.makeText(getContext(), " Weight should not be more than 200", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (spin_no_of_hours_drink.getSelectedItemPosition() == 0) {
                    Toast.makeText(getContext(), "Please select no. of hours drink", Toast.LENGTH_LONG).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else {
                    result.setVisibility(View.VISIBLE);
                    double value;
                    double BAC;
                    value = Double.parseDouble(spin_no_drinks.getSelectedItem().toString());
                    double w = Double.parseDouble(weight.getText().toString()) * 2.205;
                    if (gender.equals("Male")) {
                        double rForman = 0.73;
                        BAC = (Double.parseDouble(String.format("%.4f", value * 5.14 / w))* rForman ) - .015 * (Double.parseDouble(spin_no_of_hours_drink.getSelectedItem().toString()));
                        result1 = String.format("%.4f", BAC);
                        tv_result_value_green.setText(result1);
                        if (Double.parseDouble(result1) <= 0.03) {
                            img_drop_high_risk.setVisibility(View.INVISIBLE);
                            img_drop_low_risk.setVisibility(View.VISIBLE);
                            ll_result_green.setVisibility(View.VISIBLE);
                            ll_reult_red.setVisibility(View.INVISIBLE);
                            tv_result_value_green.setText(String.valueOf(result1));
                            tv_result_type_green.setText(" within permissible limit");
                        } else {
                            img_drop_high_risk.setVisibility(View.VISIBLE);
                            img_drop_low_risk.setVisibility(View.INVISIBLE);
                            ll_result_green.setVisibility(View.INVISIBLE);
                            ll_reult_red.setVisibility(View.VISIBLE);
                            tv_result_value_red.setText(String.valueOf(result1));
                            tv_result_type_red.setText(" Above permissible limit");
                        }
                    } else {
                        double rForWoman = 0.66;
                        BAC = (Double.parseDouble(String.format("%.4f", value * 5.14 / w * rForWoman))) - .015 * (Double.parseDouble(spin_no_of_hours_drink.getSelectedItem().toString()));
                        result1 = String.format("%.4f", BAC);
                        tv_result_value_green.setText(result1);
                        if (Double.parseDouble(result1) <= 0.03) {
                            img_drop_high_risk.setVisibility(View.INVISIBLE);
                            img_drop_low_risk.setVisibility(View.VISIBLE);
                            ll_result_green.setVisibility(View.VISIBLE);
                            ll_reult_red.setVisibility(View.INVISIBLE);
                            tv_result_value_green.setText(String.valueOf(result1));
                            tv_result_type_green.setText(" within permissible limit");
                        } else {
                            img_drop_high_risk.setVisibility(View.VISIBLE);
                            img_drop_low_risk.setVisibility(View.INVISIBLE);
                            ll_result_green.setVisibility(View.INVISIBLE);
                            ll_reult_red.setVisibility(View.VISIBLE);
                            tv_result_value_red.setText(String.valueOf(result1));
                            tv_result_type_red.setText(" Above permissible limit ");
                        }
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
            object.put("NoOfDrinks", spin_no_drinks.getSelectedItem().toString());
            object.put("TypeOfAlcohol", spin_type_of_alcohal.getSelectedItem().toString());
            object.put("Weight", weight.getText().toString());
            object.put("NoOfHoursSinceLastDrink", spin_no_of_hours_drink.getSelectedItem().toString());
            object.put("Result", result1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_BAC, this, RequestHealthConstants.CALCULATOR_BAC);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_BAC) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","BAC result","User successfully stored his BAC result " + result1);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","BAC result","User result of BAC could not be saved");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
