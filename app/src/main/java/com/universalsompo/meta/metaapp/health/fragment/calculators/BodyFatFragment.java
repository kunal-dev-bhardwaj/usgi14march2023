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

public class BodyFatFragment extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private EditText height_feet,height_inche;
    private EditText weight,age;
    private LinearLayout result;
    private TextView result_txt;
    private double a;
    private double bmi;
    private String gender;
    private MySharedPreference pref;
    private String body_fat_ideal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_body_fat, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        gender = pref.getgender();
        weight = v.findViewById(R.id.weight);
        age = v.findViewById(R.id.age);
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        result_txt = v.findViewById(R.id.result_txt);
        height_feet = v.findViewById(R.id.height_feet);
        height_inche = v.findViewById(R.id.height_inche);

        if(pref.getweight() != null) {
            weight.setText(pref.getweight());
        }
        if(pref.getfeet() != null) {
            height_feet.setText(pref.getfeet());
        }
        if(pref.getinches() != null) {
            height_inche.setText(pref.getinches());
        }
        age.setText(pref.getAge());
        if (gender.equalsIgnoreCase("Male")) {
            a = 1;
        } else {
            a = 0;
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
                age.getText().clear();
                height_feet.getText().clear();
                height_inche.getText().clear();
                if (gender.equalsIgnoreCase("Male")) {
                    a = 1;
                } else {
                    a = 0;
                }
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;

            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                result.setVisibility(View.VISIBLE);
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
                } else if(weight.getText().toString().isEmpty() || weight.getText().toString().equals("0")){
                    Toast.makeText(getActivity(), "Please enter your weight", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                } else {
                    result.setVisibility(View.VISIBLE);
                    double height_ft = Double.parseDouble(height_feet.getText().toString());
                    double height_in;
                    if (height_inche.getText().toString().equals("0")) {
                        height_in = 0.0;
                    } else {
                        height_in = Double.parseDouble(height_inche.getText().toString());
                    }
                    double weight1 = Double.parseDouble(weight.getText().toString());
                    double height1 = (height_ft * 30.48) + (height_in * 2.54);
                    double height_m = height1 * 0.01;
                    double total_height = height_m * height_m;
                    double age1 = Double.parseDouble(age.getText().toString());
                    if(total_height == 0.0){
                        bmi = 0;
                    }else{
                        bmi = weight1 / total_height;
                    }
                    double body_fat = (1.20 * bmi) + (0.23 * age1) - (10.8 * a) - 5.4;
                    System.out.println("abc" + bmi + " " + age1 + " " + a + " " + body_fat + " " + height1 + " " + height_m);

                    body_fat_ideal = new DecimalFormat("##.##").format(body_fat);
                    result_txt.setText(body_fat_ideal + " %");
                    callApi();
                }
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("BMI", bmi);
            object.put("Age", age.getText().toString());
            object.put("Result", body_fat_ideal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_BODY_FAT, this, RequestHealthConstants.CALCULATOR_BODY_FAT);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_BMI) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Body fat result","User successfully stored his body fat result " + body_fat_ideal);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Body fat result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
