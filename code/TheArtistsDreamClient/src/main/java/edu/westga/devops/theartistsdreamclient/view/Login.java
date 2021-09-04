package edu.westga.devops.theartistsdreamclient.view;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Controller for the login
 *
 * @author Jamia Echols
 * @version Fall 2021
 */

public class Login {

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button createAccountButton;

    @FXML
    private Button loginButton;

    @FXML
    private ImageView IconImage;

    @FXML
    void handleCreateAccountButtonClick(ActionEvent event) {

    }

    @FXML
    void handleLoginButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TheArtistsDreamApplication.class.getResource("view/TODO.fxml"));
        loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.getRoot());
        stage.setTitle("The Artist's Dream");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

}
