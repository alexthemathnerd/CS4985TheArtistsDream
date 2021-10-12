package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ArtworkPopupViewModel {

	private StringProperty newTitleProperty;
	private IntegerProperty artworkIdProperty;

	public ArtworkPopupViewModel() {
		this.newTitleProperty = new SimpleStringProperty("");
		this.artworkIdProperty = new SimpleIntegerProperty();
	}

	public void editArtwork() {
		ArtworkManager.getArtworkManager().editArtwork(artworkIdProperty.get(), newTitleProperty.get(), new ArrayList<Integer>());

	}

	public void removeArtwork() {
		ArtworkManager.getArtworkManager().removeArtwork(this.artworkIdProperty.get());
	}

	public StringProperty newTitleProperty() {
		return this.newTitleProperty;
	}

	public IntegerProperty artworkIdProperty() {
		return this.artworkIdProperty;
	}

}
