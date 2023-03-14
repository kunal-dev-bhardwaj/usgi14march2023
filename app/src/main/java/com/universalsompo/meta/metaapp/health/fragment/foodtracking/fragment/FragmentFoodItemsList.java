package com.universalsompo.meta.metaapp.health.fragment.foodtracking.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.adapter.FoodAdapter;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.adapter.PopularFoodAdapter;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodDatabaseHelper1;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodIntake;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodIntake1;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.model.FoodModel;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.model.FoodModel1;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class FragmentFoodItemsList extends Fragment implements ResponseListener {
    private View v, view_food_track;
    private SelectorListener binder;
    MySharedPreference pref;
    private TextView month_year_txt;
    private LinearLayout early_breakfast_background, breakfast_background, lunch_background, evening_snack_background, dinner_background;
    private ImageView early_breakfast, breakfast, lunch, evening_snack, dinner;
    private ImageView early_breakfast1, breakfast1, lunch1, evening_snack1, dinner1;

    private LinearLayout add_food;
    private TextView diet_no_data;
    private TextView diet_no_data1;
    private TextView diet_no_data2;
    private TextView diet_no_data3;
    private TextView diet_no_data4;

    private FoodAdapter foodAdapter;
    ArrayList<FoodModel> data = new ArrayList<>();

    private PopularFoodAdapter popularfoodAdapter;
    ArrayList<FoodModel1> data1 = new ArrayList<>();

    /* Early Breakfast */
    private LinearLayout early_breakfast_linear;
    private RecyclerView early_breakfast_list;
    private LinearLayout early_breakfast_popular_linear;
    private RecyclerView early_breakfast_popular_list;

    /* Breakfast */
    private LinearLayout breakfast_linear;
    private RecyclerView breakfast_list;
    private LinearLayout breakfast_popular_linear;
    private RecyclerView breakfast_popular_list;

    /* Lunch */
    private LinearLayout lunch_linear;
    private RecyclerView lunch_list;
    private LinearLayout lunch_popular_linear;
    private RecyclerView lunch_popular_list;

    /* Evening Snack */
    private LinearLayout evening_snack_linear;
    private RecyclerView evening_snack_list;
    private LinearLayout evening_snack_popular_linear;
    private RecyclerView evening_snack_popular_list;

    /* Dinner */
    private LinearLayout dinner_linear;
    private RecyclerView dinner_list;
    private LinearLayout dinner_popular_linear;
    private RecyclerView dinner_popular_list;

    int year, month;

    private List<FoodIntake> foodintakeList;
    private List<FoodIntake> foodintakeList1;
    private FoodDatabaseHelper db;
    private List<FoodIntake1> foodintakepopularList;
    private FoodDatabaseHelper1 db1;
    String selected_date, selected_date1;
    String formattedDate;

    private HorizontalCalendar horizontalCalendar;

    int meal_type_id;
    double total_cal;
    private TextView total_cal_txt, most_popular_txt;

    int dateDifference;
    String type;
    int itemFoodTabClicked;
    String meal_type="";
    private Bundle bundle;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_food_item_list, container,false);
        pref = MySharedPreference.getInstance(getActivity());
        ((MainActivityHealth)getActivity()).hidenav();
        bundle = getArguments();
        setHasOptionsMenu(true);
        getcurrentdate();
        init();
        getcurrentyear();
        return v;
    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        selected_date1 = selected_date;
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

    public void init(){
        db1 = new FoodDatabaseHelper1(getActivity());

        diet_no_data = v.findViewById(R.id.diet_no_data);
        diet_no_data1 = v.findViewById(R.id.diet_no_data1);
        diet_no_data2 = v.findViewById(R.id.diet_no_data2);
        diet_no_data3 = v.findViewById(R.id.diet_no_data3);
        diet_no_data4 = v.findViewById(R.id.diet_no_data4);
        most_popular_txt = v.findViewById(R.id.most_popular_txt);

        month_year_txt = v.findViewById(R.id.month_year_txt);
        early_breakfast_background = v.findViewById(R.id.early_breakfast_background);
        breakfast_background = v.findViewById(R.id.breakfast_background);
        lunch_background = v.findViewById(R.id.lunch_background);
        evening_snack_background = v.findViewById(R.id.evening_snack_background);
        dinner_background = v.findViewById(R.id.dinner_background);

        early_breakfast = v.findViewById(R.id.early_breakfast);
        breakfast = v.findViewById(R.id.breakfast);
        lunch = v.findViewById(R.id.lunch);
        evening_snack = v.findViewById(R.id.evening_snack);
        dinner = v.findViewById(R.id.dinner);

        early_breakfast1 = v.findViewById(R.id.early_breakfast1);
        breakfast1 = v.findViewById(R.id.breakfast1);
        lunch1 = v.findViewById(R.id.lunch1);
        evening_snack1 = v.findViewById(R.id.evening_snack1);
        dinner1 = v.findViewById(R.id.dinner1);

        add_food = v.findViewById(R.id.add_food);

        early_breakfast_linear = v.findViewById(R.id.early_breakfast_linear);
        breakfast_linear = v.findViewById(R.id.breakfast_linear);
        lunch_linear = v.findViewById(R.id.lunch_linear);
        evening_snack_linear = v.findViewById(R.id.evening_snack_linear);
        dinner_linear = v.findViewById(R.id.dinner_linear);

        early_breakfast_list = v.findViewById(R.id.early_breakfast_list);
        breakfast_list = v.findViewById(R.id.breakfast_list);
        lunch_list = v.findViewById(R.id.lunch_list);
        evening_snack_list = v.findViewById(R.id.evening_snack_list);
        dinner_list = v.findViewById(R.id.dinner_list);

        early_breakfast_popular_linear = v.findViewById(R.id.early_breakfast_popular_linear);
        breakfast_popular_linear = v.findViewById(R.id.breakfast_popular_linear);
        lunch_popular_linear = v.findViewById(R.id.lunch_popular_linear);
        evening_snack_popular_linear = v.findViewById(R.id.evening_snack_popular_linear);
        dinner_popular_linear = v.findViewById(R.id.dinner_popular_linear);

        early_breakfast_popular_list = v.findViewById(R.id.early_breakfast_popular_list);
        breakfast_popular_list = v.findViewById(R.id.breakfast_popular_list);
        lunch_popular_list = v.findViewById(R.id.lunch_popular_list);
        evening_snack_popular_list = v.findViewById(R.id.evening_snack_popular_list);
        dinner_popular_list = v.findViewById(R.id.dinner_popular_list);

        early_breakfast_popular_list.setNestedScrollingEnabled(false);
        breakfast_popular_list.setNestedScrollingEnabled(false);
        lunch_popular_list.setNestedScrollingEnabled(false);
        evening_snack_popular_list.setNestedScrollingEnabled(false);
        dinner_popular_list.setNestedScrollingEnabled(false);

        total_cal_txt = v.findViewById(R.id.total_cal_txt);
        total_cal_txt.setText("Total Cal : 0");
        total_cal = 0.0;

        meal_type_id = 0;
        type = "EarlyMorning";


        bundle = getArguments();
        if (bundle!=null&& bundle.containsKey("Meal_type")){
            meal_type = bundle.getString("Meal_type");

            if (meal_type.equals("EarlyMorning")){
                earlybreakfastmethod();
            }else  if (meal_type.equals("Breakfast")){
                breakfastmethod();
            }else  if (meal_type.equals("Lunch")){
                lunchmethod();
            }else  if (meal_type.equals("EveningSnacks")){
                eveningsnackmethod();
            }else  if (meal_type.equals("Dinner")){
                dinnermethod();
            }
        }


        callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
        getpopularfooditems("EarlyMorning");

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.YEAR, -1);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 0);
        horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

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

                if (early_breakfast.getVisibility() == View.VISIBLE) {
                    meal_type_id = 0;
                    type = "EarlyMorning";
                    callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
                    getpopularfooditems("EarlyMorning");
                } else if (breakfast1.getVisibility() == View.VISIBLE) {
                    meal_type_id = 1;
                    type = "Breakfast";
                    callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
                    getpopularfooditems("Breakfast");
                } else if (lunch1.getVisibility() == View.VISIBLE) {
                    meal_type_id = 2;
                    type = "Lunch";
                    callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
                    getpopularfooditems("Lunch");
                } else if (evening_snack1.getVisibility() == View.VISIBLE) {
                    meal_type_id = 3;
                    type = "EveningSnacks";
                    callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
                    getpopularfooditems("EveningSnacks");
                } else if (dinner1.getVisibility() == View.VISIBLE) {
                    meal_type_id = 4;
                    type = "Dinner";
                    callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
                    getpopularfooditems("Dinner");
                }

                dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), selected_date, selected_date1);
                System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
                if(dateDifference > 3) {
                    add_food.setVisibility(View.GONE);
                } else {
                    add_food.setVisibility(View.VISIBLE);
                }
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

        early_breakfast_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_cal = 0.0;
                earlybreakfastmethod();
            }
        });

        breakfast_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_cal = 0.0;
                breakfastmethod();
            }
        });

        lunch_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_cal = 0.0;
                lunchmethod();
            }
        });

        evening_snack_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_cal = 0.0;
                eveningsnackmethod();
            }
        });

        dinner_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_cal = 0.0;
                dinnermethod();
            }
        });

        add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), selected_date, selected_date1);
                System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
                if(dateDifference > 3) {
                    Toast.makeText(getActivity(), "More than 3 days back data cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    total_cal = 0.0;
                    if(meal_type_id == 0){
                        replaceFragment(new SearchFood("EarlyMorning", selected_date), FragmentsHealthTags.FRAGMENT_FOOD_TRACKING);
                    } else if(meal_type_id == 1){
                        replaceFragment(new SearchFood("Breakfast", selected_date), FragmentsHealthTags.FRAGMENT_FOOD_TRACKING);
                    } else if(meal_type_id == 2){
                        replaceFragment(new SearchFood("Lunch", selected_date), FragmentsHealthTags.FRAGMENT_FOOD_TRACKING);
                    } else if(meal_type_id == 3){
                        replaceFragment(new SearchFood("EveningSnacks", selected_date), FragmentsHealthTags.FRAGMENT_FOOD_TRACKING);
                    } else {
                        replaceFragment(new SearchFood("Dinner", selected_date), FragmentsHealthTags.FRAGMENT_FOOD_TRACKING);
                    }
                }
            }
        });
    }

    private void earlybreakfastmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        early_breakfast.setVisibility(View.VISIBLE);
        early_breakfast1.setVisibility(View.GONE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        meal_type_id = 0;
        type = "EarlyMorning";
        callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
        getpopularfooditems("EarlyMorning");
    }

    private void breakfastmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.GONE);
        breakfast1.setVisibility(View.VISIBLE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        meal_type_id = 1;
        type = "Breakfast";
        callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
        getpopularfooditems("Breakfast");
    }

    private void lunchmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.GONE);
        lunch1.setVisibility(View.VISIBLE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        meal_type_id = 2;
        type = "Lunch";
        callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
        getpopularfooditems("Lunch");
    }

    private void eveningsnackmethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        } else {
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
        }

        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.GONE);
        evening_snack1.setVisibility(View.VISIBLE);
        dinner.setVisibility(View.VISIBLE);
        dinner1.setVisibility(View.GONE);

        meal_type_id = 3;
        type = "EveningSnacks";
        callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
        getpopularfooditems("EveningSnacks");
    }

    private void dinnermethod() {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            early_breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
        } else {
            early_breakfast_background.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set));
            breakfast_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            lunch_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            evening_snack_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder_not_set) );
            dinner_background.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.circle_reminder) );
        }

        early_breakfast.setVisibility(View.GONE);
        early_breakfast1.setVisibility(View.VISIBLE);
        breakfast.setVisibility(View.VISIBLE);
        breakfast1.setVisibility(View.GONE);
        lunch.setVisibility(View.VISIBLE);
        lunch1.setVisibility(View.GONE);
        evening_snack.setVisibility(View.VISIBLE);
        evening_snack1.setVisibility(View.GONE);
        dinner.setVisibility(View.GONE);
        dinner1.setVisibility(View.VISIBLE);

        meal_type_id = 4;
        type = "Dinner";
        callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
        getpopularfooditems("Dinner");
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

    void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
            return;
        }
    }



    public void callApi(Integer id, String uid, String type, String date){
        if (id == RequestHealthConstants.GET_FOOD_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH,pref.getToken_no());
                object.put("UserID", uid);
                object.put("Type", type);
                object.put("Date", date);
                object.put("NoOfDays", "1");
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_FOOD_DATA, this, RequestHealthConstants.GET_FOOD_DATA);
            req.execute();
        }
    }


    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if(Tag == RequestHealthConstants.GET_FOOD_DATA) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                if(type.equalsIgnoreCase("EarlyMorning")){
                    early_breakfast_linear.setVisibility(View.VISIBLE);
                    breakfast_linear.setVisibility(View.GONE);
                    lunch_linear.setVisibility(View.GONE);
                    evening_snack_linear.setVisibility(View.GONE);
                    dinner_linear.setVisibility(View.GONE);
                    early_breakfast_list.setVisibility(View.VISIBLE);
                    diet_no_data.setVisibility(View.GONE);
                    total_cal_txt.setVisibility(View.GONE);
                } else if(type.equalsIgnoreCase("Breakfast")){
                    early_breakfast_linear.setVisibility(View.GONE);
                    breakfast_linear.setVisibility(View.VISIBLE);
                    lunch_linear.setVisibility(View.GONE);
                    evening_snack_linear.setVisibility(View.GONE);
                    dinner_linear.setVisibility(View.GONE);
                    breakfast_list.setVisibility(View.VISIBLE);
                    diet_no_data1.setVisibility(View.GONE);
                    total_cal_txt.setVisibility(View.GONE);
                } else if(type.equalsIgnoreCase("Lunch")){
                    early_breakfast_linear.setVisibility(View.GONE);
                    breakfast_linear.setVisibility(View.GONE);
                    lunch_linear.setVisibility(View.VISIBLE);
                    evening_snack_linear.setVisibility(View.GONE);
                    dinner_linear.setVisibility(View.GONE);
                    lunch_list.setVisibility(View.VISIBLE);
                    diet_no_data2.setVisibility(View.GONE);
                    total_cal_txt.setVisibility(View.GONE);
                } else if(type.equalsIgnoreCase("EveningSnacks")){
                    early_breakfast_linear.setVisibility(View.GONE);
                    breakfast_linear.setVisibility(View.GONE);
                    lunch_linear.setVisibility(View.GONE);
                    evening_snack_linear.setVisibility(View.VISIBLE);
                    dinner_linear.setVisibility(View.GONE);
                    evening_snack_list.setVisibility(View.VISIBLE);
                    diet_no_data3.setVisibility(View.GONE);
                    total_cal_txt.setVisibility(View.GONE);
                } else if(type.equalsIgnoreCase("Dinner")){
                    early_breakfast_linear.setVisibility(View.GONE);
                    breakfast_linear.setVisibility(View.GONE);
                    lunch_linear.setVisibility(View.GONE);
                    evening_snack_linear.setVisibility(View.GONE);
                    dinner_linear.setVisibility(View.VISIBLE);
                    dinner_list.setVisibility(View.VISIBLE);
                    diet_no_data4.setVisibility(View.GONE);
                    total_cal_txt.setVisibility(View.GONE);
                }
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    total_cal_txt.setText("Total Cal : " + object.getString("TotalCalories"));
                    total_cal_txt.setVisibility(View.VISIBLE);
                    arr = object.getJSONArray("DBoardUsersFoodLogRes");
                    if (arr.length() != 0) {
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj1 = arr.getJSONObject(i);
                            data.add(
                                    new FoodModel(
                                            obj1.optString("FoodName"),
                                            obj1.optString("Calories"),
                                            obj1.optString("ID"),
                                            obj1.optString("DateTime"),
                                            obj1.optString("Type"),
                                            obj1.optString("Quantity")
                                    )
                            );
                        }

                        if (type.equalsIgnoreCase("EarlyMorning")){
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            early_breakfast_list.setLayoutManager(layoutManager);
                            foodAdapter = new FoodAdapter(getActivity(), data, early_breakfast_list, FragmentFoodItemsList.this, "EarlyMorning", selected_date);
                            early_breakfast_list.setAdapter(foodAdapter);
                        } else if (type.equalsIgnoreCase("Breakfast")) {
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            breakfast_list.setLayoutManager(layoutManager);
                            foodAdapter = new FoodAdapter(getActivity(), data, breakfast_list, FragmentFoodItemsList.this, "Breakfast", selected_date);
                            breakfast_list.setAdapter(foodAdapter);
                        } else if (type.equalsIgnoreCase("Lunch")) {
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            lunch_list.setLayoutManager(layoutManager);
                            foodAdapter = new FoodAdapter(getActivity(), data, lunch_list, FragmentFoodItemsList.this, "Lunch", selected_date);
                            lunch_list.setAdapter(foodAdapter);
                        } else if (type.equalsIgnoreCase("EveningSnacks")) {
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            evening_snack_list.setLayoutManager(layoutManager);
                            foodAdapter = new FoodAdapter(getActivity(), data, evening_snack_list, FragmentFoodItemsList.this, "EveningSnacks", selected_date);
                            evening_snack_list.setAdapter(foodAdapter);
                        } else if (type.equalsIgnoreCase("Dinner")) {
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                            dinner_list.setLayoutManager(layoutManager);
                            foodAdapter = new FoodAdapter(getActivity(), data, dinner_list, FragmentFoodItemsList.this, "Dinner", selected_date);
                            dinner_list.setAdapter(foodAdapter);
                        }
                    } else {
                        if(type.equalsIgnoreCase("EarlyMorning")){
                            early_breakfast_linear.setVisibility(View.VISIBLE);
                            breakfast_linear.setVisibility(View.GONE);
                            lunch_linear.setVisibility(View.GONE);
                            evening_snack_linear.setVisibility(View.GONE);
                            dinner_linear.setVisibility(View.GONE);
                            early_breakfast_list.setVisibility(View.GONE);
                            diet_no_data.setVisibility(View.VISIBLE);
                            total_cal_txt.setVisibility(View.GONE);
                        } else if(type.equalsIgnoreCase("Breakfast")){
                            early_breakfast_linear.setVisibility(View.GONE);
                            breakfast_linear.setVisibility(View.VISIBLE);
                            lunch_linear.setVisibility(View.GONE);
                            evening_snack_linear.setVisibility(View.GONE);
                            dinner_linear.setVisibility(View.GONE);
                            breakfast_list.setVisibility(View.GONE);
                            diet_no_data1.setVisibility(View.VISIBLE);
                            total_cal_txt.setVisibility(View.GONE);
                        } else if (type.equalsIgnoreCase("Lunch")){
                            early_breakfast_linear.setVisibility(View.GONE);
                            breakfast_linear.setVisibility(View.GONE);
                            lunch_linear.setVisibility(View.VISIBLE);
                            evening_snack_linear.setVisibility(View.GONE);
                            dinner_linear.setVisibility(View.GONE);
                            lunch_list.setVisibility(View.GONE);
                            diet_no_data2.setVisibility(View.VISIBLE);
                            total_cal_txt.setVisibility(View.GONE);
                        } else if(type.equalsIgnoreCase("EveningSnacks")){
                            early_breakfast_linear.setVisibility(View.GONE);
                            breakfast_linear.setVisibility(View.GONE);
                            lunch_linear.setVisibility(View.GONE);
                            evening_snack_linear.setVisibility(View.VISIBLE);
                            dinner_linear.setVisibility(View.GONE);
                            evening_snack_list.setVisibility(View.GONE);
                            diet_no_data3.setVisibility(View.VISIBLE);
                            total_cal_txt.setVisibility(View.GONE);
                        } else if(type.equalsIgnoreCase("Dinner")){
                            early_breakfast_linear.setVisibility(View.GONE);
                            breakfast_linear.setVisibility(View.GONE);
                            lunch_linear.setVisibility(View.GONE);
                            evening_snack_linear.setVisibility(View.GONE);
                            dinner_linear.setVisibility(View.VISIBLE);
                            dinner_list.setVisibility(View.GONE);
                            diet_no_data4.setVisibility(View.VISIBLE);
                            total_cal_txt.setVisibility(View.GONE);
                        }
                    }
                } catch (Exception e) {
                        e.printStackTrace();
                    }
            } else {
                if(meal_type_id == 0){
                    early_breakfast_linear.setVisibility(View.VISIBLE);
                    breakfast_linear.setVisibility(View.GONE);
                    lunch_linear.setVisibility(View.GONE);
                    evening_snack_linear.setVisibility(View.GONE);
                    dinner_linear.setVisibility(View.GONE);
                    early_breakfast_list.setVisibility(View.GONE);
                    diet_no_data.setVisibility(View.VISIBLE);
                    total_cal_txt.setVisibility(View.GONE);
                } else if(meal_type_id == 1){
                    early_breakfast_linear.setVisibility(View.GONE);
                    breakfast_linear.setVisibility(View.VISIBLE);
                    lunch_linear.setVisibility(View.GONE);
                    evening_snack_linear.setVisibility(View.GONE);
                    dinner_linear.setVisibility(View.GONE);
                    breakfast_list.setVisibility(View.GONE);
                    diet_no_data1.setVisibility(View.VISIBLE);
                    total_cal_txt.setVisibility(View.GONE);
                } else if(meal_type_id == 2){
                    early_breakfast_linear.setVisibility(View.GONE);
                    breakfast_linear.setVisibility(View.GONE);
                    lunch_linear.setVisibility(View.VISIBLE);
                    evening_snack_linear.setVisibility(View.GONE);
                    dinner_linear.setVisibility(View.GONE);
                    lunch_list.setVisibility(View.GONE);
                    diet_no_data2.setVisibility(View.VISIBLE);
                    total_cal_txt.setVisibility(View.GONE);
                } else if(meal_type_id == 3){
                    early_breakfast_linear.setVisibility(View.GONE);
                    breakfast_linear.setVisibility(View.GONE);
                    lunch_linear.setVisibility(View.GONE);
                    evening_snack_linear.setVisibility(View.VISIBLE);
                    dinner_linear.setVisibility(View.GONE);
                    evening_snack_list.setVisibility(View.GONE);
                    diet_no_data3.setVisibility(View.VISIBLE);
                    total_cal_txt.setVisibility(View.GONE);
                } else if(meal_type_id == 4){
                    early_breakfast_linear.setVisibility(View.GONE);
                    breakfast_linear.setVisibility(View.GONE);
                    lunch_linear.setVisibility(View.GONE);
                    evening_snack_linear.setVisibility(View.GONE);
                    dinner_linear.setVisibility(View.VISIBLE);
                    dinner_list.setVisibility(View.GONE);
                    diet_no_data4.setVisibility(View.VISIBLE);
                    total_cal_txt.setVisibility(View.GONE);
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    private void getpopularfooditems(String meal){
        foodintakepopularList = new ArrayList<>();
        foodintakepopularList.addAll(db1.getAllFood1(meal, pref.getUID()));
        JSONArray jsonArray1 = new JSONArray();
        for (FoodIntake1 cn1 : foodintakepopularList) {
            JSONObject food_taken1 = new JSONObject();
            try {
                food_taken1.put("name", cn1.getFoodName());
                food_taken1.put("nutrition", cn1.getFood_nutrition());
                food_taken1.put("food_id", cn1.getFood_id());
                food_taken1.put("cal", cn1.getCalories());
                food_taken1.put("carb", cn1.getCarbs());
                food_taken1.put("pro", cn1.getProtein());
                food_taken1.put("fat", cn1.getFat());
                food_taken1.put("serve_desc", cn1.getServing_desc());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray1.put(food_taken1);
        }

        JSONObject foodObj1 = new JSONObject();
        try {
            foodObj1.put("popularfood", jsonArray1);
            if(jsonArray1.length() > 0){
                foodObj1.put("message", "success");
            } else {
                foodObj1.put("message", "error");
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = foodObj1.toString();
        System.out.println("jsonString: " + jsonStr);

        try {
            JSONObject obj = new JSONObject(jsonStr);
            if (obj.optString("message").equals("success")){
                if(meal_type_id == 0){
                    early_breakfast_popular_linear.setVisibility(View.VISIBLE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    early_breakfast_popular_list.setVisibility(View.VISIBLE);
                    most_popular_txt.setVisibility(View.VISIBLE);
                } else if(meal_type_id == 1){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.VISIBLE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_list.setVisibility(View.VISIBLE);
                    most_popular_txt.setVisibility(View.VISIBLE);
                } else if(meal_type_id == 2){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.VISIBLE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    lunch_popular_list.setVisibility(View.VISIBLE);
                    most_popular_txt.setVisibility(View.VISIBLE);
                } else if(meal_type_id == 3){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.VISIBLE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_list.setVisibility(View.VISIBLE);
                    most_popular_txt.setVisibility(View.VISIBLE);
                } else if(meal_type_id == 4){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.VISIBLE);
                    dinner_popular_list.setVisibility(View.VISIBLE);
                    most_popular_txt.setVisibility(View.VISIBLE);
                }
                JSONArray arr;
                if (!data1.isEmpty())
                    data1.clear();
                try {
                    arr = obj.getJSONArray("popularfood");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj1 = arr.getJSONObject(i);
                        data1.add(
                                new FoodModel1(
                                        obj1.optString("name"),
                                        obj1.optString("nutrition"),
                                        obj1.optString("food_id"),
                                        obj1.optString("cal"),
                                        obj1.optString("carb"),
                                        obj1.optString("pro"),
                                        obj1.optString("fat"),
                                        obj1.optString("serve_desc")
                                )
                        );
                    }
                    if (meal_type_id == 0){
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        early_breakfast_popular_list.setLayoutManager(layoutManager);
                        popularfoodAdapter = new PopularFoodAdapter(getActivity(), data1, "EarlyMorning", selected_date, FragmentFoodItemsList.this);
                        early_breakfast_popular_list.setAdapter(popularfoodAdapter);
                    } else if (meal_type_id == 1) {
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        breakfast_popular_list.setLayoutManager(layoutManager);
                        popularfoodAdapter = new PopularFoodAdapter(getActivity(), data1, "Breakfast", selected_date,  FragmentFoodItemsList.this);
                        breakfast_popular_list.setAdapter(popularfoodAdapter);
                    } else if (meal_type_id == 2) {
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        lunch_popular_list.setLayoutManager(layoutManager);
                        popularfoodAdapter = new PopularFoodAdapter(getActivity(), data1, "Lunch", selected_date,  FragmentFoodItemsList.this);
                        lunch_popular_list.setAdapter(popularfoodAdapter);
                    } else if (meal_type_id == 3) {
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        evening_snack_popular_list.setLayoutManager(layoutManager);
                        popularfoodAdapter = new PopularFoodAdapter(getActivity(), data1, "EveningSnacks", selected_date,  FragmentFoodItemsList.this);
                        evening_snack_popular_list.setAdapter(popularfoodAdapter);
                    } else if (meal_type_id == 4) {
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        dinner_popular_list.setLayoutManager(layoutManager);
                        popularfoodAdapter = new PopularFoodAdapter(getActivity(), data1, "Dinner", selected_date,  FragmentFoodItemsList.this);
                        dinner_popular_list.setAdapter(popularfoodAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                if(meal_type_id == 0){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    early_breakfast_popular_list.setVisibility(View.GONE);
                    most_popular_txt.setVisibility(View.GONE);
                } else if(meal_type_id == 1){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_list.setVisibility(View.GONE);
                    most_popular_txt.setVisibility(View.GONE);
                } else if(meal_type_id == 2){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    lunch_popular_list.setVisibility(View.GONE);
                    most_popular_txt.setVisibility(View.GONE);
                } else if(meal_type_id == 3){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_list.setVisibility(View.GONE);
                    most_popular_txt.setVisibility(View.GONE);
                } else if(meal_type_id == 4){
                    early_breakfast_popular_linear.setVisibility(View.GONE);
                    breakfast_popular_linear.setVisibility(View.GONE);
                    lunch_popular_linear.setVisibility(View.GONE);
                    evening_snack_popular_linear.setVisibility(View.GONE);
                    dinner_popular_linear.setVisibility(View.GONE);
                    dinner_popular_list.setVisibility(View.GONE);
                    most_popular_txt.setVisibility(View.GONE);
                }
            }
        } catch (Throwable t) {
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

    public void loaddata(Integer value, String date10) {
        if (value == 0) {
            type = "EarlyMorning";
            callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
            getpopularfooditems("EarlyMorning");
        } else if (value == 1) {
            type = "Breakfast";
            callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
            getpopularfooditems("Breakfast");
        } else if (value == 2) {
            type = "Lunch";
            callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
            getpopularfooditems("Lunch");
        } else if (value == 3) {
            type = "EveningSnacks";
            callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
            getpopularfooditems("EveningSnacks");
        } else if (value == 4) {
            type = "Dinner";
            callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), type, selected_date);
            getpopularfooditems("Dinner");
        }
    }
}