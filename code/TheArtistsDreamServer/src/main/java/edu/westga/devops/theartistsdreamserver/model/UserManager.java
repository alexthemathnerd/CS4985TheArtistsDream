package edu.westga.devops.theartistsdreamserver.model;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import java.util.*;


public class UserManager {

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
        
        User user = new User(TheArtistsDreamServer.USERS.size(), email, username, password);
        int count = 0;
        for (User currUser : TheArtistsDreamServer.USERS) {
            if (user.getEmail().equals(currUser.getEmail())) {
                return new Request(count);
            }
            count++;
        }
        TheArtistsDreamServer.USERS.add(user);
        return new Request(TheArtistsDreamServer.USERS.size() - 1);
    }

    public static Request getUser(Object[] data) {
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

    public static Request searchForUser(Object[] data) {
        String username;
        try {
            username = (String) data[0];
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }
        ArrayList<User> users = new ArrayList<User>();
        for (User user : TheArtistsDreamServer.USERS) {
            if (user.getUsername().contains(username)) {
                users.add(user);
            }
        }
        return new Request(users);
    }
     
}
