package a2340.m4_login;
import android.app.Service;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manx on 11/13/2017.
 */

public class ManuTest {

    /**
     * Tests to see if the RatSighting constructor and getters are working
     */
    @Test
    public void testEquals() throws Exception{
        RatSighting r0 = new RatSighting(31464015, "9/4/2015", LocationType.MIXBUILDING3,
                10006, "", City.NEWYORK, Borough.MANHATTAN, 40.7077715536364,
                -74.0129630997047);
        RatSighting r1 = new RatSighting(31464045, "9/4/2015 0:00", LocationType.MIXBUILDING,
                10009, "blob", City.NEWYORK, Borough.BROOKLYN, 40.7066615536364,
                -74.0126660997047);
        //test key
        assertEquals(r0.getKEY(), 31464015);
        assertEquals(r1.getKEY(), 31464045);
        //test date
        assertEquals(false, r0.getDateString().equals("9/4/2015"));
        assertEquals(true, r0.getDateString().equals("09/04/2015"));
        assertEquals(false, r1.getDateString().equals("9/4/2015 0:00"));
        assertEquals(true, r1.getDateString().equals("09/04/2015 0:00"));
        //test locType
        assertEquals(true, r0.getLocTypeString().equals(LocationType.MIXBUILDING3.getDetail()));
        assertEquals(true, r1.getLocTypeString().equals(LocationType.MIXBUILDING.getDetail()));
        //test zip
        assertEquals(r0.getIncZipString(), "10006");
        assertEquals(r1.getIncZipString(), "10009");
        //test address
        assertEquals(false, r0.getIncAddString().equals(""));
        assertEquals(true, r0.getIncAddString().equals("unknown"));
        assertEquals(false, r1.getIncAddString().equals("unknown"));
        assertEquals(true, r1.getIncAddString().equals("blob"));
        //test city
        assertEquals(true, r0.getCityString().equals(City.NEWYORK.getDetail()));
        assertEquals(true, r1.getCityString().equals(City.NEWYORK.getDetail()));
        //test borough
        assertEquals(true, r0.getBoroughString().equals(Borough.MANHATTAN.getDetail()));
        assertEquals(true, r1.getBoroughString().equals(Borough.BROOKLYN.getDetail()));
        //test lat
        assertEquals(r0.getLatString(), "40.7077715536364");
        assertEquals(r1.getLatString(), "40.7066615536364");
        //test lon
        assertEquals(r0.getLonString(), "-74.0129630997047");
        assertEquals(r1.getLonString(), "-74.0126660997047");
    }

}