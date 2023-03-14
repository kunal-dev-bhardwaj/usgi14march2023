package com.universalsompo.meta.metaapp.health.fragment.foodtracking.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;

@SuppressLint("ValidFragment")
public class SearchFood extends Fragment implements FoodItemSearch.FragmentCallbacks {
    View v;
    private SelectorListener binder;
    Fragment fatSecretSearch;
    String meal_type1, date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_add_diet_chart, container, false);
        init();
        setHasOptionsMenu(true);
        return v;
    }

    @SuppressLint("ValidFragment")
    public  SearchFood(String meal_type, String date1){
        meal_type1 = meal_type;
        date = date1;
    }

    void init() {
        fatSecretSearch = new FoodItemSearch();
        Bundle args = new Bundle();
        args.putString("Meal_type", meal_type1);
        args.putString("Date", date);
        fatSecretSearch.setArguments(args);
        if (fatSecretSearch != null)
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fatSecretSearch).commit();
    }

    @Override
    public void fromFragment() {

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
}
