package a2340.m4_login;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharlesXu on 2017/10/24.
 * this class wraps the ratSighting instance and uploads that onto Firebase database
 */

public class ReportPost {

    public int key;
    public String createdDate;
    public LocationType locType;
    public int incZip;
    public String incAdd;
    public City city;
    public Borough borough;
    public double latitude;
    public double longitude;
    public static int key2 = 1;

    public ReportPost() {
        // Default constructor required for calls to DataSnapshot.getValue(ReportPost.class)
    }

    public ReportPost(int k, String cD, LocationType lT, int iZ, String iA,
                      City c, Borough b, double lat, double lon) {
        key = k;
        createdDate = cD;
        locType = lT;
        incZip = iZ;
        incAdd = iA;
        city = c;
        borough = b;
        latitude = lat;
        longitude = lon;
    }

    public Map<String, Object> toMap() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("key", key);
        result.put("createdDate", createdDate);
        result.put("locType", locType);
        result.put("incZip", incZip);
        result.put("incAdd", incAdd);
        result.put("city", city);
        result.put("borough", borough);
        result.put("latitude", latitude);
        result.put("longitude", longitude);
        return result;
    }
}
