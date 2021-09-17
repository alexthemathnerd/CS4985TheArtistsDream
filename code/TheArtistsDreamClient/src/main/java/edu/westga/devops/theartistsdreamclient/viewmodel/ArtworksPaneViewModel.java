package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;

import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.collections.FXCollections;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.List;

/**
 * ArtworksPane ViewModel
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworksPaneViewModel {

    private ListProperty<Artwork> artworksProperty;
    private ListProperty<Tag> filterTagsProperty;
    private IntegerProperty indexProperty;
    private IntegerProperty maxIndexProperty;

    /**
     * Creates a new ArtworkPaneViewModel
     *
     * @precondition none
     * @postcondition artworksProperty() != null && indexProperty().getValue() == 50 && maxIndexProperty().getValue() >
     * 0
     */
    public ArtworksPaneViewModel() {
        this.artworksProperty = new SimpleListProperty<Artwork>(FXCollections.observableArrayList());
        this.filterTagsProperty = new SimpleListProperty<Tag>(FXCollections.observableArrayList());
        this.indexProperty = new SimpleIntegerProperty(0);
        this.maxIndexProperty = new SimpleIntegerProperty(50);
    }

    /**
     * Gets the artworks property
     *
     * @return the artworks property
     * @precondition none
     * @postcondition none
     */
    public ListProperty<Artwork> artworksProperty() {
        return this.artworksProperty;
    }

    public ListProperty<Tag> filterTagsProperty() {
        return this.filterTagsProperty;
    }

    /**
     * Gets the index property
     *
     * @return the index property
     * @precondition none
     * @postcondition none
     */
    public IntegerProperty indexProperty() {
        return this.indexProperty;
    }

    /**
     * Gets the max index property
     *
     * @return the max index property
     * @precondition none
     * @postcondition none
     */
    public IntegerProperty maxIndexProperty() {
        return this.maxIndexProperty;
    }

    /**
     * Allows more artworks to be shown on the codebehind
     *
     * @precondition none
     * @postcondition indexProperty() == indexProperty() + 10 @ pre && artworksProperty().get().size() >
     * artworksProperty().get().size() @ prev
     */
    public void viewMoreArtworks() {
        this.artworksProperty.addAll(FXCollections.observableArrayList(TheArtistsDreamApplication.artworkManager.getNextTenArtworks(this.indexProperty.getValue())));
        this.indexProperty.setValue(this.indexProperty.getValue() + 10);
    }

    public void viewInitialArtworks() {

        this.artworksProperty.addAll(FXCollections.observableArrayList(TheArtistsDreamApplication.artworkManager.getFirstFiftyArtworks()));
    }

    public void filterArtworks() {
        List<Artwork> artworks = TheArtistsDreamApplication.artworkManager.getArtworksOfTags(this.filterTagsProperty.get());
        System.out.println(artworks.size());
        this.artworksProperty.setAll(artworks);
    }
}

