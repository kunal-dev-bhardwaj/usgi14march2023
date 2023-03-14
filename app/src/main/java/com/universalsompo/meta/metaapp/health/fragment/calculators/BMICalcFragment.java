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

import java.text.DecimalFormat;
import java.util.Objects;

public class BMICalcFragment extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private MySharedPreference pref;
    private LinearLayout result;
    private TextView result_txt;
    private EditText weight,height_feet,height_inche;
    private double wt;
    private TextView result_txt_desc;
    private ImageView needle;
    private String bmi_string;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.bmi_calc_fragment, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init(){
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        result_txt = v.findViewById(R.id.result_txt);
        weight = v.findViewById(R.id.weight);
        height_feet = v.findViewById(R.id.height_feet);
        height_inche = v.findViewById(R.id.height_inche);
        needle = v.findViewById(R.id.needle);
        result_txt_desc = v.findViewById(R.id.result_txt_desc);

        if(pref.getweight() != null) {
            weight.setText(pref.getweight());
        }

        if(pref.getfeet() != null) {
            height_feet.setText(pref.getfeet());
        }

        if(pref.getinches() != null) {
            height_inche.setText(pref.getinches());
        }

        clear_data.setOnClickListener(this);
        calculate.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.clear_data:
                weight.getText().clear();
                height_feet.getText().clear();
                height_inche.getText().clear();
                if(result.isShown()){
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
                    return;
                } else if (Integer.parseInt(height_feet.getText().toString()) < 4 || Integer.parseInt(height_feet.getText().toString()) > 6) {
                    Toast.makeText(getActivity(), "Please enter height in feet between 4 and 6", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (height_inche.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter height in inches", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (Integer.parseInt(height_inche.getText().toString()) > 11) {
                    Toast.makeText(getActivity(), "Please enter height in inches between 0 to 11", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if(weight.getText().toString().isEmpty() || weight.getText().toString().equals("0")){
                    Toast.makeText(getActivity(), "Please enter your weight", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else {
                    result.setVisibility(View.VISIBLE);
                    double height_ft = Double.parseDouble(height_feet.getText().toString());
                    double height_in;
                    if (height_inche.getText().toString().equals("0")) {
                        height_in = 0.0;
                    } else {
                        height_in = Double.parseDouble(height_inche.getText().toString());
                    }
                    wt = Double.parseDouble(weight.getText().toString());
                    double height_cms = (height_ft * 30.48) + (height_in * 2.54);
                    double height_m = height_cms * 0.01;
                    double total_height = height_m * height_m;
                    double bmi;
                    if(total_height == 0.0){
                        bmi = 0;
                    }else{
                        bmi = wt / total_height;
                    }
                    System.out.println("BMI" + bmi);
                    bmi_string = new DecimalFormat("##.##").format(bmi);
                    callApi();
                    result_txt.setText(bmi_string + " Kg/m2");
                    String bmiLabel = "";

                    double rotation_cal;
                    int needle_rotate;
                    if(bmi == 0 || bmi <= 18.5){
                        rotation_cal = bmi / 1.32;
                        needle_rotate = (int) rotation_cal;
                        needle.setRotation(needle_rotate);
                    } else if (bmi > 18.5 || bmi <= 24.9){
                        rotation_cal = bmi / 0.42;
                        needle_rotate = (int) rotation_cal;
                        needle.setRotation(needle_rotate);
                    } else if(bmi >= 25 || bmi <= 29.9){
                        rotation_cal = bmi / 0.33;
                        needle_rotate = (int) rotation_cal;
                        needle.setRotation(needle_rotate);
                    } else if(bmi >= 30 || bmi <= 34.9){
                        rotation_cal = bmi / 0.29;
                        needle_rotate = (int) rotation_cal;
                        needle.setRotation(needle_rotate);
                    } else if(bmi >= 35 || bmi <= 39.9){
                        rotation_cal = bmi / 0.24;
                        needle_rotate = (int) rotation_cal;
                        needle.setRotation(needle_rotate);
                    } else if(bmi >= 40 || bmi <= 44.9){
                        rotation_cal = bmi / 0.25;
                        needle_rotate = (int) rotation_cal;
                        needle.setRotation(needle_rotate);
                    } else {
                        needle.setRotation(180);
                }
                result_txt_desc.setText(bmiLabel);
                }
                break;
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Height", height_feet.getText().toString() + "." + height_inche.getText().toString());
            object.put("Weight", String.valueOf(wt));
            object.put("Result", bmi_string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_BMI, this, RequestHealthConstants.CALCULATOR_BMI);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_BMI) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","BMI result","User successfully stored his BMI result " + bmi_string);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","BMI result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
