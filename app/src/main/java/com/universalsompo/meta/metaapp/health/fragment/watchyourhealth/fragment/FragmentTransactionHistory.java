package com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.fragment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.adapter.TransactionHistoryListAdapter;
import com.universalsompo.meta.metaapp.health.fragment.watchyourhealth.model.TransactionHistoryList;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FragmentTransactionHistory extends Fragment {
    private View v;
    private RecyclerView transaction_history_list;
    private final ArrayList<TransactionHistoryList> data = new ArrayList<>();
    private CustomProgressDialog customprogress;
    private MySharedPreference pref;
    private TextView current_points;
    private TextView blocked_points;
    private LinearLayout no_data;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_transaction_history_list, container,false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).show_elevation();
        customprogress = new CustomProgressDialog(getActivity());
        pref = new MySharedPreference(getActivity());
        init();
        return v;
    }

    private void init() {
        transaction_history_list = v.findViewById(R.id.transaction_history_list);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(transaction_history_list.getContext(),
                getResources().getConfiguration().orientation);
        transaction_history_list.addItemDecoration(dividerItemDecoration);
        current_points = v.findViewById(R.id.current_points);
        blocked_points = v.findViewById(R.id.blocked_points);
        no_data = v.findViewById(R.id.no_data);

        gettransactionhistorylist();
    }

    private void gettransactionhistorylist() {
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
                .url(UrlHealthConstants.TRANSACTION_HISTORY)
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
                            JSONObject jobj1 = jobj.getJSONObject("Data");
                            JSONObject jobj2 = jobj1.getJSONObject("PolSummaryEntity");
                            final String curr_points = jobj2.getString("PolCurrentPoints");
                            final String block_points = jobj2.getString("PolBlockedPoints");
                            JSONArray jarray;
                            if (!data.isEmpty())
                                data.clear();
                            jarray = jobj1.getJSONArray("RewardTransactionsEntity");
                            if (jarray.length() != 0) {
                                for(int i1 = 0 ; i1 < jarray.length(); i1++) {
                                    JSONObject a1 = jarray.getJSONObject(i1);
                                    data.add(new TransactionHistoryList(a1.getString("Id") ,a1.getString("OpeningBalance") ,a1.getString("Amount") ,a1.getString("ClosingBalance") ,a1.getString("TransactionType") ,a1.getString("Perticular") ,a1.getString("CreatedOn")));
                                }
                                Collections.reverse(data);
                                Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        current_points.setText(curr_points);
                                        blocked_points.setText(block_points);
                                        customprogress.hideProgressBar();
                                        transaction_history_list.setVisibility(View.VISIBLE);
                                        no_data.setVisibility(View.GONE);
                                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                        transaction_history_list.setLayoutManager(layoutManager);
                                        TransactionHistoryListAdapter redeemPointsListAdapter = new TransactionHistoryListAdapter(getActivity(), data);
                                        transaction_history_list.setAdapter(redeemPointsListAdapter);
                                    }
                                });
                            } else {
                                Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        current_points.setText(curr_points);
                                        blocked_points.setText(block_points);
                                        customprogress.hideProgressBar();
                                        transaction_history_list.setVisibility(View.GONE);
                                        no_data.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
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
