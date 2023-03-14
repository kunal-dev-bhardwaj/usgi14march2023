package com.universalsompo.meta.metaapp.health.fragment.calculators;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
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

import org.joda.time.LocalDate;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PregnancyCalculator extends Fragment implements View.OnClickListener, ResponseListener {
    private View v;
    private EditText dateview;
    private int curYear, expMonth, expDay;
    private int expYear, curMonth, curDay;
    private int startyear, startmonth, startday;
    private Calendar expCalenderDate;
    private LinearLayout result;
    private TextView result_txt,result_desc_txt;
    private String d, abc, abc1;
    private MySharedPreference pref;
    private String formattedDate, currentdate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.pregnancy_calc_fragment, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        getcurrentdate();
        getCurrentDateTime();
        init();
        setHasOptionsMenu(true);
        return v;
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        currentdate = df.format(c);
    }

    private void init() {
        dateview = v.findViewById(R.id.dateView);
        Button clear_data = v.findViewById(R.id.clear_data);
        Button calculate = v.findViewById(R.id.calculate);
        result = v.findViewById(R.id.result);
        result_txt = v.findViewById(R.id.result_txt);
        result_desc_txt = v.findViewById(R.id.result_desc_txt);
        clear_data.setOnClickListener(this);
        calculate.setOnClickListener(this);

        dateview.setOnClickListener(v -> {
            DatePickerDialog expdatePickerDialog;
            expdatePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()), (view, year, month, dayOfMonth) -> {
                startyear = year;
                startmonth = month;
                startday = dayOfMonth;
                Calendar c = createCalender("" + startday, "" + startmonth, "" + startyear);
                d = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
                abc = (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.YEAR);
                abc1 = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
                dateview.setText(abc1);
                expCalenderDate = Calendar.getInstance();
                expYear = expCalenderDate.get(Calendar.YEAR);
                expMonth = expCalenderDate.get(Calendar.MONTH) + 1;
                expDay = expCalenderDate.get(Calendar.DAY_OF_MONTH);
                System.out.println(expYear + " " + expMonth + " " + expDay);
            }, curYear, curMonth, curDay);
            expdatePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
            expdatePickerDialog.show();

        });
    }

    private void getCurrentDateTime() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        curYear = c.get(Calendar.YEAR);
        curMonth = c.get(Calendar.MONTH);
        curDay = c.get(Calendar.DAY_OF_MONTH);
    }

    private Calendar createCalender(String day, String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, Integer.parseInt(month));
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        return calendar;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.clear_data:
                dateview.getText().clear();
                if(result.isShown()){
                    result.setVisibility(View.GONE);
                }
                break;
            case R.id.calculate:
                final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
                if(dateview.getText().toString().isEmpty() || dateview.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please select date", Toast.LENGTH_SHORT).show();
                    result.setVisibility(View.GONE);
                } else {
                    result.setVisibility(View.VISIBLE);
                    LocalDate date = LocalDate.parse(d);
                    date = date.plusDays(280);

                    formattedDate = date.toString("MM/dd/yyyy");
                    String formattedDate1 = date.toString("dd/MM/yyyy");

                    System.out.println("Pregnancy due date is: "+ formattedDate1);
                    result_txt.setText("" + formattedDate1);

                    @SuppressLint("SimpleDateFormat") int dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), currentdate, formattedDate);
                    System.out.println("dateDifference: " + date + currentdate + dateDifference);

                    result_desc_txt.setText("Congratulations! You are only " + dateDifference + " days away from motherhood.");

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
            object.put("FirstDayofLastMenstrualPeriod", abc);
            object.put("Result", formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.CALCULATOR_PREGNANCY, this, RequestHealthConstants.CALCULATOR_PREGNANCY);
        req.execute();

    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.CALCULATOR_PREGNANCY) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Pregnancy result","User successfully saved her pregnancy result " + formattedDate);
                LogUtils.showLog("Added", "Successfully added");
            } else {
                new AppDataPushApi().callApi(getActivity(),"Calculators","Pregnancy result","User could not save his result");
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private static long getDateDiff(SimpleDateFormat format, String oldDate, String currentdate) {
        try {
            return TimeUnit.DAYS.convert(Objects.requireNonNull(format.parse(currentdate)).getTime() - Objects.requireNonNull(format.parse(oldDate)).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
