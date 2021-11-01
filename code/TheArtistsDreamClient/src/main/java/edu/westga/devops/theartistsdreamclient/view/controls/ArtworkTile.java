package edu.westga.devops.theartistsdreamclient.view.controls;

import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.User;
import edu.westga.devops.theartistsdreamclient.model.UserManager;
import edu.westga.devops.theartistsdreamclient.view.PortfolioPage;
import edu.westga.devops.theartistsdreamclient.view.WindowLoader;
import edu.westga.devops.theartistsdreamclient.view.popups.ArtworkPopup;
import edu.westga.devops.theartistsdreamclient.view.popups.PopupLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


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

    private Artwork currentArtwork;
    private boolean onProfile;

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
     * @param artwork   the artwork
     * @param onProfile whether the artwork is on the profile
     * @precondition artwork != null
     * @postcondition none
     */
    public ArtworkTile(Artwork artwork, boolean onProfile) {
        FXMLLoader loader = new FXMLLoader(Header.class.getResource(ARTWORK_TILE_FXML));
        loader.setRoot(this);
        loader.setController(this);
        try {
            this.currentArtwork = artwork;
            this.onProfile = onProfile;
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        this.artworkImageView.setImage(this.currentArtwork.getImage());
        this.artworkImageView.setCursor(Cursor.HAND);
        this.titleLabel.setText(this.currentArtwork.getTitle());
    }

    @FXML
    void handleViewImage(MouseEvent event) {
        try {
            Parent mainFrame = ((Node) event.getSource()).getParent().getParent();
            Stage popup = PopupLoader.loadPopup("Artwork", ArtworkPopup.class.getResource(ARTWORK_POPUP_FXML), new ArtworkPopup(this.currentArtwork, this.onProfile), mainFrame);
            popup.setOnCloseRequest((event2) -> {
                mainFrame.setEffect(null);
                Object data = popup.getUserData();
                if (data != null) {
                    try {
                        int userId = (int) data;
                        Stage currentStage = (Stage) this.getScene().getWindow();
                        if (userId == User.getUser().getUserId()) {
                            WindowLoader.changeScene(currentStage, "PortfolioPage.fxml", new PortfolioPage(User.getUser()), "Profile", false);
                        } else {
                            WindowLoader.changeScene(currentStage, "PortfolioPage.fxml", new PortfolioPage(UserManager.getUserManager().getUser(userId)), "Profile", false);
                        }
                        currentStage.setMaximized(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
