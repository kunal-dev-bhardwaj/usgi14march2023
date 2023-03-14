package com.universalsompo.meta.metaapp.motor.models;

import java.io.Serializable;

public class MotorRssModel implements Serializable {
    private String Category;
    private String CategoryId;
    private String ImagePath;
    private String Links;
    private String PubDate;
    private String Title;

    public MotorRssModel(String category, String categoryId, String imagePath, String links, String pubDate, String title) {
        this.Category = category;
        this.CategoryId = categoryId;
        this.ImagePath = imagePath;
        this.Links = links;
        this.PubDate = pubDate;
        this.Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getLinks() {
        return Links;
    }

    public String getPubDate() {
        return PubDate;
    }

    public String getTitle() {
        return Title;
    }
}
