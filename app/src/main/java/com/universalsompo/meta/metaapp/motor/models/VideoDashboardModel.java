package com.universalsompo.meta.metaapp.motor.models;

public class VideoDashboardModel{
    private String VideoId, VideoHeading, VideoThumbnail, VideoCategoryID, VideoCategoryName, VideoCode, Datetime;

        public VideoDashboardModel(String videoId, String videoHeading, String videoThumbnail, String videoCategoryID, String videoCategoryName, String videoCode, String datetime) {
            VideoId = videoId;
            VideoHeading = videoHeading;
            VideoThumbnail = videoThumbnail;
            VideoCategoryID = videoCategoryID;
            VideoCategoryName = videoCategoryName;
            VideoCode = videoCode;
            Datetime = datetime;
        }

        public String getVideoId() {
            return VideoId;
        }

        public String getVideoHeading() {
            return VideoHeading;
        }

        public String getVideoThumbnail() {
            return VideoThumbnail;
        }

        public String getVideoCategoryID() {
            return VideoCategoryID;
        }

        public String getVideoCategoryName() {
            return VideoCategoryName;
        }

        public String getVideoCode() {
            return VideoCode;
        }

        public String getDatetime() {
            return Datetime;
        }
}
