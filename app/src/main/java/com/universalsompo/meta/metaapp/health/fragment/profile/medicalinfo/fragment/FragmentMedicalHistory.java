package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.MedicalHistoryAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.database.DBModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.database.DatabaseHelper12;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.MedicalHistoryModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentMedicalHistory extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private ListView list;
    private TextView no_data;
    private MedicalHistoryAdapter medicalhistoryAdapter;
    ArrayList<MedicalHistoryModel> data = new ArrayList<>();
    private MySharedPreference mySharedPreference;
    private DatabaseHelper12 db;
    private List<DBModel> userHistorylist;
    private LinearLayout other_layout;
    private CheckBox chkbox1;
    private LinearLayout other_layout_edt;
    private EditText other_edt;
    private LinearLayout submitmedicalhistory;
    String other_type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_medical_history, container,false);
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(v.getWindowToken(), 0);
        mySharedPreference = MySharedPreference.getInstance(getActivity());
        init();
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        list = v.findViewById(R.id.list);
        no_data= v.findViewById(R.id.no_data);
        other_layout = v.findViewById(R.id.other_layout);
        chkbox1 = v.findViewById(R.id.chkbox1);
        other_layout_edt = v.findViewById(R.id.other_layout_edt);
        other_edt = v.findViewById(R.id.other_edt);
        submitmedicalhistory = v.findViewById(R.id.submitmedicalhistory);
        getActivity().deleteDatabase("user_medical_history_db");
        db = new DatabaseHelper12(getActivity());
        getmedicalhistory1();
        getmedicalhistory();

        chkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    other_layout_edt.setVisibility(View.VISIBLE);
                }else{
                    other_edt.setText("");
                    other_layout_edt.setVisibility(View.GONE);
                }
            }
        });

        submitmedicalhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                responsebuilder();
            }
        });
    }

    private void getmedicalhistory1() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
            object.put("Type", "1");
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_MEDICAL_HISTORY_INITIAL, this, RequestHealthConstants.GET_MEDICAL_HISTORY_INITIAL);
        req.execute();
    }

    public void getmedicalhistory() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
            object.put("Type", "1");
            object.put("IsShowOnApp", "true");
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_MEDICAL_HISTORY, this, RequestHealthConstants.GET_MEDICAL_HISTORY);
        req.execute();
    }

    public void responsebuilder(){
        userHistorylist = new ArrayList<>();
        userHistorylist.addAll(db.getAllUserHistory(mySharedPreference.getUID()));
        JSONArray jsonArray = new JSONArray();
        for (DBModel cn : userHistorylist) {
            JSONObject symp = new JSONObject();
            try {
                if(cn.getIsusersuffer().equalsIgnoreCase("true")){
                    symp.put("DiseasesID", cn.getDiseasesid());
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(cn.getIsusersuffer().equalsIgnoreCase("true")){
                jsonArray.put(symp);
            }
        }

        String jsonStr = jsonArray.toString();
        System.out.println("jsonString: " + jsonStr);
        savedata(jsonArray);
    }

    public void savedata(JSONArray s1) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
            object.put("Type", "1");
            object.put("OtherType", other_edt.getText().toString());
            object.put("MedicalHistoryReq", s1);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.SAVE_MEDICAL_HISTORY, this, RequestHealthConstants.SAVE_MEDICAL_HISTORY);
        req.execute();
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

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_MEDICAL_HISTORY){
            if (object.optString("Message").equals("Success")) {
                list.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);
                other_layout.setVisibility(View.VISIBLE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("MasterDiseasesRes");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        String diseaseid = obj.getString("DiseasesID");
                        String diseasename = obj.getString("DiseasesName");
                        String issuffer = obj.getString("IsUserSuffer");
                        data.add(
                                new MedicalHistoryModel(
                                        obj.optString("DiseasesID"),
                                        obj.optString("DiseasesName"),
                                        obj.optString("IsUserSuffer")
                                )
                        );

                        long id = db.insertUserHistory(mySharedPreference.getUID(), diseaseid, diseasename, issuffer);
                    }
                    medicalhistoryAdapter = new MedicalHistoryAdapter(getActivity(), data);
                    list.setAdapter(medicalhistoryAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    other_type = object.getString("OtherType");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(other_type.equalsIgnoreCase("null") || other_type.equalsIgnoreCase("") || other_type.equalsIgnoreCase(null)) {
                    other_layout_edt.setVisibility(View.GONE);
                    chkbox1.setChecked(false);
                } else {
                    chkbox1.setChecked(true);
                    other_layout_edt.setVisibility(View.VISIBLE);
                    other_edt.setText(other_type);
                }
            } else {
                list.setVisibility(View.GONE);
                no_data.setText(object.optString("Message"));
                no_data.setVisibility(View.VISIBLE);
                other_layout.setVisibility(View.GONE);
                other_layout_edt.setVisibility(View.GONE);
            }
        } else if (Tag == RequestHealthConstants.SAVE_MEDICAL_HISTORY) {
            if(object.optString("Message").equals("Success")) {
                Toast.makeText(getActivity(), "Successfully updated", Toast.LENGTH_SHORT).show();
                ((MainActivityHealth) getActivity()).getCurrentFragment();
            } else {
                Toast.makeText(getActivity(), "Unable to update record. Please try again.", Toast.LENGTH_SHORT).show();
            }
        } else if (Tag == RequestHealthConstants.GET_MEDICAL_HISTORY_INITIAL) {
            if(object.optString("Message").equals("Success")) {
            } else {
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
