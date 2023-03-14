package com.universalsompo.meta.metaapp.motor.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.adapters.AutoClaimFormAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.CashLessModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class FragmentClaimPolicyCashless extends Fragment implements ResponseListener {
    private String InsComp;
    private TextView heading;
    private TextView no_data;
    private LinearLayout content;
    private RecyclerView claim_forms;
    private String v_type;
    MySharedPreference pref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.claim_policy_cashless, container, false);
         pref = MySharedPreference.getInstance(getActivity());
        InsComp = pref.getINSkey();
        assert getArguments() != null;
        v_type = getArguments().getString("v_type");
        heading =  v.findViewById(R.id.heading);
        claim_forms = v.findViewById(R.id.claim_forms);
        no_data =  v.findViewById(R.id.no_data);
        content =  v.findViewById(R.id.content);
        content.setVisibility(View.GONE);
        no_data.setVisibility(View.GONE);

        hitApi();
        return v;
    }

    private void hitApi() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("InsCompId", InsComp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.DOWNLOAD_CLAIM_FORM, this, RequestConstants.DOWNLOAD_CLAIM_FORM);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        new AppDataPushApi().callApi(getActivity(),"Claim","Claim Forms","Claim forms loaded");
        if (object.optString("Message").equalsIgnoreCase("Success")) {
            content.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.GONE);
            JSONArray arr;
            ArrayList<CashLessModel> data = new ArrayList<>();
            try {
                arr = object.getJSONArray("ALClaimFormDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    data.add(new CashLessModel(obj.optString("FormId"), obj.optString("FormPath"), obj.optString("FormType"), obj.optString("InsCompName")));
                }
                heading.setText(data.get(0).getInsCompName());
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                claim_forms.setLayoutManager(layoutManager);
                AutoClaimFormAdapter autoclaimformAdapter = new AutoClaimFormAdapter(getActivity(), data, v_type);
                claim_forms.setAdapter(autoclaimformAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            content.setVisibility(View.GONE);
            no_data.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}