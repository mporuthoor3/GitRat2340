package a2340.m4_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Allows users to add a new rat sighting to the ListView.
 */
public class EnterDataActivity extends AppCompatActivity {

    private Spinner locType;
    private EditText zip;
    private EditText address;
    private Spinner cityType;
    private Spinner boroughType;
    private EditText lati, longi;
    private Button submit;

    private String dt, adr;
    private int key, zp;
    private Double latitude, longitude;
    private LocationType loc;
    private City ct;
    private Borough br;

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference ReportRef = mRootRef.child("ratReports");
    /**
     * Sets layout view.
     * @param savedInstanceState current state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);

        inflateWidgets();
        userClick();
    }

    /**
     * Inflates widgets.
     */
    private void inflateWidgets() {
        locType = (Spinner) findViewById(R.id.locSpinner);
        locType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, LocationType.values()));
        cityType = (Spinner) findViewById(R.id.citySpinner);
        cityType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, City.values()));
        boroughType = (Spinner) findViewById(R.id.boroughSpinner);
        boroughType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Borough.values()));
        zip = (EditText) findViewById(R.id.zip);
        address = (EditText) findViewById(R.id.Address);
        lati = (EditText) findViewById(R.id.latitideText);
        longi = (EditText) findViewById(R.id.longitudeText);
        submit = (Button) findViewById(R.id.submit_Button);

    }

    /**
     * Listens for user inputs.
     */
    private void userClick() {

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    loc = LocationType.valueOf(locType.getSelectedItem().toString());
                    zp = Integer.parseInt(zip.getText().toString());
                    adr = address.getText().toString();
                    ct = City.valueOf(cityType.getSelectedItem().toString());
                    br = Borough.valueOf(boroughType.getSelectedItem().toString());
                    latitude = Double.parseDouble(lati.getText().toString());
                    longitude = Double.parseDouble(longi.getText().toString());
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    dt = timestamp.toString();
                    key = 37018532 + (((int)(Math.random() * 20000)) + 37);
                    //RatSighting r = new RatSighting(key, dt, loc, zp, adr, ct, br, latitude, longitude);
                    writeNewPost(key, dt, loc, zp, adr, ct, br, latitude, longitude);

                    //SightingModel model = SightingModel.model;
                    //model.addToFront(r);
                } catch (Exception e){
                    // do nothing
                }
                onBackPressed();
            }
        });
    }

    /**
     * Creates an intent to go back to HomeActivity.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    /**
     * Creates a new rat report.
     * @param k is the ratSighting's key
     * @param cD is created date
     * @param lT is the location type
     * @param iZ is the incident zip
     * @param iA is the incident adress
     * @param c is the city
     * @param b if the borough
     * @param lat is the latitude
     * @param lon is the longitude
     */
    private void writeNewPost(int k, String cD, LocationType lT, int iZ, String iA,
                              City c, Borough b, double lat, double lon) {

        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously

        String key = ReportRef.push().getKey();
        System.out.println(key);
        ReportPost reportPost = new ReportPost(k, cD, lT, iZ, iA, c, b, lat, lon);
        Map<String, Object> postValues = reportPost.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);

        ReportRef.updateChildren(childUpdates);

    }
}
