package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.TheArtistsDreamApplication;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

import javafx.event.ActionEvent;

import java.io.IOException;
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

    /**
     * Initializes the FXML for the ArtworksPane control
     */
    public ArtworksPane() {
	    this.viewModel = new ArtworksPaneViewModel();
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(ARTWORKS_PANE_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        for (Artwork artwork : this.viewModel.artworksProperty()) {
            this.artworksTilePane.getChildren().add(new ArtworkTile(artwork));
        }
	this.viewMoreButton.disableProperty().bind(this.viewModel.indexProperty().isEqualTo(TheArtistsDreamApplication.artworkManager.size()));
    }

    @FXML
    void handleViewMore(ActionEvent event) {
        this.artworksTilePane.setPrefRows(this.artworksTilePane.getPrefRows() + 2);
	this.viewModel.viewMoreArtworks();
	this.artworksTilePane.getChildren().clear();
	for(Artwork artwork : this.viewModel.artworksProperty()){
		this.artworksTilePane.getChildren().add(new ArtworkTile(artwork));
	}
    }
}
