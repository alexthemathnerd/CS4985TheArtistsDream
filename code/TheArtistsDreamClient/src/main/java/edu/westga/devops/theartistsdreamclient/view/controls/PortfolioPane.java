package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.view.popups.AddArtPopup;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Controller for the PortfolioPane Control
 *
 * @author Alexander Schmidt
 * @version Fall 2021
 */
public class PortfolioPane extends HBox {

    public static final String PORTFOLIO_PANE_FXML = "PortfolioPane.fxml";

    @FXML
    private ImageView profileImage;

    @FXML
    private Label artistNameLabel;

    @FXML
    private Label followingLabel;

    @FXML
    private Label followersLabel;

    @FXML
    private Button addArtButton;

    @FXML
    private Button settingsButton;

    @FXML
    private ToggleButton followToggleButton;

    @FXML
    private Button commisionButton;

    private ObjectProperty<User> userProperty;

    /**
     * Creates a new PortfolioPane
     *
     * @precondition none
     * @postcondition none
     */
    public PortfolioPane() {
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(PORTFOLIO_PANE_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            this.userProperty = new SimpleObjectProperty<User>();
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initialize() {
        this.userProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue.equals(User.getUser())) {
                    this.followToggleButton.setVisible(false);
                    this.followToggleButton.setDisable(true);
                    this.followToggleButton.setManaged(false);

                    this.commisionButton.setVisible(false);
                    this.commisionButton.setDisable(true);
                    this.commisionButton.setManaged(false);
                } else {
                    this.addArtButton.setVisible(false);
                    this.addArtButton.setDisable(true);
                    this.addArtButton.setManaged(false);

                    this.settingsButton.setVisible(false);
                    this.settingsButton.setDisable(true);
                    this.settingsButton.setManaged(false);
                }
                this.artistNameLabel.setText(newValue.getUsername());
                this.followersLabel.setText(newValue.getFollowerIds().size() + " followers");
                this.followingLabel.setText(newValue.getFollowingIds().size() + " followers");
                this.profileImage.setImage(new Image(new ByteArrayInputStream(newValue.getProfilePic())));
                this.profileImage.setClip(new Circle(75, 75, 75));
            }
        });
    }

    @FXML
    private void handleAddArt(ActionEvent event) {
        try {
            Node mainFrame = this.getScene().getRoot();
            Stage popup = PopupLoader.loadPopup("Add Art", AddArtPopup.class.getResource("AddArtPopup.fxml"), new AddArtPopup(), (Parent) mainFrame);
            popup.setOnCloseRequest((event2) -> {
                mainFrame.setEffect(null);
            });
            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSettings(ActionEvent event) {

    }

    @FXML
    private void handleFollow(ActionEvent event) {

    }

    @FXML
    private void handleCommision(ActionEvent event) {

    }

    /**
     * Sets the user of the portfolio pane
     *
     * @param user the user of the portfolio
     *
     * @precondition none
     * @postcondition none
     */
    public void setUser(User user) {
        this.userProperty.set(user);
    }
}
