package edu.westga.devops.theartistsdreamclient.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import edu.westga.devops.theartistsdreamclient.model.User;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 
 */
public class DirectMessage {

    @FXML
    private Button sendButton;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button exitButton;

    @FXML
    private TextField messageTextField;

    private User user;

    private DirectMessageViewModel viewModel;

    public DirectMessage(User user) {
        this.user = user;
        this.viewModel = new DirectMessageViewModel();
    }

    @FXML
    void handleExitButtonClick(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            WindowLoader.changeScene(currentStage, "PortfolioPage.fxml", new PortfolioPage(this.user), "The Artist's Dream", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleSendButtonClick(ActionEvent event) {
        this.viewModel.sendMessage(this.messageTextField.getText(), User.getUser(), this.user);
    }


    @FXML
    private void initialize() {
    }

}
