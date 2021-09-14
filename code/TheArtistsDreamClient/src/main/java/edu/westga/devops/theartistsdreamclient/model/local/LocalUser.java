package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.utils.UI;

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
        if (userId < 0) {
            throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_ID);
        }
        if (email == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.EMAIL_NULL);
        }
        if (username == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.USERNAME_NULL);
        }
        if (password == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.PASSWORD_NULL);
        }
        if (email.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.EMAIL_EMPTY);
        }
        if (username.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.EMAIL_EMPTY);
        }
        if (password.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.PASSWORD_EMPTY);
        }
        this.email = email;
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    public String getEmail() {
        return this.email;
    }  

    public String getUsername() {
        return this.username;
    }  

    public String getPassword() {
        return this.password;
    }

    public int getUserId() {
        return this.userId;
    }
}
