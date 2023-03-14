package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.Conditions;

import java.util.ArrayList;
import java.util.List;

public class ConditionsDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "condition_added_db";

    public ConditionsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Conditions.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Conditions.TABLE_NAME);
        onCreate(db);
    }

    public long insertConditions(String user_id, String user_name, String interview_id, String condition_id, String condition_name, String condition_common_name, String probability) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Conditions.USER_ID, user_id);
        values.put(Conditions.USER_NAME, user_name);
        values.put(Conditions.INTERVIEW_ID, interview_id);
        values.put(Conditions.CONDITION_ID,condition_id);
        values.put(Conditions.CONDITION_NAME, condition_name);
        values.put(Conditions.CONDITION_COMMON_NAME, condition_common_name);
        values.put(Conditions.CONDITION_PROBABILITY, probability);
        long id1 = db.insert(Conditions.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public List<Conditions> getAllConditions(String interview_id) {
        List<Conditions> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + Conditions.TABLE_NAME + " WHERE " + Conditions.INTERVIEW_ID + " = " + "'" + interview_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Conditions basic_symps1 = new Conditions();
                basic_symps1.setUserid(cursor.getString(cursor.getColumnIndex(Conditions.USER_ID)));
                basic_symps1.setUsername(cursor.getString(cursor.getColumnIndex(Conditions.USER_NAME)));
                basic_symps1.setInterviewid(cursor.getString(cursor.getColumnIndex(Conditions.INTERVIEW_ID)));
                basic_symps1.setConditionid(cursor.getString(cursor.getColumnIndex(Conditions.CONDITION_ID)));
                basic_symps1.setConditionname(cursor.getString(cursor.getColumnIndex(Conditions.CONDITION_NAME)));
                basic_symps1.setConditioncommonname(cursor.getString(cursor.getColumnIndex(Conditions.CONDITION_COMMON_NAME)));
                basic_symps1.setConditionprobability(cursor.getString(cursor.getColumnIndex(Conditions.CONDITION_PROBABILITY)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public void deleteCondition(String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Conditions.TABLE_NAME, Conditions.USER_ID + " = '" + user_id + "'",
                null);
        db.close();
    }
}
