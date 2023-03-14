package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.Search_symptom_list_adapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.SymptomConfirmAdapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Search_symptom_list_getter_setter;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import com.universalsompo.meta.metaapp.utilities.WrappingGridView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FragmentSymptomSearch extends Fragment {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    private EditText symptoms;
    private Search_symptom_list_adapter symptomAdap;
    private List<Search_symptom_list_getter_setter> symptom;
    private ListView list;
    private Button next, back;
    private LinearLayout symptom_choosen_list;
    private WrappingGridView choosen_symptom;
    private BasicQuesDatabaseHelper db;
    private List<BasicQuestion> symptomList;
    private SymptomConfirmAdapter mAdapter;
    private LinearLayout buttons;
    private LinearLayout info_layout;
    private LinearLayout infermedica_text;
    private RelativeLayout relative_layout;
    private Context mContext;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_symptom_search, container,false);
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        prefrences = MySharedPreference.getInstance(getActivity());
        db = new BasicQuesDatabaseHelper(getActivity());
        mContext = getActivity();
        init();

        final View activityRootView = getActivity().findViewById(R.id.content_main1);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff > dpToPx(mContext, 200)) { // if more than 200 dp, it's probably a keyboard...
                    buttons.setVisibility(View.GONE);
                    info_layout.setVisibility(View.GONE);
                    infermedica_text.setVisibility(View.GONE);
                } else {
                    buttons.setVisibility(View.VISIBLE);
                    info_layout.setVisibility(View.VISIBLE);
                    infermedica_text.setVisibility(View.VISIBLE);
                }
            }
        });

        return v;
    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    void init() {
        symptoms = v.findViewById(R.id.symptoms);
        list = v.findViewById(R.id.list);
        next = v.findViewById(R.id.next);
        back = v.findViewById(R.id.back);
        symptom_choosen_list = v.findViewById(R.id.symptom_choosen_list);
        choosen_symptom = v.findViewById(R.id.choosen_symptom);
        buttons = v.findViewById(R.id.buttons);
        info_layout = v.findViewById(R.id.info_layout);
        infermedica_text = v.findViewById(R.id.infermedica_text);
        relative_layout = v.findViewById(R.id.relative_layout);

        symptomList = new ArrayList<>();
        symptomList.addAll(db.getAllBasicSymptom(prefrences.getSymptominterviewid(), "FragmentSymptomSearch"));
        if(symptomList.size() != 0){
            list.setVisibility(View.GONE);
            symptom_choosen_list.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            back.setVisibility(View.VISIBLE);
            mAdapter = new SymptomConfirmAdapter(getActivity(), symptomList, FragmentSymptomSearch.this, prefrences.getSymptominterviewid());
            choosen_symptom.setAdapter(mAdapter);
        } else {
            symptom_choosen_list.setVisibility(View.GONE);
            next.setVisibility(View.VISIBLE);
            back.setVisibility(View.VISIBLE);
        }

        symptoms.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(symptom_choosen_list.getVisibility() == View.VISIBLE){
                    symptom_choosen_list.setVisibility(View.GONE);
                    next.setVisibility(View.GONE);
                    list.setVisibility(View.VISIBLE);
                } else {
                    list.setVisibility(View.VISIBLE);
                }
                String s1 = symptoms.getText().toString();
                getSymptomList(s1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentBasicQuestion(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FragmentSymptomSuggestions(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
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

    private void getSymptomList(String s2) {
        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("https://api.infermedica.com/v2/search?phrase=" + s2 + "&sex="+ prefrences.getgender().toLowerCase() + "&max_results=8&type=symptom")
                .get()
                .addHeader("app-id", "4eb1d3a2")
                .addHeader("app-key", "0032394801c5c304ddc208f9761b46ff")
                .addHeader("Model", "infermedica-en")
                .addHeader("Interview-Id", prefrences.getSymptominterviewid())
                .addHeader("User-Id", prefrences.getUID())
                .addHeader("Dev-Mode", "true")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "861fd799-40d3-431c-4da0-deb611d0803f")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage();
                Log.w("failure Response", mMessage);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String mMessage = response.body().string();
                Log.d("Response" , mMessage);
                if (response.isSuccessful()){
                    symptom = new ArrayList<Search_symptom_list_getter_setter>();
                    try {
                        JSONArray json = new JSONArray(mMessage);
                        for (int i=0; i < json.length(); i++){
                            JSONObject c = json.getJSONObject(i);
                            symptom.add(
                                    new Search_symptom_list_getter_setter(c.getString("id"),c.getString("label"))
                            );
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                symptomAdap = new Search_symptom_list_adapter(getActivity(), symptom, list, prefrences.getSymptominterviewid(), next, back, symptom_choosen_list, choosen_symptom, symptoms, FragmentSymptomSearch.this);
                                list.setAdapter(symptomAdap);
                                symptomAdap.notifyDataSetChanged();
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
}
