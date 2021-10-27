package edu.westga.devops.theartistsdreamclient.model;

import java.util.List;

/**
 * The UserManager class manages the users that have been loaded from the database
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public abstract class UserManager {

    private static UserManager userManager = null;

    /**
     * Gets the singleton of the user manager
     *
     * @return the singleton of the user manager
     * @precondition none
     * @postcondition none
     */
    public static UserManager getUserManager() {
        return UserManager.userManager;
    }

    /**
     * Sets the userManager singleton
     *
     * @param userManager the new user manager
     * @preconditon userManager != null
     * @postcondition getUserManager() == userManager
     */
    public static void setUserManager(UserManager userManager) {
        UserManager.userManager = userManager;
    }

    /**
     * Gets the user specified by the id
     *
     * @param userId the id of the user
     * @return the user specified by the id
     * @precondition none
     * @postcondition none
     */
    public abstract User getUser(int userId);

    /**
     * Finds the user specified by the username
     *
     * @param username the username of the searched user
     * @return the user specified by the username
     * @precondition username != null && !username.isEmpty()
     * @postcondition none
     */
    public abstract User retrieveSearchedUser(String username);

    /**
     * Finds the user specified by the username and password
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the user specified by the username and password
     * @precondition username != null && password != null && !username.isEmpty() && !password.isEmpty()
     * @postcondition none
     */
    public abstract User findUser(String username, String password);

    /**
     * Adds the user specified by the username, password, and email
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param email    the email of the user
     * @return the id of the added user or -1 if the username and password are used already
     * @precondition username != null && password != null && email != null && !username.isEmpty() && !password.isEmpty() && !email.isEmpty()
     * @postcondition none
     */
    public abstract int addUser(String username, String password, String email);

    /**
     * Gets users that match the term
     *
     * @param searchTerm the entered search value
     * @return the users that match the search
     * @precondition searchTerm != null
     * @postcondition none
     */
    public abstract List<User> searchForUsers(String searchTerm);

    /**
     * Adds a follower to the user with followedId and adds to following to the user with artistsId
     *
     * @param artistsId the artist id who is trying to follow
     * @param followedId the person id the user wants to follow
     * @return true if successful; otherwise false;
     * @precondition  artistsId >= 0 && followedId >= 0
     * @postcondition getFollowerId(followedId).contains(artistId) && getFollowingIds(artistsId).contains(followedId)
     */
    public abstract boolean followArtist(int artistsId, int followedId);

    /**
     * Removes a follower to the user with followedId and removes a following to the user with artistsId
     *
     * @param artistsId the artist id who is trying to unfollow
     * @param followedId the person id the user wants to unfollow
     * @return true if successful; otherwise false;
     * @precondition  artistsId >= 0 && followedId >= 0
     * @postcondition !getFollowerId(followedId).contains(artistId) && !getFollowingIds(artistsId).contains(followedId)
     */
    public abstract boolean unfollowArtist(int artistsId, int followedId);

    /**
     * Checks if the user with artistsId follows the user with followId
     *
     * @param artistsId the artist id who is following
     * @param followedId the person id who is followed
     * @return true if the user with artistId follows the user with followedId; otherwise false
     * @precondition  artistsId >= 0 && followedId >= 0
     * @postcondition none
     */
    public abstract boolean isFollowing(int artistsId, int followedId);

    /**
     * Gets a list of ids of the people who follow the user with the given id
     *
     * @param userId the user to get the followers of
     * @return the list of follower ids of the given user
     * @precondition userId >= 0
     */
    public abstract List<Integer> getFollowerIds(int userId);

    /**
     * Gets a list of ids of the people who the user with the given id is following
     *
     * @param userId the user to get the followers of
     * @return the list of following ids of the given user
     * @precondition userId >= 0
     */
    public abstract List<Integer> getFollowingIds(int userId);
}