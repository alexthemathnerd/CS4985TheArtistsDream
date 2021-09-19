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

public class ArtworkPopup {

	@FXML
	private Label titleLabel;

	@FXML
	private Label artistLabel;

	@FXML
	private Button closeButton;

	@FXML
	private ImageView artworkImageView;
	
	private Artwork artwork;

	public ArtworkPopup(Artwork artwork) {
	    this.artwork = artwork;
	}

	@FXML
	void initialize() {
	    this.titleLabel.setText(this.artwork.getTitle());
	 	this.artistLabel.setText(UserManager.getUserManager().getUser(this.artwork.getArtistID()).getUsername());
	    this.artworkImageView.setImage(this.artwork.getImage());
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

}
