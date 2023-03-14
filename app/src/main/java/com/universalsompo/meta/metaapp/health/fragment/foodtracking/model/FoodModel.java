package com.universalsompo.meta.metaapp.health.fragment.foodtracking.model;

public class FoodModel {
    private String name;
    private String cal;
    private String food_id;
    private String date;
    private String meal_type;
    private String no_of_serve;

    public FoodModel(String Name, String Cal, String Food_id, String Date, String Meal_type, String No_of_serve)
    {
        name = Name;
        cal = Cal;
        food_id = Food_id;
        date = Date;
        meal_type = Meal_type;
        no_of_serve = No_of_serve;
    }

    public String getname() {
        return name;
    }

    public String getcal() {
        return cal;
    }

    public String getfood_id() {
        return food_id;
    }

    public String getdate() {
        return date;
    }

    public String getmeal_type() {
        return meal_type;
    }

    public String getNo_of_serve() { return no_of_serve;}
}
