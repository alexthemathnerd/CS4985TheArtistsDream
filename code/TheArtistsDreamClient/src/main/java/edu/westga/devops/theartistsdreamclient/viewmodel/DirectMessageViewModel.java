package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.ChatRecord;
import edu.westga.devops.theartistsdreamclient.model.network.Chat;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.ZonedDateTime;
import javafx.application.Platform;

/**
 * DirectMessageViewModel class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class DirectMessageViewModel {

    private Chat chat;
    private User sender;
    private User receiver;
    private ObjectProperty<ChatRecord> chatRecordProperty;
    private StringProperty messageStringProperty;

    /**
     * Initializes a new DirectMessage View Model
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param sender the user sending the message
     * @param receiver the user receiving the message
     */
    public DirectMessageViewModel(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.chat = new Chat();
        this.messageStringProperty = new SimpleStringProperty("");
        this.chatRecordProperty = new SimpleObjectProperty<ChatRecord>();
    }

    /**
     * Gets the chatRecordProperty
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the chatRecordProperty
     */
    public ObjectProperty<ChatRecord> chatRecordProperty() {
        return this.chatRecordProperty;
    }

    /**
     * Gets the messageStringProperty
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the messageStringProperty
     */
    public StringProperty messageStringProperty() {
        return this.messageStringProperty;
    }
    
    /**
     * Sends the message
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    public void send() {
        Platform.runLater(()-> {
            this.chatRecordProperty.set(
                this.chat.sendMessage(this.receiver.getUserId(), this.messageStringProperty.get(), this.sender.getUserId())
                    );
                }
            );
    }
}
