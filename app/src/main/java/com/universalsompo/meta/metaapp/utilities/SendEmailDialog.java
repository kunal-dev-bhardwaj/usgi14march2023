package com.universalsompo.meta.metaapp.utilities;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.Objects;

public class SendEmailDialog extends Dialog implements
        android.view.View.OnClickListener, ResponseListener, RadioGroup.OnCheckedChangeListener {
    public Activity activity;
    public Dialog d;
    private EditText edt_add_mail;
    private MySharedPreference pref;
    private String mailId;
    private TextView txt_mailid;
    private String policy_no;
    private String frafment_tag;

    public SendEmailDialog(Activity activity, String veh_type,String mailId, String policy_no, String frafment_tag) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
        this.mailId = mailId;
        this.policy_no = policy_no;
        this.frafment_tag = frafment_tag;
    }

    public SendEmailDialog(Activity activity, String mailId, String policy_no, String frafment_tag) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
        this.mailId = mailId;
        this.policy_no = policy_no;
        this.frafment_tag = frafment_tag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setCancelable(false);
        setContentView(R.layout.dialog_send_email_motor);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        pref = MySharedPreference.getInstance(activity);
        init();

        if (!mailId.equals("")) {
            txt_mailid.setText(mailId);
        }
    }

    public void init() {
        TextView txt_sndEmail = findViewById(R.id.btn_send_mail);
        edt_add_mail = findViewById(R.id.edt_add_mail);
        txt_mailid = findViewById(R.id.txt_mailid);
        TextView cancel = findViewById(R.id.cancel);
        edt_add_mail.setVisibility(View.GONE);
        RadioGroup mail_radiogroup = findViewById(R.id.mail_radioGroup);
        RadioButton mail_radiobtn = findViewById(R.id.mail_radio_btn);
        mail_radiobtn.setChecked(true);
        mail_radiogroup.setOnCheckedChangeListener(this);
        txt_sndEmail.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_mail:
                if (edt_add_mail.isShown()) {
                    String newMailId = edt_add_mail.getText().toString();
                    if (!newMailId.equalsIgnoreCase("")) {
                        if (Patterns.EMAIL_ADDRESS.matcher(newMailId).matches())
                            callApi(newMailId);
                        else
                            Toast.makeText(activity, "Invalid e-mail id" + newMailId, Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(activity, "Please provide other e-mail id" + newMailId, Toast.LENGTH_LONG).show();
                } else
                    callApi(MySharedPreference.getInstance(activity).getEmailId());
                dismiss();
                break;

            case R.id.cancel:
                dismiss();
        }
    }

    private void callApi(String e_mail) {
        JSONObject object = new JSONObject();
        switch (frafment_tag) {
            case FragmentsTags.FRAGMENT_DOCUMENT_POLICY: {
                try {
                    object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
                    object.put("Uid",pref.getUID());
                    object.put("Email", e_mail);
                    object.put("PolicyId", policy_no);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlConstants.EMAIL_API, this, RequestConstants.EMAIL_API);
                req.execute();
                break;
            }
            case FragmentsTags.FRAGMENT_DOCUMENT_CLAIM: {
                try {
                    object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
                    object.put("Uid",pref.getUID());
                    object.put("Email", e_mail);
                    object.put("FormId", policy_no);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlConstants.SEND_MAIL_CLAIM_FORM, this, RequestConstants.SEND_MAIL_CLAIM_FORM);
                req.execute();
                break;
            }
            case FragmentsHealthTags.FRAGMENT_INDIVIDUAL_MY_POLICY: {
                try {
                    object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                    object.put("UserID", pref.getUID());
                    object.put("EmailID", e_mail);
                    object.put("PolicyID", policy_no);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.MAIL_POLICY_DOC, this, RequestHealthConstants.MAIL_POLICY_DOC);
                req.execute();
                break;
            }
            case FragmentsHealthTags.FRAGMENT_HEALTH_EMAIL_CLAIM_FORM: {
                try {
                    object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
                    object.put("Uid",pref.getUID());
                    object.put("Email", e_mail);
                    object.put("FormId", policy_no);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.EMAIL_HEALTH_CALIM_FORM, this, RequestHealthConstants.EMAIL_HEALTH_CALIM_FORM);
                req.execute();
                break;
            }
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.EMAIL_API) {
            Toast.makeText(activity, "E-mail sent Successfully", Toast.LENGTH_LONG).show();
        } else if (Tag == RequestConstants.SEND_MAIL_CLAIM_FORM) {
            if (object.optString("Status").equals("true"))
                Toast.makeText(activity, "E-mail sent Successfully", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(activity, object.optString("Message"), Toast.LENGTH_LONG).show();
        } else if (Tag == RequestHealthConstants.MAIL_POLICY_DOC) {
            Toast.makeText(activity, "E-mail sent Successfully", Toast.LENGTH_LONG).show();
        } else if (Tag == RequestHealthConstants.EMAIL_HEALTH_CALIM_FORM) {
            if (object.optString("Status").equals("true"))
                Toast.makeText(activity, "E-mail sent Successfully", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(activity, object.optString("Message"), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof AuthFailureError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof ServerError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof NetworkError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof ParseError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.mail_radio_btn:
                if (edt_add_mail.isShown()) {
                    edt_add_mail.setVisibility(View.GONE);
                    txt_mailid.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ohtermail_radio_btn:
                if (!edt_add_mail.isShown()) {
                    txt_mailid.setVisibility(View.GONE);
                    edt_add_mail.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}