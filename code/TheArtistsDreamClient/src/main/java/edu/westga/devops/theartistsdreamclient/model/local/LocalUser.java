package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.User;

/**
 * The User Class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class LocalUser extends User {
    private String email;
    private String username;
    private String password;

    public LocalUser(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }  

    public String getUserName() {
        return this.username;
    }  

    public String getPassword() {
        return this.password;
    }
}
