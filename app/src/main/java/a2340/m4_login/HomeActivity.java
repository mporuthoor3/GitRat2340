package a2340.m4_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.InputStream;
import java.util.Scanner;

public class HomeActivity extends AppCompatActivity {

    private Button logOut;
    private TextView text;
    private Button readRatData;
    private Button enterData;
    private  int alreadyRead = 0;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference ReportRef = mRootRef.child("ratReports").child("posts");

    /**
     * Sets layout view.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        inflateWidgets();
    }

    /**
     * Inflates widgets.
     */
    private void inflateWidgets() {

        text = (TextView) findViewById(R.id.textView);
        Scanner s = new Scanner(UserActivity.getCurr().getName());
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
                if (SightingModel.model.getSightings().size() <= 1){
                    alreadyRead++;
                    launchActivity2();
                } else {
                    launchActivity3();
                }
            }
        });

        enterData = (Button) findViewById(R.id.enter_data);
        enterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchEnterData();
            }
        });
    }

    /**
     * Launch activities.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    private void launchActivity() {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
    private void launchActivity2() {
        InputStream is = getResources().openRawResource(R.raw.rat_sightings);
        LoadSightings.loadData(is);
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }
    private void launchActivity3() {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }
    private void launchEnterData() {
        Intent intent = new Intent(this, EnterDataActivity.class);
        startActivity(intent);
    }


    protected void onStart() {
        super.onStart();
        ReportRef.orderByChild("createdDate").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                ReportPost reportpost = dataSnapshot.getValue(ReportPost.class);
                SightingModel.model.addItem(new RatSighting(reportpost.key, reportpost.createdDate, reportpost.locType, reportpost.incZip,
                        reportpost.incAdd, reportpost.city, reportpost.borough, reportpost.latitude, reportpost.longitude));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
