package edu.westga.devops.theartistsdreamclient.model.network;

import java.util.List;
import java.util.ArrayList;

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
    public User getUser(int userId) {
        Type type = new TypeToken<Response<User>>() {
        }.getType();
        Response<User> response = this.communicator.request(new Request(UI.ServerCodes.GET_USER, new Object[]{userId}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return null;
        }
        return response.getData();
    }

    @Override
    public User findUser(String username, String password) {
        Type type = new TypeToken<Response<User>>() {
        }.getType();
        Response<User> response = this.communicator.request(new Request(UI.ServerCodes.FIND_USER, new Object[]{username, password}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return null;
        }
        return response.getData();
    }

    @Override
    public User retrieveSearchedUser(String username) {
        Type type = new TypeToken<Response<User>>() {
        }.getType();
        Response<User> response = this.communicator.request(new Request(UI.ServerCodes.RETRIEVE_USER, new Object[]{username}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return null;
        }
        return response.getData();
    }

    @Override
    public int addUser(String username, String email, String password) {
        Type type = new TypeToken<Response<Integer>>() {
        }.getType();
        Response<Integer> response = this.communicator.request(new Request(UI.ServerCodes.ADD_USER, new Object[]{username, email, password}), type);
        if (response.getError() != null) {
            return -1;
        }
        return response.getData();
    }

    @Override
    public List<User> searchForUsers(String searchTerm) {
        Type type = new TypeToken<Response<ArrayList<User>>>() {
        }.getType();
        Response<ArrayList<User>> response = this.communicator.request(new Request(UI.ServerCodes.SEARCH_USERS, new Object[]{searchTerm}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }

    @Override
    public boolean followArtist(int artistsId, int followedId) {
        Type type = new TypeToken<Response<Boolean>>() {
        }.getType();
        Response<Boolean> response = this.communicator.request(new Request(UI.ServerCodes.FOLLOW_ARTIST, new Object[]{artistsId, followedId}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return false;
        }
        return response.getData();
    }

    @Override
    public List<Integer> getFollowerIds(int userId) {
        Type type = new TypeToken<Response<ArrayList<Integer>>>() {
        }.getType();
        Response<ArrayList<Integer>> response = this.communicator.request(new Request(UI.ServerCodes.GET_FOLLOWERS, new Object[]{userId}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }

    @Override
    public List<Integer> getFollowingIds(int userId) {
        Type type = new TypeToken<Response<ArrayList<Integer>>>() {
        }.getType();
        Response<ArrayList<Integer>> response = this.communicator.request(new Request(UI.ServerCodes.GET_FOLLOWINGS, new Object[]{userId}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return new ArrayList<>();
        }
        return response.getData();
    }
}   
