package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.beans.property.ListProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;

import java.util.List;

/**
 * ArtworksPane ViewModel
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworksPaneViewModel {

    private final ListProperty<Artwork> artworksProperty;
    private final ListProperty<Tag> filterTagsProperty;
    private final IntegerProperty indexProperty;
    private final IntegerProperty maxIndexProperty;
    private final IntegerProperty userIdProperty;
    private final BooleanProperty onFollowingPageProperty;

    /**
     * Creates a new ArtworkPaneViewModel
     *
     * @precondition none
     * @postcondition artworksProperty() != null && indexProperty().getValue() == 50 && maxIndexProperty().getValue() >
     */
    public ArtworksPaneViewModel() {
        this.artworksProperty = new SimpleListProperty<Artwork>(FXCollections.observableArrayList());
        this.filterTagsProperty = new SimpleListProperty<Tag>(FXCollections.observableArrayList());
        this.indexProperty = new SimpleIntegerProperty(50);
        this.maxIndexProperty = new SimpleIntegerProperty(50);
        this.userIdProperty = new SimpleIntegerProperty(-1);
        this.onFollowingPageProperty = new SimpleBooleanProperty(false);
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

    /**
     * Gets the tags to filter by property
     *
     * @return the tags to filter by property
     * @precondition none
     * @postcondition none
     */
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
        if (this.userIdProperty.isEqualTo(-1).get()) {
            this.artworksProperty.addAll(ArtworkManager.getArtworkManager().getNextTenArtworks(this.indexProperty.getValue()));
        } else if (this.onFollowingPageProperty.not().get()) {
            this.artworksProperty.addAll(ArtworkManager.getArtworkManager().getNextTenArtworks(this.indexProperty.getValue(), this.userIdProperty.get()));
        } else {
            this.artworksProperty.addAll(ArtworkManager.getArtworkManager().getNextTenArtworks(this.indexProperty.getValue(), this.onFollowingPageProperty.get()));
        }
        this.indexProperty.set(this.indexProperty.get() + this.artworksProperty.getSize());
    }

    /**
     * Allows the initial 50 artworks to be shown
     *
     * @precondition none
     * @postcondition artworksProperty().get().size() == 50
     */
    public void viewInitialArtworks() {
        if (this.userIdProperty.isEqualTo(-1).get()) {
            this.artworksProperty.addAll(FXCollections.observableArrayList(ArtworkManager.getArtworkManager().getFirstFiftyArtworks()));
        } else if (this.onFollowingPageProperty.not().get()) {
            this.artworksProperty.addAll(FXCollections.observableArrayList(ArtworkManager.getArtworkManager().getFirstFiftyArtworks(this.userIdProperty.get())));
        } else {
            this.artworksProperty.addAll(FXCollections.observableArrayList(ArtworkManager.getArtworkManager().getFirstFiftyArtworks(true)));
        }
    }

    /**
     * Filters the artworks
     *
     * @precondition none
     * @postcondition none
     */
    public void filterArtworks() {
        List<Artwork> artworks = ArtworkManager.getArtworkManager().getArtworksOfTags(this.filterTagsProperty.get());
        this.artworksProperty.setAll(artworks);
    }

    /**
     * Gets the user id property
     *
     * @return the user id property
     * @precondition none
     * @postcondition none
     */
    public IntegerProperty userIdProperty() {
        return this.userIdProperty;
    }

    /**
     * Gets the on following page property
     *
     * @return the on following page property
     * @precondition none
     * @postcondition none
     */
    public BooleanProperty onFollowingPageProperty() {
        return this.onFollowingPageProperty;
    }
}

