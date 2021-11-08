package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworksPaneViewModel;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;

import java.io.IOException;

/**
 * The Controller for the Custom Control for the Artworks view of the application
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworksPane extends ScrollPane {

    public static final String ARTWORKS_PANE_FXML = "ArtworksPane.fxml";
    private final ArtworksPaneViewModel viewModel;
    private final IntegerProperty userIdProperty;
    private final ListProperty<Tag> tagsToFilterListProperty;
    private final BooleanProperty onFollowingPageProperty;
    private final BooleanProperty onProfileProperty;
    @FXML
    private TilePane artworksTilePane;
    @FXML
    private Button viewMoreButton;

    /**
     * Initializes the FXML for the ArtworksPane control
     */
    public ArtworksPane() {
        this.viewModel = new ArtworksPaneViewModel();
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(ARTWORKS_PANE_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            this.tagsToFilterListProperty = new SimpleListProperty<Tag>(FXCollections.observableArrayList());
            this.userIdProperty = new SimpleIntegerProperty(-1);
            this.onFollowingPageProperty = new SimpleBooleanProperty(false);
            this.onProfileProperty = new SimpleBooleanProperty();
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        this.userIdProperty.bindBidirectional(this.viewModel.userIdProperty());
        this.onFollowingPageProperty.bindBidirectional(this.viewModel.onFollowingPageProperty());
        this.tagsToFilterListProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (!newValue.isEmpty()) {
                    this.viewModel.filterArtworks();
                }
            }
        });
        this.viewModel.filterTagsProperty().bindBidirectional(this.tagsToFilterListProperty());
        this.viewModel.artworksProperty().addListener((observable, oldValue, newValue) -> {
            this.artworksTilePane.getChildren().clear();
            for (Artwork artwork : newValue) {
                this.artworksTilePane.getChildren().add(new ArtworkTile(artwork, this.onProfileProperty.get()));
            }
        });
    }

    /**
     * Initializes the artworks
     *
     * @precondition none
     * @postcondition none
     */
    public void initArts() {
        this.viewModel.viewInitialArtworks();
    }

    @FXML
    void handleViewMore(ActionEvent event) {
        this.artworksTilePane.setPrefRows(this.artworksTilePane.getPrefRows() + 2);
        this.viewModel.viewMoreArtworks();
    }

    /**
     * Gets the tags to filter list property
     *
     * @return the tags to filter list property
     * @precondition none
     * @postcondition none
     */
    public ListProperty<Tag> tagsToFilterListProperty() {
        return this.tagsToFilterListProperty;
    }

    /**
     * Gets the userid property
     *
     * @return the userid property
     * @precondition none
     * @postcondition none
     */
    public IntegerProperty userIdProperty() {
        return this.userIdProperty;
    }

    /**
     * Sets the userid property
     *
     * @param id the id to set the userid to
     * @precondition none
     * @postcondition userIdProperty().get() == id
     */
    public void setUserId(int id) {
        this.userIdProperty.set(id);
    }

    /**
     * Sets the on following page property
     *
     * @param onFollowingPage the value if the pane is on the following page
     * @precondition none
     * @postcondition none
     */
    public void setOnFollowingPage(boolean onFollowingPage) {
        this.onFollowingPageProperty.set(onFollowingPage);
    }

    /**
     * Sets the on profile property
     *
     * @param onProfile the value of if the pane is on a profile page
     * @precondition none
     * @postcondition none
     */
    public void setOnProfile(boolean onProfile) {
        this.onProfileProperty.set(onProfile);
    }
}
