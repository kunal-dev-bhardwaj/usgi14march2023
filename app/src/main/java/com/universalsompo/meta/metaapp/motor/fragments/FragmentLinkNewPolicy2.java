package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.InputFilter;
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
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.Dashboard_buy_policy_item;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import static com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy.filtericonVisibility;

public class FragmentLinkNewPolicy2 extends Fragment implements ResponseListener {
    private int status = 0;
    private EditText engineNo;
    private EditText policyNo;
    private View view;
    private String policyno, engineno;
    private MySharedPreference pref;
    private ArrayList<Dashboard_buy_policy_item> buy_policy_items = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_new_policy_new, container, false);
        assert getParentFragment() != null;
        onAttachFragment(getParentFragment());
        filtericonVisibility(false);
        pref = MySharedPreference.getInstance(getActivity());
        new AppDataPushApi().callApi(getActivity(),"Link Policy","Linking of new policy","User visited to add a new policy");
        initView();
        return view;
    }

    public void onAttachFragment(@NonNull Fragment fragment) {
        try {
            if (status == 0) {
                status = 1;
            }
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    fragment.toString() + " must implement OnPlayerSelectionSetListener");
        }
    }

    private InputFilter filter = (source, start, end, dest, dstart, dend) -> {
        String blockCharacterSet = "~#^|$%&*!/";
        if (source != null && blockCharacterSet.contains(("" + source))) {
            return "";
        }
        return null;
    };

    private void initView() {
        policyNo = view.findViewById(R.id.policy_no_new);
        engineNo = view.findViewById(R.id.engine_no_new);
        Button buy_policy = view.findViewById(R.id.buy_policy);

        if (pref.getisUSGIUser().equalsIgnoreCase("1")) {
            buy_policy.setVisibility(View.VISIBLE);
        } else {
            buy_policy.setVisibility(View.VISIBLE);
        }

        buy_policy.setOnClickListener(v -> callBuyApi());

        engineNo.setFilters(new InputFilter[] { filter });
        Button btn_add_policy_new = view.findViewById(R.id.btn_add_policy_new);

        btn_add_policy_new.setOnClickListener(v -> {
            policyno = policyNo.getText().toString().trim();
            engineno = engineNo.getText().toString().trim();

            if (engineno.contains("/")) {
                Toast.makeText(getActivity(), "Invalid chasis number or engine number.", Toast.LENGTH_SHORT).show();
            } else {
                if (policyno.isEmpty()) {
                    policyNo.setFocusableInTouchMode(true);
                    policyNo.setCursorVisible(true);
                    policyNo.requestFocus();
                    Toast.makeText(getActivity(), "Policy number is mandatory", Toast.LENGTH_SHORT).show();
                } else if (engineno.isEmpty()) {
                    engineNo.setFocusableInTouchMode(true);
                    engineNo.setCursorVisible(true);
                    engineNo.requestFocus();
                    Toast.makeText(getActivity(), "Engine number or chassis number is mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    hitLinkNewWebservice(policyno, engineno);
                }
            }
        });
    }

    private void hitLinkNewWebservice(final String policyno, final String engineno) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("PolicyNo", policyno);
            object.put("Param", engineno);
            object.put("UserID", pref.getUID());
            object.put("ClientUserID", pref.getClientUserID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.URL_LINK_NEW_POLICY, new ResponseListener() {
            @Override
            public void onSuccess(JSONObject object, int Tag) {
                if (Tag == RequestConstants.URL_LINK_NEW_POLICY) {
                    if (object.optString("Message").equals("Success")) {
                        new AppDataPushApi().callApi(getActivity(),"Link Policy","Linking of new policy","User successfully added a new policy " + policyno);
                        Toast.makeText(getActivity(), "Policy successfully added", Toast.LENGTH_SHORT).show();
                        requireActivity().onBackPressed();
                    } else {
                        showOnErrorDialog(object.optString("Message"));
                    }
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
//        if (mesg.equalsIgnoreCase("Invalid Client User ID.") || mesg.equalsIgnoreCase("Invalid User ID.") || mesg.equalsIgnoreCase("Something went wrong") || mesg.equalsIgnoreCase("No policy found in USGI DB.") || mesg.equalsIgnoreCase("Token No Not Valid.") || mesg.equalsIgnoreCase("Invalid Policy No.")) {
        if (mesg.equals("Invalid Client User ID.") || mesg.equals("Invalid User ID.") || mesg.equals("Something went wrong") || mesg.equals("No policy found in USGI DB.") || mesg.equals("Token No Not Valid.") || mesg.equals("Invalid Policy No.")) {
            alert_msg.setText("No policy found. For more details, please contact USGI support.");
        } else {
            alert_msg.setText(mesg);
        }
        alert_heading.setText("Error");
        alert_dialog.show();
        ok_txt.setOnClickListener(v -> alert_dialog.dismiss());
    }

    private void callBuyApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("Mode", "MOTOR");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.BUY_POLICY_URL, this, RequestConstants.BUY_POLICY_URL);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.BUY_POLICY_URL) {
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("ProductMappingList");
                    buy_policy_items.clear();
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject jsonObject = arr.getJSONObject(i);
                        buy_policy_items.add(new Dashboard_buy_policy_item(
                                        jsonObject.optString("Id"),
                                        jsonObject.optString("ProductName"),
                                        jsonObject.optString("ProductUrl"),
                                        jsonObject.optString("ThankPageUrl")
                                )
                        );
                    }


                    final Dialog dialog = new Dialog(requireActivity(),R.style.CustomDialog);
                    dialog.setCanceledOnTouchOutside(true);
                    dialog.setCancelable(true);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                    dialog.setContentView(R.layout.buy_now_dialog);
                    TextView btn_two_wheeler = dialog.findViewById(R.id.btn_two_wheeler);
                    TextView btn_four_wheeler = dialog.findViewById(R.id.btn_four_wheeler);

                    btn_four_wheeler.setText(buy_policy_items.get(0).getProductName());
                    btn_two_wheeler.setText(buy_policy_items.get(1).getProductName());

                    btn_four_wheeler.setOnClickListener(v1 -> {
                        dialog.dismiss();
                        Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                        in.putExtra("PolicyNo", "");
                        in.putExtra("VehicleType", "");
                        in.putExtra("vendor_id", "");
                        in.putExtra("ISFROMPDFFULL", "");
                        in.putExtra("Url", buy_policy_items.get(0).getProductUrl() + pref.getMOBILE());
                        in.putExtra("fargmentTag", "Buy Policy");
                        in.putExtra("type", buy_policy_items.get(0).getProductName());
                        requireActivity().startActivity(in);
                    });

                    btn_two_wheeler.setOnClickListener(v12 -> {
                        dialog.dismiss();
                        Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                        in.putExtra("PolicyNo", "");
                        in.putExtra("VehicleType", "");
                        in.putExtra("vendor_id", "");
                        in.putExtra("ISFROMPDFFULL", "");
                        in.putExtra("Url", buy_policy_items.get(1).getProductUrl() + pref.getMOBILE());
                        in.putExtra("fargmentTag", "Buy Policy");
                        in.putExtra("type", buy_policy_items.get(1).getProductName());
                        requireActivity().startActivity(in);
                    });
                    dialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}

