package com.universalsompo.meta.metaapp.utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Places {

    public List<HashMap<String, String>> parse(JSONObject jsonObject) {
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }

    private List<HashMap<String, String>> getPlaces(JSONArray jsonArray) {
        int placesCount = jsonArray.length();
        List<HashMap<String, String>> placesList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> placeMap = null;

        for (int i = 0; i < placesCount; i++) {
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(placeMap);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return placesList;
    }

    private HashMap<String, String> getPlace(JSONObject googlePlaceJson) {
        HashMap<String, String> googlePlaceMap = new HashMap<String, String>();
        String formattedAddress="-NA-";
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";
        String photo_Ref = "-NA-";
        String Rating = "-NA-";
        String Opening_Hours="-NA-";

        try {
            if (!googlePlaceJson.isNull("name")) {
                placeName = googlePlaceJson.getString("name");
            } if (!googlePlaceJson.isNull("formatted_address")) {
                formattedAddress = googlePlaceJson.getString("formatted_address");
            }
            if (!googlePlaceJson.isNull("vicinity")) {
                vicinity = googlePlaceJson.getString("vicinity");
            }
            latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = googlePlaceJson.getString("reference");
            try {
                photo_Ref = googlePlaceJson.getJSONArray("photos").getJSONObject(0).getString("photo_reference");
            } catch (Exception e) {
                        e.printStackTrace();
                    }
            try{
                Rating = googlePlaceJson.getString("rating");

            }catch (Exception e)
            {
            }
            try{
                Opening_Hours = googlePlaceJson.getJSONObject("opening_hours").getString("open_now");
            }catch (Exception e)
            {

            }

            googlePlaceMap.put("place_name", placeName);
            googlePlaceMap.put("formatted_address", formattedAddress);
            googlePlaceMap.put("vicinity", vicinity);
            googlePlaceMap.put("lat", latitude);
            googlePlaceMap.put("lng", longitude);
            googlePlaceMap.put("place_reference", reference);
            googlePlaceMap.put("photo_Ref", photo_Ref);
            googlePlaceMap.put("rating", Rating);
            googlePlaceMap.put("open_hour", Opening_Hours);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return googlePlaceMap;
    }
}