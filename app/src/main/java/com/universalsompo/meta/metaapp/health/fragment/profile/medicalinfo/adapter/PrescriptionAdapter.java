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
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.fragment.FragmentDetailPrescription;
import com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.model.PrescriptionModel;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentConsultationReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.FragmentMedicineReminder;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.List;

public class PrescriptionAdapter extends BaseAdapter {
    private Activity activity;
    private List<PrescriptionModel> prescriptionModelList;
    private MySharedPreference prefrences;
    Fragment fragment;
    private LayoutInflater inflater;

    public PrescriptionAdapter(Activity activity, List<PrescriptionModel> prescriptionModelList) {
        this.activity = activity;
        this.prescriptionModelList = prescriptionModelList;
    }

    @Override
    public int getCount() {
        return prescriptionModelList.size();
    }

    @Override
    public Object getItem(int location) {
        return prescriptionModelList.get(location);
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
            convertView = inflater.inflate(R.layout.prescription_list_item, null);

        prefrences = MySharedPreference.getInstance(activity);
        TextView patient_name = convertView.findViewById(R.id.patient_name);
        TextView consult_date = convertView.findViewById(R.id.consult_date);
        LinearLayout set_reminder = convertView.findViewById(R.id.set_reminder);
        LinearLayout holder_view = convertView.findViewById(R.id.holder_view);

        final PrescriptionModel m = prescriptionModelList.get(position);

        patient_name.setText(m.getPatientName());
        consult_date.setText(m.getConsultDate());

        holder_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentDetailPrescription();
                Bundle args = new Bundle();
                args.putString("patient_name", m.getPatientName());
                args.putString("consult_date", m.getConsultDate());
                args.putString("prescription_image", m.getReportPath());
                args.putString("prescription_id", m.getMedRecordID());
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_PRESCRIPTION);
                ((MainActivityHealth)activity).changeTitle(FragmentsHealthTags.PRESCRIPTION);
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
        TextView txt_revisit = dialog.findViewById(R.id.prescription_revisit_reminder);
        TextView txt_medicine = dialog.findViewById(R.id.prescription_medicine_reminder);

        dialog.show();

        txt_revisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentConsultationReminder();
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_CONSULTATION_REMINDER);
                ((MainActivityHealth)activity).changeTitle("Consultation Reminder");
                dialog.dismiss();
            }
        });

        txt_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FragmentMedicineReminder();
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_MEDICINE_REMINDER);
                ((MainActivityHealth)activity).changeTitle("Medicine Reminder");
                dialog.dismiss();
            }
        });

    }
}
