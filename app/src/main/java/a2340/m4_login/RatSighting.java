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


}
