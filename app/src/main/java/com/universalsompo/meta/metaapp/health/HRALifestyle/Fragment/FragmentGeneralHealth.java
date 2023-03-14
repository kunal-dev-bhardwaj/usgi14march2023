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
import com.universalsompo.meta.metaapp.health.HRALifestyle.Adapter.ReportedUserHisAdapter;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.Model.LifestyleHRAModel;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Model.Userhis_getter_setter;
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

public class FragmentGeneralHealth extends Fragment {
    private View v;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private TextView ques;
    private ListView list;
    private CheckBox chkbox1;
    private LinearLayout other_layout_edt;
    private EditText other_edt;
    private ArrayList<Userhis_getter_setter> reported_userhis = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_general_health, container, false);
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
        state_progress.setCurrentProgress(8);

        boolean check_values = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentGeneralHealth");
        if (check_values) {
            responsebuilder();
        } else {
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "None", "", "", "", "", "", "HEALTHHIST", "15_NONE", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Arthritis", "", "", "", "", "", "HEALTHHIST", "15_ARTH", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Asthma", "", "", "", "", "", "HEALTHHIST", "15_ASTAMA", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Cancer", "", "", "", "", "", "HEALTHHIST", "15_CANCER", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Diabetes", "", "", "", "", "", "HEALTHHIST", "15_DIAB", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "High blood pressure", "", "", "", "", "", "HEALTHHIST", "15_HBP", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Heart disease", "", "", "", "", "", "HEALTHHIST", "15_HRTPROB", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Elevated cholestrol", "", "", "", "", "", "HEALTHHIST", "15_INC_CHOL", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Mental illness", "", "", "", "", "", "HEALTHHIST", "15_MENTAL", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Stroke", "", "", "", "", "", "HEALTHHIST", "15_STROCK", "", "", "", "no", "FragmentGeneralHealth");
            db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Thyroid", "", "", "", "", "", "HEALTHHIST", "15_THYRIOD", "", "", "", "no", "FragmentGeneralHealth");
            responsebuilder();
        }

        boolean b = db.CheckIsDataCol1AlreadyInDBorNotID(pref.getUID(), "Other", "FragmentGeneralHealth");
        if (b) {
            String others_value = db.getLifestyleAnsOtherValue(pref.getUID(), "FragmentGeneralHealth");
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
                if(isChecked){
                    other_layout_edt.setVisibility(View.VISIBLE);
                    boolean pres = db.CheckIsAnswerCodeAlreadyInDBorNotID(pref.getUID(), "15_OTHERS", "FragmentGeneralHealth");
                    if (pres) {
                        db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Other", "", "", "", "", "", "HEALTHHIST", "15_OTHERS", "", "", "", "yes", "FragmentGeneralHealth");
                    } else {
                        db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Other", "", "", "", "", "", "HEALTHHIST", "15_OTHERS", "", "", "", "yes", "FragmentGeneralHealth");
                    }
                }else{
                    db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Other", "", "", "", "", "", "HEALTHHIST", "15_OTHERS", "", "", "", "no", "FragmentGeneralHealth");
                    other_edt.setText("");
                    other_layout_edt.setVisibility(View.GONE);
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentFamilyHealth();
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
                        db.updateLifestyleValueOther(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Other", "", "", "", "", "", "HEALTHHIST", "15_OTHERS", other_edt.getText().toString(), "", "", "yes", "FragmentGeneralHealth");
                        Fragment frag = new FragmentFruitServing();
                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                    }
                } else {
                    boolean a = db.CheckIsOthersAlreadyInDBorNotID(pref.getUID(), "Other", "FragmentGeneralHealth");
                    if (a) {
                        db.updateLifestyleValueOther(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "9", ques.getText().toString(), "HHILL", "Other", "", "", "", "", "", "HEALTHHIST", "15_OTHERS", "", "", "", "no", "FragmentGeneralHealth");
                        Fragment frag = new FragmentFruitServing();
                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                    } else {
                        Fragment frag = new FragmentFruitServing();
                        FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                    }
                }
            }
        });
    }

    public void responsebuilder() {
        List<LifestyleHRAModel> reportedList = new ArrayList<>();
        reportedList.addAll(db.getAllUserHealth(pref.getUID(), pref.getsessionid(), "FragmentGeneralHealth"));
        JSONArray jsonArray = new JSONArray();
        for (LifestyleHRAModel cn : reportedList) {
            JSONObject userhea = new JSONObject();
            try {
                userhea.put("userid", cn.getUserid());
                userhea.put("authtoken", cn.getAuthtoken());
                userhea.put("accountid", cn.getAccountid());
                userhea.put("personid", cn.getPersonid());
                userhea.put("tempid", cn.getTemplateid());
                userhea.put("quesid", cn.getQuestionid());
                userhea.put("ques", cn.getQuestion());
                userhea.put("quescode", cn.getQuestioncode());
                userhea.put("col1", cn.getCol1());
                userhea.put("col2", cn.getCol2());
                userhea.put("col3", cn.getCol3());
                userhea.put("col4", cn.getCol4());
                userhea.put("col5", cn.getCol5());
                userhea.put("col6", cn.getCol6());
                userhea.put("category", cn.getCategory());
                userhea.put("answercode", cn.getAnswercode());
                userhea.put("ansother", cn.getAnswerother());
                userhea.put("paracode", cn.getParametercode());
                userhea.put("unit", cn.getUnit());
                userhea.put("yesno", cn.getYesno());
                userhea.put("frag", cn.getFragment());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(userhea);
            System.out.println("Forward array" + jsonArray);
        }

        JSONObject sympObj = new JSONObject();
        try {
            sympObj.put("reporteduserhea", jsonArray);
            sympObj.put("message", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray arr1;
        if (!reported_userhis.isEmpty())
            reported_userhis.clear();
        try {
            arr1 = sympObj.getJSONArray("reporteduserhea");
            for (int i = 0; i < arr1.length(); i++) {
                JSONObject obj = arr1.getJSONObject(i);
                if (!obj.getString("col1").equalsIgnoreCase("Other")) {
                    reported_userhis.add(new Userhis_getter_setter(obj.getString("userid"),obj.getString("authtoken"),obj.getString("accountid"),obj.getString("personid"),obj.getString("tempid"),obj.getString("quesid"),obj.getString("ques"),obj.getString("quescode"),obj.getString("col1"),obj.getString("col2"),obj.getString("col3"),obj.getString("col4"),obj.getString("col5"),obj.getString("col6"),obj.getString("category"),obj.getString("answercode"),obj.getString("ansother"),obj.getString("paracode"),obj.getString("unit"),obj.getString("yesno"),obj.getString("frag")));
                }
            }

            ReportedUserHisAdapter reporteduserhisAdapter = new ReportedUserHisAdapter(getActivity(), reported_userhis);
            list.setAdapter(reporteduserhisAdapter);
            justifyListViewHeightBasedOnChildren(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void justifyListViewHeightBasedOnChildren (ListView listView) {
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
