package com.universalsompo.meta.metaapp.health.fragment.reminders.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.fragment.reminders.database.models.SetFoodTypeReminder;

public class FoodTypeDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "food_type_reminder_db";

    public FoodTypeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SetFoodTypeReminder.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SetFoodTypeReminder.TABLE_NAME);
        onCreate(db);
    }

    public long insertFoodTypeReminder(String user_id, String food_reminder, String meal_tyoe, String time, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SetFoodTypeReminder.USER_ID, user_id);
        values.put(SetFoodTypeReminder.TYPE_OF_REMINDER, food_reminder);
        values.put(SetFoodTypeReminder.TYPE_OF_MEAL, meal_tyoe);
        values.put(SetFoodTypeReminder.TIME, time);
        values.put(SetFoodTypeReminder.ACTIVE_DEACTIVE, active_deactive);
        long id1 = db.insert(SetFoodTypeReminder.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public String getStatusofReminder(String user_id, String food_reminder, String meal_type) {
        String str = null;
        String selectQuery = "SELECT  " + SetFoodTypeReminder.ACTIVE_DEACTIVE + " FROM " + SetFoodTypeReminder.TABLE_NAME + " WHERE " + SetFoodTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + SetFoodTypeReminder.TYPE_OF_REMINDER + " = " + "'" + food_reminder + "'" + " AND " + SetFoodTypeReminder.TYPE_OF_MEAL + " = " + "'" + meal_type + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(SetFoodTypeReminder.ACTIVE_DEACTIVE));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public String getTimeofReminder(String user_id, String food_reminder, String meal_type) {
        String str = null;
        String selectQuery = "SELECT  " + SetFoodTypeReminder.TIME + " FROM " + SetFoodTypeReminder.TABLE_NAME + " WHERE " + SetFoodTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + SetFoodTypeReminder.TYPE_OF_REMINDER + " = " + "'" + food_reminder + "'" + " AND " + SetFoodTypeReminder.TYPE_OF_MEAL + " = " + "'" + meal_type + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(SetFoodTypeReminder.TIME));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public long updateStatusofReminder(String user_id, String food_reminder, String meal_type, String time, String active_deactive) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SetFoodTypeReminder.USER_ID, user_id);
        values.put(SetFoodTypeReminder.TYPE_OF_REMINDER, food_reminder);
        values.put(SetFoodTypeReminder.TYPE_OF_MEAL, meal_type);
        values.put(SetFoodTypeReminder.TIME, time);
        values.put(SetFoodTypeReminder.ACTIVE_DEACTIVE, active_deactive);

        return db.update(SetFoodTypeReminder.TABLE_NAME, values, SetFoodTypeReminder.USER_ID + " = ? AND " + SetFoodTypeReminder.TYPE_OF_REMINDER + " =?  AND " + SetFoodTypeReminder.TYPE_OF_MEAL + " =?",
                new String[]{String.valueOf(user_id),String.valueOf(food_reminder),String.valueOf(meal_type)});
    }

    public boolean CheckIsDataAlreadyInDBorNotID(String user_id, String food_reminder, String meal_type) {
        String selectQuery = "SELECT  * FROM " + SetFoodTypeReminder.TABLE_NAME + " WHERE " + SetFoodTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + SetFoodTypeReminder.TYPE_OF_REMINDER + " = " + "'" + food_reminder + "'" + " AND " + SetFoodTypeReminder.TYPE_OF_MEAL + " = " + "'" + meal_type + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public int getActiveStatus(String user_id, String type_of_reminder, String status) {
        String countQuery = "SELECT  * FROM " + SetFoodTypeReminder.TABLE_NAME + " WHERE " + SetFoodTypeReminder.USER_ID + " = " + "'" + user_id + "'" + " AND " + SetFoodTypeReminder.TYPE_OF_REMINDER + " = " + "'" + type_of_reminder + "'"  + " AND " + SetFoodTypeReminder.ACTIVE_DEACTIVE + " = " + "'" + status + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}