package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.MyIssuesMotorStatus;

import java.util.ArrayList;

public class MyIssueMotorDetailAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MyIssuesMotorStatus> arrayListModel;

    public MyIssueMotorDetailAdapter(Context context, ArrayList<MyIssuesMotorStatus> arrayListModel) {
        this.context = context;
        this.arrayListModel=arrayListModel;
    }

    @Override
    public int getCount() {
        return arrayListModel.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        TextView txt_date,txt_status;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null)
        {vh=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.fragment_tracking_issue_motor_status,null);
            vh.txt_date= convertView.findViewById(R.id.txt_date);
            vh.txt_status= convertView.findViewById(R.id.txt_status);
            convertView.setTag(vh);
        }
        else
            vh= (ViewHolder) convertView.getTag();

        vh.txt_status.setText(arrayListModel.get(position).getComment());
        vh.txt_date.setText(arrayListModel.get(position).getIssueCommentDate());

        return convertView;
    }
}
