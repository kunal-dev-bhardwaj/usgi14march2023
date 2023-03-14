package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FragmentWorkoutAddValue extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    String date;
    EditText edt_hr, edt_min;
    LinearLayout clear_data, save;
    String type;
    private LinearLayout shape_dark_left, shape_white_center, shape_white_right, shape_white_left, shape_dark_center, shape_dark_right;
    double met;
    String currentdate;
    double total_hr, hr, min, min_hr, calorie_burnt;
    int calorie_burnt1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_workout_add_value, container,false);
        prefrences = MySharedPreference.getInstance(getActivity());
        getcurrentdate();
        date = getArguments().getString("Date");
        init();
        return v;
    }

    void init() {
        shape_dark_left = v.findViewById(R.id.shape_dark_left);
        shape_white_center = v.findViewById(R.id.shape_white_center);
        shape_white_right = v.findViewById(R.id.shape_white_right);
        shape_white_left = v.findViewById(R.id.shape_white_left);
        shape_dark_center = v.findViewById(R.id.shape_dark_center);
        shape_dark_right = v.findViewById(R.id.shape_dark_right);
        edt_hr = v.findViewById(R.id.edt_hr);
        edt_min = v.findViewById(R.id.edt_min);
        clear_data = v.findViewById(R.id.clear_data);
        save = v.findViewById(R.id.save);

        type = "light";
        met = 3.5;

        clear_data.setOnClickListener(this);
        save.setOnClickListener(this);
        shape_white_center.setOnClickListener(this);
        shape_white_right.setOnClickListener(this);
        shape_white_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.shape_white_left:
                selectLight();
                break;

            case R.id.shape_white_center:
                selectModerate();
                break;

            case R.id.shape_white_right:
                selectVigrous();
                break;

            case R.id.clear_data:
                edt_hr.setText("");
                edt_min.setText("");
                if(shape_white_left.getVisibility() == View.VISIBLE) {
                    selectLight();
                }
                break;

            case R.id.save:
                int dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), date, currentdate);
                System.out.println("dateDifference: " + date + currentdate + dateDifference);
                if(dateDifference > 3) {
                    Toast.makeText(getActivity(), "More than 3 days back data cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    if (edt_hr.getText().toString().equalsIgnoreCase("") || edt_hr.getText().toString().equalsIgnoreCase(null)) {
                        edt_hr.setText("0");
                    } else if (Integer.parseInt(edt_hr.getText().toString()) >= 13 || Integer.parseInt(edt_hr.getText().toString()) < 0) {
                        Toast.makeText(getActivity(), "Please type value between 0 to 12.", Toast.LENGTH_SHORT).show();
                    } else if (edt_min.getText().toString().equalsIgnoreCase("") || edt_min.getText().toString().equalsIgnoreCase(null)) {
                        edt_min.setText("0");
                    } else if (Integer.parseInt(edt_min.getText().toString()) >= 60 || Integer.parseInt(edt_min.getText().toString()) < 0) {
                        Toast.makeText(getActivity(), "Please type value between 1 to 59.", Toast.LENGTH_SHORT).show();
                    } else if (Integer.parseInt(edt_hr.getText().toString()) == 0 && Integer.parseInt(edt_min.getText().toString()) == 0) {
                        Toast.makeText(getActivity(), "Please enter either of two values.", Toast.LENGTH_SHORT).show();
                    } else {
                        hr = Double.parseDouble(edt_hr.getText().toString());
                        min = Double.parseDouble(edt_min.getText().toString());
                        min_hr = min / 60;
                        total_hr = hr + min_hr;
                        calorie_burnt = met * (Double.parseDouble(prefrences.getweight())) * total_hr;
                        calorie_burnt1 = (int) calorie_burnt;
                        callApi(RequestHealthConstants.SAVE_WORKOUT_ACTIVITY);
                    }
                }
                break;
        }
    }

    void selectLight() {
        shape_dark_left.setVisibility(View.VISIBLE);
        shape_white_center.setVisibility(View.VISIBLE);
        shape_white_right.setVisibility(View.VISIBLE);
        shape_white_left.setVisibility(View.GONE);
        shape_dark_center.setVisibility(View.GONE);
        shape_dark_right.setVisibility(View.GONE);

        type = "Light";
        met = 3.5;
    }

    void selectModerate() {
        shape_dark_left.setVisibility(View.GONE);
        shape_white_center.setVisibility(View.GONE);
        shape_white_right.setVisibility(View.VISIBLE);
        shape_white_left.setVisibility(View.VISIBLE);
        shape_dark_center.setVisibility(View.VISIBLE);
        shape_dark_right.setVisibility(View.GONE);

        type = "Moderate";
        met = 5.0;
    }

    void selectVigrous() {
        shape_dark_left.setVisibility(View.GONE);
        shape_white_center.setVisibility(View.VISIBLE);
        shape_white_right.setVisibility(View.GONE);
        shape_white_left.setVisibility(View.VISIBLE);
        shape_dark_center.setVisibility(View.GONE);
        shape_dark_right.setVisibility(View.VISIBLE);

        type = "Vigrous";
        met = 5.5;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.SAVE_WORKOUT_ACTIVITY) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
                object.put("UserID", prefrences.getUID());
                object.put("Hours", edt_hr.getText().toString());
                object.put("Minute", edt_min.getText().toString());
                object.put("Type", type);
                object.put("Date", date);
                object.put("Calories", calorie_burnt1);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_WORKOUT_ACTIVITY, this, RequestHealthConstants.SAVE_WORKOUT_ACTIVITY);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if(Tag == RequestHealthConstants.SAVE_WORKOUT_ACTIVITY) {
            if(object.optString("Message").equalsIgnoreCase("Success")) {
                Toast.makeText(getActivity(), "Successfully added", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            } else {
                Toast.makeText(getActivity(), "Please try after sometime.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        currentdate = df.format(c);
    }

    public static long getDateDiff(SimpleDateFormat format, String oldDate, String currentdate) {
        try {
            return TimeUnit.DAYS.convert(format.parse(currentdate).getTime() - format.parse(oldDate).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
