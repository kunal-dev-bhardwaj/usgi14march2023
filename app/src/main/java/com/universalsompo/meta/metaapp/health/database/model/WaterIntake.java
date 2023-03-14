package com.universalsompo.meta.metaapp.health.database.model;

/**
 * Created by user on 27-04-2018.
 */

public class WaterIntake {
    public static final String TABLE_NAME = "water_intake";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LITRE_CONSUMED = "litres_consumed";
    public static final String COLUMN_DATE = "date";

    private int id;
    private String litres_consumed;
    private String date;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_LITRE_CONSUMED + " TEXT,"
                    + COLUMN_DATE + " TEXT"
                    + ")";

    public WaterIntake(){}

    public WaterIntake(int id, String litres_consumed){
        this.id = id;
        this.litres_consumed = litres_consumed;
    }

    public WaterIntake(int id, String litres_consumed, String date){
        this.id = id;
        this.litres_consumed = litres_consumed;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaterIntake() {
        return litres_consumed;
    }

    public void setWaterIntake(String litres_consumed) {
        this.litres_consumed = litres_consumed;
    }

    public String getDate() {
        return date;
    }

    public void setTimestamp(String date) {
        this.date = date;
    }
}
