package com.universalsompo.meta.metaapp.health.fragment.foodtracking.model;

public class FoodModel1 {
    private String name;
    private String nutrition;
    private String food_id;
    private String cal;
    private String carb;
    private String pro;
    private String fat;
    private String serve_desc;

    public FoodModel1(String Name, String Nutrition, String Food_id, String Cal, String Carb, String Pro, String Fat, String Serve_desc)
    {
        name = Name;
        nutrition = Nutrition;
        food_id = Food_id;
        cal = Cal;
        carb = Carb;
        pro = Pro;
        fat = Fat;
        serve_desc = Serve_desc;
    }

    public String getname() {
        return name;
    }

    public String getnutrition() {
        return nutrition;
    }

    public String getFood_id() {
        return food_id;
    }

    public String getCal() {
        return cal;
    }

    public String getCarb() {
        return carb;
    }

    public String getPro() {
        return pro;
    }

    public String getFat() {
        return fat;
    }

    public String getServe_desc() {
        return serve_desc;
    }
}
