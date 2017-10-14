package a2340.m4_login;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class enterDataActivity extends AppCompatActivity {
    private EditText date;
    private Spinner locType;
    private EditText zip;
    private EditText address;
    private Spinner cityType;
    private Spinner boroughType;
    private EditText lati, longi;
    private Button submit;

    private String dt, adr;
    private int zp;
    private Double latitude, longitude;
    private LocationType loc;
    private City ct;
    private Borough br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);
        locType = (Spinner) findViewById(R.id.locSpinner);
        locType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, LocationType.values()));
        cityType = (Spinner) findViewById(R.id.citySpinner);
        cityType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, City.values()));
        boroughType = (Spinner) findViewById(R.id.boroughSpinner);
        boroughType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Borough.values()));
        date = (EditText) findViewById(R.id.date_button);
        zip = (EditText) findViewById(R.id.zip);
        address = (EditText) findViewById(R.id.Address);
        lati = (EditText) findViewById(R.id.latitideText);
        longi = (EditText) findViewById(R.id.longitudeText);




        submit = (Button) findViewById(R.id.submit_Button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dt = date.getText().toString();
                    loc = LocationType.valueOf(locType.getSelectedItem().toString());
                    zp = Integer.parseInt(zip.getText().toString());
                    adr = address.getText().toString();
                    ct = City.valueOf(cityType.getSelectedItem().toString());
                    br = Borough.valueOf(boroughType.getSelectedItem().toString());
                    latitude = Double.parseDouble(lati.getText().toString());
                    longitude = Double.parseDouble(longi.getText().toString());
                    RatSighting r = new RatSighting(RatSighting.getKEY(), dt, loc, zp, adr, ct, br, latitude, longitude);

                    SightingModel model = SightingModel.model;


                    model.addToFront(r);
                } catch (Exception e){

                }
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
