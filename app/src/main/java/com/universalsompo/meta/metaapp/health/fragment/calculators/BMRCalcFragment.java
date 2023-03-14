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

import java.text.DecimalFormat;
import java.util.Objects;

public class BMRCalcFragment extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private LinearLayout result;
    private TextView result_txt,result_txt_bmr;
    private EditText weight,age;
    private EditText height_feet,height_inche;
    private double a,b,c,d,e;
    private double wt;
    private MySharedPreference pref;
    private String gender;
    private String ideal_bmr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bmr_calc, container, false);
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
        result_txt_bmr = v.findViewById(R.id.result_txt_bmr);
        weight = v.findViewById(R.id.weight);
        age = v.findViewById(R.id.age);
        height_feet = v.findViewById(R.id.height_feet);
        height_inche = v.findViewById(R.id.height_inche);
        weight.setText(pref.getweight());
        height_feet.setText(pref.getfeet());
        height_inche.setText(pref.getinches());
        age.setText(pref.getAge());
        if (gender.equalsIgnoreCase("Female")) {
            a = 10;
            b = 6.25;
            c = 5;
            d = 161;
            e = 1.2;
        } else {
            a = 10;
            b = 6.25;
            c = 5;
            d = 5;
            e = 1.2;
        }
        clear_data.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.clear_data:
                weight.getText().clear();
                height_feet.getText().clear();
                height_inche.getText().clear();
                age.getText().clear();
                if (gender.equalsIgnoreCase("Female")) {
                    a = 10;
                    b = 6.25;
                    c = 5;
                    d = 161;
                    e = 1.2;
                } else {
                    a = 10;
                    b = 6.25;
                    c = 5;
                    d = 5;
                    e = 1.2;
                }
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;

            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                if(height_feet.getText().toString().isEmpty() || height_feet.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter height in feet", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (Integer.parseInt(height_feet.getText().toString()) < 4 || Integer.parseInt(height_feet.getText().toString()) > 6) {
                    Toast.makeText(getActivity(), "Please enter height in feet between 4 and 6", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (height_inche.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter height in inches", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (Integer.parseInt(height_inche.getText().toString()) > 11) {
                    Toast.makeText(getActivity(), "Please enter height in inches between 0 to 11", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (weight.getText().toString().isEmpty() || weight.getText().toString().equals("0")){
                    Toast.makeText(getActivity(), "Please enter your weight", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else if (age.getText().toString().equalsIgnoreCase("") || age.getText().toString().equalsIgnoreCase("0")) {
                    Toast.makeText(getActivity(), "Please enter your age", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else {
                    result.setVisibility(View.VISIBLE);
                    wt = Double.parseDouble(weight.getText().toString());
                    double height_ft = Double.parseDouble(height_feet.getText().toString());
                    double height_in;
                    if (height_inche.getText().toString().equals("0")) {
                        height_in = 0.0;
                    } else {
                        height_in = Double.parseDouble(height_inche.getText().toString());
                    }
                    double age1 = Double.parseDouble(age.getText().toString());
                    double height_cms = (height_ft * 30.48) + (height_in * 2.54);
                    double bmr;
                    double tdee;
                    if(pref.getgender().equalsIgnoreCase("Male")){
                        tdee = ((a * wt) + (b * height_cms) - (c * age1) + d) * e;
                    } else {
                        tdee = ((a * wt) + (b * height_cms) - (c * age1) - d) * e;
                    }
                    bmr = tdee / e;
                    String ideal_tdee = new DecimalFormat("##.##").format(tdee);
                    ideal_bmr = new DecimalFormat("##.##").format(bmr);
                    result_txt_bmr.setText(ideal_bmr + " Calories/day");
                    result_txt.setText(ideal_tdee + " Calories/day");
                    callApi();
                }
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Weight", String.valueOf(wt));
            object.put("Height", height_feet.getText().toString() + "." + height_inche.getText().toString());
            object.put("Age", age.getText().toString());
            object.put("Result", ideal_bmr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_BMR, this, RequestHealthConstants.CALCULATOR_BMR);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_BMR) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","BMR result","User successfully stored his BMR result " + ideal_bmr);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","BMR result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
