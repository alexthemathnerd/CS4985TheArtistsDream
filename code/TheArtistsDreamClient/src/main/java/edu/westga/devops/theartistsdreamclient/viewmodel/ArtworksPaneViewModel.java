package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

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
    private IntegerProperty userIdProperty;

    /**
     * Creates a new ArtworkPaneViewModel
     *
     * @precondition none
     * @postcondition artworksProperty() != null && indexProperty().getValue() == 50 && maxIndexProperty().getValue() >
     */
    public ArtworksPaneViewModel() {
        this.artworksProperty = new SimpleListProperty<Artwork>(FXCollections.observableArrayList());
        this.filterTagsProperty = new SimpleListProperty<Tag>(FXCollections.observableArrayList());
        this.indexProperty = new SimpleIntegerProperty(0);
        this.maxIndexProperty = new SimpleIntegerProperty(50);
        this.userIdProperty = new SimpleIntegerProperty(-1);
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
        this.artworksProperty.addAll(FXCollections.observableArrayList(ArtworkManager.getArtworkManager().getNextTenArtworks(this.indexProperty.getValue())));
        this.indexProperty.setValue(this.indexProperty.getValue() + 10);
    }

    public void viewInitialArtworks() {
        if (this.userIdProperty.isEqualTo(-1).get()) {
            this.artworksProperty.addAll(FXCollections.observableArrayList(ArtworkManager.getArtworkManager().getFirstFiftyArtworks()));
        } else {
            this.artworksProperty.addAll(FXCollections.observableArrayList(ArtworkManager.getArtworkManager().getFirstFiftyArtworks(this.userIdProperty.get())));
        }

    }

    public void filterArtworks() {
        List<Artwork> artworks = ArtworkManager.getArtworkManager().getArtworksOfTags(this.filterTagsProperty.get());
        this.artworksProperty.setAll(artworks);
    }

    public IntegerProperty userIdProperty() {
        return this.userIdProperty;
    }
}

