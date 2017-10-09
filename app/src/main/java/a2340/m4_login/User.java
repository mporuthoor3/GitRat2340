package a2340.m4_login;

import java.io.Serializable;

public class User implements Serializable{

    private String name, user, password;
    private boolean admin;

    public User(String nam, boolean adm, String id, String pass) {
        name = nam;
        admin = adm;
        user = id;
        password = pass;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return password;
    }

}
