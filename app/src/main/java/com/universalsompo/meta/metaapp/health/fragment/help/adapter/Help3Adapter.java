package com.universalsompo.meta.metaapp.health.fragment.help.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;
import com.universalsompo.meta.metaapp.health.fragment.help.fragment.FragmentHelp4;
import com.universalsompo.meta.metaapp.health.fragment.help.model.Help;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.util.List;

public class Help3Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Help> help_list;
    private String id_help1, id_help2, id_help3;

    public Help3Adapter(Activity activity, List<Help> help, String Id_help, String Id_help1, String Id_help2) {
        this.activity = activity;
        this.help_list = help;
        this.id_help1 = Id_help;
        this.id_help2 = Id_help1;
        this.id_help3 = Id_help2;
    }

    @Override
    public int getCount() {
        return help_list.size();
    }

    @Override
    public Object getItem(int i) {
        return help_list.get(i);
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
            view = inflater.inflate(R.layout.help_list_layout, viewGroup, false);

        final TextView name =  view.findViewById(R.id.name);
        final LinearLayout category_selected =  view.findViewById(R.id.category_selected);
        final ImageView right_arrow =  view.findViewById(R.id.right_arrow);

        final Help m = help_list.get(i);

        name.setText(m.getCategoryName());
        right_arrow.setVisibility(View.GONE);

        category_selected.setOnClickListener(view1 -> {
            Fragment frag = new FragmentHelp4();
            Bundle args = new Bundle();
            args.putString("name", m.getCategoryName());
            args.putString("id_help1", id_help1);
            args.putString("id_help2", id_help2);
            args.putString("id_help3", id_help3);
            args.putString("id_help4", m.getID());
            frag.setArguments(args);
            FragmentsTransactionsUtils.replaceFragmentKeepPrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_HELP);
        });
        return view;
    }
}
