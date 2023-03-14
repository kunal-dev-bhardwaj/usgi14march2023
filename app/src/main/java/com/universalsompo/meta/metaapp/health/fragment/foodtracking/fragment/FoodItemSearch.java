package com.universalsompo.meta.metaapp.health.fragment.foodtracking.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.felipecsl.quickreturn.library.QuickReturnAttacher;
import com.felipecsl.quickreturn.library.widget.QuickReturnAdapter;
import com.felipecsl.quickreturn.library.widget.QuickReturnTargetView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.FatSecretImplementation.Equations;
import com.universalsompo.meta.metaapp.health.FatSecretImplementation.FatSecretGet;
import com.universalsompo.meta.metaapp.health.FatSecretImplementation.FatSecretSearch;
import com.universalsompo.meta.metaapp.health.SearchRowAdapter.Item;
import com.universalsompo.meta.metaapp.health.SearchRowAdapter.SearchAdapter;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.dietchart.FatSecretSearchFragment;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodDatabaseHelper1;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodIntake;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodIntake1;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class FoodItemSearch extends Fragment implements ResponseListener {
    private SelectorListener binder;
    static boolean IS_SEARCH_VISIBLE; // retain list
    static boolean SEARCH_RETAIN; // retain search toolbar
    private static String STRING_FOOD_SEARCH; // retain editText
    private static int CURRENT_PAGE = 0; // Was used to control page items with CURRENT_PAGE++

    private View v; // Main content view
    private View mListViewFooter; // ListView Footer
    private FoodDatabaseHelper db;
    private FoodDatabaseHelper1 db1;

    MySharedPreference pref;
    String food_name,carbohydrate,calories,protein,fat,serving_description,serving_id, fud_id, fud_name;
    String a_carb, a_pro, a_fat, a_cal, a_serving;

    private SearchAdapter mSearchAdapter;
    private ArrayList<Item> mItem;
    QuickReturnAttacher mQuickReturnAttacher; // Library: https://github.com/felipecsl/QuickReturn
    RelativeLayout mSlidingLayout;

    Dialog dialog;
    Boolean isListClicked = false;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_fatsecret_search, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        setHasOptionsMenu(true);
        mListViewFooter = inflater.inflate(R.layout.search_row_footer, null);
        if (savedInstanceState != null) {
            IS_SEARCH_VISIBLE = savedInstanceState.getBoolean("IS_SEARCH_VISIBLE");
            STRING_FOOD_SEARCH = savedInstanceState.getString("STRING_FOOD_SEARCH");
            SEARCH_RETAIN = savedInstanceState.getBoolean("SEARCH_RETAIN");
        }
        findViewsById();
        // toolbarTop();
        toolbarSearch();
        // retainState();
        searchImplementation();
        getImplementation();
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mToolbarSearch.getVisibility() == View.VISIBLE)
            outState.putBoolean("IS_SEARCH_VISIBLE", true);
        if (mSearch.getText().toString().length() > 0)
            outState.putString("STRING_FOOD_SEARCH", mSearch.getText().toString());
        outState.putBoolean("SEARCH_RETAIN", SEARCH_RETAIN);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    private void retainState() {
        if (IS_SEARCH_VISIBLE) {
            mToolbarSearch.setVisibility(View.VISIBLE);
            mToolbarSearch.bringToFront();
            mToolbarSearch.startAnimation(mFadeIn);
            mSearch.requestFocus();
        }
        if (STRING_FOOD_SEARCH != null)
            mSearch.setText(STRING_FOOD_SEARCH);
        if (SEARCH_RETAIN) searchFood(mSearch.getText().toString(), 0);
    }

    private void updateList() {
        if (mSearchAdapter.getCount() == 0) {
            mListView.setVisibility(View.GONE);
        } else {
            mListView.setVisibility(View.VISIBLE);
        }
    }

    private FatSecretSearch mFatSecretSearch;
    private FatSecretGet mFatSecretGet;
    private Animation mFadeIn;
    private InputMethodManager imm;
    private Toolbar mToolbarTop, mToolbarSearch;
    private EditText mSearch;
    private ListView mListView;
    private ProgressBar mProgressMore, mProgressSearch;
    String meal_type, date;

    private void findViewsById() {
        mFatSecretSearch = new FatSecretSearch(); // method.search
        mFatSecretGet = new FatSecretGet(); // method.get
        meal_type = getArguments().getString("Meal_type");
        date = getArguments().getString("Date");
        // Toast.makeText(getActivity(), meal_type, Toast.LENGTH_SHORT).show();
        mFadeIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fadein);
        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); // handle soft keyboard
        mToolbarTop = v.findViewById(R.id.toolbar_top);
        mToolbarSearch = v.findViewById(R.id.toolbar_search);
        mSearch = v.findViewById(R.id.etSearch);
        mListView = v.findViewById(R.id.listView);
        listViewConfigurations();
        mProgressMore = mListViewFooter.findViewById(R.id.progressBar);
        mProgressMore.setVisibility(View.INVISIBLE);
        mProgressSearch = v.findViewById(R.id.searchProgress);
        mProgressSearch.setVisibility(View.INVISIBLE);
        updateList();
        db = new FoodDatabaseHelper(getActivity());
        db1 = new FoodDatabaseHelper1(getActivity());
    }

    private void listViewConfigurations() {
        mListView.addFooterView(mListViewFooter);
        mItem = new ArrayList<>();
        mSearchAdapter = new SearchAdapter(getActivity(), mItem);
        mListView.setAdapter(new QuickReturnAdapter(mSearchAdapter));

        mListView.setSelection(mSearchAdapter.getCount() - 1);
        mQuickReturnAttacher = QuickReturnAttacher.forView(mListView);
        mSlidingLayout = v.findViewById(R.id.relativeLayout);
        mQuickReturnAttacher.addTargetView(mSlidingLayout, QuickReturnTargetView.POSITION_TOP, Equations.dpToPx(getActivity(), 55));
    }
//mListView .setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
    private void toolbarTop() {
        mToolbarTop.setTitle("Search");
        mToolbarTop.inflateMenu(R.menu.menu_main);
        mToolbarTop.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_search) {
                    mToolbarSearch.setVisibility(View.VISIBLE);
                    mToolbarSearch.bringToFront();
                    mToolbarSearch.startAnimation(mFadeIn);
                    mSearch.requestFocus();
                    IS_SEARCH_VISIBLE = true;
                    CURRENT_PAGE = 0;
                    imm.toggleSoftInput(0, 0);
                }
                return false;
            }
        });
    }

    private void toolbarSearch() {
        mToolbarSearch.setVisibility(View.VISIBLE);
        mToolbarSearch.bringToFront();
        //mToolbarSearch.startAnimation(mFadeIn);
        mSearch.requestFocus();
        IS_SEARCH_VISIBLE = true;
        CURRENT_PAGE = 0;
        imm.toggleSoftInput(0, 0);
        // mToolbarSearch.inflateMenu(R.menu.menu_search);
        // mToolbarSearch.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_arrow_back));
        /*mToolbarSearch.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbarSearch.setVisibility(View.GONE);
                imm.hideSoftInputFromWindow(mSearch.getWindowToken(), 0);
                mSearch.setText("");
                mToolbarSearch.getMenu().clear();
                mToolbarSearch.inflateMenu(R.menu.menu_search);
                mToolbarTop.bringToFront();
                mItem.clear();
                mSearchAdapter.notifyDataSetChanged();
                IS_SEARCH_VISIBLE = false;
                CURRENT_PAGE = 0;
                SEARCH_RETAIN = false;
                updateList();
            }
        });*/
        mToolbarSearch.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItem = item.getItemId();
                /*if (menuItem == R.id.action_voice) {
                    promptSpeechInput();
                }*/
                if (menuItem == R.id.action_clear) {
                    mSearch.setText("");
                    SEARCH_RETAIN = false;
                }
                return false;
            }
        });

        mSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 1) {
                    mItem.clear();
                    mToolbarSearch.getMenu().clear();
                    mToolbarSearch.inflateMenu(R.menu.menu_search_clear);
                    searchFood(mSearch.getText().toString(), 0);
                } else {
                    mToolbarSearch.getMenu().clear();
                    // mToolbarSearch.inflateMenu(R.menu.menu_search);
                    mItem.clear();
                    mSearchAdapter.notifyDataSetChanged();
                    updateList();
                    CURRENT_PAGE = 0;
                    SEARCH_RETAIN = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() >= 1) {
                    mItem.clear();
                    mToolbarSearch.getMenu().clear();
                    mToolbarSearch.inflateMenu(R.menu.menu_search_clear);
                    searchFood(mSearch.getText().toString(), 0);
                } else {
                    mToolbarSearch.getMenu().clear();
                    // mToolbarSearch.inflateMenu(R.menu.menu_search);
                    mItem.clear();
                    mSearchAdapter.notifyDataSetChanged();
                    updateList();
                    CURRENT_PAGE = 0;
                    SEARCH_RETAIN = false;
                }
            }
        });
    }
    private void searchImplementation() {
        mSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    searchFood(mSearch.getText().toString(), CURRENT_PAGE);
                    mSearch.clearFocus();
                    return true;
                }
                return false;
            }
        });
    }

    private void getImplementation() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < mItem.size()) { // Should to be refactored
                    // getFood(Long.valueOf(mItem.get(position - 1).getID()));

                    fud_id = mItem.get(position - 1).getID();
                    fud_name = mItem.get(position - 1).getTitle();
                    carbohydrate = mItem.get(position - 1).getFoodCarb();
                    calories = mItem.get(position - 1).getFoodCal();
                    protein = mItem.get(position - 1).getFoodPro();
                    fat = mItem.get(position - 1).getFoodFat();
                    serving_description = mItem.get(position - 1).getFoodServe();

                    System.out.println("Nutrition values " + carbohydrate + " " + calories + " " + protein + " " + fat + " " + serving_description);

                    if (!isListClicked) {
                        fooddialog();
                        isListClicked = true;
                    } else {
                        isListClicked = false;
                    }
                    // String food_desc = mItem.get(position-1).getFoodDescription();
                    // String food_name = mItem.get(position-1).getTitle();
                    // Toast.makeText(getActivity(), food_name + "\n" + food_desc, Toast.LENGTH_SHORT).show();
                } else {
                    if (mItem.size() == 20)
                        searchFood(mSearch.getText().toString(), 1);
                    else if (mItem.size() == 40)
                        searchFood(mSearch.getText().toString(), 2);
                    else if (mItem.size() == 60)
                        searchFood(mSearch.getText().toString(), 3);
                    else if (mItem.size() == 80)
                        searchFood(mSearch.getText().toString(), 4);
                    else if (mItem.size() == 100)
                        searchFood(mSearch.getText().toString(), 5);
                    else if (mItem.size() == 120)
                        searchFood(mSearch.getText().toString(), 6);
                    else if (mItem.size() == 140)
                        searchFood(mSearch.getText().toString(), 7);
                    else if (mItem.size() == 160)
                        searchFood(mSearch.getText().toString(), 8);
                    else if (mItem.size() == 180)
                        searchFood(mSearch.getText().toString(), 9);
                    else if (mItem.size() == 200)
                        searchFood(mSearch.getText().toString(), 10);
                }
            }
        });
    }

    /**
     * FatSecret Search
     */
    String brand;

    private void searchFood(final String item, final int page_num) {
        new AsyncTask<String, String, String>() {
            @Override
            protected void onPreExecute() {
                mProgressMore.setVisibility(View.VISIBLE);
                mProgressSearch.setVisibility(View.VISIBLE);
            }

            @Override
            protected String doInBackground(String... arg0) {
                JSONObject food = mFatSecretSearch.searchFood(item, page_num);
                JSONArray FOODS_ARRAY;
                try {
                    if (food != null) {
                        Object fud = food.get("food");
                        if(fud instanceof JSONArray){
                            FOODS_ARRAY = food.getJSONArray("food");
                            if (FOODS_ARRAY != null) {
                                for (int i = 0; i < FOODS_ARRAY.length(); i++) {
                                    JSONObject food_items = FOODS_ARRAY.optJSONObject(i);
                                    String food_name = food_items.getString("food_name");
                                    String food_description = food_items.getString("food_description");
                                    String[] row = food_description.split(" - ");
                                    String first_part = row[0];
                                    String second_part = row[1];
                                    a_serving = first_part;
                                    String[] split1 = second_part.split(" | ");
                                    String first_second_part = split1[1];
                                    String second_second_part = split1[4];
                                    String third_second_part = split1[7];
                                    String fourth_second_part = split1[10];
                                    a_cal = first_second_part.replaceAll("[^0-9?!\\.]","");
                                    a_fat = second_second_part.replaceAll("[^0-9?!\\.]","");
                                    a_carb = third_second_part.replaceAll("[^0-9?!\\.]","");
                                    a_pro = fourth_second_part.replaceAll("[^0-9?!\\.]","");

                                    String id = food_items.getString("food_type");
                                    if (id.equals("Brand")) {
                                        brand = food_items.getString("brand_name");
                                    }
                                    if (id.equals("Generic")) {
                                        brand = "Generic";
                                    }
                                    String food_id = food_items.getString("food_id");
                                    mItem.add(new Item(food_name, row[1],
                                            "" + brand, food_id, a_cal, a_fat, a_carb, a_pro, a_serving));
                                }
                            }
                        }

                        if(fud instanceof JSONObject){
                            JSONObject fud1 = food.getJSONObject("food");
                            String food_name = fud1.getString("food_name");
                            String food_description = fud1.getString("food_description");
                            String[] row = food_description.split(" - ");
                            String first_part = row[0];
                            String second_part = row[1];
                            a_serving = first_part;
                            String[] split1 = second_part.split(" | ");
                            String first_second_part = split1[1];
                            String second_second_part = split1[4];
                            String third_second_part = split1[7];
                            String fourth_second_part = split1[10];
                            a_cal = first_second_part.replaceAll("[^0-9?!\\.]","");
                            a_fat = second_second_part.replaceAll("[^0-9?!\\.]","");
                            a_carb = third_second_part.replaceAll("[^0-9?!\\.]","");
                            a_pro = fourth_second_part.replaceAll("[^0-9?!\\.]","");
                            String id = fud1.getString("food_type");
                            if (id.equals("Brand")) {
                                brand = fud1.getString("brand_name");
                            }
                            if (id.equals("Generic")) {
                                brand = "Generic";
                            }
                            String food_id = fud1.getString("food_id");
                            mItem.add(new Item(food_name, row[1].substring(1),
                                    "" + brand, food_id, a_cal, a_fat, a_carb, a_pro, a_serving));
                            //Toast.makeText(getActivity(),"Object",Toast.LENGTH_SHORT).show();
                        }

                    }
                } catch (JSONException exception) {
                    return "Error";
                }
                return "";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                if (result.equals("Error"))
                    Toast.makeText(getActivity(), "No Items Containing Your Search", Toast.LENGTH_SHORT).show();
                mSearchAdapter.notifyDataSetChanged();
                updateList();
                mProgressMore.setVisibility(View.INVISIBLE);
                mProgressSearch.setVisibility(View.INVISIBLE);
                SEARCH_RETAIN = true;
            }
        }.execute();
    }

    /**
     * FatSecret get
     */
    private void getFood(final long id) {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... arg0) {
                JSONObject foodGet = mFatSecretGet.getFood(id);
                try {
                    if (foodGet != null) {
                        food_name = foodGet.getString("food_name");
                        JSONObject servings = foodGet.getJSONObject("servings");

                        Object serve = servings.get("serving");
                        System.out.println("Details" + serve);
                        if(serve instanceof JSONArray){
                            JSONArray serving = servings.getJSONArray("serving");
                            for (int j = 0; j < serving.length(); j++) {
                                JSONObject c = serving.getJSONObject(j);
                                serving_id = c.getString("serving_id");
                                carbohydrate = c.getString("carbohydrate");
                                calories = c.getString("calories");
                                protein = c.getString("protein");
                                fat = c.getString("fat");
                                serving_description = c.getString("serving_description");
                            }
                        }

                        if(serve instanceof JSONObject){
                            JSONObject serve1 = servings.getJSONObject("serving");
                            serving_id = serve1.getString("serving_id");
                            carbohydrate = serve1.getString("carbohydrate");
                            calories = serve1.getString("calories");
                            protein = serve1.getString("protein");
                            fat = serve1.getString("fat");
                            serving_description = serve1.getString("serving_description");
                        }
                    }
                } catch (JSONException exception) {
                    return "Error";
                }
                return "";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                if (result.equals("Error"))
                    Toast.makeText(getActivity(), "No Items Containing Your Search", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    /*
    Get Method
     Nutrient values for each food item are returned according to the standard serving sizes available. The elements returned for each standard serving size are:
     serving_id – the unique serving identifier.
     serving_description – the full description of the serving size. E.G.: "1 cup" or "100 g".
     serving_url – URL of the serving size for this food item on www.fatsecret.com.
     metric_serving_amount is a Decimal - the metric quantity combined with metric_serving_unit to derive the total standardized quantity of the serving (where available).
     metric_serving_unit – the metric unit of measure for the serving size – either "g" or "ml" or "oz" – combined with metric_serving_amount to derive the total standardized quantity of the serving (where available).
     number_of_units is a Decimal - the number of units in this standard serving size. For instance, if the serving description is "2 tablespoons" the number of units is "2", while if the serving size is "1 cup" the number of units is "1".
     measurement_description – a description of the unit of measure used in the serving description. For instance, if the description is "1/2 cup" the measurement description is "cup", while if the serving size is "100 g" the measurement description is "g".
     The complete nutritional information is returned - see nutrient
     calories is a Decimal – the energy content in kcal.
     carbohydrate is a Decimal – the total carbohydrate content in grams.
     protein is a Decimal – the protein content in grams.
     fat is a Decimal – the total fat content in grams.
     saturated_fat is a Decimal – the saturated fat content in grams (where available).
     polyunsaturated_fat is a Decimal – the polyunsaturated fat content in grams (where available).
     monounsaturated_fat is a Decimal – the monounsaturated fat content in grams (where available).
     trans_fat is a Decimal – the trans fat content in grams (where available).
     cholesterol is a Decimal – the cholesterol content in milligrams (where available).
     sodium is a Decimal – the sodium content in milligrams (where available).
     potassium is a Decimal – the potassium content in milligrams (where available).
     fiber is a Decimal – the fiber content in grams (where available).
     sugar is a Decimal – the sugar content in grams (where available).
     vitamin_a is a Decimal – the percentage of daily recommended Vitamin A, based on a 2000 calorie diet (where available).
     vitamin_c is a Decimal – the percentage of daily recommended Vitamin C, based on a 2000 calorie diet (where available).
     calcium is a Decimal – the percentage of daily recommended Calcium, based on a 2000 calorie diet (where available).
     iron is a Decimal – the percentage of daily recommended Iron, based on a 2000 calorie diet (where available).
      */
    /*
      Speech Input
       */
    private final int REQ_CODE_SPEECH_INPUT = 100;

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say Something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getActivity().getApplicationContext(), "Not Supported", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_SPEECH_INPUT) {
            if (resultCode == Activity.RESULT_OK && null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                mSearch.setText(result.get(0));
                searchFood(mSearch.getText().toString(), CURRENT_PAGE);
                mSearch.clearFocus();
            }
        }
    }


    /**
     * Interface to transfer data to MainActivity
     */

    private FatSecretSearchFragment.FragmentCallbacks mCallbacks;

    private void responsebuilder (String food_name2, String serve_id, String food_nutrition, String meal_type, String no_serve, String date) {
        JSONArray arr = new JSONArray();
        JSONObject obj = new JSONObject();
        try {
            obj.put("FoodName", food_name2);
            obj.put("FoodID", serve_id);
            obj.put("FoodNutritionalInfo", food_nutrition);
            obj.put("Type", meal_type);
            obj.put("Quantity", no_serve);
            obj.put("Date", date);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        arr.put(obj);
        callApi(RequestHealthConstants.SAVE_FOOD_TRACKING_DATA, arr);
    }

    private void callApi(Integer id, JSONArray a) {
        if (id == RequestHealthConstants.SAVE_FOOD_TRACKING_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                object.put("UserID", pref.getUID());
                object.put("TargetCalaries", pref.getcaloriegoal());
                object.put("DboardFoodLog", a);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_FOOD_TRACKING_DATA, this, RequestHealthConstants.SAVE_FOOD_TRACKING_DATA);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_FOOD_TRACKING_DATA) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                Log.e("Message", "Successfully Added");
            } else {
                Log.e("Message", "Not Added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    public interface FragmentCallbacks {
        void fromFragment();
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



    void addFragment(Fragment frg) {
        Bundle args = new Bundle();
        args.putString("Meal_type", meal_type);
        frg.setArguments(args);
        if (frg != null)
        {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, frg).commit();
            onDestroy();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void fooddialog() {
        final FoodIntake n = db.getFoodIntake(pref.getUID(),meal_type,date);
        final FoodIntake1 n1 = db1.getFoodIntake1(meal_type, pref.getUID());
        // if(n == null){

        final int count = db.getFoodIntakeCount(pref.getUID());
        final int count1 = db1.getFoodIntakeCount1(pref.getUID());

        dialog = new Dialog(getActivity(),R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.servings_add1);
        final TextView food_name1 = dialog.findViewById(R.id.food_name);
        food_name1.setText(fud_name);
        final TextView food_servings = dialog.findViewById(R.id.food_servings);
        food_servings.setText(serving_description);
        final TextView food_description = dialog.findViewById(R.id.food_description);
        food_description.setText("Calories: " + calories + " | Carbs: " + carbohydrate + " | Protein: " + protein + " | Fat: " + fat);
        final EditText no_of_serving = dialog.findViewById(R.id.no_of_serving);
        final RelativeLayout cancel = dialog.findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isListClicked = false;
                dialog.dismiss(); }
        });
        final RelativeLayout add = dialog.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no_serve = no_of_serving.getText().toString();
                if(no_serve.equals("") || no_serve.equals(null)){
                    Toast.makeText(getActivity(), "Please fill the field", Toast.LENGTH_SHORT).show();
                } else {
                    float no_serve1 = Float.parseFloat(no_serve);
                    String food_name2 = fud_name;
                    float cal = Float.parseFloat(calories) * no_serve1;
                    float carb = Float.parseFloat(carbohydrate) * no_serve1;
                    float pro = Float.parseFloat(protein) * no_serve1;
                    float fat1 = Float.parseFloat(fat) * no_serve1;
                    String serve_id = fud_id;
                    String food_nutrition = "Nutrition : " + serving_description +" - Calories: " + calories + " kcal | Fat: " + fat + " g | Carbs: " + carbohydrate + " g | Protein: " + protein + " g" ;
                    if (count == 0 && count1 == 0) {
                        Toast.makeText(getActivity(), "Food added successfully" , Toast.LENGTH_SHORT).show();
                        long id = db.insertFoodIntake(pref.getUID(), meal_type, food_name2, String.valueOf(cal), String.valueOf(carb), String.valueOf(fat1), String.valueOf(pro), date, String.valueOf(serve_id), food_nutrition, no_serve);
                        long id1 = db1.insertFoodIntake1(pref.getUID(), meal_type, food_name2, String.valueOf(calories), String.valueOf(carbohydrate), String.valueOf(fat), String.valueOf(protein), String.valueOf(serving_description), String.valueOf(serve_id), food_nutrition, "1");
                        responsebuilder(food_name2, serve_id, food_nutrition, meal_type, no_serve, date);
//                        ((MainActivityHealth) getActivity()).getCurrentFragment();
                        addFragment(new FoodIntakeMainTab());


                    } else if (count == 0 && count1 != 0) {
                        Toast.makeText(getActivity(), "Food added successfully" , Toast.LENGTH_SHORT).show();
                        long id1 = db.insertFoodIntake(pref.getUID(), meal_type, food_name2, String.valueOf(cal), String.valueOf(carb), String.valueOf(fat1), String.valueOf(pro), date, String.valueOf(serve_id), food_nutrition, no_serve);
                        boolean a = db1.CheckIsDataAlreadyInDBorNot1(meal_type, serve_id, pref.getUID());
                        if (a == true) {
                            String incre = db1.getFoodIntake2(meal_type, serve_id, pref.getUID());
                            int b = Integer.parseInt(incre) + 1;
                            int b1 = db1.updateFoodIntake1(pref.getUID(), meal_type, food_name2, String.valueOf(calories), String.valueOf(carbohydrate), String.valueOf(fat), String.valueOf(protein), String.valueOf(serving_description), String.valueOf(serve_id), food_nutrition, String.valueOf(b));
                        } else {
                            long id2 = db1.insertFoodIntake1(pref.getUID(), meal_type, food_name2, String.valueOf(calories), String.valueOf(carbohydrate), String.valueOf(fat), String.valueOf(protein), String.valueOf(serving_description), String.valueOf(serve_id), food_nutrition, "1");
                        }
                        responsebuilder(food_name2, serve_id, food_nutrition, meal_type, no_serve, date);
//                        ((MainActivityHealth) getActivity()).getCurrentFragment();
                        addFragment(new FoodIntakeMainTab());

                    } else {
                        Toast.makeText(getActivity(), "Food added successfully" , Toast.LENGTH_SHORT).show();
                        boolean c = db.CheckIsDataAlreadyInDBorNot(meal_type, serve_id, date, pref.getUID());
                        if (c == true) {
                            int d = db.updateFoodIntake(pref.getUID(), meal_type, food_name2,String.valueOf(cal), String.valueOf(carb), String.valueOf(fat1), String.valueOf(pro), date, String.valueOf(serve_id), food_nutrition, no_serve);
                        } else {
                            long id3 = db.insertFoodIntake(pref.getUID(), meal_type, food_name2, String.valueOf(cal), String.valueOf(carb), String.valueOf(fat1), String.valueOf(pro), date, String.valueOf(serve_id), food_nutrition, no_serve);
                        }

                        boolean d = db1.CheckIsDataAlreadyInDBorNot1(meal_type, serve_id, pref.getUID());
                        if (d == true) {
                            String incre = db1.getFoodIntake2(meal_type, serve_id, pref.getUID());
                            int e = Integer.parseInt(incre) + 1;
                            int e1 = db1.updateFoodIntake1(pref.getUID(), meal_type, food_name2, String.valueOf(calories), String.valueOf(carbohydrate), String.valueOf(fat), String.valueOf(protein), String.valueOf(serving_description), String.valueOf(serve_id), food_nutrition, String.valueOf(e));
                        } else {
                            long id4 = db1.insertFoodIntake1(pref.getUID(), meal_type, food_name2, String.valueOf(calories), String.valueOf(carbohydrate), String.valueOf(fat), String.valueOf(protein), String.valueOf(serving_description), String.valueOf(serve_id), food_nutrition, "1");
                        }

                        responsebuilder(food_name2, serve_id, food_nutrition, meal_type, no_serve, date);
//                        ((MainActivityHealth) getActivity()).getCurrentFragment();
                        addFragment(new FoodIntakeMainTab());

                    }
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    isListClicked = false;
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}
