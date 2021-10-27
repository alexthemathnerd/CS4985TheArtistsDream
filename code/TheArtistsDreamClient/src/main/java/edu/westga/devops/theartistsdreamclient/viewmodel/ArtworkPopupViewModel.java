package edu.westga.devops.theartistsdreamclient.viewmodel;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * ViewModel for ArtworkPopup
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworkPopupViewModel {

    private final ObjectProperty<Artwork> artworkProperty;
    private final StringProperty titleProperty;

    /**
     * Creates a new ArtworkPopupViewModel with the specified artwork
     *
     * @precondition none
     * @postcondition getArtwork() == artwork && titleProperty().get() == artwork.getTitle()
     */
    public ArtworkPopupViewModel(Artwork artwork) {
        this.artworkProperty = new SimpleObjectProperty<Artwork>(artwork);
        this.titleProperty = new SimpleStringProperty(artwork.getTitle());
    }

    /**
     * Gets the artwork displayed in the popup
     *
     * @return the artwork
     * @precondition none
     * @postcondition none
     */
    public Artwork getArtwork() {
        return this.artworkProperty.get();
    }

    /**
     * Gets the titleProperty
     *
     * @return the titleProperty
     * @precondition none
     * @postcondition none
     */
    public StringProperty titleProperty() {
        return this.titleProperty;
    }

    /**
     * Edits the current artwork
     *
     * @precondition getArtwork() != null
     * @postcondition getArtwork().getTitle() == titleProperty().get()
     */
    public void editArtwork() {
        ArtworkManager.getArtworkManager().editArtwork(this.artworkProperty.get().getID(), this.titleProperty.get(), new ArrayList<Integer>());
    }

    /**
     * Removes the current artwork
     *
     * @precondition getArtwork() != null
     * @postcondition none
     */
    public void removeArtwork() {
        ArtworkManager.getArtworkManager().removeArtwork(this.getArtwork().getID());
    }

}
