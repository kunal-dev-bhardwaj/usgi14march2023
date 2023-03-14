package com.universalsompo.meta.metaapp.health.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.universalsompo.meta.metaapp.health.database.model.ActivityIds;

public class DatabaseActivityID extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "activity_ids";

    public DatabaseActivityID(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ActivityIds.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ActivityIds.TABLE_NAME);
        onCreate(db);
    }

    public long insertData(String user_id,String name, String id, String uni_name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ActivityIds.USER_ID ,user_id);
        values.put(ActivityIds.ACTIVITY_NAME ,name);
        values.put(ActivityIds.ACTIVITY_ID ,id);
        values.put(ActivityIds.ACTIVITY_UNIQUE_NAME ,uni_name);
        long id1 = db.insertWithOnConflict(ActivityIds.TABLE_NAME, null, values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        return id1;
    }

    public String getActivityId(String user_id,String uni_name){
        String str = null;
        String selectQuery = "SELECT  " + ActivityIds.ACTIVITY_ID + " FROM " + ActivityIds.TABLE_NAME + " WHERE " + ActivityIds.USER_ID + " = " + "'" + user_id + "'" + " AND " + ActivityIds.ACTIVITY_UNIQUE_NAME + " = " + "'" +uni_name +"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do
            {
                str  =  cursor.getString(cursor.getColumnIndex(ActivityIds.ACTIVITY_ID));
            }while (cursor.moveToNext());
        }
        db.close();
        return str;
    }

    public boolean deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ ActivityIds.TABLE_NAME);
        return true;
    }
    public boolean CheckIsDataAlreadyInDBorNot(String user_id) {
        String selectQuery = "SELECT  * FROM " + ActivityIds.TABLE_NAME + " WHERE " + ActivityIds.USER_ID + " = " + "'" + user_id + "'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
