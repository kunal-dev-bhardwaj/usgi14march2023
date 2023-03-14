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

import java.util.Objects;

public class HealthyweightCalcFragment extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private LinearLayout result;
    private TextView result_txt;
    private EditText weight, height_feet, height_inche;
    private MySharedPreference pref;
    private String gender;
    private double wt;
    private double IBW;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_healthy_weight_calc, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        gender = pref.getgender();
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        result_txt = v.findViewById(R.id.result_txt);
        weight = v.findViewById(R.id.weight);
        height_feet = v.findViewById(R.id.height_feet);
        height_inche = v.findViewById(R.id.height_inche);
        height_feet.setText(pref.getfeet());
        height_inche.setText(pref.getinches());
        weight.setText(pref.getweight());
        clear_data.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.clear_data:
                height_feet.getText().clear();
                height_inche.getText().clear();
                weight.getText().clear();
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;

            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                if (height_feet.getText().toString().isEmpty() || height_feet.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter height in feet", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (Integer.parseInt(height_feet.getText().toString()) < 4 || Integer.parseInt(height_feet.getText().toString()) > 6) {
                    Toast.makeText(getActivity(), "Please enter height in feet between 4 and 6", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (height_inche.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter height in inches", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (Integer.parseInt(height_inche.getText().toString()) > 11) {
                    Toast.makeText(getActivity(), "Please enter height in inches between 0 to 11", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (weight.getText().toString().isEmpty() || weight.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter your weight", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else {
                    result.setVisibility(View.VISIBLE);
                    wt = Double.parseDouble(weight.getText().toString());

                    if (gender.equalsIgnoreCase("Male")) {
                        if (Integer.parseInt(height_feet.getText().toString()) >= 5) {
                            double result =  convertToInches(height_feet.getText().toString(),height_inche.getText().toString());
                            IBW = 56.2 + (1.41 * result);
                            @SuppressLint("DefaultLocale") String value = String.format("%.2f", IBW);
                            result_txt.setText("Your ideal weight " + value + " kg");
                        } else {
                            Toast.makeText(getContext(), "This is work for adults age 18 or older", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        if (Integer.parseInt(height_feet.getText().toString()) >= 5) {
                            double result =  convertToInches(height_feet.getText().toString(),height_inche.getText().toString());
                            IBW = 53.1 + (1.36 * result);
                            @SuppressLint("DefaultLocale") String value = String.format("%.2f", IBW);
                            result_txt.setText("Your ideal weight " + value + "kg");
                        } else
                            Toast.makeText(getContext(), "This is work for adults age 18 or older", Toast.LENGTH_SHORT).show();
                    }
                    callApi();
                    break;
                }
        }
    }

    private double convertToInches(String s, String inches) {
        return ((Double.parseDouble(s) - 5.0)*12)+Double.parseDouble(inches);
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Height", height_feet.getText().toString() + "." + height_inche.getText().toString());
            object.put("Weight", String.valueOf(wt));
            object.put("Result", IBW);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_HEALTHY_WEIGHT, this, RequestHealthConstants.CALCULATOR_HEALTHY_WEIGHT);
        req.execute();

    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_BMI) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Healthy weight result","User successfully saved his healthy weight result " + IBW);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Healthy weight result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}

