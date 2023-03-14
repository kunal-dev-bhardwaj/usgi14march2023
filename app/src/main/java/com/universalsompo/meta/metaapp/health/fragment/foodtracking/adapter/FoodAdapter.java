package com.universalsompo.meta.metaapp.health.fragment.foodtracking.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.fragment.FragmentFoodItemsList;
import com.universalsompo.meta.metaapp.health.fragment.foodtracking.model.FoodModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> implements ResponseListener {
    private Activity activity;
    private List<FoodModel> foodModelList;
    FragmentFoodItemsList fragment;
    MySharedPreference pref;
    RecyclerView recyclerview;
    private int position;
    String meal_type, date;

    public FoodAdapter(Activity activity, List<FoodModel> foodModelList, RecyclerView recyclerview, FragmentFoodItemsList fragment, String meal_type, String date) {
        this.activity = activity;
        this.foodModelList = foodModelList;
        this.recyclerview = recyclerview;
        this.fragment = fragment;
        this.meal_type = meal_type;
        this.date = date;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView food_name, food_cal, food_no_serve;
        LinearLayout delete_item;

        public MyViewHolder(View view) {
            super(view);
            food_name = view.findViewById(R.id.food_name);
            food_cal = view.findViewById(R.id.food_cal);
            food_no_serve = view.findViewById(R.id.food_no_serve);
            delete_item = view.findViewById(R.id.delete_item);
        }
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, parent, false);
        pref = MySharedPreference.getInstance(activity);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.food_name.setText(foodModelList.get(position).getname());

        meal_type = foodModelList.get(position).getmeal_type();
        date = foodModelList.get(position).getdate();
        String no_of_serves = foodModelList.get(position).getNo_of_serve();
        String no_of_cal = foodModelList.get(position).getcal();
        String[] split = no_of_cal.split(" ");
        String firstSubString = split[0];
        int no_of_serves1 = Integer.parseInt(no_of_serves);
        int no_of_cal1 = Integer.parseInt(firstSubString);
        int calc = no_of_serves1 * no_of_cal1;

        holder.food_cal.setText(calc + " kcal");
        holder.food_no_serve.setText("Qty : " + foodModelList.get(position).getNo_of_serve());

        holder.delete_item.setOnClickListener(v -> {
            FoodAdapter.this.position = position;
            callApi(position);
        });
    }

    @Override
    public int getItemCount() {
        return foodModelList.size();
    }

    private void callApi(Integer pos) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("LogID", foodModelList.get(pos).getfood_id());
            object.put("Date", foodModelList.get(pos).getdate());
            object.put("Type", foodModelList.get(pos).getmeal_type());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.DELETE_FOOD_ITEM, this, RequestHealthConstants.DELETE_FOOD_ITEM);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.DELETE_FOOD_ITEM) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                Log.e("Deleted", "Successfully deleted");
                fragment.callApi(RequestHealthConstants.GET_FOOD_DATA, pref.getUID(), meal_type, date);
            } else {
                Log.e("Not Deleted", "Not deleted");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
