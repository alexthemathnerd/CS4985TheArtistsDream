package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Artwork;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * ViewModel for ArtworkPopup
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworkPopupViewModel {

	private ObjectProperty<Artwork> artworkProperty;
	private StringProperty titleProperty;

	/**
	 * Creates a new ArtworkPopupViewModel with the specified artwork
	 *
	 * @precondition none
	 * @postcondition getArtwork() == artwork && titleProperty().get() == artwork.getTitle()
	 *
	 */
	public ArtworkPopupViewModel(Artwork artwork) {
		this.artworkProperty = new SimpleObjectProperty<Artwork>(artwork);
		this.titleProperty = new SimpleStringProperty(artwork.getTitle());
	}

	/**
	 * Gets the artwork displayed in the popup
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the artwork
	 */
	public Artwork getArtwork() {
		return this.artworkProperty.get();
	}

	/**
	 * Gets the titleProperty
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the titleProperty
	 */
	public StringProperty titleProperty() {
		return this.titleProperty;
	}

	/**
	 * Edits the current artwork
	 *
	 * @precondition getArtwork() != null
	 * @postcondition getArtwork().getTitle() == titleProperty().get()
	 *
	 */
	public void editArtwork() {
		ArtworkManager.getArtworkManager().editArtwork(this.artworkProperty.get().getID(), this.titleProperty.get(), new ArrayList<Integer>());
	}

	/**
	 * Removes the current artwork
	 *
	 * @precondition getArtwork() != null
	 * @postcondition none
	 *
	 */
	public void removeArtwork() {
		ArtworkManager.getArtworkManager().removeArtwork(this.getArtwork().getID());
	}

}
