package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentMaintenanceSchedule extends Fragment implements AdapterView.OnItemSelectedListener,ResponseListener,View.OnClickListener {
    private View v;
    private MySharedPreference prefrences;
    private TextView data_not_found;
    private Spinner txt_registration;
    private List<String> listVehicleRegistration;
    private List<ClaimFilterModel> vehicleRegistrationModelList;
    private String selectedRegistrationNumberId;
    private TextView text_make,text_model,text_year,kilometer,info;
    private EditText kms;
    private String km,makeId,modelId;
    private LinearLayout linear1,linear2;
    private View view1;
    private ImageView maintain_icon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_maintenance_schedule, container, false);
        prefrences = MySharedPreference.getInstance(getActivity());
        new AppDataPushApi().callApi(getActivity(),"Service schedule","Service schedule page","User visited to check service schedule of his car");
        initView();
        return v;
    }

    private void initView() {
        txt_registration = v.findViewById(R.id.txt_registration);
        text_make = v.findViewById(R.id.text_make);
        text_model = v.findViewById(R.id.text_model);
        text_year = v.findViewById(R.id.text_year);
        kilometer = v.findViewById(R.id.kilometer);
        info = v.findViewById(R.id.info);
        kms = v.findViewById(R.id.kms);
        LinearLayout submit = v.findViewById(R.id.submit);
        linear1 = v.findViewById(R.id.linear1);
        linear2 = v.findViewById(R.id.linear2);
        view1 = v.findViewById(R.id.view1);
        maintain_icon = v.findViewById(R.id.maintain_icon);
        data_not_found = v.findViewById(R.id.data_not_found);
        LinearLayout image_click = v.findViewById(R.id.image_click);
        submit.setOnClickListener(this);
        txt_registration.setOnItemSelectedListener(this);
        listVehicleRegistration = new ArrayList<>();
        vehicleRegistrationModelList = new ArrayList<>();
        image_click.setOnClickListener(v -> txt_registration.performClick());
        hitWebServiceVehicleRegistration();
    }

    private void hitWebServiceVehicleRegistration() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("Uid", prefrences.getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.VEHICLE_REGISTRATION_NUMBER1, this, RequestConstants.VEHICLE_REGISTRATION_NUMBER1);
        req.execute();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (vehicleRegistrationModelList.size() > 0) {
            selectedRegistrationNumberId = vehicleRegistrationModelList.get(position).getId();
            kms.setText("");
            maintain_icon.setVisibility(View.VISIBLE);
            linear1.setVisibility(View.GONE);
            linear2.setVisibility(View.GONE);
            view1.setVisibility(View.GONE);
            data_not_found.setVisibility(View.GONE);
            if(!selectedRegistrationNumberId.equals("-1"))
            hitWebServiceVehicleMakeModel();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    private void hitWebServiceVehicleMakeModel() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("Uid",prefrences.getUID());
            object.put("PolicyId", selectedRegistrationNumberId);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.VEHICLE_REGISTRATION_MAKE_MODEL_1, this, RequestConstants.VEHICLE_REGISTRATION_MAKE_MODEL_1);
        req.execute();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.VEHICLE_REGISTRATION_NUMBER1 && object.optString("Message").equals("Success")) {
            try {
                listVehicleRegistration.clear();
                vehicleRegistrationModelList.add(new ClaimFilterModel("-1", "-Select-",null));
                listVehicleRegistration.add("-Select-");
                JSONArray arr = object.getJSONArray("RegistrationNoDetails");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    if (obj.getString("VehicleType").equals("FW")){
                    vehicleRegistrationModelList.add(new ClaimFilterModel(obj.getString("PolicyId"), obj.getString("RegNo"), obj.getString("VehicleType")));
                    listVehicleRegistration.add(obj.optString("RegNo"));
                    }
                }
                ArrayAdapter vehicleRegistrationArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.vehicle_registration_spinner_item, listVehicleRegistration);
                txt_registration.setAdapter(vehicleRegistrationArrayAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (Tag == RequestConstants.VEHICLE_REGISTRATION_MAKE_MODEL_1 && object.optString("Message").equals("Success")) {
            try {
                makeId = object.optString("MakeId");
                modelId = object.optString("ModelId");
                new AppDataPushApi().callApi(getActivity(),"Service schedule","Service schedule page","User checked service schedule for make id " + makeId + " & model id " + modelId);
                if (object.optString("Make").equals("")) {
                    text_make.setText("No Info");
                } else {
                    text_make.setText(object.optString("Make"));
                }

                if (object.optString("Model").equals("")) {
                    text_model.setText("No Info");
                } else {
                    text_model.setText(object.optString("Model"));
                }

                if (object.optString("Year").equals("")) {
                    text_year.setText("No Info");
                } else {
                    text_year.setText(object.optString("Year"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Tag == RequestConstants.VEHICLE_KMS_INFO && object.optString("Message").equals("Data Not Found")) {
            try {
                maintain_icon.setVisibility(View.GONE);
                linear1.setVisibility(View.GONE);
                view1.setVisibility(View.GONE);
                linear2.setVisibility(View.GONE);
                data_not_found.setVisibility(View.VISIBLE);
                data_not_found.setText(object.optString("Message"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Tag == RequestConstants.VEHICLE_KMS_INFO && object.optString("Message").equals("Success")) {
            try {
                    maintain_icon.setVisibility(View.GONE);
                    data_not_found.setVisibility(View.GONE);
                    linear1.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.VISIBLE);
                    linear2.setVisibility(View.VISIBLE);
                    kilometer.setText(object.optString("Title"));
                String data = object.optString("PlanDetails");
                Spanned result;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        result = Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY);
                    } else {
                        result = Html.fromHtml(data);
                    }
                    info.setText(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    @Override
    public void onClick(View v) {
        km = kms.getText().toString();
        if(km.length() <= 0)
        {
            Toast.makeText(getActivity(), "Please enter kilometer your vehicle runned", Toast.LENGTH_SHORT).show();
        }
        else
        {
            hitWebServiceFetchKmsDetail();
        }
    }

    private void hitWebServiceFetchKmsDetail() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("Uid",prefrences.getUID());
            object.put("Make", makeId);
            object.put("Model", modelId);
            object.put("KM",km );
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.VEHICLE_KMS_INFO, this, RequestConstants.VEHICLE_KMS_INFO);
        req.execute();
    }
}
