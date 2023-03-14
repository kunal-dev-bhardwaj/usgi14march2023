package com.universalsompo.meta.metaapp.health.fragment.watertracking.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WaterDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "water_intake_db";

    public WaterDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WaterIntake1.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WaterIntake1.TABLE_NAME);
        onCreate(db);
    }

    public long insertWaterIntake(String litres, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WaterIntake1.COLUMN_LITRE_CONSUMED, litres);
        values.put(WaterIntake1.COLUMN_DATE, date);
        long id = db.insert(WaterIntake1.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public WaterIntake1 getWaterIntake(String date) {
        WaterIntake1 waterintake = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(WaterIntake1.TABLE_NAME,
                new String[]{WaterIntake1.COLUMN_ID, WaterIntake1.COLUMN_LITRE_CONSUMED, WaterIntake1.COLUMN_DATE},
                WaterIntake1.COLUMN_DATE + "=?",
                new String[]{String.valueOf(date)}, null, null, null, null);

        if(cursor !=null && cursor.moveToFirst()){
            waterintake = new WaterIntake1(
                    cursor.getInt(cursor.getColumnIndex(WaterIntake1.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(WaterIntake1.COLUMN_LITRE_CONSUMED)),
                    cursor.getString(cursor.getColumnIndex(WaterIntake1.COLUMN_DATE)));
            cursor.close();
        }

        return waterintake;
    }

    public int updateWaterIntake(String litre_consume_update, String current_date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WaterIntake1.COLUMN_LITRE_CONSUMED, litre_consume_update);
        return db.update(WaterIntake1.TABLE_NAME, values, WaterIntake1.COLUMN_DATE + " = ?",
                new String[]{String.valueOf(current_date)});
    }
}
