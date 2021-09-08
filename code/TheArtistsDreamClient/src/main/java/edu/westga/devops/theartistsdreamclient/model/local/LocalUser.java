package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.User;

/**
 * The User Class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class LocalUser extends User {
    private int userId;
    private String email;
    private String username;
    private String password;

    public LocalUser(int userId, String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userId = userId;
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

    public int getUserId() {
        return this.userId;
    }
}
