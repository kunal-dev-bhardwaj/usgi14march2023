package com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.symptomHRA.database.model.Result;

import java.io.File;

public class ResultDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "basic_symptom_result_added_db";

    public ResultDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Result.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Result.TABLE_NAME);
        onCreate(db);
    }

    public long insertbasicSymptomResult(String user_id, String interview_id, String result_value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Result.USER_ID, user_id);
        values.put(Result.SYMPTOM_ID, interview_id);
        values.put(Result.RESULT, result_value);
        long id1 = db.insert(Result.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public boolean CheckIsInterviewIdDataAlreadyInDBorNot(String user_id, String interview_id) {
        String selectQuery = "SELECT  * FROM " + Result.TABLE_NAME + " WHERE " + Result.SYMPTOM_ID + " = " + "'" + interview_id + "'" + " AND " + Result.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
    public   boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }

    public String getBasicSymptomResult(String user_id, String interview_id) {
        String str = null;
        String selectQuery = "SELECT  " + Result.RESULT + " FROM " + Result.TABLE_NAME + " WHERE " + Result.USER_ID + " = " + "'" + user_id + "'" + " AND " + Result.SYMPTOM_ID + " = " + "'" + interview_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(Result.RESULT));
            }while (cursor.moveToNext());
        }

        db.close();
        return str;
    }

    public void deleteResult(String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Result.TABLE_NAME, Result.USER_ID + " = '" + user_id + "'",
                null);
        db.close();
    }
}
