package com.universalsompo.meta.metaapp.health.fragment.reminders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.ConsultationReminder;

import java.util.ArrayList;
import java.util.List;

public class ConsultationReminderDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "consultation_reminder_db";

    public ConsultationReminderDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)  {
        db.execSQL(ConsultationReminder.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConsultationReminder.TABLE_NAME);
        onCreate(db);
    }

    public long insertConsultationReminder(String user_id, String doctor_name, String doctor_number, String date, String time, String id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConsultationReminder.USER_ID, user_id);
        values.put(ConsultationReminder.DOCTOR_NAME, doctor_name);
        values.put(ConsultationReminder.DOCTOR_NUMBER, doctor_number);
        values.put(ConsultationReminder.DATE, date);
        values.put(ConsultationReminder.TIME, time);
        values.put(ConsultationReminder.CON_REMIN_ID, id);
        values.put(ConsultationReminder.ACTIVE_DEACTIVE, active_deactive);
        long id1 = db.insert(ConsultationReminder.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public int getCount(String user_id) {
        String countQuery = "SELECT  * FROM " + ConsultationReminder.TABLE_NAME + " WHERE " + ConsultationReminder.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void deleteLabtest(String user_id, String doctor_name, String doctor_number, String con_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ConsultationReminder.TABLE_NAME, ConsultationReminder.USER_ID + " = '" + user_id + "'" + " AND " + ConsultationReminder.DOCTOR_NAME + " = '" + doctor_name + "'" + " AND " + ConsultationReminder.DOCTOR_NUMBER + " = '" + doctor_number + "'" + " AND " + ConsultationReminder.CON_REMIN_ID + " = '" + con_id + "'",
                null);
        db.close();
    }

    public void deleteLabtest(String user_id, String con_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ConsultationReminder.TABLE_NAME, ConsultationReminder.USER_ID + " = '" + user_id + "'" + " AND " + ConsultationReminder.CON_REMIN_ID + " = '" + con_id + "'",
                null);
        db.close();
    }

    public List<ConsultationReminder> getAllConsultation(String user_id) {
        List<ConsultationReminder> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + ConsultationReminder.TABLE_NAME + " WHERE " + ConsultationReminder.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ConsultationReminder consult = new ConsultationReminder();
                consult.setUserid(cursor.getString(cursor.getColumnIndex(ConsultationReminder.USER_ID)));
                consult.setDoctorname(cursor.getString(cursor.getColumnIndex(ConsultationReminder.DOCTOR_NAME)));
                consult.setDoctornumber(cursor.getString(cursor.getColumnIndex(ConsultationReminder.DOCTOR_NUMBER)));
                consult.setDate(cursor.getString(cursor.getColumnIndex(ConsultationReminder.DATE)));
                consult.setTime(cursor.getString(cursor.getColumnIndex(ConsultationReminder.TIME)));
                consult.setId(cursor.getString(cursor.getColumnIndex(ConsultationReminder.CON_REMIN_ID)));
                consult.setActivedeactive(cursor.getString(cursor.getColumnIndex(ConsultationReminder.ACTIVE_DEACTIVE)));
                symps2.add(consult);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public long updateStatusofReminder(String user_id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConsultationReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(ConsultationReminder.TABLE_NAME, values, ConsultationReminder.USER_ID + " = ?",
                new String[]{String.valueOf(user_id)});
    }

    public String getStatusofReminder(String user_id, String con_id) {
        String str = null;
        String selectQuery = "SELECT  " + ConsultationReminder.ACTIVE_DEACTIVE + " FROM " + ConsultationReminder.TABLE_NAME + " WHERE " + ConsultationReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + ConsultationReminder.CON_REMIN_ID + " = " + "'" + con_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(ConsultationReminder.ACTIVE_DEACTIVE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getTimeofReminder(String user_id, String conid) {
        String str = null;
        String selectQuery = "SELECT  " + ConsultationReminder.TIME + " FROM " + ConsultationReminder.TABLE_NAME + " WHERE " + ConsultationReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + ConsultationReminder.CON_REMIN_ID + " = " + "'" + conid + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(ConsultationReminder.TIME));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getDateofReminder(String user_id, String conid) {
        String str = null;
        String selectQuery = "SELECT  " + ConsultationReminder.DATE + " FROM " + ConsultationReminder.TABLE_NAME + " WHERE " + ConsultationReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + ConsultationReminder.CON_REMIN_ID + " = " + "'" + conid + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(ConsultationReminder.DATE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public long updateStatusofReminder(String user_id, String conid, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConsultationReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(ConsultationReminder.TABLE_NAME, values, ConsultationReminder.USER_ID + " = ? AND " + ConsultationReminder.CON_REMIN_ID + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(conid)});
    }

    public int getdeactiveCount(String userid, String active_deactive) {
        String countQuery = "SELECT  * FROM " + ConsultationReminder.TABLE_NAME + " WHERE " + ConsultationReminder.USER_ID + " = " + "'" + userid + "'" + " AND " + ConsultationReminder.ACTIVE_DEACTIVE + " = " + "'" + active_deactive + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}