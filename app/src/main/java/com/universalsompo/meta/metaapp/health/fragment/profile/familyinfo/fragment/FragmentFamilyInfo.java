package com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.health.fragment.mypolicyUSGI.model.MyHealthPolicyModel;
import com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.adapter.FamilyAdapter;
import com.universalsompo.meta.metaapp.health.fragment.profile.familyinfo.model.FamilyModel;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentFamilyInfo extends Fragment implements ResponseListener {
    private View myView;
    private SelectorListener binder;
    private ListView list;
    private TextView no_data;
    private Menu menuGroup;
    MenuItem inviteMenuItem;
    private FamilyAdapter familyAdapter;
    ArrayList<FamilyModel> data = new ArrayList<>();
    private MySharedPreference prefrences;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_family_info, container, false);
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);
        ((MainActivityHealth) getActivity()).show_elevation();
        prefrences = MySharedPreference.getInstance(getActivity());
        init();
        return myView;
    }

    private void init(){
        list = myView.findViewById(R.id.list);
        no_data= myView.findViewById(R.id.no_data);
        
        getfamilydetails();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_family, menu);
        menuGroup = menu;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.invite_family_menu).setVisible(true);
        super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.invite_family_menu:
                replaceFragment(new FragmentInvite(), FragmentsHealthTags.FRAGMENT_INVITE);
                /* To open sharing apps list */
                /*Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);*/
                return true;
        }
        return false;
    }

    public void getfamilydetails() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("UserID", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlHealthConstants.UNIVERSAL_HEALTH_POLICY, this, RequestHealthConstants.UNIVERSAL_HEALTH_POLICY);
        req.execute();
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (object.optString("Message").equals("Success")){
            if (Tag == RequestHealthConstants.GET_FAMILY_DETAILS) {
                // setHasOptionsMenu(true);
                list.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.GONE);
                JSONArray arr;
                if (!data.isEmpty())
                    data.clear();
                try {
                    arr = object.getJSONArray("FamilyDetails");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        data.add(
                                new FamilyModel(
                                        obj.optString("Age"),
                                        obj.optString("FamilyName"),
                                        obj.optString("MobileNo"),
                                        obj.optString("Relationship"),
                                        obj.optString("UserFamilyId")
                                )
                        );
                    }
                    familyAdapter = new FamilyAdapter(getActivity(), data);
                    list.setAdapter(familyAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            list.setVisibility(View.GONE);
            no_data.setText(object.optString("Message"));
            no_data.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }

    void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame1, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
