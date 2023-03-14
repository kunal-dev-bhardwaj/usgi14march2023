package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.constants.FragmentsHealthTags;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomQuestions;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Singlegroup_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;
import com.universalsompo.meta.metaapp.utilities.FragmentsTransactionsUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SingleGroupAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Singlegroup_getter_setter> statusItems;
    public static final String TAG = "MyTag";
    private ListView list;
    private BasicQuesDatabaseHelper db;
    private int selectedPosition = -1;
    FragmentSymptomQuestions frag;
    Button next, back;
    MySharedPreference pref;
    String question, symp_name;
    String selected_date;

    public SingleGroupAdapter(Activity activity, FragmentSymptomQuestions frag, List<Singlegroup_getter_setter> statusItems, ListView list, Button next, Button back, String question) {
        this.activity = activity;
        this.frag = frag;
        this.statusItems = statusItems;
        this.list = list;
        this.next = next;
        this.back = back;
        this.question = question;
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
            convertView = inflater.inflate(R.layout.single_group_list_item, null);

        pref = MySharedPreference.getInstance(activity);

        RadioButton single_check = convertView.findViewById(R.id.single_check);
        //TextView symptom_name = convertView.findViewById(R.id.symptom_name);

        db = new BasicQuesDatabaseHelper(activity);
        Singlegroup_getter_setter m = statusItems.get(position);

        single_check.setText(m.getname());

        if (selectedPosition == -1) {
            boolean ques_present = db.CheckIsQuestionAlreadyInDBorNot(pref.getSymptominterviewid(), "FragmentSymptomQuestions", question, pref.getUID());
            if (ques_present == true) {
                symp_name = db.getNameFromQuestion(pref.getUID(), pref.getSymptominterviewid(), question, "FragmentSymptomQuestions");
                if (symp_name.equalsIgnoreCase(single_check.getText().toString())) {
                    selectedPosition = position;
                } else {
                    selectedPosition = -1;
                }
            }
        }

        single_check.setTag(position);
        if (position == selectedPosition) {
            single_check.setChecked(true);
            Log.d("Selected checkbox", m.getid() + " " + m.getname());
            next.setEnabled(true);
            click_button(m.getid(),m.getname());
        } else {
            single_check.setChecked(false);
        }

        single_check.setOnClickListener(onStateChangedListener(single_check, position));

        return convertView;
    }

    private View.OnClickListener onStateChangedListener(final RadioButton checkBox, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    selectedPosition = position;
                } else {
                    selectedPosition = -1;
                }
                notifyDataSetChanged();
            }
        };
    }

    public void click_button(final String id, final String name){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                selected_date = df.format(c);
                Log.d("Selected checkbox", id + " " + name);
                if(id.equalsIgnoreCase(null) || id.equalsIgnoreCase("")) {
                    Toast.makeText(activity, "Please select a value", Toast.LENGTH_SHORT).show();
                } else {
                    boolean a = db.CheckIsQuesDataAlreadyInDBorNot(pref.getSymptominterviewid(), "FragmentSymptomQuestions", question, pref.getUID());
                    if (a == true) {
                        long b1 = db.updateBasicSymptomQuesBased(pref.getUID(), pref.getUserName(), pref.getSymptominterviewid(), "single_group", question, id, name, "false", "present", selected_date, "FragmentSymptomQuestions");
                    } else {
                        long id2 = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), pref.getSymptominterviewid(), "single_group", question, id, name, "false", "present", selected_date, "FragmentSymptomQuestions");
                    }
                    Fragment frag = new FragmentSymptomQuestions();
                    FragmentsTransactionsUtils.replaceFragmentRemovePrevious(activity, frag, R.id.main_frame1, FragmentsHealthTags.FRAGMENT_BASIC_QUESTION);
                }
            }
        });
    }
}
