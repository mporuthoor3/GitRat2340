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

public class GraphActivity extends AppCompatActivity{

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference userRef = mRootRef.child("ratReports").child("posts");
    //private DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("ratReports");
    private GraphView graph;
    DataPoint[] pnts;

    /**
     * Sets layout view.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        String initialDate = this.getIntent().getExtras().getString("Start");
        String finalDate = this.getIntent().getExtras().getString("End");
  /*      userRef.orderByChild("date").startAt(initialDate).endAt(finalDate).limitToLast(50);
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
*/
      //experimentation code
        SightingModel model = SightingModel.model;

        //InputStream is = getResources().openRawResource(R.raw.rat_sightings);
        //LoadSightings.loadData(is);
        ArrayList<RatSighting> rats = (ArrayList<RatSighting>) model.getSightings();

        ArrayList<Date> months = new ArrayList<Date>();
        addMonths(months, initialDate, finalDate);
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for (int x = 0; x < months.size(); x++) {
            vals.add(0);
        }
        int max = 5000, count = 0;

        for (int x = 0; x < rats.size(); x++) {
            if (count >= max) {
                break;
            } else {
                int temp = checkDate(rats.get(x).getDateString(), initialDate, finalDate);
                if (temp != -1) {
                    int temp2 = vals.get(temp);
                    vals.set(temp, temp2+1);
                    count++;
                }
            }
        }

        pnts = new DataPoint[months.size()];
        for (int x = 0; x < months.size(); x++) {
            pnts[x] = new DataPoint(months.get(x), vals.get(x));
           // Log.d("data", months.get(x).toString() + " #"+vals.get(x));
        }

        graph = (GraphView) findViewById(R.id.graph);



        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(pnts);

        graph.addSeries(series);

        // set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graph.getGridLabelRenderer().setNumHorizontalLabels(2); // only 2 because of the space

// set manual x bounds to have nice steps
        try {
            SimpleDateFormat df = new SimpleDateFormat();
            graph.getViewport().setMinX(df.parse(initialDate).getTime());
            graph.getViewport().setMaxX(df.parse(finalDate).getTime());
        } catch (ParseException p) {

        }
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getGridLabelRenderer().setHumanRounding(false);

    }

    private void addMonths(ArrayList<Date> dates, String str, String str2) {
        String temp = str;
        boolean temp2 = true;
        while (temp2) {
            if (temp.substring(0,2).equals(str2.substring(0,2)) &&
                    temp.substring(6,10).equals(str2.substring(6,10))) {
                temp2 = false;
            } else {
                try{
                    dates.add(new java.text.SimpleDateFormat("MM/dd/yyyy").parse(temp.substring(0,10)));
                    Log.d("dates", new java.text.SimpleDateFormat("MM/dd/yyyy").parse(temp.substring(0,10)).toString());
                    temp = incMonth(temp);
                } catch (ParseException p) {

                }
            }
        }
    }

    private String incMonth(String str) {
        String str2 = str;
        if(Integer.parseInt(str2.substring(0,2)) == 12) {
            str2 = "01/" + str2.substring(3,5) + (Integer.parseInt(str2.substring(6,10))+1) + str2.substring(10);
        } else {
            int num = Integer.parseInt(str2.substring(0,2))+1;
            str2 = (num<=9?"0"+num:String.valueOf(num)) + str2.substring(2);
        }
        return str2;
    }

    private int checkDate(String date, String start, String end) {
        int dt, st, nd;
        dt = Integer.parseInt(date.substring(6,10)+date.substring(0,2)+date.substring(3,5));
        st = Integer.parseInt(start.substring(6,10)+start.substring(0,2)+start.substring(3,5));
        nd = Integer.parseInt(end.substring(6,10)+end.substring(0,2)+end.substring(3,5));
        if (dt >= st && dt <= nd) {
            int temp = st;
            st = ((temp/100)%100)+(12*temp/10000);
            temp = dt;
            dt = ((temp/100)%100)+(12*temp/10000);
            return dt-st;
        } else {
            return -1;
        }
    }
}
