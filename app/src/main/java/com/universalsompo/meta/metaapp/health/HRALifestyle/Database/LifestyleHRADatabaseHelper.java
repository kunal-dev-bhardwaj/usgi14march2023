package com.universalsompo.meta.metaapp.health.HRALifestyle.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.HRALifestyle.Database.Model.LifestyleHRAModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LifestyleHRADatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "lifestyle_hra_db";


    public LifestyleHRADatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(LifestyleHRAModel.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + LifestyleHRAModel.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertLifestyleHRAValues(String user_id, String auth_token, String account_id, String person_id, String template_id, String question_id, String question, String question_code, String col1, String col2, String col3, String col4, String col5, String col6, String category, String answer_code, String answer_other, String parameter_code, String unit, String yes_no, String fragment) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(LifestyleHRAModel.COLUMN_USERID, user_id);
        values.put(LifestyleHRAModel.COLUMN_AUTH_TOKEN, auth_token);
        values.put(LifestyleHRAModel.COLUMN_ACCOUNT_ID, account_id);
        values.put(LifestyleHRAModel.COLUMN_PERSON_ID, person_id);
        values.put(LifestyleHRAModel.COLUMN_TEMPLATE_ID, template_id);
        values.put(LifestyleHRAModel.COLUMN_QUESTION_ID, question_id);
        values.put(LifestyleHRAModel.COLUMN_QUESTION, question);
        values.put(LifestyleHRAModel.COLUMN_QUESTION_CODE, question_code);
        values.put(LifestyleHRAModel.COLUMN_COL1, col1);
        values.put(LifestyleHRAModel.COLUMN_COL2, col2);
        values.put(LifestyleHRAModel.COLUMN_COL3, col3);
        values.put(LifestyleHRAModel.COLUMN_COL4, col4);
        values.put(LifestyleHRAModel.COLUMN_COL5, col5);
        values.put(LifestyleHRAModel.COLUMN_COL6, col6);
        values.put(LifestyleHRAModel.COLUMN_CATEGORY, category);
        values.put(LifestyleHRAModel.COLUMN_ANSWER_CODE, answer_code);
        values.put(LifestyleHRAModel.COLUMN_ANSWER_OTHER, answer_other);
        values.put(LifestyleHRAModel.COLUMN_PARAMETER_CODE, parameter_code);
        values.put(LifestyleHRAModel.COLUMN_UNIT, unit);
        values.put(LifestyleHRAModel.COLUMN_YES_NO, yes_no);
        values.put(LifestyleHRAModel.COLUMN_FRAGMENT, fragment);

        long id = db.insert(LifestyleHRAModel.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public long updateLifestyleValue(String user_id, String auth_token, String account_id, String person_id, String template_id, String question_id, String question, String question_code, String col1, String col2, String col3, String col4, String col5, String col6, String category, String answer_code, String answer_other, String parameter_code, String unit, String yes_no, String fragment) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LifestyleHRAModel.COLUMN_USERID, user_id);
        values.put(LifestyleHRAModel.COLUMN_AUTH_TOKEN, auth_token);
        values.put(LifestyleHRAModel.COLUMN_ACCOUNT_ID, account_id);
        values.put(LifestyleHRAModel.COLUMN_PERSON_ID, person_id);
        values.put(LifestyleHRAModel.COLUMN_TEMPLATE_ID, template_id);
        values.put(LifestyleHRAModel.COLUMN_QUESTION_ID, question_id);
        values.put(LifestyleHRAModel.COLUMN_QUESTION, question);
        values.put(LifestyleHRAModel.COLUMN_QUESTION_CODE, question_code);
        values.put(LifestyleHRAModel.COLUMN_COL1, col1);
        values.put(LifestyleHRAModel.COLUMN_COL2, col2);
        values.put(LifestyleHRAModel.COLUMN_COL3, col3);
        values.put(LifestyleHRAModel.COLUMN_COL4, col4);
        values.put(LifestyleHRAModel.COLUMN_COL5, col5);
        values.put(LifestyleHRAModel.COLUMN_COL6, col6);
        values.put(LifestyleHRAModel.COLUMN_CATEGORY, category);
        values.put(LifestyleHRAModel.COLUMN_ANSWER_CODE, answer_code);
        values.put(LifestyleHRAModel.COLUMN_ANSWER_OTHER, answer_other);
        values.put(LifestyleHRAModel.COLUMN_PARAMETER_CODE, parameter_code);
        values.put(LifestyleHRAModel.COLUMN_UNIT, unit);
        values.put(LifestyleHRAModel.COLUMN_YES_NO, yes_no);
        values.put(LifestyleHRAModel.COLUMN_FRAGMENT, fragment);

        // updating row
        return db.update(LifestyleHRAModel.TABLE_NAME, values, LifestyleHRAModel.COLUMN_USERID + " = ? AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " =?",
                new String[]{String.valueOf(user_id),String.valueOf(fragment)});
    }

    public long updateLifestyleValue1(String user_id, String auth_token, String account_id, String person_id, String template_id, String question_id, String question, String question_code, String col1, String col2, String col3, String col4, String col5, String col6, String category, String answer_code, String answer_other, String parameter_code, String unit, String yes_no, String fragment) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LifestyleHRAModel.COLUMN_USERID, user_id);
        values.put(LifestyleHRAModel.COLUMN_AUTH_TOKEN, auth_token);
        values.put(LifestyleHRAModel.COLUMN_ACCOUNT_ID, account_id);
        values.put(LifestyleHRAModel.COLUMN_PERSON_ID, person_id);
        values.put(LifestyleHRAModel.COLUMN_TEMPLATE_ID, template_id);
        values.put(LifestyleHRAModel.COLUMN_QUESTION_ID, question_id);
        values.put(LifestyleHRAModel.COLUMN_QUESTION, question);
        values.put(LifestyleHRAModel.COLUMN_QUESTION_CODE, question_code);
        values.put(LifestyleHRAModel.COLUMN_COL1, col1);
        values.put(LifestyleHRAModel.COLUMN_COL2, col2);
        values.put(LifestyleHRAModel.COLUMN_COL3, col3);
        values.put(LifestyleHRAModel.COLUMN_COL4, col4);
        values.put(LifestyleHRAModel.COLUMN_COL5, col5);
        values.put(LifestyleHRAModel.COLUMN_COL6, col6);
        values.put(LifestyleHRAModel.COLUMN_CATEGORY, category);
        values.put(LifestyleHRAModel.COLUMN_ANSWER_CODE, answer_code);
        values.put(LifestyleHRAModel.COLUMN_ANSWER_OTHER, answer_other);
        values.put(LifestyleHRAModel.COLUMN_PARAMETER_CODE, parameter_code);
        values.put(LifestyleHRAModel.COLUMN_UNIT, unit);
        values.put(LifestyleHRAModel.COLUMN_YES_NO, yes_no);
        values.put(LifestyleHRAModel.COLUMN_FRAGMENT, fragment);

        // updating row
        return db.update(LifestyleHRAModel.TABLE_NAME, values, LifestyleHRAModel.COLUMN_USERID + " = ? AND " + LifestyleHRAModel.COLUMN_COL1 + " = ? AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(col1), String.valueOf(fragment)});
    }

    public long updateLifestyleValueOther(String user_id, String auth_token, String account_id, String person_id, String template_id, String question_id, String question, String question_code, String col1, String col2, String col3, String col4, String col5, String col6, String category, String answer_code, String answer_other, String parameter_code, String unit, String yes_no, String fragment) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LifestyleHRAModel.COLUMN_USERID, user_id);
        values.put(LifestyleHRAModel.COLUMN_AUTH_TOKEN, auth_token);
        values.put(LifestyleHRAModel.COLUMN_ACCOUNT_ID, account_id);
        values.put(LifestyleHRAModel.COLUMN_PERSON_ID, person_id);
        values.put(LifestyleHRAModel.COLUMN_TEMPLATE_ID, template_id);
        values.put(LifestyleHRAModel.COLUMN_QUESTION_ID, question_id);
        values.put(LifestyleHRAModel.COLUMN_QUESTION, question);
        values.put(LifestyleHRAModel.COLUMN_QUESTION_CODE, question_code);
        values.put(LifestyleHRAModel.COLUMN_COL1, col1);
        values.put(LifestyleHRAModel.COLUMN_COL2, col2);
        values.put(LifestyleHRAModel.COLUMN_COL3, col3);
        values.put(LifestyleHRAModel.COLUMN_COL4, col4);
        values.put(LifestyleHRAModel.COLUMN_COL5, col5);
        values.put(LifestyleHRAModel.COLUMN_COL6, col6);
        values.put(LifestyleHRAModel.COLUMN_CATEGORY, category);
        values.put(LifestyleHRAModel.COLUMN_ANSWER_CODE, answer_code);
        values.put(LifestyleHRAModel.COLUMN_ANSWER_OTHER, answer_other);
        values.put(LifestyleHRAModel.COLUMN_PARAMETER_CODE, parameter_code);
        values.put(LifestyleHRAModel.COLUMN_UNIT, unit);
        values.put(LifestyleHRAModel.COLUMN_YES_NO, yes_no);
        values.put(LifestyleHRAModel.COLUMN_FRAGMENT, fragment);

        // updating row
        return db.update(LifestyleHRAModel.TABLE_NAME, values, LifestyleHRAModel.COLUMN_USERID + " = ? AND " + LifestyleHRAModel.COLUMN_COL1 + " = ? AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(col1), String.valueOf(fragment)});
    }

    public void deleteChoosenValue(String user_id, String frag_name, String answer_code) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LifestyleHRAModel.TABLE_NAME, LifestyleHRAModel.COLUMN_USERID + " = '" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'"  + " AND " + LifestyleHRAModel.COLUMN_ANSWER_CODE + " = " + "'" + answer_code + "'",
                null);
        db.close();
    }

    public int getLifestyleCount() {
        String countQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public String getLifestyleAuthTicket() {
        String str = null;
        String selectQuery = "SELECT  DISTINCT " + LifestyleHRAModel.COLUMN_AUTH_TOKEN + " FROM " + LifestyleHRAModel.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_AUTH_TOKEN));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestylePersonId() {
        String str = null;
        String selectQuery = "SELECT  DISTINCT " + LifestyleHRAModel.COLUMN_PERSON_ID + " FROM " + LifestyleHRAModel.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_PERSON_ID));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleAccountId() {
        String str = null;
        String selectQuery = "SELECT  DISTINCT " + LifestyleHRAModel.COLUMN_ACCOUNT_ID + " FROM " + LifestyleHRAModel.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ACCOUNT_ID));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleTemplateId() {
        String str = null;
        String selectQuery = "SELECT  DISTINCT " + LifestyleHRAModel.COLUMN_TEMPLATE_ID + " FROM " + LifestyleHRAModel.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_TEMPLATE_ID));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLastRowFragmentName(String user_id) {
        String str = null, str2 = null, str3 = null;
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToLast()) {
            str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_FRAGMENT));
        }
        db.close();
        return str;
    }

    public int getQuestionCountAsPerFragment(String user_id, String ques, String frag_name) {
        String countQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_QUESTION + " = " + "'" + ques + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public boolean CheckIsDataAlreadyInDBorNotID(String user_id, String ques, String frag_name) {
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_QUESTION + " = " + "'" + ques + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean CheckIsDataAlreadyInDBorNotID(String user_id) {
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'";
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

    public boolean CheckIsDataCol1AlreadyInDBorNotID(String user_id, String col1, String frag_name) {
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_COL1 + " = " + "'" + col1 + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean CheckIsAnswerCodeAlreadyInDBorNotID(String user_id, String answer_code, String frag_name) {
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_ANSWER_CODE + " = " + "'" + answer_code + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean CheckIsDataAlreadyInDBorNotID(String user_id, String frag_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "
                        + LifestyleHRAModel.TABLE_NAME + " where " + LifestyleHRAModel.COLUMN_USERID + "=?"
                        + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + "=?",
                new String[] {user_id, frag_name});
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public boolean CheckIsOthersAlreadyInDBorNotID(String user_id, String other, String frag_name) {
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_COL1 + " = " + "'" + other + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public String getLifestyleBMIValues(String user_id, String frag_name) {
        String str = null, str1 = null, str2 = null, str3 = null;
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_TEMPLATE_ID));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleCol1Value(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_COL1 + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL1));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleCol2Value(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_COL2 + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL2));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleCol3Value(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_COL3 + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL3));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleCol4Value(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_COL4 + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL4));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleCol5Value(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_COL5 + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL5));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleCol6Value(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_COL6 + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL6));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleAnswerCodeValue(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_ANSWER_CODE + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_CODE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleQuestionIDValue(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_QUESTION_ID + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION_ID));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleOtherValue(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_ANSWER_OTHER + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_OTHER));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public List<LifestyleHRAModel> getAllFamilyHist(String user_id, String session_id, String fragment_name) {
        List<LifestyleHRAModel> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_AUTH_TOKEN + " = " + "'" + session_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + fragment_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                LifestyleHRAModel basic_symps1 = new LifestyleHRAModel();
                basic_symps1.setUserid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_USERID)));
                basic_symps1.setAuthtoken(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_AUTH_TOKEN)));
                basic_symps1.setAccountid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ACCOUNT_ID)));
                basic_symps1.setPersonid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_PERSON_ID)));
                basic_symps1.setTemplateid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_TEMPLATE_ID)));
                basic_symps1.setQuestionid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION_ID)));
                basic_symps1.setQuestion(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION)));
                basic_symps1.setQuestioncode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION_CODE)));
                basic_symps1.setCol1(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL1)));
                basic_symps1.setCol2(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL2)));
                basic_symps1.setCol3(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL3)));
                basic_symps1.setCol4(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL4)));
                basic_symps1.setCol5(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL5)));
                basic_symps1.setCol6(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL6)));
                basic_symps1.setCategory(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_CATEGORY)));
                basic_symps1.setAnswercode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_CODE)));
                basic_symps1.setAnswerother(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_OTHER)));
                basic_symps1.setParametercode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_PARAMETER_CODE)));
                basic_symps1.setUnit(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_UNIT)));
                basic_symps1.setYesno(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_YES_NO)));
                basic_symps1.setFragment(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_FRAGMENT)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public List<LifestyleHRAModel> getAllUserHist(String user_id, String session_id, String fragment_name) {
        List<LifestyleHRAModel> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_AUTH_TOKEN + " = " + "'" + session_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + fragment_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                LifestyleHRAModel basic_symps1 = new LifestyleHRAModel();
                basic_symps1.setUserid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_USERID)));
                basic_symps1.setAuthtoken(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_AUTH_TOKEN)));
                basic_symps1.setAccountid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ACCOUNT_ID)));
                basic_symps1.setPersonid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_PERSON_ID)));
                basic_symps1.setTemplateid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_TEMPLATE_ID)));
                basic_symps1.setQuestionid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION_ID)));
                basic_symps1.setQuestion(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION)));
                basic_symps1.setQuestioncode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION_CODE)));
                basic_symps1.setCol1(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL1)));
                basic_symps1.setCol2(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL2)));
                basic_symps1.setCol3(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL3)));
                basic_symps1.setCol4(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL4)));
                basic_symps1.setCol5(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL5)));
                basic_symps1.setCol6(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL6)));
                basic_symps1.setCategory(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_CATEGORY)));
                basic_symps1.setAnswercode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_CODE)));
                basic_symps1.setAnswerother(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_OTHER)));
                basic_symps1.setParametercode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_PARAMETER_CODE)));
                basic_symps1.setUnit(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_UNIT)));
                basic_symps1.setYesno(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_YES_NO)));
                basic_symps1.setFragment(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_FRAGMENT)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public List<LifestyleHRAModel> getAllUserHealth(String user_id, String session_id, String fragment_name) {
        List<LifestyleHRAModel> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_AUTH_TOKEN + " = " + "'" + session_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + fragment_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                LifestyleHRAModel basic_symps1 = new LifestyleHRAModel();
                basic_symps1.setUserid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_USERID)));
                basic_symps1.setAuthtoken(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_AUTH_TOKEN)));
                basic_symps1.setAccountid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ACCOUNT_ID)));
                basic_symps1.setPersonid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_PERSON_ID)));
                basic_symps1.setTemplateid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_TEMPLATE_ID)));
                basic_symps1.setQuestionid(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION_ID)));
                basic_symps1.setQuestion(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION)));
                basic_symps1.setQuestioncode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION_CODE)));
                basic_symps1.setCol1(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL1)));
                basic_symps1.setCol2(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL2)));
                basic_symps1.setCol3(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL3)));
                basic_symps1.setCol4(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL4)));
                basic_symps1.setCol5(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL5)));
                basic_symps1.setCol6(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_COL6)));
                basic_symps1.setCategory(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_CATEGORY)));
                basic_symps1.setAnswercode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_CODE)));
                basic_symps1.setAnswerother(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_OTHER)));
                basic_symps1.setParametercode(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_PARAMETER_CODE)));
                basic_symps1.setUnit(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_UNIT)));
                basic_symps1.setYesno(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_YES_NO)));
                basic_symps1.setFragment(cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_FRAGMENT)));
                symps2.add(basic_symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public String getLifestyleAnsOtherValue(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_ANSWER_OTHER + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_ANSWER_OTHER));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleYesNoValue(String user_id, String col1,String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_YES_NO + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_COL1 + " = " + "'" + col1 + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_YES_NO));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public void deleteOtherValues(String other, String frag_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LifestyleHRAModel.TABLE_NAME, LifestyleHRAModel.COLUMN_COL1 + " = '" + other + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = '" + frag_name + "'",
                null);
        db.close();
    }

    public int getLifeStyleCount() {
        String countQuery = "SELECT  * FROM " + LifestyleHRAModel.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public String getLifestyleCategoryValue(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_CATEGORY + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_CATEGORY));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getLifestyleQuestionCodeValue(String user_id, String frag_name) {
        String str = null;
        String selectQuery = "SELECT " + LifestyleHRAModel.COLUMN_QUESTION_CODE + " FROM " + LifestyleHRAModel.TABLE_NAME + " WHERE " + LifestyleHRAModel.COLUMN_USERID + " = " + "'" + user_id + "'" + " AND " + LifestyleHRAModel.COLUMN_FRAGMENT + " = " + "'" + frag_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LifestyleHRAModel.COLUMN_QUESTION_CODE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public void deleteLifestyleHRA(String user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LifestyleHRAModel.TABLE_NAME, LifestyleHRAModel.COLUMN_USERID + " = '" + user_id + "'",
                null);
        db.close();
    }
}
