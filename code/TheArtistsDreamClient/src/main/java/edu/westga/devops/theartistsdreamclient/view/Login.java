package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.viewmodel.LoginViewModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import edu.westga.devops.theartistsdreamclient.model.User;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

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
    private PasswordField passwordTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField confirmPasswordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private Label errorMessageLabel;

    private LoginViewModel viewModel;

    private BooleanProperty isCreateingAccount;

    public Login() {
        this.viewModel = new LoginViewModel();
        this.isCreateingAccount = new SimpleBooleanProperty(false);
    }

    private void setupBindings() {
        this.emailTextField.textProperty().bindBidirectional(this.viewModel.emailStringProperty());
        this.passwordTextField.textProperty().bindBidirectional(this.viewModel.passwordStringProperty());
        this.usernameTextField.textProperty().bindBidirectional(this.viewModel.usernameStringProperty());
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
        this.isCreateingAccount.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                this.confirmPasswordTextField.setVisible(true);
                this.confirmPasswordTextField.setDisable(false);
                this.confirmPasswordTextField.setManaged(true);
                this.emailTextField.setDisable(false);
                this.emailTextField.setVisible(true);
                this.emailTextField.setManaged(true);
                this.loginButton.setText("CANCEL");
            } else {
                this.confirmPasswordTextField.setVisible(false);
                this.confirmPasswordTextField.setDisable(true);
                this.confirmPasswordTextField.setManaged(false);
                this.emailTextField.setDisable(true);
                this.emailTextField.setVisible(false);
                this.emailTextField.setManaged(false);
                this.loginButton.setText("LOGIN");
                this.errorMessageLabel.setText("");
            }
        });
    }

    @FXML
    void handleCreateAccountButtonClick(ActionEvent event) {
        if (this.isCreateingAccount.get()) {
            if (this.validateCreateAccount()) {
                this.isCreateingAccount.set(false);
            }
        } else {
            this.isCreateingAccount.set(true);
        }
    }

    private boolean validateCreateAccount() {
        if (!this.emailTextField.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
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
        if (this.isCreateingAccount.get()) {
            this.isCreateingAccount.set(false);
        } else {
            User user = this.viewModel.getUser();
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
                WindowLoader.changeScene(currentStage, RECOMMENDED_PAGE_FXML, new RecommendedPage(), "The Artist's Dream");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}