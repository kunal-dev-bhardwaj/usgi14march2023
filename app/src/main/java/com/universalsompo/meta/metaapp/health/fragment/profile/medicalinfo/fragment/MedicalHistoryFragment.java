package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter.MedicalHistoryAdapter1;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.MedicalHistoryModel1;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.Vrequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MedicalHistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private MedicalHistoryAdapter1 medicalHistoryAdapter;
    private ArrayList<MedicalHistoryModel1> medicalHistoryModelArrayList;
    private CheckBox cb;
    private Spinner sp;
    private ArrayList<String> otherhistorylist;
    private int Positions;
    private Button btnsave;
    private ArrayList<String> cbV;
    private int check = 0;
    private JSONArray jArray;
    private String Type;
    private EditText etother;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_medical_history1, container, false);

        TextView toolbar_text = v.findViewById(R.id.toolbar_title);

        Type = getArguments().getString("type");

        if (Type.equals("1")) {
            toolbar_text.setText("Medical History");
        } else {
            toolbar_text.setText("Family History");
        }

        cb = v.findViewById(R.id.cb_otherhismed);
        sp = v.findViewById(R.id.sp_otherhismed);
        btnsave = v.findViewById(R.id.btn_savemedhis);
        etother = v.findViewById(R.id.et_hisother);

        otherhistorylist = new ArrayList<>();
        cbV = new ArrayList<String>();

        recyclerView = v.findViewById(R.id.rv_medihistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        medicalHistoryModelArrayList = new ArrayList<>();
        medicalHistoryAdapter = new MedicalHistoryAdapter1(medicalHistoryModelArrayList, getContext(), getActivity(), new MedicalHistoryAdapter1.AdddiseaseListener() {
            @Override
            public void onClick(String diseaseID) {
                cbV.add(diseaseID);
            }
            @Override
            public void onUnClick(String diseaseID) {
                cbV.remove(diseaseID);
            }
        });

        if (NetworkUtils.isConnected(getContext())) {
            GetHistoryList();
            //GetOtherHistoryList();
        } else {
            Toast.makeText(getContext(), "You are not connected to Internet !", Toast.LENGTH_SHORT).show();
        }


        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb.isChecked()) {
                    //   sp.setVisibility(View.VISIBLE);
                    etother.setVisibility(View.VISIBLE);
                } else if (!cb.isChecked()) {
                    // sp.setVisibility(View.GONE);
                    etother.setVisibility(View.GONE);
                }
            }
        });


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (++check > 1) {
                    Positions = sp.getSelectedItemPosition() + 1;
                    String str = Integer.toString(Positions);
                    cbV.add(str);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SaveHistory();

            }
        });
        return v;
    }


    private void SaveHistory() {

        JSONObject jResult = new JSONObject();// main object
        jArray = new JSONArray();// /ItemDetail jsonArray
        for (int i = 0; i < cbV.size(); i++) {
            JSONObject jGroup = new JSONObject();// /sub Object
            try {
                jGroup.put("DiseasesID", cbV.get(i));
                jArray.put(jGroup);
                // /itemDetail Name is JsonArray Name
                jResult.put("itemDetail", jArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < jArray.length(); i++) {
            LogUtils.showLog("arrayvalues", jArray.toString());
        }
        MySharedPreference pref = MySharedPreference.getInstance(getContext());
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Type", Type);
            object.put("OtherType", etother.getText().toString());
            object.put("MedicalHistoryReq", jArray);
            LogUtils.showLog("SaveHistoryjson", "" + object);

        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getContext(), object, UrlHealthConstants.savemedicalhistory, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                LogUtils.showLog("SaveHistory", "SaveHistoryerror :" + object.toString());
                //     Toast.makeText(VitalsActivity.this, ""+object.toString(), Toast.LENGTH_SHORT).show();
                cbV.clear();

                FragmentsTransactionsUtils.popFragment(getActivity());

            }

            @Override
            public void onError(VolleyError error, int Tag) {
                LogUtils.showLog("SaveHistoryerror", "" + error.toString());
                //  Toast.makeText(BasicInfoEditActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }, 9005);
        req.execute();

    }


    private void GetHistoryList() {

        final MySharedPreference pref = MySharedPreference.getInstance(getContext());
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Type", Type);
            object.put("IsShowOnApp", "true");
            LogUtils.showLog("medihisjson", "" + object);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        Vrequest req = new Vrequest(getContext(), object, UrlHealthConstants.Getmedicalhistory, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                LogUtils.showLog("bpresponce", "" + object.toString());
                // Toast.makeText(VitalsActivity.this, ""+object.toString(), Toast.LENGTH_SHORT).show();
                try {
                    if (object.getString("Message").equalsIgnoreCase("Success")){
                        String OtherType = object.getString("OtherType");
                        if (!OtherType.isEmpty() || OtherType !=null){
                            etother.setText(OtherType);
                        }else {
                            etother.setText("");
                        }

                        JSONArray jsonArray = object.getJSONArray("MasterDiseasesRes");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String DiseaseName = jsonObject.getString("DiseasesName");
                            String IsUserSuffer = jsonObject.getString("IsUserSuffer");
                            String DiseasesID = jsonObject.getString("DiseasesID");

                            MedicalHistoryModel1 medicalHistoryModel = new MedicalHistoryModel1();
                            medicalHistoryModel.setName(DiseaseName);
                            medicalHistoryModel.setId(IsUserSuffer);
                            medicalHistoryModel.setDiseaseId(DiseasesID);
                            medicalHistoryModelArrayList.add(medicalHistoryModel);
                            LogUtils.showLog("Responces", "" + DiseaseName + "" + IsUserSuffer);
                        }
                        recyclerView.setAdapter(medicalHistoryAdapter);
                        medicalHistoryAdapter.notifyDataSetChanged();
                    }else {
                        Toast.makeText(getContext(), "No Data Available", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {

                LogUtils.showLog("bperror", "Gethistorylisterror :" + error.toString());
                // Toast.makeText(VitalsActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();


            }
        }, 9000);
        req.execute();
    }


}
