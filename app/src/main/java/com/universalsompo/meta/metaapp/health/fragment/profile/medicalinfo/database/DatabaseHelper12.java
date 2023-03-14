package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper12 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_medical_history_db";

    public DatabaseHelper12(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBModel.TABLE_NAME);
        onCreate(db);
    }

    public long insertUserHistory(String user_id, String diseases_id, String diseases_name, String is_user_suffer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBModel.USER_ID, user_id);
        values.put(DBModel.DISEASE_ID, diseases_id);
        values.put(DBModel.DISEASE_NAME, diseases_name);
        values.put(DBModel.USER_SUFFER, is_user_suffer);
        long id1 = db.insert(DBModel.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public List<DBModel> getAllUserHistory(String user_id) {
        List<DBModel> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + DBModel.TABLE_NAME + " WHERE " + DBModel.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                DBModel symps1 = new DBModel();
                symps1.setUserid(cursor.getString(cursor.getColumnIndex(DBModel.USER_ID)));
                symps1.setDiseasesid(cursor.getString(cursor.getColumnIndex(DBModel.DISEASE_ID)));
                symps1.setDiseasesname(cursor.getString(cursor.getColumnIndex(DBModel.DISEASE_NAME)));
                symps1.setIsusersuffer(cursor.getString(cursor.getColumnIndex(DBModel.USER_SUFFER)));
                symps2.add(symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public void deleteUserHistory(String disease_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DBModel.TABLE_NAME, DBModel.DISEASE_ID + " = ?",
                new String[]{disease_id});
        db.close();
    }

    public boolean checkForTableExists(String disease_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + DBModel.DISEASE_ID + " FROM " + DBModel.TABLE_NAME + " WHERE " + DBModel.DISEASE_ID + " = " + "'" + disease_id + "'";
        Cursor mCursor = db.rawQuery(sql, null);
        if (mCursor.getCount() > 0) {
            return true;
        }
        mCursor.close();
        return false;
    }

    public void updatedata(String userid, String id, String name, String a) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBModel.USER_ID , userid);
        cv.put(DBModel.DISEASE_ID, id); //These Fields should be your String values of actual column names
        cv.put(DBModel.DISEASE_NAME, name);
        cv.put(DBModel.USER_SUFFER, a);
        db.update(DBModel.TABLE_NAME, cv, DBModel.DISEASE_ID + " = " + "'" + id + "'", null);
    }

    public String getissuffervalue(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DBModel.TABLE_NAME, new String[] { DBModel.USER_SUFFER }, DBModel.DISEASE_ID + "=?", new String[] { String.valueOf(id) },
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        String is_user_suffer = cursor.getString(0);

        return is_user_suffer;
    }
}
