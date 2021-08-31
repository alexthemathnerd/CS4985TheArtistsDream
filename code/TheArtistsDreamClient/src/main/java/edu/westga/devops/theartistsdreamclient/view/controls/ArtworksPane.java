package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

/**
 * The Controller for the Custom Control for the Artworks view of the application
 */
public class ArtworksPane extends ScrollPane {

    public static final String ARTWORKS_PANE_FXML = "ArtworksPane.fxml";

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
