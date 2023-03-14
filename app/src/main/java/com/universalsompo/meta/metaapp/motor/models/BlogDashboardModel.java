package com.universalsompo.meta.metaapp.motor.models;

public class BlogDashboardModel {
    private String BlogCategoryId, BlogCategoryName, BlogHeading, BlogId, BlogImage, Datetime;

    public BlogDashboardModel(String blogCategoryId, String blogCategoryName, String blogHeading, String blogId, String blogImage, String datetime) {
        BlogCategoryId = blogCategoryId;
        BlogCategoryName = blogCategoryName;
        BlogHeading = blogHeading;
        BlogId = blogId;
        BlogImage = blogImage;
        Datetime = datetime;
    }

    public String getBlogCategoryId() {
        return BlogCategoryId;
    }

    public String getBlogCategoryName() {
        return BlogCategoryName;
    }

    public String getBlogHeading() {
        return BlogHeading;
    }

    public String getBlogId() {
        return BlogId;
    }

    public String getBlogImage() {
        return BlogImage;
    }

    public String getDatetime() {
        return Datetime;
    }
}
