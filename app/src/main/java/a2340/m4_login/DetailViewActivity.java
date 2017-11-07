package a2340.m4_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static a2340.m4_login.R.id.uniqueIdText;

/**
 * Created by zlillie on 10/11/17.
 * A controller class for DetailView.
 */
public class DetailViewActivity extends AppCompatActivity {
    private TextView idText;
    private TextView createdDateText;
    private TextView locTypeText;
    private TextView zipText;
    private TextView addressText;
    private TextView cityText;
    private TextView boroughText;
    private TextView latitudeText;
    private TextView longitudeText;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview);
        inflateWidgets();
        retrieveIntentInfo();
    }

    /**
     * Inflates widgets that will appear on the DetailView.
     */
    private void inflateWidgets() {
        idText = (TextView) findViewById(uniqueIdText);
        createdDateText = (TextView) findViewById(R.id.createdDateText);
        locTypeText = (TextView) findViewById(R.id.locTypeText);
        zipText = (TextView) findViewById(R.id.zipText);
        addressText = (TextView) findViewById(R.id.addressText);
        cityText = (TextView) findViewById(R.id.cityText);
        boroughText = (TextView) findViewById(R.id.boroughText);
        latitudeText = (TextView) findViewById(R.id.latitudeText);
        longitudeText = (TextView) findViewById(R.id.longitudeText);
        backButton = (Button) findViewById(R.id.goBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchListViewActivity();
            }
        });
    }

    /**
     * Gets information that was passed from ListViewActivity.
     */
    private void retrieveIntentInfo() {
        String id = this.getIntent().getExtras().getString("id");
        idText.setText("ID: " + id);

        String createdDate = this.getIntent().getExtras().getString("created");
        createdDateText.setText("CREATED DATE: " + createdDate);

        String locationType = this.getIntent().getExtras().getString("location-type");
        locTypeText.setText("LOCATION TYPE: " + locationType);

        String zipCode = this.getIntent().getExtras().getString("zip-code");
        zipText.setText("ZIP CODE: " + zipCode);

        String address = this.getIntent().getExtras().getString("address");
        addressText.setText("ADDRESS: " + address);

        String borough = this.getIntent().getExtras().getString("borough");
        boroughText.setText("BOROUGH: " + borough);

        String city = this.getIntent().getExtras().getString("city");
        cityText.setText("CITY: " + city);

        String latitude = this.getIntent().getExtras().getString("latitude");
        latitudeText.setText("LATITUDE: " + latitude);

        String longitude = this.getIntent().getExtras().getString("longitude");
        longitudeText.setText("LONGITUDE: " + longitude);
    }

    /**
     * Launches ListViewActivity when users press the back button.
     */
    private void launchListViewActivity() {
        Intent intent = new Intent(DetailViewActivity.this, ListViewActivity.class);
        startActivity(intent);
    }
}
