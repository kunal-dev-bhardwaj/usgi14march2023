package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.AddedSymptom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SelectedSympDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_symptom_added_db";

    public SelectedSympDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AddedSymptom.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AddedSymptom.TABLE_NAME);
        onCreate(db);
    }

    public long insertSymptom(String user_id, String user_name, String interview_id, String ques_type, String ques_text, String symptom_id, String symptom_name, String init, String choice_id, String date, String symptom_frag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AddedSymptom.USER_ID, user_id);
        values.put(AddedSymptom.USER_NAME, user_name);
        values.put(AddedSymptom.INTERVIEW_ID, interview_id);
        values.put(AddedSymptom.QUES_TYPE, ques_type);
        values.put(AddedSymptom.QUES_TEXT, ques_text);
        values.put(AddedSymptom.SYMPTOM_ID, symptom_id);
        values.put(AddedSymptom.SYMPTOM_NAME, symptom_name);
        values.put(AddedSymptom.INITIAL, init);
        values.put(AddedSymptom.CHOICE_ID, choice_id);
        values.put(AddedSymptom.DATE, date);
        values.put(AddedSymptom.SYMPTOM_FRAG, symptom_frag);
        long id1 = db.insert(AddedSymptom.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public List<AddedSymptom> getAllUserSymptom(String interview_id, String symptom_frag) {
        List<AddedSymptom> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + AddedSymptom.TABLE_NAME + " WHERE " + AddedSymptom.INTERVIEW_ID + " = " + "'" + interview_id + "'" + " AND " + AddedSymptom.SYMPTOM_FRAG + " = " + "'" + symptom_frag + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                AddedSymptom basic_symps1 = new AddedSymptom();
                basic_symps1.setUserid(cursor.getString(cursor.getColumnIndex(AddedSymptom.USER_ID)));
                basic_symps1.setUsername(cursor.getString(cursor.getColumnIndex(AddedSymptom.USER_NAME)));
                basic_symps1.setInterviewid(cursor.getString(cursor.getColumnIndex(AddedSymptom.INTERVIEW_ID)));
                basic_symps1.setQuestype(cursor.getString(cursor.getColumnIndex(AddedSymptom.QUES_TYPE)));
                basic_symps1.setQuestext(cursor.getString(cursor.getColumnIndex(AddedSymptom.QUES_TEXT)));
                basic_symps1.setSymptomid(cursor.getString(cursor.getColumnIndex(AddedSymptom.SYMPTOM_ID)));
                basic_symps1.setName(cursor.getString(cursor.getColumnIndex(AddedSymptom.SYMPTOM_NAME)));
                basic_symps1.setInit(cursor.getString(cursor.getColumnIndex(AddedSymptom.INITIAL)));
                basic_symps1.setChoiceid(cursor.getString(cursor.getColumnIndex(AddedSymptom.CHOICE_ID)));
                basic_symps1.setDate(cursor.getString(cursor.getColumnIndex(AddedSymptom.DATE)));
                basic_symps1.setSymptomfrag(cursor.getString(cursor.getColumnIndex(AddedSymptom.SYMPTOM_FRAG)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public List<AddedSymptom> getAllUserSymptom(String interview_id) {
        List<AddedSymptom> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + AddedSymptom.TABLE_NAME + " WHERE " + AddedSymptom.INTERVIEW_ID + " = " + "'" + interview_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                AddedSymptom basic_symps1 = new AddedSymptom();
                basic_symps1.setUserid(cursor.getString(cursor.getColumnIndex(AddedSymptom.USER_ID)));
                basic_symps1.setUsername(cursor.getString(cursor.getColumnIndex(AddedSymptom.USER_NAME)));
                basic_symps1.setInterviewid(cursor.getString(cursor.getColumnIndex(AddedSymptom.INTERVIEW_ID)));
                basic_symps1.setQuestype(cursor.getString(cursor.getColumnIndex(AddedSymptom.QUES_TYPE)));
                basic_symps1.setQuestext(cursor.getString(cursor.getColumnIndex(AddedSymptom.QUES_TEXT)));
                basic_symps1.setSymptomid(cursor.getString(cursor.getColumnIndex(AddedSymptom.SYMPTOM_ID)));
                basic_symps1.setName(cursor.getString(cursor.getColumnIndex(AddedSymptom.SYMPTOM_NAME)));
                basic_symps1.setInit(cursor.getString(cursor.getColumnIndex(AddedSymptom.INITIAL)));
                basic_symps1.setChoiceid(cursor.getString(cursor.getColumnIndex(AddedSymptom.CHOICE_ID)));
                basic_symps1.setDate(cursor.getString(cursor.getColumnIndex(AddedSymptom.DATE)));
                basic_symps1.setSymptomfrag(cursor.getString(cursor.getColumnIndex(AddedSymptom.SYMPTOM_FRAG)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }
    public   boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
    public void deleteUserSymptom(String user_symptom_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AddedSymptom.TABLE_NAME, AddedSymptom.SYMPTOM_ID + " = ?",
                new String[]{user_symptom_id});
        db.close();
    }

    public int getSymptomInterviewID() {
        String countQuery = "SELECT  DISTINCT " + AddedSymptom.INTERVIEW_ID + " FROM " + AddedSymptom.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getAddedSymptomCount() {
        String countQuery = "SELECT  * FROM " + AddedSymptom.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public String getLastRowFragmentName(String basic_user_id, String basic_interview_id) {
        String str = null, str2 = null, str3 = null;
        String selectQuery = "SELECT  * FROM " + AddedSymptom.TABLE_NAME + " WHERE " + AddedSymptom.USER_ID + " = " + "'" + basic_user_id + "'" + " AND " + AddedSymptom.INTERVIEW_ID + " = " + "'" + basic_interview_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToLast()) {
            str  =  cursor.getString(cursor.getColumnIndex(AddedSymptom.SYMPTOM_FRAG));
            str2  =  cursor.getString(cursor.getColumnIndex(AddedSymptom.DATE));
            str3 = str + " " + str2;
        }
        db.close();
        return str3;
    }

    public boolean CheckIsInterviewIdDataAlreadyInDBorNot(String user_id, String interview_id) {
        String selectQuery = "SELECT  * FROM " + AddedSymptom.TABLE_NAME + " WHERE " + AddedSymptom.INTERVIEW_ID + " = " + "'" + interview_id + "'" + " AND " + AddedSymptom.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public void deleteSelectedSymp(String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(AddedSymptom.TABLE_NAME, AddedSymptom.USER_ID + " = '" + user_id + "'",
                null);
        db.close();
    }
}
