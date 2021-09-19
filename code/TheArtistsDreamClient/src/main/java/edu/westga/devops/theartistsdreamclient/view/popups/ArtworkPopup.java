package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.User;

public class ArtworkPopup {

	@FXML
	private Label titleLabel;

	@FXML
	private Label artistLabel;

	@FXML
	private Button closeButton;

	@FXML
	private Button editButton;

	@FXML
	private Button removeButton;

	@FXML
	private ImageView artworkImageView;
	
	private Artwork artwork;
	private boolean onProfile;

	public ArtworkPopup(Artwork artwork, boolean onProfile) {
	    this.artwork = artwork;
	    this.onProfile = onProfile;
	}

	@FXML
	void initialize() {
	    this.titleLabel.setText(this.artwork.getTitle());
	 	this.artistLabel.setText(UserManager.getUserManager().getUser(this.artwork.getArtistID()).getUsername());
	    this.artworkImageView.setImage(this.artwork.getImage());
	    this.editButton.setVisible(this.onProfile && UserManager.getUserManager().getUser(this.artwork.getArtistID()).getUsername().equals(User.getUser().getUsername()));
	    this.removeButton.setVisible(this.onProfile && UserManager.getUserManager().getUser(this.artwork.getArtistID()).getUsername().equals(User.getUser().getUsername()));
	}

	@FXML
	void handleClose(ActionEvent event) {
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		currentStage.close();
	}

	@FXML
	void handleViewArtistProfile(MouseEvent event) {
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		currentStage.setUserData(this.artwork.getArtistID());
		currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		currentStage.close();
	}


	@FXML
	void handleEdit(ActionEvent event) {

	}

	@FXML
	void handleRemove(ActionEvent event) {

	}


}
