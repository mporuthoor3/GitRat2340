package a2340.m4_login;

import java.io.Serializable;

/**
 * A model class that defines characteristics for RatSighting.
 */
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
    private static int counter;

    /**
     * Creates an instance of RatSighting.
     * @param k unique key
     * @param cD time stamp
     * @param lT location type
     * @param iZ zip code
     * @param iA address
     * @param c city
     * @param b borough
     * @param lat latitude
     * @param lon longitude
     */
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

    /**
     * A getter method for a unique key.
     * @return unique key
     */
    public String getKeyString() {
        return "" + key;
    }

    /**
     * A getter method for date of creation.
     * @return created date
     */
    public String getDateString() {
        return createdDate;
    }

    /**
     * A getter method for location type.
     * @return type of location
     */
    public String getLocTypeString() {
        return locType.getDetail();
    }

    /**
     * A getter method for zip code.
     * @return zip code
     */
    public String getIncZipString() {
        if(incZip == 0) {
            return "unknown";
        } else {
            return "" + incZip;
        }
    }

    /**
     * A getter method for address.
     * @return address
     */
    public String getIncAddString() {
        return incAdd;
    }

    /**
     * A getter method for city.
     * @return city
     */
    public String getCityString() {
        return city.getDetail();
    }

    /**
     * A getter method for borough.
     * @return borough
     */
    public String getBoroughString() {
        return borough.getDetail();
    }

    /**
     * A getter method for latitude.
     * @return latitude
     */
    public String getLatString() {
        if(latitude == 0.0) {
            return "unknown";
        } else {
            return "" + latitude;
        }
    }

    /**
     * A getter method for longitude.
     * @return longitude
     */
    public String getLonString() {
        if(longitude == 0.0) {
            return "unknown";
        } else {
            return "" + longitude;
        }
    }

    /**
     * Returns a description of a uniquely generated RatSighting.
     * @return String
     */
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

    /**
     * Returns an integer representation of a unique key.
     * @return key
     */
    public int getKEY() {
        return key;
    }
}
