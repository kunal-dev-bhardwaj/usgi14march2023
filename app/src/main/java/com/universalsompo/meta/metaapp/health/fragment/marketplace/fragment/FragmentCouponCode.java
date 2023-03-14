package com.universalsompo.meta.metaapp.health.fragment.marketplace.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import java.util.Objects;

public class FragmentCouponCode extends Fragment {
    private View v;
    private TextView coupon_code;
    private String id;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_coupon_code, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        new AppDataPushApi().callApi(getActivity(),"Coupon code","Coupon code page","User landed on coupon code page");
        assert getArguments() != null;
        id = getArguments().getString("id");
        init();
        return v;
    }

    private void init() {
        Button copy_code = v.findViewById(R.id.copy_code);
        coupon_code = v.findViewById(R.id.coupon_code);
        copy_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AppDataPushApi().callApi(getActivity(),"Coupon code","Coupon code page","User copied coupon code of 1mg for lab test");
                setClipboard(getActivity(), coupon_code.getText().toString());
                Intent intent = new Intent(getActivity(), BookDriver.class);
                intent.putExtra("title", "Lab Test");
                intent.putExtra("URL", "https://www.1mg.com/labs?utm_source=1mg&utm_medium=jewel&utm_campaign=labsgrowth");
                intent.putExtra("domain", "1mg.com");
                intent.putExtra("name", "1mg");
                intent.putExtra("VendorId", id);
                intent.putExtra("VehicleType", "Lab Test");
                startActivity(intent);
            }
        });
    }

    private void setClipboard(Context context, String text) {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
            Toast.makeText(getActivity(), "Successfully copied", Toast.LENGTH_SHORT).show();
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getActivity(), "Successfully copied", Toast.LENGTH_SHORT).show();
        }
    }
}
