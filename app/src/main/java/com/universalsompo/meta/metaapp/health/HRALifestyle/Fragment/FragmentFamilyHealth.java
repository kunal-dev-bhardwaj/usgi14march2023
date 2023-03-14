package com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Adapter.ReportedFamHisAdapter;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.Model.LifestyleHRAModel;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Model.Famhis_getter_setter;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import params.com.stepprogressview.StepProgressView;

public class FragmentFamilyHealth extends Fragment {
    private View v;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private TextView ques;
    private ListView list;
    private CheckBox chkbox1;
    private LinearLayout other_layout_edt;
    private EditText other_edt;
    private ArrayList<Famhis_getter_setter> reported_famhis = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_family_health, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        db = new LifestyleHRADatabaseHelper(getActivity());
        init();
        return v;
    }

    private void init() {
        ques =  v.findViewById(R.id.ques);
        list = v.findViewById(R.id.list);
        chkbox1 =  v.findViewById(R.id.chkbox1);
        other_layout_edt =  v.findViewById(R.id.other_layout_edt);
        other_edt = v.findViewById(R.id.other_edt);
        Button previous = v.findViewById(R.id.previous);
        Button next = v.findViewById(R.id.next);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(7);

        boolean b = db.CheckIsDataCol1AlreadyInDBorNotID(pref.getUID(), "Other", "FragmentFamilyHealth");
        if (b) {
            String others_value = db.getLifestyleAnsOtherValue(pref.getUID(), "FragmentFamilyHealth");
            if (others_value.isEmpty()) {
                chkbox1.setChecked(false);
                other_layout_edt.setVisibility(View.GONE);
            } else {
                chkbox1.setChecked(true);
                other_layout_edt.setVisibility(View.VISIBLE);
                other_edt.setText(others_value);
            }
        } else {
            chkbox1.setChecked(false);
            other_layout_edt.setVisibility(View.GONE);
        }

        chkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    other_layout_edt.setVisibility(View.VISIBLE);
                } else {
                    other_edt.setText("");
                    other_layout_edt.setVisibility(View.GONE);
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentCigarettes();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkbox1.isChecked()) {
                    if (other_edt.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Please enter value", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean other_avail = db.CheckIsOthersAlreadyInDBorNotID(pref.getUID(), "Other", "FragmentFamilyHealth");
                        if (other_avail) {
                            db.updateLifestyleValueOther(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "", "Other", "", "", "", "", "", "", "", other_edt.getText().toString(), "", "", "yes", "FragmentFamilyHealth");
                        } else {
                            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "", "Other", "", "", "", "", "", "", "", other_edt.getText().toString(), "", "", "yes", "FragmentFamilyHealth");
                        }
                        Fragment frag = new FragmentGeneralHealth();
                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                    }
                } else {
                    boolean other_avail = db.CheckIsOthersAlreadyInDBorNotID(pref.getUID(), "Other", "FragmentFamilyHealth");
                    if (other_avail) {
                        db.deleteOtherValues("Other", "FragmentFamilyHealth");
                        Fragment frag = new FragmentGeneralHealth();
                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                    } else {
                        Fragment frag = new FragmentGeneralHealth();
                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                    }
                }
            }
        });

        boolean check_values = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentFamilyHealth");
        if (check_values) {
            responsebuilder();
        } else {
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "None", "", "", "", "", "", "FAMILY", "1_NONE", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Anxiety", "", "", "", "", "", "FAMILY", "1_ANXIETY", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Arthritis", "", "", "", "", "", "FAMILY", "1_ARTHRITIS", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Asthma", "", "", "", "", "", "FAMILY", "1_ASTAMA", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Breast cancer", "", "", "", "", "", "FAMILY", "1_BRECANCER", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Cervical cancer", "", "", "", "", "", "FAMILY", "1_CERCANCER", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Colorectal cancer", "", "", "", "", "", "FAMILY", "1_COLORECTAL", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Depression", "", "", "", "", "", "FAMILY", "1_DEPRESSION", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Diabetic", "", "", "", "", "", "FAMILY", "1_DIABETIC", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Elevated cholestrol", "", "", "", "", "", "FAMILY", "1_ELECHOLESTEROL", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "High blood pressure", "", "", "", "", "", "FAMILY", "1_HIGHBP", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Heart attack under age 50", "", "", "", "", "", "FAMILY", "1_HRTATK", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Heart operation", "", "", "", "", "", "FAMILY", "1_HRTOPR", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Mental illness", "", "", "", "", "", "FAMILY", "1_MENTALILLNESS", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Migraine", "", "", "", "", "", "FAMILY", "1_MIGRAINE", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Obesity", "", "", "", "", "", "FAMILY", "1_OBESE", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Osteoporosis", "", "", "", "", "", "FAMILY", "1_OSTEOPOROSIS", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Prostate cancer", "", "", "", "", "", "FAMILY", "1_PROCANCER", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "8", ques.getText().toString(), "FHIST", "Stroke under age 50", "", "", "", "", "", "FAMILY", "1_STROKE", "", "SETFAMILYHIST", "", "no", "FragmentFamilyHealth");

            responsebuilder();
        }
    }

    public void responsebuilder() {
        List<LifestyleHRAModel> reportedList = new ArrayList<>();
        reportedList.addAll(db.getAllFamilyHist(pref.getUID(), pref.getsessionid(), "FragmentFamilyHealth"));
        JSONArray jsonArray = new JSONArray();
        for (LifestyleHRAModel cn : reportedList) {
            JSONObject famhis = new JSONObject();
            try {
                famhis.put("userid", cn.getUserid());
                famhis.put("authtoken", cn.getAuthtoken());
                famhis.put("accountid", cn.getAccountid());
                famhis.put("personid", cn.getPersonid());
                famhis.put("tempid", cn.getTemplateid());
                famhis.put("quesid", cn.getQuestionid());
                famhis.put("ques", cn.getQuestion());
                famhis.put("quescode", cn.getQuestioncode());
                famhis.put("col1", cn.getCol1());
                famhis.put("col2", cn.getCol2());
                famhis.put("col3", cn.getCol3());
                famhis.put("col4", cn.getCol4());
                famhis.put("col5", cn.getCol5());
                famhis.put("col6", cn.getCol6());
                famhis.put("category", cn.getCategory());
                famhis.put("answercode", cn.getAnswercode());
                famhis.put("ansother", cn.getAnswerother());
                famhis.put("paracode", cn.getParametercode());
                famhis.put("unit", cn.getUnit());
                famhis.put("yesno", cn.getYesno());
                famhis.put("frag", cn.getFragment());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(famhis);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("reportedfamhist", jsonArray);
            sympObj.put("message", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray arr1;
        if (!reported_famhis.isEmpty())
            reported_famhis.clear();
        try {
            arr1 = sympObj.getJSONArray("reportedfamhist");
            for (int i = 0; i < arr1.length(); i++) {
                JSONObject obj = arr1.getJSONObject(i);
                if (!obj.getString("col1").equalsIgnoreCase("Other")) {
                    reported_famhis.add(new Famhis_getter_setter(obj.getString("userid"), obj.getString("authtoken"), obj.getString("accountid"), obj.getString("personid"), obj.getString("tempid"), obj.getString("quesid"), obj.getString("ques"), obj.getString("quescode"), obj.getString("col1"), obj.getString("col2"), obj.getString("col3"), obj.getString("col4"), obj.getString("col5"), obj.getString("col6"), obj.getString("category"), obj.getString("answercode"), obj.getString("ansother"), obj.getString("paracode"), obj.getString("unit"), obj.getString("yesno"), obj.getString("frag")));
                    System.out.println("Col1 : " + obj.getString("col1") + " Yes_no : " + obj.getString("yesno"));
                }
            }

            ReportedFamHisAdapter reportedfamhisAdapter = new ReportedFamHisAdapter(getActivity(), reported_famhis);
            list.setAdapter(reportedfamhisAdapter);
            justifyListViewHeightBasedOnChildren(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void justifyListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
}
