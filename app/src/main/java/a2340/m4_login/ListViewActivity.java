package a2340.m4_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class ListViewActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv = (ListView) findViewById(R.id.RatView);
        ArrayAdapter<RatSighting> adapter = new ArrayAdapter<RatSighting>(this,
                android.R.layout.simple_list_item_1, SightingModel.model.getSightings());
        lv.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    private void launchActivity() {

    }

}
