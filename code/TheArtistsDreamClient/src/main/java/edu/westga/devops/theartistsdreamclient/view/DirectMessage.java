package edu.westga.devops.theartistsdreamclient.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.viewmodel.DirectMessageViewModel;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import java.time.format.DateTimeFormatter;
import javafx.scene.text.Text;

/**
 * Direct Message class
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class DirectMessage {

    private final User receiver;

    private final User sender;

    private final DirectMessageViewModel viewModel;

    @FXML
    private GridPane chatGridPane;
    
    @FXML
    private TextField messageTextField;

    @FXML
    private Button sendButton;

    public DirectMessage(User receiver, User sender) {
        this.sender = sender;
        this.receiver = receiver;
        this.viewModel = new DirectMessageViewModel(sender, receiver);
    }

    private void setupBindings() {
        this.messageTextField.textProperty().bindBidirectional(this.viewModel.messageStringProperty());
    }

    @FXML
    public void initialize() {
        this.setupBindings();
        this.chatRecordOnChanged();
    }

    @FXML
    void handleSendClick(ActionEvent event) {
        this.viewModel.send();
    }
    
    private void chatRecordOnChanged() {
        this.viewModel.chatRecordProperty().addListener((observableValue, oldRecord, newRecord) -> {
        
        final Text username = new Text();    
        final Text recordMessage = new Text(newRecord.getMessage()); 
        final var messageFlow = new TextFlow(recordMessage);
    
        if (newRecord.getUserId() == this.sender.getUserId()) {
            username.setText(this.sender.getUsername());
            recordMessage.getStyleClass().add("sentMessageContent");
            messageFlow.getStyleClass().addAll("sentMessage", "message");
        } else {
            username.setText(this.receiver.getUsername());
            recordMessage.getStyleClass().add("receivedMessageContent");
            messageFlow.getStyleClass().addAll("receivedMessage", "message");
        }
        messageFlow.setLineSpacing(2);
    
        //final var recordDate =  new Text(newRecord.getDate().format(DateTimeFormatter.ofPattern("hh : mm a "))); 
    
        final var columnIndex = (newRecord.getUserId() == this.sender.getUserId()) ? 1 : 0;
        final var columnSpan = 2;
    
        final var rowIndex = this.chatGridPane.getRowCount();
        final var rowSpan = 1;
    
        final VBox vBox = getVBox(username, messageFlow);
        chatGridPane.add(vBox, columnIndex, rowIndex, columnSpan, rowSpan);
        });
    } 

    private static VBox getVBox(Node... nodes) {
        final var vBox = new VBox(nodes);
        vBox.setPadding(new Insets(10));
        return vBox;
    }

}
