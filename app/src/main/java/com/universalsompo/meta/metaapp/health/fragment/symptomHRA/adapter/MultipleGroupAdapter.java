package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.fragments.FragmentSymptomQuestions;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Multiplegroup_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MultipleGroupAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Multiplegroup_getter_setter> statusItems;
    public static final String TAG = "MyTag";
    private ListView list;
    private BasicQuesDatabaseHelper db;
    private int selectedPosition = -1;
    FragmentSymptomQuestions frag;
    Button next2, back2;
    private RadioGroup radioGroup;
    private RadioButton present, absent, unknown;
    String choice_id;
    int i = 0;
    String id1, name1, ques1, symptom_id, symptom_name, selected_date, symptom_name1;
    MySharedPreference pref;

    public MultipleGroupAdapter(Activity activity, FragmentSymptomQuestions frag, List<Multiplegroup_getter_setter> statusItems, ListView list, Button next2, Button back2, String ques1) {
        this.activity = activity;
        this.frag = frag;
        this.statusItems = statusItems;
        this.list = list;
        this.next2 = next2;
        this.back2 = back2;
        this.ques1 = ques1;
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
            convertView = inflater.inflate(R.layout.multiple_group_list_item, null);

        pref = MySharedPreference.getInstance(activity);
        db = new BasicQuesDatabaseHelper(activity);
        final Multiplegroup_getter_setter m = statusItems.get(position);

        TextView name = convertView.findViewById(R.id.name);

        name.setText(m.getname());
        symptom_id = m.getid();
        symptom_name = m.getname();
        radioGroup = convertView.findViewById(R.id.radioGroup);
        present = convertView.findViewById(R.id.present);
        absent = convertView.findViewById(R.id.absent);
        unknown = convertView.findViewById(R.id.unknown);

        boolean sym_id = db.CheckIsSymptomIDAlreadyInDBorNot(pref.getSymptominterviewid(), pref.getUID(), symptom_id, "FragmentSymptomQuestions");
        if (sym_id == true) {
            choice_id = db.getChoiceIdFromSymptomId(pref.getUID(), pref.getSymptominterviewid(), symptom_id, "FragmentSymptomQuestions");
            if (choice_id.equalsIgnoreCase("Present")) {
                radioGroup.check(R.id.present);
                i++;
            } else if (choice_id.equalsIgnoreCase("Absent")) {
                radioGroup.check(R.id.absent);
                i++;
            } else {
                radioGroup.check(R.id.unknown);
                i++;
            }
        } else {
            radioGroup.clearCheck();
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    String choice = (String) rb.getText();
                    if (choice.equalsIgnoreCase("Yes")) {
                        choice_id = "present";
                    } else if (choice.equalsIgnoreCase("No")) {
                        choice_id = "absent";
                    } else {
                        choice_id = "unknown";
                    }
                    symptom_id = statusItems.get(position).getid();
                    symptom_name1 = statusItems.get(position).getname();
                    Log.d("choice id + symptom id" , choice_id + " " + symptom_id + " " + symptom_name1);
                    radiogroup_click(choice_id, symptom_id, symptom_name1);
                }
            }
        });
        return convertView;
    }

    public void radiogroup_click(String choiceid, String symp_id, String symptom_name1) {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        selected_date = df.format(c);
        boolean a = db.CheckIsDataAlreadyInDBorNotID(pref.getSymptominterviewid(), "FragmentSymptomQuestions", symp_id, pref.getUID());
        if (a == true) {
            long b1 = db.updateBasicSymptom(pref.getUID(), pref.getUserName(), pref.getSymptominterviewid(), "group_multiple", ques1, symp_id, symptom_name1, "false", choiceid, selected_date, "FragmentSymptomQuestions");
        } else {
            long id2 = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), pref.getSymptominterviewid(), "group_multiple", ques1, symp_id, symptom_name1, "false", choiceid, selected_date, "FragmentSymptomQuestions");
            i++;
        }
    }
}
