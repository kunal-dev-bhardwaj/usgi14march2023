package com.universalsompo.meta.metaapp.health.fragment.diary;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.Objects;

public class FragmentDietDiary extends Fragment implements View.OnClickListener {
    private View v, view1, view2, view3;
    private ImageView diet_icon, water_icon, exercise_icon;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_diary_new_design, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).remove_elevation();
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        init();
        return v;
    }

    private void init() {
        LinearLayout diet_cal = v.findViewById(R.id.diet_cal);
        LinearLayout water_cal = v.findViewById(R.id.water_cal);
        LinearLayout exercise_cal = v.findViewById(R.id.exercise_cal);
        diet_icon = v.findViewById(R.id.diet_icon);
        water_icon = v.findViewById(R.id.water_icon);
        exercise_icon = v.findViewById(R.id.exercise_icon);
        view1 = v.findViewById(R.id.view1);
        view2 = v.findViewById(R.id.view2);
        view3 = v.findViewById(R.id.view3);

        diet_cal.setOnClickListener(this);
        water_cal.setOnClickListener(this);
        exercise_cal.setOnClickListener(this);
        new AppDataPushApi().callApi(getActivity(),"Diary","Diary tabs","User clicked on diet diary");
        addFragment(new FragmentDietDetail(), FragmentsHealthTags.DIARY_DIET_TAG);
    }

    private void selectDiet() {
        ImageViewCompat.setImageTintList(diet_icon, ColorStateList.valueOf(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.tab_text)));
        ImageViewCompat.setImageTintList(water_icon, ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.lightblack)));
        ImageViewCompat.setImageTintList(exercise_icon, ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.lightblack)));
        view2.setBackgroundResource(R.color.grey);
        view3.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.tab_text);
        new AppDataPushApi().callApi(getActivity(),"Diary","Diary tabs","User clicked on diet diary");
        addFragment(new FragmentDietDetail(), FragmentsHealthTags.DIARY_DIET_TAG);
    }

    private void selectWater() {
        ImageViewCompat.setImageTintList(diet_icon, ColorStateList.valueOf(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack)));
        ImageViewCompat.setImageTintList(water_icon, ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.tab_text)));
        ImageViewCompat.setImageTintList(exercise_icon, ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.lightblack)));
        view2.setBackgroundResource(R.color.tab_text);
        view3.setBackgroundResource(R.color.grey);
        view1.setBackgroundResource(R.color.grey);
        new AppDataPushApi().callApi(getActivity(),"Diary","Diary tabs","User clicked on water diary");
        addFragment(new FragmentWaterDetail(), FragmentsHealthTags.DIARY_WATER_TAG);
    }

    private void selectExercise() {
        ImageViewCompat.setImageTintList(diet_icon, ColorStateList.valueOf(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack)));
        ImageViewCompat.setImageTintList(water_icon, ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.lightblack)));
        ImageViewCompat.setImageTintList(exercise_icon, ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.tab_text)));
        view2.setBackgroundResource(R.color.grey);
        view3.setBackgroundResource(R.color.tab_text);
        view1.setBackgroundResource(R.color.grey);
        new AppDataPushApi().callApi(getActivity(),"Diary","Diary tabs","User clicked on step diary");
        addFragment(new FragmentStepDetail(), FragmentsHealthTags.DIARY_EXERCISE_TAG);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.diet_cal:
                selectDiet();
                break;

            case R.id.water_cal:
                selectWater();
                break;

            case R.id.exercise_cal:
                selectExercise();
                break;
        }
    }

    private void addFragment(Fragment frg, String s) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.diet_water_exercise_container, frg);
        childFragTrans.commit();
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).detect(s);
    }
}
