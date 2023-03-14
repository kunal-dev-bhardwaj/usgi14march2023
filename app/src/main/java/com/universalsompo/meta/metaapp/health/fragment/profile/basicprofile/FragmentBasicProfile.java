package com.universalsompo.meta.metaapp.health.fragment.profile.basicprofile;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.database.DatabaseActivityID;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.universalsompo.meta.R.id.save_profile_menu;

public class FragmentBasicProfile extends Fragment implements ResponseListener, AdapterView.OnItemSelectedListener {
    private View v;
    private int saveMenuSatus = 0;
    private Menu menuGroup;
    MenuItem saveMenuItem, editMenuItem;
    private Spinner blood_group_spinner;
    private EditText userDobEdit,feet, inches, weight, emergency_name, emergency_contact;
    private TextView user_name, user_id, user_email_id, user_office_location, user_mobile_number, user_office_landline, user_gender, user_dob, user_blood_group, user_feet, user_inches, user_weight, user_emergency_name, user_emergency_contact;
    private ArrayAdapter<String> bloodgroupArrayAdapter;
    private List<String> bloodgroupList;
    private List<ClaimFilterModel> bloodgroupModelList;
    private String selectedBloodGroup = "";
    private MySharedPreference mySharedPreference;
    private TextView feet_txt, inches_txt, user_weight1;
    private LinearLayout edt_feet, edt_inches, inches_layout;
    private TextView user_daily_activity;
    private Spinner daily_activity_spinner;
    List<String> daily_activity;
    String item;
    ArrayAdapter<String> dataAdapter;
    DatabaseActivityID activityID;
    private SimpleDateFormat dateFormatter;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_basic_profile, container, false);
        ((MainActivityHealth) requireActivity()).show_elevation();
        mySharedPreference = MySharedPreference.getInstance(getActivity());
        init();
        callApi(RequestHealthConstants.GET_PROFILE_DETAIL);
        setHasOptionsMenu(true);
        return v;
    }

    private void init() {
        user_name = v.findViewById(R.id.user_name);
        user_id = v.findViewById(R.id.user_id);
        user_email_id = v.findViewById(R.id.user_email_id);
        user_office_location = v.findViewById(R.id.user_office_location);
        user_mobile_number = v.findViewById(R.id.user_mobile_number);
        user_office_landline = v.findViewById(R.id.user_office_landline);
        user_gender = v.findViewById(R.id.user_gender);
        user_dob = v.findViewById(R.id.user_dob);
        user_blood_group = v.findViewById(R.id.user_blood_group);
        user_emergency_name = v.findViewById(R.id.user_emergency_name);
        user_emergency_contact = v.findViewById(R.id.user_emergency_contact);
        blood_group_spinner = v.findViewById(R.id.blood_group_spinner);
        user_feet = v.findViewById(R.id.user_feet);
        user_inches = v.findViewById(R.id.user_inches);
        feet_txt = v.findViewById(R.id.feet_txt);
        inches_txt = v.findViewById(R.id.inches_txt);
        feet = v.findViewById(R.id.feet);
        userDobEdit = v.findViewById(R.id.userDobEdit);
        inches = v.findViewById(R.id.inches);
        user_weight = v.findViewById(R.id.user_weight);
        weight = v.findViewById(R.id.weight);
        emergency_contact = v.findViewById(R.id.emergency_contact);
        emergency_name = v.findViewById(R.id.emergency_name);
        edt_feet = v.findViewById(R.id.edt_feet);
        edt_inches = v.findViewById(R.id.edt_inches);
        user_weight1 = v.findViewById(R.id.user_weight1);
        inches_layout = v.findViewById(R.id.inches_layout);
        user_daily_activity = v.findViewById(R.id.user_daily_activity);
        daily_activity_spinner = v.findViewById(R.id.daily_activity_spinner);
        activityID = new DatabaseActivityID(getActivity());
        callApi(RequestHealthConstants.GET_BLOOD_GROUP);

        blood_group_spinner.setOnItemSelectedListener(this);
        daily_activity_spinner.setOnItemSelectedListener(this);

        daily_activity = new ArrayList<>();
        daily_activity.add("No Exercise");
        daily_activity.add("Light Exercise");
        daily_activity.add("Moderate Exercise");
        daily_activity.add("Heavy Exercise");
        daily_activity.add("Very Heavy Exercise");

        dataAdapter = new ArrayAdapter<>(requireActivity(), R.layout.spinner_item, daily_activity);
        daily_activity_spinner.setAdapter(dataAdapter);
        bloodgroupList = new ArrayList<>();
        bloodgroupModelList = new ArrayList<>();

        userDobEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalender();
            }
        });

    }
    private void showCalender() {
        Calendar newCalendar = Calendar.getInstance();
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        DatePickerDialog datePicker = new DatePickerDialog(requireActivity(), R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                Toast.makeText(getActivity(), dateFormatter.format(newDate.getTime()), Toast.LENGTH_SHORT).show();
                userDobEdit.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePicker.show();
    }
    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.profile_menu, menu);
        menuGroup = menu;
    }

    @Override
    public void onPrepareOptionsMenu(@NotNull Menu menu) {
        if (saveMenuSatus == 0)
            menu.findItem(R.id.edit_profile_menu).setVisible(true);
        else
            menu.findItem(R.id.save_profile_menu).setVisible(true);

        super.onPrepareOptionsMenu(menu);

    }

    public void menuInvisible() {
        setHasOptionsMenu(true);// Take part in populating the action bar menu
        if (saveMenuSatus == 0) {
            editMenuItem = menuGroup.findItem(R.id.edit_profile_menu);
            editMenuItem.setVisible(true);
            saveMenuItem = menuGroup.findItem(save_profile_menu);
            saveMenuItem.setVisible(false);
        } else {
            saveMenuItem = menuGroup.findItem(R.id.save_profile_menu);
            saveMenuItem.setVisible(true);
            editMenuItem = menuGroup.findItem(R.id.edit_profile_menu);
            editMenuItem.setVisible(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.edit_profile_menu:
                user_blood_group.setVisibility(View.GONE);
                blood_group_spinner.setVisibility(View.VISIBLE);
                feet.setVisibility(View.VISIBLE);
                user_feet.setVisibility(View.GONE);
                inches.setVisibility(View.VISIBLE);
                feet_txt.setVisibility(View.VISIBLE);
                inches_txt.setVisibility(View.VISIBLE);
                user_inches.setVisibility(View.GONE);
                weight.setVisibility(View.VISIBLE);
                emergency_name.setVisibility(View.VISIBLE);
                emergency_contact.setVisibility(View.VISIBLE);
                user_emergency_contact.setVisibility(View.GONE);
                user_emergency_name.setVisibility(View.GONE);
                user_weight.setVisibility(View.GONE);
                edt_feet.setVisibility(View.VISIBLE);
                edt_inches.setVisibility(View.VISIBLE);
                user_weight1.setVisibility(View.VISIBLE);
                inches_layout.setVisibility(View.VISIBLE);
                user_daily_activity.setVisibility(View.GONE);
                daily_activity_spinner.setVisibility(View.VISIBLE);
                inches_layout.setVisibility(View.VISIBLE);
                userDobEdit.setVisibility(View.VISIBLE);
                user_dob.setVisibility(View.GONE);
                this.editMenuItem = item;
                saveMenuSatus = 1;
                menuInvisible();
                return true;

            case R.id.save_profile_menu:
                if (Integer.parseInt(feet.getText().toString()) >= 8) {
                    Toast.makeText(getActivity(), "Height cannot be more than 7 feet.", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(inches.getText().toString()) >= 12) {
                    Toast.makeText(getActivity(), "Height cannot be more than 11 inches.", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(weight.getText().toString()) >= 201) {
                    Toast.makeText(getActivity(), "Weight cannot be greater than 200 kg.", Toast.LENGTH_SHORT).show();
                } else {
                    this.saveMenuItem = item;
                    user_blood_group.setVisibility(View.VISIBLE);
                    blood_group_spinner.setVisibility(View.GONE);
                    feet.setVisibility(View.GONE);
                    user_feet.setVisibility(View.VISIBLE);
                    inches.setVisibility(View.GONE);
                    user_inches.setVisibility(View.VISIBLE);
                    feet_txt.setVisibility(View.GONE);
                    inches_txt.setVisibility(View.GONE);
                    weight.setVisibility(View.GONE);
                    user_weight.setVisibility(View.VISIBLE);
                    emergency_name.setVisibility(View.GONE);
                    emergency_contact.setVisibility(View.GONE);
                    user_emergency_contact.setVisibility(View.VISIBLE);
                    user_emergency_name.setVisibility(View.VISIBLE);
                    edt_feet.setVisibility(View.GONE);
                    edt_inches.setVisibility(View.GONE);
                    user_weight1.setVisibility(View.GONE);
                    inches_layout.setVisibility(View.GONE);
                    user_daily_activity.setVisibility(View.VISIBLE);
                    daily_activity_spinner.setVisibility(View.GONE);
                    inches_layout.setVisibility(View.GONE);
                    userDobEdit.setVisibility(View.GONE);
                    user_dob.setVisibility(View.VISIBLE);
                    saveMenuSatus = 0;
                    menuInvisible();
                    callApi(RequestHealthConstants.PROFILE_UPDATE_WEIGHT_HEIGHT_BLOODGROUP);
                }
                return true;
        }
        return false;
    }

    private void callApi(Integer id) {
        //************************************* profile detail Api Call *******************************
        if (id == RequestHealthConstants.GET_PROFILE_DETAIL) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_PROFILE_DETAIL, this, RequestHealthConstants.GET_PROFILE_DETAIL);
            req.execute();
        }

        //****************************************** Get City Api Call *********************************************
        else if (id == RequestHealthConstants.GET_BLOOD_GROUP) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_BLOOD_GROUP, this, RequestHealthConstants.GET_BLOOD_GROUP);
            req.execute();
        }

        else if (id == RequestHealthConstants.PROFILE_UPDATE_WEIGHT_HEIGHT_BLOODGROUP) {
            JSONObject object = new JSONObject();
            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("UserID", mySharedPreference.getUID());
                object.put("BloodGroup", selectedBloodGroup);
                object.put("HeightInInch", inches.getText().toString().trim());
                object.put("HeightInFeet", feet.getText().toString());
                object.put("Weight", weight.getText().toString());
                object.put("DailyActivity", item);
                object.put("EmergencyContactPersonName", emergency_name.getText().toString());
                object.put("EmergencyContactNo", emergency_contact.getText().toString());
            } catch (JSONException je) {
                je.printStackTrace();
            }
            ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.PROFILE_UPDATE_WEIGHT_HEIGHT_BLOODGROUP, this, RequestHealthConstants.PROFILE_UPDATE_WEIGHT_HEIGHT_BLOODGROUP);
            req.execute();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.blood_group_spinner:
                if (bloodgroupModelList.size() > 0) {
                    selectedBloodGroup = bloodgroupModelList.get(position).getName();
                }
                break;
            case R.id.daily_activity_spinner:
                item = parent.getItemAtPosition(position).toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_PROFILE_DETAIL) {
            try {
                if (!object.optString("Name").equals("")) {
                    user_name.setText(object.optString("Name"));
                }

                if (!object.optString("EmployeeID").equals("")) {
                    user_id.setText(object.optString("EmployeeID"));
                    mySharedPreference.setEmpid(object.optString("EmployeeID"));
                }

                if (!object.optString("Email").equals("")) {
                    user_email_id.setText(object.optString("Email"));
                }

                if (!object.optString("OfficeLocation").equals("")) {
                    user_office_location.setText(object.optString("OfficeLocation"));
                }

                if (!object.optString("Mobile").equals("")) {
                    user_mobile_number.setText(object.optString("Mobile"));
                }

                if (!object.optString("LandlineNo").equals("")) {
                    user_office_landline.setText(object.optString("LandlineNo"));
                }

                if (!object.optString("Gender").equals("")) {
                    user_gender.setText(object.optString("Gender"));
                    mySharedPreference.setgender(object.optString("Gender"));
                }

                if (!object.optString("DateOfBirth").equals("")) {
                    user_dob.setText(parseDateToddMMyyyy(object.optString("DateOfBirth")));
                    String dobb = parseDateToddMMyyyy(object.optString("DateOfBirth"));
                    mySharedPreference.setDOB(dobb);
                }

                if (!object.optString("BloodGroup").equals("")) {
                    user_blood_group.setText(object.optString("BloodGroup"));
                    String spin_value1 = object.optString("BloodGroup");
                    int spinnerPosition = bloodgroupArrayAdapter.getPosition(spin_value1);
                    blood_group_spinner.setSelection(spinnerPosition);
                }

                if (!object.optString("Height").equals("")) {
                    String height = object.optString("Height");
                    String[] parts = height.split("\\'");
                    String feet_txt = parts[0];
                    String inches_txt = parts[1];
                    user_feet.setText(feet_txt + "'" + inches_txt + "''");
                    user_inches.setText(inches_txt);
                    feet.setText(feet_txt);
                    inches.setText(inches_txt);
                    mySharedPreference.setfeet(feet_txt);
                    mySharedPreference.setinches(inches_txt);
                }

                if (!object.optString("Weight").equals("")) {
                    user_weight.setText(object.optString("Weight") + " kg");
                    weight.setText(object.optString("Weight"));
                    mySharedPreference.setweight(object.optString("Weight"));
                }

                if (!object.optString("DailyActivity").equals("")) {
                    user_daily_activity.setText(object.optString("DailyActivity"));
                    String spin_value = object.optString("DailyActivity");
                    int spinnerPosition = dataAdapter.getPosition(spin_value);
                    daily_activity_spinner.setSelection(spinnerPosition);
                    mySharedPreference.setDailyactivity(object.optString("DailyActivity"));
                }

                if (!object.optString("EmergencyContactNo").equals("")) {
                    user_emergency_contact.setText(object.optString("EmergencyContactNo"));
                    emergency_contact.setText(object.optString("EmergencyContactNo"));
                }

                if (!object.optString("EmergencyContactPersonaName").equals("")) {
                    user_emergency_name.setText(object.optString("EmergencyContactPersonaName"));
                    emergency_name.setText(object.optString("EmergencyContactPersonaName"));
                }

                if (!object.optString("Age").equals("")) {
                    mySharedPreference.setAge(object.optString("Age"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Tag == RequestHealthConstants.GET_BLOOD_GROUP) {
            try {
                bloodgroupList.clear();
                JSONArray arr = object.getJSONArray("objMasterBloodGroupRes");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    bloodgroupModelList.add(new ClaimFilterModel(obj.getString("BloodGroupId"), obj.getString("BloodGroupName")));
                    bloodgroupList.add(obj.optString("BloodGroupName"));
                }
                bloodgroupArrayAdapter = new ArrayAdapter<>(requireActivity(), R.layout.spinner_item, bloodgroupList);

                blood_group_spinner.setAdapter(bloodgroupArrayAdapter);

                ArrayAdapter myAdap = (ArrayAdapter) blood_group_spinner.getAdapter(); //cast to an ArrayAdapter
                int spinnerPosition = myAdap.getPosition(selectedBloodGroup);
                blood_group_spinner.setSelection(spinnerPosition);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if (Tag == RequestHealthConstants.PROFILE_UPDATE_WEIGHT_HEIGHT_BLOODGROUP){
            if (object.optString("Message").equals("Success")){
                callApi(RequestHealthConstants.GET_PROFILE_DETAIL);
                Toast.makeText(getActivity(), "Successfully updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Unable to update your profile", Toast.LENGTH_SHORT).show();
            }
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

    private String parseDateToddMMyyyy(String time) {
        String inputPattern;

        if(time.contains("/"))
            inputPattern = "MM/dd/yyyy";
        else
            inputPattern = "MMM-dd-yyyy";

        String outputPattern = "dd-MMM-yyyy";
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
