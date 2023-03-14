package com.universalsompo.meta.metaapp.health.fragment.reminders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.MedicineTypeReminder;

import java.util.ArrayList;
import java.util.List;

public class MedicineReminderDatabaseHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "medicine_reminder_db";

    public MedicineReminderDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MedicineTypeReminder.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MedicineTypeReminder.TABLE_NAME);
        onCreate(db);
    }

    public long insertMedReminder(String user_id, String time, String id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MedicineTypeReminder.USER_ID, user_id);
        values.put(MedicineTypeReminder.TIME, time);
        values.put(MedicineTypeReminder.MED_REMIN_ID, id);
        values.put(MedicineTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        long id1 = db.insert(MedicineTypeReminder.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public int getCount(String user_id) {
        String countQuery = "SELECT  * FROM " + MedicineTypeReminder.TABLE_NAME + " WHERE " + MedicineTypeReminder.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void deleteMedRem(String user_id, String med_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MedicineTypeReminder.TABLE_NAME, MedicineTypeReminder.USER_ID + " = '" + user_id + "'" + " AND "+ MedicineTypeReminder.MED_REMIN_ID + " = '" + med_id + "'",
                null);
        db.close();
    }

    public List<MedicineTypeReminder> getAllMedList(String user_id) {
        List<MedicineTypeReminder> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + MedicineTypeReminder.TABLE_NAME + " WHERE " + MedicineTypeReminder.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MedicineTypeReminder med_rem = new MedicineTypeReminder();
                med_rem.setUser_id(cursor.getString(cursor.getColumnIndex(MedicineTypeReminder.USER_ID)));
                med_rem.setTime(cursor.getString(cursor.getColumnIndex(MedicineTypeReminder.TIME)));
                med_rem.setId(cursor.getString(cursor.getColumnIndex(MedicineTypeReminder.MED_REMIN_ID)));
                med_rem.setActive_deactive(cursor.getString(cursor.getColumnIndex(MedicineTypeReminder.ACTIVE_DEACTIVE)));
                symps2.add(med_rem);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }


    public long updateStatusofReminder(String user_id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MedicineTypeReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(MedicineTypeReminder.TABLE_NAME, values, MedicineTypeReminder.USER_ID + " = ?",
                new String[]{String.valueOf(user_id)});
    }

    public long updateStatusofReminder(String user_id, String med_id, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MedicineTypeReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(MedicineTypeReminder.TABLE_NAME, values, MedicineTypeReminder.USER_ID + " = ? AND " + MedicineTypeReminder.MED_REMIN_ID + " =?",
                new String[]{String.valueOf(user_id), String.valueOf(med_id)});
    }

    public String getStatusofReminder(String user_id) {
        String str = null;
        String selectQuery = "SELECT  " + MedicineTypeReminder.ACTIVE_DEACTIVE + " FROM " + MedicineTypeReminder.TABLE_NAME + " WHERE " + MedicineTypeReminder.USER_ID + " = " + "'" + user_id + "'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(MedicineTypeReminder.ACTIVE_DEACTIVE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getTimeofReminder(String user_id, String med_id) {
        String str = null;
        String selectQuery = "SELECT  " + MedicineTypeReminder.TIME + " FROM " + MedicineTypeReminder.TABLE_NAME + " WHERE " + MedicineTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + MedicineTypeReminder.MED_REMIN_ID + " = " + "'" + med_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(MedicineTypeReminder.TIME));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String user_id) {
        String selectQuery = "SELECT  * FROM " + MedicineTypeReminder.TABLE_NAME + " WHERE " + MedicineTypeReminder.USER_ID + " = " + "'" + user_id + "'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
    public int getActiveCount(String userid, String active_deactive) {
        String countQuery = "SELECT  * FROM " + MedicineTypeReminder.TABLE_NAME + " WHERE " + MedicineTypeReminder.USER_ID + " = " + "'" + userid + "'" + " AND " + MedicineTypeReminder.ACTIVE_DEACTIVE + " = " + "'" + active_deactive + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}
