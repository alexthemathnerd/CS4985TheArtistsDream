package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.view.popups.AddArtPopup;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import edu.westga.devops.theartistsdreamclient.view.popups.CommissionFormPopup;
import edu.westga.devops.theartistsdreamclient.view.PortfolioPage;
import edu.westga.devops.theartistsdreamclient.view.WindowLoader;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
    public static final String DIRECT_MESSAGE_FXML = "popups/DirectMessageView.fxml";

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
    private Button commissionButton;

    private final ObjectProperty<User> userProperty;
    private final BooleanProperty isFollowing;

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
            this.isFollowing = new SimpleBooleanProperty(false);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initialize() {
        this.followToggleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                this.followToggleButton.setText("FOLLOW");
            } else {
                this.followToggleButton.setText("FOLLOWING");
            }
        });
        this.followToggleButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && this.followToggleButton.isSelected()) {
                this.followToggleButton.setText("UNFOLLOW");
            } else if (!newValue && this.followToggleButton.isSelected()) {
                this.followToggleButton.setText("FOLLOWING");
            } else {
                this.followToggleButton.setText("FOLLOW");
            }
        });
        this.userProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue.equals(User.getUser())) {
                    this.followToggleButton.setVisible(false);
                    this.followToggleButton.setDisable(true);
                    this.followToggleButton.setManaged(false);

                    this.commissionButton.setVisible(false);
                    this.commissionButton.setDisable(true);
                    this.commissionButton.setManaged(false);
                } else {
                    this.addArtButton.setVisible(false);
                    this.addArtButton.setDisable(true);
                    this.addArtButton.setManaged(false);

                    this.settingsButton.setVisible(false);
                    this.settingsButton.setDisable(true);
                    this.settingsButton.setManaged(false);
                }
                this.artistNameLabel.setText(this.userProperty.get().getUsername());
                this.followersLabel.setText(UserManager.getUserManager().getFollowerIds(this.userProperty.get().getUserId()).size() + " followers");
                this.followingLabel.setText(UserManager.getUserManager().getFollowingIds(this.userProperty.get().getUserId()).size() + " followings");
                this.profileImage.setImage(new Image(new ByteArrayInputStream(this.userProperty.get().getProfilePic())));
                this.profileImage.setClip(new Circle(75, 75, 75));
                this.followToggleButton.setSelected(UserManager.getUserManager().isFollowing(User.getUser().getUserId(), this.userProperty.get().getUserId()));
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
		        Object data = popup.getUserData();
		        if (data != null) {
			        try {
				        Stage currentStage = (Stage) this.getScene().getWindow();
				        WindowLoader.changeScene(currentStage, "PortfolioPage.fxml", new PortfolioPage(User.getUser()), "Profile", false);
				        currentStage.setMaximized(true);
			        } catch (IOException e) {
				        e.printStackTrace();
			        }
		        }
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
        if (this.followToggleButton.isSelected()) {
            this.followToggleButton.setText("FOLLOWING");
            UserManager.getUserManager().followArtist(User.getUser().getUserId(), this.userProperty.get().getUserId());
        } else {
            this.followToggleButton.setText("FOLLOW");
            UserManager.getUserManager().unfollowArtist(User.getUser().getUserId(), this.userProperty.get().getUserId());
        }

    }

    @FXML
    private void handleCommission(ActionEvent event) {
        try {
            Node mainFrame = this.getScene().getRoot();
            Stage popup = PopupLoader.loadPopup("Commision Form", CommissionFormPopup.class.getResource("CommissionFormPopup.fxml"), new CommissionFormPopup(), (Parent) mainFrame);      
            popup.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void setIsFollowing(boolean following) {
        this.isFollowing.set(following);
    }
}
