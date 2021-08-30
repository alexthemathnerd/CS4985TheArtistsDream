package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * The Controller for the Custom Control for the Artworks view of the application
 */
public class ArtworksPane extends HBox {

    public static final String ARTWORKS_PANE_FXML = "TODO";

    //TODO: CODE BEHIND JUST FOR VIEWING ART.

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

}