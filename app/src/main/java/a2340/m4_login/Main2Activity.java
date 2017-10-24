package a2340.m4_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import java.util.ArrayList;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;


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
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference userRef = mRootRef.child("users").child("posts");
    LoginButton loginButton;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email","public_profile");
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String userid = loginResult.getAccessToken().getUserId();
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        displayUserInfo(object);
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields","first_name, last_name,email,id");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
            }


            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

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

    public void checkwithFB(String name) {
        if (uNames.contains(user)) {
            curr = findUser(user);
            if (curr.getPass().equals(password)) {
                Notification.setText("");
                launchActivity();
            } else {
                curr = null;
                Notification.setText("Login Unsuccessful");
            }


        } else {
            Notification.setText("");
            Main2Activity.addUser(new User(name, false, user, password));
            launchActivity();
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

    public void displayUserInfo(JSONObject Object) {
        String first_name, last_name, email,id;
        first_name = "";
        last_name = "";
        email = "";
        id = "";
        try {
            first_name = Object.getString("first_name");
            last_name = Object.getString("last_name");
            email = Object.getString("email");
            id = Object.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        userField = (EditText) findViewById(R.id.User_Input);
        passField = (EditText) findViewById(R.id.Password_Input);
        userField.setText(first_name + "_"+ last_name);
        String pass = (first_name+last_name+email+id);
        int hashPass = pass.hashCode();
        String passw = Integer.toString(hashPass);
        passField.setText(passw);

        user = userField.getText().toString();
        password = passField.getText().toString();
        Notification = (TextView) findViewById(R.id.Notif);

        String tempName = first_name+ " "+ last_name;

        checkwithFB(tempName);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void onStart() {
        super.onStart();
        userRef.orderByChild("user").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Post post = dataSnapshot.getValue(Post.class);
                Main2Activity.addUser(new User(post.name, post.admin, post.user, post.password));
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
