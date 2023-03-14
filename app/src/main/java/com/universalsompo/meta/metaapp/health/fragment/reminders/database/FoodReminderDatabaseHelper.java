package com.universalsompo.meta.metaapp.health.fragment.reminders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.FoodReminder;

public class FoodReminderDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "food_reminder_db";

    public FoodReminderDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FoodReminder.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FoodReminder.TABLE_NAME);
        onCreate(db);
    }

    public long insertFoodReminder(String user_id, String food_reminder, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FoodReminder.USER_ID, user_id);
        values.put(FoodReminder.TYPE_OF_ALARM, food_reminder);
        values.put(FoodReminder.ACTIVE_DEACTIVE, active_deactive);
        long id1 = db.insert(FoodReminder.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public String getStatusofReminder(String user_id, String food_reminder) {
        String str = null;
        String selectQuery = "SELECT  " + FoodReminder.ACTIVE_DEACTIVE + " FROM " + FoodReminder.TABLE_NAME + " WHERE " + FoodReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + FoodReminder.TYPE_OF_ALARM + " = " + "'" + food_reminder + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(FoodReminder.ACTIVE_DEACTIVE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public long updateStatusofReminder(String user_id, String food_reminder, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FoodReminder.USER_ID, user_id);
        values.put(FoodReminder.TYPE_OF_ALARM, food_reminder);
        values.put(FoodReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(FoodReminder.TABLE_NAME, values, FoodReminder.USER_ID + " = ? AND " + FoodReminder.TYPE_OF_ALARM + " =?",
                new String[]{String.valueOf(user_id),String.valueOf(food_reminder)});
    }

    public boolean CheckIsDataAlreadyInDBorNotID(String user_id, String food_reminder) {
        String selectQuery = "SELECT  * FROM " + FoodReminder.TABLE_NAME + " WHERE " + FoodReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + FoodReminder.TYPE_OF_ALARM + " = " + "'" + food_reminder + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
