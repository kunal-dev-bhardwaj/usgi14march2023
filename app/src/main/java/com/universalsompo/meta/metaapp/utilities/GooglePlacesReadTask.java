package com.universalsompo.meta.metaapp.utilities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class GooglePlacesReadTask extends AsyncTask<Object, Integer, String> {
    private String googlePlacesData = null;
    private GoogleMap googleMap;
    @SuppressLint("StaticFieldLeak")
    Context mContext;
    private LatLng latlng;

    public GooglePlacesReadTask(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    protected String doInBackground(Object... inputObj) {

        try {
            googleMap = (GoogleMap) inputObj[0];
            String googlePlacesUrl = (String) inputObj[1];
            latlng = (LatLng) inputObj[2];
            Http http = new Http();
            googlePlacesData = http.read(googlePlacesUrl);
        } catch (Exception e) {
             LogUtils.showLog("$$$$$$$$$$$$$$$", e.toString());
        }
        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String result) {
        PlacesDisplayTask placesDisplayTask = new PlacesDisplayTask(mContext);
        Object[] toPass = new Object[3];
        toPass[0] = googleMap;
        toPass[1] = result;
        toPass[2]=latlng;
        placesDisplayTask.execute(toPass);
    }
}