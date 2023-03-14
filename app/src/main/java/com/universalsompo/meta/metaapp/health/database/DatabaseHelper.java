package com.universalsompo.meta.metaapp.health.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.universalsompo.meta.metaapp.health.database.model.WaterIntake;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 27-04-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "water_intake_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(WaterIntake.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + WaterIntake.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertWaterIntake(String litres, String date) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(WaterIntake.COLUMN_LITRE_CONSUMED, litres);
        values.put(WaterIntake.COLUMN_DATE, date);

        // insert row
        long id = db.insert(WaterIntake.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public WaterIntake getWaterIntake(String date) {
        WaterIntake waterintake = null;
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(WaterIntake.TABLE_NAME,
                new String[]{WaterIntake.COLUMN_ID, WaterIntake.COLUMN_LITRE_CONSUMED, WaterIntake.COLUMN_DATE},
                WaterIntake.COLUMN_DATE + "=?",
                new String[]{String.valueOf(date)}, null, null, null, null);

        if(cursor !=null && cursor.moveToFirst()){
            waterintake = new WaterIntake(
                    cursor.getInt(cursor.getColumnIndex(WaterIntake.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(WaterIntake.COLUMN_LITRE_CONSUMED)),
                    cursor.getString(cursor.getColumnIndex(WaterIntake.COLUMN_DATE)));
            cursor.close();
        }
        /*if (cursor != null)
            cursor.moveToFirst();*/

        // prepare note object
       /* WaterIntake waterintake = new WaterIntake(
                cursor.getInt(cursor.getColumnIndex(WaterIntake.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(WaterIntake.COLUMN_LITRE_CONSUMED)),
                cursor.getString(cursor.getColumnIndex(WaterIntake.COLUMN_DATE)));*/

        // close the db connection
       // cursor.close();

        return waterintake;
    }

    public List<WaterIntake> getAllNotes() {
        List<WaterIntake> waterintake3 = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + WaterIntake.TABLE_NAME + " ORDER BY " +
                WaterIntake.COLUMN_DATE + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                WaterIntake waterintake1 = new WaterIntake();
                waterintake1.setId(cursor.getInt(cursor.getColumnIndex(WaterIntake.COLUMN_ID)));
                waterintake1.setWaterIntake(cursor.getString(cursor.getColumnIndex(WaterIntake.COLUMN_LITRE_CONSUMED)));
                waterintake1.setTimestamp(cursor.getString(cursor.getColumnIndex(WaterIntake.COLUMN_DATE)));

                waterintake3.add(waterintake1);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return waterintake3;
    }

    /* public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Note.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    } */

    public int updateWaterIntake(String litre_consume_update, String current_date) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WaterIntake.COLUMN_LITRE_CONSUMED, litre_consume_update);

        // updating row
        return db.update(WaterIntake.TABLE_NAME, values, WaterIntake.COLUMN_DATE + " = ?",
                new String[]{String.valueOf(current_date)});
    }

    /* public void deleteNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Note.TABLE_NAME, Note.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }*/
}
