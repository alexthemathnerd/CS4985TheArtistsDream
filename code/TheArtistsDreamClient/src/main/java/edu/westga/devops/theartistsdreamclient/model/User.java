package edu.westga.devops.theartistsdreamclient.model;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The User Class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class User {

    private static User user;

    private int userId;


    private String email;
    private String username;
    private String password;

    private byte[] profilePic;
    private List<Integer> followerIds;
    private List<Integer> followingIds;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        User.user = user;
    }

    public User(int userId, String email, String username, String password, byte[] profilePic) {
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
        this.followerIds = new ArrayList<>();
        this.followingIds = new ArrayList<>();
        this.profilePic = profilePic;
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

    public byte[] getProfilePic() {
        return this.profilePic;
    }

    public List<Integer> getFollowerIds() {
        return new ArrayList<>();
    }

    public List<Integer> getFollowingIds() {
        return new ArrayList<>();
    }
}
