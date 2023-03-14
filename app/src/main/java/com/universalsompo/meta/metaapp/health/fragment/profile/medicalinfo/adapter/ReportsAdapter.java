package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentDetailReports;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.ReportsModel;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentConsultationReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentLabTestReminder;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.List;

public class ReportsAdapter extends BaseAdapter {
    private Activity activity;
    private List<ReportsModel> reportsModelList;
    private MySharedPreference prefrences;
    Fragment fragment;
    private LayoutInflater inflater;

    public ReportsAdapter(Activity activity, List<ReportsModel> reportsModelList) {
        this.activity = activity;
        this.reportsModelList = reportsModelList;
    }

    @Override
    public int getCount() {
        return reportsModelList.size();
    }

    @Override
    public Object getItem(int location) {
        return reportsModelList.get(location);
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
            convertView = inflater.inflate(R.layout.reports_list_item, null);

        prefrences = MySharedPreference.getInstance(activity);
        TextView patient_name = convertView.findViewById(R.id.patient_name);
        TextView consult_date = convertView.findViewById(R.id.consult_date);
        LinearLayout set_reminder = convertView.findViewById(R.id.set_reminder);
        LinearLayout holder_view = convertView.findViewById(R.id.holder_view);

        final ReportsModel m = reportsModelList.get(position);

        patient_name.setText(m.getPatientName());
        consult_date.setText(m.getTestDate());

        holder_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentDetailReports();
                Bundle args = new Bundle();
                args.putString("patient_name", m.getPatientName());
                args.putString("test_date", m.getTestDate());
                args.putString("test_image", m.getReportPath());
                args.putString("test_id", m.getReportID());
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_REPORT);
                ((MainActivityHealth)activity).changeTitle(FragmentsHealthTags.REPORT);
            }
        });

        set_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdailog();
            }
        });

        return convertView;
    }

    private void showdailog() {
        final Dialog dialog = new Dialog(activity, R.style.CustomDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.set_reminder_prescription_dialog);
        TextView txt_doctor_consultation = dialog.findViewById(R.id.prescription_revisit_reminder);
        txt_doctor_consultation.setText("Consultation");
        TextView txt_lab_test = dialog.findViewById(R.id.prescription_medicine_reminder);
        txt_lab_test.setText("Lab Test");
        dialog.show();

        txt_doctor_consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentConsultationReminder();
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_CONSULTATION_REMINDER);
                ((MainActivityHealth)activity).changeTitle("Consultation Reminder");
                dialog.dismiss();
            }
        });

        txt_lab_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentLabTestReminder();
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_LAB_TEST_REMINDER);
                ((MainActivityHealth)activity).changeTitle("Lab Test Reminder");
                dialog.dismiss();
            }
        });
    }
}
