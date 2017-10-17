package a2340.m4_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A controller class for ListView.
 */
public class ListViewActivity extends AppCompatActivity {

    private ListView lv;
    final Context context = this;

    /**
     * Sets layout view, inflates widgets, and adds a on-click listener to the ListView.
     * @param savedInstanceState saved state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv = (ListView) findViewById(R.id.RatView);
        ArrayAdapter<RatSighting> adapter = new ArrayAdapter<RatSighting>(this,
                android.R.layout.simple_list_item_1, SightingModel.model.getSightings());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                RatSighting entry = (RatSighting) adapter.getItemAtPosition(position);
                Intent intent = new Intent(context, DetailViewActivity.class);
                intent.putExtra("id", entry.getKeyString());
                intent.putExtra("created", entry.getDateString());
                intent.putExtra("location-type", entry.getLocTypeString());
                intent.putExtra("zip-code", entry.getIncZipString());
                intent.putExtra("address", entry.getIncAddString());
                intent.putExtra("city", entry.getCityString());
                intent.putExtra("borough", entry.getBoroughString());
                intent.putExtra("latitude", entry.getLatString());
                intent.putExtra("longitude", entry.getLonString());

                startActivity(intent);
            }
        });
    }

    /**
     * Creates an intent to start Main3Activity.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
