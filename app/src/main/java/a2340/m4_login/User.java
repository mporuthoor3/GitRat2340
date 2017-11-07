package a2340.m4_login;

import java.io.Serializable;

/**
 * public class for the user
 */
public class User implements Serializable{

    private String name, user, password;
    private boolean admin;

    /**
     *
     * @param nam is the user's name
     * @param adm is the amd
     * @param id is the user name
     * @param pass is the password
     */
    public User(String nam, boolean adm, String id, String pass) {
        name = nam;
        admin = adm;
        user = id;
        password = pass;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the entire user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @return the user's password
     */
    public String getPass() {
        return password;
    }

}
