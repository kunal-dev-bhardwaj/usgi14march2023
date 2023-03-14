package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentClaimStatusDetail extends Fragment implements ResponseListener {
    private View v;
    private String claimNo;
    private TextView txt_tpa_name, txt_policy_holder_name, txt_policy_number, txt_claim_status, txt_claim_type, txt_claim_amount;
    private TextView txt_sum_insured, txt_balance_sum_insured, txt_bill_amount, txt_approved_amount, txt_expiry_date, txt_applied_on;
    private TextView txt_message, no_data;
    private ScrollView scrollview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_health_claim_status_details, container, false);
        assert getArguments() != null;
        claimNo = getArguments().getString("claimNo");
        init();
        return v;
    }

    private void init() {
        no_data = v.findViewById(R.id.no_data);
        scrollview = v.findViewById(R.id.scrollview);
        txt_tpa_name = v.findViewById(R.id.txt_tpa_name);
        txt_policy_holder_name = v.findViewById(R.id.txt_policy_holder_name);
        txt_policy_number = v.findViewById(R.id.txt_policy_number);
        txt_claim_status = v.findViewById(R.id.txt_claim_status);
        txt_claim_type = v.findViewById(R.id.txt_claim_type);
        txt_claim_amount = v.findViewById(R.id.txt_claim_amount);
        txt_sum_insured = v.findViewById(R.id.txt_sum_insured);
        txt_balance_sum_insured = v.findViewById(R.id.txt_balance_sum_insured);
        txt_bill_amount = v.findViewById(R.id.txt_bill_amount);
        txt_approved_amount = v.findViewById(R.id.txt_approved_amount);
        txt_expiry_date = v.findViewById(R.id.txt_expiry_date);
        txt_applied_on = v.findViewById(R.id.txt_applied_on);
        txt_message = v.findViewById(R.id.txt_message);

        callApi();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
            object.put("ClaimNo", claimNo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_CLAIM_STATUS_DETAIL1, this, RequestHealthConstants.GET_CLAIM_STATUS_DETAIL1);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_CLAIM_STATUS_DETAIL1) {
            new AppDataPushApi().callApi(getActivity(), "Claim Status", "Claim status detail page", "User visited to check claim detail for reference number " + claimNo);
            if (object.optString("Message").equalsIgnoreCase("")) {
                scrollview.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);

                txt_tpa_name.setText(object.optString("TPA_Name"));
                txt_policy_holder_name.setText(object.optString("Policy_Holder_Name"));
                txt_policy_number.setText(object.optString("Policy_Number"));
                txt_claim_status.setText(object.optString("ClaimStatus"));
                txt_claim_type.setText(object.optString("ClaimType"));
                txt_claim_amount.setText("Rs. " + object.optString("Claim_Amount"));
                txt_sum_insured.setText("Rs. " + object.optString("SumInsured"));
                txt_balance_sum_insured.setText("Rs. " + object.optString("BalanceSumInsured"));
                txt_bill_amount.setText("Rs. " + object.optString("BillAmount"));
                txt_approved_amount.setText("Rs. " + object.optString("ApprovedAmount"));
                txt_expiry_date.setText(parseDateToddMMyyyy(object.optString("Policy_Expiry_Date")));
                txt_applied_on.setText(parseDateToddMMyyyy(object.optString("Claim_Applied_On")));
                txt_message.setText(object.optString("LossDesc"));
            } else {
                scrollview.setVisibility(View.GONE);
                no_data.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

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
