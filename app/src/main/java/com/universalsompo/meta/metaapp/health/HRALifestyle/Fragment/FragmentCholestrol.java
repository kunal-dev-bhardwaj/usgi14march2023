package com.universalsompo.meta.metaapp.health.HRALifestyle.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONObject;

import java.util.Objects;

import params.com.stepprogressview.StepProgressView;

public class FragmentCholestrol extends Fragment implements ResponseListener {
    private View v;
    private EditText edt_ldl, edt_hdl, edt_trig, edt_total;
    private MySharedPreference pref;
    private LifestyleHRADatabaseHelper db;
    private Context mContext;
    private LinearLayout allizhealth_txt, button;
    private String waist_value, hip_value, sys_value, dia_value, fasting_value, pp_value, ldl_value, hdl_value, tri_value, total_value;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_cholestrol, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = getActivity().getCurrentFocus();
        if (view == null) {
            view = new View(getActivity());
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        pref = MySharedPreference.getInstance(getActivity());
        db = new LifestyleHRADatabaseHelper(getActivity());
        mContext = getActivity();
        init();

        final View activityRootView = getActivity().findViewById(R.id.content_main1);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff > dpToPx(mContext, 200)) { // if more than 200 dp, it's probably a keyboard...
                    button.setVisibility(View.GONE);
                    allizhealth_txt.setVisibility(View.GONE);
                } else {
                    button.setVisibility(View.VISIBLE);
                    allizhealth_txt.setVisibility(View.VISIBLE);
                }
            }
        });
        return v;
    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    private void init() {
        edt_ldl = v.findViewById(R.id.edt_ldl);
        edt_hdl = v.findViewById(R.id.edt_hdl);
        edt_trig = v.findViewById(R.id.edt_trig);
        edt_total = v.findViewById(R.id.edt_total);
        Button previous = v.findViewById(R.id.previous);
        Button next = v.findViewById(R.id.next);
        TextView dont_know = v.findViewById(R.id.dont_know);
        StepProgressView state_progress = v.findViewById(R.id.state_progress);
        button =  v.findViewById(R.id.button);
        allizhealth_txt =  v.findViewById(R.id.allizhealth_txt);
        state_progress.setTotalProgress(20);
        state_progress.setMarkerColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.grey));
        state_progress.setProgressColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.my_policy_tab_dark));
        state_progress.setCurrentProgress(4);

        boolean check_chol = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentCholestrol");
        if (check_chol) {
            String ldl = db.getLifestyleCol1Value(pref.getUID(), "FragmentCholestrol");
            String hdl = db.getLifestyleCol2Value(pref.getUID(), "FragmentCholestrol");
            String trig = db.getLifestyleCol3Value(pref.getUID(), "FragmentCholestrol");
            String total = db.getLifestyleCol4Value(pref.getUID(), "FragmentCholestrol");

            if (ldl.equalsIgnoreCase("0")) {
                edt_ldl.setText("");
            } else {
                edt_ldl.setText(ldl);
            }

            if (hdl.equalsIgnoreCase("0")) {
                edt_hdl.setText("");
            } else {
                edt_hdl.setText(hdl);
            }

            if (trig.equalsIgnoreCase("0")) {
                edt_trig.setText("");
            } else {
                edt_trig.setText(trig);
            }

            if (total.equalsIgnoreCase("0")) {
                edt_total.setText("");
            } else {
                edt_total.setText(total);
            }
        } else {
            edt_ldl.setText("");
            edt_hdl.setText("");
            edt_trig.setText("");
            edt_total.setText("");
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_ldl.getText().toString().isEmpty() || edt_ldl.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter ldl", Toast.LENGTH_SHORT).show();
                } else if (edt_hdl.getText().toString().isEmpty() || edt_hdl.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter hdl", Toast.LENGTH_SHORT).show();
                } else if (edt_trig.getText().toString().isEmpty() || edt_trig.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter triglycerides", Toast.LENGTH_SHORT).show();
                } else if (edt_total.getText().toString().isEmpty() || edt_total.getText().toString().equals("0")) {
                    Toast.makeText(getActivity(), "Please enter total cholestrol", Toast.LENGTH_SHORT).show();
                } else {
                    boolean check_chol = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentCholestrol");
                    if (check_chol) {
                        db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "5", "", "", edt_ldl.getText().toString(), edt_hdl.getText().toString(), edt_trig.getText().toString(), edt_total.getText().toString(), "0", "true", "", "", "", "CHOL_LDL|CHOL_HDL|CHOL_TRY|CHOL_TOTAL", "mg/dL", "yes", "FragmentCholestrol");
                    } else {
                        db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "5", "", "", edt_ldl.getText().toString(), edt_hdl.getText().toString(), edt_trig.getText().toString(), edt_total.getText().toString(), "0", "true", "", "", "","CHOL_LDL|CHOL_HDL|CHOL_TRY|CHOL_TOTAL", "mg/dL", "yes", "FragmentCholestrol");
                    }

                    String heightft = db.getLifestyleCol1Value(pref.getUID(), "FragmentBMI");
                    String heightinc = db.getLifestyleCol2Value(pref.getUID(), "FragmentBMI");
                    String weight = db.getLifestyleCol4Value(pref.getUID(), "FragmentBMI");
                    String waist = db.getLifestyleCol1Value(pref.getUID(), "FragmentWHR");
                    String hip = db.getLifestyleCol2Value(pref.getUID(), "FragmentWHR");
                    String sys = db.getLifestyleCol1Value(pref.getUID(), "FragmentBP");
                    String dia = db.getLifestyleCol2Value(pref.getUID(), "FragmentBP");
                    String fasting = db.getLifestyleCol1Value(pref.getUID(), "FragmentBloodSugar");
                    String pp = db.getLifestyleCol2Value(pref.getUID(), "FragmentBloodSugar");
                    String ldl = db.getLifestyleCol1Value(pref.getUID(), "FragmentCholestrol");
                    String hdl = db.getLifestyleCol2Value(pref.getUID(), "FragmentCholestrol");
                    String tri = db.getLifestyleCol3Value(pref.getUID(), "FragmentCholestrol");
                    String total = db.getLifestyleCol4Value(pref.getUID(), "FragmentCholestrol");

                    if (waist.equalsIgnoreCase("0")) {
                        waist_value = "";
                    } else {
                        waist_value = waist;
                    }

                    if (hip.equalsIgnoreCase("0")) {
                        hip_value = "";
                    } else {
                        hip_value = hip;
                    }

                    if (sys.equalsIgnoreCase("0")) {
                        sys_value = "";
                    } else {
                        sys_value = sys;
                    }

                    if (dia.equalsIgnoreCase("0")) {
                        dia_value = "";
                    } else {
                        dia_value = dia;
                    }

                    if (fasting.equalsIgnoreCase("0")) {
                        fasting_value = "";
                    } else {
                        fasting_value = fasting;
                    }

                    if (pp.equalsIgnoreCase("0")) {
                        pp_value = "";
                    } else {
                        pp_value = pp;
                    }

                    if (ldl.equalsIgnoreCase("0")) {
                        ldl_value = "";
                    } else {
                        ldl_value = ldl;
                    }

                    if (hdl.equalsIgnoreCase("0")) {
                        hdl_value = "";
                    } else {
                        hdl_value = hdl;
                    }

                    if (tri.equalsIgnoreCase("0")) {
                        tri_value = "";
                    } else {
                        tri_value = tri;
                    }

                    if (total.equalsIgnoreCase("0")) {
                        total_value = "";
                    } else {
                        total_value = total;
                    }

                    saveuserdetails(heightft, heightinc, weight, waist_value, hip_value, sys_value, dia_value, fasting_value, pp_value, ldl_value, hdl_value, tri_value, total_value);

                    Fragment frag = new FragmentAlcohol();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
                }
            }
        });

        dont_know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check_chol = db.CheckIsDataAlreadyInDBorNotID(pref.getUID(), "FragmentCholestrol");
                if (check_chol) {
                    db.updateLifestyleValue(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "5", "", "", "0", "0", "0", "0", "0", "false", "", "", "", "", "", "no", "FragmentCholestrol");
                } else {
                    db.insertLifestyleHRAValues(pref.getUID(), pref.getsessionid(), pref.getaccid(), pref.getpersonid(), pref.gettempid(), "5", "", "", "0", "0", "0", "0", "0", "false", "", "", "", "", "", "no", "FragmentCholestrol");
                }

                String heightft = db.getLifestyleCol1Value(pref.getUID(), "FragmentBMI");
                String heightinc = db.getLifestyleCol2Value(pref.getUID(), "FragmentBMI");
                String weight = db.getLifestyleCol4Value(pref.getUID(), "FragmentBMI");
                String waist = db.getLifestyleCol1Value(pref.getUID(), "FragmentWHR");
                String hip = db.getLifestyleCol2Value(pref.getUID(), "FragmentWHR");
                String sys = db.getLifestyleCol1Value(pref.getUID(), "FragmentBP");
                String dia = db.getLifestyleCol2Value(pref.getUID(), "FragmentBP");
                String fasting = db.getLifestyleCol1Value(pref.getUID(), "FragmentBloodSugar");
                String pp = db.getLifestyleCol2Value(pref.getUID(), "FragmentBloodSugar");
                String ldl = db.getLifestyleCol1Value(pref.getUID(), "FragmentCholestrol");
                String hdl = db.getLifestyleCol2Value(pref.getUID(), "FragmentCholestrol");
                String tri = db.getLifestyleCol3Value(pref.getUID(), "FragmentCholestrol");
                String total = db.getLifestyleCol4Value(pref.getUID(), "FragmentCholestrol");

                if (waist.equalsIgnoreCase("0")) {
                    waist_value = "";
                } else {
                    waist_value = waist;
                }

                if (hip.equalsIgnoreCase("0")) {
                    hip_value = "";
                } else {
                    hip_value = hip;
                }

                if (sys.equalsIgnoreCase("0")) {
                    sys_value = "";
                } else {
                    sys_value = sys;
                }

                if (dia.equalsIgnoreCase("0")) {
                    dia_value = "";
                } else {
                    dia_value = dia;
                }

                if (fasting.equalsIgnoreCase("0")) {
                    fasting_value = "";
                } else {
                    fasting_value = fasting;
                }

                if (pp.equalsIgnoreCase("0")) {
                    pp_value = "";
                } else {
                    pp_value = pp;
                }

                if (ldl.equalsIgnoreCase("0")) {
                    ldl_value = "";
                } else {
                    ldl_value = ldl;
                }

                if (hdl.equalsIgnoreCase("0")) {
                    hdl_value = "";
                } else {
                    hdl_value = hdl;
                }

                if (tri.equalsIgnoreCase("0")) {
                    tri_value = "";
                } else {
                    tri_value = tri;
                }

                if (total.equalsIgnoreCase("0")) {
                    total_value = "";
                } else {
                    total_value = total;
                }

                saveuserdetails(heightft, heightinc, weight, waist_value, hip_value, sys_value, dia_value, fasting_value, pp_value, ldl_value, hdl_value, tri_value, total_value);

                Fragment frag = new FragmentAlcohol();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentBloodSugar();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(getActivity(), frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HRA);
            }
        });
    }

    private void saveuserdetails(String heightft, String heightinc, String weight, String waist_value, String hip_value, String sys_value, String dia_value, String fasting_value, String pp_value, String ldl_value, String hdl_value, String tri_value, String total_value) {
        JSONObject object = new JSONObject();

        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("HeightInFeet", heightft);
            object.put("HeightInInch", heightinc);
            object.put("Weight", weight);
            object.put("Waist", waist_value);
            object.put("Hip", hip_value);
            object.put("BloodPressureSystolic", sys_value);
            object.put("BloodPressureDiastolic", dia_value);
            object.put("SugerFasting", fasting_value);
            object.put("SugerPP", pp_value);
            object.put("LDL", ldl_value);
            object.put("HDL", hdl_value);
            object.put("Triglyceride", tri_value);
            object.put("Total_Cholesterol", total_value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlHealthConstants.SAVE_USER_BASIC_DETAILS, this, RequestHealthConstants.SAVE_USER_BASIC_DETAILS);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.SAVE_USER_BASIC_DETAILS) {
            if (object.optString("Message").equalsIgnoreCase("Success")) {
                Log.e("Success", "Successfully added");
            } else {
                Log.e("Unsuccess", "Not added successfully");
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
