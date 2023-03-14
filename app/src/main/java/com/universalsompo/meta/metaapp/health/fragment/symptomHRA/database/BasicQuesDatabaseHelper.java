package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.BasicQuestion;
import java.util.ArrayList;
import java.util.List;

public class BasicQuesDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "basic_symptom_added_db";

    public BasicQuesDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BasicQuestion.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BasicQuestion.TABLE_NAME);
        onCreate(db);
    }

    public long insertbasicSymptom(String basic_user_id, String basic_user_name, String basic_interview_id, String ques_type, String ques_txt, String basic_symptom_id, String basic_symp_name, String basic_init, String basic_choice_id, String basic_date, String basic_fragment_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BasicQuestion.BASIC_USER_ID, basic_user_id);
        values.put(BasicQuestion.BASIC_USER_NAME, basic_user_name);
        values.put(BasicQuestion.BASIC_INTERVIEW_ID, basic_interview_id);
        values.put(BasicQuestion.QUES_TYPE,ques_type);
        values.put(BasicQuestion.QUES_TEXT, ques_txt);
        values.put(BasicQuestion.BASIC_SYMPTOM_ID, basic_symptom_id);
        values.put(BasicQuestion.BASIC_SYMPTOM_NAME, basic_symp_name);
        values.put(BasicQuestion.BASIC_INITIAL, basic_init);
        values.put(BasicQuestion.BASIC_CHOICE_ID, basic_choice_id);
        values.put(BasicQuestion.BASIC_DATE, basic_date);
        values.put(BasicQuestion.BASIC_FRAGMENT_NAME, basic_fragment_name);
        long id1 = db.insert(BasicQuestion.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public List<BasicQuestion> getAllBasicSymptom(String basic_interview_id, String basic_fragment_name) {
        List<BasicQuestion> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + basic_fragment_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                BasicQuestion basic_symps1 = new BasicQuestion();
                basic_symps1.setbasicUserid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_ID)));
                basic_symps1.setbasicUsername(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_NAME)));
                basic_symps1.setbasicInterviewid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INTERVIEW_ID)));
                basic_symps1.setbasicQuestype(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TYPE)));
                basic_symps1.setbasicQuestxt(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TEXT)));
                basic_symps1.setbasicSymptomid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_ID)));
                basic_symps1.setbasicName(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME)));
                basic_symps1.setbasicInit(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INITIAL)));
                basic_symps1.setbasicChoiceid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID)));
                basic_symps1.setbasicDate(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_DATE)));
                basic_symps1.setbasicFragmentname(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_FRAGMENT_NAME)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public List<BasicQuestion> getAllBasicSymptom(String basic_interview_id, String choice_id, String basic_fragment_name) {
        List<BasicQuestion> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_CHOICE_ID + " = " + "'" + choice_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + basic_fragment_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                BasicQuestion basic_symps1 = new BasicQuestion();
                basic_symps1.setbasicUserid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_ID)));
                basic_symps1.setbasicUsername(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_NAME)));
                basic_symps1.setbasicInterviewid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INTERVIEW_ID)));
                basic_symps1.setbasicQuestype(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TYPE)));
                basic_symps1.setbasicQuestxt(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TEXT)));
                basic_symps1.setbasicSymptomid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_ID)));
                basic_symps1.setbasicName(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME)));
                basic_symps1.setbasicInit(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INITIAL)));
                basic_symps1.setbasicChoiceid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID)));
                basic_symps1.setbasicDate(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_DATE)));
                basic_symps1.setbasicFragmentname(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_FRAGMENT_NAME)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public List<BasicQuestion> getAllBasicSymptom(String basic_interview_id) {
        List<BasicQuestion> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                BasicQuestion basic_symps1 = new BasicQuestion();
                basic_symps1.setbasicUserid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_ID)));
                basic_symps1.setbasicUsername(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_NAME)));
                basic_symps1.setbasicInterviewid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INTERVIEW_ID)));
                basic_symps1.setbasicQuestype(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TYPE)));
                basic_symps1.setbasicQuestxt(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TEXT)));
                basic_symps1.setbasicSymptomid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_ID)));
                basic_symps1.setbasicName(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME)));
                basic_symps1.setbasicInit(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INITIAL)));
                basic_symps1.setbasicChoiceid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID)));
                basic_symps1.setbasicDate(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_DATE)));
                basic_symps1.setbasicFragmentname(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_FRAGMENT_NAME)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public List<BasicQuestion> getAllBasicSymptomAsFrag(String basic_interview_id, String frag) {
        List<BasicQuestion> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                BasicQuestion basic_symps1 = new BasicQuestion();
                basic_symps1.setbasicUserid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_ID)));
                basic_symps1.setbasicUsername(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_NAME)));
                basic_symps1.setbasicInterviewid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INTERVIEW_ID)));
                basic_symps1.setbasicQuestype(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TYPE)));
                basic_symps1.setbasicQuestxt(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TEXT)));
                basic_symps1.setbasicSymptomid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_ID)));
                basic_symps1.setbasicName(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME)));
                basic_symps1.setbasicInit(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INITIAL)));
                basic_symps1.setbasicChoiceid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID)));
                basic_symps1.setbasicDate(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_DATE)));
                basic_symps1.setbasicFragmentname(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_FRAGMENT_NAME)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public List<BasicQuestion> getAllSymptomAsFrag(String basic_interview_id, String frag) {
        List<BasicQuestion> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int j = cursor.getCount();
        if (cursor.moveToFirst()) {
            for (int i = 0; i < (j - 1) ; i++) {
                BasicQuestion basic_symps1 = new BasicQuestion();
                basic_symps1.setbasicUserid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_ID)));
                basic_symps1.setbasicUsername(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_NAME)));
                basic_symps1.setbasicInterviewid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INTERVIEW_ID)));
                basic_symps1.setbasicQuestype(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TYPE)));
                basic_symps1.setbasicQuestxt(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TEXT)));
                basic_symps1.setbasicSymptomid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_ID)));
                if (cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME)).equalsIgnoreCase("")) {
                    basic_symps1.setbasicName("");
                } else {
                    basic_symps1.setbasicName(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME)));
                }
                basic_symps1.setbasicInit(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INITIAL)));
                basic_symps1.setbasicChoiceid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID)));
                basic_symps1.setbasicDate(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_DATE)));
                basic_symps1.setbasicFragmentname(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_FRAGMENT_NAME)));
                symps2.add(basic_symps1);
                cursor.moveToNext();
            }
        }
        db.close();
        return symps2;
    }

    public List<BasicQuestion> getAllSymptomAsFrag1(String basic_interview_id, String frag, int count) {
        List<BasicQuestion> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int j = cursor.getCount();
        if (cursor.moveToFirst()) {
            for (int i = 0; i < (j - count) ; i++) {
                BasicQuestion basic_symps1 = new BasicQuestion();
                basic_symps1.setbasicUserid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_ID)));
                basic_symps1.setbasicUsername(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_USER_NAME)));
                basic_symps1.setbasicInterviewid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INTERVIEW_ID)));
                basic_symps1.setbasicQuestype(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TYPE)));
                basic_symps1.setbasicQuestxt(cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TEXT)));
                basic_symps1.setbasicSymptomid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_ID)));
                if (cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME)).equalsIgnoreCase("")) {
                    basic_symps1.setbasicName("");
                } else {
                    basic_symps1.setbasicName(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME)));
                }
                basic_symps1.setbasicInit(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_INITIAL)));
                basic_symps1.setbasicChoiceid(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID)));
                basic_symps1.setbasicDate(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_DATE)));
                basic_symps1.setbasicFragmentname(cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_FRAGMENT_NAME)));
                symps2.add(basic_symps1);
                cursor.moveToNext();
            }
        }
        db.close();
        return symps2;
    }

    public int getAllBasicSymptomWithChoiceID0(String basic_user_id, String basic_interview_id) {
        int i = 0;
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + basic_user_id + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_CHOICE_ID + " = 0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID)).equalsIgnoreCase("0")) {
                    i++;
                }
            } while (cursor.moveToNext());
        }
        db.close();
        return i;
    }

    public void deleteBasicInterviewId(String basic_interview_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BasicQuestion.TABLE_NAME, BasicQuestion.BASIC_INTERVIEW_ID + " = '" + basic_interview_id + "'",
                null);
        db.close();
    }

    public void deleteBasicSymptomId(String basic_interview_id, String basic_symptom_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BasicQuestion.TABLE_NAME, BasicQuestion.BASIC_INTERVIEW_ID + " = '" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_SYMPTOM_ID + " = " + "'" + basic_symptom_id + "'",
                null);
        db.close();
    }

    public void deleteSuggestedItems(String basic_interview_id, String frag_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BasicQuestion.TABLE_NAME, BasicQuestion.BASIC_INTERVIEW_ID + " = '" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag_name + "'",
                null);
        db.close();
    }

    public void deleteMultipleQues(String basic_interview_id, String ques, String frag_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BasicQuestion.TABLE_NAME, BasicQuestion.BASIC_INTERVIEW_ID + " = '" + basic_interview_id + "'" + " AND " + BasicQuestion.QUES_TEXT + " = " + "'" + ques + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag_name + "'",
                null);
        db.close();
    }

    public int getBasicSymptomCount() {
        String countQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getBasicSymptomSuggestCount(String userid, String interviewid, String frag) {
        String countQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + userid + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + interviewid + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag + "'" ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getBasicSymptomInterviewID() {
        String countQuery = "SELECT  DISTINCT " + BasicQuestion.BASIC_INTERVIEW_ID + " FROM " + BasicQuestion.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getBasicSymptomQuestionCount(String userid, String interviewid, String frag) {
        String countQuery = "SELECT  DISTINCT " + BasicQuestion.QUES_TEXT + " FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + userid + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + interviewid + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public long updateBasicSymptom(String basic_user_id, String basic_user_name, String basic_interview_id, String ques_type, String ques_txt, String basic_symptom_id, String basic_symp_name, String basic_init, String basic_choice_id, String basic_date, String basic_fragment_name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BasicQuestion.BASIC_USER_ID, basic_user_id);
        values.put(BasicQuestion.BASIC_USER_NAME, basic_user_name);
        values.put(BasicQuestion.BASIC_INTERVIEW_ID, basic_interview_id);
        values.put(BasicQuestion.QUES_TYPE, ques_type);
        values.put(BasicQuestion.QUES_TEXT, ques_txt);
        values.put(BasicQuestion.BASIC_SYMPTOM_ID, basic_symptom_id);
        values.put(BasicQuestion.BASIC_SYMPTOM_NAME, basic_symp_name);
        values.put(BasicQuestion.BASIC_INITIAL, basic_init);
        values.put(BasicQuestion.BASIC_CHOICE_ID, basic_choice_id);
        values.put(BasicQuestion.BASIC_DATE, basic_date);
        values.put(BasicQuestion.BASIC_FRAGMENT_NAME, basic_fragment_name);

        // updating row
        return db.update(BasicQuestion.TABLE_NAME, values, BasicQuestion.BASIC_USER_ID + " = ? AND " + BasicQuestion.BASIC_INTERVIEW_ID + " =?  AND " + BasicQuestion.BASIC_SYMPTOM_ID + " =? AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " =?",
                new String[]{String.valueOf(basic_user_id),String.valueOf(basic_interview_id),String.valueOf(basic_symptom_id),String.valueOf(basic_fragment_name)});
    }

    public long updateBasicSymptomQuesBased(String basic_user_id, String basic_user_name, String basic_interview_id, String ques_type, String ques_txt, String basic_symptom_id, String basic_symp_name, String basic_init, String basic_choice_id, String basic_date, String basic_fragment_name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BasicQuestion.BASIC_USER_ID, basic_user_id);
        values.put(BasicQuestion.BASIC_USER_NAME, basic_user_name);
        values.put(BasicQuestion.BASIC_INTERVIEW_ID, basic_interview_id);
        values.put(BasicQuestion.QUES_TYPE, ques_type);
        values.put(BasicQuestion.QUES_TEXT, ques_txt);
        values.put(BasicQuestion.BASIC_SYMPTOM_ID, basic_symptom_id);
        values.put(BasicQuestion.BASIC_SYMPTOM_NAME, basic_symp_name);
        values.put(BasicQuestion.BASIC_INITIAL, basic_init);
        values.put(BasicQuestion.BASIC_CHOICE_ID, basic_choice_id);
        values.put(BasicQuestion.BASIC_DATE, basic_date);
        values.put(BasicQuestion.BASIC_FRAGMENT_NAME, basic_fragment_name);

        // updating row
        return db.update(BasicQuestion.TABLE_NAME, values, BasicQuestion.BASIC_USER_ID + " = ? AND " + BasicQuestion.BASIC_INTERVIEW_ID + " =?  AND " + BasicQuestion.QUES_TEXT + " =? AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " =?",
                new String[]{String.valueOf(basic_user_id),String.valueOf(basic_interview_id),String.valueOf(ques_txt),String.valueOf(basic_fragment_name)});
    }

    public String getLastRowFragmentName(String basic_user_id, String basic_interview_id) {
        String str, str2, str3 = null;
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + basic_user_id + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToLast()) {
            str  =  cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_FRAGMENT_NAME));
            str2  =  cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_DATE));
            str3 = str + " " + str2;
        }

        db.close();
        return str3;
    }

    public int getBasicSymptomCountAsPerFragment(String user_id, String interview_id, String frag_name) {
        String countQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + user_id + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + interview_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getBasicSymptomCountAsPerQuestion(String user_id, String interview_id, String ques, String frag_name) {
        String countQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + user_id + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + interview_id + "'" + " AND " + BasicQuestion.QUES_TEXT + " = " + "'" + ques + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public boolean CheckIsDataAlreadyInDBorNotID(String interview_id,
                                               String frag_name, String symptomid, String user_id) {
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + interview_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag_name + "'" + " AND " + BasicQuestion.BASIC_SYMPTOM_ID + " = " + "'" + symptomid + "'" + " AND " + BasicQuestion.BASIC_USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean CheckIsQuesDataAlreadyInDBorNot(String interview_id,
                                               String frag_name, String ques, String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "
                        + BasicQuestion.TABLE_NAME + " where " + BasicQuestion.BASIC_INTERVIEW_ID + "=?"
                        + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + "=?" + " AND " + BasicQuestion.QUES_TEXT + "=?" + " AND " +BasicQuestion.BASIC_USER_ID + "=?",
                new String[] {interview_id, frag_name, ques, user_id});
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean CheckIsQuestionAlreadyInDBorNot(String interview_id,
                                               String frag_name, String ques, String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "
                        + BasicQuestion.TABLE_NAME + " where " + BasicQuestion.BASIC_INTERVIEW_ID + "=?"
                        + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + "=?" + " AND " + BasicQuestion.QUES_TEXT + "=?" + " AND " +BasicQuestion.BASIC_USER_ID + "=?",
                new String[] {interview_id, frag_name, ques, user_id});
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean CheckIsSymptomIDAlreadyInDBorNot(String interview_id, String user_id, String symp_id, String frag_name) {
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + interview_id + "'" + " AND " + BasicQuestion.BASIC_USER_ID + " = " + "'" + user_id + "'" + " AND " + BasicQuestion.BASIC_SYMPTOM_ID + " = " + "'" + symp_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public String getChoiceIdFromQuestion(String basic_user_id, String basic_interview_id, String ques, String frag) {
        String str = null;
        String selectQuery = "SELECT  " + BasicQuestion.BASIC_CHOICE_ID + " FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + basic_user_id + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.QUES_TEXT + " = " + "'" + ques + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID));
            }while (cursor.moveToNext());
        }

        db.close();
        return str;
    }

    public String getChoiceIdFromSymptomId(String basic_user_id, String basic_interview_id, String symp_id, String frag) {
        String str = null;
        String selectQuery = "SELECT  " + BasicQuestion.BASIC_CHOICE_ID + " FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + basic_user_id + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_SYMPTOM_ID + " = " + "'" + symp_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_CHOICE_ID));
            }while (cursor.moveToNext());
        }

        db.close();
        return str;
    }

    public String getNameFromQuestion(String basic_user_id, String basic_interview_id, String ques, String frag) {
        String str = null;
        String selectQuery = "SELECT  " + BasicQuestion.BASIC_SYMPTOM_NAME + " FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + basic_user_id + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.QUES_TEXT + " = " + "'" + ques + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(BasicQuestion.BASIC_SYMPTOM_NAME));
            }while (cursor.moveToNext());
        }

        db.close();
        return str;
    }

    public String getLastRowQuestion(String basic_user_id, String basic_interview_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_USER_ID + " = " + "'" + basic_user_id + "'" + " AND " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + basic_interview_id + "'" + " AND " + BasicQuestion.BASIC_FRAGMENT_NAME + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToLast()) {
            str  =  cursor.getString(cursor.getColumnIndex(BasicQuestion.QUES_TEXT));
        }
        db.close();
        return str;
    }

    public boolean CheckIsInterviewIdDataAlreadyInDBorNot(String user_id, String interview_id) {
        String selectQuery = "SELECT  * FROM " + BasicQuestion.TABLE_NAME + " WHERE " + BasicQuestion.BASIC_INTERVIEW_ID + " = " + "'" + interview_id + "'" + " AND " + BasicQuestion.BASIC_USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public void deleteBasicQuestion(String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BasicQuestion.TABLE_NAME, BasicQuestion.BASIC_USER_ID + " = '" + user_id + "'",
                null);
        db.close();
    }
}
