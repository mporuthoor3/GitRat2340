package a2340.m4_login;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * public class for filtering data
 */
public class FilterGraphDataActivity extends AppCompatActivity {
    Button filterData;
    DatePicker startDate;
    DatePicker endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtergraphdata);

        inflateWidgets();
    }

    private void inflateWidgets() {
        filterData = (Button) findViewById(R.id.filterButton);
        filterData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilterGraphDataActivity.this, GraphActivity.class);
                intent.putExtra("Start", toDateString(startDate));
                intent.putExtra("End", toDateString(endDate));
                startActivity(intent);
            }
        });

        startDate = (DatePicker) findViewById(R.id.startDatePicker);
        endDate = (DatePicker) findViewById(R.id.endDatePicker);

    }

    private String toDateString(DatePicker pic) {
        String str = "";

        int num = pic.getMonth() + 1;
        str += ((num<=9?"0"+num:String.valueOf(num))) + "/";
        num = pic.getDayOfMonth();
        str += (num<=9?"0"+num:String.valueOf(num)) + "/";
        str += pic.getYear() + " 00:00";

        return str;
    }

}
