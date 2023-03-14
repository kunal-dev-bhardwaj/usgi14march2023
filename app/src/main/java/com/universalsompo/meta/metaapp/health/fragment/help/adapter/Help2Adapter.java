package com.universalsompo.meta.metaapp.health.fragment.help.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.help.fragment.FragmentHelp3;
import com.universalsompo.meta.metaapp.health.fragment.help.fragment.FragmentHelp4;
import com.universalsompo.meta.metaapp.health.fragment.help.model.Help;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import org.json.JSONObject;

import java.util.List;

public class Help2Adapter extends BaseAdapter implements ResponseListener {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Help> help_list;
    private String id_help1, id_help2;
    private String id_category;
    private String name_category;

    public Help2Adapter(Activity activity, List<Help> help, String Id_help, String Id_help1) {
        this.activity = activity;
        this.help_list = help;
        this.id_help1 = Id_help;
        this.id_help2 = Id_help1;
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

        final TextView name =  view.findViewById(R.id.name);
        final LinearLayout category_selected =  view.findViewById(R.id.category_selected);

        final Help m = help_list.get(i);

        name.setText(m.getCategoryName());

        category_selected.setOnClickListener(view1 -> {
            id_category = m.getID();
            name_category = m.getCategoryName();
            callApi(m.getID());
        });
        return view;
    }


    private void callApi(String mId) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, MySharedPreference.getInstance(activity).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(activity).getUID());
            object.put("CategoryID", mId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(activity, object, UrlHealthConstants.GET_HELP3, this, RequestHealthConstants.GET_HELP3);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_HELP3) {
            if (object.optString("Message").equals("Success")) {
                Fragment frag = new FragmentHelp3();
                Bundle args = new Bundle();
                args.putString("name", name_category);
                args.putString("id_help1", id_help1);
                args.putString("id_help2", id_help1);
                args.putString("id_help3", id_category);
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HELP);
            } else {
               /* select_issue1.setVisibility(View.GONE);
                no_data.setVisibility(View.VISIBLE);*/
                Fragment frag = new FragmentHelp4();
                Bundle args = new Bundle();
                args.putString("name", name_category);
                args.putString("id_help1", id_help1);
                args.putString("id_help2", id_help2);
                args.putString("id_help3", id_category);
                args.putString("id_help4", "");
                frag.setArguments(args);
                FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HELP);
            }
        }

    }

    @Override
    public void onError(VolleyError error, int Tag) {


    }
}