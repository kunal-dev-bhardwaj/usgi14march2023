package com.universalsompo.meta.metaapp.health.fragment.blogs.model;

public class Blog {
    private String BlogHeading, BlogID, ImagePath;

    public Blog(String blogHeading, String blogID, String imagePath)
    {
        BlogHeading = blogHeading;
        BlogID = blogID;
        ImagePath = imagePath;
    }

    public String getBlogHeading() {
        return BlogHeading;
    }

    public String getBlogID() {
        return BlogID;
    }

    public String getImagePath() {
        return ImagePath;
    }

}
