package edu.westga.devops.theartistsdreamserver.model;

import java.util.List;

public class User {
    private int userId;
    private String email;
    private String username;
    private String password;
    private byte[] profilePic;
    private List<Integer> followerIds;
    private List<Integer> followingIds;

    public User(int userId, String email, String username, String password, byte[] profilePic) {
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
