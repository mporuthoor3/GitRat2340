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

    /**
     *
     * @return admin status
     */
    public boolean isAdmin() {
        return this.admin;
    }

    /**
     *
     * @param other the object to compare
     * @return boolean compare result
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        User temp = (User) other;
        return (temp.getName() == this.getName() && temp.getUser() == this.getUser() && temp.getPass() == this.getPass()
                && temp.isAdmin() == this.isAdmin());

    }

}
