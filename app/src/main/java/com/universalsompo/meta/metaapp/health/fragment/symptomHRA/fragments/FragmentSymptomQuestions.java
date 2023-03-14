package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments;

import android.annotation.SuppressLint;
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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.MultipleGroupAdapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Multiplegroup_getter_setter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Singlegroup_getter_setter;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.CustomProgressDialog;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.SingleGroupAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import params.com.stepprogressview.StepProgressView;

public class FragmentSymptomQuestions extends Fragment {
    View v;
    private SelectorListener binder;
    MySharedPreference pref;
    private List<BasicQuestion> symptomList;
    private List<BasicQuestion> symptomListbasic;
    private List<BasicQuestion> symptomListsearch;
    private List<BasicQuestion> symptomListsuggest;
    private List<BasicQuestion> symptomListsymptomques;
    BasicQuesDatabaseHelper db;
    CustomProgressDialog customprogress;

    /* Single question */
    private LinearLayout single_type;
    private TextView ques;
    private RadioGroup radioGroup;
    private RadioButton present, absent, unknown;
    private Button back, next;
    String choice_id, selected_date, id1, name1;

    /* Single group question */
    private LinearLayout group_single_layout;
    private TextView single_ques;
    private ListView group_single_list;
    public Button next1, back1;
    private SingleGroupAdapter mAdapter;
    private List<Singlegroup_getter_setter> group_single;

    /* Group multiple question */
    private LinearLayout group_multiple_layout;
    private TextView multiple_ques;
    private ListView group_multiple_list;
    public Button next2, back2;
    private MultipleGroupAdapter mAdapter1;
    private List<Multiplegroup_getter_setter> group_multiple;

    String type, question, choice_id1;
    int n;
    int abc, abc1;
    private StepProgressView state_progress;
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    List<Integer> list;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_symptom_question, container, false);
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        db = new BasicQuesDatabaseHelper(getActivity());
        customprogress = new CustomProgressDialog(getActivity());
        init();
        return v;
    }

    private void init() {
        list = new ArrayList<>(arr.length);
        for (int i : arr) {
            list.add(Integer.valueOf(i));
        }
        state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(8);
        state_progress.setMarkerColor(getResources().getColor(R.color.grey));
        state_progress.setProgressColor(getResources().getColor(R.color.my_policy_tab_dark));
        state_progress.setMarkers(list);

        /* Single question */
        single_type = v.findViewById(R.id.single_type);
        ques = v.findViewById(R.id.ques);
        radioGroup = v.findViewById(R.id.radioGroup);
        present = v.findViewById(R.id.present);
        absent = v.findViewById(R.id.absent);
        unknown = v.findViewById(R.id.unknown);
        back = v.findViewById(R.id.back);
        next = v.findViewById(R.id.next);

        /* Single group question */
        group_single_layout = v.findViewById(R.id.single_multiple_type);
        single_ques = v.findViewById(R.id.single_ques);
        group_single_list = v.findViewById(R.id.group_single_list);
        next1 = v.findViewById(R.id.next1);
        back1 = v.findViewById(R.id.back1);

        /* Group multiple question */
        group_multiple_layout = v.findViewById(R.id.group_multiple_type);
        multiple_ques = v.findViewById(R.id.multiple_ques);
        group_multiple_list = v.findViewById(R.id.group_multiple_list);
        next2 = v.findViewById(R.id.next2);
        back2 = v.findViewById(R.id.back2);

        responsebuilder();
    }

    public void responsebuilder(){
        symptomList = new ArrayList<>();
        symptomList.addAll(db.getAllBasicSymptom(pref.getSymptominterviewid()));
        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : symptomList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("choice_id", cn.getbasicChoiceid().toLowerCase());
                if(cn.getbasicInit().equalsIgnoreCase("true")){
                    symp.put("initial", cn.getbasicInit());
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Forward array" + jsonArray);
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
        System.out.println("jsonString: " + jsonStr);
        getQuestion(jsonStr);
    }

    public void responsebuilder1(){
        symptomListbasic = new ArrayList<>();
        symptomListsearch = new ArrayList<>();
        symptomListsuggest = new ArrayList<>();
        symptomListbasic.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentBasicQuestion"));
        symptomListsearch.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentSymptomSearch"));
        symptomListbasic.addAll(symptomListsearch);
        int suggest_count = db.getBasicSymptomSuggestCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
        if (suggest_count != 0) {
            symptomListsuggest.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentSymptomSuggestions"));
            symptomListbasic.addAll(symptomListsuggest);
        }

        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : symptomListbasic) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("choice_id", cn.getbasicChoiceid().toLowerCase());
                if(cn.getbasicInit().equalsIgnoreCase("true")){
                    symp.put("initial", cn.getbasicInit());
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Backward array" + jsonArray);
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
        System.out.println("jsonString: " + jsonStr);
        getQuestion(jsonStr);
    }

    public void responsebuilder2(){
        symptomListbasic = new ArrayList<>();
        symptomListsearch = new ArrayList<>();
        symptomListsuggest = new ArrayList<>();
        symptomListsymptomques = new ArrayList<>();
        symptomListbasic.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentBasicQuestion"));
        symptomListsearch.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentSymptomSearch"));
        symptomListbasic.addAll(symptomListsearch);
        int suggest_count = db.getBasicSymptomSuggestCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
        if (suggest_count != 0) {
            symptomListsuggest.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentSymptomSuggestions"));
            symptomListbasic.addAll(symptomListsuggest);
        }
        symptomListsymptomques.addAll(db.getAllSymptomAsFrag(pref.getSymptominterviewid(), "FragmentSymptomQuestions"));
        symptomListbasic.addAll(symptomListsymptomques);

        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : symptomListbasic) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("choice_id", cn.getbasicChoiceid().toLowerCase());
                if(cn.getbasicInit().equalsIgnoreCase("true")){
                    symp.put("initial", cn.getbasicInit());
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Backward array" + jsonArray);
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
        System.out.println("jsonString: " + jsonStr);
        getQuestion(jsonStr);
    }

    public void responsebuilder3(int count){
        symptomListbasic = new ArrayList<>();
        symptomListsearch = new ArrayList<>();
        symptomListsuggest = new ArrayList<>();
        symptomListsymptomques = new ArrayList<>();
        symptomListbasic.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentBasicQuestion"));
        symptomListsearch.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentSymptomSearch"));
        symptomListbasic.addAll(symptomListsearch);
        int suggest_count = db.getBasicSymptomSuggestCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
        if (suggest_count != 0) {
            symptomListsuggest.addAll(db.getAllBasicSymptomAsFrag(pref.getSymptominterviewid(), "FragmentSymptomSuggestions"));
            symptomListbasic.addAll(symptomListsuggest);
        }
        symptomListsymptomques.addAll(db.getAllSymptomAsFrag1(pref.getSymptominterviewid(), "FragmentSymptomQuestions", count));
        symptomListbasic.addAll(symptomListsymptomques);

        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : symptomListbasic) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("choice_id", cn.getbasicChoiceid().toLowerCase());
                if(cn.getbasicInit().equalsIgnoreCase("true")){
                    symp.put("initial", cn.getbasicInit());
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Backward array" + jsonArray);
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
        System.out.println("jsonString: " + jsonStr);
        getQuestion(jsonStr);
    }

    public void getQuestion(final String s2) {
        customprogress.showProgressBar();
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, s2);
        Request request = new Request.Builder()
                .url("https://api.infermedica.com/v2/diagnosis")
                .post(body)
                .addHeader("app-id", "4eb1d3a2")
                .addHeader("app-key", "0032394801c5c304ddc208f9761b46ff")
                .addHeader("content-type", "application/json")
                .addHeader("Model", "infermedica-en")
                .addHeader("Interview-Id", pref.getSymptominterviewid())
                .addHeader("User-Id", pref.getUID())
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "b81ebff0-e92d-f259-81d6-d090f6858158")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage();
                Log.w("failure Response", mMessage);
                Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
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
                    String id = null;
                    group_single = new ArrayList<>();
                    group_multiple = new ArrayList<>();
                    try {
                        JSONObject jobj = new JSONObject(mMessage);
                        JSONObject jobj1 = jobj.getJSONObject("question");
                        final String type = jobj1.getString("type");
                        final String ques1 = jobj1.getString("text");
                        JSONArray jarray = jobj1.getJSONArray("items");
                        final String should_stop = jobj.getString("should_stop");
                        if(type.equalsIgnoreCase("single")){
                            for(int i = 0 ; i < jarray.length(); i++){
                                JSONObject a = jarray.getJSONObject(i);
                                id = a.getString("id");
                            }
                        } else if(type.equalsIgnoreCase("group_single")){
                            for(int i1 = 0 ; i1 < jarray.length(); i1++){
                                JSONObject a1 = jarray.getJSONObject(i1);
                                group_single.add(new Singlegroup_getter_setter(a1.getString("id"),a1.getString("name")));
                            }
                        }  else if(type.equalsIgnoreCase("group_multiple")){
                            for(int i2 = 0 ; i2 < jarray.length(); i2++){
                                JSONObject a2 = jarray.getJSONObject(i2);
                                group_multiple.add(new Multiplegroup_getter_setter(a2.getString("id"),a2.getString("name")));
                            }
                        }


                        id1 = id;
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                customprogress.hideProgressBar();
                                abc = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                abc1 = abc + 1;
                                state_progress.setCurrentProgress(abc);
                                /*if (abc == 0) {
                                } else if (abc == 1) {

                                    //state_progress.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                                } else if (abc == 2) {
                                    //state_progress.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                                } else if (abc == 3) {
                                    //state_progress.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                                } else if (abc == 4) {
                                    //state_progress.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
                                } else if (abc == 5) {
                                    //state_progress.setCurrentStateNumber(StateProgressBar.StateNumber.FIVE);
                                }*/
                                if ( abc < 7 ) {
                                    if(should_stop.equalsIgnoreCase("false")){
                                        if(type.equalsIgnoreCase("single")){
                                            single_type.setVisibility(View.VISIBLE);
                                            group_single_layout.setVisibility(View.GONE);
                                            group_multiple_layout.setVisibility(View.GONE);
                                            ques.setText(ques1);
                                            radioGroup.clearCheck();

                                            radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
                                                RadioButton rb = group.findViewById(checkedId);
                                                if (null != rb && checkedId > -1) {
                                                    String choice = (String) rb.getText();
                                                    if (choice.equalsIgnoreCase("Yes")) {
                                                        choice_id = "present";
                                                    } else if (choice.equalsIgnoreCase("No")) {
                                                        choice_id = "absent";
                                                    } else {
                                                        choice_id = "unknown";
                                                    }
                                                }
                                            });

                                            boolean ques_present = db.CheckIsQuestionAlreadyInDBorNot(pref.getSymptominterviewid(), "FragmentSymptomQuestions", ques1, pref.getUID());
                                            if (ques_present == true) {
                                                choice_id = db.getChoiceIdFromQuestion(pref.getUID(), pref.getSymptominterviewid(), ques1, "FragmentSymptomQuestions");
                                                if (choice_id.equalsIgnoreCase("present")) {
                                                    radioGroup.check(R.id.present);
                                                } else if (choice_id.equalsIgnoreCase("absent")) {
                                                    radioGroup.check(R.id.absent);
                                                } else {
                                                    radioGroup.check(R.id.unknown);
                                                }
                                            }

                                            Date c = Calendar.getInstance().getTime();
                                            System.out.println("Current time => " + c);

                                            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                                            selected_date = df.format(c);

                                            next.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {

                                                    if (choice_id == null) {
                                                        Toast.makeText(getActivity(), "Please select a value", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        boolean a = db.CheckIsQuesDataAlreadyInDBorNot(pref.getSymptominterviewid(), "FragmentSymptomQuestions", ques1, pref.getUID());
                                                        if (a == true) {
                                                            long b1 = db.updateBasicSymptomQuesBased(pref.getUID(), pref.getUserName(), pref.getSymptominterviewid(), "single", ques1, id1, ques1, "false", choice_id, selected_date, "FragmentSymptomQuestions");
                                                        } else {
                                                            long id2 = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), pref.getSymptominterviewid(), "single", ques1, id1, ques1, "false", choice_id, selected_date, "FragmentSymptomQuestions");
                                                        }
                                                        responsebuilder();
                                                    }
                                                }
                                            });

                                            back.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    boolean a = db.CheckIsQuesDataAlreadyInDBorNot(pref.getSymptominterviewid(), "FragmentSymptomQuestions", ques1, pref.getUID());
                                                    if (a == true) {
                                                        db.deleteMultipleQues(pref.getSymptominterviewid(), ques1, "FragmentSymptomQuestions");
                                                        int total_row = db.getBasicSymptomCountAsPerFragment(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                        if (total_row > 0) {
                                                            int distinct_ques = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                            if (distinct_ques == 1) {
                                                                single_type.setVisibility(View.GONE);
                                                                responsebuilder1();
                                                            } else {
                                                                String questn = db.getLastRowQuestion(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                int count_questn = db.getBasicSymptomCountAsPerQuestion(pref.getUID(), pref.getSymptominterviewid(), questn, "FragmentSymptomQuestions");
                                                                if (count_questn == 1) {
                                                                    int distinct_ques1 = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                    if (distinct_ques1 == 1) {
                                                                        single_type.setVisibility(View.GONE);
                                                                        responsebuilder1();
                                                                    } else {
                                                                        single_type.setVisibility(View.GONE);
                                                                        responsebuilder2();
                                                                    }
                                                                } else {
                                                                    int distinct_ques2 = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                    if (distinct_ques2 == 1) {
                                                                        single_type.setVisibility(View.GONE);
                                                                        responsebuilder1();
                                                                    } else {
                                                                        single_type.setVisibility(View.GONE);
                                                                        responsebuilder3(count_questn);
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            replaceFragment(new FragmentSymptomSearch(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                                            db.deleteSuggestedItems(pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
                                                        }
                                                    } else {
                                                        int total_row = db.getBasicSymptomCountAsPerFragment(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                        if (total_row > 0) {
                                                            String questn = db.getLastRowQuestion(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                            int count_questn = db.getBasicSymptomCountAsPerQuestion(pref.getUID(), pref.getSymptominterviewid(), questn, "FragmentSymptomQuestions");
                                                            if (count_questn == 1) {
                                                                int distinct_ques = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                if (distinct_ques == 1) {
                                                                    single_type.setVisibility(View.GONE);
                                                                    responsebuilder1();
                                                                } else {
                                                                    single_type.setVisibility(View.GONE);
                                                                    responsebuilder2();
                                                                }
                                                            } else {
                                                                int distinct_ques = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                if (distinct_ques == 1) {
                                                                    single_type.setVisibility(View.GONE);
                                                                    responsebuilder1();
                                                                } else {
                                                                    single_type.setVisibility(View.GONE);
                                                                    responsebuilder3(count_questn);
                                                                }
                                                            }
                                                        } else {
                                                            replaceFragment(new FragmentSymptomSearch(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                                            db.deleteSuggestedItems(pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
                                                        }
                                                    }
                                                }
                                            });
                                        } else if(type.equalsIgnoreCase("group_single")){
                                            single_type.setVisibility(View.GONE);
                                            group_single_layout.setVisibility(View.VISIBLE);
                                            group_multiple_layout.setVisibility(View.GONE);
                                            single_ques.setText(ques1);
                                            mAdapter = new SingleGroupAdapter(getActivity(), new FragmentSymptomQuestions(), group_single, group_single_list, next1, back1, ques1);
                                            group_single_list.setAdapter(mAdapter);

                                            back1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    boolean a = db.CheckIsQuesDataAlreadyInDBorNot(pref.getSymptominterviewid(), "FragmentSymptomQuestions", ques1, pref.getUID());
                                                    if (a == true) {
                                                        db.deleteMultipleQues(pref.getSymptominterviewid(), ques1, "FragmentSymptomQuestions");
                                                        int total_row = db.getBasicSymptomCountAsPerFragment(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                        if (total_row > 0) {
                                                            int distinct_ques = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                            if (distinct_ques == 1) {
                                                                group_single_layout.setVisibility(View.GONE);
                                                                responsebuilder1();
                                                            } else {
                                                                String questn = db.getLastRowQuestion(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                int count_questn = db.getBasicSymptomCountAsPerQuestion(pref.getUID(), pref.getSymptominterviewid(), questn, "FragmentSymptomQuestions");
                                                                if (count_questn == 1) {
                                                                    int distinct_ques1 = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                    if (distinct_ques1 == 1) {
                                                                        group_single_layout.setVisibility(View.GONE);
                                                                        responsebuilder1();
                                                                    } else {
                                                                        group_single_layout.setVisibility(View.GONE);
                                                                        responsebuilder2();
                                                                    }
                                                                } else {
                                                                    int distinct_ques2 = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                    if (distinct_ques2 == 1) {
                                                                        group_single_layout.setVisibility(View.GONE);
                                                                        responsebuilder1();
                                                                    } else {
                                                                        group_single_layout.setVisibility(View.GONE);
                                                                        responsebuilder3(count_questn);
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            replaceFragment(new FragmentSymptomSearch(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                                            db.deleteSuggestedItems(pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
                                                        }
                                                    } else {
                                                        int total_row = db.getBasicSymptomCountAsPerFragment(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                        if (total_row > 0) {
                                                            String questn = db.getLastRowQuestion(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                            int count_questn = db.getBasicSymptomCountAsPerQuestion(pref.getUID(), pref.getSymptominterviewid(), questn, "FragmentSymptomQuestions");
                                                            if (count_questn == 1) {
                                                                int distinct_ques = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                if (distinct_ques == 1) {
                                                                    group_single_layout.setVisibility(View.GONE);
                                                                    responsebuilder1();
                                                                } else {
                                                                    group_single_layout.setVisibility(View.GONE);
                                                                    responsebuilder2();
                                                                }
                                                            } else {
                                                                int distinct_ques = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                if (distinct_ques == 1) {
                                                                    group_single_layout.setVisibility(View.GONE);
                                                                    responsebuilder1();
                                                                } else {
                                                                    group_single_layout.setVisibility(View.GONE);
                                                                    responsebuilder3(count_questn);
                                                                }
                                                            }
                                                        } else {
                                                            replaceFragment(new FragmentSymptomSearch(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                                            db.deleteSuggestedItems(pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
                                                        }
                                                    }
                                                }
                                            });
                                        } else if(type.equalsIgnoreCase("group_multiple")){
                                            single_type.setVisibility(View.GONE);
                                            group_single_layout.setVisibility(View.GONE);
                                            group_multiple_layout.setVisibility(View.VISIBLE);
                                            multiple_ques.setText(ques1);
                                            mAdapter1 = new MultipleGroupAdapter(getActivity(), new FragmentSymptomQuestions(), group_multiple, group_multiple_list, next2, back2, ques1);
                                            group_multiple_list.setAdapter(mAdapter1);
                                            justifyListViewHeightBasedOnChildren(group_multiple_list);

                                            next2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    int ques_count = db.getBasicSymptomCountAsPerQuestion(pref.getUID(), pref.getSymptominterviewid(), ques1, "FragmentSymptomQuestions");
                                                    if (ques_count == group_multiple_list.getCount()) {
                                                        Fragment frag = new FragmentSymptomQuestions();
                                                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                                    } else {
                                                        Toast.makeText(getActivity(), "Please select all values", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                            back2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    boolean a = db.CheckIsQuesDataAlreadyInDBorNot(pref.getSymptominterviewid(), "FragmentSymptomQuestions", ques1, pref.getUID());
                                                    if (a == true) {
                                                        db.deleteMultipleQues(pref.getSymptominterviewid(), ques1, "FragmentSymptomQuestions");
                                                        int total_row = db.getBasicSymptomCountAsPerFragment(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                        if (total_row > 0) {
                                                            int distinct_ques = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                            if (distinct_ques == 1) {
                                                                group_multiple_layout.setVisibility(View.GONE);
                                                                responsebuilder1();
                                                            } else {
                                                                String questn = db.getLastRowQuestion(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                int count_questn = db.getBasicSymptomCountAsPerQuestion(pref.getUID(), pref.getSymptominterviewid(), questn, "FragmentSymptomQuestions");
                                                                if (count_questn == 1) {
                                                                    group_multiple_layout.setVisibility(View.GONE);
                                                                    responsebuilder2();
                                                                } else {
                                                                    group_multiple_layout.setVisibility(View.GONE);
                                                                    responsebuilder3(count_questn);
                                                                }
                                                            }
                                                        } else {
                                                            replaceFragment(new FragmentSymptomSearch(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                                            db.deleteSuggestedItems(pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
                                                        }
                                                    } else {
                                                        int total_row = db.getBasicSymptomCountAsPerFragment(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                        if (total_row > 0) {
                                                            int distinct_ques = db.getBasicSymptomQuestionCount(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                            if (distinct_ques == 1) {
                                                                group_multiple_layout.setVisibility(View.GONE);
                                                                responsebuilder1();
                                                            } else {
                                                                String questn = db.getLastRowQuestion(pref.getUID(), pref.getSymptominterviewid(), "FragmentSymptomQuestions");
                                                                int count_questn = db.getBasicSymptomCountAsPerQuestion(pref.getUID(), pref.getSymptominterviewid(), questn, "FragmentSymptomQuestions");
                                                                if (count_questn == 1) {
                                                                    group_multiple_layout.setVisibility(View.GONE);
                                                                    responsebuilder2();
                                                                } else {
                                                                    group_multiple_layout.setVisibility(View.GONE);
                                                                    responsebuilder3(count_questn);
                                                                }
                                                            }
                                                        } else {
                                                            replaceFragment(new FragmentSymptomSearch(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                                            db.deleteSuggestedItems(pref.getSymptominterviewid(), "FragmentSymptomSuggestions");
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    } else {
                                        replaceFragment(new FragmentSymptomResult(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                    }
                                } else {
                                    replaceFragment(new FragmentSymptomResult(), FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                                }
                            }
                        });

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
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
