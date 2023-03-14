package com.universalsompo.meta.metaapp.health.notificationReminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ReminderDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "reminder_notification_db";

    public ReminderDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NotificationReminderModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NotificationReminderModel.TABLE_NAME);
        onCreate(db);
    }

    public long insertReminderDatabase(String user_id, String activity_name,
                                       String pending_intent, String date, String time,
                                       String status, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NotificationReminderModel.USER_ID, user_id);
        values.put(NotificationReminderModel.ACTIVITY_NAME, activity_name);
        values.put(NotificationReminderModel.PENDING_INTENT, pending_intent);
        values.put(NotificationReminderModel.DATE, date);
        values.put(NotificationReminderModel.TIME, time);
        values.put(NotificationReminderModel.STATUS, status);
        values.put(NotificationReminderModel.ACTIVE_DEACTIVE, active_deactive);
        long id1 = db.insert(NotificationReminderModel.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public int getCount(String user_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + NotificationReminderModel.TABLE_NAME +
                " WHERE " + NotificationReminderModel.USER_ID + " =? ", new String[]{user_id});
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public List<NotificationReminderModel> getAllNotification(String user_id) {
        List<NotificationReminderModel> symps2 = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + NotificationReminderModel.TABLE_NAME + " WHERE " +
                NotificationReminderModel.USER_ID + " =?", new String[]{user_id});
        if (cursor.moveToFirst()) {
            do {
                NotificationReminderModel reminderModel = new NotificationReminderModel();
                reminderModel.setUser_id(cursor.getString(cursor.getColumnIndex(NotificationReminderModel.USER_ID)));
                reminderModel.setActivity_name(cursor.getString(cursor.getColumnIndex(NotificationReminderModel.ACTIVITY_NAME)));
                reminderModel.setPending_intent(cursor.getString(cursor.getColumnIndex(NotificationReminderModel.PENDING_INTENT)));
                reminderModel.setDate(cursor.getString(cursor.getColumnIndex(NotificationReminderModel.DATE)));
                reminderModel.setTime(cursor.getString(cursor.getColumnIndex(NotificationReminderModel.TIME)));
                reminderModel.setStatus(cursor.getString(cursor.getColumnIndex(NotificationReminderModel.STATUS)));
                reminderModel.setActive_deactive(cursor.getString(cursor.getColumnIndex(NotificationReminderModel.ACTIVE_DEACTIVE)));
                symps2.add(reminderModel);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public long updateStatusofReminder(String user_id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NotificationReminderModel.ACTIVE_DEACTIVE, active_deactive);

        return db.update(NotificationReminderModel.TABLE_NAME, values, NotificationReminderModel.USER_ID + " = ?",
                new String[]{String.valueOf(user_id)});
    }

    public long updateDateofReminder(String activity, String date,String status) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NotificationReminderModel.STATUS, status);
        values.put(NotificationReminderModel.DATE, date);

        return db.update(NotificationReminderModel.TABLE_NAME, values, NotificationReminderModel.ACTIVITY_NAME + " =?",
                new String[]{String.valueOf(activity)});
    }
    public String getStatusofReminder(String user_id, String activity_name) {
        String str = null;
        String selectQuery = "SELECT  " + NotificationReminderModel.ACTIVE_DEACTIVE + " FROM " + NotificationReminderModel.TABLE_NAME + " WHERE " + NotificationReminderModel.USER_ID + " = " + "'" + user_id + "'" + " AND " + NotificationReminderModel.ACTIVITY_NAME + " = " + "'" + activity_name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do{
                str  =  cursor.getString(cursor.getColumnIndex(NotificationReminderModel.ACTIVE_DEACTIVE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getTimeofReminder(String user_id, String activity_name) {
        String str = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  " + NotificationReminderModel.TIME + " FROM " + NotificationReminderModel.TABLE_NAME + " WHERE " + NotificationReminderModel.USER_ID + " =? " + " AND " + NotificationReminderModel.ACTIVITY_NAME + " =? ", new String[]{user_id,activity_name});
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(NotificationReminderModel.TIME));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getDateofReminder(String user_id, String activity_name) {
        String str = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  " + NotificationReminderModel.DATE + " FROM " + NotificationReminderModel.TABLE_NAME + " WHERE " + NotificationReminderModel.USER_ID + " =? " + " AND " + NotificationReminderModel.ACTIVITY_NAME + " =? ", new String[]{user_id,activity_name});
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(NotificationReminderModel.DATE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

}
