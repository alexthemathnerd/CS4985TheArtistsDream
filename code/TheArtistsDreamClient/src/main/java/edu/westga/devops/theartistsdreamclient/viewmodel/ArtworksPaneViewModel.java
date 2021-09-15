package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;

import javafx.collections.FXCollections;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * ArtworksPane ViewModel
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworksPaneViewModel {

	private ListProperty<Artwork> artworksProperty;
	private IntegerProperty indexProperty;
	private IntegerProperty maxIndexProperty;

	/**
	 * Creates a new ArtworkPaneViewModel
	 *
	 * @precondition none
	 * @postcondition artworksProperty() != null && indexProperty().getValue() == 50 && maxIndexProperty().getValue() > 0
	 */
    public ArtworksPaneViewModel() {
	    this.artworksProperty = new SimpleListProperty<Artwork>(FXCollections.observableArrayList(TheArtistsDreamApplication.artworkManager.getFirstFiftyArtworks()));
	   this.indexProperty = new SimpleIntegerProperty(50);
	    this.maxIndexProperty = new SimpleIntegerProperty(TheArtistsDreamApplication.artworkManager.size());
    }

    /**
     * Gets the artworks property
     *
     * @precondition none
     * @postcondition none
     *
     * @return the artworks property
     */
    public ListProperty<Artwork> artworksProperty(){
	    return this.artworksProperty;
    }

    /**
     * Gets the index property
     *
     * @precondition none
     * @postcondition none
     *
     * @return the index property
     */
    public IntegerProperty indexProperty(){
	    return this.indexProperty;
    }

    /**
     * Gets the max index property
     *
     * @precondition none
     * @postcondition none
     *
     * @return the max index property
     */
    public IntegerProperty maxIndexProperty(){
	    return this.maxIndexProperty;
    }

    /**
     * Allows more artworks to be shown on the codebehind
     *
     * @precondition none
     * @postcondition indexProperty() == indexProperty() + 10 @ pre && artworksProperty().get().size() > artworksProperty().get().size() @ prev
     *
     */
    public void viewMoreArtworks(){
	    this.artworksProperty.addAll(FXCollections.observableArrayList(TheArtistsDreamApplication.artworkManager.getNextTenArtworks(this.indexProperty.getValue())));
	    this.indexProperty.setValue(this.indexProperty.getValue() + 10);
    }
}

