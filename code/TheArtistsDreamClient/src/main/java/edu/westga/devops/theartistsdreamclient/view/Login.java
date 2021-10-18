package edu.westga.devops.theartistsdreamclient.view;

import java.io.IOException;

import edu.westga.devops.theartistsdreamclient.utils.UI;
import edu.westga.devops.theartistsdreamclient.viewmodel.LoginViewModel;
import edu.westga.devops.theartistsdreamclient.model.User;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    private final LoginViewModel viewModel;

    private final BooleanProperty isCreatingAccount;

    /**
     * Initiailizes ViewModel for Login
     */
    public Login() {
        this.viewModel = new LoginViewModel();
        this.isCreatingAccount = new SimpleBooleanProperty(false);
    }

    private void setupBindings() {
        this.emailTextField.textProperty().bindBidirectional(this.viewModel.emailProperty());
        this.passwordTextField.textProperty().bindBidirectional(this.viewModel.passwordProperty());
        this.usernameTextField.textProperty().bindBidirectional(this.viewModel.usernameProperty());
        this.confirmPasswordTextField.textProperty().bindBidirectional(this.viewModel.confirmPasswordProperty());
        this.errorMessageLabel.textProperty().bindBidirectional(this.viewModel.errorProperty());
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
        this.isCreatingAccount.addListener((observable, oldValue, newValue) -> {
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
        if (this.isCreatingAccount.get()) {
            if (this.viewModel.validateCreateAccount()) {
                this.isCreatingAccount.set(false);
                this.viewModel.addUser();
            }
        } else {
            this.isCreatingAccount.set(true);
        }
    }

    @FXML
    void handleLoginButtonClick(ActionEvent event) throws Exception {
        if (this.isCreatingAccount.get()) {
            this.isCreatingAccount.set(false);
        } else {
            User user = this.viewModel.getUser();
            if (user == null) {
                Alert alert = new Alert(AlertType.ERROR, UI.ErrorMessages.USER_NOT_FOUND);
                alert.show();
            } else {
                User.setUser(user);
                try {
                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    WindowLoader.changeScene(currentStage, RECOMMENDED_PAGE_FXML, new RecommendedPage(), "The Artist's Dream", true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }   
        }
    }
}
