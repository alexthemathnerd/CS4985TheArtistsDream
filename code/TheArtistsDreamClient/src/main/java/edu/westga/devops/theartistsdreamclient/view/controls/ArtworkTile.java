package edu.westga.devops.theartistsdreamclient.view.controls;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

import javafx.scene.Cursor;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.view.popups.ArtworkPopup;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;

/**
 * The Controller for the Custom Control for each single piece of artwork shown in the application
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */

public class ArtworkTile extends VBox {

    public static final String ARTWORK_TILE_FXML = "ArtworkTile.fxml";
    private static final String ARTWORK_POPUP_FXML = "ArtworkPopup.fxml";

    @FXML
    private Label titleLabel;

    @FXML
    private ImageView artworkImageView;

    /**
     * Initializes the FXML for the ArtworkTile Control
     *
     * @precondition none
     * @postcondition none
     */
    public ArtworkTile() {
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(ARTWORK_TILE_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            this.artworkImageView.setCursor(Cursor.HAND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates an ArtworkTile with a specified artwork
     *
     * @precondition artwork != null
     * @postcondition none
     */
    public ArtworkTile(Artwork artwork) {
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(ARTWORK_TILE_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.artworkImageView.setImage(artwork.getImage());
        this.artworkImageView.setCursor(Cursor.HAND);
        this.titleLabel.setText(artwork.getTitle());
    }

    @FXML
    void initialize() {

    }

    @FXML
    void handleViewImage(MouseEvent event) {
	    try {
		    Node mainFrame = ((Node) event.getSource()).getParent().getParent();
		    Stage popup = PopupLoader.loadPopup("Artwork", ArtworkPopup.class.getResource(ARTWORK_POPUP_FXML), new ArtworkPopup(), (Parent) mainFrame);
		    popup.setOnCloseRequest((event2) -> {
			    mainFrame.setEffect(null);
		    });
		    popup.show();
    } catch (IOException e) {
	    e.printStackTrace();
    }
    }
}
