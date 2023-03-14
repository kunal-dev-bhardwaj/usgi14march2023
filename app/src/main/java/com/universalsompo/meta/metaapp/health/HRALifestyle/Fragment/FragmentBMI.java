package com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MYSharePrefLifestyleHRA;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.Objects;

import params.com.stepprogressview.StepProgressView;

public class FragmentBMI extends Fragment{
    private View v;
    private EditText edt_height_feet, edt_height_inch, edt_weight;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private double height_ft, height_inc, wt;
    private double height_cms, height_m, bmi;
    private Context mContext;
    private LinearLayout allizhealth_txt, button;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bmi, container, false);
        new AppDataPushApi().callApi(getActivity(),"Lifestyle HRA","BMI page","User started lifestyle HRA");
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = getActivity().getCurrentFocus();
        if (view == null) {
            view = new View(getActivity());
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        pref = MySharedPreference.getInstance(getActivity());
        MYSharePrefLifestyleHRA pref1 = MYSharePrefLifestyleHRA.getInstance(getActivity());
        pref1.setHitLifestyleAPI("false");
        db = new LifestyleHRADatabaseHelper(getActivity());
        mContext = getActivity();
        init();

        final View activityRootView = getActivity().findViewById(R.id.content_main1);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff > dpToPx(mContext, 200)) { // if more than 200 dp, it's probably a keyboard...
                    button.setVisibility(View.GONE);
                    allizhealth_txt.setVisibility(View.GONE);
                } else {
                    button.setVisibility(View.VISIBLE);
                    allizhealth_txt.setVisibility(View.VISIBLE);
                }
            }
        });
        return v;
    }

    private void init() {
        System.out.println("Account id : " + pref.getaccid() + " Person id : " + pref.getpersonid() + " Template id : " + pref.gettempid() + " Session id : " + pref.getsessionid());
        edt_height_feet = v.findViewById(R.id.edt_height_feet);
        edt_height_inch = v.findViewById(R.id.edt_height_inch);
        edt_weight = v.findViewById(R.id.edt_weight);
        button =  v.findViewById(R.id.button);
        allizhealth_txt =  v.findViewById(R.id.allizhealth_txt);
        Button next = v.findViewById(R.id.next);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(0);

        boolean check_bmi = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentBMI");
        if (check_bmi) {
            String feet = db.getLifestyleCol1Value(pref.getUID(), "FragmentBMI");
            String inches = db.getLifestyleCol2Value(pref.getUID(), "FragmentBMI");
            String weight = db.getLifestyleCol4Value(pref.getUID(), "FragmentBMI");

            edt_height_feet.setText(feet);
            edt_height_inch.setText(inches);
            edt_weight.setText(weight);
        } else {
            edt_height_feet.setText(pref.getfeet());
            edt_height_inch.setText(pref.getinches());
            edt_weight.setText(pref.getweight());
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_height_feet.getText().toString().isEmpty() || edt_height_feet.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter height in feet", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(edt_height_feet.getText().toString()) < 4 || Integer.parseInt(edt_height_feet.getText().toString()) > 6) {
                    Toast.makeText(getActivity(), "Please enter height in feet between 4 and 6", Toast.LENGTH_SHORT).show();
                } else if (edt_height_inch.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter height in inches", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(edt_height_inch.getText().toString()) > 11) {
                    Toast.makeText(getActivity(), "Please enter height in inches between 0 to 11", Toast.LENGTH_SHORT).show();
                } else if(edt_weight.getText().toString().isEmpty() || edt_weight.getText().toString().equals("0")){
                    Toast.makeText(getActivity(), "Please enter your weight", Toast.LENGTH_SHORT).show();
                } else {
                    height_ft = Double.parseDouble(edt_height_feet.getText().toString());
                    if (edt_height_inch.getText().toString().equals("0")) {
                        height_inc = 0.0;
                    } else {
                        height_inc = Double.parseDouble(edt_height_inch.getText().toString());
                    }
                    wt = Double.parseDouble(edt_weight.getText().toString());
                    height_cms = (height_ft * 30.48) + (height_inc * 2.54);
                    height_m = height_cms * 0.01;
                    double total_height = height_m * height_m;
                    if(total_height == 0.0){
                        bmi = 0;
                    }else{
                        bmi = wt / total_height;
                    }

                    boolean check_bmi = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentBMI");
                    if (check_bmi) {
                        db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "1", "", "", edt_height_feet.getText().toString(), edt_height_inch.getText().toString(), String.valueOf(height_cms), edt_weight.getText().toString(), String.valueOf(bmi), "true", "", "", "", "", "", "yes", "FragmentBMI");
                    } else {
                        db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "1", "", "", edt_height_feet.getText().toString(), edt_height_inch.getText().toString(), String.valueOf(height_cms), edt_weight.getText().toString(), String.valueOf(bmi), "true", "", "", "", "", "", "yes", "FragmentBMI");
                    }

                    Fragment frag = new FragmentWHR();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                }
            }
        });
    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }
}
