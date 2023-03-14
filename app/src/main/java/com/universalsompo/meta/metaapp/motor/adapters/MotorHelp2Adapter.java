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

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMotorHelp3;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMotorHelp4;
import com.universalsompo.meta.metaapp.motor.models.MotorHelp;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONObject;

import java.util.List;

public class MotorHelp2Adapter extends BaseAdapter implements ResponseListener {
    private Activity activity;
    private LayoutInflater inflater;
    private List<MotorHelp> help_list;
    private String id_category;
    private String name_category;
    private String id_help1, id_help2;

    public MotorHelp2Adapter(Activity activity, List<MotorHelp> help, String id_help1, String id_help2) {
        this.activity = activity;
        this.help_list = help;
        this.id_help1 = id_help1;
        this.id_help2 = id_help2;
    }

    @Override
    public int getCount() {
        return help_list.size();
    }

    @Override
    public Object getItem(int i) {
        return help_list.get(i);
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
            view = inflater.inflate(R.layout.help_list_layout, viewGroup, false);

        final TextView name = view.findViewById(R.id.name);
        final LinearLayout category_selected = view.findViewById(R.id.category_selected);

        final MotorHelp m = help_list.get(i);

        name.setText(m.getCategoryName());

        category_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_category = m.getID();
                name_category = m.getCategoryName();
                callApi(m.getID());
            }
        });
        return view;
    }

    private void callApi(String mId) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(activity).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(activity).getUID());
            object.put("CategoryID", mId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlConstants.GET_HELP3, this, RequestConstants.GET_HELP3);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_HELP3) {
            if (object.optString("Message").equals("Success")) {
                Fragment frag = new FragmentMotorHelp3();
                Bundle args = new Bundle();
                args.putString("name", name_category);
                args.putString("id_help1", id_help1);
                args.putString("id_help2", id_help2);
                args.putString("id_help3", id_category);
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame, FragmentsTags.FRAGMENT_MOTOR_HELP);
            } else {
                Fragment frag = new FragmentMotorHelp4();
                Bundle args = new Bundle();
                args.putString("name", name_category);
                args.putString("id_help1", id_help1);
                args.putString("id_help2", id_help2);
                args.putString("id_help3", id_category);
                args.putString("id_help4", "");
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame, FragmentsTags.FRAGMENT_MOTOR_HELP);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
