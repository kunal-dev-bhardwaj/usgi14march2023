package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.BasicQuesDatabaseHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.model.Suggested_Symptom_list_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Suggested_Symptom_list_adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Suggested_Symptom_list_getter_setter> statusItems;
    public static final String TAG = "MyTag";
    private ListView list;
    private BasicQuesDatabaseHelper db;
    MySharedPreference pref;
    String selected_date;

    public Suggested_Symptom_list_adapter(Activity activity, List<Suggested_Symptom_list_getter_setter> statusItems, ListView list) {
        this.activity = activity;
        this.statusItems = statusItems;
        this.list = list;
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
            convertView = inflater.inflate(R.layout.suggest_list_item, parent, false);

        //TextView text1 = convertView.findViewById(R.id.text1);
        CheckBox check = convertView.findViewById(R.id.check);
        pref = MySharedPreference.getInstance(activity);
        db = new BasicQuesDatabaseHelper(activity);

        Suggested_Symptom_list_getter_setter m = statusItems.get(position);

        check.setText(m.getname());

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String id = statusItems.get(position).getid();
                    String name = statusItems.get(position).getname();
                    String init = "true";
                    String choiceid = "present";

                    Date c = Calendar.getInstance().getTime();
                    System.out.println("Current time => " + c);

                    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    selected_date = df.format(c);

                    long id1 = db.insertbasicSymptom(pref.getUID(), pref.getUserName(), pref.getSymptominterviewid(), "", "" , id, name, init, choiceid, selected_date, "FragmentSymptomSuggestions");
                }else{
                    db.deleteBasicSymptomId(pref.getSymptominterviewid(), statusItems.get(position).getid());
                }
            }
        });
        return convertView;
    }
}
