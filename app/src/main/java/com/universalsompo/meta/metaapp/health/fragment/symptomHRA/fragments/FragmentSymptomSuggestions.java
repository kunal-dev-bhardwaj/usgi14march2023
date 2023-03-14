package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.Suggested_Symptom_list_adapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Suggested_Symptom_list_getter_setter;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FragmentSymptomSuggestions extends Fragment {
    View v;
    private SelectorListener binder;
    private List<BasicQuestion> symptomList = new ArrayList<>();
    private Suggested_Symptom_list_adapter symptomAdap;
    private List<Suggested_Symptom_list_getter_setter> symptom;
    private BasicQuesDatabaseHelper db;
    private ListView list;
    private Button next, back;
    CustomProgressDialog customprogress;
    MySharedPreference pref;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_symptom_suggestion, container, false);
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    void init() {
        customprogress = new CustomProgressDialog(getActivity());

        list = v.findViewById(R.id.list1);
        next = v.findViewById(R.id.next);
        back = v.findViewById(R.id.back);

        db = new BasicQuesDatabaseHelper(getActivity());

        symptomList.addAll(db.getAllBasicSymptom(pref.getSymptominterviewid()));

        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : symptomList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("choice_id", cn.getbasicChoiceid().toLowerCase());
                symp.put("initial", cn.getbasicInit());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
        }


        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("sex", pref.getgender().toLowerCase());
            sympObj.put("age", Integer.parseInt(pref.getAge()));
            sympObj.put("evidence", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = sympObj.toString();
        System.out.println("jsonString: "+jsonStr);
        getSuggestions(jsonStr);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FragmentSymptomQuestions(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentSymptomSearch(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                db.deleteSuggestedItems(pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
            }
        });
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

    private void getSuggestions(String s2) {
        customprogress.showProgressBar();
        final OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, s2);
        Request request = new Request.Builder()
                .url("https://api.infermedica.com/v2/suggest")
                .post(body)
                .addHeader("app-id", "4eb1d3a2")
                .addHeader("app-key", "0032394801c5c304ddc208f9761b46ff")
                .addHeader("content-type", "application/json")
                .addHeader("Model", "infermedica-en")
                .addHeader("Interview-Id", pref.getSymptominterviewid())
                .addHeader("User-Id", pref.getUID())
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "3c668ff3-eb1c-dca0-8e0b-2ffc4a2d905c")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage();
                Log.w("failure Response", mMessage);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        customprogress.hideProgressBar();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String mMessage = response.body().string();
                Log.d("Response" , mMessage);
                if (response.isSuccessful()){
                    symptom = new ArrayList<>();
                    try {
                        JSONArray json = new JSONArray(mMessage);
                        for (int i=0; i < json.length(); i++){
                            JSONObject c = json.getJSONObject(i);
                            symptom.add(
                                    new Suggested_Symptom_list_getter_setter(c.getString("id"),c.getString("name"), c.getString("common_name"))
                            );
                            Log.d("Values" , symptom.toString());
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                customprogress.hideProgressBar();
                                symptomAdap = new Suggested_Symptom_list_adapter(getActivity(), symptom, list);
                                list.setAdapter(symptomAdap);
                                justifyListViewHeightBasedOnChildren(list);
                            }
                        });
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
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

    public static void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
}
