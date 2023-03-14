package com.universalsompo.meta.metaapp.motor.models;

import java.io.Serializable;

public class ContentModel implements Serializable {
    private String thumbnail;
    private String heading;
    private String pubdate;
    private String description;
    private String url;

    public String getPubDate() {
        return pubdate;
    }

    public ContentModel(String thumbnail, String heading,String pubdate, String description, String url) {
        this.thumbnail = thumbnail;
        this.heading = heading;
        this.pubdate=pubdate;
        this.description=description;
        this.url=url;
    }

    public String getthumbnail() {
        return thumbnail;
    }

    public String getheading() {
        return heading;
    }

    public String getdescription() {
        return description;
    }

    public String geturl() {
        return url;
    }
}
