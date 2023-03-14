package com.universalsompo.meta.metaapp.health.HRALifestyle.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.Model.ResultLifestyleModel;

public class LifestyleResultDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lifestyle_result_added_db";

    public LifestyleResultDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ResultLifestyleModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ResultLifestyleModel.TABLE_NAME);
        onCreate(db);
    }

    public long insertbasicSymptomResult(String user_id, String auth_token, String result_value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ResultLifestyleModel.USER_ID, user_id);
        values.put(ResultLifestyleModel.LIFESTYLE_AUTH_TOKEN, auth_token);
        values.put(ResultLifestyleModel.RESULT, result_value);
        long id1 = db.insert(ResultLifestyleModel.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public boolean CheckIsAuthTokenDataAlreadyInDBorNot(String user_id, String auth_token) {
        String selectQuery = "SELECT  * FROM " + ResultLifestyleModel.TABLE_NAME + " WHERE " + ResultLifestyleModel.LIFESTYLE_AUTH_TOKEN + " = " + "'" + auth_token + "'" + " AND " + ResultLifestyleModel.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public String getLifestyleResult(String user_id, String auth_token) {
        String str = null;
        String selectQuery = "SELECT  " + ResultLifestyleModel.RESULT + " FROM " + ResultLifestyleModel.TABLE_NAME + " WHERE " + ResultLifestyleModel.USER_ID + " = " + "'" + user_id + "'" + " AND " + ResultLifestyleModel.LIFESTYLE_AUTH_TOKEN + " = " + "'" + auth_token + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(ResultLifestyleModel.RESULT));
            }while (cursor.moveToNext());
        }

        db.close();
        return str;
    }

    public void deleteResultLifestyle(String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ResultLifestyleModel.TABLE_NAME, ResultLifestyleModel.USER_ID + " = '" + user_id + "'",
                null);
        db.close();
    }
}
