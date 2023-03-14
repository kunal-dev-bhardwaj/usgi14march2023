package com.universalsompo.meta.metaapp.health.fragment.reminders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.WalkTypeReminder;


public class WalkTypeDatasbaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "walk_type_reminder_db";

    public WalkTypeDatasbaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WalkTypeReminder.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WalkTypeReminder.TABLE_NAME);
        onCreate(db);
    }


    public long insertWalkTypeReminder(String user_id, String walk_reminder, String walk_time, String time, String active_deactive, String selected_days) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("righthere1",user_id+walk_reminder+walk_time+time+active_deactive+selected_days);
        ContentValues values = new ContentValues();
        values.put(WalkTypeReminder.USER_ID, user_id);
        values.put(WalkTypeReminder.TYPE_OF_REMINDER, walk_reminder);
        values.put(WalkTypeReminder.TIME_OF_WALK, walk_time);
        values.put(WalkTypeReminder.TIME, time);
        values.put(WalkTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        values.put(WalkTypeReminder.SELECTED_DAYS, selected_days);
        long id1 = db.insert(WalkTypeReminder.TABLE_NAME, null, values);
        db.close();
        return id1;
    }



    public String getStatusofReminder(String user_id, String walk_reminder, String walk_time) {
        String str = null;
        String selectQuery = "SELECT  " + WalkTypeReminder.ACTIVE_DEACTIVE + " FROM " + WalkTypeReminder.TABLE_NAME + " WHERE " + WalkTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WalkTypeReminder.TYPE_OF_REMINDER + " = " + "'" + walk_reminder + "'" + " AND " + WalkTypeReminder.TIME_OF_WALK + " = " + "'" + walk_time + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                str = cursor.getString(cursor.getColumnIndex(WalkTypeReminder.ACTIVE_DEACTIVE));
            } while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getTimeofReminder(String user_id, String walk_reminder, String walk_time) {
        String str = null;
        String selectQuery = "SELECT  " + WalkTypeReminder.TIME + " FROM " + WalkTypeReminder.TABLE_NAME + " WHERE " + WalkTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WalkTypeReminder.TYPE_OF_REMINDER + " = " + "'" + walk_reminder + "'" + " AND " + WalkTypeReminder.TIME_OF_WALK + " = " + "'" + walk_time + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                str = cursor.getString(cursor.getColumnIndex(WalkTypeReminder.TIME));
            } while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public long updateStatusofReminder(String user_id, String walk_reminder, String time_of_walk, String time, String active_deactive, String selected_days) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WalkTypeReminder.USER_ID, user_id);
        values.put(WalkTypeReminder.TYPE_OF_REMINDER, walk_reminder);
        values.put(WalkTypeReminder.TIME_OF_WALK, time_of_walk);
        values.put(WalkTypeReminder.TIME, time);
        values.put(WalkTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        values.put(WalkTypeReminder.SELECTED_DAYS, selected_days);
        return db.update(WalkTypeReminder.TABLE_NAME, values, WalkTypeReminder.USER_ID + " =? AND " + WalkTypeReminder.TYPE_OF_REMINDER + " =?  AND " + WalkTypeReminder.TIME_OF_WALK + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(walk_reminder), String.valueOf(time_of_walk)});
    }

    public boolean CheckIsDataAlreadyInDBorNotID(String user_id, String walk_reminder, String walk_time) {
        String selectQuery = "SELECT  * FROM " + WalkTypeReminder.TABLE_NAME + " WHERE " + WalkTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WalkTypeReminder.TYPE_OF_REMINDER + " = " + "'" + walk_reminder + "'" + " AND " + WalkTypeReminder.TIME_OF_WALK + " = " + "'" + walk_time + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public int getActiveStatus(String user_id, String type_of_reminder, String status) {
        String countQuery = "SELECT  * FROM " + WalkTypeReminder.TABLE_NAME + " WHERE " + WalkTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WalkTypeReminder.TYPE_OF_REMINDER + " = " + "'" + type_of_reminder + "'" + " AND " + WalkTypeReminder.ACTIVE_DEACTIVE + " = " + "'" + status + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }


    public boolean CheckIsDataAlreadyInDBorNot(String user_id, String walk_reminder) {
        String selectQuery = "SELECT  * FROM " + WalkTypeReminder.TABLE_NAME + " WHERE " + WalkTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + WalkTypeReminder.TYPE_OF_REMINDER + " = " + "'" + walk_reminder + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }


    public int getStatusofReminder(String user_id) {
        String str = null;
        String selectQuery = "SELECT COUNT(*) FROM " + WalkTypeReminder.TABLE_NAME + " WHERE " + WalkTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + "active_deactive='active'";
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


    public String getDaysofReminder(String userid){
        String day = null;
        String selectQuery = "SELECT " + WalkTypeReminder.SELECTED_DAYS + " FROM "+ WalkTypeReminder.TABLE_NAME + " WHERE " + WalkTypeReminder.USER_ID + " = " + userid + " AND " + WalkTypeReminder.SELECTED_DAYS + " != '' LIMIT 1";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor != null){
            try {
                if (cursor.moveToFirst()){
                    day = cursor.getString(0);
                }
            }finally {
                cursor.close();
            }
        }
        return day;
    }




    public long updateStatusofReminder(String user_id, String walk_reminder, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WalkTypeReminder.USER_ID, user_id);
        values.put(WalkTypeReminder.TYPE_OF_REMINDER, walk_reminder);
        values.put(WalkTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        return db.update(WalkTypeReminder.TABLE_NAME, values, WalkTypeReminder.USER_ID + " =? AND " + WalkTypeReminder.TYPE_OF_REMINDER + " =?  AND " + WalkTypeReminder.ACTIVE_DEACTIVE + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(walk_reminder), String.valueOf(active_deactive)});
    }
}