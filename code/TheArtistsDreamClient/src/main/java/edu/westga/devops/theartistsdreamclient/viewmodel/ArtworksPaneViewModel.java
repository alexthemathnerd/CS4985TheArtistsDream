package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;

import javafx.collections.FXCollections;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
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
	private ObjectProperty<Artwork> selectedArtworkProperty;
	private IntegerProperty indexProperty;

    public ArtworksPaneViewModel() {
	    this.artworksProperty = new SimpleListProperty<Artwork>(FXCollections.observableArrayList(TheArtistsDreamApplication.artworkManager.getFirstFiftyArtworks()));
	    this.selectedArtworkProperty = new SimpleObjectProperty<Artwork>();
	    this.indexProperty = new SimpleIntegerProperty(50);
    }

    public ListProperty<Artwork> artworksProperty(){
	    return this.artworksProperty;
    }

    public ObjectProperty<Artwork> selectedArtworkProperty(){
	    return this.selectedArtworkProperty;
    }

    public IntegerProperty indexProperty(){
	    return this.indexProperty;
    }

    public void viewMoreArtworks(){
	    this.artworksProperty.addAll(FXCollections.observableArrayList(TheArtistsDreamApplication.artworkManager.getNextTenArtworks(this.indexProperty.getValue())));
	    this.indexProperty.setValue(this.indexProperty.getValue() + 10);
    }
}

