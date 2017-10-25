package a2340.m4_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Map;
import java.util.HashMap;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    private Button register;
    private String name, user, password;
    private boolean admin;
    private EditText nameField, userField, passField;
    private Spinner adminSpinner;
    private TextView Notification;

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference userRef = mRootRef.child("users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button) findViewById(R.id.Register_Button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameField = (EditText) findViewById(R.id.Name_Input);
                adminSpinner = (Spinner) findViewById(R.id.Admin_Spinner);
                userField = (EditText) findViewById(R.id.User_Input);
                passField = (EditText) findViewById(R.id.Password_Input);
                name = nameField.getText().toString();
                admin = adminSpinner.getItemAtPosition(adminSpinner.getSelectedItemPosition())
                        .toString().equals("Admin");
                user = userField.getText().toString();
                password = passField.getText().toString();
                Notification = (TextView) findViewById(R.id.Notification);
                check();
            }
        });
    }

    private void check() {
        if (Main2Activity.getNames().contains(user)) {
            Notification.setText("Invalid User");
            return;
        } else {
            Notification.setText("");
            Main2Activity.addUser(new User(name, admin, user, password));
            writeNewPost(name, admin, user, password);
            launchActivity();
        }
    }

    private void launchActivity() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    private void writeNewPost(String name, boolean admin, String user, String password) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = userRef.push().getKey();
        Post post = new Post(name, admin, user, password);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);

        userRef.updateChildren(childUpdates);

    }

}
