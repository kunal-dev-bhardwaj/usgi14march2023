package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentDetailOthers;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.OthersModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.List;

public class OthersAdapter extends BaseAdapter {
    private Activity activity;
    private List<OthersModel> othersModelList;
    private MySharedPreference prefrences;
    Fragment fragment;
    private LayoutInflater inflater;

    public OthersAdapter(Activity activity, List<OthersModel> othersModelList) {
        this.activity = activity;
        this.othersModelList = othersModelList;
    }

    @Override
    public int getCount() {
        return othersModelList.size();
    }

    @Override
    public Object getItem(int location) {
        return othersModelList.get(location);
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
            convertView = inflater.inflate(R.layout.others_list_item, null);

        prefrences = MySharedPreference.getInstance(activity);
        TextView patient_name = convertView.findViewById(R.id.patient_name);
        TextView consult_date = convertView.findViewById(R.id.consult_date);
        LinearLayout holder_view = convertView.findViewById(R.id.holder_view);

        final OthersModel m = othersModelList.get(position);

        patient_name.setText(m.getPatientName());
        consult_date.setText(m.getDate());

        holder_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentDetailOthers();
                Bundle args = new Bundle();
                args.putString("patient_name", m.getPatientName());
                args.putString("date", m.getDate());
                args.putString("image", m.getDocumentPath());
                args.putString("id", m.getDocID());
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_OTHER);
                ((MainActivityHealth)activity).changeTitle(FragmentsHealthTags.OTHER);
            }
        });

        return convertView;
    }
}
