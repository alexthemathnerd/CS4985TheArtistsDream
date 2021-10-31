package edu.westga.devops.theartistsdreamserver.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * User Class
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class User {

    private HashMap<Integer, ArrayList<ChatRecord>> messages;
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
        this.messages = new HashMap<Integer, ArrayList<ChatRecord>>();
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

    /**
     * Gets the user's messages
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the messages 
     */
    public HashMap<Integer, ArrayList<ChatRecord>> getMessages() {
        return this.messages;
    }

    /**
     * Get the chat from the specified user
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param userId the User Id of the chat you are trying to get
     * 
     * @return the chat of the specified user
     */
    public ArrayList<ChatRecord> getChatByUserId(int userId) {
        if (this.messages.get(userId) == null) {
            this.messages.put(userId, new ArrayList<ChatRecord>());
        } 
        return this.messages.get(userId);
    }

    /**
     * Updates the chat with the specified userId
     * 
     * @precondtion none
     * @postcondition none
     * 
     * @param userId the user Id of the user associated with the chat
     * @param chat the chat replacing the existing chat
     * 
     * @return the updated chat
     */
    public ArrayList<ChatRecord> updateChat(int userId, ArrayList<ChatRecord> chat) {
        return this.messages.replace(userId, chat);
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
