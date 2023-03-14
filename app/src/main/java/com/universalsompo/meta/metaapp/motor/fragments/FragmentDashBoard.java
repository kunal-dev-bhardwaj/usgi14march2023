package com.universalsompo.meta.metaapp.motor.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.health.adapter.VideoAdapter;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.kotlinchat.ChatBot;
import com.universalsompo.meta.metaapp.kotlinchat.ChatFragment;
import com.universalsompo.meta.metaapp.motor.activities.BookDriver;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.activities.Policies_web_Browser;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.activities.Renewal_motor_policies;
import com.universalsompo.meta.metaapp.motor.activities.TravelInsurance;
import com.universalsompo.meta.metaapp.motor.activities.motor_policies.MotorPrivate;
import com.universalsompo.meta.metaapp.motor.activities.motor_renewal.RenewalFragment;
import com.universalsompo.meta.metaapp.motor.activities.motorclaim.ClaimIntimateWeb;
import com.universalsompo.meta.metaapp.motor.activities.policy_fragment.Motor_Private_car;
import com.universalsompo.meta.metaapp.motor.adapters.Article_Adapter;
import com.universalsompo.meta.metaapp.motor.adapters.ContentAdapter;
import com.universalsompo.meta.metaapp.motor.adapters.TipOfTheDayAdapter;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.intefaces.ChangeOptionIconInterface;
import com.universalsompo.meta.metaapp.intefaces.NnvigationUpdater;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.BlogDashboardModel;
import com.universalsompo.meta.metaapp.motor.models.ContentModel;
import com.universalsompo.meta.metaapp.motor.models.Dashboard_buy_policy_item;
import com.universalsompo.meta.metaapp.motor.models.MotorTipsModel;
import com.universalsompo.meta.metaapp.motor.models.SliderImageModel;
import com.universalsompo.meta.metaapp.motor.models.VideoDashboardModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy2;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FragmentDashBoard extends Fragment implements ResponseListener {
    private SelectorListener binder;
    private MySharedPreference pref;
    private ImageSlider image_slider;
    private LinearLayout rl_policy_btn;
    private LinearLayout rl_claim_btn;
    private LinearLayout rl_document_btn;
    private LinearLayout rl_service_btn;
    private LinearLayout claim_intimation;
    private LinearLayout rl_rsa_btn;
    private LinearLayout rl_buy_policy_btn;
    private NnvigationUpdater updator;
    private ChangeOptionIconInterface optionIconInterface;
    private Dialog dialog;
    private ArrayList<Dashboard_buy_policy_item> buy_policy_items = new ArrayList<>();
    private RecyclerView recyclerview_videos;
    private LinearLayout layout_content_section;
    private ArrayList<VideoDashboardModel> model_video_dashboard = new ArrayList<>();
    private ArrayList<BlogDashboardModel> model_blog_dashboard = new ArrayList<>();
    private LinearLayout layout_videos;
    private LinearLayout view_all_content;
    private RecyclerView listView;
    ArrayList<MotorTipsModel>modelList=new ArrayList<>();
    MotorTipsModel model;
    Article_Adapter adapter_;
   String data;
    FloatingActionButton openChatBot;
    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
            updator = (NnvigationUpdater) activity;
            optionIconInterface = (ChangeOptionIconInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_dashboard_new, container, false);
        ((InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(myView.getWindowToken(), 0);

        ((MainActivity) getActivity()).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        initViews(myView);
        initListeners();
//        showExtraNotificationData();
        return myView;
    }

//    private void showExtraNotificationData() {
//        Bundle bundle = getArguments();
//        if (bundle !=null&& bundle.containsKey("botId")){
//            data = getDataFromIntent();
//            showNotificationAlert(Objects.requireNonNull(getActivity()).getIntent().getExtras().getString("botId"));
//        }
//
//    }

//    private String getDataFromIntent() {
//        String data1=mut
//        return data;
//    }

//    private void showNotificationAlert(String botId) {
//    }

    private void initViews(View myView) {
        image_slider = myView.findViewById(R.id.image_slider);
        rl_buy_policy_btn = myView.findViewById(R.id.rl_buy_policy_btn);
        rl_policy_btn = myView.findViewById(R.id.rl_policy_btn);
        rl_claim_btn = myView.findViewById(R.id.rl_claim_btn);
        rl_document_btn = myView.findViewById(R.id.rl_document_btn);
        rl_service_btn = myView.findViewById(R.id.rl_service_btn);
        claim_intimation = myView.findViewById(R.id.claim_intimation);
        rl_rsa_btn = myView.findViewById(R.id.rl_rsa_btn);
        layout_content_section = myView.findViewById(R.id.layout_content_section);
        openChatBot = myView.findViewById(R.id.openChatBot);
        recyclerview_videos = myView.findViewById(R.id.recyclerview_videos);
        layout_videos = myView.findViewById(R.id.layout_videos);
        view_all_content = myView.findViewById(R.id.view_all_content);
        listView = myView.findViewById(R.id.tips_list);
        view_all_content.setOnClickListener(view -> replaceFragment(new FragmentVideosArticle(), FragmentsTags.video_article_fragment));

        callApi();
        hitblogs();
        hitarticle();
    }

    //kro
    private void callApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put(RequestConstants.USER_ID, pref.getUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.GET_SLIDER_IMAGE, this, RequestConstants.GET_SLIDER_IMAGE);
        req.execute();
    }
    private void hitblogs() {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", pref.getToken_no());
            object.put("Uid",pref.getUID());
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.GET_CONTENT, this, RequestConstants.GET_CONTENT);
        req.execute();
    }
    private void hitarticle() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put("CategoryId", "0");
            ProjectVolleyRequest2 req = new ProjectVolleyRequest2(getActivity(), object, UrlConstants.GET_RSS_FEED, this, RequestConstants.GET_RSS_FEED);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initListeners() {
        rl_buy_policy_btn.setOnClickListener(v -> {
            new AppDataPushApi().callApi(getActivity(), "Dashboard", "Buy Policy", "User clicked on buy policy button");
//            replaceFragment1(new Motor_Private_car(), FragmentsTags.Buy_POLICY_FRAGMENT);
//            callBuyApi();
            Intent intent = new Intent(getActivity(), MotorPrivate.class);
            intent.putExtra("strFor","0");
            intent.putExtra("strNewFor","0");
            intent.putExtra("CheckString","0");
            startActivity(intent);
        });

        rl_policy_btn.setOnClickListener(view -> replaceFragment(new FragmentPolicy(), FragmentsTags.POLICY_FRAGMENT));

        rl_claim_btn.setOnClickListener(view -> replaceFragment(new FragmentClaim(), FragmentsTags.CLAIM_FRAGMENT));

//        rl_document_btn.setOnClickListener(view -> replaceFragment(new FragmentDocuments(), FragmentsTags.DOCUMENTS_FRAGMENT));
        rl_document_btn.setOnClickListener(view ->replaceFragment(new RenewalFragment(), FragmentsTags.Renewal_Fragment));
//            Intent intent = new Intent(getActivity(), Renewal_motor_policies.class);
//            startActivity(intent);
//            Intent intent = new Intent(getActivity(), Policies_web_Browser.class);
//            startActivity(intent);
        openChatBot.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TravelInsurance.class);
            startActivity(intent);
        });
//        openChatBot.setOnClickListener(view ->replaceFragment(new ChatFragment(), FragmentsTags.Renewal_Fragment));

        rl_service_btn.setOnClickListener(view -> replaceFragment(new ServiceFragment(), FragmentsTags.SERVICE_FRAGMENT));
        claim_intimation.setOnClickListener(view ->{
            Intent intent = new Intent(getActivity(), ClaimIntimateWeb.class);
            startActivity(intent);
        });

        rl_rsa_btn.setOnClickListener(v -> {
//            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
//            boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
//            if(!previouslyStarted) {
//                SharedPreferences.Editor edit = prefs.edit();
//                edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
//                edit.commit();
//                Intent i = new Intent(getContext(), MainActivityHealth.class);
//                startActivity(i);
//
//            } else {
//                Intent i = new Intent(getContext(), MainActivityHealth.class);
//                startActivity(i);
//            }

//            if (pref.getisUSGIUser().equals("1")) {
//                rsaDialog();
//            } else {
//                AlertDialogAddPolicy2 addPolicy = new AlertDialogAddPolicy2();
//                addPolicy.showAlertDialogForPolicy(getActivity(),"There is no policy added");
//            }
        });
    }

    @Override
    public void onSuccess(final JSONObject object, int Tag) {
        if (Tag == RequestConstants.GET_SLIDER_IMAGE) {
            if (object.optString("Message").equals("Success")) {
                updator.updateNavigationNow();
                pref.setUserName(object.optString("Name"));
                pref.setMobile(object.optString("Mobile"));
                pref.setProfilePic(object.optString("UserImagePath"));
                pref.setEmailId(object.optString("Email"));
                pref.setNotifyUnreadCount(object.optString("notificationCount"));

                if (object.optString("IsRead").equals("False"))
                    optionIconInterface.changeIcon("false");
                else
                    optionIconInterface.changeIcon("true");
                JSONArray arr;
                try {
                    ArrayList<SliderImageModel> data = new ArrayList<>();
                    ArrayList<SlideModel> imagelist = new ArrayList<>();
                    arr = object.getJSONArray("SliderImageDetails");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        String imgPath = obj.optString("ImagePath");
                        data.add(new SliderImageModel(obj.optString("SliderId"), imgPath));
                        imagelist.add(new SlideModel(imgPath));
                    }
                    image_slider.setImageList(imagelist);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if (Tag == RequestConstants.BUY_POLICY_URL) {
            if (object.optString("Message").equals("Success")) {
                JSONArray arr;
                try {
                    arr = object.getJSONArray("ProductMappingList");
                    buy_policy_items.clear();
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject jsonObject = arr.getJSONObject(i);
                        buy_policy_items.add(new Dashboard_buy_policy_item(
                                        jsonObject.optString("Id"),
                                        jsonObject.optString("ProductName"),
                                        jsonObject.optString("ProductUrl"),
                                        jsonObject.optString("ThankPageUrl")
                                ));
                    }
                    final Dialog dialog = new Dialog(requireActivity(),R.style.CustomDialog);
                    dialog.setCanceledOnTouchOutside(true);
                    dialog.setCancelable(true);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                    dialog.setContentView(R.layout.buy_now_dialog);
                    TextView btn_two_wheeler = dialog.findViewById(R.id.btn_two_wheeler);
                    TextView btn_four_wheeler = dialog.findViewById(R.id.btn_four_wheeler);

                    btn_four_wheeler.setText(buy_policy_items.get(0).getProductName());
                    btn_two_wheeler.setText(buy_policy_items.get(1).getProductName());

                    btn_four_wheeler.setOnClickListener(v1 -> {
                        dialog.dismiss();
                        Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                        in.putExtra("PolicyNo", "");
                        in.putExtra("VehicleType", "");
                        in.putExtra("vendor_id", "");
                        in.putExtra("ISFROMPDFFULL", "");
                        if (pref.getisUSGIUser().equals("1")) {
                            in.putExtra("Url", buy_policy_items.get(0).getProductUrl() + pref.getMOBILE() + "&CustId=" + pref.getCustID());
                        } else {
                            in.putExtra("Url", buy_policy_items.get(0).getProductUrl() + pref.getMOBILE() + "&CustId=0");
                        }
                        in.putExtra("fargmentTag", "Buy Policy");
                        in.putExtra("type", buy_policy_items.get(0).getProductName());
                        requireActivity().startActivity(in);
                    });

                    btn_two_wheeler.setOnClickListener(v12 -> {
                        dialog.dismiss();
                        Intent in = new Intent(getActivity(), PolicyInBrowser.class);
                        in.putExtra("PolicyNo", "");
                        in.putExtra("VehicleType", "");
                        in.putExtra("vendor_id", "");
                        in.putExtra("ISFROMPDFFULL", "");
                        if (pref.getisUSGIUser().equals("1")) {
                            in.putExtra("Url", buy_policy_items.get(1).getProductUrl() + pref.getMOBILE() + "&CustId=" + pref.getCustID());
                        } else {
                            in.putExtra("Url", buy_policy_items.get(1).getProductUrl() + pref.getMOBILE() + "&CustId=0");
                        }
                        in.putExtra("fargmentTag", "Buy Policy");
                        in.putExtra("type", buy_policy_items.get(1).getProductName());
                        requireActivity().startActivity(in);
                    });
                    dialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if (Tag == RequestConstants.GET_CONTENT) {
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
                    recyclerview_videos.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));
                    recyclerview_videos.setHasFixedSize(true);
                    recyclerview_videos.setAdapter(content_adapter_);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(getContext(),object.optString("Message"), Toast.LENGTH_SHORT).show();
            }
        }

        else if (Tag == RequestConstants.GET_RSS_FEED) {
            new AppDataPushApi().callApi(getActivity(),"Tipss of day","Tips of day page","User visited to tips of day");
            if (!modelList.isEmpty()) {
                modelList.clear();
            }
            if (object.optString("Status").equals("false")) {
                listView.setVisibility(View.GONE);
            } else {
                listView.setVisibility(View.VISIBLE);
                try {
                    JSONArray jsonArray = object.getJSONArray("RssFeed");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        model = new MotorTipsModel(obj.optString("Category"), obj.optString("CategoryId"), obj.optString("ImagePath"), obj.optString("Links"), obj.optString("PubDate"), obj.optString("Title"));
                        modelList.add(model);
                    }
                    adapter_ = new Article_Adapter(getActivity(),modelList);
                    listView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));
                    listView.setHasFixedSize(true);
                    listView.setAdapter(adapter_);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void onError(VolleyError error, int Tag) {
    }

    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equalsIgnoreCase(FragmentsTags.POLICY_FRAGMENT)){
                Bundle args = new Bundle();
                args.putInt("otherFrag", 1);
                frag.setArguments(args);
            }
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
    private void replaceFragment1(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            if (Tag.equalsIgnoreCase(FragmentsTags.POLICY_FRAGMENT)){
                Bundle args = new Bundle();
                args.putInt("otherFrag", 1);
                args.putString("strFor", "0");
                frag.setArguments(args);
            }
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }
    private void rsaDialog() {
        dialog = new Dialog(requireContext(), R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.rsa_popup);
        TextView callrsa = dialog.findViewById(R.id.tvcallrsa);
        TextView cancel_rsa = dialog.findViewById(R.id.cancel_rsa);

        cancel_rsa.setOnClickListener(v -> dialog.dismiss());

        callrsa.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "1800 209 6678"));
            startActivity(intent);
            dialog.dismiss();
        });
        dialog.show();
    }

    private void callBuyApi() {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("Mode", "MOTOR");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProjectVolleyRequest req = new ProjectVolleyRequest(getActivity(), object, UrlConstants.BUY_POLICY_URL, this, RequestConstants.BUY_POLICY_URL);
        req.execute();
    }
}
