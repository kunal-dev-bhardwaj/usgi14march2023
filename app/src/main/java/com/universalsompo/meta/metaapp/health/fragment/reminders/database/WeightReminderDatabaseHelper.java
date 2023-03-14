package com.universalsompo.meta.metaapp.health.fragment.reminders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.WeightReminder;

public class WeightReminderDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "weight_reminder_db";

    public WeightReminderDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WeightReminder.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WeightReminder.TABLE_NAME);
        onCreate(db);
    }

    public long insertWeightReminder(String user_id, String weekly_monthly, String day, String date, String time, String id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WeightReminder.USER_ID, user_id);
        values.put(WeightReminder.WEEKLY_MONTHLY, weekly_monthly);
        values.put(WeightReminder.DAY, day);
        values.put(WeightReminder.DATE, date);
        values.put(WeightReminder.TIME, time);
        values.put(WeightReminder.WEIGHT_REMIN_ID, id);
        values.put(WeightReminder.ACTIVE_DEACTIVE, active_deactive);
        long id1 = db.insert(WeightReminder.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public long updateStatusofReminder(String user_id, String weekly_monthly, String day, String date, String time, String id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WeightReminder.USER_ID, user_id);
        values.put(WeightReminder.WEEKLY_MONTHLY, weekly_monthly);
        values.put(WeightReminder.DAY, day);
        values.put(WeightReminder.DATE, date);
        values.put(WeightReminder.TIME, time);
        values.put(WeightReminder.WEIGHT_REMIN_ID, id);
        values.put(WeightReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(WeightReminder.TABLE_NAME, values, WeightReminder.USER_ID + " = ? AND " + WeightReminder.WEEKLY_MONTHLY + " =?",
                new String[]{String.valueOf(user_id),String.valueOf(weekly_monthly)});
    }

    public long updateStatusofReminder(String user_id, String weekly_monthly, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WeightReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(WeightReminder.TABLE_NAME, values, WeightReminder.USER_ID + " = ? AND " + WeightReminder.WEEKLY_MONTHLY + " = ?",
                new String[]{String.valueOf(user_id), String.valueOf(weekly_monthly)});
    }

    public String getWeeklyMonthlyReminder(String user_id, String active_deactive) {
        String str = null;
        String selectQuery = "SELECT  " + WeightReminder.WEEKLY_MONTHLY + " FROM " + WeightReminder.TABLE_NAME + " WHERE " + WeightReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WeightReminder.ACTIVE_DEACTIVE + " = " + "'" + active_deactive + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(WeightReminder.WEEKLY_MONTHLY));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public int getActiveCount(String userid, String active_deactive) {
        String countQuery = "SELECT  * FROM " + WeightReminder.TABLE_NAME + " WHERE " + WeightReminder.USER_ID + " = " + "'" + userid + "'" + " AND " + WeightReminder.ACTIVE_DEACTIVE + " = " + "'" + active_deactive + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public long updateStatusofReminder(String user_id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WeightReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(WeightReminder.TABLE_NAME, values, WeightReminder.USER_ID + " = ?",
                new String[]{String.valueOf(user_id)});
    }

    public boolean CheckIsDataAlreadyInDBorNotID(String user_id, String weekly_monthly) {
        String selectQuery = "SELECT  * FROM " + WeightReminder.TABLE_NAME + " WHERE " + WeightReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WeightReminder.WEEKLY_MONTHLY + " = " + "'" + weekly_monthly + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public String getStatus(String user_id, String weekly_monthly) {
        String str = null;
        String selectQuery = "SELECT  " + WeightReminder.ACTIVE_DEACTIVE + " FROM " + WeightReminder.TABLE_NAME + " WHERE " + WeightReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WeightReminder.WEEKLY_MONTHLY + " = " + "'" + weekly_monthly + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(WeightReminder.ACTIVE_DEACTIVE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getWeeklyDayReminder(String user_id, String weekly_monthly) {
        String str = null;
        String selectQuery = "SELECT  " + WeightReminder.DAY + " FROM " + WeightReminder.TABLE_NAME + " WHERE " + WeightReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WeightReminder.WEEKLY_MONTHLY + " = " + "'" + weekly_monthly + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(WeightReminder.DAY));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getMonthlyDateReminder(String user_id, String weekly_monthly) {
        String str = null;
        String selectQuery = "SELECT  " + WeightReminder.DATE + " FROM " + WeightReminder.TABLE_NAME + " WHERE " + WeightReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WeightReminder.WEEKLY_MONTHLY + " = " + "'" + weekly_monthly + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(WeightReminder.DATE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getMonthlyWeeklyTimeReminder(String user_id, String weekly_monthly) {
        String str = null;
        String selectQuery = "SELECT  " + WeightReminder.TIME + " FROM " + WeightReminder.TABLE_NAME + " WHERE " + WeightReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WeightReminder.WEEKLY_MONTHLY + " = " + "'" + weekly_monthly + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(WeightReminder.TIME));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }
}