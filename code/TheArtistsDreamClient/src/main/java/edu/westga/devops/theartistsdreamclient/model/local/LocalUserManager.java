package edu.westga.devops.theartistsdreamclient.model.local;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * Local Implementation of UserManager Collection Class
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class LocalUserManager extends UserManager {

    private final List<User> users;

    /**
     * Creates a new LocalUserManager
     *
     * @precondition none
     * @postcondition size() == 0
     */
    public LocalUserManager() {
        this.users = new ArrayList<User>();
    }

    @Override
    public User getUser(int userId) {
        if (userId < 0) {
            throw new IllegalArgumentException(UI.ErrorMessages.NEGATIVE_ID);
        }
        for (User currentUser : this.users) {
            if (userId == currentUser.getUserId()) {
                return currentUser;
            }
        }
        return null;
    }

    @Override
    public User findUser(String username, String password) {
        if (username == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.USERNAME_NULL);
        }
        if (password == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.PASSWORD_NULL);
        }
        if (username.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.USERNAME_EMPTY);
        }
        if (password.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.PASSWORD_EMPTY);
        }
        for (User currentUser : this.users) {
            if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword())) {
                return currentUser;
            }
        }
        return null;
    }

    @Override
    public User retrieveSearchedUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.USERNAME_NULL);
        }
        if (username.isEmpty()) {
            throw new IllegalArgumentException(UI.ErrorMessages.USERNAME_EMPTY);
        }
        for (User currentUser : this.users) {
            if (username.equals(currentUser.getUsername())) {
                return currentUser;
            }
        }
        return null;
    }

    @Override
    public int addUser(String username, String password, String email) {
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return -1;
            }
        }
        this.users.add(new User(this.size(), email, username, password, null));
        return this.size() - 1;
    }

    /**
     * Gets the size
     *
     * @return the size
     * @precondition none
     * @postcondition none
     */
    public int size() {
        return this.users.size();
    }

    @Override
    public List<User> searchForUsers(String searchTerm) {
        if (searchTerm == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.SEARCH_TERM_NULL);
        }
        ArrayList<User> searchedUsers = new ArrayList<User>();
        for (User user : this.users) {
            if (user.getUsername().contains(searchTerm)) {
                searchedUsers.add(user);
            }
        }
        return searchedUsers;
    }

    @Override
    public boolean followArtist(int artistsId, int followedId) {
        return false;
    }

    @Override
    public boolean unfollowArtist(int artistsId, int followedId) {
        return false;
    }

    @Override
    public boolean isFollowing(int artistsId, int followedId) {
        return false;
    }

    @Override
    public List<Integer> getFollowerIds(int userId) {
        return null;
    }

    @Override
    public List<Integer> getFollowingIds(int userId) {
        return null;
    }
}
