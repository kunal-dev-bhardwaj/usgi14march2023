package com.universalsompo.meta.metaapp.health.fragment.myissues.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.myissues.adapter.MyIssueDetailAdapter;
import com.universalsompo.meta.metaapp.health.fragment.myissues.model.MyIssuesStatus;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentMyIssueDetails extends Fragment implements ResponseListener {
    private View v;
    private String issue_id, cat1, desc1;
    private MySharedPreference pref;
    private ListView listview_status;
    private final ArrayList<MyIssuesStatus> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_my_issue_detail, container, false);
        pref = new MySharedPreference(Objects.requireNonNull(getActivity()));
        assert getArguments() != null;
        issue_id = getArguments().getString("issue_id");
        cat1 = getArguments().getString("cat");
        desc1 = getArguments().getString("desc");
        init();
        return v;
    }

    private void init() {
        TextView category_name = v.findViewById(R.id.category_name);
        TextView description = v.findViewById(R.id.description);
        category_name.setText(cat1);
        description.setText(desc1);
        listview_status = v.findViewById(R.id.listview_status);
        callApi();
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH, pref.getToken_no());
            object.put("UserID", pref.getUID());
            object.put("IssueID", issue_id);
            object.put("Mode", "Health");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_MY_ISSUE_DETAIL, this, RequestHealthConstants.GET_MY_ISSUE_DETAIL);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_MY_ISSUE_DETAIL){
            new AppDataPushApi().callApi(getActivity(),"My Issue","My issue detail page","User checked details of issue id " + issue_id);
            if (object.optString("Message").equals("Success")){
                listview_status.setVisibility(View.VISIBLE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("IssueDetailsLists");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new MyIssuesStatus(
                                        obj.optString("Comment"),
                                        obj.optString("IssueCommentDate"),
                                        obj.optString("IssueStatus")
                                )
                        );
                    }
                    MyIssueDetailAdapter myissueAdapter = new MyIssueDetailAdapter(getActivity(), data);
                    listview_status.setAdapter(myissueAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                listview_status.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
