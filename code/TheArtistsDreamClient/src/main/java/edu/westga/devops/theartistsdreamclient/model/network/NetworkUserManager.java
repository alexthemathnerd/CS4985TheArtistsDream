package edu.westga.devops.theartistsdreamclient.model.network;

import java.util.Iterator;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.network.Communicator;

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

    
}
