package edu.westga.devops.theartistsdreamclient.model.network;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.utils.UI;
/**
 * The network user
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class NetworkUser extends User {

    private Communicator communicator;

    /**
     * Initializes a network user
     * 
     * @precondition Communicator != null && communcator is not empty
     * @postcondition none
     *
     * @throws IllegalArgumentException if precondition is not met.
     */
    public NetworkUser(Communicator communicator) {
        if (communicator == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.COMMUNICATOR_NULL);
        }
        if (communicator.isClosed()) {
            throw new IllegalArgumentException(UI.ErrorMessages.COMMUNICATOR_IS_CLOSED);
        }
        this.communicator = communicator;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getUserId() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
