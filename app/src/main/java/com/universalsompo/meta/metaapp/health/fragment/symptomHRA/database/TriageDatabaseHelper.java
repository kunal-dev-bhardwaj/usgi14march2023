package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.Triage;

import java.util.ArrayList;
import java.util.List;

public class TriageDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "triage_added_db";

    public TriageDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Triage.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Triage.TABLE_NAME);
        onCreate(db);
    }

    public long insertTriage(String user_id, String user_name, String interview_id, String triage_id, String triage_name, String triage_common_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Triage.USER_ID, user_id);
        values.put(Triage.USER_NAME, user_name);
        values.put(Triage.INTERVIEW_ID, interview_id);
        values.put(Triage.TRIAGE_ID,triage_id);
        values.put(Triage.TRIAGE_NAME, triage_name);
        values.put(Triage.TRIAGE_COMMON_NAME, triage_common_name);
        long id1 = db.insert(Triage.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public List<Triage> getAllTriage(String interview_id) {
        List<Triage> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + Triage.TABLE_NAME + " WHERE " + Triage.INTERVIEW_ID + " = " + "'" + interview_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Triage basic_symps1 = new Triage();
                basic_symps1.setUserid(cursor.getString(cursor.getColumnIndex(Triage.USER_ID)));
                basic_symps1.setUsername(cursor.getString(cursor.getColumnIndex(Triage.USER_NAME)));
                basic_symps1.setInterviewid(cursor.getString(cursor.getColumnIndex(Triage.INTERVIEW_ID)));
                basic_symps1.setTriageid(cursor.getString(cursor.getColumnIndex(Triage.TRIAGE_ID)));
                basic_symps1.setTriagename(cursor.getString(cursor.getColumnIndex(Triage.TRIAGE_NAME)));
                basic_symps1.setTriagecommonname(cursor.getString(cursor.getColumnIndex(Triage.TRIAGE_COMMON_NAME)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public void deleteTriage(String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Triage.TABLE_NAME, Triage.USER_ID + " = '" + user_id + "'",
                null);
        db.close();
    }
}
