package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Objects;

public class FragmentLinkNewPolicyHealth extends Fragment {
    private SelectorListener binder;
    private EditText policy_number;
    private TextView date_of_birth;
    private View view;
    private String policy_no, dob;
    private MySharedPreference pref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_new_policy_new_health, container, false);
        assert getParentFragment() != null;
        onAttachFragment(getParentFragment());
        pref = MySharedPreference.getInstance(getActivity());
        initView();
        return view;
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

    private void initView() {
        policy_number = view.findViewById(R.id.policy_number);
        date_of_birth = view.findViewById(R.id.date_of_birth);
        Button btn_add_policy_new_health = view.findViewById(R.id.btn_add_policy_new_health);

        Button buy_policy = view.findViewById(R.id.buy_policy);

        if (pref.getisUSGIUser().equalsIgnoreCase("1")) {
//            buy_policy.setVisibility(View.GONE);
            buy_policy.setVisibility(View.VISIBLE);

        } else {
            buy_policy.setVisibility(View.VISIBLE);
        }

        buy_policy.setOnClickListener(v -> replaceFragment(new BuyPolicyMenu(), FragmentsHealthTags.FRAGMENT_HEALTH_BUY_POLICY));

        date_of_birth.setOnClickListener(v -> datePicker());

        btn_add_policy_new_health.setOnClickListener(v -> {
            policy_no = policy_number.getText().toString().trim();
            dob = date_of_birth.getText().toString().trim();

            if (policy_no.isEmpty()) {
                policy_number.setFocusableInTouchMode(true);
                policy_number.setCursorVisible(true);
                policy_number.requestFocus();
                Toast.makeText(getActivity(), "Policy number is mandatory", Toast.LENGTH_SHORT).show();
            } else if (dob.isEmpty()) {
                date_of_birth.setFocusableInTouchMode(true);
                date_of_birth.setCursorVisible(true);
                date_of_birth.requestFocus();
                Toast.makeText(getActivity(), "Date of birth is mandatory", Toast.LENGTH_SHORT).show();
            } else {
                hitLinkNewWebservice(policy_no, dob);
            }
        });
    }

    private void datePicker() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog = new DatePickerDialog(requireActivity(),
                (view, year, monthOfYear, dayOfMonth) -> date_of_birth.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year), mYear, mMonth, mDay);
        datePickerDialog.setTitle("Please select date");
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    private void hitLinkNewWebservice(final String policyno, final String dob) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo",  pref.getToken_no());
            object.put("PolicyNo", policyno);
            object.put("Param", dob);
            object.put("UserID", pref.getUID());
            object.put("ClientUserID", pref.getClientUserID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.URL_LINK_NEW_HEALTH_POLICY, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                Log.d("Response", String.valueOf(object));
                if (object.optString("Message").equals("Successfully added policy.")) {
                    if (Tag == RequestConstants.URL_LINK_NEW_POLICY) {
                        pref.setIsPolicyStatus(object.optString("IsPolicyStatus"));
                        Toast.makeText(getActivity(), "Policy successfully added", Toast.LENGTH_SHORT).show();
                        requireActivity().onBackPressed();
                    }
                } else {
                    showOnErrorDialog(object.optString("Message"));
                }
            }

            @Override
            public void onError(VolleyError error, int Tag) {
            }
        }, RequestConstants.URL_LINK_NEW_POLICY);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    private void showOnErrorDialog(String mesg) {
        final Dialog alert_dialog = new Dialog(requireActivity());
        alert_dialog.setCanceledOnTouchOutside(false);
        alert_dialog.setCancelable(false);
        alert_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(alert_dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alert_dialog.setContentView(R.layout.custom_alert_motor);
        TextView ok_txt, alert_heading, alert_msg;
        ok_txt = alert_dialog.findViewById(R.id.ok_dialog);
        alert_heading = alert_dialog.findViewById(R.id.alert_heading);
        alert_msg = alert_dialog.findViewById(R.id.alert_msg);
        if (mesg.equalsIgnoreCase("Invalid Token No.") || mesg.equalsIgnoreCase("Invalid Policy No.") || mesg.equalsIgnoreCase("Something went wrong") || mesg.equalsIgnoreCase("No policy found in USGI DB.") || mesg.equalsIgnoreCase("Invalid Client User ID.") || mesg.equalsIgnoreCase("Invalid User ID.")) {
            alert_msg.setText("No policy found. For more details, please contact USGI support.");
        } else {
            alert_msg.setText(mesg);
        }
        alert_heading.setText("Error");
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
    }

    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equalsIgnoreCase(FragmentsHealthTags.FRAGMENT_HEALTH_POLICY)){
                Bundle args = new Bundle();
                args.putInt("otherFrag", 1);
                frag.setArguments(args);
            }
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
}
