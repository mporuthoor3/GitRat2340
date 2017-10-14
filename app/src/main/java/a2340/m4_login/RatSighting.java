package a2340.m4_login;

import java.io.Serializable;

public class RatSighting implements Serializable {

    private int key;
    private String createdDate;
    private LocationType locType;
    private int incZip;
    private String incAdd;
    private City city;
    private Borough borough;
    private double latitude;
    private double longitude;
    private static int key2 = 1;

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

    public String getKeyString() {
        return "" + key;
    }

    public String getDateString() {
        return createdDate;
    }

    public String getLocTypeString() {
        return locType.getDetail();
    }

    public String getIncZipString() {
        if(incZip == 0) {
            return "unknown";
        } else {
            return "" + incZip;
        }
    }

    public String getIncAddString() {
        return incAdd;
    }

    public String getCityString() {
        return city.getDetail();
    }

    public String getBoroughString() {
        return borough.getDetail();
    }

    public String getLatString() {
        if(latitude == 0.0) {
            return "unknown";
        } else {
            return "" + latitude;
        }
    }

    public String getLonString() {
        if(longitude == 0.0) {
            return "unknown";
        } else {
            return "" + longitude;
        }
    }


    public String toString() {
        String str = ("Incident " + key + ":\nOn " + createdDate + ", a rat was seen");
        if(!locType.equals(LocationType.UNSPECIFIED)) {
            str += (" in the " + locType.getDetail());
        }
        if (!incAdd.equals("unknown")) {
            str += (" at " + incAdd);
        }
        if (!city.equals(City.UNSPECIFIED)) {
            str += (" in the city of " + city.getDetail());
        }
        str += ".";
        return str;
    }
    public static int getKEY() {
        return key2;
    }
}
