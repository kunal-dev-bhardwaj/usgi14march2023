package com.universalsompo.meta.metaapp.motor.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.TrackingStatusModel1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TrackingStatusListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TrackingStatusModel1> arrayListModel;

    public TrackingStatusListAdapter(Context context, ArrayList<TrackingStatusModel1> arrayListModel) {
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
        TextView txt_date, txt_status;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null)
        {vh=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.fragment_tracking_status_list_items,null);
            vh.txt_date= convertView.findViewById(R.id.txt_date);
            vh.txt_status= convertView.findViewById(R.id.txt_status);
            convertView.setTag(vh);
        }
        else
            vh= (ViewHolder) convertView.getTag();

        vh.txt_status.setText(arrayListModel.get(position).getStatus());
        vh.txt_date.setText(parseDateToddMMyyyy(arrayListModel.get(position).getDate()));
        return convertView;
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "dd/MM/yyyy hh:mm:ss";
        String outputPattern = "dd MMM yyyy hh:mm:ss";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
