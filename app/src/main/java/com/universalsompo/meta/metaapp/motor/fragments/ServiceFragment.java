package com.universalsompo.meta.metaapp.motor.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.intefaces.SelectorListener;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AlertDialogAddPolicy;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.NetworkUtils;
import java.util.Objects;

public class ServiceFragment extends Fragment implements View.OnClickListener {
    private View v;
    private SelectorListener binder;
    private MySharedPreference pref;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_service, container, false);
        ((InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(v.getWindowToken(), 0);
        ((MainActivity) getActivity()).show_elevation();
        pref = MySharedPreference.getInstance(getActivity());
        init();
        return v;
    }

    private void init() {
        LinearLayout service_appointment_btn = v.findViewById(R.id.service_appointment_btn);
        LinearLayout extended_warranty_btn = v.findViewById(R.id.extended_warranty_btn);
        LinearLayout spare_part_btn = v.findViewById(R.id.spare_part_btn);
        LinearLayout accessories_btn = v.findViewById(R.id.accessories_btn);
        LinearLayout preowned_btn = v.findViewById(R.id.preowned_btn);
        LinearLayout spare_car_btn = v.findViewById(R.id.spare_car_btn);
        LinearLayout driver_btn = v.findViewById(R.id.driver_btn);
        LinearLayout rsa_btn = v.findViewById(R.id.rsa_btn);

        service_appointment_btn.setOnClickListener(this);
        extended_warranty_btn.setOnClickListener(this);
        spare_part_btn.setOnClickListener(this);
        accessories_btn.setOnClickListener(this);
        preowned_btn.setOnClickListener(this);
        spare_car_btn.setOnClickListener(this);
        driver_btn.setOnClickListener(this);
        rsa_btn.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            binder = (SelectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    private void replaceFragment(Fragment frag, String Tag) {
        if (NetworkUtils.isConnected(getActivity())) {
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(getActivity(), frag, R.id.main_frame, Tag);
            binder.detect(Tag);
        } else {
            Toast.makeText(getActivity(), "You are not connected to internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        FragmentServiceItem fragmentServiceItem = new FragmentServiceItem();
        switch (v.getId()) {
            case R.id.extended_warranty_btn:
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User clicked on extended warranty");
                bundle.putString("item", "ExtendedWarraty");
                bundle.putString("frag_tag",FragmentsTags.TAG_WARRANTY_NAME);
                fragmentServiceItem.setArguments(bundle);
                replaceFragment(fragmentServiceItem, FragmentsTags.TAG_WARRANTY_NAME);
                break;

            case R.id.spare_part_btn:
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User clicked on spare parts");
                bundle.putString("item", "SpareParts");
                bundle.putString("frag_tag",FragmentsTags.SPARE_PARTS_NAME);
                fragmentServiceItem.setArguments(bundle);
                replaceFragment(fragmentServiceItem, FragmentsTags.SPARE_PARTS_NAME);
                break;

            case R.id.accessories_btn:
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User clicked on accessories");
                bundle.putString("item", "Acceriess");
                bundle.putString("frag_tag",FragmentsTags.PARTS_ACCESSORIES_NAME);
                fragmentServiceItem.setArguments(bundle);
                replaceFragment(fragmentServiceItem, FragmentsTags.PARTS_ACCESSORIES_NAME);
                break;

            case R.id.preowned_btn:
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User clicked on sell car");
                bundle.putString("item", "Preowned");
                bundle.putString("frag_tag",FragmentsTags.TAG_OWNED_CARS);
                fragmentServiceItem.setArguments(bundle);
                replaceFragment(fragmentServiceItem, FragmentsTags.TAG_OWNED_CARS);
                break;

            case R.id.spare_car_btn:
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User clicked on self drive");
                bundle.putString("item", "SpareCars");
                bundle.putString("frag_tag",FragmentsTags.SPARES_CAR);
                fragmentServiceItem.setArguments(bundle);
                replaceFragment(fragmentServiceItem, FragmentsTags.SPARES_CAR);
                break;

            case R.id.driver_btn:
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User clicked on book driver");
                bundle.putString("item", "BookDriver");
                bundle.putString("frag_tag",FragmentsTags.BOOK_DRIVER);
                fragmentServiceItem.setArguments(bundle);
                replaceFragment(fragmentServiceItem, FragmentsTags.BOOK_DRIVER);
                break;

            case R.id.service_appointment_btn:
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User clicked on service appointment");
                replaceFragment(new FragmnetServiceAppointment(), FragmentsTags.FRAGMENT_SERVICE_APPOINTMENT);
                break;

            case R.id.rsa_btn:
                new AppDataPushApi().callApi(getActivity(),"Services","Value add page","User clicked on roadside assistance");
                if (pref.getisUSGIUser().equals("1")) {
                    rsaDialog();
                } else {
                    AlertDialogAddPolicy addPolicy = new AlertDialogAddPolicy();
                    addPolicy.showAlertDialogForPolicy(getActivity(),"There is no policy added");
                }
                break;
        }
    }

    private void rsaDialog() {
        final Dialog dialog = new Dialog(Objects.requireNonNull(getContext()), R.style.CustomDialog);
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
            new AppDataPushApi().callApi(getActivity(),"Services","Roadside assistance dialog","User initiated a call for roadside assistance");
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "1800 209 6678"));
            startActivity(intent);
            dialog.dismiss();
        });
        dialog.show();
    }
}
