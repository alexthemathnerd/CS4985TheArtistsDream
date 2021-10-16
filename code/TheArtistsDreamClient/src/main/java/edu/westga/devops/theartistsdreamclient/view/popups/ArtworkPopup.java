package edu.westga.devops.theartistsdreamclient.view.popups;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworkPopupViewModel;

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
	
	private boolean onProfile;
	private BooleanProperty isEditing;
	private ArtworkPopupViewModel viewModel;

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
	    this.onProfile = onProfile;
	    this.isEditing = new SimpleBooleanProperty(false);
	    this.viewModel = new ArtworkPopupViewModel(artwork);
	}

	@FXML
	void initialize() {
	    this.titleTextField.textProperty().bindBidirectional(this.viewModel.titleProperty());  
	 	this.artistLabel.setText(UserManager.getUserManager().getUser(this.viewModel.getArtwork().getArtistID()).getUsername());
	    this.artworkImageView.setImage(this.viewModel.getArtwork().getImage());
	    this.editButton.setVisible(this.onProfile && UserManager.getUserManager().getUser(this.viewModel.getArtwork().getArtistID()).getUsername().equals(User.getUser().getUsername()));
	    this.removeButton.setVisible(this.onProfile && UserManager.getUserManager().getUser(this.viewModel.getArtwork().getArtistID()).getUsername().equals(User.getUser().getUsername()));
	    this.isEditing.addListener((observable, oldValue, newValue) -> {
		    if (newValue) {
			    this.titleTextField.setDisable(false);
			    this.titleTextField.setEditable(true);
			    this.removeButton.setVisible(false);
			    this.editButton.setText("CONFIRM");
		    } else {
			    this.titleTextField.setText(this.titleTextField.getText());
			    this.titleTextField.setDisable(true);
			    this.titleTextField.setEditable(false);
			    this.removeButton.setVisible(true);
			    this.editButton.setText("EDIT");
			    this.viewModel.editArtwork(); 
		    }
	    });
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
		currentStage.setUserData(this.viewModel.getArtwork().getArtistID());
		currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		currentStage.close();
	}


	@FXML
	void handleEdit(ActionEvent event) {
                if (this.isEditing.get()) {
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			currentStage.setUserData(this.viewModel.getArtwork().getArtistID());
			currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
			currentStage.close();
		}
		this.isEditing.set(!this.isEditing.get());
	}

	@FXML
	void handleRemove(ActionEvent event) {
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		this.viewModel.removeArtwork();
		currentStage.setUserData(this.viewModel.getArtwork().getArtistID());
		currentStage.fireEvent(new WindowEvent(currentStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		currentStage.close();
	}
}
