package com.universalsompo.meta.metaapp.health.fragment.reminders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.LabTestReminder;

import java.util.ArrayList;
import java.util.List;

public class LabTestReminderDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lab_test_reminder_db";

    public LabTestReminderDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LabTestReminder.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LabTestReminder.TABLE_NAME);
        onCreate(db);
    }

    public long insertLabTestReminder(String user_id, String test_name, String lab_name, String date, String time, String id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LabTestReminder.USER_ID, user_id);
        values.put(LabTestReminder.TEST_NAME, test_name);
        values.put(LabTestReminder.LAB_NAME, lab_name);
        values.put(LabTestReminder.DATE, date);
        values.put(LabTestReminder.TIME, time);
        values.put(LabTestReminder.LAB_REMIN_ID, id);
        values.put(LabTestReminder.ACTIVE_DEACTIVE, active_deactive);
        long id1 = db.insert(LabTestReminder.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public int getCount(String user_id) {
        String countQuery = "SELECT  * FROM " + LabTestReminder.TABLE_NAME + " WHERE " + LabTestReminder.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void deleteLabtest(String user_id, String test_name, String lab_name, String lab_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LabTestReminder.TABLE_NAME, LabTestReminder.USER_ID + " = '" + user_id + "'" + " AND " + LabTestReminder.TEST_NAME + " = '" + test_name + "'" + " AND " + LabTestReminder.LAB_NAME + " = '" + lab_name + "'" + " AND " + LabTestReminder.LAB_REMIN_ID + " = '" + lab_id + "'",
                null);
        db.close();
    }

    public void deleteLabtest(String user_id, String lab_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LabTestReminder.TABLE_NAME, LabTestReminder.USER_ID + " = '" + user_id + "'" + " AND " + LabTestReminder.LAB_REMIN_ID + " = '" + lab_id + "'",
                null);
        db.close();
    }

    public List<LabTestReminder> getAllLabtest(String user_id) {
        List<LabTestReminder> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + LabTestReminder.TABLE_NAME + " WHERE " + LabTestReminder.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                LabTestReminder lab_test = new LabTestReminder();
                lab_test.setUserid(cursor.getString(cursor.getColumnIndex(LabTestReminder.USER_ID)));
                lab_test.setTestname(cursor.getString(cursor.getColumnIndex(LabTestReminder.TEST_NAME)));
                lab_test.setLabname(cursor.getString(cursor.getColumnIndex(LabTestReminder.LAB_NAME)));
                lab_test.setDate(cursor.getString(cursor.getColumnIndex(LabTestReminder.DATE)));
                lab_test.setTime(cursor.getString(cursor.getColumnIndex(LabTestReminder.TIME)));
                lab_test.setId(cursor.getString(cursor.getColumnIndex(LabTestReminder.LAB_REMIN_ID)));
                lab_test.setActivedeactive(cursor.getString(cursor.getColumnIndex(LabTestReminder.ACTIVE_DEACTIVE)));
                symps2.add(lab_test);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public long updateStatusofReminder(String user_id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LabTestReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(LabTestReminder.TABLE_NAME, values, LabTestReminder.USER_ID + " = ?",
                new String[]{String.valueOf(user_id)});
    }

    public String getStatusofReminder(String user_id, String lab_id) {
        String str = null;
        String selectQuery = "SELECT  " + LabTestReminder.ACTIVE_DEACTIVE + " FROM " + LabTestReminder.TABLE_NAME + " WHERE " + LabTestReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + LabTestReminder.LAB_REMIN_ID + " = " + "'" + lab_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LabTestReminder.ACTIVE_DEACTIVE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getTimeofReminder(String user_id, String labid) {
        String str = null;
        String selectQuery = "SELECT  " + LabTestReminder.TIME + " FROM " + LabTestReminder.TABLE_NAME + " WHERE " + LabTestReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + LabTestReminder.LAB_REMIN_ID + " = " + "'" + labid + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LabTestReminder.TIME));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getDateofReminder(String user_id, String labid) {
        String str = null;
        String selectQuery = "SELECT  " + LabTestReminder.DATE + " FROM " + LabTestReminder.TABLE_NAME + " WHERE " + LabTestReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + LabTestReminder.LAB_REMIN_ID + " = " + "'" + labid + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(LabTestReminder.DATE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public long updateStatusofReminder(String user_id, String labid, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LabTestReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(LabTestReminder.TABLE_NAME, values, LabTestReminder.USER_ID + " = ? AND " + LabTestReminder.LAB_REMIN_ID + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(labid)});
    }

    public int getdeactiveCount(String userid, String active_deactive) {
        String countQuery = "SELECT  * FROM " + LabTestReminder.TABLE_NAME + " WHERE " + LabTestReminder.USER_ID + " = " + "'" + userid + "'" + " AND " + LabTestReminder.ACTIVE_DEACTIVE + " = " + "'" + active_deactive + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}