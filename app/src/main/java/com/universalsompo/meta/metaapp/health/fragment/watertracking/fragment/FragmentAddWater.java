package com.universalsompo.meta.metaapp.health.fragment.watertracking.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import me.itangqi.waveloadingview.WaveLoadingView;

public class FragmentAddWater extends Fragment implements ResponseListener, View.OnClickListener {
    private View v;
    private SelectorListener binder;
    MySharedPreference pref;
    private TextView month_year_txt;
    int year, month;
    String selected_date, selected_date1;
    String formattedDate;
    private HorizontalCalendar horizontalCalendar;

    private LinearLayout edit_water_goal;
    private TextView set_goal, set_goal1;
    private WaveLoadingView waveLoadingView;
    private LinearLayout add_mini_glass, add_glass, add_bottle;
    private LinearLayout subtract_mini_glass, subtract_glass, subtract_bottle;

    double water_consumed;
    int prev_target_goal;

    int count_target;
    double litres_target, litres_target1;
    Dialog dialog;
    int dateDifference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_water_item_list, container,false);
        ((MainActivityHealth)getActivity()).hidenav();
        setHasOptionsMenu(true);
        pref = MySharedPreference.getInstance(getActivity());
        init();
        getcurrentyear();
        getcurrentdate();
        return v;
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        selected_date1 = selected_date;
        callApi(RequestHealthConstants.GET_WATER_DAILY_ACTIVITY);
    }

    public void getcurrentyear(){
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        getmonthstring(month, year);
    }

    public void getmonthstring(int mon, int yr){
        if(mon == 0){
            month_year_txt.setText("" + year);
        } else if(mon == 1){
            month_year_txt.setText("" + year);
        } else if(mon == 2){
            month_year_txt.setText("" + year);
        } else if(mon == 3){
            month_year_txt.setText("" + year);
        } else if(mon == 4){
            month_year_txt.setText("" + year);
        } else if(mon == 5){
            month_year_txt.setText("" + year);
        } else if(mon == 6){
            month_year_txt.setText("" + year);
        } else if(mon == 7){
            month_year_txt.setText("" + year);
        } else if(mon == 8){
            month_year_txt.setText("" + year);
        } else if(mon == 9){
            month_year_txt.setText("" + year);
        } else if(mon == 10){
            month_year_txt.setText("" + year);
        } else {
            month_year_txt.setText("" + year);
        }
    }

    public void init() {
        edit_water_goal = v.findViewById(R.id.edit_water_goal);
        set_goal1 = v.findViewById(R.id.set_goal1);
        set_goal = v.findViewById(R.id.set_goal);
        waveLoadingView = v.findViewById(R.id.waveLoadingView);
        add_mini_glass = v.findViewById(R.id.add_mini_glass);
        add_glass = v.findViewById(R.id.add_glass);
        add_bottle = v.findViewById(R.id.add_bottle);
        subtract_mini_glass = v.findViewById(R.id.subtract_mini_glass);
        subtract_glass = v.findViewById(R.id.subtract_glass);
        subtract_bottle = v.findViewById(R.id.subtract_bottle);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.YEAR, -1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 0);
        horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();
        month_year_txt = v.findViewById(R.id.month_year_txt);

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                String month1 = Integer.toString(date.get(Calendar.MONTH));
                String day_of_month, month3;
                if (date.get(Calendar.DAY_OF_MONTH) <= 9) {
                    day_of_month = "0" + date.get(Calendar.DAY_OF_MONTH);
                } else {
                    day_of_month = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
                }
                int month2 = Integer.parseInt(month1) + 1;
                if (month2 <= 9) {
                    month3 = "0" + month2;
                } else {
                    month3 = String.valueOf(month2);
                }
                selected_date = month3 + "/" + day_of_month + "/" + date.get(Calendar.YEAR);
                getmonthstring(Integer.parseInt(day_of_month), date.get(Calendar.YEAR));
                callApi(RequestHealthConstants.GET_WATER_DAILY_ACTIVITY);
            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView,
                                         int dx, int dy) {

            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                return true;
            }
        });

        edit_water_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected_date.equalsIgnoreCase(selected_date1)) {
                    editwatergoalDialog();
                } else {
                    editwatergoalDialog1();
                }
            }
        });

        add_mini_glass.setOnClickListener(this);
        add_glass.setOnClickListener(this);
        add_bottle.setOnClickListener(this);
        subtract_mini_glass.setOnClickListener(this);
        subtract_glass.setOnClickListener(this);
        subtract_bottle.setOnClickListener(this);
    }

    private void editwatergoalDialog() {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        dialog = new Dialog(getActivity());
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.edit_water_goal_dialog);

        LinearLayout ivadd = dialog.findViewById(R.id.iv_addgoal);
        LinearLayout ivremove = dialog.findViewById(R.id.iv_removegoal);
        LinearLayout cancel = dialog.findViewById(R.id.cancel);
        LinearLayout tvok = dialog.findViewById(R.id.tv_okwatergoal);
        LinearLayout close_dialog = dialog.findViewById(R.id.close_dialog);
        final TextView tvtotalglass = dialog.findViewById(R.id.tv_totalglassgoal);
        final TextView tvtotalqty = dialog.findViewById(R.id.tv_totalqtygoal);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        formattedDate = df.format(c);

        if(formattedDate.equalsIgnoreCase(selected_date)) {
            if(pref.getWaterGlassTarget() != null) {
                count_target = Integer.parseInt(pref.getWaterGlassTarget());
            } else {
                count_target = 8;
            }
        }
        tvtotalglass.setText(count_target + " Glasses");
        litres_target = ((double) (count_target * 250)) / 1000;
        tvtotalqty.setText("(" + litres_target + " Litres)");

        ivadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_target++;
                tvtotalglass.setText(count_target + " Glasses");
                litres_target = ((double) (count_target * 250)) / 1000;
                tvtotalqty.setText("(" + litres_target + " Litres)");
            }
        });

        ivremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_target--;
                if (count_target < 0) {
                    count_target = 0;
                }
                tvtotalglass.setText(count_target + " Glasses");
                litres_target = ((double) (count_target * 250)) / 1000;
                tvtotalqty.setText("(" + litres_target + " Litres)");
            }
        });

        tvok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkUtils.isConnected(getContext())) {
                    callApi(RequestHealthConstants.SAVE_WATER_TARGET);
                    dialog.dismiss();
                } else {
                    Toast.makeText(getContext(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void editwatergoalDialog1() {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        dialog = new Dialog(getActivity());
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.edit_water_goal_dialog);

        LinearLayout ivadd = dialog.findViewById(R.id.iv_addgoal);
        LinearLayout ivremove = dialog.findViewById(R.id.iv_removegoal);
        LinearLayout cancel = dialog.findViewById(R.id.cancel);
        LinearLayout tvok = dialog.findViewById(R.id.tv_okwatergoal);
        LinearLayout close_dialog = dialog.findViewById(R.id.close_dialog);
        final TextView tvtotalglass = dialog.findViewById(R.id.tv_totalglassgoal);
        final TextView tvtotalqty = dialog.findViewById(R.id.tv_totalqtygoal);

        /*Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        formattedDate = df.format(c);

        if(formattedDate.equalsIgnoreCase(selected_date)) {
            if(pref.getWaterGlassTarget() != null) {
                count_target = Integer.parseInt(pref.getWaterGlassTarget());
            } else {
                count_target = 8;
            }
        }*/
        tvtotalglass.setText(prev_target_goal + " Glasses");
        litres_target = ((double) (prev_target_goal * 250)) / 1000;
        tvtotalqty.setText("(" + litres_target + " Litres)");

        ivadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prev_target_goal++;
                tvtotalglass.setText(prev_target_goal + " Glasses");
                litres_target = ((double) (prev_target_goal * 250)) / 1000;
                tvtotalqty.setText("(" + litres_target + " Litres)");
            }
        });

        ivremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prev_target_goal--;
                if (prev_target_goal < 0) {
                    prev_target_goal = 0;
                }
                tvtotalglass.setText(prev_target_goal + " Glasses");
                litres_target = ((double) (prev_target_goal * 250)) / 1000;
                tvtotalqty.setText("(" + litres_target + " Litres)");
            }
        });

        tvok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkUtils.isConnected(getContext())) {
                    callApi(RequestHealthConstants.SAVE_WATER_TARGET1);
                    dialog.dismiss();
                } else {
                    Toast.makeText(getContext(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void callApi(Integer id) {
        if (id == RequestHealthConstants.SAVE_WATER_TARGET) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("Target", count_target);
                object.put("Date", selected_date);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_WATER_TARGET, this, RequestHealthConstants.SAVE_WATER_TARGET);
            req.execute();
        } else if (id == RequestHealthConstants.GET_WATER_DAILY_ACTIVITY) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("Date", selected_date);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_WATER_DAILY_ACTIVITY, this, RequestHealthConstants.GET_WATER_DAILY_ACTIVITY);
            req.execute();
        } else if (id == RequestHealthConstants.SAVE_WATER_TARGET1) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("Target", prev_target_goal);
                object.put("Date", selected_date);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_WATER_TARGET1, this, RequestHealthConstants.SAVE_WATER_TARGET1);
            req.execute();
        } else if (id == RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("Liter", water_consumed);
                object.put("Date", selected_date);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_WATER_DAILY_ACTIVITY, this, RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if(Tag == RequestHealthConstants.SAVE_WATER_TARGET) {
            if(object.optString("Message").equalsIgnoreCase("Success")) {
                pref.setWaterGlassTarget(String.valueOf(count_target));
                callApi(RequestHealthConstants.GET_WATER_DAILY_ACTIVITY);
            }
        } else if(Tag == RequestHealthConstants.SAVE_WATER_TARGET1) {
            if(object.optString("Message").equalsIgnoreCase("Success")) {
                Log.d("Success" , "Success");
                callApi(RequestHealthConstants.GET_WATER_DAILY_ACTIVITY);
            }
        } else if(Tag == RequestHealthConstants.GET_WATER_DAILY_ACTIVITY) {
            if(object.optString("Message").equalsIgnoreCase("Success")) {
                if(object.optString("Target").equalsIgnoreCase("0")) {
                    if (pref.getWaterGlassTarget() != null) {
                        count_target = Integer.parseInt(pref.getWaterGlassTarget());
                        set_goal1.setText(pref.getWaterGlassTarget() + " Glasses");
                        litres_target1 = ((double) (Integer.parseInt(pref.getWaterGlassTarget()) * 250)) / 1000;
                        set_goal.setText("(" + litres_target1 + " Litres)");
                        StringTokenizer stringTokenizer = new StringTokenizer(object.optString("QuantityInLiter"), " ");
                        String consume = stringTokenizer.nextToken();
                        double consumewater =Double.parseDouble(consume);
                        water_consumed = consumewater;
                        double targetlitres = (count_target * 250) / 1000;
                        double progress = (consumewater / targetlitres) * 100;
                        int progress_value = (int) progress;
                        waveLoadingView.setProgressValue(progress_value);
                        waveLoadingView.setBottomTitle(object.optString("QuantityInLiter"));
                        waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                        callApi(RequestHealthConstants.SAVE_WATER_TARGET);
                    } else {
                        count_target = 8;
                        set_goal1.setText(count_target + " Glasses");
                        litres_target1 = ((double) (count_target * 250)) / 1000;
                        set_goal.setText("(" + litres_target1 + " Litres)");
                        StringTokenizer stringTokenizer = new StringTokenizer(object.optString("QuantityInLiter"), " ");
                        String consume = stringTokenizer.nextToken();
                        double consumewater =Double.parseDouble(consume);
                        water_consumed = consumewater;
                        double targetlitres = (count_target * 250) / 1000;
                        double progress = (consumewater / targetlitres) * 100;
                        int progress_value = (int) progress;
                        waveLoadingView.setProgressValue(progress_value);
                        waveLoadingView.setBottomTitle(object.optString("QuantityInLiter"));
                        waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                        callApi(RequestHealthConstants.SAVE_WATER_TARGET);
                    }
                } else {
                    prev_target_goal = Integer.parseInt(object.optString("Target"));
                    set_goal1.setText(object.optString("Target") + " Glasses");
                    litres_target1 = ((double) (Integer.parseInt(object.optString("Target")) * 250)) / 1000;
                    set_goal.setText("(" + litres_target1 + " Litres)");
                    StringTokenizer stringTokenizer = new StringTokenizer(object.optString("QuantityInLiter"), " ");
                    String consume = stringTokenizer.nextToken();
                    double consumewater =Double.parseDouble(consume);
                    water_consumed = consumewater;
                    double targetlitres = (prev_target_goal * 250.0) / 1000.0;
                    double progress = (consumewater / targetlitres) * 100.0;
                    int progress_value = (int) progress;
                    waveLoadingView.setProgressValue(progress_value);
                    waveLoadingView.setBottomTitle(object.optString("QuantityInLiter"));
                    waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                }
            }
        } else if(Tag == RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY) {
            if(object.optString("Message").equalsIgnoreCase("Success")) {
                Log.d("Success" , "Success");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.add_mini_glass:
                dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), selected_date, selected_date1);
                System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
                if(dateDifference > 3) {
                    Toast.makeText(getActivity(), "More than 3 days back data cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    water_consumed = water_consumed + 0.25;
                    double targetlitres;
                    if(selected_date.equalsIgnoreCase(selected_date1)) {
                        if(count_target == 0) {
                            targetlitres = (prev_target_goal * 250.0) / 1000.0;
                        } else {
                            targetlitres = (count_target * 250.0) / 1000.0;
                        }
                    } else {
                        targetlitres = (prev_target_goal * 250.0) / 1000.0;
                    }
                    double progress = (water_consumed / targetlitres) * 100.0;
                    int progress_value = (int) progress;
                    if(progress_value >= 100) {
                        waveLoadingView.setProgressValue(100);
                    } else {
                        waveLoadingView.setProgressValue(progress_value);
                    }
                    waveLoadingView.setBottomTitle(water_consumed + " L");
                    waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    callApi(RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY);
                }
                break;

            case R.id.add_glass:
                dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), selected_date, selected_date1);
                System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
                if(dateDifference > 3) {
                    Toast.makeText(getActivity(), "More than 3 days back data cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    water_consumed = water_consumed + 0.50;
                    double targetlitres1;
                    if(selected_date.equalsIgnoreCase(selected_date1)) {
                        if(count_target == 0) {
                            targetlitres1 = (prev_target_goal * 250.0) / 1000.0;
                        } else {
                            targetlitres1 = (count_target * 250.0) / 1000.0;
                        }
                    } else {
                        targetlitres1 = (prev_target_goal * 250.0) / 1000.0;
                    }
                    double progress1 = (water_consumed / targetlitres1) * 100.0;
                    int progress_value1 = (int) progress1;
                    if(progress_value1 >= 100) {
                        waveLoadingView.setProgressValue(100);
                    } else {
                        waveLoadingView.setProgressValue(progress_value1);
                    }
                    waveLoadingView.setBottomTitle(water_consumed + " L");
                    waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    callApi(RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY);
                }
                break;

            case R.id.add_bottle:
                dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), selected_date, selected_date1);
                System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
                if(dateDifference > 3) {
                    Toast.makeText(getActivity(), "More than 3 days back data cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    water_consumed = water_consumed + 1.00;
                    double targetlitres2;
                    if(selected_date.equalsIgnoreCase(selected_date1)) {
                        if(count_target == 0) {
                            targetlitres2 = (prev_target_goal * 250.0) / 1000.0;
                        } else {
                            targetlitres2 = (count_target * 250.0) / 1000.0;
                        }
                    } else {
                        targetlitres2 = (prev_target_goal * 250.0) / 1000.0;
                    }
                    double progress2 = (water_consumed / targetlitres2) * 100.0;
                    int progress_value2 = (int) progress2;
                    if(progress_value2 >= 100) {
                        waveLoadingView.setProgressValue(100);
                    } else {
                        waveLoadingView.setProgressValue(progress_value2);
                    }
                    waveLoadingView.setBottomTitle(water_consumed + " L");
                    waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    callApi(RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY);
                }
                break;

            case R.id.subtract_mini_glass:
                dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), selected_date, selected_date1);
                System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
                if(dateDifference > 3) {
                    Toast.makeText(getActivity(), "More than 3 days back data cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    water_consumed = water_consumed - 0.25;
                    double targetlitres3;
                    if(selected_date.equalsIgnoreCase(selected_date1)) {
                        if(count_target == 0) {
                            targetlitres3 = (prev_target_goal * 250.0) / 1000.0;
                        } else {
                            targetlitres3 = (count_target * 250.0) / 1000.0;
                        }
                    } else {
                        targetlitres3 = (prev_target_goal * 250.0) / 1000.0;
                    }
                    double progress3 = (water_consumed / targetlitres3) * 100.0;
                    int progress_value3 = (int) progress3;
                    if(progress_value3 <= 0) {
                        water_consumed = 0;
                        waveLoadingView.setProgressValue(0);
                        waveLoadingView.setBottomTitle(0 + " L");
                        waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    } else {
                        waveLoadingView.setProgressValue(progress_value3);
                        waveLoadingView.setBottomTitle(water_consumed + " L");
                        waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    }
                    callApi(RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY);
                }
                break;

            case R.id.subtract_glass:
                dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), selected_date, selected_date1);
                System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
                if(dateDifference > 3) {
                    Toast.makeText(getActivity(), "More than 3 days back data cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    water_consumed = water_consumed - 0.50;
                    double targetlitres4;
                    if(selected_date.equalsIgnoreCase(selected_date1)) {
                        if(count_target == 0) {
                            targetlitres4 = (prev_target_goal * 250.0) / 1000.0;
                        } else {
                            targetlitres4 = (count_target * 250.0) / 1000.0;
                        }
                    } else {
                        targetlitres4 = (prev_target_goal * 250.0) / 1000.0;
                    }
                    double progress4 = (water_consumed / targetlitres4) * 100.0;
                    int progress_value4 = (int) progress4;
                    if(progress_value4 <= 0) {
                        water_consumed = 0;
                        waveLoadingView.setProgressValue(0);
                        waveLoadingView.setBottomTitle(0 + " L");
                        waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    } else {
                        waveLoadingView.setProgressValue(progress_value4);
                        waveLoadingView.setBottomTitle(water_consumed + " L");
                        waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    }
                    callApi(RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY);
                }
                break;

            case R.id.subtract_bottle:
                dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), selected_date, selected_date1);
                System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
                if(dateDifference > 3) {
                    Toast.makeText(getActivity(), "More than 3 days back data cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    water_consumed = water_consumed - 1.00;
                    double targetlitres5;
                    if(selected_date.equalsIgnoreCase(selected_date1)) {
                        if(count_target == 0) {
                            targetlitres5 = (prev_target_goal * 250.0) / 1000.0;
                        } else {
                            targetlitres5 = (count_target * 250.0) / 1000.0;
                        }
                    } else {
                        targetlitres5 = (prev_target_goal * 250.0) / 1000.0;
                    }
                    double progress5 = (water_consumed / targetlitres5) * 100.0;
                    int progress_value5 = (int) progress5;
                    if(progress_value5 <= 0) {
                        water_consumed = 0;
                        waveLoadingView.setProgressValue(0);
                        waveLoadingView.setBottomTitle(0 + " L");
                        waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    } else {
                        waveLoadingView.setProgressValue(progress_value5);
                        waveLoadingView.setBottomTitle(water_consumed + " L");
                        waveLoadingView.setBottomTitleColor(getResources().getColor(R.color.white));
                    }
                    callApi(RequestHealthConstants.SAVE_WATER_DAILY_ACTIVITY);
                }
                break;
        }
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
