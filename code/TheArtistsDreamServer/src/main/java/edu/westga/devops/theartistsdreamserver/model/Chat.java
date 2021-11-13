package edu.westga.devops.theartistsdreamserver.model;

import java.util.ArrayList;
import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.utils.UI;

/**
 * Chat Class
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class Chat {

     /**
     * Sends the message
     *
     * @param data the data
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to send the message
     */
    public static Request sendMessage(Object[] data) {
        int senderUserId;
        String message;
        int receiverUserId;
        try {
            senderUserId = ((Double) data[0]).intValue();
            message = (String) data[1];
            receiverUserId = ((Double) data[2]).intValue();
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }
        ChatRecord chatRecord = new ChatRecord(senderUserId, message);
        for (User user : TheArtistsDreamServer.USERS) {
            if (user.getUserId() == receiverUserId) {
                ArrayList<ChatRecord> chat = user.getChatByUserId(receiverUserId);
                chat.add(chatRecord);
                user.updateChat(senderUserId, chat);
            } else if (user.getUserId() == senderUserId) {
                ArrayList<ChatRecord> chat = user.getChatByUserId(senderUserId);
                chat.add(chatRecord);
                user.updateChat(senderUserId, chat);
            }
        }
        return new Request(chatRecord);
    }
}
