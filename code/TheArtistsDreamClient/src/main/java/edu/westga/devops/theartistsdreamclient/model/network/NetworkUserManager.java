package edu.westga.devops.theartistsdreamclient.model.network;

import java.util.Iterator;
import java.util.*;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.utils.UI;

/**
 * Tne NetworkUserManager class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class NetworkUserManager extends UserManager {

    private Communicator communicator;

    /**
     * Initailizes a network User manager
     * 
     * @precondition none
     * @postcondition none
     */
    public NetworkUserManager() {
        this.communicator = new Communicator("tcp://localHost:4444");
    }

    @Override
    public Iterator<User> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean verifyCredentials(String username, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User getUser(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    public User getUser(String username, String password) {
        Type type = new TypeToken<Response<User>>() {
        }.getType();
        Response<User> response = this.communicator.request(new Request(UI.ServerCodes.GET_USER, new Object[]{username, password}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return null;
        }
        return response.getData();
    }

    @Override
    public double addUser(String username, String email, String password) {
        Type type = new TypeToken<Integer>() {
        }.getType();
        Response<Double> response = this.communicator.request(new Request(UI.ServerCodes.ADD_USER, new Object[]{username, email, password}));
        if (response.getError() != null) {
            return -1;
        }
        return response.getData();
    }

    public ArrayList<User> searchForUsers(String username) {
        Type type = new TypeToken<Integer> () {
        }.getType();
        Response<ArrayList<User>> response = this.communicator.request(new Request(UI.ServerCodes.SEARCH_USERS, new Object[]{username}), type);
        if (response.getError() != null) {
            return null;
        }
        return response.getData();
    }

    @Override
    public boolean checkForUser(int userId) {
        // TODO Auto-generated method stub
        return false;
    }

    
}
