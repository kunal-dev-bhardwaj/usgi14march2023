package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "exercise_calorie_intake_db";


    public ExerciseDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(ExerciseCalorieIntake.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + ExerciseCalorieIntake.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertExerciseCalorieIntake(String user_id, String type, String calories, String date) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(ExerciseCalorieIntake.COLUMN_USER_ID, user_id);
        values.put(ExerciseCalorieIntake.COLUMN_TYPE, type);
        values.put(ExerciseCalorieIntake.COLUMN_CALORIES, calories);
        values.put(ExerciseCalorieIntake.COLUMN_DATE, date);

        // insert row
        long id = db.insert(ExerciseCalorieIntake.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public ExerciseCalorieIntake getExerciseCalorieIntake(String user_id, String date) {
        ExerciseCalorieIntake exercisecalorieintake = null;
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ExerciseCalorieIntake.TABLE_NAME,
                new String[]{ExerciseCalorieIntake.COLUMN_ID, ExerciseCalorieIntake.COLUMN_USER_ID, ExerciseCalorieIntake.COLUMN_TYPE, ExerciseCalorieIntake.COLUMN_CALORIES, ExerciseCalorieIntake.COLUMN_DATE},
                ExerciseCalorieIntake.COLUMN_DATE + "=? AND " + ExerciseCalorieIntake.COLUMN_USER_ID + "=?",
                new String[]{String.valueOf(date),String.valueOf(user_id)}, null, null, null, null);

        if(cursor !=null && cursor.moveToFirst()){
            exercisecalorieintake = new ExerciseCalorieIntake(
                    cursor.getInt(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_USER_ID)),
                    cursor.getString(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_TYPE)),
                    cursor.getString(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_CALORIES)),
                    cursor.getString(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_DATE)));
            cursor.close();
        }

        return exercisecalorieintake;
    }

    public List<ExerciseCalorieIntake> getAllExerciseCalorieIntake(String date, String user_id) {
        List<ExerciseCalorieIntake> exercisecalorieintake3 = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + ExerciseCalorieIntake.TABLE_NAME + " WHERE " + ExerciseCalorieIntake.COLUMN_DATE + " = " + "'" + date + "'" + " AND " + ExerciseCalorieIntake.COLUMN_USER_ID + " = " + "'" + user_id + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ExerciseCalorieIntake exercisecalorieintake1 = new ExerciseCalorieIntake();
                exercisecalorieintake1.setId(cursor.getInt(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_ID)));
                exercisecalorieintake1.setUserid(cursor.getString(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_USER_ID)));
                exercisecalorieintake1.setType(cursor.getString(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_TYPE)));
                exercisecalorieintake1.setCalories(cursor.getString(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_CALORIES)));
                exercisecalorieintake1.setTimestamp(cursor.getString(cursor.getColumnIndex(ExerciseCalorieIntake.COLUMN_DATE)));

                exercisecalorieintake3.add(exercisecalorieintake1);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return exercisecalorieintake3;
    }

    public int getExerciseCalorieIntakeCount(String user_id, String date) {
        String countQuery = "SELECT  * FROM " + ExerciseCalorieIntake.TABLE_NAME  + " WHERE " + ExerciseCalorieIntake.COLUMN_USER_ID + " = " + "'" + user_id + "'" + " AND " + ExerciseCalorieIntake.COLUMN_DATE + " = " + "'" + date + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}
