package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.PolicyDetailModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.google.gson.Gson;

import java.util.Objects;
import java.util.StringTokenizer;

public class FragmentTabPolicy extends Fragment implements View.OnClickListener {
    private View v;
    private MySharedPreference prefrences;
    private TextView edt_booked_insurer_com_name;
    private TextView booked_policy_no;
    private TextView edt_booked_policy_type;
    private TextView edt_booked_last_prm_amt;
    private TextView edt_booked_idv_value;
    private TextView edt_booked_fullname;
    private TextView edt_booked_mobile;
    private TextView edt_booked_email_add;
    private TextView edt_booked_start_date;
    private TextView edt_booked_expiry_date;
    private TextView test;
    private RelativeLayout expand_detail;
    private LinearLayout llCoverageDetail;
    private LinearLayout llCoverageParent;
    private ImageView expand_icon;
    private ScrollView scrollview;
    private LinearLayout addons_expandableLayout;
    private LinearLayout add_on_heading_llayout;
    private ImageView addons_expand_img;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_policy_tab, container, false);
        prefrences = MySharedPreference.getInstance(getActivity());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen._10sdp), 1);
        lp.setMargins(0, 0, 0, 0);
        initView();
        return v;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        edt_booked_insurer_com_name = v.findViewById(R.id.edt_booked_insurer_com_name);
        booked_policy_no = v.findViewById(R.id.booked_policy_no);
        edt_booked_policy_type = v.findViewById(R.id.edt_booked_policy_type);
        edt_booked_last_prm_amt = v.findViewById(R.id.edt_booked_last_prm_amt);
        edt_booked_idv_value = v.findViewById(R.id.edt_booked_idv_value);
        edt_booked_fullname = v.findViewById(R.id.edt_booked_fullname);
        edt_booked_mobile = v.findViewById(R.id.edt_booked_mobile);
        edt_booked_email_add = v.findViewById(R.id.edt_booked_email_add);
        edt_booked_start_date = v.findViewById(R.id.edt_booked_start_date);
        edt_booked_expiry_date = v.findViewById(R.id.edt_booked_expiry_date);
        test = v.findViewById(R.id.textt);
        expand_detail = v.findViewById(R.id.expand_detail);
        llCoverageDetail = v.findViewById(R.id.llCoverageDetail);
        llCoverageParent= v.findViewById(R.id.llCoverageParent);
        scrollview = v.findViewById(R.id.scrollV_policy_view);
        expand_icon = v.findViewById(R.id.expand_icon);
        SeekBar seek = v.findViewById(R.id.seek);
        seek.setPadding((int) getResources().getDimension(R.dimen._5sdp), (int) getResources().getDimension(R.dimen._5sdp), (int) getResources().getDimension(R.dimen._5sdp), (int) getResources().getDimension(R.dimen._5sdp));
        seek.setOnTouchListener((v, event) -> true);

        addons_expandableLayout = v.findViewById(R.id.addons_expandableLayout);
        add_on_heading_llayout = v.findViewById(R.id.add_on_heading_llayout);
        RelativeLayout add_ons_rlayout = v.findViewById(R.id.add_ons_rlayout);
        addons_expand_img = v.findViewById(R.id.addons_expand_img);
        add_on_heading_llayout.setOnClickListener(this);
        add_ons_rlayout.setVisibility(View.GONE);
        initializeData();
    }

    @SuppressLint("SetTextI18n")
    private void initializeData() {
        PolicyDetailModel data = new Gson().fromJson(prefrences.getRenewalPolicyDetail(), PolicyDetailModel.class);
        if (data.getPolicyNo() != null)
            booked_policy_no.setText(data.getPolicyNo());
        if (data.getPolicyHolderName() != null)
            edt_booked_fullname.setText("" + data.getPolicyHolderName());
        if (data.getMobileNo() != null)
            edt_booked_mobile.setText("" + data.getMobileNo());
        if (data.getEmailID() != null)
            edt_booked_email_add.setText("" + data.getEmailID());
        if (data.getIDV() != null)
            edt_booked_idv_value.setText("" + data.getIDV());
        if (data.getPremium() != null)
            edt_booked_last_prm_amt.setText("" + data.getPremium());
        if (data.getPolicyType() != null)
            edt_booked_policy_type.setText("" + data.getPolicyType());
        if (data.getInsurerName() != null)
            edt_booked_insurer_com_name.setText("" + data.getInsurerName());
        if (data.getPolicyStartDate() != null)
            edt_booked_start_date.setText("" + data.getPolicyStartDate());
        if (data.getPolicyEndDate() != null)
            edt_booked_expiry_date.setText("" + data.getPolicyEndDate());
        if (data.getCoverages() != null) {
            String coverages = data.getCoverages();
            StringTokenizer tokenizer = new StringTokenizer(coverages, ",");
            while (tokenizer.hasMoreTokens()) {
                test.append("\u25CF" + " " + tokenizer.nextToken());
                test.append("\n");
            }
            llCoverageParent.setVisibility(View.VISIBLE);
        }

        expand_detail.setOnClickListener(v -> {
            if (llCoverageDetail.getVisibility() == View.VISIBLE) {
                expand_icon.setBackgroundResource(R.drawable.drop_down2);
                expand_detail.setBackgroundResource(R.drawable.rounded_darker_grey);
                llCoverageDetail.setVisibility(View.GONE);
                test.setVisibility(View.GONE);
            } else {
                expand_detail.setBackgroundResource(R.drawable.top_rounded);
                expand_icon.setBackgroundResource(R.drawable.drop_down3);
                llCoverageDetail.setVisibility(View.VISIBLE);
                test.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_on_heading_llayout) {
            expandableImage();
        }
    }

    private void expandableImage() {
        if (addons_expandableLayout.isShown()) {
            add_on_heading_llayout.setBackgroundResource(R.drawable.rounded_darker_grey);
            addons_expand_img.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.drop_down2));
            addons_expandableLayout.setVisibility(View.GONE);
        } else {
            add_on_heading_llayout.setBackgroundResource(R.drawable.top_rounded);
            addons_expand_img.setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.drop_down3));
            addons_expandableLayout.setVisibility(View.VISIBLE);
            scrollview.post(() -> scrollview.scrollTo(0, scrollview.getBottom() *2));
        }
    }
}
