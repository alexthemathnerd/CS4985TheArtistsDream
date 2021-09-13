package edu.westga.devops.theartistsdreamclient.model.network;

import java.util.Iterator;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;

public class NetworkUserManager extends UserManager {

    private Communicator communicator;

    public NetworkUserManager() {
        this.communicator = new Communicator("tcp//localHost:4444");
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

    @Override
    public boolean addUser(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean checkForUser(int userId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
