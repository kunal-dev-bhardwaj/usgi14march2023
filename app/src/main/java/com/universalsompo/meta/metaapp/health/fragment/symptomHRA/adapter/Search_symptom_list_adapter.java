package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.activities.MainActivityHealth;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter.SymptomConfirmAdapter;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomSearch;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Search_symptom_list_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.WrappingGridView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Search_symptom_list_adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Search_symptom_list_getter_setter> statusItems;
    public static final String TAG = "MyTag";
    private ListView list;
    private WrappingGridView choosen_symptom;
    private LinearLayout symptom_choosen_list;
    private Button next, back;
    private BasicQuesDatabaseHelper db;
    String interviewid;
    private List<BasicQuestion> symptomList = new ArrayList<>();
    private SymptomConfirmAdapter mAdapter;
    private EditText symptoms;
    private FragmentSymptomSearch fragment;
    MySharedPreference pref;
    String selected_date;

    public Search_symptom_list_adapter(Activity activity, List<Search_symptom_list_getter_setter> statusItems, ListView list, String interviewid, Button next, Button back, LinearLayout symptom_choosen_list, WrappingGridView choosen_symptom, EditText symptoms, FragmentSymptomSearch fragment) {
        this.activity = activity;
        this.statusItems = statusItems;
        this.list = list;
        this.interviewid = interviewid;
        this.next = next;
        this.back = back;
        this.symptom_choosen_list = symptom_choosen_list;
        this.choosen_symptom = choosen_symptom;
        this.symptoms = symptoms;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return statusItems.size();
    }

    @Override
    public Object getItem(int location) {
        return statusItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.symptom_list_item, null);

        TextView label = convertView.findViewById(R.id.label);
        LinearLayout item_selected = convertView.findViewById(R.id.item_selected);
        db = new BasicQuesDatabaseHelper(activity);
        pref = MySharedPreference.getInstance(activity);

        Search_symptom_list_getter_setter m = statusItems.get(position);

        label.setText(m.getlabel());

        item_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = statusItems.get(position).getid();
                String name = statusItems.get(position).getlabel();
                String init = "true";
                String choiceid = "present";

                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                selected_date = df.format(c);

                long id1 = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), interviewid, "", "", id, name, init, choiceid, selected_date, "FragmentSymptomSearch");
                MainActivityHealth.hideSoftKeyboard(activity);
                symptoms.setText("");
                getsymptomlist();
            }
        });
        return convertView;
    }

    public void getsymptomlist(){
        db = new BasicQuesDatabaseHelper(activity);
        list.setVisibility(View.GONE);
        symptom_choosen_list.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        symptomList = new ArrayList<>();
        symptomList.addAll(db.getAllBasicSymptom(interviewid, "FragmentSymptomSearch"));
        mAdapter = new SymptomConfirmAdapter(activity, symptomList, fragment, interviewid);
        choosen_symptom.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
