package com.universalsompo.meta.metaapp.health.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;
import com.universalsompo.meta.metaapp.intefaces.NoDocInterface;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.motor.models.DocumentModel;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DocumentPreviewAdapter1 extends BaseAdapter implements ResponseListener {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<DocumentModel> modelList;
    private int visibleFlag = 0;
    private String selectedDocId;
    private View v;
    private NoDocInterface noDocInterface;

    private MySharedPreference pref;
    public DocumentPreviewAdapter1(Context context, ArrayList<DocumentModel> modelList, NoDocInterface noDocInterface) {
        this.context = context;
        this.noDocInterface = noDocInterface;
        this.modelList = modelList;


    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        pref = MySharedPreference.getInstance(context);
        ViewHolder vh = new ViewHolder();
        inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_document_preview_item, null);
            v = convertView;
            vh.img_doc = convertView.findViewById(R.id.img_doc);
            vh.img_delete_doc = convertView.findViewById(R.id.img_del_doc);
            vh.txt_doc_type = convertView.findViewById(R.id.txt_doctype);
            vh.exp_date_txt = convertView.findViewById(R.id.exp_date_txt);
            vh.img_delete_doc.setVisibility(View.GONE);
            vh.exp_date_txt.setVisibility(View.GONE);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Picasso.get().load(modelList.get(position).getDoc_img_url()).fit().placeholder(R.drawable.loading).into(vh.img_doc);
        vh.txt_doc_type.setText("Lab test report " + position);

        if(modelList.get(position).getDoc_exp_date()!=null&&modelList.get(position).getDoc_category().equals("Pollution Doc"))
        {
            vh.exp_date_txt.setVisibility(View.GONE);
        }else
        {
            vh.exp_date_txt.setVisibility(View.GONE);
        }

        if (visibleFlag == 1) {
            vh.img_delete_doc.setVisibility(View.VISIBLE);
            vh.img_delete_doc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedDocId = modelList.get(position).getDoc_img_id();
                    confirmDelete(context, position);
                }
            });

        }

        if (visibleFlag == 2)
            vh.img_delete_doc.setVisibility(View.GONE);

        return convertView;
    }


    public class ViewHolder {
        ImageView img_doc;
        ImageView img_delete_doc;
        TextView txt_doc_type;
        TextView exp_date_txt;
    }


    public void updateView(int flag) {
        visibleFlag = flag;
    }

    public void confirmDelete(Context context, final int position) {

        final AlertDialog d = new AlertDialog.Builder(context)
                .setTitle("Confirm delete!")
                .setMessage("Are you sure to delete this Document?").setCancelable(false)

                .setPositiveButton("Delete", null)
                // Set to null. We override the onclick
                .setNegativeButton("Cancel", null).create();

        d.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {
                Button delete = d.getButton(AlertDialog.BUTTON_POSITIVE);

                delete.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        callApi(v, selectedDocId);
                        d.dismiss();
                        modelList.remove(position);
                        if (modelList.isEmpty()) {
                            noDocInterface.no_data("0");
                        }
                        notifyDataSetChanged();

                    }
                });

                Button cancel = d.getButton(AlertDialog.BUTTON_NEGATIVE);

                cancel.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();

                    }
                });

            }
        });

        d.show();
        d.getButton(Dialog.BUTTON_POSITIVE).setTextColor(context.getResources().getColor(R.color.colorPrimary));
        d.getButton(Dialog.BUTTON_NEGATIVE).setTextColor(context.getResources().getColor(R.color.colorPrimary));
    }

    private void callApi(View v, String id) {

        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, pref.getToken_no());
            object.put("Uid",pref.getUID());
            object.put(RequestConstants.ELCOKER_ID, id);
        } catch (Exception e) {
                        e.printStackTrace();
                    }
        ProjectVolleyRequest req = new ProjectVolleyRequest(context, object, UrlConstants.DOCUMENT_IMG_DELETE, this, RequestConstants.DOCUMENT_IMG_DELETE);
        req.execute();

    }


    @Override
    public void onSuccess(JSONObject object, int Tag) {
        if (Tag == RequestConstants.DOCUMENT_IMG_DELETE) {
            String msg = object.optString("Message");
            Toast.makeText(context, "Delete Successfully", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onError(VolleyError error, int Tag) {
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof AuthFailureError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof ServerError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof NetworkError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        } else if (error instanceof ParseError) {
            //TODO
            Log.d("check1", "Error: " + error.getMessage());
        }
    }


    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "dd-MM-yyyy";
        String outputPattern = "dd/MMM/yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
