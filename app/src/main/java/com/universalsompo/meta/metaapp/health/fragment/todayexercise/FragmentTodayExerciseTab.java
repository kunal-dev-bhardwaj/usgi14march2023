package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import java.util.Objects;

public class FragmentTodayExerciseTab extends Fragment implements View.OnClickListener {
    private View v, view1, view2, view3, view4, view5, view6;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_health_today_exercise, container,false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).remove_elevation();
        setHasOptionsMenu(true);
        init();
        return v;
    }

    void init() {
        LinearLayout steps = v.findViewById(R.id.steps);
        LinearLayout running = v.findViewById(R.id.running);
        LinearLayout cycling = v.findViewById(R.id.cycling);
        LinearLayout swimming = v.findViewById(R.id.swimming);
        LinearLayout workout = v.findViewById(R.id.workout);
        LinearLayout yoga = v.findViewById(R.id.yoga);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);
        view3 = v.findViewById(R.id.view3);
        view4 = v.findViewById(R.id.view4);
        view5 = v.findViewById(R.id.view5);
        view6 = v.findViewById(R.id.view6);

        steps.setOnClickListener(this);
        running.setOnClickListener(this);
        cycling.setOnClickListener(this);
        swimming.setOnClickListener(this);
        workout.setOnClickListener(this);
        yoga.setOnClickListener(this);

        addFragment(new FragmentStepsDetails());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.steps:
                selectSteps();
                break;

            case R.id.running:
                selectRunning();
                break;

            case R.id.cycling:
                selectCycling();
                break;

            case R.id.swimming:
                selectSwimming();
                break;

            case R.id.workout:
                selectWorkout();
                break;

            case R.id.yoga:
                selectYoga();
                break;
        }
    }

    private void selectSteps() {
        view1.setBackgroundResource(R.color.pastel_purple);
        view2.setBackgroundResource(R.color.white);
        view3.setBackgroundResource(R.color.white);
        view4.setBackgroundResource(R.color.white);
        view5.setBackgroundResource(R.color.white);
        view6.setBackgroundResource(R.color.white);

        addFragment(new FragmentStepsDetails());
    }

    private void selectRunning() {
        view1.setBackgroundResource(R.color.white);
        view2.setBackgroundResource(R.color.pastel_purple);
        view3.setBackgroundResource(R.color.white);
        view4.setBackgroundResource(R.color.white);
        view5.setBackgroundResource(R.color.white);
        view6.setBackgroundResource(R.color.white);

        addFragment(new FragmentRunningDetailsNew());
    }

    private void selectCycling() {
        view1.setBackgroundResource(R.color.white);
        view2.setBackgroundResource(R.color.white);
        view3.setBackgroundResource(R.color.pastel_purple);
        view4.setBackgroundResource(R.color.white);
        view5.setBackgroundResource(R.color.white);
        view6.setBackgroundResource(R.color.white);

        addFragment(new FragmentCyclingDetailsNew());
    }

    private void selectSwimming() {
        view1.setBackgroundResource(R.color.white);
        view2.setBackgroundResource(R.color.white);
        view3.setBackgroundResource(R.color.white);
        view4.setBackgroundResource(R.color.pastel_purple);
        view5.setBackgroundResource(R.color.white);
        view6.setBackgroundResource(R.color.white);

        addFragment(new FragmentSwimmingDetails());
    }

    private void selectWorkout() {
        view1.setBackgroundResource(R.color.white);
        view2.setBackgroundResource(R.color.white);
        view3.setBackgroundResource(R.color.white);
        view4.setBackgroundResource(R.color.white);
        view5.setBackgroundResource(R.color.pastel_purple);
        view6.setBackgroundResource(R.color.white);

        addFragment(new FragmentWorkoutDetails());
    }

    private void selectYoga() {
        view1.setBackgroundResource(R.color.white);
        view2.setBackgroundResource(R.color.white);
        view3.setBackgroundResource(R.color.white);
        view4.setBackgroundResource(R.color.white);
        view5.setBackgroundResource(R.color.white);
        view6.setBackgroundResource(R.color.pastel_purple);

        addFragment(new FragmentYogaDetails());
    }

    private void addFragment(Fragment frg) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.exercise_container1, frg);
        childFragTrans.commit();
    }
}
