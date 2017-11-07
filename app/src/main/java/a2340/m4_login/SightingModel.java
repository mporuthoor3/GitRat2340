package a2340.m4_login;

import java.util.ArrayList;
import java.util.List;

/**
 * sightingMOdel that houses some information
 */
public class SightingModel {

    public static final SightingModel model = new SightingModel();
    private List<RatSighting> sightings;

    /**
     * default constructor
     */
    public SightingModel()    {
        sightings = new ArrayList<RatSighting>();
    }

    /**
     * add a new sighting to the model
     * @param r is the new ratSighting
     */
    public void addItem(RatSighting r) {
        sightings.add(r);
    }

    /**
     *
     * @return the sightings array
     */
    public List<RatSighting> getSightings() {
        return sightings;
    }

    /**
     * add a rat to the front of the array
     * @param r is the new rat
     */
    public void addToFront(RatSighting r) {

        sightings.add(0, r);
    }

}
