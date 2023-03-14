package com.universalsompo.meta.metaapp.motor.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.Objects;

public class FragmentCouponCodeMotor extends Fragment {
    private View v;
    private TextView coupon_code;
    private String vehtype;
    private String vendname;
    private String vendid;
    private String titl;
    private String url;
    private String dom;
    private String coupcod;
    private String dis;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_coupon_code_motor, container, false);
        assert getArguments() != null;
        vehtype= getArguments().getString("VehicleType");
        vendname= getArguments().getString("vendor_name");
        vendid= getArguments().getString("vendor_id");
        titl= getArguments().getString("title");
        url= getArguments().getString("URL");
        dom= getArguments().getString("domain");
        coupcod= getArguments().getString("Coupancode");
        dis= getArguments().getString("discount");
        new AppDataPushApi().callApi(getActivity(),"Marketplace","Coupon Code","Checked for " + vendname + " coupon code");
        init();
        return v;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        Button copy_code = v.findViewById(R.id.copy_code);
        coupon_code = v.findViewById(R.id.coupon_code);
        TextView dis_heading = v.findViewById(R.id.dis_heading);
        TextView dis_tag = v.findViewById(R.id.dis_tag);
        dis_heading.setText("Please use the below code to avail the discount* on " + vendname);
        dis_tag.setText(dis);
        coupon_code.setText(coupcod);

        copy_code.setOnClickListener(v -> {
            setClipboard(Objects.requireNonNull(getActivity()), coupon_code.getText().toString());
            appInBrowser();
        });
    }

    private void appInBrowser()
    {
        Intent intent = new Intent(getActivity(), BookDriver.class);
        intent.putExtra("title", titl);
        intent.putExtra("URL", url);
        intent.putExtra("domain", dom);
        intent.putExtra("name", vendname);
        intent.putExtra("VendorId",vendid);
        intent.putExtra("VehicleType", vehtype);
        startActivity(intent);
        FragmentsTransactionsUtils.popFragment(getActivity());
        MainActivity mainActivity=(MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.getPreviousFragmnet();
    }

    private void setClipboard(Context context, String text) {
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getActivity(), "Successfully copied", Toast.LENGTH_SHORT).show();
    }
}
