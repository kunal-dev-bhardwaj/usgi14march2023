package com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.fragment.FragmentFamilyInfo;
import com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.model.FamilyModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONObject;

import java.util.List;

public class FamilyAdapter extends BaseAdapter implements ResponseListener {
    private Activity activity;
    private List<FamilyModel> familyModelList;
    private MySharedPreference prefrences;
    Fragment fragment;
    private LayoutInflater inflater;
    private TextView family_member_name, family_member_relationship, family_member_age;
    private TextView family_member_mobile;
    private LinearLayout edit_layout, save_layout;


    public FamilyAdapter(Activity activity, List<FamilyModel> familyModelList) {
        this.activity = activity;
        this.familyModelList = familyModelList;
    }

    @Override
    public int getCount() {
        return familyModelList.size();
    }

    @Override
    public Object getItem(int location) {
        return familyModelList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.family_info_list_item, null);

        prefrences = MySharedPreference.getInstance(activity);
        family_member_name = convertView.findViewById(R.id.family_member_name);
        family_member_relationship = convertView.findViewById(R.id.family_member_relationship);
        family_member_age = convertView.findViewById(R.id.family_member_age);
        family_member_mobile = convertView.findViewById(R.id.family_member_mobile);

        edit_layout = convertView.findViewById(R.id.edit_layout);
        save_layout = convertView.findViewById(R.id.save_layout);

        final FamilyModel m = familyModelList.get(position);

        family_member_name.setText(m.getFamilyName());
        family_member_relationship.setText(m.getRelationship());
        family_member_age.setText(m.getAge());
        family_member_mobile.setText(m.getMobileNo());

        edit_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmobiledialog(m.getUserFamilyId());
            }
        });

        save_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return convertView;
    }

    private void openmobiledialog(final String family_id) {
        final Dialog dialog = new Dialog(activity);
        //dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_box);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.mobile_update_dialog);

        final EditText mobile_number = dialog.findViewById(R.id.mobile_number);
        TextView save = dialog.findViewById(R.id.tvsave);
        TextView cancel = dialog.findViewById(R.id.tvcancel);
        // if button is clicked, close the custom dialog
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatefamilymobilenumber(mobile_number.getText().toString(), family_id);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void updatefamilymobilenumber(String mobile_update, String family_id) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(activity).getToken_no());
            object.put("UserID", MySharedPreference.getInstance(activity).getUID());
            object.put("FamilyID", family_id);
            object.put("MobileNo", mobile_update);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.UPDATE_FAMILY_MOBILE_NUMBER, this, RequestHealthConstants.UPDATE_FAMILY_MOBILE_NUMBER);
        req.execute();

    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (object.optString("Message").equals("Success")) {
            if (Tag == RequestHealthConstants.UPDATE_FAMILY_MOBILE_NUMBER) {
                FragmentManager fm = ((FragmentActivity)activity).getSupportFragmentManager();
                FragmentFamilyInfo fragment = (FragmentFamilyInfo)fm.findFragmentByTag(FragmentsHealthTags.FRAGMENT_FAMILY_INFO);
                fragment.getfamilydetails();
            }
        } else {
            Toast.makeText(activity, "Unable to update mobile number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
