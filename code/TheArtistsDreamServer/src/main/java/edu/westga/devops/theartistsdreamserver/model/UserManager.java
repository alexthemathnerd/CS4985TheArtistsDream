package edu.westga.devops.theartistsdreamserver.model;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;

import java.util.List;
import java.util.ArrayList;
import edu.westga.devops.theartistsdreamserver.utils.UI;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/**
 * UserManager Class
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class UserManager {

    /**
     * Adds the user
     *
     * @param data the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to add the user
     */
    public static Request addUser(Object[] data) {
        String username;
        String email;
        String password;
        try {
            username = (String) data[0];
            password = (String) data[1];
            email = (String) data[2];
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }

        for (User aUser: TheArtistsDreamServer.USERS) {
            if (email.equals(aUser.getEmail())) {
                return new Request(UI.ErrorMessages.USER_EXISTS, -1);
            }
        }
        InputStream profile = TheArtistsDreamServer.class.getResourceAsStream("assets/default.jpg");
        byte[] image = new byte[0];
        try {
            image = IOUtils.toByteArray(profile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User(TheArtistsDreamServer.USERS.size(), email, username, password, image);
        TheArtistsDreamServer.USERS.add(user);
        return new Request(TheArtistsDreamServer.USERS.size() - 1);
    }

    /**
     * Gets the user
     *
     * @param data the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to get the user
     */
    public static Request getUser(Object[] data) {
        int userId;
        try {
            userId = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }
        for (User user : TheArtistsDreamServer.USERS) {
            if (user.getUserId() == userId) {
                return new Request(user);
            }
        }
        return new Request(UI.ErrorMessages.USER_NOT_FOUND);
    }

    /**
     * Finds the user
     *
     * @param data the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to find the user
     */
    public static Request findUser(Object[] data) {
        String username;
        String password;
        try {
            username = (String) data[0];
            password = (String) data[1];
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }
        for (User user : TheArtistsDreamServer.USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return new Request(user);
            }
        }
        return new Request(null);
    }

    /**
     * Finds the users with usernames containing the searchTerm specified by the data
     *
     * @param data the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to find the users
     */
    public static Request searchForUser(Object[] data) {
        String username;
        try {
            username = (String) data[0];
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }
        List<User> users = new ArrayList<User>();
        for (User user : TheArtistsDreamServer.USERS) {
            if (user.getUsername().contains(username)) {
                users.add(user);
            }
        }
        return new Request(users);
    }

    /**
     * Finds the user with username matching the username specified by the data
     *
     * @param data the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to find the user
     */
    public static Request retrieveSearchedUser(Object[] data) {
        String username;
        try {
            username = (String) data[0];
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }
        for (User user : TheArtistsDreamServer.USERS) {
            if (user.getUsername().equals(username)) {
                return new Request(user);
            }
        }
        return new Request(null);
    }

    public static Request followArtist(Object[] data) {
	    int artistId;
	    int followedId;
	    User user;
	    User followedUser;
	    try {
		    artistId = ((Double) data[0]).intValue();
		    followedId = ((Double) data[1]).intValue();
		    user = TheArtistsDreamServer.USERS.get(artistId);
		    followedUser = TheArtistsDreamServer.USERS.get(followedId);
	    } catch (ClassCastException e) {
		    return new Request(UI.ErrorMessages.INVALID_FORMAT);
	    } catch (IndexOutOfBoundsException e) {
		    return new Request(UI.ErrorMessages.USER_NOT_FOUND);
	    }
	    if (user.getFollowingIds().contains(followedId)) {
		    return new Request(false);
	    }
	    return new Request(user.addFollowing(followedId) && followedUser.addFollower(artistId));
    }

    public static Request unfollowArtist(Object[] data) {
        int artistId;
        int followedId;
        User user;
        User followedUser;
        try {
            artistId = ((Double) data[0]).intValue();
            followedId = ((Double) data[1]).intValue();
            user = TheArtistsDreamServer.USERS.get(artistId);
            followedUser = TheArtistsDreamServer.USERS.get(followedId);
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        } catch (IndexOutOfBoundsException e) {
            return new Request(UI.ErrorMessages.USER_NOT_FOUND);
        }
        return new Request(user.removeFollowing(followedId) && followedUser.removeFollower(artistId));
    }

    public static Request isFollowing(Object[] data) {
        int artistId;
        int followedId;
        User user;
        try {
            artistId = ((Double) data[0]).intValue();
            followedId = ((Double) data[1]).intValue();
            user = TheArtistsDreamServer.USERS.get(artistId);
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        } catch (IndexOutOfBoundsException e) {
            return new Request(UI.ErrorMessages.USER_NOT_FOUND);
        }
        return new Request(user.getFollowingIds().contains(followedId));
    }

    public static Request getFollowerIds(Object[] data) {
        int artistId;
        User user;
        try {
            artistId = ((Double) data[0]).intValue();
            user = TheArtistsDreamServer.USERS.get(artistId);
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        } catch (IndexOutOfBoundsException e) {
            return new Request(UI.ErrorMessages.USER_NOT_FOUND);
        }
        return new Request(user.getFollowerIds());
    }

    public static Request getFollowingIds(Object[] data) {
        int artistId;
        User user;
        try {
            artistId = ((Double) data[0]).intValue();
            user = TheArtistsDreamServer.USERS.get(artistId);
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        } catch (IndexOutOfBoundsException e) {
            return new Request(UI.ErrorMessages.USER_NOT_FOUND);
        }
        return new Request(user.getFollowingIds());
    }

}
