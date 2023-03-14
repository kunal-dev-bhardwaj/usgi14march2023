package com.universalsompo.meta.metaapp.health.database.model;

public class DietIntake {
    public static final String TABLE_NAME = "diet_intake";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MEAL_TYPE = "meal_type";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_CARBOHYDRATES = "carbs";
    public static final String COLUMN_FAT = "fat";
    public static final String COLUMN_PROTEIN = "protein";
    public static final String COLUMN_DATE = "date";

    private int id;
    private String meal_type;
    private String calories;
    private String carbs;
    private String fat;
    private String protein;
    private String date;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_MEAL_TYPE + " TEXT,"
                    + COLUMN_CALORIES + " TEXT,"
                    + COLUMN_CARBOHYDRATES + " TEXT,"
                    + COLUMN_FAT + " TEXT,"
                    + COLUMN_PROTEIN + " TEXT,"
                    + COLUMN_DATE + " TEXT"
                    + ")";

    public DietIntake(){}

    public DietIntake(int id, String meal_type, String calories, String carbs,  String fat, String protein){
        this.id = id;
        this.meal_type = meal_type;
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
    }

    public DietIntake(int id, String meal_type, String calories, String carbs,  String fat, String protein, String date){
        this.id = id;
        this.meal_type = meal_type;
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealType() {
        return meal_type;
    }

    public void setMealType(String meal_type) {
        this.meal_type = meal_type;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setcarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getDate() {
        return date;
    }

    public void setTimestamp(String date) {
        this.date = date;
    }
}
