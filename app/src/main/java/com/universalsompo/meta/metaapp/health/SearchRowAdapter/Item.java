package com.universalsompo.meta.metaapp.health.SearchRowAdapter;

public class Item {
    private String FOOD_NAME;
    private String FOOD_DESCRIPTION;
    private String FOOD_BRAND;
    private String FOOD_ID;
    private String FOOD_CALORIES;
    private String FOOD_CARBS;
    private String FOOD_FAT;
    private String FOOD_PROTEIN;
    private String FOOD_SERVING;

    public Item(String food_name, String food_description, String food_brand, String food_id, String cal, String fat, String carb, String pro, String serve) {
        super();
        this.FOOD_NAME = food_name;
        this.FOOD_DESCRIPTION = food_description;
        this.FOOD_BRAND = food_brand;
        this.FOOD_ID = food_id;
        this.FOOD_CALORIES = cal;
        this.FOOD_CARBS = carb;
        this.FOOD_FAT = fat;
        this.FOOD_PROTEIN = pro;
        this.FOOD_SERVING = serve;
    }

    public String getID() {
        return FOOD_ID;
    }

    public String getBrand() {
        return FOOD_BRAND;
    }

    public String getTitle() {
        return FOOD_NAME;
    }

    public String getFoodDescription() {
        return FOOD_DESCRIPTION;
    }

    public String getFoodCal() {
        return FOOD_CALORIES;
    }

    public String getFoodCarb() {
        return FOOD_CARBS;
    }

    public String getFoodFat() {
        return FOOD_FAT;
    }

    public String getFoodPro() {
        return FOOD_PROTEIN;
    }

    public String getFoodServe() {
        return FOOD_SERVING;
    }
}
