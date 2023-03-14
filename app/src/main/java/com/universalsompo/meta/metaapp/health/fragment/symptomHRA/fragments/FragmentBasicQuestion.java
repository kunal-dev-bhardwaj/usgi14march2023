package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.BasicQuesAdapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.BasicQuesModel;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentBasicQuestion extends Fragment {
    private View v;
    private MySharedPreference prefrences;
    private SelectorListener binder;
    private BasicQuesDatabaseHelper db;
    private ArrayList<BasicQuesModel> data = new ArrayList<>();
    private RecyclerView basic_question_list;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_symptom_basic_question, container,false);
        new AppDataPushApi().callApi(getActivity(),"Symptom HRA","Basic question page","User started symptom HRA");
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        prefrences = MySharedPreference.getInstance(getActivity());
        db = new BasicQuesDatabaseHelper(getActivity());
        init();
        return v;
    }

    private void init() {
        basic_question_list = v.findViewById(R.id.basic_question_list);
        Button next = v.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no_of_value = db.getAllBasicSymptomWithChoiceID0(prefrences.getUID(), prefrences.getSymptominterviewid());
                if (no_of_value == 0) {
                    replaceFragment(new FragmentSymptomSearch());
                } else {
                    Toast.makeText(getActivity(), "Please select all statements", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getbasicsymptoms();
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    private void getbasicsymptoms(){
        List<BasicQuestion> basicquestionList = new ArrayList<>();
        basicquestionList.addAll(db.getAllBasicSymptom(prefrences.getSymptominterviewid(), "FragmentBasicQuestion"));
        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : basicquestionList) {
            JSONObject basic_interview_ques = new JSONObject();
            try {
                basic_interview_ques.put("basic_userid", cn.getbasicUserid());
                basic_interview_ques.put("basic_username", cn.getbasicUsername());
                basic_interview_ques.put("basic_interviewid", cn.getbasicInterviewid());
                basic_interview_ques.put("basic_symptomid", cn.getbasicSymptomid());
                basic_interview_ques.put("basic_symptomname", cn.getbasicName());
                basic_interview_ques.put("basic_initial", cn.getbasicInit());
                basic_interview_ques.put("basic_choiceid", cn.getbasicChoiceid());
                basic_interview_ques.put("basic_date", cn.getbasicDate());
                basic_interview_ques.put("basic_fragment_name", cn.getbasicFragmentname());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(basic_interview_ques);
        }

        JSONObject foodObj = new JSONObject();
        try {
            foodObj.put("basic_questions", jsonArray);
            if(jsonArray.length() > 0){
                foodObj.put("message", "success");
            } else {
                foodObj.put("message", "error");
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = foodObj.toString();
        System.out.println("jsonString: " + jsonStr);

        try {
            JSONObject obj = new JSONObject(jsonStr);
            if (obj.optString("message").equals("success")){
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = obj.getJSONArray("basic_questions");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj1 = arr.getJSONObject(i);
                        data.add(
                                new BasicQuesModel(
                                        obj1.optString("basic_userid"),
                                        obj1.optString("basic_username"),
                                        obj1.optString("basic_interviewid"),
                                        obj1.optString("basic_symptomid"),
                                        obj1.optString("basic_symptomname"),
                                        obj1.optString("basic_initial"),
                                        obj1.optString("basic_choiceid"),
                                        obj1.optString("basic_date"),
                                        obj1.optString("basic_fragment_name")
                                )
                        );
                    }
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    basic_question_list.setLayoutManager(layoutManager);
                    BasicQuesAdapter basicquesAdapter = new BasicQuesAdapter(getActivity(), data, basic_question_list, FragmentBasicQuestion.this);
                    basic_question_list.setAdapter(basicquesAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void replaceFragment(Fragment frag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
            binder.detect(FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
