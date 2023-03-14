package com.universalsompo.meta.metaapp.health.fragment.calculators;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SmokeCalcFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,View.OnClickListener, ResponseListener {
    private View v;
    private TextView tv_date_of_start_smoking;
    private TextView tv_date_of_end_smoking;
    private int curYear, curMonth, curDay;
    private LinearLayout result;
    private TextView result_txt;
    private RadioButton no_radio_btn, yes_radio_btn;
    private LinearLayout end_date;
    private EditText no_of_cigi;
    private long days;
    private MySharedPreference pref;
    private String abc, abc1;
    private Date minDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.smoke_calc_fragment, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        getCurrentDateTime();
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        RadioGroup stop_smoking_radio_group = v.findViewById(R.id.stop_smoking_radio_group);
        no_radio_btn = v.findViewById(R.id.no_radio_btn);
        yes_radio_btn = v.findViewById(R.id.yes_radio_btn);
        tv_date_of_start_smoking = v.findViewById(R.id.tv_date_of_start_smoking);
        tv_date_of_end_smoking = v.findViewById(R.id.tv_date_of_end_smoking);
        no_of_cigi = v.findViewById(R.id.no_of_cigi);
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        end_date = v.findViewById(R.id.end_date);
        result_txt = v.findViewById(R.id.result_txt);
        no_radio_btn.setChecked(true);
        end_date.setVisibility(View.GONE);
        stop_smoking_radio_group.setOnCheckedChangeListener(this);
        clear_data.setOnClickListener(this);
        calculate.setOnClickListener(this);
        tv_date_of_start_smoking.setOnClickListener(this);
        tv_date_of_end_smoking.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.no_radio_btn:
                end_date.setVisibility(View.GONE);
                result.setVisibility(View.GONE);
                break;
            case R.id.yes_radio_btn:
                end_date.setVisibility(View.VISIBLE);
                result.setVisibility(View.GONE);
                break;
        }
    }
    private void getCurrentDateTime() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        curYear = c.get(Calendar.YEAR);
        curMonth = c.get(Calendar.MONTH);
        curDay = c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_date_of_start_smoking:
                datePickerTillToday(tv_date_of_start_smoking);
                break;
            case R.id.tv_date_of_end_smoking:
                datePickerTillToday1(tv_date_of_end_smoking);
                break;
            case R.id.clear_data:
                tv_date_of_start_smoking.setText("");
                tv_date_of_end_smoking.setText("");
                no_of_cigi.getText().clear();
                no_radio_btn.setChecked(true);
                end_date.setVisibility(View.GONE);
                if (result.isShown()) {
                    result.setVisibility(View.GONE);
                }
                break;

            case R.id.calculate:
                if (tv_date_of_start_smoking.getText().toString().trim().length() <= 0) {
                    Toast.makeText(getContext(), "Please select smoking start date", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (yes_radio_btn.isChecked() && tv_date_of_end_smoking.getText().toString().trim().length() <= 0) {
                    Toast.makeText(getContext(), "Please select smoking end date", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else if (no_of_cigi.getText().toString().trim().length() <= 0) {
                    Toast.makeText(getContext(), "Please enter no of cigratte per day used", Toast.LENGTH_SHORT).show();
                    if (result.getVisibility() == View.VISIBLE) {
                        result.setVisibility(View.GONE);
                    }
                    return;
                } else {
                    calcuateDays();
                }
                break;
        }
    }

    private void calcuateDays() {
        Date date1;
        String startDate;
        if (!tv_date_of_end_smoking.getText().toString().equals("")) {
            startDate = tv_date_of_start_smoking.getText().toString();
            String endDate = tv_date_of_end_smoking.getText().toString();
            @SuppressLint("SimpleDateFormat") SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {

                try {
                    date1 = myFormat.parse(startDate);
                    Date date2 = myFormat.parse(endDate);
                    assert date2 != null;
                    assert date1 != null;
                    long diff = date2.getTime() - date1.getTime() ;
                    days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    if (days <= 0) {
                        Toast.makeText(getActivity(), "End date cannot be less than start date. Please select a valid end date", Toast.LENGTH_SHORT).show();
                    } else {
                        calculate();
                    }
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                        e.printStackTrace();
                    }
        } else {
            Date date = new Date();
            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate= formatter.format(date);
            startDate = tv_date_of_start_smoking.getText().toString();
            @SuppressLint("SimpleDateFormat") SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date currntDate = myFormat.parse(strDate);
                date1 = myFormat.parse(startDate);
                assert currntDate != null;
                assert date1 != null;
                long diff = currntDate.getTime() - date1.getTime() ;
                days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                if (days <= 0) {
                    Toast.makeText(getActivity(), "End date cannot be less than start date. Please select a valid end date", Toast.LENGTH_SHORT).show();
                } else {
                    calculate();
                }
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void calculate() {
        days = days + 1;
        long totalcig = days  * (Integer.parseInt(no_of_cigi.getText().toString()));
        double time = (totalcig * 11.0)/60.0;
        convertMinitueTodays(time);
    }

    @SuppressLint("SetTextI18n")
    private void convertMinitueTodays(double time) {
        if(time>=24){
            double daysSpendInCig = time / 24;
            @SuppressLint("DefaultLocale") String value = String.format("%.2f", daysSpendInCig);
            result_txt.setText(value + " days");
        } else {
            @SuppressLint("DefaultLocale") String value = String.format("%.2f", time);
            result_txt.setText(value+ " hours");
        }
        result.setVisibility(View.VISIBLE);
        callApi();
    }

    private void callApi() {
        JSONObject object = new JSONObject();

        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("WhenDidYouStartSmoking", pref.getStartSmokingDate());
            if (yes_radio_btn.isChecked()) {
                object.put("DidYouStopSmoking", "Yes");
            } else {
                object.put("DidYouStopSmoking", "No");
            }
            if (yes_radio_btn.isChecked()) {
                object.put("WhenDidYouStopSmoking", pref.getStopSmokingDate());
            } else {
                object.put("WhenDidYouStopSmoking", "");
            }
            object.put("NoOfCigratePerDay", no_of_cigi.getText().toString());
            object.put("Result", result_txt.getText().toString());
        } catch (Exception e) {
                    e.printStackTrace();
                }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_SMOKING, this, RequestHealthConstants.CALCULATOR_SMOKING);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_SMOKING) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Smoking risk result","User successfully saved his smoking risk result " + result_txt.getText().toString());
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Smoking risk result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }


    private void datePickerTillToday(final TextView tv) {
        initDate();
        @SuppressLint("SetTextI18n") DatePickerDialog expdatePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()),R.style.DialogTheme, (view, year, month, dayOfMonth) -> {
            tv.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            abc = (month + 1) + "/" + dayOfMonth + "/" + year;
            try {
                minDate = cdate(dayOfMonth+"/"+(month + 1)+"/"+year);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            pref.setStartSmokingDate(abc);
        }, curYear, curMonth, curDay);
        expdatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        expdatePickerDialog.show();
    }

    private void datePickerTillToday1(final TextView tv) {
        initDate();
        @SuppressLint("SetTextI18n") DatePickerDialog expdatePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()),R.style.DialogTheme, (view, year, month, dayOfMonth) -> {
            tv.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            abc1 = (month + 1) + "/" + dayOfMonth + "/" + year;
            pref.setStopSmokingDate(abc1);
        }, curYear, curMonth, curDay);
        expdatePickerDialog.getDatePicker().setMinDate(minDate.getTime());
        expdatePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        expdatePickerDialog.show();
    }

    private Date cdate(String sDate1) throws ParseException {
        @SuppressLint("SimpleDateFormat") Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        System.out.println(sDate1+"\t"+date1);
        return date1;
    }

    private void initDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        curYear = c.get(Calendar.YEAR);
        curMonth = c.get(Calendar.MONTH);
        curDay = c.get(Calendar.DAY_OF_MONTH);
    }
}
