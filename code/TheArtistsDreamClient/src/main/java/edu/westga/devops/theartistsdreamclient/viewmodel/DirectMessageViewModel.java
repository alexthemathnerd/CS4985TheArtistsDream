package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.ChatRecord;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.network.Chat;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * DirectMessageViewModel class
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class DirectMessageViewModel {

    private final Chat chat;
    private final User sender;
    private final User receiver;
    private final ObjectProperty<ChatRecord> chatRecordProperty;
    private final StringProperty messageStringProperty;

    /**
     * Initializes a new DirectMessage View Model
     *
     * @param sender   the user sending the message
     * @param receiver the user receiving the message
     * @precondition none
     * @postcondition none
     */
    public DirectMessageViewModel(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.chat = new Chat();
        this.messageStringProperty = new SimpleStringProperty("");
        this.chatRecordProperty = new SimpleObjectProperty<ChatRecord>();
    }

    /**
     * Initializes a new DirectMessage View Model (Only use for testing)
     *
     * @param sender   the user sending the message
     * @param receiver the user receiving the message
     * @precondition none
     * @postcondition none
     */
    public DirectMessageViewModel(Chat chat, User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.chat = chat;
        this.messageStringProperty = new SimpleStringProperty("");
        this.chatRecordProperty = new SimpleObjectProperty<ChatRecord>();
    }

    /**
     * Gets the chatRecordProperty
     *
     * @return the chatRecordProperty
     * @precondition none
     * @postcondition none
     */
    public ObjectProperty<ChatRecord> chatRecordProperty() {
        return this.chatRecordProperty;
    }

    /**
     * Gets the messageStringProperty
     *
     * @return the messageStringProperty
     * @precondition none
     * @postcondition none
     */
    public StringProperty messageStringProperty() {
        return this.messageStringProperty;
    }

    /**
     * Sends the message
     *
     * @precondition none
     * @postcondition none
     */
    public void send() {
        Platform.runLater(() -> this.chatRecordProperty.set(this.chat.sendMessage(this.receiver.getUserId(), this.messageStringProperty.get(), this.sender.getUserId())));
    }
}
