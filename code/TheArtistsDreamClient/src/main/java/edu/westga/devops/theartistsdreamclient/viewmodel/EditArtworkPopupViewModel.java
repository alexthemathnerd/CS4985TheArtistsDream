package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class EditArtworkPopupViewModel {

	private StringProperty newTitleProperty;
	private IntegerProperty artworkIdProperty;

	public EditArtworkPopupViewModel() {
		this.newTitleProperty = new SimpleStringProperty("");
		this.artworkIdProperty = new SimpleIntegerProperty();
	}

	public void editArtwork() {
		ArtworkManager.getArtworkManager().editArtwork(artworkIdProperty.get(), newTitleProperty.get(), new ArrayList<Integer>());

	}

	public StringProperty newTitleProperty() {
		return this.newTitleProperty;
	}

	public IntegerProperty artworkIdProperty() {
		return this.artworkIdProperty;
	}

}
