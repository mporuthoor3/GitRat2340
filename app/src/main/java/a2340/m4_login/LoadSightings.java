package a2340.m4_login;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoadSightings {

    private static ArrayList<RatSighting> rats;

    public static void loadData(InputStream is) {

        SightingModel model = SightingModel.model;
        BufferedReader s = new BufferedReader(new InputStreamReader(is));
        String str;
        String[] strs;
        int count = 0;

        int key;
        String createdDate;
        LocationType locType;
        int incZip;
        String incAdd;
        City city;
        Borough borough;
        double latitude;
        double longitude;

        try {
            str = s.readLine();
            while ((str = s.readLine()) != null) {
                strs = str.split(",");
                if (strs[0].length() != 0) {
                    key = Integer.parseInt(strs[0]);
                } else {
                    key = 35502335 + count;
                }
                if (strs[1].length() != 0) {
                    createdDate = strs[1];
                } else {
                    createdDate = "unknown";
                }
                locType = LocationType.valueOf(LocationType.getNam(strs[7].toLowerCase()));
                if (strs[8].length() != 0) {
                    try {
                        incZip = Integer.parseInt(strs[8]);
                    } catch (NumberFormatException n) {
                        incZip = 0;
                    }
                } else {
                    incZip = 0;
                }
                if (strs[9].length() != 0) {
                    incAdd = strs[9];
                } else {
                    incAdd = "unknown";
                }
                city = City.valueOf(City.getNam(strs[16].toLowerCase()));
                borough = Borough.valueOf(Borough.getNam(strs[23].toLowerCase()));
                if (strs.length >= 50 && strs[49].length() != 0) {
                    latitude = Double.parseDouble(strs[49]);
                } else {
                    latitude = 0;
                }
                if (strs.length >= 51 && strs[50].length() != 0) {
                    longitude = Double.parseDouble(strs[50]);
                } else {
                    longitude = 0;
                }
                RatSighting rat = new RatSighting(key, createdDate, locType, incZip, incAdd, city,
                        borough, latitude, longitude);
                model.addItem(rat);
                count++;
            }
            Log.d("data", "end read in");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
