package com.universalsompo.meta.metaapp.health.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.universalsompo.meta.metaapp.health.database.model.DietIntake;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper1 extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "diet_intake_db";


    public DatabaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(DietIntake.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DietIntake.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertDietIntake(String meal_type, String calories, String carbohydrate, String fat, String protein, String date) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(DietIntake.COLUMN_MEAL_TYPE, meal_type);
        values.put(DietIntake.COLUMN_CALORIES, calories);
        values.put(DietIntake.COLUMN_CARBOHYDRATES, carbohydrate);
        values.put(DietIntake.COLUMN_FAT, fat);
        values.put(DietIntake.COLUMN_PROTEIN, protein);
        values.put(DietIntake.COLUMN_DATE, date);

        // insert row
        long id = db.insert(DietIntake.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public DietIntake getDietIntake(String meal_type, String date) {
        DietIntake dietintake = null;
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DietIntake.TABLE_NAME,
                new String[]{DietIntake.COLUMN_ID, DietIntake.COLUMN_MEAL_TYPE, DietIntake.COLUMN_CALORIES, DietIntake.COLUMN_CARBOHYDRATES, DietIntake.COLUMN_FAT, DietIntake.COLUMN_PROTEIN, DietIntake.COLUMN_DATE},
                DietIntake.COLUMN_DATE + "=? AND " + DietIntake.COLUMN_MEAL_TYPE + "=?",
                new String[]{String.valueOf(date),String.valueOf(meal_type)}, null, null, null, null);

        if(cursor !=null && cursor.moveToFirst()){
            dietintake = new DietIntake(
                    cursor.getInt(cursor.getColumnIndex(DietIntake.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_MEAL_TYPE)),
                    cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_CALORIES)),
                    cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_CARBOHYDRATES)),
                    cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_FAT)),
                    cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_PROTEIN)),
                    cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_DATE)));
            cursor.close();
        }

        return dietintake;
    }

    public List<DietIntake> getAllNotes() {
        List<DietIntake> dietintake3 = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DietIntake.TABLE_NAME + " ORDER BY " +
                DietIntake.COLUMN_DATE + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DietIntake dietintake1 = new DietIntake();
                dietintake1.setId(cursor.getInt(cursor.getColumnIndex(DietIntake.COLUMN_ID)));
                dietintake1.setMealType(cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_MEAL_TYPE)));
                dietintake1.setCalories(cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_CALORIES)));
                dietintake1.setcarbs(cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_CARBOHYDRATES)));
                dietintake1.setFat(cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_FAT)));
                dietintake1.setProtein(cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_PROTEIN)));
                dietintake1.setTimestamp(cursor.getString(cursor.getColumnIndex(DietIntake.COLUMN_DATE)));

                dietintake3.add(dietintake1);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return dietintake3;
    }

    public int updateDietIntake(String meal_type, String calories, String carbohydrate, String fat, String protein, String current_date) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DietIntake.COLUMN_MEAL_TYPE, meal_type);
        values.put(DietIntake.COLUMN_CALORIES, calories);
        values.put(DietIntake.COLUMN_CARBOHYDRATES, carbohydrate);
        values.put(DietIntake.COLUMN_FAT, fat);
        values.put(DietIntake.COLUMN_PROTEIN, protein);

        // updating row
        return db.update(DietIntake.TABLE_NAME, values, DietIntake.COLUMN_DATE + " = ? AND " + DietIntake.COLUMN_MEAL_TYPE + " =?",
                new String[]{String.valueOf(current_date),String.valueOf(meal_type)});
    }
}
