package a2340.m4_login;

import java.io.Serializable;

public class RatSighting implements Serializable{

    private int key;
    private String createdDate;
    private LocationType locType;
    private int incZip;
    private String incAdd;
    private City city;
    private Borough borough;
    private double latitude;
    private double longitude;

    public RatSighting(int k, String cD, LocationType lT, int iZ, String iA,
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

    public String toString() {
        String str = "";
        String inczip, longitud, latitud;
        if(incZip == 0) {
            inczip = "unknown";
        } else {
            inczip = "" + incZip;
        }
        if(longitude == 0) {
            longitud = "unknown";
        } else {
            longitud = "" + longitude;
        }
        if(incZip == 0) {
            latitud = "unknown";
        } else {
            latitud = "" + latitude;
        }

        str += ("Key: " + key);
        str += (", Date Created: " + createdDate);
        str += (", Location Type: " + locType.getDetail());
        str += (", Incident Zip: " + inczip);
        str += (", Incident Address: " + incAdd);
        str += (", City: " + city.getDetail());
        str += (", Borough: " + borough.getDetail());
        str += (", Latitude: " + latitud);
        str += (", Longitude: " + longitud);
        return str;
    }
}
