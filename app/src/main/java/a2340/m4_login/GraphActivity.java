package a2340.m4_login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * public class for the graphs
 */
public class GraphActivity extends AppCompatActivity{

    //private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    //private DatabaseReference userRef = mRootRef.child("ratReports").child("posts");
    private DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("ratReports");
    private GraphView graph;
    DataPoint[] pnts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        String initialDate = this.getIntent().getExtras().getString("Start");
        String finalDate = this.getIntent().getExtras().getString("End");
        Log.d("tag","listen");
        userRef.orderByChild(null).startAt(initialDate).endAt(finalDate).limitToLast(50);
        userRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> collection = dataSnapshot.getChildren();

                ArrayList<Date> points = new ArrayList<Date>();
                ArrayList<Integer> vals = new ArrayList<Integer>();

                SimpleDateFormat df = new SimpleDateFormat();

                for (DataSnapshot ds: collection) {
                    ReportPost report = ds.getValue(ReportPost.class);
                    if (report.createdDate != null) {
                        try {
                            Date date = df.parse(report.createdDate);
                            int num = points.indexOf(date);
                            if (num != -1) {
                                vals.set(num, vals.get(num) + 1);
                            } else {
                                points.add(date);
                                vals.add(1);
                            }

                        } catch (ParseException p) {

                        }
                    }

                }
                pnts = new DataPoint[points.size()];
                for (int x = 0; x < points.size(); x++) {
                    pnts[x] = new DataPoint(points.get(x), vals.get(x));
                }

            }
        });

      //experimentation code
      /*SightingModel model = SightingModel.model;

        //InputStream is = getResources().openRawResource(R.raw.rat_sightings);
        //LoadSightings.loadData(is);
        ArrayList<RatSighting> rats = (ArrayList<RatSighting>) model.getSightings();

        ArrayList<Date> points = new ArrayList<Date>();
        ArrayList<Integer> vals = new ArrayList<Integer>();


        int start = Math.abs(initialDate.hashCode()/100000);
        int end = Math.min(Math.abs(finalDate.hashCode()/10000), rats.size());
        Log.d("tag","s"+start);
        Log.d("tag","e"+end);

        for (int x = start; x < start+50; x++) {
            try {
                Date date = df.parse(rats.get(x).getDateString());
               // Log.d("tag",date.toString());
                int num = points.indexOf(date);
                if (num != -1) {
                    vals.set(num, vals.get(num)+1);
                } else {
                    points.add(date);
                    vals.add(1);
                }

            } catch (ParseException p) {

            }

        }

        pnts = new DataPoint[points.size()];
        Log.d("tag","listen3");
        for (int x = 0; x < points.size(); x++) {
            pnts[x] = new DataPoint(points.get(x), vals.get(x));
            if (x % 2000 == 9)
                Log.d("tage", pnts[x].toString());
        }*/

        graph = (GraphView) findViewById(R.id.graph);



        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(pnts);

        graph.addSeries(series);

        // set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 3 because of the space

// set manual x bounds to have nice steps
        try {
            SimpleDateFormat df = new SimpleDateFormat();
            graph.getViewport().setMinX(df.parse(initialDate).getTime());
            graph.getViewport().setMaxX(df.parse(finalDate).getTime());
        } catch (ParseException p) {

        }
        graph.getViewport().setXAxisBoundsManual(true);

    }
}
