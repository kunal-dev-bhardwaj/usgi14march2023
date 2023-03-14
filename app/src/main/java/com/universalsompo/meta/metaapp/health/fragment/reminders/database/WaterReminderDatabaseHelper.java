package com.universalsompo.meta.metaapp.health.fragment.reminders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.WaterTypeReminder;
import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.WorkOutTypeReminder;

public class WaterReminderDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "water_type_reminder_db";

    public WaterReminderDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WaterTypeReminder.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WaterTypeReminder.TABLE_NAME);
        onCreate(db);
    }


    public long insertWaterTypeReminder(String user_id, String water_reminder, String type_of_interval, String start_time, String end_time, String no_of_times,String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WaterTypeReminder.USER_ID, user_id);
        values.put(WaterTypeReminder.TYPE_OF_REMINDER, water_reminder);
        values.put(WaterTypeReminder.TIME_OF_INTERVAL, type_of_interval);
        values.put(WaterTypeReminder.START_TIME, start_time);
        values.put(WaterTypeReminder.END_TIME, end_time);
        values.put(WaterTypeReminder.NO_OF_TIMES, no_of_times);
        values.put(WaterTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        long id1 = db.insert(WaterTypeReminder.TABLE_NAME, null, values);
        db.close();
        return id1;
    }


    public String getStatusofReminder(String user_id, String water_reminder, String type_of_interval) {
        String str = null;
        String selectQuery = "SELECT  " + WaterTypeReminder.ACTIVE_DEACTIVE + " FROM " + WaterTypeReminder.TABLE_NAME + " WHERE " + WaterTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WaterTypeReminder.TYPE_OF_REMINDER + " = " + "'" + water_reminder + "'" + " AND " + WaterTypeReminder.TIME_OF_INTERVAL + " = " + "'" + type_of_interval + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                str = cursor.getString(cursor.getColumnIndex(WaterTypeReminder.ACTIVE_DEACTIVE));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return str;
    }


    public int getStatusofReminder(String user_id) {
        String selectQuery = "SELECT COUNT(*) FROM " + WaterTypeReminder.TABLE_NAME + " WHERE " + WaterTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + "active_deactive='active'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int sum = 0;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    sum = cursor.getInt(0);
                }
            } finally {
                cursor.close();
            }
        }
        return sum;
    }
    public String getStartTimeofReminder(String user_id, String water_reminder, String type_of_inteval) {
        String str = null;
        String selectQuery = "SELECT  " + WaterTypeReminder.START_TIME + " FROM " + WaterTypeReminder.TABLE_NAME + " WHERE " + WaterTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WaterTypeReminder.TYPE_OF_REMINDER + " = " + "'" + water_reminder + "'" + " AND " + WaterTypeReminder.TIME_OF_INTERVAL + " = " + "'" + type_of_inteval + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                str = cursor.getString(cursor.getColumnIndex(WaterTypeReminder.START_TIME));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return str;
    }

    public String getEndTimeofReminder(String user_id, String water_reminder, String type_of_inteval) {
        String str = null;
        String selectQuery = "SELECT  " + WaterTypeReminder.END_TIME + " FROM " + WaterTypeReminder.TABLE_NAME + " WHERE " + WaterTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WaterTypeReminder.TYPE_OF_REMINDER + " = " + "'" + water_reminder + "'" + " AND " + WaterTypeReminder.TIME_OF_INTERVAL + " = " + "'" + type_of_inteval + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                str = cursor.getString(cursor.getColumnIndex(WaterTypeReminder.END_TIME));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return str;
    }

    public String getNoOfTimeofReminder(String user_id, String water_reminder, String type_of_inteval) {
        String str = null;
        String selectQuery = "SELECT  " + WaterTypeReminder.NO_OF_TIMES + " FROM " + WaterTypeReminder.TABLE_NAME + " WHERE " + WaterTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WaterTypeReminder.TYPE_OF_REMINDER + " = " + "'" + water_reminder + "'" + " AND " + WaterTypeReminder.TIME_OF_INTERVAL + " = " + "'" + type_of_inteval + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                str = cursor.getString(cursor.getColumnIndex(WaterTypeReminder.NO_OF_TIMES));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return str;
    }
    public long updateEndTimeReminder(String user_id, String water_reminder, String type_of_interval, String end_time,String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WaterTypeReminder.USER_ID, user_id);
        values.put(WaterTypeReminder.TYPE_OF_REMINDER, water_reminder);
        values.put(WaterTypeReminder.TIME_OF_INTERVAL, type_of_interval);
        values.put(WaterTypeReminder.END_TIME, end_time);
        values.put(WaterTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        return db.update(WaterTypeReminder.TABLE_NAME, values, WaterTypeReminder.USER_ID + " =? AND " + WaterTypeReminder.TYPE_OF_REMINDER + " =?  AND " + WaterTypeReminder.TIME_OF_INTERVAL + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(water_reminder), String.valueOf(type_of_interval)});
    }
    public long updateStartTimeReminder(String user_id, String water_reminder, String type_of_interval, String start_time,String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WaterTypeReminder.USER_ID, user_id);
        values.put(WaterTypeReminder.TYPE_OF_REMINDER, water_reminder);
        values.put(WaterTypeReminder.TIME_OF_INTERVAL, type_of_interval);
        values.put(WaterTypeReminder.START_TIME, start_time);
        values.put(WaterTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        return db.update(WaterTypeReminder.TABLE_NAME, values, WaterTypeReminder.USER_ID + " =? AND " + WaterTypeReminder.TYPE_OF_REMINDER + " =?  AND " + WaterTypeReminder.TIME_OF_INTERVAL + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(water_reminder), String.valueOf(type_of_interval)});
    }
    public long updateNoofTimeReminder(String user_id, String water_reminder, String type_of_interval, String no_of_times,String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WaterTypeReminder.USER_ID, user_id);
        values.put(WaterTypeReminder.TYPE_OF_REMINDER, water_reminder);
        values.put(WaterTypeReminder.TIME_OF_INTERVAL, type_of_interval);
        values.put(WaterTypeReminder.NO_OF_TIMES, no_of_times);
        values.put(WaterTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        return db.update(WaterTypeReminder.TABLE_NAME, values, WaterTypeReminder.USER_ID + " =? AND " + WaterTypeReminder.TYPE_OF_REMINDER + " =?  AND " + WaterTypeReminder.TIME_OF_INTERVAL + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(water_reminder), String.valueOf(type_of_interval)});
    }
    public boolean CheckIsDataAlreadyInDBorNotID(String user_id, String water_reminder, String type_of_interval) {
        String selectQuery = "SELECT  * FROM " + WaterTypeReminder.TABLE_NAME + " WHERE " + WaterTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WaterTypeReminder.TYPE_OF_REMINDER + " = " + "'" + water_reminder + "'" + " AND " + WaterTypeReminder.TIME_OF_INTERVAL + " = " + "'" + type_of_interval + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
    public boolean CheckIsDataAlreadyInDBorNot(String user_id) {
        String selectQuery = "SELECT  * FROM " + WaterTypeReminder.TABLE_NAME + " WHERE " + WaterTypeReminder.USER_ID + " = " + "'" + user_id + "'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public long updateStatusofReminder(String user_id, String water_reminder, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WaterTypeReminder.USER_ID, user_id);
        values.put(WaterTypeReminder.TYPE_OF_REMINDER, water_reminder);
        values.put(WaterTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        return db.update(WaterTypeReminder.TABLE_NAME, values, WaterTypeReminder.USER_ID + " =? AND " + WaterTypeReminder.TYPE_OF_REMINDER + " =?  AND " + WaterTypeReminder.ACTIVE_DEACTIVE + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(water_reminder), String.valueOf(active_deactive)});
    }



    public int getActiveCount(String userid, String active_deactive) {
        String countQuery = "SELECT  * FROM " + WaterTypeReminder.TABLE_NAME + " WHERE " + WaterTypeReminder.USER_ID + " = " + "'" + userid + "'" + " AND " + WaterTypeReminder.ACTIVE_DEACTIVE + " = " + "'" + active_deactive + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}