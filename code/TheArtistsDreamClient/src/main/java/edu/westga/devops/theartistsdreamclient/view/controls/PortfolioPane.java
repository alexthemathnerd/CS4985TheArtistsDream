package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworksPaneViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

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

    public PortfolioPane() {
        // this.viewModel = new ArtworksPaneViewModel();
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
                this.profileImage.setImage(null);
                this.artistNameLabel.setText(this.userProperty.get().getUsername());
            }
        });
    }

    @FXML
    private void handleAddArt(ActionEvent e) {

    }

    @FXML
    private void handleSettings(ActionEvent e) {

    }

    @FXML
    private void handleFollow(ActionEvent e) {

    }

    @FXML
    private void handleCommision(ActionEvent e) {

    }

    public void setUser(User user) {
        this.userProperty.set(user);
    }
}
