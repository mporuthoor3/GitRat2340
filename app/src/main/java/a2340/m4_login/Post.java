package a2340.m4_login;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharlesXu on 2017/10/24.
 */

public class Post {
    public String name, user, password;
    public boolean admin;
    public Map<String, Boolean> stars = new HashMap<>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String nam, boolean adm, String use, String pass) {
        name = nam;
        admin = adm;
        user = use;
        password = pass;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("user", user);
        result.put("password", password);
        result.put("Admin", admin);
        return result;
    }
}