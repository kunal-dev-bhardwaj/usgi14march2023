package com.universalsompo.meta.metaapp.health.fragment.myissues.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.myissues.adapter.MyIssueAdapter;
import com.universalsompo.meta.metaapp.health.fragment.myissues.model.MyIssues;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class MyIssueList extends Fragment implements ResponseListener {
    private View v;
    private ListView issue_list;
    private TextView no_issue_to_track;
    private final ArrayList<MyIssues> data = new ArrayList<>();
    private MySharedPreference pref;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my_issues, container, false);
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        pref = new MySharedPreference(getActivity());
        init();
        return v;
    }

    private void init() {
        issue_list = v.findViewById(R.id.issue_list);
        no_issue_to_track = v.findViewById(R.id.no_issue_to_track);
        callApi();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("Mode", "Health");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_MY_ISSUE_LIST, this, RequestHealthConstants.GET_MY_ISSUE_LIST);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_MY_ISSUE_LIST){
            new AppDataPushApi().callApi(getActivity(),"My Issues","My issue list page","User checked for list of issues listed by him");
            if (object.optString("Message").equals("Success")){
                issue_list.setVisibility(View.VISIBLE);
                no_issue_to_track.setVisibility(View.GONE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("IssueLists");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new MyIssues(
                                        obj.optString("Category"),
                                        obj.optString("Comment"),
                                        obj.optString("IssueDate"),
                                        obj.optString("IssueID"),
                                        obj.optString("IssueStatus")
                                )
                        );
                    }
                    MyIssueAdapter myissueAdapter = new MyIssueAdapter(getActivity(), data);
                    issue_list.setAdapter(myissueAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                issue_list.setVisibility(View.GONE);
                no_issue_to_track.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
