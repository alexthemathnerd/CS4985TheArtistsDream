package edu.westga.devops.theartistsdreamclient.model;

import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * The User Class
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class User {

    private static User user;

    private final int userId;

    private final String email;
    private final String username;
    private final String password;

    private final HashMap<Integer, ArrayList<ChatRecord>> chats;
    private final byte[] profilePic;

    /**
     * Creates a new user
     *
     * @param userId     the id of the user
     * @param email      the email of the user
     * @param username   the username of the user
     * @param password   the password of the user
     * @param profilePic the profile picture of the user
     * @throws IllegalArgumentException if a precondition is not met
     * @precondition userId >= 0 && email != null && !email.isEmpty() && username != null && !username.isEmpty() && password != null && !password.isEmpty() && profilePic != null
     * @postcondition getUserId() == userId && getEmail() == email && getUsername() == username && getPassword() == password && getFollowerIds().size() == 0 && getFollowingIds().size() == 0
     */
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
        this.profilePic = profilePic;
        this.chats = new HashMap<Integer, ArrayList<ChatRecord>>();
    }

    /**
     * Gets the singleton User
     *
     * @return the singleton user
     * @precondition none
     * @postcondition none
     */
    public static User getUser() {
        return user;
    }

    /**
     * Sets the singleton User
     *
     * @param user The user to be set
     * @precondition none
     * @postcondition getUser() == user
     */
    public static void setUser(User user) {
        User.user = user;
    }

    /**
     * Gets the email
     *
     * @return the email
     * @precondition none
     * @postcondition none
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets the username
     *
     * @return the username
     * @precondition none
     * @postcondition none
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Gets the password
     *
     * @return the password
     * @precondition none
     * @postcondition none
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Gets the user id
     *
     * @return the user id
     * @precondition none
     * @postcondition none
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Gets the list of follower ids
     *
     * @return the list of follower ids
     * @precondition none
     * @postcondition none
     */
    public byte[] getProfilePic() {
        return this.profilePic;
    }

    /**
     * Gets the ids of the followers
     *
     * @return the list of follower ids
     * @precondition none
     * @postcondition none
     */
    public List<Integer> getFollowerIds() {
        return new ArrayList<>();
    }

    /**
     * Gets the list of following user ids
     *
     * @return the list of the following ids
     * @precondition none
     * @postcondition none
     */
    public List<Integer> getFollowingIds() {
        return new ArrayList<>();
    }

    /**
     * Gets the chats
     *
     * @return the chats of the users
     * @precondition none
     * @postconditiion none
     */
    public HashMap<Integer, ArrayList<ChatRecord>> getChats() {
        return this.chats;
    }

    /**
     * Gets a chat by the id
     *
     * @param userId the id of the user
     * @return the chat of the user by the id
     * @precondition none
     * @postcondition none
     */
    public ArrayList<ChatRecord> getChatById(int userId) {
        if (this.chats.get(userId) == null) {
            this.chats.put(userId, new ArrayList<ChatRecord>());
        }
        return this.chats.get(userId);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof User) {
            return this.userId == ((User) user).userId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId);
    }
}
