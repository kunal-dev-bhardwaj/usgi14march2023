package com.universalsompo.meta.metaapp.health.fragment.foodtracking.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FoodDatabaseHelper1 extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "food_intake_popular_item_db";


    public FoodDatabaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(FoodIntake1.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + FoodIntake1.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertFoodIntake1(String user_id, String meal_type, String food_name, String calories, String carbohydrate, String fat, String protein, String serving_desc, String food_id, String food_nutrition, String increment) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(FoodIntake1.COLUMN_USER_ID, user_id);
        values.put(FoodIntake1.COLUMN_MEAL_TYPE, meal_type);
        values.put(FoodIntake1.COLUMN_FOOD_NAME, food_name);
        values.put(FoodIntake1.COLUMN_CALORIES, calories);
        values.put(FoodIntake1.COLUMN_CARBOHYDRATES, carbohydrate);
        values.put(FoodIntake1.COLUMN_FAT, fat);
        values.put(FoodIntake1.COLUMN_PROTEIN, protein);
        values.put(FoodIntake1.COLUMN_SERVING_DESC, serving_desc);
        values.put(FoodIntake1.COLUMN_FOOD_ID, food_id);
        values.put(FoodIntake1.COLUMN_FOOD_NUTRITION, food_nutrition);
        values.put(FoodIntake1.COLUMN_INCREMENT, increment);

        // insert row
        long id = db.insert(FoodIntake1.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public FoodIntake1 getFoodIntake1(String meal_type, String user_id) {
        FoodIntake1 foodintake = null;
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(FoodIntake1.TABLE_NAME,
                new String[]{FoodIntake1.COLUMN_ID, FoodIntake1.COLUMN_USER_ID, FoodIntake1.COLUMN_MEAL_TYPE, FoodIntake1.COLUMN_FOOD_NAME, FoodIntake1.COLUMN_CALORIES, FoodIntake1.COLUMN_CARBOHYDRATES, FoodIntake1.COLUMN_FAT, FoodIntake1.COLUMN_PROTEIN, FoodIntake1.COLUMN_SERVING_DESC, FoodIntake1.COLUMN_FOOD_ID, FoodIntake1.COLUMN_FOOD_NUTRITION, FoodIntake1.COLUMN_INCREMENT},
                FoodIntake1.COLUMN_MEAL_TYPE + "=?  AND " + FoodIntake1.COLUMN_USER_ID + "=?",
                new String[]{String.valueOf(meal_type), String.valueOf(user_id)}, null, null, null, null);

        if(cursor !=null && cursor.moveToFirst()){
            foodintake = new FoodIntake1(
                    cursor.getInt(cursor.getColumnIndex(FoodIntake1.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_USER_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_MEAL_TYPE)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_FOOD_NAME)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_CALORIES)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_CARBOHYDRATES)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_FAT)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_PROTEIN)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_SERVING_DESC)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_FOOD_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_FOOD_NUTRITION)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_INCREMENT)));
            cursor.close();
        }

        return foodintake;
    }

    public List<FoodIntake1> getAllFood1(String meal_type, String user_id) {
        List<FoodIntake1> foodintake3 = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + FoodIntake1.TABLE_NAME + " WHERE " + FoodIntake1.COLUMN_MEAL_TYPE + " = " + "'" + meal_type + "'" + " AND " + FoodIntake1.COLUMN_USER_ID + " = " + "'" + user_id + "'" + " LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FoodIntake1 foodintake2 = new FoodIntake1();
                foodintake2.setId(cursor.getInt(cursor.getColumnIndex(FoodIntake1.COLUMN_ID)));
                foodintake2.setUserid(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_USER_ID)));
                foodintake2.setMealType(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_MEAL_TYPE)));
                foodintake2.setFoodName(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_FOOD_NAME)));
                foodintake2.setCalories(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_CALORIES)));
                foodintake2.setcarbs(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_CARBOHYDRATES)));
                foodintake2.setFat(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_FAT)));
                foodintake2.setProtein(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_PROTEIN)));
                foodintake2.setServing_desc(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_SERVING_DESC)));
                foodintake2.setFood_id(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_FOOD_ID)));
                foodintake2.setFood_nutrition(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_FOOD_NUTRITION)));
                foodintake2.setIncrement(cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_INCREMENT)));

                foodintake3.add(foodintake2);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return foodintake3;
    }

    public int updateFoodIntake1(String user_id, String meal_type, String food_name, String calories, String carbohydrate, String fat, String protein, String serving_desc, String food_id, String food_nutrition, String increment) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FoodIntake1.COLUMN_USER_ID, user_id);
        values.put(FoodIntake1.COLUMN_MEAL_TYPE, meal_type);
        values.put(FoodIntake1.COLUMN_FOOD_NAME, food_name);
        values.put(FoodIntake1.COLUMN_CALORIES, calories);
        values.put(FoodIntake1.COLUMN_CARBOHYDRATES, carbohydrate);
        values.put(FoodIntake1.COLUMN_FAT, fat);
        values.put(FoodIntake1.COLUMN_PROTEIN, protein);
        values.put(FoodIntake1.COLUMN_SERVING_DESC, serving_desc);
        values.put(FoodIntake1.COLUMN_FOOD_ID, food_id);
        values.put(FoodIntake1.COLUMN_FOOD_NUTRITION, food_nutrition);
        values.put(FoodIntake1.COLUMN_INCREMENT, increment);

        // updating row
        return db.update(FoodIntake1.TABLE_NAME, values, FoodIntake1.COLUMN_FOOD_ID + " = ? AND " + FoodIntake1.COLUMN_MEAL_TYPE + " =?  AND " + FoodIntake1.COLUMN_USER_ID + " =?",
                new String[]{String.valueOf(food_id),String.valueOf(meal_type),String.valueOf(user_id)});
    }

    public int getFoodIntakeCount1(String user_id) {
        String countQuery = "SELECT  * FROM " + FoodIntake1.TABLE_NAME + " WHERE " + FoodIntake1.COLUMN_USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public boolean CheckIsDataAlreadyInDBorNot1(String meal_type,
                                               String food_id, String user_id) {
        String selectQuery = "SELECT  * FROM " + FoodIntake1.TABLE_NAME + " WHERE " + FoodIntake1.COLUMN_MEAL_TYPE + " = " + "'" + meal_type + "'" + " AND " + FoodIntake1.COLUMN_FOOD_ID + " = " + "'" + food_id + "'" + " AND " + FoodIntake1.COLUMN_USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public String getFoodIntake2(String meal_type, String food_id, String user_id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(FoodIntake1.TABLE_NAME,
                new String[]{FoodIntake1.COLUMN_INCREMENT},
                FoodIntake1.COLUMN_MEAL_TYPE + "=? AND " + FoodIntake1.COLUMN_FOOD_ID + "=?  AND " + FoodIntake1.COLUMN_USER_ID + "=?",
                new String[]{String.valueOf(meal_type),String.valueOf(food_id),String.valueOf(user_id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        String increment_value = cursor.getString(cursor.getColumnIndex(FoodIntake1.COLUMN_INCREMENT));

        // close the db connection
        cursor.close();

        return increment_value;
    }
}
