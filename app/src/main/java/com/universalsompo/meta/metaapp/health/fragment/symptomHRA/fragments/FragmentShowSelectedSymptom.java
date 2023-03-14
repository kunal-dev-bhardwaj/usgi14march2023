package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.AbsentSymptomAdapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.DontKnowSymptomAdapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.PresentSymptomAdapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.ReportedSymptomAdapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.AbsentSymptom_getter_setter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.DontKnowSymptom_getter_setter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.PresentSymptom_getter_setter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.ReportedSymptom_getter_setter;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentShowSelectedSymptom extends Fragment {
    private View v, present_view, absent_view;
    private MySharedPreference pref;
    private SelectorListener binder;
    private BasicQuesDatabaseHelper db;
    private TextView tv_nameanswer, tv_sexanswer, tv_ageanswer, present_txt, absent_txt, dont_know_txt;
    private RecyclerView rv_reportedsymp, rv_presentsym, rv_absentsym, rv_dontknowsym;

    private List<BasicQuestion> reportedsymptomList;
    private List<BasicQuestion> presentsymptomList;
    private List<BasicQuestion> absentsymptomList;
    private List<BasicQuestion> dontknowsymptomList;

    private ReportedSymptomAdapter reportedsymptomAdapter;
    private ArrayList<ReportedSymptom_getter_setter> reported_symptom = new ArrayList<>();

    private PresentSymptomAdapter presentsymptomAdapter;
    private ArrayList<PresentSymptom_getter_setter> present_symptom = new ArrayList<>();

    private AbsentSymptomAdapter absentsymptomAdapter;
    private ArrayList<AbsentSymptom_getter_setter> absent_symptom = new ArrayList<>();

    private DontKnowSymptomAdapter dontknowsymptomAdapter;
    private ArrayList<DontKnowSymptom_getter_setter> dontknow_symptom = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_show_selected_symptom, container,false);
        ((MainActivityHealth)getActivity()).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        db = new BasicQuesDatabaseHelper(getActivity());
        init();
        return v;
    }

    void init() {
        tv_nameanswer = v.findViewById(R.id.tv_nameanswer);
        tv_sexanswer = v.findViewById(R.id.tv_sexanswer);
        tv_ageanswer = v.findViewById(R.id.tv_ageanswer);
        present_txt = v.findViewById(R.id.present_txt);
        absent_txt = v.findViewById(R.id.absent_txt);
        dont_know_txt = v.findViewById(R.id.dont_know_txt);
        present_view = v.findViewById(R.id.present_view);
        absent_view = v.findViewById(R.id.absent_view);
        rv_reportedsymp = v.findViewById(R.id.rv_reportedsymp);
        rv_presentsym = v.findViewById(R.id.rv_presentsym);
        rv_absentsym = v.findViewById(R.id.rv_absentsym);
        rv_dontknowsym = v.findViewById(R.id.rv_dontknowsym);

        rv_reportedsymp.setNestedScrollingEnabled(false);
        rv_presentsym.setNestedScrollingEnabled(false);
        rv_absentsym.setNestedScrollingEnabled(false);
        rv_dontknowsym.setNestedScrollingEnabled(false);

        tv_nameanswer.setText(pref.getUserName());
        tv_sexanswer.setText("Sex : " + pref.getgender());
        tv_ageanswer.setText("Age : " + pref.getAge() + " Years");

        responsebuilderreported();
        responsebuilderpresent();
        responsebuilderabsent();
        responsebuilderdontknow();
    }

    public void responsebuilderreported() {
        reportedsymptomList = new ArrayList<>();
        reportedsymptomList.addAll(db.getAllBasicSymptom(pref.getSymptominterviewid(), "FragmentSymptomSearch"));
        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : reportedsymptomList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("name", cn.getbasicName());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("reportedsymptoms", jsonArray);
            sympObj.put("message", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray arr1;
        if (!reported_symptom.isEmpty())
            reported_symptom.clear();
        try {
            arr1 = sympObj.getJSONArray("reportedsymptoms");
            for (int i = 0; i < arr1.length(); i++) {
                JSONObject obj = arr1.getJSONObject(i);
                reported_symptom.add(new ReportedSymptom_getter_setter(obj.getString("id"),obj.getString("name")));
            }
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            rv_reportedsymp.setLayoutManager(layoutManager);
            reportedsymptomAdapter = new ReportedSymptomAdapter(getActivity(), reported_symptom);
            rv_reportedsymp.setAdapter(reportedsymptomAdapter);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
    }

    public void responsebuilderpresent(){
        presentsymptomList = new ArrayList<>();
        presentsymptomList.addAll(db.getAllBasicSymptom(pref.getSymptominterviewid(), "present", "FragmentSymptomQuestions"));
        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : presentsymptomList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("name", cn.getbasicName());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("presentsymptoms", jsonArray);
            sympObj.put("message", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray arr1;
        if (!present_symptom.isEmpty())
            present_symptom.clear();
        try {
            arr1 = sympObj.getJSONArray("presentsymptoms");
            for (int i = 0; i < arr1.length(); i++) {
                JSONObject obj = arr1.getJSONObject(i);
                present_symptom.add(new PresentSymptom_getter_setter(obj.getString("id"),obj.getString("name")));
            }
            if (present_symptom.size() > 0) {
                present_txt.setVisibility(View.VISIBLE);
                present_view.setVisibility(View.VISIBLE);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                rv_presentsym.setLayoutManager(layoutManager);
                presentsymptomAdapter = new PresentSymptomAdapter(getActivity(), present_symptom);
                rv_presentsym.setAdapter(presentsymptomAdapter);
            } else {
                present_txt.setVisibility(View.GONE);
                present_view.setVisibility(View.GONE);
            }
        } catch (Exception e) {
                        e.printStackTrace();
                    }
    }

    public void responsebuilderabsent(){
        absentsymptomList = new ArrayList<>();
        absentsymptomList.addAll(db.getAllBasicSymptom(pref.getSymptominterviewid(), "absent", "FragmentSymptomQuestions"));
        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : absentsymptomList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("name", cn.getbasicName());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("absentsymptoms", jsonArray);
            sympObj.put("message", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray arr1;
        if (!absent_symptom.isEmpty())
            absent_symptom.clear();
        try {
            arr1 = sympObj.getJSONArray("absentsymptoms");
            for (int i = 0; i < arr1.length(); i++) {
                JSONObject obj = arr1.getJSONObject(i);
                absent_symptom.add(new AbsentSymptom_getter_setter(obj.getString("id"),obj.getString("name")));
            }
            if (absent_symptom.size() > 0) {
                absent_txt.setVisibility(View.VISIBLE);
                absent_view.setVisibility(View.VISIBLE);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                rv_absentsym.setLayoutManager(layoutManager);
                absentsymptomAdapter = new AbsentSymptomAdapter(getActivity(), absent_symptom);
                rv_absentsym.setAdapter(absentsymptomAdapter);
            } else {
                absent_txt.setVisibility(View.GONE);
                absent_view.setVisibility(View.GONE);
            }
        } catch (Exception e) {
                        e.printStackTrace();
                    }
    }

    public void responsebuilderdontknow(){
        dontknowsymptomList = new ArrayList<>();
        dontknowsymptomList.addAll(db.getAllBasicSymptom(pref.getSymptominterviewid(), "unknown", "FragmentSymptomQuestions"));
        JSONArray jsonArray = new JSONArray();
        for (BasicQuestion cn : dontknowsymptomList) {
            JSONObject symp = new JSONObject();
            try {
                symp.put("id", cn.getbasicSymptomid());
                symp.put("name", cn.getbasicName());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(symp);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("dontknowsymptoms", jsonArray);
            sympObj.put("message", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray arr1;
        if (!dontknow_symptom.isEmpty())
            dontknow_symptom.clear();
        try {
            arr1 = sympObj.getJSONArray("dontknowsymptoms");
            for (int i = 0; i < arr1.length(); i++) {
                JSONObject obj = arr1.getJSONObject(i);
                dontknow_symptom.add(new DontKnowSymptom_getter_setter(obj.getString("id"),obj.getString("name")));
            }
            if (dontknow_symptom.size() > 0) {
                dont_know_txt.setVisibility(View.VISIBLE);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                rv_dontknowsym.setLayoutManager(layoutManager);
                dontknowsymptomAdapter = new DontKnowSymptomAdapter(getActivity(), dontknow_symptom);
                rv_dontknowsym.setAdapter(dontknowsymptomAdapter);
            } else {
                dont_know_txt.setVisibility(View.GONE);
            }
        } catch (Exception e) {
                        e.printStackTrace();
                    }
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
}
