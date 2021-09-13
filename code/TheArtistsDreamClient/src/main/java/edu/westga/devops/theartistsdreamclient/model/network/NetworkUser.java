package edu.westga.devops.theartistsdreamclient.model.network;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.utils.UI;

public class NetworkUser extends User {

    private Communicator communicator;

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
