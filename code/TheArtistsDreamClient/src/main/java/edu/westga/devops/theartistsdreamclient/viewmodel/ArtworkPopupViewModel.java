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

public class ArtworkPopupViewModel {

	private ObjectProperty<Artwork> artworkProperty;
	private StringProperty titleProperty;

	public ArtworkPopupViewModel(Artwork artwork) {
		this.artworkProperty = new SimpleObjectProperty<Artwork>(artwork);
		this.titleProperty = new SimpleStringProperty(artwork.getTitle());
	}

	public Artwork getArtwork() {
		return this.artworkProperty.get();
	}

	public void editArtwork() {
		ArtworkManager.getArtworkManager().editArtwork(this.artworkProperty.get().getID(), this.titleProperty.get(), new ArrayList<Integer>());
	}

	public void removeArtwork() {
		ArtworkManager.getArtworkManager().removeArtwork(this.getArtwork().getID());
	}

	public StringProperty titleProperty() {
		return this.titleProperty;
	}

}
