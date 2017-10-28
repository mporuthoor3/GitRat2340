package a2340.m4_login;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * Created by zlillie on 10/26/17.
 */

public class FilterDataActivity extends AppCompatActivity {
    Button filterData;
    DatePicker startDate;
    DatePicker endDate;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filterdata);

        inflateWidgets();
    }

    private void inflateWidgets() {
        filterData = (Button) findViewById(R.id.filterButton);
        filterData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilterDataActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        startDate = (DatePicker) findViewById(R.id.startDatePicker);
        endDate = (DatePicker) findViewById(R.id.endDatePicker);

    }

}
