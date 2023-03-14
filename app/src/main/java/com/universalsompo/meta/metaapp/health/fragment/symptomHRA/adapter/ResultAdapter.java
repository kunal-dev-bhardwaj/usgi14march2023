package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.SymptomConditionWebviewActivity;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.DatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Result_getter_setter;


import java.util.List;

public class ResultAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Result_getter_setter> statusItems;
    public static final String TAG = "MyTag";
    private ListView list;
    private DatabaseHelper db;
    String userid,interviewid;

    public ResultAdapter(Activity activity, List<Result_getter_setter> statusItems, ListView list, String userid, String interviewid) {
        this.activity = activity;
        this.statusItems = statusItems;
        this.list = list;
        this.userid = userid;
        this.interviewid = interviewid;
    }

    @Override
    public int getCount() {
        return statusItems.size();
    }

    @Override
    public Object getItem(int location) {
        return statusItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.result_list_item, null);

        TextView name = convertView.findViewById(R.id.name);
        TextView severity = convertView.findViewById(R.id.severity);
        // TextView percentage = convertView.findViewById(R.id.percentage);
        ProgressBar simpleProgressBar = convertView.findViewById(R.id.simpleProgressBar);
        LinearLayout linear_layout = convertView.findViewById(R.id.linear_layout);
        simpleProgressBar.setMax(100);

        final Result_getter_setter m = statusItems.get(position);

        name.setText(m.getname());
        float per = Float.parseFloat(m.getprobability());
        float per11 = per * 100;
        int per1 = Math.round(per11);
        if(per1 >= 70.00){
            simpleProgressBar.setProgress(per1);
            simpleProgressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.red)));
            severity.setText("High risk (" + per1 + " %)");
            severity.setTextColor(ContextCompat.getColor(activity,R.color.red));
        } else if(per1 >= 30.00 && per1 < 70.00){
            simpleProgressBar.setProgress(per1);
            simpleProgressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.almondz_policy)));
            severity.setText("Medium risk (" + per1 + " %)");
            severity.setTextColor(ContextCompat.getColor(activity,R.color.almondz_policy));
        } else {
            simpleProgressBar.setProgress(per1);
            simpleProgressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.green)));
            severity.setText("Low risk (" + per1 + " %)");
            severity.setTextColor(ContextCompat.getColor(activity,R.color.green));
        }

        linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SymptomConditionWebviewActivity.class);
                intent.putExtra("title", m.getname());
                intent.putExtra("URL", m.getname());
                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
