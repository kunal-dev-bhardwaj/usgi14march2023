package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.adapters.TrackingStatusListAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.motor.models.TrackingStatusModel1;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentSinglePolicyStatus extends Fragment implements ResponseListener {
    private MySharedPreference pref;
    private ArrayList<TrackingStatusModel1> detailListModel;
    private ListView listView;
    private TextView insurer_name, holder_name, policy_no, make_model, reg_no, policy_expiry_date, ref_no, claim_applied_date;
    private View rootView;
    private String claim_no;
    private String PolicyId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tracking_status_for_single_policy, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        assert getArguments() != null;
        claim_no = getArguments().getString("claim_no");
        PolicyId = getArguments().getString("PolicyId");
        initView();
        return rootView;
    }

    private void initView() {
        listView = rootView.findViewById(R.id.listview_status);
        insurer_name = rootView.findViewById(R.id.insurer_name);
        holder_name = rootView.findViewById(R.id.holder_name);
        policy_no = rootView.findViewById(R.id.policy_no);
        make_model = rootView.findViewById(R.id.make_model);
        reg_no = rootView.findViewById(R.id.reg_no);
        policy_expiry_date = rootView.findViewById(R.id.policy_expiry_date);
        ref_no = rootView.findViewById(R.id.ref_no);
        claim_applied_date = rootView.findViewById(R.id.claim_applied_date);
        detailListModel = new ArrayList<>();
        callApi();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO,pref.getToken_no());
            object.put("UserId", pref.getUID());
            object.put("ClaimNo", claim_no);
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_TRACKING_DETAIL1, this, RequestConstants.GET_TRACKING_DETAIL1);
            req.execute();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_TRACKING_DETAIL1) {
            new AppDataPushApi().callApi(getActivity(),"Claim Status","Claim status detail page","User visited to check claim detail for policy id " + PolicyId + " & reference numver " + claim_no);
            if (object.optString("Status").equalsIgnoreCase("true")) {
                if (!detailListModel.isEmpty())
                    detailListModel.clear();
                try {
                    insurer_name.setText("Universal Sompo General Insurance Co. Ltd.");
                    holder_name.setText(object.optString("InsurerName"));
                    policy_no.setText(object.optString("PolicyNumber"));
                    make_model.setText(object.optString("Make") + " " + object.optString("Model"));
                    reg_no.setText(object.optString("VechileRegNo"));
                    policy_expiry_date.setText("Policy Expire : " + parseDateToddMMyyyy(object.optString("ExpiryDate")));
                    ref_no.setText("Ref. No : " + object.optString("ClaimNo"));
                    claim_applied_date.setText("Applied on : " + parseDateToddMMyyyy(object.optString("ClaimAppliedNo")));


                    JSONArray jsonArray = object.getJSONArray("ClaimStatusList");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object1 = jsonArray.getJSONObject(i);
                        TrackingStatusModel1 statusModel = new TrackingStatusModel1(object1.optString("Status"), object1.optString("Status_Update_DateTime"));
                        detailListModel.add(statusModel);
                    }
                    TrackingStatusListAdapter adapter = new TrackingStatusListAdapter(getActivity(), detailListModel);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "dd/MM/yyyy hh:mm:ss";
        String outputPattern = "dd MMM yyyy";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
