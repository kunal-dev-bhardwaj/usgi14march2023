package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.FragmentDashBoardHealth;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class FragmentHealthClaimIntimation extends Fragment implements ResponseListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference prefrences;
    private EditText edt_policy_number, edt_insured_name, edt_email_id, edt_mobile_number, edt_intimator_name;
    private EditText edt_contact_number, edt_estimated_amount, hospital_place, hospital_city, loss_intim_state;
    private EditText disease_txt, remarks, disease_details;
    private TextView loss_intim_claim_date, loss_intim_claim_time, admission_date, admission_time;
    private int curYear;
    private int curMonth;
    private int curDay;
    private String policyID;
    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_health_claim_intimate_form, container, false);
        assert getArguments() != null;
        policyID = getArguments().getString("policyID");
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        return v;
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

    private void init() {
        edt_policy_number = v.findViewById(R.id.edt_policy_number);
        edt_insured_name = v.findViewById(R.id.edt_insured_name);
        edt_email_id = v.findViewById(R.id.edt_email_id);
        edt_mobile_number = v.findViewById(R.id.edt_mobile_number);
        edt_intimator_name = v.findViewById(R.id.edt_intimator_name);
        edt_contact_number = v.findViewById(R.id.edt_contact_number);
        edt_estimated_amount = v.findViewById(R.id.edt_estimated_amount);
        hospital_place = v.findViewById(R.id.hospital_place);
        hospital_city = v.findViewById(R.id.hospital_city);
        loss_intim_state = v.findViewById(R.id.loss_intim_state);
        disease_txt = v.findViewById(R.id.disease_txt);
        remarks = v.findViewById(R.id.remarks);
        disease_details = v.findViewById(R.id.disease_details);
        loss_intim_claim_date = v.findViewById(R.id.loss_intim_claim_date);
        loss_intim_claim_time = v.findViewById(R.id.loss_intim_claim_time);
        admission_date = v.findViewById(R.id.admission_date);
        admission_time = v.findViewById(R.id.admission_time);
        Button submit = v.findViewById(R.id.submit);
        edt_policy_number.setText(prefrences.getPolicy_no_health());
        edt_email_id.setText(prefrences.getEmailId());
        edt_mobile_number.setText(prefrences.getMOBILE());
        String date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        loss_intim_claim_date.setText(date);
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        String dateString = dateFormat.format(new Date());
        loss_intim_claim_time.setText(dateString);

        admission_date.setOnClickListener(v -> datePickerTillToday(admission_date));

        admission_time.setOnClickListener(v -> setTime(admission_time));

        submit.setOnClickListener(v -> validatefields());
    }

    private void validatefields() {
        if (edt_insured_name.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter patient name.", Toast.LENGTH_SHORT).show();
        } else if (edt_intimator_name.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter intimator name.", Toast.LENGTH_SHORT).show();
        } else if (edt_contact_number.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter alternate contact number.", Toast.LENGTH_SHORT).show();
        } else if (edt_estimated_amount.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter estimated amount.", Toast.LENGTH_SHORT).show();
        } else if (hospital_place.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter hospital name and address.", Toast.LENGTH_SHORT).show();
        } else if (hospital_city.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter city.", Toast.LENGTH_SHORT).show();
        } else if (loss_intim_state.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter state.", Toast.LENGTH_SHORT).show();
        } else if (loss_intim_claim_date.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter intimation date.", Toast.LENGTH_SHORT).show();
        } else if (loss_intim_claim_time.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter intimation time.", Toast.LENGTH_SHORT).show();
        } else if (admission_date.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter admission date.", Toast.LENGTH_SHORT).show();
        } else if (admission_time.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter admission time.", Toast.LENGTH_SHORT).show();
        } else if (disease_txt.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter disease which beneficiary is facing.", Toast.LENGTH_SHORT).show();
        } else if (remarks.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter remarks.", Toast.LENGTH_SHORT).show();
        } else if (disease_details.getText().toString().trim().length() == 0) {
            Toast.makeText(getActivity(), "Please enter complete details of disease facing by beneficiary.", Toast.LENGTH_SHORT).show();
        }  else {
            callApi();
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, prefrences.getToken_no());
            object.put("PolicyID", policyID);
            object.put("UserID", prefrences.getUID());
            object.put("PolicyNumber", edt_policy_number.getText().toString());
            object.put("IntimationDate", loss_intim_claim_date.getText().toString());
            object.put("IntimationTime", loss_intim_claim_time.getText().toString());
            object.put("AccidentDate", admission_date.getText().toString());
            object.put("AccidentTime", admission_time.getText().toString());
            object.put("AccidentPlace", hospital_place.getText().toString());
            object.put("AccidentCity", hospital_city.getText().toString());
            object.put("AccidentState", loss_intim_state.getText().toString());
            object.put("LossNature", "");
            object.put("EstimatedAmount", edt_estimated_amount.getText().toString());
            object.put("Remarks", remarks.getText().toString());
            object.put("InsuredName", edt_insured_name.getText().toString());
            object.put("MobileNumber", edt_mobile_number.getText().toString());
            object.put("ClaimIntimatedBy", "META");
            object.put("IntimatorName", edt_intimator_name.getText().toString());
            object.put("ContactNumber", edt_contact_number.getText().toString());
            object.put("CustomerEmailID", edt_email_id.getText().toString());
            object.put("LossDetails", disease_details.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.HEALTH_INTIMATE_CLAIM, this, RequestHealthConstants.HEALTH_INTIMATE_CLAIM);
        req.execute();
    }

    private void datePickerTillToday(final TextView tv) {
        initDate();
        DatePickerDialog expdatePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()),R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }, curYear, curMonth, curDay);
        expdatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        expdatePickerDialog.show();
    }

    private void initDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        curYear = c.get(Calendar.YEAR);
        curMonth = c.get(Calendar.MONTH);
        curDay = c.get(Calendar.DAY_OF_MONTH);
    }

    private void setTime(final TextView tv) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getActivity(),R.style.DialogTheme, (timePicker, selectedHour, selectedMinute) -> {
            // TODO Auto-generated method stub
            int hour1 = selectedHour;

            String min;
            if (selectedMinute < 10)
                min = "0" + selectedMinute;
            else
                min = String.valueOf(selectedMinute);
            String aTime = new StringBuilder().append(hour1).append(':').append(min).toString();
            tv.setText(aTime);
        }, hour, minute, false);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.HEALTH_INTIMATE_CLAIM) {
            if (object.optString("Message").equals("Success")) {
                if (object.optString("APIStatus").equals("Rejected")) {
                    Toast.makeText(getActivity(), "The claim was not intimated successfully. Please try again.", Toast.LENGTH_SHORT).show();
                } else {
                    new AppDataPushApi().callApi(getActivity(),"Claim","Claim intimation page","Claim intimated successfully");
                    dialog = new Dialog(Objects.requireNonNull(getContext()), R.style.CustomDialog);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setCancelable(false);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                    dialog.setContentView(R.layout.claim_intimation_popup);
                    TextView claim_number = dialog.findViewById(R.id.claim_number);
                    claim_number.setText(object.optString("APIClaimNo"));
                    TextView callrsa = dialog.findViewById(R.id.tvcallrsa);
                    callrsa.setOnClickListener(v -> {
                        dialog.dismiss();
                        Fragment frag = new FragmentDashBoardHealth();
                        Bundle args = new Bundle();
                        args.putString("hidevalue", "0");
                        frag.setArguments(args);
                        FragmentsTransactionsUtils.addFragmentAgain(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
                        binder.detect(FragmentsHealthTags.DASH_BOARD_FRAGMENT1);
                    });
                    dialog.show();
                }
            } else {
                Toast.makeText(getActivity(), "The claim was not intimated successfully. Please try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
