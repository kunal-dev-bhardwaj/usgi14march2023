package com.universalsompo.meta.metaapp.motor.adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Target;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.constants.RequestConstants;
import com.universalsompo.meta.metaapp.motor.constants.UrlConstants;
import com.universalsompo.meta.metaapp.intefaces.NoDocInterface;
import com.universalsompo.meta.metaapp.intefaces.ProjectVolleyRequest;
import com.universalsompo.meta.metaapp.intefaces.ResponseListener;
import com.universalsompo.meta.metaapp.motor.models.DocumentModel;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.squareup.picasso.Picasso;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.AppDataPushApi;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class DocumentPreviewAdapter extends BaseAdapter implements ResponseListener {
    private Context context;
    private ArrayList<DocumentModel> modelList;
    private int visibleFlag = 0;
    private String selectedDocId;
    private NoDocInterface noDocInterface;

    public DocumentPreviewAdapter(Context context, ArrayList<DocumentModel> modelList, NoDocInterface noDocInterface) {
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

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_document_preview_item, null);
            vh.img_doc = convertView.findViewById(R.id.img_doc);
            vh.img_delete_doc = convertView.findViewById(R.id.img_del_doc);
            vh.img_share_doc = convertView.findViewById(R.id.img_share_doc);
            vh.txt_doc_type = convertView.findViewById(R.id.txt_doctype);
            vh.exp_date_txt = convertView.findViewById(R.id.exp_date_txt);
            vh.img_delete_doc.setVisibility(View.GONE);
            vh.exp_date_txt.setVisibility(View.GONE);
            vh.img_share_doc.setVisibility(View.VISIBLE);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Picasso.get().load(modelList.get(position).getDoc_img_url()).fit().placeholder(R.drawable.loading).into(vh.img_doc);
        vh.txt_doc_type.setText(modelList.get(position).getDoc_type());
        if(modelList.get(position).getDoc_exp_date()!=null&&modelList.get(position).getDoc_category().equals("Pollution Doc")) {
            String custom_date=parseDateToddMMyyyy(modelList.get(position).getDoc_exp_date());
            vh.exp_date_txt.setVisibility(View.VISIBLE);
            vh.exp_date_txt.setText("POC Exp Date: "+custom_date);
        } else {
            vh.exp_date_txt.setVisibility(View.GONE);
        }

        vh.img_share_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDocId = modelList.get(position).getDoc_img_id();
                ShareImage(modelList.get(position).getDoc_img_url());
            }
        });

        if (visibleFlag == 1) {
            vh.img_share_doc.setVisibility(View.GONE);
            vh.img_delete_doc.setVisibility(View.VISIBLE);
            vh.img_delete_doc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedDocId = modelList.get(position).getDoc_img_id();
                    confirmDelete(context, position);
                }
            });
        } if (visibleFlag == 2){
            vh.img_delete_doc.setVisibility(View.GONE);
            vh.img_share_doc.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    public class ViewHolder {
        ImageView img_doc;
        ImageView img_delete_doc;
        ImageView img_share_doc;
        TextView txt_doc_type;
        TextView exp_date_txt;
    }

    public void updateView(int flag) {
        visibleFlag = flag;
    }

    private void ShareImage(String url)
    {
        Picasso.get().load(url).into(new Target() {
            @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("image/*");
                i.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(bitmap));
                context.startActivity(Intent.createChooser(i, "Share Image"));
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override public void onPrepareLoad(Drawable placeHolderDrawable) { }
        });
    }

    private Uri getLocalBitmapUri(Bitmap bmp) {
        Uri bmpUri = null;
        try {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            File file =  new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    private void confirmDelete(final Context context, final int position) {
        final Dialog dialog = new Dialog(context, R.style.CustomDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.setContentView(R.layout.delete_others_medical_record_dialog);
        TextView yes = dialog.findViewById(R.id.delete_medical_other_record);
        TextView no = dialog.findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                new AppDataPushApi().callApi(context,"KYC Docs","KYC Docs preview page","User deleted his KYC doc " + selectedDocId);
                callApi(selectedDocId);
                modelList.remove(position);
                if (modelList.isEmpty()) {
                    noDocInterface.no_data("0");
                }
                notifyDataSetChanged();
            }
        });

        dialog.show();
    }

    private void callApi(String id) {
        JSONObject object = new JSONObject();
        try {
            object.put(RequestConstants.TOKEN_NO, MySharedPreference.getInstance(context).getToken_no());
            object.put("Uid",MySharedPreference.getInstance(context).getUID());
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

    private String parseDateToddMMyyyy(String time) {
        String inputPattern = "dd-MM-yyyy";
        String outputPattern = "dd/MMM/yyyy";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
        Date date;
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
