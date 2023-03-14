package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomSearch;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.List;

public class SymptomConfirmAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    public static final String TAG = "MyTag";
    private ListView list;
    private List<BasicQuestion> symptomList;
    private FragmentSymptomSearch fragment;
    String interviewid;
    private BasicQuesDatabaseHelper db;

    public SymptomConfirmAdapter(Activity activity, List<BasicQuestion> symptomList, FragmentSymptomSearch fragment, String interviewid) {
        this.activity = activity;
        this.symptomList = symptomList;
        this.fragment = fragment;
        this.interviewid = interviewid;
    }

    @Override
    public int getCount() {
        return symptomList.size();
    }

    @Override
    public Object getItem(int i) {
        return symptomList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.symptom_confirm_list, null);

        final TextView name = view.findViewById(R.id.name);
        final LinearLayout delete = view.findViewById(R.id.delete);
        db = new BasicQuesDatabaseHelper(activity);

        final BasicQuestion m = symptomList.get(i);

        name.setText(m.getbasicName());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteBasicSymptomId(m.getbasicInterviewid(), m.getbasicSymptomid());
                Fragment frag = new FragmentSymptomSearch();
                FragmentsTransactionsUtils.replaceFragmentRemovePrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
            }
        });
        return view;
    }
}
