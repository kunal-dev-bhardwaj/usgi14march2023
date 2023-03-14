package com.universalsompo.meta.metaapp.motor.fragments;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.activities.MainActivity;
import java.util.Objects;

public class FragmentDocuments extends Fragment implements View.OnClickListener {
    private View rootview;
    private TextView doc_preview;
    private TextView doc_upload;
    private View view1,view2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_my_documents, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).remove_elevation();
        init();
        addFragment(new FragmentDocumentPreview());
        return rootview;
    }

    private void init() {
        doc_preview = rootview.findViewById(R.id.txt_doc_preview);
        doc_upload = rootview.findViewById(R.id.txt_doc_upload);
        view1 = rootview.findViewById(R.id.view1);
        view2 = rootview.findViewById(R.id.view2);
        doc_upload.setOnClickListener(this);
        doc_preview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment frg;
        switch (v.getId()) {
            case R.id.txt_doc_preview:
                doc_preview.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.tab_text));
                doc_upload.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
                view1.setBackgroundResource(R.color.tab_text);
                view2.setBackgroundResource(R.color.white);
                frg = new FragmentDocumentPreview();
                addFragment(frg);
                break;
            case R.id.txt_doc_upload:
                doc_preview.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.lightblack));
                doc_upload.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.tab_text));
                view1.setBackgroundResource(R.color.white);
                view2.setBackgroundResource(R.color.tab_text);
                frg = new FragmentDocumentUpload();
                addFragment(frg);
                break;
            default:
                break;
        }
    }

    private void addFragment(Fragment frg) {
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.docment_container, frg);
        childFragTrans.commit();
    }
}
