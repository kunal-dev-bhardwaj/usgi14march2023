package com.universalsompo.meta.metaapp.motor.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.adapter.VideoAdapter;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.adapters.Video_fragment_Adapter;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.BlogDashboardModel;
import com.universalsompo.meta.metaapp.motor.models.ContentModel;
import com.universalsompo.meta.metaapp.motor.models.VideoDashboardModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentVideosArticle extends Fragment implements ResponseListener {
    private RecyclerView recyclerview_videos;
    private LinearLayout layout_content_section;
    private ArrayList<VideoDashboardModel> model_video_dashboard = new ArrayList<>();
    private ArrayList<BlogDashboardModel> model_blog_dashboard = new ArrayList<>();
    private LinearLayout layout_videos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_videos_article, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).remove_elevation();
        layout_content_section = view.findViewById(R.id.layout_content_section);
        recyclerview_videos = view.findViewById(R.id.recyclerview_videos);
        layout_videos = view.findViewById(R.id.layout_videos);
        hitblogs();

        return view;
    }
    private void hitblogs() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", MySharedPreference.getInstance(getActivity()).getToken_no());
            object.put("Uid", MySharedPreference.getInstance(getActivity()).getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.GET_CONTENT, this, RequestConstants.GET_CONTENT);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_CONTENT) {
            new AppDataPushApi().callApi(getActivity(),"Content","Video section","Checked for uploaded youtub videos");
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("VideoContentDetails");
                    LogUtils.showLog("content", "array size" + arr);
                    final ArrayList<ContentModel> data = new ArrayList<>();
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);

                        String imgPath = obj.optString("ThumbnailPath");
                        /*if (imgPath.contains("AppCMS")){
                            String[] abc = imgPath.split("AppCMS");
                            imgPath = "http://mobile.universalsompo.in/AppCMS" + abc[1];
                        }*/

                        data.add(
                                new ContentModel(
                                        imgPath,
                                        obj.optString("Title"),
                                        obj.optString("UploadedDate"),
                                        obj.optString("Description"),
                                        obj.optString("URL")
                                )
                        );

                    }
                    VideoAdapter content_adapter_ = new VideoAdapter(data, this.getLifecycle());
                    Video_fragment_Adapter myvideoAdapter = new Video_fragment_Adapter(data, this.getLifecycle());
                    recyclerview_videos.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
                    recyclerview_videos.setHasFixedSize(true);
                    recyclerview_videos.setAdapter(myvideoAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(getContext(),object.optString("Message"), Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onError(VolleyError error, int Tag) {

    }
}