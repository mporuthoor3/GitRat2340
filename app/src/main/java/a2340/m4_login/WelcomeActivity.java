package a2340.m4_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Welcomes users to the app.
 */
public class WelcomeActivity extends AppCompatActivity {

    private Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign = (Button) findViewById(R.id.button);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
    }

    private void launchActivity() {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
}
