package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import edu.westga.devops.theartistsdreamclient.viewmodel.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import edu.westga.devops.theartistsdreamclient.model.*;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUser;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import edu.westga.devops.theartistsdreamclient.view.controls.ArtworksPane;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import edu.westga.devops.theartistsdreamclient.view.WindowLoader;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * The Controller for the login
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class Login {
    public static final String ICON_PATH = "icon.png";
    public static final String RECOMMENDED_PAGE_FXML = "RecommendedPage.fxml";

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField confirmPasswordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane thePane;

    @FXML
    private Label errorMessageLabel;

    private LoginViewModel viewModel;

    /**
     * Initiailizes ViewModel for Login
     */
    public Login() {
        this.viewModel = new LoginViewModel();
    }

    private void setupBindings() {
        this.emailTextField.textProperty().bindBidirectional(this.viewModel.emailStringProperty());
        this.passwordTextField.textProperty().bindBidirectional(this.viewModel.passwordStringProperty());
        this.usernameTextField.textProperty().bindBidirectional(this.viewModel.usernameStringProperty());
        this.confirmPasswordTextField.textProperty().bindBidirectional(this.viewModel.confirmPasswordStringProperty());
        this.errorMessageLabel.textProperty().bindBidirectional(this.viewModel.errorLabelStringProperty());
    }

    @FXML
    public void initialize() {
        this.confirmPasswordTextField.setVisible(false);
        this.confirmPasswordTextField.setDisable(true);
        this.confirmPasswordTextField.setManaged(false);
        this.emailTextField.setDisable(true);
        this.emailTextField.setVisible(false);
        this.setupBindings();
        this.emailTextField.setManaged(false);
    }

    @FXML
    void handleCreateAccountButtonClick(ActionEvent event) {
        if (this.confirmPasswordTextField.isVisible() && this.emailTextField.isVisible()) {
           if (this.viewModel.validateCreateAccount()) {
               //TODO
           }
        } else {
            this.confirmPasswordTextField.setVisible(true);
            this.confirmPasswordTextField.setDisable(false);
            this.emailTextField.setVisible(true);
            this.loginButton.setText("CANCEL");
        }
    }

    @FXML
    void handleLoginButtonClick(ActionEvent event) throws Exception {
        if (this.loginButton.getText() == "CANCEL") {
            this.confirmPasswordTextField.setVisible(false);
            this.emailTextField.setVisible(false);
            this.loginButton.setText("LOGIN");
        } else {
            LocalUser user = this.viewModel.getUser();
            if (user == null) {
                Alert alert = new Alert(AlertType.ERROR, "User not found");
                alert.show();
            } else {
                Alert alert = new Alert(AlertType.CONFIRMATION, "User found:" + user.getUserName());
                alert.show();
            }
            FXMLLoader loader = new FXMLLoader(TheArtistsDreamApplication.class.getResource(RECOMMENDED_PAGE_FXML));
            try {
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.setMaximized(true);
                WindowLoader.changeScene(currentStage, RECOMMENDED_PAGE_FXML, null, "The Artist's Dream");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
