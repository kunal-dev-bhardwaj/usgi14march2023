package com.universalsompo.meta.metaapp.health.HRALifestyle.Adapter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.LifestyleHRADatabaseHelper;
import com.universalsompo.meta.metaapp.health.HRALifestyle.Model.Famhis_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.ArrayList;

public class ReportedFamHisAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Famhis_getter_setter> familyhistoryModelList;
    Fragment fragment;
    private LayoutInflater inflater;
    private LifestyleHRADatabaseHelper db;
    private MySharedPreference pref;
    static CheckBox chkbox, chkbox1;

    public ReportedFamHisAdapter(Activity activity, ArrayList<Famhis_getter_setter> familyModelList) {
        this.activity = activity;
        this.familyhistoryModelList = familyModelList;
    }

    @Override
    public int getCount() {
        return familyhistoryModelList.size();
    }

    @Override
    public Object getItem(int location) {
        return familyhistoryModelList.get(location);
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
            convertView = inflater.inflate(R.layout.fam_hist_item, null);

        pref = MySharedPreference.getInstance(activity);
        chkbox = convertView.findViewById(R.id.chkbox);
        chkbox1 = convertView.findViewById(R.id.chkbox1);
        pref = MySharedPreference.getInstance(activity);
        db = new LifestyleHRADatabaseHelper(activity);

        final Famhis_getter_setter m = familyhistoryModelList.get(position);

        chkbox.setText(m.getCol1());

        chkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String user_id = pref.getUID();
                    String auth_token = m.getAuthtoken();
                    String account_id = m.getAccountid();
                    String person_id = m.getPersonid();
                    String template_id = m.getTemplateid();
                    String question_id = m.getQuestionid();
                    String question = m.getQuestion();
                    String question_code = m.getQuestioncode();
                    String col1 = m.getCol1();
                    String col2 = m.getCol2();
                    String col3 = m.getCol3();
                    String col4 = m.getCol4();
                    String col5 = m.getCol5();
                    String col6 = m.getCol6();
                    String category = m.getCategory();
                    String answer_code = m.getAnswercode();
                    String answer_other = m.getAnswerother();
                    String parameter_code = m.getParametercode();
                    String unit = m.getUnit();
                    String yes_no = "yes";
                    String fragment = m.getFragment();

                    db.updateLifestyleValue1(user_id, auth_token, account_id, person_id, template_id, question_id, question, question_code, col1, col2, col3, col4, col5, col6, category, answer_code, answer_other, parameter_code, unit, yes_no, fragment);
                }else{
                    String user_id = pref.getUID();
                    String auth_token = m.getAuthtoken();
                    String account_id = m.getAccountid();
                    String person_id = m.getPersonid();
                    String template_id = m.getTemplateid();
                    String question_id = m.getQuestionid();
                    String question = m.getQuestion();
                    String question_code = m.getQuestioncode();
                    String col1 = m.getCol1();
                    String col2 = m.getCol2();
                    String col3 = m.getCol3();
                    String col4 = m.getCol4();
                    String col5 = m.getCol5();
                    String col6 = m.getCol6();
                    String category = m.getCategory();
                    String answer_code = m.getAnswercode();
                    String answer_other = m.getAnswerother();
                    String parameter_code = m.getParametercode();
                    String unit = m.getUnit();
                    String yes_no = "no";
                    String fragment = m.getFragment();

                    db.updateLifestyleValue1(user_id, auth_token, account_id, person_id, template_id, question_id, question, question_code, col1, col2, col3, col4, col5, col6, category, answer_code, answer_other, parameter_code, unit, yes_no, fragment);
                }
            }
        });

        String yes_no = db.getLifestyleYesNoValue(pref.getUID(), m.getCol1(), "FragmentFamilyHealth");
        System.out.println("Suffer " + yes_no);
        if(yes_no.equalsIgnoreCase("yes")){
            chkbox.setChecked(true);
        } else {
            chkbox.setChecked(false);
        }

        return convertView;
    }
}
