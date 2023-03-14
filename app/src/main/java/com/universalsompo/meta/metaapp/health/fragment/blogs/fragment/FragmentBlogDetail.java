package com.universalsompo.meta.metaapp.health.fragment.blogs.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.constants.RequestHealthConstants;
import com.universalsompo.meta.metaapp.health.constants.UrlHealthConstants;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class FragmentBlogDetail extends Fragment implements ResponseListener {
    private View v;
    private String blogid;
    private ImageView blog_image;
    private TextView blog_heading, blog_content;
    MySharedPreference pref;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_blog_detail, container, false);
        pref = MySharedPreference.getInstance(getActivity());
        ((MainActivityHealth) Objects.requireNonNull(getActivity())).hidenav();
        ((MainActivityHealth) getActivity()).hidefooter();
        ((MainActivityHealth) getActivity()).show_elevation();
        ((MainActivityHealth)getActivity()).changeTitle(FragmentsHealthTags.BLOGS);
        init();
        callApi();
        return v;
    }

    private void init() {
        blog_image = v.findViewById(R.id.blog_image);
        blog_heading = v.findViewById(R.id.blog_heading);
        blog_content = v.findViewById(R.id.blog_content);
        assert getArguments() != null;
        blogid = getArguments().getString("blog_id");
    }

    private void callApi(){
        JSONObject object = new JSONObject();
        try {
            object.put(RequestHealthConstants.TOKEN_NO_HEALTH,pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("BlogID", blogid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlHealthConstants.GET_BLOG_DETAIL, this, RequestHealthConstants.GET_BLOG_DETAIL);
        req.execute();
    }

    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestHealthConstants.GET_BLOG_DETAIL) {
            if (object.optString("Message").equals("Success")) {
                try {
                    String imgPath = object.optString("ImagePath");

                    /*if (imgPath.contains("AppCMS")){
                        String[] abc = imgPath.split("AppCMS");
                        imgPath = "http://mobile.universalsompo.in:50003/AppCMS" + abc[1];
                    }*/
                    blog_heading.setText(object.getString("Heading"));
                    new AppDataPushApi().callApi(getActivity(),"Blogs","Blog detail page","User came to read blog related to " + object.getString("Heading"));
                    blog_content.setText(Html.fromHtml(object.getString("Content")));
                    Picasso.get().load(imgPath).placeholder(R.drawable.loading).error(R.drawable.error).into(blog_image);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) { }
}
