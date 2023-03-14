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
import com.universalsompo.meta.metaapp.health.HRALifestyle.Model.Userhis_getter_setter;
import com.universalsompo.meta.metaapp.motor.sharedpreferences.MySharedPreference;

import java.util.List;

public class ReportedUserHisAdapter extends BaseAdapter {
    private Activity activity;
    private List<Userhis_getter_setter> userhistoryModelList;
    Fragment fragment;
    private LayoutInflater inflater;
    private LifestyleHRADatabaseHelper db;
    private MySharedPreference pref;
    static CheckBox chkbox;

    public ReportedUserHisAdapter(Activity activity, List<Userhis_getter_setter> userModelList) {
        this.activity = activity;
        this.userhistoryModelList = userModelList;
    }

    @Override
    public int getCount() {
        return userhistoryModelList.size();
    }

    @Override
    public Object getItem(int location) {
        return userhistoryModelList.get(location);
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
            convertView = inflater.inflate(R.layout.user_hist_item, null);

        pref = MySharedPreference.getInstance(activity);
        // TextView user_disease = convertView.findViewById(R.id.user_disease);
        chkbox = convertView.findViewById(R.id.chkbox);
        pref = MySharedPreference.getInstance(activity);
        db = new LifestyleHRADatabaseHelper(activity);

        final Userhis_getter_setter m = userhistoryModelList.get(position);

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

        String yes_no = db.getLifestyleYesNoValue(pref.getUID(), m.getCol1(), "FragmentGeneralHealth");
        System.out.println("Suffer " + yes_no);
        if(yes_no.equalsIgnoreCase("yes")){
            chkbox.setChecked(true);
        } else {
            chkbox.setChecked(false);
        }

        return convertView;
    }
}