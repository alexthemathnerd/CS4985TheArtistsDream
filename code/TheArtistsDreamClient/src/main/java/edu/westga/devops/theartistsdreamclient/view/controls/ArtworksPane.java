package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.Tag;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Arrays;

import javafx.beans.binding.Bindings;
import edu.westga.devops.theartistsdreamclient.viewmodel.ArtworksPaneViewModel;

/**
 * The Controller for the Custom Control for the Artworks view of the application
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworksPane extends ScrollPane {

    public static final String ARTWORKS_PANE_FXML = "ArtworksPane.fxml";

    @FXML
    private TilePane artworksTilePane;

    @FXML
    private Button viewMoreButton;

    private ArtworksPaneViewModel viewModel;

    private ListProperty<Tag> tagsToFilterListProperty;

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
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
//        for (Artwork artwork : this.viewModel.artworksProperty()) {
//            this.artworksTilePane.getChildren().add(new ArtworkTile(artwork));
//        }
        //this.viewModel.viewInitialArtworks();
        this.viewMoreButton.disableProperty().bind(this.viewModel.indexProperty().isEqualTo(this.viewModel.maxIndexProperty()));
        this.tagsToFilterListProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            if (newValue != null && !newValue.isEmpty()) {
                System.out.println("I DO SOMETHING");
                this.viewModel.filterArtworks();
            }
        });
        this.viewModel.filterTagsProperty().bindBidirectional(this.tagsToFilterListProperty());
        this.viewModel.artworksProperty().addListener((observable, oldValue, newValue) -> {
            this.artworksTilePane.getChildren().clear();
            for (Artwork artwork : this.viewModel.artworksProperty()) {
                this.artworksTilePane.getChildren().add(new ArtworkTile(artwork));
            }
        });
        this.viewModel.viewInitialArtworks();
    }

    @FXML
    void handleViewMore(ActionEvent event) {
        this.artworksTilePane.setPrefRows(this.artworksTilePane.getPrefRows() + 2);
        this.viewModel.viewMoreArtworks();
    }

    public ListProperty<Tag> tagsToFilterListProperty() {
        return this.tagsToFilterListProperty;
    }

}
