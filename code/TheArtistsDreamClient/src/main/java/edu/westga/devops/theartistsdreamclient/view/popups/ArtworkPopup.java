package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;

/**
 * Controller for the ArtworkPopup
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworkPopup {

	@FXML
	private TextField titleTextField;

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

	/**
	 * Creates a new ArtworkPopup with the specified artwork and value of if it is on a profile
	 *
	 * @param artwork the artwork to display in the popup
	 * @param onProfile the value of if the popup is being displayed on a profile or not
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public ArtworkPopup(Artwork artwork, boolean onProfile) {
	    this.artwork = artwork;
	    this.onProfile = onProfile;
	}

	@FXML
	void initialize() {
	    this.titleTextField.setText(this.artwork.getTitle());
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
		this.titleTextField.setEditable(true);
	}

	@FXML
	void handleRemove(ActionEvent event) {
		ArtworkManager.getArtworkManager().removeArtwork(this.artwork.getID());
	}

	@FXML
	void handleChangeTitle(ActionEvent event) {
		this.artwork.setTitle(this.titleTextField.getText());
	}

}
