package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.SelectedSymptom;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "symptom_added_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SelectedSymptom.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SelectedSymptom.TABLE_NAME);
        onCreate(db);
    }

    public long insertSymptom(String user_id, String interview_id, String symptom_id, String symptom_name, String init, String choice_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SelectedSymptom.USER_ID, user_id);
        values.put(SelectedSymptom.INTERVIEW_ID, interview_id);
        values.put(SelectedSymptom.SYMPTOM_ID, symptom_id);
        values.put(SelectedSymptom.SYMPTOM_NAME, symptom_name);
        values.put(SelectedSymptom.INITIAL, init);
        values.put(SelectedSymptom.CHOICE_ID, choice_id);
        long id1 = db.insert(SelectedSymptom.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public long insertSymptom1(String user_id, String interview_id, String symptom_id, String symptom_name, String choice_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SelectedSymptom.USER_ID, user_id);
        values.put(SelectedSymptom.INTERVIEW_ID, interview_id);
        values.put(SelectedSymptom.SYMPTOM_ID, symptom_id);
        values.put(SelectedSymptom.SYMPTOM_NAME, symptom_name);
        values.put(SelectedSymptom.CHOICE_ID, choice_id);
        long id1 = db.insert(SelectedSymptom.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public List<SelectedSymptom> getAllSymptom(String interview_id) {
        List<SelectedSymptom> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + SelectedSymptom.TABLE_NAME + " WHERE " + SelectedSymptom.INTERVIEW_ID + " = " + "'" + interview_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                SelectedSymptom symps1 = new SelectedSymptom();
                symps1.setUserid(cursor.getString(cursor.getColumnIndex(SelectedSymptom.USER_ID)));
                symps1.setInterviewid(cursor.getString(cursor.getColumnIndex(SelectedSymptom.INTERVIEW_ID)));
                symps1.setSymptomid(cursor.getString(cursor.getColumnIndex(SelectedSymptom.SYMPTOM_ID)));
                symps1.setName(cursor.getString(cursor.getColumnIndex(SelectedSymptom.SYMPTOM_NAME)));
                symps1.setInit(cursor.getString(cursor.getColumnIndex(SelectedSymptom.INITIAL)));
                symps1.setChoiceid(cursor.getString(cursor.getColumnIndex(SelectedSymptom.CHOICE_ID)));
                symps2.add(symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public void deleteSymptom(String symptom_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SelectedSymptom.TABLE_NAME, SelectedSymptom.SYMPTOM_ID + " = ?",
                new String[]{symptom_id});
        db.close();
    }
}
