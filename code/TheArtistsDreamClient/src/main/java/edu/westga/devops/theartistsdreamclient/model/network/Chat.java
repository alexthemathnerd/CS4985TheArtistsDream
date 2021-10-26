package edu.westga.devops.theartistsdreamclient.model.network;

import edu.westga.devops.theartistsdreamclient.utils.UI;
import edu.westga.devops.theartistsdreamclient.model.ChatRecord;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import java.util.List;
import java.util.ArrayList;

/**
 * The class chat
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class Chat {
    private final Communicator communicator;

    /**
     * Creates a new chat
     *
     * @precondition none
     * @postcondition none
     */
    public Chat() {
        this.communicator = new Communicator("tcp://localhost:4444");
    }

    /**
     * Creates a new chat (Use only for tests)
     *
     * @precondition none
     * @postcondition none
     */
    public Chat(Communicator communicator) {
        this.communicator = communicator;
    }

    /**
     * Sends the message
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param receiverId the id of user that is receiving the message
     * @param message the message being sent
     * @param senderId the id of the user sending the message
     * 
     * @return the chat record
     */
    public ChatRecord sendMessage(int receiverId, String message, int senderId) {
        Type type = new TypeToken<Response<ChatRecord>>() {
        }.getType();
        Response<ChatRecord> response = this.communicator.request(new Request(UI.ServerCodes.SEND_MESSAGE, new Object[]{senderId, message, receiverId}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return null;
        }
        return response.getData();
    }
}
