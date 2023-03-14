package com.universalsompo.meta.metaapp.health.fragment.weightlog.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.BubbleSeekBar;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Objects;

public class FragmentSetYourTarget extends Fragment implements ResponseListener {
    private View v;
    private MySharedPreference pref;
    private BubbleSeekBar bubbleSeekBar;
    private TextView current_weight_bmi;
    private TextView current_weight_bmi_status;
    private TextView ideal_weight;
    private TextView tv_loseorgain;
    private TextView target_weight_bmi;
    private TextView target_weight_bmi_status;
    private LinearLayout target_bmi_layout;
    private double weight;
    private double feet;
    private double inches;
    private RelativeLayout set_loss_gain_fast_layout;
    private Spinner spinner;
    private String[] weight_spinner = {"0.25", "0.50", "0.75", "1.00"};
    private String targetweight_loss_gain;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_weight_set_your_target, container,false);
        pref = MySharedPreference.getInstance(getActivity());
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        init();
        return v;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        TextView current_weight = v.findViewById(R.id.current_weight);
        current_weight_bmi = v.findViewById(R.id.current_weight_bmi);
        current_weight_bmi_status = v.findViewById(R.id.current_weight_bmi_status);
        bubbleSeekBar = v.findViewById(R.id.demo_1_seek_bar);
        ideal_weight = v.findViewById(R.id.ideal_weight);
        target_weight_bmi = v.findViewById(R.id.target_weight_bmi);
        target_weight_bmi_status = v.findViewById(R.id.target_weight_bmi_status);
        tv_loseorgain = v.findViewById(R.id.tv_loseorgain);
        set_loss_gain_fast_layout = v.findViewById(R.id.set_loss_gain_fast_layout);
        target_bmi_layout = v.findViewById(R.id.target_bmi_layout);
        spinner = v.findViewById(R.id.sp_weight);
        ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, weight_spinner);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        current_weight.setText(pref.getweight() + " "+ Objects.requireNonNull(getActivity()).getResources().getString(R.string.kg));

        setbmi();
        setidealweight();

        String target = pref.getTargetweight();
        if(target == null) {
            bubbleSeekBar.setProgress(Integer.parseInt(pref.getweight()));
            pref.setTargetweight(String.valueOf(bubbleSeekBar.getProgress()));
            pref.setlossgain_txt("");
            pref.setlossgain("0");
            callApi(String.valueOf(bubbleSeekBar.getProgress()));
        } else {
            bubbleSeekBar.setProgress(Integer.parseInt(pref.getTargetweight()));
            pref.setTargetweight(String.valueOf(bubbleSeekBar.getProgress()));
            double target_to_be_set = Integer.parseInt(pref.getTargetweight());
            double feet_to_be_set = Double.parseDouble(pref.getfeet());
            double inches_to_be_set = Double.parseDouble(pref.getinches());

            double height_cms_to_be_set = (feet_to_be_set * 30.48) + (inches_to_be_set * 2.54);
            double height_m_to_be_set = height_cms_to_be_set * 0.01;

            double total_height_to_be_set = height_m_to_be_set * height_m_to_be_set;
            double bmi_to_be_set;
            if(total_height_to_be_set == 0.0){
                bmi_to_be_set = 0;
            }else{
                bmi_to_be_set = target_to_be_set / total_height_to_be_set;
            }

            System.out.println("BMI as per progress" + bmi_to_be_set);
            String bmi_string_to_be_set = new DecimalFormat("##.##").format(bmi_to_be_set);
            double bmi_string_to_be_set_1 = Double.parseDouble(bmi_string_to_be_set);
            double current_user_bmi = Double.parseDouble(current_weight_bmi.getText().toString());

            settargetbmi(bmi_string_to_be_set_1);
            setlossgainvalue(current_user_bmi, bmi_string_to_be_set_1);
            setgainlosstxt();
            callApi(String.valueOf(bubbleSeekBar.getProgress()));
        }

        String spin_value = pref.getSpinnervalue();
        if(spin_value != null) {
            int spinnerPosition = aa.getPosition(spin_value);
            spinner.setSelection(spinnerPosition);
        } else {
            spinner.setSelection(0);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                targetweight_loss_gain = spinner.getSelectedItem().toString();
                pref.setSpinnervalue(targetweight_loss_gain);
                setdailyweighttarget(pref.getSpinnervalue());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                setgainlosstxt();
            }
            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
                double weight_to_be_set = Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()));
                double feet_to_be_set = Double.parseDouble(pref.getfeet());
                double inches_to_be_set = Double.parseDouble(pref.getinches());

                double height_cms_to_be_set = (feet_to_be_set * 30.48) + (inches_to_be_set * 2.54);
                double height_m_to_be_set = height_cms_to_be_set * 0.01;

                double total_height_to_be_set = height_m_to_be_set * height_m_to_be_set;
                double bmi_to_be_set;
                if(total_height_to_be_set == 0.0){
                    bmi_to_be_set = 0;
                }else{
                    bmi_to_be_set = weight_to_be_set / total_height_to_be_set;
                }

                System.out.println("BMI as per progress" + bmi_to_be_set);
                String bmi_string_to_be_set = new DecimalFormat("##.##").format(bmi_to_be_set);
                double bmi_string_to_be_set_1 = Double.parseDouble(bmi_string_to_be_set);
                double current_user_bmi = Double.parseDouble(current_weight_bmi.getText().toString());

                settargetbmi(bmi_string_to_be_set_1);
                setlossgainvalue(current_user_bmi, bmi_string_to_be_set_1);
                setgainlosstxt();
            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) { }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setbmi() {
        weight = Double.parseDouble(pref.getweight());
        feet = Double.parseDouble(pref.getfeet());
        inches = Double.parseDouble(pref.getinches());

        double height_cms = (feet * 30.48) + (inches * 2.54);
        double height_m = height_cms * 0.01;

        double total_height = height_m * height_m;
        double bmi;
        if (total_height == 0.0) {
            bmi = 0;
        } else {
            bmi = weight / total_height;
        }
        String bmi_string = new DecimalFormat("##.#").format(bmi);
        if(bmi >= 0.0 && bmi <= 18.5){
            current_weight_bmi.setText(bmi_string);
            current_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.yellow));
            current_weight_bmi_status.setText(getActivity().getResources().getString(R.string.underweight));
            current_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.yellow));
        } else if (bmi > 18.5 && bmi <= 24.9){
            current_weight_bmi.setText(bmi_string);
            current_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.green));
            current_weight_bmi_status.setText(getActivity().getResources().getString(R.string.normal));
            current_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.green));
        } else if(bmi >= 25.0 && bmi <= 29.9){
            current_weight_bmi.setText(bmi_string);
            current_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.color_orange));
            current_weight_bmi_status.setText(getActivity().getResources().getString(R.string.overweight));
            current_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.color_orange));
        } else if(bmi >= 30.0 && bmi <= 34.9){
            current_weight_bmi.setText(bmi_string);
            current_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
            current_weight_bmi_status.setText(getActivity().getResources().getString(R.string.obese_1));
            current_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
        } else if(bmi >= 35.0 && bmi <= 39.9){
            current_weight_bmi.setText(bmi_string);
            current_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
            current_weight_bmi_status.setText(getActivity().getResources().getString(R.string.obese_2));
            current_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
        } else if(bmi >= 40.0 && bmi <= 44.9){
            current_weight_bmi.setText(bmi_string);
            current_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
            current_weight_bmi_status.setText(getActivity().getResources().getString(R.string.obese_3));
            current_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
        } else {
            current_weight_bmi.setText(bmi_string);
            current_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
            current_weight_bmi_status.setText(getActivity().getResources().getString(R.string.obese_3));
            current_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
        }
    }

    @SuppressLint("SetTextI18n")
    private void setidealweight() {
        if (feet == 4 && inches == 8) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_first));
        } else if (feet == 4 && inches == 9) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_second));
        } else if (feet == 4 && inches == 10) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_second));
        } else if (feet == 4 && inches == 11) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_third));
        } else if (feet == 5 && inches == 0) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_third));
        } else if (feet == 5 && inches == 1) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_third));
        } else if (feet == 5 && inches == 2) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_fourth));
        } else if (feet == 5 && inches == 3) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_fourth));
        } else if (feet == 5 && inches == 4) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_fifth));
        } else if (feet == 5 && inches == 5) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_sixth));
        } else if (feet == 5 && inches == 6) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_sixth));
        } else if (feet == 5 && inches == 7) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_seventh));
        } else if (feet == 5 && inches == 8) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_eight));
        } else if (feet == 5 && inches == 9) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_eight));
        } else if (feet == 5 && inches == 10) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_ninth));
        } else if (feet == 5 && inches == 11) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_tenth));
        } else if (feet == 6 && inches == 0) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_eleventh));
        } else if (feet == 6 && inches == 1) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_tweleve));
        } else if (feet == 6 && inches == 2) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_thirteen));
        } else if (feet == 6 && inches == 3) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_thirteen));
        } else if (feet == 6 && inches == 4) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_forteen));
        } else if (feet == 6 && inches == 5) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_forteen));
        } else if (feet == 6 && inches == 6) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_fifteen));
        } else if (feet == 6 && inches == 7) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_fifteen));
        } else if (feet == 6 && inches == 8) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_sixteen));
        } else if (feet == 6 && inches == 9) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_seventeen));
        } else if (feet == 6 && inches == 10) {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_eighteen));
        } else {
            ideal_weight.setText(Objects.requireNonNull(getActivity()).getResources().getString(R.string.ideal_weight_ninteen));
        }
    }

    @SuppressLint("SetTextI18n")
    private void settargetbmi(double a) {
        if(a >= 0.0 && a <= 18.5){
            target_weight_bmi.setText(String.valueOf(a));
            target_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.yellow));
            target_weight_bmi_status.setText(getActivity().getResources().getString(R.string.underweight));
            target_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.yellow));
        } else if (a > 18.5 && a <= 24.9){
            target_weight_bmi.setText(String.valueOf(a));
            target_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.green));
            target_weight_bmi_status.setText(getActivity().getResources().getString(R.string.normal));
            target_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.green));
        } else if(a >= 25.0 && a <= 29.9){
            target_weight_bmi.setText(String.valueOf(a));
            target_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.color_orange));
            target_weight_bmi_status.setText(getActivity().getResources().getString(R.string.overweight));
            target_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.color_orange));
        } else if(a >= 30.0 && a <= 34.9){
            target_weight_bmi.setText(String.valueOf(a));
            target_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
            target_weight_bmi_status.setText(getActivity().getResources().getString(R.string.obese_1));
            target_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
        } else if(a >= 35.0 && a <= 39.9){
            target_weight_bmi.setText(String.valueOf(a));
            target_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
            target_weight_bmi_status.setText(getActivity().getResources().getString(R.string.obese_2));
            target_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
        } else if(a >= 40.0 && a <= 44.9){
            target_weight_bmi.setText(String.valueOf(a));
            target_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
            target_weight_bmi_status.setText(getActivity().getResources().getString(R.string.obese_3));
            target_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
        } else {
            target_weight_bmi.setText(String.valueOf(a));
            target_weight_bmi.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
            target_weight_bmi_status.setText(getActivity().getResources().getString(R.string.obese_3));
            target_weight_bmi_status.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.red));
        }
    }

    private void setgainlosstxt() {
        double seekbarvalue = bubbleSeekBar.getProgress();
        if(seekbarvalue == weight) {
            pref.setlossgain_txt("");
            tv_loseorgain.setText("");
            set_loss_gain_fast_layout.setVisibility(View.GONE);
            target_bmi_layout.setVisibility(View.GONE);
        } else if (seekbarvalue < weight) {
            pref.setlossgain_txt("Lose");
            tv_loseorgain.setText(getResources().getString(R.string.how_fast_you_want_to_lose));
            target_bmi_layout.setVisibility(View.VISIBLE);
            set_loss_gain_fast_layout.setVisibility(View.VISIBLE);
            spinner.setEnabled(true);
        } else {
            pref.setlossgain_txt("Gain");
            tv_loseorgain.setText(getResources().getString(R.string.how_fast_you_want_to_gain));
            target_bmi_layout.setVisibility(View.VISIBLE);
            set_loss_gain_fast_layout.setVisibility(View.VISIBLE);
            spinner.setEnabled(true);
        }
    }

    private void callApi(String targetweight) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Weight", targetweight);
            if (pref.getlossgain_txt() != null) {
                object.put("LoseGain", pref.getlossgain_txt());
            } else {
                object.put("LoseGain", "");
            }
            if (pref.getlossgain() != null) {
                object.put("LoseGainBy", pref.getlossgain());
            } else {
                object.put("LoseGainBy", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_TARGET_WEIGHT, this, RequestHealthConstants.GET_USER_WEIGHT_LIST);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if(Tag == RequestHealthConstants.SAVE_TARGET_WEIGHT) {
            if(object.optString("Message").equalsIgnoreCase("Success")) {
                LogUtils.showLog("Added", "Successfully added");
                new AppDataPushApi().callApi(getActivity(),"Weight","Target","Add Value");
            } else {
                LogUtils.showLog("Not added", "Not added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private void setlossgainvalue(double current_user_bmi, double bmi_string_to_be_set_1) {
        if (current_user_bmi < 18.5) {
            if (bmi_string_to_be_set_1 >= current_user_bmi) {
                pref.setTargetweight(String.valueOf(bubbleSeekBar.getProgress()));
                setdailyweighttarget(pref.getSpinnervalue());
                setgainlosstxt();
                double loss_gain;
                if (Double.parseDouble(pref.getweight()) > Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()))) {
                    loss_gain = Double.parseDouble(pref.getweight()) - Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()));
                    pref.setlossgain("" + (int) loss_gain);
                } else if (Double.parseDouble(pref.getweight()) < Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()))) {
                    loss_gain = Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress())) - Double.parseDouble(pref.getweight());
                    pref.setlossgain("" + (int) loss_gain);
                } else {
                    loss_gain = 0;
                    pref.setlossgain("" + (int) loss_gain);
                }
                callApi(String.valueOf(bubbleSeekBar.getProgress()));
            } else {
                showerrordialog("Please increase your target weight as this will lead to unhealthy weight loss and your BMI will become less than 18.5");
            }
        } else if (current_user_bmi > 24.9) {
            if (bmi_string_to_be_set_1 <= current_user_bmi) {
                pref.setTargetweight(String.valueOf(bubbleSeekBar.getProgress()));
                setdailyweighttarget(pref.getSpinnervalue());
                setgainlosstxt();
                double loss_gain;
                if (Double.parseDouble(pref.getweight()) > Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()))) {
                    loss_gain = Double.parseDouble(pref.getweight()) - Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()));
                    pref.setlossgain("" + (int) loss_gain);
                } else if (Double.parseDouble(pref.getweight()) < Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()))) {
                    loss_gain = Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress())) - Double.parseDouble(pref.getweight());
                    pref.setlossgain("" + (int) loss_gain);
                } else {
                    loss_gain = 0;
                    pref.setlossgain("" + (int) loss_gain);
                }
                callApi(String.valueOf(bubbleSeekBar.getProgress()));
            } else {
                showerrordialog("Please decrease your target weight as this will lead to unhealthy weight gain and your BMI will become greater than 24.9");
            }
        } else {
            pref.setTargetweight(String.valueOf(bubbleSeekBar.getProgress()));
            setdailyweighttarget(pref.getSpinnervalue());
            setgainlosstxt();
            double loss_gain;
            if (Double.parseDouble(pref.getweight()) > Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()))) {
                loss_gain = Double.parseDouble(pref.getweight()) - Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()));
                pref.setlossgain("" + (int) loss_gain);
            } else if (Double.parseDouble(pref.getweight()) < Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress()))) {
                loss_gain = Double.parseDouble(String.valueOf(bubbleSeekBar.getProgress())) - Double.parseDouble(pref.getweight());
                pref.setlossgain("" + (int) loss_gain);
            } else {
                loss_gain = 0;
                pref.setlossgain("" + (int) loss_gain);
            }
            callApi(String.valueOf(bubbleSeekBar.getProgress()));
        }
    }

    private void setdailyweighttarget(String targetweight_loss_gain) {
        double bmr, height_cms2, tdee = 0, weight_cal = 0;
        double feet2 = Double.parseDouble(pref.getfeet());
        double inches2 = Double.parseDouble(pref.getinches());

        height_cms2 = (feet2 * 30.48) + (inches2 * 2.54);

        if (pref.getgender().equalsIgnoreCase("Male")) {
            bmr = (10 * Double.parseDouble(pref.getweight())) + (6.25 * height_cms2) - (5 * Double.parseDouble(pref.getAge())) + 5;
        } else {
            bmr = (10 * Double.parseDouble(pref.getweight())) + (6.25 * height_cms2) - (5 * Double.parseDouble(pref.getAge())) - 161;
        }

        if (pref.getDailyactivity().equalsIgnoreCase("No Exercise")) {
            tdee = bmr * 1.2;
        } else if (pref.getDailyactivity().equalsIgnoreCase("Light Exercise")) {
            tdee = bmr * 1.375;
        } else if (pref.getDailyactivity().equalsIgnoreCase("Moderate Exercise")) {
            tdee = bmr * 1.55;
        }else if (pref.getDailyactivity().equalsIgnoreCase("Heavy Exercise")) {
            tdee = bmr * 1.725;
        }else if (pref.getDailyactivity().equalsIgnoreCase("Very Heavy Exercise")) {
            tdee = bmr * 1.9;
        }

        if(bubbleSeekBar.getProgress() < weight) {
            if(Double.parseDouble(targetweight_loss_gain) == 0.25) {
                weight_cal = tdee - 250;
            } else if (Double.parseDouble(targetweight_loss_gain) == 0.50) {
                weight_cal = tdee - 500;
            } else if (Double.parseDouble(targetweight_loss_gain) == 0.75) {
                weight_cal = tdee - 850;
            } else if (Double.parseDouble(targetweight_loss_gain) == 1.00) {
                weight_cal = tdee - 1100;
            }
        } else if(bubbleSeekBar.getProgress() > weight) {
            if(Double.parseDouble(targetweight_loss_gain) == 0.25) {
                weight_cal = tdee + 250;
            } else if (Double.parseDouble(targetweight_loss_gain) == 0.50) {
                weight_cal = tdee + 500;
            } else if (Double.parseDouble(targetweight_loss_gain) == 0.75) {
                weight_cal = tdee + 850;
            } else if (Double.parseDouble(targetweight_loss_gain) == 1.00) {
                weight_cal = tdee + 1100;
            }
        } else if (bubbleSeekBar.getProgress() == weight) {
            weight_cal = tdee;
        }

        pref.setcaloriegoal(String.valueOf((int)weight_cal));
    }

    private void showerrordialog(String s) {
        final Dialog alert_dialog = new Dialog(Objects.requireNonNull(getActivity()));
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt =  alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading =  alert_dialog.findViewById(R.id.alert_heading);
        alert_msg =  alert_dialog.findViewById(R.id.alert_msg);
        alert_msg.setText(s);
        alert_heading.setText(getResources().getString(R.string.alert));

        alert_dialog.show();
        ok_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog.dismiss();
                bubbleSeekBar.setProgress((int) weight);
            }
        });
    }
}
