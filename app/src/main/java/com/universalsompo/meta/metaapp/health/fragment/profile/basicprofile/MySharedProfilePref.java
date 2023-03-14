package com.universalsompo.meta.metaapp.health.fragment.profile.basicprofile;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedProfilePref {
    private static MySharedProfilePref object;
    private Context mContext;
    public static final String MyPREFERENCES = "MyPrefs";

    public static final String WEIGHT = "weight";
    public static final String FEET = "feet";
    public static final String INCHES = "inches";
    public static final String GENDER = "gender";
    public static final String DAILYACTIVITY = "daily_activity";
    public static final String AGE = "age";
    public static final String CONTACT_PERSON_NAME = "contact_person_name";
    public static final String CONTACT_PERSON_NUMBER = "contact_person_number";

    SharedPreferences sharedpreferences;

    public MySharedProfilePref(Context mContext) {
        this.mContext = mContext;
        sharedpreferences = mContext.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public static MySharedProfilePref getInstance(Context mContext) {
        if (object == null) {
            object = new MySharedProfilePref(mContext);
        }
        return object;
    }

    public void setweight(String weight) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(WEIGHT, weight);
        editor.commit();
    }

    public void setfeet(String feet) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(FEET, feet);
        editor.commit();
    }

    public void setinches(String inches) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(INCHES, inches);
        editor.commit();
    }

    public void setgender(String gender) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(GENDER, gender);
        editor.commit();
    }

    public void setDailyactivity(String daily_activity) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(DAILYACTIVITY, daily_activity);
        editor.commit();
    }

    public void setAge(String age) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(AGE, age);
        editor.commit();
    }

    public void setEmergencycontactpersonname(String emergencycontactpersonname) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CONTACT_PERSON_NAME, emergencycontactpersonname);
        editor.commit();
    }

    public void setEmergencycontactno(String emergencycontactno) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CONTACT_PERSON_NUMBER, emergencycontactno);
        editor.commit();
    }

    public String getweight() {
        return sharedpreferences.getString(WEIGHT, null);
    }
    public String getfeet() {
        return sharedpreferences.getString(FEET, null);
    }
    public String getinches() {
        return sharedpreferences.getString(INCHES, null);
    }
    public String getgender() {
        return sharedpreferences.getString(GENDER, null);
    }
    public String getDailyactivity() {
        return sharedpreferences.getString(DAILYACTIVITY, null);
    }
    public String getEmergencycontactpersonname() {
        return sharedpreferences.getString(CONTACT_PERSON_NAME, null);
    }
    public String getEmergencycontactno() {
        return sharedpreferences.getString(CONTACT_PERSON_NUMBER, null);
    }
    public String getAge() {
        return sharedpreferences.getString(AGE, null);
    }
}
