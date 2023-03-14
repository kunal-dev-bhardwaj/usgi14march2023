package com.universalsompo.meta.metaapp.health.fragment.foodtracking.database;

public class FoodIntake1 {
    public static final String TABLE_NAME = "diet_intake_popular_items";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_MEAL_TYPE = "meal_type";
    public static final String COLUMN_FOOD_NAME = "food_name";
    public static final String COLUMN_FOOD_ID = "food_id";
    public static final String COLUMN_FOOD_NUTRITION = "food_nutrition";
    public static final String COLUMN_INCREMENT = "increment";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_CARBOHYDRATES = "carbs";
    public static final String COLUMN_FAT = "fat";
    public static final String COLUMN_PROTEIN = "protein";
    public static final String COLUMN_SERVING_DESC = "serving_desc";

    private int id;
    private String user_id;
    private String meal_type;
    private String food_name;
    private String food_id;
    private String food_nutrition;
    private String increment;
    private String calories;
    private String carbs;
    private String fat;
    private String protein;
    private String serving_desc;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_USER_ID + " TEXT,"
                    + COLUMN_MEAL_TYPE + " TEXT,"
                    + COLUMN_FOOD_NAME + " TEXT,"
                    + COLUMN_CALORIES + " TEXT,"
                    + COLUMN_CARBOHYDRATES + " TEXT,"
                    + COLUMN_FAT + " TEXT,"
                    + COLUMN_PROTEIN + " TEXT,"
                    + COLUMN_SERVING_DESC + " TEXT,"
                    + COLUMN_FOOD_ID + " TEXT,"
                    + COLUMN_FOOD_NUTRITION + " TEXT,"
                    + COLUMN_INCREMENT + " TEXT"
                    + ")";

    public FoodIntake1(){}

    public FoodIntake1(int id, String user_id, String meal_type, String food_name, String calories, String carbs,  String fat, String protein, String serving_desc, String food_id, String food_nutrition, String increment){
        this.id = id;
        this.user_id = user_id;
        this.meal_type = meal_type;
        this.food_name = food_name;
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
        this.serving_desc = serving_desc;
        this.food_id = food_id;
        this.food_nutrition = food_nutrition;
        this.increment = increment;
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

    public String getMealType() {
        return meal_type;
    }

    public void setMealType(String meal_type) {
        this.meal_type = meal_type;
    }

    public String getFoodName() {
        return food_name;
    }

    public void setFoodName(String food_name) {
        this.food_name = food_name;
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

    public String getServing_desc() {
        return serving_desc;
    }

    public void setServing_desc(String serving_desc) {
        this.serving_desc = serving_desc;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getFood_nutrition() {
        return food_nutrition;
    }

    public void setFood_nutrition(String food_nutrition) {
        this.food_nutrition = food_nutrition;
    }

    public String getIncrement() {
        return increment;
    }

    public void setIncrement(String increment) {
        this.increment = increment;
    }
}
