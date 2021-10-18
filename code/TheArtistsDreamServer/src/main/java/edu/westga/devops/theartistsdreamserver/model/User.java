package edu.westga.devops.theartistsdreamserver.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User Class
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class User {
    private final int userId;
    private final String email;
    private final String username;
    private final String password;
    private final byte[] profilePic;
    private final List<Integer> followerIds;
    private final List<Integer> followingIds;

    /**
     * Creates a new User
     *
     * @param userId the id of the user
     * @param email the email of the user
     * @param username the username of the user
     * @param password the password of the user
     * @param profilePic the profile picture of the user
     *
     * @precondition none
     * @postcondition getEmail().equals(email) && getUsername().equals(username) && getPassword().equals(password) && getUserId() == userId
     */
    public User(int userId, String email, String username, String password, byte[] profilePic) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.profilePic = profilePic;
        this.followerIds = new ArrayList<>();
        this.followingIds = new ArrayList<>();
    }

    /**
     * Gets the email
     *
     * @precondition none
     * @postcondition none
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }  

    /**
     * Gets the username
     *
     * @precondition none
     * @postcondition none
     *
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }  

    /**
     * Gets the password
     *
     * @precondition none
     * @postcondition none
     *
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Gets the user id
     *
     * @precondition none
     * @postcondition none
     *
     * @return the user id
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Gets the bytes of the profile pic
     *
     * @precondition none
     * @postcondition none
     *
     * @return the bytes of the profile pic
     */
    public byte[] getProfilePic() {
        return this.profilePic;
    }

    public boolean addFollowing(int userId) {
        return this.followingIds.add(userId);
    }

    public boolean addFollower(int userId) {
        return this.followerIds.add(userId);
    }

    public List<Integer> getFollowerIds() {
        return this.followerIds;
    }

    public List<Integer> getFollowingIds() {
        return this.followingIds;
    }

    public boolean removeFollowing(int userId) {
        return this.followingIds.remove((Object) userId);
    }

    public boolean removeFollower(int userId) {
        return this.followerIds.remove((Object) userId);
    }
}
