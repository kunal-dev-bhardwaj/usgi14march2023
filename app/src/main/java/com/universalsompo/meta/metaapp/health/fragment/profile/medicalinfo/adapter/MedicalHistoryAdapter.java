package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.database.DatabaseHelper12;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.MedicalHistoryModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.List;

public class MedicalHistoryAdapter extends BaseAdapter {
    private Activity activity;
    private List<MedicalHistoryModel> medicalhistoryModelList;
    private MySharedPreference prefrences;
    Fragment fragment;
    private LayoutInflater inflater;
    private DatabaseHelper12 db;
    private MySharedPreference pref;
    static CheckBox chkbox;

    public MedicalHistoryAdapter(Activity activity, List<MedicalHistoryModel> medicalModelList) {
        this.activity = activity;
        this.medicalhistoryModelList = medicalModelList;
    }

    @Override
    public int getCount() {
        return medicalhistoryModelList.size();
    }

    @Override
    public Object getItem(int location) {
        return medicalhistoryModelList.get(location);
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
            convertView = inflater.inflate(R.layout.medical_history_list_item, null);

        prefrences = MySharedPreference.getInstance(activity);
        TextView medical_history_name = convertView.findViewById(R.id.medical_history_name);
        chkbox = convertView.findViewById(R.id.chkbox);
        pref = MySharedPreference.getInstance(activity);
        db = new DatabaseHelper12(activity);

        final MedicalHistoryModel m = medicalhistoryModelList.get(position);

        medical_history_name.setText(m.getConditionName());

        chkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String userid = pref.getUID();
                    String diseaese_id = m.getConditionID();
                    String diseases_name = m.getConditionName();
                    String is_user_suffer = "True";
                    db.updatedata(userid, diseaese_id, diseases_name, is_user_suffer);
                }else{
                    String userid = pref.getUID();
                    String diseaese_id = m.getConditionID();
                    String diseases_name = m.getConditionName();
                    String is_user_suffer = "False";
                    db.updatedata(userid, diseaese_id, diseases_name, is_user_suffer);
                }
            }
        });

        String suffer = db.getissuffervalue(m.getConditionID());
        System.out.println("Suffer " + suffer);
        if(suffer.equalsIgnoreCase("true")){
            chkbox.setChecked(true);
        } else {
            chkbox.setChecked(false);
        }

        return convertView;
    }
}
