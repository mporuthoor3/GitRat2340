package a2340.m4_login;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharlesXu on 2017/10/24.
 */

public class Post {
    public String name, user, password;
    public boolean admin;

    /**
     * default constructor
     */
    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    /**
     *
     * @param nam is the name
     * @param adm is adm
     * @param use is the user
     * @param pass is the password
     */
    public Post(String nam, boolean adm, String use, String pass) {
        name = nam;
        admin = adm;
        user = use;
        password = pass;
    }

    /**
     *
     * @return a map of the combined above items
     */
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("user", user);
        result.put("password", password);
        result.put("Admin", admin);
        return result;
    }
}