package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.fragment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.adapter.RedeemPointsListAdapter;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model.RedeemPointsList;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FragmentWYHRedeemPoints extends Fragment {
    private View v;
    private RecyclerView redeem_points_list;
    private final ArrayList<RedeemPointsList> data = new ArrayList<>();
    private CustomProgressDialog customprogress;
    private MySharedPreference pref;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_redeem_points_list, container,false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        customprogress = new CustomProgressDialog(getActivity());
        pref = new MySharedPreference(getActivity());
        init();
        return v;
    }

    private void init() {
        redeem_points_list = v.findViewById(R.id.redeem_points_list);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(redeem_points_list.getContext(),
                getResources().getConfiguration().orientation);
        redeem_points_list.addItemDecoration(dividerItemDecoration);

        getredeempointlist();
    }

    private void getredeempointlist() {
        customprogress.showProgressBar();
        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("PolicyNumber", "2841/61176505/00/000");
            sympObj.put("MemberId", "101234939211");
            sympObj.put("RequestSource", "67946C5D-E3C9-4C32-943C-8440532C6652");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = sympObj.toString();

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonStr);
        Request request = new Request.Builder()
                .url(UrlHealthConstants.UPLOAD_WYH_REDEEM_POINTS_LIST)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("token", pref.getWYHAuthToken())
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "a57d8d70-0e6a-96df-b479-6f6e91c1f026")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        customprogress.hideProgressBar();
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String mMessage = Objects.requireNonNull(response.body()).string();
                Log.d("Response" , mMessage);
                if (response.isSuccessful()) {
                    try {
                        JSONObject jobj = new JSONObject(mMessage);
                        String a = jobj.getString("IsSuccess");
                        if (a.equalsIgnoreCase("true")) {
                            JSONArray jarray;
                            if (!data.isEmpty())
                                data.clear();
                            jarray = jobj.getJSONArray("Data");
                            for(int i1 = 0 ; i1 < jarray.length(); i1++){
                                JSONObject a1 = jarray.getJSONObject(i1);
                                data.add(new RedeemPointsList(a1.getString("Id") ,a1.getString("CategoryName") ,a1.getString("ActivityDescription") ,a1.getString("AllowdUserLimit")));
                            }
                            Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    customprogress.hideProgressBar();
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                    redeem_points_list.setLayoutManager(layoutManager);
                                    RedeemPointsListAdapter redeemPointsListAdapter = new RedeemPointsListAdapter(getActivity(), data);
                                    redeem_points_list.setAdapter(redeemPointsListAdapter);
                                }
                            });
                        } else {
                            if (jobj.optString("Message").equalsIgnoreCase("Authorization has been denied for this request")) {
                                Toast.makeText(getActivity(), "Token expired. Please recreate your token", Toast.LENGTH_SHORT).show();
                                (Objects.requireNonNull(getActivity())).onBackPressed();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
