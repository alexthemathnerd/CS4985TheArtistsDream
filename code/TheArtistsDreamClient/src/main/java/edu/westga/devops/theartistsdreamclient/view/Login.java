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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 * The Controller for the login and Create Account
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class Login {
	public static final String ICON_PATH = "icon.png";
	public static final String HEADER_FXML = "view/controls/Header.fxml";

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

    public Login() {
    	this.viewModel = new LoginViewModel();
    }

    private void setupBindings() {
        this.emailTextField.textProperty().bindBidirectional(this.viewModel.emailStringProperty());
        this.passwordTextField.textProperty().bindBidirectional(this.viewModel.passwordStringProperty());
        this.usernameTextField.textProperty().bindBidirectional(this.viewModel.usernameStringProperty());
    }

    @FXML
    public void initialize() {
        this.confirmPasswordTextField.setVisible(false);
        this.emailTextField.setVisible(false);
        this.setupBindings();
    }
    
    @FXML
    void handleCreateAccountButtonClick(ActionEvent event) {
        if (this.confirmPasswordTextField.isVisible() && this.emailTextField.isVisible()) {
            if (this.validateCreateAccount()) {
                this.viewModel.addUser();
            }
        }
            this.confirmPasswordTextField.setVisible(true);
            this.emailTextField.setVisible(true);
            this.loginButton.setText("CANCEL");
    }
    
    private boolean validateCreateAccount() {
        if (!this.emailTextField.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))  {
            this.errorMessageLabel.setText("Must enter a valid email.");
            return false;
        }
        if (this.passwordTextField.getText().length() < 7) {
            this.emailTextField.setText("Password length must be greater than 7");
            return false;
        }
        if (!this.passwordTextField.getText().equals(this.confirmPasswordTextField.getText())) {
            this.errorMessageLabel.setText("Passwords must match");
            return false;
        }
        return true;
    }

  @FXML
  void handleLoginButtonClick(ActionEvent event) throws Exception {
    if (this.loginButton.getText() == "CANCEL") {
        this.confirmPasswordTextField.setVisible(false);
        this.emailTextField.setVisible(false);
        this.loginButton.setText("LOGIN");
    } else {
        User user = this.viewModel.getUser();
        if (user == null) {
            Alert alert = new Alert( AlertType.ERROR, "User not found");
            alert.show();
        } else {
            Alert alert = new Alert( AlertType.CONFIRMATION, "User found:" + user.getUserName());
            alert.show();
        }
        TheArtistsDreamApplication.PRIMARY_STAGE.setTitle("The Artists Dream");
        TheArtistsDreamApplication.PRIMARY_STAGE.setScene(new Scene(new Header()));
        TheArtistsDreamApplication.PRIMARY_STAGE.getIcons().add(new Image(TheArtistsDreamApplication.class.getResourceAsStream(ICON_PATH)));
        TheArtistsDreamApplication.PRIMARY_STAGE.show();
    }
  }

}
