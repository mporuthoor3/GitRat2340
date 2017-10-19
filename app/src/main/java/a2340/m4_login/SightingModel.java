package a2340.m4_login;

import java.util.ArrayList;
import java.util.List;

public class SightingModel {

    public static final SightingModel model = new SightingModel();
    private List<RatSighting> sightings;

    public SightingModel() {
        sightings = new ArrayList<RatSighting>();
    }

    public void addItem(RatSighting r) {
        sightings.add(r);
    }

    public List<RatSighting> getSightings() {
        return sightings;
    }

    public void addToFront(RatSighting r) {
        sightings.add(0, r);
    }

}
