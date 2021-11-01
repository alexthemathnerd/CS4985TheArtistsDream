package edu.westga.devops.theartistsdreamclient.model.network;

import com.google.gson.reflect.TypeToken;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.ChatRecord;
import edu.westga.devops.theartistsdreamclient.utils.UI;

import java.lang.reflect.Type;

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
     * @param communicator the communicator to use
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
     * @param receiverId the id of user that is receiving the message
     * @param message    the message being sent
     * @param senderId   the id of the user sending the message
     * @return the chat record
     * @precondition none
     * @postcondition none
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
