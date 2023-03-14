package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentStats;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.AllergicToModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.Allergy;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.AllergyTypeModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.ReactionModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class GetAllergiesAdapter extends BaseAdapter implements ResponseListener, AdapterView.OnItemSelectedListener {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Allergy> user_allergy_list;
    private MySharedPreference mySharedPreference;
    private LinearLayout allergies_layout_1;
    private ImageView down_arrow5, up_arrow5;
    private Spinner spn_allergy_type, spn_allergic_to, spn_reaction;
    private ArrayAdapter<String> allergytypeArrayAdapter, allergictoArrayAdapter, reactionArrayAdapter;
    private List<String> allergytypeList;
    private List<String> allergictoList;
    private List<String> reactionList;
    private List<AllergyTypeModel> allergytypeModelList;
    private List<AllergicToModel> allergictoModelList;
    private List<ReactionModel> reactionModelList;
    private String selectedAllergyTypeId = "";
    private String selectedAllergicToId = "";
    private String selectedReactionId = "";
    private String selectedAllergyType = "";
    private String selectedAllergicTo = "";
    private String selectedReaction = "";

    public GetAllergiesAdapter(Activity activity, List<Allergy> allergy, LinearLayout allergies_Layout_1, ImageView Down_arrow5, ImageView Up_arrow5) {
        this.activity = activity;
        this.user_allergy_list = allergy;
        this.allergies_layout_1 = allergies_Layout_1;
        this.down_arrow5 = Down_arrow5;
        this.up_arrow5 = Up_arrow5;
    }

    @Override
    public int getCount() {
        return user_allergy_list.size();
    }

    @Override
    public Object getItem(int i) {
        return user_allergy_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.allergy_list_layout, null);

        TextView allergy_type = view.findViewById(R.id.allergy_type);
        TextView allergy_to = view.findViewById(R.id.allergy_to);
        TextView reaction = view.findViewById(R.id.reaction);
        LinearLayout delete_allergy = view.findViewById(R.id.delete_allergy);
        LinearLayout edit_allergy = view.findViewById(R.id.edit_allergy);
        LinearLayout share_allergy = view.findViewById(R.id.share_allergy);

        mySharedPreference = MySharedPreference.getInstance(activity);
        final Allergy m = user_allergy_list.get(i);

        allergy_type.setText(m.getAllergiesType());
        allergy_to.setText(m.getAllergies());
        reaction.setText(m.getReaction());

        edit_allergy.setOnClickListener(view12 -> open_dialog(m.getID(), m.getAllergiesType(), m.getAllergies(), m.getReaction()));

        delete_allergy.setOnClickListener(view1 -> {
            final Dialog dialog = new Dialog(activity,R.style.CustomDialog);

            dialog.setCanceledOnTouchOutside(true);
            dialog.setCancelable(true);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.setContentView(R.layout.delete_others_medical_record_dialog);

            TextView yes = dialog.findViewById(R.id.delete_medical_other_record);
            TextView cancel = dialog.findViewById(R.id.no);

            cancel.setOnClickListener(v -> dialog.dismiss());

            yes.setOnClickListener(v -> {
                callApi(m.getID());
                dialog.dismiss();
            });
            dialog.show();
        });

        share_allergy.setOnClickListener(v -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "1. Allergy Type : " + m.getAllergiesType();
            String shareBody1 = "2. Allergic To : " + m.getAllergies();
            String shareBody2 = "3. Reaction : " + m.getReaction();
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"Allergies Report");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody + "\n" + shareBody1 + "\n" + shareBody2);
            activity.startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        return view;
    }

    private void open_dialog(final String allergy_id, String allergy_type, String allergic_to, String reaction) {
        final Dialog dialog = new Dialog(activity,R.style.CustomDialog);
        //dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_box);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.allergy_update_dialog1);

        spn_allergy_type = dialog.findViewById(R.id.spn_allergy_type);
        spn_allergic_to = dialog.findViewById(R.id.spn_allergic_to);
        spn_reaction = dialog.findViewById(R.id.spn_reaction);
        TextView save = dialog.findViewById(R.id.tvsave);
        TextView cancel = dialog.findViewById(R.id.tvcancel);

        spn_allergy_type.setOnItemSelectedListener(this);
        spn_allergic_to.setOnItemSelectedListener(this);
        spn_reaction.setOnItemSelectedListener(this);
        allergytypeList = new ArrayList<>();
        allergictoList = new ArrayList<>();
        reactionList = new ArrayList<>();
        allergytypeModelList = new ArrayList<>();
        allergictoModelList = new ArrayList<>();
        reactionModelList = new ArrayList<>();

        callApi1(RequestHealthConstants.GET_ALLERGY_TYPE);
        callApi1(RequestHealthConstants.GET_REACTION);

        selectedAllergyType = allergy_type;
        selectedAllergicTo = allergic_to;
        selectedReaction = reaction;

        // if button is clicked, close the custom dialog
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        save.setOnClickListener(v -> {
            callApi2(RequestHealthConstants.SAVE_ALLERGY_DATA, allergy_id);
            dialog.dismiss();
        });

        dialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spn_allergy_type:
                if (allergytypeModelList.size() > 0) {
                    selectedAllergyTypeId = allergytypeModelList.get(position).getTypeId();
                }
                if (!selectedAllergyTypeId.equals("")) {
                    spn_allergic_to.setEnabled(true);
                    LogUtils.showLog("ALLERGY TYPE ID", selectedAllergyTypeId);
                    callApi1(RequestHealthConstants.GET_ALLERGIC_TO);
                }
                break;

            case R.id.spn_allergic_to:
                if (allergictoModelList.size() > 0) {
                    selectedAllergicToId = allergictoModelList.get(position).getTypeId();
                }
                if (!selectedAllergicToId.equals("")) {
                    spn_reaction.setEnabled(true);
                    LogUtils.showLog("ALLERGIC TO ID", selectedAllergicToId);
                }
                break;

            case R.id.spn_reaction:
                if (reactionModelList.size() > 0) {
                    LogUtils.showLog("REACTION ID", selectedReactionId);
                    selectedReactionId = reactionModelList.get(position).getTypeId();
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    private void callApi(String id) {
        /* Delete allergy */
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
            object.put("UserID", mySharedPreference.getUID());
            object.put("DataID", id);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.DELETE_ALLERGY, this, RequestHealthConstants.DELETE_ALLERGY);
        req.execute();
    }

    private void callApi1(Integer id){
        /* Get Allergy Type */
        if (id == RequestHealthConstants.GET_ALLERGY_TYPE) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.GET_ALLERGY_TYPE, this, RequestHealthConstants.GET_ALLERGY_TYPE);
            req.execute();
        }

        /* Get Allergy To */
        else if (id == RequestHealthConstants.GET_ALLERGIC_TO) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
                object.put("TypeID", selectedAllergyTypeId);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.GET_ALLERGIC_TO, this, RequestHealthConstants.GET_ALLERGIC_TO);
            req.execute();
        }

        /* Get Allergy Type */
        else if (id == RequestHealthConstants.GET_REACTION) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("Uid", mySharedPreference.getUID());
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.GET_REACTION, this, RequestHealthConstants.GET_REACTION);
            req.execute();
        }
    }

    private void callApi2(Integer id, String allergyid){
        if (id == RequestHealthConstants.SAVE_ALLERGY_DATA) {
            JSONObject object = new JSONObject();

            try {
                object.put(RequestHealthConstants.TOKEN_NO_HEALTH, mySharedPreference.getToken_no());
                object.put("ID", allergyid);
                object.put("UserID", mySharedPreference.getUID());
                object.put("AllergiesTypeID", selectedAllergyTypeId);
                object.put("AllergiesID", selectedAllergicToId);
                object.put("ReactionID", selectedReactionId);
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.SAVE_ALLERGY_DATA, this, RequestHealthConstants.SAVE_ALLERGY_DATA);
            req.execute();
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.DELETE_ALLERGY){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(activity, "Successfully deleted", Toast.LENGTH_SHORT).show();
                allergies_layout_1.setVisibility(View.GONE);
                down_arrow5.setVisibility(View.VISIBLE);
                up_arrow5.setVisibility(View.GONE);
            } else {
                Toast.makeText(activity, "Unable to update your blood pressure values", Toast.LENGTH_SHORT).show();
            }
        }

        else if(Tag == RequestHealthConstants.GET_ALLERGY_TYPE){
            try {
                allergytypeList.clear();
                JSONArray arr = object.getJSONArray("objMasterTypeRes");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    allergytypeModelList.add(new AllergyTypeModel(obj.getString("TypeId"), obj.getString("TypeName")));
                    allergytypeList.add(obj.optString("TypeName"));
                }
                allergytypeArrayAdapter = new ArrayAdapter<String>(activity, R.layout.spinner_item, allergytypeList);

                spn_allergy_type.setAdapter(allergytypeArrayAdapter);

                ArrayAdapter myAdap = (ArrayAdapter) spn_allergy_type.getAdapter();
                int spinnerPosition = myAdap.getPosition(selectedAllergyType);
                spn_allergy_type.setSelection(spinnerPosition);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        else if(Tag == RequestHealthConstants.GET_ALLERGIC_TO){
            try {
                allergictoList.clear();
                JSONArray arr = object.getJSONArray("objMasterAllergiesRes");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    allergictoModelList.add(new AllergicToModel(obj.getString("AllergiesId"), obj.getString("AllergiesName")));
                    allergictoList.add(obj.optString("AllergiesName"));
                }
                allergictoArrayAdapter = new ArrayAdapter<String>(activity, R.layout.spinner_item, allergictoList);

                spn_allergic_to.setAdapter(allergictoArrayAdapter);

                ArrayAdapter myAdap1 = (ArrayAdapter) spn_allergic_to.getAdapter();
                int spinnerPosition1 = myAdap1.getPosition(selectedAllergicTo);
                spn_allergic_to.setSelection(spinnerPosition1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        else if(Tag == RequestHealthConstants.GET_REACTION){
            try {
                reactionList.clear();
                JSONArray arr = object.getJSONArray("objMasterReactionRes");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    reactionModelList.add(new ReactionModel(obj.getString("ReactionId"), obj.getString("ReactionName")));
                    reactionList.add(obj.optString("ReactionName"));
                }
                reactionArrayAdapter = new ArrayAdapter<String>(activity, R.layout.spinner_item, reactionList);

                spn_reaction.setAdapter(reactionArrayAdapter);

                ArrayAdapter myAdap2 = (ArrayAdapter) spn_reaction.getAdapter();
                int spinnerPosition2 = myAdap2.getPosition(selectedReaction);
                spn_reaction.setSelection(spinnerPosition2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        /* Save allergy data */
        else if (Tag == RequestHealthConstants.SAVE_ALLERGY_DATA){
            if (object.optString("Message").equals("Success")){
                Toast.makeText(activity, "Successfully updated", Toast.LENGTH_SHORT).show();
                FragmentManager fm = ((FragmentActivity)activity).getSupportFragmentManager();
                FragmentStats fragment = (FragmentStats)fm.findFragmentByTag(FragmentsHealthTags.FRAGMENT_STATS);
                fragment.getallergydetails();
            } else {
                Toast.makeText(activity, "Unable to update values", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}
