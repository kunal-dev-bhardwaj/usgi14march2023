package com.universalsompo.meta.metaapp.motor.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMyIssueMotorDetails;
import com.universalsompo.meta.metaapp.motor.models.MyIssuesMotor;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.List;

public class MyIssueMotorAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<MyIssuesMotor> issue_list;
    private String issue_id, category1, desc;

    public MyIssueMotorAdapter(Activity activity, List<MyIssuesMotor> help) {
        this.activity = activity;
        this.issue_list = help;
    }

    @Override
    public int getCount() {
        return issue_list.size();
    }

    @Override
    public Object getItem(int i) {
        return issue_list.get(i);
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
            view = inflater.inflate(R.layout.my_issue_motor_list_layout, viewGroup, false);

        final TextView category =  view.findViewById(R.id.category);
        final TextView description =  view.findViewById(R.id.description);
        final TextView status =  view.findViewById(R.id.status);
        final TextView date =  view.findViewById(R.id.date);
        final LinearLayout my_issue_selected =  view.findViewById(R.id.my_issue_selected);

        final MyIssuesMotor m = issue_list.get(i);

        category.setText(m.getCategory());
        description.setText(m.getComment());
        status.setText(activity.getResources().getString(R.string.status)+" : " + m.getIssueStatus());
        date.setText(m.getIssueDate());

        my_issue_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                issue_id = m.getIssueID();
                category1 = m.getCategory();
                desc = m.getComment();
                Fragment frag = new FragmentMyIssueMotorDetails();
                Bundle args = new Bundle();
                args.putString("issue_id", issue_id);
                args.putString("cat", category1);
                args.putString("desc", desc);
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame, FragmentsTags.FRAGMENT_MY_ISSUE);
            }
        });
        return view;
    }
}
