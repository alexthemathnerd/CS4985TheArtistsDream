package edu.westga.devops.theartistsdreamserver.model;

import java.util.List;

/**
 * User Class
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class User {
    private int userId;
    private String email;
    private String username;
    private String password;
    private byte[] profilePic;
    private List<Integer> followerIds;
    private List<Integer> followingIds;

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
}
