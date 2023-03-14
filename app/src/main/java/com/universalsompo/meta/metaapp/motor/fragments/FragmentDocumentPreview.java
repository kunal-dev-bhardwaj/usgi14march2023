package com.universalsompo.meta.metaapp.motor.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.DocumentZoomingActivity;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.adapters.DocumentPreviewAdapter;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.NoDocInterface;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.DocumentModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.android.volley.VolleyError;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentDocumentPreview extends Fragment implements ResponseListener, AdapterView.OnItemLongClickListener,
        AdapterView.OnItemClickListener, View.OnKeyListener, NoDocInterface {
    private View v;

    private GridView grid_doc;
    private LinearLayout grid_llayout;
    private TextView no_data;
    private ArrayList<DocumentModel> modelList;
    private DocumentPreviewAdapter previewAdapter;
    private LayoutAnimationController controller;
    private Activity a;
    private int checkAnimationFlag = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_document_preview, container, false);
        init();
        callApi();
        backPressedAction();
        return v;
    }

    private void init() {
        no_data = v.findViewById(R.id.no_data);
        grid_doc = v.findViewById(R.id.grdv_document);
        grid_llayout= v.findViewById(R.id.grid_llayout);
        modelList = new ArrayList<>();
        grid_doc.setOnItemLongClickListener(this);
        grid_doc.setOnItemClickListener(this);
        v.setOnKeyListener(this);
        Animation animation = AnimationUtils.loadAnimation(a, R.anim.shake);
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(animation);
        controller = new LayoutAnimationController(set, 0.5f);
    }

    private void backPressedAction() {
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (MainActivity.menu.getVisibility() != View.VISIBLE && MainActivity.locator.getVisibility() != View.VISIBLE && MainActivity.bebefits.getVisibility() != View.VISIBLE && MainActivity.tips_dialog.getVisibility() != View.VISIBLE) {
                    if (checkAnimationFlag == 1) {
                        grid_doc.clearAnimation();
                        grid_doc.setLayoutAnimation(new LayoutAnimationController(new AnimationSet(false)));
                        previewAdapter.updateView(2);
                        ((DocumentPreviewAdapter) grid_doc.getAdapter()).notifyDataSetChanged();
                        checkAnimationFlag = 0;
                        return true;
                    } else
                        return false;
                } else {
                    return false;
                }
            }
            return false;
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            a = (Activity) context;
        }
    }

    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(a).getToken_no());
            object.put(RequestConstants.USER_ID, MySharedPreference.getInstance(a).getUID());
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(a, object, UrlConstants.DOCUMENT_IMG_PREVIEW, this, RequestConstants.DOCUMENT_IMG_PREVIEW);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        new AppDataPushApi().callApi(getActivity(),"KYC Docs","Preview page","Checked for all KYC docs uploaded");
        if (object.optString("Message").equals("Success")) {
            if (Tag == RequestConstants.DOCUMENT_IMG_PREVIEW) {
                try {
                    JSONArray jsonArray = object.getJSONArray("ELocker");
                    JSONObject jsonObject;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        DocumentModel documentModel;
                        if (jsonObject.getString("DocCategory").equalsIgnoreCase("Vehicle Reg"))
                            documentModel = new DocumentModel(jsonObject.getString("ELockerId"), jsonObject.getString("RegNo"), jsonObject.getString("FilePath"), null,jsonObject.getString("DocCategory"));
                        else if (jsonObject.getString("DocCategory").equalsIgnoreCase("Pollution Doc"))
                            documentModel = new DocumentModel(jsonObject.getString("ELockerId"), jsonObject.getString("RegNo"), jsonObject.getString("FilePath"), jsonObject.getString("DocExpiryDate"),jsonObject.getString("DocCategory"));
                        else
                            documentModel = new DocumentModel(jsonObject.getString("ELockerId"), jsonObject.getString("DocCategory"), jsonObject.getString("FilePath"), null,jsonObject.getString("DocCategory"));
                        modelList.add(documentModel);
                    }
                    previewAdapter = new DocumentPreviewAdapter(a, modelList, this);
                    grid_doc.setAdapter(previewAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!grid_llayout.isShown()) {
                    grid_llayout.setVisibility(View.VISIBLE);
                    no_data.setVisibility(View.GONE);
                }
            }
        } else {
            if (!no_data.isShown()) {
                no_data.setVisibility(View.VISIBLE);
                grid_llayout.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        Toast.makeText(a, error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        previewAdapter.updateView(1);
        grid_doc.setLayoutAnimation(controller);
        previewAdapter.notifyDataSetChanged();

        if (modelList.size() > 0)
            checkAnimationFlag = 1;
        grid_doc.setClickable(false);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (checkAnimationFlag == 0) {
            Intent i = new Intent(a, DocumentZoomingActivity.class);
            i.putExtra("IMG URL", modelList.get(position).getDoc_img_url());
            startActivity(i);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                grid_doc.clearAnimation();
                grid_doc.setLayoutAnimation(new LayoutAnimationController(new AnimationSet(false)));
                previewAdapter.updateView(2);
                ((DocumentPreviewAdapter) grid_doc.getAdapter()).notifyDataSetChanged();
                return true;
            }
            return false;
        }
    }
    @Override
    public void no_data(String status) {
        if (status.equals("0")) {
            no_data.setVisibility(View.VISIBLE);
            if (grid_llayout.isShown())
                grid_llayout.setVisibility(View.GONE);
            checkAnimationFlag = 0;
        }
    }
}

