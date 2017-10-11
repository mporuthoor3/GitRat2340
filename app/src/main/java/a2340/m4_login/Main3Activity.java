package a2340.m4_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class Main3Activity extends AppCompatActivity {
    private Button logOut;
    private TextView text;
    private Button readRatData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text = (TextView) findViewById(R.id.textView);
        Scanner s = new Scanner(Main2Activity.getCurr().getName());
        text.setText("Welcome, " + s.next());
        logOut = (Button) findViewById(R.id.Log_Out);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
        readRatData = (Button) findViewById(R.id.readRatData);
        readRatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity2();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    private void launchActivity() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    private void launchActivity2() {
        InputStream is = getResources().openRawResource(R.raw.rat_sightings);
        LoadSightings.loadData(is);
    }
}
