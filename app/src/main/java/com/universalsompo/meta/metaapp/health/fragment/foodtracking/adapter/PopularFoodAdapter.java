package com.universalsompo.meta.metaapp.health.fragment.foodtracking.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.FatSecretImplementation.FatSecretGet;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;

import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodDatabaseHelper1;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodIntake;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.database.FoodIntake1;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.fragment.FragmentFoodItemsList;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.model.FoodModel1;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PopularFoodAdapter extends RecyclerView.Adapter<PopularFoodAdapter.MyViewHolder> implements ResponseListener {
    private Activity activity;
    private List<FoodModel1> popularfoodModelList;
    FragmentFoodItemsList fragment;
    private LayoutInflater inflater;
    private FatSecretGet mFatSecretGet;
    MySharedPreference pref;
    private FoodDatabaseHelper db;
    private FoodDatabaseHelper1 db1;
    String meal_type, date;
    int meal_type_id;
    String selected_date, selected_date1;
    int dateDifference;

    public PopularFoodAdapter(Activity activity, List<FoodModel1> popularfoodModelList, String meal_type, String date, FragmentFoodItemsList Fragment) {
        this.activity = activity;
        this.popularfoodModelList = popularfoodModelList;
        this.meal_type = meal_type;
        this.date = date;
        this.fragment = Fragment;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView food_name, food_nutrition;
        LinearLayout add_food_again;

        public MyViewHolder(View view) {
            super(view);
            food_name = view.findViewById(R.id.food_name);
            food_nutrition = view.findViewById(R.id.food_nutrition);
            add_food_again = view.findViewById(R.id.add_food_again);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_food_list_item, parent, false);
        pref = MySharedPreference.getInstance(activity);
        mFatSecretGet = new FatSecretGet();
        db = new FoodDatabaseHelper(activity);
        db1 = new FoodDatabaseHelper1(activity);
        getcurrentdate();
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.food_name.setText(popularfoodModelList.get(position).getname());
        holder.food_nutrition.setText(popularfoodModelList.get(position).getnutrition());

        dateDifference = (int) getDateDiff(new SimpleDateFormat("MM/dd/yyyy"), date, selected_date1);
        System.out.println("dateDifference: " + selected_date + selected_date1 + dateDifference);
        if(dateDifference > 3) {
            holder.add_food_again.setVisibility(View.GONE);
        } else {
            holder.add_food_again.setVisibility(View.VISIBLE);
        }

        holder.add_food_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addagaindialog(popularfoodModelList.get(position).getname(), popularfoodModelList.get(position).getFood_id(), popularfoodModelList.get(position).getCal(), popularfoodModelList.get(position).getCarb(), popularfoodModelList.get(position).getPro(), popularfoodModelList.get(position).getFat(), popularfoodModelList.get(position).getServe_desc());
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularfoodModelList.size();
    }

    public void addagaindialog(final String food_name, final String food_id, final String cal, final String carb, final String pro, final String fat, final String serve_desc) {
        final FoodIntake n = db.getFoodIntake(pref.getUID(),meal_type,date);
        final FoodIntake1 n1 = db1.getFoodIntake1(meal_type, pref.getUID());
        final int count = db.getFoodIntakeCount(pref.getUID());
        final int count1 = db1.getFoodIntakeCount1(pref.getUID());

        final Dialog dialog = new Dialog(activity,R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.servings_add1);
        final TextView food_name1 = dialog.findViewById(R.id.food_name);
        food_name1.setText(food_name);
        final TextView food_servings = dialog.findViewById(R.id.food_servings);
        food_servings.setText(serve_desc);
        final TextView food_description = dialog.findViewById(R.id.food_description);
        food_description.setText("Calories: " + cal + " | Carbs: " + carb + " | Protein: " + pro + " | Fat: " + fat);
        final EditText no_of_serving = dialog.findViewById(R.id.no_of_serving);
        final RelativeLayout cancel = dialog.findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); }
        });

        final RelativeLayout add = dialog.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no_serve = no_of_serving.getText().toString();
                if(no_serve.equals("") || no_serve.equals(null)){
                    Toast.makeText(activity, "Please fill the field", Toast.LENGTH_SHORT).show();
                } else {
                    float no_serve1 = Float.parseFloat(no_serve);
                    String food_name2 = food_name;
                    float cal1 = Float.parseFloat(cal) * no_serve1;
                    float carb1 = Float.parseFloat(carb) * no_serve1;
                    float pro1 = Float.parseFloat(pro) * no_serve1;
                    float fat1 = Float.parseFloat(fat) * no_serve1;
                    String serve_id = food_id;
                    Log.e("Serve " , serve_id);
                    String food_nutrition = "Nutrition : " + serve_desc +" - Calories: " + cal + " kcal | Carbs: " + carb + " g | Protein: " + pro + " g | Fat: " + fat + " g";
                    if (count == 0 && count1 == 0) {
                        Toast.makeText(activity, "Food added successfully" , Toast.LENGTH_SHORT).show();
                        long id = db.insertFoodIntake(pref.getUID(), meal_type, food_name2, String.valueOf(cal1), String.valueOf(carb1), String.valueOf(fat1), String.valueOf(pro1), date, String.valueOf(serve_id), food_nutrition, no_serve);
                        long id1 = db1.insertFoodIntake1(pref.getUID(), meal_type, food_name2, cal, carb, fat, pro, String.valueOf(serve_desc), String.valueOf(serve_id), food_nutrition, "1");
                        responsebuilder(food_name2, serve_id, food_nutrition, meal_type, no_serve, date);
                    } else if (count == 0 && count1 != 0) {
                        Toast.makeText(activity, "Food added successfully" , Toast.LENGTH_SHORT).show();
                        long id1 = db.insertFoodIntake(pref.getUID(), meal_type, food_name2, String.valueOf(cal1), String.valueOf(carb1), String.valueOf(fat1), String.valueOf(pro1), date, String.valueOf(serve_id), food_nutrition, no_serve);
                        boolean a = db1.CheckIsDataAlreadyInDBorNot1(meal_type, serve_id, pref.getUID());
                        if (a == true) {
                            String incre = db1.getFoodIntake2(meal_type, serve_id, pref.getUID());
                            int b = Integer.parseInt(incre) + 1;
                            int b1 = db1.updateFoodIntake1(pref.getUID(), meal_type, food_name2, cal, carb, fat, pro, String.valueOf(serve_desc), String.valueOf(serve_id), food_nutrition, String.valueOf(b));
                        } else {
                            long id2 = db1.insertFoodIntake1(pref.getUID(), meal_type, food_name2, cal, carb, fat, pro, String.valueOf(serve_desc), String.valueOf(serve_id), food_nutrition, "1");
                        }
                        responsebuilder(food_name2, serve_id, food_nutrition, meal_type, no_serve, date);
                    } else {
                        Toast.makeText(activity, "Food added successfully" , Toast.LENGTH_SHORT).show();
                        boolean c = db.CheckIsDataAlreadyInDBorNot(meal_type, serve_id, date, pref.getUID());
                        if (c == true) {
                            int d = db.updateFoodIntake(pref.getUID(), meal_type, food_name2,String.valueOf(cal1), String.valueOf(carb1), String.valueOf(fat1), String.valueOf(pro1), date, String.valueOf(serve_id), food_nutrition, no_serve);
                        } else {
                            long id3 = db.insertFoodIntake(pref.getUID(), meal_type, food_name2, String.valueOf(cal1), String.valueOf(carb1), String.valueOf(fat1), String.valueOf(pro1), date, String.valueOf(serve_id), food_nutrition, no_serve);
                        }

                        boolean d = db1.CheckIsDataAlreadyInDBorNot1(meal_type, serve_id, pref.getUID());
                        if (d == true) {
                            String incre = db1.getFoodIntake2(meal_type, serve_id, pref.getUID());
                            int e = Integer.parseInt(incre) + 1;
                            int e1 = db1.updateFoodIntake1(pref.getUID(), meal_type, food_name2, cal, carb, fat, pro, String.valueOf(serve_desc), String.valueOf(serve_id), food_nutrition, String.valueOf(e));
                        } else {
                            long id4 = db1.insertFoodIntake1(pref.getUID(), meal_type, food_name2, cal, carb, fat, pro, String.valueOf(serve_desc), String.valueOf(serve_id), food_nutrition, "1");
                        }

                        responsebuilder(food_name2, serve_id, food_nutrition, meal_type, no_serve, date);
                    }
                    InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

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
            ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.SAVE_FOOD_TRACKING_DATA, this, RequestHealthConstants.SAVE_FOOD_TRACKING_DATA);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_FOOD_TRACKING_DATA) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                Log.e("Message", "Successfully Added");
                if (meal_type.equalsIgnoreCase("EarlyMorning")) {
                    meal_type_id = 0;
                    fragment.loaddata(meal_type_id, date);
                } else if (meal_type.equalsIgnoreCase("Breakfast")) {
                    meal_type_id = 1;
                    fragment.loaddata(meal_type_id, date);
                } else if (meal_type.equalsIgnoreCase("Lunch")) {
                    meal_type_id = 2;
                    fragment.loaddata(meal_type_id, date);
                } else if (meal_type.equalsIgnoreCase("EveningSnacks")) {
                    meal_type_id = 3;
                    fragment.loaddata(meal_type_id, date);
                } else if (meal_type.equalsIgnoreCase("Dinner")) {
                    meal_type_id = 4;
                    fragment.loaddata(meal_type_id, date);
                }
            } else {
                Log.e("Message", "Not Added");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    public void getcurrentdate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        selected_date1 = selected_date;
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
