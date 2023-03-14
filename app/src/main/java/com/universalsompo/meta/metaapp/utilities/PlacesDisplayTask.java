package com.universalsompo.meta.metaapp.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.universalsompo.meta.metaapp.motor.activities.GoogleMapPlacesActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class PlacesDisplayTask extends AsyncTask<Object, Integer, List<HashMap<String, String>>> implements GoogleMap.OnMarkerClickListener {
    JSONObject googlePlacesJson;
    GoogleMap googleMap;
    private Context mContext;
    private ArrayList<Marker> markerList = new ArrayList<Marker>();
    LatLng latlng;
    List<HashMap<String, String>> list;
    private Bitmap icon;
    private Marker Selectedmarker = null;

    public PlacesDisplayTask(Context mContext) {
        this.mContext = mContext;
        icon = getIcon();
    }

    @Override
    protected List<HashMap<String, String>> doInBackground(Object... inputObj) {

        List<HashMap<String, String>> googlePlacesList = null;
        Places placeJsonParser = new Places();

        try {
            googleMap = (GoogleMap) inputObj[0];
            googlePlacesJson = new JSONObject((String) inputObj[1]);
            latlng = (LatLng) inputObj[2];
            googlePlacesList = placeJsonParser.parse(googlePlacesJson);
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }
        return googlePlacesList;
    }

    @Override
    protected void onPostExecute(List<HashMap<String, String>> list) {
        googleMap.clear();
        markerList.clear();
        this.list = list;
        googleMap.setOnMarkerClickListener(this);
        if(list==null)
            return;
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                MarkerOptions markerOptions = new MarkerOptions();
                HashMap<String, String> googlePlace = list.get(i);
                double lat = Double.parseDouble(Objects.requireNonNull(googlePlace.get("lat")));
                double lng = Double.parseDouble(Objects.requireNonNull(googlePlace.get("lng")));
                String placeName = googlePlace.get("place_name");
                String vicinity = googlePlace.get("vicinity");
                String formatedAddress=googlePlace.get("formatted_address");
                LatLng latLng = new LatLng(lat, lng);
                markerOptions.position(latLng);
                markerOptions.title(placeName + " : " + vicinity + " : " +formatedAddress);
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
                markerList.add(googleMap.addMarker(markerOptions));

            }
            markerList.add(googleMap.addMarker(new MarkerOptions().position(this.latlng).title("Current Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))));
            int width;
            int height;
            int padding;
            CameraUpdate cu;
            LatLngBounds.Builder builder;
            builder = new LatLngBounds.Builder();
            for (Marker marker : markerList) {
                builder.include(marker.getPosition());
            }
            LatLngBounds bounds = builder.build();
            width = mContext.getResources().getDisplayMetrics().widthPixels;
            height = mContext.getResources().getDisplayMetrics().heightPixels;
            padding = (int) (width * 0.15);
            cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
            googleMap.animateCamera(cu);
        } else {
            Toast.makeText(mContext, "No Place Found", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (markerList.contains(marker)) {
            int i = markerList.indexOf(marker);
            if (!marker.getTitle().equals("Current Location")) {
                HashMap<String, String> data = list.get(i);
                GoogleMapPlacesActivity act = ((GoogleMapPlacesActivity) mContext);
                act.MarkerClick(data);
                setMarker(marker);
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    Bitmap getIcon() {
        String uri;
        uri = "@drawable/new_pinpoint_icon";
        IconGenerator generator = new IconGenerator(mContext);
        generator.setBackground(null);
        int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());
        ImageView iv = new ImageView(mContext);
        Drawable res = mContext.getResources().getDrawable(imageResource);
        iv.setImageDrawable(res);
        generator.setContentView(iv);
        return generator.makeIcon();
    }

    void setMarker(Marker marker) {
        if (Selectedmarker != null) {
            Selectedmarker.setIcon(BitmapDescriptorFactory.fromBitmap(normalIcon()));
        }
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(ActiveIcon()));
        Selectedmarker = marker;
    }

    Bitmap ActiveIcon() {
        String Select_uri;
        Select_uri = "@drawable/new_pinpoint_icon";
        IconGenerator generator = new IconGenerator(mContext);
        generator.setBackground(null);
        int imageResource = mContext.getResources().getIdentifier(Select_uri, null, mContext.getPackageName());
        ImageView iv = new ImageView(mContext);
        Drawable res = mContext.getResources().getDrawable(imageResource);
        iv.setImageDrawable(res);
        generator.setContentView(iv);
        return generator.makeIcon();
    }

    Bitmap normalIcon() {
        String normal_uri;
        normal_uri = "@drawable/new_pinpoint_icon";
        IconGenerator generator = new IconGenerator(mContext);
        generator.setBackground(null);
        int imageResource = mContext.getResources().getIdentifier(normal_uri, null, mContext.getPackageName());
        ImageView iv = new ImageView(mContext);
        Drawable res = mContext.getResources().getDrawable(imageResource);
        iv.setImageDrawable(res);
        generator.setContentView(iv);
        return generator.makeIcon();
    }
}

