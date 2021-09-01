package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

import javafx.event.ActionEvent;

import java.io.IOException;

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


    /**
     * Initializes the FXML for the ArtworksPane control
     */
    public ArtworksPane() {
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
    void initialize(){
	    //TODO: bindings
    }

    @FXML
    void handleViewMore(ActionEvent event){
	    this.artworksTilePane.setPrefRows(this.artworksTilePane.getPrefRows() + 2);
	    for(int i = 0; i < 10; i++) {
		    this.artworksTilePane.getChildren().add(new ArtworkTile());
	    }
    }
}
