package com.universalsompo.meta.metaapp.health.fragment.foodtracking.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FoodDatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "food_intake_db";


    public FoodDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(FoodIntake.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + FoodIntake.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertFoodIntake(String user_id, String meal_type, String food_name, String calories, String carbohydrate, String fat, String protein, String date, String food_id, String food_nutrition, String quantity) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(FoodIntake.COLUMN_USER_ID, user_id);
        values.put(FoodIntake.COLUMN_MEAL_TYPE, meal_type);
        values.put(FoodIntake.COLUMN_FOOD_NAME, food_name);
        values.put(FoodIntake.COLUMN_CALORIES, calories);
        values.put(FoodIntake.COLUMN_CARBOHYDRATES, carbohydrate);
        values.put(FoodIntake.COLUMN_FAT, fat);
        values.put(FoodIntake.COLUMN_PROTEIN, protein);
        values.put(FoodIntake.COLUMN_DATE, date);
        values.put(FoodIntake.COLUMN_FOOD_ID, food_id);
        values.put(FoodIntake.COLUMN_FOOD_NUTRITION, food_nutrition);
        values.put(FoodIntake.COLUMN_QUANTITY, quantity);

        // insert row
        long id = db.insert(FoodIntake.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public FoodIntake getFoodIntake(String user_id, String meal_type, String date) {
        FoodIntake foodintake = null;
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(FoodIntake.TABLE_NAME,
                new String[]{FoodIntake.COLUMN_ID, FoodIntake.COLUMN_USER_ID, FoodIntake.COLUMN_MEAL_TYPE, FoodIntake.COLUMN_FOOD_NAME, FoodIntake.COLUMN_CALORIES, FoodIntake.COLUMN_CARBOHYDRATES, FoodIntake.COLUMN_FAT, FoodIntake.COLUMN_PROTEIN, FoodIntake.COLUMN_DATE, FoodIntake.COLUMN_FOOD_ID, FoodIntake.COLUMN_FOOD_NUTRITION, FoodIntake.COLUMN_QUANTITY},
                FoodIntake.COLUMN_DATE + "=? AND " + FoodIntake.COLUMN_MEAL_TYPE + "=? AND " + FoodIntake.COLUMN_USER_ID + "=?",
                new String[]{String.valueOf(date),String.valueOf(meal_type),String.valueOf(user_id)}, null, null, null, null);

        if(cursor !=null && cursor.moveToFirst()){
            foodintake = new FoodIntake(
                    cursor.getInt(cursor.getColumnIndex(FoodIntake.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_USER_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_MEAL_TYPE)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_NAME)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_CALORIES)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_CARBOHYDRATES)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FAT)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_PROTEIN)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_DATE)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_NUTRITION)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_QUANTITY)));
            cursor.close();
        }

        return foodintake;
    }

    public FoodIntake getFoodIntake1(String date, String user_id) {
        FoodIntake foodintake = null;
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(FoodIntake.TABLE_NAME,
                new String[]{FoodIntake.COLUMN_ID, FoodIntake.COLUMN_USER_ID, FoodIntake.COLUMN_MEAL_TYPE, FoodIntake.COLUMN_FOOD_NAME, FoodIntake.COLUMN_CALORIES, FoodIntake.COLUMN_CARBOHYDRATES, FoodIntake.COLUMN_FAT, FoodIntake.COLUMN_PROTEIN, FoodIntake.COLUMN_DATE, FoodIntake.COLUMN_FOOD_ID, FoodIntake.COLUMN_FOOD_NUTRITION, FoodIntake.COLUMN_QUANTITY},
                FoodIntake.COLUMN_DATE + "=? AND " + FoodIntake.COLUMN_MEAL_TYPE + "=? AND " + FoodIntake.COLUMN_USER_ID + "=?",
                new String[]{String.valueOf(date),String.valueOf(user_id)}, null, null, null, null);

        if(cursor !=null && cursor.moveToFirst()){
            foodintake = new FoodIntake(
                    cursor.getInt(cursor.getColumnIndex(FoodIntake.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_USER_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_MEAL_TYPE)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_NAME)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_CALORIES)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_CARBOHYDRATES)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FAT)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_PROTEIN)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_DATE)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_ID)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_NUTRITION)),
                    cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_QUANTITY)));
            cursor.close();
        }

        return foodintake;
    }

    public List<FoodIntake> getAllFood(String meal_type, String date, String user_id) {
        List<FoodIntake> foodintake3 = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + FoodIntake.TABLE_NAME + " WHERE " + FoodIntake.COLUMN_MEAL_TYPE + " = " + "'" + meal_type + "'" + " AND " + FoodIntake.COLUMN_DATE + " = " + "'" + date + "'" + " AND " + FoodIntake.COLUMN_USER_ID + " = " + "'" + user_id + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FoodIntake foodintake1 = new FoodIntake();
                foodintake1.setId(cursor.getInt(cursor.getColumnIndex(FoodIntake.COLUMN_ID)));
                foodintake1.setUserid(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_USER_ID)));
                foodintake1.setMealType(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_MEAL_TYPE)));
                foodintake1.setFoodName(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_NAME)));
                foodintake1.setCalories(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_CALORIES)));
                foodintake1.setcarbs(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_CARBOHYDRATES)));
                foodintake1.setFat(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FAT)));
                foodintake1.setProtein(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_PROTEIN)));
                foodintake1.setTimestamp(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_DATE)));
                foodintake1.setFood_id(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_ID)));
                foodintake1.setFood_nutrition(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_NUTRITION)));
                foodintake1.setQuantity(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_QUANTITY)));

                foodintake3.add(foodintake1);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return foodintake3;
    }

    public List<FoodIntake> getAllFood1(String date, String user_id) {
        List<FoodIntake> foodintake3 = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + FoodIntake.TABLE_NAME + " WHERE " + FoodIntake.COLUMN_DATE + " = " + "'" + date + "'" + " AND " + FoodIntake.COLUMN_USER_ID + " = " + "'" + user_id + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FoodIntake foodintake1 = new FoodIntake();
                foodintake1.setId(cursor.getInt(cursor.getColumnIndex(FoodIntake.COLUMN_ID)));
                foodintake1.setUserid(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_USER_ID)));
                foodintake1.setMealType(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_MEAL_TYPE)));
                foodintake1.setFoodName(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_NAME)));
                foodintake1.setCalories(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_CALORIES)));
                foodintake1.setcarbs(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_CARBOHYDRATES)));
                foodintake1.setFat(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FAT)));
                foodintake1.setProtein(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_PROTEIN)));
                foodintake1.setTimestamp(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_DATE)));
                foodintake1.setFood_id(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_ID)));
                foodintake1.setFood_nutrition(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_FOOD_NUTRITION)));
                foodintake1.setQuantity(cursor.getString(cursor.getColumnIndex(FoodIntake.COLUMN_QUANTITY)));

                foodintake3.add(foodintake1);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return foodintake3;
    }

    public int updateFoodIntake(String user_id, String meal_type, String food_name, String calories, String carbohydrate, String fat, String protein, String current_date, String food_id, String food_nutrition, String quantity) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FoodIntake.COLUMN_USER_ID, user_id);
        values.put(FoodIntake.COLUMN_MEAL_TYPE, meal_type);
        values.put(FoodIntake.COLUMN_FOOD_NAME, food_name);
        values.put(FoodIntake.COLUMN_CALORIES, calories);
        values.put(FoodIntake.COLUMN_CARBOHYDRATES, carbohydrate);
        values.put(FoodIntake.COLUMN_FAT, fat);
        values.put(FoodIntake.COLUMN_PROTEIN, protein);
        values.put(FoodIntake.COLUMN_FOOD_ID, food_id);
        values.put(FoodIntake.COLUMN_FOOD_NUTRITION, food_nutrition);
        values.put(FoodIntake.COLUMN_QUANTITY, quantity);

        // updating row
        return db.update(FoodIntake.TABLE_NAME, values, FoodIntake.COLUMN_DATE + " = ? AND " + FoodIntake.COLUMN_MEAL_TYPE + " =?  AND " + FoodIntake.COLUMN_USER_ID + " =?",
                new String[]{String.valueOf(current_date),String.valueOf(meal_type),String.valueOf(user_id)});
    }

    public int getFoodIntakeCount(String user_id) {
        String countQuery = "SELECT  * FROM " + FoodIntake.TABLE_NAME  + " WHERE " + FoodIntake.COLUMN_USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String meal_type,
                                               String food_id, String date, String user_id) {
        String selectQuery = "SELECT  * FROM " + FoodIntake.TABLE_NAME + " WHERE " + FoodIntake.COLUMN_MEAL_TYPE + " = " + "'" + meal_type + "'" + " AND " + FoodIntake.COLUMN_FOOD_ID + " = " + "'" + food_id + "'" + " AND " + FoodIntake.COLUMN_DATE + " = " + "'" + date + "'" + " AND " + FoodIntake.COLUMN_USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public void deleteItem(String userid, String food_id, String meal_type, String date) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = FoodIntake.COLUMN_USER_ID + "=? AND " + FoodIntake.COLUMN_FOOD_ID + "=? AND " + FoodIntake.COLUMN_MEAL_TYPE + "=? AND " + FoodIntake.COLUMN_DATE + "=?";
        db.delete(FoodIntake.TABLE_NAME, whereClause, new String[]{String.valueOf(userid),String.valueOf(food_id),String.valueOf(meal_type),String.valueOf(date)});
        db.close();
    }
}
