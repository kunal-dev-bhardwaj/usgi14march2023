package com.universalsompo.meta.metaapp.motor.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Filterable;

import com.android.volley.VolleyError;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.intefaces.Interface3;
import com.universalsompo.meta.metaapp.intefaces.PolicyBackPressCallback;
import com.universalsompo.meta.metaapp.intefaces.PressNonBackPress;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest2;
import com.universalsompo.meta.metaapp.intefaces.RenewalDialogCallback;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.activities.PolicyInBrowser;
import com.universalsompo.meta.metaapp.motor.constants.Constants;
import com.universalsompo.meta.metaapp.motor.constants.FragmentsTags;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentClaimDetail;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentMetaOwnPolicyDetail;
import com.universalsompo.meta.metaapp.motor.fragments.FragmentPolicy;
import com.universalsompo.meta.metaapp.motor.fragments.mypolicytab.NonExpired;
import com.universalsompo.meta.metaapp.motor.models.MyPolicyModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;
import com.universalsompo.meta.metaapp.utilities.LogUtils;
import com.universalsompo.meta.metaapp.utilities.SendEmailDialog;

import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.universalsompo.meta.metaapp.motor.constants.RequestConstants.RENEWAL_POLICY_DETAIL_URL;

public class MyPolicyAdapter extends RecyclerView.Adapter<MyPolicyAdapter.MyViewHolder> implements ResponseListener, Filterable, RenewalDialogCallback, PressNonBackPress {
    private Activity mContext;
    private List<MyPolicyModel> listModelJobsInfo;
    private List<MyPolicyModel> mainListModelJobsInfo;
    private MySharedPreference prefrences;
    private Fragment fragment;
    private int position;
    private String policyId;
    private Interface3 listener;
    private PolicyBackPressCallback policyBackPressCallback;
    private ItemFilter mFilter = new ItemFilter();
    private String policy_no;

    public MyPolicyAdapter(Activity mContext, Fragment fragment, List<MyPolicyModel> listModelJobsInfo, MySharedPreference prefrences) {

        this.mContext = mContext;
        this.fragment = fragment;
        this.listModelJobsInfo = listModelJobsInfo;
        this.mainListModelJobsInfo = listModelJobsInfo;
        this.prefrences = prefrences;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(mContext, "testing adapter", Toast.LENGTH_SHORT).show();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_motor, tv_policynumber, tv_expiry_date, tv_car_no, tv_insurancecompany;
        TextView expire_day, expire, fullname;
        ImageView vehicle_type_img;
        LinearLayout img_dots;
        RelativeLayout rel1;

        public MyViewHolder(View view) {
            super(view);
            tv_motor = view.findViewById(R.id.tv_motor);
            tv_policynumber = view.findViewById(R.id.tv_policynumber);
            tv_insurancecompany = view.findViewById(R.id.tv_insurancecompany);
            tv_expiry_date = view.findViewById(R.id.tv_expiry_date);
            tv_car_no = view.findViewById(R.id.tv_car_no);
            rel1 = view.findViewById(R.id.rel1);
            img_dots = view.findViewById(R.id.img_dots);
            vehicle_type_img = view.findViewById(R.id.vehicle_type_img);
            expire_day = view.findViewById(R.id.expire_day);
            expire = view.findViewById(R.id.expire);
            fullname = view.findViewById(R.id.fullname);
        }
    }

    public MyPolicyAdapter(Activity mContext, Fragment fragment, List<MyPolicyModel> listModelJobsInfo, MySharedPreference prefrences, Interface3 listener, PolicyBackPressCallback policyBackPressCallback) {
        this.mContext = mContext;
        this.fragment = fragment;
        this.listModelJobsInfo = listModelJobsInfo;
        this.mainListModelJobsInfo = listModelJobsInfo;
        this.prefrences = prefrences;
        this.listener = listener;
        this.policyBackPressCallback = policyBackPressCallback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meta_own_policy_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_motor.setText(listModelJobsInfo.get(position).getModel());
        holder.tv_expiry_date.setText(listModelJobsInfo.get(position).getPolicyToDate());
        holder.tv_policynumber.setText(listModelJobsInfo.get(position).getPolicyNumber());
        holder.tv_car_no.setText(listModelJobsInfo.get(position).getRegistrationNumber());
        holder.tv_insurancecompany.setText("Universal Sompo General Insurance Co. Ltd.");
        holder.fullname.setText(listModelJobsInfo.get(position).getPolicyHolderName());

        if (listModelJobsInfo.get(position).getVehicleType().equals(Constants.TWO_WHEELER))
            holder.vehicle_type_img.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bike));
        else
            holder.vehicle_type_img.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.car1));

        int day_left_to_expire = Integer.parseInt(listModelJobsInfo.get(position).getNoOfDaysLeft());
        if (day_left_to_expire < 1) {
            holder.expire.setVisibility(View.GONE);
            holder.expire_day.setVisibility(View.VISIBLE);
            holder.expire_day.setText("Expired");
            holder.expire_day.setTypeface(Typeface.SERIF);
            holder.expire_day.setTextColor(ContextCompat.getColor(mContext, R.color.expiry_header));
        } else if (day_left_to_expire == 1) {
            holder.expire.setVisibility(View.VISIBLE);
            holder.expire_day.setVisibility(View.VISIBLE);
            holder.expire_day.setTextColor(ContextCompat.getColor(mContext, R.color.lightblack));
            holder.expire_day.setText(day_left_to_expire + " Day");
        } else if (day_left_to_expire < 31) {
            holder.expire.setVisibility(View.VISIBLE);
            holder.expire_day.setVisibility(View.VISIBLE);
            holder.expire_day.setTextColor(ContextCompat.getColor(mContext, R.color.lightblack));
            holder.expire_day.setText(day_left_to_expire + " Days");
        } else {
            holder.expire.setVisibility(View.GONE);
            holder.expire_day.setVisibility(View.GONE);
        }

        holder.rel1.setOnClickListener(view -> {
            FragmentPolicy.filtericonVisibility(false);
            FragmentManager fragmentManager2 = fragment.getFragmentManager();
            assert fragmentManager2 != null;
            FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
            prefrences.addPID(listModelJobsInfo.get(position).getPolicyID());
            prefrences.addVehicheType(listModelJobsInfo.get(position).getVehicleType());
            prefrences.addInsureCompID(listModelJobsInfo.get(position).getInsCompID());
            FragmentMetaOwnPolicyDetail fragmentMetaOwnPolicyDetail = new FragmentMetaOwnPolicyDetail();
            fragmentTransaction2.replace(R.id.policy_container, fragmentMetaOwnPolicyDetail);
            fragmentMetaOwnPolicyDetail.setFragmnet(policyBackPressCallback);
            fragmentTransaction2.addToBackStack("back");
            fragmentTransaction2.commit();
        });

        holder.img_dots.setOnClickListener(view -> {
            MyPolicyAdapter.this.position = position;
            MyPolicyAdapter.this.policyId = listModelJobsInfo.get(position).getPolicyID();
            showPopupMenu(holder.img_dots, listModelJobsInfo.get(position).getVehicleType(), listModelJobsInfo.get(position).getPolicyDoc(), listModelJobsInfo.get(position).getPolicyID(), listModelJobsInfo.get(position).getNoOfDaysLeft());
        });
    }

    private void showPopupMenu(View view, String veh_type, String Doc, String Id, String noofdaysleft) {
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        if (Integer.parseInt(noofdaysleft) < 1) {
            inflater.inflate(R.menu.menu_dots_two, popup.getMenu());
        } else if (Integer.parseInt(noofdaysleft) > 1 && Integer.parseInt(noofdaysleft) < 31) {
            inflater.inflate(R.menu.menu_dots, popup.getMenu());
        } else {
            inflater.inflate(R.menu.menu_dots_five, popup.getMenu());
        }
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(Doc, Id, veh_type));
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        String DOc_Path;
        String PID_doc;
        String veh_type;

        public MyMenuItemClickListener(String Path, String PID, String veh_type) {
            DOc_Path = Path;
            PID_doc = PID;
            this.veh_type = veh_type;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.sendEmail:
                    new AppDataPushApi().callApi(mContext,"My Policy","My policy list page","User clicked on email button");
                    SendEmailDialog emailDialog = new SendEmailDialog(mContext, veh_type, MySharedPreference.getInstance(mContext).getEmailId(), PID_doc, FragmentsTags.FRAGMENT_DOCUMENT_POLICY);
                    emailDialog.show();
                    return true;
                case R.id.fileClaim:
                    new AppDataPushApi().callApi(mContext,"My Policy","My policy list page","User clicked on file claim button for policy " + policyId);
                    Fragment frag = new FragmentClaimDetail();
                    Bundle b = new Bundle();
                    b.putString("key", listModelJobsInfo.get(position).getInsCompID());
                    b.putString("make", listModelJobsInfo.get(position).getMake());
                    b.putString("contact", listModelJobsInfo.get(position).getInsCompContactNo());
                    b.putString("policyIdFrDots", policyId);
                    b.putString("vehicleType", listModelJobsInfo.get(position).getVehicleType());
                    frag.setArguments(b);
                    FragmentsTransactionsUtils.replaceFragmentKeepPrevious(mContext, frag, R.id.main_frame, FragmentsTags.FRAGMENT_CLAIM_DETAIL);
                    listener.getSelect(-1);
                    return true;
                case R.id.renew:
                    new AppDataPushApi().callApi(mContext,"My Policy","My policy list page","User clicked on renew button for policy " + listModelJobsInfo.get(position).getPolicyNumber());
                    policy_no = listModelJobsInfo.get(position).getPolicyNumber();
                    String policy_id = listModelJobsInfo.get(position).getPolicyID();
                    String veh_type1 = listModelJobsInfo.get(position).getVehicleType();
                    init(policy_id, veh_type1);
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return listModelJobsInfo.size();
    }

    @Override
    public void onError(VolleyError error, int Tag) { }

    private void removeAt() {
        listModelJobsInfo.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listModelJobsInfo.size());
        Toast.makeText(mContext, "Policy deleted successfully", Toast.LENGTH_SHORT).show();
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString();
            FilterResults results = new FilterResults();
            final List<MyPolicyModel> list = mainListModelJobsInfo;
            int count = list.size();
            final ArrayList<MyPolicyModel> nlist = new ArrayList<>(count);
            MyPolicyModel claimPolicyModel;
            for (int i = 0; i < count; i++) {
                if (filterString.equalsIgnoreCase(list.get(i).getVehicleType())) {
                    claimPolicyModel = list.get(i);
                    nlist.add(claimPolicyModel);
                }
            }
            results.values = nlist;
            results.count = nlist.size();
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listModelJobsInfo = (ArrayList<MyPolicyModel>) results.values;
            notifyDataSetChanged();
        }
    }

    @Override
    public void getRenewalUpdateData(JSONObject jsonObject) {
        try {
            if (jsonObject.getString("Status").equals("true")) {
                Intent in = new Intent(mContext, PolicyInBrowser.class);
                in.putExtra("PolicyNo", policy_no);
                in.putExtra("Url", jsonObject.getString("RenewalLink"));
                in.putExtra("fargmentTag", "Renew Policy");
                in.putExtra("ISFROMPDFFULL", "");
                in.putExtra("VehicleType", "");
                in.putExtra("vendor_id", "");
                in.putExtra("type", "Renew Policy");
                mContext.startActivity(in);
            } else
                Toast.makeText(mContext, jsonObject.optString("Message"), Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init(String policyid, String vehtype1) {
        JSONObject object = new JSONObject();
        try {
            object.put("TokenNo", prefrences.getToken_no());
            object.put("PolicyID", policyid);
            object.put("UserID", prefrences.getUID());
            object.put("VehicleType", vehtype1);
            object.put("IsOwnershipChange", "");
            object.put("IsClaimMade", "");
            object.put("NCB","0" );
            ProjectVolleyRequest2 req = new ProjectVolleyRequest2(mContext, object, UrlConstants.RENEWAL_POLICY_DETAIL_URL, this, RENEWAL_POLICY_DETAIL_URL);
            req.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RENEWAL_POLICY_DETAIL_URL) {
            getRenewalUpdateData(object);
        }
    }



}
