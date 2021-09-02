package edu.westga.devops.theartistsdreamclient.view;


import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.view.controls.Header;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 * The Controller for the login
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
        TheArtistsDreamApplication.PRIMARY_STAGE.setTitle("The Artists Dream");
        TheArtistsDreamApplication.PRIMARY_STAGE.setScene(new Scene(new Header()));
        TheArtistsDreamApplication.PRIMARY_STAGE.getIcons().add(new Image(TheArtistsDreamApplication.class.getResourceAsStream(ICON_PATH)));
        TheArtistsDreamApplication.PRIMARY_STAGE.show();
    }
  }

}
