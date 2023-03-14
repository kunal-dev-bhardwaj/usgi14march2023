package com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.model.FamilyModel1;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.List;

public class FamilyAdapter1 extends BaseAdapter {
    private Activity activity;
    private List<FamilyModel1> familyModelList;
    private MySharedPreference prefrences;
    Fragment fragment;
    private LayoutInflater inflater;
    private TextView family_member_name;
    private TextView family_member_mobile;
    private CheckBox chk_family_member;
    private int selectedPosition = -1;

    public FamilyAdapter1(Activity activity, List<FamilyModel1> familyModelList) {
        this.activity = activity;
        this.familyModelList = familyModelList;
    }

    @Override
    public int getCount() {
        return familyModelList.size();
    }

    @Override
    public Object getItem(int location) {
        return familyModelList.get(location);
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
            convertView = inflater.inflate(R.layout.family_info_list_item1, null);

        prefrences = MySharedPreference.getInstance(activity);
        family_member_name = convertView.findViewById(R.id.family_member_name);
        family_member_mobile = convertView.findViewById(R.id.family_member_mobile);
        chk_family_member = convertView.findViewById(R.id.chk_family_member);

        final FamilyModel1 m = familyModelList.get(position);

        family_member_name.setText(m.getFamilyName());
        family_member_mobile.setText(m.getMobileNo());

        chk_family_member.setTag(position);
        if (position == selectedPosition) {
            chk_family_member.setChecked(true);
            // Log.d("Selected checkbox", m.getFamilyName() + " " + m.getMobileNo());
            Toast.makeText(activity, "Name "+m.getFamilyName()+" mobile " +m.getMobileNo(), Toast.LENGTH_SHORT).show();
        } else {
            chk_family_member.setChecked(false);
        }

        chk_family_member.setOnClickListener(onStateChangedListener(chk_family_member, position));

        return convertView;
    }

    private View.OnClickListener onStateChangedListener(final CheckBox checkBox, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    selectedPosition = position;
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                    sendIntent.setType("text/plain");
                    activity.startActivity(sendIntent);
                } else {
                    selectedPosition = -1;
                }
                notifyDataSetChanged();
            }
        };
    }
}
