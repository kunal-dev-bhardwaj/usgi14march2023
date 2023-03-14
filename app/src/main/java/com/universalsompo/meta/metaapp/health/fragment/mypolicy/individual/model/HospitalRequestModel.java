package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model;

public class HospitalRequestModel {
    private String InsCompId;
    private String TokenNo;
    private String Latitude;
    private String Longitude;
    private String StateId;
    private String CityId;

    public String getInsCompId() {
        return InsCompId;
    }

    public void setInsCompId(String insCompId) {
        InsCompId = insCompId;
    }

    public String getTokenNo() {
        return TokenNo;
    }

    public void setTokenNo(String tokenNo) {
        TokenNo = tokenNo;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getStateId() {
        return StateId;
    }

    public void setStateId(String stateid) {
        StateId = stateid;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityid) {
        CityId = cityid;
    }
}
