package com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.Objects;

public class FragmentContactPolicy extends Fragment {
    private View v;
    private MySharedPreference prefrences;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_health_contact_tab, container, false);
        prefrences = MySharedPreference.getInstance(getActivity());
        initView();
        return v;
    }

    private void initView() {
        TextView email_address = v.findViewById(R.id.email_address);
        TextView contact_number = v.findViewById(R.id.contact_number);
        Button call = v.findViewById(R.id.call);

        email_address.setText(prefrences.getHealthClaimEmail());
        contact_number.setText(prefrences.getHealthClaimNumber());

        call.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + prefrences.getHealthClaimNumber()));
            Objects.requireNonNull(getActivity()).startActivity(intent);
        });
    }
}
