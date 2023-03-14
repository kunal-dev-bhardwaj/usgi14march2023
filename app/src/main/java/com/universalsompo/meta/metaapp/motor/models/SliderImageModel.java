package com.universalsompo.meta.metaapp.motor.models;

public class SliderImageModel {

    private String SliderId;
    private String ImagePath;

    public SliderImageModel(String sliderId, String imagePath) {
        SliderId = sliderId;
        ImagePath = imagePath;

    }

    public String getSliderId() {
        return SliderId;
    }

    public String getImagePath() {
        return ImagePath;
    }


}
