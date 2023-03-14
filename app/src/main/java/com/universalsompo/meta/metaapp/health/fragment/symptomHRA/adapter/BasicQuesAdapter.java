package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentBasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.BasicQuesModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.List;

public class BasicQuesAdapter extends RecyclerView.Adapter<BasicQuesAdapter.MyViewHolder> {
    private Activity activity;
    private List<BasicQuesModel> basicquesModelList;
    private LayoutInflater inflater;
    FragmentBasicQuestion frag;
    RecyclerView recyclerView;
    MySharedPreference pref;
    private int position;
    String choice_id;
    BasicQuesDatabaseHelper db;

    public BasicQuesAdapter(Activity activity, List<BasicQuesModel> basicquesModelList, RecyclerView recyclerview, FragmentBasicQuestion frag) {
        this.activity = activity;
        this.basicquesModelList = basicquesModelList;
        this.recyclerView = recyclerview;
        this.frag = frag;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView basic_question;
        RadioGroup radioGroup;
        RadioButton present, absent, unknown;

        public MyViewHolder(View view) {
            super(view);
            basic_question = view.findViewById(R.id.basic_question);
            radioGroup = view.findViewById(R.id.radioGroup);
            present = view.findViewById(R.id.present);
            absent = view.findViewById(R.id.absent);
            unknown = view.findViewById(R.id.unknown);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.basic_symptom_item, parent, false);
        pref = MySharedPreference.getInstance(activity);
        db = new BasicQuesDatabaseHelper(activity);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.basic_question.setText(basicquesModelList.get(position).getbasic_sympname());

        if (basicquesModelList.get(position).getbasic_choiceid().equalsIgnoreCase("present")) {
            holder.present.setChecked(true);
            holder.absent.setChecked(false);
            holder.unknown.setChecked(false);
        } else if (basicquesModelList.get(position).getbasic_choiceid().equalsIgnoreCase("absent")) {
            holder.present.setChecked(false);
            holder.absent.setChecked(true);
            holder.unknown.setChecked(false);
        } else if (basicquesModelList.get(position).getbasic_choiceid().equalsIgnoreCase("unknown")) {
            holder.present.setChecked(false);
            holder.absent.setChecked(false);
            holder.unknown.setChecked(true);
        } else {
            holder.present.setChecked(false);
            holder.absent.setChecked(false);
            holder.unknown.setChecked(false);
        }

        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    String choice = (String) rb.getText();
                    if (choice.equalsIgnoreCase("Yes")) {
                        choice_id = "present";
                    } else if (choice.equalsIgnoreCase("No")) {
                        choice_id = "absent";
                    } else {
                        choice_id = "unknown";
                    }
                    db.updateBasicSymptom(pref.getUID(), pref.getUserName(), basicquesModelList.get(position).getbasic_interviewid(), "", "", basicquesModelList.get(position).getbasic_symptomid(), basicquesModelList.get(position).getbasic_sympname(), "true", choice_id, basicquesModelList.get(position).getbasicDate(), basicquesModelList.get(position).getbasicFragmentname());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return basicquesModelList.size();
    }
}
