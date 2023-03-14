package com.universalsompo.meta.metaapp.motor.fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONObject;

import java.util.Objects;

public class FragmentAboutUs extends Fragment implements ResponseListener {
    private TextView txt_about_us;
    private TextView no_data_txt;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about_us, container, false);
        String s = Objects.requireNonNull(getActivity()).getClass().getSimpleName();
        if(s.equalsIgnoreCase("MainActivity")) {
            ((MainActivity) getActivity()).show_elevation();
        } else {
            ((MainActivityHealth) getActivity()).show_elevation();
        }
        txt_about_us = v.findViewById(R.id.txt_about_us);
        Typeface fontStyle = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Montserrat-Regular.ttf");
        txt_about_us.setTypeface(fontStyle);
        no_data_txt= v.findViewById(R.id.no_data);
        callApi();
        return v;
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
            object.put("ContentType", "AboutUs");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.ABOUT_US, this, RequestConstants.ABOUT_US);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.ABOUT_US) {
            String data = object.optString("ContentText");
            if (!data.equals("")) {
                no_data_txt.setVisibility(View.GONE);
                Spanned result;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    result = Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY);
                } else {
                    result = Html.fromHtml(data);
                }
                txt_about_us.setText(result);
                new AppDataPushApi().callApi(getActivity(),"About Us","About Us","Checked about us");
            } else {
                no_data_txt.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
    }
}
