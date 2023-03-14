package com.universalsompo.meta.metaapp.health.fragment.profile.medicalinfo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperFamily extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "family_medical_history_db";

    public DatabaseHelperFamily(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBFamilyModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBFamilyModel.TABLE_NAME);
        onCreate(db);
    }

    public long insertUserHistory(String user_id, String diseases_id, String diseases_name, String is_user_suffer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBFamilyModel.USER_ID, user_id);
        values.put(DBFamilyModel.DISEASE_ID, diseases_id);
        values.put(DBFamilyModel.DISEASE_NAME, diseases_name);
        values.put(DBFamilyModel.USER_SUFFER, is_user_suffer);
        long id1 = db.insert(DBFamilyModel.TABLE_NAME, null, values);
        db.close();
        return id1;
    }

    public List<DBFamilyModel> getAllUserHistory(String user_id) {
        List<DBFamilyModel> symps2 = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + DBFamilyModel.TABLE_NAME + " WHERE " + DBFamilyModel.USER_ID + " = " + "'" + user_id + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                DBFamilyModel symps1 = new DBFamilyModel();
                symps1.setUserid(cursor.getString(cursor.getColumnIndex(DBFamilyModel.USER_ID)));
                symps1.setDiseasesid(cursor.getString(cursor.getColumnIndex(DBFamilyModel.DISEASE_ID)));
                symps1.setDiseasesname(cursor.getString(cursor.getColumnIndex(DBFamilyModel.DISEASE_NAME)));
                symps1.setIsusersuffer(cursor.getString(cursor.getColumnIndex(DBFamilyModel.USER_SUFFER)));
                symps2.add(symps1);
            } while (cursor.moveToNext());
        }
        db.close();
        return symps2;
    }

    public void deleteUserHistory(String disease_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DBFamilyModel.TABLE_NAME, DBFamilyModel.DISEASE_ID + " = ?",
                new String[]{disease_id});
        db.close();
    }

    public boolean checkForTableExists(String disease_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + DBFamilyModel.DISEASE_ID + " FROM " + DBFamilyModel.TABLE_NAME + " WHERE " + DBFamilyModel.DISEASE_ID + " = " + "'" + disease_id + "'";
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
        cv.put(DBFamilyModel.USER_ID , userid);
        cv.put(DBFamilyModel.DISEASE_ID, id); //These Fields should be your String values of actual column names
        cv.put(DBFamilyModel.DISEASE_NAME, name);
        cv.put(DBFamilyModel.USER_SUFFER, a);
        db.update(DBFamilyModel.TABLE_NAME, cv, DBFamilyModel.DISEASE_ID + " = " + "'" + id + "'", null);
    }

    public String getissuffervalue(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DBFamilyModel.TABLE_NAME, new String[] { DBFamilyModel.USER_SUFFER }, DBFamilyModel.DISEASE_ID + "=?", new String[] { String.valueOf(id) },
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        String is_user_suffer = cursor.getString(0);

        return is_user_suffer;
    }
}
