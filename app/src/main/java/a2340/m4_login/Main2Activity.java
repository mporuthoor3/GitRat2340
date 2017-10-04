package a2340.m4_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private Button signIn, register;
    private EditText userField;
    private EditText passField;
    private TextView Notification;
    private String user;
    private String password;
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<String> uNames = new ArrayList<String>();
    private static User curr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        signIn = (Button) findViewById(R.id.Sign_In_Button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userField = (EditText) findViewById(R.id.User_Input);
                passField = (EditText) findViewById(R.id.Password_Input);
                user = userField.getText().toString();
                password = passField.getText().toString();
                Notification = (TextView) findViewById(R.id.Notif);
                check();
            }
        });
        register = (Button) findViewById(R.id.Register_Button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity2();
            }
        });
    }

    public void check() {
        if (uNames.contains(user)) {
            curr = findUser(user);
            if (curr.getPass().equals(password)) {
                Notification.setText("");
                launchActivity();
            } else {
                curr = null;
                Notification.setText("Invalid Password");
            }
        } else {
            Notification.setText("Invalid User");
        }
    }

    private User findUser(String use) {
        for(int x = 0; x < users.size(); x++) {
            if (users.get(x).getUser().equals(use)) {
                return users.get(x);
            }
        }
        return null;
    }

    public static ArrayList<String> getNames() {
        return uNames;
    }

    public static void addUser(User person) {
        users.add(person);
        uNames.add(person.getUser());

    }

    public static User getCurr() {
        return curr;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void launchActivity() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    private void launchActivity2() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
