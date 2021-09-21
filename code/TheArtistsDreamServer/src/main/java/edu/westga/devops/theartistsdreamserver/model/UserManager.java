package edu.westga.devops.theartistsdreamserver.model;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import java.util.*;


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
            email = (String) data[1];
            password = (String) data[2];
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }

        for (User aUser: TheArtistsDreamServer.USERS) {
            if (email.equals(aUser.getEmail())) {
                return new Request("User alredy Exist", -1);
            }
        }
        User user = new User(TheArtistsDreamServer.USERS.size(), email, username, password, null);
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
            return new Request("Invalid Format");
        }
        for (User user : TheArtistsDreamServer.USERS) {
            if (user.getUserId() == userId) {
                return new Request(user);
            }
        }
        return new Request("Can't find user");
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
            return new Request("Invalid Format");
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
            return new Request("Invalid Format");
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
            return new Request("Invalid Format");
        }
        for (User user : TheArtistsDreamServer.USERS) {
            if (user.getUsername().equals(username)) {
                return new Request(user);
            }
        }
        return new Request(null);
    }    
}
