package com.universalsompo.meta.metaapp.health.fragment.todayexercise;

public class ExerciseCalorieIntake {
    public static final String TABLE_NAME = "exercise_calorie_intake";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_DATE = "date";

    private int id;
    private String user_id;
    private String type;
    private String calories;
    private String date;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_USER_ID + " TEXT,"
                    + COLUMN_TYPE + " TEXT,"
                    + COLUMN_CALORIES + " TEXT,"
                    + COLUMN_DATE + " TEXT"
                    + ")";

    public ExerciseCalorieIntake() {
    }

    public ExerciseCalorieIntake(int id, String user_id, String type, String calories, String date) {
        this.id = id;
        this.user_id = user_id;
        this.type = type;
        this.calories = calories;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return user_id;
    }

    public void setUserid(String user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public void setTimestamp(String date) {
        this.date = date;
    }
}