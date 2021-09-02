package edu.westga.devops.theartistsdreamclient.view;


import java.net.URL;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * The Controller for the login
 *
 * @author Jamia Echols
 * @version Fall 2021
 */
public class Login {
	public static final String ICON_PATH = "icon.png";
	public static final String HEADER_FXML = "view/controls/Header.fxml";
	public static final String CREATE_ACCOUNT_FXML = "view/CreateAccount.fxml";

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
    
    public Login() {
    	
    }

    @FXML
    public void initialize() {
        this.confirmPasswordTextField.setVisible(false);
        this.emailTextField.setVisible(false);
    }
    
    @FXML
    void handleCreateAccountButtonClick(ActionEvent event) {
        if (this.confirmPasswordTextField.isVisible() && this.emailTextField.isVisible()) {

        } else {
            this.confirmPasswordTextField.setVisible(true);
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
    Parent resource = FXMLLoader.load(TheArtistsDreamApplication.class.getResource(HEADER_FXML));
    TheArtistsDreamApplication.PRIMARY_STAGE.setTitle("Test");
    TheArtistsDreamApplication.PRIMARY_STAGE.setScene(new Scene(resource));
    TheArtistsDreamApplication.PRIMARY_STAGE.getIcons().add(new Image(TheArtistsDreamApplication.class.getResourceAsStream(ICON_PATH)));
    TheArtistsDreamApplication.PRIMARY_STAGE.show();
      }
  }

}
